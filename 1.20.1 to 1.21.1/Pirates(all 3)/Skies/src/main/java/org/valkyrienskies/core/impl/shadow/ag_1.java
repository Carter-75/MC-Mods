/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.fasterxml.classmate.ResolvedType
 */
package org.valkyrienskies.core.impl.shadow;

import com.fasterxml.classmate.ResolvedType;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import org.valkyrienskies.core.impl.shadow.ai_1;
import org.valkyrienskies.core.impl.shadow.ak_1;
import org.valkyrienskies.core.impl.shadow.ap_1;
import org.valkyrienskies.core.impl.shadow.au_1;
import org.valkyrienskies.core.impl.shadow.aw_1;
import org.valkyrienskies.core.impl.shadow.ax_1;
import org.valkyrienskies.core.impl.shadow.ba_2;
import org.valkyrienskies.core.impl.shadow.bb_2;
import org.valkyrienskies.core.impl.shadow.bo_2;
import org.valkyrienskies.core.impl.shadow.bp_2;
import org.valkyrienskies.core.impl.shadow.bq_2;
import org.valkyrienskies.core.impl.shadow.bv_2;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.aG
 */
public final class ag_1 {
    private final ak_1 a;
    private final au_1 b;
    private final bb_2 c;
    private final List<ObjectNode> d;
    private final bo_2 e;

    static ObjectNode a(ak_1 object, au_1 object2, Type object3, Type ... object4) {
        ObjectNode objectNode;
        boolean bl;
        ag_1 ag_12 = new ag_1((ak_1)object, (au_1)object2);
        object = ag_12;
        ResolvedType resolvedType = object3;
        object3 = object4;
        object2 = resolvedType;
        object = ag_12;
        object2 = ag_12.b.a((Type)object2, (Type[])object3);
        object3 = ((ag_1)object).c.c((ResolvedType)object2);
        object4 = ((ag_1)object).a.o();
        if (((ag_1)object).a.e()) {
            ((ObjectNode)object4).put(((ag_1)object).a.a(ap_1.TAG_SCHEMA), ((ag_1)object).a.a(ap_1.TAG_SCHEMA_VALUE));
        }
        if (bl = ((ag_1)object).a.c()) {
            ((ag_1)object).c.a((ResolvedType)object2, (ObjectNode)object4, null, false);
        }
        if (((JsonNode)(objectNode = super.a((String)(object2 = ((ag_1)object).a.a(ap_1.TAG_DEFINITIONS)), (ax_1)object3, ((ag_1)object).c))).size() > 0) {
            ((ObjectNode)object4).set((String)object2, objectNode);
        }
        if (!bl) {
            object2 = ((ag_1)object).c.a((ax_1)object3);
            ((ObjectNode)object4).setAll((ObjectNode)object2);
            ((ag_1)object).d.add((ObjectNode)object4);
        }
        super.a();
        return object4;
    }

    static ag_1 a(ak_1 ak_12, au_1 au_12) {
        return new ag_1(ak_12, au_12);
    }

    ag_1(ak_1 object, au_1 object2) {
        this.a = object;
        this.b = object2;
        this.c = new bb_2(this.a, this.b);
        this.d = new ArrayList<ObjectNode>();
        object2 = object.q();
        if (object2 == null) {
            object2 = new bp_2();
        }
        ba_2 ba_22 = new ba_2((ak_1)object);
        object = object.f() ? ba_22::b : ba_22::a;
        this.e = new bo_2((bq_2)object2, (Function<String, String>)object);
    }

    private ObjectNode a(Type object, Type ... object2) {
        ObjectNode objectNode;
        boolean bl;
        object = this.b.a((Type)object, (Type)object2);
        object2 = this.c.c((ResolvedType)object);
        ObjectNode objectNode2 = this.a.o();
        if (this.a.e()) {
            objectNode2.put(this.a.a(ap_1.TAG_SCHEMA), this.a.a(ap_1.TAG_SCHEMA_VALUE));
        }
        if (bl = this.a.c()) {
            this.c.a((ResolvedType)object, objectNode2, null, false);
        }
        if (((JsonNode)(objectNode = this.a((String)(object = this.a.a(ap_1.TAG_DEFINITIONS)), (ax_1)object2, this.c))).size() > 0) {
            objectNode2.set((String)object, objectNode);
        }
        if (!bl) {
            object = this.c.a((ax_1)object2);
            objectNode2.setAll((ObjectNode)object);
            this.d.add(objectNode2);
        }
        this.a();
        return objectNode2;
    }

    private ObjectNode b(Type object, Type ... object2) {
        object = this.b.a((Type)object, (Type)object2);
        object2 = object;
        object = this.c;
        object = ((bb_2)object).a((ResolvedType)object2, (bv_2)null);
        this.d.add((ObjectNode)object);
        return object;
    }

    private ObjectNode a(String object) {
        object = this.a((String)object, null, this.c);
        this.a();
        return object;
    }

    private void a() {
        ba_2 ba_22 = new ba_2(this.a);
        if (this.a.h()) {
            ba_22.a(this.d);
        }
        ba_22.b(this.d);
    }

    private ObjectNode a(String string, ax_1 ax_13, bb_2 bb_22) {
        ObjectNode objectNode2 = this.a.o();
        boolean bl = this.a.b();
        boolean bl2 = this.a.d();
        AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        Predicate<ax_1> predicate = ax_12 -> {
            if (bl2) {
                return false;
            }
            if (ax_12.equals(ax_13)) {
                return true;
            }
            List<ObjectNode> list = bb_22.b((ax_1)ax_12);
            if (atomicBoolean.get() && list.isEmpty()) {
                return false;
            }
            ax_13 = bb_22.c((ax_1)ax_12);
            return bl || list.size() + ax_13.size() > 1;
        };
        Map<ax_1, String> map2 = this.a(ax_13, predicate, bb_22);
        atomicBoolean.set(true);
        boolean bl3 = this.a.c();
        for (Map.Entry entry : map2.entrySet()) {
            Object object;
            String string2 = (String)entry.getValue();
            ax_1 ax_14 = (ax_1)entry.getKey();
            List<ObjectNode> list = bb_22.b(ax_14);
            List<ObjectNode> list2 = bb_22.c(ax_14);
            boolean bl4 = !predicate.test(ax_14);
            if (bl4) {
                object = bb_22.a(ax_14);
                list.forEach(arg_0 -> ag_1.b((ObjectNode)object, arg_0));
                object = null;
            } else {
                if (bl3 || !ax_14.equals(ax_13)) {
                    objectNode2.set(string2, bb_22.a(ax_14));
                    object = this.a.a(ap_1.TAG_REF_MAIN) + '/' + string + '/' + string2;
                } else {
                    object = this.a.a(ap_1.TAG_REF_MAIN);
                }
                list.forEach(arg_0 -> this.a((String)object, arg_0));
            }
            if (list2.isEmpty()) continue;
            object = bl4 ? bb_22.a(ax_14) : this.a.o().put(this.a.a(ap_1.TAG_REF), (String)object);
            bb_22.a((ObjectNode)object);
            if (!bl2 && (bl || list2.size() > 1)) {
                String string3 = this.e.a(ax_14, string2, bb_22);
                objectNode2.set(string3, (JsonNode)object);
                list2.forEach(objectNode -> objectNode.put(this.a.a(ap_1.TAG_REF), this.a.a(ap_1.TAG_REF_MAIN) + '/' + string + '/' + string3));
                continue;
            }
            list2.forEach(arg_0 -> ag_1.a((ObjectNode)object, arg_0));
        }
        objectNode2.forEach(jsonNode -> this.d.add((ObjectNode)jsonNode));
        return objectNode2;
    }

    private Map<ax_1, String> a(ax_1 ax_13, Predicate<ax_1> predicate, bb_2 bb_22) {
        boolean bl = this.a.c();
        Object object = ax_12 -> this.e.a((ax_1)ax_12, (ai_1)bb_22);
        object = bb_22.c().stream().collect(Collectors.groupingBy(object, TreeMap::new, Collectors.toList()));
        LinkedHashMap<ax_1, String> linkedHashMap = new LinkedHashMap<ax_1, String>();
        for (Map.Entry entry2 : object.entrySet()) {
            ((List)entry2.getValue()).forEach(ax_12 -> linkedHashMap.put((ax_1)ax_12, ""));
            List<ax_1> list = ((List)entry2.getValue()).stream().filter(predicate).collect(Collectors.toList());
            if (list.size() == 1 || list.size() == 2 && !bl && list.contains(ax_13)) {
                list.forEach(ax_12 -> linkedHashMap.put((ax_1)ax_12, (String)object2.getKey()));
                continue;
            }
            Map map2 = list.stream().collect(Collectors.toMap(ax_12 -> ax_12, ax_12 -> (String)object2.getKey(), (string, string2) -> string, LinkedHashMap::new));
            this.e.a(map2, (ai_1)bb_22);
            if (list.size() != map2.size()) {
                throw new IllegalStateException(bq_2.class.getSimpleName() + " of type " + this.e.getClass().getSimpleName() + " altered list of subschemas with duplicate names.");
            }
            linkedHashMap.putAll(map2);
        }
        object = linkedHashMap.values().stream().filter(string -> !string.isEmpty()).collect(Collectors.groupingBy(string -> string, Collectors.counting())).entrySet().stream().filter(entry -> (Long)entry.getValue() > 1L).map(Map.Entry::getKey).collect(Collectors.joining(", "));
        if (!((String)object).isEmpty()) {
            throw new IllegalStateException(bq_2.class.getSimpleName() + " of type " + this.e.getClass().getSimpleName() + " produced duplicate keys: " + (String)object);
        }
        return linkedHashMap;
    }

    private static /* synthetic */ void a(ObjectNode objectNode, ObjectNode objectNode2) {
        aw_1.a(objectNode2, objectNode);
    }

    private /* synthetic */ void a(String string, ObjectNode objectNode) {
        objectNode.put(this.a.a(ap_1.TAG_REF), string);
    }

    private static /* synthetic */ void b(ObjectNode objectNode, ObjectNode objectNode2) {
        aw_1.a(objectNode2, objectNode);
    }
}

