/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 */
package org.valkyrienskies.core.impl.shadow;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.databind.module.SimpleModule;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.joml.Matrix3d;
import org.joml.Matrix3dc;
import org.joml.Matrix3f;
import org.joml.Matrix3fc;
import org.joml.Matrix4d;
import org.joml.Matrix4dc;
import org.joml.Matrix4f;
import org.joml.Matrix4fc;
import org.joml.Quaterniond;
import org.joml.Quaterniondc;
import org.joml.Quaternionf;
import org.joml.Quaternionfc;
import org.joml.Vector2d;
import org.joml.Vector2dc;
import org.joml.Vector2f;
import org.joml.Vector2fc;
import org.joml.Vector2i;
import org.joml.Vector2ic;
import org.joml.Vector3d;
import org.joml.Vector3dc;
import org.joml.Vector3f;
import org.joml.Vector3fc;
import org.joml.Vector3i;
import org.joml.Vector3ic;
import org.joml.primitives.AABBd;
import org.joml.primitives.AABBdc;
import org.joml.primitives.AABBf;
import org.joml.primitives.AABBfc;
import org.joml.primitives.AABBi;
import org.joml.primitives.AABBic;
import org.valkyrienskies.core.api.ships.properties.ShipInertiaData;
import org.valkyrienskies.core.impl.game.ships.ShipInertiaDataImpl;

public final class GB
extends SimpleModule {
    public GB() {
        GB gB = this;
        SimpleModule simpleModule = gB;
        Intrinsics.checkNotNullExpressionValue((Object)simpleModule.addAbstractTypeMapping(Vector2ic.class, Vector2i.class), (String)"");
        simpleModule = gB;
        Intrinsics.checkNotNullExpressionValue((Object)simpleModule.setMixInAnnotation(Vector2i.class, a.class), (String)"");
        gB = this;
        simpleModule = gB;
        Intrinsics.checkNotNullExpressionValue((Object)simpleModule.addAbstractTypeMapping(Vector2fc.class, Vector2f.class), (String)"");
        simpleModule = gB;
        Intrinsics.checkNotNullExpressionValue((Object)simpleModule.setMixInAnnotation(Vector2f.class, a.class), (String)"");
        gB = this;
        simpleModule = gB;
        Intrinsics.checkNotNullExpressionValue((Object)simpleModule.addAbstractTypeMapping(Vector2dc.class, Vector2d.class), (String)"");
        simpleModule = gB;
        Intrinsics.checkNotNullExpressionValue((Object)simpleModule.setMixInAnnotation(Vector2d.class, a.class), (String)"");
        gB = this;
        simpleModule = gB;
        Intrinsics.checkNotNullExpressionValue((Object)simpleModule.addAbstractTypeMapping(Vector3ic.class, Vector3i.class), (String)"");
        simpleModule = gB;
        Intrinsics.checkNotNullExpressionValue((Object)simpleModule.setMixInAnnotation(Vector3i.class, a.class), (String)"");
        gB = this;
        simpleModule = gB;
        Intrinsics.checkNotNullExpressionValue((Object)simpleModule.addAbstractTypeMapping(Vector3fc.class, Vector3f.class), (String)"");
        simpleModule = gB;
        Intrinsics.checkNotNullExpressionValue((Object)simpleModule.setMixInAnnotation(Vector3f.class, a.class), (String)"");
        gB = this;
        simpleModule = gB;
        Intrinsics.checkNotNullExpressionValue((Object)simpleModule.addAbstractTypeMapping(Vector3dc.class, Vector3d.class), (String)"");
        simpleModule = gB;
        Intrinsics.checkNotNullExpressionValue((Object)simpleModule.setMixInAnnotation(Vector3d.class, a.class), (String)"");
        gB = this;
        simpleModule = gB;
        Intrinsics.checkNotNullExpressionValue((Object)simpleModule.addAbstractTypeMapping(Quaternionfc.class, Quaternionf.class), (String)"");
        simpleModule = gB;
        Intrinsics.checkNotNullExpressionValue((Object)simpleModule.setMixInAnnotation(Quaternionf.class, a.class), (String)"");
        gB = this;
        simpleModule = gB;
        Intrinsics.checkNotNullExpressionValue((Object)simpleModule.addAbstractTypeMapping(Quaterniondc.class, Quaterniond.class), (String)"");
        simpleModule = gB;
        Intrinsics.checkNotNullExpressionValue((Object)simpleModule.setMixInAnnotation(Quaterniond.class, a.class), (String)"");
        gB = this;
        simpleModule = gB;
        Intrinsics.checkNotNullExpressionValue((Object)simpleModule.addAbstractTypeMapping(Matrix4fc.class, Matrix4f.class), (String)"");
        simpleModule = gB;
        Intrinsics.checkNotNullExpressionValue((Object)simpleModule.setMixInAnnotation(Matrix4f.class, a.class), (String)"");
        gB = this;
        simpleModule = gB;
        Intrinsics.checkNotNullExpressionValue((Object)simpleModule.addAbstractTypeMapping(Matrix4dc.class, Matrix4d.class), (String)"");
        simpleModule = gB;
        Intrinsics.checkNotNullExpressionValue((Object)simpleModule.setMixInAnnotation(Matrix4d.class, a.class), (String)"");
        gB = this;
        simpleModule = gB;
        Intrinsics.checkNotNullExpressionValue((Object)simpleModule.addAbstractTypeMapping(Matrix3fc.class, Matrix3f.class), (String)"");
        simpleModule = gB;
        Intrinsics.checkNotNullExpressionValue((Object)simpleModule.setMixInAnnotation(Matrix3f.class, a.class), (String)"");
        gB = this;
        simpleModule = gB;
        Intrinsics.checkNotNullExpressionValue((Object)simpleModule.addAbstractTypeMapping(Matrix3dc.class, Matrix3d.class), (String)"");
        simpleModule = gB;
        Intrinsics.checkNotNullExpressionValue((Object)simpleModule.setMixInAnnotation(Matrix3d.class, a.class), (String)"");
        gB = this;
        simpleModule = gB;
        Intrinsics.checkNotNullExpressionValue((Object)simpleModule.addAbstractTypeMapping(AABBic.class, AABBi.class), (String)"");
        simpleModule = gB;
        Intrinsics.checkNotNullExpressionValue((Object)simpleModule.setMixInAnnotation(AABBi.class, a.class), (String)"");
        gB = this;
        simpleModule = gB;
        Intrinsics.checkNotNullExpressionValue((Object)simpleModule.addAbstractTypeMapping(AABBfc.class, AABBf.class), (String)"");
        simpleModule = gB;
        Intrinsics.checkNotNullExpressionValue((Object)simpleModule.setMixInAnnotation(AABBf.class, a.class), (String)"");
        gB = this;
        simpleModule = gB;
        Intrinsics.checkNotNullExpressionValue((Object)simpleModule.addAbstractTypeMapping(AABBdc.class, AABBd.class), (String)"");
        simpleModule = gB;
        Intrinsics.checkNotNullExpressionValue((Object)simpleModule.setMixInAnnotation(AABBd.class, a.class), (String)"");
        gB = this;
        simpleModule = gB;
        Intrinsics.checkNotNullExpressionValue((Object)simpleModule.addAbstractTypeMapping(ShipInertiaData.class, ShipInertiaDataImpl.class), (String)"");
        simpleModule = gB;
        Intrinsics.checkNotNullExpressionValue((Object)simpleModule.setMixInAnnotation(ShipInertiaDataImpl.class, a.class), (String)"");
    }

    private final /* synthetic */ <A, B extends A> void a() {
        SimpleModule simpleModule = this;
        Intrinsics.reifiedOperationMarker((int)4, (String)"A");
        Intrinsics.reifiedOperationMarker((int)4, (String)"B");
        Intrinsics.checkNotNullExpressionValue((Object)simpleModule.addAbstractTypeMapping(Object.class, Object.class), (String)"");
        simpleModule = this;
        Intrinsics.reifiedOperationMarker((int)4, (String)"B");
        Intrinsics.checkNotNullExpressionValue((Object)simpleModule.setMixInAnnotation(Object.class, a.class), (String)"");
    }

    @JsonAutoDetect(getterVisibility=JsonAutoDetect.Visibility.NONE, isGetterVisibility=JsonAutoDetect.Visibility.NONE, setterVisibility=JsonAutoDetect.Visibility.NONE, fieldVisibility=JsonAutoDetect.Visibility.ANY)
    @Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u00c3\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003"}, d2={"Lorg/valkyrienskies/core/impl/shadow/GB$a;", "", "<init>", "()V"})
    static final class a {
        public static final a INSTANCE = new a();

        private a() {
        }
    }
}

