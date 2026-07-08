/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.DefaultConstructorMarker
 */
package com.fasterxml.jackson.module.kotlin;

import com.fasterxml.jackson.module.kotlin.ExtensionsKt;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={1, 5, 1}, k=1, xi=48, d1={"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u000b\b\u0086\u0001\u0018\u0000 \f2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\fB\u0011\b\u0002\u0012\u0006\u0010\b\u001a\u00020\u0007\u00a2\u0006\u0004\b\n\u0010\u000bR\u001a\u0010\u0003\u001a\u00020\u00028\u0000X\u0080\u0004\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\b\u001a\u00020\u00078\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\b\u0010\tj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011\u00a8\u0006\u0012"}, d2={"Lcom/fasterxml/jackson/module/kotlin/KotlinFeature;", "", "Ljava/util/BitSet;", "bitSet", "Ljava/util/BitSet;", "getBitSet$jackson_module_kotlin", "()Ljava/util/BitSet;", "", "enabledByDefault", "Z", "<init>", "(Ljava/lang/String;IZ)V", "Companion", "NullToEmptyCollection", "NullToEmptyMap", "NullIsSameAsDefault", "SingletonSupport", "StrictNullChecks", "jackson-module-kotlin"})
public final class KotlinFeature
extends Enum<KotlinFeature> {
    @NotNull
    public static final Companion Companion;
    private final boolean enabledByDefault;
    @NotNull
    private final BitSet bitSet;
    public static final /* enum */ KotlinFeature NullToEmptyCollection;
    public static final /* enum */ KotlinFeature NullToEmptyMap;
    public static final /* enum */ KotlinFeature NullIsSameAsDefault;
    public static final /* enum */ KotlinFeature SingletonSupport;
    public static final /* enum */ KotlinFeature StrictNullChecks;
    private static final /* synthetic */ KotlinFeature[] $VALUES;

    private KotlinFeature(boolean enabledByDefault) {
        this.enabledByDefault = enabledByDefault;
        double d2 = 2.0;
        int n2 = this.ordinal();
        boolean bl = false;
        this.bitSet = ExtensionsKt.toBitSet((int)Math.pow(d2, n2));
    }

    @NotNull
    public final BitSet getBitSet$jackson_module_kotlin() {
        return this.bitSet;
    }

    public static KotlinFeature[] values() {
        return (KotlinFeature[])$VALUES.clone();
    }

    public static KotlinFeature valueOf(String value) {
        return Enum.valueOf(KotlinFeature.class, value);
    }

    static {
        NullToEmptyCollection = new KotlinFeature(false);
        NullToEmptyMap = new KotlinFeature(false);
        NullIsSameAsDefault = new KotlinFeature(false);
        SingletonSupport = new KotlinFeature(false);
        StrictNullChecks = new KotlinFeature(false);
        $VALUES = kotlinFeatureArray = new KotlinFeature[]{KotlinFeature.NullToEmptyCollection, KotlinFeature.NullToEmptyMap, KotlinFeature.NullIsSameAsDefault, KotlinFeature.SingletonSupport, KotlinFeature.StrictNullChecks};
        Companion = new Companion(null);
    }

    @Metadata(mv={1, 5, 1}, k=1, xi=48, d1={"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\u0005\u001a\u00020\u00028@X\u0080\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004\u00a8\u0006\b"}, d2={"Lcom/fasterxml/jackson/module/kotlin/KotlinFeature$Companion;", "", "Ljava/util/BitSet;", "getDefaults$jackson_module_kotlin", "()Ljava/util/BitSet;", "defaults", "<init>", "()V", "jackson-module-kotlin"})
    public static final class Companion {
        private Companion() {
        }

        /*
         * WARNING - void declaration
         */
        @NotNull
        public final BitSet getDefaults$jackson_module_kotlin() {
            void $this$forEach$iv;
            void $this$filterTo$iv$iv;
            BitSet bitSet = ExtensionsKt.toBitSet(0);
            boolean bl = false;
            boolean bl2 = false;
            BitSet $this$_get_defaults__u24lambda_u2d2 = bitSet;
            boolean bl3 = false;
            Object $this$filter$iv = KotlinFeature.values();
            boolean $i$f$filter = false;
            KotlinFeature[] kotlinFeatureArray = $this$filter$iv;
            Collection destination$iv$iv = new ArrayList();
            boolean $i$f$filterTo = false;
            void var11_12 = $this$filterTo$iv$iv;
            int n2 = ((void)var11_12).length;
            for (int i2 = 0; i2 < n2; ++i2) {
                void element$iv$iv;
                void it = element$iv$iv = var11_12[i2];
                boolean bl4 = false;
                if (!((KotlinFeature)it).enabledByDefault) continue;
                destination$iv$iv.add(element$iv$iv);
            }
            $this$filter$iv = (List)destination$iv$iv;
            boolean $i$f$forEach = false;
            for (Object element$iv : $this$forEach$iv) {
                KotlinFeature it = (KotlinFeature)((Object)element$iv);
                boolean bl5 = false;
                $this$_get_defaults__u24lambda_u2d2.or(it.getBitSet$jackson_module_kotlin());
            }
            return bitSet;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }
}

