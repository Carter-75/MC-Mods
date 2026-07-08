/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1266
 *  net.minecraft.class_1296
 *  net.minecraft.class_1299
 *  net.minecraft.class_1309
 *  net.minecraft.class_1315
 *  net.minecraft.class_1493
 *  net.minecraft.class_1767
 *  net.minecraft.class_1937
 *  net.minecraft.class_2487
 *  net.minecraft.class_2940
 *  net.minecraft.class_2941
 *  net.minecraft.class_2943
 *  net.minecraft.class_2945
 *  net.minecraft.class_2945$class_9222
 *  net.minecraft.class_2960
 *  net.minecraft.class_3218
 *  net.minecraft.class_3414
 *  net.minecraft.class_3730
 *  net.minecraft.class_5354
 *  net.minecraft.class_5425
 *  net.minecraft.class_6880
 *  net.minecraft.class_9346
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
import backported.updates.content.common.api.wolf.WolfSoundVariant;
import backported.updates.content.common.api.wolf.WolfSoundVariantHolder;
import backported.updates.content.common.api.wolf.WolfSoundVariants;
import backported.updates.content.common.level.entities.animal.WolfDataVariant;
import backported.updates.content.common.level.entities.animal.modules.WolfSoundVariantsModule;
import backported.updates.content.core.registries.ModBuiltinRegistries;
import backported.updates.content.core.util.ColorUtils;
import backported_updates.mixin.access.WolfAccessor;
import backported_updates.mixin.common.entities.TamableAnimalMixin;
import java.util.Optional;
import net.minecraft.class_1266;
import net.minecraft.class_1296;
import net.minecraft.class_1299;
import net.minecraft.class_1309;
import net.minecraft.class_1315;
import net.minecraft.class_1493;
import net.minecraft.class_1767;
import net.minecraft.class_1937;
import net.minecraft.class_2487;
import net.minecraft.class_2940;
import net.minecraft.class_2941;
import net.minecraft.class_2943;
import net.minecraft.class_2945;
import net.minecraft.class_2960;
import net.minecraft.class_3218;
import net.minecraft.class_3414;
import net.minecraft.class_3730;
import net.minecraft.class_5354;
import net.minecraft.class_5425;
import net.minecraft.class_6880;
import net.minecraft.class_9346;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(value={class_1493.class})
public abstract class WolfMixin
extends TamableAnimalMixin
implements class_5354,
WolfSoundVariantHolder,
VariantDataHolder<WolfDataVariant> {
    @Unique
    private static class_2940<String> DATA_SOUND_VARIANT_ID;
    @Unique
    private static class_2940<String> DATA_VARIANT_ID;

    @Shadow
    public abstract class_1767 method_6713();

    @Shadow
    public abstract class_6880<class_9346> method_58062();

    protected WolfMixin(class_1299<? extends class_1309> entityType, class_1937 level) {
        super(entityType, level);
    }

    @Inject(method={"<clinit>"}, at={@At(value="TAIL")})
    private static void vb$registerAccessor(CallbackInfo ci) {
        DATA_SOUND_VARIANT_ID = class_2945.method_12791(class_1493.class, (class_2941)class_2943.field_13326);
        DATA_VARIANT_ID = class_2945.method_12791(class_1493.class, (class_2941)class_2943.field_13326);
    }

    @Override
    protected void vb$defineSynchedData(class_2945.class_9222 builder, CallbackInfo ci) {
        builder.method_56912(DATA_SOUND_VARIANT_ID, (Object)VariantUtils.getDefaultID(ModBuiltinRegistries.WOLF_SOUND_VARIANTS, WolfSoundVariants.CLASSIC));
        builder.method_56912(DATA_VARIANT_ID, (Object)"minecraft:pale");
    }

    @Inject(method={"addAdditionalSaveData"}, at={@At(value="RETURN")})
    private void vb$addAdditionalData(class_2487 tag, CallbackInfo ci) {
        VariantUtils.addVariantSaveData(this, tag, ModBuiltinRegistries.WOLF_VARIANTS);
        tag.method_10582("sound_variant", ModBuiltinRegistries.WOLF_SOUND_VARIANTS.getKey(this.getSoundVariant()).toString());
    }

    @Inject(method={"readAdditionalSaveData"}, at={@At(value="HEAD")})
    private void vb$readAdditionalData(class_2487 tag, CallbackInfo ci) {
        VariantUtils.readVariantSaveData(this, tag, ModBuiltinRegistries.WOLF_VARIANTS);
        WolfSoundVariant soundVariant = ModBuiltinRegistries.WOLF_SOUND_VARIANTS.get(class_2960.method_12829((String)tag.method_10558("sound_variant")));
        if (soundVariant != null) {
            this.setSoundVariant(soundVariant);
        }
    }

    @Override
    public WolfSoundVariant getSoundVariant() {
        return VariantUtils.getVariant(ModBuiltinRegistries.WOLF_SOUND_VARIANTS, (String)this.field_6011.method_12789(DATA_SOUND_VARIANT_ID));
    }

    @Override
    public void setSoundVariant(WolfSoundVariant variant) {
        this.field_6011.method_12778(DATA_SOUND_VARIANT_ID, (Object)VariantUtils.getID(ModBuiltinRegistries.WOLF_SOUND_VARIANTS, variant));
    }

    @Override
    public Optional<WolfDataVariant> getVariantData() {
        return VariantUtils.getOrDefault(ModBuiltinRegistries.WOLF_VARIANTS, (String)this.field_6011.method_12789(DATA_VARIANT_ID));
    }

    @Override
    public void setVariantData(WolfDataVariant variant) {
        this.field_6011.method_12778(DATA_VARIANT_ID, (Object)VariantUtils.getID(ModBuiltinRegistries.WOLF_VARIANTS, variant));
    }

    @Inject(method={"getAmbientSound"}, at={@At(value="HEAD")}, cancellable=true)
    public void vb$getAmbientSound(CallbackInfoReturnable<class_3414> cir) {
        class_3414 result = WolfSoundVariantsModule.getAmbientSound((class_1493)this);
        if (result != null) {
            cir.setReturnValue((Object)result);
        }
    }

    @Inject(method={"getHurtSound"}, at={@At(value="HEAD")}, cancellable=true)
    private void vb$getHurtSound(CallbackInfoReturnable<class_3414> cir) {
        class_3414 result = WolfSoundVariantsModule.getHurtSound((class_1493)this);
        if (result != null) {
            cir.setReturnValue((Object)result);
        }
    }

    @Inject(method={"getDeathSound"}, at={@At(value="HEAD")}, cancellable=true)
    private void vb$getDeathSound(CallbackInfoReturnable<class_3414> cir) {
        class_3414 result = WolfSoundVariantsModule.getDeathSound((class_1493)this);
        if (result != null) {
            cir.setReturnValue((Object)result);
        }
    }

    @Override
    protected void vb$finalizeSpawn(class_5425 level, class_1266 difficulty, class_3730 reason, class_1315 spawnData, CallbackInfoReturnable<class_1315> cir) {
        this.setSoundVariant(ModBuiltinRegistries.WOLF_SOUND_VARIANTS.getRandomElement(level.method_8409()));
        VariantUtils.selectVariantToSpawn(SpawnContext.create(level, this.method_24515()), ModBuiltinRegistries.WOLF_VARIANTS).ifPresent(this::setVariantData);
    }

    @Inject(method={"getBreedOffspring(Lnet/minecraft/server/level/ServerLevel;Lnet/minecraft/world/entity/AgeableMob;)Lnet/minecraft/world/entity/animal/Wolf;"}, at={@At(value="RETURN")})
    private void vb$getBreedOffspring(class_3218 level, class_1296 otherParent, CallbackInfoReturnable<class_1493> cir) {
        class_1493 child = (class_1493)cir.getReturnValue();
        if (child != null && otherParent instanceof class_1493) {
            class_1493 mate = (class_1493)otherParent;
            if (this.method_6181()) {
                class_1767 fatherColor = this.method_6713();
                class_1767 motherColor = mate.method_6713();
                ((WolfAccessor)child).callSetCollarColor(ColorUtils.getMixedColor(level, fatherColor, motherColor));
            }
            WolfSoundVariantHolder.of(child).setSoundVariant(ModBuiltinRegistries.WOLF_SOUND_VARIANTS.getRandomElement(this.method_59922()));
            VariantDataHolder.trySetOffspringVariant((class_1309)child, this, (class_1309)mate);
        }
    }
}

