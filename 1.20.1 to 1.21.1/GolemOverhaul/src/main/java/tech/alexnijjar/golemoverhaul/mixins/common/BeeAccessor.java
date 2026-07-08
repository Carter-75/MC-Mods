/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_4466
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.gen.Accessor
 *  org.spongepowered.asm.mixin.gen.Invoker
 */
package tech.alexnijjar.golemoverhaul.mixins.common;

import net.minecraft.class_4466;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;
import org.spongepowered.asm.mixin.gen.Invoker;

@Mixin(value={class_4466.class})
public interface BeeAccessor {
    @Accessor
    public int getRemainingCooldownBeforeLocatingNewHive();

    @Accessor
    public void setRemainingCooldownBeforeLocatingNewHive(int var1);

    @Accessor
    public void setRemainingCooldownBeforeLocatingNewFlower(int var1);

    @Invoker
    public boolean invokeWantsToEnterHive();
}

