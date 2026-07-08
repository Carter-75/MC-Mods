/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.world.LocalDifficulty
 *  net.minecraft.entity.EntityType
 *  net.minecraft.entity.EntityData
 *  net.minecraft.entity.passive.AnimalEntity
 *  net.minecraft.world.World
 *  net.minecraft.nbt.NbtCompound
 *  net.minecraft.entity.data.TrackedData
 *  net.minecraft.entity.data.TrackedDataHandler
 *  net.minecraft.entity.data.TrackedDataHandlerRegistry
 *  net.minecraft.entity.data.DataTracker
 *  net.minecraft.entity.data.DataTracker$Builder
 *  net.minecraft.entity.SpawnReason
 *  net.minecraft.world.ServerWorldAccess
 *  net.minecraft.registry.entry.RegistryEntry
 *  net.minecraft.entity.passive.FrogEntity
 *  net.minecraft.entity.passive.FrogVariant
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
import backported.updates.content.common.level.entities.animal.FrogDataVariant;
import backported.updates.content.core.registries.ModBuiltinRegistries;
import backported_updates.mixin.common.entities.MobMixin;
import java.util.Optional;
import net.minecraft.world.LocalDifficulty;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.EntityData;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.world.World;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.data.TrackedDataHandler;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.SpawnReason;
import net.minecraft.world.ServerWorldAccess;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.entity.passive.FrogEntity;
import net.minecraft.entity.passive.FrogVariant;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(value={FrogEntity.class})
public abstract class FrogMixin
extends MobMixin
implements VariantDataHolder<FrogDataVariant> {
    @Unique
    private static final TrackedData<String> DATA_VARIANT_ID = DataTracker.registerData(FrogEntity.class, (TrackedDataHandler)TrackedDataHandlerRegistry.STRING);

    @Shadow
    public abstract RegistryEntry<FrogVariant> getVariant();

    protected FrogMixin(EntityType<? extends AnimalEntity> entityType, World level) {
        super(entityType, level);
    }

    @Override
    protected void vb$defineSynchedData(DataTracker.Builder builder, CallbackInfo ci) {
        builder.add(DATA_VARIANT_ID, "minecraft:temperate");
    }

    @Override
    public void setVariantData(FrogDataVariant variant) {
        this.dataTracker.set(DATA_VARIANT_ID, VariantUtils.getID(ModBuiltinRegistries.FROG_VARIANTS, variant));
    }

    @Override
    public Optional<FrogDataVariant> getVariantData() {
        return VariantUtils.getOrDefault(ModBuiltinRegistries.FROG_VARIANTS, (String)this.dataTracker.get(DATA_VARIANT_ID));
    }

    @Inject(method={"writeCustomDataToNbt"}, at={@At(value="RETURN")})
    private void vb$addAdditionalData(NbtCompound tag, CallbackInfo ci) {
        VariantUtils.addVariantSaveData(this, tag, ModBuiltinRegistries.FROG_VARIANTS);
    }

    @Inject(method={"readCustomDataFromNbt"}, at={@At(value="HEAD")})
    private void vb$readAdditionalData(NbtCompound tag, CallbackInfo ci) {
        VariantUtils.readVariantSaveData(this, tag, ModBuiltinRegistries.FROG_VARIANTS);
    }

    @Override
    protected void vb$finalizeSpawn(ServerWorldAccess level, LocalDifficulty difficulty, SpawnReason reason, EntityData spawnData, CallbackInfoReturnable<EntityData> cir) {
        VariantUtils.selectVariantToSpawn(SpawnContext.create(level, this.getBlockPos()), ModBuiltinRegistries.FROG_VARIANTS).ifPresent(this::setVariantData);
    }
}

