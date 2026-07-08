/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.internal.Intrinsics
 */
package org.valkyrienskies.core.impl.bodies.properties;

import java.io.DataInput;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.joml.Quaterniond;
import org.joml.Quaterniondc;
import org.joml.Vector3d;
import org.joml.Vector3dc;
import org.valkyrienskies.core.api.bodies.properties.BodyTransform;
import org.valkyrienskies.core.api.ships.properties.ShipTransform;
import org.valkyrienskies.core.impl.bodies.properties.BodyTransformBuilderImpl;
import org.valkyrienskies.core.impl.bodies.properties.BodyTransformImpl;

@Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0006\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b \u0010!J(\u0010\b\u001a\u00020\u00072\u0017\u0010\u0006\u001a\u0013\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002\u00a2\u0006\u0002\b\u0005H\u0016\u00a2\u0006\u0004\b\b\u0010\tJ/\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\nH\u0016\u00a2\u0006\u0004\b\u0011\u0010\u0012J'\u0010\u0017\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u00072\u0006\u0010\u0016\u001a\u00020\u0015H\u0016\u00a2\u0006\u0004\b\u0017\u0010\u0018J\u000f\u0010\u0019\u001a\u00020\u0003H\u0016\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\u0017\u0010\u0019\u001a\u00020\u00032\u0006\u0010\u001b\u001a\u00020\u0007H\u0016\u00a2\u0006\u0004\b\u0019\u0010\u001cJ\u0017\u0010\u001e\u001a\u00020\u00102\u0006\u0010\u001b\u001a\u00020\u001dH\u0016\u00a2\u0006\u0004\b\u001e\u0010\u001f"}, d2={"Lorg/valkyrienskies/core/impl/bodies/properties/BodyTransformFactory;", "Lorg/valkyrienskies/core/api/bodies/properties/BodyTransform$Factory;", "Lkotlin/Function1;", "Lorg/valkyrienskies/core/api/bodies/properties/BodyTransform$Builder;", "", "Lkotlin/ExtensionFunctionType;", "builder", "Lorg/valkyrienskies/core/api/bodies/properties/BodyTransform;", "build", "(Lkotlin/jvm/functions/Function1;)Lorg/valkyrienskies/core/api/bodies/properties/BodyTransform;", "Lorg/joml/Vector3dc;", "position", "Lorg/joml/Quaterniondc;", "rotation", "scaling", "positionInModel", "Lorg/valkyrienskies/core/api/ships/properties/ShipTransform;", "create", "(Lorg/joml/Vector3dc;Lorg/joml/Quaterniondc;Lorg/joml/Vector3dc;Lorg/joml/Vector3dc;)Lorg/valkyrienskies/core/api/ships/properties/ShipTransform;", "previous", "current", "", "alpha", "createFromSlerp", "(Lorg/valkyrienskies/core/api/bodies/properties/BodyTransform;Lorg/valkyrienskies/core/api/bodies/properties/BodyTransform;D)Lorg/valkyrienskies/core/api/ships/properties/ShipTransform;", "newBuilder", "()Lorg/valkyrienskies/core/api/bodies/properties/BodyTransform$Builder;", "from", "(Lorg/valkyrienskies/core/api/bodies/properties/BodyTransform;)Lorg/valkyrienskies/core/api/bodies/properties/BodyTransform$Builder;", "Ljava/io/DataInput;", "readFrom", "(Ljava/io/DataInput;)Lorg/valkyrienskies/core/api/ships/properties/ShipTransform;", "<init>", "()V"})
public final class BodyTransformFactory
implements BodyTransform.Factory {
    public static final BodyTransformFactory INSTANCE = new BodyTransformFactory();

    private BodyTransformFactory() {
    }

    @Override
    public final BodyTransform.Builder newBuilder() {
        return new BodyTransformBuilderImpl(null, null, null, null, 15, null);
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public final BodyTransform.Builder newBuilder(BodyTransform from) {
        void var1_1;
        Intrinsics.checkNotNullParameter((Object)from, (String)"");
        return this.newBuilder().from((BodyTransform)var1_1);
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public final ShipTransform readFrom(DataInput from) {
        void var1_1;
        Intrinsics.checkNotNullParameter((Object)from, (String)"");
        return this.create(new Vector3d(from.readDouble(), from.readDouble(), from.readDouble()), new Quaterniond(from.readDouble(), from.readDouble(), from.readDouble(), from.readDouble()), new Vector3d(from.readDouble(), from.readDouble(), from.readDouble()), new Vector3d(from.readDouble(), from.readDouble(), var1_1.readDouble()));
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public final ShipTransform create(Vector3dc position, Quaterniondc rotation, Vector3dc scaling, Vector3dc positionInModel) {
        void var3_3;
        void var2_2;
        void var1_1;
        Intrinsics.checkNotNullParameter((Object)position, (String)"");
        Intrinsics.checkNotNullParameter((Object)rotation, (String)"");
        Intrinsics.checkNotNullParameter((Object)scaling, (String)"");
        Intrinsics.checkNotNullParameter((Object)positionInModel, (String)"");
        return new BodyTransformImpl((Vector3dc)var1_1, (Quaterniondc)var2_2, (Vector3dc)var3_3, positionInModel);
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public final ShipTransform createFromSlerp(BodyTransform previous, BodyTransform current, double alpha) {
        void var3_3;
        void var2_2;
        Vector3d vector3d;
        Intrinsics.checkNotNullParameter((Object)previous, (String)"");
        Intrinsics.checkNotNullParameter((Object)current, (String)"");
        Vector3dc vector3dc = current.getPositionInModel();
        Vector3d vector3d2 = current.getPositionInModel().sub(previous.getPositionInModel(), new Vector3d());
        vector3d2 = previous.getToWorld().transformDirection(vector3d2, new Vector3d()).add(previous.getPosition());
        vector3d2 = vector3d2.lerp(current.getPosition(), alpha, new Vector3d());
        Quaterniond quaterniond = previous.getRotation().slerp(current.getRotation(), alpha, new Quaterniond()).normalize();
        vector3d = vector3d.getScaling().lerp(var2_2.getScaling(), (double)var3_3, new Vector3d());
        Intrinsics.checkNotNullExpressionValue((Object)vector3d2, (String)"");
        Vector3dc vector3dc2 = vector3d2;
        Intrinsics.checkNotNullExpressionValue((Object)quaterniond, (String)"");
        Quaterniondc quaterniondc = quaterniond;
        Intrinsics.checkNotNullExpressionValue((Object)vector3d, (String)"");
        return this.create(vector3dc2, quaterniondc, vector3d, vector3dc);
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public final BodyTransform build(Function1<? super BodyTransform.Builder, Unit> builder) {
        void var1_1;
        Intrinsics.checkNotNullParameter(builder, (String)"");
        BodyTransform.Builder builder2 = this.newBuilder();
        var1_1.invoke((Object)builder2);
        return builder2.build();
    }
}

