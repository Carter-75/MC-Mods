/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1263
 *  net.minecraft.class_1293
 *  net.minecraft.class_1294
 *  net.minecraft.class_1297
 *  net.minecraft.class_1299
 *  net.minecraft.class_1308
 *  net.minecraft.class_1309
 *  net.minecraft.class_1313
 *  net.minecraft.class_1314
 *  net.minecraft.class_1335
 *  net.minecraft.class_1335$class_1336
 *  net.minecraft.class_1352
 *  net.minecraft.class_1361
 *  net.minecraft.class_1376
 *  net.minecraft.class_1378
 *  net.minecraft.class_1379
 *  net.minecraft.class_1400
 *  net.minecraft.class_1409
 *  net.minecraft.class_1412
 *  net.minecraft.class_1427
 *  net.minecraft.class_1657
 *  net.minecraft.class_1792
 *  net.minecraft.class_1802
 *  net.minecraft.class_1937
 *  net.minecraft.class_2246
 *  net.minecraft.class_2338
 *  net.minecraft.class_238
 *  net.minecraft.class_243
 *  net.minecraft.class_2487
 *  net.minecraft.class_2680
 *  net.minecraft.class_2700$class_2702
 *  net.minecraft.class_2940
 *  net.minecraft.class_2941
 *  net.minecraft.class_2943
 *  net.minecraft.class_2945
 *  net.minecraft.class_3414
 *  net.minecraft.class_3532
 *  net.minecraft.class_3956
 *  net.minecraft.class_4538
 *  net.minecraft.class_5132$class_5133
 *  net.minecraft.class_5134
 *  net.minecraft.class_7
 *  org.jetbrains.annotations.NotNull
 *  software.bernie.geckolib.core.animatable.GeoAnimatable
 *  software.bernie.geckolib.core.animation.AnimatableManager$ControllerRegistrar
 *  software.bernie.geckolib.core.animation.AnimationController
 *  software.bernie.geckolib.core.animation.AnimationState
 *  software.bernie.geckolib.core.object.PlayState
 */
package tech.alexnijjar.golemoverhaul.common.entities.golems;

import net.minecraft.class_1263;
import net.minecraft.class_1293;
import net.minecraft.class_1294;
import net.minecraft.class_1297;
import net.minecraft.class_1299;
import net.minecraft.class_1308;
import net.minecraft.class_1309;
import net.minecraft.class_1313;
import net.minecraft.class_1314;
import net.minecraft.class_1335;
import net.minecraft.class_1352;
import net.minecraft.class_1361;
import net.minecraft.class_1376;
import net.minecraft.class_1378;
import net.minecraft.class_1379;
import net.minecraft.class_1400;
import net.minecraft.class_1409;
import net.minecraft.class_1412;
import net.minecraft.class_1427;
import net.minecraft.class_1657;
import net.minecraft.class_1792;
import net.minecraft.class_1802;
import net.minecraft.class_1937;
import net.minecraft.class_2246;
import net.minecraft.class_2338;
import net.minecraft.class_238;
import net.minecraft.class_243;
import net.minecraft.class_2487;
import net.minecraft.class_2680;
import net.minecraft.class_2700;
import net.minecraft.class_2940;
import net.minecraft.class_2941;
import net.minecraft.class_2943;
import net.minecraft.class_2945;
import net.minecraft.class_3414;
import net.minecraft.class_3532;
import net.minecraft.class_3956;
import net.minecraft.class_4538;
import net.minecraft.class_5132;
import net.minecraft.class_5134;
import net.minecraft.class_7;
import org.jetbrains.annotations.NotNull;
import software.bernie.geckolib.core.animatable.GeoAnimatable;
import software.bernie.geckolib.core.animation.AnimatableManager;
import software.bernie.geckolib.core.animation.AnimationController;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.core.object.PlayState;
import tech.alexnijjar.golemoverhaul.common.constants.ConstantAnimations;
import tech.alexnijjar.golemoverhaul.common.entities.golems.base.BaseGolem;
import tech.alexnijjar.golemoverhaul.common.recipes.GolemConstructionRecipe;
import tech.alexnijjar.golemoverhaul.common.recipes.SingleEntityInput;
import tech.alexnijjar.golemoverhaul.common.registry.ModEntityTypes;
import tech.alexnijjar.golemoverhaul.common.registry.ModRecipeTypes;
import tech.alexnijjar.golemoverhaul.common.registry.ModSoundEvents;
import tech.alexnijjar.golemoverhaul.common.utils.ModUtils;

public class KelpGolem
extends BaseGolem {
    protected final class_1412 waterNavigation;
    protected final class_1409 groundNavigation;
    private static final class_2940<Boolean> ID_CHARGED = class_2945.method_12791(KelpGolem.class, (class_2941)class_2943.field_13323);

    public KelpGolem(class_1299<? extends class_1427> type, class_1937 level) {
        super(type, level);
        this.field_6194 = 14;
        this.method_5941(class_7.field_18, 0.0f);
        this.field_6207 = new KelpGolemMoveControl();
        this.waterNavigation = new class_1412((class_1308)this, level);
        this.groundNavigation = new class_1409((class_1308)this, level);
    }

    public static class_5132.class_5133 createAttributes() {
        return class_1308.method_26828().method_26868(class_5134.field_23716, 30.0).method_26868(class_5134.field_23719, 0.085).method_26868(class_5134.field_23721, 8.0);
    }

    public static void trySpawnGolem(class_1937 level, class_2338 pos) {
        GolemConstructionRecipe recipe = (GolemConstructionRecipe)level.method_8433().method_8132((class_3956)ModRecipeTypes.GOLEM_CONSTRUCTION.get(), (class_1263)new SingleEntityInput((class_1299)ModEntityTypes.KELP_GOLEM.get()), level).orElseThrow();
        class_2700.class_2702 pattern = recipe.createPattern().method_11708((class_4538)level, pos);
        if (pattern == null) {
            return;
        }
        KelpGolem golem = (KelpGolem)((class_1299)ModEntityTypes.KELP_GOLEM.get()).method_5883(level);
        if (golem == null) {
            return;
        }
        ModUtils.spawnGolemInWorld(level, pattern, (class_1297)golem, pattern.method_11717(1, 2, 0).method_11683());
    }

    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllers) {
        controllers.add(new AnimationController[]{this.getMovementController()});
        controllers.add(new AnimationController[]{new AnimationController((GeoAnimatable)this, "attack_controller", 0, state -> {
            if (!this.hasAttackAnimation()) {
                return PlayState.STOP;
            }
            if (this.attackAnimationTicks == 0) {
                state.resetCurrentAnimation();
                return PlayState.STOP;
            }
            return this.getAttackAnimation((AnimationState<? extends BaseGolem>)state);
        })});
        controllers.add(new AnimationController[]{new AnimationController((GeoAnimatable)this, "spin_controller", 0, state -> {
            if (!this.isCharged()) {
                state.resetCurrentAnimation();
                return PlayState.STOP;
            }
            return state.setAndContinue(ConstantAnimations.SPIN);
        })});
    }

    @Override
    public AnimationController<?> getMovementController() {
        return super.getMovementController().setSoundKeyframeHandler(event -> this.method_37908().method_45446(this.method_24515(), (class_3414)ModSoundEvents.KELP_GOLEM_STEP.get(), this.method_5634(), 1.0f, 1.0f, false));
    }

    @Override
    public PlayState handleMovementController(AnimationState<BaseGolem> state) {
        boolean moving;
        boolean bl = moving = (double)state.getLimbSwingAmount() > 0.05 || (double)state.getLimbSwingAmount() < -0.05;
        if (this.method_5799()) {
            state.getController().setAnimation(ConstantAnimations.SWIM);
            return PlayState.CONTINUE;
        }
        state.getController().setAnimation(moving ? ConstantAnimations.WALK : (this.method_5799() ? ConstantAnimations.IDLE_WATER : ConstantAnimations.IDLE));
        return PlayState.CONTINUE;
    }

    protected void method_5693() {
        super.method_5693();
        this.field_6011.method_12784(ID_CHARGED, (Object)false);
    }

    public void method_5652(class_2487 compound) {
        super.method_5652(compound);
        compound.method_10556("Charged", this.isCharged());
    }

    @Override
    public void method_5749(class_2487 compound) {
        super.method_5749(compound);
        this.setCharged(compound.method_10577("Charged"));
    }

    @Override
    protected void method_5959() {
        this.field_6201.method_6277(0, (class_1352)new class_1400((class_1308)this, class_1308.class, 3, true, false, this::shouldAttack));
        this.field_6201.method_6277(2, (class_1352)new class_1378((class_1314)this, 1.0, 40));
        this.field_6201.method_6277(4, (class_1352)new class_1379((class_1314)this, 0.6));
        this.field_6201.method_6277(7, (class_1352)new class_1361((class_1308)this, class_1657.class, 6.0f));
        this.field_6201.method_6277(8, (class_1352)new class_1376((class_1308)this));
    }

    public boolean isCharged() {
        return (Boolean)this.field_6011.method_12789(ID_CHARGED);
    }

    public void setCharged(boolean charged) {
        this.field_6011.method_12778(ID_CHARGED, (Object)charged);
    }

    @Override
    protected class_3414 method_6002() {
        return (class_3414)ModSoundEvents.KELP_GOLEM_DEATH.get();
    }

    protected void method_5712(class_2338 pos, class_2680 state) {
    }

    @Override
    public boolean canFloatInWater() {
        return false;
    }

    @Override
    public class_1792 getRepairItem() {
        return class_1802.field_17532;
    }

    @Override
    public float getRepairItemHealAmount() {
        return 5.0f;
    }

    @Override
    public class_3414 getRepairSound() {
        return (class_3414)ModSoundEvents.KELP_GOLEM_STEP.get();
    }

    @Override
    public int getAttackTicks() {
        return 18;
    }

    @Override
    public int getAttackDelayTicks() {
        return 6;
    }

    public boolean method_5675() {
        return !this.method_5681();
    }

    public void method_5670() {
        int airSupply = this.method_5669();
        super.method_5670();
        this.handleAirSupply(airSupply);
    }

    public void method_5773() {
        super.method_5773();
        if (!this.method_37908().method_8608() && this.field_6012 % 60 == 0) {
            if (this.inConduitRange()) {
                this.setCharged(true);
                this.method_6092(new class_1293(class_1294.field_5910, 100, 1, true, true));
                this.method_6092(new class_1293(class_1294.field_5924, 100, 0, true, true));
                this.method_6092(new class_1293(class_1294.field_5907, 100, 1, true, true));
            } else {
                this.setCharged(false);
            }
        }
    }

    private boolean inConduitRange() {
        return this.method_6059(class_1294.field_5927);
    }

    public boolean method_5957(class_4538 level) {
        return level.method_8606((class_1297)this);
    }

    public void method_6091(@NotNull class_243 travelVector) {
        if (this.method_5787() && this.method_5799()) {
            this.method_5724(0.01f, travelVector);
            this.method_5784(class_1313.field_6308, this.method_18798());
            this.method_18799(this.method_18798().method_1021(0.9));
        } else {
            super.method_6091(travelVector);
        }
    }

    public void method_5790() {
        if (!this.method_37908().method_8608()) {
            if (this.method_6034() && this.method_37908().method_8320(this.method_24515().method_10086(2)).method_27852(class_2246.field_10382)) {
                this.field_6189 = this.waterNavigation;
                this.method_5796(true);
            } else {
                this.field_6189 = this.groundNavigation;
                this.method_5796(false);
            }
        }
        super.method_5790();
    }

    protected void handleAirSupply(int airSupply) {
        if (this.method_5805() && !this.method_5816()) {
            this.method_5855(airSupply - 1);
            if (this.method_5669() == -20) {
                this.method_5855(0);
                this.method_5643(this.method_48923().method_48824(), 2.0f);
            }
        } else {
            this.method_5855(300);
        }
    }

    @Override
    protected class_238 getAttackBoundingBox() {
        return super.getAttackBoundingBox().method_1009(2.0, 0.0, 2.0);
    }

    private class KelpGolemMoveControl
    extends class_1335 {
        KelpGolemMoveControl() {
            super((class_1308)KelpGolem.this);
        }

        public void method_6240() {
            if (!KelpGolem.this.method_5799()) {
                super.method_6240();
                return;
            }
            class_1309 livingEntity = KelpGolem.this.method_5968();
            if (livingEntity != null && livingEntity.method_23318() > KelpGolem.this.method_23318()) {
                KelpGolem.this.method_18799(KelpGolem.this.method_18798().method_1031(0.0, 0.002, 0.0));
            }
            if (this.field_6374 != class_1335.class_1336.field_6378 || KelpGolem.this.method_5942().method_6357()) {
                KelpGolem.this.method_6125(0.0f);
                return;
            }
            double x = this.field_6370 - KelpGolem.this.method_23317();
            double y = this.field_6369 - KelpGolem.this.method_23318();
            double z = this.field_6367 - KelpGolem.this.method_23321();
            double distance = Math.sqrt(x * x + y * y + z * z);
            y /= distance;
            float h = (float)(class_3532.method_15349((double)z, (double)x) * 57.3) - 90.0f;
            KelpGolem.this.method_36456(this.method_6238(KelpGolem.this.method_36454(), h, 90.0f));
            KelpGolem.this.field_6283 = KelpGolem.this.method_36454();
            float speed = (float)(this.field_6372 * KelpGolem.this.method_26825(class_5134.field_23719));
            speed = class_3532.method_16439((float)0.125f, (float)KelpGolem.this.method_6029(), (float)speed);
            KelpGolem.this.method_6125(speed);
            KelpGolem.this.method_18799(KelpGolem.this.method_18798().method_1031((double)(speed *= 20.0f) * x * 0.005, (double)speed * y * 0.025, (double)speed * z * 0.005));
        }
    }
}

