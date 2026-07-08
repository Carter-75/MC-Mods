/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1266
 *  net.minecraft.class_1268
 *  net.minecraft.class_1269
 *  net.minecraft.class_1282
 *  net.minecraft.class_1297
 *  net.minecraft.class_1299
 *  net.minecraft.class_1308
 *  net.minecraft.class_1309
 *  net.minecraft.class_1315
 *  net.minecraft.class_1352
 *  net.minecraft.class_1381
 *  net.minecraft.class_1427
 *  net.minecraft.class_1603
 *  net.minecraft.class_1657
 *  net.minecraft.class_1792
 *  net.minecraft.class_1799
 *  net.minecraft.class_1802
 *  net.minecraft.class_1936
 *  net.minecraft.class_1937
 *  net.minecraft.class_2338
 *  net.minecraft.class_238
 *  net.minecraft.class_2487
 *  net.minecraft.class_2520
 *  net.minecraft.class_2940
 *  net.minecraft.class_2941
 *  net.minecraft.class_2943
 *  net.minecraft.class_2945
 *  net.minecraft.class_3414
 *  net.minecraft.class_3417
 *  net.minecraft.class_3730
 *  net.minecraft.class_5132$class_5133
 *  net.minecraft.class_5134
 *  net.minecraft.class_5425
 *  net.minecraft.class_5819
 *  net.minecraft.class_8111
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 *  software.bernie.geckolib.core.animation.AnimatableManager$ControllerRegistrar
 */
package tech.alexnijjar.golemoverhaul.common.entities.golems;

import java.util.List;
import java.util.Locale;
import java.util.function.Predicate;
import net.minecraft.class_1266;
import net.minecraft.class_1268;
import net.minecraft.class_1269;
import net.minecraft.class_1282;
import net.minecraft.class_1297;
import net.minecraft.class_1299;
import net.minecraft.class_1308;
import net.minecraft.class_1309;
import net.minecraft.class_1315;
import net.minecraft.class_1352;
import net.minecraft.class_1381;
import net.minecraft.class_1427;
import net.minecraft.class_1603;
import net.minecraft.class_1657;
import net.minecraft.class_1792;
import net.minecraft.class_1799;
import net.minecraft.class_1802;
import net.minecraft.class_1936;
import net.minecraft.class_1937;
import net.minecraft.class_2338;
import net.minecraft.class_238;
import net.minecraft.class_2487;
import net.minecraft.class_2520;
import net.minecraft.class_2940;
import net.minecraft.class_2941;
import net.minecraft.class_2943;
import net.minecraft.class_2945;
import net.minecraft.class_3414;
import net.minecraft.class_3417;
import net.minecraft.class_3730;
import net.minecraft.class_5132;
import net.minecraft.class_5134;
import net.minecraft.class_5425;
import net.minecraft.class_5819;
import net.minecraft.class_8111;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.core.animation.AnimatableManager;
import tech.alexnijjar.golemoverhaul.common.config.GolemOverhaulConfig;
import tech.alexnijjar.golemoverhaul.common.entities.IShearable;
import tech.alexnijjar.golemoverhaul.common.entities.golems.base.BaseGolem;
import tech.alexnijjar.golemoverhaul.common.entities.projectiles.MudBallProjectile;
import tech.alexnijjar.golemoverhaul.common.tags.ModItemTags;

public class TerracottaGolem
extends BaseGolem
implements IShearable,
class_1603 {
    public static final int RANGED_ATTACK_DELAY_TICKS = 2;
    private static final class_2940<Byte> ID_TYPE = class_2945.method_12791(TerracottaGolem.class, (class_2941)class_2943.field_13319);
    private final class_1381 rangedAttackGoal = new class_1381((class_1603)this, 1.0, 20, 15.0f);
    private int attackAnimationDelay = -1;
    private class_1799 equippedStack = class_1799.field_8037;

    public TerracottaGolem(class_1299<? extends class_1427> type, class_1937 level) {
        super(type, level);
        this.field_6194 = 6;
    }

    public static class_5132.class_5133 createAttributes() {
        return class_1308.method_26828().method_26868(class_5134.field_23716, 30.0).method_26868(class_5134.field_23719, 0.2).method_26868(class_5134.field_23721, (double)Type.CACTUS.attackDamage);
    }

    public static boolean checkMobSpawnRules(class_1299<? extends class_1308> type, class_1936 level, class_3730 spawnType, class_2338 pos, class_5819 random) {
        if (!GolemOverhaulConfig.spawnTerracottaGolems || !GolemOverhaulConfig.allowSpawning) {
            return false;
        }
        return class_1308.method_20636(type, (class_1936)level, (class_3730)spawnType, (class_2338)pos, (class_5819)random);
    }

    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllers) {
        super.registerControllers(controllers);
    }

    protected void method_5693() {
        super.method_5693();
        this.field_6011.method_12784(ID_TYPE, (Object)0);
    }

    public void method_5652(class_2487 compound) {
        super.method_5652(compound);
        compound.method_10582("type", this.getTerracottaType().name().toLowerCase(Locale.ROOT));
        if (!this.equippedStack.method_7960()) {
            compound.method_10566("item", (class_2520)this.equippedStack.method_7953(new class_2487()));
        }
    }

    @Override
    public void method_5749(class_2487 compound) {
        super.method_5749(compound);
        this.setTerracottaType(Type.valueOf(compound.method_10558("type").toUpperCase(Locale.ROOT)));
        if (compound.method_10573("item", 10)) {
            this.equippedStack = class_1799.method_7915((class_2487)compound.method_10562("item"));
        }
    }

    @Override
    public boolean canMeleeAttack() {
        return !this.getTerracottaType().ranged;
    }

    public Type getTerracottaType() {
        return Type.values()[(Byte)this.field_6011.method_12789(ID_TYPE)];
    }

    public void setTerracottaType(Type type) {
        this.field_6011.method_12778(ID_TYPE, (Object)((byte)type.ordinal()));
        this.method_5996(class_5134.field_23721).method_6192((double)type.attackDamage);
        this.method_5996(class_5134.field_23718).method_6192((double)type.knockbackResistance);
        this.field_6201.method_6280((class_1352)this.rangedAttackGoal);
        if (type.ranged) {
            this.field_6201.method_6277(2, (class_1352)this.rangedAttackGoal);
        }
        this.updateAttackGoals();
    }

    @Override
    public int getAttackTicks() {
        return 12;
    }

    @Override
    public class_1792 getRepairItem() {
        return class_1802.field_8696;
    }

    @Override
    public float getRepairItemHealAmount() {
        return 4.0f;
    }

    @Override
    public class_3414 getRepairSound() {
        return class_3417.field_14574;
    }

    @Override
    @Nullable
    public class_1315 method_5943(class_5425 level, class_1266 difficulty, class_3730 reason, @Nullable class_1315 spawnData, @Nullable class_2487 dataTag) {
        this.setTerracottaType(Type.values()[level.method_8409().method_43048(Type.values().length)]);
        return super.method_5943(level, difficulty, reason, spawnData, dataTag);
    }

    @Override
    @NotNull
    protected class_1269 method_5992(class_1657 player, @NotNull class_1268 hand) {
        class_1799 stack;
        Type type;
        if (this.getTerracottaType() == Type.NORMAL && !this.method_37908().method_8608() && (type = Type.ofStack(stack = player.method_5998(hand))) != null) {
            this.equippedStack = stack.method_46651(1);
            stack.method_7934(1);
            this.method_43077(class_3417.field_14883);
            this.setTerracottaType(type);
            return class_1269.field_5812;
        }
        return super.method_5992(player, hand);
    }

    @Override
    @NotNull
    public List<class_1799> onSheared() {
        this.method_43077(class_3417.field_22273);
        this.setTerracottaType(Type.NORMAL);
        if (!this.equippedStack.method_7960()) {
            return List.of(this.equippedStack);
        }
        return List.of(this.getTerracottaType().equipItem.method_7854());
    }

    @Override
    public boolean isShearable() {
        return this.getTerracottaType() != Type.NORMAL;
    }

    public boolean method_5643(class_1282 source, float amount) {
        class_1297 class_12972;
        if (!this.method_37908().method_8608() && this.getTerracottaType() == Type.CACTUS && !source.method_49708(class_8111.field_42330) && (class_12972 = source.method_5526()) instanceof class_1309) {
            class_1309 entity = (class_1309)class_12972;
            entity.method_5643(this.method_48923().method_48818((class_1297)this), 6.0f);
        }
        return super.method_5643(source, amount);
    }

    public void method_7105(class_1309 target, float velocity) {
        if (this.attackAnimationDelay == -1) {
            this.sendAttackEvent();
            this.attackAnimationDelay = 2;
        }
    }

    public void actuallyShoot(class_1309 target) {
        if (target == null) {
            return;
        }
        MudBallProjectile projectile = new MudBallProjectile(this.method_37908(), (class_1309)this);
        projectile.method_5814(this.method_23317(), this.method_23318(), this.method_23321());
        double x = target.method_23317() - this.method_23317();
        double y = target.method_23318() - projectile.method_23318();
        double z = target.method_23321() - this.method_23321();
        double distance = Math.sqrt(x * x + z * z) * 0.2;
        projectile.method_7485(x, y + distance, z, 1.0f, 5.0f);
        this.method_37908().method_8649((class_1297)projectile);
        this.method_5783(class_3417.field_14745, 1.0f, 0.4f / (this.method_6051().method_43057() * 0.4f + 0.8f));
    }

    protected void method_5958() {
        this.attackAnimationDelay = Math.max(-1, this.attackAnimationDelay - 1);
        if (this.attackAnimationDelay == 0) {
            this.actuallyShoot(this.method_5968());
            this.attackAnimationDelay = -1;
        }
    }

    @Override
    protected class_238 getAttackBoundingBox() {
        return super.getAttackBoundingBox().method_1009(0.5, 0.0, 0.5);
    }

    public static enum Type {
        NORMAL(2.0f, 0.0f, class_1802.field_8162, false, stack -> false),
        CACTUS(6.0f, 1.0f, class_1802.field_17520, false, stack -> stack.method_31573(ModItemTags.CACTUS)),
        DEAD_BUSH(4.0f, 0.0f, class_1802.field_8689, true, stack -> stack.method_31574(class_1802.field_8689));

        private final float attackDamage;
        private final float knockbackResistance;
        private final class_1792 equipItem;
        private final boolean ranged;
        private final Predicate<class_1799> isValidStack;

        private Type(float attackDamage, float knockbackResistance, class_1792 equipItem, boolean ranged, Predicate<class_1799> isValidStack) {
            this.attackDamage = attackDamage;
            this.knockbackResistance = knockbackResistance;
            this.equipItem = equipItem;
            this.ranged = ranged;
            this.isValidStack = isValidStack;
        }

        @Nullable
        private static Type ofStack(class_1799 stack) {
            for (Type type : Type.values()) {
                if (!type.isValidStack.test(stack)) continue;
                return type;
            }
            return null;
        }
    }
}

