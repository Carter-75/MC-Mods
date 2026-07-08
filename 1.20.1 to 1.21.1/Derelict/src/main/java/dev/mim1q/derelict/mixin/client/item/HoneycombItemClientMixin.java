/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.common.collect.BiMap
 *  net.minecraft.class_2248
 *  net.minecraft.class_2960
 *  net.minecraft.class_5953
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.Unique
 */
package dev.mim1q.derelict.mixin.client.item;

import com.google.common.collect.BiMap;
import dev.mim1q.derelict.config.DerelictConfigs;
import dev.mim1q.derelict.item.CrosshairTipItem;
import net.minecraft.class_2248;
import net.minecraft.class_2960;
import net.minecraft.class_5953;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;

@Mixin(value={class_5953.class})
public class HoneycombItemClientMixin
implements CrosshairTipItem {
    @Unique
    private static final class_2960 TEXTURE = new class_2960("textures/item/honeycomb.png");
    @Unique
    private class_2248 lastBlock = null;
    @Unique
    private boolean didShowTip = false;

    @Override
    public boolean shouldShowTip(@Nullable class_2248 block) {
        if (block == null || !DerelictConfigs.CLIENT_CONFIG.waxableCrosshairTip()) {
            return false;
        }
        if (block == this.lastBlock) {
            return this.didShowTip;
        }
        this.lastBlock = block;
        this.didShowTip = ((BiMap)class_5953.field_29560.get()).containsKey((Object)block);
        return this.didShowTip;
    }

    @Override
    @NotNull
    public class_2960 getTipTexture() {
        return TEXTURE;
    }
}

