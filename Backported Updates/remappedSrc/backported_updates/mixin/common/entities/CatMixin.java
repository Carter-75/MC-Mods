/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1266
 *  net.minecraft.class_1296
 *  net.minecraft.class_1299
 *  net.minecraft.class_1309
 *  net.minecraft.class_1315
 *  net.minecraft.class_1429
 *  net.minecraft.class_1451
 *  net.minecraft.class_1767
 *  net.minecraft.class_1937
 *  net.minecraft.class_2487
 *  net.minecraft.class_2940
 *  net.minecraft.class_2941
 *  net.minecraft.class_2943
 *  net.minecraft.class_2945
 *  net.minecraft.class_2945$class_9222
 *  net.minecraft.class_3218
 *  net.minecraft.class_3730
 *  net.minecraft.class_5425
 *  net.minecraft.class_6880
 *  net.minecraft.class_7375
 *  org.spongepowered.asm.mixin.Final
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.Shadow
 *  org.spongepowered.asm.mixin.Unique
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfo
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable
 */
package backported_updates.mixin.common.entities;

import backported.updates.content.common.api.variant.VariantDataHolder;
import backported.updates.content.common.api.variant.VariantUtils;
import backported.updates.content.common.api.variant.spawn.SpawnContext;
import backported.updates.content.common.level.entities.animal.CatDataVariant;
import backported.updates.content.core.registries.ModBuiltinRegistries;
import backported.updates.content.core.util.ColorUtils;
import backported_updates.mixin.common.entities.TamableAnimalMixin;
import java.util.Optional;
import net.minecraft.class_1266;
import net.minecraft.class_1296;
import net.minecraft.class_1299;
import net.minecraft.class_1309;
import net.minecraft.class_1315;
import net.minecraft.class_1429;
import net.minecraft.class_1451;
import net.minecraft.class_1767;
import net.minecraft.class_1937;
import net.minecraft.class_2487;
import net.minecraft.class_2940;
import net.minecraft.class_2941;
import net.minecraft.class_2943;
import net.minecraft.class_2945;
import net.minecraft.class_3218;
import net.minecraft.class_3730;
import net.minecraft.class_5425;
import net.minecraft.class_6880;
import net.minecraft.class_7375;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(value={class_1451.class})
public abstract class CatMixin
extends TamableAnimalMixin
implements VariantDataHolder<CatDataVariant> {
    @Unique
    private static final class_2940<String> DATA_VARIANT_ID = class_2945.method_12791(class_1451.class, (class_2941)class_2943.field_13326);
    @Shadow
    @Final
    private static class_2940<Integer> field_16285;

    @Shadow
    public abstract class_6880<class_7375> method_47843();

    @Shadow
    public abstract class_1767 method_16096();

    protected CatMixin(class_1299<? extends class_1429> entityType, class_1937 level) {
        super(entityType, level);
    }

    @Override
    protected void vb$defineSynchedData(class_2945.class_9222 builder, CallbackInfo ci) {
        builder.method_56912(DATA_VARIANT_ID, (Object)"minecraft:tabby");
    }

    @Override
    public void setVariantData(CatDataVariant variant) {
        this.field_6011.method_12778(DATA_VARIANT_ID, (Object)VariantUtils.getID(ModBuiltinRegistries.CAT_VARIANTS, variant));
    }

    @Override
    public Optional<CatDataVariant> getVariantData() {
        return VariantUtils.getOrDefault(ModBuiltinRegistries.CAT_VARIANTS, (String)this.field_6011.method_12789(DATA_VARIANT_ID));
    }

    @Inject(method={"addAdditionalSaveData"}, at={@At(value="RETURN")})
    private void vb$addAdditionalData(class_2487 tag, CallbackInfo ci) {
        VariantUtils.addVariantSaveData(this, tag, ModBuiltinRegistries.CAT_VARIANTS);
    }

    @Inject(method={"readAdditionalSaveData"}, at={@At(value="HEAD")})
    private void vb$readAdditionalData(class_2487 tag, CallbackInfo ci) {
        VariantUtils.readVariantSaveData(this, tag, ModBuiltinRegistries.CAT_VARIANTS);
    }

    @Override
    protected void vb$finalizeSpawn(class_5425 level, class_1266 difficulty, class_3730 reason, class_1315 spawnData, CallbackInfoReturnable<class_1315> cir) {
        VariantUtils.selectVariantToSpawn(SpawnContext.create(level, this.method_24515()), ModBuiltinRegistries.CAT_VARIANTS).ifPresent(this::setVariantData);
    }

    @Inject(method={"getBreedOffspring(Lnet/minecraft/server/level/ServerLevel;Lnet/minecraft/world/entity/AgeableMob;)Lnet/minecraft/world/entity/animal/Cat;"}, at={@At(value="RETURN")})
    private void vb$getBreedOffspring(class_3218 level, class_1296 otherParent, CallbackInfoReturnable<class_1451> cir) {
        class_1451 child = (class_1451)cir.getReturnValue();
        if (child != null && otherParent instanceof class_1451) {
            class_1451 mate = (class_1451)otherParent;
            if (this.method_6181()) {
                class_1767 fatherColor = this.method_16096();
                class_1767 motherColor = mate.method_16096();
                child.method_5841().method_12778(field_16285, (Object)ColorUtils.getMixedColor(level, fatherColor, motherColor).method_7789());
            }
            VariantDataHolder.trySetOffspringVariant((class_1309)child, this, (class_1309)mate);
        }
    }
}

