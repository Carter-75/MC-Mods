/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.class_2164
 *  net.minecraft.class_2168
 *  net.minecraft.class_2172
 *  net.minecraft.class_2561
 *  net.minecraft.class_746
 */
package org.valkyrienskies.mod.common.command;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.class_2164;
import net.minecraft.class_2168;
import net.minecraft.class_2172;
import net.minecraft.class_2561;
import net.minecraft.class_746;
import org.jetbrains.annotations.NotNull;
import org.valkyrienskies.core.api.world.ShipWorld;
import org.valkyrienskies.mod.common.VSGameUtilsKt;
import org.valkyrienskies.mod.mixin.feature.commands.ClientSuggestionProviderAccessor;

@Metadata(mv={2, 0, 0}, k=2, xi=48, d1={"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u0019\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001\u00a2\u0006\u0004\b\u0004\u0010\u0005\"\u0015\u0010\t\u001a\u00020\u0006*\u00020\u00008F\u00a2\u0006\u0006\u001a\u0004\b\u0007\u0010\b\u00a8\u0006\n"}, d2={"Lnet/minecraft/class_2172;", "Lnet/minecraft/class_2561;", "component", "", "sendVSMessage", "(Lnet/minecraft/class_2172;Lnet/minecraft/class_2561;)V", "Lorg/valkyrienskies/core/api/world/ShipWorld;", "getShipWorld", "(Lnet/minecraft/class_2172;)Lorg/valkyrienskies/core/api/world/ShipWorld;", "shipWorld", "valkyrienskies-120"})
public final class VSCommandsKt {
    @NotNull
    public static final ShipWorld getShipWorld(@NotNull class_2172 $this$shipWorld) {
        Intrinsics.checkNotNullParameter((Object)$this$shipWorld, (String)"<this>");
        if ($this$shipWorld instanceof class_2168) {
            return VSGameUtilsKt.getShipObjectWorld(((class_2168)$this$shipWorld).method_9225());
        }
        if ($this$shipWorld instanceof ClientSuggestionProviderAccessor) {
            if (((ClientSuggestionProviderAccessor)$this$shipWorld).getMinecraft().field_1687 == null) {
                String string = "Required value was null.";
                throw new IllegalStateException(string.toString());
            }
            return VSGameUtilsKt.getShipObjectWorld(((ClientSuggestionProviderAccessor)$this$shipWorld).getMinecraft().field_1687);
        }
        throw new class_2164((class_2561)class_2561.method_43470((String)"Command source wasn't CommandSourceStack or ClientSuggestionProvider? Please report this as a bug"));
    }

    public static final void sendVSMessage(@NotNull class_2172 $this$sendVSMessage, @NotNull class_2561 component) {
        block2: {
            block1: {
                Intrinsics.checkNotNullParameter((Object)$this$sendVSMessage, (String)"<this>");
                Intrinsics.checkNotNullParameter((Object)component, (String)"component");
                if (!($this$sendVSMessage instanceof class_2168)) break block1;
                ((class_2168)$this$sendVSMessage).method_45068(component);
                break block2;
            }
            if (!($this$sendVSMessage instanceof ClientSuggestionProviderAccessor)) break block2;
            class_746 class_7462 = ((ClientSuggestionProviderAccessor)$this$sendVSMessage).getMinecraft().field_1724;
            if (class_7462 != null) {
                class_7462.method_43496(component);
            }
        }
    }
}

