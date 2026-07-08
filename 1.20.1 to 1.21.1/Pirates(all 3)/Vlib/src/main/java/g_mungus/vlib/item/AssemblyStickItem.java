/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.class_1269
 *  net.minecraft.class_1657
 *  net.minecraft.class_1792
 *  net.minecraft.class_1792$class_1793
 *  net.minecraft.class_1814
 *  net.minecraft.class_1838
 *  net.minecraft.class_1937
 *  net.minecraft.class_2338
 *  net.minecraft.class_3218
 *  org.jetbrains.annotations.NotNull
 */
package g_mungus.vlib.item;

import g_mungus.vlib.v2.api.VLibAPI;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.class_1269;
import net.minecraft.class_1657;
import net.minecraft.class_1792;
import net.minecraft.class_1814;
import net.minecraft.class_1838;
import net.minecraft.class_1937;
import net.minecraft.class_2338;
import net.minecraft.class_3218;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a2\u0006\u0004\b\u0005\u0010\u0006\u00a8\u0006\t"}, d2={"Lg_mungus/vlib/item/AssemblyStickItem;", "Lnet/minecraft/class_1792;", "Lnet/minecraft/class_1838;", "context", "Lnet/minecraft/class_1269;", "useOn", "(Lnet/minecraft/class_1838;)Lnet/minecraft/class_1269;", "<init>", "()V", "vlib"})
public final class AssemblyStickItem
extends class_1792 {
    public AssemblyStickItem() {
        super(new class_1792.class_1793().method_7894(class_1814.field_8904));
    }

    @NotNull
    public class_1269 method_7884(@NotNull class_1838 context) {
        Intrinsics.checkNotNullParameter((Object)context, (String)"context");
        if (context.method_8045() instanceof class_3218) {
            class_1937 class_19372 = context.method_8045();
            Intrinsics.checkNotNull((Object)class_19372, (String)"null cannot be cast to non-null type net.minecraft.server.level.ServerLevel");
            class_3218 class_32182 = (class_3218)class_19372;
            class_2338 class_23382 = context.method_8037();
            Intrinsics.checkNotNullExpressionValue((Object)class_23382, (String)"getClickedPos(...)");
            VLibAPI.assembleByConnectivity$default(class_32182, class_23382, null, 4, null);
        }
        class_1657 class_16572 = context.method_8036();
        if (class_16572 != null) {
            class_16572.method_6104(context.method_20287());
        }
        class_1269 class_12692 = super.method_7884(context);
        Intrinsics.checkNotNullExpressionValue((Object)class_12692, (String)"useOn(...)");
        return class_12692;
    }
}

