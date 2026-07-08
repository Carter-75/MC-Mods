/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1263
 *  net.minecraft.class_1266
 *  net.minecraft.class_1282
 *  net.minecraft.class_1297
 *  net.minecraft.class_1299
 *  net.minecraft.class_1308
 *  net.minecraft.class_1315
 *  net.minecraft.class_1427
 *  net.minecraft.class_1792
 *  net.minecraft.class_1799
 *  net.minecraft.class_1802
 *  net.minecraft.class_1936
 *  net.minecraft.class_1937
 *  net.minecraft.class_2338
 *  net.minecraft.class_238
 *  net.minecraft.class_243
 *  net.minecraft.class_2487
 *  net.minecraft.class_2700$class_2702
 *  net.minecraft.class_2940
 *  net.minecraft.class_2941
 *  net.minecraft.class_2943
 *  net.minecraft.class_2945
 *  net.minecraft.class_3414
 *  net.minecraft.class_3417
 *  net.minecraft.class_3730
 *  net.minecraft.class_3956
 *  net.minecraft.class_4538
 *  net.minecraft.class_5132$class_5133
 *  net.minecraft.class_5134
 *  net.minecraft.class_5425
 *  net.minecraft.class_5819
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 *  software.bernie.geckolib.core.animation.AnimatableManager$ControllerRegistrar
 */
package tech.alexnijjar.golemoverhaul.common.entities.golems;

import java.util.List;
import java.util.Locale;
import net.minecraft.class_1263;
import net.minecraft.class_1266;
import net.minecraft.class_1282;
import net.minecraft.class_1297;
import net.minecraft.class_1299;
import net.minecraft.class_1308;
import net.minecraft.class_1315;
import net.minecraft.class_1427;
import net.minecraft.class_1792;
import net.minecraft.class_1799;
import net.minecraft.class_1802;
import net.minecraft.class_1936;
import net.minecraft.class_1937;
import net.minecraft.class_2338;
import net.minecraft.class_238;
import net.minecraft.class_243;
import net.minecraft.class_2487;
import net.minecraft.class_2700;
import net.minecraft.class_2940;
import net.minecraft.class_2941;
import net.minecraft.class_2943;
import net.minecraft.class_2945;
import net.minecraft.class_3414;
import net.minecraft.class_3417;
import net.minecraft.class_3730;
import net.minecraft.class_3956;
import net.minecraft.class_4538;
import net.minecraft.class_5132;
import net.minecraft.class_5134;
import net.minecraft.class_5425;
import net.minecraft.class_5819;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.core.animation.AnimatableManager;
import tech.alexnijjar.golemoverhaul.common.config.GolemOverhaulConfig;
import tech.alexnijjar.golemoverhaul.common.entities.IShearable;
import tech.alexnijjar.golemoverhaul.common.entities.golems.base.BaseGolem;
import tech.alexnijjar.golemoverhaul.common.recipes.GolemConstructionRecipe;
import tech.alexnijjar.golemoverhaul.common.recipes.SingleEntityInput;
import tech.alexnijjar.golemoverhaul.common.registry.ModEntityTypes;
import tech.alexnijjar.golemoverhaul.common.registry.ModRecipeTypes;
import tech.alexnijjar.golemoverhaul.common.registry.ModSoundEvents;
import tech.alexnijjar.golemoverhaul.common.utils.ModUtils;

public class HayGolem
extends BaseGolem
implements IShearable {
    private static final class_2940<Byte> ID_COLOR = class_2945.method_12791(HayGolem.class, (class_2941)class_2943.field_13319);
    private static final class_2940<Boolean> ID_SHEARED = class_2945.method_12791(HayGolem.class, (class_2941)class_2943.field_13323);

    public HayGolem(class_1299<? extends class_1427> type, class_1937 level) {
        super(type, level);
        this.field_6194 = 8;
    }

    public static class_5132.class_5133 createAttributes() {
        return class_1308.method_26828().method_26868(class_5134.field_23716, 40.0).method_26868(class_5134.field_23719, 0.18).method_26868(class_5134.field_23721, 3.0);
    }

    public static boolean checkMobSpawnRules(class_1299<? extends class_1308> type, class_1936 level, class_3730 spawnType, class_2338 pos, class_5819 random) {
        if (!GolemOverhaulConfig.spawnHayGolems || !GolemOverhaulConfig.allowSpawning) {
            return false;
        }
        return class_1308.method_20636(type, (class_1936)level, (class_3730)spawnType, (class_2338)pos, (class_5819)random);
    }

    public static void trySpawnGolem(class_1937 level, class_2338 pos) {
        GolemConstructionRecipe recipe = (GolemConstructionRecipe)level.method_8433().method_8132((class_3956)ModRecipeTypes.GOLEM_CONSTRUCTION.get(), (class_1263)new SingleEntityInput((class_1299)ModEntityTypes.HAY_GOLEM.get()), level).orElseThrow();
        class_2700.class_2702 pattern = recipe.createPattern().method_11708((class_4538)level, pos);
        if (pattern == null) {
            return;
        }
        HayGolem golem = (HayGolem)((class_1299)ModEntityTypes.HAY_GOLEM.get()).method_5883(level);
        if (golem == null) {
            return;
        }
        golem.setColor(level.method_8409().method_43056() ? Color.GREEN : Color.RED);
        ModUtils.spawnGolemInWorld(level, pattern, (class_1297)golem, pattern.method_11717(1, 2, 0).method_11683());
    }

    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllers) {
        super.registerControllers(controllers);
    }

    protected void method_5693() {
        super.method_5693();
        this.field_6011.method_12784(ID_COLOR, (Object)0);
        this.field_6011.method_12784(ID_SHEARED, (Object)false);
    }

    public void method_5652(class_2487 compound) {
        super.method_5652(compound);
        compound.method_10582("color", this.getColor().name().toLowerCase(Locale.ROOT));
        compound.method_10556("sheared", this.isSheared());
    }

    @Override
    public void method_5749(class_2487 compound) {
        super.method_5749(compound);
        if (compound.method_10545("color")) {
            this.setColor(Color.valueOf(compound.method_10558("color").toUpperCase(Locale.ROOT)));
        }
        this.setSheared(compound.method_10577("sheared"));
    }

    @Override
    public boolean canTarget() {
        return false;
    }

    public Color getColor() {
        return Color.values()[(Byte)this.field_6011.method_12789(ID_COLOR)];
    }

    public void setColor(Color color) {
        this.field_6011.method_12778(ID_COLOR, (Object)((byte)color.ordinal()));
    }

    public boolean isSheared() {
        return (Boolean)this.field_6011.method_12789(ID_SHEARED);
    }

    public void setSheared(boolean sheared) {
        this.field_6011.method_12778(ID_SHEARED, (Object)sheared);
    }

    @Override
    protected class_3414 method_6011(class_1282 damageSource) {
        return (class_3414)ModSoundEvents.HAY_GOLEM_HURT.get();
    }

    @Override
    protected class_3414 method_6002() {
        return (class_3414)ModSoundEvents.HAY_GOLEM_DEATH.get();
    }

    @Override
    public class_1792 getRepairItem() {
        return class_1802.field_8861;
    }

    @Override
    public float getRepairItemHealAmount() {
        return 10.0f;
    }

    @Override
    public class_3414 getRepairSound() {
        return class_3417.field_28617;
    }

    @Override
    @Nullable
    public class_1315 method_5943(class_5425 level, class_1266 difficulty, class_3730 reason, @Nullable class_1315 spawnData, @Nullable class_2487 dataTag) {
        this.setColor(level.method_8409().method_43056() ? Color.GREEN : Color.RED);
        return super.method_5943(level, difficulty, reason, spawnData, dataTag);
    }

    @Override
    protected class_238 getAttackBoundingBox() {
        return super.getAttackBoundingBox().method_1009(0.5, 0.0, 0.5);
    }

    @NotNull
    protected class_243 method_29919() {
        return new class_243(0.0, (double)0.3f, 0.0);
    }

    @Override
    @NotNull
    public List<class_1799> onSheared() {
        this.method_43077(class_3417.field_22273);
        this.setSheared(true);
        return List.of(class_1802.field_17519.method_7854());
    }

    @Override
    public boolean isShearable() {
        return !this.isSheared();
    }

    public static enum Color {
        GREEN,
        RED;

    }
}

