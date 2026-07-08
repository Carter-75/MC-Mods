/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.JvmName
 */
package org.valkyrienskies.core.impl.shadow;

import kotlin.Metadata;
import kotlin.jvm.JvmName;
import org.valkyrienskies.core.impl.shadow.GR;
import org.valkyrienskies.core.impl.shadow.GV;
import org.valkyrienskies.core.impl.shadow.IF;
import org.valkyrienskies.core.impl.shadow.IG;
import org.valkyrienskies.core.impl.shadow.IH;
import org.valkyrienskies.core.impl.shadow.hj_0;
import org.valkyrienskies.core.impl.shadow.hk_0;
import org.valkyrienskies.core.impl.shadow.ih_0;
import org.valkyrienskies.physics_api_krunch.KrunchCollisionShapeFactory;

@Metadata(mv={1, 6, 0}, k=1, xi=48, d1={"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u00c0\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0005\u001a\u00020\u00028\u0017X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001e\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u00078\u0017X\u0096\u0004\u00a2\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001e\u0010\r\u001a\u0006\u0012\u0002\b\u00030\f8\u0017X\u0096\u0004\u00a2\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\r\u0010\u000fR\u001e\u0010\n\u001a\u0006\u0012\u0002\b\u00030\u00108\u0017X\u0096\u0004\u00a2\u0006\f\n\u0004\b\n\u0010\u0011\u001a\u0004\b\u0003\u0010\u0012"}, d2={"Lorg/valkyrienskies/core/impl/shadow/II;", "Lorg/valkyrienskies/core/impl/shadow/Hk;", "Lorg/valkyrienskies/core/impl/shadow/GR;", "b", "Lorg/valkyrienskies/core/impl/shadow/GR;", "a", "()Lorg/valkyrienskies/core/impl/shadow/GR;", "Lorg/valkyrienskies/core/impl/shadow/GV;", "e", "Lorg/valkyrienskies/core/impl/shadow/GV;", "d", "()Lorg/valkyrienskies/core/impl/shadow/GV;", "Lorg/valkyrienskies/core/impl/shadow/Ih;", "c", "Lorg/valkyrienskies/core/impl/shadow/Ih;", "()Lorg/valkyrienskies/core/impl/shadow/Ih;", "Lorg/valkyrienskies/core/impl/shadow/Hj;", "Lorg/valkyrienskies/core/impl/shadow/Hj;", "()Lorg/valkyrienskies/core/impl/shadow/Hj;", "<init>", "()V"})
public final class II
implements hk_0 {
    public static final II INSTANCE = new II();
    private static final GR b = new KrunchCollisionShapeFactory();
    private static final ih_0<?> c = IH.INSTANCE;
    private static final hj_0<?> d = IF.INSTANCE;
    private static final GV<?> e = IG.INSTANCE;

    private II() {
    }

    @Override
    @JvmName(name="a")
    public final GR a() {
        return b;
    }

    @Override
    @JvmName(name="c")
    public final ih_0<?> c() {
        return c;
    }

    @Override
    @JvmName(name="b")
    public final hj_0<?> b() {
        return d;
    }

    @Override
    @JvmName(name="d")
    public final GV<?> d() {
        return e;
    }
}

