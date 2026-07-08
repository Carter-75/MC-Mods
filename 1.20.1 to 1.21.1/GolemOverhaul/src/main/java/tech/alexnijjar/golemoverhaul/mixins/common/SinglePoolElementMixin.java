/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.datafixers.util.Either
 *  net.minecraft.class_1297
 *  net.minecraft.class_1299
 *  net.minecraft.class_1308
 *  net.minecraft.class_1936
 *  net.minecraft.class_1937
 *  net.minecraft.class_2338
 *  net.minecraft.class_2374
 *  net.minecraft.class_243
 *  net.minecraft.class_2470
 *  net.minecraft.class_2794
 *  net.minecraft.class_2960
 *  net.minecraft.class_3341
 *  net.minecraft.class_3485
 *  net.minecraft.class_3492
 *  net.minecraft.class_3499
 *  net.minecraft.class_3730
 *  net.minecraft.class_3781
 *  net.minecraft.class_5138
 *  net.minecraft.class_5281
 *  net.minecraft.class_5425
 *  net.minecraft.class_5819
 *  org.spongepowered.asm.mixin.Final
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.Shadow
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable
 */
package tech.alexnijjar.golemoverhaul.mixins.common;

import com.mojang.datafixers.util.Either;
import net.minecraft.class_1297;
import net.minecraft.class_1299;
import net.minecraft.class_1308;
import net.minecraft.class_1936;
import net.minecraft.class_1937;
import net.minecraft.class_2338;
import net.minecraft.class_2374;
import net.minecraft.class_243;
import net.minecraft.class_2470;
import net.minecraft.class_2794;
import net.minecraft.class_2960;
import net.minecraft.class_3341;
import net.minecraft.class_3485;
import net.minecraft.class_3492;
import net.minecraft.class_3499;
import net.minecraft.class_3730;
import net.minecraft.class_3781;
import net.minecraft.class_5138;
import net.minecraft.class_5281;
import net.minecraft.class_5425;
import net.minecraft.class_5819;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import tech.alexnijjar.golemoverhaul.common.entities.golems.BarrelGolem;
import tech.alexnijjar.golemoverhaul.common.entities.golems.HayGolem;
import tech.alexnijjar.golemoverhaul.common.entities.golems.base.BaseGolem;
import tech.alexnijjar.golemoverhaul.common.registry.ModEntityTypes;

@Mixin(value={class_3781.class})
public abstract class SinglePoolElementMixin {
    private static final class_2960 IRON_GOLEM_STRUCTURE = new class_2960("village/common/iron_golem");
    @Shadow
    @Final
    protected Either<class_2960, class_3499> field_24015;

    @Shadow
    protected abstract class_3492 method_16616(class_2470 var1, class_3341 var2, boolean var3);

    @Inject(method={"place(Lnet/minecraft/world/level/levelgen/structure/templatesystem/StructureTemplateManager;Lnet/minecraft/world/level/WorldGenLevel;Lnet/minecraft/world/level/StructureManager;Lnet/minecraft/world/level/chunk/ChunkGenerator;Lnet/minecraft/core/BlockPos;Lnet/minecraft/core/BlockPos;Lnet/minecraft/world/level/block/Rotation;Lnet/minecraft/world/level/levelgen/structure/BoundingBox;Lnet/minecraft/util/RandomSource;Z)Z"}, at={@At(value="RETURN")})
    private void golemoverhaul$place(class_3485 structureTemplateManager, class_5281 worldGenLevel, class_5138 structureManager, class_2794 generator, class_2338 offset, class_2338 pos, class_2470 rotation, class_3341 box, class_5819 random, boolean keepJigsaws, CallbackInfoReturnable<Boolean> cir) {
        if (!((Boolean)cir.getReturnValue()).booleanValue()) {
            return;
        }
        if (worldGenLevel.method_8608()) {
            return;
        }
        this.field_24015.left().ifPresent(templateLocation -> {
            class_1299 hayGolemEntityType;
            if (!templateLocation.equals((Object)IRON_GOLEM_STRUCTURE)) {
                return;
            }
            class_3492 settings = this.method_16616(rotation, box, keepJigsaws);
            class_1299 barrelGolemEntityType = (class_1299)ModEntityTypes.BARREL_GOLEM.get();
            if (BarrelGolem.checkMobSpawnRules((class_1299<? extends class_1308>)barrelGolemEntityType, (class_1936)worldGenLevel, class_3730.field_16469, offset, worldGenLevel.method_8409())) {
                this.spawnAdditionalGolem(barrelGolemEntityType, worldGenLevel, settings, offset);
            }
            if (HayGolem.checkMobSpawnRules((class_1299<? extends class_1308>)(hayGolemEntityType = (class_1299)ModEntityTypes.HAY_GOLEM.get()), (class_1936)worldGenLevel, class_3730.field_16469, offset, worldGenLevel.method_8409())) {
                this.spawnAdditionalGolem(hayGolemEntityType, worldGenLevel, settings, offset);
            }
        });
    }

    private <T extends BaseGolem> void spawnAdditionalGolem(class_1299<T> entityType, class_5281 worldGenLevel, class_3492 settings, class_2338 offset) {
        BaseGolem golem = (BaseGolem)entityType.method_5883((class_1937)worldGenLevel.method_8410());
        if (golem == null) {
            return;
        }
        class_243 spawnPos = new class_243((double)offset.method_10263() + 0.5, (double)(offset.method_10264() + 1), (double)offset.method_10260() + 0.5);
        float yRot = golem.method_5832(settings.method_15113());
        golem.method_5808(spawnPos.field_1352, spawnPos.field_1351, spawnPos.field_1350, yRot += golem.method_5763(settings.method_15114()) - golem.method_36454(), golem.method_36455());
        if (settings.method_27265()) {
            golem.method_5943((class_5425)worldGenLevel, worldGenLevel.method_8404(class_2338.method_49638((class_2374)spawnPos)), class_3730.field_16474, null, null);
        }
        worldGenLevel.method_30771((class_1297)golem);
    }
}

