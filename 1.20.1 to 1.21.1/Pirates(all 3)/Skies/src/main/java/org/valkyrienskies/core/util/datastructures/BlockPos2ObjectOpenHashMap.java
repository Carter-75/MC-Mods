/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  it.unimi.dsi.fastutil.HashCommon
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.collections.ArraysKt
 *  kotlin.jvm.functions.Function0
 *  kotlin.jvm.functions.Function4
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 */
package org.valkyrienskies.core.util.datastructures;

import it.unimi.dsi.fastutil.HashCommon;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.joml.Vector3ic;
import org.valkyrienskies.core.util.datastructures.MurmurHash3;

@Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u0000Z\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u001e\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0002\b\u000f\n\u0002\u0010\u0011\n\u0002\b\u000b\u0018\u0000 V*\u0004\b\u0000\u0010\u00012\u00020\u0002:\u0002VWB\u001b\u0012\b\b\u0002\u0010R\u001a\u00020\u0006\u0012\b\b\u0002\u0010S\u001a\u00020:\u00a2\u0006\u0004\bT\u0010UJ\r\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0004\u0010\u0005J%\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u0006\u00a2\u0006\u0004\b\u000b\u0010\fJ'\u0010\r\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u0006H\u0002\u00a2\u0006\u0004\b\r\u0010\u000eJ9\u0010\u0011\u001a\u00020\u00032$\u0010\u0010\u001a \u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00030\u000fH\u0086\b\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0011\u0010\u0012J\u001b\u0010\u0011\u001a\u00020\u00032\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00000\u0013\u00a2\u0006\u0004\b\u0011\u0010\u0014J'\u0010\u0015\u001a\u0004\u0018\u00018\u00002\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u0006\u00a2\u0006\u0004\b\u0015\u0010\u0016J3\u0010\u0019\u001a\u00028\u00002\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u00062\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00028\u00000\u0017\u00a2\u0006\u0004\b\u0019\u0010\u001aJ#\u0010\u0019\u001a\u00028\u00002\u0006\u0010\u001c\u001a\u00020\u001b2\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00028\u00000\u0017\u00a2\u0006\u0004\b\u0019\u0010\u001dJ'\u0010\u001e\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u0006H\u0002\u00a2\u0006\u0004\b\u001e\u0010\u000eJ9\u0010 \u001a\u00020\u00032\u0006\u0010\u001c\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u00062\b\u0010\u001f\u001a\u0004\u0018\u00018\u0000H\u0002\u00a2\u0006\u0004\b \u0010!J1\u0010\"\u001a\u0004\u0018\u00018\u00002\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u00062\b\u0010\u001f\u001a\u0004\u0018\u00018\u0000\u00a2\u0006\u0004\b\"\u0010#J\u0017\u0010%\u001a\u00020\u00032\u0006\u0010$\u001a\u00020\u0006H\u0002\u00a2\u0006\u0004\b%\u0010&J'\u0010'\u001a\u0004\u0018\u00018\u00002\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u0006\u00a2\u0006\u0004\b'\u0010\u0016J\u0019\u0010(\u001a\u0004\u0018\u00018\u00002\u0006\u0010\u001c\u001a\u00020\u0006H\u0002\u00a2\u0006\u0004\b(\u0010)J\u0011\u0010*\u001a\u0004\u0018\u00018\u0000H\u0002\u00a2\u0006\u0004\b*\u0010+J\"\u0010-\u001a\u0004\u0018\u00018\u00002\u0006\u0010\u001c\u001a\u00020\u001b2\u0006\u0010,\u001a\u00028\u0000H\u0086\u0002\u00a2\u0006\u0004\b-\u0010.J\u0017\u0010/\u001a\u00020\u00032\u0006\u0010\u001c\u001a\u00020\u0006H\u0002\u00a2\u0006\u0004\b/\u0010&R$\u00101\u001a\u00020\n2\u0006\u00100\u001a\u00020\n8\u0006@BX\u0086\u000e\u00a2\u0006\f\n\u0004\b1\u00102\u001a\u0004\b3\u00104R$\u00105\u001a\u0004\u0018\u00018\u00008\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b5\u00106\u001a\u0004\b7\u0010+\"\u0004\b8\u00109R\u0014\u0010;\u001a\u00020:8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b;\u0010<R$\u0010>\u001a\u00020=2\u0006\u00100\u001a\u00020=8\u0006@BX\u0086\u000e\u00a2\u0006\f\n\u0004\b>\u0010?\u001a\u0004\b@\u0010AR\u0014\u0010D\u001a\u00020\u00068BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\bB\u0010CR\u0016\u0010E\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bE\u0010FR\u0014\u0010G\u001a\u00020\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bG\u0010FR$\u0010H\u001a\u00020\u00062\u0006\u00100\u001a\u00020\u00068\u0006@BX\u0086\u000e\u00a2\u0006\f\n\u0004\bH\u0010F\u001a\u0004\bI\u0010CR\u0014\u0010K\u001a\u00020\u00068BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\bJ\u0010CR\u0016\u0010L\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bL\u0010FR4\u0010N\u001a\n\u0012\u0006\u0012\u0004\u0018\u00018\u00000M2\u000e\u00100\u001a\n\u0012\u0006\u0012\u0004\u0018\u00018\u00000M8\u0006@BX\u0086\u000e\u00a2\u0006\f\n\u0004\bN\u0010O\u001a\u0004\bP\u0010Q\u0082\u0002\u0007\n\u0005\b\u009920\u0001\u00a8\u0006X"}, d2={"Lorg/valkyrienskies/core/util/datastructures/BlockPos2ObjectOpenHashMap;", "T", "", "", "clear", "()V", "", "x", "y", "z", "", "contains", "(III)Z", "find", "(III)I", "Lkotlin/Function4;", "fn", "forEach", "(Lkotlin/jvm/functions/Function4;)V", "Lorg/valkyrienskies/core/util/datastructures/BlockPos2ObjectOpenHashMap$EntryConsumer;", "(Lorg/valkyrienskies/core/util/datastructures/BlockPos2ObjectOpenHashMap$EntryConsumer;)V", "get", "(III)Ljava/lang/Object;", "Lkotlin/Function0;", "default", "getOrPut", "(IIILkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "Lorg/joml/Vector3ic;", "pos", "(Lorg/joml/Vector3ic;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "hash", "v", "insert", "(IIIILjava/lang/Object;)V", "put", "(IIILjava/lang/Object;)Ljava/lang/Object;", "newN", "rehash", "(I)V", "remove", "removeEntry", "(I)Ljava/lang/Object;", "removeNullEntry", "()Ljava/lang/Object;", "value", "set", "(Lorg/joml/Vector3ic;Ljava/lang/Object;)Ljava/lang/Object;", "shiftKeys", "<set-?>", "containsNullKey", "Z", "getContainsNullKey", "()Z", "defRetValue", "Ljava/lang/Object;", "getDefRetValue", "setDefRetValue", "(Ljava/lang/Object;)V", "", "f", "F", "", "keys", "[I", "getKeys", "()[I", "getMask", "()I", "mask", "maxFill", "I", "minN", "n", "getN", "getRealSize", "realSize", "size", "", "values", "[Ljava/lang/Object;", "getValues", "()[Ljava/lang/Object;", "expected", "loadFactor", "<init>", "(IF)V", "Companion", "EntryConsumer", "util"})
@SourceDebugExtension(value={"SMAP\nBlockPos2ObjectOpenHashMap.kt\nKotlin\n*S Kotlin\n*F\n+ 1 BlockPos2ObjectOpenHashMap.kt\norg/valkyrienskies/core/util/datastructures/BlockPos2ObjectOpenHashMap\n*L\n1#1,273:1\n68#1,10:274\n*S KotlinDebug\n*F\n+ 1 BlockPos2ObjectOpenHashMap.kt\norg/valkyrienskies/core/util/datastructures/BlockPos2ObjectOpenHashMap\n*L\n80#1:274,10\n*E\n"})
public final class BlockPos2ObjectOpenHashMap<T> {
    @NotNull
    public static final Companion Companion = new Companion(null);
    private int n;
    private int size;
    @NotNull
    private int[] keys;
    @NotNull
    private T[] values;
    private boolean containsNullKey;
    private int maxFill;
    @Nullable
    private T defRetValue;
    private final int minN;
    private final float f;
    public static final int NUM_KEYS = 3;

    public BlockPos2ObjectOpenHashMap(int expected, float loadFactor) {
        this.f = loadFactor;
        this.minN = this.n = HashCommon.arraySize((int)expected, (float)this.f);
        this.maxFill = HashCommon.maxFill((int)this.n, (float)loadFactor);
        this.keys = new int[(this.n + 1) * 3];
        this.values = new Object[this.n + 1];
    }

    public /* synthetic */ BlockPos2ObjectOpenHashMap(int n2, float f2, int n3, DefaultConstructorMarker defaultConstructorMarker) {
        if ((n3 & 1) != 0) {
            n2 = 10;
        }
        if ((n3 & 2) != 0) {
            f2 = 0.75f;
        }
        this(n2, f2);
    }

    public final int getN() {
        return this.n;
    }

    @NotNull
    public final int[] getKeys() {
        return this.keys;
    }

    @NotNull
    public final T[] getValues() {
        return this.values;
    }

    public final boolean getContainsNullKey() {
        return this.containsNullKey;
    }

    @Nullable
    public final T getDefRetValue() {
        return this.defRetValue;
    }

    public final void setDefRetValue(@Nullable T t) {
        this.defRetValue = t;
    }

    private final int getMask() {
        return this.n - 1;
    }

    private final int getRealSize() {
        return this.containsNullKey ? this.size - 1 : this.size;
    }

    @Nullable
    public final T get(int x, int y, int z) {
        int pos = this.find(x, y, z);
        return pos < 0 ? this.defRetValue : this.values[pos];
    }

    public final void clear() {
        if (this.size == 0) {
            return;
        }
        this.size = 0;
        this.containsNullKey = false;
        ArraysKt.fill$default((int[])this.keys, (int)0, (int)0, (int)0, (int)6, null);
        ArraysKt.fill$default((Object[])this.values, null, (int)0, (int)0, (int)6, null);
    }

    public final T getOrPut(int x, int y, int z, @NotNull Function0<? extends T> function0) {
        Object object;
        Intrinsics.checkNotNullParameter(function0, (String)"default");
        if (this.contains(x, y, z)) {
            object = this.get(x, y, z);
        } else {
            Object newValue = function0.invoke();
            this.put(x, y, z, newValue);
            object = newValue;
        }
        return object;
    }

    public final T getOrPut(@NotNull Vector3ic pos, @NotNull Function0<? extends T> function0) {
        Intrinsics.checkNotNullParameter((Object)pos, (String)"pos");
        Intrinsics.checkNotNullParameter(function0, (String)"default");
        return this.getOrPut(pos.x(), pos.y(), pos.z(), function0);
    }

    public final void forEach(@NotNull Function4<? super Integer, ? super Integer, ? super Integer, ? super T, Unit> fn) {
        Intrinsics.checkNotNullParameter(fn, (String)"fn");
        boolean $i$f$forEach = false;
        if (this.getContainsNullKey()) {
            fn.invoke((Object)this.getKeys()[this.getN() * 3], (Object)this.getKeys()[this.getN() * 3 + 1], (Object)this.getKeys()[this.getN() * 3 + 2], this.getValues()[this.getN()]);
        }
        for (int pos = this.getN(); -1 < pos; --pos) {
            if (this.getKeys()[pos * 3] == 0 && this.getKeys()[pos * 3 + 1] == 0 && this.getKeys()[pos * 3 + 2] == 0) continue;
            fn.invoke((Object)this.getKeys()[pos * 3], (Object)this.getKeys()[pos * 3 + 1], (Object)this.getKeys()[pos * 3 + 2], this.getValues()[pos]);
        }
    }

    public final void forEach(@NotNull EntryConsumer<T> fn) {
        T v;
        int z;
        int y;
        boolean bl;
        int x;
        Intrinsics.checkNotNullParameter(fn, (String)"fn");
        BlockPos2ObjectOpenHashMap this_$iv = this;
        boolean $i$f$forEach = false;
        if (this_$iv.getContainsNullKey()) {
            T t = this_$iv.getValues()[this_$iv.getN()];
            int n2 = this_$iv.getKeys()[this_$iv.getN() * 3 + 2];
            int n3 = this_$iv.getKeys()[this_$iv.getN() * 3 + 1];
            x = this_$iv.getKeys()[this_$iv.getN() * 3];
            bl = false;
            fn.accept(x, y, z, v);
        }
        for (int pos$iv = this_$iv.getN(); -1 < pos$iv; --pos$iv) {
            if (this_$iv.getKeys()[pos$iv * 3] == 0 && this_$iv.getKeys()[pos$iv * 3 + 1] == 0 && this_$iv.getKeys()[pos$iv * 3 + 2] == 0) continue;
            v = this_$iv.getValues()[pos$iv];
            z = this_$iv.getKeys()[pos$iv * 3 + 2];
            y = this_$iv.getKeys()[pos$iv * 3 + 1];
            x = this_$iv.getKeys()[pos$iv * 3];
            bl = false;
            fn.accept(x, y, z, v);
        }
    }

    @Nullable
    public final T put(int x, int y, int z, @Nullable T v) {
        int pos = this.find(x, y, z);
        if (pos < 0) {
            this.insert(-pos - 1, x, y, z, v);
            return this.defRetValue;
        }
        T oldValue = this.values[pos];
        this.values[pos] = v;
        return oldValue;
    }

    @Nullable
    public final T remove(int x, int y, int z) {
        if (x == 0 && y == 0 && z == 0) {
            return this.containsNullKey ? this.removeNullEntry() : this.defRetValue;
        }
        int pos = this.find(x, y, z);
        if (pos < 0) {
            return this.defRetValue;
        }
        return this.removeEntry(pos);
    }

    public final boolean contains(int x, int y, int z) {
        return this.find(x, y, z) >= 0;
    }

    private final T removeNullEntry() {
        this.containsNullKey = false;
        T oldValue = this.values[this.n];
        int n2 = this.size;
        this.size = n2 + -1;
        if (this.n > this.minN && this.size < this.maxFill / 4 && this.n > 16) {
            this.rehash(this.n / 2);
        }
        return oldValue;
    }

    private final T removeEntry(int pos) {
        T oldValue = this.values[pos];
        int n2 = this.size;
        this.size = n2 + -1;
        this.shiftKeys(pos);
        if (this.n > this.minN && this.size < this.maxFill / 4 && this.n > 16) {
            this.rehash(this.n / 2);
        }
        return oldValue;
    }

    private final void shiftKeys(int pos) {
        int pos2 = pos;
        int last2 = 0;
        int slot = 0;
        int curX = 0;
        int curY = 0;
        int curZ = 0;
        int[] key = this.keys;
        while (true) {
            last2 = pos2;
            pos2 = pos2 + 1 & this.getMask();
            while (true) {
                curX = key[pos2 * 3];
                curY = key[pos2 * 3 + 1];
                curZ = key[pos2 * 3 + 2];
                if (curX == 0 && curY == 0 && curZ == 0) {
                    key[last2 * 3] = 0;
                    key[last2 * 3 + 1] = 0;
                    key[last2 * 3 + 2] = 0;
                    return;
                }
                slot = this.hash(curX, curY, curZ) & this.getMask();
                if (last2 <= pos2 ? last2 >= slot || slot > pos2 : last2 >= slot && slot > pos2) break;
                pos2 = pos2 + 1 & this.getMask();
            }
            key[last2 * 3] = curX;
            key[last2 * 3 + 1] = curY;
            key[last2 * 3 + 2] = curZ;
            this.values[last2] = this.values[pos2];
        }
    }

    private final int hash(int x, int y, int z) {
        int hash = 0;
        hash = MurmurHash3.INSTANCE.mix32(x, hash);
        hash = MurmurHash3.INSTANCE.mix32(y, hash);
        hash = MurmurHash3.INSTANCE.mix32(z, hash);
        return MurmurHash3.INSTANCE.fmix32(hash ^= 0xC);
    }

    private final void insert(int pos, int x, int y, int z, T v) {
        if (pos == this.n) {
            this.containsNullKey = true;
        }
        int keyPos = pos * 3;
        this.keys[keyPos] = x;
        this.keys[keyPos + 1] = y;
        this.keys[keyPos + 2] = z;
        this.values[pos] = v;
        int n2 = this.size;
        this.size = n2 + 1;
        if (n2 >= this.maxFill) {
            this.rehash(HashCommon.arraySize((int)(this.size + 1), (float)this.f));
        }
    }

    private final void rehash(int newN) {
        int[] keys2 = this.keys;
        T[] values2 = this.values;
        int newMask = newN - 1;
        int[] newKey = new int[(newN + 1) * 3];
        Object[] newValue = new Object[newN + 1];
        int pos = 0;
        int j2 = this.getRealSize();
        int i2 = this.n * 3;
        while (j2-- != 0) {
            while (keys2[i2 -= 3] == 0 && keys2[i2 + 1] == 0 && keys2[i2 + 2] == 0) {
            }
            int oldPos = i2 / 3;
            pos = this.hash(keys2[i2], keys2[i2 + 1], keys2[i2 + 2]) & newMask;
            int keyPos = pos * 3;
            while (newKey[keyPos] != 0 || newKey[keyPos + 1] != 0 || newKey[keyPos + 2] != 0) {
                pos = pos + 1 & newMask;
                keyPos = pos * 3;
            }
            newKey[keyPos] = keys2[i2];
            newKey[keyPos + 1] = keys2[i2 + 1];
            newKey[keyPos + 2] = keys2[i2 + 2];
            newValue[pos] = values2[oldPos];
        }
        newValue[newN] = values2[this.n];
        this.n = newN;
        this.maxFill = HashCommon.maxFill((int)this.n, (float)this.f);
        this.keys = newKey;
        this.values = newValue;
    }

    private final int find(int x, int y, int z) {
        if (x == 0 && y == 0 && z == 0) {
            return this.containsNullKey ? this.n : -(this.n + 1);
        }
        int[] keys2 = this.keys;
        int mask = this.getMask();
        int pos = this.hash(x, y, z) & mask;
        while (true) {
            int keyPos = pos * 3;
            int curX = keys2[keyPos];
            int curY = keys2[keyPos + 1];
            int curZ = keys2[keyPos + 2];
            if (curX == 0 && curY == 0 && curZ == 0) {
                return -(pos + 1);
            }
            if (x == curX && y == curY && z == curZ) {
                return pos;
            }
            pos = pos + 1 & mask;
        }
    }

    @Nullable
    public final T set(@NotNull Vector3ic pos, T value) {
        Intrinsics.checkNotNullParameter((Object)pos, (String)"pos");
        return this.put(pos.x(), pos.y(), pos.z(), value);
    }

    public BlockPos2ObjectOpenHashMap() {
        this(0, 0.0f, 3, null);
    }

    @Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2={"Lorg/valkyrienskies/core/util/datastructures/BlockPos2ObjectOpenHashMap$Companion;", "", "", "NUM_KEYS", "I", "<init>", "()V", "util"})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }

    @Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u0000\u001a\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u00e6\u0080\u0001\u0018\u0000*\u0004\b\u0001\u0010\u00012\u00020\u0002J/\u0010\t\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00028\u0001H&\u00a2\u0006\u0004\b\t\u0010\n\u00f8\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001\u00a8\u0006\u000b\u00c0\u0006\u0001"}, d2={"Lorg/valkyrienskies/core/util/datastructures/BlockPos2ObjectOpenHashMap$EntryConsumer;", "T", "", "", "x", "y", "z", "v", "", "accept", "(IIILjava/lang/Object;)V", "util"})
    public static interface EntryConsumer<T> {
        public void accept(int var1, int var2, int var3, T var4);
    }
}

