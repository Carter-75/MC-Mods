/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.netty.buffer.Unpooled
 *  net.minecraft.class_11
 *  net.minecraft.class_1308
 *  net.minecraft.class_1657
 *  net.minecraft.class_1937
 *  net.minecraft.class_2540
 *  net.minecraft.class_2596
 *  net.minecraft.class_2658
 *  net.minecraft.class_3222
 *  net.minecraft.class_4209
 *  net.minecraft.class_4459
 *  net.minecraft.class_9
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfo
 */
package org.valkyrienskies.mod.mixin.feature.render_pathfinding;

import io.netty.buffer.Unpooled;
import java.util.Set;
import net.minecraft.class_11;
import net.minecraft.class_1308;
import net.minecraft.class_1657;
import net.minecraft.class_1937;
import net.minecraft.class_2540;
import net.minecraft.class_2596;
import net.minecraft.class_2658;
import net.minecraft.class_3222;
import net.minecraft.class_4209;
import net.minecraft.class_4459;
import net.minecraft.class_9;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.valkyrienskies.mod.common.config.VSGameConfig;
import org.valkyrienskies.mod.mixin.accessors.world.level.pathfinder.PathAccessor;

@Mixin(value={class_4209.class})
public class MixinDebugPackets {
    @Inject(method={"sendPathFindingPacket"}, at={@At(value="HEAD")})
    private static void sendPathFindingPacket(class_1937 level, class_1308 mob, class_11 path, float maxDistanceToWaypoint, CallbackInfo ci) {
        if (path == null || level.field_9236 || !VSGameConfig.COMMON.ADVANCED.getRenderPathfinding()) {
            return;
        }
        class_2540 buf = new class_2540(Unpooled.buffer());
        buf.writeInt(mob.method_5628());
        buf.writeFloat(maxDistanceToWaypoint);
        MixinDebugPackets.writePath(buf, path);
        class_2658 lv = new class_2658(class_2658.field_12161, buf);
        for (class_1657 player : level.method_18456()) {
            ((class_3222)player).field_13987.method_14364((class_2596)lv);
        }
    }

    private static void writePath(class_2540 buffer, class_11 path) {
        buffer.writeBoolean(path.method_21655());
        buffer.writeInt(path.method_39());
        Set<class_4459> targetSet = ((PathAccessor)path).getTargetNodes();
        if (targetSet != null) {
            buffer.writeInt(targetSet.size());
            targetSet.forEach(node -> MixinDebugPackets.writeNode(buffer, (class_9)node));
        } else {
            buffer.writeInt(0);
        }
        buffer.writeInt(path.method_48().method_10263());
        buffer.writeInt(path.method_48().method_10264());
        buffer.writeInt(path.method_48().method_10260());
        buffer.writeInt(path.method_38());
        for (int i2 = 0; i2 < path.method_38(); ++i2) {
            class_9 node2 = path.method_40(i2);
            MixinDebugPackets.writeNode(buffer, node2);
        }
        buffer.writeInt(0);
        buffer.writeInt(0);
    }

    private static void writeNode(class_2540 buffer, class_9 node) {
        buffer.writeInt(node.field_40);
        buffer.writeInt(node.field_39);
        buffer.writeInt(node.field_38);
        buffer.writeFloat(node.field_46);
        buffer.writeFloat(node.field_43);
        buffer.writeBoolean(node.field_42);
        buffer.writeInt(node.field_41.ordinal());
        buffer.writeFloat(node.field_47);
    }
}

