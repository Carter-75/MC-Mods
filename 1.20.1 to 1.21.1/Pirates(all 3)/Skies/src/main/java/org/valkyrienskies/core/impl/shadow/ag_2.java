/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.ag
 */
final class ag_2 {
    ag_2() {
    }

    static List<JsonNode> a(ArrayNode arrayNode) {
        int n2 = ((JsonNode)arrayNode).size();
        ArrayList<JsonNode> arrayList = new ArrayList<JsonNode>(n2);
        for (int i2 = 0; i2 < n2; ++i2) {
            arrayList.add(((JsonNode)arrayNode).get(i2));
        }
        return arrayList;
    }

    private static List<JsonNode> a(List<JsonNode> list, List<JsonNode> list2) {
        int n2;
        int n3;
        if (list == null || list2 == null) {
            throw new NullPointerException("List must not be null for longestCommonSubsequence");
        }
        LinkedList<JsonNode> linkedList = new LinkedList<JsonNode>();
        int n4 = list.size();
        int n5 = list2.size();
        int[][] nArray = new int[n4 + 1][n5 + 1];
        for (n3 = 1; n3 <= n4; ++n3) {
            for (n2 = 1; n2 <= n5; ++n2) {
                nArray[n3][n2] = n3 == 0 || n2 == 0 ? 0 : (list.get(n3 - 1).equals(list2.get(n2 - 1)) ? nArray[n3 - 1][n2 - 1] + 1 : Math.max(nArray[n3][n2 - 1], nArray[n3 - 1][n2]));
            }
        }
        n3 = n4;
        n2 = n5;
        while (n3 > 0 && n2 > 0) {
            if (list.get(n3 - 1).equals(list2.get(n2 - 1))) {
                linkedList.add(list.get(n3 - 1));
                --n3;
                --n2;
                continue;
            }
            if (nArray[n3 - 1][n2] > nArray[n3][n2 - 1]) {
                --n3;
                continue;
            }
            --n2;
        }
        Collections.reverse(linkedList);
        return linkedList;
    }
}

