/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.class_1269
 *  net.minecraft.class_1657
 *  net.minecraft.class_1792
 *  net.minecraft.class_1792$class_1793
 *  net.minecraft.class_1838
 *  net.minecraft.class_1937
 *  net.minecraft.class_2338
 *  net.minecraft.class_2561
 *  net.minecraft.class_2680
 *  net.minecraft.class_3218
 */
package org.valkyrienskies.mod.common.item;

import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.class_1269;
import net.minecraft.class_1657;
import net.minecraft.class_1792;
import net.minecraft.class_1838;
import net.minecraft.class_1937;
import net.minecraft.class_2338;
import net.minecraft.class_2561;
import net.minecraft.class_2680;
import net.minecraft.class_3218;
import org.jetbrains.annotations.NotNull;
import org.valkyrienskies.core.api.ships.ServerShip;
import org.valkyrienskies.mod.common.VSGameUtilsKt;
import org.valkyrienskies.mod.common.assembly.ShipAssembler;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\b\u001a\u00020\u0007\u00a2\u0006\u0004\b\t\u0010\nJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a2\u0006\u0004\b\u0005\u0010\u0006\u00a8\u0006\u000b"}, d2={"Lorg/valkyrienskies/mod/common/item/ShipAssemblerItem;", "Lnet/minecraft/class_1792;", "Lnet/minecraft/class_1838;", "ctx", "Lnet/minecraft/class_1269;", "useOn", "(Lnet/minecraft/class_1838;)Lnet/minecraft/class_1269;", "Lnet/minecraft/class_1792$class_1793;", "properties", "<init>", "(Lnet/minecraft/class_1792$class_1793;)V", "valkyrienskies-120"})
public final class ShipAssemblerItem
extends class_1792 {
    public ShipAssemblerItem(@NotNull class_1792.class_1793 properties) {
        Intrinsics.checkNotNullParameter((Object)properties, (String)"properties");
        super(properties);
    }

    @NotNull
    public class_1269 method_7884(@NotNull class_1838 ctx) {
        Intrinsics.checkNotNullParameter((Object)ctx, (String)"ctx");
        class_1937 class_19372 = ctx.method_8045();
        class_3218 class_32182 = class_19372 instanceof class_3218 ? (class_3218)class_19372 : null;
        if (class_32182 == null) {
            class_1269 class_12692 = super.method_7884(ctx);
            Intrinsics.checkNotNullExpressionValue((Object)class_12692, (String)"useOn(...)");
            return class_12692;
        }
        class_3218 level = class_32182;
        class_2338 pos = ctx.method_8037();
        class_2680 class_26802 = level.method_8320(pos);
        Intrinsics.checkNotNullExpressionValue((Object)class_26802, (String)"getBlockState(...)");
        class_2680 blockState = class_26802;
        if (!level.field_9236) {
            class_1937 class_19373 = ctx.method_8045();
            Intrinsics.checkNotNullExpressionValue((Object)class_19373, (String)"getLevel(...)");
            if (VSGameUtilsKt.isChunkInShipyard(class_19373, pos.method_10263() >> 4, pos.method_10260() >> 4)) {
                class_1657 class_16572 = ctx.method_8036();
                if (class_16572 != null) {
                    class_16572.method_43496((class_2561)class_2561.method_43470((String)"That chunk is already part of a ship!"));
                }
            } else if (!blockState.method_26215()) {
                List set = new ArrayList();
                for (int x = -3; x < 4; ++x) {
                    for (int z = -3; z < 4; ++z) {
                        set.add(new class_2338(pos.method_10263() + x, pos.method_10264(), pos.method_10260() + z));
                    }
                }
                ServerShip shipData = ShipAssembler.assembleToShip$default(ShipAssembler.INSTANCE, (class_1937)level, set, true, 0.0, false, 24, null);
                class_1657 class_16573 = ctx.method_8036();
                if (class_16573 != null) {
                    class_16573.method_43496((class_2561)class_2561.method_43470((String)"SHIPIFIED!"));
                }
            }
        }
        class_1269 class_12693 = super.method_7884(ctx);
        Intrinsics.checkNotNullExpressionValue((Object)class_12693, (String)"useOn(...)");
        return class_12693;
    }
}

