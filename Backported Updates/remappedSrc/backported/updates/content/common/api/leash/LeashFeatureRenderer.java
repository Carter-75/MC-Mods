/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.fabricmc.api.EnvType
 *  net.fabricmc.api.Environment
 *  net.minecraft.class_1297
 *  net.minecraft.class_1921
 *  net.minecraft.class_1944
 *  net.minecraft.class_2338
 *  net.minecraft.class_2374
 *  net.minecraft.class_238
 *  net.minecraft.class_243
 *  net.minecraft.class_3532
 *  net.minecraft.class_4587
 *  net.minecraft.class_4588
 *  net.minecraft.class_4597
 *  net.minecraft.class_4604
 *  net.minecraft.class_765
 *  net.minecraft.class_898
 *  net.minecraft.class_9817
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
import net.minecraft.class_1297;
import net.minecraft.class_1921;
import net.minecraft.class_1944;
import net.minecraft.class_2338;
import net.minecraft.class_2374;
import net.minecraft.class_238;
import net.minecraft.class_243;
import net.minecraft.class_3532;
import net.minecraft.class_4587;
import net.minecraft.class_4588;
import net.minecraft.class_4597;
import net.minecraft.class_4604;
import net.minecraft.class_765;
import net.minecraft.class_898;
import net.minecraft.class_9817;
import org.jetbrains.annotations.Nullable;
import org.joml.Matrix4f;

@Environment(value=EnvType.CLIENT)
public class LeashFeatureRenderer<T extends class_1297> {
    private static final int LEASH_RENDER_STEPS = 24;
    private static final float LEASH_WIDTH = 0.05f;
    private final class_898 dispatcher;
    @Nullable
    private List<LeashState> leashStates;

    public LeashFeatureRenderer(class_898 dispatcher) {
        this.dispatcher = dispatcher;
    }

    public boolean shouldRender(T entity, class_4604 camera, boolean isVisible, boolean fallback) {
        if (!isVisible) {
            class_9817 leashable;
            class_1297 leashHolder;
            class_238 boundingBox = entity.method_5830().method_1014(0.5);
            if (boundingBox.method_1013() || boundingBox.method_995() == 0.0) {
                boundingBox = new class_238(entity.method_23317() - 2.0, entity.method_23318() - 2.0, entity.method_23321() - 2.0, entity.method_23317() + 2.0, entity.method_23318() + 2.0, entity.method_23321() + 2.0);
            }
            if (camera.method_23093(boundingBox)) {
                return true;
            }
            if (entity instanceof class_9817 && (leashHolder = (leashable = (class_9817)entity).method_60952()) != null) {
                class_238 leasherBox = leashHolder.method_5830();
                return camera.method_23093(leasherBox) || camera.method_23093(boundingBox.method_991(leasherBox));
            }
        }
        return fallback;
    }

    public boolean shouldRender(T entity, class_4604 camera, boolean isVisible) {
        return this.shouldRender(entity, camera, isVisible, isVisible);
    }

    public void render(T entity, float partialTick, class_4587 poseStack, class_4597 buffer) {
        this.setupLeashRendering(entity, partialTick);
        if (this.leashStates != null) {
            for (LeashState leashState : this.leashStates) {
                this.renderLeash(poseStack, buffer, leashState);
            }
        }
    }

    private void renderLeash(class_4587 stack, class_4597 buffer, LeashState state) {
        int segment;
        float dx = (float)(state.end.field_1352 - state.start.field_1352);
        float dy = (float)(state.end.field_1351 - state.start.field_1351);
        float dz = (float)(state.end.field_1350 - state.start.field_1350);
        float offsetFactor = class_3532.method_48119((float)(dx * dx + dz * dz)) * 0.05f / 2.0f;
        float dxOff = dz * offsetFactor;
        float dzOff = dx * offsetFactor;
        stack.method_22903();
        stack.method_22904(state.offset.field_1352, state.offset.field_1351, state.offset.field_1350);
        class_4588 builder = buffer.getBuffer(class_1921.method_23587());
        Matrix4f matrices = stack.method_23760().method_23761();
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
        stack.method_22909();
    }

    private static void addVertexPair(class_4588 builder, Matrix4f pose, float dx, float dy, float dz, float fudge, float dxOff, float dzOff, int segment, boolean backwards, LeashState state) {
        float progress = (float)segment / 24.0f;
        int block = (int)class_3532.method_16439((float)progress, (float)state.startBlockLight, (float)state.endBlockLight);
        int sky = (int)class_3532.method_16439((float)progress, (float)state.startSkyLight, (float)state.endSkyLight);
        int lightCoords = class_765.method_23687((int)block, (int)sky);
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
        builder.method_22918(pose, x - dxOff, y + fudge, z + dzOff).method_22915(r, g, b, 1.0f).method_60803(lightCoords);
        builder.method_22918(pose, x + dxOff, y + 0.05f - fudge, z - dzOff).method_22915(r, g, b, 1.0f).method_60803(lightCoords);
    }

    private void setupLeashRendering(T entity, float partialTicks) {
        if (!(entity instanceof class_9817)) {
            this.leashStates = null;
            return;
        }
        class_9817 leashable = (class_9817)entity;
        LeashExtension extension = (LeashExtension)leashable;
        class_1297 holder = leashable.method_60952();
        if (holder != null) {
            int leashCount;
            LeashExtension ext;
            float entityYRot = LeashExtension.vb$getPreciseBodyRotation(entity, partialTicks) * ((float)Math.PI / 180);
            class_243 attackOffset = entity.method_45321(partialTicks);
            class_2338 entityEyePos = class_2338.method_49638((class_2374)entity.method_5836(partialTicks));
            class_2338 roperEyePos = class_2338.method_49638((class_2374)holder.method_5836(partialTicks));
            int startBlockLight = this.getBlockLightLevel((class_1297)entity, entityEyePos);
            int endBlockLight = this.getBlockLightLevel(holder, roperEyePos);
            int startSkyLight = entity.method_37908().method_8314(class_1944.field_9284, entityEyePos);
            int endSkyLight = entity.method_37908().method_8314(class_1944.field_9284, roperEyePos);
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
                class_243 holderPos = holder.method_30950(partialTicks);
                class_243[] leashableAttachmentPoints = extension.vb$getQuadLeashOffsets();
                class_243[] roperAttachmentPoints = ((LeashExtension)holder).vb$getQuadLeashHolderOffsets();
                for (int i = 0; i < leashCount; ++i) {
                    LeashState leashState = this.leashStates.get(i);
                    leashState.offset = leashableAttachmentPoints[i].method_1024(-entityYRot);
                    leashState.start = entity.method_30950(partialTicks).method_1019(leashState.offset);
                    leashState.end = holderPos.method_1019(roperAttachmentPoints[i].method_1024(-roperYRot));
                    leashState.startBlockLight = startBlockLight;
                    leashState.endBlockLight = endBlockLight;
                    leashState.startSkyLight = startSkyLight;
                    leashState.endSkyLight = endSkyLight;
                    leashState.slack = false;
                }
            } else {
                class_243 rotatedAttachOffset = attackOffset.method_1024(-entityYRot);
                LeashState leashState = this.leashStates.getFirst();
                leashState.offset = rotatedAttachOffset;
                leashState.start = entity.method_30950(partialTicks).method_1019(rotatedAttachOffset);
                leashState.end = holder.method_30951(partialTicks);
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

    private int getBlockLightLevel(class_1297 entity, class_2338 pos) {
        return ((EntityRendererAccessor)this.dispatcher.method_3953(entity)).callGetBlockLightLevel(entity, pos);
    }
}

