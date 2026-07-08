/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  it.unimi.dsi.fastutil.objects.ObjectArrayList
 *  net.minecraft.entity.Entity
 *  net.minecraft.loot.context.LootContextTypes
 *  net.minecraft.item.ItemStack
 *  net.minecraft.loot.context.LootContextParameters
 *  net.minecraft.server.world.ServerWorld
 *  net.minecraft.loot.LootTable
 *  net.minecraft.registry.RegistryKey
 *  net.minecraft.loot.context.LootContextParameterSet
 *  net.minecraft.loot.context.LootContextParameterSet$Builder
 */
package backported.updates.content.core.util;

import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import java.util.function.BiConsumer;
import java.util.function.Function;
import net.minecraft.entity.Entity;
import net.minecraft.loot.context.LootContextTypes;
import net.minecraft.item.ItemStack;
import net.minecraft.loot.context.LootContextParameters;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.loot.LootTable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.loot.context.LootContextParameterSet;

public class LootUtils {
    public static boolean dropFromGiftLootTable(Entity entity, ServerWorld level, RegistryKey<LootTable> key, BiConsumer<ServerWorld, ItemStack> consumer) {
        return LootUtils.dropFromLootTable(level, key, builder -> builder.add(LootContextParameters.ORIGIN, entity.getPos()).add(LootContextParameters.THIS_ENTITY, entity).build(LootContextTypes.GIFT), consumer);
    }

    private static boolean dropFromLootTable(ServerWorld level, RegistryKey<LootTable> key, Function<LootContextParameterSet.Builder, LootContextParameterSet> function, BiConsumer<ServerWorld, ItemStack> consumer) {
        LootContextParameterSet lootParams;
        LootTable lootTable = level.getServer().getReloadableRegistries().getLootTable(key);
        ObjectArrayList list = lootTable.generateLoot(lootParams = function.apply(new LootContextParameterSet.Builder(level)));
        if (!list.isEmpty()) {
            list.forEach(stack -> consumer.accept(level, (ItemStack)stack));
            return true;
        }
        return false;
    }
}

