/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.ResultKt
 *  kotlin.Unit
 *  kotlin.coroutines.Continuation
 *  kotlin.coroutines.intrinsics.IntrinsicsKt
 *  kotlin.jvm.functions.Function0
 *  kotlin.jvm.functions.Function2
 *  kotlin.jvm.functions.Function3
 *  kotlin.jvm.functions.Function4
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  kotlin.sequences.SequenceScope
 *  kotlin.sequences.SequencesKt
 */
package org.valkyrienskies.core.util.datastructures;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.sequences.SequenceScope;
import kotlin.sequences.SequencesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.joml.Vector3i;
import org.joml.Vector3ic;
import org.valkyrienskies.core.util.datastructures.BlockPos2ObjectOpenHashMap;
import org.valkyrienskies.core.util.datastructures.DenseBlockPosSet;
import org.valkyrienskies.core.util.datastructures.IBlockPosSet;
import org.valkyrienskies.core.util.datastructures.SingleChunkDenseBlockPosSet;

@Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010)\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b'\u0010\fJ'\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0002H\u0016\u00a2\u0006\u0004\b\u0007\u0010\bJ'\u0010\t\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0002H\u0016\u00a2\u0006\u0004\b\t\u0010\bJ\u000f\u0010\u000b\u001a\u00020\nH\u0016\u00a2\u0006\u0004\b\u000b\u0010\fJ'\u0010\r\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0002H\u0016\u00a2\u0006\u0004\b\r\u0010\bJ3\u0010\u0010\u001a\u00020\n2\u001e\u0010\u000f\u001a\u001a\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\n0\u000eH\u0086\b\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0010\u0010\u0011J9\u0010\u0014\u001a\u00020\n2$\u0010\u000f\u001a \u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\n0\u0012H\u0086\b\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0014\u0010\u0015J'\u0010\u0016\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0016\u0010\u0017J\u0016\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00190\u0018H\u0096\u0002\u00a2\u0006\u0004\b\u001a\u0010\u001bJ'\u0010\u001c\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0002H\u0016\u00a2\u0006\u0004\b\u001c\u0010\bR\u001d\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00130\u001d8\u0006\u00a2\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!R$\u0010#\u001a\u00020\u00022\u0006\u0010\"\u001a\u00020\u00028\u0016@RX\u0096\u000e\u00a2\u0006\f\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&\u0082\u0002\u0007\n\u0005\b\u009920\u0001\u00a8\u0006("}, d2={"Lorg/valkyrienskies/core/util/datastructures/DenseBlockPosSet;", "Lorg/valkyrienskies/core/util/datastructures/IBlockPosSet;", "", "x", "y", "z", "", "add", "(III)Z", "canStore", "", "clear", "()V", "contains", "Lkotlin/Function3;", "fn", "forEach", "(Lkotlin/jvm/functions/Function3;)V", "Lkotlin/Function4;", "Lorg/valkyrienskies/core/util/datastructures/SingleChunkDenseBlockPosSet;", "forEachChunk", "(Lkotlin/jvm/functions/Function4;)V", "getChunk", "(III)Lorg/valkyrienskies/core/util/datastructures/SingleChunkDenseBlockPosSet;", "", "Lorg/joml/Vector3ic;", "iterator", "()Ljava/util/Iterator;", "remove", "Lorg/valkyrienskies/core/util/datastructures/BlockPos2ObjectOpenHashMap;", "chunks", "Lorg/valkyrienskies/core/util/datastructures/BlockPos2ObjectOpenHashMap;", "getChunks", "()Lorg/valkyrienskies/core/util/datastructures/BlockPos2ObjectOpenHashMap;", "<set-?>", "size", "I", "getSize", "()I", "<init>", "util"})
@SourceDebugExtension(value={"SMAP\nDenseBlockPosSet.kt\nKotlin\n*S Kotlin\n*F\n+ 1 DenseBlockPosSet.kt\norg/valkyrienskies/core/util/datastructures/DenseBlockPosSet\n+ 2 BlockPos2ObjectOpenHashMap.kt\norg/valkyrienskies/core/util/datastructures/BlockPos2ObjectOpenHashMap\n+ 3 SingleChunkDenseBlockPosSet.kt\norg/valkyrienskies/core/util/datastructures/SingleChunkDenseBlockPosSet\n+ 4 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n+ 5 Util.kt\norg/valkyrienskies/core/util/UtilKt\n*L\n1#1,90:1\n68#2,10:91\n68#2,2:101\n72#2,3:125\n77#2:143\n24#3:103\n25#3:106\n26#3,2:110\n28#3,4:117\n32#3:122\n33#3:124\n25#3,3:128\n28#3,4:136\n32#3,2:141\n13477#4,2:104\n13479#4:123\n10#5,3:107\n66#5,5:112\n14#5:121\n66#5,5:131\n14#5:140\n*S KotlinDebug\n*F\n+ 1 DenseBlockPosSet.kt\norg/valkyrienskies/core/util/datastructures/DenseBlockPosSet\n*L\n78#1:91,10\n84#1:101,2\n84#1:125,3\n84#1:143\n85#1:103\n85#1:106\n85#1:110,2\n85#1:117,4\n85#1:122\n85#1:124\n85#1:128,3\n85#1:136,4\n85#1:141,2\n85#1:104,2\n85#1:123\n85#1:107,3\n85#1:112,5\n85#1:121\n85#1:131,5\n85#1:140\n*E\n"})
public final class DenseBlockPosSet
implements IBlockPosSet {
    @NotNull
    private final BlockPos2ObjectOpenHashMap<SingleChunkDenseBlockPosSet> chunks = new BlockPos2ObjectOpenHashMap(0, 0.0f, 3, null);
    private int size;

    @NotNull
    public final BlockPos2ObjectOpenHashMap<SingleChunkDenseBlockPosSet> getChunks() {
        return this.chunks;
    }

    public int getSize() {
        return this.size;
    }

    @Nullable
    public final SingleChunkDenseBlockPosSet getChunk(int x, int y, int z) {
        return this.chunks.get(x >> 4, y >> 4, z >> 4);
    }

    @Override
    public boolean add(int x, int y, int z) {
        boolean prev2 = this.chunks.getOrPut(x >> 4, y >> 4, z >> 4, (Function0<SingleChunkDenseBlockPosSet>)((Function0)add.prev.1.INSTANCE)).add(x & 0xF, y & 0xF, z & 0xF);
        if (prev2) {
            int n2 = this.size();
            this.size = n2 + 1;
        }
        return prev2;
    }

    @Override
    public void clear() {
        this.chunks.clear();
        this.size = 0;
    }

    @Override
    @NotNull
    public Iterator<Vector3ic> iterator() {
        return new Iterator<Vector3ic>(this){
            private Vector3i lastReturnedVector;
            private final Iterator<Vector3ic> blockPosIterator;
            final /* synthetic */ DenseBlockPosSet this$0;
            {
                this.this$0 = $receiver;
                this.blockPosIterator = SequencesKt.sequence((Function2)((Function2)new Function2<SequenceScope<? super Vector3i>, Continuation<? super Unit>, Object>($receiver, this, null){
                    Object L$1;
                    Object L$2;
                    Object L$3;
                    int I$0;
                    int I$1;
                    int I$2;
                    int I$3;
                    int I$4;
                    int I$5;
                    int I$6;
                    int I$7;
                    int I$8;
                    byte B$0;
                    int label;
                    private /* synthetic */ Object L$0;
                    final /* synthetic */ DenseBlockPosSet this$0;
                    final /* synthetic */ iterator.1 this$1;
                    {
                        this.this$0 = $receiver;
                        this.this$1 = $receiver2;
                        super(2, $completion);
                    }

                    /*
                     * Unable to fully structure code
                     */
                    public final Object invokeSuspend(Object var1_1) {
                        block17: {
                            block14: {
                                block15: {
                                    block16: {
                                        var50_2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                                        block0 : switch (this.label) {
                                            case 0: {
                                                ResultKt.throwOnFailure((Object)var1_1);
                                                $this$sequence = (SequenceScope)this.L$0;
                                                var3_4 = this.this$0;
                                                var4_5 = this.this$1;
                                                $i$f$forEach = false;
                                                this_$iv$iv = this_$iv.getChunks();
                                                $i$f$forEach = false;
                                                if (!this_$iv$iv.getContainsNullKey()) break block16;
                                                var8_9 = this_$iv$iv.getValues()[this_$iv$iv.getN()];
                                                var9_10 = this_$iv$iv.getKeys()[this_$iv$iv.getN() * 3 + 2];
                                                var10_11 = this_$iv$iv.getKeys()[this_$iv$iv.getN() * 3 + 1];
                                                chunkX$iv = this_$iv$iv.getKeys()[this_$iv$iv.getN() * 3];
                                                $i$a$-forEach-DenseBlockPosSet$forEach$1$iv = false;
                                                this_$iv$iv = chunk$iv;
                                                $i$f$forEach = false;
                                                $this$forEachIndexed$iv$iv$iv = this_$iv$iv.getData();
                                                $i$f$forEachIndexed = false;
                                                index$iv$iv$iv = 0;
                                                var18_19 = 0;
                                                var19_20 = $this$forEachIndexed$iv$iv$iv.length;
lbl24:
                                                // 2 sources

                                                while (var18_19 < var19_20) {
                                                    item$iv$iv$iv = $this$forEachIndexed$iv$iv$iv[var18_19];
                                                    v0 = index$iv$iv$iv++;
                                                    var21_22 = item$iv$iv$iv;
                                                    index$iv$iv = v0;
                                                    $i$a$-forEachIndexed-SingleChunkDenseBlockPosSet$forEach$1$iv$iv = false;
                                                    $this$iterateBits$iv$iv$iv = byte$iv$iv;
                                                    $i$f$iterateBits = false;
                                                    i$iv$iv$iv = 7;
lbl33:
                                                    // 2 sources

                                                    while (-1 < i$iv$iv$iv) {
                                                        var28_29 = i$iv$iv$iv;
                                                        masked$iv$iv$iv = $this$iterateBits$iv$iv$iv & 1 << i$iv$iv$iv;
                                                        isSet$iv$iv = masked$iv$iv$iv != 0;
                                                        $i$a$-iterateBits-SingleChunkDenseBlockPosSet$forEach$1$1$iv$iv = false;
                                                        if (isSet$iv$iv) {
                                                            var31_32 = index$iv$iv * 8 + bitIndex$iv$iv;
                                                            dimensions$iv$iv$iv = SingleChunkDenseBlockPosSet.Companion.getDimensions();
                                                            $i$f$unwrapIndex = false;
                                                            z$iv$iv$iv = index$iv$iv$iv / (dimensions$iv$iv$iv.x() * dimensions$iv$iv$iv.y());
                                                            y$iv$iv$iv = (index$iv$iv$iv - z$iv$iv$iv * dimensions$iv$iv$iv.x() * dimensions$iv$iv$iv.y()) / dimensions$iv$iv$iv.x();
                                                            x$iv$iv$iv = (index$iv$iv$iv - z$iv$iv$iv * dimensions$iv$iv$iv.x() * dimensions$iv$iv$iv.y()) % dimensions$iv$iv$iv.x();
                                                            var37_38 = z$iv$iv$iv;
                                                            var38_39 = y$iv$iv$iv;
                                                            x$iv$iv = x$iv$iv$iv;
                                                            $i$a$-unwrapIndex-SingleChunkDenseBlockPosSet$forEach$1$1$1$iv$iv = false;
                                                            var41_42 = z$iv$iv;
                                                            var42_43 = y$iv$iv;
                                                            x$iv = x$iv$iv;
                                                            $i$a$-forEach-DenseBlockPosSet$forEach$1$1$iv = false;
                                                            var45_46 = z$iv + (chunkZ$iv << 4);
                                                            var46_47 = y$iv + (chunkY$iv << 4);
                                                            posX = x$iv + (chunkX$iv << 4);
                                                            $i$a$-forEach-DenseBlockPosSet$iterator$1$blockPosIterator$1$1 = false;
                                                            iterator.1.access$setLastReturnedVector$p(var4_5, new Vector3i(posX, posY, posZ));
                                                            v1 = iterator.1.access$getLastReturnedVector$p(var4_5);
                                                            Intrinsics.checkNotNull((Object)v1);
                                                            this.L$0 = $this$sequence;
                                                            this.L$1 = var4_5;
                                                            this.L$2 = this_$iv$iv;
                                                            this.L$3 = $this$forEachIndexed$iv$iv$iv;
                                                            this.I$0 = chunkZ$iv;
                                                            this.I$1 = chunkY$iv;
                                                            this.I$2 = chunkX$iv;
                                                            this.I$3 = index$iv$iv$iv;
                                                            this.I$4 = var18_19;
                                                            this.I$5 = var19_20;
                                                            this.I$6 = index$iv$iv;
                                                            this.B$0 = $this$iterateBits$iv$iv$iv;
                                                            this.I$7 = i$iv$iv$iv;
                                                            this.label = 1;
                                                            v2 = $this$sequence.yield((Object)v1, (Continuation)this);
                                                            if (v2 == var50_2) {
                                                                return var50_2;
                                                            }
                                                        }
                                                        ** GOTO lbl112
                                                    }
                                                    break block0;
                                                }
                                                break block16;
                                            }
                                            case 1: {
                                                $i$f$forEach = false;
                                                $i$f$forEach = false;
                                                $i$a$-forEach-DenseBlockPosSet$forEach$1$iv = false;
                                                $i$f$forEach = false;
                                                $i$f$forEachIndexed = false;
                                                $i$a$-forEachIndexed-SingleChunkDenseBlockPosSet$forEach$1$iv$iv = false;
                                                $i$f$iterateBits = false;
                                                $i$a$-iterateBits-SingleChunkDenseBlockPosSet$forEach$1$1$iv$iv = false;
                                                $i$f$unwrapIndex = false;
                                                $i$a$-unwrapIndex-SingleChunkDenseBlockPosSet$forEach$1$1$1$iv$iv = false;
                                                $i$a$-forEach-DenseBlockPosSet$forEach$1$1$iv = false;
                                                $i$a$-forEach-DenseBlockPosSet$iterator$1$blockPosIterator$1$1 = false;
                                                i$iv$iv$iv = this.I$7;
                                                $this$iterateBits$iv$iv$iv = this.B$0;
                                                index$iv$iv = this.I$6;
                                                var19_20 = this.I$5;
                                                var18_19 = this.I$4;
                                                index$iv$iv$iv = this.I$3;
                                                chunkX$iv = this.I$2;
                                                chunkY$iv = this.I$1;
                                                chunkZ$iv = this.I$0;
                                                $this$forEachIndexed$iv$iv$iv = (byte[])this.L$3;
                                                this_$iv$iv = (BlockPos2ObjectOpenHashMap)this.L$2;
                                                var4_5 = this.L$1;
                                                $this$sequence = (SequenceScope)this.L$0;
                                                ResultKt.throwOnFailure((Object)$result);
                                                v2 = $result;
lbl112:
                                                // 2 sources

                                                --i$iv$iv$iv;
                                                ** GOTO lbl33
                                            }
                                        }
                                        ++var18_19;
                                        ** GOTO lbl24
                                    }
                                    pos$iv$iv = this_$iv$iv.getN();
lbl118:
                                    // 2 sources

                                    while (-1 < pos$iv$iv) {
                                        if (this_$iv$iv.getKeys()[pos$iv$iv * 3] == 0 && this_$iv$iv.getKeys()[pos$iv$iv * 3 + 1] == 0 && this_$iv$iv.getKeys()[pos$iv$iv * 3 + 2] == 0) break block14;
                                        chunk$iv = this_$iv$iv.getValues()[pos$iv$iv];
                                        chunkZ$iv = this_$iv$iv.getKeys()[pos$iv$iv * 3 + 2];
                                        chunkY$iv = this_$iv$iv.getKeys()[pos$iv$iv * 3 + 1];
                                        chunkX$iv = this_$iv$iv.getKeys()[pos$iv$iv * 3];
                                        $i$a$-forEach-DenseBlockPosSet$forEach$1$iv = false;
                                        this_$iv$iv = chunk$iv;
                                        $i$f$forEach = false;
                                        $this$forEachIndexed$iv$iv$iv = this_$iv$iv.getData();
                                        $i$f$forEachIndexed = false;
                                        index$iv$iv$iv = 0;
                                        var18_19 = 0;
                                        var19_20 = $this$forEachIndexed$iv$iv$iv.length;
lbl132:
                                        // 2 sources

                                        while (var18_19 < var19_20) {
                                            item$iv$iv$iv = $this$forEachIndexed$iv$iv$iv[var18_19];
                                            v3 = index$iv$iv$iv++;
                                            byte$iv$iv = item$iv$iv$iv;
                                            index$iv$iv = v3;
                                            $i$a$-forEachIndexed-SingleChunkDenseBlockPosSet$forEach$1$iv$iv = false;
                                            $this$iterateBits$iv$iv$iv = byte$iv$iv;
                                            $i$f$iterateBits = false;
                                            i$iv$iv$iv = 7;
lbl141:
                                            // 2 sources

                                            while (-1 < i$iv$iv$iv) {
                                                masked$iv$iv$iv = $this$iterateBits$iv$iv$iv & 1 << i$iv$iv$iv;
                                                v4 = masked$iv$iv$iv != 0;
                                                bitIndex$iv$iv = i$iv$iv$iv;
                                                isSet$iv$iv = v4;
                                                $i$a$-iterateBits-SingleChunkDenseBlockPosSet$forEach$1$1$iv$iv = false;
                                                if (isSet$iv$iv) {
                                                    index$iv$iv$iv = index$iv$iv * 8 + bitIndex$iv$iv;
                                                    dimensions$iv$iv$iv = SingleChunkDenseBlockPosSet.Companion.getDimensions();
                                                    $i$f$unwrapIndex = false;
                                                    z$iv$iv$iv = index$iv$iv$iv / (dimensions$iv$iv$iv.x() * dimensions$iv$iv$iv.y());
                                                    y$iv$iv$iv = (index$iv$iv$iv - z$iv$iv$iv * dimensions$iv$iv$iv.x() * dimensions$iv$iv$iv.y()) / dimensions$iv$iv$iv.x();
                                                    x$iv$iv$iv = (index$iv$iv$iv - z$iv$iv$iv * dimensions$iv$iv$iv.x() * dimensions$iv$iv$iv.y()) % dimensions$iv$iv$iv.x();
                                                    z$iv$iv = z$iv$iv$iv;
                                                    y$iv$iv = y$iv$iv$iv;
                                                    x$iv$iv = x$iv$iv$iv;
                                                    $i$a$-unwrapIndex-SingleChunkDenseBlockPosSet$forEach$1$1$1$iv$iv = false;
                                                    z$iv = z$iv$iv;
                                                    y$iv = y$iv$iv;
                                                    x$iv = x$iv$iv;
                                                    $i$a$-forEach-DenseBlockPosSet$forEach$1$1$iv = false;
                                                    posZ = z$iv + (chunkZ$iv << 4);
                                                    posY = y$iv + (chunkY$iv << 4);
                                                    posX = x$iv + (chunkX$iv << 4);
                                                    $i$a$-forEach-DenseBlockPosSet$iterator$1$blockPosIterator$1$1 = false;
                                                    iterator.1.access$setLastReturnedVector$p(var4_5, new Vector3i(posX, posY, posZ));
                                                    v5 = iterator.1.access$getLastReturnedVector$p(var4_5);
                                                    Intrinsics.checkNotNull((Object)v5);
                                                    this.L$0 = $this$sequence;
                                                    this.L$1 = var4_5;
                                                    this.L$2 = this_$iv$iv;
                                                    this.L$3 = $this$forEachIndexed$iv$iv$iv;
                                                    this.I$0 = chunkZ$iv;
                                                    this.I$1 = chunkY$iv;
                                                    this.I$2 = chunkX$iv;
                                                    this.I$3 = index$iv$iv$iv;
                                                    this.I$4 = var18_19;
                                                    this.I$5 = var19_20;
                                                    this.I$6 = index$iv$iv;
                                                    this.B$0 = $this$iterateBits$iv$iv$iv;
                                                    this.I$7 = i$iv$iv$iv;
                                                    this.I$8 = pos$iv$iv;
                                                    this.label = 2;
                                                    v6 = $this$sequence.yield((Object)v5, (Continuation)this);
                                                    if (v6 == var50_2) {
                                                        return var50_2;
                                                    }
                                                }
                                                ** GOTO lbl224
                                            }
                                            break block15;
                                        }
                                        break block14;
                                    }
                                    {
                                        break block17;
                                        case 2: {
                                            $i$f$forEach = false;
                                            $i$f$forEach = false;
                                            $i$a$-forEach-DenseBlockPosSet$forEach$1$iv = false;
                                            $i$f$forEach = false;
                                            $i$f$forEachIndexed = false;
                                            $i$a$-forEachIndexed-SingleChunkDenseBlockPosSet$forEach$1$iv$iv = false;
                                            $i$f$iterateBits = false;
                                            $i$a$-iterateBits-SingleChunkDenseBlockPosSet$forEach$1$1$iv$iv = false;
                                            $i$f$unwrapIndex = false;
                                            $i$a$-unwrapIndex-SingleChunkDenseBlockPosSet$forEach$1$1$1$iv$iv = false;
                                            $i$a$-forEach-DenseBlockPosSet$forEach$1$1$iv = false;
                                            $i$a$-forEach-DenseBlockPosSet$iterator$1$blockPosIterator$1$1 = false;
                                            pos$iv$iv = this.I$8;
                                            i$iv$iv$iv = this.I$7;
                                            $this$iterateBits$iv$iv$iv = this.B$0;
                                            index$iv$iv = this.I$6;
                                            var19_20 = this.I$5;
                                            var18_19 = this.I$4;
                                            index$iv$iv$iv = this.I$3;
                                            chunkX$iv = this.I$2;
                                            chunkY$iv = this.I$1;
                                            chunkZ$iv = this.I$0;
                                            $this$forEachIndexed$iv$iv$iv = (byte[])this.L$3;
                                            this_$iv$iv = (BlockPos2ObjectOpenHashMap)this.L$2;
                                            var4_5 = this.L$1;
                                            $this$sequence = (SequenceScope)this.L$0;
                                            ResultKt.throwOnFailure((Object)$result);
                                            v6 = $result;
lbl224:
                                            // 2 sources

                                            --i$iv$iv$iv;
                                            ** GOTO lbl141
                                        }
                                    }
                                }
                                ++var18_19;
                                ** GOTO lbl132
                            }
                            --pos$iv$iv;
                            ** GOTO lbl118
                        }
                        return Unit.INSTANCE;
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }

                    public final Continuation<Unit> create(Object value, Continuation<?> $completion) {
                        var var3_3 = new /* invalid duplicate definition of identical inner class */;
                        var3_3.L$0 = value;
                        return (Continuation)var3_3;
                    }

                    public final Object invoke(SequenceScope<? super Vector3i> p1, Continuation<? super Unit> p2) {
                        return (this.create(p1, p2)).invokeSuspend(Unit.INSTANCE);
                    }
                })).iterator();
            }

            public boolean hasNext() {
                return this.blockPosIterator.hasNext();
            }

            public Vector3ic next() {
                return this.blockPosIterator.next();
            }

            public void remove() {
                if (this.lastReturnedVector == null) {
                    throw new IllegalStateException("Remove is not ready!");
                }
                Vector3i vector3i = this.lastReturnedVector;
                Intrinsics.checkNotNull((Object)vector3i);
                int n2 = vector3i.x;
                Vector3i vector3i2 = this.lastReturnedVector;
                Intrinsics.checkNotNull((Object)vector3i2);
                int n3 = vector3i2.y;
                Vector3i vector3i3 = this.lastReturnedVector;
                Intrinsics.checkNotNull((Object)vector3i3);
                this.this$0.remove(n2, n3, vector3i3.z);
                this.lastReturnedVector = null;
            }

            public static final /* synthetic */ void access$setLastReturnedVector$p(iterator.1 $this, Vector3i vector3i) {
                $this.lastReturnedVector = vector3i;
            }

            public static final /* synthetic */ Vector3i access$getLastReturnedVector$p(iterator.1 $this) {
                return $this.lastReturnedVector;
            }
        };
    }

    @Override
    public boolean remove(int x, int y, int z) {
        boolean prev2;
        SingleChunkDenseBlockPosSet singleChunkDenseBlockPosSet = this.chunks.get(x >> 4, y >> 4, z >> 4);
        boolean bl = prev2 = singleChunkDenseBlockPosSet != null ? singleChunkDenseBlockPosSet.remove(x & 0xF, y & 0xF, z & 0xF) : false;
        if (prev2) {
            int n2 = this.size();
            this.size = n2 + -1;
        }
        return prev2;
    }

    @Override
    public boolean contains(int x, int y, int z) {
        SingleChunkDenseBlockPosSet singleChunkDenseBlockPosSet = this.chunks.get(x >> 4, y >> 4, z >> 4);
        return singleChunkDenseBlockPosSet != null ? singleChunkDenseBlockPosSet.contains(x & 0xF, y & 0xF, z & 0xF) : false;
    }

    @Override
    public boolean canStore(int x, int y, int z) {
        return true;
    }

    public final void forEachChunk(@NotNull Function4<? super Integer, ? super Integer, ? super Integer, ? super SingleChunkDenseBlockPosSet, Unit> fn) {
        SingleChunkDenseBlockPosSet chunk;
        int z;
        int y;
        boolean bl;
        int x;
        Intrinsics.checkNotNullParameter(fn, (String)"fn");
        boolean $i$f$forEachChunk = false;
        BlockPos2ObjectOpenHashMap<SingleChunkDenseBlockPosSet> this_$iv = this.getChunks();
        boolean $i$f$forEach = false;
        if (this_$iv.getContainsNullKey()) {
            SingleChunkDenseBlockPosSet singleChunkDenseBlockPosSet = this_$iv.getValues()[this_$iv.getN()];
            int n2 = this_$iv.getKeys()[this_$iv.getN() * 3 + 2];
            int n3 = this_$iv.getKeys()[this_$iv.getN() * 3 + 1];
            x = this_$iv.getKeys()[this_$iv.getN() * 3];
            bl = false;
            fn.invoke((Object)x, (Object)y, (Object)z, (Object)chunk);
        }
        for (int pos$iv = this_$iv.getN(); -1 < pos$iv; --pos$iv) {
            if (this_$iv.getKeys()[pos$iv * 3] == 0 && this_$iv.getKeys()[pos$iv * 3 + 1] == 0 && this_$iv.getKeys()[pos$iv * 3 + 2] == 0) continue;
            chunk = this_$iv.getValues()[pos$iv];
            z = this_$iv.getKeys()[pos$iv * 3 + 2];
            y = this_$iv.getKeys()[pos$iv * 3 + 1];
            x = this_$iv.getKeys()[pos$iv * 3];
            bl = false;
            fn.invoke((Object)x, (Object)y, (Object)z, (Object)chunk);
        }
    }

    public final void forEach(@NotNull Function3<? super Integer, ? super Integer, ? super Integer, Unit> fn) {
        int chunkZ;
        int z;
        int chunkY;
        int y;
        boolean bl;
        int x;
        int y$iv;
        int z$iv;
        boolean bl2;
        int x$iv;
        int x$iv$iv;
        int y$iv$iv;
        int z$iv$iv;
        int index$iv$iv;
        boolean $i$f$unwrapIndex;
        Vector3ic dimensions$iv$iv;
        int bitIndex$iv;
        boolean bl3;
        boolean isSet$iv;
        int masked$iv$iv;
        int i$iv$iv;
        boolean $i$f$iterateBits;
        byte $this$iterateBits$iv$iv;
        byte byte$iv;
        boolean bl4;
        int index$iv;
        int index$iv$iv2;
        boolean $i$f$forEachIndexed;
        byte[] $this$forEachIndexed$iv$iv;
        boolean $i$f$forEach;
        SingleChunkDenseBlockPosSet this_$iv;
        SingleChunkDenseBlockPosSet chunk;
        boolean bl5;
        int chunkX;
        Intrinsics.checkNotNullParameter(fn, (String)"fn");
        boolean $i$f$forEach2 = false;
        BlockPos2ObjectOpenHashMap<SingleChunkDenseBlockPosSet> this_$iv2 = this.getChunks();
        boolean $i$f$forEach3 = false;
        if (this_$iv2.getContainsNullKey()) {
            SingleChunkDenseBlockPosSet singleChunkDenseBlockPosSet = this_$iv2.getValues()[this_$iv2.getN()];
            int n2 = this_$iv2.getKeys()[this_$iv2.getN() * 3 + 2];
            int n3 = this_$iv2.getKeys()[this_$iv2.getN() * 3 + 1];
            chunkX = this_$iv2.getKeys()[this_$iv2.getN() * 3];
            bl5 = false;
            this_$iv = chunk;
            $i$f$forEach = false;
            $this$forEachIndexed$iv$iv = this_$iv.getData();
            $i$f$forEachIndexed = false;
            index$iv$iv2 = 0;
            for (byte item$iv$iv : $this$forEachIndexed$iv$iv) {
                int n4 = index$iv$iv2++;
                byte by = item$iv$iv;
                index$iv = n4;
                bl4 = false;
                $this$iterateBits$iv$iv = byte$iv;
                $i$f$iterateBits = false;
                for (i$iv$iv = 7; -1 < i$iv$iv; --i$iv$iv) {
                    int n5 = i$iv$iv;
                    masked$iv$iv = $this$iterateBits$iv$iv & 1 << i$iv$iv;
                    isSet$iv = masked$iv$iv != 0;
                    bl3 = false;
                    if (!isSet$iv) continue;
                    int n6 = index$iv * 8 + bitIndex$iv;
                    dimensions$iv$iv = SingleChunkDenseBlockPosSet.Companion.getDimensions();
                    $i$f$unwrapIndex = false;
                    z$iv$iv = index$iv$iv / (dimensions$iv$iv.x() * dimensions$iv$iv.y());
                    y$iv$iv = (index$iv$iv - z$iv$iv * dimensions$iv$iv.x() * dimensions$iv$iv.y()) / dimensions$iv$iv.x();
                    x$iv$iv = (index$iv$iv - z$iv$iv * dimensions$iv$iv.x() * dimensions$iv$iv.y()) % dimensions$iv$iv.x();
                    int n7 = z$iv$iv;
                    int n8 = y$iv$iv;
                    x$iv = x$iv$iv;
                    bl2 = false;
                    void var38_38 = z$iv;
                    void var39_39 = y$iv;
                    x = x$iv;
                    bl = false;
                    fn.invoke((Object)(x + (chunkX << 4)), (Object)(y + (chunkY << 4)), (Object)(z + (chunkZ << 4)));
                }
            }
        }
        for (int pos$iv = this_$iv2.getN(); -1 < pos$iv; --pos$iv) {
            if (this_$iv2.getKeys()[pos$iv * 3] == 0 && this_$iv2.getKeys()[pos$iv * 3 + 1] == 0 && this_$iv2.getKeys()[pos$iv * 3 + 2] == 0) continue;
            chunk = this_$iv2.getValues()[pos$iv];
            chunkZ = this_$iv2.getKeys()[pos$iv * 3 + 2];
            chunkY = this_$iv2.getKeys()[pos$iv * 3 + 1];
            chunkX = this_$iv2.getKeys()[pos$iv * 3];
            bl5 = false;
            this_$iv = chunk;
            $i$f$forEach = false;
            $this$forEachIndexed$iv$iv = this_$iv.getData();
            $i$f$forEachIndexed = false;
            index$iv$iv2 = 0;
            for (byte item$iv$iv : $this$forEachIndexed$iv$iv) {
                int n9 = index$iv$iv2++;
                byte$iv = item$iv$iv;
                index$iv = n9;
                bl4 = false;
                $this$iterateBits$iv$iv = byte$iv;
                $i$f$iterateBits = false;
                for (i$iv$iv = 7; -1 < i$iv$iv; --i$iv$iv) {
                    masked$iv$iv = $this$iterateBits$iv$iv & 1 << i$iv$iv;
                    boolean bl6 = masked$iv$iv != 0;
                    bitIndex$iv = i$iv$iv;
                    isSet$iv = bl6;
                    bl3 = false;
                    if (!isSet$iv) continue;
                    index$iv$iv = index$iv * 8 + bitIndex$iv;
                    dimensions$iv$iv = SingleChunkDenseBlockPosSet.Companion.getDimensions();
                    $i$f$unwrapIndex = false;
                    z$iv$iv = index$iv$iv / (dimensions$iv$iv.x() * dimensions$iv$iv.y());
                    y$iv$iv = (index$iv$iv - z$iv$iv * dimensions$iv$iv.x() * dimensions$iv$iv.y()) / dimensions$iv$iv.x();
                    x$iv$iv = (index$iv$iv - z$iv$iv * dimensions$iv$iv.x() * dimensions$iv$iv.y()) % dimensions$iv$iv.x();
                    z$iv = z$iv$iv;
                    y$iv = y$iv$iv;
                    x$iv = x$iv$iv;
                    bl2 = false;
                    z = z$iv;
                    y = y$iv;
                    x = x$iv;
                    bl = false;
                    fn.invoke((Object)(x + (chunkX << 4)), (Object)(y + (chunkY << 4)), (Object)(z + (chunkZ << 4)));
                }
            }
        }
    }
}

