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
import org.joml.Vector3dc;
import org.joml.primitives.AABBd;
import org.valkyrienskies.core.impl.shadow.GS;
import org.valkyrienskies.core.impl.shadow.GX;
import org.valkyrienskies.core.impl.shadow.ha_0;
import org.valkyrienskies.core.impl.shadow.hb_0;
import org.valkyrienskies.core.impl.shadow.hc_0;

@Metadata(mv={1, 6, 0}, k=1, xi=48, d1={"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0006\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\bf\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\u00020\u0003J\u001f\u0010\b\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H&\u00a2\u0006\u0004\b\b\u0010\tJ\u0017\u0010\n\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0004H&\u00a2\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\r\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u0004H&\u00a2\u0006\u0004\b\r\u0010\u000bJ\u0017\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u0004H&\u00a2\u0006\u0004\b\u000f\u0010\u000bJ\u0017\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u0004H&\u00a2\u0006\u0004\b\u0011\u0010\u000bJ\u0017\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0013\u001a\u00020\u0012H&\u00a2\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0017\u001a\u00020\u0014H&\u00a2\u0006\u0004\b\u0017\u0010\u0018J\u000f\u0010\u0019\u001a\u00020\u0014H&\u00a2\u0006\u0004\b\u0019\u0010\u0018J\u000f\u0010\u001b\u001a\u00020\u001aH&\u00a2\u0006\u0004\b\u001b\u0010\u001cJ\u000f\u0010\u001d\u001a\u00020\u0007H&\u00a2\u0006\u0004\b\u001d\u0010\u001eR$\u0010#\u001a\u00020\u001a2\u0006\u0010\u001f\u001a\u00020\u001a8f@fX\u00a6\u000e\u00a2\u0006\f\u001a\u0004\b \u0010\u001c\"\u0004\b!\u0010\"R$\u0010)\u001a\u00020$2\u0006\u0010\u001f\u001a\u00020$8f@fX\u00a6\u000e\u00a2\u0006\f\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R(\u0010.\u001a\u0004\u0018\u00018\u00002\b\u0010\u001f\u001a\u0004\u0018\u00018\u00008f@fX\u00a6\u000e\u00a2\u0006\f\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R$\u00102\u001a\u00020\u00042\u0006\u0010\u001f\u001a\u00020\u00048f@fX\u00a6\u000e\u00a2\u0006\f\u001a\u0004\b/\u00100\"\u0004\b1\u0010\u000bR$\u00105\u001a\u00020\u001a2\u0006\u0010\u001f\u001a\u00020\u001a8f@fX\u00a6\u000e\u00a2\u0006\f\u001a\u0004\b3\u0010\u001c\"\u0004\b4\u0010\"R$\u00109\u001a\u00020\u00142\u0006\u0010\u001f\u001a\u00020\u00148f@fX\u00a6\u000e\u00a2\u0006\f\u001a\u0004\b6\u0010\u0018\"\u0004\b7\u00108R$\u0010<\u001a\u00020\u001a2\u0006\u0010\u001f\u001a\u00020\u001a8f@fX\u00a6\u000e\u00a2\u0006\f\u001a\u0004\b:\u0010\u001c\"\u0004\b;\u0010\"R$\u0010B\u001a\u00020=2\u0006\u0010\u001f\u001a\u00020=8f@fX\u00a6\u000e\u00a2\u0006\f\u001a\u0004\b>\u0010?\"\u0004\b@\u0010AR$\u0010C\u001a\u00020\u00142\u0006\u0010\u001f\u001a\u00020\u00148f@fX\u00a6\u000e\u00a2\u0006\f\u001a\u0004\bC\u0010\u0018\"\u0004\bD\u00108R(\u0010J\u001a\u0004\u0018\u00010E2\b\u0010\u001f\u001a\u0004\u0018\u00010E8f@fX\u00a6\u000e\u00a2\u0006\f\u001a\u0004\bF\u0010G\"\u0004\bH\u0010IR\u0018\u0010M\u001a\u00060$j\u0002`K8&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\bL\u0010&R\u0014\u0010Q\u001a\u00020N8&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\bO\u0010PR$\u0010W\u001a\u00020R2\u0006\u0010\u001f\u001a\u00020R8f@fX\u00a6\u000e\u00a2\u0006\f\u001a\u0004\bS\u0010T\"\u0004\bU\u0010VR$\u0010Z\u001a\u00020\u001a2\u0006\u0010\u001f\u001a\u00020\u001a8f@fX\u00a6\u000e\u00a2\u0006\f\u001a\u0004\bX\u0010\u001c\"\u0004\bY\u0010\"R$\u0010]\u001a\u00020\u001a2\u0006\u0010\u001f\u001a\u00020\u001a8f@fX\u00a6\u000e\u00a2\u0006\f\u001a\u0004\b[\u0010\u001c\"\u0004\b\\\u0010\"\u00a8\u0006^"}, d2={"Lorg/valkyrienskies/physics_api/PhysicsBodyReference;", "Lorg/valkyrienskies/physics_api/CollisionShapeReference;", "T", "", "Lorg/joml/Vector3dc;", "forcePosInLocal", "invariantForce", "", "addInvariantForceAtPosToNextPhysTick", "(Lorg/joml/Vector3dc;Lorg/joml/Vector3dc;)V", "addInvariantForceToNextPhysTick", "(Lorg/joml/Vector3dc;)V", "invariantTorque", "addInvariantTorqueToNextPhysTick", "forceInLocal", "addRotDependentForceToNextPhysTick", "torqueInLocal", "addRotDependentTorqueToNextPhysTick", "Lorg/joml/primitives/AABBd;", "output", "", "getAABB", "(Lorg/joml/primitives/AABBd;)Z", "hasBeenDeleted", "()Z", "isAsleep", "", "liquidCollisionOverlap", "()D", "wakeUp", "()V", "<set-?>", "getBuoyantFactor", "setBuoyantFactor", "(D)V", "buoyantFactor", "", "getCollisionMask", "()I", "setCollisionMask", "(I)V", "collisionMask", "getCollisionShape", "()Lorg/valkyrienskies/physics_api/CollisionShapeReference;", "setCollisionShape", "(Lorg/valkyrienskies/physics_api/CollisionShapeReference;)V", "collisionShape", "getCollisionShapeOffset", "()Lorg/joml/Vector3dc;", "setCollisionShapeOffset", "collisionShapeOffset", "getCollisionShapeScaling", "setCollisionShapeScaling", "collisionShapeScaling", "getDoFluidDrag", "setDoFluidDrag", "(Z)V", "doFluidDrag", "getDynamicFrictionCoefficient", "setDynamicFrictionCoefficient", "dynamicFrictionCoefficient", "Lorg/valkyrienskies/physics_api/PhysicsBodyInertiaData;", "getInertiaData", "()Lorg/valkyrienskies/physics_api/PhysicsBodyInertiaData;", "setInertiaData", "(Lorg/valkyrienskies/physics_api/PhysicsBodyInertiaData;)V", "inertiaData", "isStatic", "setStatic", "Lorg/valkyrienskies/physics_api/Pose;", "getKinematicTarget", "()Lorg/valkyrienskies/physics_api/Pose;", "setKinematicTarget", "(Lorg/valkyrienskies/physics_api/Pose;)V", "kinematicTarget", "Lorg/valkyrienskies/physics_api/PhysicsBodyId;", "getPhysicsBodyId", "physicsBodyId", "Lorg/valkyrienskies/physics_api/PhysicsWorldReference;", "getPhysicsWorldReference", "()Lorg/valkyrienskies/physics_api/PhysicsWorldReference;", "physicsWorldReference", "Lorg/valkyrienskies/physics_api/PoseVel;", "getPoseVel", "()Lorg/valkyrienskies/physics_api/PoseVel;", "setPoseVel", "(Lorg/valkyrienskies/physics_api/PoseVel;)V", "poseVel", "getRestitutionCoefficient", "setRestitutionCoefficient", "restitutionCoefficient", "getStaticFrictionCoefficient", "setStaticFrictionCoefficient", "staticFrictionCoefficient", "physics_api"})
public interface GY<T extends GS> {
    @JvmName(name="a")
    public int a();

    @JvmName(name="b")
    public ha_0 b();

    @JvmName(name="c")
    public T c();

    @JvmName(name="a")
    public void a(T var1);

    @JvmName(name="d")
    public hc_0 d();

    @JvmName(name="a")
    public void a(hc_0 var1);

    @JvmName(name="e")
    public GX e();

    @JvmName(name="a")
    public void a(GX var1);

    @JvmName(name="f")
    public boolean f();

    @JvmName(name="a")
    public void a(boolean var1);

    @JvmName(name="g")
    public double g();

    @JvmName(name="a")
    public void a(double var1);

    @JvmName(name="h")
    public double h();

    @JvmName(name="b")
    public void b(double var1);

    @JvmName(name="i")
    public double i();

    @JvmName(name="c")
    public void c(double var1);

    @JvmName(name="j")
    public double j();

    @JvmName(name="d")
    public void d(double var1);

    @JvmName(name="k")
    public Vector3dc k();

    @JvmName(name="a")
    public void a(Vector3dc var1);

    @JvmName(name="l")
    public double l();

    @JvmName(name="e")
    public void e(double var1);

    @JvmName(name="m")
    public boolean m();

    @JvmName(name="b")
    public void b(boolean var1);

    @JvmName(name="n")
    public int n();

    @JvmName(name="a")
    public void a(int var1);

    @JvmName(name="o")
    public hb_0 o();

    @JvmName(name="a")
    public void a(hb_0 var1);

    public void b(Vector3dc var1);

    public void c(Vector3dc var1);

    public void d(Vector3dc var1);

    public void e(Vector3dc var1);

    public void a(Vector3dc var1, Vector3dc var2);

    public boolean p();

    public boolean a(AABBd var1);

    public void q();

    public boolean r();

    public double s();
}

