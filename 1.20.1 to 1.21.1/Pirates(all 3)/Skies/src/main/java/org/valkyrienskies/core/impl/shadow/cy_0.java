/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 */
package org.valkyrienskies.core.impl.shadow;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import javax.inject.Inject;
import javax.inject.Provider;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.valkyrienskies.core.impl.shadow.CA;
import org.valkyrienskies.core.impl.shadow.CE;
import org.valkyrienskies.core.impl.shadow.CH;
import org.valkyrienskies.core.impl.shadow.dy_1;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.Cy
 */
@dy_1
@Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0017\b\u0007\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\b\u00a2\u0006\u0004\b\n\u0010\u000bJ\r\u0010\u0003\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0003\u0010\u0004J\u0015\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005\u00a2\u0006\u0004\b\u0003\u0010\u0007R\u001a\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\t"}, d2={"Lorg/valkyrienskies/core/impl/shadow/Cy;", "", "Lorg/valkyrienskies/core/impl/shadow/CA;", "a", "()Lorg/valkyrienskies/core/impl/shadow/CA;", "Lcom/fasterxml/jackson/databind/JsonNode;", "p0", "(Lcom/fasterxml/jackson/databind/JsonNode;)Lorg/valkyrienskies/core/impl/shadow/CA;", "Ljavax/inject/Provider;", "Ljavax/inject/Provider;", "<init>", "(Ljavax/inject/Provider;)V"})
public final class cy_0 {
    public final Provider<CA> a;

    @Inject
    public cy_0(Provider<CA> provider) {
        Intrinsics.checkNotNullParameter(provider, (String)"");
        this.a = provider;
    }

    public final CA a() {
        CA cA = this.a.get();
        Intrinsics.checkNotNullExpressionValue((Object)cA, (String)"");
        return cA;
    }

    public final CA a(JsonNode object) {
        Intrinsics.checkNotNullParameter((Object)object, (String)"");
        if (!(object instanceof ObjectNode)) {
            object = "AttachmentHolderFactory: Tried to create AttachmentHolder from non-object JsonNode " + (JsonNode)object;
            throw new IllegalArgumentException(object.toString());
        }
        CA cA = this.a.get();
        Object object2 = (ObjectNode)object;
        object = cA;
        Intrinsics.checkNotNullParameter((Object)object2, (String)"");
        Lock lock = ((CA)object).b;
        lock.lock();
        try {
            ((CA)object).d.clear();
            ((CA)object).c = object2;
            ((CA)object).e.clear();
            Iterator<Map.Entry<String, JsonNode>> iterator2 = ((JsonNode)object2).fields();
            Intrinsics.checkNotNullExpressionValue(iterator2, (String)"");
            object2 = iterator2;
            while (object2.hasNext()) {
                CE cE;
                Object object3 = (Map.Entry)object2.next();
                Intrinsics.checkNotNullExpressionValue((Object)object3, (String)"");
                String string = (String)object3.getKey();
                object3 = (JsonNode)object3.getValue();
                CH cH = ((CA)object).a;
                Intrinsics.checkNotNullExpressionValue((Object)string, (String)"");
                Intrinsics.checkNotNullExpressionValue((Object)object3, (String)"");
                object3 = cH.a(string, (JsonNode)object3);
                if (object3 instanceof CE.d) {
                    cE = (CE.d)object3;
                    ((CA)object).setAttachment(cE.a);
                    continue;
                }
                if (object3 instanceof CE.f) {
                    cE = (CE.f)object3;
                    ((CA)object).setAttachment(((CE.f)cE).a);
                    ((CA)object).d.add(string);
                    continue;
                }
                if (object3 instanceof CE.c) continue;
                if (object3 instanceof CE.a) {
                    cE = (CE.a)object3;
                    ((CA)object).f.put(string, ((CE.a)cE).a);
                    continue;
                }
                if (object3 instanceof CE.b) {
                    CE.b b2 = (CE.b)object3;
                    cE = b2;
                    cE = (CE.b)object3;
                    ((CA)object).f.put(b2.b, ((CE.b)cE).a);
                    continue;
                }
                if (!(object3 instanceof CE.e)) continue;
                ((CA)object).d.add(string);
            }
        }
        finally {
            lock.unlock();
        }
        Intrinsics.checkNotNullExpressionValue((Object)cA, (String)"");
        return cA;
    }
}

