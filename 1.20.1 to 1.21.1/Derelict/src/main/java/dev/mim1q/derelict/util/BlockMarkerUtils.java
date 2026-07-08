/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.jvm.functions.Function6
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.class_239$class_240
 *  net.minecraft.class_2960
 *  net.minecraft.class_310
 *  net.minecraft.class_332
 *  net.minecraft.class_3965
 *  org.jetbrains.annotations.NotNull
 */
package dev.mim1q.derelict.util;

import dev.mim1q.derelict.DerelictClient;
import dev.mim1q.derelict.item.CrosshairTipItem;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function6;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.class_239;
import net.minecraft.class_2960;
import net.minecraft.class_310;
import net.minecraft.class_332;
import net.minecraft.class_3965;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u0007\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003JO\u0010\f\u001a\u00020\b20\u0010\t\u001a,\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u00042\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u0006\u00a2\u0006\u0004\b\f\u0010\rJ\u001d\u0010\u0012\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u0010\u00a2\u0006\u0004\b\u0012\u0010\u0013J\u001f\u0010\u0015\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0014\u001a\u00020\u0005H\u0002\u00a2\u0006\u0004\b\u0015\u0010\u0016R\u0014\u0010\u0017\u001a\u00020\u00058\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018\u00a8\u0006\u0019"}, d2={"Ldev/mim1q/derelict/util/BlockMarkerUtils;", "", "<init>", "()V", "Lkotlin/Function6;", "Lnet/minecraft/class_2960;", "", "", "", "textureDrawer", "x", "y", "renderWaxedIndicator", "(Lkotlin/jvm/functions/Function6;II)V", "Lnet/minecraft/class_332;", "context", "Ldev/mim1q/derelict/item/CrosshairTipItem;", "item", "renderCrosshairTip", "(Lnet/minecraft/class_332;Ldev/mim1q/derelict/item/CrosshairTipItem;)V", "texture", "renderCrosshairTipTexture", "(Lnet/minecraft/class_332;Lnet/minecraft/class_2960;)V", "HONEYCOMB_TEXTURE", "Lnet/minecraft/class_2960;", "derelict"})
public final class BlockMarkerUtils {
    @NotNull
    public static final BlockMarkerUtils INSTANCE = new BlockMarkerUtils();
    @NotNull
    private static final class_2960 HONEYCOMB_TEXTURE = new class_2960("textures/item/honeycomb.png");

    private BlockMarkerUtils() {
    }

    public final void renderWaxedIndicator(@NotNull Function6<? super class_2960, ? super Integer, ? super Integer, ? super Integer, ? super Integer, ? super Float, Unit> textureDrawer, int x, int y) {
        Intrinsics.checkNotNullParameter(textureDrawer, (String)"textureDrawer");
        int size = (int)(DerelictClient.INSTANCE.getCLIENT_CONFIG().waxedIndicatorScale() * (float)16);
        int startX = x - size / 2;
        int startY = y - size / 2;
        float alpha = DerelictClient.INSTANCE.getCLIENT_CONFIG().waxedIndicatorOpacity();
        textureDrawer.invoke((Object)HONEYCOMB_TEXTURE, (Object)startX, (Object)startY, (Object)300, (Object)size, (Object)Float.valueOf(alpha));
    }

    /*
     * Unable to fully structure code
     */
    public final void renderCrosshairTip(@NotNull class_332 context, @NotNull CrosshairTipItem item) {
        block3: {
            Intrinsics.checkNotNullParameter((Object)context, (String)"context");
            Intrinsics.checkNotNullParameter((Object)item, (String)"item");
            v0 = target = class_310.method_1551().field_1765;
            if ((v0 != null ? v0.method_17783() : null) != class_239.class_240.field_1332) break block3;
            v1 = class_310.method_1551().field_1687;
            if (v1 == null) ** GOTO lbl-1000
            Intrinsics.checkNotNull((Object)target, (String)"null cannot be cast to non-null type net.minecraft.util.hit.BlockHitResult");
            if ((v1 = v1.method_8320(((class_3965)target).method_17777())) != null) {
                v2 = v1.method_26204();
            } else lbl-1000:
            // 2 sources

            {
                v2 = block = null;
            }
            if (item.shouldShowTip(block)) {
                this.renderCrosshairTipTexture(context, item.getTipTexture());
            }
        }
    }

    private final void renderCrosshairTipTexture(class_332 context, class_2960 texture) {
        int x = class_310.method_1551().method_22683().method_4486() / 2 + 6;
        int y = class_310.method_1551().method_22683().method_4502() / 2 - 8;
        context.method_25290(texture, x, y, 0.0f, 0.0f, 16, 16, 16, 16);
    }
}

