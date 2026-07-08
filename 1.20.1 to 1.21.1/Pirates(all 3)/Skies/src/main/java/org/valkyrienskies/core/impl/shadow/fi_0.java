/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.netty.buffer.ByteBuf
 *  it.unimi.dsi.fastutil.booleans.BooleanConsumer
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.jvm.JvmName
 *  kotlin.jvm.functions.Function0
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.functions.Function2
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.PropertyReference1
 *  kotlin.jvm.internal.PropertyReference1Impl
 *  kotlin.jvm.internal.Reflection
 *  kotlin.reflect.KProperty
 */
package org.valkyrienskies.core.impl.shadow;

import io.netty.buffer.ByteBuf;
import it.unimi.dsi.fastutil.booleans.BooleanConsumer;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.net.SocketException;
import javax.crypto.SecretKey;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import org.apache.logging.log4j.Logger;
import org.valkyrienskies.core.api.event.RegisteredListener;
import org.valkyrienskies.core.impl.config.VSCoreConfig;
import org.valkyrienskies.core.impl.networking.impl.PacketRequestUdp;
import org.valkyrienskies.core.impl.networking.impl.PacketUdpState;
import org.valkyrienskies.core.impl.networking.simple.SimplePacketNetworking;
import org.valkyrienskies.core.impl.shadow.EY;
import org.valkyrienskies.core.impl.shadow.EZ;
import org.valkyrienskies.core.impl.shadow.FW;
import org.valkyrienskies.core.impl.shadow.fa_0;
import org.valkyrienskies.core.impl.shadow.fb_0;
import org.valkyrienskies.core.impl.shadow.ff_0;
import org.valkyrienskies.core.impl.shadow.fg_0;
import org.valkyrienskies.core.internal.world.VsiPlayer;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.Fi
 */
@Singleton
@Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u0000d\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001:\u0001\u000bB)\b\u0007\u0012\u0006\u0010\u0007\u001a\u00020\u0015\u0012\u0006\u0010\t\u001a\u00020\u0015\u0012\u0006\u0010\u0010\u001a\u00020(\u0012\u0006\u0010)\u001a\u00020&\u00a2\u0006\u0004\b*\u0010+J\r\u0010\u0003\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0004J\u001f\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0002\u00a2\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\u0002H\u0002\u00a2\u0006\u0004\b\r\u0010\u0004J%\u0010\u000b\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u000f\u00a2\u0006\u0004\b\u000b\u0010\u0011J\u000f\u0010\u0013\u001a\u0004\u0018\u00010\u0012\u00a2\u0006\u0004\b\u0013\u0010\u0014R\u0017\u0010\u000b\u001a\u00020\u00158\u0007\u00a2\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0016\u0010\u0018R\u0014\u0010\u0016\u001a\u00020\u00198\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u001aR\u0017\u0010\u001b\u001a\u00020\u00158\u0007\u00a2\u0006\f\n\u0004\b\u000b\u0010\u0017\u001a\u0004\b\u000b\u0010\u0018R\"\u0010\u001c\u001a\u00020\n8\u0007@\u0007X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001b\u0010\u001e\"\u0004\b\u000b\u0010\u001fR\u001b\u0010\u0003\u001a\u00020 8CX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b!\u0010#R\u0018\u0010\u0013\u001a\u0004\u0018\u00010$8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0013\u0010%R\"\u0010\r\u001a\u00020\n8\u0007@\u0007X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u001d\u001a\u0004\b\u001c\u0010\u001e\"\u0004\b\u0016\u0010\u001fR\u0014\u0010\u0005\u001a\u00020&8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001b\u0010'"}, d2={"Lorg/valkyrienskies/core/impl/shadow/Fi;", "", "", "e", "()V", "h", "Ljava/net/SocketAddress;", "p0", "", "p1", "", "a", "(Ljava/net/SocketAddress;J)Z", "g", "Ljavax/crypto/SecretKey;", "Lit/unimi/dsi/fastutil/booleans/BooleanConsumer;", "p2", "(Ljava/net/SocketAddress;Ljavax/crypto/SecretKey;Lit/unimi/dsi/fastutil/booleans/BooleanConsumer;)V", "Lorg/valkyrienskies/core/impl/shadow/Fg;", "f", "()Lorg/valkyrienskies/core/impl/shadow/Fg;", "Lorg/valkyrienskies/core/impl/shadow/EY;", "b", "Lorg/valkyrienskies/core/impl/shadow/EY;", "()Lorg/valkyrienskies/core/impl/shadow/EY;", "Lorg/valkyrienskies/core/impl/shadow/Fa;", "Lorg/valkyrienskies/core/impl/shadow/Fa;", "c", "d", "Z", "()Z", "(Z)V", "Lorg/apache/logging/log4j/Logger;", "i", "Lorg/apache/logging/log4j/Logger;", "()Lorg/apache/logging/log4j/Logger;", "Lorg/valkyrienskies/core/api/event/RegisteredListener;", "Lorg/valkyrienskies/core/api/event/RegisteredListener;", "Lorg/valkyrienskies/core/impl/networking/simple/SimplePacketNetworking;", "Lorg/valkyrienskies/core/impl/networking/simple/SimplePacketNetworking;", "Lorg/valkyrienskies/core/impl/shadow/Fb;", "p3", "<init>", "(Lorg/valkyrienskies/core/impl/shadow/EY;Lorg/valkyrienskies/core/impl/shadow/EY;Lorg/valkyrienskies/core/impl/shadow/Fb;Lorg/valkyrienskies/core/impl/networking/simple/SimplePacketNetworking;)V"})
public final class fi_0 {
    private static /* synthetic */ KProperty<Object>[] g;
    public final EY a;
    public final EY b;
    public final SimplePacketNetworking c;
    private final fa_0 h;
    public boolean d;
    public boolean e;
    public RegisteredListener f;
    private final Logger i;

    @Inject
    public fi_0(EY eY, EY eY2, fb_0 fb_02, SimplePacketNetworking simplePacketNetworking) {
        Intrinsics.checkNotNullParameter((Object)eY, (String)"");
        Intrinsics.checkNotNullParameter((Object)eY2, (String)"");
        Intrinsics.checkNotNullParameter((Object)fb_02, (String)"");
        Intrinsics.checkNotNullParameter((Object)simplePacketNetworking, (String)"");
        this.a = eY;
        this.b = eY2;
        this.c = simplePacketNetworking;
        this.h = this.b.a("UDP fallback");
        this.i = FW.a(this, g[0]);
    }

    @JvmName(name="a")
    public final EY a() {
        return this.a;
    }

    @JvmName(name="b")
    public final EY b() {
        return this.b;
    }

    @JvmName(name="c")
    public final boolean c() {
        return this.d;
    }

    @JvmName(name="a")
    public final void a(boolean bl) {
        this.d = bl;
    }

    @JvmName(name="d")
    public final boolean d() {
        return this.e;
    }

    @JvmName(name="b")
    private void b(boolean bl) {
        this.e = bl;
    }

    public final void e() {
        fi_0 fi_02 = this;
        fi_02.b.a(fi_02.h, arg_0 -> fi_0.a(fi_02, arg_0));
        fi_02.b.a(fi_02.h, (arg_0, arg_1) -> fi_0.a(fi_02, arg_0, arg_1));
    }

    public final fg_0 f() {
        if (VSCoreConfig.SERVER.getEnableUdp()) {
            try {
                DatagramSocket datagramSocket = new DatagramSocket(VSCoreConfig.SERVER.getUdpPort());
                fg_0 fg_02 = new fg_0(datagramSocket, this.a, this.h);
                this.e = true;
                SimplePacketNetworking simplePacketNetworking = this.c;
                simplePacketNetworking.registerServerHandler1(Reflection.getOrCreateKotlinClass(PacketRequestUdp.class), (Function2)new Function2<PacketRequestUdp, VsiPlayer, Unit>(fg_02, simplePacketNetworking, datagramSocket, this){
                    private /* synthetic */ fg_0 $a;
                    private /* synthetic */ SimplePacketNetworking $b;
                    private /* synthetic */ DatagramSocket $c;
                    private /* synthetic */ fi_0 d;
                    {
                        this.$a = fg_02;
                        this.$b = simplePacketNetworking;
                        this.$c = datagramSocket;
                        this.d = fi_02;
                        super(2);
                    }

                    public final void a(PacketRequestUdp object, VsiPlayer vsiPlayer) {
                        Intrinsics.checkNotNullParameter((Object)object, (String)"");
                        Intrinsics.checkNotNullParameter((Object)vsiPlayer, (String)"");
                        Long l2 = this.$a.a(vsiPlayer, (PacketRequestUdp)object);
                        if (l2 != null) {
                            object = l2;
                            SimplePacketNetworking simplePacketNetworking = this.$b;
                            DatagramSocket datagramSocket = this.$c;
                            fi_0 fi_02 = this.d;
                            long l3 = ((Number)object).longValue();
                            object = fi_02;
                            simplePacketNetworking.sendToClient1(new PacketUdpState(datagramSocket.getLocalPort(), ((fi_0)object).e, l3), vsiPlayer);
                            return;
                        }
                    }

                    /*
                     * WARNING - void declaration
                     */
                    public final /* synthetic */ Object invoke(Object p1, Object p2) {
                        void var2_2;
                        void var1_1;
                        this.a((PacketRequestUdp)var1_1, (VsiPlayer)var2_2);
                        return Unit.INSTANCE;
                    }
                });
                return fg_02;
            }
            catch (SocketException socketException) {
                this.i().error("Tried to bind to " + VSCoreConfig.SERVER.getUdpPort() + " but failed!", (Throwable)socketException);
            }
            catch (Exception exception) {
                this.i().error("Tried to setup udp with port: " + VSCoreConfig.SERVER.getUdpPort() + " but failed!", (Throwable)exception);
            }
        }
        this.g();
        return null;
    }

    public final void a(SocketAddress socketAddress, SecretKey secretKey, BooleanConsumer booleanConsumer) {
        Intrinsics.checkNotNullParameter((Object)socketAddress, (String)"");
        Intrinsics.checkNotNullParameter((Object)secretKey, (String)"");
        Intrinsics.checkNotNullParameter((Object)booleanConsumer, (String)"");
        RegisteredListener registeredListener = this.f;
        if (registeredListener != null) {
            registeredListener.unregister();
        }
        SimplePacketNetworking simplePacketNetworking = this.c;
        this.f = simplePacketNetworking.registerClientHandler1(Reflection.getOrCreateKotlinClass(PacketUdpState.class), (Function1)new Function1<PacketUdpState, Unit>(booleanConsumer, socketAddress, this){
            private /* synthetic */ BooleanConsumer $a;
            private /* synthetic */ SocketAddress $b;
            private /* synthetic */ fi_0 c;
            {
                this.$a = booleanConsumer;
                this.$b = socketAddress;
                this.c = fi_02;
                super(1);
            }

            public final void a(PacketUdpState packetUdpState) {
                Intrinsics.checkNotNullParameter((Object)packetUdpState, (String)"");
                this.$a.accept(packetUdpState.getState());
                if (packetUdpState.getState()) {
                    SocketAddress socketAddress = this.$b;
                    if (socketAddress instanceof InetSocketAddress && ((InetSocketAddress)socketAddress).getPort() != packetUdpState.getPort()) {
                        socketAddress = new InetSocketAddress(((InetSocketAddress)socketAddress).getAddress(), packetUdpState.getPort());
                    }
                    if (!this.c.a(socketAddress, packetUdpState.getId())) {
                        this.c.g();
                    }
                }
            }

            /*
             * WARNING - void declaration
             */
            public final /* synthetic */ Object invoke(Object p1) {
                void var1_1;
                this.a((PacketUdpState)var1_1);
                return Unit.INSTANCE;
            }
        });
        byte[] byArray = secretKey.getEncoded();
        Intrinsics.checkNotNullExpressionValue((Object)byArray, (String)"");
        simplePacketNetworking.sendToServer1(new PacketRequestUdp(0, byArray));
    }

    private final boolean a(SocketAddress socketAddress, long l2) {
        try {
            DatagramSocket datagramSocket = new DatagramSocket();
            new ff_0(datagramSocket, this.a, socketAddress, l2, (Function0<Unit>)((Function0)new Function0<Unit>(this){
                private /* synthetic */ fi_0 a;
                {
                    this.a = fi_02;
                    super(0);
                }

                public final void a() {
                    boolean bl = true;
                    fi_0 fi_02 = this.a;
                    this.a.d = bl;
                }

                public final /* synthetic */ Object invoke() {
                    this.a();
                    return Unit.INSTANCE;
                }
            }));
            return true;
        }
        catch (Exception exception) {
            this.i().error("Tried to setup udp client with socket address: " + socketAddress + " but failed!", (Throwable)exception);
            return false;
        }
    }

    private final void g() {
        this.i().info("We are not using UDP, falling back to TCP");
        this.d = false;
        this.e = false;
        SimplePacketNetworking simplePacketNetworking = this.c;
        simplePacketNetworking.registerServerHandler1(Reflection.getOrCreateKotlinClass(PacketRequestUdp.class), (Function2)new Function2<PacketRequestUdp, VsiPlayer, Unit>(simplePacketNetworking, this){
            private /* synthetic */ SimplePacketNetworking $a;
            private /* synthetic */ fi_0 b;
            {
                this.$a = simplePacketNetworking;
                this.b = fi_02;
                super(2);
            }

            public final void a(PacketRequestUdp object, VsiPlayer vsiPlayer) {
                Intrinsics.checkNotNullParameter((Object)object, (String)"");
                Intrinsics.checkNotNullParameter((Object)vsiPlayer, (String)"");
                object = this.b;
                this.$a.sendToClient1(new PacketUdpState(-1, ((fi_0)object).e, -1L), vsiPlayer);
            }

            /*
             * WARNING - void declaration
             */
            public final /* synthetic */ Object invoke(Object p1, Object p2) {
                void var2_2;
                void var1_1;
                this.a((PacketRequestUdp)var1_1, (VsiPlayer)var2_2);
                return Unit.INSTANCE;
            }
        });
        this.a.a((Function2<? super ByteBuf, ? super VsiPlayer, Unit>)((Function2)new Function2<ByteBuf, VsiPlayer, Unit>(this){
            private /* synthetic */ fi_0 a;
            {
                this.a = fi_02;
                super(2);
            }

            public final void a(ByteBuf byteBuf, VsiPlayer vsiPlayer) {
                Intrinsics.checkNotNullParameter((Object)byteBuf, (String)"");
                Intrinsics.checkNotNullParameter((Object)vsiPlayer, (String)"");
                this.a.h.a(byteBuf, vsiPlayer);
            }

            /*
             * WARNING - void declaration
             */
            public final /* synthetic */ Object invoke(Object p1, Object p2) {
                void var2_2;
                void var1_1;
                this.a((ByteBuf)var1_1, (VsiPlayer)var2_2);
                return Unit.INSTANCE;
            }
        }));
        this.a.a((Function1<? super ByteBuf, Unit>)((Function1)new Function1<ByteBuf, Unit>(this){
            private /* synthetic */ fi_0 a;
            {
                this.a = fi_02;
                super(1);
            }

            public final void a(ByteBuf byteBuf) {
                Intrinsics.checkNotNullParameter((Object)byteBuf, (String)"");
                this.a.h.b(byteBuf);
            }

            /*
             * WARNING - void declaration
             */
            public final /* synthetic */ Object invoke(Object p1) {
                void var1_1;
                this.a((ByteBuf)var1_1);
                return Unit.INSTANCE;
            }
        }));
    }

    private final void h() {
        this.b.a(this.h, arg_0 -> fi_0.a(this, arg_0));
        this.b.a(this.h, (arg_0, arg_1) -> fi_0.a(this, arg_0, arg_1));
    }

    @JvmName(name="i")
    private final Logger i() {
        KProperty<Object> kProperty = g[0];
        Logger logger = this.i;
        Intrinsics.checkNotNullParameter(kProperty, (String)"");
        return logger;
    }

    private static final void a(fi_0 object, EZ eZ) {
        Intrinsics.checkNotNullParameter((Object)eZ, (String)"");
        object = eZ;
        ((fi_0)object).a.a(((EZ)object).b);
    }

    private static final void a(fi_0 object, EZ eZ, VsiPlayer vsiPlayer) {
        Intrinsics.checkNotNullParameter((Object)eZ, (String)"");
        Intrinsics.checkNotNullParameter((Object)vsiPlayer, (String)"");
        object = eZ;
        ((fi_0)object).a.a(((EZ)object).b, vsiPlayer);
    }

    static {
        KProperty[] kPropertyArray = new KProperty[1];
        KProperty[] kPropertyArray2 = kPropertyArray;
        kPropertyArray[0] = Reflection.property1((PropertyReference1)((PropertyReference1)new PropertyReference1Impl(fi_0.class, "logger", "getLogger()Lorg/apache/logging/log4j/Logger;", 0)));
        g = kPropertyArray2;
    }
}

