/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  it.unimi.dsi.fastutil.HashCommon
 *  kotlin.Metadata
 *  kotlin.jvm.internal.DefaultConstructorMarker
 */
package org.valkyrienskies.core.util.datastructures;

import it.unimi.dsi.fastutil.HashCommon;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.valkyrienskies.core.util.datastructures.MurmurHash3;

@Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0005\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0014\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0002\b\f\n\u0002\u0010\u0012\n\u0002\b\b\u0018\u0000 =2\u00020\u0001:\u0001=B\u001b\u0012\b\b\u0002\u00109\u001a\u00020\u0002\u0012\b\b\u0002\u0010:\u001a\u00020&\u00a2\u0006\u0004\b;\u0010<J%\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0007\u0010\bJ'\u0010\t\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0002H\u0002\u00a2\u0006\u0004\b\t\u0010\nJ%\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0002\u00a2\u0006\u0004\b\f\u0010\rJ'\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0002H\u0002\u00a2\u0006\u0004\b\u000e\u0010\nJ7\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u000bH\u0002\u00a2\u0006\u0004\b\u0012\u0010\u0013J-\u0010\u0014\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u000b\u00a2\u0006\u0004\b\u0014\u0010\u0015J\u0017\u0010\u0017\u001a\u00020\u00112\u0006\u0010\u0016\u001a\u00020\u0002H\u0002\u00a2\u0006\u0004\b\u0017\u0010\u0018J%\u0010\u0019\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0019\u0010\rJ\u0017\u0010\u001a\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u0002H\u0002\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\u000f\u0010\u001c\u001a\u00020\u000bH\u0002\u00a2\u0006\u0004\b\u001c\u0010\u001dJ\u0017\u0010\u001e\u001a\u00020\u00112\u0006\u0010\u000f\u001a\u00020\u0002H\u0002\u00a2\u0006\u0004\b\u001e\u0010\u0018R\u0016\u0010\u001f\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 R\"\u0010!\u001a\u00020\u000b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010\u001d\"\u0004\b$\u0010%R\u0014\u0010'\u001a\u00020&8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b'\u0010(R\u0016\u0010*\u001a\u00020)8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b*\u0010+R\u0014\u0010.\u001a\u00020\u00028BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b,\u0010-R\u0016\u0010/\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b/\u00100R\u0014\u00101\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b1\u00100R\u0016\u00102\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b2\u00100R\u0014\u00104\u001a\u00020\u00028BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b3\u0010-R\u0016\u00105\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b5\u00100R\u0016\u00107\u001a\u0002068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b7\u00108\u00a8\u0006>"}, d2={"Lorg/valkyrienskies/core/util/datastructures/BlockPos2ByteOpenHashMap;", "", "", "x", "y", "z", "", "contains", "(III)Z", "find", "(III)I", "", "get", "(III)B", "hash", "pos", "v", "", "insert", "(IIIIB)V", "put", "(IIIB)B", "newN", "rehash", "(I)V", "remove", "removeEntry", "(I)B", "removeNullEntry", "()B", "shiftKeys", "containsNullKey", "Z", "defRetValue", "B", "getDefRetValue", "setDefRetValue", "(B)V", "", "f", "F", "", "keys", "[I", "getMask", "()I", "mask", "maxFill", "I", "minN", "n", "getRealSize", "realSize", "size", "", "values", "[B", "expected", "loadFactor", "<init>", "(IF)V", "Companion", "util"})
public final class BlockPos2ByteOpenHashMap {
    @NotNull
    public static final Companion Companion = new Companion(null);
    private int n;
    private int size;
    @NotNull
    private int[] keys;
    @NotNull
    private byte[] values;
    private boolean containsNullKey;
    private int maxFill;
    private byte defRetValue;
    private final int minN;
    private final float f;
    private static final int NUM_KEYS = 3;

    public BlockPos2ByteOpenHashMap(int expected, float loadFactor) {
        this.f = loadFactor;
        this.minN = this.n = HashCommon.arraySize((int)expected, (float)this.f);
        this.maxFill = HashCommon.maxFill((int)this.n, (float)loadFactor);
        this.keys = new int[(this.n + 1) * 3];
        this.values = new byte[this.n + 1];
    }

    public /* synthetic */ BlockPos2ByteOpenHashMap(int n2, float f2, int n3, DefaultConstructorMarker defaultConstructorMarker) {
        if ((n3 & 1) != 0) {
            n2 = 10;
        }
        if ((n3 & 2) != 0) {
            f2 = 0.75f;
        }
        this(n2, f2);
    }

    public final byte getDefRetValue() {
        return this.defRetValue;
    }

    public final void setDefRetValue(byte by) {
        this.defRetValue = by;
    }

    private final int getMask() {
        return this.n - 1;
    }

    private final int getRealSize() {
        return this.containsNullKey ? this.size - 1 : this.size;
    }

    public final byte get(int x, int y, int z) {
        int pos = this.find(x, y, z);
        return pos < 0 ? this.defRetValue : this.values[pos];
    }

    public final byte put(int x, int y, int z, byte v) {
        int pos = this.find(x, y, z);
        if (pos < 0) {
            this.insert(-pos - 1, x, y, z, v);
            return this.defRetValue;
        }
        byte oldValue = this.values[pos];
        this.values[pos] = v;
        return oldValue;
    }

    public final byte remove(int x, int y, int z) {
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

    private final byte removeNullEntry() {
        this.containsNullKey = false;
        byte oldValue = this.values[this.n];
        int n2 = this.size;
        this.size = n2 + -1;
        if (this.n > this.minN && this.size < this.maxFill / 4 && this.n > 16) {
            this.rehash(this.n / 2);
        }
        return oldValue;
    }

    private final byte removeEntry(int pos) {
        byte oldValue = this.values[pos];
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

    private final void insert(int pos, int x, int y, int z, byte v) {
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
        byte[] values2 = this.values;
        int newMask = newN - 1;
        int[] newKey = new int[(newN + 1) * 3];
        byte[] newValue = new byte[newN + 1];
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

    public BlockPos2ByteOpenHashMap() {
        this(0, 0.0f, 3, null);
    }

    @Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2={"Lorg/valkyrienskies/core/util/datastructures/BlockPos2ByteOpenHashMap$Companion;", "", "", "NUM_KEYS", "I", "<init>", "()V", "util"})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }
}

