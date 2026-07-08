package com.drone_army.item;

import net.minecraft.entity.EntityType;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.registry.Registries;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import java.util.Optional;

import net.minecraft.component.DataComponentTypes;
import net.minecraft.component.type.NbtComponent;

public class EssenceItem extends Item {
    public static final String ESSENCE_KEY = "EssenceData";
    public static final String ENTITY_ID_KEY = "EntityId";

    public EssenceItem(Settings settings) {
        super(settings);
    }

    @Override
    public Text getName(ItemStack stack) {
        NbtCompound nbt = stack.getOrDefault(DataComponentTypes.CUSTOM_DATA, NbtComponent.DEFAULT).copyNbt();
        if (nbt.contains(ESSENCE_KEY)) {
            NbtCompound essenceData = nbt.getCompound(ESSENCE_KEY);
            if (essenceData.contains(ENTITY_ID_KEY)) {
                String entityId = essenceData.getString(ENTITY_ID_KEY);
                Optional<EntityType<?>> entityType = Registries.ENTITY_TYPE.getOrEmpty(Identifier.of(entityId));

                if (entityType.isPresent()) {
                    return Text.translatable("item.dronearmy.essence_format", entityType.get().getName());
                }
            }
        }
        return super.getName(stack);
    }
}
