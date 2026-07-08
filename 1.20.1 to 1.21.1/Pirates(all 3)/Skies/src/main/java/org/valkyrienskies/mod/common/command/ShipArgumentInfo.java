/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.gson.JsonObject
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.class_2314
 *  net.minecraft.class_2540
 */
package org.valkyrienskies.mod.common.command;

import com.google.gson.JsonObject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.class_2314;
import net.minecraft.class_2540;
import org.jetbrains.annotations.NotNull;
import org.valkyrienskies.mod.common.command.ShipArgument;
import org.valkyrienskies.mod.common.command.ShipArgumentInfoTemplate;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007\u00a2\u0006\u0004\b\u0013\u0010\u0014J\u001f\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0016\u00a2\u0006\u0004\b\b\u0010\tJ\u0017\u0010\n\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0016\u00a2\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\r\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u0002H\u0016\u00a2\u0006\u0004\b\r\u0010\u000eJ\u001f\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u000fH\u0016\u00a2\u0006\u0004\b\u0011\u0010\u0012\u00a8\u0006\u0015"}, d2={"Lorg/valkyrienskies/mod/common/command/ShipArgumentInfo;", "Lnet/minecraft/class_2314;", "Lorg/valkyrienskies/mod/common/command/ShipArgument;", "Lorg/valkyrienskies/mod/common/command/ShipArgumentInfoTemplate;", "template", "Lnet/minecraft/class_2540;", "friendlyByteBuf", "", "serializeToNetwork", "(Lorg/valkyrienskies/mod/common/command/ShipArgumentInfoTemplate;Lnet/minecraft/class_2540;)V", "deserializeFromNetwork", "(Lnet/minecraft/class_2540;)Lorg/valkyrienskies/mod/common/command/ShipArgumentInfoTemplate;", "argumentType", "unpack", "(Lorg/valkyrienskies/mod/common/command/ShipArgument;)Lorg/valkyrienskies/mod/common/command/ShipArgumentInfoTemplate;", "Lcom/google/gson/JsonObject;", "jsonObject", "serializeToJson", "(Lorg/valkyrienskies/mod/common/command/ShipArgumentInfoTemplate;Lcom/google/gson/JsonObject;)V", "<init>", "()V", "valkyrienskies-120"})
public final class ShipArgumentInfo
implements class_2314<ShipArgument, ShipArgumentInfoTemplate> {
    public void serializeToNetwork(@NotNull ShipArgumentInfoTemplate template, @NotNull class_2540 friendlyByteBuf) {
        Intrinsics.checkNotNullParameter((Object)template, (String)"template");
        Intrinsics.checkNotNullParameter((Object)friendlyByteBuf, (String)"friendlyByteBuf");
        friendlyByteBuf.writeBoolean(template.getSelectorOnly$valkyrienskies_120());
    }

    @NotNull
    public ShipArgumentInfoTemplate deserializeFromNetwork(@NotNull class_2540 friendlyByteBuf) {
        Intrinsics.checkNotNullParameter((Object)friendlyByteBuf, (String)"friendlyByteBuf");
        return new ShipArgumentInfoTemplate(this, friendlyByteBuf.readBoolean());
    }

    @NotNull
    public ShipArgumentInfoTemplate unpack(@NotNull ShipArgument argumentType) {
        Intrinsics.checkNotNullParameter((Object)argumentType, (String)"argumentType");
        return new ShipArgumentInfoTemplate(this, argumentType.getSelectorOnly());
    }

    public void serializeToJson(@NotNull ShipArgumentInfoTemplate template, @NotNull JsonObject jsonObject) {
        Intrinsics.checkNotNullParameter((Object)template, (String)"template");
        Intrinsics.checkNotNullParameter((Object)jsonObject, (String)"jsonObject");
        jsonObject.addProperty("selectorOnly", Boolean.valueOf(template.getSelectorOnly$valkyrienskies_120()));
    }
}

