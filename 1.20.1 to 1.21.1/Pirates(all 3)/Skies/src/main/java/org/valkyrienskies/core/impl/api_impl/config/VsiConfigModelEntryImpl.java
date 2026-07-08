/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.jvm.functions.Function0
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 */
package org.valkyrienskies.core.impl.api_impl.config;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.valkyrienskies.core.internal.config.VsiConfigModelEntry;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
@Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u0000<\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0013\b\u0086\b\u0018\u0000 0*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002:\u00010BO\u0012\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003\u0012\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00070\u0006\u0012\b\u0010\u0013\u001a\u0004\u0018\u00018\u0000\u0012\b\u0010\u0014\u001a\u0004\u0018\u00018\u0000\u0012\u0006\u0010\u0015\u001a\u00020\r\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\r\u00a2\u0006\u0004\b.\u0010/J\u0016\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003H\u00c6\u0003\u00a2\u0006\u0004\b\u0004\u0010\u0005J\u001c\u0010\b\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00070\u0006H\u00c6\u0003\u00a2\u0006\u0004\b\b\u0010\tJ\u0012\u0010\n\u001a\u0004\u0018\u00018\u0000H\u00c6\u0003\u00a2\u0006\u0004\b\n\u0010\u000bJ\u0012\u0010\f\u001a\u0004\u0018\u00018\u0000H\u00c6\u0003\u00a2\u0006\u0004\b\f\u0010\u000bJ\u0010\u0010\u000e\u001a\u00020\rH\u00c6\u0003\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u0012\u0010\u0010\u001a\u0004\u0018\u00010\rH\u00c6\u0003\u00a2\u0006\u0004\b\u0010\u0010\u000fJj\u0010\u0017\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u000e\b\u0002\u0010\u0011\u001a\b\u0012\u0004\u0012\u00028\u00000\u00032\u0014\b\u0002\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00070\u00062\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00018\u00002\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00018\u00002\b\b\u0002\u0010\u0015\u001a\u00020\r2\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\rH\u00c6\u0001\u00a2\u0006\u0004\b\u0017\u0010\u0018J\u001a\u0010\u001c\u001a\u00020\u001b2\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019H\u00d6\u0003\u00a2\u0006\u0004\b\u001c\u0010\u001dJ\u0010\u0010\u001f\u001a\u00020\u001eH\u00d6\u0001\u00a2\u0006\u0004\b\u001f\u0010 J\u0010\u0010!\u001a\u00020\rH\u00d6\u0001\u00a2\u0006\u0004\b!\u0010\u000fR\u001a\u0010\"\u001a\u00028\u00008\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010\u000bR\u001c\u0010\u0016\u001a\u0004\u0018\u00010\r8\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u0016\u0010%\u001a\u0004\b&\u0010\u000fR \u0010\u0011\u001a\b\u0012\u0004\u0012\u00028\u00000\u00038\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u0011\u0010'\u001a\u0004\b(\u0010\u0005R\u001c\u0010\u0014\u001a\u0004\u0018\u00018\u00008\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u0014\u0010#\u001a\u0004\b)\u0010\u000bR\u001c\u0010\u0013\u001a\u0004\u0018\u00018\u00008\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u0013\u0010#\u001a\u0004\b*\u0010\u000bR\u001a\u0010\u0015\u001a\u00020\r8\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u0015\u0010%\u001a\u0004\b+\u0010\u000fR&\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00070\u00068\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u0012\u0010,\u001a\u0004\b-\u0010\t\u00a8\u00061"}, d2={"Lorg/valkyrienskies/core/impl/api_impl/config/VsiConfigModelEntryImpl;", "T", "Lorg/valkyrienskies/core/internal/config/VsiConfigModelEntry;", "Lkotlin/Function0;", "component1", "()Lkotlin/jvm/functions/Function0;", "Lkotlin/Function1;", "", "component2", "()Lkotlin/jvm/functions/Function1;", "component3", "()Ljava/lang/Object;", "component4", "", "component5", "()Ljava/lang/String;", "component6", "getValue", "setValue", "min", "max", "name", "description", "copy", "(Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;)Lorg/valkyrienskies/core/impl/api_impl/config/VsiConfigModelEntryImpl;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "default", "Ljava/lang/Object;", "getDefault", "Ljava/lang/String;", "getDescription", "Lkotlin/jvm/functions/Function0;", "getGetValue", "getMax", "getMin", "getName", "Lkotlin/jvm/functions/Function1;", "getSetValue", "<init>", "(Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;)V", "Companion", "internal"})
public final class VsiConfigModelEntryImpl<T>
implements VsiConfigModelEntry<T> {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    private final Function0<T> getValue;
    @NotNull
    private final Function1<T, Unit> setValue;
    @Nullable
    private final T min;
    @Nullable
    private final T max;
    @NotNull
    private final String name;
    @Nullable
    private final String description;
    private final T default;

    public VsiConfigModelEntryImpl(@NotNull Function0<? extends T> getValue, @NotNull Function1<? super T, Unit> setValue, @Nullable T min, @Nullable T max, @NotNull String name, @Nullable String description) {
        Intrinsics.checkNotNullParameter(getValue, (String)"getValue");
        Intrinsics.checkNotNullParameter(setValue, (String)"setValue");
        Intrinsics.checkNotNullParameter((Object)name, (String)"name");
        this.getValue = getValue;
        this.setValue = setValue;
        this.min = min;
        this.max = max;
        this.name = name;
        this.description = description;
        this.default = this.getGetValue().invoke();
    }

    @Override
    @NotNull
    public Function0<T> getGetValue() {
        return this.getValue;
    }

    @Override
    @NotNull
    public Function1<T, Unit> getSetValue() {
        return this.setValue;
    }

    @Override
    @Nullable
    public T getMin() {
        return this.min;
    }

    @Override
    @Nullable
    public T getMax() {
        return this.max;
    }

    @Override
    @NotNull
    public String getName() {
        return this.name;
    }

    @Override
    @Nullable
    public String getDescription() {
        return this.description;
    }

    @Override
    public T getDefault() {
        return this.default;
    }

    @NotNull
    public final Function0<T> component1() {
        return this.getValue;
    }

    @NotNull
    public final Function1<T, Unit> component2() {
        return this.setValue;
    }

    @Nullable
    public final T component3() {
        return this.min;
    }

    @Nullable
    public final T component4() {
        return this.max;
    }

    @NotNull
    public final String component5() {
        return this.name;
    }

    @Nullable
    public final String component6() {
        return this.description;
    }

    @NotNull
    public final VsiConfigModelEntryImpl<T> copy(@NotNull Function0<? extends T> getValue, @NotNull Function1<? super T, Unit> setValue, @Nullable T min, @Nullable T max, @NotNull String name, @Nullable String description) {
        Intrinsics.checkNotNullParameter(getValue, (String)"getValue");
        Intrinsics.checkNotNullParameter(setValue, (String)"setValue");
        Intrinsics.checkNotNullParameter((Object)name, (String)"name");
        return new VsiConfigModelEntryImpl<T>(getValue, setValue, min, max, name, description);
    }

    public static /* synthetic */ VsiConfigModelEntryImpl copy$default(VsiConfigModelEntryImpl vsiConfigModelEntryImpl, Function0 function0, Function1 function1, Object object, Object object2, String string, String string2, int n2, Object object3) {
        if ((n2 & 1) != 0) {
            function0 = vsiConfigModelEntryImpl.getValue;
        }
        if ((n2 & 2) != 0) {
            function1 = vsiConfigModelEntryImpl.setValue;
        }
        if ((n2 & 4) != 0) {
            object = vsiConfigModelEntryImpl.min;
        }
        if ((n2 & 8) != 0) {
            object2 = vsiConfigModelEntryImpl.max;
        }
        if ((n2 & 0x10) != 0) {
            string = vsiConfigModelEntryImpl.name;
        }
        if ((n2 & 0x20) != 0) {
            string2 = vsiConfigModelEntryImpl.description;
        }
        return vsiConfigModelEntryImpl.copy(function0, function1, object, object2, string, string2);
    }

    @NotNull
    public String toString() {
        return "VsiConfigModelEntryImpl(getValue=" + this.getValue + ", setValue=" + this.setValue + ", min=" + this.min + ", max=" + this.max + ", name=" + this.name + ", description=" + this.description + ")";
    }

    public int hashCode() {
        int result2 = this.getValue.hashCode();
        result2 = result2 * 31 + this.setValue.hashCode();
        result2 = result2 * 31 + (this.min == null ? 0 : this.min.hashCode());
        result2 = result2 * 31 + (this.max == null ? 0 : this.max.hashCode());
        result2 = result2 * 31 + this.name.hashCode();
        result2 = result2 * 31 + (this.description == null ? 0 : this.description.hashCode());
        return result2;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof VsiConfigModelEntryImpl)) {
            return false;
        }
        VsiConfigModelEntryImpl vsiConfigModelEntryImpl = (VsiConfigModelEntryImpl)other;
        if (!Intrinsics.areEqual(this.getValue, vsiConfigModelEntryImpl.getValue)) {
            return false;
        }
        if (!Intrinsics.areEqual(this.setValue, vsiConfigModelEntryImpl.setValue)) {
            return false;
        }
        if (!Intrinsics.areEqual(this.min, vsiConfigModelEntryImpl.min)) {
            return false;
        }
        if (!Intrinsics.areEqual(this.max, vsiConfigModelEntryImpl.max)) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.name, (Object)vsiConfigModelEntryImpl.name)) {
            return false;
        }
        return Intrinsics.areEqual((Object)this.description, (Object)vsiConfigModelEntryImpl.description);
    }

    @Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0015\u0010\u0016J[\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00010\u000e\"\u0004\b\u0001\u0010\u00022\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00010\u00032\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000b\u00a2\u0006\u0004\b\u000f\u0010\u0010J'\u0010\u0013\u001a\u0004\u0018\u00018\u0001\"\u0004\b\u0001\u0010\u00022\u0006\u0010\u0011\u001a\u00028\u00012\u0006\u0010\u0012\u001a\u00020\bH\u0002\u00a2\u0006\u0004\b\u0013\u0010\u0014\u00a8\u0006\u0017"}, d2={"Lorg/valkyrienskies/core/impl/api_impl/config/VsiConfigModelEntryImpl$Companion;", "", "T", "Lkotlin/Function0;", "getValue", "Lkotlin/Function1;", "", "setValue", "", "min", "max", "", "name", "description", "Lorg/valkyrienskies/core/impl/api_impl/config/VsiConfigModelEntryImpl;", "build", "(Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;DDLjava/lang/String;Ljava/lang/String;)Lorg/valkyrienskies/core/impl/api_impl/config/VsiConfigModelEntryImpl;", "value", "bound", "processBoundingValue", "(Ljava/lang/Object;D)Ljava/lang/Object;", "<init>", "()V", "internal"})
    @SourceDebugExtension(value={"SMAP\nVsiConfigModelEntryImpl.kt\nKotlin\n*S Kotlin\n*F\n+ 1 VsiConfigModelEntryImpl.kt\norg/valkyrienskies/core/impl/api_impl/config/VsiConfigModelEntryImpl$Companion\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,49:1\n1#2:50\n*E\n"})
    public static final class Companion {
        private Companion() {
        }

        /*
         * WARNING - void declaration
         */
        @NotNull
        public final <T> VsiConfigModelEntryImpl<T> build(@NotNull Function0<? extends T> getValue, @NotNull Function1<? super T, Unit> setValue, double min, double max, @NotNull String name, @NotNull String description) {
            void it;
            String string;
            Intrinsics.checkNotNullParameter(getValue, (String)"getValue");
            Intrinsics.checkNotNullParameter(setValue, (String)"setValue");
            Intrinsics.checkNotNullParameter((Object)name, (String)"name");
            Intrinsics.checkNotNullParameter((Object)description, (String)"description");
            String string2 = string = description;
            String string3 = name;
            Object object = this.processBoundingValue(getValue.invoke(), max);
            Object object2 = this.processBoundingValue(getValue.invoke(), min);
            Function1<? super T, Unit> function1 = setValue;
            Function0<? extends T> function0 = getValue;
            boolean bl = false;
            boolean bl2 = ((CharSequence)it).length() > 0;
            String string4 = bl2 ? string : null;
            String string5 = string3;
            Object object3 = object;
            Object object4 = object2;
            Function1<? super T, Unit> function12 = function1;
            Function0<? extends T> function02 = function0;
            return new VsiConfigModelEntryImpl<Object>(function02, function12, object4, object3, string5, string4);
        }

        private final <T> T processBoundingValue(T value, double bound) {
            T t;
            return (T)(Double.isNaN(bound) ? null : ((t = value) instanceof Integer ? (Object)((int)bound) : (t instanceof Double ? (Object)bound : (t instanceof Float ? (Object)Float.valueOf((float)bound) : (t instanceof Long ? (Object)((long)bound) : null)))));
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }
}

