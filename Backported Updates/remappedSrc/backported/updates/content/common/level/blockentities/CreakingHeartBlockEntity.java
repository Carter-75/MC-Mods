/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.datafixers.util.Either
 *  net.minecraft.class_1267
 *  net.minecraft.class_1282
 *  net.minecraft.class_1297
 *  net.minecraft.class_156
 *  net.minecraft.class_1657
 *  net.minecraft.class_1928
 *  net.minecraft.class_1937
 *  net.minecraft.class_2246
 *  net.minecraft.class_2248
 *  net.minecraft.class_2338
 *  net.minecraft.class_2350
 *  net.minecraft.class_2374
 *  net.minecraft.class_238
 *  net.minecraft.class_2382
 *  net.minecraft.class_243
 *  net.minecraft.class_2487
 *  net.minecraft.class_2586
 *  net.minecraft.class_2596
 *  net.minecraft.class_2602
 *  net.minecraft.class_2622
 *  net.minecraft.class_2680
 *  net.minecraft.class_2741
 *  net.minecraft.class_2769
 *  net.minecraft.class_3218
 *  net.minecraft.class_3419
 *  net.minecraft.class_3532
 *  net.minecraft.class_3730
 *  net.minecraft.class_4538
 *  net.minecraft.class_5712
 *  net.minecraft.class_5712$class_7397
 *  net.minecraft.class_5778
 *  net.minecraft.class_5819
 *  net.minecraft.class_6880
 *  net.minecraft.class_7225$class_7874
 *  org.apache.commons.lang3.mutable.Mutable
 *  org.apache.commons.lang3.mutable.MutableObject
 *  org.jetbrains.annotations.Nullable
 */
package backported.updates.content.common.level.blockentities;

import backported.updates.content.client.level.particles.particleoptions.TrailParticleOption;
import backported.updates.content.client.registries.ModParticles;
import backported.updates.content.client.registries.ModSoundEvents;
import backported.updates.content.common.level.blocks.CreakingHeartBlock;
import backported.updates.content.common.level.blocks.blockstates.CreakingHeartState;
import backported.updates.content.common.level.entities.creaking.Creaking;
import backported.updates.content.common.registries.ModBlockEntities;
import backported.updates.content.common.registries.ModBlocks;
import backported.updates.content.common.registries.ModEntities;
import backported.updates.content.core.VanillaBackport;
import backported.updates.content.core.data.tags.ModBlockTags;
import backported.updates.content.core.util.SpawnExtras;
import com.mojang.datafixers.util.Either;
import java.util.Optional;
import java.util.UUID;
import net.minecraft.class_1267;
import net.minecraft.class_1282;
import net.minecraft.class_1297;
import net.minecraft.class_156;
import net.minecraft.class_1657;
import net.minecraft.class_1928;
import net.minecraft.class_1937;
import net.minecraft.class_2246;
import net.minecraft.class_2248;
import net.minecraft.class_2338;
import net.minecraft.class_2350;
import net.minecraft.class_2374;
import net.minecraft.class_238;
import net.minecraft.class_2382;
import net.minecraft.class_243;
import net.minecraft.class_2487;
import net.minecraft.class_2586;
import net.minecraft.class_2596;
import net.minecraft.class_2602;
import net.minecraft.class_2622;
import net.minecraft.class_2680;
import net.minecraft.class_2741;
import net.minecraft.class_2769;
import net.minecraft.class_3218;
import net.minecraft.class_3419;
import net.minecraft.class_3532;
import net.minecraft.class_3730;
import net.minecraft.class_4538;
import net.minecraft.class_5712;
import net.minecraft.class_5778;
import net.minecraft.class_5819;
import net.minecraft.class_6880;
import net.minecraft.class_7225;
import org.apache.commons.lang3.mutable.Mutable;
import org.apache.commons.lang3.mutable.MutableObject;
import org.jetbrains.annotations.Nullable;

public class CreakingHeartBlockEntity
extends class_2586 {
    private static final Optional<Creaking> NO_CREAKING = Optional.empty();
    @Nullable
    private Either<Creaking, UUID> creakingInfo;
    private long ticksExisted;
    private int ticker;
    private int emitter;
    @Nullable
    private class_243 emitterTarget;
    private int outputSignal;

    public CreakingHeartBlockEntity(class_2338 pos, class_2680 state) {
        super(ModBlockEntities.CREAKING_HEART.get(), pos, state);
    }

    public static void serverTick(class_1937 level, class_2338 pos, class_2680 state, CreakingHeartBlockEntity heart) {
        ++heart.ticksExisted;
        if (level instanceof class_3218) {
            class_3218 server = (class_3218)level;
            int signal = heart.computeAnalogOutputSignal();
            if (heart.outputSignal != signal) {
                heart.outputSignal = signal;
                level.method_8455(pos, ModBlocks.CREAKING_HEART.get());
            }
            if (heart.emitter > 0) {
                if (heart.emitter > 50) {
                    heart.emitParticles(server, 1, true);
                    heart.emitParticles(server, 1, false);
                }
                if (heart.emitter % 10 == 0 && heart.emitterTarget != null) {
                    heart.getCreakingProtector().ifPresent(creaking -> {
                        heart.emitterTarget = creaking.method_5829().method_1005();
                    });
                    class_243 center = class_243.method_24953((class_2382)pos);
                    float emission = 0.2f + 0.8f * (float)(100 - heart.emitter) / 100.0f;
                    class_243 position = center.method_1020(heart.emitterTarget).method_1021((double)emission).method_1019(heart.emitterTarget);
                    class_2338 target = class_2338.method_49638((class_2374)position);
                    float volume = (float)heart.emitter / 2.0f / 100.0f + 0.5f;
                    level.method_8396(null, target, ModSoundEvents.CREAKING_HEART_HURT.get(), class_3419.field_15245, volume, 1.0f);
                }
                --heart.emitter;
            }
            if (heart.ticker-- < 0) {
                heart.ticker = heart.field_11863 == null ? 20 : heart.field_11863.field_9229.method_43048(5) + 20;
                class_2680 updatedState = CreakingHeartBlockEntity.updateCreakingState(level, state, pos, heart);
                if (updatedState != state) {
                    level.method_8652(pos, updatedState, 3);
                    if (updatedState.method_11654(CreakingHeartBlock.STATE) == CreakingHeartState.UPROOTED) {
                        return;
                    }
                }
                if (heart.creakingInfo == null) {
                    class_1657 player;
                    if (updatedState.method_11654(CreakingHeartBlock.STATE) == CreakingHeartState.AWAKE && level.method_8407() != class_1267.field_5801 && level.method_8450().method_8355(class_1928.field_19390) && (player = level.method_18459((double)pos.method_10263(), (double)pos.method_10264(), (double)pos.method_10260(), 32.0, false)) != null && (creaking = CreakingHeartBlockEntity.spawnProtector(server, heart)) != null) {
                        heart.setCreakingInfo(creaking);
                        creaking.method_43077(ModSoundEvents.CREAKING_SPAWN.get());
                        level.method_8396(null, heart.method_11016(), ModSoundEvents.CREAKING_HEART_SPAWN.get(), class_3419.field_15245, 1.0f, 1.0f);
                    }
                } else {
                    Optional<Creaking> protector = heart.getCreakingProtector();
                    if (protector.isPresent()) {
                        creaking = protector.get();
                        if (!CreakingHeartBlock.isNaturalNight(level) && !creaking.method_5947() || heart.distanceToCreaking() > 34.0 || creaking.playerIsStuckInYou()) {
                            heart.removeProtector(null);
                        }
                    }
                }
            }
        }
    }

    private static class_2680 updateCreakingState(class_1937 level, class_2680 state, class_2338 pos, CreakingHeartBlockEntity heart) {
        if (!CreakingHeartBlock.hasRequiredLogs(state, (class_4538)level, pos) && heart.creakingInfo == null) {
            return (class_2680)state.method_11657(CreakingHeartBlock.STATE, (Comparable)((Object)CreakingHeartState.UPROOTED));
        }
        boolean isNaturalNight = CreakingHeartBlock.isNaturalNight(level);
        return (class_2680)state.method_11657(CreakingHeartBlock.STATE, (Comparable)((Object)(isNaturalNight ? CreakingHeartState.AWAKE : CreakingHeartState.DORMANT)));
    }

    private double distanceToCreaking() {
        return this.getCreakingProtector().map(creaking -> Math.sqrt(creaking.method_5707(class_243.method_24955((class_2382)this.method_11016())))).orElse(0.0);
    }

    private void clearCreakingInfo() {
        this.creakingInfo = null;
        this.method_5431();
    }

    public void setCreakingInfo(Creaking creaking) {
        this.creakingInfo = Either.left((Object)((Object)creaking));
        this.method_5431();
    }

    public void setCreakingInfo(UUID uuid) {
        this.creakingInfo = Either.right((Object)uuid);
        this.ticksExisted = 0L;
        this.method_5431();
    }

    private Optional<Creaking> getCreakingProtector() {
        class_1937 class_19372;
        if (this.creakingInfo == null) {
            return NO_CREAKING;
        }
        if (this.creakingInfo.left().isPresent()) {
            Creaking creaking = (Creaking)((Object)this.creakingInfo.left().get());
            if (!creaking.method_31481()) {
                return Optional.of(creaking);
            }
            this.setCreakingInfo(creaking.method_5667());
        }
        if ((class_19372 = this.field_11863) instanceof class_3218) {
            class_3218 server = (class_3218)class_19372;
            if (this.creakingInfo.right().isPresent()) {
                UUID uuid = (UUID)this.creakingInfo.right().get();
                class_1297 class_12972 = server.method_14190(uuid);
                if (class_12972 instanceof Creaking) {
                    Creaking creaking = (Creaking)class_12972;
                    this.setCreakingInfo(creaking);
                    return Optional.of(creaking);
                }
                if (this.ticksExisted >= 30L) {
                    this.clearCreakingInfo();
                }
                return NO_CREAKING;
            }
        }
        return NO_CREAKING;
    }

    @Nullable
    private static Creaking spawnProtector(class_3218 level, CreakingHeartBlockEntity heart) {
        if (!VanillaBackport.COMMON_CONFIG.hasCreaking.get().booleanValue()) {
            return null;
        }
        class_2338 pos = heart.method_11016();
        Optional<Creaking> protector = SpawnExtras.trySpawnMob(ModEntities.CREAKING.get(), class_3730.field_16469, level, pos, 5, 16, 8, SpawnExtras.ON_TOP_OF_COLLIDER_NO_LEAVES, true);
        if (protector.isEmpty()) {
            return null;
        }
        Creaking creaking = protector.get();
        level.method_43275((class_1297)creaking, (class_6880)class_5712.field_28738, creaking.method_19538());
        level.method_8421((class_1297)creaking, (byte)60);
        creaking.setTransient(pos);
        return creaking;
    }

    public class_2596<class_2602> method_38235() {
        return class_2622.method_38585((class_2586)this);
    }

    public class_2487 method_16887(class_7225.class_7874 provider) {
        return this.method_58692(provider);
    }

    public void creakingHurt() {
        class_1937 class_19372;
        Creaking creaking = this.getCreakingProtector().orElse(null);
        if (creaking != null && (class_19372 = this.field_11863) instanceof class_3218) {
            class_3218 server = (class_3218)class_19372;
            if (this.emitter <= 0) {
                this.emitParticles(server, 20, false);
                if (this.method_11010().method_11654(CreakingHeartBlock.STATE) == CreakingHeartState.AWAKE && VanillaBackport.COMMON_CONFIG.hasResin.get().booleanValue()) {
                    int i = this.field_11863.method_8409().method_39332(2, 3);
                    for (int j = 0; j < i; ++j) {
                        this.spreadResin().ifPresent(pos -> {
                            this.field_11863.method_8396(null, pos, ModSoundEvents.RESIN_PLACE.get(), class_3419.field_15245, 1.0f, 1.0f);
                            this.field_11863.method_43276((class_6880)class_5712.field_28164, pos, class_5712.class_7397.method_43287((class_2680)this.method_11010()));
                        });
                    }
                }
                this.emitter = 100;
                this.emitterTarget = creaking.method_5829().method_1005();
            }
        }
    }

    private Optional<class_2338> spreadResin() {
        if (this.field_11863 == null) {
            return Optional.empty();
        }
        MutableObject mutable = new MutableObject(null);
        class_2338.method_49925((class_2338)this.field_11867, (int)2, (int)64, (pos, consumer) -> {
            for (class_2350 direction : class_156.method_43253((Object[])class_2350.values(), (class_5819)this.field_11863.method_8409())) {
                class_2338 neighbor = pos.method_10093(direction);
                if (!this.field_11863.method_8320(neighbor).method_26164(ModBlockTags.CREAKING_HEART_HOLDERS)) continue;
                consumer.accept(neighbor);
            }
        }, arg_0 -> this.lambda$spreadResin$4((Mutable)mutable, arg_0));
        return Optional.ofNullable((class_2338)mutable.getValue());
    }

    private void emitParticles(class_3218 level, int count, boolean reverseDirection) {
        Creaking creaking = this.getCreakingProtector().orElse(null);
        if (creaking != null) {
            int color = reverseDirection ? VanillaBackport.COMMON_CONFIG.creakingParticleReverseColor.get() : VanillaBackport.COMMON_CONFIG.creakingParticleColor.get();
            class_5819 random = level.method_8409();
            for (double i = 0.0; i < (double)count; i += 1.0) {
                class_238 creakingBounds = creaking.method_5829();
                class_243 currentPos = new class_243(creakingBounds.field_1323, creakingBounds.field_1322, creakingBounds.field_1321).method_1031(random.method_43058() * creakingBounds.method_17939(), random.method_43058() * creakingBounds.method_17940(), random.method_43058() * creakingBounds.method_17941());
                class_243 heartPos = class_243.method_24954((class_2382)this.method_11016()).method_1031(random.method_43058(), random.method_43058(), random.method_43058());
                if (reverseDirection) {
                    class_243 target = currentPos;
                    currentPos = heartPos;
                    heartPos = target;
                }
                TrailParticleOption particle = new TrailParticleOption(heartPos, color, random.method_43048(40) + 10);
                ModParticles.sendParticles(level, particle, true, true, currentPos.field_1352, currentPos.field_1351, currentPos.field_1350, 1, 0.0, 0.0, 0.0, 0.0);
            }
        }
    }

    public void removeProtector(@Nullable class_1282 source) {
        Creaking creaking = this.getCreakingProtector().orElse(null);
        if (creaking != null) {
            if (source == null) {
                creaking.tearDown();
            } else {
                creaking.creakingDeathEffects(source);
                creaking.setTearingDown();
                creaking.method_6033(0.0f);
            }
            this.clearCreakingInfo();
        }
    }

    public boolean isProtector(Creaking creaking) {
        return this.getCreakingProtector().map(target -> target == creaking).orElse(false);
    }

    public int getAnalogOutputSignal() {
        return this.outputSignal;
    }

    public int computeAnalogOutputSignal() {
        if (this.creakingInfo != null && this.getCreakingProtector().isPresent()) {
            double distance = this.distanceToCreaking();
            double signalFromDistance = class_3532.method_15350((double)distance, (double)0.0, (double)32.0) / 32.0;
            return 15 - (int)Math.floor(signalFromDistance * 15.0);
        }
        return 0;
    }

    public void method_11014(class_2487 tag, class_7225.class_7874 provider) {
        super.method_11014(tag, provider);
        if (tag.method_25928("creaking")) {
            this.setCreakingInfo(tag.method_25926("creaking"));
        } else {
            this.clearCreakingInfo();
        }
    }

    protected void method_11007(class_2487 tag, class_7225.class_7874 provider) {
        super.method_11007(tag, provider);
        if (this.creakingInfo != null) {
            tag.method_25927("creaking", (UUID)this.creakingInfo.map(class_1297::method_5667, uuid -> uuid));
        }
    }

    private /* synthetic */ boolean lambda$spreadResin$4(Mutable mutable, class_2338 pos) {
        if (this.field_11863.method_8320(pos).method_26164(ModBlockTags.CREAKING_HEART_HOLDERS)) {
            for (class_2350 direction : class_156.method_43253((Object[])class_2350.values(), (class_5819)this.field_11863.method_8409())) {
                class_2338 neighbor = pos.method_10093(direction);
                class_2680 neighborState = this.field_11863.method_8320(neighbor);
                class_2350 opposite = direction.method_10153();
                class_2248 resinClump = ModBlocks.RESIN_CLUMP.get();
                if (neighborState.method_26215()) {
                    neighborState = resinClump.method_9564();
                } else if (neighborState.method_27852(class_2246.field_10382) && neighborState.method_26227().method_15771()) {
                    neighborState = (class_2680)resinClump.method_9564().method_11657((class_2769)class_2741.field_12508, (Comparable)Boolean.valueOf(true));
                }
                if (!neighborState.method_27852(resinClump) || class_5778.method_33366((class_2680)neighborState, (class_2350)opposite)) continue;
                this.field_11863.method_8652(neighbor, (class_2680)neighborState.method_11657((class_2769)class_5778.method_33374((class_2350)opposite), (Comparable)Boolean.valueOf(true)), 3);
                mutable.setValue((Object)neighbor);
                return false;
            }
        }
        return true;
    }
}

