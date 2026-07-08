/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.datafixers.kinds.App
 *  com.mojang.datafixers.kinds.Applicative
 *  com.mojang.serialization.Codec
 *  com.mojang.serialization.codecs.RecordCodecBuilder
 *  com.mojang.serialization.codecs.RecordCodecBuilder$Instance
 *  kotlin.Metadata
 *  kotlin.Pair
 *  kotlin.Unit
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  kotlin.jvm.optionals.OptionalsKt
 *  kotlin.reflect.KProperty1
 *  net.minecraft.class_1922
 *  net.minecraft.class_1936
 *  net.minecraft.class_2338
 *  net.minecraft.class_2338$class_2339
 *  net.minecraft.class_2350
 *  net.minecraft.class_2470
 *  net.minecraft.class_2680
 *  net.minecraft.class_2960
 *  net.minecraft.class_3031
 *  net.minecraft.class_3037
 *  net.minecraft.class_3485
 *  net.minecraft.class_3492
 *  net.minecraft.class_3499
 *  net.minecraft.class_3499$class_3501
 *  net.minecraft.class_3499$class_5162
 *  net.minecraft.class_5281
 *  net.minecraft.class_5425
 *  net.minecraft.class_5819
 *  net.minecraft.class_5821
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package dev.mim1q.derelict.world.feature;

import com.mojang.datafixers.kinds.App;
import com.mojang.datafixers.kinds.Applicative;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import dev.mim1q.derelict.util.MathUtilsKt;
import dev.mim1q.derelict.world.feature.NbtFeature;
import dev.mim1q.derelict.world.feature.SpiderSilkPillarKt;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.optionals.OptionalsKt;
import kotlin.reflect.KProperty1;
import net.minecraft.class_1922;
import net.minecraft.class_1936;
import net.minecraft.class_2338;
import net.minecraft.class_2350;
import net.minecraft.class_2470;
import net.minecraft.class_2680;
import net.minecraft.class_2960;
import net.minecraft.class_3031;
import net.minecraft.class_3037;
import net.minecraft.class_3485;
import net.minecraft.class_3492;
import net.minecraft.class_3499;
import net.minecraft.class_5281;
import net.minecraft.class_5425;
import net.minecraft.class_5819;
import net.minecraft.class_5821;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\nB\u0007\u00a2\u0006\u0004\b\u0003\u0010\u0004J\u001d\u0010\b\u001a\u00020\u00072\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u0005H\u0016\u00a2\u0006\u0004\b\b\u0010\t\u00a8\u0006\u000b"}, d2={"Ldev/mim1q/derelict/world/feature/NbtFeature;", "Lnet/minecraft/class_3031;", "Ldev/mim1q/derelict/world/feature/NbtFeature$NbtFeatureConfig;", "<init>", "()V", "Lnet/minecraft/class_5821;", "context", "", "generate", "(Lnet/minecraft/class_5821;)Z", "NbtFeatureConfig", "derelict"})
@SourceDebugExtension(value={"SMAP\nNbtFeature.kt\nKotlin\n*S Kotlin\n*F\n+ 1 NbtFeature.kt\ndev/mim1q/derelict/world/feature/NbtFeature\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 Maps.kt\nkotlin/collections/MapsKt__MapsKt\n*L\n1#1,77:1\n1863#2,2:78\n1863#2:80\n1864#2:88\n381#3,7:81\n*S KotlinDebug\n*F\n+ 1 NbtFeature.kt\ndev/mim1q/derelict/world/feature/NbtFeature\n*L\n30#1:78,2\n36#1:80\n36#1:88\n37#1:81,7\n*E\n"})
public final class NbtFeature
extends class_3031<NbtFeatureConfig> {
    public NbtFeature() {
        super(NbtFeatureConfig.Companion.getCODEC());
    }

    /*
     * WARNING - void declaration
     */
    public boolean method_13151(@NotNull class_5821<NbtFeatureConfig> context) {
        Object it;
        ArrayList arrayList;
        Intrinsics.checkNotNullParameter(context, (String)"context");
        class_3485 manager = context.method_33652().method_8410().method_14183();
        Map<class_2960, Integer> map = ((NbtFeatureConfig)context.method_33656()).getStructures();
        class_5819 class_58192 = context.method_33654();
        Intrinsics.checkNotNullExpressionValue((Object)class_58192, (String)"getRandom(...)");
        class_2960 chosenTemplateId = MathUtilsKt.pickWeightedRandom(map, class_58192);
        Optional optional = manager.method_15094(chosenTemplateId);
        Intrinsics.checkNotNullExpressionValue((Object)optional, (String)"getTemplate(...)");
        class_3499 class_34992 = (class_3499)OptionalsKt.getOrNull((Optional)optional);
        if (class_34992 == null) {
            return false;
        }
        class_3499 template = class_34992;
        class_2470 rotation = class_2470.method_16548((class_5819)context.method_33654());
        ArrayList arrayList2 = arrayList = new ArrayList();
        class_3492 class_34922 = new class_3492().method_15123(rotation);
        class_2338 class_23382 = context.method_33655();
        class_2338 class_23383 = context.method_33655();
        class_5425 class_54252 = (class_5425)context.method_33652();
        boolean bl = false;
        List list = template.field_15586;
        Intrinsics.checkNotNullExpressionValue((Object)list, (String)"blockInfoLists");
        Iterable $this$forEach$iv = list;
        boolean $i$f$forEach = false;
        for (Object element$iv : $this$forEach$iv) {
            void $this$generate_u24lambda_u241;
            it = (class_3499.class_5162)element$iv;
            boolean bl2 = false;
            $this$generate_u24lambda_u241.addAll(it.method_27125());
        }
        Unit unit = Unit.INSTANCE;
        List blocks = class_3499.method_16446((class_5425)class_54252, (class_2338)class_23383, (class_2338)class_23382, (class_3492)class_34922, (List)arrayList);
        HashMap yDeclines = new HashMap();
        Intrinsics.checkNotNull((Object)blocks);
        Iterable $this$forEach$iv2 = blocks;
        boolean $i$f$forEach2 = false;
        for (Object element$iv : $this$forEach$iv2) {
            Integer yDecline;
            Object v;
            void $this$getOrPut$iv;
            class_3499.class_3501 it2 = (class_3499.class_3501)element$iv;
            boolean bl3 = false;
            it = yDeclines;
            Pair key$iv = new Pair((Object)it2.comp_1341().method_10263(), (Object)it2.comp_1341().method_10260());
            boolean $i$f$getOrPut = false;
            Object value$iv = $this$getOrPut$iv.get(key$iv);
            if (value$iv == null) {
                Integer n;
                block7: {
                    boolean bl4 = false;
                    class_2338.class_2339 mutPos = it2.comp_1341().method_25503();
                    for (int i = 0; i < 11; ++i) {
                        if (context.method_33652().method_8320((class_2338)mutPos).method_26215()) {
                            mutPos.method_10100(0, -1, 0);
                            continue;
                        }
                        class_2680 state = context.method_33652().method_8320((class_2338)mutPos);
                        if (!state.method_51367() || !state.method_26206((class_1922)context.method_33652(), (class_2338)mutPos, class_2350.field_11036)) continue;
                        n = i - 1;
                        break block7;
                    }
                    n = null;
                }
                Integer answer$iv = n;
                $this$getOrPut$iv.put(key$iv, answer$iv);
                v = answer$iv;
            } else {
                v = value$iv;
            }
            if ((yDecline = (Integer)v) == null) continue;
            class_5281 class_52812 = context.method_33652();
            Intrinsics.checkNotNullExpressionValue((Object)class_52812, (String)"getWorld(...)");
            class_1936 class_19362 = (class_1936)class_52812;
            class_2338 class_23384 = it2.comp_1341().method_10087(yDecline.intValue());
            Intrinsics.checkNotNullExpressionValue((Object)class_23384, (String)"down(...)");
            class_2680 class_26802 = it2.comp_1342().method_26186(rotation);
            Intrinsics.checkNotNullExpressionValue((Object)class_26802, (String)"rotate(...)");
            SpiderSilkPillarKt.placeIfPossible(class_19362, class_23384, class_26802);
        }
        return true;
    }

    @Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\b\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018B\u001b\u0012\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u001c\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002H\u00c6\u0003\u00a2\u0006\u0004\b\b\u0010\tJ&\u0010\n\u001a\u00020\u00002\u0014\b\u0002\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002H\u00c6\u0001\u00a2\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\fH\u00d6\u0003\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0011\u001a\u00020\u0004H\u00d6\u0001\u00a2\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0014\u001a\u00020\u0013H\u00d6\u0001\u00a2\u0006\u0004\b\u0014\u0010\u0015R#\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010\u0016\u001a\u0004\b\u0017\u0010\t\u00a8\u0006\u0019"}, d2={"Ldev/mim1q/derelict/world/feature/NbtFeature$NbtFeatureConfig;", "Lnet/minecraft/class_3037;", "", "Lnet/minecraft/class_2960;", "", "structures", "<init>", "(Ljava/util/Map;)V", "component1", "()Ljava/util/Map;", "copy", "(Ljava/util/Map;)Ldev/mim1q/derelict/world/feature/NbtFeature$NbtFeatureConfig;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "Ljava/util/Map;", "getStructures", "Companion", "derelict"})
    public static final class NbtFeatureConfig
    implements class_3037 {
        @NotNull
        public static final Companion Companion = new Companion(null);
        @NotNull
        private final Map<class_2960, Integer> structures;
        @NotNull
        private static final Codec<NbtFeatureConfig> CODEC;

        public NbtFeatureConfig(@NotNull Map<class_2960, Integer> structures) {
            Intrinsics.checkNotNullParameter(structures, (String)"structures");
            this.structures = structures;
        }

        @NotNull
        public final Map<class_2960, Integer> getStructures() {
            return this.structures;
        }

        @NotNull
        public final Map<class_2960, Integer> component1() {
            return this.structures;
        }

        @NotNull
        public final NbtFeatureConfig copy(@NotNull Map<class_2960, Integer> structures) {
            Intrinsics.checkNotNullParameter(structures, (String)"structures");
            return new NbtFeatureConfig(structures);
        }

        public static /* synthetic */ NbtFeatureConfig copy$default(NbtFeatureConfig nbtFeatureConfig, Map map, int n, Object object) {
            if ((n & 1) != 0) {
                map = nbtFeatureConfig.structures;
            }
            return nbtFeatureConfig.copy(map);
        }

        @NotNull
        public String toString() {
            return "NbtFeatureConfig(structures=" + this.structures + ")";
        }

        public int hashCode() {
            return ((Object)this.structures).hashCode();
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof NbtFeatureConfig)) {
                return false;
            }
            NbtFeatureConfig nbtFeatureConfig = (NbtFeatureConfig)other;
            return Intrinsics.areEqual(this.structures, nbtFeatureConfig.structures);
        }

        private static final Map CODEC$lambda$1$lambda$0(KProperty1 $tmp0, NbtFeatureConfig p0) {
            Intrinsics.checkNotNullParameter((Object)$tmp0, (String)"$tmp0");
            return (Map)((Function1)$tmp0).invoke((Object)p0);
        }

        private static final App CODEC$lambda$1(RecordCodecBuilder.Instance instance) {
            Intrinsics.checkNotNullParameter((Object)instance, (String)"instance");
            return instance.group((App)Codec.unboundedMap((Codec)class_2960.field_25139, (Codec)((Codec)Codec.INT)).fieldOf("structures").forGetter(arg_0 -> NbtFeatureConfig.CODEC$lambda$1$lambda$0((KProperty1)Companion.CODEC.1.1.INSTANCE, arg_0))).apply((Applicative)instance, NbtFeatureConfig::new);
        }

        static {
            Codec codec = RecordCodecBuilder.create(NbtFeatureConfig::CODEC$lambda$1);
            Intrinsics.checkNotNullExpressionValue((Object)codec, (String)"create(...)");
            CODEC = codec;
        }

        @Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003R\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\t\u00a8\u0006\n"}, d2={"Ldev/mim1q/derelict/world/feature/NbtFeature$NbtFeatureConfig$Companion;", "", "<init>", "()V", "Lcom/mojang/serialization/Codec;", "Ldev/mim1q/derelict/world/feature/NbtFeature$NbtFeatureConfig;", "CODEC", "Lcom/mojang/serialization/Codec;", "getCODEC", "()Lcom/mojang/serialization/Codec;", "derelict"})
        public static final class Companion {
            private Companion() {
            }

            @NotNull
            public final Codec<NbtFeatureConfig> getCODEC() {
                return CODEC;
            }

            public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
                this();
            }
        }
    }
}

