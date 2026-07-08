/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.common.collect.ImmutableList
 *  com.google.common.collect.ImmutableSet
 *  io.netty.buffer.ByteBuf
 *  io.netty.buffer.Unpooled
 *  it.unimi.dsi.fastutil.longs.Long2ObjectMap
 *  kotlin.Metadata
 *  kotlin.collections.CollectionsKt
 *  kotlin.jvm.JvmName
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.PropertyReference1
 *  kotlin.jvm.internal.PropertyReference1Impl
 *  kotlin.jvm.internal.Reflection
 *  kotlin.reflect.KProperty
 */
package org.valkyrienskies.core.impl.shadow;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import it.unimi.dsi.fastutil.longs.Long2ObjectMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import org.apache.logging.log4j.Logger;
import org.joml.primitives.AABBi;
import org.joml.primitives.AABBic;
import org.valkyrienskies.core.impl.api.ServerShipInternal;
import org.valkyrienskies.core.impl.shadow.EO;
import org.valkyrienskies.core.impl.shadow.FA;
import org.valkyrienskies.core.impl.shadow.FD;
import org.valkyrienskies.core.impl.shadow.FH;
import org.valkyrienskies.core.impl.shadow.FW;
import org.valkyrienskies.core.impl.shadow.er_0;
import org.valkyrienskies.core.impl.shadow.ez_0;
import org.valkyrienskies.core.impl.shadow.fa_0;
import org.valkyrienskies.core.impl.shadow.fb_0;
import org.valkyrienskies.core.impl.shadow.fi_0;
import org.valkyrienskies.core.impl.shadow.hc_0;
import org.valkyrienskies.core.internal.physics.PhysicsEntityServer;
import org.valkyrienskies.core.internal.world.VsiPlayer;
import org.valkyrienskies.core.util.VSCoreUtilKt;

@Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u00052\u00020\u0001:\u0001\u0005B!\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0013\u0012\u0006\u0010\u0015\u001a\u00020\u0007\u0012\u0006\u0010\u0016\u001a\u00020\u0010\u00a2\u0006\u0004\b\u0017\u0010\u0018J\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0005\u001a\u00020\u00078\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\b\u0010\tR\"\u0010\r\u001a\u00020\n8\u0007@\u0007X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u0005\u0010\u000fR\u0014\u0010\b\u001a\u00020\u00108\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0011\u001a\u00020\u00138\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u0014"}, d2={"Lorg/valkyrienskies/core/impl/shadow/FF;", "", "Lorg/valkyrienskies/core/impl/shadow/FH;", "p0", "", "a", "(Lorg/valkyrienskies/core/impl/shadow/FH;)V", "Lorg/valkyrienskies/core/impl/shadow/Fi;", "c", "Lorg/valkyrienskies/core/impl/shadow/Fi;", "", "e", "Z", "b", "()Z", "(Z)V", "Lorg/valkyrienskies/core/impl/shadow/Fb;", "d", "Lorg/valkyrienskies/core/impl/shadow/Fb;", "Lorg/valkyrienskies/core/impl/shadow/Er;", "Lorg/valkyrienskies/core/impl/shadow/Er;", "p1", "p2", "<init>", "(Lorg/valkyrienskies/core/impl/shadow/Er;Lorg/valkyrienskies/core/impl/shadow/Fi;Lorg/valkyrienskies/core/impl/shadow/Fb;)V"})
public final class FF {
    public static final a a = new a(null);
    private final er_0 b;
    private final fi_0 c;
    private final fb_0 d;
    private boolean e;
    private static int f = 128;
    private static int g = 48;
    private static final Logger h = FW.a(a, org.valkyrienskies.core.impl.shadow.FF$a.a[0]);

    @Inject
    public FF(er_0 er_02, fi_0 fi_02, fb_0 fb_02) {
        Intrinsics.checkNotNullParameter((Object)er_02, (String)"");
        Intrinsics.checkNotNullParameter((Object)fi_02, (String)"");
        Intrinsics.checkNotNullParameter((Object)fb_02, (String)"");
        this.b = er_02;
        this.c = fi_02;
        this.d = fb_02;
        this.e = true;
    }

    @JvmName(name="b")
    private boolean b() {
        return this.e;
    }

    @JvmName(name="a")
    private void a(boolean bl) {
        this.e = bl;
    }

    public final void a(FH fH) {
        Object object;
        ByteBuf byteBuf;
        VsiPlayer vsiPlayer;
        Object object2;
        Intrinsics.checkNotNullParameter((Object)fH, (String)"");
        boolean bl = this.e = !this.e;
        if (this.e) {
            return;
        }
        Iterator iterator2 = this.b;
        iterator2 = ((er_0)((Object)iterator2)).c;
        iterator2 = ((ez_0)((Object)iterator2)).a;
        iterator2 = (Map)((EO)((Object)iterator2)).g;
        for (ImmutableSet immutableSet : iterator2.entrySet()) {
            object2 = immutableSet;
            object2 = immutableSet;
            vsiPlayer = (VsiPlayer)immutableSet.getKey();
            object2 = (ImmutableSet)object2.getValue();
            byteBuf = Unpooled.buffer();
            object = this.c;
            if (((fi_0)object).e) {
                Intrinsics.checkNotNullExpressionValue((Object)object2, (String)"");
                object2 = CollectionsKt.chunked((Iterable)((Iterable)object2), (int)3);
                object2 = object2.iterator();
                while (object2.hasNext()) {
                    object = object2.next();
                    object = (List)object;
                    FF.a(byteBuf, fH, this, vsiPlayer, (List<? extends ServerShipInternal>)object);
                }
                continue;
            }
            ImmutableList immutableList = object2.asList();
            Intrinsics.checkNotNullExpressionValue((Object)immutableList, (String)"");
            FF.a(byteBuf, fH, this, vsiPlayer, (List)immutableList);
        }
        iterator2 = this.b;
        iterator2 = ((er_0)((Object)iterator2)).c;
        iterator2 = ((ez_0)((Object)iterator2)).a;
        iterator2 = (Map)((EO)((Object)iterator2)).h;
        for (Map.Entry entry : iterator2.entrySet()) {
            object2 = entry;
            object2 = entry;
            vsiPlayer = (VsiPlayer)entry.getKey();
            object2 = (ImmutableSet)object2.getValue();
            byteBuf = Unpooled.buffer();
            object = this.c;
            if (((fi_0)object).e) {
                Intrinsics.checkNotNullExpressionValue((Object)object2, (String)"");
                object2 = CollectionsKt.chunked((Iterable)((Iterable)object2), (int)10);
                object2 = object2.iterator();
                while (object2.hasNext()) {
                    object = object2.next();
                    object = (List)object;
                    FF.b(byteBuf, fH, this, vsiPlayer, (List<PhysicsEntityServer>)object);
                }
                continue;
            }
            ImmutableList immutableList = object2.asList();
            Intrinsics.checkNotNullExpressionValue((Object)immutableList, (String)"");
            FF.b(byteBuf, fH, this, vsiPlayer, (List)immutableList);
        }
    }

    private static final void a(ByteBuf byteBuf, FH object, FF fF, VsiPlayer vsiPlayer, List<? extends ServerShipInternal> list) {
        byteBuf.clear();
        try {
            Intrinsics.checkNotNullExpressionValue((Object)byteBuf, (String)"");
            org.valkyrienskies.core.impl.shadow.FF$a.a(byteBuf, list, (FH)object);
        }
        catch (Exception exception) {
            org.valkyrienskies.core.impl.shadow.FF$a.a(a).error(exception);
        }
        object = fF.d;
        fa_0 fa_02 = ((fb_0)object).d;
        Intrinsics.checkNotNullExpressionValue((Object)byteBuf, (String)"");
        Intrinsics.checkNotNullExpressionValue((Object)vsiPlayer, (String)"");
        fa_02.a(byteBuf, vsiPlayer);
    }

    private static final void b(ByteBuf byteBuf, FH object, FF fF, VsiPlayer vsiPlayer, List<PhysicsEntityServer> list) {
        byteBuf.clear();
        Intrinsics.checkNotNullExpressionValue((Object)byteBuf, (String)"");
        org.valkyrienskies.core.impl.shadow.FF$a.b(byteBuf, list, (FH)object);
        object = fF.d;
        fa_0 fa_02 = ((fb_0)object).e;
        Intrinsics.checkNotNullExpressionValue((Object)vsiPlayer, (String)"");
        fa_02.a(byteBuf, vsiPlayer);
    }

    @Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0017\u0010\u0018J+\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\b\u001a\u00020\u0007\u00a2\u0006\u0004\b\n\u0010\u000bJ+\u0010\r\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\f0\u00042\u0006\u0010\b\u001a\u00020\u0007\u00a2\u0006\u0004\b\r\u0010\u000bR\u0014\u0010\n\u001a\u00020\u000e8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0014\u0010\r\u001a\u00020\u000e8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0010R\u001b\u0010\u0016\u001a\u00020\u00128CX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\n\u0010\u0015"}, d2={"Lorg/valkyrienskies/core/impl/shadow/FF$a;", "", "Lio/netty/buffer/ByteBuf;", "p0", "", "Lorg/valkyrienskies/core/impl/api/ServerShipInternal;", "p1", "Lorg/valkyrienskies/core/impl/shadow/FH;", "p2", "", "a", "(Lio/netty/buffer/ByteBuf;Ljava/util/List;Lorg/valkyrienskies/core/impl/shadow/FH;)V", "Lorg/valkyrienskies/core/internal/physics/PhysicsEntityServer;", "b", "", "g", "I", "f", "Lorg/apache/logging/log4j/Logger;", "i", "Lorg/apache/logging/log4j/Logger;", "()Lorg/apache/logging/log4j/Logger;", "c", "<init>", "()V"})
    public static final class a {
        static final /* synthetic */ KProperty<Object>[] a;

        private a() {
        }

        public static void a(ByteBuf byteBuf, List<? extends ServerShipInternal> object, FH object2) {
            Intrinsics.checkNotNullParameter((Object)byteBuf, (String)"");
            Intrinsics.checkNotNullParameter(object, (String)"");
            Intrinsics.checkNotNullParameter((Object)object2, (String)"");
            Object object3 = object2;
            Long2ObjectMap<? extends FA> long2ObjectMap = ((FH)object3).a;
            object3 = object2;
            byteBuf.writeInt(((FH)object3).b);
            object = (Iterable)object;
            object = object.iterator();
            while (object.hasNext()) {
                object2 = object.next();
                object3 = (FA)long2ObjectMap.get((object2 = (ServerShipInternal)object2).getId());
                if (object3 == null) continue;
                Intrinsics.checkNotNullExpressionValue((Object)object3, (String)"");
                object3 = FD.a.a((FA)object3, (ServerShipInternal)object2);
                byteBuf.writeLong(object2.getId());
                VSCoreUtilKt.writeVec3d(byteBuf, object3.getPositionInModel());
                VSCoreUtilKt.writeVec3AsFloat(byteBuf, object3.getScaling());
                VSCoreUtilKt.writeNormQuatdAs3F(byteBuf, object3.getRotation());
                VSCoreUtilKt.writeVec3d(byteBuf, object3.getPosition());
                VSCoreUtilKt.writeVec3AsFloat(byteBuf, object2.getVelocity());
                VSCoreUtilKt.writeVec3AsFloat(byteBuf, object2.getAngularVelocity());
                AABBic aABBic = object2.getShipAABB();
                if (aABBic == null) {
                    aABBic = new AABBi(Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE);
                }
                object2 = aABBic;
                VSCoreUtilKt.writeAABBi(byteBuf, (AABBic)object2);
            }
        }

        public static void b(ByteBuf byteBuf, List<PhysicsEntityServer> object, FH object2) {
            Intrinsics.checkNotNullParameter((Object)byteBuf, (String)"");
            Intrinsics.checkNotNullParameter(object, (String)"");
            Intrinsics.checkNotNullParameter((Object)object2, (String)"");
            Object object3 = object2;
            Long2ObjectMap<? extends FA> long2ObjectMap = ((FH)object3).a;
            object3 = object2;
            byteBuf.writeInt(((FH)object3).b);
            object = (Iterable)object;
            object = object.iterator();
            while (object.hasNext()) {
                object2 = object.next();
                Object object4 = (FA)long2ObjectMap.get(((PhysicsEntityServer)(object2 = (PhysicsEntityServer)object2)).getId());
                if (object4 == null) continue;
                Intrinsics.checkNotNullExpressionValue((Object)object4, (String)"");
                FA fA = object4;
                object3 = fA;
                object4 = fA.a;
                byteBuf.writeLong(((PhysicsEntityServer)object2).getId());
                object3 = object4;
                VSCoreUtilKt.writeVec3d(byteBuf, ((hc_0)object3).b);
                object3 = object4;
                VSCoreUtilKt.writeNormQuatdAs3F(byteBuf, ((hc_0)object3).c);
                object3 = fA;
                byteBuf.writeFloat((float)((FA)object3).c);
            }
        }

        @JvmName(name="a")
        private final Logger a() {
            KProperty<Object> kProperty = a[0];
            Logger logger = h;
            Intrinsics.checkNotNullParameter(kProperty, (String)"");
            return logger;
        }

        public static final /* synthetic */ Logger a(a object) {
            KProperty<Object> kProperty = a[0];
            object = h;
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

