/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.world.LocalDifficulty
 *  net.minecraft.entity.passive.PassiveEntity
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.EntityType
 *  net.minecraft.entity.LivingEntity
 *  net.minecraft.entity.EntityData
 *  net.minecraft.entity.passive.ChickenEntity
 *  net.minecraft.entity.passive.AnimalEntity
 *  net.minecraft.item.ItemStack
 *  net.minecraft.item.Items
 *  net.minecraft.item.ItemConvertible
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
 *  org.spongepowered.asm.mixin.injection.ModifyArg
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfo
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable
 */
package backported_updates.mixin.common.entities;

import backported.updates.content.common.api.variant.VariantDataHolder;
import backported.updates.content.common.api.variant.VariantSpawner;
import backported.updates.content.common.api.variant.VariantUtils;
import backported.updates.content.common.api.variant.spawn.SpawnContext;
import backported.updates.content.common.level.entities.animal.ChickenVariant;
import backported.updates.content.common.level.entities.animal.ChickenVariants;
import backported.updates.content.core.registries.ModBuiltInLootTables;
import backported.updates.content.core.registries.ModBuiltinRegistries;
import backported.updates.content.core.util.LootUtils;
import backported_updates.mixin.common.entities.MobMixin;
import java.util.Optional;
import net.minecraft.world.LocalDifficulty;
import net.minecraft.entity.passive.PassiveEntity;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.EntityData;
import net.minecraft.entity.passive.ChickenEntity;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.ItemConvertible;
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
import org.spongepowered.asm.mixin.injection.ModifyArg;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(value={ChickenEntity.class})
public abstract class ChickenMixin
extends MobMixin
implements VariantDataHolder<ChickenVariant> {
    @Unique
    private static final TrackedData<String> DATA_VARIANT_ID = DataTracker.registerData(ChickenEntity.class, (TrackedDataHandler)TrackedDataHandlerRegistry.STRING);

    protected ChickenMixin(EntityType<? extends AnimalEntity> entityType, World level) {
        super(entityType, level);
    }

    @Inject(method={"createChild"}, at={@At(value="RETURN")})
    private void vb$getBreedOffspring(ServerWorld level, PassiveEntity otherParent, CallbackInfoReturnable<ChickenEntity> cir) {
        ChickenEntity child = (ChickenEntity)cir.getReturnValue();
        if (child != null && otherParent instanceof ChickenEntity) {
            ChickenEntity mate = (ChickenEntity)otherParent;
            VariantDataHolder.trySetOffspringVariant((LivingEntity)child, this, (LivingEntity)mate);
        }
    }

    @Override
    protected void vb$defineSynchedData(DataTracker.Builder builder, CallbackInfo ci) {
        builder.add(DATA_VARIANT_ID, "minecraft:temperate");
    }

    @Override
    public void setVariantData(ChickenVariant variant) {
        this.dataTracker.set(DATA_VARIANT_ID, VariantUtils.getID(ModBuiltinRegistries.CHICKEN_VARIANTS, variant));
    }

    @Override
    public Optional<ChickenVariant> getVariantData() {
        return VariantUtils.getOrDefault(ModBuiltinRegistries.CHICKEN_VARIANTS, (String)this.dataTracker.get(DATA_VARIANT_ID));
    }

    @Override
    protected void vb$addAdditionalSaveData(NbtCompound tag, CallbackInfo ci) {
        VariantUtils.addVariantSaveData(this, tag, ModBuiltinRegistries.CHICKEN_VARIANTS);
    }

    @Override
    protected void vb$readAdditionalSaveData(NbtCompound tag, CallbackInfo ci) {
        VariantUtils.readVariantSaveData(this, tag, ModBuiltinRegistries.CHICKEN_VARIANTS);
    }

    @Override
    protected void vb$finalizeSpawn(ServerWorldAccess level, LocalDifficulty difficulty, SpawnReason reason, EntityData spawnData, CallbackInfoReturnable<EntityData> cir) {
        VariantUtils.selectVariantToSpawn(SpawnContext.create(level, this.getBlockPos()), ModBuiltinRegistries.CHICKEN_VARIANTS, VariantSpawner.FARM_ANIMALS).ifPresent(this::setVariantData);
    }

    @ModifyArg(method={"tickMovement"}, at=@At(value="INVOKE", target="Lnet/minecraft/entity/passive/ChickenEntity;dropItem(Lnet/minecraft/item/ItemConvertible;)Lnet/minecraft/entity/ItemEntity;"), index=0)
    private ItemConvertible vb$modifyEggDrop(ItemConvertible originalItem) {
        Optional<ChickenVariant> variant = this.getVariantData();
        if (variant.isPresent() && !VariantUtils.matches(ModBuiltinRegistries.CHICKEN_VARIANTS, variant.get(), ChickenVariants.TEMPERATE) && LootUtils.dropFromGiftLootTable((Entity)this, (ServerWorld)this.getWorld(), ModBuiltInLootTables.CHICKEN_LAY, (level, stack) -> this.dropStack((ItemStack)stack))) {
            return Items.AIR;
        }
        return originalItem;
    }
}

