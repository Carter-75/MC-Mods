package mod.universalmobwar.client;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import mod.universalmobwar.config.ModConfig;
import net.fabricmc.fabric.api.client.rendering.v1.level.LevelRenderContext;
import net.fabricmc.fabric.api.client.rendering.v1.level.LevelRenderEvents;
import net.minecraft.client.Camera;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.SubmitNodeCollector;
import net.minecraft.client.renderer.rendertype.RenderTypes;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.phys.Vec3;

/**
 * Handles rendering of visual features: target lines.
 *
 * <p>Ported to MC 26.2. The old immediate-mode {@code WorldRenderEvents.Last} +
 * {@code Tessellator}/{@code BufferBuilder}/{@code RenderSystem.setShader} path was
 * removed by the Blaze3D render-pipeline rewrite. We now register on
 * {@link LevelRenderEvents#AFTER_TRANSLUCENT_TERRAIN} and enqueue our line geometry
 * through the submit-node collector via
 * {@link SubmitNodeCollector#submitCustomGeometry} with {@link RenderTypes#lines()}.
 * The camera-relative offset math and per-line coloring are unchanged.
 */
public class MobVisualRenderer implements LevelRenderEvents.AfterTranslucentTerrain {

    private static final ModConfig CONFIG = ModConfig.getInstance();

    @Override
    public void afterTranslucentTerrain(LevelRenderContext context) {
        Minecraft client = Minecraft.getInstance();
        if (client.player == null || client.level == null) return;

        // Performance check: Skip if FPS is too low
        if (client.getFps() < CONFIG.minFpsForVisuals) return;

        PoseStack matrices = context.poseStack();
        SubmitNodeCollector collector = context.submitNodeCollector();
        Camera camera = client.gameRenderer.mainCamera();
        Vec3 cameraPos = camera.position();

        // Get all entities in render distance
        Iterable<Entity> entities = client.level.entitiesForRendering();

        for (Entity entity : entities) {
            if (!(entity instanceof Mob mob)) continue;

            // Check distance for performance
            double distance = entity.position().distanceTo(cameraPos);
            if (distance > 64.0) continue; // Only render within 64 blocks

            renderForMob(matrices, collector, cameraPos, mob, distance);
        }
    }

    private void renderForMob(PoseStack matrices, SubmitNodeCollector collector, Vec3 cameraPos, Mob mob, double distance) {
        Vec3 mobPos = mob.position();

        // Target lines
        if (CONFIG.showTargetLines) {
            LivingEntity target = mob.getTarget();
            if (target != null) {
                drawTargetLine(matrices, collector, cameraPos, mobPos, target.position());
            }
        }
    }

    private void drawTargetLine(PoseStack matrices, SubmitNodeCollector collector, Vec3 cameraPos, Vec3 start, Vec3 end) {
        final float sx = (float) (start.x - cameraPos.x);
        final float sy = (float) (start.y - cameraPos.y + 1.0);
        final float sz = (float) (start.z - cameraPos.z);
        final float ex = (float) (end.x - cameraPos.x);
        final float ey = (float) (end.y - cameraPos.y + 1.0);
        final float ez = (float) (end.z - cameraPos.z);

        // Line from mob to target (red). The LINES render type requires a per-vertex
        // normal (used for line width/orientation); use the segment direction.
        float dx = ex - sx;
        float dy = ey - sy;
        float dz = ez - sz;
        float len = (float) Math.sqrt(dx * dx + dy * dy + dz * dz);
        if (len < 1.0e-4f) return;
        final float nx = dx / len;
        final float ny = dy / len;
        final float nz = dz / len;

        collector.submitCustomGeometry(matrices, RenderTypes.lines(), (pose, buffer) -> {
            buffer.addVertex(pose, sx, sy, sz).setColor(255, 0, 0, 255).setNormal(pose, nx, ny, nz);
            buffer.addVertex(pose, ex, ey, ez).setColor(255, 0, 0, 255).setNormal(pose, nx, ny, nz);
        });
    }
}
