/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.common.collect.BiMap
 *  kotlin.Metadata
 *  kotlin.jvm.functions.Function0
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  net.fabricmc.fabric.api.item.v1.FabricItemSettings
 *  net.minecraft.class_1269
 *  net.minecraft.class_1792
 *  net.minecraft.class_1792$class_1793
 *  net.minecraft.class_1838
 *  net.minecraft.class_1937
 *  net.minecraft.class_2248
 *  net.minecraft.class_2338
 *  net.minecraft.class_2394
 *  net.minecraft.class_2398
 *  net.minecraft.class_2400
 *  net.minecraft.class_2680
 *  net.minecraft.class_2960
 *  net.minecraft.class_3414
 *  net.minecraft.class_3417
 *  net.minecraft.class_3419
 *  net.minecraft.class_5945
 *  net.minecraft.class_5953
 *  net.minecraft.class_5955
 *  net.minecraft.class_6017
 *  net.minecraft.class_6019
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package dev.mim1q.derelict.item;

import com.google.common.collect.BiMap;
import dev.mim1q.derelict.DerelictClient;
import dev.mim1q.derelict.block.flickering.FlickeringBlock;
import dev.mim1q.derelict.init.ModBlocksAndItems;
import dev.mim1q.derelict.item.CrosshairTipItem;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.class_1269;
import net.minecraft.class_1792;
import net.minecraft.class_1838;
import net.minecraft.class_1937;
import net.minecraft.class_2248;
import net.minecraft.class_2338;
import net.minecraft.class_2394;
import net.minecraft.class_2398;
import net.minecraft.class_2400;
import net.minecraft.class_2680;
import net.minecraft.class_2960;
import net.minecraft.class_3414;
import net.minecraft.class_3417;
import net.minecraft.class_3419;
import net.minecraft.class_5945;
import net.minecraft.class_5953;
import net.minecraft.class_5955;
import net.minecraft.class_6017;
import net.minecraft.class_6019;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/*
 * Uses 'sealed' constructs - enablewith --sealed true
 */
@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u00012\u00020\u0002:\u0002)*B\u0011\b\u0004\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0005\u0010\u0006J\u0019\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016\u00a2\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\r\u001a\u00020\fH\u0016\u00a2\u0006\u0004\b\r\u0010\u000eJ\u0019\u0010\u000f\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\u0007H&\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0012\u001a\u00020\u0011H\u0016\u00a2\u0006\u0004\b\u0014\u0010\u0015J5\u0010\u0019\u001a\u0004\u0018\u00010\u00072\"\u0010\u0018\u001a\u0012\u0012\u000e\b\u0001\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u00170\u0016\"\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0017H\u0004\u00a2\u0006\u0004\b\u0019\u0010\u001aR\u0018\u0010\u001b\u001a\u0004\u0018\u00010\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0016\u0010\u001d\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0014\u0010 \u001a\u00020\f8$X\u00a4\u0004\u00a2\u0006\u0006\u001a\u0004\b\u001f\u0010\u000eR\u0014\u0010$\u001a\u00020!8$X\u00a4\u0004\u00a2\u0006\u0006\u001a\u0004\b\"\u0010#R\u0014\u0010(\u001a\u00020%8$X\u00a4\u0004\u00a2\u0006\u0006\u001a\u0004\b&\u0010'\u0082\u0001\u0002+,\u00a8\u0006-"}, d2={"Ldev/mim1q/derelict/item/StaffItem;", "Lnet/minecraft/class_1792;", "Ldev/mim1q/derelict/item/CrosshairTipItem;", "Lnet/fabricmc/fabric/api/item/v1/FabricItemSettings;", "settings", "<init>", "(Lnet/fabricmc/fabric/api/item/v1/FabricItemSettings;)V", "Lnet/minecraft/class_2248;", "block", "", "shouldShowTip", "(Lnet/minecraft/class_2248;)Z", "Lnet/minecraft/class_2960;", "getTipTexture", "()Lnet/minecraft/class_2960;", "getBlockConversion", "(Lnet/minecraft/class_2248;)Lnet/minecraft/class_2248;", "Lnet/minecraft/class_1838;", "context", "Lnet/minecraft/class_1269;", "useOnBlock", "(Lnet/minecraft/class_1838;)Lnet/minecraft/class_1269;", "", "Lkotlin/Function0;", "suppliers", "firstNonNull", "([Lkotlin/jvm/functions/Function0;)Lnet/minecraft/class_2248;", "lastBlock", "Lnet/minecraft/class_2248;", "didShowTip", "Z", "getTexture", "texture", "Lnet/minecraft/class_2394;", "getParticle", "()Lnet/minecraft/class_2394;", "particle", "Lnet/minecraft/class_3414;", "getSound", "()Lnet/minecraft/class_3414;", "sound", "Aging", "Waxing", "Ldev/mim1q/derelict/item/StaffItem$Aging;", "Ldev/mim1q/derelict/item/StaffItem$Waxing;", "derelict"})
@SourceDebugExtension(value={"SMAP\nStaffItem.kt\nKotlin\n*S Kotlin\n*F\n+ 1 StaffItem.kt\ndev/mim1q/derelict/item/StaffItem\n+ 2 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n*L\n1#1,111:1\n13346#2,2:112\n*S KotlinDebug\n*F\n+ 1 StaffItem.kt\ndev/mim1q/derelict/item/StaffItem\n*L\n90#1:112,2\n*E\n"})
public abstract class StaffItem
extends class_1792
implements CrosshairTipItem {
    @Nullable
    private class_2248 lastBlock;
    private boolean didShowTip;

    private StaffItem(FabricItemSettings settings) {
        super((class_1792.class_1793)settings);
    }

    @NotNull
    protected abstract class_2960 getTexture();

    @NotNull
    protected abstract class_2394 getParticle();

    @NotNull
    protected abstract class_3414 getSound();

    @Override
    public boolean shouldShowTip(@Nullable class_2248 block) {
        if (block == null) {
            return false;
        }
        if (Intrinsics.areEqual((Object)block, (Object)this.lastBlock)) {
            return this.didShowTip;
        }
        this.lastBlock = block;
        this.didShowTip = this.getBlockConversion(block) != null;
        return this.didShowTip;
    }

    @Override
    @NotNull
    public class_2960 getTipTexture() {
        return this.getTexture();
    }

    @Nullable
    public abstract class_2248 getBlockConversion(@NotNull class_2248 var1);

    @NotNull
    public class_1269 method_7884(@NotNull class_1838 context) {
        Intrinsics.checkNotNullParameter((Object)context, (String)"context");
        class_1937 world = context.method_8045();
        class_2338 pos = context.method_8037();
        class_2680 state = world.method_8320(pos);
        class_2248 class_22482 = state.method_26204();
        Intrinsics.checkNotNullExpressionValue((Object)class_22482, (String)"getBlock(...)");
        class_2248 conversion = this.getBlockConversion(class_22482);
        if (conversion != null) {
            if (world.field_9236) {
                class_5945.method_34682((class_1937)world, (class_2338)pos, (class_2394)this.getParticle(), (class_6017)((class_6017)class_6019.method_35017((int)3, (int)5)));
            }
            world.method_8396(null, pos, this.getSound(), class_3419.field_15245, 1.0f, 1.0f);
            world.method_8501(context.method_8037(), conversion.method_34725(state));
            if (conversion instanceof FlickeringBlock) {
                world.method_39279(pos, conversion, 1);
            }
            return class_1269.field_5812;
        }
        return class_1269.field_5811;
    }

    @Nullable
    protected final class_2248 firstNonNull(Function0<? extends class_2248> ... suppliers) {
        Intrinsics.checkNotNullParameter(suppliers, (String)"suppliers");
        Function0<? extends class_2248>[] $this$forEach$iv = suppliers;
        boolean $i$f$forEach = false;
        int n = $this$forEach$iv.length;
        for (int i = 0; i < n; ++i) {
            class_2248 block;
            Function0<? extends class_2248> element$iv;
            Function0<? extends class_2248> it = element$iv = $this$forEach$iv[i];
            boolean bl = false;
            class_2248 class_22482 = block = (class_2248)it.invoke();
            if (class_22482 == null) continue;
            return class_22482;
        }
        return null;
    }

    public /* synthetic */ StaffItem(FabricItemSettings settings, DefaultConstructorMarker $constructor_marker) {
        this(settings);
    }

    @Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0004\u0010\u0005J\u0019\u0010\b\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a2\u0006\u0004\b\b\u0010\tJ\u0019\u0010\u000b\u001a\u00020\n2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016\u00a2\u0006\u0004\b\u000b\u0010\fR\u001a\u0010\u000e\u001a\u00020\r8\u0014X\u0094\u0004\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0013\u001a\u00020\u00128\u0014X\u0094\u0004\u00a2\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0018\u001a\u00020\u00178\u0014X\u0094\u0004\u00a2\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\u00a8\u0006\u001c"}, d2={"Ldev/mim1q/derelict/item/StaffItem$Aging;", "Ldev/mim1q/derelict/item/StaffItem;", "Lnet/fabricmc/fabric/api/item/v1/FabricItemSettings;", "settings", "<init>", "(Lnet/fabricmc/fabric/api/item/v1/FabricItemSettings;)V", "Lnet/minecraft/class_2248;", "block", "getBlockConversion", "(Lnet/minecraft/class_2248;)Lnet/minecraft/class_2248;", "", "shouldShowTip", "(Lnet/minecraft/class_2248;)Z", "Lnet/minecraft/class_2960;", "texture", "Lnet/minecraft/class_2960;", "getTexture", "()Lnet/minecraft/class_2960;", "Lnet/minecraft/class_2394;", "particle", "Lnet/minecraft/class_2394;", "getParticle", "()Lnet/minecraft/class_2394;", "Lnet/minecraft/class_3414;", "sound", "Lnet/minecraft/class_3414;", "getSound", "()Lnet/minecraft/class_3414;", "derelict"})
    @SourceDebugExtension(value={"SMAP\nStaffItem.kt\nKotlin\n*S Kotlin\n*F\n+ 1 StaffItem.kt\ndev/mim1q/derelict/item/StaffItem$Aging\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,111:1\n1#2:112\n*E\n"})
    public static final class Aging
    extends StaffItem {
        @NotNull
        private final class_2960 texture;
        @NotNull
        private final class_2394 particle;
        @NotNull
        private final class_3414 sound;

        public Aging(@NotNull FabricItemSettings settings) {
            Intrinsics.checkNotNullParameter((Object)settings, (String)"settings");
            super(settings, null);
            this.texture = new class_2960("textures/item/clock_00.png");
            class_2400 class_24002 = class_2398.field_23956;
            Intrinsics.checkNotNullExpressionValue((Object)class_24002, (String)"WHITE_ASH");
            this.particle = (class_2394)class_24002;
            class_3414 class_34142 = class_3417.field_15026;
            Intrinsics.checkNotNullExpressionValue((Object)class_34142, (String)"BLOCK_STONE_BREAK");
            this.sound = class_34142;
        }

        @Override
        @NotNull
        protected class_2960 getTexture() {
            return this.texture;
        }

        @Override
        @NotNull
        protected class_2394 getParticle() {
            return this.particle;
        }

        @Override
        @NotNull
        protected class_3414 getSound() {
            return this.sound;
        }

        @Override
        @Nullable
        public class_2248 getBlockConversion(@NotNull class_2248 block) {
            Intrinsics.checkNotNullParameter((Object)block, (String)"block");
            Function0[] function0Array = new Function0[]{() -> Aging.getBlockConversion$lambda$0(block), () -> Aging.getBlockConversion$lambda$1(block), () -> Aging.getBlockConversion$lambda$4(block)};
            return this.firstNonNull(function0Array);
        }

        @Override
        public boolean shouldShowTip(@Nullable class_2248 block) {
            return DerelictClient.INSTANCE.getCLIENT_CONFIG().ageableCrosshairTip() && super.shouldShowTip(block);
        }

        private static final class_2248 getBlockConversion$lambda$0(class_2248 $block) {
            Intrinsics.checkNotNullParameter((Object)$block, (String)"$block");
            return ModBlocksAndItems.INSTANCE.getBLOCK_AGING_MAP().get($block);
        }

        private static final class_2248 getBlockConversion$lambda$1(class_2248 $block) {
            Intrinsics.checkNotNullParameter((Object)$block, (String)"$block");
            return class_5955.method_34737((class_2248)$block).orElse(null);
        }

        /*
         * Enabled force condition propagation
         * Lifted jumps to return sites
         */
        private static final class_2248 getBlockConversion$lambda$4(class_2248 $block) {
            Intrinsics.checkNotNullParameter((Object)$block, (String)"$block");
            class_2248 class_22482 = (class_2248)((BiMap)class_5953.field_29561.get()).get((Object)$block);
            if (class_22482 == null) return null;
            class_2248 it = class_22482;
            boolean bl = false;
            class_2248 class_22483 = class_5955.method_34737((class_2248)it).orElse(null);
            if (class_22483 == null) return null;
            it = class_22483;
            boolean bl2 = false;
            class_2248 class_22484 = (class_2248)((BiMap)class_5953.field_29560.get()).get((Object)it);
            return class_22484;
        }
    }

    @Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0004\u0010\u0005J\u0019\u0010\b\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a2\u0006\u0004\b\b\u0010\tJ\u0019\u0010\u000b\u001a\u00020\n2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016\u00a2\u0006\u0004\b\u000b\u0010\fR\u001a\u0010\u000e\u001a\u00020\r8\u0014X\u0094\u0004\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0013\u001a\u00020\u00128\u0014X\u0094\u0004\u00a2\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0018\u001a\u00020\u00178\u0014X\u0094\u0004\u00a2\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\u00a8\u0006\u001c"}, d2={"Ldev/mim1q/derelict/item/StaffItem$Waxing;", "Ldev/mim1q/derelict/item/StaffItem;", "Lnet/fabricmc/fabric/api/item/v1/FabricItemSettings;", "settings", "<init>", "(Lnet/fabricmc/fabric/api/item/v1/FabricItemSettings;)V", "Lnet/minecraft/class_2248;", "block", "getBlockConversion", "(Lnet/minecraft/class_2248;)Lnet/minecraft/class_2248;", "", "shouldShowTip", "(Lnet/minecraft/class_2248;)Z", "Lnet/minecraft/class_2960;", "texture", "Lnet/minecraft/class_2960;", "getTexture", "()Lnet/minecraft/class_2960;", "Lnet/minecraft/class_2394;", "particle", "Lnet/minecraft/class_2394;", "getParticle", "()Lnet/minecraft/class_2394;", "Lnet/minecraft/class_3414;", "sound", "Lnet/minecraft/class_3414;", "getSound", "()Lnet/minecraft/class_3414;", "derelict"})
    public static final class Waxing
    extends StaffItem {
        @NotNull
        private final class_2960 texture;
        @NotNull
        private final class_2394 particle;
        @NotNull
        private final class_3414 sound;

        public Waxing(@NotNull FabricItemSettings settings) {
            Intrinsics.checkNotNullParameter((Object)settings, (String)"settings");
            super(settings, null);
            this.texture = new class_2960("textures/item/honeycomb.png");
            class_2400 class_24002 = class_2398.field_29642;
            Intrinsics.checkNotNullExpressionValue((Object)class_24002, (String)"WAX_ON");
            this.particle = (class_2394)class_24002;
            class_3414 class_34142 = class_3417.field_29543;
            Intrinsics.checkNotNullExpressionValue((Object)class_34142, (String)"ITEM_HONEYCOMB_WAX_ON");
            this.sound = class_34142;
        }

        @Override
        @NotNull
        protected class_2960 getTexture() {
            return this.texture;
        }

        @Override
        @NotNull
        protected class_2394 getParticle() {
            return this.particle;
        }

        @Override
        @NotNull
        protected class_3414 getSound() {
            return this.sound;
        }

        @Override
        @Nullable
        public class_2248 getBlockConversion(@NotNull class_2248 block) {
            Intrinsics.checkNotNullParameter((Object)block, (String)"block");
            Function0[] function0Array = new Function0[]{() -> Waxing.getBlockConversion$lambda$0(block)};
            return this.firstNonNull(function0Array);
        }

        @Override
        public boolean shouldShowTip(@Nullable class_2248 block) {
            return DerelictClient.INSTANCE.getCLIENT_CONFIG().waxableCrosshairTip() && super.shouldShowTip(block);
        }

        private static final class_2248 getBlockConversion$lambda$0(class_2248 $block) {
            Intrinsics.checkNotNullParameter((Object)$block, (String)"$block");
            return (class_2248)((BiMap)class_5953.field_29560.get()).get((Object)$block);
        }
    }
}

