/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.JvmStatic
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlinx.serialization.KSerializer
 *  kotlinx.serialization.Serializable
 *  kotlinx.serialization.descriptors.SerialDescriptor
 *  kotlinx.serialization.encoding.CompositeEncoder
 *  kotlinx.serialization.internal.PluginExceptionsKt
 *  kotlinx.serialization.internal.SerializationConstructorMarker
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package g_mungus.vlib.v2.internal.template;

import g_mungus.vlib.v2.internal.template.VLibStructureData$;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Serializable
@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0087\b\u0018\u0000 !2\u00020\u0001:\u0002!\"B\u0011\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0002\u00a2\u0006\u0004\b\u001b\u0010\u001cB#\b\u0010\u0012\u0006\u0010\u001d\u001a\u00020\u000b\u0012\u0006\u0010\u0005\u001a\u00020\u0002\u0012\b\u0010\u001f\u001a\u0004\u0018\u00010\u001e\u00a2\u0006\u0004\b\u001b\u0010 J\u0010\u0010\u0003\u001a\u00020\u0002H\u00c6\u0003\u00a2\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0006\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u0002H\u00c6\u0001\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u001a\u0010\t\u001a\u00020\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003\u00a2\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bH\u00d6\u0001\u00a2\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000f\u001a\u00020\u000eH\u00d6\u0001\u00a2\u0006\u0004\b\u000f\u0010\u0010J'\u0010\u0019\u001a\u00020\u00162\u0006\u0010\u0011\u001a\u00020\u00002\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u0014H\u0001\u00a2\u0006\u0004\b\u0017\u0010\u0018R\u0017\u0010\u0005\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010\u001a\u001a\u0004\b\u0005\u0010\u0004\u00a8\u0006#"}, d2={"Lg_mungus/vlib/v2/internal/template/VLibStructureData;", "", "", "component1", "()Z", "isShip", "copy", "(Z)Lg_mungus/vlib/v2/internal/template/VLibStructureData;", "other", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "self", "Lkotlinx/serialization/encoding/CompositeEncoder;", "output", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "serialDesc", "", "write$Self$vlib", "(Lg_mungus/vlib/v2/internal/template/VLibStructureData;Lkotlinx/serialization/encoding/CompositeEncoder;Lkotlinx/serialization/descriptors/SerialDescriptor;)V", "write$Self", "Z", "<init>", "(Z)V", "seen0", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "serializationConstructorMarker", "(IZLkotlinx/serialization/internal/SerializationConstructorMarker;)V", "Companion", ".serializer", "vlib"})
public final class VLibStructureData {
    @NotNull
    public static final Companion Companion = new Companion(null);
    private final boolean isShip;
    @NotNull
    private static final VLibStructureData DEFAULT = new VLibStructureData(false, 1, null);

    public VLibStructureData(boolean isShip) {
        this.isShip = isShip;
    }

    public /* synthetic */ VLibStructureData(boolean bl, int n, DefaultConstructorMarker defaultConstructorMarker) {
        if ((n & 1) != 0) {
            bl = false;
        }
        this(bl);
    }

    public final boolean isShip() {
        return this.isShip;
    }

    public final boolean component1() {
        return this.isShip;
    }

    @NotNull
    public final VLibStructureData copy(boolean isShip) {
        return new VLibStructureData(isShip);
    }

    public static /* synthetic */ VLibStructureData copy$default(VLibStructureData vLibStructureData, boolean bl, int n, Object object) {
        if ((n & 1) != 0) {
            bl = vLibStructureData.isShip;
        }
        return vLibStructureData.copy(bl);
    }

    @NotNull
    public String toString() {
        return "VLibStructureData(isShip=" + this.isShip + ")";
    }

    public int hashCode() {
        return Boolean.hashCode(this.isShip);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof VLibStructureData)) {
            return false;
        }
        VLibStructureData vLibStructureData = (VLibStructureData)other;
        return this.isShip == vLibStructureData.isShip;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$vlib(VLibStructureData self, CompositeEncoder output, SerialDescriptor serialDesc) {
        if (output.shouldEncodeElementDefault(serialDesc, 0) ? true : self.isShip) {
            output.encodeBooleanElement(serialDesc, 0, self.isShip);
        }
    }

    public /* synthetic */ VLibStructureData(int seen0, boolean isShip, SerializationConstructorMarker serializationConstructorMarker) {
        if ((0 & seen0) != 0) {
            PluginExceptionsKt.throwMissingFieldException((int)seen0, (int)0, (SerialDescriptor)$serializer.INSTANCE.getDescriptor());
        }
        this.isShip = (seen0 & 1) == 0 ? false : isShip;
    }

    public VLibStructureData() {
        this(false, 1, null);
    }

    @Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\n\u0010\u000bJ\u0013\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\u00a2\u0006\u0004\b\u0004\u0010\u0005R\u0017\u0010\u0006\u001a\u00020\u00038\u0006\u00a2\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\t\u00a8\u0006\f"}, d2={"Lg_mungus/vlib/v2/internal/template/VLibStructureData$Companion;", "", "Lkotlinx/serialization/KSerializer;", "Lg_mungus/vlib/v2/internal/template/VLibStructureData;", "serializer", "()Lkotlinx/serialization/KSerializer;", "DEFAULT", "Lg_mungus/vlib/v2/internal/template/VLibStructureData;", "getDEFAULT", "()Lg_mungus/vlib/v2/internal/template/VLibStructureData;", "<init>", "()V", "vlib"})
    public static final class Companion {
        private Companion() {
        }

        @NotNull
        public final VLibStructureData getDEFAULT() {
            return DEFAULT;
        }

        @NotNull
        public final KSerializer<VLibStructureData> serializer() {
            return (KSerializer)$serializer.INSTANCE;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }
}

