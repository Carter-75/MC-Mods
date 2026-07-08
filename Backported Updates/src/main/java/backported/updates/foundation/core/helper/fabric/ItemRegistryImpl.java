/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.EntityType
 *  net.minecraft.entity.mob.MobEntity
 *  net.minecraft.item.Item
 *  net.minecraft.item.Item$Settings
 *  net.minecraft.item.SpawnEggItem
 */
package backported.updates.foundation.core.helper.fabric;

import java.util.function.Supplier;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.item.Item;
import net.minecraft.item.SpawnEggItem;

public class ItemRegistryImpl {
    public static <T extends MobEntity> Item createSpawnEgg(Supplier<EntityType<T>> entity, int primaryColor, int secondaryColor, Item.Settings properties) {
        return new SpawnEggItem(entity.get(), primaryColor, secondaryColor, properties);
    }
}

