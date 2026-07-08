/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.serialization.MapCodec
 *  net.minecraft.world.gen.treedecorator.TreeDecorator
 *  net.minecraft.world.gen.treedecorator.TreeDecoratorType
 *  net.minecraft.registry.RegistryKeys
 */
package backported.updates.content.common.registries;

import backported.updates.content.common.worldgen.treedecorators.AttachedToLogsDecorator;
import backported.updates.content.common.worldgen.treedecorators.CreakingHeartDecorator;
import backported.updates.content.common.worldgen.treedecorators.PaleMossDecorator;
import backported.updates.content.common.worldgen.treedecorators.PlaceOnGroundDecorator;
import backported.updates.foundation.core.CoreRegistry;
import backported_updates.mixin.access.TreeDecoratorTypeAccessor;
import com.mojang.serialization.MapCodec;
import java.util.function.Supplier;
import net.minecraft.world.gen.treedecorator.TreeDecorator;
import net.minecraft.world.gen.treedecorator.TreeDecoratorType;
import net.minecraft.registry.RegistryKeys;

public class ModTreeDecorators {
    public static final CoreRegistry<TreeDecoratorType<?>> DECORATORS = CoreRegistry.create(RegistryKeys.TREE_DECORATOR_TYPE, "minecraft");
    public static final Supplier<TreeDecoratorType<PaleMossDecorator>> PALE_MOSS = ModTreeDecorators.register("pale_moss", PaleMossDecorator.CODEC);
    public static final Supplier<TreeDecoratorType<CreakingHeartDecorator>> CREAKING_HEART = ModTreeDecorators.register("creaking_heart", CreakingHeartDecorator.CODEC);
    public static final Supplier<TreeDecoratorType<AttachedToLogsDecorator>> ATTACHED_TO_LOGS = ModTreeDecorators.register("attached_to_logs", AttachedToLogsDecorator.CODEC);
    public static final Supplier<TreeDecoratorType<PlaceOnGroundDecorator>> PLACE_ON_GROUND = ModTreeDecorators.register("place_on_ground", PlaceOnGroundDecorator.CODEC);

    private static <P extends TreeDecorator> Supplier<TreeDecoratorType<P>> register(String name, MapCodec<P> codec) {
        return DECORATORS.register(name, () -> TreeDecoratorTypeAccessor.createTreeDecorator(codec));
    }
}

