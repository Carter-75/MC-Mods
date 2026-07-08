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
 *  net.minecraft.entity.passive.CowEntity
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
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.Unique
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfo
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable
 */
package backported_updates.mixin.common.entities;

import backported.updates.content.common.api.variant.VariantDataHolder;
import backported.updates.content.common.api.variant.VariantSpawner;
import backported.updates.content.common.api.variant.VariantUtils;
import backported.updates.content.common.api.variant.spawn.SpawnContext;
import backported.updates.content.common.level.entities.animal.CowVariant;
import backported.updates.content.core.registries.ModBuiltinRegistries;
import backported_updates.mixin.common.entities.MobMixin;
import java.util.Optional;
import net.minecraft.world.LocalDifficulty;
import net.minecraft.entity.passive.PassiveEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.EntityData;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.passive.CowEntity;
import net.minecraft.world.World;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.data.TrackedDataHandler;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.entity.SpawnReason;
import net.minecraft.world.ServerWorldAccess;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(value={CowEntity.class})
public abstract class CowMixin
extends MobMixin
implements VariantDataHolder<CowVariant> {
    @Unique
    private static final TrackedData<String> DATA_VARIANT_ID = DataTracker.registerData(CowEntity.class, (TrackedDataHandler)TrackedDataHandlerRegistry.STRING);

    protected CowMixin(EntityType<? extends AnimalEntity> entityType, World level) {
        super(entityType, level);
    }

    @Inject(method={"createChild"}, at={@At(value="RETURN")})
    private void vb$getBreedOffspring(ServerWorld level, PassiveEntity otherParent, CallbackInfoReturnable<CowEntity> cir) {
        CowEntity child = (CowEntity)cir.getReturnValue();
        if (child != null && otherParent instanceof CowEntity) {
            CowEntity mate = (CowEntity)otherParent;
            VariantDataHolder.trySetOffspringVariant((LivingEntity)child, this, (LivingEntity)mate);
        }
    }

    @Override
    protected void vb$defineSynchedData(DataTracker.Builder builder, CallbackInfo ci) {
        builder.add(DATA_VARIANT_ID, "minecraft:temperate");
    }

    @Override
    public void setVariantData(CowVariant variant) {
        this.dataTracker.set(DATA_VARIANT_ID, VariantUtils.getID(ModBuiltinRegistries.COW_VARIANTS, variant));
    }

    @Override
    public Optional<CowVariant> getVariantData() {
        return VariantUtils.getOrDefault(ModBuiltinRegistries.COW_VARIANTS, (String)this.dataTracker.get(DATA_VARIANT_ID));
    }

    @Override
    protected void vb$addAdditionalSaveData(NbtCompound tag, CallbackInfo ci) {
        VariantUtils.addVariantSaveData(this, tag, ModBuiltinRegistries.COW_VARIANTS);
    }

    @Override
    protected void vb$readAdditionalSaveData(NbtCompound tag, CallbackInfo ci) {
        VariantUtils.readVariantSaveData(this, tag, ModBuiltinRegistries.COW_VARIANTS);
    }

    @Override
    protected void vb$finalizeSpawn(ServerWorldAccess level, LocalDifficulty difficulty, SpawnReason reason, EntityData spawnData, CallbackInfoReturnable<EntityData> cir) {
        VariantUtils.selectVariantToSpawn(SpawnContext.create(level, this.getBlockPos()), ModBuiltinRegistries.COW_VARIANTS, VariantSpawner.FARM_ANIMALS).ifPresent(this::setVariantData);
    }
}

