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
 *  net.minecraft.class_1802
 *  net.minecraft.class_1937
 *  net.minecraft.class_2246
 *  net.minecraft.class_2248
 *  net.minecraft.class_2338
 *  net.minecraft.class_2680
 *  net.minecraft.class_3218
 *  net.minecraft.class_3417
 *  net.minecraft.class_3419
 *  net.minecraft.class_3489
 *  net.minecraft.class_3965
 *  net.minecraft.class_4970$class_2251
 *  net.minecraft.class_5547
 *  net.minecraft.class_5819
 *  net.minecraft.class_5955
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
import net.minecraft.class_1802;
import net.minecraft.class_1937;
import net.minecraft.class_2246;
import net.minecraft.class_2248;
import net.minecraft.class_2338;
import net.minecraft.class_2680;
import net.minecraft.class_3218;
import net.minecraft.class_3417;
import net.minecraft.class_3419;
import net.minecraft.class_3489;
import net.minecraft.class_3965;
import net.minecraft.class_4970;
import net.minecraft.class_5547;
import net.minecraft.class_5819;
import net.minecraft.class_5955;
import net.minecraft.class_9062;

public class WeatheringCopperLightningRodBlock
extends CopperLightningRodBlock
implements class_5955 {
    public static final MapCodec<WeatheringCopperLightningRodBlock> CODEC = RecordCodecBuilder.mapCodec(instance -> instance.group((App)class_5955.class_5811.field_46493.fieldOf("weathering_state").forGetter(class_5547::method_33622), (App)WeatheringCopperLightningRodBlock.method_54096()).apply((Applicative)instance, WeatheringCopperLightningRodBlock::new));
    private final class_5955.class_5811 weatherState;

    @Override
    public MapCodec<? extends CopperLightningRodBlock> method_53969() {
        return CODEC;
    }

    public WeatheringCopperLightningRodBlock(class_5955.class_5811 weatherState, class_4970.class_2251 properties) {
        super(properties);
        this.weatherState = weatherState;
    }

    public class_5955.class_5811 getAge() {
        return this.weatherState;
    }

    public Optional<class_2248> getNextBlock() {
        return switch (this.weatherState) {
            default -> throw new MatchException(null, null);
            case class_5955.class_5811.field_28704 -> Optional.of((class_2248)ModBlocks.EXPOSED_LIGHTNING_ROD.get());
            case class_5955.class_5811.field_28705 -> Optional.of((class_2248)ModBlocks.WEATHERED_LIGHTNING_ROD.get());
            case class_5955.class_5811.field_28706 -> Optional.of((class_2248)ModBlocks.OXIDIZED_LIGHTNING_ROD.get());
            case class_5955.class_5811.field_28707 -> Optional.empty();
        };
    }

    public Optional<class_2248> getPreviousBlock() {
        return switch (this.weatherState) {
            default -> throw new MatchException(null, null);
            case class_5955.class_5811.field_28704 -> Optional.empty();
            case class_5955.class_5811.field_28705 -> Optional.of(class_2246.field_27171);
            case class_5955.class_5811.field_28706 -> Optional.of((class_2248)ModBlocks.EXPOSED_LIGHTNING_ROD.get());
            case class_5955.class_5811.field_28707 -> Optional.of((class_2248)ModBlocks.WEATHERED_LIGHTNING_ROD.get());
        };
    }

    public Optional<class_2248> getWaxedBlock() {
        return switch (this.weatherState) {
            default -> throw new MatchException(null, null);
            case class_5955.class_5811.field_28704 -> Optional.of((class_2248)ModBlocks.WAXED_LIGHTNING_ROD.get());
            case class_5955.class_5811.field_28705 -> Optional.of((class_2248)ModBlocks.WAXED_EXPOSED_LIGHTNING_ROD.get());
            case class_5955.class_5811.field_28706 -> Optional.of((class_2248)ModBlocks.WAXED_WEATHERED_LIGHTNING_ROD.get());
            case class_5955.class_5811.field_28707 -> Optional.of((class_2248)ModBlocks.WAXED_OXIDIZED_LIGHTNING_ROD.get());
        };
    }

    protected void method_9514(class_2680 state, class_3218 level, class_2338 pos, class_5819 random) {
        this.method_54764(state, level, pos, random);
    }

    protected boolean method_9542(class_2680 state) {
        return this.getNextBlock().isPresent();
    }

    public Optional<class_2680> method_31639(class_2680 state) {
        return this.getNextBlock().map(block -> block.method_34725(state));
    }

    public float method_33620() {
        return 1.0f;
    }

    protected class_9062 method_55765(class_1799 stack, class_2680 state, class_1937 level, class_2338 pos, class_1657 player, class_1268 hand, class_3965 hitResult) {
        Optional<class_2248> previousBlock;
        Optional<class_2248> waxedBlock;
        if (stack.method_31574(class_1802.field_20414) && (waxedBlock = this.getWaxedBlock()).isPresent()) {
            level.method_8396(player, pos, class_3417.field_29543, class_3419.field_15245, 1.0f, 1.0f);
            level.method_8444(player, 3003, pos, 0);
            if (!level.field_9236) {
                level.method_8652(pos, waxedBlock.get().method_34725(state), 11);
                if (!player.method_31549().field_7477) {
                    stack.method_7934(1);
                }
            }
            return class_9062.method_55644((boolean)level.field_9236);
        }
        if (stack.method_31573(class_3489.field_42612) && (previousBlock = this.getPreviousBlock()).isPresent()) {
            level.method_8396(player, pos, class_3417.field_29541, class_3419.field_15245, 1.0f, 1.0f);
            level.method_8444(player, 3005, pos, 0);
            if (!level.field_9236) {
                level.method_8652(pos, previousBlock.get().method_34725(state), 11);
                if (!player.method_31549().field_7477) {
                    stack.method_7970(1, (class_1309)player, hand == class_1268.field_5808 ? class_1304.field_6173 : class_1304.field_6171);
                }
            }
            return class_9062.method_55644((boolean)level.field_9236);
        }
        return super.method_55765(stack, state, level, pos, player, hand, hitResult);
    }
}

