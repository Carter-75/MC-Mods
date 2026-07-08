/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.serialization.Codec
 *  io.netty.buffer.ByteBuf
 *  net.minecraft.class_3542
 *  net.minecraft.class_7995
 *  net.minecraft.class_7995$class_7996
 *  net.minecraft.class_9135
 *  net.minecraft.class_9139
 *  org.jetbrains.annotations.NotNull
 */
package backported.updates.copper.entity;

import com.mojang.serialization.Codec;
import io.netty.buffer.ByteBuf;
import java.util.function.IntFunction;
import net.minecraft.class_3542;
import net.minecraft.class_7995;
import net.minecraft.class_9135;
import net.minecraft.class_9139;
import org.jetbrains.annotations.NotNull;

public enum CopperGolemState implements class_3542
{
    IDLE("idle", 0),
    GETTING_ITEM("getting_item", 1),
    GETTING_NO_ITEM("getting_no_item", 2),
    DROPPING_ITEM("dropping_item", 3),
    DROPPING_NO_ITEM("dropping_no_item", 4),
    PRESSING_BUTTON("pressing_button", 5);

    public static final Codec<CopperGolemState> CODEC;
    private static final IntFunction<CopperGolemState> BY_ID;
    public static final class_9139<ByteBuf, CopperGolemState> STREAM_CODEC;
    private final String name;
    private final int id;

    private CopperGolemState(String name, int id) {
        this.name = name;
        this.id = id;
    }

    @NotNull
    public String method_15434() {
        return this.name;
    }

    private int id() {
        return this.id;
    }

    static {
        CODEC = class_3542.method_28140(CopperGolemState::values);
        BY_ID = class_7995.method_47914(CopperGolemState::id, (Object[])CopperGolemState.values(), (class_7995.class_7996)class_7995.class_7996.field_41664);
        STREAM_CODEC = class_9135.method_56375(BY_ID, CopperGolemState::id);
    }
}

