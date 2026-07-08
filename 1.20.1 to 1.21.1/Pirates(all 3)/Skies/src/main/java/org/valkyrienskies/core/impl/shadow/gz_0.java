/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.common.collect.ClassToInstanceMap
 *  com.google.common.collect.MutableClassToInstanceMap
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 */
package org.valkyrienskies.core.impl.shadow;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import com.google.common.collect.ClassToInstanceMap;
import com.google.common.collect.MutableClassToInstanceMap;
import java.text.ParseException;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.Gz
 */
public final class gz_0
extends SimpleModule {
    public gz_0() {
        this.addSerializer(MutableClassToInstanceMap.class, b.INSTANCE);
        this.addDeserializer(MutableClassToInstanceMap.class, a.INSTANCE);
        gz_0 gz_02 = this;
        super.addAbstractTypeMapping(ClassToInstanceMap.class, MutableClassToInstanceMap.class);
    }

    private final /* synthetic */ <A, B extends A> void a() {
        Intrinsics.reifiedOperationMarker((int)4, (String)"A");
        Intrinsics.reifiedOperationMarker((int)4, (String)"B");
        super.addAbstractTypeMapping(Object.class, Object.class);
    }

    @Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c2\u0002\u0018\u00002\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\t\u0010\nJ#\u0010\u0007\u001a\u0006\u0012\u0002\b\u00030\u00022\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0016\u00a2\u0006\u0004\b\u0007\u0010\b"}, d2={"Lorg/valkyrienskies/core/impl/shadow/Gz$a;", "Lcom/fasterxml/jackson/databind/deser/std/StdDeserializer;", "Lcom/google/common/collect/MutableClassToInstanceMap;", "Lcom/fasterxml/jackson/core/JsonParser;", "p0", "Lcom/fasterxml/jackson/databind/DeserializationContext;", "p1", "a", "(Lcom/fasterxml/jackson/core/JsonParser;Lcom/fasterxml/jackson/databind/DeserializationContext;)Lcom/google/common/collect/MutableClassToInstanceMap;", "<init>", "()V"})
    static final class a
    extends StdDeserializer<MutableClassToInstanceMap<?>> {
        public static final a INSTANCE = new a();

        private a() {
            super(MutableClassToInstanceMap.class);
        }

        private static MutableClassToInstanceMap<?> a(JsonParser jsonParser, DeserializationContext deserializationContext) {
            Intrinsics.checkNotNullParameter((Object)jsonParser, (String)"");
            Intrinsics.checkNotNullParameter((Object)deserializationContext, (String)"");
            if (jsonParser.getCurrentToken() != JsonToken.START_OBJECT) {
                throw new ParseException("Expected start of object", jsonParser.getCurrentLocation().getLineNr());
            }
            deserializationContext = MutableClassToInstanceMap.create();
            Object object = jsonParser.nextToken();
            while (object != JsonToken.END_OBJECT) {
                if (object != JsonToken.FIELD_NAME) {
                    throw new ParseException("Expected field name", jsonParser.getCurrentLocation().getLineNr());
                }
                object = Class.forName(jsonParser.getCurrentName());
                jsonParser.nextToken();
                Object t = jsonParser.getCodec().readValue(jsonParser, object);
                Intrinsics.checkNotNullExpressionValue((Object)deserializationContext, (String)"");
                ((Map)((Object)deserializationContext)).put(object, t);
                object = jsonParser.nextToken();
            }
            Intrinsics.checkNotNullExpressionValue((Object)deserializationContext, (String)"");
            return deserializationContext;
        }

        @Override
        public final /* synthetic */ Object deserialize(JsonParser p0, DeserializationContext p1) {
            MutableClassToInstanceMap mutableClassToInstanceMap;
            JsonParser jsonParser = p0;
            Intrinsics.checkNotNullParameter((Object)jsonParser, (String)"");
            Intrinsics.checkNotNullParameter((Object)mutableClassToInstanceMap, (String)"");
            if (jsonParser.getCurrentToken() != JsonToken.START_OBJECT) {
                throw new ParseException("Expected start of object", jsonParser.getCurrentLocation().getLineNr());
            }
            mutableClassToInstanceMap = MutableClassToInstanceMap.create();
            Object object = jsonParser.nextToken();
            while (object != JsonToken.END_OBJECT) {
                if (object != JsonToken.FIELD_NAME) {
                    throw new ParseException("Expected field name", jsonParser.getCurrentLocation().getLineNr());
                }
                object = Class.forName(jsonParser.getCurrentName());
                jsonParser.nextToken();
                Object t = jsonParser.getCodec().readValue(jsonParser, object);
                Intrinsics.checkNotNullExpressionValue((Object)mutableClassToInstanceMap, (String)"");
                ((Map)mutableClassToInstanceMap).put(object, t);
                object = jsonParser.nextToken();
            }
            Intrinsics.checkNotNullExpressionValue((Object)mutableClassToInstanceMap, (String)"");
            return mutableClassToInstanceMap;
        }
    }

    @Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u00c2\u0002\u0018\u00002\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fJ+\u0010\t\u001a\u00020\b2\n\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a2\u0006\u0004\b\t\u0010\n"}, d2={"Lorg/valkyrienskies/core/impl/shadow/Gz$b;", "Lcom/fasterxml/jackson/databind/ser/std/StdSerializer;", "Lcom/google/common/collect/MutableClassToInstanceMap;", "p0", "Lcom/fasterxml/jackson/core/JsonGenerator;", "p1", "Lcom/fasterxml/jackson/databind/SerializerProvider;", "p2", "", "a", "(Lcom/google/common/collect/MutableClassToInstanceMap;Lcom/fasterxml/jackson/core/JsonGenerator;Lcom/fasterxml/jackson/databind/SerializerProvider;)V", "<init>", "()V"})
    static final class b
    extends StdSerializer<MutableClassToInstanceMap<?>> {
        public static final b INSTANCE = new b();

        private b() {
            super(MutableClassToInstanceMap.class);
        }

        private static void a(MutableClassToInstanceMap<?> object, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            Intrinsics.checkNotNullParameter(object, (String)"");
            Intrinsics.checkNotNullParameter((Object)jsonGenerator, (String)"");
            Intrinsics.checkNotNullParameter((Object)serializerProvider, (String)"");
            jsonGenerator.writeStartObject();
            for (Map.Entry entry : object.entrySet()) {
                jsonGenerator.writeFieldName(((Class)entry.getKey()).getName());
                serializerProvider.defaultSerializeValue(entry.getValue(), jsonGenerator);
            }
            jsonGenerator.writeEndObject();
        }

        /*
         * WARNING - void declaration
         */
        @Override
        public final /* synthetic */ void serialize(Object p0, JsonGenerator p1, SerializerProvider p2) {
            void var3_3;
            void var2_2;
            MutableClassToInstanceMap mutableClassToInstanceMap = (MutableClassToInstanceMap)p0;
            Intrinsics.checkNotNullParameter((Object)mutableClassToInstanceMap, (String)"");
            Intrinsics.checkNotNullParameter((Object)var2_2, (String)"");
            Intrinsics.checkNotNullParameter((Object)var3_3, (String)"");
            var2_2.writeStartObject();
            for (Map.Entry entry : mutableClassToInstanceMap.entrySet()) {
                var2_2.writeFieldName(((Class)entry.getKey()).getName());
                var3_3.defaultSerializeValue(entry.getValue(), (JsonGenerator)var2_2);
            }
            var2_2.writeEndObject();
        }
    }
}

