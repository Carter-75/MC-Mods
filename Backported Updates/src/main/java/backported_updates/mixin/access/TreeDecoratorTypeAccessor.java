/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.serialization.MapCodec
 *  net.minecraft.world.gen.treedecorator.TreeDecorator
 *  net.minecraft.world.gen.treedecorator.TreeDecoratorType
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.gen.Invoker
 */
package backported_updates.mixin.access;

import com.mojang.serialization.MapCodec;
import net.minecraft.world.gen.treedecorator.TreeDecorator;
import net.minecraft.world.gen.treedecorator.TreeDecoratorType;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;

@Mixin(value={TreeDecoratorType.class})
public interface TreeDecoratorTypeAccessor {
    @Invoker(value="<init>")
    public static <T extends TreeDecorator> TreeDecoratorType<T> createTreeDecorator(MapCodec<T> codec) {
        throw new AssertionError();
    }
}

