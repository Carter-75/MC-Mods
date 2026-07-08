/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.slf4j.Logger
 *  org.slf4j.LoggerFactory
 */
package org.valkyrienskies.core.impl.shadow;

import com.fasterxml.jackson.databind.JsonNode;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.valkyrienskies.core.impl.shadow.bt_1;
import org.valkyrienskies.core.impl.shadow.bv_1;
import org.valkyrienskies.core.impl.shadow.cp_2;
import org.valkyrienskies.core.impl.shadow.cv_2;
import org.valkyrienskies.core.impl.shadow.df_2;
import org.valkyrienskies.core.impl.shadow.dg_2;
import org.valkyrienskies.core.impl.shadow.di_2;
import org.valkyrienskies.core.impl.shadow.dj_2;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.bP
 */
public class bp_1
extends bt_1
implements cv_2 {
    private static final Logger g = LoggerFactory.getLogger(bp_1.class);
    private final boolean i;
    private final cp_2 j;
    private final Set<String> k;
    private final List<Pattern> l = new ArrayList<Pattern>();

    public bp_1(String iterator2, JsonNode jsonNode, cp_2 cp_22, df_2 df_22) {
        super((String)((Object)iterator2), jsonNode, cp_22, dj_2.ADDITIONAL_PROPERTIES, df_22);
        if (jsonNode.isBoolean()) {
            this.i = jsonNode.booleanValue();
            this.j = null;
        } else if (jsonNode.isObject()) {
            this.i = true;
            this.j = new cp_2(df_22, this.e().a(), cp_22.i(), jsonNode, cp_22);
        } else {
            this.i = false;
            this.j = null;
        }
        this.k = new HashSet<String>();
        iterator2 = cp_22.c().get("properties");
        if (iterator2 != null) {
            iterator2 = ((JsonNode)((Object)iterator2)).fieldNames();
            while (iterator2.hasNext()) {
                this.k.add((String)iterator2.next());
            }
        }
        if ((iterator2 = cp_22.c().get("patternProperties")) != null) {
            iterator2 = ((JsonNode)((Object)iterator2)).fieldNames();
            while (iterator2.hasNext()) {
                this.l.add(Pattern.compile(iterator2.next()));
            }
        }
        bp_1 bp_12 = this;
        bp_12.a(bp_12.e().d());
    }

    private void b(String string) {
        ArrayList<String> arrayList = bv_1.a().a("com.networknt.schema.UnEvaluatedPropertiesValidator.EvaluatedProperties");
        if (arrayList == null) {
            arrayList = new ArrayList<String>();
            bv_1.a().a("com.networknt.schema.UnEvaluatedPropertiesValidator.EvaluatedProperties", arrayList);
        } else {
            arrayList = arrayList;
        }
        arrayList.add(string);
    }

    @Override
    public Set<dg_2> a(JsonNode jsonNode, JsonNode jsonNode2, String string) {
        Iterator<String> iterator2;
        if (g.isDebugEnabled()) {
            this.a(g, jsonNode, jsonNode2, string);
        }
        LinkedHashSet<dg_2> linkedHashSet = new LinkedHashSet<dg_2>();
        if (!jsonNode.isObject()) {
            return linkedHashSet;
        }
        if (this.i) {
            iterator2 = jsonNode.fieldNames();
            while (iterator2.hasNext()) {
                this.b(string + "." + iterator2.next());
            }
        }
        iterator2 = jsonNode.fieldNames();
        while (iterator2.hasNext()) {
            String string2 = iterator2.next();
            if (string2.startsWith("#")) continue;
            boolean bl = false;
            for (Pattern pattern : this.l) {
                Matcher object = pattern.matcher(string2);
                if (!object.find()) continue;
                bl = true;
                break;
            }
            if (this.k.contains(string2) || bl) continue;
            if (!this.i) {
                linkedHashSet.add(this.a(string, string2));
                continue;
            }
            if (this.j == null) continue;
            di_2 di_22 = (di_2)bv_1.a().a("com.networknt.schema.ValidatorState");
            if (di_22 != null && di_22.c()) {
                linkedHashSet.addAll(((bt_1)this.j).a(jsonNode.get(string2), jsonNode2, string + "." + string2, di_22.d()));
                continue;
            }
            linkedHashSet.addAll(this.j.a(jsonNode.get(string2), jsonNode2, string + "." + string2));
        }
        return Collections.unmodifiableSet(linkedHashSet);
    }

    @Override
    public Set<dg_2> a(JsonNode jsonNode, JsonNode jsonNode2, String string, boolean bl) {
        if (bl) {
            return this.a(jsonNode, jsonNode2, string);
        }
        if (jsonNode == null || !jsonNode.isObject()) {
            return Collections.emptySet();
        }
        Iterator<String> iterator2 = jsonNode.fieldNames();
        while (iterator2.hasNext()) {
            String string2 = iterator2.next();
            if (string2.startsWith("#")) continue;
            boolean bl2 = false;
            Object object = this.l.iterator();
            while (object.hasNext()) {
                Object object2 = object.next();
                if (!((Matcher)(object2 = ((Pattern)object2).matcher(string2))).find()) continue;
                bl2 = true;
                break;
            }
            if (this.k.contains(string2) || bl2 || !this.i || this.j == null || (object = (di_2)bv_1.a().a("com.networknt.schema.ValidatorState")) == null || !((di_2)object).c()) continue;
            ((bt_1)this.j).a(jsonNode.get(string2), jsonNode2, string + "." + string2, ((di_2)object).d());
        }
        return Collections.emptySet();
    }

    @Override
    public void a_() {
        if (this.j != null) {
            this.j.o();
        }
    }
}

