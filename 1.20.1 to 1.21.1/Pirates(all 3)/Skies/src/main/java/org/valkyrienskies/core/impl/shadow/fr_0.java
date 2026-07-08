/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.netty.buffer.ByteBuf
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.jvm.JvmClassMappingKt
 *  kotlin.jvm.JvmName
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.functions.Function2
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.PropertyReference1
 *  kotlin.jvm.internal.PropertyReference1Impl
 *  kotlin.jvm.internal.Reflection
 *  kotlin.jvm.internal.TypeIntrinsics
 *  kotlin.reflect.KClass
 *  kotlin.reflect.KFunction
 *  kotlin.reflect.KProperty
 *  kotlin.reflect.full.KClasses
 *  org.valkyrienskies.core.impl.shadow.Fr
 */
package org.valkyrienskies.core.impl.shadow;

import io.netty.buffer.ByteBuf;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.reflect.KClass;
import kotlin.reflect.KFunction;
import kotlin.reflect.KProperty;
import kotlin.reflect.full.KClasses;
import org.apache.logging.log4j.Logger;
import org.valkyrienskies.core.api.event.RegisteredListener;
import org.valkyrienskies.core.impl.networking.simple.SimplePacket;
import org.valkyrienskies.core.impl.networking.simple.SimplePacketNetworking;
import org.valkyrienskies.core.impl.shadow.EY;
import org.valkyrienskies.core.impl.shadow.EZ;
import org.valkyrienskies.core.impl.shadow.FX;
import org.valkyrienskies.core.impl.shadow.Fr;
import org.valkyrienskies.core.impl.shadow.dt_1;
import org.valkyrienskies.core.impl.shadow.fa_0;
import org.valkyrienskies.core.impl.shadow.fe_0;
import org.valkyrienskies.core.impl.shadow.ft_0;
import org.valkyrienskies.core.internal.world.VsiPlayer;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.Fr
 */
@Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0016\u0018\u0000 \u001f2\u00020\u0001:\u0002\u001f\u001cB\u0017\b\u0007\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020&0%\u00a2\u0006\u0004\b(\u0010)J\u001f\u0010\u0006\u001a\u00020\u00052\u000e\u0010\u0004\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00030\u0002H\u0016\u00a2\u0006\u0004\b\u0006\u0010\u0007J;\u0010\f\u001a\u00020\u000b\"\b\b\u0000\u0010\b*\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u00022\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00050\tH\u0016\u00a2\u0006\u0004\b\f\u0010\rJA\u0010\u0010\u001a\u00020\u000b\"\b\b\u0000\u0010\b*\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u00022\u0018\u0010\n\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00050\u000eH\u0016\u00a2\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016\u00a2\u0006\u0004\b\u0012\u0010\u0013J\u001f\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000fH\u0016\u00a2\u0006\u0004\b\u0014\u0010\u0015J+\u0010\u0017\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u00032\u0012\u0010\n\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u000f0\u0016\"\u00020\u000fH\u0016\u00a2\u0006\u0004\b\u0017\u0010\u0018J\u0017\u0010\u0019\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016\u00a2\u0006\u0004\b\u0019\u0010\u0013J\u001b\u0010\u001c\u001a\u00020\u001b*\n\u0012\u0006\b\u0001\u0012\u00020\u00030\u001aH\u0002\u00a2\u0006\u0004\b\u001c\u0010\u001dJ\u001b\u0010\u001f\u001a\u00020\u001e*\n\u0012\u0006\b\u0001\u0012\u00020\u00030\u001aH\u0002\u00a2\u0006\u0004\b\u001f\u0010 R@\u0010\u001f\u001a.\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00030\u001a\u0012\u0004\u0012\u00020\u001e0!j\u0016\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00030\u001a\u0012\u0004\u0012\u00020\u001e`\"8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b#\u0010$R\u001a\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020&0%8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001c\u0010'"}, d2={"Lorg/valkyrienskies/core/impl/shadow/Fr;", "Lorg/valkyrienskies/core/impl/networking/simple/SimplePacketNetworking;", "Lkotlin/reflect/KClass;", "Lorg/valkyrienskies/core/impl/networking/simple/SimplePacket;", "p0", "", "register", "(Lkotlin/reflect/KClass;)V", "T", "Lkotlin/Function1;", "p1", "Lorg/valkyrienskies/core/api/event/RegisteredListener;", "registerClientHandler", "(Lkotlin/reflect/KClass;Lkotlin/jvm/functions/Function1;)Lorg/valkyrienskies/core/api/event/RegisteredListener;", "Lkotlin/Function2;", "Lorg/valkyrienskies/core/internal/world/VsiPlayer;", "registerServerHandler", "(Lkotlin/reflect/KClass;Lkotlin/jvm/functions/Function2;)Lorg/valkyrienskies/core/api/event/RegisteredListener;", "sendToAllClients", "(Lorg/valkyrienskies/core/impl/networking/simple/SimplePacket;)V", "sendToClient", "(Lorg/valkyrienskies/core/impl/networking/simple/SimplePacket;Lorg/valkyrienskies/core/internal/world/VsiPlayer;)V", "", "sendToClients", "(Lorg/valkyrienskies/core/impl/networking/simple/SimplePacket;[Lorg/valkyrienskies/core/internal/world/VsiPlayer;)V", "sendToServer", "Ljava/lang/Class;", "Lorg/valkyrienskies/core/impl/shadow/Fa;", "b", "(Ljava/lang/Class;)Lorg/valkyrienskies/core/impl/shadow/Fa;", "Lorg/valkyrienskies/core/impl/shadow/Fr$b;", "a", "(Ljava/lang/Class;)Lorg/valkyrienskies/core/impl/shadow/Fr$b;", "Ljava/util/HashMap;", "Lkotlin/collections/d;", "c", "Ljava/util/HashMap;", "Lorg/valkyrienskies/core/impl/shadow/dT;", "Lorg/valkyrienskies/core/impl/shadow/EY;", "Lorg/valkyrienskies/core/impl/shadow/dT;", "<init>", "(Lorg/valkyrienskies/core/impl/shadow/dT;)V"})
public class fr_0
implements SimplePacketNetworking {
    public static final a a = new a(null);
    private final dt_1<EY> b;
    private final HashMap<Class<? extends SimplePacket>, b> c;
    private static final Logger d = FX.a("Simple Packet");

    @Inject
    public fr_0(dt_1<EY> dt_12) {
        Intrinsics.checkNotNullParameter(dt_12, (String)"");
        this.b = dt_12;
        this.c = new HashMap();
    }

    private final b a(Class<? extends SimplePacket> object) {
        b b2 = this.c.get(object);
        if (b2 == null) {
            object = "SimplePacket (" + object + ") not registered";
            throw new IllegalArgumentException(object.toString());
        }
        return b2;
    }

    private final fa_0 b(Class<? extends SimplePacket> object) {
        object = this.a((Class<? extends SimplePacket>)object);
        return ((b)object).a;
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public <T extends SimplePacket> RegisteredListener registerServerHandler(KClass<T> klass, Function2<? super T, ? super VsiPlayer, Unit> handler) {
        void var2_2;
        void var1_1;
        Intrinsics.checkNotNullParameter(klass, (String)"");
        Intrinsics.checkNotNullParameter(handler, (String)"");
        b b2 = this.a(JvmClassMappingKt.getJavaClass(klass));
        b2.b.add((Function2<SimplePacket, VsiPlayer, Unit>)((Function2)TypeIntrinsics.beforeCheckcastToFunctionOfArity(handler, (int)2)));
        return () -> fr_0.a(this, (KClass)var1_1, (Function2)var2_2);
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public <T extends SimplePacket> RegisteredListener registerClientHandler(KClass<T> klass, Function1<? super T, Unit> handler) {
        void var2_2;
        void var1_1;
        Intrinsics.checkNotNullParameter(klass, (String)"");
        Intrinsics.checkNotNullParameter(handler, (String)"");
        b b2 = this.a(JvmClassMappingKt.getJavaClass(klass));
        b2.c.add((Function1<SimplePacket, Unit>)((Function1)TypeIntrinsics.beforeCheckcastToFunctionOfArity(handler, (int)1)));
        return () -> fr_0.a(this, (KClass)var1_1, (Function1)var2_2);
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public void sendToServer(SimplePacket packet) {
        void var1_1;
        Intrinsics.checkNotNullParameter((Object)packet, (String)"");
        this.b(packet.getClass()).b(ft_0.a((SimplePacket)var1_1));
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public void sendToClient(SimplePacket packet, VsiPlayer player) {
        void var2_2;
        void var1_1;
        Intrinsics.checkNotNullParameter((Object)packet, (String)"");
        Intrinsics.checkNotNullParameter((Object)player, (String)"");
        this.b(packet.getClass()).a(ft_0.a((SimplePacket)var1_1), (VsiPlayer)var2_2);
    }

    @Override
    public void sendToClients(SimplePacket packet, VsiPlayer ... players) {
        Object object;
        Object object2;
        Intrinsics.checkNotNullParameter((Object)packet, (String)"");
        Intrinsics.checkNotNullParameter((Object)players, (String)"");
        if (!(!(players.length == 0))) {
            packet = "Failed requirement.";
            throw new IllegalArgumentException(packet.toString());
        }
        void v0 = object2;
        VsiPlayer[] vsiPlayerArray = (VsiPlayer[])Arrays.copyOf(v0, ((void)v0).length);
        object2 = ft_0.a((SimplePacket)object);
        object = this.b(packet.getClass());
        Intrinsics.checkNotNullParameter((Object)object2, (String)"");
        Intrinsics.checkNotNullParameter((Object)vsiPlayerArray, (String)"");
        vsiPlayerArray = Arrays.copyOf(vsiPlayerArray, vsiPlayerArray.length);
        object2 = ((fa_0)object).a((ByteBuf)object2);
        object = ((fa_0)object).a;
        Intrinsics.checkNotNullParameter((Object)object2, (String)"");
        Intrinsics.checkNotNullParameter((Object)vsiPlayerArray, (String)"");
        for (VsiPlayer vsiPlayer : vsiPlayerArray) {
            ((EY)object).a((EZ)object2, vsiPlayer);
        }
    }

    @Override
    public void sendToAllClients(SimplePacket packet) {
        fa_0 fa_02;
        Intrinsics.checkNotNullParameter((Object)packet, (String)"");
        ByteBuf byteBuf = ft_0.a((SimplePacket)((Object)fa_02));
        fa_02 = this.b(packet.getClass());
        Intrinsics.checkNotNullParameter((Object)byteBuf, (String)"");
        fa_02.a.b(fa_02.a(byteBuf));
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public void register(KClass<? extends SimplePacket> klass) {
        boolean bl;
        boolean bl2;
        Intrinsics.checkNotNullParameter(klass, (String)"");
        if (!klass.isData()) {
            String string = "SimplePacket (" + JvmClassMappingKt.getJavaClass(klass) + ") must be a data class!";
            throw new IllegalStateException(string.toString());
        }
        Iterator iterator2 = this.b.get();
        Object object = "SimplePacket - " + JvmClassMappingKt.getJavaClass(klass);
        iterator2 = ((EY)((Object)iterator2)).a((String)object);
        object = new b((fa_0)((Object)iterator2), null, null, 6, null);
        ((Map)this.c).put(JvmClassMappingKt.getJavaClass(klass), object);
        ((fa_0)((Object)iterator2)).a(arg_0 -> fr_0.a(klass, (b)object, (fa_0)((Object)iterator2), arg_0));
        object = (arg_0, arg_1) -> fr_0.a(klass, (b)object, (fa_0)((Object)iterator2), arg_0, arg_1);
        Intrinsics.checkNotNullParameter((Object)object, (String)"");
        ((fa_0)((Object)iterator2)).a.a((fa_0)((Object)iterator2), (fe_0)object);
        iterator2 = KClasses.getDeclaredMemberFunctions(klass);
        if (!(iterator2 instanceof Collection) || !((Collection)((Object)iterator2)).isEmpty()) {
            iterator2 = iterator2.iterator();
            while (iterator2.hasNext()) {
                object = iterator2.next();
                if (!Intrinsics.areEqual((Object)(object = (KFunction)object).getName(), (Object)"receivedByClient")) continue;
                bl2 = true;
                break;
            }
        } else {
            bl2 = false;
        }
        if (bl2) {
            this.registerClientHandler1(klass, org.valkyrienskies.core.impl.shadow.Fr$c.a);
        }
        if (!((iterator2 = (Iterable)KClasses.getDeclaredMemberFunctions(klass)) instanceof Collection) || !((Collection)((Object)iterator2)).isEmpty()) {
            iterator2 = iterator2.iterator();
            while (iterator2.hasNext()) {
                object = iterator2.next();
                if (!Intrinsics.areEqual((Object)(object = (KFunction)object).getName(), (Object)"receivedByServer")) continue;
                bl = true;
                break;
            }
        } else {
            bl = false;
        }
        if (bl) {
            void var1_1;
            this.registerServerHandler1((KClass)var1_1, org.valkyrienskies.core.impl.shadow.Fr$d.a);
        }
    }

    private static final void a(fr_0 object, KClass kClass, Function2 function2) {
        object = ((fr_0)object).a(JvmClassMappingKt.getJavaClass((KClass)kClass));
        ((b)object).b.remove(function2);
    }

    private static final void a(fr_0 object, KClass kClass, Function1 function1) {
        object = ((fr_0)object).a(JvmClassMappingKt.getJavaClass((KClass)kClass));
        ((b)object).c.remove(function1);
    }

    private static final void a(KClass object, b b2, fa_0 fa_02, EZ object2) {
        Intrinsics.checkNotNullParameter((Object)object2, (String)"");
        object = ft_0.a(object, ((EZ)object2).b);
        object2 = b2;
        object2 = ((b)object2).c;
        object2 = object2.iterator();
        while (object2.hasNext()) {
            Object object3 = object2.next();
            object3 = (Function1)object3;
            object3.invoke(object);
        }
        object2 = b2;
        if (((b)object2).c.isEmpty()) {
            org.valkyrienskies.core.impl.shadow.Fr$a.a(a).warn("No client handlers registered for the received SimplePacket (" + fa_02 + ")");
        }
    }

    private static final void a(KClass object, b b2, fa_0 fa_02, EZ object2, VsiPlayer vsiPlayer) {
        Intrinsics.checkNotNullParameter((Object)object2, (String)"");
        Intrinsics.checkNotNullParameter((Object)vsiPlayer, (String)"");
        object = ft_0.a(object, ((EZ)object2).b);
        object2 = b2;
        object2 = ((b)object2).b;
        object2 = object2.iterator();
        while (object2.hasNext()) {
            Object object3 = object2.next();
            object3 = (Function2)object3;
            object3.invoke(object, (Object)vsiPlayer);
        }
        object2 = b2;
        if (((b)object2).b.isEmpty()) {
            org.valkyrienskies.core.impl.shadow.Fr$a.a(a).warn("No server handlers registered for the received SimplePacket (" + fa_02 + ")");
        }
    }

    public static final /* synthetic */ Logger a() {
        return d;
    }

    @Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0007\u0010\bR\u001b\u0010\u0005\u001a\u00020\u00028CX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006"}, d2={"Lorg/valkyrienskies/core/impl/shadow/Fr$a;", "", "Lorg/apache/logging/log4j/Logger;", "d", "Lorg/apache/logging/log4j/Logger;", "a", "()Lorg/apache/logging/log4j/Logger;", "<init>", "()V"})
    public static final class a {
        private static /* synthetic */ KProperty<Object>[] a;

        private a() {
        }

        @JvmName(name="a")
        private final Logger a() {
            KProperty<Object> kProperty = a[0];
            Logger logger = Fr.a();
            Intrinsics.checkNotNullParameter(kProperty, (String)"");
            return logger;
        }

        public static final /* synthetic */ Logger a(a object) {
            KProperty<Object> kProperty = a[0];
            object = Fr.a();
            Intrinsics.checkNotNullParameter(kProperty, (String)"");
            return object;
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        static {
            KProperty[] kPropertyArray = new KProperty[1];
            KProperty[] kPropertyArray2 = kPropertyArray;
            kPropertyArray[0] = Reflection.property1((PropertyReference1)((PropertyReference1)new PropertyReference1Impl(a.class, "logger", "getLogger()Lorg/apache/logging/log4j/Logger;", 0)));
            a = kPropertyArray2;
        }
    }

    @Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\b\u0082\b\u0018\u00002\u00020\u0001BM\u0012\u0006\u0010\u000e\u001a\u00020\u0002\u0012 \b\u0002\u0010\u000f\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u00060\u0005\u0012\u001a\b\u0002\u0010\u0010\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\t0\f0\u0005\u00a2\u0006\u0004\b \u0010!J\u0010\u0010\u0003\u001a\u00020\u0002H\u00c6\u0003\u00a2\u0006\u0004\b\u0003\u0010\u0004J(\u0010\n\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u00060\u0005H\u00c6\u0003\u00a2\u0006\u0004\b\n\u0010\u000bJ\"\u0010\r\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\t0\f0\u0005H\u00c6\u0003\u00a2\u0006\u0004\b\r\u0010\u000bJX\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u000e\u001a\u00020\u00022 \b\u0002\u0010\u000f\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u00060\u00052\u001a\b\u0002\u0010\u0010\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\t0\f0\u0005H\u00c6\u0001\u00a2\u0006\u0004\b\u0011\u0010\u0012J\u001a\u0010\u0014\u001a\u00020\u00132\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003\u00a2\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0017\u001a\u00020\u0016H\u00d6\u0001\u00a2\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\u001a\u001a\u00020\u0019H\u00d6\u0001\u00a2\u0006\u0004\b\u001a\u0010\u001bR)\u0010\u0011\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\t0\f0\u00058\u0007\u00a2\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001c\u0010\u000bR/\u0010\u001e\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u00060\u00058\u0007\u00a2\u0006\f\n\u0004\b\u001e\u0010\u001d\u001a\u0004\b\u001e\u0010\u000bR\u0017\u0010\u001c\u001a\u00020\u00028\u0007\u00a2\u0006\f\n\u0004\b\u0011\u0010\u001f\u001a\u0004\b\u0011\u0010\u0004"}, d2={"Lorg/valkyrienskies/core/impl/shadow/Fr$b;", "", "Lorg/valkyrienskies/core/impl/shadow/Fa;", "d", "()Lorg/valkyrienskies/core/impl/shadow/Fa;", "", "Lkotlin/Function2;", "Lorg/valkyrienskies/core/impl/networking/simple/SimplePacket;", "Lorg/valkyrienskies/core/internal/world/VsiPlayer;", "", "e", "()Ljava/util/List;", "Lkotlin/Function1;", "f", "p0", "p1", "p2", "a", "(Lorg/valkyrienskies/core/impl/shadow/Fa;Ljava/util/List;Ljava/util/List;)Lorg/valkyrienskies/core/impl/shadow/Fr$b;", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "c", "Ljava/util/List;", "b", "Lorg/valkyrienskies/core/impl/shadow/Fa;", "<init>", "(Lorg/valkyrienskies/core/impl/shadow/Fa;Ljava/util/List;Ljava/util/List;)V"})
    static final class b {
        final fa_0 a;
        final List<Function2<SimplePacket, VsiPlayer, Unit>> b;
        final List<Function1<SimplePacket, Unit>> c;

        private b(fa_0 fa_02, List<Function2<SimplePacket, VsiPlayer, Unit>> list, List<Function1<SimplePacket, Unit>> list2) {
            Intrinsics.checkNotNullParameter((Object)fa_02, (String)"");
            Intrinsics.checkNotNullParameter(list, (String)"");
            Intrinsics.checkNotNullParameter(list2, (String)"");
            this.a = fa_02;
            this.b = list;
            this.c = list2;
        }

        public /* synthetic */ b(fa_0 fa_02, List list, List list2, int n2, DefaultConstructorMarker defaultConstructorMarker) {
            if ((n2 & 2) != 0) {
                list = new ArrayList();
            }
            if ((n2 & 4) != 0) {
                list2 = new ArrayList();
            }
            this(fa_02, list, list2);
        }

        @JvmName(name="a")
        public final fa_0 a() {
            return this.a;
        }

        @JvmName(name="b")
        public final List<Function2<SimplePacket, VsiPlayer, Unit>> b() {
            return this.b;
        }

        @JvmName(name="c")
        public final List<Function1<SimplePacket, Unit>> c() {
            return this.c;
        }

        private fa_0 d() {
            return this.a;
        }

        private List<Function2<SimplePacket, VsiPlayer, Unit>> e() {
            return this.b;
        }

        private List<Function1<SimplePacket, Unit>> f() {
            return this.c;
        }

        private static b a(fa_0 fa_02, List<Function2<SimplePacket, VsiPlayer, Unit>> list, List<Function1<SimplePacket, Unit>> list2) {
            Intrinsics.checkNotNullParameter((Object)fa_02, (String)"");
            Intrinsics.checkNotNullParameter(list, (String)"");
            Intrinsics.checkNotNullParameter(list2, (String)"");
            return new b(fa_02, list, list2);
        }

        private static /* synthetic */ b a$default(b object, fa_0 object2, List list, List list2, int n2) {
            if ((n2 & 1) != 0) {
                object2 = ((b)object).a;
            }
            if ((n2 & 2) != 0) {
                list = ((b)object).b;
            }
            if ((n2 & 4) != 0) {
                list2 = ((b)object).c;
            }
            fa_0 fa_02 = object2;
            List<Function2<SimplePacket, VsiPlayer, Unit>> list3 = list;
            list = list2;
            object2 = list3;
            object = fa_02;
            Intrinsics.checkNotNullParameter((Object)fa_02, (String)"");
            Intrinsics.checkNotNullParameter((Object)object2, (String)"");
            Intrinsics.checkNotNullParameter(list, (String)"");
            return new b((fa_0)object, (List<Function2<SimplePacket, VsiPlayer, Unit>>)object2, list);
        }

        public final String toString() {
            return "SimplePacketInfo(type=" + this.a + ", serverHandlers=" + this.b + ", clientHandlers=" + this.c + ")";
        }

        public final int hashCode() {
            int n2 = this.a.hashCode();
            n2 = n2 * 31 + ((Object)this.b).hashCode();
            n2 = n2 * 31 + ((Object)this.c).hashCode();
            return n2;
        }

        public final boolean equals(Object other) {
            b b2;
            if (this == other) {
                return true;
            }
            if (!(other instanceof b)) {
                return false;
            }
            b2 = b2;
            if (!Intrinsics.areEqual((Object)this.a, (Object)b2.a)) {
                return false;
            }
            if (!Intrinsics.areEqual(this.b, b2.b)) {
                return false;
            }
            return Intrinsics.areEqual(this.c, b2.c);
        }
    }
}

