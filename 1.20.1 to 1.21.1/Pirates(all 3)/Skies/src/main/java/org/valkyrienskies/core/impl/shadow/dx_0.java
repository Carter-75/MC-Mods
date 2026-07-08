/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  it.unimi.dsi.fastutil.ints.Int2IntOpenHashMap
 *  it.unimi.dsi.fastutil.ints.IntArrayList
 *  it.unimi.dsi.fastutil.ints.IntIterator
 *  it.unimi.dsi.fastutil.ints.IntListIterator
 *  javax.annotation.Nonnull
 *  org.valkyrienskies.core.impl.shadow.Dx
 */
package org.valkyrienskies.core.impl.shadow;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.TreeCodec;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import it.unimi.dsi.fastutil.ints.Int2IntOpenHashMap;
import it.unimi.dsi.fastutil.ints.IntArrayList;
import it.unimi.dsi.fastutil.ints.IntIterator;
import it.unimi.dsi.fastutil.ints.IntListIterator;
import java.util.Iterator;
import javax.annotation.Nonnull;
import org.joml.Vector3i;
import org.joml.Vector3ic;
import org.valkyrienskies.core.api.util.functions.IntTernaryConsumer;
import org.valkyrienskies.core.impl.shadow.Dx;
import org.valkyrienskies.core.util.datastructures.IBlockPosSet;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.Dx
 */
@JsonDeserialize(using=b.class)
@JsonSerialize(using=c.class)
public class dx_0
implements IBlockPosSet {
    private static final int f = 4095;
    private static final int g = 255;
    @Nonnull
    final IntArrayList a = new IntArrayList();
    @Nonnull
    final Int2IntOpenHashMap b = new Int2IntOpenHashMap();
    final int c;
    final int d;
    final int e;

    public dx_0(int n2, int n3, int n4) {
        this.c = n2;
        this.d = n3;
        this.e = n4;
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public boolean add(int x, int y, int z) {
        void var3_3;
        void var2_2;
        int n2;
        if (!this.canStore(x, y, z)) {
            throw new IllegalArgumentException("Cannot store block position at <" + x + "," + y + "," + z + "> into SmallBlockPosSet centered at <" + this.c + "," + this.d + "," + this.e + ">");
        }
        if (this.b.containsKey(n2 = this.a(n2, (int)var2_2, (int)var3_3))) {
            return false;
        }
        this.a.add(n2);
        this.b.put(n2, this.a.size() - 1);
        return true;
    }

    @Override
    public boolean remove(int x, int y, int z) {
        int n2;
        int n3;
        int n4;
        if (!this.canStore(x, y, z)) {
            throw new IllegalArgumentException("Cannot remove block position at <" + x + "," + y + "," + z + ">");
        }
        if (!this.b.containsKey(n4 = this.a(n4, n3, n2))) {
            return false;
        }
        n3 = this.b.get(n4);
        if (n3 == this.a.size() - 1) {
            this.a.removeInt(n3);
        } else {
            n2 = this.a.removeInt(this.a.size() - 1);
            this.a.set(n3, n2);
            this.b.put(n2, n3);
        }
        this.b.remove(n4);
        return true;
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public boolean contains(int x, int y, int z) {
        void var3_3;
        void var2_2;
        void var1_1;
        if (!this.canStore(x, y, z)) {
            return false;
        }
        return this.b.containsKey(this.a((int)var1_1, (int)var2_2, (int)var3_3));
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public boolean canStore(int x, int y, int z) {
        void var3_3;
        int n2;
        void var2_2;
        return !((var2_2 -= this.d) < -128 | var2_2 > 127 | (n2 = x - this.c) < -2048 | n2 > 2047 | (var3_3 -= this.e) < -2048 | var3_3 > 2047);
    }

    @Override
    public int size() {
        return this.a.size();
    }

    @Override
    @Nonnull
    public Iterator<Vector3ic> iterator() {
        dx_0 dx_02 = this;
        return new a(dx_02, dx_02.a.iterator());
    }

    @Override
    public void forEach(@Nonnull IntTernaryConsumer action) {
        IntListIterator intListIterator = this.a.iterator();
        while (intListIterator.hasNext()) {
            int n2 = intListIterator.nextInt();
            int n3 = n2 >> 20;
            int n4 = n2 >> 12 & 0xFF;
            if ((n4 & 0x80) != 0) {
                n4 |= 0xFFFFFF00;
            }
            n2 = (n2 & 0xFFF) << 20 >> 20;
            action.accept(n2 + this.c, n4 + this.d, n3 + this.e);
        }
    }

    @Override
    public void clear() {
        this.a.clear();
        this.b.clear();
    }

    @Nonnull
    private Vector3i a(int n2) {
        return this.a(n2, new Vector3i());
    }

    Vector3i a(int n2, Vector3i vector3i) {
        int n3 = n2 >> 20;
        int n4 = n2 >> 12 & 0xFF;
        if ((n4 & 0x80) != 0) {
            n4 |= 0xFFFFFF00;
        }
        n2 = (n2 & 0xFFF) << 20 >> 20;
        vector3i.set(n2 + this.c, n4 + this.d, n3 + this.e);
        return vector3i;
    }

    private int a(int n2, int n3, int n4) {
        n2 = n2 - this.c & 0xFFF;
        n3 = n3 - this.d & 0xFF;
        n4 = n4 - this.e & 0xFFF;
        return n2 | n3 << 12 | n4 << 20;
    }

    @Override
    public void forEachUnsafe(@Nonnull IntTernaryConsumer action) {
        Vector3i vector3i = new Vector3i();
        for (int i2 = 0; this.a.size() >= i2; ++i2) {
            try {
                int n2 = this.a.get(i2);
                this.a(n2, vector3i);
                action.accept(vector3i.x(), vector3i.y(), vector3i.z());
                continue;
            }
            catch (Exception exception) {
                return;
            }
        }
    }

    private int a() {
        return this.c;
    }

    private int b() {
        return this.d;
    }

    private int c() {
        return this.e;
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public boolean equals(Object other) {
        if (other instanceof IBlockPosSet) {
            void var1_1;
            return ((IBlockPosSet)other).size() == this.size() && ((IBlockPosSet)var1_1).containsAll(this);
        }
        return false;
    }

    final class a
    implements Iterator<Vector3ic> {
        private final IntIterator a;
        private /* synthetic */ dx_0 b;

        a(dx_0 dx_02, IntListIterator intListIterator) {
            this.b = dx_02;
            this.a = intListIterator;
        }

        @Override
        public final boolean hasNext() {
            return this.a.hasNext();
        }

        private Vector3ic a() {
            int n2 = this.a.next();
            dx_0 dx_02 = this.b;
            return dx_02.a(n2, new Vector3i());
        }

        @Override
        public final /* synthetic */ Object next() {
            Object object = this;
            int n2 = ((a)object).a.next();
            object = ((a)object).b;
            return object.a(n2, new Vector3i());
        }
    }

    public static final class b
    extends StdDeserializer<dx_0> {
        public b() {
            super((Class<?>)null);
        }

        private static dx_0 a(JsonParser iterator2) {
            iterator2 = (JsonNode)((TreeCodec)((JsonParser)((Object)iterator2)).getCodec()).readTree((JsonParser)((Object)iterator2));
            int n2 = ((JsonNode)((Object)iterator2)).get("centerX").asInt();
            int n3 = ((JsonNode)((Object)iterator2)).get("centerY").asInt();
            int n4 = ((JsonNode)((Object)iterator2)).get("centerZ").asInt();
            Dx dx = new Dx(n2, n3, n4);
            for (JsonNode jsonNode : ((JsonNode)((Object)iterator2)).get("positions")) {
                n3 = jsonNode.asInt();
                dx.a.add(n3);
                dx.b.put(n3, dx.a.size() - 1);
            }
            return dx;
        }

        @Override
        public final /* synthetic */ Object deserialize(JsonParser iterator2, DeserializationContext deserializationContext) {
            iterator2 = (JsonNode)((TreeCodec)((JsonParser)((Object)iterator2)).getCodec()).readTree((JsonParser)((Object)iterator2));
            int n2 = ((JsonNode)((Object)iterator2)).get("centerX").asInt();
            int n3 = ((JsonNode)((Object)iterator2)).get("centerY").asInt();
            int n4 = ((JsonNode)((Object)iterator2)).get("centerZ").asInt();
            Dx dx = new Dx(n2, n3, n4);
            for (JsonNode jsonNode : ((JsonNode)((Object)iterator2)).get("positions")) {
                n3 = jsonNode.asInt();
                dx.a.add(n3);
                dx.b.put(n3, dx.a.size() - 1);
            }
            return dx;
        }
    }

    public static final class c
    extends StdSerializer<dx_0> {
        public c() {
            super(null);
        }

        private static void a(dx_0 dx_02, JsonGenerator jsonGenerator) {
            jsonGenerator.writeStartObject();
            jsonGenerator.writeFieldName("positions");
            jsonGenerator.writeStartArray(((Dx)dx_02).a, ((Dx)dx_02).a.size());
            IntListIterator intListIterator = ((Dx)dx_02).a.iterator();
            while (intListIterator.hasNext()) {
                jsonGenerator.writeNumber(intListIterator.nextInt());
            }
            jsonGenerator.writeEndArray();
            jsonGenerator.writeNumberField("centerX", ((Dx)dx_02).c);
            jsonGenerator.writeNumberField("centerY", ((Dx)dx_02).d);
            jsonGenerator.writeNumberField("centerZ", ((Dx)dx_02).e);
            jsonGenerator.writeEndObject();
        }

        @Override
        public final /* synthetic */ void serialize(Object object, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            object = (Dx)object;
            jsonGenerator.writeStartObject();
            jsonGenerator.writeFieldName("positions");
            jsonGenerator.writeStartArray(((Dx)object).a, ((Dx)object).a.size());
            serializerProvider = ((Dx)object).a.iterator();
            while (serializerProvider.hasNext()) {
                jsonGenerator.writeNumber(serializerProvider.nextInt());
            }
            jsonGenerator.writeEndArray();
            jsonGenerator.writeNumberField("centerX", ((Dx)object).c);
            jsonGenerator.writeNumberField("centerY", ((Dx)object).d);
            jsonGenerator.writeNumberField("centerZ", ((Dx)object).e);
            jsonGenerator.writeEndObject();
        }
    }
}

