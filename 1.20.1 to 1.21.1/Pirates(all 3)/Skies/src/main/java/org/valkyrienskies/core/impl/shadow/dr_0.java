/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nonnull
 *  javax.annotation.Nullable
 *  org.valkyrienskies.core.impl.shadow.Dr
 */
package org.valkyrienskies.core.impl.shadow;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.core.TreeCodec;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import java.util.Iterator;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import org.joml.Vector3i;
import org.joml.Vector3ic;
import org.joml.primitives.AABBi;
import org.valkyrienskies.core.api.ships.properties.ChunkClaim;
import org.valkyrienskies.core.api.util.functions.IntTernaryConsumer;
import org.valkyrienskies.core.api.world.LevelYRange;
import org.valkyrienskies.core.impl.shadow.Dr;
import org.valkyrienskies.core.impl.shadow.du_0;
import org.valkyrienskies.core.impl.shadow.dv_0;
import org.valkyrienskies.core.impl.shadow.dx_0;
import org.valkyrienskies.core.util.datastructures.DenseBlockPosSet;
import org.valkyrienskies.core.util.datastructures.IBlockPosSet;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.Dr
 */
@JsonDeserialize(using=a.class)
@JsonSerialize(using=b.class)
public final class dr_0
implements dv_0 {
    final IBlockPosSet a;
    final int b;
    final int c;
    final int d;
    final int e;
    final int f;
    final int g;
    private final du_0 h;
    private final du_0 i;
    private final du_0 j;

    private dr_0(ChunkClaim chunkClaim, LevelYRange levelYRange) {
        this(chunkClaim, levelYRange, new DenseBlockPosSet());
    }

    private dr_0(ChunkClaim object, LevelYRange levelYRange, DenseBlockPosSet denseBlockPosSet) {
        Vector3i vector3i = object.getCenterBlockCoordinates(levelYRange, new Vector3i());
        object = object.getBlockSize(levelYRange, new Vector3i());
        this.a = denseBlockPosSet;
        this.b = vector3i.x();
        this.c = vector3i.y();
        this.d = vector3i.z();
        this.e = object.x();
        this.f = object.y();
        this.g = object.z();
        this.h = new du_0(this.e);
        this.i = new du_0(this.f);
        this.j = new du_0(this.g);
    }

    private dr_0(int n2, int n3, int n4, int n5, int n6, int n7) {
        this(new DenseBlockPosSet(), n2, n3, n4, n5, n6, n7);
    }

    dr_0(IBlockPosSet iBlockPosSet, int n2, int n3, int n4, int n5, int n6, int n7) {
        this.a = iBlockPosSet;
        this.b = n2;
        this.c = n3;
        this.d = n4;
        this.e = n5;
        this.f = n6;
        this.g = n7;
        this.h = new du_0(n5);
        this.i = new du_0(n6);
        this.j = new du_0(n7);
    }

    @Override
    @Nullable
    public final AABBi a() {
        if (this.a.isEmpty()) {
            return null;
        }
        du_0 du_02 = this.h;
        int n2 = du_02.a - this.e / 2;
        du_02 = this.h;
        int n3 = du_02.b - this.e / 2;
        du_02 = this.i;
        int n4 = du_02.a - this.f / 2;
        du_02 = this.i;
        int n5 = du_02.b - this.f / 2;
        du_02 = this.j;
        int n6 = du_02.a - this.g / 2;
        du_02 = this.j;
        int n7 = du_02.b - this.g / 2;
        return new AABBi(n2 += this.b, n4 += this.c, n6 += this.d, n3 += this.b, n5 += this.c, n7 += this.d);
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public final boolean add(int x, int y, int z) {
        boolean bl = this.a.add(x, y, z);
        if (bl) {
            void var3_3;
            void var2_2;
            void var1_1;
            this.a((int)var1_1, (int)var2_2, (int)var3_3);
        }
        return bl;
    }

    private void a(int n2, int n3, int n4) {
        this.h.a(n2 - this.b + this.e / 2);
        this.i.a(n3 - this.c + this.f / 2);
        this.j.a(n4 - this.d + this.g / 2);
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public final boolean remove(int x, int y, int z) {
        boolean bl = this.a.remove(x, y, z);
        if (bl) {
            void var1_1;
            void var2_3;
            void var3_4;
            void var5_6 = var3_4;
            var3_4 = var2_3;
            var2_3 = var1_1;
            dr_0 dr_02 = this;
            dr_02.h.b((int)(var2_3 - dr_02.b + dr_02.e / 2));
            dr_02.i.b((int)(var3_4 - dr_02.c + dr_02.f / 2));
            dr_02.j.b((int)(var5_6 - dr_02.d + dr_02.g / 2));
        }
        return bl;
    }

    private void b(int n2, int n3, int n4) {
        this.h.b(n2 - this.b + this.e / 2);
        this.i.b(n3 - this.c + this.f / 2);
        this.j.b(n4 - this.d + this.g / 2);
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public final boolean contains(int x, int y, int z) {
        void var3_3;
        void var2_2;
        void var1_1;
        return this.a.contains((int)var1_1, (int)var2_2, (int)var3_3);
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public final boolean canStore(int x, int y, int z) {
        void var3_3;
        void var2_2;
        void var1_1;
        return this.a.canStore((int)var1_1, (int)var2_2, (int)var3_3);
    }

    @Override
    public final int size() {
        return this.a.size();
    }

    @Override
    @Nonnull
    public final Iterator<Vector3ic> iterator() {
        return this.a.iterator();
    }

    @Override
    public final void clear() {
        this.a.clear();
        this.h.a();
        this.i.a();
        this.j.a();
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public final void forEach(@Nonnull IntTernaryConsumer action) {
        void var1_1;
        this.a.forEach((IntTernaryConsumer)var1_1);
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public final boolean equals(Object other) {
        if (other instanceof dv_0) {
            void var1_1;
            return ((dv_0)other).size() == this.size() && ((dv_0)var1_1).containsAll(this);
        }
        return false;
    }

    public static final class a
    extends StdDeserializer<dr_0> {
        private final ObjectMapper a = new ObjectMapper();

        public a() {
            super((Class<?>)null);
        }

        private dr_0 a(JsonParser object) {
            object = (JsonNode)((TreeCodec)((JsonParser)object).getCodec()).readTree((JsonParser)object);
            dx_0 dx_02 = ((ObjectCodec)this.a).treeToValue(((JsonNode)object).get("blockPosSet"), dx_0.class);
            int n2 = ((JsonNode)object).get("centerX").asInt();
            int n3 = ((JsonNode)object).get("centerY").asInt();
            int n4 = ((JsonNode)object).get("centerZ").asInt();
            int n5 = ((JsonNode)object).get("xSize").asInt();
            int n6 = ((JsonNode)object).get("ySize").asInt();
            int n7 = ((JsonNode)object).get("zSize").asInt();
            Dr dr = new Dr((IBlockPosSet)dx_02, n2, n3, n4, n5, n6, n7);
            dx_02.forEach((arg_0, arg_1, arg_2) -> ((dr_0)dr).a(arg_0, arg_1, arg_2));
            return dr;
        }

        @Override
        public final /* synthetic */ Object deserialize(JsonParser object, DeserializationContext object2) {
            object2 = object;
            object = this;
            object2 = (JsonNode)((TreeCodec)((JsonParser)object2).getCodec()).readTree((JsonParser)object2);
            object = ((ObjectCodec)((a)object).a).treeToValue(((JsonNode)object2).get("blockPosSet"), dx_0.class);
            int n2 = ((JsonNode)object2).get("centerX").asInt();
            int n3 = ((JsonNode)object2).get("centerY").asInt();
            int n4 = ((JsonNode)object2).get("centerZ").asInt();
            int n5 = ((JsonNode)object2).get("xSize").asInt();
            int n6 = ((JsonNode)object2).get("ySize").asInt();
            int n7 = ((JsonNode)object2).get("zSize").asInt();
            Dr dr = new Dr((IBlockPosSet)object, n2, n3, n4, n5, n6, n7);
            ((dx_0)object).forEach((arg_0, arg_1, arg_2) -> ((dr_0)dr).a(arg_0, arg_1, arg_2));
            return dr;
        }
    }

    public static final class b
    extends StdSerializer<dr_0> {
        public b() {
            super(null);
        }

        private static void a(dr_0 dr_02, JsonGenerator jsonGenerator) {
            jsonGenerator.writeStartObject();
            jsonGenerator.writeObjectField("blockPosSet", ((Dr)dr_02).a);
            jsonGenerator.writeNumberField("centerX", ((Dr)dr_02).b);
            jsonGenerator.writeNumberField("centerY", ((Dr)dr_02).c);
            jsonGenerator.writeNumberField("centerZ", ((Dr)dr_02).d);
            jsonGenerator.writeNumberField("xSize", ((Dr)dr_02).e);
            jsonGenerator.writeNumberField("ySize", ((Dr)dr_02).f);
            jsonGenerator.writeNumberField("zSize", ((Dr)dr_02).g);
            jsonGenerator.writeEndObject();
        }

        @Override
        public final /* synthetic */ void serialize(Object object, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            object = (Dr)object;
            jsonGenerator.writeStartObject();
            jsonGenerator.writeObjectField("blockPosSet", ((Dr)object).a);
            jsonGenerator.writeNumberField("centerX", ((Dr)object).b);
            jsonGenerator.writeNumberField("centerY", ((Dr)object).c);
            jsonGenerator.writeNumberField("centerZ", ((Dr)object).d);
            jsonGenerator.writeNumberField("xSize", ((Dr)object).e);
            jsonGenerator.writeNumberField("ySize", ((Dr)object).f);
            jsonGenerator.writeNumberField("zSize", ((Dr)object).g);
            jsonGenerator.writeEndObject();
        }
    }
}

