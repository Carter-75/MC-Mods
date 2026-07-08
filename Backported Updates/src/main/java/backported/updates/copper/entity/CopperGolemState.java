/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.serialization.Codec
 *  io.netty.buffer.ByteBuf
 *  net.minecraft.util.StringIdentifiable
 *  net.minecraft.util.function.ValueLists
 *  net.minecraft.util.function.ValueLists$OutOfBoundsHandling
 *  net.minecraft.network.codec.PacketCodecs
 *  net.minecraft.network.codec.PacketCodec
 *  org.jetbrains.annotations.NotNull
 */
package backported.updates.copper.entity;

import com.mojang.serialization.Codec;
import io.netty.buffer.ByteBuf;
import java.util.function.IntFunction;
import net.minecraft.util.StringIdentifiable;
import net.minecraft.util.function.ValueLists;
import net.minecraft.network.codec.PacketCodecs;
import net.minecraft.network.codec.PacketCodec;
import org.jetbrains.annotations.NotNull;

public enum CopperGolemState implements StringIdentifiable
{
    IDLE("idle", 0),
    GETTING_ITEM("getting_item", 1),
    GETTING_NO_ITEM("getting_no_item", 2),
    DROPPING_ITEM("dropping_item", 3),
    DROPPING_NO_ITEM("dropping_no_item", 4),
    PRESSING_BUTTON("pressing_button", 5);

    public static final Codec<CopperGolemState> CODEC;
    private static final IntFunction<CopperGolemState> BY_ID;
    public static final PacketCodec<ByteBuf, CopperGolemState> STREAM_CODEC;
    private final String name;
    private final int id;

    private CopperGolemState(String name, int id) {
        this.name = name;
        this.id = id;
    }

    @NotNull
    public String asString() {
        return this.name;
    }

    private int id() {
        return this.id;
    }

    static {
        CODEC = StringIdentifiable.createCodec(CopperGolemState::values);
        BY_ID = ValueLists.createIdToValueFunction(CopperGolemState::id, CopperGolemState.values(), (ValueLists.OutOfBoundsHandling)ValueLists.OutOfBoundsHandling.ZERO);
        STREAM_CODEC = PacketCodecs.indexed(BY_ID, CopperGolemState::id);
    }
}

