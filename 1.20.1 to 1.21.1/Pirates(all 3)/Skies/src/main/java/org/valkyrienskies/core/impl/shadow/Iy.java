/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import org.valkyrienskies.core.impl.shadow.It;
import org.valkyrienskies.physics_api_krunch.KrunchNativePhysicsThreadPoolReference;
import org.valkyrienskies.physics_api_krunch.KrunchNativePhysicsWorldReference;

public final class Iy {
    private static void a() {
        It.INSTANCE.a();
        new KrunchNativePhysicsWorldReference(new KrunchNativePhysicsThreadPoolReference(1));
    }

    private static /* synthetic */ void b() {
        It.INSTANCE.a();
        new KrunchNativePhysicsWorldReference(new KrunchNativePhysicsThreadPoolReference(1));
    }
}

