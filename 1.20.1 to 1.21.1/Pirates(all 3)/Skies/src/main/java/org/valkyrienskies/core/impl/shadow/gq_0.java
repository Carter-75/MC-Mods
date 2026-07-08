/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.collections.ArraysKt
 *  kotlin.collections.CollectionsKt
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.internal.Intrinsics
 *  org.valkyrienskies.core.impl.shadow.Gq
 */
package org.valkyrienskies.core.impl.shadow;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.valkyrienskies.core.impl.shadow.Gq;
import org.valkyrienskies.core.impl.shadow.gd_0;
import org.valkyrienskies.core.impl.shadow.gi_0;
import org.valkyrienskies.core.impl.shadow.gj_0;
import org.valkyrienskies.core.impl.shadow.gk_0;
import org.valkyrienskies.core.impl.shadow.gl_0;
import org.valkyrienskies.core.impl.shadow.gm_0;
import org.valkyrienskies.core.impl.shadow.gn_0;
import org.valkyrienskies.core.impl.shadow.go_0;
import org.valkyrienskies.core.impl.shadow.gp_0;
import org.valkyrienskies.core.impl.shadow.gt_0;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.Gq
 */
@Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u0000\u001e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u00e6\u0080\u0001\u0018\u0000 \b*\u0004\b\u0000\u0010\u00012\u00020\u0002:\u0001\bJ'\u0010\b\u001a\u0004\u0018\u00010\u00072\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u00032\u0006\u0010\u0006\u001a\u00020\u0005H&\u00a2\u0006\u0004\b\b\u0010\t\u00f8\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001\u00c0\u0006\u0001"}, d2={"Lorg/valkyrienskies/core/impl/shadow/Gq;", "S", "", "", "p0", "", "p1", "", "a", "(Ljava/util/List;Z)Ljava/lang/String;"})
public interface gq_0<S> {
    public static final a a = org.valkyrienskies.core.impl.shadow.Gq$a.a;

    public String a(List<? extends S> var1, boolean var2);

    public static final class a {
        static final /* synthetic */ a a;

        private a() {
        }

        public static <S> gq_0<S> a(S ... SArray) {
            Intrinsics.checkNotNullParameter(SArray, (String)"");
            return (Gq)new gk_0(ArraysKt.asList((Object[])SArray));
        }

        public static <S> gq_0<S> b(S ... SArray) {
            Intrinsics.checkNotNullParameter(SArray, (String)"");
            return (Gq)new go_0<S>(Arrays.copyOf(SArray, SArray.length));
        }

        public static <S> gq_0<S> c(S ... SArray) {
            Intrinsics.checkNotNullParameter(SArray, (String)"");
            return (Gq)new gm_0(ArraysKt.asList((Object[])SArray));
        }

        private static <S> gq_0<S> b(List<? extends S> list) {
            Intrinsics.checkNotNullParameter(list, (String)"");
            return (Gq)new gm_0(CollectionsKt.toList((Iterable)list));
        }

        public static <S> gq_0<S> a(gt_0<S> ... gt_0Array) {
            Intrinsics.checkNotNullParameter(gt_0Array, (String)"");
            return (Gq)new gn_0(ArraysKt.asList((Object[])gt_0Array));
        }

        public static <S> gq_0<S> a(List<? extends gt_0<S>> list) {
            Intrinsics.checkNotNullParameter(list, (String)"");
            return (Gq)new gn_0(CollectionsKt.toList((Iterable)list));
        }

        public final <S> gq_0<S> a(Function1<? super gd_0<S>, Unit> function1) {
            Intrinsics.checkNotNullParameter(function1, (String)"");
            gd_0 gd_02 = new gd_0();
            function1.invoke(gd_02);
            return org.valkyrienskies.core.impl.shadow.Gq$a.a(gd_02.a());
        }

        public static <S> gq_0<S> d(S ... SArray) {
            Intrinsics.checkNotNullParameter(SArray, (String)"");
            return (Gq)new gj_0<S>(Arrays.copyOf(SArray, SArray.length));
        }

        public static <S> gq_0<S> e(S ... SArray) {
            Intrinsics.checkNotNullParameter(SArray, (String)"");
            return (Gq)new gl_0<S>(Arrays.copyOf(SArray, SArray.length));
        }

        public static <S> gq_0<S> a(gq_0<S> ... gq_0Array) {
            Intrinsics.checkNotNullParameter(gq_0Array, (String)"");
            return (Gq)new gi_0<S>(Arrays.copyOf(gq_0Array, gq_0Array.length));
        }

        public final <S> gq_0<S> f(S ... SArray) {
            Intrinsics.checkNotNullParameter(SArray, (String)"");
            Gq[] gqArray = new Gq[2];
            Gq[] gqArray2 = gqArray;
            gqArray[0] = org.valkyrienskies.core.impl.shadow.Gq$a.c(Arrays.copyOf(SArray, SArray.length));
            gqArray2[1] = org.valkyrienskies.core.impl.shadow.Gq$a.b(Arrays.copyOf(SArray, SArray.length));
            return org.valkyrienskies.core.impl.shadow.Gq$a.a(gqArray2);
        }

        public final <S> gq_0<S> g(S ... SArray) {
            Intrinsics.checkNotNullParameter(SArray, (String)"");
            Gq[] gqArray = new Gq[2];
            Gq[] gqArray2 = gqArray;
            gqArray[0] = org.valkyrienskies.core.impl.shadow.Gq$a.c(Arrays.copyOf(SArray, SArray.length));
            gqArray2[1] = org.valkyrienskies.core.impl.shadow.Gq$a.d(Arrays.copyOf(SArray, SArray.length));
            return org.valkyrienskies.core.impl.shadow.Gq$a.a(gqArray2);
        }

        public static <S> gq_0<S> a(Predicate<Thread> predicate, S ... SArray) {
            Intrinsics.checkNotNullParameter(predicate, (String)"");
            Intrinsics.checkNotNullParameter(SArray, (String)"");
            return (Gq)new gp_0<S>(predicate, Arrays.copyOf(SArray, SArray.length));
        }

        static {
            a = new a();
        }
    }
}

