/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 */
package org.valkyrienskies.core.impl.shadow;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.valkyrienskies.core.impl.shadow.GZ;
import org.valkyrienskies.core.impl.shadow.II;
import org.valkyrienskies.core.impl.shadow.IM;
import org.valkyrienskies.core.impl.shadow.Is;
import org.valkyrienskies.core.impl.shadow.Iw;
import org.valkyrienskies.core.impl.shadow.ha_0;
import org.valkyrienskies.core.impl.shadow.hk_0;
import org.valkyrienskies.physics_api_krunch.KrunchNativePhysicsThreadPoolReference;
import org.valkyrienskies.physics_api_krunch.KrunchNativePhysicsWorldReference;

@Metadata(mv={1, 6, 0}, k=1, xi=48, d1={"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0015\u0010\rJ\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006J\u0015\u0010\u0005\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\u0004\b\u0005\u0010\bJ\r\u0010\n\u001a\u00020\t\u00a2\u0006\u0004\b\n\u0010\u000bJ\r\u0010\u0005\u001a\u00020\f\u00a2\u0006\u0004\b\u0005\u0010\rJ\u0015\u0010\u0005\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u000e\u00a2\u0006\u0004\b\u0005\u0010\u000fJ\u001d\u0010\u0005\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u0010\u00a2\u0006\u0004\b\u0005\u0010\u0012R\u0016\u0010\u0005\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\n\u0010\u0014"}, d2={"Lorg/valkyrienskies/core/impl/shadow/It;", "", "", "p0", "Lorg/valkyrienskies/core/impl/shadow/GZ;", "a", "(I)Lorg/valkyrienskies/core/impl/shadow/GZ;", "Lorg/valkyrienskies/core/impl/shadow/Ha;", "(Lorg/valkyrienskies/core/impl/shadow/GZ;)Lorg/valkyrienskies/core/impl/shadow/Ha;", "Lorg/valkyrienskies/core/impl/shadow/Hk;", "b", "()Lorg/valkyrienskies/core/impl/shadow/Hk;", "", "()V", "", "(Ljava/lang/String;)V", "Lorg/valkyrienskies/core/impl/shadow/Iw;", "p1", "(Lorg/valkyrienskies/core/impl/shadow/Ha;Lorg/valkyrienskies/core/impl/shadow/Iw;)V", "", "Z", "<init>"})
public final class It {
    public static final It INSTANCE = new It();
    private static boolean b;

    private It() {
    }

    public static GZ a(int n2) {
        if (!b) {
            throw new Is();
        }
        return new KrunchNativePhysicsThreadPoolReference(n2);
    }

    public static ha_0 a(GZ gZ) {
        Intrinsics.checkNotNullParameter((Object)gZ, (String)"");
        if (!b) {
            throw new Is();
        }
        return (ha_0)((Object)new KrunchNativePhysicsWorldReference((KrunchNativePhysicsThreadPoolReference)gZ));
    }

    public static void a(ha_0 ha_02, Iw iw) {
        Intrinsics.checkNotNullParameter((Object)ha_02, (String)"");
        Intrinsics.checkNotNullParameter((Object)iw, (String)"");
        KrunchNativePhysicsWorldReference cfr_ignored_0 = (KrunchNativePhysicsWorldReference)((Object)ha_02);
        ((KrunchNativePhysicsWorldReference)((Object)ha_02)).a(iw);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Converted monitor instructions to comments
     * Lifted jumps to return sites
     */
    public static void a() {
        if (b) {
            return;
        }
        IM iM = new IM();
        String string = "KrunchJni";
        if (!IM.a) {
            Class<IM> clazz = IM.class;
            // MONITORENTER : org.valkyrienskies.core.impl.shadow.IM.class
            if (IM.e(string)) {
                // MONITOREXIT : clazz
            } else {
                String string2 = IM.a(string);
                System.out.println("KrunchPhysicsAPISharedLibraryLoader loading library " + string);
                try {
                    if (IM.b) {
                        System.loadLibrary(string2);
                    } else {
                        iM.c(string2);
                    }
                    IM.d(string);
                }
                catch (Throwable throwable) {
                    String string3;
                    StringBuilder stringBuilder = new StringBuilder("Couldn't load shared library '").append(string2).append("' for target: ").append(System.getProperty("os.name"));
                    if (IM.c) {
                        string3 = ", 64-bit";
                        throw new RuntimeException(stringBuilder.append(string3).toString(), throwable);
                    }
                    string3 = ", 32-bit";
                    throw new RuntimeException(stringBuilder.append(string3).toString(), throwable);
                }
            }
        }
        b = true;
    }

    public static void a(String string) {
        Intrinsics.checkNotNullParameter((Object)string, (String)"");
        if (b) {
            return;
        }
        System.load(string);
        b = true;
    }

    public static hk_0 b() {
        return II.INSTANCE;
    }
}

