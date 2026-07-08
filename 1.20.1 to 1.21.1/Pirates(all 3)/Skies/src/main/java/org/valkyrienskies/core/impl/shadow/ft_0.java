/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.netty.buffer.ByteBuf
 *  io.netty.buffer.ByteBufInputStream
 *  io.netty.buffer.Unpooled
 *  kotlin.Deprecated
 *  kotlin.Unit
 *  kotlin.jvm.JvmClassMappingKt
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.functions.Function2
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.reflect.KClass
 *  org.valkyrienskies.core.impl.shadow.Fb
 */
package org.valkyrienskies.core.impl.shadow;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufInputStream;
import io.netty.buffer.Unpooled;
import java.io.InputStream;
import java.util.Arrays;
import kotlin.Deprecated;
import kotlin.Unit;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
import org.valkyrienskies.core.api.event.RegisteredListener;
import org.valkyrienskies.core.impl.networking.simple.SimplePacket;
import org.valkyrienskies.core.impl.networking.simple.SimplePacketNetworking;
import org.valkyrienskies.core.impl.shadow.EY;
import org.valkyrienskies.core.impl.shadow.Fb;
import org.valkyrienskies.core.impl.shadow.fb_0;
import org.valkyrienskies.core.impl.util.serialization.VSJacksonUtil;
import org.valkyrienskies.core.internal.world.VsiPlayer;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.Ft
 */
public final class ft_0 {
    private static final SimplePacketNetworking a;

    public static final ByteBuf a(SimplePacket simplePacket) {
        Intrinsics.checkNotNullParameter((Object)simplePacket, (String)"");
        ByteBuf byteBuf = Unpooled.wrappedBuffer((byte[])VSJacksonUtil.INSTANCE.getPacketMapper().writeValueAsBytes(simplePacket));
        Intrinsics.checkNotNullExpressionValue((Object)byteBuf, (String)"");
        return byteBuf;
    }

    public static final <T extends SimplePacket> T a(KClass<T> object, ByteBuf byteBuf) {
        Intrinsics.checkNotNullParameter(object, (String)"");
        Intrinsics.checkNotNullParameter((Object)byteBuf, (String)"");
        ObjectMapper objectMapper = VSJacksonUtil.INSTANCE.getPacketMapper();
        ByteBuf byteBuf2 = byteBuf.duplicate();
        Intrinsics.checkNotNullExpressionValue((Object)byteBuf2, (String)"");
        Class clazz = JvmClassMappingKt.getJavaClass(object);
        byteBuf = byteBuf2;
        object = objectMapper;
        Intrinsics.checkNotNullParameter((Object)objectMapper, (String)"");
        Intrinsics.checkNotNullParameter((Object)byteBuf, (String)"");
        Intrinsics.checkNotNullParameter((Object)clazz, (String)"");
        return (T)((SimplePacket)((ObjectMapper)object).readValue((InputStream)new ByteBufInputStream(byteBuf), clazz));
    }

    @Deprecated(message="This is global state; please inject a SimplePacketNetworking and use that instead")
    private static <T extends SimplePacket> RegisteredListener a(KClass<T> kClass, Function2<? super T, ? super VsiPlayer, Unit> function2) {
        Intrinsics.checkNotNullParameter(kClass, (String)"");
        Intrinsics.checkNotNullParameter(function2, (String)"");
        SimplePacketNetworking simplePacketNetworking = a;
        return simplePacketNetworking.registerServerHandler1(kClass, function2);
    }

    @Deprecated(message="This is global state; please inject a SimplePacketNetworking and use that instead")
    private static <T extends SimplePacket> RegisteredListener a(KClass<T> kClass, Function1<? super T, Unit> function1) {
        Intrinsics.checkNotNullParameter(kClass, (String)"");
        Intrinsics.checkNotNullParameter(function1, (String)"");
        SimplePacketNetworking simplePacketNetworking = a;
        return simplePacketNetworking.registerClientHandler1(kClass, function1);
    }

    @Deprecated(message="This is global state; please inject a SimplePacketNetworking and use that instead")
    private static void b(SimplePacket simplePacket) {
        Intrinsics.checkNotNullParameter((Object)simplePacket, (String)"");
        SimplePacketNetworking simplePacketNetworking = a;
        simplePacketNetworking.sendToServer1(simplePacket);
    }

    @Deprecated(message="This is global state; please inject a SimplePacketNetworking and use that instead")
    private static void a(SimplePacket simplePacket, VsiPlayer vsiPlayer) {
        Intrinsics.checkNotNullParameter((Object)simplePacket, (String)"");
        Intrinsics.checkNotNullParameter((Object)vsiPlayer, (String)"");
        SimplePacketNetworking simplePacketNetworking = a;
        simplePacketNetworking.sendToClient1(simplePacket, vsiPlayer);
    }

    @Deprecated(message="This is global state; please inject a SimplePacketNetworking and use that instead")
    private static void a(SimplePacket simplePacket, VsiPlayer ... vsiPlayerArray) {
        Intrinsics.checkNotNullParameter((Object)simplePacket, (String)"");
        Intrinsics.checkNotNullParameter((Object)vsiPlayerArray, (String)"");
        SimplePacketNetworking simplePacketNetworking = a;
        simplePacketNetworking.sendToClients1(simplePacket, Arrays.copyOf(vsiPlayerArray, vsiPlayerArray.length));
    }

    @Deprecated(message="This is global state; please inject a SimplePacketNetworking and use that instead")
    private static void c(SimplePacket simplePacket) {
        Intrinsics.checkNotNullParameter((Object)simplePacket, (String)"");
        SimplePacketNetworking simplePacketNetworking = a;
        simplePacketNetworking.sendToAllClients1(simplePacket);
    }

    @Deprecated(message="This is global state; please inject a SimplePacketNetworking and use that instead")
    private static Void a(KClass<? extends SimplePacket> kClass, String string) {
        Intrinsics.checkNotNullParameter(kClass, (String)"");
        Intrinsics.checkNotNullParameter((Object)string, (String)"");
        throw new UnsupportedOperationException("This method has been removed.");
    }

    private static /* synthetic */ Void a(KClass kClass, EY object, String object2, int n2) {
        if ((n2 & 2) != 0) {
            object2 = "SimplePacket - " + JvmClassMappingKt.getJavaClass((KClass)kClass);
        }
        object = object2;
        Intrinsics.checkNotNullParameter((Object)kClass, (String)"");
        Intrinsics.checkNotNullParameter((Object)object, (String)"");
        throw new UnsupportedOperationException("This method has been removed.");
    }

    static {
        fb_0 fb_02 = Fb.a.a();
        a = ((Fb)fb_02).b;
    }
}

