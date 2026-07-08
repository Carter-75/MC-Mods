/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.datafixers.kinds.App
 *  com.mojang.datafixers.kinds.Applicative
 *  com.mojang.serialization.MapCodec
 *  com.mojang.serialization.codecs.RecordCodecBuilder
 *  net.minecraft.class_1268
 *  net.minecraft.class_1304
 *  net.minecraft.class_1309
 *  net.minecraft.class_1657
 *  net.minecraft.class_1799
 *  net.minecraft.class_1937
 *  net.minecraft.class_2246
 *  net.minecraft.class_2248
 *  net.minecraft.class_2338
 *  net.minecraft.class_2680
 *  net.minecraft.class_3417
 *  net.minecraft.class_3419
 *  net.minecraft.class_3489
 *  net.minecraft.class_3965
 *  net.minecraft.class_4970$class_2251
 *  net.minecraft.class_5955$class_5811
 *  net.minecraft.class_9062
 */
package backported.updates.copper.block;

import backported.updates.copper.block.CopperLightningRodBlock;
import backported.updates.copper.registry.ModBlocks;
import com.mojang.datafixers.kinds.App;
import com.mojang.datafixers.kinds.Applicative;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import java.util.Optional;
import net.minecraft.class_1268;
import net.minecraft.class_1304;
import net.minecraft.class_1309;
import net.minecraft.class_1657;
import net.minecraft.class_1799;
import net.minecraft.class_1937;
import net.minecraft.class_2246;
import net.minecraft.class_2248;
import net.minecraft.class_2338;
import net.minecraft.class_2680;
import net.minecraft.class_3417;
import net.minecraft.class_3419;
import net.minecraft.class_3489;
import net.minecraft.class_3965;
import net.minecraft.class_4970;
import net.minecraft.class_5955;
import net.minecraft.class_9062;

public class WaxedCopperLightningRodBlock
extends CopperLightningRodBlock {
    public static final MapCodec<WaxedCopperLightningRodBlock> CODEC = RecordCodecBuilder.mapCodec(instance -> instance.group((App)class_5955.class_5811.field_46493.fieldOf("weathering_state").forGetter(WaxedCopperLightningRodBlock::getWeatheringState), (App)WaxedCopperLightningRodBlock.method_54096()).apply((Applicative)instance, WaxedCopperLightningRodBlock::new));
    private final class_5955.class_5811 weatheringState;

    @Override
    public MapCodec<? extends CopperLightningRodBlock> method_53969() {
        return CODEC;
    }

    public WaxedCopperLightningRodBlock(class_5955.class_5811 weatheringState, class_4970.class_2251 properties) {
        super(properties);
        this.weatheringState = weatheringState;
    }

    public class_5955.class_5811 getWeatheringState() {
        return this.weatheringState;
    }

    public Optional<class_2248> getUnwaxedBlock() {
        return switch (this.weatheringState) {
            default -> throw new MatchException(null, null);
            case class_5955.class_5811.field_28704 -> Optional.of(class_2246.field_27171);
            case class_5955.class_5811.field_28705 -> Optional.of((class_2248)ModBlocks.EXPOSED_LIGHTNING_ROD.get());
            case class_5955.class_5811.field_28706 -> Optional.of((class_2248)ModBlocks.WEATHERED_LIGHTNING_ROD.get());
            case class_5955.class_5811.field_28707 -> Optional.of((class_2248)ModBlocks.OXIDIZED_LIGHTNING_ROD.get());
        };
    }

    protected class_9062 method_55765(class_1799 stack, class_2680 state, class_1937 level, class_2338 pos, class_1657 player, class_1268 hand, class_3965 hitResult) {
        Optional<class_2248> unwaxed;
        if (stack.method_31573(class_3489.field_42612) && (unwaxed = this.getUnwaxedBlock()).isPresent()) {
            level.method_8396(player, pos, class_3417.field_29542, class_3419.field_15245, 1.0f, 1.0f);
            level.method_8444(player, 3004, pos, 0);
            if (!level.field_9236) {
                level.method_8652(pos, unwaxed.get().method_34725(state), 11);
                if (!player.method_31549().field_7477) {
                    stack.method_7970(1, (class_1309)player, hand == class_1268.field_5808 ? class_1304.field_6173 : class_1304.field_6171);
                }
            }
            return class_9062.method_55644((boolean)level.field_9236);
        }
        return super.method_55765(stack, state, level, pos, player, hand, hitResult);
    }
}

