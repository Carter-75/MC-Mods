/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1297
 *  net.minecraft.class_2338
 *  net.minecraft.class_243
 *  net.minecraft.class_2680
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.gen.Accessor
 */
package org.valkyrienskies.mod.mixin.accessors.entity;

import net.minecraft.class_1297;
import net.minecraft.class_2338;
import net.minecraft.class_243;
import net.minecraft.class_2680;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(value={class_1297.class})
public interface EntityAccessor {
    @Accessor(value="position")
    public void setPosNoUpdates(class_243 var1);

    @Accessor(value="blockPosition")
    public void setBlockPosition(class_2338 var1);

    @Accessor(value="blockPosition")
    public class_2338 getBlockPosition();

    @Accessor(value="feetBlockState")
    public void setFeetBlockState(class_2680 var1);

    @Accessor(value="portalCooldown")
    public void setPortalCooldown(int var1);

    @Accessor(value="portalCooldown")
    public int getPortalCooldown();

    @Accessor(value="portalEntrancePos")
    public class_2338 getPortalEntrancePos();
}

