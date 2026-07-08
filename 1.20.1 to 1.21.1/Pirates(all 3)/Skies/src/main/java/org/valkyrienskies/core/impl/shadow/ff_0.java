/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.netty.buffer.ByteBuf
 *  io.netty.buffer.Unpooled
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.jvm.JvmName
 *  kotlin.jvm.functions.Function0
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.internal.Intrinsics
 *  org.valkyrienskies.core.impl.shadow.Ff$a
 */
package org.valkyrienskies.core.impl.shadow;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketAddress;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.message.Message;
import org.apache.logging.log4j.message.StringFormattedMessage;
import org.valkyrienskies.core.impl.shadow.EY;
import org.valkyrienskies.core.impl.shadow.FW;
import org.valkyrienskies.core.impl.shadow.Ff;
import org.valkyrienskies.core.impl.shadow.ff_2;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.Ff
 */
@Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0004\u0018\u0000 \u00072\u00020\u0001:\u0001\u0007B5\u0012\u0006\u0010\u0006\u001a\u00020\u001c\u0012\u0006\u0010!\u001a\u00020\t\u0012\u0006\u0010\"\u001a\u00020\u0018\u0012\u0006\u0010$\u001a\u00020#\u0012\f\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00020\r\u00a2\u0006\u0004\b&\u0010'J\u000f\u0010\u0003\u001a\u00020\u0002H\u0002\u00a2\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0002\u00a2\u0006\u0004\b\u0007\u0010\bR\u0017\u0010\u0007\u001a\u00020\t8\u0007\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\n\u0010\fR\u001a\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00020\r8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u000eR\u0014\u0010\n\u001a\u00020\u00108\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0016\u001a\u00020\u00138\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0003\u001a\u00020\u00138\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0015R\u0017\u0010\u001b\u001a\u00020\u00188\u0007\u00a2\u0006\f\n\u0004\b\u0016\u0010\u0019\u001a\u0004\b\u0016\u0010\u001aR\u0017\u0010\u0011\u001a\u00020\u001c8\u0007\u00a2\u0006\f\n\u0004\b\u000f\u0010\u001d\u001a\u0004\b\u000f\u0010\u001eR\u0014\u0010\u0014\u001a\u00020\u001f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001b\u0010 "}, d2={"Lorg/valkyrienskies/core/impl/shadow/Ff;", "", "", "e", "()V", "Lio/netty/buffer/ByteBuf;", "p0", "a", "(Lio/netty/buffer/ByteBuf;)V", "Lorg/valkyrienskies/core/impl/shadow/EY;", "c", "Lorg/valkyrienskies/core/impl/shadow/EY;", "()Lorg/valkyrienskies/core/impl/shadow/EY;", "Lkotlin/Function0;", "Lkotlin/jvm/functions/Function0;", "b", "", "g", "[B", "Ljava/net/DatagramPacket;", "h", "Ljava/net/DatagramPacket;", "d", "i", "Ljava/net/SocketAddress;", "Ljava/net/SocketAddress;", "()Ljava/net/SocketAddress;", "f", "Ljava/net/DatagramSocket;", "Ljava/net/DatagramSocket;", "()Ljava/net/DatagramSocket;", "Ljava/lang/Thread;", "Ljava/lang/Thread;", "p1", "p2", "", "p3", "p4", "<init>", "(Ljava/net/DatagramSocket;Lorg/valkyrienskies/core/impl/shadow/EY;Ljava/net/SocketAddress;JLkotlin/jvm/functions/Function0;)V"})
public final class ff_0 {
    public static final ff_2.a_0 a = new Ff.a(null);
    private final DatagramSocket b;
    private final EY c;
    private final SocketAddress d;
    private final Function0<Unit> e;
    private final Thread f;
    private final byte[] g;
    private final DatagramPacket h;
    private final DatagramPacket i;
    private static final Logger j = FW.a(a, Ff.a.a[0]);

    public ff_0(DatagramSocket datagramSocket, EY eY, SocketAddress socketAddress, long l2, Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter((Object)datagramSocket, (String)"");
        Intrinsics.checkNotNullParameter((Object)eY, (String)"");
        Intrinsics.checkNotNullParameter((Object)socketAddress, (String)"");
        Intrinsics.checkNotNullParameter(function0, (String)"");
        this.b = datagramSocket;
        this.c = eY;
        this.d = socketAddress;
        this.e = function0;
        this.f = new Thread(this::e);
        this.g = new byte[508];
        this.h = new DatagramPacket(this.g, 508);
        this.i = new DatagramPacket(new byte[508], 508);
        this.c.a((Function1<? super ByteBuf, Unit>)((Function1)new Function1<ByteBuf, Unit>(this){

            public final void a(ByteBuf byteBuf) {
                Intrinsics.checkNotNullParameter((Object)byteBuf, (String)"");
                ((ff_0)this.receiver).a(byteBuf);
            }

            public final /* synthetic */ Object invoke(Object p1) {
                this.a((ByteBuf)p1);
                return Unit.INSTANCE;
            }
        }));
        this.i.setSocketAddress(this.d);
        ByteBuf byteBuf = Unpooled.buffer((int)8).writeLong(l2);
        Intrinsics.checkNotNullExpressionValue((Object)byteBuf, (String)"");
        this.a(byteBuf);
        this.b.setSendBufferSize(30480);
        this.b.setReceiveBufferSize(30480);
        this.f.start();
    }

    @JvmName(name="b")
    private DatagramSocket b() {
        return this.b;
    }

    @JvmName(name="c")
    private EY c() {
        return this.c;
    }

    @JvmName(name="d")
    private SocketAddress d() {
        return this.d;
    }

    private final void a(ByteBuf byteBuf) {
        this.i.setData(byteBuf.array());
        this.i.setLength(byteBuf.writerIndex());
        this.b.send(this.i);
    }

    private final void e() {
        this.b.setSoTimeout(1000);
        this.b.receive(this.h);
        if (this.h.getLength() != 16) {
            throw new IllegalStateException("Invalid confirmation packet");
        }
        this.b.setSoTimeout(0);
        this.e.invoke();
        int n2 = 0;
        long l2 = System.currentTimeMillis();
        while (!this.b.isClosed()) {
            try {
                this.b.receive(this.h);
                ++n2;
                if (!this.h.getSocketAddress().equals(this.d)) {
                    Ff.a.a((ff_2.a_0)a).warn("Received packet from non server address: " + this.h.getSocketAddress());
                    Ff.a.a((ff_2.a_0)a).warn("This is VERY SUSPICIOUS!");
                    continue;
                }
                if (l2 + 1000L < System.currentTimeMillis()) {
                    Ff.a.a((ff_2.a_0)a).trace("Received " + n2 + " UDP packets");
                    n2 = 0;
                    l2 = System.currentTimeMillis();
                }
                Ff.a.a((ff_2.a_0)a).trace(() -> ff_0.a(this));
                ByteBuf byteBuf = Unpooled.wrappedBuffer((byte[])this.g, (int)0, (int)this.h.getLength());
                Intrinsics.checkNotNullExpressionValue((Object)byteBuf, (String)"");
                this.c.a(byteBuf);
            }
            catch (Exception exception) {
                Ff.a.a((ff_2.a_0)a).error("Error in client network thread", (Throwable)exception);
            }
        }
    }

    private static final Message a(ff_0 ff_02) {
        return new StringFormattedMessage("Client received packet of size " + ff_02.h.getLength(), new Object[0]);
    }

    public static final /* synthetic */ Logger a() {
        return j;
    }
}

