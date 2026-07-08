/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  dev.architectury.injectables.annotations.ExpectPlatform
 *  dev.architectury.injectables.annotations.ExpectPlatform$Transformed
 *  net.minecraft.entity.EntityType
 *  net.minecraft.entity.mob.MobEntity
 *  net.minecraft.item.Item
 *  net.minecraft.item.Item$Settings
 *  net.minecraft.block.Block
 *  net.minecraft.registry.Registries
 */
package backported.updates.foundation.core.helper;

import backported.updates.foundation.core.CoreRegistry;
import backported.updates.foundation.core.helper.fabric.ItemRegistryImpl;
import dev.architectury.injectables.annotations.ExpectPlatform;
import java.util.function.Function;
import java.util.function.Supplier;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.item.Item;
import net.minecraft.block.Block;
import net.minecraft.registry.Registries;

public class ItemRegistry {
    private final CoreRegistry<Item> items;

    private ItemRegistry(String modId) {
        this.items = CoreRegistry.create(Registries.ITEM, modId);
    }

    public static ItemRegistry create(String modId) {
        return new ItemRegistry(modId);
    }

    public <T extends Item> Supplier<T> register(String name, Supplier<T> item) {
        return this.items.register(name, item);
    }

    public Supplier<Item> register(String name) {
        return this.register(name, new Item.Settings());
    }

    public Supplier<Item> register(String name, Item.Settings properties) {
        return this.register(name, Item::new, properties);
    }

    public Supplier<Item> register(String name, Function<Item.Settings, Item> function) {
        return this.register(name, function, new Item.Settings());
    }

    public Supplier<Item> register(String name, Function<Item.Settings, Item> factory, Item.Settings properties) {
        return this.items.register(name, () -> (Item)factory.apply(properties));
    }

    public <T extends MobEntity> Supplier<Item> spawnEgg(String name, Supplier<EntityType<T>> entity, int primaryColor, int secondaryColor, Item.Settings properties) {
        return this.items.register(name, () -> ItemRegistry.createSpawnEgg(entity, primaryColor, secondaryColor, properties));
    }

    public Supplier<Item> fromBlock(Supplier<Block> block) {
        return () -> ((Block)block.get()).asItem();
    }

    public void register() {
        this.items.register();
    }

    public CoreRegistry<Item> registry() {
        return this.items;
    }

    @ExpectPlatform
    @ExpectPlatform.Transformed
    public static <T extends MobEntity> Item createSpawnEgg(Supplier<EntityType<T>> entity, int primaryColor, int secondaryColor, Item.Settings properties) {
        return ItemRegistryImpl.createSpawnEgg(entity, primaryColor, secondaryColor, properties);
    }
}

