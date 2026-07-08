/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1297
 *  net.minecraft.class_4048
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.gen.Accessor
 *  org.spongepowered.asm.mixin.gen.Invoker
 */
package backported_updates.mixin.access;

import net.minecraft.class_1297;
import net.minecraft.class_4048;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;
import org.spongepowered.asm.mixin.gen.Invoker;

@Mixin(value={class_1297.class})
public interface EntityAccessor {
    @Accessor
    public class_4048 getDimensions();

    @Invoker
    public void callReapplyPosition();

    @Invoker
    public void callSetRot(float var1, float var2);
}

