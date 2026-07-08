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
import org.valkyrienskies.core.impl.shadow.GU;
import org.valkyrienskies.core.impl.shadow.GV;
import org.valkyrienskies.core.impl.shadow.hi_0;
import org.valkyrienskies.physics_api_krunch.voxel.KrunchLod1BlockRegistry;

@Metadata(mv={1, 6, 0}, k=1, xi=48, d1={"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c0\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u0016\u00a2\u0006\u0004\b\u0005\u0010\u0006"}, d2={"Lorg/valkyrienskies/core/impl/shadow/IG;", "Lorg/valkyrienskies/core/impl/shadow/GV;", "Lorg/valkyrienskies/physics_api_krunch/voxel/KrunchLod1BlockRegistry;", "Lorg/valkyrienskies/core/impl/shadow/Hi;", "p0", "b", "(Lorg/valkyrienskies/core/impl/shadow/Hi;)Lorg/valkyrienskies/physics_api_krunch/voxel/KrunchLod1BlockRegistry;", "<init>", "()V"})
public final class IG
implements GV<KrunchLod1BlockRegistry> {
    public static final IG INSTANCE = new IG();

    private IG() {
    }

    private static KrunchLod1BlockRegistry b(hi_0 hi_02) {
        Intrinsics.checkNotNullParameter((Object)hi_02, (String)"");
        return new KrunchLod1BlockRegistry(hi_02);
    }

    @Override
    public final /* synthetic */ GU a(hi_0 hi_02) {
        Intrinsics.checkNotNullParameter((Object)hi_02, (String)"");
        return new KrunchLod1BlockRegistry(hi_02);
    }
}

