/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.JvmName
 *  kotlin.jvm.internal.Intrinsics
 */
package org.valkyrienskies.core.impl.bodies.properties;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonIncludeProperties;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.Externalizable;
import java.io.InvalidObjectException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import org.joml.Matrix4d;
import org.joml.Matrix4dc;
import org.joml.Quaterniond;
import org.joml.Quaterniondc;
import org.joml.Vector3d;
import org.joml.Vector3dc;
import org.valkyrienskies.core.api.VsBeta;
import org.valkyrienskies.core.api.bodies.properties.BodyKinematics;
import org.valkyrienskies.core.api.bodies.properties.BodyTransform;
import org.valkyrienskies.core.api.ships.properties.ShipTransform;
import org.valkyrienskies.core.impl.bodies.properties.BodyKinematicsFactory;
import org.valkyrienskies.core.impl.bodies.properties.BodyTransformFactory;
import org.valkyrienskies.core.impl.util.DoNotObfuscate;

@JsonIncludeProperties(value={"position", "positionInModel", "rotation", "scaling"})
@JsonIgnoreProperties(ignoreUnknown=true)
@DoNotObfuscate
@Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003:\u00019B1\b\u0007\u0012\b\b\u0001\u0010#\u001a\u00020\u0017\u0012\b\b\u0001\u0010*\u001a\u00020)\u0012\b\b\u0001\u0010.\u001a\u00020\u0017\u0012\b\b\u0001\u0010'\u001a\u00020\u0017\u00a2\u0006\u0004\b7\u00108J\u001a\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0096\u0002\u00a2\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\n\u001a\u00020\tH\u0016\u00a2\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\fH\u0002\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0012\u001a\u00020\u0011H\u0016\u00a2\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0015\u001a\u00020\u0014H\u0016\u00a2\u0006\u0004\b\u0015\u0010\u0016J\u001f\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u0017H\u0017\u00a2\u0006\u0004\b\u001b\u0010\u001cJ\u000f\u0010\u001d\u001a\u00020\u0004H\u0002\u00a2\u0006\u0004\b\u001d\u0010\u001eJ\u0017\u0010!\u001a\u00020\u000e2\u0006\u0010 \u001a\u00020\u001fH\u0017\u00a2\u0006\u0004\b!\u0010\"R\u001a\u0010#\u001a\u00020\u00178\u0017X\u0096\u0004\u00a2\u0006\f\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&R\u001a\u0010'\u001a\u00020\u00178\u0017X\u0096\u0004\u00a2\u0006\f\n\u0004\b'\u0010$\u001a\u0004\b(\u0010&R\u001a\u0010*\u001a\u00020)8\u0017X\u0096\u0004\u00a2\u0006\f\n\u0004\b*\u0010+\u001a\u0004\b,\u0010-R\u001a\u0010.\u001a\u00020\u00178\u0017X\u0096\u0004\u00a2\u0006\f\n\u0004\b.\u0010$\u001a\u0004\b/\u0010&R\u001a\u00101\u001a\u0002008\u0017X\u0096\u0004\u00a2\u0006\f\n\u0004\b1\u00102\u001a\u0004\b3\u00104R\u001a\u00105\u001a\u0002008\u0017X\u0096\u0004\u00a2\u0006\f\n\u0004\b5\u00102\u001a\u0004\b6\u00104"}, d2={"Lorg/valkyrienskies/core/impl/bodies/properties/BodyTransformImpl;", "Lorg/valkyrienskies/core/api/ships/properties/ShipTransform;", "Lorg/valkyrienskies/core/api/bodies/properties/BodyTransform;", "Ljava/io/Serializable;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "Ljava/io/ObjectInputStream;", "s", "", "readObject", "(Ljava/io/ObjectInputStream;)V", "Lorg/valkyrienskies/core/api/bodies/properties/BodyTransform$Builder;", "toBuilder", "()Lorg/valkyrienskies/core/api/bodies/properties/BodyTransform$Builder;", "", "toString", "()Ljava/lang/String;", "Lorg/joml/Vector3dc;", "velocity", "angularVelocity", "Lorg/valkyrienskies/core/api/bodies/properties/BodyKinematics;", "withVelocity", "(Lorg/joml/Vector3dc;Lorg/joml/Vector3dc;)Lorg/valkyrienskies/core/api/bodies/properties/BodyKinematics;", "writeReplace", "()Ljava/lang/Object;", "Ljava/io/DataOutput;", "output", "writeTransform", "(Ljava/io/DataOutput;)V", "position", "Lorg/joml/Vector3dc;", "getPosition", "()Lorg/joml/Vector3dc;", "positionInModel", "getPositionInModel", "Lorg/joml/Quaterniondc;", "rotation", "Lorg/joml/Quaterniondc;", "getRotation", "()Lorg/joml/Quaterniondc;", "scaling", "getScaling", "Lorg/joml/Matrix4dc;", "toModel", "Lorg/joml/Matrix4dc;", "getToModel", "()Lorg/joml/Matrix4dc;", "toWorld", "getToWorld", "<init>", "(Lorg/joml/Vector3dc;Lorg/joml/Quaterniondc;Lorg/joml/Vector3dc;Lorg/joml/Vector3dc;)V", "SerializationDelegate"})
public final class BodyTransformImpl
implements Serializable,
BodyTransform,
ShipTransform {
    private final Vector3dc position;
    private final Vector3dc positionInModel;
    private final Quaterniondc rotation;
    private final Vector3dc scaling;
    private final Matrix4dc toWorld;
    private final Matrix4dc toModel;

    /*
     * WARNING - void declaration
     */
    @JsonCreator
    public BodyTransformImpl(@JsonAlias(value={"positionInWorld", "shipPositionInWorldCoordinates"}) Vector3dc position, @JsonAlias(value={"shipToWorldRotation", "shipCoordinatesToWorldCoordinatesRotation"}) Quaterniondc rotation, @JsonAlias(value={"shipToWorldScaling", "shipCoordinatesToWorldCoordinatesScaling"}) Vector3dc scaling, @JsonAlias(value={"positionInShip", "shipPositionInShipCoordinates"}) Vector3dc positionInModel) {
        void var3_3;
        void var2_2;
        void var1_1;
        Intrinsics.checkNotNullParameter((Object)position, (String)"");
        Intrinsics.checkNotNullParameter((Object)rotation, (String)"");
        Intrinsics.checkNotNullParameter((Object)scaling, (String)"");
        Intrinsics.checkNotNullParameter((Object)positionInModel, (String)"");
        if (!position.isFinite()) {
            position = "Cannot construct BodyTransform with non-finite position: " + (Vector3dc)position;
            throw new IllegalArgumentException(position.toString());
        }
        if (!positionInModel.isFinite()) {
            position = "Cannot construct BodyTransform with non-finite positionInModel: " + positionInModel;
            throw new IllegalArgumentException(position.toString());
        }
        if (!rotation.isFinite()) {
            position = "Cannot construct BodyTransform with non-finite rotation: " + rotation;
            throw new IllegalArgumentException(position.toString());
        }
        if (!scaling.isFinite()) {
            position = "Cannot construct BodyTransform with non-finite scaling: " + scaling;
            throw new IllegalArgumentException(position.toString());
        }
        if (!(scaling.x() == scaling.y() && scaling.y() == scaling.z())) {
            position = "Cannot construct BodyTransform with non-uniform scaling: " + scaling;
            throw new IllegalArgumentException(position.toString());
        }
        if (!(Math.abs(rotation.lengthSquared() - 1.0) < 1.0E-12)) {
            position = "Cannot construct BodyTransform with non-normalized rotation: " + rotation;
            throw new IllegalArgumentException(position.toString());
        }
        this.position = new Vector3d((Vector3dc)position);
        this.positionInModel = new Vector3d(positionInModel);
        this.rotation = new Quaterniond(rotation);
        this.scaling = new Vector3d(scaling);
        Matrix4d matrix4d = new Matrix4d().translate((Vector3dc)var1_1).rotate((Quaterniondc)var2_2).scale((Vector3dc)var3_3).translate(-positionInModel.x(), -positionInModel.y(), -positionInModel.z());
        Intrinsics.checkNotNullExpressionValue((Object)matrix4d, (String)"");
        this.toWorld = matrix4d;
        Matrix4d matrix4d2 = this.getToWorld().invert(new Matrix4d());
        Intrinsics.checkNotNullExpressionValue((Object)matrix4d2, (String)"");
        this.toModel = matrix4d2;
    }

    @Override
    @JvmName(name="getPosition")
    public final Vector3dc getPosition() {
        return this.position;
    }

    @Override
    @JvmName(name="getPositionInModel")
    public final Vector3dc getPositionInModel() {
        return this.positionInModel;
    }

    @Override
    @JvmName(name="getRotation")
    public final Quaterniondc getRotation() {
        return this.rotation;
    }

    @Override
    @JvmName(name="getScaling")
    public final Vector3dc getScaling() {
        return this.scaling;
    }

    @Override
    @JvmName(name="getToWorld")
    public final Matrix4dc getToWorld() {
        return this.toWorld;
    }

    @Override
    @JvmName(name="getToModel")
    public final Matrix4dc getToModel() {
        return this.toModel;
    }

    /*
     * WARNING - void declaration
     */
    @Override
    @VsBeta
    public final BodyKinematics withVelocity(Vector3dc velocity, Vector3dc angularVelocity) {
        void var2_2;
        void var1_1;
        Intrinsics.checkNotNullParameter((Object)velocity, (String)"");
        Intrinsics.checkNotNullParameter((Object)angularVelocity, (String)"");
        return BodyKinematicsFactory.INSTANCE.create((Vector3dc)var1_1, (Vector3dc)var2_2, this);
    }

    @Override
    public final BodyTransform.Builder toBuilder() {
        return BodyTransformFactory.INSTANCE.newBuilder(this);
    }

    /*
     * WARNING - void declaration
     */
    @Override
    @VsBeta
    public final void writeTransform(DataOutput output) {
        void var1_1;
        Intrinsics.checkNotNullParameter((Object)output, (String)"");
        void v0 = var1_1;
        var1_1 = v0;
        var1_1 = v0;
        v0.writeDouble(this.getPosition().x());
        var1_1.writeDouble(this.getPosition().y());
        var1_1.writeDouble(this.getPosition().z());
        var1_1.writeDouble(this.getRotation().x());
        var1_1.writeDouble(this.getRotation().y());
        var1_1.writeDouble(this.getRotation().z());
        var1_1.writeDouble(this.getRotation().w());
        var1_1.writeDouble(this.getScaling().x());
        var1_1.writeDouble(this.getScaling().y());
        var1_1.writeDouble(this.getScaling().z());
        var1_1.writeDouble(this.getPositionInModel().x());
        var1_1.writeDouble(this.getPositionInModel().y());
        var1_1.writeDouble(this.getPositionInModel().z());
    }

    public final int hashCode() {
        int n2 = this.getPosition().hashCode();
        n2 = n2 * 31 + this.getPositionInModel().hashCode();
        n2 = n2 * 31 + this.getRotation().hashCode();
        n2 = n2 * 31 + this.getScaling().hashCode();
        return n2;
    }

    /*
     * WARNING - void declaration
     */
    public final boolean equals(Object other) {
        void var1_1;
        if (this == other) {
            return true;
        }
        if (!(other instanceof BodyTransform)) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.getPosition(), (Object)((BodyTransform)other).getPosition())) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.getPositionInModel(), (Object)((BodyTransform)other).getPositionInModel())) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.getRotation(), (Object)((BodyTransform)other).getRotation())) {
            return false;
        }
        return Intrinsics.areEqual((Object)this.getScaling(), (Object)((BodyTransform)var1_1).getScaling());
    }

    private final Object writeReplace() {
        return new SerializationDelegate(this);
    }

    private final void readObject(ObjectInputStream s) {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    public final String toString() {
        return "BodyTransform(position=" + this.getPosition() + ", rotation=" + this.getRotation() + ", scaling=" + this.getScaling() + ", positionInModel=" + this.getPositionInModel() + ")";
    }

    @Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000f\u001a\u00020\u000e\u00a2\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a2\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0007H\u0002\u00a2\u0006\u0004\b\b\u0010\tJ\u0017\u0010\f\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\nH\u0016\u00a2\u0006\u0004\b\f\u0010\rR\u0016\u0010\u000f\u001a\u00020\u000e8\u0002@\u0002X\u0083\u000e\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010"}, d2={"Lorg/valkyrienskies/core/impl/bodies/properties/BodyTransformImpl$SerializationDelegate;", "Ljava/io/Externalizable;", "Ljava/io/ObjectInput;", "input", "", "readExternal", "(Ljava/io/ObjectInput;)V", "", "readResolve", "()Ljava/lang/Object;", "Ljava/io/ObjectOutput;", "out", "writeExternal", "(Ljava/io/ObjectOutput;)V", "Lorg/valkyrienskies/core/api/bodies/properties/BodyTransform;", "transform", "Lorg/valkyrienskies/core/api/bodies/properties/BodyTransform;", "<init>", "(Lorg/valkyrienskies/core/api/bodies/properties/BodyTransform;)V"})
    static final class SerializationDelegate
    implements Externalizable {
        private BodyTransform transform;

        /*
         * WARNING - void declaration
         */
        public SerializationDelegate(BodyTransform transform2) {
            void var1_1;
            Intrinsics.checkNotNullParameter((Object)transform2, (String)"");
            this.transform = var1_1;
        }

        /*
         * WARNING - void declaration
         */
        @Override
        public final void writeExternal(ObjectOutput out) {
            void var1_1;
            Intrinsics.checkNotNullParameter((Object)out, (String)"");
            this.transform.writeTransform((DataOutput)var1_1);
        }

        /*
         * WARNING - void declaration
         */
        @Override
        public final void readExternal(ObjectInput input) {
            void var1_1;
            Intrinsics.checkNotNullParameter((Object)input, (String)"");
            this.transform = BodyTransformFactory.INSTANCE.readFrom((DataInput)var1_1);
        }

        private final Object readResolve() {
            return this.transform;
        }
    }
}

