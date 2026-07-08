/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.apache.commons.lang3.StringUtils
 *  org.slf4j.Logger
 *  org.slf4j.LoggerFactory
 *  org.valkyrienskies.core.impl.shadow.co
 */
package org.valkyrienskies.core.impl.shadow;

import com.fasterxml.jackson.databind.JsonNode;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.valkyrienskies.core.impl.shadow.ci_2;
import org.valkyrienskies.core.impl.shadow.cj_2;
import org.valkyrienskies.core.impl.shadow.ck_1;
import org.valkyrienskies.core.impl.shadow.co;
import org.valkyrienskies.core.impl.shadow.cp_2;
import org.valkyrienskies.core.impl.shadow.cq_2;
import org.valkyrienskies.core.impl.shadow.cv_2;
import org.valkyrienskies.core.impl.shadow.cw_2;
import org.valkyrienskies.core.impl.shadow.df_2;
import org.valkyrienskies.core.impl.shadow.dj_2;
import org.valkyrienskies.core.impl.shadow.dk_2;
import org.valkyrienskies.core.impl.shadow.dm_2;
import org.valkyrienskies.core.impl.shadow.dn_2;
import org.valkyrienskies.core.impl.shadow.do_2;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.co
 */
public class co_2 {
    private static final Logger b = LoggerFactory.getLogger(co_2.class);
    private static Map<String, String> c = new ConcurrentHashMap<String, String>();
    public static final List<ci_2> a = new ArrayList<ci_2>();
    private final String d;
    private final String e;
    private final Map<String, cw_2> f;

    static ck_1 a(String string, String string2) {
        return new ck_1(string, string2);
    }

    private co_2(String string, String string2, Map<String, cw_2> map2) {
        if (StringUtils.isBlank((CharSequence)string)) {
            throw new IllegalArgumentException("uri must not be null or blank");
        }
        if (StringUtils.isBlank((CharSequence)string2)) {
            throw new IllegalArgumentException("idKeyword must not be null or blank");
        }
        if (map2 == null) {
            throw new IllegalArgumentException("keywords must not be null ");
        }
        this.d = string;
        this.e = string2;
        this.f = map2;
    }

    public static co_2 a() {
        return new dm_2().a();
    }

    public static co_2 b() {
        return new dn_2().a();
    }

    public static co_2 c() {
        return new do_2().a();
    }

    public static co_2 d() {
        return new dk_2().a();
    }

    public static a a(String string) {
        return new a(string);
    }

    public static a a(String string, co_2 co_22) {
        cj_2 cj_22 = (cj_2)co_22.f.get(dj_2.FORMAT.a());
        if (cj_22 == null) {
            throw new IllegalArgumentException("The formatKeyword did not exist - blueprint is invalid.");
        }
        return co_2.a(string).a(co_22.e).a(co_22.f.values()).b(cj_22.b());
    }

    public String a(JsonNode jsonNode) {
        return this.a(jsonNode, this.e);
    }

    public JsonNode a(String string, JsonNode object) {
        String string2;
        boolean bl = this.f.containsKey("$anchor");
        String string3 = bl ? string.substring(1) : string;
        boolean bl2 = string3.equals(this.a((JsonNode)object, string2 = bl ? "$anchor" : this.e));
        if (bl2) {
            return object;
        }
        object = ((JsonNode)object).elements();
        while (object.hasNext()) {
            JsonNode jsonNode = this.a(string, (JsonNode)object.next());
            if (jsonNode == null) continue;
            return jsonNode;
        }
        return null;
    }

    private String a(JsonNode jsonNode, String string) {
        if ((jsonNode = jsonNode.get(string)) == null || !jsonNode.isTextual()) {
            return null;
        }
        return jsonNode.textValue();
    }

    public String e() {
        return this.d;
    }

    public cv_2 a(df_2 df_22, String string, String string2, JsonNode jsonNode, cp_2 cp_22, String string3) {
        try {
            cw_2 cw_22 = this.f.get(string2);
            if (cw_22 == null) {
                String string4 = string2;
                if (c.put(string4, string4) == null) {
                    b.warn("Unknown keyword " + string2 + " - you should define your own Meta Schema. If the keyword is irrelevant for validation, just use a NonValidationKeyword");
                }
                return null;
            }
            cw_22.a(string3);
            return cw_22.a(string, jsonNode, cp_22, df_22);
        }
        catch (InvocationTargetException invocationTargetException) {
            InvocationTargetException invocationTargetException2 = invocationTargetException;
            if (invocationTargetException.getTargetException() instanceof cq_2) {
                b.error("Error:", (Throwable)invocationTargetException2);
                throw (cq_2)invocationTargetException2.getTargetException();
            }
            b.warn("Could not load validator " + string2);
            throw new cq_2(invocationTargetException2.getTargetException());
        }
        catch (cq_2 cq_22) {
            cq_2 cq_23 = cq_22;
            throw cq_22;
        }
        catch (Exception exception) {
            b.warn("Could not load validator " + string2);
            throw new cq_2(exception);
        }
    }

    static {
        a.add(co_2.a("time", "^\\d{2}:\\d{2}:\\d{2}(?:\\.\\d+)?$"));
        a.add(co_2.a("ip-address", "^(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)$"));
        a.add(co_2.a("ipv4", "^(([0-9]|[1-9][0-9]|1[0-9][0-9]|2[0-4][0-9]|25[0-5])\\.){3}([0-9]|[1-9][0-9]|1[0-9][0-9]|2[0-4][0-9]|25[0-5])$"));
        a.add(co_2.a("ipv6", "^\\s*((([0-9A-Fa-f]{1,4}:){7}([0-9A-Fa-f]{1,4}|:))|(([0-9A-Fa-f]{1,4}:){6}(:[0-9A-Fa-f]{1,4}|((25[0-5]|2[0-4]\\d|1\\d\\d|[1-9]?\\d)(\\.(25[0-5]|2[0-4]\\d|1\\d\\d|[1-9]?\\d)){3})|:))|(([0-9A-Fa-f]{1,4}:){5}(((:[0-9A-Fa-f]{1,4}){1,2})|:((25[0-5]|2[0-4]\\d|1\\d\\d|[1-9]?\\d)(\\.(25[0-5]|2[0-4]\\d|1\\d\\d|[1-9]?\\d)){3})|:))|(([0-9A-Fa-f]{1,4}:){4}(((:[0-9A-Fa-f]{1,4}){1,3})|((:[0-9A-Fa-f]{1,4})?:((25[0-5]|2[0-4]\\d|1\\d\\d|[1-9]?\\d)(\\.(25[0-5]|2[0-4]\\d|1\\d\\d|[1-9]?\\d)){3}))|:))|(([0-9A-Fa-f]{1,4}:){3}(((:[0-9A-Fa-f]{1,4}){1,4})|((:[0-9A-Fa-f]{1,4}){0,2}:((25[0-5]|2[0-4]\\d|1\\d\\d|[1-9]?\\d)(\\.(25[0-5]|2[0-4]\\d|1\\d\\d|[1-9]?\\d)){3}))|:))|(([0-9A-Fa-f]{1,4}:){2}(((:[0-9A-Fa-f]{1,4}){1,5})|((:[0-9A-Fa-f]{1,4}){0,3}:((25[0-5]|2[0-4]\\d|1\\d\\d|[1-9]?\\d)(\\.(25[0-5]|2[0-4]\\d|1\\d\\d|[1-9]?\\d)){3}))|:))|(([0-9A-Fa-f]{1,4}:){1}(((:[0-9A-Fa-f]{1,4}){1,6})|((:[0-9A-Fa-f]{1,4}){0,4}:((25[0-5]|2[0-4]\\d|1\\d\\d|[1-9]?\\d)(\\.(25[0-5]|2[0-4]\\d|1\\d\\d|[1-9]?\\d)){3}))|:))|(:(((:[0-9A-Fa-f]{1,4}){1,7})|((:[0-9A-Fa-f]{1,4}){0,5}:((25[0-5]|2[0-4]\\d|1\\d\\d|[1-9]?\\d)(\\.(25[0-5]|2[0-4]\\d|1\\d\\d|[1-9]?\\d)){3}))|:)))(%.+)?\\s*$"));
        a.add(co_2.a("uri", "^[A-Za-z][A-Za-z0-9+.-]*:(\\/\\/([A-Za-z0-9._~\\-%!$&'()*+,;=:]*@)?[A-Za-z0-9._~\\-!$&'()*+,;=%:\\[\\]]*(:[0-9]*)?)?[A-Za-z0-9._~\\-%!$&'()*+,;=:@\\/]*([?][A-Za-z0-9._~\\-%!$&'()*+,;=:@\\/?]*)?([#][A-Za-z0-9._~\\-%!$&'()*+,;=:@\\/?]*)?"));
        a.add(co_2.a("color", "(#?([0-9A-Fa-f]{3,6})\\b)|(aqua)|(black)|(blue)|(fuchsia)|(gray)|(green)|(lime)|(maroon)|(navy)|(olive)|(orange)|(purple)|(red)|(silver)|(teal)|(white)|(yellow)|(rgb\\(\\s*\\b([0-9]|[1-9][0-9]|1[0-9][0-9]|2[0-4][0-9]|25[0-5])\\b\\s*,\\s*\\b([0-9]|[1-9][0-9]|1[0-9][0-9]|2[0-4][0-9]|25[0-5])\\b\\s*,\\s*\\b([0-9]|[1-9][0-9]|1[0-9][0-9]|2[0-4][0-9]|25[0-5])\\b\\s*\\))|(rgb\\(\\s*(\\d?\\d%|100%)+\\s*,\\s*(\\d?\\d%|100%)+\\s*,\\s*(\\d?\\d%|100%)+\\s*\\))"));
        a.add(co_2.a("hostname", "^([a-zA-Z0-9]|[a-zA-Z0-9][a-zA-Z0-9\\-]{0,61}[a-zA-Z0-9])(\\.([a-zA-Z0-9]|[a-zA-Z0-9][a-zA-Z0-9\\-]{0,61}[a-zA-Z0-9]))*$"));
        a.add(co_2.a("alpha", "^[a-zA-Z]+$"));
        a.add(co_2.a("alphanumeric", "^[a-zA-Z0-9]+$"));
        a.add(co_2.a("phone", "^\\+(?:[0-9] ?){6,14}[0-9]$"));
        a.add(co_2.a("utc-millisec", "^[0-9]+(\\.?[0-9]+)?$"));
        a.add(co_2.a("style", "\\s*(.+?):\\s*([^;]+);?"));
    }

    public static class a {
        private Map<String, cw_2> a = new HashMap<String, cw_2>();
        private Map<String, ci_2> b = new HashMap<String, ci_2>();
        private String c;
        private String d = "id";

        public a(String string) {
            this.c = string;
        }

        private static Map<String, cw_2> a(Map<String, cw_2> object, Map<String, ci_2> map2) {
            HashMap<String, Object> hashMap = new HashMap<String, Object>();
            for (Map.Entry entry : object.entrySet()) {
                String string = (String)entry.getKey();
                cw_2 object2 = (cw_2)entry.getValue();
                if (dj_2.FORMAT.a().equals(string)) {
                    if (object2 instanceof cj_2) continue;
                    throw new IllegalArgumentException("Overriding the keyword 'format' is not supported");
                }
                hashMap.put(object2.a(), object2);
            }
            object = new cj_2(dj_2.FORMAT, map2);
            hashMap.put(((cj_2)object).a(), object);
            return Collections.unmodifiableMap(hashMap);
        }

        public a a(cw_2 cw_22) {
            this.a.put(cw_22.a(), cw_22);
            return this;
        }

        public a a(Collection<? extends cw_2> object) {
            object = object.iterator();
            while (object.hasNext()) {
                cw_2 cw_22 = (cw_2)object.next();
                this.a.put(cw_22.a(), cw_22);
            }
            return this;
        }

        public a a(ci_2 ci_22) {
            this.b.put(ci_22.a(), ci_22);
            return this;
        }

        public a b(Collection<? extends ci_2> object) {
            object = object.iterator();
            while (object.hasNext()) {
                ci_2 ci_22 = (ci_2)object.next();
                this.a(ci_22);
            }
            return this;
        }

        public a a(String string) {
            this.d = string;
            return this;
        }

        public co_2 a() {
            Map<String, cw_2> map2 = org.valkyrienskies.core.impl.shadow.co$a.a(this.a, this.b);
            return new co(this.c, this.d, map2, null);
        }
    }
}

