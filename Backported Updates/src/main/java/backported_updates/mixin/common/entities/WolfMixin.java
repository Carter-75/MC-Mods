/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.world.LocalDifficulty
 *  net.minecraft.entity.passive.PassiveEntity
 *  net.minecraft.entity.EntityType
 *  net.minecraft.entity.LivingEntity
 *  net.minecraft.entity.EntityData
 *  net.minecraft.entity.passive.WolfEntity
 *  net.minecraft.util.DyeColor
 *  net.minecraft.world.World
 *  net.minecraft.nbt.NbtCompound
 *  net.minecraft.entity.data.TrackedData
 *  net.minecraft.entity.data.TrackedDataHandler
 *  net.minecraft.entity.data.TrackedDataHandlerRegistry
 *  net.minecraft.entity.data.DataTracker
 *  net.minecraft.entity.data.DataTracker$Builder
 *  net.minecraft.util.Identifier
 *  net.minecraft.server.world.ServerWorld
 *  net.minecraft.sound.SoundEvent
 *  net.minecraft.entity.SpawnReason
 *  net.minecraft.entity.mob.Angerable
 *  net.minecraft.world.ServerWorldAccess
 *  net.minecraft.registry.entry.RegistryEntry
 *  net.minecraft.entity.passive.WolfVariant
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
import net.minecraft.world.LocalDifficulty;
import net.minecraft.entity.passive.PassiveEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.EntityData;
import net.minecraft.entity.passive.WolfEntity;
import net.minecraft.util.DyeColor;
import net.minecraft.world.World;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.data.TrackedDataHandler;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.util.Identifier;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundEvent;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.mob.Angerable;
import net.minecraft.world.ServerWorldAccess;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.entity.passive.WolfVariant;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(value={WolfEntity.class})
public abstract class WolfMixin
extends TamableAnimalMixin
implements Angerable,
WolfSoundVariantHolder,
VariantDataHolder<WolfDataVariant> {
    @Unique
    private static TrackedData<String> DATA_SOUND_VARIANT_ID;
    @Unique
    private static TrackedData<String> DATA_VARIANT_ID;

    @Shadow
    public abstract DyeColor getCollarColor();

    @Shadow
    public abstract RegistryEntry<WolfVariant> getVariant();

    protected WolfMixin(EntityType<? extends LivingEntity> entityType, World level) {
        super(entityType, level);
    }

    @Inject(method={"<clinit>"}, at={@At(value="TAIL")})
    private static void vb$registerAccessor(CallbackInfo ci) {
        DATA_SOUND_VARIANT_ID = DataTracker.registerData(WolfEntity.class, (TrackedDataHandler)TrackedDataHandlerRegistry.STRING);
        DATA_VARIANT_ID = DataTracker.registerData(WolfEntity.class, (TrackedDataHandler)TrackedDataHandlerRegistry.STRING);
    }

    @Override
    protected void vb$defineSynchedData(DataTracker.Builder builder, CallbackInfo ci) {
        builder.add(DATA_SOUND_VARIANT_ID, VariantUtils.getDefaultID(ModBuiltinRegistries.WOLF_SOUND_VARIANTS, WolfSoundVariants.CLASSIC));
        builder.add(DATA_VARIANT_ID, "minecraft:pale");
    }

    @Inject(method={"writeCustomDataToNbt"}, at={@At(value="RETURN")})
    private void vb$addAdditionalData(NbtCompound tag, CallbackInfo ci) {
        VariantUtils.addVariantSaveData(this, tag, ModBuiltinRegistries.WOLF_VARIANTS);
        tag.putString("sound_variant", ModBuiltinRegistries.WOLF_SOUND_VARIANTS.getKey(this.getSoundVariant()).toString());
    }

    @Inject(method={"readCustomDataFromNbt"}, at={@At(value="HEAD")})
    private void vb$readAdditionalData(NbtCompound tag, CallbackInfo ci) {
        VariantUtils.readVariantSaveData(this, tag, ModBuiltinRegistries.WOLF_VARIANTS);
        WolfSoundVariant soundVariant = ModBuiltinRegistries.WOLF_SOUND_VARIANTS.get(Identifier.tryParse((String)tag.getString("sound_variant")));
        if (soundVariant != null) {
            this.setSoundVariant(soundVariant);
        }
    }

    @Override
    public WolfSoundVariant getSoundVariant() {
        return VariantUtils.getVariant(ModBuiltinRegistries.WOLF_SOUND_VARIANTS, (String)this.dataTracker.get(DATA_SOUND_VARIANT_ID));
    }

    @Override
    public void setSoundVariant(WolfSoundVariant variant) {
        this.dataTracker.set(DATA_SOUND_VARIANT_ID, VariantUtils.getID(ModBuiltinRegistries.WOLF_SOUND_VARIANTS, variant));
    }

    @Override
    public Optional<WolfDataVariant> getVariantData() {
        return VariantUtils.getOrDefault(ModBuiltinRegistries.WOLF_VARIANTS, (String)this.dataTracker.get(DATA_VARIANT_ID));
    }

    @Override
    public void setVariantData(WolfDataVariant variant) {
        this.dataTracker.set(DATA_VARIANT_ID, VariantUtils.getID(ModBuiltinRegistries.WOLF_VARIANTS, variant));
    }

    @Inject(method={"getAmbientSound"}, at={@At(value="HEAD")}, cancellable=true)
    public void vb$getAmbientSound(CallbackInfoReturnable<SoundEvent> cir) {
        SoundEvent result = WolfSoundVariantsModule.getAmbientSound((WolfEntity)(Object)this);
        if (result != null) {
            cir.setReturnValue(result);
        }
    }

    @Inject(method={"getHurtSound"}, at={@At(value="HEAD")}, cancellable=true)
    private void vb$getHurtSound(CallbackInfoReturnable<SoundEvent> cir) {
        SoundEvent result = WolfSoundVariantsModule.getHurtSound((WolfEntity)(Object)this);
        if (result != null) {
            cir.setReturnValue(result);
        }
    }

    @Inject(method={"getDeathSound"}, at={@At(value="HEAD")}, cancellable=true)
    private void vb$getDeathSound(CallbackInfoReturnable<SoundEvent> cir) {
        SoundEvent result = WolfSoundVariantsModule.getDeathSound((WolfEntity)(Object)this);
        if (result != null) {
            cir.setReturnValue(result);
        }
    }

    @Override
    protected void vb$finalizeSpawn(ServerWorldAccess level, LocalDifficulty difficulty, SpawnReason reason, EntityData spawnData, CallbackInfoReturnable<EntityData> cir) {
        this.setSoundVariant(ModBuiltinRegistries.WOLF_SOUND_VARIANTS.getRandomElement(level.getRandom()));
        VariantUtils.selectVariantToSpawn(SpawnContext.create(level, this.getBlockPos()), ModBuiltinRegistries.WOLF_VARIANTS).ifPresent(this::setVariantData);
    }

    @Inject(method={"createChild"}, at={@At(value="RETURN")})
    private void vb$getBreedOffspring(ServerWorld level, PassiveEntity otherParent, CallbackInfoReturnable<WolfEntity> cir) {
        WolfEntity child = (WolfEntity)cir.getReturnValue();
        if (child != null && otherParent instanceof WolfEntity) {
            WolfEntity mate = (WolfEntity)otherParent;
            if (this.isTamed()) {
                DyeColor fatherColor = this.getCollarColor();
                DyeColor motherColor = mate.getCollarColor();
                ((WolfAccessor)child).callSetCollarColor(ColorUtils.getMixedColor(level, fatherColor, motherColor));
            }
            WolfSoundVariantHolder.of(child).setSoundVariant(ModBuiltinRegistries.WOLF_SOUND_VARIANTS.getRandomElement(this.getRandom()));
            VariantDataHolder.trySetOffspringVariant((LivingEntity)child, this, (LivingEntity)mate);
        }
    }
}

