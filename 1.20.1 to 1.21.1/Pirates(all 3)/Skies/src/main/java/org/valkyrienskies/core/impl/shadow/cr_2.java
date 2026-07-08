/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.slf4j.Logger
 *  org.slf4j.LoggerFactory
 *  org.valkyrienskies.core.impl.shadow.cr
 */
package org.valkyrienskies.core.impl.shadow;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.valkyrienskies.core.impl.shadow.co_2;
import org.valkyrienskies.core.impl.shadow.cp_2;
import org.valkyrienskies.core.impl.shadow.cq_2;
import org.valkyrienskies.core.impl.shadow.cr;
import org.valkyrienskies.core.impl.shadow.ct_1;
import org.valkyrienskies.core.impl.shadow.ct_2;
import org.valkyrienskies.core.impl.shadow.cu_1;
import org.valkyrienskies.core.impl.shadow.da_1;
import org.valkyrienskies.core.impl.shadow.db_1;
import org.valkyrienskies.core.impl.shadow.dc_1;
import org.valkyrienskies.core.impl.shadow.dd_1;
import org.valkyrienskies.core.impl.shadow.df_2;
import org.valkyrienskies.core.impl.shadow.dk_2;
import org.valkyrienskies.core.impl.shadow.dl_2;
import org.valkyrienskies.core.impl.shadow.dm_2;
import org.valkyrienskies.core.impl.shadow.dn_2;
import org.valkyrienskies.core.impl.shadow.do_2;
import org.valkyrienskies.core.impl.shadow.du_2;
import org.valkyrienskies.core.impl.shadow.dv_2;
import org.valkyrienskies.core.impl.shadow.dx_2;
import org.valkyrienskies.core.impl.shadow.dy_2;
import org.valkyrienskies.core.impl.shadow.dz_2;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.cr
 */
public class cr_2 {
    private static final Logger a = LoggerFactory.getLogger(cr_2.class);
    private final ObjectMapper b;
    private final String c;
    private final dz_2 d;
    private final da_1 e;
    private final dd_1 f;
    private final Map<String, co_2> g;
    private final Map<String, String> h;
    private final ConcurrentMap<URI, cp_2> i = new ConcurrentHashMap<URI, cp_2>();
    private final boolean j;
    private final boolean k;

    private cr_2(ObjectMapper objectMapper, String string, dz_2 dz_22, da_1 da_12, dd_1 dd_12, Map<String, co_2> map2, Map<String, String> map3, boolean bl, boolean bl2) {
        if (objectMapper == null) {
            throw new IllegalArgumentException("ObjectMapper must not be null");
        }
        if (string == null || string.trim().isEmpty()) {
            throw new IllegalArgumentException("defaultMetaSchemaURI must not be null or empty");
        }
        if (dz_22 == null) {
            throw new IllegalArgumentException("URIFactory must not be null");
        }
        if (da_12 == null) {
            throw new IllegalArgumentException("URIFetcher must not be null");
        }
        if (map2 == null || map2.isEmpty()) {
            throw new IllegalArgumentException("Json Meta Schemas must not be null or empty");
        }
        if (map2.get(string) == null) {
            throw new IllegalArgumentException("Meta Schema for default Meta Schema URI must be provided");
        }
        if (map3 == null) {
            throw new IllegalArgumentException("URL Mappings must not be null");
        }
        this.b = objectMapper;
        this.c = string;
        this.d = dz_22;
        this.e = da_12;
        this.f = dd_12;
        this.g = map2;
        this.h = map3;
        this.j = bl;
        this.k = bl2;
    }

    static a a() {
        return new a();
    }

    @Deprecated
    public static cr_2 b() {
        return cr_2.a(cu_1.a.V4);
    }

    public static cr_2 a(cu_1.a object) {
        object = cr_2.b((cu_1.a)((Object)object));
        object = ((ct_2)object).a();
        return cr_2.a().a(((co_2)object).e()).a((co_2)object).a();
    }

    public static ct_2 b(cu_1.a a2) {
        ct_2 ct_22 = null;
        switch (a2) {
            case V202012: {
                ct_22 = new dl_2();
                break;
            }
            case V201909: {
                ct_22 = new dk_2();
                break;
            }
            case V7: {
                ct_22 = new do_2();
                break;
            }
            case V6: {
                ct_22 = new dn_2();
                break;
            }
            case V4: {
                ct_22 = new dm_2();
            }
        }
        return ct_22;
    }

    public static a a(cr_2 cr_22) {
        a a2 = cr_2.a().a(cr_22.g.values()).a(cr_22.c).a(cr_22.b).a(cr_22.h);
        for (Map.Entry<String, dx_2> entry : cr_22.d.a().entrySet()) {
            a2 = a2.a(entry.getValue(), entry.getKey());
        }
        for (Map.Entry<String, Object> entry : cr_22.e.a().entrySet()) {
            a2 = a2.a((dy_2)entry.getValue(), entry.getKey());
        }
        return a2;
    }

    protected cp_2 a(URI uRI, JsonNode jsonNode, ct_1 ct_12) {
        df_2 df_22 = this.a(jsonNode);
        df_22.a(ct_12);
        return new cp_2(df_22, uRI, jsonNode);
    }

    protected df_2 a(JsonNode object) {
        object = this.c((JsonNode)object);
        return new df_2(this.d, this.f, (co_2)object, this, null);
    }

    private co_2 c(JsonNode object) {
        if ((object = ((JsonNode)object).get("$schema")) != null && !((JsonNode)object).isNull() && !((JsonNode)object).isTextual()) {
            throw new cq_2("Unknown MetaSchema: " + ((JsonNode)object).toString());
        }
        co_2 co_22 = this.g.get(object = object == null || ((JsonNode)object).isNull() ? this.c : cr_2.a(((JsonNode)object).textValue(), this.j, this.k));
        if (co_22 == null) {
            throw new cq_2("Unknown MetaSchema: " + (String)object);
        }
        return co_22;
    }

    public dx_2 c() {
        return this.d;
    }

    public cp_2 a(String object, ct_1 ct_12) {
        try {
            object = this.b.readTree((String)object);
            return this.a(null, (JsonNode)object, ct_12);
        }
        catch (IOException iOException) {
            a.error("Failed to load json schema!", (Throwable)iOException);
            throw new cq_2(iOException);
        }
    }

    public cp_2 a(String string) {
        return this.a(string, null);
    }

    public cp_2 a(InputStream object, ct_1 ct_12) {
        try {
            object = this.b.readTree((InputStream)object);
            return this.a(null, (JsonNode)object, ct_12);
        }
        catch (IOException iOException) {
            a.error("Failed to load json schema!", (Throwable)iOException);
            throw new cq_2(iOException);
        }
    }

    public cp_2 a(InputStream inputStream) {
        return this.a(inputStream, null);
    }

    public cp_2 a(URI object, ct_1 ct_12) {
        block11: {
            InputStream inputStream = null;
            Serializable serializable = ct_12 != null ? ct_12.d() : new HashMap<String, String>();
            serializable.putAll(this.h);
            try {
                serializable = this.d.a(serializable.get(((URI)object).toString()) != null ? (String)serializable.get(((URI)object).toString()) : ((URI)object).toString());
            }
            catch (IllegalArgumentException illegalArgumentException) {
                a.error("Failed to create URI.", (Throwable)illegalArgumentException);
                throw new cq_2(illegalArgumentException);
            }
            if (this.i.containsKey(serializable)) {
                cp_2 cp_22 = (cp_2)this.i.get(serializable);
                cp_22.h().a(ct_12);
                return cp_22;
            }
            try {
                inputStream = this.e.a((URI)serializable);
                JsonNode jsonNode = this.b.readTree(inputStream);
                co_2 co_22 = this.c(jsonNode);
                if (this.a(co_22, jsonNode, (URI)object)) {
                    object = new cp_2(new df_2(this.d, this.f, co_22, this, ct_12), (URI)serializable, jsonNode, true);
                } else {
                    object = this.a(jsonNode);
                    ((df_2)object).a(ct_12);
                    object = new cp_2((df_2)object, (URI)serializable, jsonNode);
                }
                this.i.put((URI)serializable, (cp_2)object);
                if (inputStream == null) break block11;
            }
            catch (Throwable throwable) {
                try {
                    if (inputStream != null) {
                        inputStream.close();
                    }
                    throw throwable;
                }
                catch (IOException iOException) {
                    a.error("Failed to load json schema!", (Throwable)iOException);
                    throw new cq_2(iOException);
                }
            }
            inputStream.close();
        }
        return object;
    }

    public cp_2 a(URI uRI) {
        return this.a(uRI, new ct_1());
    }

    public cp_2 b(URI uRI, JsonNode jsonNode, ct_1 ct_12) {
        return this.a(uRI, jsonNode, ct_12);
    }

    public cp_2 a(JsonNode jsonNode, ct_1 ct_12) {
        return this.a(null, jsonNode, ct_12);
    }

    public cp_2 a(URI uRI, JsonNode jsonNode) {
        return this.a(uRI, jsonNode, null);
    }

    public cp_2 b(JsonNode jsonNode) {
        return this.a((URI)null, jsonNode, (ct_1)null);
    }

    private boolean a(co_2 object, JsonNode jsonNode, URI uRI) {
        if ((object = ((co_2)object).a(jsonNode)) == null || ((String)object).isEmpty()) {
            return false;
        }
        boolean bl = ((String)object).equals(uRI.toString());
        if (a.isDebugEnabled()) {
            a.debug("Matching " + (String)object + " to " + uRI.toString() + ": " + bl);
        }
        return bl;
    }

    protected static String a(String string, boolean bl, boolean bl2) {
        try {
            URI uRI = new URI(string);
            Object object = bl ? "https" : uRI.getScheme();
            object = new URI((String)object, uRI.getUserInfo(), uRI.getHost(), uRI.getPort(), uRI.getPath(), null, null);
            if (!bl2 && string.endsWith("#")) {
                return object + "#";
            }
            return ((URI)object).toString();
        }
        catch (URISyntaxException uRISyntaxException) {
            throw new cq_2("Wrong MetaSchema URI: " + string);
        }
    }

    public static class a {
        private ObjectMapper a = new ObjectMapper();
        private String b;
        private final Map<String, dx_2> c = new HashMap<String, dx_2>();
        private final Map<String, dy_2> d = new HashMap<String, dy_2>();
        private dd_1 e;
        private final Map<String, co_2> f = new HashMap<String, co_2>();
        private final Map<String, String> g = new HashMap<String, String>();
        private boolean h = true;
        private boolean i = true;

        public a() {
            db_1 object22 = new db_1();
            for (String string : db_1.a) {
                this.c.put(string, object22);
            }
            Iterator<String> iterator2 = new dc_1();
            for (String string : dc_1.a) {
                this.d.put(string, (dy_2)((Object)iterator2));
            }
            du_2 du_22 = new du_2();
            dv_2 dv_22 = new dv_2();
            for (String string : du_2.b) {
                this.c.put(string, du_22);
                this.d.put(string, dv_22);
            }
        }

        public a a(ObjectMapper objectMapper) {
            this.a = objectMapper;
            return this;
        }

        public a a(String string) {
            this.b = string;
            return this;
        }

        public a a(dx_2 dx_22, String ... stringArray) {
            return this.a(dx_22, Arrays.asList(stringArray));
        }

        public a a(dx_2 dx_22, Iterable<String> object) {
            object = object.iterator();
            while (object.hasNext()) {
                String string = (String)object.next();
                this.c.put(string, dx_22);
            }
            return this;
        }

        public a a(dy_2 dy_22, String ... stringArray) {
            return this.a(dy_22, Arrays.asList(stringArray));
        }

        public a a(dy_2 dy_22, Iterable<String> object) {
            object = object.iterator();
            while (object.hasNext()) {
                String string = (String)object.next();
                this.d.put(string, dy_22);
            }
            return this;
        }

        public a a(co_2 co_22) {
            this.f.put(co_22.e(), co_22);
            return this;
        }

        public a a(Collection<? extends co_2> object) {
            object = object.iterator();
            while (object.hasNext()) {
                co_2 co_22 = (co_2)object.next();
                this.f.put(co_22.e(), co_22);
            }
            return this;
        }

        public a a(Map<String, String> map2) {
            this.g.putAll(map2);
            return this;
        }

        public a a(dd_1 dd_12) {
            this.e = dd_12;
            return this;
        }

        public a a(boolean bl) {
            this.h = bl;
            return this;
        }

        public a b(boolean bl) {
            this.i = bl;
            return this;
        }

        public cr_2 a() {
            return new cr(this.a == null ? new ObjectMapper() : this.a, this.b, new dz_2(this.c), new da_1(this.d), this.e, this.f, this.g, this.h, this.i, null);
        }
    }
}

