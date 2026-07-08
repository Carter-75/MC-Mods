package com.itemuncrafting.component;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.world.item.ItemStack;
import java.util.List;

public record UncraftedItems(List<ItemStack> items) {
    public static final Codec<UncraftedItems> CODEC = RecordCodecBuilder.create(instance ->
        instance.group(
            ItemStack.CODEC.listOf().fieldOf("items").forGetter(UncraftedItems::items)
        ).apply(instance, UncraftedItems::new)
    );

    public static final StreamCodec<RegistryFriendlyByteBuf, UncraftedItems> STREAM_CODEC = StreamCodec.composite(
        net.minecraft.network.codec.ByteBufCodecs.collection(java.util.ArrayList::new, ItemStack.STREAM_CODEC), UncraftedItems::items,
        UncraftedItems::new
    );
}
