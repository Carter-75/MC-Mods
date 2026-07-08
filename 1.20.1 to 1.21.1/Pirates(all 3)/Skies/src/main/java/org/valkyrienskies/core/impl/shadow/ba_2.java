/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;
import org.valkyrienskies.core.impl.shadow.ak_1;
import org.valkyrienskies.core.impl.shadow.ap_1;
import org.valkyrienskies.core.impl.shadow.aq_1;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.ba
 */
public final class ba_2 {
    private final ak_1 a;

    public ba_2(ak_1 ak_12) {
        this.a = ak_12;
    }

    public final void a(List<ObjectNode> list) {
        String string = this.a.a(ap_1.TAG_ALLOF);
        this.a(list, (ObjectNode objectNode) -> this.a((JsonNode)objectNode, string));
    }

    public final void b(List<ObjectNode> list) {
        String string = this.a.a(ap_1.TAG_ANYOF);
        this.a(list, (ObjectNode objectNode) -> this.b((JsonNode)objectNode, string));
    }

    private Set<String> a() {
        aq_1 aq_12 = this.a.a();
        return Stream.of(ap_1.TAG_ADDITIONAL_PROPERTIES, ap_1.TAG_ITEMS).map(ap_12 -> ap_12.a(aq_12)).collect(Collectors.toSet());
    }

    private Set<String> b() {
        aq_1 aq_12 = this.a.a();
        return Stream.of(ap_1.TAG_ALLOF, ap_1.TAG_ANYOF, ap_1.TAG_ONEOF).map(ap_12 -> ap_12.a(aq_12)).collect(Collectors.toSet());
    }

    private Set<String> c() {
        aq_1 aq_12 = this.a.a();
        return Stream.of(ap_1.TAG_PATTERN_PROPERTIES, ap_1.TAG_PROPERTIES).map(ap_12 -> ap_12.a(aq_12)).collect(Collectors.toSet());
    }

    private void a(List<ObjectNode> list, Consumer<ObjectNode> consumer) {
        list = new ArrayList<ObjectNode>(list);
        Consumer<JsonNode> consumer2 = jsonNode -> {
            if (jsonNode instanceof ObjectNode) {
                list.add((ObjectNode)jsonNode);
            }
        };
        Set<String> set = this.a();
        Set<String> set2 = this.b();
        Set<String> set3 = this.c();
        do {
            Object object = new ArrayList<ObjectNode>(list);
            list.clear();
            object = object.iterator();
            while (object.hasNext()) {
                ObjectNode objectNode = (ObjectNode)object.next();
                consumer.accept(objectNode);
                set.stream().map(objectNode::get).forEach(consumer2);
                set2.stream().map(objectNode::get).filter(jsonNode -> jsonNode instanceof ArrayNode).forEach(jsonNode -> jsonNode.forEach(consumer2));
                set3.stream().map(objectNode::get).filter(jsonNode -> jsonNode instanceof ObjectNode).forEach(jsonNode -> jsonNode.forEach(consumer2));
            }
        } while (!list.isEmpty());
    }

    private void a(JsonNode jsonNode2, String string) {
        if (!(jsonNode2 instanceof ObjectNode)) {
            return;
        }
        Iterable<JsonNode> iterable = jsonNode2.get(string);
        if (!(iterable instanceof ArrayNode)) {
            return;
        }
        iterable.forEach(jsonNode -> this.a((JsonNode)jsonNode, string));
        Object object = new ArrayList();
        iterable.forEach(arg_0 -> object.add(arg_0));
        if (object.stream().anyMatch(jsonNode -> !(jsonNode instanceof ObjectNode) && !jsonNode.asBoolean())) {
            return;
        }
        iterable = object.stream().filter(jsonNode -> jsonNode instanceof ObjectNode).map(jsonNode -> (ObjectNode)jsonNode).collect(Collectors.toList());
        object = Stream.concat(Stream.of(jsonNode2), iterable.stream()).flatMap(jsonNode -> StreamSupport.stream(((Iterable)() -> jsonNode.fields()).spliterator(), false)).collect(Collectors.groupingBy(Map.Entry::getKey, Collectors.mapping(Map.Entry::getValue, Collectors.toList())));
        if ((this.a.a() == aq_1.DRAFT_6 || this.a.a() == aq_1.DRAFT_7) && object.containsKey(this.a.a(ap_1.TAG_REF))) {
            return;
        }
        String string2 = this.a.a(ap_1.TAG_IF);
        for (Map.Entry entry : object.entrySet()) {
            int n2;
            if (((List)entry.getValue()).size() == 1) continue;
            if (string2.equals(entry.getKey())) {
                return;
            }
            if (!string.equals(entry.getKey())) {
                n2 = 0;
            } else {
                if (((List)entry.getValue()).size() == 2) continue;
                n2 = 1;
            }
            if (((List)entry.getValue()).stream().skip(n2 + 1).allMatch(((JsonNode)((List)entry.getValue()).get(n2))::equals)) continue;
            return;
        }
        object = (ObjectNode)jsonNode2;
        ((ObjectNode)object).remove(string);
        iterable.forEach(((ObjectNode)object)::setAll);
    }

    private void b(JsonNode jsonNode2, String string) {
        if (!(jsonNode2 instanceof ObjectNode)) {
            return;
        }
        if (!((jsonNode2 = jsonNode2.get(string)) instanceof ArrayNode)) {
            return;
        }
        jsonNode2.forEach(jsonNode -> this.b((JsonNode)jsonNode, string));
        for (int i2 = jsonNode2.size() - 1; i2 >= 0; --i2) {
            JsonNode jsonNode3 = jsonNode2.get(i2);
            if (!(jsonNode3 instanceof ObjectNode) || jsonNode3.size() != 1 || !((jsonNode3 = jsonNode3.get(string)) instanceof ArrayNode)) continue;
            ((ArrayNode)jsonNode2).remove(i2);
            for (int i3 = jsonNode3.size() - 1; i3 >= 0; --i3) {
                ((ArrayNode)jsonNode2).insert(i2, jsonNode3.get(i3));
            }
        }
    }

    public final String a(String string) {
        return string.replaceAll("\\[\\]", "*").replaceAll("<", "(").replaceAll(">", ")").replaceAll("[^a-zA-Z0-9\\.\\-_\\$\\*\\(\\),]+", "");
    }

    public final String b(String string) {
        return string.replaceAll("\\$", "-").replaceAll("\\[\\]", "...").replaceAll("[<>]", "_").replaceAll(",", ".").replaceAll("[^a-zA-Z0-9\\.\\-_]+", "");
    }
}

