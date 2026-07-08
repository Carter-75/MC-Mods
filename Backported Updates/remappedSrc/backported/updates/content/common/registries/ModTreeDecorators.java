/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.serialization.MapCodec
 *  net.minecraft.class_4662
 *  net.minecraft.class_4663
 *  net.minecraft.class_7924
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
import net.minecraft.class_4662;
import net.minecraft.class_4663;
import net.minecraft.class_7924;

public class ModTreeDecorators {
    public static final CoreRegistry<class_4663<?>> DECORATORS = CoreRegistry.create(class_7924.field_41232, "minecraft");
    public static final Supplier<class_4663<PaleMossDecorator>> PALE_MOSS = ModTreeDecorators.register("pale_moss", PaleMossDecorator.CODEC);
    public static final Supplier<class_4663<CreakingHeartDecorator>> CREAKING_HEART = ModTreeDecorators.register("creaking_heart", CreakingHeartDecorator.CODEC);
    public static final Supplier<class_4663<AttachedToLogsDecorator>> ATTACHED_TO_LOGS = ModTreeDecorators.register("attached_to_logs", AttachedToLogsDecorator.CODEC);
    public static final Supplier<class_4663<PlaceOnGroundDecorator>> PLACE_ON_GROUND = ModTreeDecorators.register("place_on_ground", PlaceOnGroundDecorator.CODEC);

    private static <P extends class_4662> Supplier<class_4663<P>> register(String name, MapCodec<P> codec) {
        return DECORATORS.register(name, () -> TreeDecoratorTypeAccessor.createTreeDecorator(codec));
    }
}

