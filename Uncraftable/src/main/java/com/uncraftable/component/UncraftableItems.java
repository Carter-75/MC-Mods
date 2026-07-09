package com.uncraftable.component;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.world.item.ItemStack;
import java.util.List;

public record UncraftableItems(List<ItemStack> items) {
    public static final Codec<UncraftableItems> CODEC = RecordCodecBuilder.create(instance ->
        instance.group(
            ItemStack.CODEC.listOf().fieldOf("items").forGetter(UncraftableItems::items)
        ).apply(instance, UncraftableItems::new)
    );

    public static final StreamCodec<RegistryFriendlyByteBuf, UncraftableItems> STREAM_CODEC = StreamCodec.composite(
        net.minecraft.network.codec.ByteBufCodecs.collection(java.util.ArrayList::new, ItemStack.STREAM_CODEC), UncraftableItems::items,
        UncraftableItems::new
    );
}
