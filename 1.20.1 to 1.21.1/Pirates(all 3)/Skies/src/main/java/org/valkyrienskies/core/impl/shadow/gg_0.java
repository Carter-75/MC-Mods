/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  it.unimi.dsi.fastutil.ints.IntOpenHashSet
 *  it.unimi.dsi.fastutil.ints.IntSet
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.collections.CollectionsKt
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.functions.Function2
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.sequences.Sequence
 *  kotlin.sequences.SequencesKt
 */
package org.valkyrienskies.core.impl.shadow;

import it.unimi.dsi.fastutil.ints.IntOpenHashSet;
import it.unimi.dsi.fastutil.ints.IntSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;
import org.valkyrienskies.core.impl.shadow.ge_0;
import org.valkyrienskies.core.impl.shadow.gq_0;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.Gg
 */
@Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u0000H\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002BO\u0012\u0006\u0010\u0003\u001a\u00028\u0000\u0012\u0012\u0010\u001b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\b0\u0007\u0012\b\b\u0002\u0010\u001c\u001a\u00020\u000e\u0012\b\b\u0002\u0010\u001d\u001a\u00020\u000e\u0012\u0016\b\u0002\u0010\u001e\u001a\u0010\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0012\u00a2\u0006\u0004\b\u001f\u0010 J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00028\u0000H\u0016\u00a2\u0006\u0004\b\u0005\u0010\u0006R \u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\b0\u00078\u0002X\u0083\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\nR\u0014\u0010\t\u001a\u00020\u000b8\u0002X\u0083\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010\rR\u0014\u0010\u0011\u001a\u00020\u000e8\u0002X\u0083\u0004\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0014\u0010\u000f\u001a\u00020\u000e8\u0002X\u0083\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0010R \u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00040\u00128\u0002X\u0083\u0004\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0017\u001a\u00028\u00008\u0002X\u0083\u0004\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0016R$\u0010\f\u001a\u0012\u0012\u0004\u0012\u00028\u00000\u0018j\b\u0012\u0004\u0012\u00028\u0000`\u00198\u0002X\u0083\u0004\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u001a"}, d2={"Lorg/valkyrienskies/core/impl/shadow/Gg;", "S", "Lorg/valkyrienskies/core/impl/shadow/Ge;", "p0", "", "a", "(Ljava/lang/Object;)V", "", "Lorg/valkyrienskies/core/impl/shadow/Gq;", "b", "Ljava/util/List;", "Lit/unimi/dsi/fastutil/ints/IntSet;", "g", "Lit/unimi/dsi/fastutil/ints/IntSet;", "", "d", "Z", "c", "Lkotlin/Function1;", "", "e", "Lkotlin/jvm/functions/Function1;", "Ljava/lang/Object;", "f", "Ljava/util/ArrayList;", "Lkotlin/collections/b;", "Ljava/util/ArrayList;", "p1", "p2", "p3", "p4", "<init>", "(Ljava/lang/Object;Ljava/util/List;ZZLkotlin/jvm/functions/Function1;)V"})
public final class gg_0<S>
implements ge_0<S> {
    private final S a;
    private final List<gq_0<S>> b;
    private final boolean c;
    private final boolean d;
    private final Function1<String, Unit> e;
    private final ArrayList<S> f;
    private final IntSet g;

    public gg_0(S s, List<? extends gq_0<S>> list, boolean bl, boolean bl2, Function1<? super String, Unit> function1) {
        Intrinsics.checkNotNullParameter(list, (String)"");
        this.a = s;
        this.b = list;
        this.c = bl;
        this.d = bl2;
        Function1 function12 = function1;
        if (function12 == null) {
            function12 = 1.a;
        }
        this.e = function12;
        this.f = new ArrayList();
        this.g = (IntSet)new IntOpenHashSet();
    }

    public /* synthetic */ gg_0(Object object, List list, boolean bl, boolean bl2, Function1 function1, int n2, DefaultConstructorMarker defaultConstructorMarker) {
        if ((n2 & 4) != 0) {
            bl = false;
        }
        if ((n2 & 8) != 0) {
            bl2 = true;
        }
        if ((n2 & 0x10) != 0) {
            function1 = null;
        }
        this(object, list, bl, bl2, (Function1<? super String, Unit>)function1);
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public final void a(S object) {
        boolean bl = Intrinsics.areEqual((Object)object, this.a);
        boolean n2 = this.f.isEmpty();
        if (this.c && !bl && n2) {
            return;
        }
        if (!bl && n2) {
            throw new IllegalArgumentException("First executed stage must be the reset (" + this.a + ") but was " + object);
        }
        List list = new ArrayList();
        if (bl && !n2) {
            Sequence sequence = SequencesKt.filterIndexed((Sequence)CollectionsKt.asSequence((Iterable)this.b), (Function2)new Function2<Integer, gq_0<S>, Boolean>(this){
                private /* synthetic */ gg_0<S> a;
                {
                    this.a = gg_02;
                    super(2);
                }

                public final Boolean a(int n2, gq_0<S> gq_02) {
                    Intrinsics.checkNotNullParameter(gq_02, (String)"");
                    return !this.a.g.contains(n2);
                }

                /*
                 * WARNING - void declaration
                 */
                public final /* synthetic */ Object invoke(Object p1, Object p2) {
                    void var2_2;
                    void var1_1;
                    return this.a(((Number)var1_1).intValue(), (gq_0)var2_2);
                }
            });
            Object object222 = sequence;
            object222 = sequence;
            for (Object object222 : sequence) {
                Object e2 = object222;
                e2 = (gq_0)object222;
                String string = e2.a((List)this.f, true);
                if (string == null) continue;
                object222 = string;
                ((Collection)list).add(object222);
            }
            if (!((Collection)list).isEmpty()) {
                this.e.invoke((Object)("Constraints failed (last stage before reset). Stages since last reset: " + this.f + "\n" + CollectionsKt.joinToString$default((Iterable)list, (CharSequence)"\n", null, null, (int)0, null, null, (int)62, null)));
            }
            this.g.clear();
            this.f.clear();
        }
        this.f.add(object);
        Object object4 = this.b;
        boolean bl2 = false;
        object4 = object4.iterator();
        while (object4.hasNext()) {
            Object object2;
            void var3_9;
            void n3;
            Object e2 = object4.next();
            if ((n3 = ++var3_9) < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            object = (gq_0)e2;
            void var5_14 = n3;
            String string = object.a((List)this.f, false);
            if (string != null) {
                object = string;
                if (this.d) {
                    this.g.add((int)var5_14);
                }
                object2 = object;
            } else {
                object2 = null;
            }
            if (object2 == null) continue;
            object = object2;
            ((Collection)list).add(object);
        }
        if (!((Collection)list).isEmpty()) {
            this.e.invoke((Object)("Constraints failed. Stages since last reset: " + this.f + "\n" + CollectionsKt.joinToString$default((Iterable)list, (CharSequence)"\n", null, null, (int)0, null, null, (int)62, null)));
        }
    }
}

