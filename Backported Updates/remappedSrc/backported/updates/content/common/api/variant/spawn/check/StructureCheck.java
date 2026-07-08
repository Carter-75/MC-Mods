/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.datafixers.kinds.App
 *  com.mojang.datafixers.kinds.Applicative
 *  com.mojang.serialization.MapCodec
 *  com.mojang.serialization.codecs.RecordCodecBuilder
 *  net.minecraft.class_1923
 *  net.minecraft.class_2338
 *  net.minecraft.class_2378
 *  net.minecraft.class_3195
 *  net.minecraft.class_3449
 *  net.minecraft.class_5138
 *  net.minecraft.class_5321
 *  net.minecraft.class_6880
 *  net.minecraft.class_6885
 *  net.minecraft.class_6895
 *  net.minecraft.class_7924
 */
package backported.updates.content.common.api.variant.spawn.check;

import backported.updates.content.common.api.variant.spawn.SpawnCondition;
import backported.updates.content.common.api.variant.spawn.SpawnContext;
import com.mojang.datafixers.kinds.App;
import com.mojang.datafixers.kinds.Applicative;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import java.util.List;
import java.util.function.Predicate;
import net.minecraft.class_1923;
import net.minecraft.class_2338;
import net.minecraft.class_2378;
import net.minecraft.class_3195;
import net.minecraft.class_3449;
import net.minecraft.class_5138;
import net.minecraft.class_5321;
import net.minecraft.class_6880;
import net.minecraft.class_6885;
import net.minecraft.class_6895;
import net.minecraft.class_7924;

public record StructureCheck(class_6885<class_3195> requiredStructures) implements SpawnCondition
{
    public static final MapCodec<StructureCheck> CODEC = RecordCodecBuilder.mapCodec(instance -> instance.group((App)class_6895.method_40340((class_5321)class_7924.field_41246).fieldOf("structures").forGetter(StructureCheck::requiredStructures)).apply((Applicative)instance, StructureCheck::new));

    @Override
    public boolean test(SpawnContext context) {
        return this.getStructureWithPieceAt(context, arg_0 -> this.requiredStructures.method_40241(arg_0)).method_16657();
    }

    private class_3449 getStructureWithPieceAt(SpawnContext context, Predicate<class_6880<class_3195>> predicate) {
        class_5138 manager = context.level().method_8410().method_27056();
        class_2338 pos = context.pos();
        class_2378 registry = manager.method_41036().method_30530(class_7924.field_41246);
        List starts = manager.method_41035(new class_1923(pos), structure -> registry.method_40265(registry.method_10206(structure)).map(predicate::test).orElse(false));
        for (class_3449 start : starts) {
            if (!manager.method_41033(pos, start)) continue;
            return start;
        }
        return class_3449.field_16713;
    }

    @Override
    public MapCodec<? extends SpawnCondition> codec() {
        return CODEC;
    }
}

