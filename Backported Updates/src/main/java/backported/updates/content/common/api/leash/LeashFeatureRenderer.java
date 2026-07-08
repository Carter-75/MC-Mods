/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.fabricmc.api.EnvType
 *  net.fabricmc.api.Environment
 *  net.minecraft.entity.Entity
 *  net.minecraft.client.render.RenderLayer
 *  net.minecraft.world.LightType
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.util.math.Position
 *  net.minecraft.util.math.Box
 *  net.minecraft.util.math.Vec3d
 *  net.minecraft.util.math.MathHelper
 *  net.minecraft.client.util.math.MatrixStack
 *  net.minecraft.client.render.VertexConsumer
 *  net.minecraft.client.render.VertexConsumerProvider
 *  net.minecraft.client.render.Frustum
 *  net.minecraft.client.render.LightmapTextureManager
 *  net.minecraft.client.render.entity.EntityRenderDispatcher
 *  net.minecraft.entity.Leashable
 *  org.jetbrains.annotations.Nullable
 *  org.joml.Matrix4f
 */
package backported.updates.content.common.api.leash;

import backported.updates.content.common.api.leash.LeashExtension;
import backported.updates.content.common.api.leash.LeashState;
import backported_updates.mixin.access.EntityRendererAccessor;
import java.util.ArrayList;
import java.util.List;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.entity.Entity;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.world.LightType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Position;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.MathHelper;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.Frustum;
import net.minecraft.client.render.LightmapTextureManager;
import net.minecraft.client.render.entity.EntityRenderDispatcher;
import net.minecraft.entity.Leashable;
import org.jetbrains.annotations.Nullable;
import org.joml.Matrix4f;

@Environment(value=EnvType.CLIENT)
public class LeashFeatureRenderer<T extends Entity> {
    private static final int LEASH_RENDER_STEPS = 24;
    private static final float LEASH_WIDTH = 0.05f;
    private final EntityRenderDispatcher dispatcher;
    @Nullable
    private List<LeashState> leashStates;

    public LeashFeatureRenderer(EntityRenderDispatcher dispatcher) {
        this.dispatcher = dispatcher;
    }

    public boolean shouldRender(T entity, Frustum camera, boolean isVisible, boolean fallback) {
        if (!isVisible) {
            Leashable leashable;
            Entity leashHolder;
            Box boundingBox = entity.getVisibilityBoundingBox().expand(0.5);
            if (boundingBox.isNaN() || boundingBox.getAverageSideLength() == 0.0) {
                boundingBox = new Box(entity.getX() - 2.0, entity.getY() - 2.0, entity.getZ() - 2.0, entity.getX() + 2.0, entity.getY() + 2.0, entity.getZ() + 2.0);
            }
            if (camera.isVisible(boundingBox)) {
                return true;
            }
            if (entity instanceof Leashable && (leashHolder = (leashable = (Leashable)entity).getLeashHolder()) != null) {
                Box leasherBox = leashHolder.getVisibilityBoundingBox();
                return camera.isVisible(leasherBox) || camera.isVisible(boundingBox.union(leasherBox));
            }
        }
        return fallback;
    }

    public boolean shouldRender(T entity, Frustum camera, boolean isVisible) {
        return this.shouldRender(entity, camera, isVisible, isVisible);
    }

    public void render(T entity, float partialTick, MatrixStack poseStack, VertexConsumerProvider buffer) {
        this.setupLeashRendering(entity, partialTick);
        if (this.leashStates != null) {
            for (LeashState leashState : this.leashStates) {
                this.renderLeash(poseStack, buffer, leashState);
            }
        }
    }

    private void renderLeash(MatrixStack stack, VertexConsumerProvider buffer, LeashState state) {
        int segment;
        float dx = (float)(state.end.x - state.start.x);
        float dy = (float)(state.end.y - state.start.y);
        float dz = (float)(state.end.z - state.start.z);
        float offsetFactor = MathHelper.inverseSqrt((float)(dx * dx + dz * dz)) * 0.05f / 2.0f;
        float dxOff = dz * offsetFactor;
        float dzOff = dx * offsetFactor;
        stack.push();
        stack.translate(state.offset.x, state.offset.y, state.offset.z);
        VertexConsumer builder = buffer.getBuffer(RenderLayer.getLeash());
        Matrix4f matrices = stack.peek().getPositionMatrix();
        for (segment = 0; segment <= 24; ++segment) {
            LeashFeatureRenderer.addVertexPair(builder, matrices, dx, dy, dz, 0.05f, dxOff, dzOff, segment, false, state);
        }
        for (segment = 24; segment >= 0; --segment) {
            LeashFeatureRenderer.addVertexPair(builder, matrices, dx, dy, dz, 0.05f, dxOff, dzOff, segment, true, state);
        }
        if (!state.slack) {
            for (segment = 0; segment <= 24; ++segment) {
                LeashFeatureRenderer.addVertexPair(builder, matrices, dx, dy, dz, 0.05f, -dxOff, dzOff, segment, false, state);
            }
            for (segment = 24; segment >= 0; --segment) {
                LeashFeatureRenderer.addVertexPair(builder, matrices, dx, dy, dz, 0.05f, -dxOff, dzOff, segment, true, state);
            }
        }
        stack.pop();
    }

    private static void addVertexPair(VertexConsumer builder, Matrix4f pose, float dx, float dy, float dz, float fudge, float dxOff, float dzOff, int segment, boolean backwards, LeashState state) {
        float progress = (float)segment / 24.0f;
        int block = (int)MathHelper.lerp((float)progress, (float)state.startBlockLight, (float)state.endBlockLight);
        int sky = (int)MathHelper.lerp((float)progress, (float)state.startSkyLight, (float)state.endSkyLight);
        int lightCoords = LightmapTextureManager.pack((int)block, (int)sky);
        float colorModifier = segment % 2 == (backwards ? 1 : 0) ? 0.7f : 1.0f;
        float r = 0.5f * colorModifier;
        float g = 0.4f * colorModifier;
        float b = 0.3f * colorModifier;
        float x = dx * progress;
        float y = dy * progress;
        float z = dz * progress;
        if (state.slack) {
            y = dy > 0.0f ? dy * progress * progress : dy - dy * (1.0f - progress) * (1.0f - progress);
        }
        builder.vertex(pose, x - dxOff, y + fudge, z + dzOff).color(r, g, b, 1.0f).light(lightCoords);
        builder.vertex(pose, x + dxOff, y + 0.05f - fudge, z - dzOff).color(r, g, b, 1.0f).light(lightCoords);
    }

    private void setupLeashRendering(T entity, float partialTicks) {
        if (!(entity instanceof Leashable)) {
            this.leashStates = null;
            return;
        }
        Leashable leashable = (Leashable)entity;
        LeashExtension extension = (LeashExtension)leashable;
        Entity holder = leashable.getLeashHolder();
        if (holder != null) {
            int leashCount;
            LeashExtension ext;
            float entityYRot = LeashExtension.vb$getPreciseBodyRotation(entity, partialTicks) * ((float)Math.PI / 180);
            Vec3d attackOffset = entity.getLeashOffset(partialTicks);
            BlockPos entityEyePos = BlockPos.ofFloored((Position)entity.getCameraPosVec(partialTicks));
            BlockPos roperEyePos = BlockPos.ofFloored((Position)holder.getCameraPosVec(partialTicks));
            int startBlockLight = this.getBlockLightLevel((Entity)entity, entityEyePos);
            int endBlockLight = this.getBlockLightLevel(holder, roperEyePos);
            int startSkyLight = entity.getWorld().getLightLevel(LightType.SKY, entityEyePos);
            int endSkyLight = entity.getWorld().getLightLevel(LightType.SKY, roperEyePos);
            boolean quadConnection = holder instanceof LeashExtension && (ext = (LeashExtension)holder).vb$supportQuadLeashAsHolder() && extension.vb$supportQuadLeash();
            int n = leashCount = quadConnection ? 4 : 1;
            if (this.leashStates == null || this.leashStates.size() != leashCount) {
                this.leashStates = new ArrayList<LeashState>(leashCount);
                for (int i = 0; i < leashCount; ++i) {
                    this.leashStates.add(new LeashState());
                }
            }
            if (quadConnection) {
                float roperYRot = LeashExtension.vb$getPreciseBodyRotation(holder, partialTicks) * ((float)Math.PI / 180);
                Vec3d holderPos = holder.getLerpedPos(partialTicks);
                Vec3d[] leashableAttachmentPoints = extension.vb$getQuadLeashOffsets();
                Vec3d[] roperAttachmentPoints = ((LeashExtension)holder).vb$getQuadLeashHolderOffsets();
                for (int i = 0; i < leashCount; ++i) {
                    LeashState leashState = this.leashStates.get(i);
                    leashState.offset = leashableAttachmentPoints[i].rotateY(-entityYRot);
                    leashState.start = entity.getLerpedPos(partialTicks).add(leashState.offset);
                    leashState.end = holderPos.add(roperAttachmentPoints[i].rotateY(-roperYRot));
                    leashState.startBlockLight = startBlockLight;
                    leashState.endBlockLight = endBlockLight;
                    leashState.startSkyLight = startSkyLight;
                    leashState.endSkyLight = endSkyLight;
                    leashState.slack = false;
                }
            } else {
                Vec3d rotatedAttachOffset = attackOffset.rotateY(-entityYRot);
                LeashState leashState = this.leashStates.getFirst();
                leashState.offset = rotatedAttachOffset;
                leashState.start = entity.getLerpedPos(partialTicks).add(rotatedAttachOffset);
                leashState.end = holder.getLeashPos(partialTicks);
                leashState.startBlockLight = startBlockLight;
                leashState.endBlockLight = endBlockLight;
                leashState.startSkyLight = startSkyLight;
                leashState.endSkyLight = endSkyLight;
                leashState.slack = true;
            }
        } else {
            this.leashStates = null;
        }
    }

    private int getBlockLightLevel(Entity entity, BlockPos pos) {
        return ((EntityRendererAccessor)this.dispatcher.getRenderer(entity)).callGetBlockLight(entity, pos);
    }
}

