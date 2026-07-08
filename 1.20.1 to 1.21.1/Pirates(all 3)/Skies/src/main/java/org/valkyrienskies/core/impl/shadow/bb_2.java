/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.fasterxml.classmate.ResolvedType
 *  com.fasterxml.classmate.ResolvedTypeWithMembers
 *  com.fasterxml.classmate.members.HierarchicType
 *  com.fasterxml.classmate.members.ResolvedField
 *  com.fasterxml.classmate.members.ResolvedMethod
 *  org.slf4j.Logger
 *  org.slf4j.LoggerFactory
 */
package org.valkyrienskies.core.impl.shadow;

import com.fasterxml.classmate.ResolvedType;
import com.fasterxml.classmate.ResolvedTypeWithMembers;
import com.fasterxml.classmate.members.HierarchicType;
import com.fasterxml.classmate.members.ResolvedField;
import com.fasterxml.classmate.members.ResolvedMethod;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.BooleanNode;
import com.fasterxml.jackson.databind.node.ContainerNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.databind.node.TextNode;
import java.lang.invoke.LambdaMetafactory;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.valkyrienskies.core.impl.shadow.ab_1;
import org.valkyrienskies.core.impl.shadow.ac_1;
import org.valkyrienskies.core.impl.shadow.ai_1;
import org.valkyrienskies.core.impl.shadow.ak_1;
import org.valkyrienskies.core.impl.shadow.ap_1;
import org.valkyrienskies.core.impl.shadow.at_2;
import org.valkyrienskies.core.impl.shadow.au_1;
import org.valkyrienskies.core.impl.shadow.av_1;
import org.valkyrienskies.core.impl.shadow.av_2;
import org.valkyrienskies.core.impl.shadow.aw_1;
import org.valkyrienskies.core.impl.shadow.ax_1;
import org.valkyrienskies.core.impl.shadow.ax_2;
import org.valkyrienskies.core.impl.shadow.ay_2;
import org.valkyrienskies.core.impl.shadow.bk_2;
import org.valkyrienskies.core.impl.shadow.bv_2;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.bb
 */
public class bb_2
implements ai_1 {
    private static final Logger a = LoggerFactory.getLogger(bb_2.class);
    private final ak_1 b;
    private final au_1 c;
    private final Map<ax_1, ObjectNode> d = new LinkedHashMap<ax_1, ObjectNode>();
    private final Map<ax_1, List<ObjectNode>> e = new HashMap<ax_1, List<ObjectNode>>();
    private final Map<ax_1, List<ObjectNode>> f = new HashMap<ax_1, List<ObjectNode>>();

    public bb_2(ak_1 ak_12, au_1 au_12) {
        this.b = ak_12;
        this.c = au_12;
    }

    @Override
    public final ak_1 a() {
        return this.b;
    }

    @Override
    public final au_1 b() {
        return this.c;
    }

    public final ax_1 c(ResolvedType resolvedType) {
        this.a(resolvedType, null, false);
        return new ax_1(resolvedType, null);
    }

    private bb_2 a(ResolvedType resolvedType, ObjectNode objectNode, av_2 av_22) {
        this.d.put(new ax_1(resolvedType, av_22), objectNode);
        return this;
    }

    private boolean a(ResolvedType resolvedType, av_2 av_22) {
        return this.d.containsKey(new ax_1(resolvedType, av_22));
    }

    public final ObjectNode a(ax_1 ax_12) {
        return this.d.get(ax_12);
    }

    public final Set<ax_1> c() {
        return Collections.unmodifiableSet(this.d.keySet());
    }

    public final bb_2 a(ResolvedType object, ObjectNode objectNode, av_2 av_22, boolean bl) {
        Map<ax_1, List<ObjectNode>> map2 = bl ? this.f : this.e;
        object = new ax_1((ResolvedType)object, av_22);
        object = map2.computeIfAbsent((ax_1)object, ax_12 -> new ArrayList());
        object.add(objectNode);
        return this;
    }

    public final List<ObjectNode> b(ax_1 ax_12) {
        return Collections.unmodifiableList(this.e.getOrDefault(ax_12, Collections.emptyList()));
    }

    public final List<ObjectNode> c(ax_1 ax_12) {
        return Collections.unmodifiableList(this.f.getOrDefault(ax_12, Collections.emptyList()));
    }

    @Override
    public final ObjectNode a(ResolvedType resolvedType) {
        return this.a(resolvedType, (bk_2)null);
    }

    @Override
    public final ObjectNode b(ResolvedType resolvedType) {
        return this.a(resolvedType, (bv_2)null);
    }

    @Override
    public final ObjectNode a(ResolvedType object, bk_2 bk_22) {
        ObjectNode objectNode = this.b.o();
        object = this.c.b((ResolvedType)object);
        this.a((av_1)object, objectNode, false, true, bk_22);
        return objectNode;
    }

    @Override
    public final ObjectNode a(ay_2 ay_22, ax_2<ay_2> ax_22) {
        return this.a(ay_22, false, true, ax_22);
    }

    @Override
    public final JsonNode a(ac_1 ac_12, ax_2<ac_1> ax_22) {
        return this.a(ac_12, false, true, ax_22);
    }

    @Override
    public final ObjectNode a(ResolvedType object, bv_2 bv_22) {
        ObjectNode objectNode = this.b.o();
        object = this.c.b((ResolvedType)object);
        this.a((av_1)object, objectNode, false, false, bv_22);
        return objectNode;
    }

    @Override
    public final ObjectNode b(ay_2 ay_22, ax_2<ay_2> ax_22) {
        return this.a(ay_22, false, false, ax_22);
    }

    @Override
    public final JsonNode b(ac_1 ac_12, ax_2<ac_1> ax_22) {
        return this.a(ac_12, false, false, ax_22);
    }

    private void a(ResolvedType object, ObjectNode objectNode, boolean bl) {
        object = this.c.b((ResolvedType)object);
        this.a((av_1)object, objectNode, false, false, null);
    }

    private void a(av_1 av_12, ObjectNode objectNode, boolean bl, boolean bl2, av_2 av_22) {
        ObjectNode objectNode2;
        boolean bl3;
        Object object = av_12;
        ResolvedType resolvedType = ((av_1)object).d;
        if (!bl2 && this.a(resolvedType, av_22)) {
            a.debug("adding reference to existing definition of {}", (Object)resolvedType);
            this.a(resolvedType, objectNode, av_22, bl);
            return;
        }
        at_2 at_22 = this.b.a(resolvedType, (ai_1)this, av_22);
        if (at_22 != null && (at_22.b() || bl2)) {
            bl3 = at_22.c();
            if (objectNode == null) {
                a.debug("storing configured custom inline type for {} as definition (since it is the main schema \"#\")", (Object)resolvedType);
                object = at_22;
                objectNode2 = ((at_2)object).a;
                this.a(resolvedType, objectNode2, av_22);
            } else {
                a.debug("directly applying configured custom inline type for {}", (Object)resolvedType);
                object = at_22;
                objectNode.setAll(((at_2)object).a);
                objectNode2 = objectNode;
            }
            if (bl) {
                this.a(objectNode2);
            }
        } else {
            boolean bl4;
            bl3 = au_1.c(resolvedType);
            if (bl2 || bl3 && objectNode != null && at_22 == null) {
                objectNode2 = objectNode;
            } else {
                objectNode2 = this.b.o();
                this.a(resolvedType, objectNode2, av_22);
                if (objectNode != null) {
                    this.a(resolvedType, objectNode, av_22, bl);
                }
            }
            if (at_22 != null) {
                a.debug("applying configured custom definition for {}", (Object)resolvedType);
                object = at_22;
                objectNode2.setAll(((at_2)object).a);
                bl4 = at_22.c();
            } else if (bl3) {
                a.debug("generating array definition for {}", (Object)resolvedType);
                this.a(av_12, objectNode2, bl);
                bl4 = true;
            } else {
                a.debug("generating definition for {}", (Object)resolvedType);
                bl4 = bl3 = !this.a(resolvedType, objectNode2);
            }
        }
        if (bl3) {
            Set<String> set = this.b(objectNode2);
            objectNode = aw_1.a(av_12, this, set);
            objectNode.setAll(objectNode2);
            objectNode2.setAll(objectNode);
        }
        this.b.r().forEach(at_12 -> at_12.a(objectNode2, av_12, this));
    }

    private boolean a(ResolvedType object, ObjectNode objectNode) {
        List list = this.b.a((ResolvedType)object, this);
        if (list.isEmpty()) {
            this.b((ResolvedType)object, objectNode);
            return false;
        }
        object = list.size() == 1 ? ap_1.TAG_ALLOF : ap_1.TAG_ANYOF;
        object = objectNode.withArray(this.a((ap_1)((Object)object)));
        list.forEach(arg_0 -> this.a((ArrayNode)object, arg_0));
        return true;
    }

    private Set<String> b(ObjectNode iterable) {
        iterable = (iterable = ((JsonNode)iterable).get(this.a(ap_1.TAG_TYPE))) == null ? Collections.emptySet() : (((JsonNode)iterable).isTextual() ? Collections.singleton(((JsonNode)iterable).textValue()) : StreamSupport.stream(iterable.spliterator(), false).map(JsonNode::textValue).collect(Collectors.toSet()));
        return iterable;
    }

    private void a(av_1 object, ObjectNode objectNode, boolean bl) {
        if (bl) {
            ArrayNode arrayNode = this.b.p().add(this.a(ap_1.TAG_TYPE_ARRAY)).add(this.a(ap_1.TAG_TYPE_NULL));
            objectNode.set(this.a(ap_1.TAG_TYPE), arrayNode);
        } else {
            objectNode.put(this.a(ap_1.TAG_TYPE), this.a(ap_1.TAG_TYPE_ARRAY));
        }
        if (object instanceof ab_1) {
            ab_1 ab_12 = (ab_1)object;
            if (!ab_12.c) {
                ab_12 = ((ab_1)object).e();
                if (object instanceof ay_2) {
                    object = this.a((ay_2)ab_12);
                } else if (object instanceof ac_1) {
                    object = this.a((ac_1)ab_12);
                } else {
                    throw new IllegalStateException("Unsupported member type: " + object.getClass().getName());
                }
                objectNode.set(this.a(ap_1.TAG_ITEMS), (JsonNode)object);
                return;
            }
        }
        ObjectNode objectNode2 = this.b.o();
        objectNode.set(this.a(ap_1.TAG_ITEMS), objectNode2);
        this.a(((av_1)object).w(), objectNode2, false);
    }

    private void b(ResolvedType object, ObjectNode objectNode) {
        objectNode.put(this.a(ap_1.TAG_TYPE), this.a(ap_1.TAG_TYPE_OBJECT));
        Object object2 = new LinkedHashMap();
        HashSet<String> hashSet = new HashSet<String>();
        this.a((ResolvedType)object, (Map<String, ab_1<?, ?>>)object2, (Set<String>)hashSet);
        if (!object2.isEmpty()) {
            object = this.b.o();
            object2 = object2.values().stream().sorted(this.b::a).collect(Collectors.toList());
            Object object3 = object2.iterator();
            while (object3.hasNext()) {
                JsonNode jsonNode;
                ab_1 ab_12 = (ab_1)object3.next();
                if (ab_12 instanceof ay_2) {
                    jsonNode = this.a((ay_2)ab_12);
                } else if (ab_12 instanceof ac_1) {
                    jsonNode = this.a((ac_1)ab_12);
                } else {
                    throw new IllegalStateException("Unsupported member scope of type " + ab_12.getClass());
                }
                ((ObjectNode)object).set(ab_12.s(), jsonNode);
            }
            objectNode.set(this.a(ap_1.TAG_PROPERTIES), (JsonNode)object);
            if (!hashSet.isEmpty()) {
                object3 = this.b.p();
                object2.stream().map(ab_1::s).filter(hashSet::contains).forEach(((ArrayNode)object3)::add);
                objectNode.set(this.a(ap_1.TAG_REQUIRED), (JsonNode)object3);
            }
        }
    }

    private void a(ResolvedType resolvedType, Map<String, ab_1<?, ?>> map2, Set<String> set) {
        a.debug("collecting non-static fields and methods from {}", (Object)resolvedType);
        ResolvedTypeWithMembers resolvedTypeWithMembers = this.c.a(resolvedType);
        this.a(resolvedTypeWithMembers, ResolvedTypeWithMembers::getMemberFields, map2, set);
        this.b(resolvedTypeWithMembers, ResolvedTypeWithMembers::getMemberMethods, map2, set);
        boolean bl = this.b.i();
        boolean bl2 = this.b.j();
        if (bl || bl2) {
            for (HierarchicType hierarchicType : resolvedTypeWithMembers.allTypesAndOverrides()) {
                hierarchicType = hierarchicType.getType();
                a.debug("collecting static fields and methods from {}", (Object)hierarchicType);
                if ((!bl || hierarchicType.getStaticFields().isEmpty()) && (!bl2 || hierarchicType.getStaticMethods().isEmpty())) continue;
                hierarchicType = hierarchicType == resolvedType ? resolvedTypeWithMembers : this.c.a((ResolvedType)hierarchicType);
                if (bl) {
                    this.a((ResolvedTypeWithMembers)hierarchicType, ResolvedTypeWithMembers::getStaticFields, map2, set);
                }
                if (!bl2) continue;
                this.b((ResolvedTypeWithMembers)hierarchicType, ResolvedTypeWithMembers::getStaticMethods, map2, set);
            }
        }
    }

    private void a(ResolvedTypeWithMembers resolvedTypeWithMembers, Function<ResolvedTypeWithMembers, ResolvedField[]> function, Map<String, ab_1<?, ?>> map2, Set<String> set) {
        Stream.of(function.apply(resolvedTypeWithMembers)).map(resolvedField -> this.c.a((ResolvedField)resolvedField, resolvedTypeWithMembers)).filter(ay_22 -> !this.b.e((ay_2)ay_22)).forEach(object3 -> {
            Object object4;
            ay_2 ay_22 = object3;
            Set set = set;
            object3 = map2;
            set = ay_22;
            map2 = this;
            Object object5 = set;
            if (((ab_1)object5).c) {
                object4 = set;
                object5 = ((ab_1)((Object)set)).s();
            } else {
                object4 = ((bb_2)object).b.h((ay_2)((Object)set));
                object4 = object4 == null ? set : ((ay_2)((Object)set)).a((String)object4);
                object5 = ((ab_1)object4).s();
                if (((bb_2)object).b.b((ay_2)((Object)set))) {
                    set.add(object5);
                }
                if (object3.containsKey(object5)) {
                    object5 = object4;
                    a.debug("ignoring overridden {}.{}", (Object)((ab_1)object5).a.getDeclaringType(), (Object)((ab_1)object4).k());
                    return;
                }
            }
            object3.put(object5, object4);
        });
    }

    private void b(ResolvedTypeWithMembers resolvedTypeWithMembers, Function<ResolvedTypeWithMembers, ResolvedMethod[]> function, Map<String, ab_1<?, ?>> map2, Set<String> set) {
        Stream.of(function.apply(resolvedTypeWithMembers)).map(resolvedMethod -> this.c.a((ResolvedMethod)resolvedMethod, resolvedTypeWithMembers)).filter(ac_12 -> !this.b.e((ac_1)ac_12)).forEach(object3 -> {
            Object object4;
            ac_1 ac_12 = object3;
            Set set = set;
            object3 = map2;
            set = ac_12;
            map2 = this;
            Object object5 = set;
            if (((ab_1)object5).c) {
                object4 = set;
                object5 = ((ab_1)((Object)set)).s();
            } else {
                object4 = ((bb_2)object).b.h((ac_1)((Object)set));
                object4 = object4 == null ? set : ((ac_1)((Object)set)).a((String)object4);
                object5 = ((ab_1)object4).s();
                if (((bb_2)object).b.b((ac_1)((Object)set))) {
                    set.add(object5);
                }
                if (object3.containsKey(object5)) {
                    object5 = object4;
                    a.debug("ignoring overridden {}.{}", (Object)((ab_1)object5).a.getDeclaringType(), (Object)((ab_1)object4).k());
                    return;
                }
            }
            object3.put(object5, object4);
        });
    }

    private void a(ay_2 ay_22, Map<String, ab_1<?, ?>> map2, Set<String> set) {
        Object object;
        Object object2 = ay_22;
        if (((ab_1)object2).c) {
            object = ay_22;
            object2 = ay_22.s();
        } else {
            object = this.b.h(ay_22);
            object = object == null ? ay_22 : ay_22.a((String)object);
            object2 = ((ab_1)object).s();
            if (this.b.b(ay_22)) {
                set.add((String)object2);
            }
            if (map2.containsKey(object2)) {
                object2 = object;
                a.debug("ignoring overridden {}.{}", (Object)((ab_1)object2).a.getDeclaringType(), (Object)((ab_1)object).k());
                return;
            }
        }
        map2.put((String)object2, (ab_1<?, ?>)object);
    }

    /*
     * Unable to fully structure code
     */
    private ObjectNode a(ay_2 var1_1) {
        var2_3 = this.b.g(var1_1);
        if (var2_3 == null) {
            var3_4 = var1_1;
            var2_3 = this.b.a(var3_4.d, this);
        }
        var2_3 = var2_3 == null || var2_3.isEmpty() != false ? Collections.singletonList(var1_1) : var2_3.stream().map((Function<ResolvedType, ay_2>)LambdaMetafactory.metafactory(null, null, null, (Ljava/lang/Object;)Ljava/lang/Object;, a(com.fasterxml.classmate.ResolvedType ), (Lcom/fasterxml/classmate/ResolvedType;)Lorg/valkyrienskies/core/impl/shadow/ay;)((ay_2)var1_1)).collect(Collectors.toList());
        var3_4 = var1_1;
        if (((Field)var3_4.a.getRawMember()).isEnumConstant()) ** GOTO lbl-1000
        var3_4 = var1_1;
        if ((!var3_4.c || this.b.m()) && this.b.a(var1_1)) {
            v0 = true;
        } else lbl-1000:
        // 2 sources

        {
            v0 = var1_2 = false;
        }
        if (var2_3.size() == 1) {
            return this.a((ay_2)var2_3.get(0), var1_2, false, null);
        }
        var3_4 = this.b.o();
        var4_5 = var3_4.withArray(this.a(ap_1.TAG_ANYOF));
        if (var1_2) {
            var4_5.addObject().put(this.a(ap_1.TAG_TYPE), this.a(ap_1.TAG_TYPE_NULL));
        }
        var2_3.forEach((Consumer<ay_2>)LambdaMetafactory.metafactory(null, null, null, (Ljava/lang/Object;)V, a(com.fasterxml.jackson.databind.node.ArrayNode org.valkyrienskies.core.impl.shadow.ay_2 ), (Lorg/valkyrienskies/core/impl/shadow/ay;)V)((bb_2)this, (ArrayNode)var4_5));
        return var3_4;
    }

    private ObjectNode a(ay_2 ay_22, boolean bl, boolean bl2, ax_2<ay_2> ax_22) {
        ObjectNode objectNode = this.b.o();
        ObjectNode objectNode2 = aw_1.a(ay_22, (ai_1)this);
        this.a(ay_22, objectNode, bl, bl2, objectNode2, ax_22);
        return objectNode;
    }

    private void a(ac_1 ac_12, Map<String, ab_1<?, ?>> map2, Set<String> set) {
        Object object;
        Object object2 = ac_12;
        if (((ab_1)object2).c) {
            object = ac_12;
            object2 = ac_12.s();
        } else {
            object = this.b.h(ac_12);
            object = object == null ? ac_12 : ac_12.a((String)object);
            object2 = ((ab_1)object).s();
            if (this.b.b(ac_12)) {
                set.add((String)object2);
            }
            if (map2.containsKey(object2)) {
                object2 = object;
                a.debug("ignoring overridden {}.{}", (Object)((ab_1)object2).a.getDeclaringType(), (Object)((ab_1)object).k());
                return;
            }
        }
        map2.put((String)object2, (ab_1<?, ?>)object);
    }

    /*
     * Unable to fully structure code
     */
    private JsonNode a(ac_1 var1_1) {
        var2_3 = this.b.g(var1_1);
        if (var2_3 == null && !var1_1.b()) {
            var3_4 = var1_1;
            var2_3 = this.b.a(var3_4.d, this);
        }
        var2_3 = var2_3 == null || var2_3.isEmpty() != false ? Collections.singletonList(var1_1) : var2_3.stream().map((Function<ResolvedType, ac_1>)LambdaMetafactory.metafactory(null, null, null, (Ljava/lang/Object;)Ljava/lang/Object;, a(com.fasterxml.classmate.ResolvedType ), (Lcom/fasterxml/classmate/ResolvedType;)Lorg/valkyrienskies/core/impl/shadow/aC;)((ac_1)var1_1)).collect(Collectors.toList());
        if (var1_1.b()) ** GOTO lbl-1000
        var3_4 = var1_1;
        if ((!var3_4.c || this.b.m()) && this.b.a(var1_1)) lbl-1000:
        // 2 sources

        {
            v0 = true;
        } else {
            v0 = var1_2 = false;
        }
        if (var2_3.size() == 1) {
            return this.a((ac_1)var2_3.get(0), var1_2, false, null);
        }
        var3_4 = this.b.o();
        var4_5 = var3_4.withArray(this.a(ap_1.TAG_ANYOF));
        if (var1_2) {
            var4_5.add(this.b.o().put(this.a(ap_1.TAG_TYPE), this.a(ap_1.TAG_TYPE_NULL)));
        }
        var2_3.forEach((Consumer<ac_1>)LambdaMetafactory.metafactory(null, null, null, (Ljava/lang/Object;)V, a(com.fasterxml.jackson.databind.node.ArrayNode org.valkyrienskies.core.impl.shadow.ac_1 ), (Lorg/valkyrienskies/core/impl/shadow/aC;)V)((bb_2)this, (ArrayNode)var4_5));
        return var3_4;
    }

    private JsonNode a(ac_1 ac_12, boolean bl, boolean bl2, ax_2<ac_1> ax_22) {
        if (ac_12.b()) {
            return BooleanNode.FALSE;
        }
        ObjectNode objectNode = this.b.o();
        ObjectNode objectNode2 = aw_1.a(ac_12, (ai_1)this);
        this.a(ac_12, objectNode, bl, bl2, objectNode2, ax_22);
        return objectNode;
    }

    private <M extends ab_1<?, ?>> void a(M object, ObjectNode objectNode, boolean bl, boolean bl2, ObjectNode objectNode2, ax_2<M> set) {
        if ((set = this.b.a((ab_1)object, this, (ax_2)((Object)set))) != null && ((at_2)((Object)set)).b()) {
            Set<String> set2 = set;
            objectNode.setAll(((at_2)((Object)set2)).a);
            if (((at_2)((Object)set)).c()) {
                aw_1.a(objectNode, objectNode2);
                set = this.b(objectNode);
                object = aw_1.a(object, this, set);
                aw_1.a(objectNode, object);
            }
            if (bl) {
                this.a(objectNode);
                return;
            }
        } else {
            if (set != null && !((at_2)((Object)set)).c() || objectNode2 == null || ((JsonNode)objectNode2).size() == 0) {
                set = objectNode;
            } else if (set == null && object.v()) {
                set = objectNode;
                aw_1.a(objectNode, objectNode2);
            } else {
                set = this.b.o();
                objectNode.set(this.a(ap_1.TAG_ALLOF), this.b.p().add((JsonNode)((Object)set)).add(objectNode2));
            }
            try {
                this.a((av_1)object, (ObjectNode)((Object)set), bl, bl2, null);
                return;
            }
            catch (UnsupportedOperationException unsupportedOperationException) {
                a.warn("Skipping type definition due to error", (Throwable)unsupportedOperationException);
            }
        }
    }

    @Override
    public final ObjectNode a(ObjectNode objectNode) {
        String string = this.a(ap_1.TAG_TYPE_NULL);
        if (objectNode.has(this.a(ap_1.TAG_REF)) || objectNode.has(this.a(ap_1.TAG_ALLOF)) || objectNode.has(this.a(ap_1.TAG_ANYOF)) || objectNode.has(this.a(ap_1.TAG_ONEOF)) || objectNode.has(this.a(ap_1.TAG_CONST)) || objectNode.has(this.a(ap_1.TAG_ENUM))) {
            ContainerNode containerNode = this.b.o().put(this.a(ap_1.TAG_TYPE), string);
            containerNode = this.b.p().add(containerNode).add((JsonNode)this.b.o().setAll(objectNode));
            objectNode.removeAll();
            objectNode.set(this.a(ap_1.TAG_ANYOF), containerNode);
        } else {
            JsonNode jsonNode = ((JsonNode)objectNode).get(this.a(ap_1.TAG_TYPE));
            if (jsonNode instanceof ArrayNode) {
                jsonNode = (ArrayNode)jsonNode;
                boolean bl = false;
                for (JsonNode jsonNode2 : jsonNode) {
                    bl = bl || string.equals(jsonNode2.textValue());
                }
                if (!bl) {
                    objectNode.replace(this.a(ap_1.TAG_TYPE), this.b.p().addAll((ArrayNode)jsonNode).add(string));
                }
            } else if (jsonNode instanceof TextNode && !string.equals(jsonNode.textValue())) {
                objectNode.replace(this.a(ap_1.TAG_TYPE), this.b.p().add(jsonNode).add(string));
            }
        }
        return objectNode;
    }

    @Override
    public final String a(ap_1 ap_12) {
        return this.b.a(ap_12);
    }

    private /* synthetic */ void a(ArrayNode arrayNode, ac_1 ac_12) {
        arrayNode.add(this.a(ac_12, false, false, null));
    }

    private /* synthetic */ void a(ArrayNode arrayNode, ay_2 ay_22) {
        arrayNode.add(this.a(ay_22, false, false, null));
    }

    private /* synthetic */ void a(ArrayNode arrayNode, ResolvedType resolvedType) {
        this.a(resolvedType, arrayNode.addObject(), false);
    }
}

