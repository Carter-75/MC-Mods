/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_2637
 *  net.minecraft.class_4076
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.gen.Accessor
 */
package org.valkyrienskies.mod.mixin.accessors.network.protocol.game;

import net.minecraft.class_2637;
import net.minecraft.class_4076;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(value={class_2637.class})
public interface ClientboundSectionBlocksUpdatePacketAccessor {
    @Accessor
    public class_4076 getSectionPos();
}

