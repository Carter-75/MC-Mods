/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.JvmInline
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.class_3542
 *  org.jetbrains.annotations.NotNull
 */
package dev.mim1q.derelict.util;

import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.class_3542;
import org.jetbrains.annotations.NotNull;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
@JvmInline
@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\t\b\u0087@\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0002H\u0016\u00a2\u0006\u0004\b\u0006\u0010\u0005J\u001a\u0010\r\u001a\u00020\n2\b\u0010\t\u001a\u0004\u0018\u00010\bH\u00d6\u0003\u00a2\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u0011\u001a\u00020\u000eH\u00d6\u0001\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0013\u001a\u00020\u0002H\u00d6\u0001\u00a2\u0006\u0004\b\u0012\u0010\u0005R\u0017\u0010\u0003\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\u0088\u0001\u0003\u0092\u0001\u00020\u0002\u00a8\u0006\u0017"}, d2={"Ldev/mim1q/derelict/util/StringWrapper;", "Lnet/minecraft/class_3542;", "", "value", "constructor-impl", "(Ljava/lang/String;)Ljava/lang/String;", "asString-impl", "asString", "", "other", "", "equals-impl", "(Ljava/lang/String;Ljava/lang/Object;)Z", "equals", "", "hashCode-impl", "(Ljava/lang/String;)I", "hashCode", "toString-impl", "toString", "Ljava/lang/String;", "getValue", "()Ljava/lang/String;", "derelict"})
public final class StringWrapper
implements class_3542 {
    @NotNull
    private final String value;

    @NotNull
    public final String getValue() {
        return this.value;
    }

    @NotNull
    public static String asString-impl(String arg0) {
        return arg0;
    }

    @NotNull
    public String method_15434() {
        return StringWrapper.asString-impl(this.value);
    }

    public static String toString-impl(String arg0) {
        return "StringWrapper(value=" + arg0 + ")";
    }

    public String toString() {
        return StringWrapper.toString-impl(this.value);
    }

    public static int hashCode-impl(String arg0) {
        return arg0.hashCode();
    }

    public int hashCode() {
        return StringWrapper.hashCode-impl(this.value);
    }

    public static boolean equals-impl(String arg0, Object other) {
        if (!(other instanceof StringWrapper)) {
            return false;
        }
        return Intrinsics.areEqual((Object)arg0, (Object)((StringWrapper)other).unbox-impl());
    }

    public boolean equals(Object other) {
        return StringWrapper.equals-impl(this.value, other);
    }

    private /* synthetic */ StringWrapper(String value) {
        this.value = value;
    }

    @NotNull
    public static String constructor-impl(@NotNull String value) {
        Intrinsics.checkNotNullParameter((Object)value, (String)"value");
        return value;
    }

    public static final /* synthetic */ StringWrapper box-impl(String v) {
        return new StringWrapper(v);
    }

    public final /* synthetic */ String unbox-impl() {
        return this.value;
    }

    public static final boolean equals-impl0(String p1, String p2) {
        return Intrinsics.areEqual((Object)p1, (Object)p2);
    }
}

