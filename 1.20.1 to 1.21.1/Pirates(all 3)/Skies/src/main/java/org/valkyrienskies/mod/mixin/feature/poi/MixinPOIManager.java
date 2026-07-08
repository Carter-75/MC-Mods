/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.llamalad7.mixinextras.injector.wrapoperation.Operation
 *  com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation
 *  com.llamalad7.mixinextras.sugar.Local
 *  net.minecraft.class_1923
 *  net.minecraft.class_1937
 *  net.minecraft.class_2338
 *  net.minecraft.class_238
 *  net.minecraft.class_2382
 *  net.minecraft.class_243
 *  net.minecraft.class_3218
 *  net.minecraft.class_4153
 *  net.minecraft.class_4153$class_4155
 *  net.minecraft.class_4156
 *  net.minecraft.class_4158
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.Overwrite
 *  org.spongepowered.asm.mixin.Shadow
 *  org.spongepowered.asm.mixin.Unique
 *  org.spongepowered.asm.mixin.injection.At
 */
package org.valkyrienskies.mod.mixin.feature.poi;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import com.llamalad7.mixinextras.sugar.Local;
import java.util.function.Predicate;
import java.util.stream.Stream;
import net.minecraft.class_1923;
import net.minecraft.class_1937;
import net.minecraft.class_2338;
import net.minecraft.class_238;
import net.minecraft.class_2382;
import net.minecraft.class_243;
import net.minecraft.class_3218;
import net.minecraft.class_4153;
import net.minecraft.class_4156;
import net.minecraft.class_4158;
import org.joml.Vector4ic;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.valkyrienskies.core.api.ships.LoadedServerShip;
import org.valkyrienskies.mod.common.VSGameUtilsKt;
import org.valkyrienskies.mod.common.util.VectorConversionsMCKt;
import org.valkyrienskies.mod.common.world.POIChunkSearcher;
import org.valkyrienskies.mod.mixinducks.world.OfLevel;

@Mixin(value={class_4153.class})
public abstract class MixinPOIManager
implements OfLevel {
    @Unique
    private class_1937 valkyrienskies$sLevel;

    @Shadow
    public abstract Stream<class_4156> method_19123(Predicate<class_4158> var1, class_1923 var2, class_4153.class_4155 var3);

    @Overwrite
    public Stream<class_4156> method_22383(Predicate<class_4158> predicate, class_2338 blockPos, int i2, class_4153.class_4155 occupancy) {
        int j2 = Math.floorDiv(i2, 16) + 1;
        class_238 aABB = new class_238(blockPos).method_1014((double)i2 + 1.0);
        Stream<class_1923> chunkRange = class_1923.method_19280((class_1923)new class_1923(blockPos), (int)j2);
        class_1937 class_19372 = this.valkyrienskies$sLevel;
        if (class_19372 instanceof class_3218) {
            class_3218 sLevel = (class_3218)class_19372;
            for (LoadedServerShip ship : VSGameUtilsKt.getShipObjectWorld(sLevel).getLoadedShips().getIntersecting(VectorConversionsMCKt.toJOML(aABB), VSGameUtilsKt.getDimensionId((class_1937)sLevel))) {
                Vector4ic chunkRangeBounds = POIChunkSearcher.INSTANCE.shipChunkBounds(ship.getActiveChunksSet());
                if (chunkRangeBounds == null) continue;
                chunkRange = Stream.concat(chunkRange, class_1923.method_19281((class_1923)new class_1923(chunkRangeBounds.x(), chunkRangeBounds.y()), (class_1923)new class_1923(chunkRangeBounds.z(), chunkRangeBounds.w())));
            }
        }
        return chunkRange.flatMap(chunkPos -> this.method_19123(predicate, (class_1923)chunkPos, occupancy)).filter(poiRecord -> {
            class_2338 blockPos2 = poiRecord.method_19141();
            class_243 vecPos = VSGameUtilsKt.toWorldCoordinates(this.valkyrienskies$sLevel, new class_243((double)blockPos2.method_10263(), (double)blockPos2.method_10264(), (double)blockPos2.method_10260()));
            return Math.abs(vecPos.method_10216() - (double)blockPos.method_10263()) <= (double)i2 && Math.abs(vecPos.method_10215() - (double)blockPos.method_10260()) <= (double)i2;
        });
    }

    @WrapOperation(method={"getInRange"}, at={@At(value="INVOKE", target="Ljava/util/stream/Stream;filter(Ljava/util/function/Predicate;)Ljava/util/stream/Stream;")})
    private Stream<class_4156> onGetInRange(Stream<class_4156> instance, Predicate<class_4158> predicate, Operation<Stream<class_4156>> original, @Local(argsOnly=true) class_2338 arg, @Local(argsOnly=true) int i2) {
        int k2 = i2 * i2;
        return instance.filter(poiRecord -> POIChunkSearcher.INSTANCE.getWorldPos((class_4156)poiRecord, this.valkyrienskies$sLevel).method_1025(class_243.method_24954((class_2382)arg)) <= (double)k2);
    }

    @Override
    public class_1937 getLevel() {
        return this.valkyrienskies$sLevel;
    }

    @Override
    public void setLevel(class_1937 level) {
        this.valkyrienskies$sLevel = level;
    }
}

