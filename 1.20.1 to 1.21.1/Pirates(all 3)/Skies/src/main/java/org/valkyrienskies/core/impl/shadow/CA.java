/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.collections.CollectionsKt
 *  kotlin.jvm.internal.Intrinsics
 */
package org.valkyrienskies.core.impl.shadow;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.function.Supplier;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.valkyrienskies.core.api.attachment.AttachmentHolder;
import org.valkyrienskies.core.api.attachment.AttachmentSerializer;
import org.valkyrienskies.core.api.attachment.TransientAttachmentSerializer;
import org.valkyrienskies.core.impl.shadow.CD;
import org.valkyrienskies.core.impl.shadow.CE;
import org.valkyrienskies.core.impl.shadow.CH;

@Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u001c\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010#\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u000bB\u0019\b\u0007\u0012\u0006\u0010\b\u001a\u00020$\u0012\u0006\u0010\u000e\u001a\u00020(\u00a2\u0006\u0004\b)\u0010*J\u0015\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016\u00a2\u0006\u0004\b\u0004\u0010\u0005J)\u0010\t\u001a\u0004\u0018\u00018\u0000\"\b\b\u0000\u0010\u0006*\u00020\u00032\f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007H\u0016\u00a2\u0006\u0004\b\t\u0010\nJ'\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\"\u0004\b\u0000\u0010\u00062\f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007\u00a2\u0006\u0004\b\u000b\u0010\fJ5\u0010\u000f\u001a\u00028\u0000\"\b\b\u0000\u0010\u0006*\u00020\u00032\f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\u00072\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00000\rH\u0016\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u0015\u0010\u000b\u001a\u00020\u00122\u0006\u0010\b\u001a\u00020\u0011\u00a2\u0006\u0004\b\u000b\u0010\u0013J)\u0010\u0014\u001a\u0004\u0018\u00018\u0000\"\b\b\u0000\u0010\u0006*\u00020\u00032\f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007H\u0016\u00a2\u0006\u0004\b\u0014\u0010\nJ\r\u0010\u000b\u001a\u00020\u0011\u00a2\u0006\u0004\b\u000b\u0010\u0015J#\u0010\u0016\u001a\u0004\u0018\u00018\u0000\"\b\b\u0000\u0010\u0006*\u00020\u00032\u0006\u0010\b\u001a\u00028\u0000H\u0016\u00a2\u0006\u0004\b\u0016\u0010\u0017R$\u0010\u000b\u001a\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0007\u0012\u0004\u0012\u00020\u00190\u00188\u0002X\u0083\u0004\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR \u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u001c0\u00188\u0002X\u0083\u0004\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001bR\u0016\u0010\u001f\u001a\u00020\u00118\u0002@\u0002X\u0083\u000e\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 R\u0014\u0010#\u001a\u00020!8\u0002X\u0083\u0004\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\"R\u0014\u0010\u001a\u001a\u00020$8\u0002X\u0083\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010%R\u001a\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001c0&8\u0002X\u0083\u0004\u00a2\u0006\u0006\n\u0004\b#\u0010'"}, d2={"Lorg/valkyrienskies/core/impl/shadow/CA;", "Lorg/valkyrienskies/core/api/attachment/AttachmentHolder;", "", "", "getAllAttachments", "()Ljava/lang/Iterable;", "T", "Ljava/lang/Class;", "p0", "getAttachment", "(Ljava/lang/Class;)Ljava/lang/Object;", "a", "(Ljava/lang/Class;)Ljava/lang/Iterable;", "Ljava/util/function/Supplier;", "p1", "getOrPutAttachment", "(Ljava/lang/Class;Ljava/util/function/Supplier;)Ljava/lang/Object;", "Lcom/fasterxml/jackson/databind/node/ObjectNode;", "", "(Lcom/fasterxml/jackson/databind/node/ObjectNode;)V", "removeAttachment", "()Lcom/fasterxml/jackson/databind/node/ObjectNode;", "setAttachment", "(Ljava/lang/Object;)Ljava/lang/Object;", "", "Lorg/valkyrienskies/core/impl/shadow/CA$a;", "e", "Ljava/util/Map;", "", "f", "b", "c", "Lcom/fasterxml/jackson/databind/node/ObjectNode;", "Ljava/util/concurrent/locks/ReentrantLock;", "Ljava/util/concurrent/locks/ReentrantLock;", "d", "Lorg/valkyrienskies/core/impl/shadow/CH;", "Lorg/valkyrienskies/core/impl/shadow/CH;", "", "Ljava/util/Set;", "Lcom/fasterxml/jackson/databind/ObjectMapper;", "<init>", "(Lorg/valkyrienskies/core/impl/shadow/CH;Lcom/fasterxml/jackson/databind/ObjectMapper;)V"})
public final class CA
implements AttachmentHolder {
    final CH a;
    final ReentrantLock b;
    ObjectNode c;
    final Set<String> d;
    final Map<Class<?>, a> e;
    final Map<String, String> f;

    @Inject
    public CA(CH cH, ObjectMapper objectMapper) {
        Intrinsics.checkNotNullParameter((Object)cH, (String)"");
        Intrinsics.checkNotNullParameter((Object)objectMapper, (String)"");
        this.a = cH;
        this.b = new ReentrantLock();
        ObjectNode objectNode = objectMapper.createObjectNode();
        Intrinsics.checkNotNullExpressionValue((Object)objectNode, (String)"");
        this.c = objectNode;
        this.d = new LinkedHashSet();
        this.e = new LinkedHashMap();
        this.f = new LinkedHashMap();
    }

    @Override
    public final Iterable<Object> getAllAttachments() {
        Iterable iterable;
        Lock lock = this.b;
        lock.lock();
        try {
            iterable = this.e.values();
            Object object = iterable;
            iterable = new ArrayList(CollectionsKt.collectionSizeOrDefault((Iterable)iterable, (int)10));
            object = object.iterator();
            while (object.hasNext()) {
                Object object2 = object.next();
                object2 = (a)object2;
                Iterable iterable2 = iterable;
                iterable2.add(((a)object2).a);
            }
            iterable = (List)iterable;
        }
        finally {
            lock.unlock();
        }
        return iterable;
    }

    private <T> Iterable<T> a(Class<T> object) {
        Intrinsics.checkNotNullParameter(object, (String)"");
        Lock lock = this.b;
        lock.lock();
        try {
            Object object2 = this.e.values();
            Collection collection = new ArrayList();
            object2 = object2.iterator();
            while (object2.hasNext()) {
                Object e2 = object2.next();
                Object object3 = e2;
                object3 = e2;
                object3 = e2;
                Object object4 = object;
                Object e3 = object3;
                object3 = object4;
                object3 = object4;
                Object v2 = ((Class)object4).isInstance(e3) ? ((Class)object3).cast(e3) : null;
                if (v2 == null) continue;
                object3 = v2;
                collection.add(object3);
            }
            object = (List)collection;
        }
        finally {
            lock.unlock();
        }
        return (Iterable)object;
    }

    @Override
    public final <T> T getAttachment(Class<T> clazz) {
        Intrinsics.checkNotNullParameter(clazz, (String)"");
        Lock lock = this.b;
        lock.lock();
        try {
            Object object;
            Object object2;
            a a2 = this.e.get(object2);
            if (a2 != null) {
                object2 = a2;
                object = a2.a;
            } else {
                object = null;
            }
            object2 = object;
            return (T)object2;
        }
        finally {
            lock.unlock();
        }
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public final <T> T getOrPutAttachment(Class<T> clazz, Supplier<T> supplier) {
        Intrinsics.checkNotNullParameter(clazz, (String)"");
        Intrinsics.checkNotNullParameter(supplier, (String)"");
        Lock lock = this.b;
        lock.lock();
        try {
            void var2_3;
            T t;
            t = this.getAttachment((Class<T>)t);
            if (t != null) {
                return t;
            }
            Object t2 = var2_3.get();
            Intrinsics.checkNotNullExpressionValue(t2, (String)"");
            t = t2;
            this.setAttachment(t);
            return t;
        }
        finally {
            lock.unlock();
        }
    }

    @Override
    public final <T> T setAttachment(T value) {
        Intrinsics.checkNotNullParameter(value, (String)"");
        Lock lock = this.b;
        lock.lock();
        try {
            Object object;
            Object object2;
            Class<?> clazz = value.getClass();
            CD cD = this.a.a(clazz);
            if (cD == null) {
                value = "setAttachment: attempted to set an attachment with unregistered " + clazz + ". Please register the attachment class.";
                throw new IllegalArgumentException(value.toString());
            }
            CD cD2 = cD;
            Object object3 = cD;
            if (!(cD.d == null)) {
                value = "setAttachment: failed to set attachment for " + clazz + " because it has a registered updater.";
                throw new IllegalArgumentException(value.toString());
            }
            object3 = cD2;
            String string = this.f.get(((CD)object3).b);
            if (!(string == null)) {
                object3 = cD2;
                value = "setAttachment: attempted to set attachment for " + clazz + " (key = " + ((CD)object3).b + "). Cannot set this attachment because we tried to deserialize it earlier, and the deserialization failed. " + string;
                throw new IllegalArgumentException(value.toString());
            }
            object3 = cD2;
            this.d.remove(((CD)object3).b);
            a a2 = this.e.put(clazz, new a(object2, cD2));
            if (a2 != null) {
                object3 = a2;
                object = a2.a;
            } else {
                object = null;
            }
            object2 = object;
            return (T)object2;
        }
        finally {
            lock.unlock();
        }
    }

    @Override
    public final <T> T removeAttachment(Class<T> clazz) {
        Intrinsics.checkNotNullParameter(clazz, (String)"");
        Lock lock = this.b;
        lock.lock();
        try {
            Object object;
            Object object2;
            CD cD = this.a.a((Class<?>)clazz);
            if (cD == null) {
                clazz = "removeAttachment: attempted to remove an attachment with unregistered class " + clazz + ". Please register the attachment class.";
                throw new IllegalArgumentException(clazz.toString());
            }
            Object object3 = cD;
            this.d.add(((CD)object3).b);
            a a2 = this.e.remove(object2);
            if (a2 != null) {
                object3 = a2;
                object = a2.a;
            } else {
                object = null;
            }
            object2 = object;
            return (T)object2;
        }
        finally {
            lock.unlock();
        }
    }

    public final void a(ObjectNode object) {
        Intrinsics.checkNotNullParameter((Object)object, (String)"");
        Lock lock = this.b;
        lock.lock();
        try {
            this.d.clear();
            this.c = object;
            this.e.clear();
            Iterator<Map.Entry<String, JsonNode>> iterator2 = ((JsonNode)object).fields();
            Intrinsics.checkNotNullExpressionValue(iterator2, (String)"");
            object = iterator2;
            while (object.hasNext()) {
                CE cE;
                Object object2 = (Map.Entry)object.next();
                Intrinsics.checkNotNullExpressionValue((Object)object2, (String)"");
                String string = (String)object2.getKey();
                object2 = (JsonNode)object2.getValue();
                Intrinsics.checkNotNullExpressionValue((Object)string, (String)"");
                Intrinsics.checkNotNullExpressionValue((Object)object2, (String)"");
                object2 = this.a.a(string, (JsonNode)object2);
                if (object2 instanceof CE.d) {
                    cE = (CE.d)object2;
                    this.setAttachment(cE.a);
                    continue;
                }
                if (object2 instanceof CE.f) {
                    cE = (CE.f)object2;
                    this.setAttachment(((CE.f)cE).a);
                    this.d.add(string);
                    continue;
                }
                if (object2 instanceof CE.c) continue;
                if (object2 instanceof CE.a) {
                    cE = (CE.a)object2;
                    this.f.put(string, ((CE.a)cE).a);
                    continue;
                }
                if (object2 instanceof CE.b) {
                    CE.b b2 = (CE.b)object2;
                    cE = b2;
                    cE = (CE.b)object2;
                    this.f.put(b2.b, ((CE.b)cE).a);
                    continue;
                }
                if (!(object2 instanceof CE.e)) continue;
                this.d.add(string);
            }
            return;
        }
        finally {
            lock.unlock();
        }
    }

    public final ObjectNode a() {
        Lock lock = this.b;
        lock.lock();
        try {
            ObjectNode objectNode = this.c.deepCopy();
            objectNode.remove((Collection<String>)this.d);
            Iterator<a> iterator2 = this.e.values().iterator();
            while (iterator2.hasNext()) {
                Object object;
                Object object2 = object = iterator2.next();
                object2 = ((a)object).b;
                String string = ((CD)object2).b;
                try {
                    object2 = object;
                    object = ((a)object2).a;
                    object2 = this.a;
                    Intrinsics.checkNotNullParameter((Object)object, (String)"");
                    Object object3 = ((CH)object2).b(object.getClass());
                    Object object4 = object2;
                    object2 = object3;
                    object3 = ((CD)object2).c;
                    object2 = object;
                    object = object4;
                    JsonNode jsonNode = Intrinsics.areEqual((Object)object3, (Object)TransientAttachmentSerializer.INSTANCE) ? null : ((CH)object).a((AttachmentSerializer)object3).a(object2);
                    if (jsonNode == null) continue;
                    object = jsonNode;
                    objectNode.replace(string, (JsonNode)object);
                }
                catch (Exception exception) {}
            }
            Intrinsics.checkNotNullExpressionValue((Object)objectNode, (String)"");
            this.c = objectNode;
            this.d.clear();
            return objectNode;
        }
        finally {
            lock.unlock();
        }
    }

    static final class a {
        final Object a;
        final CD b;

        public a(Object object, CD cD) {
            Intrinsics.checkNotNullParameter((Object)object, (String)"");
            Intrinsics.checkNotNullParameter((Object)cD, (String)"");
            this.a = object;
            this.b = cD;
        }

        public final Object a() {
            return this.a;
        }

        public final CD b() {
            return this.b;
        }
    }
}

