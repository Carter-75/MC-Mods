/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1268
 *  net.minecraft.class_1269
 *  net.minecraft.class_1282
 *  net.minecraft.class_1297
 *  net.minecraft.class_1299
 *  net.minecraft.class_1308
 *  net.minecraft.class_1309
 *  net.minecraft.class_1352
 *  net.minecraft.class_1359
 *  net.minecraft.class_1427
 *  net.minecraft.class_1439$class_4621
 *  net.minecraft.class_1548
 *  net.minecraft.class_1657
 *  net.minecraft.class_1778
 *  net.minecraft.class_1786
 *  net.minecraft.class_1792
 *  net.minecraft.class_1799
 *  net.minecraft.class_1802
 *  net.minecraft.class_1936
 *  net.minecraft.class_1937
 *  net.minecraft.class_1972
 *  net.minecraft.class_2246
 *  net.minecraft.class_2338
 *  net.minecraft.class_238
 *  net.minecraft.class_2394
 *  net.minecraft.class_2398
 *  net.minecraft.class_2487
 *  net.minecraft.class_2940
 *  net.minecraft.class_2941
 *  net.minecraft.class_2943
 *  net.minecraft.class_2945
 *  net.minecraft.class_3218
 *  net.minecraft.class_3414
 *  net.minecraft.class_3417
 *  net.minecraft.class_3730
 *  net.minecraft.class_5132$class_5133
 *  net.minecraft.class_5134
 *  net.minecraft.class_5819
 *  net.minecraft.class_7
 *  net.minecraft.class_8103
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 *  software.bernie.geckolib.core.animatable.GeoAnimatable
 *  software.bernie.geckolib.core.animation.AnimatableManager$ControllerRegistrar
 *  software.bernie.geckolib.core.animation.AnimationController
 *  software.bernie.geckolib.core.object.PlayState
 */
package tech.alexnijjar.golemoverhaul.common.entities.golems;

import java.util.UUID;
import net.minecraft.class_1268;
import net.minecraft.class_1269;
import net.minecraft.class_1282;
import net.minecraft.class_1297;
import net.minecraft.class_1299;
import net.minecraft.class_1308;
import net.minecraft.class_1309;
import net.minecraft.class_1352;
import net.minecraft.class_1359;
import net.minecraft.class_1427;
import net.minecraft.class_1439;
import net.minecraft.class_1548;
import net.minecraft.class_1657;
import net.minecraft.class_1778;
import net.minecraft.class_1786;
import net.minecraft.class_1792;
import net.minecraft.class_1799;
import net.minecraft.class_1802;
import net.minecraft.class_1936;
import net.minecraft.class_1937;
import net.minecraft.class_1972;
import net.minecraft.class_2246;
import net.minecraft.class_2338;
import net.minecraft.class_238;
import net.minecraft.class_2394;
import net.minecraft.class_2398;
import net.minecraft.class_2487;
import net.minecraft.class_2940;
import net.minecraft.class_2941;
import net.minecraft.class_2943;
import net.minecraft.class_2945;
import net.minecraft.class_3218;
import net.minecraft.class_3414;
import net.minecraft.class_3417;
import net.minecraft.class_3730;
import net.minecraft.class_5132;
import net.minecraft.class_5134;
import net.minecraft.class_5819;
import net.minecraft.class_7;
import net.minecraft.class_8103;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.core.animatable.GeoAnimatable;
import software.bernie.geckolib.core.animation.AnimatableManager;
import software.bernie.geckolib.core.animation.AnimationController;
import software.bernie.geckolib.core.object.PlayState;
import tech.alexnijjar.golemoverhaul.common.config.GolemOverhaulConfig;
import tech.alexnijjar.golemoverhaul.common.constants.ConstantAnimations;
import tech.alexnijjar.golemoverhaul.common.entities.golems.base.BaseGolem;
import tech.alexnijjar.golemoverhaul.common.registry.ModSoundEvents;
import tech.alexnijjar.golemoverhaul.common.utils.ModUtils;

public class CoalGolem
extends BaseGolem {
    public static final int DEATH_TICKS = 13;
    public static final int MAX_SUMMON_TICKS = 2400;
    private static final class_2940<Boolean> ID_LIT = class_2945.method_12791(CoalGolem.class, (class_2941)class_2943.field_13323);
    private boolean summoned;
    @Nullable
    private UUID summonerId;

    public CoalGolem(class_1299<? extends class_1427> type, class_1937 level) {
        super(type, level);
        this.field_6194 = 1;
        this.method_5941(class_7.field_14, 0.0f);
        this.method_5941(class_7.field_9, 0.0f);
        this.method_5941(class_7.field_3, 0.0f);
    }

    public static class_5132.class_5133 createAttributes() {
        return class_1308.method_26828().method_26868(class_5134.field_23716, 10.0).method_26868(class_5134.field_23719, 0.35).method_26868(class_5134.field_23721, 2.0);
    }

    public static boolean checkMobSpawnRules(class_1299<? extends class_1308> type, class_1936 level, class_3730 spawnType, class_2338 pos, class_5819 random) {
        if (!GolemOverhaulConfig.spawnCoalGolems || !GolemOverhaulConfig.allowSpawning) {
            return false;
        }
        if (level.method_23753(pos).method_40225(class_1972.field_37543)) {
            return false;
        }
        return pos.method_10264() < level.method_8615() && !level.method_8320(pos.method_10074()).method_27852(class_2246.field_10219) && class_1308.method_20636(type, (class_1936)level, (class_3730)spawnType, (class_2338)pos, (class_5819)random);
    }

    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllers) {
        super.registerControllers(controllers);
        controllers.add(new AnimationController[]{new AnimationController((GeoAnimatable)this, "death_controller", 5, state -> {
            if (this.field_6213 == 0) {
                return PlayState.STOP;
            }
            return state.setAndContinue(ConstantAnimations.DIE);
        })});
    }

    protected void method_5693() {
        super.method_5693();
        this.field_6011.method_12784(ID_LIT, (Object)false);
    }

    public void method_5652(class_2487 compound) {
        super.method_5652(compound);
        compound.method_10556("Lit", this.isLit());
        if (this.summonerId != null) {
            compound.method_25927("SummonerId", this.summonerId);
        }
    }

    @Override
    public void method_5749(class_2487 compound) {
        super.method_5749(compound);
        this.setLit(compound.method_10577("Lit"));
        if (compound.method_25928("SummonerId")) {
            this.setSummoner(compound.method_25926("SummonerId"));
        }
    }

    @Override
    protected void method_5959() {
        super.method_5959();
        this.field_6201.method_6277(0, (class_1352)new class_1359((class_1308)this, 0.5f));
    }

    @Override
    public boolean canTarget() {
        return this.isLit() || this.isSummoned();
    }

    public boolean isLit() {
        return (Boolean)this.field_6011.method_12789(ID_LIT);
    }

    public void setLit(boolean lit) {
        this.field_6011.method_12778(ID_LIT, (Object)lit);
        this.method_5996(class_5134.field_23721).method_6192(lit ? 12.0 : 2.0);
        this.updateAttackGoals();
    }

    public boolean isSummoned() {
        return this.summoned;
    }

    public void setSummoner(@Nullable UUID summoner) {
        this.summoned = summoner != null;
        this.summonerId = summoner;
    }

    protected void method_16080(class_1282 damageSource) {
        if (this.isSummoned()) {
            return;
        }
        super.method_16080(damageSource);
    }

    protected void method_6108() {
        ++this.field_6213;
        if (this.isLit() || this.field_6213 >= 13 && !this.method_37908().method_8608() && !this.method_31481()) {
            this.removeAndAddDeathParticles();
        }
    }

    protected class_3414 method_5994() {
        return this.isLit() ? (class_3414)ModSoundEvents.COAL_GOLEM_AMBIENT.get() : super.method_5994();
    }

    @Override
    protected class_3414 method_6011(class_1282 damageSource) {
        return this.isLit() ? (class_3414)ModSoundEvents.COAL_GOLEM_HURT.get() : super.method_6011(damageSource);
    }

    @Override
    protected class_3414 method_6002() {
        return this.isLit() ? (class_3414)ModSoundEvents.COAL_GOLEM_DEATH.get() : super.method_6002();
    }

    @Override
    public class_1439.class_4621 getCrackiness() {
        return class_1439.class_4621.field_21081;
    }

    @Override
    public boolean shouldAttack(class_1309 entity) {
        if (entity instanceof class_1548) {
            return this.isLit();
        }
        return super.shouldAttack(entity);
    }

    public void method_5730() {
        super.method_5730();
        this.setLit(true);
    }

    public boolean method_5643(class_1282 source, float amount) {
        if (source.method_48789(class_8103.field_42246)) {
            this.setLit(true);
        }
        return super.method_5643(source, amount);
    }

    public boolean method_5974(double distanceToClosestPlayer) {
        return true;
    }

    @Override
    public int getAttackTicks() {
        return 10;
    }

    @Override
    public class_1792 getRepairItem() {
        return class_1802.field_8713;
    }

    @Override
    public float getRepairItemHealAmount() {
        return this.method_6063();
    }

    public void method_46395() {
        super.method_46395();
        if (this.isLit()) {
            this.setLit(false);
            this.method_43077(class_3417.field_15222);
            for (int i = 0; i < 20; ++i) {
                this.method_37908().method_8406((class_2394)class_2398.field_11237, this.method_23317() + this.field_5974.method_43059() * 0.3, this.method_23318() + 0.5 + this.field_5974.method_43059() * 0.3, this.method_23321() + this.field_5974.method_43059() * 0.3, 0.0, 0.0, 0.0);
            }
        }
    }

    @Override
    public boolean method_6121(@NotNull class_1297 target) {
        if (super.method_6121(target)) {
            if (this.isLit() && !this.method_37908().method_8608()) {
                target.method_5639(5);
                this.method_5768();
                this.field_6213 = 10;
                this.method_43077((class_3414)ModSoundEvents.COAL_GOLEM_EXPLODE.get());
                for (int i = 0; i < 10; ++i) {
                    ModUtils.sendParticles((class_3218)this.method_37908(), class_2398.field_11240, this.method_23317() + this.field_5974.method_43059() * 0.3, this.method_23318() + 0.5 + this.field_5974.method_43059() * 0.3, this.method_23321() + this.field_5974.method_43059() * 0.3, 1, 0.0, 0.0, 0.0, 0.0);
                }
            }
            return true;
        }
        return false;
    }

    public void method_5773() {
        class_1937 class_19372 = this.method_37908();
        if (class_19372 instanceof class_3218) {
            class_1297 summoner;
            class_3218 level = (class_3218)class_19372;
            if (this.field_6012 > 2400 && this.isSummoned()) {
                this.method_5768();
                this.method_43077((class_3414)ModSoundEvents.COAL_GOLEM_EXPLODE.get());
            }
            if (this.summonerId != null && (summoner = level.method_14190(this.summonerId)) instanceof class_1308) {
                class_1308 mob = (class_1308)summoner;
                this.method_5980(mob.method_5968());
            }
        }
        super.method_5773();
    }

    @Override
    @NotNull
    protected class_1269 method_5992(class_1657 player, @NotNull class_1268 hand) {
        if (super.method_5992(player, hand).method_23665()) {
            return class_1269.field_5812;
        }
        if (this.method_37908().method_8608()) {
            return class_1269.field_5812;
        }
        class_1799 stack = player.method_5998(hand);
        if (this.isLit()) {
            if (stack.method_7960()) {
                this.method_46395();
                return class_1269.field_5812;
            }
        } else {
            if (stack.method_7909() instanceof class_1786) {
                stack.method_7956(1, (class_1309)player, p -> p.method_20236(hand));
                this.method_43077(class_3417.field_15145);
                this.setLit(true);
                return class_1269.field_5812;
            }
            if (stack.method_7909() instanceof class_1778) {
                stack.method_7934(1);
                this.method_43077(class_3417.field_15013);
                this.setLit(true);
                return class_1269.field_5812;
            }
        }
        return class_1269.field_5811;
    }

    @Override
    protected class_238 getAttackBoundingBox() {
        return super.getAttackBoundingBox().method_1009(1.0, 0.0, 1.0);
    }
}

