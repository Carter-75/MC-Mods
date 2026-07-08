/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.datafixers.kinds.App
 *  com.mojang.datafixers.kinds.Applicative
 *  com.mojang.serialization.Codec
 *  com.mojang.serialization.MapCodec
 *  com.mojang.serialization.codecs.RecordCodecBuilder
 *  net.minecraft.class_1267
 *  net.minecraft.class_1291
 *  net.minecraft.class_1293
 *  net.minecraft.class_1294
 *  net.minecraft.class_1297
 *  net.minecraft.class_1937
 *  net.minecraft.class_2248
 *  net.minecraft.class_2338
 *  net.minecraft.class_2356
 *  net.minecraft.class_2382
 *  net.minecraft.class_2394
 *  net.minecraft.class_243
 *  net.minecraft.class_2680
 *  net.minecraft.class_3218
 *  net.minecraft.class_3414
 *  net.minecraft.class_3419
 *  net.minecraft.class_4466
 *  net.minecraft.class_4970$class_2251
 *  net.minecraft.class_5712
 *  net.minecraft.class_5712$class_7397
 *  net.minecraft.class_5819
 *  net.minecraft.class_6880
 */
package backported.updates.content.common.level.blocks;

import backported.updates.content.client.level.particles.particleoptions.TrailParticleOption;
import backported.updates.content.client.registries.ModSoundEvents;
import backported.updates.content.common.level.blocks.CreakingHeartBlock;
import backported.updates.content.common.registries.ModBlocks;
import com.mojang.datafixers.kinds.App;
import com.mojang.datafixers.kinds.Applicative;
import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.class_1267;
import net.minecraft.class_1291;
import net.minecraft.class_1293;
import net.minecraft.class_1294;
import net.minecraft.class_1297;
import net.minecraft.class_1937;
import net.minecraft.class_2248;
import net.minecraft.class_2338;
import net.minecraft.class_2356;
import net.minecraft.class_2382;
import net.minecraft.class_2394;
import net.minecraft.class_243;
import net.minecraft.class_2680;
import net.minecraft.class_3218;
import net.minecraft.class_3414;
import net.minecraft.class_3419;
import net.minecraft.class_4466;
import net.minecraft.class_4970;
import net.minecraft.class_5712;
import net.minecraft.class_5819;
import net.minecraft.class_6880;

public class EyeblossomBlock
extends class_2356 {
    public static final MapCodec<EyeblossomBlock> CODEC = RecordCodecBuilder.mapCodec(instance -> instance.group((App)Codec.BOOL.fieldOf("open").forGetter(block -> block.type.open), (App)EyeblossomBlock.method_54096()).apply((Applicative)instance, EyeblossomBlock::new));
    private final Type type;

    public MapCodec<? extends EyeblossomBlock> method_53969() {
        return CODEC;
    }

    public EyeblossomBlock(Type type, class_4970.class_2251 properties) {
        super(type.effect, (float)type.effectDuration, properties);
        this.type = type;
    }

    public EyeblossomBlock(boolean open, class_4970.class_2251 properties) {
        super(Type.fromBoolean((boolean)open).effect, (float)Type.fromBoolean((boolean)open).effectDuration, properties);
        this.type = Type.fromBoolean(open);
    }

    public void method_9496(class_2680 state, class_1937 level, class_2338 pos, class_5819 random) {
        class_2680 floorState;
        if (this.type.emitSounds() && random.method_43048(700) == 0 && (floorState = level.method_8320(pos.method_10074())).method_27852(ModBlocks.PALE_MOSS_BLOCK.get())) {
            level.method_8486((double)pos.method_10263(), (double)pos.method_10264(), (double)pos.method_10260(), ModSoundEvents.EYEBLOSSOM_IDLE.get(), class_3419.field_15245, 1.0f, 1.0f, false);
        }
    }

    public void method_9514(class_2680 state, class_3218 level, class_2338 pos, class_5819 random) {
        if (this.tryChangingState(state, level, pos, random)) {
            level.method_8396(null, pos, this.type.transform().longSwitchSound, class_3419.field_15245, 1.0f, 1.0f);
        }
        super.method_9514(state, level, pos, random);
    }

    public void method_9588(class_2680 state, class_3218 level, class_2338 pos, class_5819 random) {
        if (this.tryChangingState(state, level, pos, random)) {
            level.method_8396(null, pos, this.type.transform().shortSwitchSound, class_3419.field_15245, 1.0f, 1.0f);
        }
        super.method_9588(state, level, pos, random);
    }

    private boolean tryChangingState(class_2680 state, class_3218 level, class_2338 origin, class_5819 random) {
        if (!level.method_8597().comp_645()) {
            return false;
        }
        if (CreakingHeartBlock.isNaturalNight((class_1937)level) == this.type.open) {
            return false;
        }
        Type type = this.type.transform();
        level.method_8652(origin, type.state(), 3);
        level.method_43276((class_6880)class_5712.field_28733, origin, class_5712.class_7397.method_43287((class_2680)state));
        type.spawnTransformParticle(level, origin, random);
        class_2338.method_10097((class_2338)origin.method_10069(-3, -2, -3), (class_2338)origin.method_10069(3, 2, 3)).forEach(pos -> {
            class_2680 closeState = level.method_8320(pos);
            if (closeState == state) {
                double distance = Math.sqrt(origin.method_10262((class_2382)pos));
                int ticks = random.method_39332((int)(distance * 5.0), (int)(distance * 10.0));
                level.method_39279(pos, state.method_26204(), ticks);
            }
        });
        return true;
    }

    public void method_9548(class_2680 state, class_1937 level, class_2338 pos, class_1297 entity) {
        class_4466 bee;
        if (!level.method_8608() && level.method_8407() != class_1267.field_5801 && entity instanceof class_4466 && !(bee = (class_4466)entity).method_6059(class_1294.field_5899)) {
            bee.method_6092(new class_1293(class_1294.field_5899, 25));
        }
    }

    public static enum Type {
        OPEN(true, (class_6880<class_1291>)class_1294.field_5919, 11, ModSoundEvents.EYEBLOSSOM_OPEN_LONG.get(), ModSoundEvents.EYEBLOSSOM_OPEN.get(), 16545810),
        CLOSED(false, (class_6880<class_1291>)class_1294.field_5916, 7, ModSoundEvents.EYEBLOSSOM_CLOSE_LONG.get(), ModSoundEvents.EYEBLOSSOM_CLOSE.get(), 0x5F5F5F);

        final boolean open;
        final class_6880<class_1291> effect;
        final int effectDuration;
        final class_3414 longSwitchSound;
        final class_3414 shortSwitchSound;
        final int particleColor;

        private Type(boolean open, class_6880<class_1291> effect, int effectDuration, class_3414 longSwitchSound, class_3414 shortSwitchSound, int particleColor) {
            this.open = open;
            this.effect = effect;
            this.effectDuration = effectDuration;
            this.longSwitchSound = longSwitchSound;
            this.shortSwitchSound = shortSwitchSound;
            this.particleColor = particleColor;
        }

        public class_2248 block() {
            return this.open ? ModBlocks.OPEN_EYEBLOSSOM.get() : ModBlocks.CLOSED_EYEBLOSSOM.get();
        }

        public class_2680 state() {
            return this.block().method_9564();
        }

        public Type transform() {
            return Type.fromBoolean(!this.open);
        }

        public boolean emitSounds() {
            return this.open;
        }

        public static Type fromBoolean(boolean open) {
            return open ? OPEN : CLOSED;
        }

        public void spawnTransformParticle(class_3218 level, class_2338 pos, class_5819 random) {
            class_243 center = pos.method_46558();
            double scale = 0.5 + random.method_43058();
            class_243 offset = new class_243(random.method_43058() - 0.5, random.method_43058() + 1.0, random.method_43058() - 0.5);
            class_243 target = center.method_1019(offset.method_1021(scale));
            TrailParticleOption particle = new TrailParticleOption(target, this.particleColor, (int)(20.0 * scale));
            level.method_14199((class_2394)particle, center.field_1352, center.field_1351, center.field_1350, 1, 0.0, 0.0, 0.0, 0.0);
        }

        public class_3414 longSwitchSound() {
            return this.longSwitchSound;
        }
    }
}

