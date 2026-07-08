/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.jvm.JvmName
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.PropertyReference1
 *  kotlin.jvm.internal.PropertyReference1Impl
 *  kotlin.jvm.internal.Reflection
 *  kotlin.reflect.KProperty
 */
package org.valkyrienskies.core.impl.shadow;

import com.fasterxml.jackson.databind.JsonNode;
import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import org.apache.logging.log4j.Logger;
import org.valkyrienskies.core.api.attachment.AttachmentRegistration;
import org.valkyrienskies.core.api.attachment.AttachmentSerializer;
import org.valkyrienskies.core.api.attachment.BinaryAttachmentSerializer;
import org.valkyrienskies.core.api.attachment.JacksonAttachmentSerializer;
import org.valkyrienskies.core.api.attachment.LegacyAttachmentSerializer;
import org.valkyrienskies.core.api.attachment.TransientAttachmentSerializer;
import org.valkyrienskies.core.impl.shadow.CD;
import org.valkyrienskies.core.impl.shadow.CE;
import org.valkyrienskies.core.impl.shadow.CF;
import org.valkyrienskies.core.impl.shadow.CG;
import org.valkyrienskies.core.impl.shadow.CK;
import org.valkyrienskies.core.impl.shadow.CL;
import org.valkyrienskies.core.impl.shadow.CM;
import org.valkyrienskies.core.impl.shadow.CN;
import org.valkyrienskies.core.impl.shadow.FX;
import org.valkyrienskies.core.impl.util.serialization.VSJacksonUtil;

@Singleton
@Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u0000\u0084\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u0003\u001a\u000202\u00a2\u0006\u0004\b7\u00108J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006J-\u0010\u0005\u001a\u0004\u0018\u00010\u00012\n\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u00072\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u0002H\u0002\u00a2\u0006\u0004\b\u0005\u0010\u000bJ\u001f\u0010\f\u001a\u0006\u0012\u0002\b\u00030\u00072\n\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u0007H\u0002\u00a2\u0006\u0004\b\f\u0010\rJ\u001b\u0010\u000f\u001a\u00020\u000e2\n\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u0007H\u0002\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u001b\u0010\u0005\u001a\u0004\u0018\u00010\u00112\n\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u0007\u00a2\u0006\u0004\b\u0005\u0010\u0012J\u0017\u0010\u0013\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0003\u001a\u00020\u000e\u00a2\u0006\u0004\b\u0013\u0010\u0014J\u0019\u0010\u0013\u001a\u00020\u00112\n\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u0007\u00a2\u0006\u0004\b\u0013\u0010\u0012J\u0019\u0010\u0005\u001a\u00020\u00162\b\u0010\u0003\u001a\u0004\u0018\u00010\u0015H\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0017J\u0017\u0010\u0013\u001a\u00020\u00162\u0006\u0010\u0003\u001a\u00020\u0002H\u0002\u00a2\u0006\u0004\b\u0013\u0010\u0018J\u001d\u0010\u0005\u001a\u00020\u00192\u0006\u0010\u0003\u001a\u00020\u000e2\u0006\u0010\t\u001a\u00020\b\u00a2\u0006\u0004\b\u0005\u0010\u001aJ@\u0010\u0005\u001a\u00020\u001e\"\u0004\b\u0000\u0010\u001b2\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u00072\u001d\u0010\t\u001a\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u001d\u0012\u0004\u0012\u00020\u001e0\u001c\u00a2\u0006\u0002\b\u001f\u00a2\u0006\u0004\b\u0005\u0010 J!\u0010\u0005\u001a\u00020\u001e\"\u0004\b\u0000\u0010\u001b2\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000!\u00a2\u0006\u0004\b\u0005\u0010\"J\u0015\u0010\u0005\u001a\u00020\u001e2\u0006\u0010\u0003\u001a\u00020\u000e\u00a2\u0006\u0004\b\u0005\u0010#J\u001b\u0010$\u001a\u00020\u001e2\n\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u0007H\u0002\u00a2\u0006\u0004\b$\u0010%J%\u0010\u0005\u001a\u00020\u001e2\u0006\u0010\u0003\u001a\u00020\u000e2\f\u0010\t\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0007H\u0002\u00a2\u0006\u0004\b\u0005\u0010&J\u0017\u0010\u0005\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0003\u001a\u00020\u0001\u00a2\u0006\u0004\b\u0005\u0010'J!\u0010\u0005\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0003\u001a\u00020\u00012\u0006\u0010\t\u001a\u00020\u0002H\u0002\u00a2\u0006\u0004\b\u0005\u0010(J!\u0010\u0005\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0003\u001a\u00020\u00012\u0006\u0010\t\u001a\u00020\u0011H\u0002\u00a2\u0006\u0004\b\u0005\u0010)R8\u0010\u0005\u001a&\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0007\u0012\u0004\u0012\u00020\u00110*j\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0007\u0012\u0004\u0012\u00020\u0011`+8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b,\u0010-R0\u0010\u0013\u001a\u001e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00110*j\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u0011`+8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b.\u0010-R$\u0010$\u001a\u0012\u0012\u0004\u0012\u00020\u000e0/j\b\u0012\u0004\u0012\u00020\u000e`08\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\f\u00101R\u0014\u0010\u000f\u001a\u0002028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0013\u00103R\u0014\u0010\f\u001a\u0002028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b$\u00103R\u001b\u0010,\u001a\u0002048GX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u000f\u00105\u001a\u0004\b\u0005\u00106"}, d2={"Lorg/valkyrienskies/core/impl/shadow/CH;", "", "Lorg/valkyrienskies/core/api/attachment/AttachmentSerializer;", "p0", "Lorg/valkyrienskies/core/impl/shadow/CK;", "a", "(Lorg/valkyrienskies/core/api/attachment/AttachmentSerializer;)Lorg/valkyrienskies/core/impl/shadow/CK;", "Ljava/lang/Class;", "Lcom/fasterxml/jackson/databind/JsonNode;", "p1", "p2", "(Ljava/lang/Class;Lcom/fasterxml/jackson/databind/JsonNode;Lorg/valkyrienskies/core/api/attachment/AttachmentSerializer;)Ljava/lang/Object;", "e", "(Ljava/lang/Class;)Ljava/lang/Class;", "", "d", "(Ljava/lang/Class;)Ljava/lang/String;", "Lorg/valkyrienskies/core/impl/shadow/CD;", "(Ljava/lang/Class;)Lorg/valkyrienskies/core/impl/shadow/CD;", "b", "(Ljava/lang/String;)Lorg/valkyrienskies/core/impl/shadow/CD;", "Lorg/valkyrienskies/core/impl/shadow/CL;", "", "(Lorg/valkyrienskies/core/impl/shadow/CL;)Z", "(Lorg/valkyrienskies/core/api/attachment/AttachmentSerializer;)Z", "Lorg/valkyrienskies/core/impl/shadow/CE;", "(Ljava/lang/String;Lcom/fasterxml/jackson/databind/JsonNode;)Lorg/valkyrienskies/core/impl/shadow/CE;", "T", "Lkotlin/Function1;", "Lorg/valkyrienskies/core/api/attachment/AttachmentRegistration$Builder;", "", "Lkotlin/ExtensionFunctionType;", "(Ljava/lang/Class;Lkotlin/jvm/functions/Function1;)V", "Lorg/valkyrienskies/core/api/attachment/AttachmentRegistration;", "(Lorg/valkyrienskies/core/api/attachment/AttachmentRegistration;)V", "(Ljava/lang/String;)V", "c", "(Ljava/lang/Class;)V", "(Ljava/lang/String;Ljava/lang/Class;)V", "(Ljava/lang/Object;)Lcom/fasterxml/jackson/databind/JsonNode;", "(Ljava/lang/Object;Lorg/valkyrienskies/core/api/attachment/AttachmentSerializer;)Lcom/fasterxml/jackson/databind/JsonNode;", "(Ljava/lang/Object;Lorg/valkyrienskies/core/impl/shadow/CD;)Ljava/lang/Object;", "Ljava/util/HashMap;", "Lkotlin/collections/d;", "f", "Ljava/util/HashMap;", "g", "Ljava/util/HashSet;", "Lkotlin/collections/f;", "Ljava/util/HashSet;", "Lorg/valkyrienskies/core/impl/shadow/CN;", "Lorg/valkyrienskies/core/impl/shadow/CN;", "Lorg/apache/logging/log4j/Logger;", "Lorg/apache/logging/log4j/Logger;", "()Lorg/apache/logging/log4j/Logger;", "<init>", "(Lorg/valkyrienskies/core/impl/shadow/CN;)V"})
public final class CH {
    private static /* synthetic */ KProperty<Object>[] a;
    private final CN b;
    private final CN c;
    private final Logger d;
    private final HashSet<String> e;
    private final HashMap<Class<?>, CD> f;
    private final HashMap<String, CD> g;

    @Inject
    public CH(CN cN) {
        Intrinsics.checkNotNullParameter((Object)cN, (String)"");
        this.b = cN;
        this.c = new CN(VSJacksonUtil.INSTANCE.getDefaultMapper());
        this.d = FX.a("AttachmentRegistry");
        this.e = new HashSet();
        this.f = new HashMap();
        this.g = new HashMap();
    }

    @JvmName(name="a")
    private Logger a() {
        KProperty<Object> kProperty = a[0];
        Logger logger = this.d;
        Intrinsics.checkNotNullParameter(kProperty, (String)"");
        return logger;
    }

    private static boolean b(AttachmentSerializer attachmentSerializer) {
        return attachmentSerializer instanceof JacksonAttachmentSerializer || attachmentSerializer instanceof TransientAttachmentSerializer || attachmentSerializer instanceof BinaryAttachmentSerializer || attachmentSerializer instanceof LegacyAttachmentSerializer;
    }

    private final void c(Class<?> object) {
        if (!(!((Map)this.f).containsKey(object))) {
            object = "Attachment " + object + " cannot be registered because it was already registered";
            throw new IllegalArgumentException(object.toString());
        }
    }

    private final void a(String object, Class<?> object2) {
        Object object3 = object2;
        if (object3 == null || (object3 = ((Class)object3).toString()) == null) {
            object3 = object2 = "";
        }
        if (!(!((Map)this.g).containsKey(object))) {
            object = "Attachment " + (String)object2 + " cannot be registered because another attachment with the same key, '" + (String)object + "', was already registered";
            throw new IllegalArgumentException(object.toString());
        }
        if (!(!this.e.contains(object))) {
            object = "Attachment " + (String)object2 + " cannot be registered because the key '" + (String)object + "' was already registered for removal";
            throw new IllegalArgumentException(object.toString());
        }
    }

    public final void a(String string) {
        Intrinsics.checkNotNullParameter((Object)string, (String)"");
        this.a(string, (Class<?>)null);
        this.e.add(string);
    }

    public final <T> void a(Class<T> object, Function1<? super AttachmentRegistration.Builder<T>, Unit> function1) {
        Intrinsics.checkNotNullParameter(object, (String)"");
        Intrinsics.checkNotNullParameter(function1, (String)"");
        object = new CF<T>(object);
        function1.invoke(object);
        this.a(((CF)object).build());
    }

    public final <T> void a(AttachmentRegistration<T> object) {
        Intrinsics.checkNotNullParameter(object, (String)"");
        CG cfr_ignored_0 = (CG)object;
        Class<T> clazz = object.getAttachmentClass();
        if (!Modifier.isFinal(clazz.getModifiers())) {
            String string = "Attachment " + clazz + " cannot be registered because it is not final";
            throw new IllegalArgumentException(string.toString());
        }
        if (!(!clazz.isLocalClass() && !clazz.isAnonymousClass())) {
            String string = "Attachment " + clazz + " cannot be registered because it is local or anonymous";
            throw new IllegalArgumentException(string.toString());
        }
        Object object2 = (CG)object;
        Object object3 = ((CG)object2).a;
        if (!(!this.a((CL)object3))) {
            Class<?> clazz2;
            Class<?> clazz3;
            CL cL = object3;
            if (cL != null) {
                object2 = cL;
                clazz3 = cL.a;
            } else {
                clazz3 = null;
            }
            CL cL2 = object3;
            if (cL2 != null) {
                object2 = cL2;
                clazz2 = cL2.b;
            } else {
                clazz2 = null;
            }
            object = "Attachment " + clazz + " cannot be registered because adding an updater from " + clazz3 + " to " + clazz2 + " will cause a cycle!";
            throw new IllegalArgumentException(object.toString());
        }
        if (!CH.b(object.getSerializer())) {
            object = "Attachment " + clazz + " cannot be registered with invalid serializer " + Reflection.getOrCreateKotlinClass(object.getSerializer().getClass());
            throw new IllegalArgumentException(object.toString());
        }
        object2 = object.getKey();
        Object object4 = object.getSerializer();
        object = new CD(clazz, (String)object2, (AttachmentSerializer)object4, (CL)object3);
        this.c(clazz);
        this.a((String)object2, clazz);
        object4 = this.f;
        object3 = clazz;
        if (!(object4.putIfAbsent(clazz, object) == null)) {
            object = object3 + " was already in the map";
            throw new IllegalArgumentException(object.toString());
        }
        object4 = this.g;
        object3 = object2;
        if (!(object4.putIfAbsent(object2, object) == null)) {
            object = object3 + " was already in the map";
            throw new IllegalArgumentException(object.toString());
        }
    }

    private final boolean a(CL cL) {
        if (cL != null) {
            CL cL2;
            CL cL3 = cL;
            cL3 = cL;
            if (Intrinsics.areEqual(this.e(cL2.b), cL3.a)) {
                return true;
            }
        }
        return false;
    }

    public final CD a(Class<?> clazz) {
        Intrinsics.checkNotNullParameter(clazz, (String)"");
        return this.f.get(clazz);
    }

    private CD b(String string) {
        Intrinsics.checkNotNullParameter((Object)string, (String)"");
        return this.g.get(string);
    }

    public final CD b(Class<?> object) {
        Intrinsics.checkNotNullParameter(object, (String)"");
        CD cD = this.a((Class<?>)object);
        if (cD == null) {
            object = object + " is not registered as an attachment!";
            throw new IllegalArgumentException(object.toString());
        }
        return cD;
    }

    public final JsonNode a(Object object) {
        Intrinsics.checkNotNullParameter((Object)object, (String)"");
        CD cD = this.b(object.getClass());
        Object object2 = object;
        object = cD;
        return this.a(object2, ((CD)object).c);
    }

    public final CE a(String object, JsonNode clazz) {
        Object object2;
        Object object3;
        Intrinsics.checkNotNullParameter((Object)object, (String)"");
        Intrinsics.checkNotNullParameter((Object)clazz, (String)"");
        if (this.e.contains(object)) {
            return CE.e.INSTANCE;
        }
        CD cD = this.g.get(object);
        if (cD == null) {
            return new CE.a("Deserialization was requested for attachment with key " + (String)object + " but no attachment with that key was registered");
        }
        CD cD2 = cD;
        Object object4 = cD;
        Class<?> clazz2 = cD.a;
        Object object5 = cD2;
        object5 = ((CD)object5).c;
        if (Intrinsics.areEqual((Object)object5, (Object)TransientAttachmentSerializer.INSTANCE)) {
            return CE.c.INSTANCE;
        }
        try {
            object3 = object5;
            object2 = clazz;
            clazz = clazz2;
            object4 = this;
            Object object6 = ((CH)object4).a((AttachmentSerializer)object3).a((JsonNode)object2, clazz);
            if (object6 == null) {
                return new CE.a("Deserialization failed for attachment " + (String)object + " (strategy = " + (AttachmentSerializer)object5 + ", clazz = " + clazz2 + ")");
            }
            object4 = object6;
        }
        catch (Exception exception) {
            return new CE.a("Deserialization failed for attachment " + (String)object + " with exception (strategy = " + (AttachmentSerializer)object5 + ", clazz = " + clazz2 + ") " + exception);
        }
        clazz = object4;
        Object object7 = this.a((Object)clazz, cD2);
        if (object7 == null) {
            String string = "Failed to update " + (String)object;
            clazz = clazz2;
            object4 = this;
            object2 = ((CH)object4).e(clazz);
            CD cD3 = ((CH)object4).f.get(object2);
            if (cD3 == null) {
                object = "getFinalUpdateKey: could not find the key for the end of the upgrade chain (" + (Class)object2 + ") for initial attachment (" + clazz + "). This should not be possible because the initial and final attachment class of every updater should be registered.";
                throw new IllegalArgumentException(object.toString());
            }
            Intrinsics.checkNotNullExpressionValue((Object)cD3, (String)"");
            object3 = cD3;
            object5 = cD3;
            return new CE.b(string, cD3.b);
        }
        object4 = object7;
        if (object7 == clazz) {
            return new CE.d(object4);
        }
        return new CE.f(object4);
    }

    private final String d(Class<?> object) {
        Class<?> clazz = this.e((Class<?>)object);
        CD cD = this.f.get(clazz);
        if (cD == null) {
            object = "getFinalUpdateKey: could not find the key for the end of the upgrade chain (" + clazz + ") for initial attachment (" + object + "). This should not be possible because the initial and final attachment class of every updater should be registered.";
            throw new IllegalArgumentException(object.toString());
        }
        Intrinsics.checkNotNullExpressionValue((Object)cD, (String)"");
        object = cD;
        object = cD;
        return cD.b;
    }

    /*
     * Unable to fully structure code
     */
    private final Class<?> e(Class<?> var1_1) {
        var2_2 = var1_1;
        while (var1_1 != null) {
            var2_2 = var1_1;
            v0 = this.f.get(var1_1);
            if (v0 == null) ** GOTO lbl-1000
            var1_1 = v0;
            v0 = v0.d;
            if (v0 != null) {
                var1_1 = v0;
                v1 = v0.b;
            } else lbl-1000:
            // 2 sources

            {
                v1 = null;
            }
            var1_1 = v1;
        }
        return var2_2;
    }

    private final Object a(Object object, CD object2) {
        Object object3 = object2;
        CL cL = ((CD)object3).d;
        if (cL == null) {
            return object;
        }
        object2 = cL;
        try {
            object3 = object2;
            Object object4 = ((CL)object3).c.invoke(object);
            if (object4 == null) {
                return null;
            }
            object = object4;
            object3 = object2;
            if (!Intrinsics.areEqual(((CL)object3).b, object.getClass())) {
                return null;
            }
            object3 = object2;
            CD cD = this.f.get(((CL)object3).b);
            if (cD == null) {
                return null;
            }
            object2 = cD;
            return this.a(object, (CD)object2);
        }
        catch (Exception exception) {
            return null;
        }
    }

    final CK a(AttachmentSerializer attachmentSerializer) {
        AttachmentSerializer attachmentSerializer2 = attachmentSerializer;
        if (attachmentSerializer2 instanceof JacksonAttachmentSerializer) {
            return this.b;
        }
        if (attachmentSerializer2 instanceof BinaryAttachmentSerializer) {
            return new CM((BinaryAttachmentSerializer)attachmentSerializer);
        }
        if (attachmentSerializer2 instanceof TransientAttachmentSerializer) {
            throw new IllegalArgumentException("Cannot convert TransientAttachmentSerializer. Please handle this case separately");
        }
        if (attachmentSerializer2 instanceof LegacyAttachmentSerializer) {
            return this.c;
        }
        throw new IllegalArgumentException("Unrecognized serializer " + Reflection.getOrCreateKotlinClass(attachmentSerializer.getClass()));
    }

    private final JsonNode a(Object object, AttachmentSerializer attachmentSerializer) {
        if (Intrinsics.areEqual((Object)attachmentSerializer, (Object)TransientAttachmentSerializer.INSTANCE)) {
            return null;
        }
        return this.a(attachmentSerializer).a(object);
    }

    private final Object a(Class<?> clazz, JsonNode jsonNode, AttachmentSerializer attachmentSerializer) {
        return this.a(attachmentSerializer).a(jsonNode, clazz);
    }

    static {
        KProperty[] kPropertyArray = new KProperty[1];
        KProperty[] kPropertyArray2 = kPropertyArray;
        kPropertyArray[0] = Reflection.property1((PropertyReference1)((PropertyReference1)new PropertyReference1Impl(CH.class, "log", "getLog()Lorg/apache/logging/log4j/Logger;", 0)));
        a = kPropertyArray2;
    }
}

