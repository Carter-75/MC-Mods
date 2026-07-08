/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.fasterxml.classmate.ResolvedType
 */
package org.valkyrienskies.core.impl.shadow;

import com.fasterxml.classmate.ResolvedType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import org.valkyrienskies.core.impl.shadow.aa_1;
import org.valkyrienskies.core.impl.shadow.ab_1;
import org.valkyrienskies.core.impl.shadow.ac_1;
import org.valkyrienskies.core.impl.shadow.ai_1;
import org.valkyrienskies.core.impl.shadow.ap_1;
import org.valkyrienskies.core.impl.shadow.aq_1;
import org.valkyrienskies.core.impl.shadow.at_1;
import org.valkyrienskies.core.impl.shadow.at_2;
import org.valkyrienskies.core.impl.shadow.av_1;
import org.valkyrienskies.core.impl.shadow.av_2;
import org.valkyrienskies.core.impl.shadow.ax_2;
import org.valkyrienskies.core.impl.shadow.ay_2;
import org.valkyrienskies.core.impl.shadow.bb_2;
import org.valkyrienskies.core.impl.shadow.bq_2;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.aK
 */
public interface ak_1 {
    public aq_1 a();

    public String a(ap_1 var1);

    public boolean b();

    public boolean c();

    public boolean d();

    public boolean e();

    public boolean f();

    public boolean g();

    public boolean h();

    public boolean i();

    public boolean j();

    public boolean k();

    public boolean l();

    public boolean m();

    public ObjectMapper n();

    public ObjectNode o();

    public ArrayNode p();

    public int a(ab_1<?, ?> var1, ab_1<?, ?> var2);

    public bq_2 q();

    /*
     * Ignored method signature, as it can't be verified against descriptor
     */
    public at_2 a(ab_1 var1, bb_2 var2, ax_2 var3);

    public at_2 a(ResolvedType var1, ai_1 var2, av_2 var3);

    /*
     * Ignored method signature, as it can't be verified against descriptor
     */
    public List a(ResolvedType var1, bb_2 var2);

    public List<at_1> r();

    public List<aa_1<ay_2>> s();

    public List<aa_1<ac_1>> t();

    public boolean a(ay_2 var1);

    public boolean a(ac_1 var1);

    public boolean b(ay_2 var1);

    public boolean b(ac_1 var1);

    public boolean c(ay_2 var1);

    public boolean c(ac_1 var1);

    public boolean d(ay_2 var1);

    public boolean d(ac_1 var1);

    public boolean e(ay_2 var1);

    public boolean e(ac_1 var1);

    @Deprecated
    default public ResolvedType f(ay_2 object) {
        if ((object = this.g((ay_2)object)) == null || object.isEmpty()) {
            return null;
        }
        return (ResolvedType)object.get(0);
    }

    @Deprecated
    default public ResolvedType f(ac_1 object) {
        if ((object = this.g((ac_1)object)) == null || object.isEmpty()) {
            return null;
        }
        return (ResolvedType)object.get(0);
    }

    public List<ResolvedType> g(ay_2 var1);

    public List<ResolvedType> g(ac_1 var1);

    public String h(ay_2 var1);

    public String h(ac_1 var1);

    public String a(av_1 var1);

    public String b(av_1 var1);

    public String i(ay_2 var1);

    public String i(ac_1 var1);

    public String c(av_1 var1);

    public String j(ay_2 var1);

    public String j(ac_1 var1);

    public String d(av_1 var1);

    public Object k(ay_2 var1);

    public Object k(ac_1 var1);

    public Object e(av_1 var1);

    public Collection<?> l(ay_2 var1);

    public Collection<?> l(ac_1 var1);

    public Collection<?> f(av_1 var1);

    public Type m(ay_2 var1);

    public Type m(ac_1 var1);

    public Type g(av_1 var1);

    public Map<String, Type> n(ay_2 var1);

    public Map<String, Type> n(ac_1 var1);

    public Map<String, Type> h(av_1 var1);

    public Integer o(ay_2 var1);

    public Integer o(ac_1 var1);

    public Integer i(av_1 var1);

    public Integer p(ay_2 var1);

    public Integer p(ac_1 var1);

    public Integer j(av_1 var1);

    public String q(ay_2 var1);

    public String q(ac_1 var1);

    public String k(av_1 var1);

    public String r(ay_2 var1);

    public String r(ac_1 var1);

    public String l(av_1 var1);

    public BigDecimal s(ay_2 var1);

    public BigDecimal s(ac_1 var1);

    public BigDecimal m(av_1 var1);

    public BigDecimal t(ay_2 var1);

    public BigDecimal t(ac_1 var1);

    public BigDecimal n(av_1 var1);

    public BigDecimal u(ay_2 var1);

    public BigDecimal u(ac_1 var1);

    public BigDecimal o(av_1 var1);

    public BigDecimal v(ay_2 var1);

    public BigDecimal v(ac_1 var1);

    public BigDecimal p(av_1 var1);

    public BigDecimal w(ay_2 var1);

    public BigDecimal w(ac_1 var1);

    public BigDecimal q(av_1 var1);

    public Integer x(ay_2 var1);

    public Integer x(ac_1 var1);

    public Integer r(av_1 var1);

    public Integer y(ay_2 var1);

    public Integer y(ac_1 var1);

    public Integer s(av_1 var1);

    public Boolean z(ay_2 var1);

    public Boolean z(ac_1 var1);

    public Boolean t(av_1 var1);
}

