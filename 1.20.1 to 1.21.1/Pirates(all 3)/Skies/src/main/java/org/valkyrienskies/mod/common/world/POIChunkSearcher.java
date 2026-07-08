/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.Ref$IntRef
 *  net.minecraft.class_1937
 *  net.minecraft.class_2338
 *  net.minecraft.class_243
 *  net.minecraft.class_4156
 */
package org.valkyrienskies.mod.common.world;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import net.minecraft.class_1937;
import net.minecraft.class_2338;
import net.minecraft.class_243;
import net.minecraft.class_4156;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.joml.Vector4i;
import org.joml.Vector4ic;
import org.valkyrienskies.core.api.ships.properties.IShipActiveChunksSet;
import org.valkyrienskies.mod.common.VSGameUtilsKt;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006J\u0019\u0010\u000b\u001a\u00020\n*\u00020\u00072\u0006\u0010\t\u001a\u00020\b\u00a2\u0006\u0004\b\u000b\u0010\f\u00a8\u0006\u000f"}, d2={"Lorg/valkyrienskies/mod/common/world/POIChunkSearcher;", "", "Lorg/valkyrienskies/core/api/ships/properties/IShipActiveChunksSet;", "chunkSet", "Lorg/joml/Vector4ic;", "shipChunkBounds", "(Lorg/valkyrienskies/core/api/ships/properties/IShipActiveChunksSet;)Lorg/joml/Vector4ic;", "Lnet/minecraft/class_4156;", "Lnet/minecraft/class_1937;", "level", "Lnet/minecraft/class_243;", "getWorldPos", "(Lnet/minecraft/class_4156;Lnet/minecraft/class_1937;)Lnet/minecraft/class_243;", "<init>", "()V", "valkyrienskies-120"})
public final class POIChunkSearcher {
    @NotNull
    public static final POIChunkSearcher INSTANCE = new POIChunkSearcher();

    private POIChunkSearcher() {
    }

    @Nullable
    public final Vector4ic shipChunkBounds(@NotNull IShipActiveChunksSet chunkSet) {
        Intrinsics.checkNotNullParameter((Object)chunkSet, (String)"chunkSet");
        if (chunkSet.getSize() == 0) {
            return null;
        }
        Ref.IntRef minChunkX = new Ref.IntRef();
        minChunkX.element = Integer.MAX_VALUE;
        Ref.IntRef minChunkZ = new Ref.IntRef();
        minChunkZ.element = Integer.MAX_VALUE;
        Ref.IntRef maxChunkX = new Ref.IntRef();
        maxChunkX.element = Integer.MIN_VALUE;
        Ref.IntRef maxChunkZ = new Ref.IntRef();
        maxChunkZ.element = Integer.MIN_VALUE;
        chunkSet.forEach((arg_0, arg_1) -> POIChunkSearcher.shipChunkBounds$lambda$0(minChunkX, minChunkZ, maxChunkX, maxChunkZ, arg_0, arg_1));
        if (minChunkX.element == Integer.MAX_VALUE || minChunkZ.element == Integer.MAX_VALUE || maxChunkX.element == Integer.MIN_VALUE || maxChunkZ.element == Integer.MIN_VALUE) {
            return null;
        }
        return new Vector4i(minChunkX.element, minChunkZ.element, maxChunkX.element, maxChunkZ.element);
    }

    @NotNull
    public final class_243 getWorldPos(@NotNull class_4156 $this$getWorldPos, @NotNull class_1937 level) {
        Intrinsics.checkNotNullParameter((Object)$this$getWorldPos, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)level, (String)"level");
        class_2338 class_23382 = $this$getWorldPos.method_19141();
        Intrinsics.checkNotNullExpressionValue((Object)class_23382, (String)"getPos(...)");
        return VSGameUtilsKt.toWorldCoordinates(level, class_23382);
    }

    private static final void shipChunkBounds$lambda$0(Ref.IntRef $minChunkX, Ref.IntRef $minChunkZ, Ref.IntRef $maxChunkX, Ref.IntRef $maxChunkZ, int chunkX, int chunkZ) {
        Intrinsics.checkNotNullParameter((Object)$minChunkX, (String)"$minChunkX");
        Intrinsics.checkNotNullParameter((Object)$minChunkZ, (String)"$minChunkZ");
        Intrinsics.checkNotNullParameter((Object)$maxChunkX, (String)"$maxChunkX");
        Intrinsics.checkNotNullParameter((Object)$maxChunkZ, (String)"$maxChunkZ");
        $minChunkX.element = Math.min($minChunkX.element, chunkX);
        $minChunkZ.element = Math.min($minChunkZ.element, chunkZ);
        $maxChunkX.element = Math.max($maxChunkX.element, chunkX);
        $maxChunkZ.element = Math.max($maxChunkZ.element, chunkZ);
    }
}

