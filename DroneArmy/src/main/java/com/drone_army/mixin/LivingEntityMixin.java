package com.drone_army.mixin;

import com.drone_army.item.EssenceItem;
import com.drone_army.registry.ModItems;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.passive.PassiveEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.registry.Registries;
import net.minecraft.util.Identifier;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.component.type.NbtComponent;

@Mixin(LivingEntity.class)
public abstract class LivingEntityMixin extends Entity {

    public LivingEntityMixin(EntityType<?> type, World world) {
        super(type, world);
    }

    @Inject(method = "dropLoot", at = @At("TAIL"))
    private void dropEssence(DamageSource source, boolean causedByPlayer, CallbackInfo ci) {
        if (!causedByPlayer || this.getWorld().isClient)
            return;

        LivingEntity entity = (LivingEntity) (Object) this;

        // Check if passive
        if (entity instanceof PassiveEntity)
            return;

        // Check if has attack damage attribute
        if (!entity.getAttributes().hasAttribute(EntityAttributes.GENERIC_ATTACK_DAMAGE))
            return;

        if (this.random.nextFloat() > com.drone_army.config.ModConfig.get().essenceDropChance)
            return;

        ItemStack essence = new ItemStack(ModItems.ESSENCE);
        NbtCompound nbt = essence.getOrDefault(DataComponentTypes.CUSTOM_DATA, NbtComponent.DEFAULT).copyNbt();
        NbtCompound essenceData = new NbtCompound();

        // Capture Entity ID
        Identifier id = Registries.ENTITY_TYPE.getId(entity.getType());
        essenceData.putString(EssenceItem.ENTITY_ID_KEY, id.toString());

        // Capture Full NBT
        NbtCompound entityNbt = new NbtCompound();
        entity.writeNbt(entityNbt);

        // Remove UUID to allow fresh spawning
        entityNbt.remove("UUID");
        entityNbt.remove("Pos");
        entityNbt.remove("Motion");
        entityNbt.remove("Rotation");

        // Remove Control Data (so crafted eggs spawn Wild/Hostile mobs)
        entityNbt.remove("OwnerUUID");
        entityNbt.remove("CommandMode");
        entityNbt.remove("IsControlled");

        essenceData.put("EntityTag", entityNbt);

        nbt.put(EssenceItem.ESSENCE_KEY, essenceData);
        essence.set(DataComponentTypes.CUSTOM_DATA, NbtComponent.of(nbt));

        this.dropStack(essence);
    }
}
