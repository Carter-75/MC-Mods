/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  it.unimi.dsi.fastutil.ints.IntList
 *  kotlin.Metadata
 */
package org.valkyrienskies.core.impl.shadow;

import it.unimi.dsi.fastutil.ints.IntList;
import java.util.List;
import kotlin.Metadata;
import org.joml.Vector3dc;
import org.joml.primitives.AABBi;
import org.joml.primitives.AABBic;
import org.valkyrienskies.core.impl.shadow.GS;
import org.valkyrienskies.core.impl.shadow.GY;
import org.valkyrienskies.core.impl.shadow.HI;
import org.valkyrienskies.core.impl.shadow.HS;
import org.valkyrienskies.core.impl.shadow.hd_0;
import org.valkyrienskies.core.impl.shadow.he_0;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.Ha
 */
@Metadata(mv={1, 6, 0}, k=1, xi=48, d1={"\u0000x\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\bf\u0018\u0000 =2\u00020\u0001:\u0002=>J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&\u00a2\u0006\u0004\b\u0005\u0010\u0006J'\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00000\n\"\b\b\u0000\u0010\b*\u00020\u00072\u0006\u0010\t\u001a\u00028\u0000H&\u00a2\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u000e\u001a\u00020\rH&\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u001b\u0010\u0013\u001a\u00020\u00042\n\u0010\u0012\u001a\u00060\u0010j\u0002`\u0011H&\u00a2\u0006\u0004\b\u0013\u0010\u0014J'\u0010\u0017\u001a\u00020\r2\n\u0010\u0015\u001a\u00060\u0010j\u0002`\u00112\n\u0010\u0016\u001a\u00060\u0010j\u0002`\u0011H&\u00a2\u0006\u0004\b\u0017\u0010\u0018J'\u0010\u0019\u001a\u00020\r2\n\u0010\u0015\u001a\u00060\u0010j\u0002`\u00112\n\u0010\u0016\u001a\u00060\u0010j\u0002`\u0011H&\u00a2\u0006\u0004\b\u0019\u0010\u0018J\u0015\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001aH&\u00a2\u0006\u0004\b\u001c\u0010\u001dJ\u0015\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00020\u001aH&\u00a2\u0006\u0004\b\u001e\u0010\u001dJ\u0015\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00020\u001aH&\u00a2\u0006\u0004\b\u001f\u0010\u001dJ\u0015\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00020\u001aH&\u00a2\u0006\u0004\b \u0010\u001dJ\u000f\u0010!\u001a\u00020\u0004H&\u00a2\u0006\u0004\b!\u0010\"J\u000f\u0010#\u001a\u00020\rH&\u00a2\u0006\u0004\b#\u0010\u000fJ%\u0010)\u001a\b\u0012\u0004\u0012\u00020(0\u001a2\u0006\u0010%\u001a\u00020$2\u0006\u0010'\u001a\u00020&H&\u00a2\u0006\u0004\b)\u0010*J9\u00101\u001a\u0004\u0018\u0001002\u0006\u0010+\u001a\u00020$2\u0006\u0010,\u001a\u00020$2\u0006\u0010-\u001a\u00020&2\u000e\u0010/\u001a\u00020.\"\u00060\u0010j\u0002`\u0011H&\u00a2\u0006\u0004\b1\u00102J9\u00104\u001a\u0004\u0018\u0001032\u0006\u0010+\u001a\u00020$2\u0006\u0010,\u001a\u00020$2\u0006\u0010-\u001a\u00020&2\u000e\u0010/\u001a\u00020.\"\u00060\u0010j\u0002`\u0011H&\u00a2\u0006\u0004\b4\u00105J\u001b\u00108\u001a\u00020\u00042\n\u00107\u001a\u00060\u0010j\u0002`6H&\u00a2\u0006\u0004\b8\u0010\u0014J\u001f\u0010:\u001a\u00020\r2\u000e\u00109\u001a\n\u0018\u00010\u0010j\u0004\u0018\u0001`\u0011H&\u00a2\u0006\u0004\b:\u0010;J\u0017\u0010<\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&\u00a2\u0006\u0004\b<\u0010\u0006\u00a8\u0006?"}, d2={"Lorg/valkyrienskies/physics_api/PhysicsWorldReference;", "", "Lorg/valkyrienskies/physics_api/joints/JointAndId;", "jointAndId", "", "addConstraint", "(Lorg/valkyrienskies/physics_api/joints/JointAndId;)Z", "Lorg/valkyrienskies/physics_api/CollisionShapeReference;", "T", "shape", "Lorg/valkyrienskies/physics_api/PhysicsBodyReference;", "createRigidBody", "(Lorg/valkyrienskies/physics_api/CollisionShapeReference;)Lorg/valkyrienskies/physics_api/PhysicsBodyReference;", "", "deletePhysicsWorldResources", "()V", "", "Lorg/valkyrienskies/physics_api/PhysicsBodyId;", "physicsBodyId", "deleteRigidBody", "(I)Z", "body0", "body1", "disableCollisionBetweenBodies", "(II)V", "enableCollisionBetweenBodies", "", "Lorg/valkyrienskies/physics_api/simevents/ContactEvent;", "getCollisionEvents", "()Ljava/util/List;", "getConstraints", "getConstraintsBrokenLastTick", "getConstraintsRemovedFromDeletedBodiesLastTick", "hasBeenDeleted", "()Z", "postStep", "Lorg/joml/Vector3dc;", "gravity", "", "timeStep", "Lorg/valkyrienskies/physics_api/PhysicsWorldReference$PhysicsWorldIsland;", "preStep", "(Lorg/joml/Vector3dc;D)Ljava/util/List;", "start", "normal", "distance", "", "ignoredBodies", "Lorg/valkyrienskies/physics_api/RayCastResult;", "rayTrace", "(Lorg/joml/Vector3dc;Lorg/joml/Vector3dc;D[I)Lorg/valkyrienskies/physics_api/RayCastResult;", "Lorg/valkyrienskies/physics_api/RayCastResultWithVelocity;", "rayTraceWithVel", "(Lorg/joml/Vector3dc;Lorg/joml/Vector3dc;D[I)Lorg/valkyrienskies/physics_api/RayCastResultWithVelocity;", "Lorg/valkyrienskies/physics_api/JointId;", "jointId", "removeConstraint", "groundBodyId", "setGroundBodyId", "(Ljava/lang/Integer;)V", "updateConstraint", "Companion", "PhysicsWorldIsland", "physics_api"})
public interface ha_0 {
    public static final a a = org.valkyrienskies.core.impl.shadow.Ha$a.a;

    public List<b> a(Vector3dc var1, double var2);

    public void h();

    public <T extends GS> GY<T> a(T var1);

    public boolean a(int var1);

    public void b();

    public boolean g();

    public boolean a(HI var1);

    public boolean b(HI var1);

    public boolean b(int var1);

    public List<HI> d();

    public List<HI> e();

    public List<HI> f();

    public void a(int var1, int var2);

    public void b(int var1, int var2);

    public hd_0 a(Vector3dc var1, Vector3dc var2, double var3, int ... var5);

    public he_0 b(Vector3dc var1, Vector3dc var2, double var3, int ... var5);

    public void a(Integer var1);

    public List<HS> c();

    public static interface b {
        public IntList a();

        public void a(Vector3dc var1, double var2);

        public void a(Vector3dc var1, double var2, double var4);

        public void b();
    }

    public static final class a {
        static final /* synthetic */ a a;
        private static final AABBic b;

        private a() {
        }

        public static AABBic a() {
            return b;
        }

        static {
            a = new a();
            b = new AABBi(Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE);
        }
    }
}

