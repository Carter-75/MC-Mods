/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Deprecated
 *  kotlin.DeprecationLevel
 *  kotlin.Metadata
 *  kotlin.ReplaceWith
 *  kotlin.collections.SetsKt
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.ranges.CharRange
 *  kotlin.ranges.ClosedRange
 *  kotlin.ranges.IntRange
 *  kotlin.ranges.LongRange
 *  kotlin.reflect.KClass
 */
package com.fasterxml.jackson.module.kotlin;

import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.Module;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.module.kotlin.ClosedRangeMixin;
import com.fasterxml.jackson.module.kotlin.KotlinAnnotationIntrospector;
import com.fasterxml.jackson.module.kotlin.KotlinBeanDeserializerModifier;
import com.fasterxml.jackson.module.kotlin.KotlinDeserializers;
import com.fasterxml.jackson.module.kotlin.KotlinFeature;
import com.fasterxml.jackson.module.kotlin.KotlinInstantiators;
import com.fasterxml.jackson.module.kotlin.KotlinKeyDeserializers;
import com.fasterxml.jackson.module.kotlin.KotlinKeySerializers;
import com.fasterxml.jackson.module.kotlin.KotlinNamesAnnotationIntrospector;
import com.fasterxml.jackson.module.kotlin.KotlinSerializers;
import com.fasterxml.jackson.module.kotlin.PackageVersion;
import com.fasterxml.jackson.module.kotlin.ReflectionCache;
import com.fasterxml.jackson.module.kotlin.SingletonSupport;
import java.util.BitSet;
import java.util.Set;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.CharRange;
import kotlin.ranges.ClosedRange;
import kotlin.ranges.IntRange;
import kotlin.ranges.LongRange;
import kotlin.reflect.KClass;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={1, 5, 1}, k=1, xi=48, d1={"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 '2\u00020\u0001:\u0002('B!\b\u0017\u0012\u0006\u0010\u0015\u001a\u00020\u0014\u0012\u0006\u0010\u0010\u001a\u00020\u000b\u0012\u0006\u0010\u0012\u001a\u00020\u000b\u00a2\u0006\u0004\b \u0010!B)\b\u0017\u0012\u0006\u0010\u0015\u001a\u00020\u0014\u0012\u0006\u0010\u0010\u001a\u00020\u000b\u0012\u0006\u0010\u0012\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\u000b\u00a2\u0006\u0004\b \u0010\"B\u0011\b\u0012\u0012\u0006\u0010$\u001a\u00020#\u00a2\u0006\u0004\b \u0010%BE\b\u0007\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0014\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u000b\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\u000b\u0012\b\b\u0002\u0010\u001a\u001a\u00020\u0019\u0012\b\b\u0002\u0010\u001e\u001a\u00020\u000b\u00a2\u0006\u0004\b \u0010&J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u001e\u0010\t\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\b0\u00078\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\nR\u0017\u0010\f\u001a\u00020\u000b8\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0010\u001a\u00020\u000b8\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\r\u001a\u0004\b\u0011\u0010\u000fR\u0017\u0010\u0012\u001a\u00020\u000b8\u0006\u00a2\u0006\f\n\u0004\b\u0012\u0010\r\u001a\u0004\b\u0013\u0010\u000fR\u0017\u0010\u0015\u001a\u00020\u00148\u0006\u00a2\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u0017\u0010\u001a\u001a\u00020\u00198\u0006\u00a2\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\u0017\u0010\u001e\u001a\u00020\u000b8\u0006\u00a2\u0006\f\n\u0004\b\u001e\u0010\r\u001a\u0004\b\u001f\u0010\u000f\u00a8\u0006)"}, d2={"Lcom/fasterxml/jackson/module/kotlin/KotlinModule;", "Lcom/fasterxml/jackson/databind/module/SimpleModule;", "Lcom/fasterxml/jackson/databind/Module$SetupContext;", "context", "", "setupModule", "(Lcom/fasterxml/jackson/databind/Module$SetupContext;)V", "", "Lkotlin/reflect/KClass;", "ignoredClassesForImplyingJsonCreator", "Ljava/util/Set;", "", "nullIsSameAsDefault", "Z", "getNullIsSameAsDefault", "()Z", "nullToEmptyCollection", "getNullToEmptyCollection", "nullToEmptyMap", "getNullToEmptyMap", "", "reflectionCacheSize", "I", "getReflectionCacheSize", "()I", "Lcom/fasterxml/jackson/module/kotlin/SingletonSupport;", "singletonSupport", "Lcom/fasterxml/jackson/module/kotlin/SingletonSupport;", "getSingletonSupport", "()Lcom/fasterxml/jackson/module/kotlin/SingletonSupport;", "strictNullChecks", "getStrictNullChecks", "<init>", "(IZZ)V", "(IZZZ)V", "Lcom/fasterxml/jackson/module/kotlin/KotlinModule$Builder;", "builder", "(Lcom/fasterxml/jackson/module/kotlin/KotlinModule$Builder;)V", "(IZZZLcom/fasterxml/jackson/module/kotlin/SingletonSupport;Z)V", "Companion", "Builder", "jackson-module-kotlin"})
public final class KotlinModule
extends SimpleModule {
    @NotNull
    public static final Companion Companion = new Companion(null);
    private final int reflectionCacheSize;
    private final boolean nullToEmptyCollection;
    private final boolean nullToEmptyMap;
    private final boolean nullIsSameAsDefault;
    @NotNull
    private final SingletonSupport singletonSupport;
    private final boolean strictNullChecks;
    @NotNull
    private final Set<KClass<?>> ignoredClassesForImplyingJsonCreator;
    public static final long serialVersionUID = 1L;

    @Deprecated(message="Use KotlinModule.Builder instead of named constructor parameters.", replaceWith=@ReplaceWith(expression="KotlinModule.Builder()\n            .withReflectionCacheSize(reflectionCacheSize)\n            .configure(KotlinFeature.NullToEmptyCollection, nullToEmptyCollection)\n            .configure(KotlinFeature.NullToEmptyMap, nullToEmptyMap)\n            .configure(KotlinFeature.NullIsSameAsDefault, nullIsSameAsDefault)\n            .configure(KotlinFeature.SingletonSupport, singletonSupport)\n            .configure(KotlinFeature.StrictNullChecks, strictNullChecks)\n            .build()", imports={"com.fasterxml.jackson.module.kotlin.KotlinFeature"}), level=DeprecationLevel.WARNING)
    public KotlinModule(int reflectionCacheSize, boolean nullToEmptyCollection, boolean nullToEmptyMap, boolean nullIsSameAsDefault, @NotNull SingletonSupport singletonSupport, boolean strictNullChecks) {
        Intrinsics.checkNotNullParameter((Object)((Object)singletonSupport), (String)"singletonSupport");
        super(KotlinModule.class.getName(), PackageVersion.VERSION);
        this.reflectionCacheSize = reflectionCacheSize;
        this.nullToEmptyCollection = nullToEmptyCollection;
        this.nullToEmptyMap = nullToEmptyMap;
        this.nullIsSameAsDefault = nullIsSameAsDefault;
        this.singletonSupport = singletonSupport;
        this.strictNullChecks = strictNullChecks;
        this.ignoredClassesForImplyingJsonCreator = SetsKt.emptySet();
    }

    public /* synthetic */ KotlinModule(int n2, boolean bl, boolean bl2, boolean bl3, SingletonSupport singletonSupport, boolean bl4, int n3, DefaultConstructorMarker defaultConstructorMarker) {
        if ((n3 & 1) != 0) {
            n2 = 512;
        }
        if ((n3 & 2) != 0) {
            bl = false;
        }
        if ((n3 & 4) != 0) {
            bl2 = false;
        }
        if ((n3 & 8) != 0) {
            bl3 = false;
        }
        if ((n3 & 0x10) != 0) {
            singletonSupport = SingletonSupport.DISABLED;
        }
        if ((n3 & 0x20) != 0) {
            bl4 = false;
        }
        this(n2, bl, bl2, bl3, singletonSupport, bl4);
    }

    public final int getReflectionCacheSize() {
        return this.reflectionCacheSize;
    }

    public final boolean getNullToEmptyCollection() {
        return this.nullToEmptyCollection;
    }

    public final boolean getNullToEmptyMap() {
        return this.nullToEmptyMap;
    }

    public final boolean getNullIsSameAsDefault() {
        return this.nullIsSameAsDefault;
    }

    @NotNull
    public final SingletonSupport getSingletonSupport() {
        return this.singletonSupport;
    }

    public final boolean getStrictNullChecks() {
        return this.strictNullChecks;
    }

    @Deprecated(message="For ABI compatibility", level=DeprecationLevel.HIDDEN)
    public /* synthetic */ KotlinModule(int reflectionCacheSize, boolean nullToEmptyCollection, boolean nullToEmptyMap) {
        this(new Builder().withReflectionCacheSize(reflectionCacheSize).configure(KotlinFeature.NullToEmptyCollection, nullToEmptyCollection).configure(KotlinFeature.NullToEmptyMap, nullToEmptyMap).disable(KotlinFeature.NullIsSameAsDefault));
    }

    @Deprecated(message="For ABI compatibility", level=DeprecationLevel.HIDDEN)
    public /* synthetic */ KotlinModule(int reflectionCacheSize, boolean nullToEmptyCollection, boolean nullToEmptyMap, boolean nullIsSameAsDefault) {
        this(new Builder().withReflectionCacheSize(reflectionCacheSize).configure(KotlinFeature.NullToEmptyCollection, nullToEmptyCollection).configure(KotlinFeature.NullToEmptyMap, nullToEmptyMap).configure(KotlinFeature.NullIsSameAsDefault, nullIsSameAsDefault));
    }

    private KotlinModule(Builder builder) {
        this(builder.getReflectionCacheSize(), builder.isEnabled(KotlinFeature.NullToEmptyCollection), builder.isEnabled(KotlinFeature.NullToEmptyMap), builder.isEnabled(KotlinFeature.NullIsSameAsDefault), builder.isEnabled(KotlinFeature.SingletonSupport) ? SingletonSupport.CANONICALIZE : SingletonSupport.DISABLED, builder.isEnabled(KotlinFeature.StrictNullChecks));
    }

    @Override
    public void setupModule(@NotNull Module.SetupContext context) {
        Intrinsics.checkNotNullParameter((Object)context, (String)"context");
        super.setupModule(context);
        if (!context.isEnabled(MapperFeature.USE_ANNOTATIONS)) {
            throw new IllegalStateException("The Jackson Kotlin module requires USE_ANNOTATIONS to be true or it cannot function");
        }
        ReflectionCache cache2 = new ReflectionCache(this.reflectionCacheSize);
        context.addValueInstantiators(new KotlinInstantiators(cache2, this.nullToEmptyCollection, this.nullToEmptyMap, this.nullIsSameAsDefault, this.strictNullChecks));
        SingletonSupport singletonSupport = this.singletonSupport;
        int n2 = WhenMappings.$EnumSwitchMapping$0[singletonSupport.ordinal()];
        switch (n2) {
            case 1: {
                break;
            }
            case 2: {
                context.addBeanDeserializerModifier(KotlinBeanDeserializerModifier.INSTANCE);
            }
        }
        context.insertAnnotationIntrospector(new KotlinAnnotationIntrospector(context, cache2, this.nullToEmptyCollection, this.nullToEmptyMap, this.nullIsSameAsDefault));
        context.appendAnnotationIntrospector(new KotlinNamesAnnotationIntrospector(this, cache2, this.ignoredClassesForImplyingJsonCreator));
        context.addDeserializers(new KotlinDeserializers());
        context.addKeyDeserializers(KotlinKeyDeserializers.INSTANCE);
        context.addSerializers(new KotlinSerializers());
        context.addKeySerializers(new KotlinKeySerializers());
        KotlinModule.setupModule$addMixIn(context, IntRange.class, ClosedRangeMixin.class);
        KotlinModule.setupModule$addMixIn(context, CharRange.class, ClosedRangeMixin.class);
        KotlinModule.setupModule$addMixIn(context, LongRange.class, ClosedRangeMixin.class);
        KotlinModule.setupModule$addMixIn(context, ClosedRange.class, ClosedRangeMixin.class);
    }

    private static final void setupModule$addMixIn(Module.SetupContext $context, Class<?> clazz, Class<?> mixin) {
        $context.setMixInAnnotations(clazz, mixin);
    }

    @Deprecated(message="Use KotlinModule.Builder instead of named constructor parameters.", replaceWith=@ReplaceWith(expression="KotlinModule.Builder()\n            .withReflectionCacheSize(reflectionCacheSize)\n            .configure(KotlinFeature.NullToEmptyCollection, nullToEmptyCollection)\n            .configure(KotlinFeature.NullToEmptyMap, nullToEmptyMap)\n            .configure(KotlinFeature.NullIsSameAsDefault, nullIsSameAsDefault)\n            .configure(KotlinFeature.SingletonSupport, singletonSupport)\n            .configure(KotlinFeature.StrictNullChecks, strictNullChecks)\n            .build()", imports={"com.fasterxml.jackson.module.kotlin.KotlinFeature"}), level=DeprecationLevel.WARNING)
    public KotlinModule() {
        this(0, false, false, false, null, false, 63, null);
    }

    public /* synthetic */ KotlinModule(Builder builder, DefaultConstructorMarker $constructor_marker) {
        this(builder);
    }

    @Metadata(mv={1, 5, 1}, k=1, xi=48, d1={"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2={"Lcom/fasterxml/jackson/module/kotlin/KotlinModule$Companion;", "", "", "serialVersionUID", "J", "<init>", "()V", "jackson-module-kotlin"})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }

    @Metadata(mv={1, 5, 1}, k=1, xi=48, d1={"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b*\u0010+J\r\u0010\u0003\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0003\u0010\u0004J\u001d\u0010\t\u001a\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007\u00a2\u0006\u0004\b\t\u0010\nJ\u0015\u0010\u000b\u001a\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u0005\u00a2\u0006\u0004\b\u000b\u0010\fJ\u0015\u0010\r\u001a\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u0005\u00a2\u0006\u0004\b\r\u0010\fJ\u000f\u0010\u000e\u001a\u00020\u0007H\u0007\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\u0007H\u0007\u00a2\u0006\u0004\b\u0010\u0010\u000fJ\u000f\u0010\u0011\u001a\u00020\u0007H\u0007\u00a2\u0006\u0004\b\u0011\u0010\u000fJ\u000f\u0010\u0013\u001a\u00020\u0012H\u0007\u00a2\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0015\u001a\u00020\u0007H\u0007\u00a2\u0006\u0004\b\u0015\u0010\u000fJ\u0015\u0010\u0016\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005\u00a2\u0006\u0004\b\u0016\u0010\u0017J\u0017\u0010\u0018\u001a\u00020\u00002\u0006\u0010\u0018\u001a\u00020\u0007H\u0007\u00a2\u0006\u0004\b\u0018\u0010\u0019J\u0017\u0010\u001a\u001a\u00020\u00002\u0006\u0010\u001a\u001a\u00020\u0007H\u0007\u00a2\u0006\u0004\b\u001a\u0010\u0019J\u0017\u0010\u001b\u001a\u00020\u00002\u0006\u0010\u001b\u001a\u00020\u0007H\u0007\u00a2\u0006\u0004\b\u001b\u0010\u0019J\u0017\u0010\u001d\u001a\u00020\u00002\u0006\u0010\u001d\u001a\u00020\u001cH\u0007\u00a2\u0006\u0004\b\u001d\u0010\u001eJ\u0017\u0010\u001f\u001a\u00020\u00002\u0006\u0010\u001f\u001a\u00020\u0012H\u0007\u00a2\u0006\u0004\b\u001f\u0010 J\u0017\u0010!\u001a\u00020\u00002\u0006\u0010!\u001a\u00020\u0007H\u0007\u00a2\u0006\u0004\b!\u0010\u0019J\u0015\u0010\"\u001a\u00020\u00002\u0006\u0010\u001d\u001a\u00020\u001c\u00a2\u0006\u0004\b\"\u0010\u001eR\u0014\u0010$\u001a\u00020#8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b$\u0010%R$\u0010\u001d\u001a\u00020\u001c2\u0006\u0010&\u001a\u00020\u001c8\u0006@BX\u0086\u000e\u00a2\u0006\f\n\u0004\b\u001d\u0010'\u001a\u0004\b(\u0010)\u00a8\u0006,"}, d2={"Lcom/fasterxml/jackson/module/kotlin/KotlinModule$Builder;", "", "Lcom/fasterxml/jackson/module/kotlin/KotlinModule;", "build", "()Lcom/fasterxml/jackson/module/kotlin/KotlinModule;", "Lcom/fasterxml/jackson/module/kotlin/KotlinFeature;", "feature", "", "enabled", "configure", "(Lcom/fasterxml/jackson/module/kotlin/KotlinFeature;Z)Lcom/fasterxml/jackson/module/kotlin/KotlinModule$Builder;", "disable", "(Lcom/fasterxml/jackson/module/kotlin/KotlinFeature;)Lcom/fasterxml/jackson/module/kotlin/KotlinModule$Builder;", "enable", "getNullIsSameAsDefault", "()Z", "getNullToEmptyCollection", "getNullToEmptyMap", "Lcom/fasterxml/jackson/module/kotlin/SingletonSupport;", "getSingletonSupport", "()Lcom/fasterxml/jackson/module/kotlin/SingletonSupport;", "getStrictNullChecks", "isEnabled", "(Lcom/fasterxml/jackson/module/kotlin/KotlinFeature;)Z", "nullIsSameAsDefault", "(Z)Lcom/fasterxml/jackson/module/kotlin/KotlinModule$Builder;", "nullToEmptyCollection", "nullToEmptyMap", "", "reflectionCacheSize", "(I)Lcom/fasterxml/jackson/module/kotlin/KotlinModule$Builder;", "singletonSupport", "(Lcom/fasterxml/jackson/module/kotlin/SingletonSupport;)Lcom/fasterxml/jackson/module/kotlin/KotlinModule$Builder;", "strictNullChecks", "withReflectionCacheSize", "Ljava/util/BitSet;", "bitSet", "Ljava/util/BitSet;", "<set-?>", "I", "getReflectionCacheSize", "()I", "<init>", "()V", "jackson-module-kotlin"})
    public static final class Builder {
        private int reflectionCacheSize = 512;
        @NotNull
        private final BitSet bitSet = KotlinFeature.Companion.getDefaults$jackson_module_kotlin();

        public final int getReflectionCacheSize() {
            return this.reflectionCacheSize;
        }

        @NotNull
        public final Builder withReflectionCacheSize(int reflectionCacheSize) {
            Builder builder = this;
            boolean bl = false;
            boolean bl2 = false;
            Builder $this$withReflectionCacheSize_u24lambda_u2d0 = builder;
            boolean bl3 = false;
            $this$withReflectionCacheSize_u24lambda_u2d0.reflectionCacheSize = reflectionCacheSize;
            return builder;
        }

        @NotNull
        public final Builder enable(@NotNull KotlinFeature feature) {
            Intrinsics.checkNotNullParameter((Object)((Object)feature), (String)"feature");
            Builder builder = this;
            boolean bl = false;
            boolean bl2 = false;
            Builder $this$enable_u24lambda_u2d1 = builder;
            boolean bl3 = false;
            $this$enable_u24lambda_u2d1.bitSet.or(feature.getBitSet$jackson_module_kotlin());
            return builder;
        }

        @NotNull
        public final Builder disable(@NotNull KotlinFeature feature) {
            Intrinsics.checkNotNullParameter((Object)((Object)feature), (String)"feature");
            Builder builder = this;
            boolean bl = false;
            boolean bl2 = false;
            Builder $this$disable_u24lambda_u2d2 = builder;
            boolean bl3 = false;
            $this$disable_u24lambda_u2d2.bitSet.andNot(feature.getBitSet$jackson_module_kotlin());
            return builder;
        }

        @NotNull
        public final Builder configure(@NotNull KotlinFeature feature, boolean enabled) {
            Intrinsics.checkNotNullParameter((Object)((Object)feature), (String)"feature");
            return enabled ? this.enable(feature) : this.disable(feature);
        }

        public final boolean isEnabled(@NotNull KotlinFeature feature) {
            Intrinsics.checkNotNullParameter((Object)((Object)feature), (String)"feature");
            return this.bitSet.intersects(feature.getBitSet$jackson_module_kotlin());
        }

        @Deprecated(message="Deprecated, use withReflectionCacheSize(reflectionCacheSize) instead.", replaceWith=@ReplaceWith(expression="withReflectionCacheSize(reflectionCacheSize)", imports={}))
        @NotNull
        public final Builder reflectionCacheSize(int reflectionCacheSize) {
            return this.withReflectionCacheSize(reflectionCacheSize);
        }

        @Deprecated(message="Deprecated, use isEnabled(NullToEmptyCollection) instead.", replaceWith=@ReplaceWith(expression="isEnabled(KotlinFeature.NullToEmptyCollection)", imports={"com.fasterxml.jackson.module.kotlin.KotlinFeature"}))
        public final boolean getNullToEmptyCollection() {
            return this.isEnabled(KotlinFeature.NullToEmptyCollection);
        }

        @Deprecated(message="Deprecated, use configure(NullToEmptyCollection, enabled) instead.", replaceWith=@ReplaceWith(expression="configure(KotlinFeature.NullToEmptyCollection, nullToEmptyCollection)", imports={"com.fasterxml.jackson.module.kotlin.KotlinFeature"}))
        @NotNull
        public final Builder nullToEmptyCollection(boolean nullToEmptyCollection) {
            return this.configure(KotlinFeature.NullToEmptyCollection, nullToEmptyCollection);
        }

        @Deprecated(message="Deprecated, use isEnabled(NullToEmptyMap) instead.", replaceWith=@ReplaceWith(expression="isEnabled(KotlinFeature.NullToEmptyMap)", imports={"com.fasterxml.jackson.module.kotlin.KotlinFeature"}))
        public final boolean getNullToEmptyMap() {
            return this.isEnabled(KotlinFeature.NullToEmptyMap);
        }

        @Deprecated(message="Deprecated, use configure(NullToEmptyMap, enabled) instead.", replaceWith=@ReplaceWith(expression="configure(KotlinFeature.NullToEmptyMap, nullToEmptyMap)", imports={"com.fasterxml.jackson.module.kotlin.KotlinFeature"}))
        @NotNull
        public final Builder nullToEmptyMap(boolean nullToEmptyMap) {
            return this.configure(KotlinFeature.NullToEmptyMap, nullToEmptyMap);
        }

        @Deprecated(message="Deprecated, use isEnabled(NullIsSameAsDefault) instead.", replaceWith=@ReplaceWith(expression="isEnabled(KotlinFeature.NullIsSameAsDefault)", imports={"com.fasterxml.jackson.module.kotlin.KotlinFeature"}))
        public final boolean getNullIsSameAsDefault() {
            return this.isEnabled(KotlinFeature.NullIsSameAsDefault);
        }

        @Deprecated(message="Deprecated, use configure(NullIsSameAsDefault, enabled) instead.", replaceWith=@ReplaceWith(expression="configure(KotlinFeature.NullIsSameAsDefault, nullIsSameAsDefault)", imports={"com.fasterxml.jackson.module.kotlin.KotlinFeature"}))
        @NotNull
        public final Builder nullIsSameAsDefault(boolean nullIsSameAsDefault) {
            return this.configure(KotlinFeature.NullIsSameAsDefault, nullIsSameAsDefault);
        }

        @Deprecated(message="Deprecated, use isEnabled(SingletonSupport) instead.", replaceWith=@ReplaceWith(expression="isEnabled(KotlinFeature.SingletonSupport)", imports={"com.fasterxml.jackson.module.kotlin.KotlinFeature"}))
        @NotNull
        public final SingletonSupport getSingletonSupport() {
            return this.isEnabled(KotlinFeature.SingletonSupport) ? SingletonSupport.CANONICALIZE : SingletonSupport.DISABLED;
        }

        @Deprecated(message="Deprecated, use configure(SingletonSupport, enabled) instead.", replaceWith=@ReplaceWith(expression="configure(KotlinFeature.SingletonSupport, singletonSupport)", imports={"com.fasterxml.jackson.module.kotlin.KotlinFeature"}))
        @NotNull
        public final Builder singletonSupport(@NotNull SingletonSupport singletonSupport) {
            Intrinsics.checkNotNullParameter((Object)((Object)singletonSupport), (String)"singletonSupport");
            SingletonSupport singletonSupport2 = singletonSupport;
            int n2 = WhenMappings.$EnumSwitchMapping$0[singletonSupport2.ordinal()];
            return n2 == 1 ? this.enable(KotlinFeature.SingletonSupport) : this.disable(KotlinFeature.SingletonSupport);
        }

        @Deprecated(message="Deprecated, use isEnabled(StrictNullChecks) instead.", replaceWith=@ReplaceWith(expression="isEnabled(KotlinFeature.StrictNullChecks)", imports={"com.fasterxml.jackson.module.kotlin.KotlinFeature"}))
        public final boolean getStrictNullChecks() {
            return this.isEnabled(KotlinFeature.StrictNullChecks);
        }

        @Deprecated(message="Deprecated, use configure(StrictNullChecks, enabled) instead.", replaceWith=@ReplaceWith(expression="configure(KotlinFeature.StrictNullChecks, strictNullChecks)", imports={"com.fasterxml.jackson.module.kotlin.KotlinFeature"}))
        @NotNull
        public final Builder strictNullChecks(boolean strictNullChecks) {
            return this.configure(KotlinFeature.StrictNullChecks, strictNullChecks);
        }

        @NotNull
        public final KotlinModule build() {
            return new KotlinModule(this, null);
        }

        @Metadata(mv={1, 5, 1}, k=3, xi=48)
        public final class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                int[] nArray = new int[SingletonSupport.values().length];
                nArray[SingletonSupport.CANONICALIZE.ordinal()] = 1;
                $EnumSwitchMapping$0 = nArray;
            }
        }
    }

    @Metadata(mv={1, 5, 1}, k=3, xi=48)
    public final class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] nArray = new int[SingletonSupport.values().length];
            nArray[SingletonSupport.DISABLED.ordinal()] = 1;
            nArray[SingletonSupport.CANONICALIZE.ordinal()] = 2;
            $EnumSwitchMapping$0 = nArray;
        }
    }
}

