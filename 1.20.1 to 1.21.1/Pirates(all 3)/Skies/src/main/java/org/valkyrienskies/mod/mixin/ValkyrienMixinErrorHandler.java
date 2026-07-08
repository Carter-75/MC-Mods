/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.spongepowered.asm.mixin.extensibility.IMixinConfig
 *  org.spongepowered.asm.mixin.extensibility.IMixinErrorHandler
 *  org.spongepowered.asm.mixin.extensibility.IMixinErrorHandler$ErrorAction
 *  org.spongepowered.asm.mixin.extensibility.IMixinInfo
 */
package org.valkyrienskies.mod.mixin;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import org.spongepowered.asm.mixin.extensibility.IMixinConfig;
import org.spongepowered.asm.mixin.extensibility.IMixinErrorHandler;
import org.spongepowered.asm.mixin.extensibility.IMixinInfo;

public class ValkyrienMixinErrorHandler
implements IMixinErrorHandler {
    private final Set<String> warnList = new HashSet<String>(Arrays.asList("org.valkyrienskies.mod.mixin.feature.water_in_ships_entity.MixinEntity", "org.valkyrienskies.mod.mixin.mod_compat.create_big_cannons.MixinAbstractCannonProjectile", "org.valkyrienskies.mod.mixin.mod_compat.create_big_cannons.MixinPitchOrientedContraptionEntity"));

    public IMixinErrorHandler.ErrorAction onPrepareError(IMixinConfig config, Throwable th, IMixinInfo mixin, IMixinErrorHandler.ErrorAction action) {
        if (this.warnList.contains(mixin.getClassName())) {
            return IMixinErrorHandler.ErrorAction.WARN;
        }
        return null;
    }

    public IMixinErrorHandler.ErrorAction onApplyError(String targetClassName, Throwable th, IMixinInfo mixin, IMixinErrorHandler.ErrorAction action) {
        if (this.warnList.contains(mixin.getClassName())) {
            return IMixinErrorHandler.ErrorAction.WARN;
        }
        return null;
    }
}

