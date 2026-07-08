/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.internal.Intrinsics
 */
package org.valkyrienskies.core.api.bodies.properties;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.valkyrienskies.core.api.VsBeta;
import org.valkyrienskies.core.api.bodies.properties.BodyTransform;

@Metadata(mv={1, 8, 0}, k=2, xi=48, d1={"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a=\u0010\u0006\u001a\u00020\u0000*\u00020\u00002\u0017\u0010\u0005\u001a\u0013\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001\u00a2\u0006\u0002\b\u0004H\u0087\b\u00f8\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001\u00a2\u0006\u0004\b\u0006\u0010\u0007\u0082\u0002\u0007\n\u0005\b\u009920\u0001\u00a8\u0006\b"}, d2={"Lorg/valkyrienskies/core/api/bodies/properties/BodyTransform;", "Lkotlin/Function1;", "Lorg/valkyrienskies/core/api/bodies/properties/BodyTransform$Builder;", "", "Lkotlin/ExtensionFunctionType;", "block", "rebuild", "(Lorg/valkyrienskies/core/api/bodies/properties/BodyTransform;Lkotlin/jvm/functions/Function1;)Lorg/valkyrienskies/core/api/bodies/properties/BodyTransform;", "api"})
public final class BodyTransformKt {
    @VsBeta
    @NotNull
    public static final BodyTransform rebuild(@NotNull BodyTransform $this$rebuild, @NotNull Function1<? super BodyTransform.Builder, Unit> block) {
        Intrinsics.checkNotNullParameter((Object)$this$rebuild, (String)"<this>");
        Intrinsics.checkNotNullParameter(block, (String)"block");
        boolean $i$f$rebuild = false;
        BodyTransform.Builder builder = $this$rebuild.toBuilder();
        block.invoke((Object)builder);
        return builder.build();
    }
}

