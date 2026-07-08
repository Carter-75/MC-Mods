/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.serialization.MapCodec
 *  net.minecraft.class_4662
 *  net.minecraft.class_4663
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.gen.Invoker
 */
package backported_updates.mixin.access;

import com.mojang.serialization.MapCodec;
import net.minecraft.class_4662;
import net.minecraft.class_4663;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;

@Mixin(value={class_4663.class})
public interface TreeDecoratorTypeAccessor {
    @Invoker(value="<init>")
    public static <T extends class_4662> class_4663<T> createTreeDecorator(MapCodec<T> codec) {
        throw new AssertionError();
    }
}

