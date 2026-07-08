/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.enums.EnumEntries
 *  kotlin.enums.EnumEntriesKt
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.class_1087
 *  net.minecraft.class_2350
 *  net.minecraft.class_4587
 *  net.minecraft.class_4588
 *  net.minecraft.class_4608
 *  net.minecraft.class_5819
 *  net.minecraft.class_777
 *  org.jetbrains.annotations.NotNull
 */
package dev.mim1q.derelict.util.render;

import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.class_1087;
import net.minecraft.class_2350;
import net.minecraft.class_4587;
import net.minecraft.class_4588;
import net.minecraft.class_4608;
import net.minecraft.class_5819;
import net.minecraft.class_777;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 0, 0}, k=2, xi=48, d1={"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\u001a0\u0010\u0005\u001a\u00020\u0002*\u00020\u00002\u0017\u0010\u0004\u001a\u0013\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001\u00a2\u0006\u0002\b\u0003H\u0086\b\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0005\u0010\u0006\u001a1\u0010\u000f\u001a\u00020\u0002*\u00020\u00072\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u00002\u0006\u0010\u000e\u001a\u00020\r\u00a2\u0006\u0004\b\u000f\u0010\u0010\u001a5\u0010\u0014\u001a\u00020\u00022\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00120\u00112\u0006\u0010\f\u001a\u00020\u00002\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000b\u001a\u00020\nH\u0002\u00a2\u0006\u0004\b\u0014\u0010\u0015\u0082\u0002\u0007\n\u0005\b\u009920\u0001\u00a8\u0006\u0016"}, d2={"Lnet/minecraft/class_4587;", "Lkotlin/Function1;", "", "Lkotlin/ExtensionFunctionType;", "setup", "entry", "(Lnet/minecraft/class_4587;Lkotlin/jvm/functions/Function1;)V", "Lnet/minecraft/class_1087;", "Lnet/minecraft/class_5819;", "random", "", "light", "matrices", "Lnet/minecraft/class_4588;", "buffer", "render", "(Lnet/minecraft/class_1087;Lnet/minecraft/class_5819;ILnet/minecraft/class_4587;Lnet/minecraft/class_4588;)V", "", "Lnet/minecraft/class_777;", "quads", "renderBakedQuads", "(Ljava/util/List;Lnet/minecraft/class_4587;Lnet/minecraft/class_4588;I)V", "derelict"})
public final class RenderUtilKt {
    public static final void entry(@NotNull class_4587 $this$entry, @NotNull Function1<? super class_4587, Unit> setup) {
        Intrinsics.checkNotNullParameter((Object)$this$entry, (String)"<this>");
        Intrinsics.checkNotNullParameter(setup, (String)"setup");
        boolean $i$f$entry = false;
        $this$entry.method_22903();
        setup.invoke((Object)$this$entry);
        $this$entry.method_22909();
    }

    public static final void render(@NotNull class_1087 $this$render, @NotNull class_5819 random, int light, @NotNull class_4587 matrices, @NotNull class_4588 buffer) {
        Intrinsics.checkNotNullParameter((Object)$this$render, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)random, (String)"random");
        Intrinsics.checkNotNullParameter((Object)matrices, (String)"matrices");
        Intrinsics.checkNotNullParameter((Object)buffer, (String)"buffer");
        for (class_2350 direction : EntriesMappings.entries$0) {
            List quads = $this$render.method_4707(null, direction, random);
            Intrinsics.checkNotNull((Object)quads);
            RenderUtilKt.renderBakedQuads(quads, matrices, buffer, light);
        }
        List noDirectionQuads = $this$render.method_4707(null, null, random);
        Intrinsics.checkNotNull((Object)noDirectionQuads);
        RenderUtilKt.renderBakedQuads(noDirectionQuads, matrices, buffer, light);
    }

    private static final void renderBakedQuads(List<? extends class_777> quads, class_4587 matrices, class_4588 buffer, int light) {
        for (class_777 class_7772 : quads) {
            Object[] objectArray = new float[]{1.0f, 1.0f, 1.0f, 1.0f};
            float[] fArray = objectArray;
            objectArray = new int[4];
            objectArray[0] = light;
            objectArray[1] = light;
            objectArray[2] = light;
            objectArray[3] = light;
            buffer.method_22920(matrices.method_23760(), class_7772, fArray, 1.0f, 1.0f, 1.0f, (int[])objectArray, class_4608.field_21444, false);
        }
    }

    @Metadata(mv={2, 0, 0}, k=3, xi=48)
    public final class EntriesMappings {
        public static final /* synthetic */ EnumEntries<class_2350> entries$0;

        static {
            entries$0 = EnumEntriesKt.enumEntries((Enum[])((Enum[])class_2350.values()));
        }
    }
}

