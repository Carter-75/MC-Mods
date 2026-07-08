/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.class_2314
 *  net.minecraft.class_2314$class_7217
 *  net.minecraft.class_7157
 */
package org.valkyrienskies.mod.common.command;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.class_2314;
import net.minecraft.class_7157;
import org.jetbrains.annotations.NotNull;
import org.valkyrienskies.mod.common.command.ShipArgument;
import org.valkyrienskies.mod.common.command.ShipArgumentInfo;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0017\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\u0006\u0010\u000e\u001a\u00020\r\u00a2\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u0016\u00a2\u0006\u0004\b\u0005\u0010\u0006J\u0019\u0010\b\u001a\f\u0012\u0004\u0012\u00020\u0002\u0012\u0002\b\u00030\u0007H\u0016\u00a2\u0006\u0004\b\b\u0010\tR\u0014\u0010\u000b\u001a\u00020\n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\fR\u001a\u0010\u000e\u001a\u00020\r8\u0000X\u0080\u0004\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\u00a8\u0006\u0014"}, d2={"Lorg/valkyrienskies/mod/common/command/ShipArgumentInfoTemplate;", "Lnet/minecraft/class_2314$class_7217;", "Lorg/valkyrienskies/mod/common/command/ShipArgument;", "Lnet/minecraft/class_7157;", "commandBuildContext", "instantiate", "(Lnet/minecraft/class_7157;)Lorg/valkyrienskies/mod/common/command/ShipArgument;", "Lnet/minecraft/class_2314;", "type", "()Lnet/minecraft/class_2314;", "Lorg/valkyrienskies/mod/common/command/ShipArgumentInfo;", "info", "Lorg/valkyrienskies/mod/common/command/ShipArgumentInfo;", "", "selectorOnly", "Z", "getSelectorOnly$valkyrienskies_120", "()Z", "<init>", "(Lorg/valkyrienskies/mod/common/command/ShipArgumentInfo;Z)V", "valkyrienskies-120"})
public final class ShipArgumentInfoTemplate
implements class_2314.class_7217<ShipArgument> {
    @NotNull
    private final ShipArgumentInfo info;
    private final boolean selectorOnly;

    public ShipArgumentInfoTemplate(@NotNull ShipArgumentInfo info, boolean selectorOnly) {
        Intrinsics.checkNotNullParameter((Object)info, (String)"info");
        this.info = info;
        this.selectorOnly = selectorOnly;
    }

    public final boolean getSelectorOnly$valkyrienskies_120() {
        return this.selectorOnly;
    }

    @NotNull
    public ShipArgument instantiate(@NotNull class_7157 commandBuildContext) {
        Intrinsics.checkNotNullParameter((Object)commandBuildContext, (String)"commandBuildContext");
        return this.selectorOnly ? ShipArgument.Companion.selectorOnly() : ShipArgument.Companion.ships();
    }

    @NotNull
    public class_2314<ShipArgument, ?> method_41728() {
        return this.info;
    }
}

