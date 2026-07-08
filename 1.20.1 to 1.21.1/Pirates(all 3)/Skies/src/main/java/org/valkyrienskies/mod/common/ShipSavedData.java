/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.JvmStatic
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  net.minecraft.class_18
 *  net.minecraft.class_2487
 */
package org.valkyrienskies.mod.common;

import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import net.minecraft.class_18;
import net.minecraft.class_2487;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.valkyrienskies.core.internal.world.VsiPipeline;
import org.valkyrienskies.mod.common.VSGameUtilsKt;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0003\n\u0002\b\t\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018B\u0007\u00a2\u0006\u0004\b\u0016\u0010\u0017J\u0017\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a2\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H\u0016\u00a2\u0006\u0004\b\u0007\u0010\bR\"\u0010\n\u001a\u00020\t8\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR(\u0010\u0012\u001a\u0004\u0018\u00010\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0006@BX\u0086\u000e\u00a2\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\u00a8\u0006\u0019"}, d2={"Lorg/valkyrienskies/mod/common/ShipSavedData;", "Lnet/minecraft/class_18;", "Lnet/minecraft/class_2487;", "compoundTag", "save", "(Lnet/minecraft/class_2487;)Lnet/minecraft/class_2487;", "", "isDirty", "()Z", "Lorg/valkyrienskies/core/internal/world/VsiPipeline;", "pipeline", "Lorg/valkyrienskies/core/internal/world/VsiPipeline;", "getPipeline", "()Lorg/valkyrienskies/core/internal/world/VsiPipeline;", "setPipeline", "(Lorg/valkyrienskies/core/internal/world/VsiPipeline;)V", "", "value", "loadingException", "Ljava/lang/Throwable;", "getLoadingException", "()Ljava/lang/Throwable;", "<init>", "()V", "Companion", "valkyrienskies-120"})
public final class ShipSavedData
extends class_18 {
    @NotNull
    public static final Companion Companion = new Companion(null);
    public VsiPipeline pipeline;
    @Nullable
    private Throwable loadingException;
    @NotNull
    public static final String SAVED_DATA_ID = "vs_ship_data";
    @NotNull
    private static final String QUERYABLE_SHIP_DATA_NBT_KEY = "queryable_ship_data";
    @NotNull
    private static final String CHUNK_ALLOCATOR_NBT_KEY = "chunk_allocator";
    @NotNull
    private static final String PIPELINE_NBT_KEY = "vs_pipeline";

    @NotNull
    public final VsiPipeline getPipeline() {
        VsiPipeline vsiPipeline = this.pipeline;
        if (vsiPipeline != null) {
            return vsiPipeline;
        }
        Intrinsics.throwUninitializedPropertyAccessException((String)"pipeline");
        return null;
    }

    public final void setPipeline(@NotNull VsiPipeline vsiPipeline) {
        Intrinsics.checkNotNullParameter((Object)vsiPipeline, (String)"<set-?>");
        this.pipeline = vsiPipeline;
    }

    @Nullable
    public final Throwable getLoadingException() {
        return this.loadingException;
    }

    @NotNull
    public class_2487 method_75(@NotNull class_2487 compoundTag) {
        Intrinsics.checkNotNullParameter((Object)compoundTag, (String)"compoundTag");
        compoundTag.method_10570(PIPELINE_NBT_KEY, VSGameUtilsKt.getVsCore().serializePipeline(this.getPipeline()));
        return compoundTag;
    }

    public boolean method_79() {
        return true;
    }

    @JvmStatic
    @NotNull
    public static final ShipSavedData load(@NotNull class_2487 compoundTag) {
        return Companion.load(compoundTag);
    }

    @Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000f\u0010\u0010J\r\u0010\u0003\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0007\u00a2\u0006\u0004\b\u0007\u0010\bR\u0014\u0010\n\u001a\u00020\t8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u00020\t8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\f\u0010\u000bR\u0014\u0010\r\u001a\u00020\t8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000bR\u0014\u0010\u000e\u001a\u00020\t8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000b\u00a8\u0006\u0011"}, d2={"Lorg/valkyrienskies/mod/common/ShipSavedData$Companion;", "", "Lorg/valkyrienskies/mod/common/ShipSavedData;", "createEmpty", "()Lorg/valkyrienskies/mod/common/ShipSavedData;", "Lnet/minecraft/class_2487;", "compoundTag", "load", "(Lnet/minecraft/class_2487;)Lorg/valkyrienskies/mod/common/ShipSavedData;", "", "SAVED_DATA_ID", "Ljava/lang/String;", "QUERYABLE_SHIP_DATA_NBT_KEY", "CHUNK_ALLOCATOR_NBT_KEY", "PIPELINE_NBT_KEY", "<init>", "()V", "valkyrienskies-120"})
    @SourceDebugExtension(value={"SMAP\nShipSavedData.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ShipSavedData.kt\norg/valkyrienskies/mod/common/ShipSavedData$Companion\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,66:1\n1#2:67\n*E\n"})
    public static final class Companion {
        private Companion() {
        }

        @NotNull
        public final ShipSavedData createEmpty() {
            ShipSavedData shipSavedData;
            ShipSavedData $this$createEmpty_u24lambda_u240 = shipSavedData = new ShipSavedData();
            boolean bl = false;
            $this$createEmpty_u24lambda_u240.setPipeline(VSGameUtilsKt.getVsCore().newPipeline());
            return shipSavedData;
        }

        @JvmStatic
        @NotNull
        public final ShipSavedData load(@NotNull class_2487 compoundTag) {
            ShipSavedData data;
            block5: {
                Intrinsics.checkNotNullParameter((Object)compoundTag, (String)"compoundTag");
                data = new ShipSavedData();
                byte[] queryableShipDataAsBytes = compoundTag.method_10547(ShipSavedData.QUERYABLE_SHIP_DATA_NBT_KEY);
                byte[] chunkAllocatorAsBytes = compoundTag.method_10547(ShipSavedData.CHUNK_ALLOCATOR_NBT_KEY);
                byte[] pipelineAsBytes = compoundTag.method_10547(ShipSavedData.PIPELINE_NBT_KEY);
                try {
                    Intrinsics.checkNotNull((Object)pipelineAsBytes);
                    if (!(pipelineAsBytes.length == 0)) {
                        data.setPipeline(VSGameUtilsKt.getVsCore().newPipeline(pipelineAsBytes));
                        break block5;
                    }
                    Intrinsics.checkNotNull((Object)queryableShipDataAsBytes);
                    if (!(queryableShipDataAsBytes.length == 0)) {
                        Intrinsics.checkNotNull((Object)chunkAllocatorAsBytes);
                        if (!(chunkAllocatorAsBytes.length == 0)) {
                            data.setPipeline(VSGameUtilsKt.getVsCore().newPipelineLegacyData(queryableShipDataAsBytes, chunkAllocatorAsBytes));
                            break block5;
                        }
                    }
                    throw new IllegalStateException("Couldn't find serialized ship data");
                }
                catch (Exception ex) {
                    data.loadingException = ex;
                }
            }
            return data;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }
}

