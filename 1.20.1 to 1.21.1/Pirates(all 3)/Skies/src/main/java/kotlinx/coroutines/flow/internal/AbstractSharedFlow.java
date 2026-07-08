/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.Result
 *  kotlin.Unit
 *  kotlin.coroutines.Continuation
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 */
package kotlinx.coroutines.flow.internal;

import java.util.Arrays;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.internal.AbstractSharedFlowSlot;
import kotlinx.coroutines.flow.internal.SubscriptionCountStateFlow;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0006\b \u0018\u0000*\f\b\u0000\u0010\u0002*\u0006\u0012\u0002\b\u00030\u00012\u00060\u0003j\u0002`\u0004B\u0007\u00a2\u0006\u0004\b&\u0010'J\u000f\u0010\u0005\u001a\u00028\u0000H\u0004\u00a2\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00028\u0000H$\u00a2\u0006\u0004\b\u0007\u0010\u0006J\u001f\u0010\u000b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00018\u00000\n2\u0006\u0010\t\u001a\u00020\bH$\u00a2\u0006\u0004\b\u000b\u0010\fJ$\u0010\u0010\u001a\u00020\u000e2\u0012\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u000e0\rH\u0084\b\u00a2\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00028\u0000H\u0004\u00a2\u0006\u0004\b\u0013\u0010\u0014R\u0018\u0010\u0016\u001a\u0004\u0018\u00010\u00158\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017R$\u0010\u0019\u001a\u00020\b2\u0006\u0010\u0018\u001a\u00020\b8\u0004@BX\u0084\u000e\u00a2\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u0016\u0010\u001d\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001aR8\u0010\u001e\u001a\f\u0012\u0006\u0012\u0004\u0018\u00018\u0000\u0018\u00010\n2\u0010\u0010\u0018\u001a\f\u0012\u0006\u0012\u0004\u0018\u00018\u0000\u0018\u00010\n8\u0004@BX\u0084\u000e\u00a2\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!R\u0017\u0010%\u001a\b\u0012\u0004\u0012\u00020\b0\"8F\u00a2\u0006\u0006\u001a\u0004\b#\u0010$\u00a8\u0006("}, d2={"Lkotlinx/coroutines/flow/internal/AbstractSharedFlow;", "Lkotlinx/coroutines/flow/internal/AbstractSharedFlowSlot;", "S", "", "Lkotlinx/coroutines/internal/SynchronizedObject;", "allocateSlot", "()Lkotlinx/coroutines/flow/internal/AbstractSharedFlowSlot;", "createSlot", "", "size", "", "createSlotArray", "(I)[Lkotlinx/coroutines/flow/internal/AbstractSharedFlowSlot;", "Lkotlin/Function1;", "", "block", "forEachSlotLocked", "(Lkotlin/jvm/functions/Function1;)V", "slot", "freeSlot", "(Lkotlinx/coroutines/flow/internal/AbstractSharedFlowSlot;)V", "Lkotlinx/coroutines/flow/internal/SubscriptionCountStateFlow;", "_subscriptionCount", "Lkotlinx/coroutines/flow/internal/SubscriptionCountStateFlow;", "<set-?>", "nCollectors", "I", "getNCollectors", "()I", "nextIndex", "slots", "[Lkotlinx/coroutines/flow/internal/AbstractSharedFlowSlot;", "getSlots", "()[Lkotlinx/coroutines/flow/internal/AbstractSharedFlowSlot;", "Lkotlinx/coroutines/flow/StateFlow;", "getSubscriptionCount", "()Lkotlinx/coroutines/flow/StateFlow;", "subscriptionCount", "<init>", "()V", "kotlinx-coroutines-core"})
@SourceDebugExtension(value={"SMAP\nAbstractSharedFlow.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AbstractSharedFlow.kt\nkotlinx/coroutines/flow/internal/AbstractSharedFlow\n+ 2 Synchronized.common.kt\nkotlinx/coroutines/internal/Synchronized_commonKt\n+ 3 Synchronized.kt\nkotlinx/coroutines/internal/SynchronizedKt\n+ 4 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 5 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n*L\n1#1,132:1\n28#2,4:133\n28#2,4:138\n28#2,4:144\n20#3:137\n20#3:142\n20#3:148\n1#4:143\n13579#5,2:149\n*S KotlinDebug\n*F\n+ 1 AbstractSharedFlow.kt\nkotlinx/coroutines/flow/internal/AbstractSharedFlow\n*L\n30#1:133,4\n45#1:138,4\n76#1:144,4\n30#1:137\n45#1:142\n76#1:148\n95#1:149,2\n*E\n"})
public abstract class AbstractSharedFlow<S extends AbstractSharedFlowSlot<?>> {
    @Nullable
    private S[] slots;
    private int nCollectors;
    private int nextIndex;
    @Nullable
    private SubscriptionCountStateFlow _subscriptionCount;

    @Nullable
    protected final S[] getSlots() {
        return this.slots;
    }

    protected final int getNCollectors() {
        return this.nCollectors;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @NotNull
    public final StateFlow<Integer> getSubscriptionCount() {
        SubscriptionCountStateFlow subscriptionCountStateFlow;
        boolean $i$f$synchronized = false;
        boolean $i$f$synchronizedImpl = false;
        AbstractSharedFlow abstractSharedFlow = this;
        synchronized (abstractSharedFlow) {
            boolean bl = false;
            SubscriptionCountStateFlow subscriptionCountStateFlow2 = this._subscriptionCount;
            if (subscriptionCountStateFlow2 == null) {
                SubscriptionCountStateFlow subscriptionCountStateFlow3;
                SubscriptionCountStateFlow it = subscriptionCountStateFlow3 = new SubscriptionCountStateFlow(this.nCollectors);
                boolean bl2 = false;
                this._subscriptionCount = it;
                subscriptionCountStateFlow2 = subscriptionCountStateFlow3;
            }
            subscriptionCountStateFlow = subscriptionCountStateFlow2;
        }
        return subscriptionCountStateFlow;
    }

    @NotNull
    protected abstract S createSlot();

    @NotNull
    protected abstract S[] createSlotArray(int var1);

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @NotNull
    protected final S allocateSlot() {
        AbstractSharedFlowSlot slot;
        block10: {
            AbstractSharedFlowSlot abstractSharedFlowSlot;
            SubscriptionCountStateFlow subscriptionCount = null;
            boolean $i$f$synchronized = false;
            boolean $i$f$synchronizedImpl = false;
            AbstractSharedFlow abstractSharedFlow = this;
            synchronized (abstractSharedFlow) {
                AbstractSharedFlowSlot abstractSharedFlowSlot2;
                Object[] objectArray;
                AbstractSharedFlowSlot[] it;
                AbstractSharedFlowSlot<Object>[] abstractSharedFlowSlotArray;
                boolean bl = false;
                S[] curSlots = this.slots;
                if (curSlots == null) {
                    abstractSharedFlowSlotArray = this.createSlotArray(2);
                    it = abstractSharedFlowSlotArray;
                    boolean bl2 = false;
                    this.slots = it;
                    objectArray = abstractSharedFlowSlotArray;
                } else if (this.nCollectors >= curSlots.length) {
                    S[] SArray = Arrays.copyOf(curSlots, 2 * curSlots.length);
                    Intrinsics.checkNotNullExpressionValue(SArray, (String)"copyOf(this, newSize)");
                    abstractSharedFlowSlotArray = SArray;
                    it = abstractSharedFlowSlotArray;
                    boolean bl3 = false;
                    this.slots = it;
                    objectArray = abstractSharedFlowSlotArray;
                } else {
                    objectArray = curSlots;
                }
                S[] slots = objectArray;
                int index = 0;
                index = this.nextIndex;
                AbstractSharedFlowSlot slot2 = null;
                do {
                    S s;
                    if ((s = slots[index]) == null) {
                        S s2;
                        S it2 = s2 = this.createSlot();
                        boolean bl4 = false;
                        slots[index] = it2;
                        s = s2;
                    }
                    slot2 = (AbstractSharedFlowSlot)s;
                    if (++index >= slots.length) {
                        index = 0;
                    }
                    abstractSharedFlowSlot2 = slot2;
                    Intrinsics.checkNotNull(abstractSharedFlowSlot2, (String)"null cannot be cast to non-null type kotlinx.coroutines.flow.internal.AbstractSharedFlowSlot<kotlin.Any>");
                } while (!abstractSharedFlowSlot2.allocateLocked(this));
                this.nextIndex = index;
                int n2 = this.nCollectors;
                this.nCollectors = n2 + 1;
                subscriptionCount = this._subscriptionCount;
                abstractSharedFlowSlot = slot2;
            }
            slot = abstractSharedFlowSlot;
            SubscriptionCountStateFlow subscriptionCountStateFlow = subscriptionCount;
            if (subscriptionCountStateFlow == null) break block10;
            subscriptionCountStateFlow.increment(1);
        }
        return (S)slot;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    protected final void freeSlot(@NotNull S slot) {
        block5: {
            Continuation<Unit>[] continuationArray;
            SubscriptionCountStateFlow subscriptionCount = null;
            boolean $i$f$synchronized = false;
            boolean $i$f$synchronizedImpl = false;
            AbstractSharedFlow abstractSharedFlow = this;
            synchronized (abstractSharedFlow) {
                boolean bl = false;
                int n2 = this.nCollectors;
                this.nCollectors = n2 + -1;
                subscriptionCount = this._subscriptionCount;
                if (this.nCollectors == 0) {
                    this.nextIndex = 0;
                }
                Intrinsics.checkNotNull(slot, (String)"null cannot be cast to non-null type kotlinx.coroutines.flow.internal.AbstractSharedFlowSlot<kotlin.Any>");
                continuationArray = ((AbstractSharedFlowSlot)slot).freeLocked((AbstractSharedFlow)this);
            }
            Continuation<Unit>[] resumes = continuationArray;
            int n3 = resumes.length;
            for (int i2 = 0; i2 < n3; ++i2) {
                Continuation<Unit> cont;
                Continuation<Unit> continuation = cont = resumes[i2];
                if (continuation == null) continue;
                continuation.resumeWith(Result.constructor-impl((Object)Unit.INSTANCE));
            }
            SubscriptionCountStateFlow subscriptionCountStateFlow = subscriptionCount;
            if (subscriptionCountStateFlow == null) break block5;
            subscriptionCountStateFlow.increment(-1);
        }
    }

    protected final void forEachSlotLocked(@NotNull Function1<? super S, Unit> block) {
        block2: {
            boolean $i$f$forEachSlotLocked = false;
            if (this.nCollectors == 0) {
                return;
            }
            AbstractSharedFlowSlot[] abstractSharedFlowSlotArray = this.slots;
            if (abstractSharedFlowSlotArray == null) break block2;
            AbstractSharedFlowSlot[] $this$forEach$iv = abstractSharedFlowSlotArray;
            boolean $i$f$forEach = false;
            int n2 = $this$forEach$iv.length;
            for (int i2 = 0; i2 < n2; ++i2) {
                AbstractSharedFlowSlot element$iv;
                AbstractSharedFlowSlot slot = element$iv = $this$forEach$iv[i2];
                boolean bl = false;
                if (slot == null) continue;
                block.invoke((Object)slot);
            }
        }
    }
}

