/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.common.collect.HashBiMap
 *  io.netty.buffer.ByteBuf
 *  io.netty.buffer.Unpooled
 *  it.unimi.dsi.fastutil.longs.Long2ObjectArrayMap
 *  it.unimi.dsi.fastutil.objects.ObjectCollection
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.jvm.JvmName
 *  kotlin.jvm.functions.Function2
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.PropertyReference1
 *  kotlin.jvm.internal.PropertyReference1Impl
 *  kotlin.jvm.internal.Reflection
 *  kotlin.random.Random
 *  kotlin.reflect.KProperty
 *  org.valkyrienskies.core.impl.shadow.Fg
 */
package org.valkyrienskies.core.impl.shadow;

import com.google.common.collect.HashBiMap;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import it.unimi.dsi.fastutil.longs.Long2ObjectArrayMap;
import it.unimi.dsi.fastutil.objects.ObjectCollection;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketAddress;
import java.util.HashMap;
import java.util.Map;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.random.Random;
import kotlin.reflect.KProperty;
import org.apache.logging.log4j.Logger;
import org.valkyrienskies.core.impl.networking.impl.PacketRequestUdp;
import org.valkyrienskies.core.impl.shadow.EY;
import org.valkyrienskies.core.impl.shadow.FW;
import org.valkyrienskies.core.impl.shadow.Fg;
import org.valkyrienskies.core.impl.shadow.fa_0;
import org.valkyrienskies.core.internal.world.VsiPlayer;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.Fg
 */
@Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u0000\u0086\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u00052\u00020\u0001:\u0001\u0005B\u001f\u0012\u0006\u0010\u0003\u001a\u000201\u0012\u0006\u0010\b\u001a\u00020\u000f\u0012\u0006\u00106\u001a\u00020\u001b\u00a2\u0006\u0004\b7\u00108J\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006J\u001f\u0010\u0005\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007\u00a2\u0006\u0004\b\u0005\u0010\nJ\u000f\u0010\u000b\u001a\u00020\u0004H\u0002\u00a2\u0006\u0004\b\u000b\u0010\fJ\u001f\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\r2\u0006\u0010\b\u001a\u00020\u0002H\u0002\u00a2\u0006\u0004\b\u0005\u0010\u000eR\u0017\u0010\u0005\u001a\u00020\u000f8\u0007\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R@\u0010\u0016\u001a.\u0012\b\u0012\u0006*\u00020\u00150\u0015\u0012\b\u0012\u0006*\u00020\u00020\u0002*\u0016\u0012\b\u0012\u0006*\u00020\u00150\u0015\u0012\b\u0012\u0006*\u00020\u00020\u00020\u00140\u00148\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0016\u0010\u0012\u001a\u00020\u00188\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0017\u0010\u001e\u001a\u00020\u001b8\u0007\u00a2\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR\u001a\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00020 8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0012\u0010!R\u0016\u0010\u0010\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\"\u0010#R\u0016\u0010\u001c\u001a\u00020\u00188\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b$\u0010\u001aR0\u0010)\u001a\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020&0%j\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020&`'8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001e\u0010(R\u0014\u0010+\u001a\u00020*8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b+\u0010,R\u0014\u0010.\u001a\u00020-8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b.\u0010/R\u0014\u00100\u001a\u00020-8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b0\u0010/R\u0017\u0010\u0019\u001a\u0002018\u0007\u00a2\u0006\f\n\u0004\b\u000b\u00102\u001a\u0004\b\u0016\u00103R\u0014\u0010$\u001a\u0002048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b)\u00105"}, d2={"Lorg/valkyrienskies/core/impl/shadow/Fg;", "", "Lorg/valkyrienskies/core/internal/world/VsiPlayer;", "p0", "", "a", "(Lorg/valkyrienskies/core/internal/world/VsiPlayer;)V", "Lorg/valkyrienskies/core/impl/networking/impl/PacketRequestUdp;", "p1", "", "(Lorg/valkyrienskies/core/internal/world/VsiPlayer;Lorg/valkyrienskies/core/impl/networking/impl/PacketRequestUdp;)Ljava/lang/Long;", "e", "()V", "Lio/netty/buffer/ByteBuf;", "(Lio/netty/buffer/ByteBuf;Lorg/valkyrienskies/core/internal/world/VsiPlayer;)V", "Lorg/valkyrienskies/core/impl/shadow/EY;", "f", "Lorg/valkyrienskies/core/impl/shadow/EY;", "c", "()Lorg/valkyrienskies/core/impl/shadow/EY;", "Lcom/google/common/collect/HashBiMap;", "Ljava/net/SocketAddress;", "b", "Lcom/google/common/collect/HashBiMap;", "", "l", "I", "Lorg/valkyrienskies/core/impl/shadow/Fa;", "g", "Lorg/valkyrienskies/core/impl/shadow/Fa;", "d", "()Lorg/valkyrienskies/core/impl/shadow/Fa;", "Lit/unimi/dsi/fastutil/longs/Long2ObjectArrayMap;", "Lit/unimi/dsi/fastutil/longs/Long2ObjectArrayMap;", "n", "J", "m", "Ljava/util/HashMap;", "Ljavax/crypto/SecretKey;", "Lkotlin/collections/d;", "Ljava/util/HashMap;", "h", "", "i", "[B", "Ljava/net/DatagramPacket;", "j", "Ljava/net/DatagramPacket;", "k", "Ljava/net/DatagramSocket;", "Ljava/net/DatagramSocket;", "()Ljava/net/DatagramSocket;", "Ljava/lang/Thread;", "Ljava/lang/Thread;", "p2", "<init>", "(Ljava/net/DatagramSocket;Lorg/valkyrienskies/core/impl/shadow/EY;Lorg/valkyrienskies/core/impl/shadow/Fa;)V"})
public final class fg_0 {
    public static final a a = new a(null);
    private final DatagramSocket e;
    private final EY f;
    private final fa_0 g;
    private final Thread h;
    private final byte[] i;
    private final DatagramPacket j;
    private final DatagramPacket k;
    public final HashBiMap<SocketAddress, VsiPlayer> b;
    private int l;
    public final Long2ObjectArrayMap<VsiPlayer> c;
    public final HashMap<VsiPlayer, SecretKey> d;
    private int m;
    private long n;
    private static int o = 508;
    private static final Logger p = FW.a(a, org.valkyrienskies.core.impl.shadow.Fg$a.a[0]);

    public fg_0(DatagramSocket datagramSocket, EY eY, fa_0 fa_02) {
        Intrinsics.checkNotNullParameter((Object)datagramSocket, (String)"");
        Intrinsics.checkNotNullParameter((Object)eY, (String)"");
        Intrinsics.checkNotNullParameter((Object)fa_02, (String)"");
        this.e = datagramSocket;
        this.f = eY;
        this.g = fa_02;
        this.h = new Thread(this::e);
        this.i = new byte[508];
        this.j = new DatagramPacket(this.i, 508);
        this.k = new DatagramPacket(new byte[508], 508);
        this.b = HashBiMap.create();
        this.c = new Long2ObjectArrayMap();
        this.d = new HashMap();
        this.n = System.currentTimeMillis();
        this.f.a((Function2<? super ByteBuf, ? super VsiPlayer, Unit>)((Function2)new Function2<ByteBuf, VsiPlayer, Unit>(this){

            public final void a(ByteBuf byteBuf, VsiPlayer vsiPlayer) {
                Intrinsics.checkNotNullParameter((Object)byteBuf, (String)"");
                Intrinsics.checkNotNullParameter((Object)vsiPlayer, (String)"");
                ((fg_0)this.receiver).a(byteBuf, vsiPlayer);
            }

            public final /* synthetic */ Object invoke(Object p1, Object p2) {
                this.a((ByteBuf)p1, (VsiPlayer)p2);
                return Unit.INSTANCE;
            }
        }));
        this.h.start();
        this.e.setSendBufferSize(30480);
        this.e.setReceiveBufferSize(30480);
    }

    @JvmName(name="b")
    private DatagramSocket b() {
        return this.e;
    }

    @JvmName(name="c")
    private EY c() {
        return this.f;
    }

    @JvmName(name="d")
    private fa_0 d() {
        return this.g;
    }

    private final void a(ByteBuf byteBuf, VsiPlayer vsiPlayer) {
        if (this.b.inverse().get((Object)vsiPlayer) == null) {
            this.g.a(byteBuf, vsiPlayer);
            return;
        }
        int n2 = this.m;
        this.m = n2 + 1;
        if (this.n + 1000L < System.currentTimeMillis()) {
            org.valkyrienskies.core.impl.shadow.Fg$a.a(a).trace("Sended " + this.m + " UDP packets");
            this.m = 0;
            this.n = System.currentTimeMillis();
        }
        this.k.setSocketAddress((SocketAddress)this.b.inverse().get((Object)vsiPlayer));
        byteBuf.readBytes(this.k.getData(), 0, byteBuf.writerIndex());
        this.k.setLength(byteBuf.writerIndex());
        this.e.send(this.k);
    }

    private final void e() {
        while (!this.e.isClosed()) {
            try {
                this.e.receive(this.j);
                VsiPlayer vsiPlayer = (VsiPlayer)this.b.get((Object)this.j.getSocketAddress());
                Object object = Unpooled.wrappedBuffer((byte[])this.i, (int)0, (int)this.j.getLength());
                if (vsiPlayer == null) {
                    if (object.capacity() != 8) continue;
                    VsiPlayer vsiPlayer2 = (VsiPlayer)this.c.remove(object.readLong());
                    if (vsiPlayer2 == null) continue;
                    vsiPlayer = vsiPlayer2;
                    HashBiMap<SocketAddress, VsiPlayer> hashBiMap = this.b;
                    Intrinsics.checkNotNullExpressionValue(hashBiMap, (String)"");
                    object = (Map)hashBiMap;
                    object.put(this.j.getSocketAddress(), vsiPlayer);
                    this.l = 0;
                    ByteBuf byteBuf = Unpooled.buffer((int)16).writeLong(vsiPlayer.getUuid().getLeastSignificantBits()).writeLong(vsiPlayer.getUuid().getMostSignificantBits());
                    Intrinsics.checkNotNullExpressionValue((Object)byteBuf, (String)"");
                    this.a(byteBuf, vsiPlayer);
                    continue;
                }
                Intrinsics.checkNotNullExpressionValue((Object)object, (String)"");
                this.f.a((ByteBuf)object, vsiPlayer);
            }
            catch (Exception exception) {
                org.valkyrienskies.core.impl.shadow.Fg$a.a(a).error("Error in server network thread", (Throwable)exception);
            }
        }
    }

    public final Long a(VsiPlayer vsiPlayer, PacketRequestUdp object) {
        Intrinsics.checkNotNullParameter((Object)vsiPlayer, (String)"");
        Intrinsics.checkNotNullParameter((Object)object, (String)"");
        Long l2 = Random.Default.nextLong();
        long l3 = ((Number)l2).longValue();
        object = ((PacketRequestUdp)object).getSecretKeyBytes();
        try {
            ((Map)this.d).put(vsiPlayer, new SecretKeySpec((byte[])object, "AES"));
        }
        catch (Exception exception) {
            org.valkyrienskies.core.impl.shadow.Fg$a.a(a).warn("Failed to parse secret from player " + vsiPlayer.getUuid(), (Throwable)exception);
            return null;
        }
        this.c.put(l3, (Object)vsiPlayer);
        if (this.l == 5) {
            org.valkyrienskies.core.impl.shadow.Fg$a.a(a).warn("There were 5 cases of failed connections in a row, is the UDP port accessible?");
            org.valkyrienskies.core.impl.shadow.Fg$a.a(a).info("By disabling UDP this warning shall not be printed anymore.");
        }
        int n2 = this.l;
        this.l = n2 + 1;
        return l2;
    }

    public final void a(VsiPlayer vsiPlayer) {
        Intrinsics.checkNotNullParameter((Object)vsiPlayer, (String)"");
        this.b.inverse().remove((Object)vsiPlayer);
        ((ObjectCollection)this.c.values()).remove((Object)vsiPlayer);
        this.d.remove(vsiPlayer);
    }

    public static final /* synthetic */ Logger a() {
        return p;
    }

    @Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fR\u0014\u0010\u0005\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u001b\u0010\n\u001a\u00020\u00068CX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\t"}, d2={"Lorg/valkyrienskies/core/impl/shadow/Fg$a;", "", "", "o", "I", "a", "Lorg/apache/logging/log4j/Logger;", "p", "Lorg/apache/logging/log4j/Logger;", "()Lorg/apache/logging/log4j/Logger;", "b", "<init>", "()V"})
    public static final class a {
        static final /* synthetic */ KProperty<Object>[] a;

        private a() {
        }

        @JvmName(name="a")
        private final Logger a() {
            KProperty<Object> kProperty = a[0];
            Logger logger = Fg.a();
            Intrinsics.checkNotNullParameter(kProperty, (String)"");
            return logger;
        }

        public static final /* synthetic */ Logger a(a object) {
            KProperty<Object> kProperty = a[0];
            object = Fg.a();
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
}

