/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1263
 *  net.minecraft.class_1268
 *  net.minecraft.class_1269
 *  net.minecraft.class_1282
 *  net.minecraft.class_1293
 *  net.minecraft.class_1297
 *  net.minecraft.class_1297$class_4738
 *  net.minecraft.class_1299
 *  net.minecraft.class_1308
 *  net.minecraft.class_1309
 *  net.minecraft.class_1316
 *  net.minecraft.class_1427
 *  net.minecraft.class_1657
 *  net.minecraft.class_1792
 *  net.minecraft.class_1799
 *  net.minecraft.class_1802
 *  net.minecraft.class_1937
 *  net.minecraft.class_2338
 *  net.minecraft.class_238
 *  net.minecraft.class_2394
 *  net.minecraft.class_2398
 *  net.minecraft.class_241
 *  net.minecraft.class_243
 *  net.minecraft.class_2487
 *  net.minecraft.class_2680
 *  net.minecraft.class_2700$class_2702
 *  net.minecraft.class_2940
 *  net.minecraft.class_2941
 *  net.minecraft.class_2943
 *  net.minecraft.class_2945
 *  net.minecraft.class_3218
 *  net.minecraft.class_3414
 *  net.minecraft.class_3417
 *  net.minecraft.class_3956
 *  net.minecraft.class_4538
 *  net.minecraft.class_5132$class_5133
 *  net.minecraft.class_5134
 *  net.minecraft.class_6025
 *  net.minecraft.class_7
 *  net.minecraft.class_8103
 *  net.minecraft.class_8111
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 *  software.bernie.geckolib.core.animatable.GeoAnimatable
 *  software.bernie.geckolib.core.animation.AnimatableManager$ControllerRegistrar
 *  software.bernie.geckolib.core.animation.AnimationController
 *  software.bernie.geckolib.core.animation.AnimationState
 *  software.bernie.geckolib.core.object.PlayState
 */
package tech.alexnijjar.golemoverhaul.common.entities.golems;

import java.util.List;
import net.minecraft.class_1263;
import net.minecraft.class_1268;
import net.minecraft.class_1269;
import net.minecraft.class_1282;
import net.minecraft.class_1293;
import net.minecraft.class_1297;
import net.minecraft.class_1299;
import net.minecraft.class_1308;
import net.minecraft.class_1309;
import net.minecraft.class_1316;
import net.minecraft.class_1427;
import net.minecraft.class_1657;
import net.minecraft.class_1792;
import net.minecraft.class_1799;
import net.minecraft.class_1802;
import net.minecraft.class_1937;
import net.minecraft.class_2338;
import net.minecraft.class_238;
import net.minecraft.class_2394;
import net.minecraft.class_2398;
import net.minecraft.class_241;
import net.minecraft.class_243;
import net.minecraft.class_2487;
import net.minecraft.class_2680;
import net.minecraft.class_2700;
import net.minecraft.class_2940;
import net.minecraft.class_2941;
import net.minecraft.class_2943;
import net.minecraft.class_2945;
import net.minecraft.class_3218;
import net.minecraft.class_3414;
import net.minecraft.class_3417;
import net.minecraft.class_3956;
import net.minecraft.class_4538;
import net.minecraft.class_5132;
import net.minecraft.class_5134;
import net.minecraft.class_6025;
import net.minecraft.class_7;
import net.minecraft.class_8103;
import net.minecraft.class_8111;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.core.animatable.GeoAnimatable;
import software.bernie.geckolib.core.animation.AnimatableManager;
import software.bernie.geckolib.core.animation.AnimationController;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.core.object.PlayState;
import tech.alexnijjar.golemoverhaul.common.constants.ConstantAnimations;
import tech.alexnijjar.golemoverhaul.common.entities.IShearable;
import tech.alexnijjar.golemoverhaul.common.entities.golems.CoalGolem;
import tech.alexnijjar.golemoverhaul.common.entities.golems.base.BaseGolem;
import tech.alexnijjar.golemoverhaul.common.recipes.GolemConstructionRecipe;
import tech.alexnijjar.golemoverhaul.common.recipes.SingleEntityInput;
import tech.alexnijjar.golemoverhaul.common.registry.ModEntityTypes;
import tech.alexnijjar.golemoverhaul.common.registry.ModRecipeTypes;
import tech.alexnijjar.golemoverhaul.common.registry.ModSoundEvents;
import tech.alexnijjar.golemoverhaul.common.utils.ModUtils;

public class NetheriteGolem
extends BaseGolem
implements IShearable,
class_1316 {
    public static final byte SUMMON_EVENT_ID = 8;
    public static final int SUMMON_TICKS_LENGTH = 60;
    public static final int DEATH_TICKS = 50;
    public static final int SUMMONING_COOLDOWN_TICKS_LENGTH = 1200;
    private static final class_2940<Boolean> ID_CHARGED = class_2945.method_12791(NetheriteGolem.class, (class_2941)class_2943.field_13323);
    private static final class_2940<Boolean> ID_GILDED = class_2945.method_12791(NetheriteGolem.class, (class_2941)class_2943.field_13323);
    private int summoningTicks;
    private int summonCooldown;
    private int lastJumpPower;

    public NetheriteGolem(class_1299<? extends class_1427> type, class_1937 level) {
        super(type, level);
        this.field_6194 = 24;
        this.method_5941(class_7.field_18, -1.0f);
        this.method_49477(this.method_49476() + 0.5f);
    }

    public static class_5132.class_5133 createAttributes() {
        return class_1308.method_26828().method_26868(class_5134.field_23716, 320.0).method_26868(class_5134.field_23724, 20.0).method_26868(class_5134.field_23725, 8.0).method_26868(class_5134.field_23719, 0.14).method_26868(class_5134.field_23722, 2.0).method_26868(class_5134.field_23718, 1.0).method_26868(class_5134.field_23721, 20.0);
    }

    public static void trySpawnGolem(class_1937 level, class_2338 pos) {
        GolemConstructionRecipe recipe = (GolemConstructionRecipe)level.method_8433().method_8132((class_3956)ModRecipeTypes.GOLEM_CONSTRUCTION.get(), (class_1263)new SingleEntityInput((class_1299)ModEntityTypes.NETHERITE_GOLEM.get()), level).orElseThrow();
        class_2700.class_2702 pattern = recipe.createPattern().method_11708((class_4538)level, pos);
        if (pattern == null) {
            return;
        }
        NetheriteGolem golem = (NetheriteGolem)((class_1299)ModEntityTypes.NETHERITE_GOLEM.get()).method_5883(level);
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
        }).setSoundKeyframeHandler(event -> this.method_37908().method_45446(this.method_24515(), (class_3414)ModSoundEvents.NETHERITE_GOLEM_HIT.get(), this.method_5634(), 1.0f, 1.0f, false))});
        controllers.add(new AnimationController[]{new AnimationController((GeoAnimatable)this, "death_controller", 0, state -> {
            if (this.field_6213 == 0) {
                return PlayState.STOP;
            }
            return state.setAndContinue(ConstantAnimations.DIE);
        }).setSoundKeyframeHandler(event -> this.method_37908().method_45446(this.method_24515(), (class_3414)ModSoundEvents.NETHERITE_GOLEM_DEATH.get(), this.method_5634(), 1.0f, 1.0f, false))});
        controllers.add(new AnimationController[]{new AnimationController((GeoAnimatable)this, "summon_controller", 0, state -> {
            if (this.getSummoningTicks() == 0) {
                state.resetCurrentAnimation();
                return PlayState.STOP;
            }
            return state.setAndContinue(ConstantAnimations.SUMMON);
        }).setSoundKeyframeHandler(event -> this.method_37908().method_45446(this.method_24515(), (class_3414)ModSoundEvents.NETHERITE_GOLEM_SUMMON.get(), this.method_5634(), 1.0f, 1.0f, false))});
    }

    @Override
    public AnimationController<?> getMovementController() {
        return super.getMovementController().setSoundKeyframeHandler(event -> this.method_37908().method_45446(this.method_24515(), (class_3414)ModSoundEvents.NETHERITE_GOLEM_STEP.get(), this.method_5634(), 1.0f, 1.0f, false));
    }

    protected void method_5693() {
        super.method_5693();
        this.field_6011.method_12784(ID_CHARGED, (Object)false);
        this.field_6011.method_12784(ID_GILDED, (Object)false);
    }

    public void method_5652(class_2487 compound) {
        super.method_5652(compound);
        compound.method_10556("charged", this.isCharged());
        compound.method_10556("gilded", this.isGilded());
        compound.method_10569("summoning_ticks", this.getSummoningTicks());
        compound.method_10569("summon_cooldown", this.getSummonCooldown());
    }

    @Override
    public void method_5749(class_2487 compound) {
        super.method_5749(compound);
        this.setCharged(compound.method_10577("charged"));
        this.setGilded(compound.method_10577("gilded"));
        this.setSummoningTicks(compound.method_10550("summoning_ticks"));
        this.setSummonCooldown(compound.method_10550("summon_cooldown"));
    }

    public boolean isCharged() {
        return (Boolean)this.field_6011.method_12789(ID_CHARGED);
    }

    public void setCharged(boolean charged) {
        this.field_6011.method_12778(ID_CHARGED, (Object)charged);
    }

    public boolean isGilded() {
        return (Boolean)this.field_6011.method_12789(ID_GILDED);
    }

    public void setGilded(boolean gilded) {
        this.field_6011.method_12778(ID_GILDED, (Object)gilded);
    }

    public int getSummoningTicks() {
        return this.summoningTicks;
    }

    public void setSummoningTicks(int summoningTicks) {
        this.summoningTicks = summoningTicks;
    }

    public int getSummonCooldown() {
        return this.summonCooldown;
    }

    public void setSummonCooldown(int summonCooldown) {
        this.summonCooldown = summonCooldown;
    }

    @Override
    protected class_3414 method_6011(class_1282 damageSource) {
        return (class_3414)ModSoundEvents.NETHERITE_GOLEM_HURT.get();
    }

    @Override
    protected class_3414 method_6002() {
        return (class_3414)ModSoundEvents.NETHERITE_GOLEM_DEATH.get();
    }

    protected void method_5712(class_2338 pos, class_2680 state) {
    }

    @Override
    public void method_5711(byte id) {
        super.method_5711(id);
        if (id == 8) {
            this.summoningTicks = 60;
        }
    }

    protected boolean method_29920() {
        return false;
    }

    protected float method_6120() {
        return 0.0f;
    }

    public boolean method_5810() {
        return false;
    }

    public boolean method_5675() {
        return false;
    }

    public boolean method_5643(class_1282 source, float amount) {
        if (source.method_48789(class_8103.field_42247)) {
            return false;
        }
        if (source.method_49708(class_8111.field_42344)) {
            return false;
        }
        if (source.method_49708(class_8111.field_42329)) {
            return false;
        }
        return super.method_5643(source, amount);
    }

    public boolean method_29503() {
        return this.isCharged();
    }

    public boolean method_6049(class_1293 effectInstance) {
        return effectInstance.method_5579().method_5573();
    }

    protected void method_6108() {
        ++this.field_6213;
        if (this.field_6213 >= 50 && !this.method_37908().method_8608() && !this.method_31481()) {
            this.removeAndAddDeathParticles();
        }
    }

    @Override
    public boolean canFloatInWater() {
        return false;
    }

    @Override
    public boolean hasAttackAnimation() {
        return this.getSummoningTicks() == 0;
    }

    @Override
    public int getAttackTicks() {
        return 25;
    }

    @Override
    public int getAttackDelayTicks() {
        return 14;
    }

    @Override
    public class_1792 getRepairItem() {
        return class_1802.field_22021;
    }

    @Override
    public float getRepairItemHealAmount() {
        return 80.0f;
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
        if (this.isCharged()) {
            if (stack.method_31574(class_1802.field_8550)) {
                this.setCharged(false);
                return class_1269.field_5812;
            }
        } else if (stack.method_31574(class_1802.field_8187)) {
            if (!player.method_31549().field_7477) {
                player.method_6122(hand, class_1802.field_8550.method_7854());
            }
            this.method_43077(class_3417.field_15010);
            this.setCharged(true);
            return class_1269.field_5812;
        }
        if (!this.isGilded() && stack.method_31574(class_1802.field_8695)) {
            if (!player.method_31549().field_7477) {
                stack.method_7934(1);
            }
            this.method_43077(class_3417.field_14761);
            this.setGilded(true);
            return class_1269.field_5812;
        }
        if (stack.method_31574(class_1802.field_8868)) {
            return class_1269.field_5811;
        }
        if (player.method_5854() == null) {
            player.method_36456(this.method_36454());
            player.method_36457(this.method_36455());
            player.method_5804((class_1297)this);
            return class_1269.field_5812;
        }
        return class_1269.field_5811;
    }

    @Override
    @NotNull
    public List<class_1799> onSheared() {
        this.method_43077(class_3417.field_22273);
        this.method_43077(class_3417.field_14761);
        this.setGilded(false);
        return List.of(class_1802.field_8695.method_7854());
    }

    @Override
    public boolean isShearable() {
        return this.isGilded();
    }

    @Override
    protected class_238 getAttackBoundingBox() {
        return super.getAttackBoundingBox().method_1009(1.0, 0.0, 1.0);
    }

    protected void method_5865(class_1297 passenger, class_1297.class_4738 callback) {
        super.method_5865(passenger, callback);
        if (passenger instanceof class_1309) {
            class_1309 entity = (class_1309)passenger;
            entity.field_6283 = this.field_6283;
        }
    }

    protected void method_49481(class_1657 player, class_243 travelVector) {
        super.method_49481(player, travelVector);
        class_241 vec2 = this.getRiddenRotation((class_1309)player);
        this.method_5710(vec2.field_1342, vec2.field_1343);
        this.field_6283 = this.field_6241 = this.method_36454();
        this.field_5982 = this.field_6241;
    }

    protected class_241 getRiddenRotation(class_1309 entity) {
        return new class_241(entity.method_36455() * 0.5f, entity.method_36454());
    }

    protected class_243 method_49482(class_1657 player, class_243 travelVector) {
        float x = player.field_6212 * 0.25f;
        float z = player.field_6250;
        if (z <= 0.0f) {
            z *= 0.25f;
        }
        return new class_243((double)x, 0.0, (double)z);
    }

    protected float method_49485(class_1657 player) {
        if (this.getSummoningTicks() > 0) {
            return 0.0f;
        }
        return (float)this.method_26825(class_5134.field_23719) * 0.45f;
    }

    @Nullable
    public class_1309 method_5642() {
        class_1297 class_12972;
        if (!this.method_5987() && (class_12972 = this.method_31483()) instanceof class_1309) {
            class_1309 entity = (class_1309)class_12972;
            return entity;
        }
        return null;
    }

    public void method_6154(int jumpPower) {
    }

    public boolean method_6153() {
        return !this.isAttacking();
    }

    public void method_6155(int jumpPower) {
        this.startAttacking();
        this.sendAttackEvent();
        this.lastJumpPower = jumpPower;
    }

    public void method_6156() {
    }

    @Override
    public void actuallyAttackAfterDelay(class_1309 target) {
        if (this.lastJumpPower == 0) {
            class_243 lookAngle = this.method_5720();
            target.method_45319(new class_243(lookAngle.field_1352 * 0.4, 0.5, lookAngle.field_1350 * 0.4));
            super.actuallyAttackAfterDelay(target);
        }
    }

    @Override
    public void performAdditionalAttacks(@Nullable class_1309 target) {
        if (this.lastJumpPower > 0) {
            int attackBonus = this.lastJumpPower;
            int rangeBonus = this.lastJumpPower;
            float y = 0.5f;
            if (this.lastJumpPower == 100) {
                attackBonus = 175;
                rangeBonus = 150;
                y = 0.75f;
                class_1937 class_19372 = this.method_37908();
                if (class_19372 instanceof class_3218) {
                    class_3218 level = (class_3218)class_19372;
                    class_243 lookAngle = this.method_5720();
                    ModUtils.sendParticles(level, class_2398.field_11236, this.method_23317() + lookAngle.field_1352 * 0.5, this.method_23318() + 0.5, this.method_23321() + lookAngle.field_1350 * 0.5, 10, 0.5, 0.5, 0.5, 0.0);
                }
            }
            this.doAoeAttack(null, 4.0f + (float)attackBonus / 6.0f, 1.5f + (float)rangeBonus / 40.0f, y);
            this.lastJumpPower = 0;
        } else {
            this.doAoeAttack(target, (float)this.method_26825(class_5134.field_23721), 0.5f, 0.5f);
        }
    }

    public void doAoeAttack(@Nullable class_1309 target, float damage, float radius, float y) {
        for (class_1309 entity : this.method_37908().method_18467(class_1309.class, this.method_5829().method_1014((double)radius))) {
            if (entity == this || target != null && entity instanceof class_1427 || target != null && entity instanceof class_1657 || target != null && entity instanceof class_6025 || entity.equals((Object)this.method_31483())) continue;
            entity.method_5643(this.method_48923().method_48812((class_1309)this), damage);
            class_243 lookAngle = this.method_5720();
            entity.method_45319(new class_243(lookAngle.field_1352 * 0.4, (double)y, lookAngle.field_1350 * 0.4));
        }
    }

    @Override
    public boolean method_18395(class_1309 target) {
        return !this.method_5782() && super.method_18395(target);
    }

    @Override
    public void method_6007() {
        this.summoningTicks = Math.max(0, this.summoningTicks - 1);
        this.summonCooldown = Math.max(0, this.summonCooldown - 1);
        if (!this.method_37908().method_8608()) {
            if (this.summoningTicks > 0) {
                if (this.summoningTicks == 40) {
                    this.spawnCoalGolems();
                }
                this.field_6189.method_6340();
                this.method_5980(null);
            }
            if (!this.isAttacking() && this.summonCooldown == 0 && this.method_5968() != null && this.method_31483() == null && this.field_5974.method_43048(100) == 0) {
                this.summon();
            }
        }
        if (this.method_37908().method_8608() && this.isCharged()) {
            this.spawnFireParticles();
        }
        super.method_6007();
    }

    private void spawnFireParticles() {
        class_243 lookAngle = this.method_5720();
        this.method_37908().method_8406((class_2394)class_2398.field_11240, this.method_23322(0.3) + lookAngle.field_1352 * 0.5, this.method_23318() + 0.8, this.method_23325(0.3) + lookAngle.field_1350 * 0.5, lookAngle.field_1352 * 0.05, 0.05, lookAngle.field_1350 * 0.05);
    }

    public void summon() {
        if (this.summonCooldown > 0) {
            return;
        }
        if (!this.isCharged()) {
            return;
        }
        this.summoningTicks = 60;
        this.summonCooldown = 1200;
        this.method_37908().method_8421((class_1297)this, (byte)8);
    }

    public void spawnCoalGolems() {
        int i;
        this.method_43077(class_3417.field_15013);
        for (i = 0; i < 5; ++i) {
            CoalGolem golem = (CoalGolem)((class_1299)ModEntityTypes.COAL_GOLEM.get()).method_5883(this.method_37908());
            if (golem == null) {
                return;
            }
            class_243 lookAngle = this.method_5720();
            golem.method_5814(this.method_23317() + lookAngle.field_1352 * 0.5, this.method_23318() + 0.35, this.method_23321() + lookAngle.field_1350 * 0.5);
            golem.setLit(true);
            golem.setSummoner(this.method_5667());
            this.method_37908().method_8649((class_1297)golem);
            golem.method_5980(this.method_5968());
            golem.method_5980(this.method_5968());
        }
        for (i = 0; i < 10; ++i) {
            this.method_37908().method_8406((class_2394)class_2398.field_11237, this.method_23322(0.5), this.method_23319() - 0.75, this.method_23325(0.5), (this.field_5974.method_43058() - 0.5) * 0.5, -this.field_5974.method_43058(), (this.field_5974.method_43058() - 0.5) * 0.5);
        }
    }
}

