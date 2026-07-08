/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Deprecated
 *  kotlin.Metadata
 *  kotlin.jvm.JvmName
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.Reflection
 *  org.valkyrienskies.core.impl.shadow.Fb
 */
package org.valkyrienskies.core.impl.shadow;

import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.valkyrienskies.core.impl.networking.impl.PacketCommonConfigUpdate;
import org.valkyrienskies.core.impl.networking.impl.PacketPhysEntityCreate;
import org.valkyrienskies.core.impl.networking.impl.PacketPhysEntityRemove;
import org.valkyrienskies.core.impl.networking.impl.PacketRequestUdp;
import org.valkyrienskies.core.impl.networking.impl.PacketServerConfigUpdate;
import org.valkyrienskies.core.impl.networking.impl.PacketShipDataCreate;
import org.valkyrienskies.core.impl.networking.impl.PacketShipRemove;
import org.valkyrienskies.core.impl.networking.impl.PacketUdpState;
import org.valkyrienskies.core.impl.networking.simple.SimplePacketNetworking;
import org.valkyrienskies.core.impl.shadow.EY;
import org.valkyrienskies.core.impl.shadow.Fb;
import org.valkyrienskies.core.impl.shadow.fa_0;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.Fb
 */
@Singleton
@Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u0000 \u00072\u00020\u0001:\u0001\u0007B!\b\u0007\u0012\u0006\u0010\u000e\u001a\u00020\r\u0012\u0006\u0010\u000f\u001a\u00020\r\u0012\u0006\u0010\u0010\u001a\u00020\n\u00a2\u0006\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0007\u001a\u00020\u00028\u0007\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\u0005\u001a\u00020\u00028\u0007\u00a2\u0006\f\n\u0004\b\b\u0010\u0004\u001a\u0004\b\t\u0010\u0006R\u0017\u0010\u0003\u001a\u00020\u00028\u0007\u00a2\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\u0003\u0010\u0006R\u0017\u0010\t\u001a\u00020\n8\u0007\u00a2\u0006\f\n\u0004\b\u0005\u0010\u000b\u001a\u0004\b\u0007\u0010\f"}, d2={"Lorg/valkyrienskies/core/impl/shadow/Fb;", "", "Lorg/valkyrienskies/core/impl/shadow/Fa;", "c", "Lorg/valkyrienskies/core/impl/shadow/Fa;", "b", "()Lorg/valkyrienskies/core/impl/shadow/Fa;", "a", "e", "d", "Lorg/valkyrienskies/core/impl/networking/simple/SimplePacketNetworking;", "Lorg/valkyrienskies/core/impl/networking/simple/SimplePacketNetworking;", "()Lorg/valkyrienskies/core/impl/networking/simple/SimplePacketNetworking;", "Lorg/valkyrienskies/core/impl/shadow/EY;", "p0", "p1", "p2", "<init>", "(Lorg/valkyrienskies/core/impl/shadow/EY;Lorg/valkyrienskies/core/impl/shadow/EY;Lorg/valkyrienskies/core/impl/networking/simple/SimplePacketNetworking;)V"})
public final class fb_0 {
    public static final a a = new a(null);
    public final SimplePacketNetworking b;
    public final fa_0 c;
    public final fa_0 d;
    public final fa_0 e;
    public static fb_0 f;

    @Inject
    public fb_0(EY object, EY eY, SimplePacketNetworking simplePacketNetworking) {
        Intrinsics.checkNotNullParameter((Object)object, (String)"");
        Intrinsics.checkNotNullParameter((Object)eY, (String)"");
        Intrinsics.checkNotNullParameter((Object)simplePacketNetworking, (String)"");
        this.b = simplePacketNetworking;
        this.c = ((EY)object).a("Ship data delta update");
        this.d = eY.a("Ship transform update");
        this.e = eY.a("Physics Entity transform update");
        org.valkyrienskies.core.impl.shadow.Fb$a.a(this);
        object = this.b;
        object.register1(Reflection.getOrCreateKotlinClass(PacketRequestUdp.class));
        object.register1(Reflection.getOrCreateKotlinClass(PacketUdpState.class));
        object.register1(Reflection.getOrCreateKotlinClass(PacketShipDataCreate.class));
        object.register1(Reflection.getOrCreateKotlinClass(PacketShipRemove.class));
        object.register1(Reflection.getOrCreateKotlinClass(PacketCommonConfigUpdate.class));
        object.register1(Reflection.getOrCreateKotlinClass(PacketServerConfigUpdate.class));
        object.register1(Reflection.getOrCreateKotlinClass(PacketPhysEntityCreate.class));
        object.register1(Reflection.getOrCreateKotlinClass(PacketPhysEntityRemove.class));
    }

    @JvmName(name="a")
    public final SimplePacketNetworking a() {
        return this.b;
    }

    @JvmName(name="b")
    public final fa_0 b() {
        return this.c;
    }

    @JvmName(name="c")
    public final fa_0 c() {
        return this.d;
    }

    @JvmName(name="d")
    public final fa_0 d() {
        return this.e;
    }

    @Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\n\u0010\tR(\u0010\u0005\u001a\u00020\u00028\u0007@\u0007X\u0087.\u00a2\u0006\u0018\n\u0004\b\u0003\u0010\u0004\u0012\u0004\b\b\u0010\t\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0005\u0010\u0007"}, d2={"Lorg/valkyrienskies/core/impl/shadow/Fb$a;", "", "Lorg/valkyrienskies/core/impl/shadow/Fb;", "f", "Lorg/valkyrienskies/core/impl/shadow/Fb;", "a", "()Lorg/valkyrienskies/core/impl/shadow/Fb;", "(Lorg/valkyrienskies/core/impl/shadow/Fb;)V", "b", "()V", "<init>"})
    public static final class a {
        private a() {
        }

        @JvmName(name="a")
        public static fb_0 a() {
            fb_0 fb_02 = Fb.f;
            if (fb_02 != null) {
                return fb_02;
            }
            Intrinsics.throwUninitializedPropertyAccessException((String)"");
            return null;
        }

        @JvmName(name="a")
        public static void a(fb_0 fb_02) {
            Intrinsics.checkNotNullParameter((Object)fb_02, (String)"");
            Fb.f = fb_02;
        }

        @Deprecated(message="global state")
        private static /* synthetic */ void b() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }
}

