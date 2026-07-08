/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1297
 *  net.minecraft.class_3222
 *  net.minecraft.class_3244
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.Shadow
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfo
 */
package backported_updates.mixin.common;

import backported.updates.content.common.level.entities.happyghast.HappyGhast;
import net.minecraft.class_1297;
import net.minecraft.class_3222;
import net.minecraft.class_3244;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value={class_3244.class})
public class ServerGamePacketListenerImplMixin {
    @Shadow
    public class_3222 field_14140;
    @Shadow
    private int field_14137;

    @Inject(method={"tick"}, at={@At(value="TAIL")})
    private void vb$preventFlyingKick(CallbackInfo ci) {
        HappyGhast ghast;
        class_1297 vehicle = this.field_14140.method_5854();
        if (vehicle instanceof HappyGhast && !(ghast = (HappyGhast)vehicle).method_6109()) {
            this.field_14137 = 0;
        }
    }
}

