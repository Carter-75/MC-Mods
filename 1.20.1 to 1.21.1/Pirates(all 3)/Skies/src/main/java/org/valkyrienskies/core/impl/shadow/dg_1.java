/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.valkyrienskies.core.impl.shadow.dM
 */
package org.valkyrienskies.core.impl.shadow;

import com.fasterxml.jackson.databind.JsonNode;
import java.util.List;
import java.util.Set;
import org.valkyrienskies.core.impl.shadow.cp_2;
import org.valkyrienskies.core.impl.shadow.cr_2;
import org.valkyrienskies.core.impl.shadow.dM;
import org.valkyrienskies.core.impl.shadow.df_2;
import org.valkyrienskies.core.impl.shadow.dg_2;
import org.valkyrienskies.core.impl.shadow.dk_1;
import org.valkyrienskies.core.impl.shadow.dm_1;
import org.valkyrienskies.core.impl.shadow.dn_1;
import org.valkyrienskies.core.impl.shadow.do_1;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.dG
 */
public abstract class dg_1
implements do_1 {
    protected dm_1 a(String string, JsonNode jsonNode, JsonNode jsonNode2, String string2, String string3, JsonNode jsonNode3, cp_2 cp_22, df_2 df_22, cr_2 cr_22) {
        return dM.i().c(string2).b(string).b(jsonNode).a(cp_22).c(jsonNode2).a(jsonNode3).a(string3).a(cr_22).a(df_22).a();
    }

    protected boolean a(List<dk_1> object, dm_1 dm_12) {
        boolean bl = true;
        if (object != null) {
            object = object.iterator();
            while (object.hasNext()) {
                Object object2 = (dk_1)object.next();
                if (!dn_1.SKIP.equals(object2 = object2.a(dm_12)) && !dn_1.ABORT.equals(object2)) continue;
                bl = false;
                if (!dn_1.ABORT.equals(object2)) continue;
            }
        }
        return bl;
    }

    protected void a(List<dk_1> object, dm_1 dm_12, Set<dg_2> set) {
        if (object != null) {
            object = object.iterator();
            while (object.hasNext()) {
                dk_1 dk_12 = (dk_1)object.next();
                dk_12.a(dm_12, set);
            }
        }
    }
}

