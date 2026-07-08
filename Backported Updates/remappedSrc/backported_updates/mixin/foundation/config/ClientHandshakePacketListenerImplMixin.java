/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_2899
 *  net.minecraft.class_310
 *  net.minecraft.class_635
 *  org.spongepowered.asm.mixin.Final
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.Shadow
 *  org.spongepowered.asm.mixin.Unique
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfo
 */
package backported_updates.mixin.foundation.config;

import backported.updates.foundation.core.util.config.ConfigTracker;
import net.minecraft.class_2899;
import net.minecraft.class_310;
import net.minecraft.class_635;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value={class_635.class})
public class ClientHandshakePacketListenerImplMixin {
    @Shadow
    @Final
    private class_310 field_3708;
    @Unique
    private boolean hasLoadedConfigs;

    @Inject(method={"handleCustomQuery"}, at={@At(value="HEAD")})
    public void handleCustomQuery(class_2899 packet, CallbackInfo ci) {
        if (!this.hasLoadedConfigs && !this.field_3708.method_1496()) {
            ConfigTracker.INSTANCE.loadDefaultServerConfigs();
            this.hasLoadedConfigs = true;
        }
    }
}

