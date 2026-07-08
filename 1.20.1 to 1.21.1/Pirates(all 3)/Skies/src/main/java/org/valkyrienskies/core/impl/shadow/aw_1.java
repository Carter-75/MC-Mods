/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.fasterxml.classmate.ResolvedType
 *  org.slf4j.Logger
 *  org.slf4j.LoggerFactory
 */
package org.valkyrienskies.core.impl.shadow;

import com.fasterxml.classmate.ResolvedType;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.valkyrienskies.core.impl.shadow.ac_1;
import org.valkyrienskies.core.impl.shadow.ai_1;
import org.valkyrienskies.core.impl.shadow.ak_1;
import org.valkyrienskies.core.impl.shadow.ap_1;
import org.valkyrienskies.core.impl.shadow.aq_1;
import org.valkyrienskies.core.impl.shadow.av_1;
import org.valkyrienskies.core.impl.shadow.ay_2;
import org.valkyrienskies.core.impl.shadow.bb_2;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.aW
 */
public class aw_1 {
    private static final Logger a = LoggerFactory.getLogger(aw_1.class);
    private final ObjectMapper b;

    public aw_1(ObjectMapper objectMapper) {
        this.b = objectMapper;
    }

    public static ObjectNode a(ay_2 ay_22, ai_1 ai_12) {
        ak_1 ak_12 = ai_12.a();
        ObjectNode objectNode = ak_12.o();
        aw_1 aw_12 = new aw_1(ak_12.n());
        aw_12.c(objectNode, ak_12.i(ay_22), ai_12);
        aw_12.d(objectNode, ak_12.j(ay_22), ai_12);
        aw_12.a(objectNode, ak_12.k(ay_22), ai_12);
        aw_12.a(objectNode, ak_12.l(ay_22), ai_12);
        aw_12.a(objectNode, ak_12.c(ay_22), ai_12);
        aw_12.b(objectNode, ak_12.d(ay_22), ai_12);
        aw_12.a(objectNode, ak_12.m(ay_22), ai_12);
        aw_12.a(objectNode, ak_12.n(ay_22), ai_12);
        aw_12.a(objectNode, ak_12.o(ay_22), ai_12);
        aw_12.b(objectNode, ak_12.p(ay_22), ai_12);
        aw_12.e(objectNode, ak_12.q(ay_22), ai_12);
        aw_12.f(objectNode, ak_12.r(ay_22), ai_12);
        aw_12.a(objectNode, ak_12.s(ay_22), ai_12);
        aw_12.b(objectNode, ak_12.t(ay_22), ai_12);
        aw_12.c(objectNode, ak_12.u(ay_22), ai_12);
        aw_12.d(objectNode, ak_12.v(ay_22), ai_12);
        aw_12.e(objectNode, ak_12.w(ay_22), ai_12);
        aw_12.c(objectNode, ak_12.x(ay_22), ai_12);
        aw_12.d(objectNode, ak_12.y(ay_22), ai_12);
        aw_12.a(objectNode, ak_12.z(ay_22), ai_12);
        ak_12.s().forEach(aa_12 -> aa_12.overrideInstanceAttributes(objectNode, ay_22, ai_12));
        return objectNode;
    }

    public static ObjectNode a(ac_1 ac_12, ai_1 ai_12) {
        ak_1 ak_12 = ai_12.a();
        ObjectNode objectNode = ak_12.o();
        aw_1 aw_12 = new aw_1(ak_12.n());
        aw_12.c(objectNode, ak_12.i(ac_12), ai_12);
        aw_12.d(objectNode, ak_12.j(ac_12), ai_12);
        aw_12.a(objectNode, ak_12.k(ac_12), ai_12);
        aw_12.a(objectNode, ak_12.l(ac_12), ai_12);
        aw_12.a(objectNode, ak_12.c(ac_12), ai_12);
        aw_12.b(objectNode, ak_12.d(ac_12), ai_12);
        aw_12.a(objectNode, ak_12.m(ac_12), ai_12);
        aw_12.a(objectNode, ak_12.n(ac_12), ai_12);
        aw_12.a(objectNode, ak_12.o(ac_12), ai_12);
        aw_12.b(objectNode, ak_12.p(ac_12), ai_12);
        aw_12.e(objectNode, ak_12.q(ac_12), ai_12);
        aw_12.f(objectNode, ak_12.r(ac_12), ai_12);
        aw_12.a(objectNode, ak_12.s(ac_12), ai_12);
        aw_12.b(objectNode, ak_12.t(ac_12), ai_12);
        aw_12.c(objectNode, ak_12.u(ac_12), ai_12);
        aw_12.d(objectNode, ak_12.v(ac_12), ai_12);
        aw_12.e(objectNode, ak_12.w(ac_12), ai_12);
        aw_12.c(objectNode, ak_12.x(ac_12), ai_12);
        aw_12.d(objectNode, ak_12.y(ac_12), ai_12);
        aw_12.a(objectNode, ak_12.z(ac_12), ai_12);
        ak_12.t().forEach(aa_12 -> aa_12.overrideInstanceAttributes(objectNode, ac_12, ai_12));
        return objectNode;
    }

    /*
     * Ignored method signature, as it can't be verified against descriptor
     */
    public static ObjectNode a(av_1 av_12, bb_2 bb_22, Set set) {
        ak_1 ak_12 = bb_22.a();
        ObjectNode objectNode = ak_12.o();
        aw_1 aw_12 = new aw_1(ak_12.n());
        bb_2 bb_23 = bb_22;
        String string = ak_12.a(av_12);
        ObjectNode objectNode2 = objectNode;
        aw_1 aw_13 = aw_12;
        if (string != null) {
            objectNode2.put(bb_23.a(ap_1.TAG_ID), string);
        }
        bb_23 = bb_22;
        string = ak_12.b(av_12);
        objectNode2 = objectNode;
        aw_13 = aw_12;
        if (string != null) {
            objectNode2.put(bb_23.a(ap_1.TAG_ANCHOR), string);
        }
        aw_12.c(objectNode, ak_12.c(av_12), (ai_1)bb_22);
        aw_12.d(objectNode, ak_12.d(av_12), (ai_1)bb_22);
        aw_12.a(objectNode, ak_12.e(av_12), (ai_1)bb_22);
        aw_12.a(objectNode, ak_12.f(av_12), (ai_1)bb_22);
        if (set.isEmpty() || set.contains(ak_12.a(ap_1.TAG_TYPE_OBJECT))) {
            aw_12.a(objectNode, ak_12.g(av_12), (ai_1)bb_22);
            aw_12.a(objectNode, ak_12.h(av_12), (ai_1)bb_22);
        }
        if (set.isEmpty() || set.contains(ak_12.a(ap_1.TAG_TYPE_STRING))) {
            aw_12.a(objectNode, ak_12.i(av_12), (ai_1)bb_22);
            aw_12.b(objectNode, ak_12.j(av_12), (ai_1)bb_22);
            aw_12.e(objectNode, ak_12.k(av_12), (ai_1)bb_22);
            aw_12.f(objectNode, ak_12.l(av_12), bb_22);
        }
        if (set.isEmpty() || set.contains(ak_12.a(ap_1.TAG_TYPE_INTEGER)) || set.contains(ak_12.a(ap_1.TAG_TYPE_NUMBER))) {
            aw_12.a(objectNode, ak_12.m(av_12), (ai_1)bb_22);
            aw_12.b(objectNode, ak_12.n(av_12), (ai_1)bb_22);
            aw_12.c(objectNode, ak_12.o(av_12), (ai_1)bb_22);
            aw_12.d(objectNode, ak_12.p(av_12), (ai_1)bb_22);
            aw_12.e(objectNode, ak_12.q(av_12), (ai_1)bb_22);
        }
        if (set.isEmpty() || set.contains(ak_12.a(ap_1.TAG_TYPE_ARRAY))) {
            aw_12.c(objectNode, ak_12.r(av_12), (ai_1)bb_22);
            aw_12.d(objectNode, ak_12.s(av_12), (ai_1)bb_22);
            aw_12.a(objectNode, ak_12.t(av_12), (ai_1)bb_22);
        }
        return objectNode;
    }

    public static void a(ObjectNode objectNode, ObjectNode object) {
        if (object == null) {
            return;
        }
        object = ((JsonNode)object).fields();
        while (object.hasNext()) {
            Map.Entry entry = (Map.Entry)object.next();
            if (objectNode.has((String)entry.getKey())) continue;
            objectNode.set((String)entry.getKey(), (JsonNode)entry.getValue());
        }
    }

    private aw_1 a(ObjectNode objectNode, String string, ai_1 ai_12) {
        if (string != null) {
            objectNode.put(ai_12.a(ap_1.TAG_ID), string);
        }
        return this;
    }

    private aw_1 b(ObjectNode objectNode, String string, ai_1 ai_12) {
        if (string != null) {
            objectNode.put(ai_12.a(ap_1.TAG_ANCHOR), string);
        }
        return this;
    }

    @Deprecated
    private aw_1 a(ObjectNode objectNode, String string) {
        if (string != null) {
            objectNode.put(ap_1.TAG_TITLE.a(aq_1.DRAFT_7), string);
        }
        return this;
    }

    private aw_1 c(ObjectNode objectNode, String string, ai_1 ai_12) {
        if (string != null) {
            objectNode.put(ai_12.a(ap_1.TAG_TITLE), string);
        }
        return this;
    }

    @Deprecated
    private aw_1 b(ObjectNode objectNode, String string) {
        if (string != null) {
            objectNode.put(ap_1.TAG_DESCRIPTION.a(aq_1.DRAFT_7), string);
        }
        return this;
    }

    private aw_1 d(ObjectNode objectNode, String string, ai_1 ai_12) {
        if (string != null) {
            objectNode.put(ai_12.a(ap_1.TAG_DESCRIPTION), string);
        }
        return this;
    }

    @Deprecated
    private aw_1 a(ObjectNode objectNode, Object object) {
        if (object != null) {
            String string = ap_1.TAG_DEFAULT.a(aq_1.DRAFT_7);
            if (object instanceof String) {
                objectNode.put(string, (String)object);
            } else if (object instanceof BigDecimal) {
                objectNode.put(string, (BigDecimal)object);
            } else if (object instanceof BigInteger) {
                objectNode.put(string, (BigInteger)object);
            } else if (object instanceof Boolean) {
                objectNode.put(string, (Boolean)object);
            } else if (object instanceof Double) {
                objectNode.put(string, (Double)object);
            } else if (object instanceof Float) {
                objectNode.put(string, (Float)object);
            } else if (object instanceof Integer) {
                objectNode.put(string, (Integer)object);
            } else {
                objectNode.putPOJO(string, object);
            }
        }
        return this;
    }

    private aw_1 a(ObjectNode objectNode, Object object, ai_1 object2) {
        if (object != null) {
            object2 = object2.a(ap_1.TAG_DEFAULT);
            if (object instanceof String) {
                objectNode.put((String)object2, (String)object);
            } else if (object instanceof BigDecimal) {
                objectNode.put((String)object2, (BigDecimal)object);
            } else if (object instanceof BigInteger) {
                objectNode.put((String)object2, (BigInteger)object);
            } else if (object instanceof Boolean) {
                objectNode.put((String)object2, (Boolean)object);
            } else if (object instanceof Double) {
                objectNode.put((String)object2, (Double)object);
            } else if (object instanceof Float) {
                objectNode.put((String)object2, (Float)object);
            } else if (object instanceof Integer) {
                objectNode.put((String)object2, (Integer)object);
            } else {
                objectNode.putPOJO((String)object2, object);
            }
        }
        return this;
    }

    @Deprecated
    private aw_1 a(ObjectNode objectNode, Collection<?> object) {
        if (object != null) {
            aq_1 aq_12 = aq_1.DRAFT_7;
            if ((object = object.stream().filter(this::a).filter(this::b).collect(Collectors.toList())).size() == 1) {
                Object e2 = object.get(0);
                if (e2 instanceof String) {
                    objectNode.put(ap_1.TAG_CONST.a(aq_12), (String)e2);
                } else {
                    objectNode.putPOJO(ap_1.TAG_CONST.a(aq_12), e2);
                }
            } else if (!object.isEmpty()) {
                ArrayNode arrayNode = objectNode.arrayNode();
                object = object.iterator();
                while (object.hasNext()) {
                    Object e3 = object.next();
                    if (e3 instanceof String) {
                        arrayNode.add((String)e3);
                        continue;
                    }
                    arrayNode.addPOJO(e3);
                }
                objectNode.set(ap_1.TAG_ENUM.a(aq_12), arrayNode);
            }
        }
        return this;
    }

    public final aw_1 a(ObjectNode objectNode, Collection<?> object, ai_1 ai_12) {
        if (object != null) {
            if ((object = object.stream().filter(this::a).filter(this::b).collect(Collectors.toList())).size() == 1 && ai_12.a().l()) {
                Object e2 = object.get(0);
                if (e2 instanceof String) {
                    objectNode.put(ai_12.a(ap_1.TAG_CONST), (String)e2);
                } else {
                    objectNode.putPOJO(ai_12.a(ap_1.TAG_CONST), e2);
                }
            } else if (!object.isEmpty()) {
                ArrayNode arrayNode = objectNode.arrayNode();
                object = object.iterator();
                while (object.hasNext()) {
                    Object e3 = object.next();
                    if (e3 instanceof String) {
                        arrayNode.add((String)e3);
                        continue;
                    }
                    arrayNode.addPOJO(e3);
                }
                objectNode.set(ai_12.a(ap_1.TAG_ENUM), arrayNode);
            }
        }
        return this;
    }

    private boolean a(Object clazz) {
        if (clazz == null) {
            return true;
        }
        return (clazz = clazz.getClass()).isPrimitive() || Number.class.isAssignableFrom(clazz) || CharSequence.class.isAssignableFrom(clazz) || Enum.class.isAssignableFrom(clazz);
    }

    private boolean b(Object object) {
        try {
            return object == null || this.b.writeValueAsString(object) != null;
        }
        catch (JsonProcessingException jsonProcessingException) {
            a.warn("Failed to convert value to string via ObjectMapper: {}", object, (Object)jsonProcessingException);
            return false;
        }
    }

    private aw_1 a(ObjectNode objectNode, boolean bl, ai_1 ai_12) {
        if (bl) {
            objectNode.put(ai_12.a(ap_1.TAG_READ_ONLY), bl);
        }
        return this;
    }

    private aw_1 b(ObjectNode objectNode, boolean bl, ai_1 ai_12) {
        if (bl) {
            objectNode.put(ai_12.a(ap_1.TAG_WRITE_ONLY), bl);
        }
        return this;
    }

    private aw_1 a(ObjectNode objectNode, Type object, ai_1 ai_12) {
        if (object == Void.class || object == Void.TYPE) {
            objectNode.put(ai_12.a(ap_1.TAG_ADDITIONAL_PROPERTIES), false);
        } else if (object != null && (object = ai_12.b().a((Type)object, new Type[0])).getErasedType() != Object.class) {
            object = ai_12.b((ResolvedType)object);
            objectNode.set(ai_12.a(ap_1.TAG_ADDITIONAL_PROPERTIES), (JsonNode)object);
        }
        return this;
    }

    private aw_1 a(ObjectNode objectNode, Map<String, Type> object, ai_1 ai_12) {
        if (object != null && !object.isEmpty()) {
            ObjectNode objectNode2 = this.b.createObjectNode();
            for (Map.Entry entry : object.entrySet()) {
                Object object2 = ai_12.b().a((Type)entry.getValue(), new Type[0]);
                object2 = ai_12.b((ResolvedType)object2);
                objectNode2.set((String)entry.getKey(), (JsonNode)object2);
            }
            objectNode.set(ai_12.a(ap_1.TAG_PATTERN_PROPERTIES), objectNode2);
        }
        return this;
    }

    @Deprecated
    private aw_1 a(ObjectNode objectNode, Integer n2) {
        if (n2 != null) {
            objectNode.put(ap_1.TAG_LENGTH_MIN.a(aq_1.DRAFT_7), n2);
        }
        return this;
    }

    private aw_1 a(ObjectNode objectNode, Integer n2, ai_1 ai_12) {
        if (n2 != null) {
            objectNode.put(ai_12.a(ap_1.TAG_LENGTH_MIN), n2);
        }
        return this;
    }

    @Deprecated
    private aw_1 b(ObjectNode objectNode, Integer n2) {
        if (n2 != null) {
            objectNode.put(ap_1.TAG_LENGTH_MAX.a(aq_1.DRAFT_7), n2);
        }
        return this;
    }

    private aw_1 b(ObjectNode objectNode, Integer n2, ai_1 ai_12) {
        if (n2 != null) {
            objectNode.put(ai_12.a(ap_1.TAG_LENGTH_MAX), n2);
        }
        return this;
    }

    @Deprecated
    private aw_1 c(ObjectNode objectNode, String string) {
        if (string != null) {
            objectNode.put(ap_1.TAG_FORMAT.a(aq_1.DRAFT_7), string);
        }
        return this;
    }

    private aw_1 e(ObjectNode objectNode, String string, ai_1 ai_12) {
        if (string != null) {
            objectNode.put(ai_12.a(ap_1.TAG_FORMAT), string);
        }
        return this;
    }

    @Deprecated
    private aw_1 d(ObjectNode objectNode, String string) {
        if (string != null) {
            objectNode.put(ap_1.TAG_PATTERN.a(aq_1.DRAFT_7), string);
        }
        return this;
    }

    private aw_1 f(ObjectNode objectNode, String string, ai_1 ai_12) {
        if (string != null) {
            objectNode.put(ai_12.a(ap_1.TAG_PATTERN), string);
        }
        return this;
    }

    @Deprecated
    private aw_1 a(ObjectNode objectNode, BigDecimal bigDecimal) {
        if (bigDecimal != null) {
            objectNode.put(ap_1.TAG_MINIMUM.a(aq_1.DRAFT_7), bigDecimal);
        }
        return this;
    }

    private aw_1 a(ObjectNode objectNode, BigDecimal bigDecimal, ai_1 ai_12) {
        if (bigDecimal != null) {
            objectNode.put(ai_12.a(ap_1.TAG_MINIMUM), bigDecimal);
        }
        return this;
    }

    @Deprecated
    private aw_1 b(ObjectNode objectNode, BigDecimal bigDecimal) {
        if (bigDecimal != null) {
            objectNode.put(ap_1.TAG_MINIMUM_EXCLUSIVE.a(aq_1.DRAFT_7), bigDecimal);
        }
        return this;
    }

    private aw_1 b(ObjectNode objectNode, BigDecimal bigDecimal, ai_1 ai_12) {
        if (bigDecimal != null) {
            objectNode.put(ai_12.a(ap_1.TAG_MINIMUM_EXCLUSIVE), bigDecimal);
        }
        return this;
    }

    @Deprecated
    private aw_1 c(ObjectNode objectNode, BigDecimal bigDecimal) {
        if (bigDecimal != null) {
            objectNode.put(ap_1.TAG_MAXIMUM.a(aq_1.DRAFT_7), bigDecimal);
        }
        return this;
    }

    private aw_1 c(ObjectNode objectNode, BigDecimal bigDecimal, ai_1 ai_12) {
        if (bigDecimal != null) {
            objectNode.put(ai_12.a(ap_1.TAG_MAXIMUM), bigDecimal);
        }
        return this;
    }

    @Deprecated
    private aw_1 d(ObjectNode objectNode, BigDecimal bigDecimal) {
        if (bigDecimal != null) {
            objectNode.put(ap_1.TAG_MAXIMUM_EXCLUSIVE.a(aq_1.DRAFT_7), bigDecimal);
        }
        return this;
    }

    private aw_1 d(ObjectNode objectNode, BigDecimal bigDecimal, ai_1 ai_12) {
        if (bigDecimal != null) {
            objectNode.put(ai_12.a(ap_1.TAG_MAXIMUM_EXCLUSIVE), bigDecimal);
        }
        return this;
    }

    @Deprecated
    private aw_1 e(ObjectNode objectNode, BigDecimal bigDecimal) {
        if (bigDecimal != null) {
            objectNode.put(ap_1.TAG_MULTIPLE_OF.a(aq_1.DRAFT_7), bigDecimal);
        }
        return this;
    }

    private aw_1 e(ObjectNode objectNode, BigDecimal bigDecimal, ai_1 ai_12) {
        if (bigDecimal != null) {
            objectNode.put(ai_12.a(ap_1.TAG_MULTIPLE_OF), bigDecimal);
        }
        return this;
    }

    @Deprecated
    private aw_1 c(ObjectNode objectNode, Integer n2) {
        if (n2 != null) {
            objectNode.put(ap_1.TAG_ITEMS_MIN.a(aq_1.DRAFT_7), n2);
        }
        return this;
    }

    private aw_1 c(ObjectNode objectNode, Integer n2, ai_1 ai_12) {
        if (n2 != null) {
            objectNode.put(ai_12.a(ap_1.TAG_ITEMS_MIN), n2);
        }
        return this;
    }

    @Deprecated
    private aw_1 d(ObjectNode objectNode, Integer n2) {
        if (n2 != null) {
            objectNode.put(ap_1.TAG_ITEMS_MAX.a(aq_1.DRAFT_7), n2);
        }
        return this;
    }

    private aw_1 d(ObjectNode objectNode, Integer n2, ai_1 ai_12) {
        if (n2 != null) {
            objectNode.put(ai_12.a(ap_1.TAG_ITEMS_MAX), n2);
        }
        return this;
    }

    @Deprecated
    private aw_1 a(ObjectNode objectNode, Boolean bl) {
        if (bl != null) {
            objectNode.put(ap_1.TAG_ITEMS_UNIQUE.a(aq_1.DRAFT_7), bl);
        }
        return this;
    }

    private aw_1 a(ObjectNode objectNode, Boolean bl, ai_1 ai_12) {
        if (bl != null) {
            objectNode.put(ai_12.a(ap_1.TAG_ITEMS_UNIQUE), bl);
        }
        return this;
    }
}

