package com.drone_army.item;

import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.Inventories;
import net.minecraft.inventory.Inventory;
import net.minecraft.inventory.SimpleInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.nbt.NbtElement;
import net.minecraft.nbt.NbtList;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.network.RegistryByteBuf;
import net.minecraft.screen.ScreenHandler;
import net.fabricmc.fabric.api.screenhandler.v1.ExtendedScreenHandlerFactory;
import net.minecraft.text.Text;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.world.World;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import com.drone_army.client.gui.ControllerScreenHandler;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.util.Identifier;
import net.minecraft.item.SpawnEggItem;
import com.drone_army.entity.ControlledMob;
import com.drone_army.entity.CommandMode;
import net.minecraft.registry.Registries;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.component.type.NbtComponent;

public class ControllerItem extends Item {
    private final int maxUnits;

    public ControllerItem(int maxUnits, Settings settings) {
        super(settings);
        this.maxUnits = maxUnits;
    }

    public int getMaxUnits() {
        return maxUnits;
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        ItemStack stack = user.getStackInHand(hand);

        if (user.isSneaking()) {
            if (!world.isClient) {
                user.openHandledScreen(
                        new ExtendedScreenHandlerFactory<ControllerScreenHandler.ControllerScreenData>() {
                            @Override
                            public Text getDisplayName() {
                                return stack.getName();
                            }

                            @Override
                            public ScreenHandler createMenu(int syncId, PlayerInventory inv, PlayerEntity player) {
                                return new ControllerScreenHandler(syncId, inv, getInventory(stack), stack);
                            }

                            @Override
                            public ControllerScreenHandler.ControllerScreenData getScreenOpeningData(
                                    ServerPlayerEntity player) {
                                return new ControllerScreenHandler.ControllerScreenData(stack);
                            }
                        });
            }
            return TypedActionResult.success(stack);
        } else {
            // Deploy Unit
            if (!world.isClient) {
                deployNextUnit(world, user, stack);
            }
            return TypedActionResult.success(stack);
        }
    }

    @Override
    public net.minecraft.util.ActionResult useOnEntity(ItemStack stack, PlayerEntity user, LivingEntity entity,
            Hand hand) {
        if (user.isSneaking() && entity instanceof ControlledMob controlled) {
            if (user.getUuid().equals(controlled.getOwnerUuid())) {
                if (!user.getWorld().isClient) {
                    CommandMode next = controlled.getCommandMode().next();
                    controlled.setCommandMode(next);
                    user.sendMessage(Text.literal("Command Mode: " + next.name()), true);
                }
                return net.minecraft.util.ActionResult.SUCCESS;
            }
        }
        return net.minecraft.util.ActionResult.PASS;
    }

    public static Inventory getInventory(ItemStack stack) {
        int size = 27;
        if (stack.getItem() instanceof ControllerItem ci) {
            size = ci.getMaxUnits();
        }

        // Ensure size is at least 1 to avoid crashes, though maxUnits should be >= 1
        if (size < 1)
            size = 1;
        final int inventorySize = size;

        SimpleInventory inventory = new SimpleInventory(inventorySize) {
            @Override
            public void markDirty() {
                super.markDirty();
                NbtCompound nbt = stack.getOrDefault(DataComponentTypes.CUSTOM_DATA, NbtComponent.DEFAULT).copyNbt();

                DefaultedList<ItemStack> list = DefaultedList.ofSize(inventorySize, ItemStack.EMPTY);
                for (int i = 0; i < inventorySize; i++) {
                    list.set(i, this.getStack(i));
                }
                Inventories.writeNbt(nbt, list, createRegistryLookup());
                stack.set(DataComponentTypes.CUSTOM_DATA, NbtComponent.of(nbt));
            }
        };

        NbtCompound nbt = stack.getOrDefault(DataComponentTypes.CUSTOM_DATA, NbtComponent.DEFAULT).copyNbt();
        DefaultedList<ItemStack> list = DefaultedList.ofSize(inventorySize, ItemStack.EMPTY);
        Inventories.readNbt(nbt, list, createRegistryLookup());
        for (int i = 0; i < inventorySize; i++) {
            inventory.setStack(i, list.get(i));
        }

        return inventory;
    }

    private static net.minecraft.registry.RegistryWrapper.WrapperLookup createRegistryLookup() {
        return net.minecraft.registry.RegistryWrapper.WrapperLookup.of(java.util.stream.Stream.of());
    }

    public static final String ACTIVE_UNITS_KEY = "ActiveUnits";
    public static final String COOLDOWN_KEY = "Cooldown";

    public static int getCooldownTicks() {
        return 20 * 60 * com.drone_army.config.ModConfig.get().unitCooldownMinutes;
    }

    @Override
    public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected) {
        if (!world.isClient) {
            tickCooldowns(stack, world);
        }
    }

    private void tickCooldowns(ItemStack stack, World world) {
        NbtCompound nbt = stack.getOrDefault(DataComponentTypes.CUSTOM_DATA, NbtComponent.DEFAULT).copyNbt();
        if (!nbt.contains(ACTIVE_UNITS_KEY))
            return;

        NbtList units = nbt.getList(ACTIVE_UNITS_KEY, NbtElement.COMPOUND_TYPE);
        boolean dirty = false;

        for (int i = units.size() - 1; i >= 0; i--) {
            NbtCompound unit = units.getCompound(i);
            if (unit.contains(COOLDOWN_KEY)) {
                long readyTime = unit.getLong(COOLDOWN_KEY);
                if (world.getTime() >= readyTime) {
                    // Cooldown finished, recover as item
                    if (recoverUnitToInventory(stack, unit)) {
                        units.remove(i);
                        dirty = true;
                    }
                }
            }
        }

        if (dirty) {
            nbt.put(ACTIVE_UNITS_KEY, units);
            stack.set(DataComponentTypes.CUSTOM_DATA, NbtComponent.of(nbt));
        }
    }

    private boolean recoverUnitToInventory(ItemStack stack, NbtCompound unitData) {
        Inventory inv = getInventory(stack);
        // Create spawn egg from stored data
        // We need to resolve the ID to an Item
        if (unitData.contains("Data")) {
            NbtCompound data = unitData.getCompound("Data");
            // Logic to create egg stack.
            // We need to know the EntityType ID.
            if (data.contains("id")) {
                // ... This requires parsing the entity ID from the stored entity data
                // For now, let's assume we can reconstruct it or use Essence logic
                // But wait, we need the matching Spawn Egg Item.
                // Simpler: Just reconstruct the exact stack if we stored it?
                // Or reconstruct from EntityType.
                String id = data.getString("id");
                // Find SpawnEgg
                // ... logic to find spawn egg item ...
                // For MVP, fallback to generic or find item.
                // Let's create an Essence Item as fallback if egg resolution fails?
                // Or best effort SpawnEgg.

                ItemStack result = ItemStack.EMPTY;
                // Attempt lookup
                Identifier entityId = Identifier.tryParse(id);
                if (entityId != null) {
                    net.minecraft.entity.EntityType<?> type = Registries.ENTITY_TYPE.get(entityId);
                    if (type != null) {
                        SpawnEggItem egg = SpawnEggItem.forEntity(type);
                        if (egg != null) {
                            result = new ItemStack(egg);
                            // Restore NBT? "EntityTag"
                            // Sanitize to ensure it's "Wild" if placed manually
                            data.remove("OwnerUUID");
                            data.remove("CommandMode");
                            data.remove("IsControlled");
                            data.remove("UUID");
                            data.remove("Pos");
                            data.remove("Motion");
                            data.remove("Rotation");

                            NbtCompound nbt = result.getOrDefault(DataComponentTypes.CUSTOM_DATA, NbtComponent.DEFAULT)
                                    .copyNbt();
                            nbt.put("EntityTag", data);
                            result.set(DataComponentTypes.CUSTOM_DATA, NbtComponent.of(nbt));
                        }
                    }
                }

                if (!result.isEmpty()) {
                    // Try add to inventory
                    for (int i = 0; i < inv.size(); i++) {
                        if (inv.getStack(i).isEmpty()) {
                            inv.setStack(i, result);
                            inv.markDirty(); // Saves to NBT
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    private void deployNextUnit(World world, PlayerEntity user, ItemStack stack) {
        NbtCompound nbt = stack.getOrDefault(DataComponentTypes.CUSTOM_DATA, NbtComponent.DEFAULT).copyNbt();
        NbtList activeUnits = nbt.getList(ACTIVE_UNITS_KEY, NbtElement.COMPOUND_TYPE);

        // 1. Check Limits
        if (activeUnits.stream().filter(u -> !((NbtCompound) u).contains(COOLDOWN_KEY)).count() >= maxUnits) {
            // Recall oldest
            recallOldestUnit(world, user, activeUnits, stack);
            // Refresh list as it might have changed
            nbt = stack.getOrDefault(DataComponentTypes.CUSTOM_DATA, NbtComponent.DEFAULT).copyNbt();
            activeUnits = nbt.getList(ACTIVE_UNITS_KEY, NbtElement.COMPOUND_TYPE);
        }

        // 2. Find Spawn Egg in Inventory
        Inventory inv = getInventory(stack);
        int slot = -1;
        for (int i = 0; i < inv.size(); i++) {
            ItemStack s = inv.getStack(i);
            if (!s.isEmpty() && s.getItem() instanceof SpawnEggItem) {
                slot = i;
                break;
            }
        }

        if (slot != -1) {
            ItemStack eggStack = inv.getStack(slot);
            // 3. Spawn
            // Use standard SpawnEgg logic or custom?
            // Custom to ensure we capture UUID and set Owner

            // ... Spawn Logic ...
            Entity entity = null;
            // Simplified spawn:
            if (eggStack.getItem() instanceof SpawnEggItem egg) {
                entity = egg.getEntityType(eggStack).create(world);
            }

            if (entity != null) {
                // Apply NBT from egg if present
                // setPos, etc.
                entity.setPos(user.getX(), user.getY(), user.getZ());

                // Apply "EntityTag" from stack
                NbtCompound eggNbt = eggStack.getOrDefault(DataComponentTypes.CUSTOM_DATA, NbtComponent.DEFAULT)
                        .copyNbt();
                NbtCompound entityTag = eggNbt.getCompound("EntityTag");
                if (!entityTag.isEmpty()) {
                    NbtCompound merged = new NbtCompound();
                    entity.writeNbt(merged);
                    merged.copyFrom(entityTag);
                    entity.readNbt(merged);
                }

                // Set Owner
                if (entity instanceof ControlledMob controlled) {
                    controlled.setOwnerUuid(user.getUuid());
                }

                world.spawnEntity(entity);

                // 4. Track
                NbtCompound entry = new NbtCompound();
                entry.putUuid("UUID", entity.getUuid());
                // Backup data for cooldown/recall
                NbtCompound backup = new NbtCompound();
                entity.writeNbt(backup);
                entry.put("Data", backup);

                activeUnits.add(entry);
                nbt.put(ACTIVE_UNITS_KEY, activeUnits);

                // Consume item
                inv.removeStack(slot, 1); // removeStack calls markDirty which saves inventory

                user.sendMessage(Text.literal("Deployed " + entity.getName().getString()), true);
            }
        } else {
            user.sendMessage(Text.literal("No Units available to deploy!"), true);
        }
    }

    private void recallOldestUnit(World world, PlayerEntity user, NbtList activeUnits, ItemStack stack) {
        // Find first active (non-cooldown) unit
        for (int i = 0; i < activeUnits.size(); i++) {
            NbtCompound u = activeUnits.getCompound(i);
            if (!u.contains(COOLDOWN_KEY)) {
                UUID uuid = u.getUuid("UUID");
                // Try find
                // This requires looping loaded entities or using server getEntity
                if (world instanceof net.minecraft.server.world.ServerWorld sw) {
                    Entity e = sw.getEntity(uuid);
                    if (e != null && e.isAlive()) {
                        // Capture state
                        NbtCompound data = new NbtCompound();
                        e.writeNbt(data);
                        u.put("Data", data);

                        // Despawn
                        e.discard();

                        // Recover to inventory immediately (Skip cooldown for recall)
                        if (recoverUnitToInventory(stack, u)) {
                            activeUnits.remove(i);
                            // Refresh NBT read/write
                            NbtCompound stackNbt = stack
                                    .getOrDefault(DataComponentTypes.CUSTOM_DATA, NbtComponent.DEFAULT).copyNbt();
                            stackNbt.put(ACTIVE_UNITS_KEY, activeUnits);
                            stack.set(DataComponentTypes.CUSTOM_DATA, NbtComponent.of(stackNbt));

                            user.sendMessage(Text.literal("Recalled unit."), true);
                            return;
                        }
                    }
                }
                // If not found/loaded, we can't safely recall.
                // We might skip it?
            }
        }
    }

    public static List<UUID> getActiveUnits(ItemStack stack) {
        List<UUID> uuids = new ArrayList<>();
        NbtCompound nbt = stack.getOrDefault(DataComponentTypes.CUSTOM_DATA, NbtComponent.DEFAULT).copyNbt();
        if (nbt.contains(ACTIVE_UNITS_KEY)) {
            NbtList list = nbt.getList(ACTIVE_UNITS_KEY, NbtElement.COMPOUND_TYPE);
            for (NbtElement element : list) {
                NbtCompound c = (NbtCompound) element;
                if (!c.contains(COOLDOWN_KEY)) {
                    uuids.add(c.getUuid("UUID"));
                }
            }
        }
        return uuids;
    }
}
