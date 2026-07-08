/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.world.LocalDifficulty
 *  net.minecraft.entity.passive.PassiveEntity
 *  net.minecraft.entity.EntityType
 *  net.minecraft.entity.LivingEntity
 *  net.minecraft.entity.EntityData
 *  net.minecraft.entity.passive.AnimalEntity
 *  net.minecraft.entity.passive.CatEntity
 *  net.minecraft.util.DyeColor
 *  net.minecraft.world.World
 *  net.minecraft.nbt.NbtCompound
 *  net.minecraft.entity.data.TrackedData
 *  net.minecraft.entity.data.TrackedDataHandler
 *  net.minecraft.entity.data.TrackedDataHandlerRegistry
 *  net.minecraft.entity.data.DataTracker
 *  net.minecraft.entity.data.DataTracker$Builder
 *  net.minecraft.server.world.ServerWorld
 *  net.minecraft.entity.SpawnReason
 *  net.minecraft.world.ServerWorldAccess
 *  net.minecraft.registry.entry.RegistryEntry
 *  net.minecraft.entity.passive.CatVariant
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
import net.minecraft.world.LocalDifficulty;
import net.minecraft.entity.passive.PassiveEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.EntityData;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.passive.CatEntity;
import net.minecraft.util.DyeColor;
import net.minecraft.world.World;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.data.TrackedDataHandler;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.entity.SpawnReason;
import net.minecraft.world.ServerWorldAccess;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.entity.passive.CatVariant;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(value={CatEntity.class})
public abstract class CatMixin
extends TamableAnimalMixin
implements VariantDataHolder<CatDataVariant> {
    @Unique
    private static final TrackedData<String> DATA_VARIANT_ID = DataTracker.registerData(CatEntity.class, (TrackedDataHandler)TrackedDataHandlerRegistry.STRING);
    @Shadow
    @Final
    private static TrackedData<Integer> COLLAR_COLOR;

    @Shadow
    public abstract RegistryEntry<CatVariant> getVariant();

    @Shadow
    public abstract DyeColor getCollarColor();

    protected CatMixin(EntityType<? extends AnimalEntity> entityType, World level) {
        super(entityType, level);
    }

    @Override
    protected void vb$defineSynchedData(DataTracker.Builder builder, CallbackInfo ci) {
        builder.add(DATA_VARIANT_ID, "minecraft:tabby");
    }

    @Override
    public void setVariantData(CatDataVariant variant) {
        this.dataTracker.set(DATA_VARIANT_ID, VariantUtils.getID(ModBuiltinRegistries.CAT_VARIANTS, variant));
    }

    @Override
    public Optional<CatDataVariant> getVariantData() {
        return VariantUtils.getOrDefault(ModBuiltinRegistries.CAT_VARIANTS, (String)this.dataTracker.get(DATA_VARIANT_ID));
    }

    @Inject(method={"writeCustomDataToNbt"}, at={@At(value="RETURN")})
    private void vb$addAdditionalData(NbtCompound tag, CallbackInfo ci) {
        VariantUtils.addVariantSaveData(this, tag, ModBuiltinRegistries.CAT_VARIANTS);
    }

    @Inject(method={"readCustomDataFromNbt"}, at={@At(value="HEAD")})
    private void vb$readAdditionalData(NbtCompound tag, CallbackInfo ci) {
        VariantUtils.readVariantSaveData(this, tag, ModBuiltinRegistries.CAT_VARIANTS);
    }

    @Override
    protected void vb$finalizeSpawn(ServerWorldAccess level, LocalDifficulty difficulty, SpawnReason reason, EntityData spawnData, CallbackInfoReturnable<EntityData> cir) {
        VariantUtils.selectVariantToSpawn(SpawnContext.create(level, this.getBlockPos()), ModBuiltinRegistries.CAT_VARIANTS).ifPresent(this::setVariantData);
    }

    @Inject(method={"createChild"}, at={@At(value="RETURN")})
    private void vb$getBreedOffspring(ServerWorld level, PassiveEntity otherParent, CallbackInfoReturnable<CatEntity> cir) {
        CatEntity child = (CatEntity)cir.getReturnValue();
        if (child != null && otherParent instanceof CatEntity) {
            CatEntity mate = (CatEntity)otherParent;
            if (this.isTamed()) {
                DyeColor fatherColor = this.getCollarColor();
                DyeColor motherColor = mate.getCollarColor();
                child.getDataTracker().set(COLLAR_COLOR, ColorUtils.getMixedColor(level, fatherColor, motherColor).getId());
            }
            VariantDataHolder.trySetOffspringVariant((LivingEntity)child, this, (LivingEntity)mate);
        }
    }
}

