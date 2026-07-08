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
import org.joml.Vector3dc;
import org.joml.Vector3ic;
import org.joml.primitives.AABBic;
import org.valkyrienskies.core.impl.shadow.GP;
import org.valkyrienskies.core.impl.shadow.GQ;
import org.valkyrienskies.core.impl.shadow.GR;
import org.valkyrienskies.core.impl.shadow.GT;
import org.valkyrienskies.core.impl.shadow.GU;
import org.valkyrienskies.core.impl.shadow.HC;
import org.valkyrienskies.core.impl.shadow.HD;
import org.valkyrienskies.core.impl.shadow.hg_0;
import org.valkyrienskies.core.impl.shadow.hl_0;
import org.valkyrienskies.core.impl.shadow.hm_0;
import org.valkyrienskies.core.impl.shadow.hn_0;
import org.valkyrienskies.core.impl.shadow.ho_0;
import org.valkyrienskies.core.impl.shadow.hq_0;
import org.valkyrienskies.core.impl.shadow.hw_0;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.Hp
 */
@Metadata(mv={1, 6, 0}, k=1, xi=48, d1={"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a2\u0006\u0004\b\u0005\u0010\u0006J\u001f\u0010\u0005\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\u0016\u00a2\u0006\u0004\b\u0005\u0010\nJ\u000f\u0010\u0005\u001a\u00020\u000bH\u0016\u00a2\u0006\u0004\b\u0005\u0010\fJ\u0017\u0010\u0005\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u0007H\u0016\u00a2\u0006\u0004\b\u0005\u0010\u000eJ/\u0010\u0005\u001a\u00020\u00142\u0006\u0010\u0003\u001a\u00020\u000f2\u0006\u0010\b\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u0012H\u0016\u00a2\u0006\u0004\b\u0005\u0010\u0015J'\u0010\u0005\u001a\u00020\u00172\u0006\u0010\u0003\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u0016H\u0016\u00a2\u0006\u0004\b\u0005\u0010\u0018"}, d2={"Lorg/valkyrienskies/core/impl/shadow/Hp;", "Lorg/valkyrienskies/core/impl/shadow/GR;", "Lorg/joml/Vector3dc;", "p0", "Lorg/valkyrienskies/core/impl/shadow/GP;", "a", "(Lorg/joml/Vector3dc;)Lorg/valkyrienskies/core/impl/shadow/GP;", "", "p1", "Lorg/valkyrienskies/core/impl/shadow/GQ;", "(DD)Lorg/valkyrienskies/core/impl/shadow/GQ;", "Lorg/valkyrienskies/core/impl/shadow/GT;", "()Lorg/valkyrienskies/core/impl/shadow/GT;", "Lorg/valkyrienskies/core/impl/shadow/Hg;", "(D)Lorg/valkyrienskies/core/impl/shadow/Hg;", "Lorg/joml/Vector3ic;", "Lorg/joml/primitives/AABBic;", "p2", "Lorg/valkyrienskies/core/impl/shadow/GU;", "p3", "Lorg/valkyrienskies/core/impl/shadow/Hl;", "(Lorg/joml/Vector3ic;Lorg/joml/Vector3ic;Lorg/joml/primitives/AABBic;Lorg/valkyrienskies/core/impl/shadow/GU;)Lorg/valkyrienskies/core/impl/shadow/Hl;", "", "Lorg/valkyrienskies/core/impl/shadow/Hm;", "(DDI)Lorg/valkyrienskies/core/impl/shadow/Hm;", "<init>", "()V"})
public final class hp_0
implements GR {
    public static final hp_0 INSTANCE = new hp_0();

    private hp_0() {
    }

    @Override
    public final hl_0 a(Vector3ic vector3ic, Vector3ic vector3ic2, AABBic aABBic, GU gU) {
        Intrinsics.checkNotNullParameter((Object)vector3ic, (String)"");
        Intrinsics.checkNotNullParameter((Object)vector3ic2, (String)"");
        Intrinsics.checkNotNullParameter((Object)aABBic, (String)"");
        Intrinsics.checkNotNullParameter((Object)gU, (String)"");
        return new HC(vector3ic, vector3ic2, aABBic, gU, false, 0, null, 112, null);
    }

    @Override
    public final GQ a(double d2, double d3) {
        return new ho_0(d2, d3);
    }

    @Override
    public final hm_0 a(double d2, double d3, int n2) {
        return new HD(d2, d3, n2);
    }

    @Override
    public final hg_0 a(double d2) {
        return new hw_0(d2);
    }

    @Override
    public final GP a(Vector3dc vector3dc) {
        Intrinsics.checkNotNullParameter((Object)vector3dc, (String)"");
        return new hn_0(vector3dc);
    }

    @Override
    public final GT a() {
        return new hq_0();
    }
}

