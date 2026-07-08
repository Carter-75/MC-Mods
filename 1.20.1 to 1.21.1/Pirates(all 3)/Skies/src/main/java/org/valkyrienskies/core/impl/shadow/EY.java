/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.netty.buffer.ByteBuf
 *  io.netty.buffer.CompositeByteBuf
 *  io.netty.buffer.Unpooled
 *  it.unimi.dsi.fastutil.ints.Int2ObjectOpenHashMap
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.jvm.JvmName
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.functions.Function2
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.PropertyReference1
 *  kotlin.jvm.internal.PropertyReference1Impl
 *  kotlin.jvm.internal.Reflection
 *  kotlin.reflect.KProperty
 */
package org.valkyrienskies.core.impl.shadow;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.CompositeByteBuf;
import io.netty.buffer.Unpooled;
import it.unimi.dsi.fastutil.ints.Int2ObjectOpenHashMap;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import javax.inject.Provider;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import org.apache.logging.log4j.Logger;
import org.valkyrienskies.core.api.event.RegisteredListener;
import org.valkyrienskies.core.impl.shadow.EX;
import org.valkyrienskies.core.impl.shadow.EZ;
import org.valkyrienskies.core.impl.shadow.FV;
import org.valkyrienskies.core.impl.shadow.FW;
import org.valkyrienskies.core.impl.shadow.er_0;
import org.valkyrienskies.core.impl.shadow.fa_0;
import org.valkyrienskies.core.impl.shadow.fe_0;
import org.valkyrienskies.core.internal.hooks.VsiCoreHooks;
import org.valkyrienskies.core.internal.world.VsiPlayer;

@Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u0000\u009a\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010#\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u000b2\u00020\u0001:\u0001\u000bB\u0015\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002000B\u00a2\u0006\u0004\bC\u0010DJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006J\r\u0010\u0005\u001a\u00020\u0007\u00a2\u0006\u0004\b\u0005\u0010\bJ\u0017\u0010\t\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0004H\u0002\u00a2\u0006\u0004\b\t\u0010\nJ\r\u0010\t\u001a\u00020\u0007\u00a2\u0006\u0004\b\t\u0010\bJ\u0015\u0010\u000b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0002\u00a2\u0006\u0004\b\u000b\u0010\fJ\u001d\u0010\u000b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\r\u00a2\u0006\u0004\b\u000b\u0010\u000fJ\u0017\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0002\u00a2\u0006\u0004\b\u0010\u0010\u0011J\u001d\u0010\u000b\u001a\u00020\u00142\u0006\u0010\u0003\u001a\u00020\u00122\u0006\u0010\u000e\u001a\u00020\u0013\u00a2\u0006\u0004\b\u000b\u0010\u0015J\u0015\u0010\u000b\u001a\u00020\u00142\u0006\u0010\u0003\u001a\u00020\u0013\u00a2\u0006\u0004\b\u000b\u0010\u0016J\u0015\u0010\u000b\u001a\u00020\u00142\u0006\u0010\u0003\u001a\u00020\u0017\u00a2\u0006\u0004\b\u000b\u0010\u0018J\u0015\u0010\u000b\u001a\u00020\u00122\u0006\u0010\u0003\u001a\u00020\u0019\u00a2\u0006\u0004\b\u000b\u0010\u001aJ\u001d\u0010\u000b\u001a\u00020\u00142\u0006\u0010\u0003\u001a\u00020\u00122\u0006\u0010\u000e\u001a\u00020\u0017\u00a2\u0006\u0004\b\u000b\u0010\u001bJ\u0015\u0010\u0005\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\u0004\b\u0005\u0010\nJ\u001d\u0010\u000b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\r\u00a2\u0006\u0004\b\u000b\u0010\u001cJ)\u0010\u000b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00042\u0012\u0010\u000e\u001a\n\u0012\u0006\b\u0001\u0012\u00020\r0\u001d\"\u00020\r\u00a2\u0006\u0004\b\u000b\u0010\u001eJ\u0015\u0010\u000b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\u0004\b\u000b\u0010\nJ\r\u0010\u000b\u001a\u00020\u0007\u00a2\u0006\u0004\b\u000b\u0010\bJ\u001f\u0010\u0005\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\rH\u0002\u00a2\u0006\u0004\b\u0005\u0010\u001cR \u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00130 0\u001f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b!\u0010\"R$\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00040#j\b\u0012\u0004\u0012\u00020\u0004`$8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b%\u0010&R\u0016\u0010\t\u001a\u00020'8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b(\u0010)R$\u0010\u0010\u001a\u0012\u0012\u0004\u0012\u00020\u00130*j\b\u0012\u0004\u0012\u00020\u0013`+8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b,\u0010-R$\u0010/\u001a\u0012\u0012\u0004\u0012\u00020\u00170*j\b\u0012\u0004\u0012\u00020\u0017`+8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b.\u0010-R\u001b\u00103\u001a\u0002008CX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0010\u00101\u001a\u0004\b/\u00102R$\u0010!\u001a\u0012\u0012\u0004\u0012\u00020\u00120#j\b\u0012\u0004\u0012\u00020\u0012`$8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b/\u0010&RR\u0010.\u001a2\u0012\u0013\u0012\u00110\u0002\u00a2\u0006\f\b5\u0012\b\b6\u0012\u0004\b\b(7\u0012\u0013\u0012\u00110\r\u00a2\u0006\f\b5\u0012\b\b6\u0012\u0004\b\b(8\u0012\u0004\u0012\u00020\u0007048\u0007@\u0007X\u0086.\u00a2\u0006\u0012\n\u0004\b9\u0010:\u001a\u0004\b!\u0010;\"\u0004\b\u000b\u0010<R=\u0010,\u001a\u001d\u0012\u0013\u0012\u00110\u0002\u00a2\u0006\f\b5\u0012\b\b6\u0012\u0004\b\b(7\u0012\u0004\u0012\u00020\u00070=8\u0007@\u0007X\u0086.\u00a2\u0006\u0012\n\u0004\b>\u0010?\u001a\u0004\b3\u0010@\"\u0004\b\u000b\u0010AR \u0010(\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00170 0\u001f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b3\u0010\"R\u0016\u0010%\u001a\u00020'8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0005\u0010)"}, d2={"Lorg/valkyrienskies/core/impl/shadow/EY;", "", "Lio/netty/buffer/ByteBuf;", "p0", "Lorg/valkyrienskies/core/impl/shadow/EZ;", "b", "(Lio/netty/buffer/ByteBuf;)Lorg/valkyrienskies/core/impl/shadow/EZ;", "", "()V", "c", "(Lorg/valkyrienskies/core/impl/shadow/EZ;)V", "a", "(Lio/netty/buffer/ByteBuf;)V", "Lorg/valkyrienskies/core/internal/world/VsiPlayer;", "p1", "(Lio/netty/buffer/ByteBuf;Lorg/valkyrienskies/core/internal/world/VsiPlayer;)V", "d", "(Lorg/valkyrienskies/core/impl/shadow/EZ;)Lio/netty/buffer/ByteBuf;", "Lorg/valkyrienskies/core/impl/shadow/Fa;", "Lorg/valkyrienskies/core/impl/shadow/EX;", "Lorg/valkyrienskies/core/api/event/RegisteredListener;", "(Lorg/valkyrienskies/core/impl/shadow/Fa;Lorg/valkyrienskies/core/impl/shadow/EX;)Lorg/valkyrienskies/core/api/event/RegisteredListener;", "(Lorg/valkyrienskies/core/impl/shadow/EX;)Lorg/valkyrienskies/core/api/event/RegisteredListener;", "Lorg/valkyrienskies/core/impl/shadow/Fe;", "(Lorg/valkyrienskies/core/impl/shadow/Fe;)Lorg/valkyrienskies/core/api/event/RegisteredListener;", "", "(Ljava/lang/String;)Lorg/valkyrienskies/core/impl/shadow/Fa;", "(Lorg/valkyrienskies/core/impl/shadow/Fa;Lorg/valkyrienskies/core/impl/shadow/Fe;)Lorg/valkyrienskies/core/api/event/RegisteredListener;", "(Lorg/valkyrienskies/core/impl/shadow/EZ;Lorg/valkyrienskies/core/internal/world/VsiPlayer;)V", "", "(Lorg/valkyrienskies/core/impl/shadow/EZ;[Lorg/valkyrienskies/core/internal/world/VsiPlayer;)V", "Lit/unimi/dsi/fastutil/ints/Int2ObjectOpenHashMap;", "", "g", "Lit/unimi/dsi/fastutil/ints/Int2ObjectOpenHashMap;", "Ljava/util/ArrayList;", "Lkotlin/collections/b;", "k", "Ljava/util/ArrayList;", "", "j", "Z", "Ljava/util/HashSet;", "Lkotlin/collections/f;", "i", "Ljava/util/HashSet;", "h", "e", "Lorg/valkyrienskies/core/internal/hooks/VsiCoreHooks;", "Ljavax/inject/Provider;", "()Lorg/valkyrienskies/core/internal/hooks/VsiCoreHooks;", "f", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "data", "player", "m", "Lkotlin/jvm/functions/Function2;", "()Lkotlin/jvm/functions/Function2;", "(Lkotlin/jvm/functions/Function2;)V", "Lkotlin/Function1;", "l", "Lkotlin/jvm/functions/Function1;", "()Lkotlin/jvm/functions/Function1;", "(Lkotlin/jvm/functions/Function1;)V", "Ljavax/inject/Provider;", "<init>", "(Ljavax/inject/Provider;)V"})
public final class EY {
    public static final a a;
    private static /* synthetic */ KProperty<Object>[] c;
    private final Provider d;
    private final ArrayList<fa_0> e;
    private final Int2ObjectOpenHashMap<Set<fe_0>> f;
    private final Int2ObjectOpenHashMap<Set<EX>> g;
    private final HashSet<fe_0> h;
    private final HashSet<EX> i;
    private boolean j;
    public boolean b;
    private final ArrayList<EZ> k;
    private Function1<? super ByteBuf, Unit> l;
    private Function2<? super ByteBuf, ? super VsiPlayer, Unit> m;
    private static final Logger n;
    private static boolean o = false;

    public EY(Provider<VsiCoreHooks> provider) {
        Intrinsics.checkNotNullParameter(provider, (String)"");
        this.d = provider;
        this.e = new ArrayList();
        this.f = new Int2ObjectOpenHashMap();
        this.g = new Int2ObjectOpenHashMap();
        this.h = new HashSet();
        this.i = new HashSet();
        this.k = new ArrayList();
    }

    @JvmName(name="e")
    private final VsiCoreHooks e() {
        return (VsiCoreHooks)FV.a(this.d, c[0]);
    }

    public final fa_0 a(String object) {
        Intrinsics.checkNotNullParameter((Object)object, (String)"");
        EY eY = this;
        object = new fa_0(eY, eY.e.size(), (String)object);
        fa_0 fa_02 = object;
        this.e.add(fa_02);
        return object;
    }

    private RegisteredListener a(fe_0 fe_02) {
        Intrinsics.checkNotNullParameter((Object)fe_02, (String)"");
        this.h.add(fe_02);
        return () -> EY.a(this, fe_02);
    }

    private RegisteredListener a(EX eX) {
        Intrinsics.checkNotNullParameter((Object)eX, (String)"");
        this.i.add(eX);
        return () -> EY.a(this, eX);
    }

    public final RegisteredListener a(fa_0 fa_02, fe_0 fe_02) {
        Intrinsics.checkNotNullParameter((Object)fa_02, (String)"");
        Intrinsics.checkNotNullParameter((Object)fe_02, (String)"");
        fa_0 fa_03 = fa_02;
        ((Set)this.f.computeIfAbsent(fa_03.b, EY::a)).add(fe_02);
        return () -> EY.a(this, fa_02, fe_02);
    }

    public final RegisteredListener a(fa_0 fa_02, EX eX) {
        Intrinsics.checkNotNullParameter((Object)fa_02, (String)"");
        Intrinsics.checkNotNullParameter((Object)eX, (String)"");
        fa_0 fa_03 = fa_02;
        ((Set)this.g.computeIfAbsent(fa_03.b, EY::b)).add(eX);
        return () -> EY.a(this, fa_02, eX);
    }

    public final void a(ByteBuf object) {
        Intrinsics.checkNotNullParameter((Object)object, (String)"");
        object = this.b((ByteBuf)object);
        if (this.j) {
            this.c((EZ)object);
            return;
        }
        Object object2 = object;
        ArrayList<EZ> arrayList = this.k;
        object.b.retain();
        arrayList.add((EZ)object2);
    }

    private final void c(EZ eZ) {
        Object object;
        Object object2 = eZ;
        object2 = ((EZ)object2).a;
        object2 = (Set)this.g.get(((fa_0)object2).b);
        Iterator iterator2 = this.i;
        iterator2 = iterator2.iterator();
        while (iterator2.hasNext()) {
            object = iterator2.next();
            object = (EX)object;
            object.handlePacket(eZ);
        }
        Object object3 = object2;
        if (object3 != null) {
            iterator2 = (Iterable)object3;
            iterator2 = iterator2.iterator();
            while (iterator2.hasNext()) {
                object = iterator2.next();
                object = (EX)object;
                object.handlePacket(eZ);
            }
        }
        if (this.i.isEmpty() && (object2 == null || object2.isEmpty())) {
            object2 = eZ;
            object2 = ((EZ)object2).a;
            a.a().warn("Received a packet " + ((fa_0)object2).c + " on the client, but no handlers were registered");
        }
    }

    public final void a(ByteBuf object, VsiPlayer vsiPlayer) {
        Intrinsics.checkNotNullParameter((Object)object, (String)"");
        Intrinsics.checkNotNullParameter((Object)vsiPlayer, (String)"");
        object = this.b((ByteBuf)object);
        if (this.b) {
            this.b((EZ)object, vsiPlayer);
        }
    }

    private final void b(EZ eZ, VsiPlayer vsiPlayer) {
        Object object;
        Object object2 = eZ;
        object2 = ((EZ)object2).a;
        object2 = (Set)this.f.get(((fa_0)object2).b);
        Iterator iterator2 = this.h;
        iterator2 = iterator2.iterator();
        while (iterator2.hasNext()) {
            object = iterator2.next();
            object = (fe_0)object;
            object.handlePacket(eZ, vsiPlayer);
        }
        Object object3 = object2;
        if (object3 != null) {
            iterator2 = (Iterable)object3;
            iterator2 = iterator2.iterator();
            while (iterator2.hasNext()) {
                object = iterator2.next();
                object = (fe_0)object;
                object.handlePacket(eZ, vsiPlayer);
            }
        }
        if (this.h.isEmpty() && (object2 == null || object2.isEmpty())) {
            object2 = eZ;
            object2 = ((EZ)object2).a;
            a.a().warn("Received a packet " + ((fa_0)object2).c + " on the server, but no handlers were registered");
        }
    }

    private final EZ b(ByteBuf byteBuf) {
        int n2 = byteBuf.readInt();
        fa_0 fa_02 = this.e.get(n2);
        Intrinsics.checkNotNullExpressionValue((Object)fa_02, (String)"");
        fa_0 fa_03 = fa_02;
        return new EZ(fa_03, byteBuf);
    }

    private static ByteBuf d(EZ eZ) {
        ByteBuf[] byteBufArray;
        CompositeByteBuf compositeByteBuf = Unpooled.compositeBuffer((int)2);
        ByteBuf[] byteBufArray2 = byteBufArray = Unpooled.buffer((int)4);
        Object object = eZ;
        object = ((EZ)object).a;
        byteBufArray.writeInt(((fa_0)object).b);
        ByteBuf[] byteBufArray3 = new ByteBuf[2];
        byteBufArray2 = byteBufArray3;
        byteBufArray3[0] = byteBufArray;
        object = eZ;
        byteBufArray2[1] = ((EZ)object).b;
        CompositeByteBuf compositeByteBuf2 = compositeByteBuf.addComponents(true, byteBufArray2);
        Intrinsics.checkNotNullExpressionValue((Object)compositeByteBuf2, (String)"");
        return (ByteBuf)compositeByteBuf2;
    }

    public final void a(EZ eZ) {
        Intrinsics.checkNotNullParameter((Object)eZ, (String)"");
        EY eY = this;
        Function1<? super ByteBuf, Unit> function1 = eY.l;
        if (function1 == null) {
            Intrinsics.throwUninitializedPropertyAccessException((String)"");
            function1 = null;
        }
        function1.invoke((Object)EY.d(eZ));
    }

    public final void a(EZ eZ, VsiPlayer vsiPlayer) {
        Intrinsics.checkNotNullParameter((Object)eZ, (String)"");
        Intrinsics.checkNotNullParameter((Object)vsiPlayer, (String)"");
        EY eY = this;
        Function2<? super ByteBuf, ? super VsiPlayer, Unit> function2 = eY.m;
        if (function2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException((String)"");
            function2 = null;
        }
        function2.invoke((Object)EY.d(eZ), (Object)vsiPlayer);
    }

    public final void a(EZ eZ, VsiPlayer ... vsiPlayerArray) {
        Intrinsics.checkNotNullParameter((Object)eZ, (String)"");
        Intrinsics.checkNotNullParameter((Object)vsiPlayerArray, (String)"");
        for (VsiPlayer vsiPlayer : vsiPlayerArray) {
            this.a(eZ, vsiPlayer);
        }
    }

    public final void b(EZ object) {
        Intrinsics.checkNotNullParameter((Object)object, (String)"");
        Iterator iterator2 = this;
        er_0 er_02 = (er_0)((VsiCoreHooks)FV.a(((EY)((Object)iterator2)).d, c[0])).getCurrentShipServerWorld();
        if (er_02 == null) {
            object = "Tried to send a packet of type " + ((EZ)object).a + " to all clients, but there is no server currently running!";
            throw new IllegalArgumentException(object.toString());
        }
        iterator2 = er_02;
        iterator2 = er_02.getPlayers();
        iterator2 = iterator2.iterator();
        while (iterator2.hasNext()) {
            Object object2 = iterator2.next();
            object2 = (VsiPlayer)object2;
            this.a((EZ)object, (VsiPlayer)object2);
        }
    }

    @JvmName(name="f")
    private Function1<ByteBuf, Unit> f() {
        Function1<? super ByteBuf, Unit> function1 = this.l;
        if (function1 != null) {
            return function1;
        }
        Intrinsics.throwUninitializedPropertyAccessException((String)"");
        return null;
    }

    @JvmName(name="a")
    public final void a(Function1<? super ByteBuf, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, (String)"");
        this.l = function1;
    }

    @JvmName(name="g")
    private Function2<ByteBuf, VsiPlayer, Unit> g() {
        Function2<? super ByteBuf, ? super VsiPlayer, Unit> function2 = this.m;
        if (function2 != null) {
            return function2;
        }
        Intrinsics.throwUninitializedPropertyAccessException((String)"");
        return null;
    }

    @JvmName(name="a")
    public final void a(Function2<? super ByteBuf, ? super VsiPlayer, Unit> function2) {
        Intrinsics.checkNotNullParameter(function2, (String)"");
        this.m = function2;
    }

    public final void a() {
        this.b = true;
    }

    public final void b() {
        this.j = true;
        Object object = this.k;
        object = object.iterator();
        while (object.hasNext()) {
            Object object2 = object.next();
            object2 = (EZ)object2;
            this.c((EZ)object2);
            ((EZ)object2).b.release();
        }
        this.k.clear();
    }

    public final void c() {
        this.b = false;
        this.j = false;
    }

    private static final void a(EY eY, fe_0 fe_02) {
        eY.h.remove(fe_02);
    }

    private static final void a(EY eY, EX eX) {
        eY.i.remove(eX);
    }

    private static final HashSet a(int n2) {
        return new HashSet();
    }

    private static final void a(EY object, fa_0 fa_02, fe_0 fe_02) {
        object = fa_02;
        Set set = (Set)((EY)object).f.get(((fa_0)object).b);
        if (set != null) {
            set.remove(fe_02);
            return;
        }
    }

    private static final HashSet b(int n2) {
        return new HashSet();
    }

    private static final void a(EY object, fa_0 fa_02, EX eX) {
        object = fa_02;
        Set set = (Set)((EY)object).g.get(((fa_0)object).b);
        if (set != null) {
            set.remove(eX);
            return;
        }
    }

    static {
        KProperty[] kPropertyArray = new KProperty[1];
        KProperty[] kPropertyArray2 = kPropertyArray;
        kPropertyArray[0] = Reflection.property1((PropertyReference1)((PropertyReference1)new PropertyReference1Impl(EY.class, "hooks", "getHooks()Lorg/valkyrienskies/core/internal/hooks/VsiCoreHooks;", 0)));
        c = kPropertyArray2;
        a = new a(null);
        n = FW.a(a, org.valkyrienskies.core.impl.shadow.EY$a.a[0]);
    }

    @Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fR\u0014\u0010\u0005\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u001b\u0010\n\u001a\u00020\u00068GX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\t"}, d2={"Lorg/valkyrienskies/core/impl/shadow/EY$a;", "", "", "o", "Z", "a", "Lorg/apache/logging/log4j/Logger;", "n", "Lorg/apache/logging/log4j/Logger;", "()Lorg/apache/logging/log4j/Logger;", "b", "<init>", "()V"})
    public static final class a {
        static final /* synthetic */ KProperty<Object>[] a;

        private a() {
        }

        @JvmName(name="a")
        public final Logger a() {
            KProperty<Object> kProperty = a[0];
            Logger logger = n;
            Intrinsics.checkNotNullParameter(kProperty, (String)"");
            return logger;
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
}

