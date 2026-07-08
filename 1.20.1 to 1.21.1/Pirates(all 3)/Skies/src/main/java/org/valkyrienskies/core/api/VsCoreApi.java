/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.internal.Intrinsics
 */
package org.valkyrienskies.core.api;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.joml.Quaterniondc;
import org.joml.Vector3dc;
import org.valkyrienskies.core.api.VsBeta;
import org.valkyrienskies.core.api.VsCoreApi;
import org.valkyrienskies.core.api.attachment.AttachmentRegistration;
import org.valkyrienskies.core.api.bodies.properties.BodyKinematics;
import org.valkyrienskies.core.api.bodies.properties.BodyTransform;
import org.valkyrienskies.core.api.event.ListenableEvent;
import org.valkyrienskies.core.api.events.CollisionEvent;
import org.valkyrienskies.core.api.events.MergeEvent;
import org.valkyrienskies.core.api.events.PhysTickEvent;
import org.valkyrienskies.core.api.events.ShipLoadEvent;
import org.valkyrienskies.core.api.events.ShipLoadEventClient;
import org.valkyrienskies.core.api.events.ShipUnloadEventClient;
import org.valkyrienskies.core.api.events.SplitEvent;
import org.valkyrienskies.core.api.events.StartUpdateRenderTransformsEvent;
import org.valkyrienskies.core.api.events.TickEndEvent;

@Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u0000\u00c0\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J)\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005\"\u0004\b\u0000\u0010\u00022\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003H'\u00a2\u0006\u0004\b\u0006\u0010\u0007J?\u0010\u0011\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\bH'\u00a2\u0006\u0004\b\u0011\u0010\u0012J'\u0010\u0011\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\u0013H'\u00a2\u0006\u0004\b\u0011\u0010\u0015J\u000f\u0010\u0017\u001a\u00020\u0016H'\u00a2\u0006\u0004\b\u0017\u0010\u0018J/\u0010\u0019\u001a\u00020\u00132\u0006\u0010\u000b\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\bH&\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\u000f\u0010\u001c\u001a\u00020\u001bH'\u00a2\u0006\u0004\b\u001c\u0010\u001dJ#\u0010\u001f\u001a\u00020\u001e\"\u0004\b\u0000\u0010\u00022\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003H\u0017\u00a2\u0006\u0004\b\u001f\u0010 JB\u0010\u001f\u001a\u00020\u001e\"\u0004\b\u0000\u0010\u00022\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u00032\u001d\u0010#\u001a\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0005\u0012\u0004\u0012\u00020\u001e0!\u00a2\u0006\u0002\b\"H'\u00a2\u0006\u0004\b\u001f\u0010$J#\u0010\u001f\u001a\u00020\u001e\"\u0004\b\u0000\u0010\u00022\f\u0010&\u001a\b\u0012\u0004\u0012\u00028\u00000%H'\u00a2\u0006\u0004\b\u001f\u0010'J\u0017\u0010*\u001a\u00020\u001e2\u0006\u0010)\u001a\u00020(H'\u00a2\u0006\u0004\b*\u0010+R \u00102\u001a\b\u0012\u0004\u0012\u00020-0,8&X\u00a7\u0004\u00a2\u0006\f\u0012\u0004\b0\u00101\u001a\u0004\b.\u0010/R \u00105\u001a\b\u0012\u0004\u0012\u00020-0,8&X\u00a7\u0004\u00a2\u0006\f\u0012\u0004\b4\u00101\u001a\u0004\b3\u0010/R \u00108\u001a\b\u0012\u0004\u0012\u00020-0,8&X\u00a7\u0004\u00a2\u0006\f\u0012\u0004\b7\u00101\u001a\u0004\b6\u0010/R \u0010<\u001a\b\u0012\u0004\u0012\u0002090,8&X\u00a7\u0004\u00a2\u0006\f\u0012\u0004\b;\u00101\u001a\u0004\b:\u0010/R \u0010@\u001a\b\u0012\u0004\u0012\u00020=0,8&X\u00a7\u0004\u00a2\u0006\f\u0012\u0004\b?\u00101\u001a\u0004\b>\u0010/R \u0010D\u001a\b\u0012\u0004\u0012\u00020A0,8&X\u00a7\u0004\u00a2\u0006\f\u0012\u0004\bC\u00101\u001a\u0004\bB\u0010/R \u0010H\u001a\b\u0012\u0004\u0012\u00020E0,8&X\u00a7\u0004\u00a2\u0006\f\u0012\u0004\bG\u00101\u001a\u0004\bF\u0010/R \u0010L\u001a\b\u0012\u0004\u0012\u00020I0,8&X\u00a7\u0004\u00a2\u0006\f\u0012\u0004\bK\u00101\u001a\u0004\bJ\u0010/R \u0010P\u001a\b\u0012\u0004\u0012\u00020M0,8&X\u00a7\u0004\u00a2\u0006\f\u0012\u0004\bO\u00101\u001a\u0004\bN\u0010/R \u0010T\u001a\b\u0012\u0004\u0012\u00020Q0,8&X\u00a7\u0004\u00a2\u0006\f\u0012\u0004\bS\u00101\u001a\u0004\bR\u0010/R \u0010X\u001a\b\u0012\u0004\u0012\u00020U0,8&X\u00a7\u0004\u00a2\u0006\f\u0012\u0004\bW\u00101\u001a\u0004\bV\u0010/R\u001a\u0010]\u001a\u00020Y8&X\u00a7\u0004\u00a2\u0006\f\u0012\u0004\b\\\u00101\u001a\u0004\bZ\u0010[\u00f8\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001\u00a8\u0006^\u00c0\u0006\u0001"}, d2={"Lorg/valkyrienskies/core/api/VsCoreApi;", "", "T", "Ljava/lang/Class;", "attachmentClass", "Lorg/valkyrienskies/core/api/attachment/AttachmentRegistration$Builder;", "newAttachmentRegistrationBuilder", "(Ljava/lang/Class;)Lorg/valkyrienskies/core/api/attachment/AttachmentRegistration$Builder;", "Lorg/joml/Vector3dc;", "velocity", "angularVelocity", "position", "Lorg/joml/Quaterniondc;", "rotation", "scaling", "positionInModel", "Lorg/valkyrienskies/core/api/bodies/properties/BodyKinematics;", "newBodyKinematics", "(Lorg/joml/Vector3dc;Lorg/joml/Vector3dc;Lorg/joml/Vector3dc;Lorg/joml/Quaterniondc;Lorg/joml/Vector3dc;Lorg/joml/Vector3dc;)Lorg/valkyrienskies/core/api/bodies/properties/BodyKinematics;", "Lorg/valkyrienskies/core/api/bodies/properties/BodyTransform;", "transform", "(Lorg/joml/Vector3dc;Lorg/joml/Vector3dc;Lorg/valkyrienskies/core/api/bodies/properties/BodyTransform;)Lorg/valkyrienskies/core/api/bodies/properties/BodyKinematics;", "Lorg/valkyrienskies/core/api/bodies/properties/BodyKinematics$Builder;", "newBodyKinematicsBuilder", "()Lorg/valkyrienskies/core/api/bodies/properties/BodyKinematics$Builder;", "newBodyTransform", "(Lorg/joml/Vector3dc;Lorg/joml/Quaterniondc;Lorg/joml/Vector3dc;Lorg/joml/Vector3dc;)Lorg/valkyrienskies/core/api/bodies/properties/BodyTransform;", "Lorg/valkyrienskies/core/api/bodies/properties/BodyTransform$Builder;", "newBodyTransformBuilder", "()Lorg/valkyrienskies/core/api/bodies/properties/BodyTransform$Builder;", "", "registerAttachment", "(Ljava/lang/Class;)V", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "registrationBuilder", "(Ljava/lang/Class;Lkotlin/jvm/functions/Function1;)V", "Lorg/valkyrienskies/core/api/attachment/AttachmentRegistration;", "registration", "(Lorg/valkyrienskies/core/api/attachment/AttachmentRegistration;)V", "", "attachmentKey", "registerAttachmentForRemoval", "(Ljava/lang/String;)V", "Lorg/valkyrienskies/core/api/event/ListenableEvent;", "Lorg/valkyrienskies/core/api/events/CollisionEvent;", "getCollisionEndEvent", "()Lorg/valkyrienskies/core/api/event/ListenableEvent;", "getCollisionEndEvent$annotations", "()V", "collisionEndEvent", "getCollisionPersistEvent", "getCollisionPersistEvent$annotations", "collisionPersistEvent", "getCollisionStartEvent", "getCollisionStartEvent$annotations", "collisionStartEvent", "Lorg/valkyrienskies/core/api/events/MergeEvent;", "getMergeEvent", "getMergeEvent$annotations", "mergeEvent", "Lorg/valkyrienskies/core/api/events/PhysTickEvent;", "getPhysTickEvent", "getPhysTickEvent$annotations", "physTickEvent", "Lorg/valkyrienskies/core/api/events/ShipLoadEvent;", "getShipLoadEvent", "getShipLoadEvent$annotations", "shipLoadEvent", "Lorg/valkyrienskies/core/api/events/ShipLoadEventClient;", "getShipLoadEventClient", "getShipLoadEventClient$annotations", "shipLoadEventClient", "Lorg/valkyrienskies/core/api/events/ShipUnloadEventClient;", "getShipUnloadEventClient", "getShipUnloadEventClient$annotations", "shipUnloadEventClient", "Lorg/valkyrienskies/core/api/events/SplitEvent;", "getSplitEvent", "getSplitEvent$annotations", "splitEvent", "Lorg/valkyrienskies/core/api/events/StartUpdateRenderTransformsEvent;", "getStartUpdateRenderTransformsEvent", "getStartUpdateRenderTransformsEvent$annotations", "startUpdateRenderTransformsEvent", "Lorg/valkyrienskies/core/api/events/TickEndEvent;", "getTickEndEvent", "getTickEndEvent$annotations", "tickEndEvent", "Lorg/valkyrienskies/core/api/bodies/properties/BodyTransform$Factory;", "getTransformFactory", "()Lorg/valkyrienskies/core/api/bodies/properties/BodyTransform$Factory;", "getTransformFactory$annotations", "transformFactory", "api"})
public interface VsCoreApi {
    @NotNull
    public BodyTransform.Factory getTransformFactory();

    @VsBeta
    public static /* synthetic */ void getTransformFactory$annotations() {
    }

    @NotNull
    public ListenableEvent<ShipLoadEvent> getShipLoadEvent();

    @VsBeta
    public static /* synthetic */ void getShipLoadEvent$annotations() {
    }

    @NotNull
    public ListenableEvent<ShipLoadEventClient> getShipLoadEventClient();

    @VsBeta
    public static /* synthetic */ void getShipLoadEventClient$annotations() {
    }

    @NotNull
    public ListenableEvent<ShipUnloadEventClient> getShipUnloadEventClient();

    @VsBeta
    public static /* synthetic */ void getShipUnloadEventClient$annotations() {
    }

    @NotNull
    public ListenableEvent<StartUpdateRenderTransformsEvent> getStartUpdateRenderTransformsEvent();

    @VsBeta
    public static /* synthetic */ void getStartUpdateRenderTransformsEvent$annotations() {
    }

    @NotNull
    public ListenableEvent<TickEndEvent> getTickEndEvent();

    @VsBeta
    public static /* synthetic */ void getTickEndEvent$annotations() {
    }

    @NotNull
    public ListenableEvent<CollisionEvent> getCollisionStartEvent();

    @VsBeta
    public static /* synthetic */ void getCollisionStartEvent$annotations() {
    }

    @NotNull
    public ListenableEvent<CollisionEvent> getCollisionEndEvent();

    @VsBeta
    public static /* synthetic */ void getCollisionEndEvent$annotations() {
    }

    @NotNull
    public ListenableEvent<CollisionEvent> getCollisionPersistEvent();

    @VsBeta
    public static /* synthetic */ void getCollisionPersistEvent$annotations() {
    }

    @NotNull
    public ListenableEvent<MergeEvent> getMergeEvent();

    @VsBeta
    public static /* synthetic */ void getMergeEvent$annotations() {
    }

    @NotNull
    public ListenableEvent<SplitEvent> getSplitEvent();

    @VsBeta
    public static /* synthetic */ void getSplitEvent$annotations() {
    }

    @NotNull
    public ListenableEvent<PhysTickEvent> getPhysTickEvent();

    @VsBeta
    public static /* synthetic */ void getPhysTickEvent$annotations() {
    }

    @VsBeta
    @NotNull
    public BodyKinematics newBodyKinematics(@NotNull Vector3dc var1, @NotNull Vector3dc var2, @NotNull BodyTransform var3);

    @VsBeta
    @NotNull
    public BodyKinematics newBodyKinematics(@NotNull Vector3dc var1, @NotNull Vector3dc var2, @NotNull Vector3dc var3, @NotNull Quaterniondc var4, @NotNull Vector3dc var5, @NotNull Vector3dc var6);

    @VsBeta
    @NotNull
    public BodyKinematics.Builder newBodyKinematicsBuilder();

    @NotNull
    public BodyTransform newBodyTransform(@NotNull Vector3dc var1, @NotNull Quaterniondc var2, @NotNull Vector3dc var3, @NotNull Vector3dc var4);

    @VsBeta
    @NotNull
    public BodyTransform.Builder newBodyTransformBuilder();

    @VsBeta
    @NotNull
    public <T> AttachmentRegistration.Builder<T> newAttachmentRegistrationBuilder(@NotNull Class<T> var1);

    @VsBeta
    public <T> void registerAttachment(@NotNull AttachmentRegistration<T> var1);

    @VsBeta
    default public <T> void registerAttachment(@NotNull Class<T> attachmentClass) {
        Intrinsics.checkNotNullParameter(attachmentClass, (String)"attachmentClass");
        this.registerAttachment(attachmentClass, registerAttachment.1.INSTANCE);
    }

    @VsBeta
    public <T> void registerAttachment(@NotNull Class<T> var1, @NotNull Function1<? super AttachmentRegistration.Builder<T>, Unit> var2);

    @VsBeta
    public void registerAttachmentForRemoval(@NotNull String var1);
}

