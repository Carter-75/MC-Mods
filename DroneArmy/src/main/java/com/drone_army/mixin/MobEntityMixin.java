package com.drone_army.mixin;

import net.minecraft.entity.damage.DamageSource;
import org.spongepowered.asm.mixin.Unique;
import com.drone_army.entity.CommandMode;
import com.drone_army.entity.ControlledMob;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.UUID;

@Mixin(MobEntity.class)
public abstract class MobEntityMixin extends net.minecraft.entity.LivingEntity implements ControlledMob {
    @Unique
    private UUID ownerUuid;
    @Unique
    private CommandMode commandMode = CommandMode.FOLLOW;
    @Unique
    private boolean isControlled = false;

    protected MobEntityMixin(EntityType<? extends net.minecraft.entity.LivingEntity> entityType, World world) {
        super(entityType, world);
    }

    @Override
    public void setOwnerUuid(UUID uuid) {
        this.ownerUuid = uuid;
        this.isControlled = (uuid != null);
    }

    @Override
    public UUID getOwnerUuid() {
        return ownerUuid;
    }

    @Override
    public void setCommandMode(CommandMode mode) {
        this.commandMode = mode;
    }

    @Override
    public CommandMode getCommandMode() {
        return commandMode;
    }

    @Override
    public boolean isControlled() {
        return isControlled;
    }

    @Override
    public void setControllerStackId(UUID id) {
        // Implementation logic if needed
    }

    @org.spongepowered.asm.mixin.Shadow
    protected net.minecraft.entity.ai.goal.GoalSelector goalSelector;
    @org.spongepowered.asm.mixin.Shadow
    protected net.minecraft.entity.ai.goal.GoalSelector targetSelector;

    @Inject(method = "initGoals", at = @At("HEAD"))
    private void addDroneGoals(CallbackInfo ci) {
        if ((Object) this instanceof net.minecraft.entity.mob.PathAwareEntity pathAwareMob) {
            // Priority 6: Follow Owner
            this.goalSelector.add(6, new com.drone_army.entity.ai.DroneFollowGoal(pathAwareMob, 1.25D, 10.0F, 5.0F));
        }

        // Priority 2: Target Enemies
        this.targetSelector.add(2, new com.drone_army.entity.ai.DroneTargetGoal<>((MobEntity) (Object) this,
                net.minecraft.entity.mob.HostileEntity.class, true));
        this.targetSelector.add(3, new com.drone_army.entity.ai.DroneTargetGoal<>((MobEntity) (Object) this,
                net.minecraft.entity.player.PlayerEntity.class, true));
    }

    @Inject(method = "dropLoot", at = @At("HEAD"))
    private void onControlledDeath(DamageSource damageSource, boolean causedByPlayer, CallbackInfo ci) {
        if (!this.getWorld().isClient && this.isControlled && this.ownerUuid != null) {
            // Logic to find controller and start cooldown
            net.minecraft.server.network.ServerPlayerEntity player = this.getWorld().getServer().getPlayerManager()
                    .getPlayer(this.ownerUuid);
            if (player != null) {
                // Scan inventory
                for (int i = 0; i < player.getInventory().size(); i++) {
                    net.minecraft.item.ItemStack stack = player.getInventory().getStack(i);
                    if (stack.getItem() instanceof com.drone_army.item.ControllerItem) {
                        net.minecraft.nbt.NbtCompound nbt = stack
                                .getOrDefault(net.minecraft.component.DataComponentTypes.CUSTOM_DATA,
                                        net.minecraft.component.type.NbtComponent.DEFAULT)
                                .copyNbt();
                        if (nbt != null && nbt.contains(com.drone_army.item.ControllerItem.ACTIVE_UNITS_KEY)) {
                            net.minecraft.nbt.NbtList units = nbt.getList(
                                    com.drone_army.item.ControllerItem.ACTIVE_UNITS_KEY,
                                    net.minecraft.nbt.NbtElement.COMPOUND_TYPE);
                            boolean found = false;
                            for (int j = 0; j < units.size(); j++) {
                                net.minecraft.nbt.NbtCompound u = units.getCompound(j);
                                if (u.contains("UUID") && u.getUuid("UUID").equals(this.getUuid())) {
                                    // Found it. Set Cooldown.
                                    u.putLong(com.drone_army.item.ControllerItem.COOLDOWN_KEY, this.getWorld().getTime()
                                            + com.drone_army.item.ControllerItem.getCooldownTicks());
                                    found = true;
                                    player.sendMessage(
                                            net.minecraft.text.Text.literal("Unit lost! 10m cooldown started."), true);
                                    break;
                                }
                            }
                            if (found) {
                                stack.set(net.minecraft.component.DataComponentTypes.CUSTOM_DATA,
                                        net.minecraft.component.type.NbtComponent.of(nbt));
                                break;
                            }
                        }
                    }
                }
            }
        }
    }

    @Inject(method = "writeCustomDataToNbt", at = @At("TAIL"))
    private void writeControlledData(NbtCompound nbt, CallbackInfo ci) {
        if (this.isControlled && this.ownerUuid != null) {
            nbt.putUuid("OwnerUUID", this.ownerUuid);
            nbt.putString("CommandMode", this.commandMode.name());
            nbt.putBoolean("IsControlled", true);
        }
    }

    @Inject(method = "readCustomDataFromNbt", at = @At("TAIL"))
    private void readControlledData(NbtCompound nbt, CallbackInfo ci) {
        if (nbt.contains("OwnerUUID")) {
            this.ownerUuid = nbt.getUuid("OwnerUUID");
            this.isControlled = true;
        }
        if (nbt.contains("CommandMode")) {
            try {
                this.commandMode = CommandMode.valueOf(nbt.getString("CommandMode"));
            } catch (IllegalArgumentException e) {
                this.commandMode = CommandMode.FOLLOW;
            }
        }
    }

    // Safety check: Prevent despawning if controlled?
    // "Cannot naturally despawn" -> setPersistent() logic is usually handled by
    // vanilla persistence field.
    // I should ensure setPersistent() is called when deployed.
}
