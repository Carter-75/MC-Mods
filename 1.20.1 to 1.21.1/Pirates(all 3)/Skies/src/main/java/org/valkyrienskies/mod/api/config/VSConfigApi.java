/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.collections.CollectionsKt
 *  kotlin.jvm.JvmStatic
 *  kotlin.jvm.functions.Function2
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.Reflection
 *  kotlin.jvm.internal.SourceDebugExtension
 *  net.minecraftforge.common.ForgeConfigSpec$Builder
 *  net.minecraftforge.common.ForgeConfigSpec$ConfigValue
 *  net.minecraftforge.common.ForgeConfigSpec$EnumValue
 *  net.minecraftforge.fml.config.ModConfig
 */
package org.valkyrienskies.mod.api.config;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.fml.config.ModConfig;
import org.jetbrains.annotations.NotNull;
import org.valkyrienskies.core.impl.api_impl.config.VsiConfigModelImpl;
import org.valkyrienskies.core.internal.config.VsiConfigModel;
import org.valkyrienskies.core.internal.config.VsiConfigModelCategory;
import org.valkyrienskies.core.internal.config.VsiConfigModelEntry;
import org.valkyrienskies.core.internal.config.VsiConfigNode;
import org.valkyrienskies.mod.common.config.ConfigType;
import org.valkyrienskies.mod.common.hooks.VSGameEvents;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b$\u0010%J\u0017\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u0001H\u0007\u00a2\u0006\u0004\b\u0004\u0010\u0005J?\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u001e\b\u0002\u0010\u000e\u001a\u0018\u0012\u0004\u0012\u00020\u000b\u0012\b\u0012\u0006\u0012\u0002\b\u00030\f\u0012\u0004\u0012\u00020\r0\nH\u0007\u00a2\u0006\u0004\b\u000f\u0010\u0010J1\u0010\u0019\u001a\u00020\r*\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u00142\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00170\u0016H\u0007\u00a2\u0006\u0004\b\u0019\u0010\u001aJG\u0010\u001f\u001a\u00020\r*\u00020\u00062\u000e\b\u0002\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u000b0\u001b2\"\u0010\u001e\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\u001b\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u001d\u0012\u0004\u0012\u00020\r0\nH\u0002\u00a2\u0006\u0004\b\u001f\u0010 J'\u0010\"\u001a\u0006\u0012\u0002\b\u00030\f2\u0006\u0010\t\u001a\u00020\b2\n\u0010!\u001a\u0006\u0012\u0002\b\u00030\u001dH\u0002\u00a2\u0006\u0004\b\"\u0010#\u00a8\u0006&"}, d2={"Lorg/valkyrienskies/mod/api/config/VSConfigApi;", "", "annotatedConfigObject", "Lorg/valkyrienskies/core/impl/api_impl/config/VsiConfigModelImpl;", "buildVSConfigModel", "(Ljava/lang/Object;)Lorg/valkyrienskies/core/impl/api_impl/config/VsiConfigModelImpl;", "Lorg/valkyrienskies/core/internal/config/VsiConfigModelCategory;", "configCategory", "Lnet/minecraftforge/common/ForgeConfigSpec$Builder;", "builder", "Lkotlin/Function2;", "", "Lnet/minecraftforge/common/ForgeConfigSpec$ConfigValue;", "", "forgeConfigValueConsumer", "buildForgeConfigSpec", "(Lorg/valkyrienskies/core/internal/config/VsiConfigModelCategory;Lnet/minecraftforge/common/ForgeConfigSpec$Builder;Lkotlin/jvm/functions/Function2;)Lnet/minecraftforge/common/ForgeConfigSpec$Builder;", "Lorg/valkyrienskies/core/internal/config/VsiConfigModel;", "Lnet/minecraftforge/fml/config/ModConfig;", "forgeConfig", "Lorg/valkyrienskies/mod/common/config/ConfigType;", "configType", "", "Lorg/valkyrienskies/mod/common/hooks/VSGameEvents$ConfigUpdateEntry;", "updatedEntries", "update", "(Lorg/valkyrienskies/core/internal/config/VsiConfigModel;Lnet/minecraftforge/fml/config/ModConfig;Lorg/valkyrienskies/mod/common/config/ConfigType;Ljava/util/Set;)V", "", "category", "Lorg/valkyrienskies/core/internal/config/VsiConfigModelEntry;", "callback", "forEachEntry", "(Lorg/valkyrienskies/core/internal/config/VsiConfigModelCategory;Ljava/util/List;Lkotlin/jvm/functions/Function2;)V", "entry", "defineNode", "(Lnet/minecraftforge/common/ForgeConfigSpec$Builder;Lorg/valkyrienskies/core/internal/config/VsiConfigModelEntry;)Lnet/minecraftforge/common/ForgeConfigSpec$ConfigValue;", "<init>", "()V", "valkyrienskies-120"})
@SourceDebugExtension(value={"SMAP\nVSConfigApi.kt\nKotlin\n*S Kotlin\n*F\n+ 1 VSConfigApi.kt\norg/valkyrienskies/mod/api/config/VSConfigApi\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,130:1\n1#2:131\n*E\n"})
public final class VSConfigApi {
    @NotNull
    public static final VSConfigApi INSTANCE = new VSConfigApi();

    private VSConfigApi() {
    }

    @JvmStatic
    @NotNull
    public static final VsiConfigModelImpl buildVSConfigModel(@NotNull Object annotatedConfigObject) {
        Intrinsics.checkNotNullParameter((Object)annotatedConfigObject, (String)"annotatedConfigObject");
        return VsiConfigModelImpl.Companion.build(annotatedConfigObject);
    }

    @JvmStatic
    @NotNull
    public static final ForgeConfigSpec.Builder buildForgeConfigSpec(@NotNull VsiConfigModelCategory configCategory, @NotNull ForgeConfigSpec.Builder builder, @NotNull Function2<? super String, ? super ForgeConfigSpec.ConfigValue<?>, Unit> forgeConfigValueConsumer) {
        Intrinsics.checkNotNullParameter((Object)configCategory, (String)"configCategory");
        Intrinsics.checkNotNullParameter((Object)builder, (String)"builder");
        Intrinsics.checkNotNullParameter(forgeConfigValueConsumer, (String)"forgeConfigValueConsumer");
        for (Map.Entry<String, VsiConfigNode> node : configCategory.getChildren().entrySet()) {
            VsiConfigNode entry = node.getValue();
            if (entry instanceof VsiConfigModelCategory) {
                builder.push(((VsiConfigModelCategory)entry).getTitle());
                VSConfigApi.buildForgeConfigSpec((VsiConfigModelCategory)entry, builder, forgeConfigValueConsumer);
                builder.pop();
                continue;
            }
            if (!(entry instanceof VsiConfigModelEntry)) continue;
            forgeConfigValueConsumer.invoke((Object)((VsiConfigModelEntry)entry).getName(), INSTANCE.defineNode(builder, (VsiConfigModelEntry)entry));
        }
        return builder;
    }

    public static /* synthetic */ ForgeConfigSpec.Builder buildForgeConfigSpec$default(VsiConfigModelCategory vsiConfigModelCategory, ForgeConfigSpec.Builder builder, Function2 function2, int n2, Object object) {
        if ((n2 & 4) != 0) {
            function2 = VSConfigApi::buildForgeConfigSpec$lambda$0;
        }
        return VSConfigApi.buildForgeConfigSpec(vsiConfigModelCategory, builder, function2);
    }

    @JvmStatic
    public static final void update(@NotNull VsiConfigModel $this$update, @NotNull ModConfig forgeConfig, @NotNull ConfigType configType, @NotNull Set<VSGameEvents.ConfigUpdateEntry> updatedEntries) {
        Intrinsics.checkNotNullParameter((Object)$this$update, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)forgeConfig, (String)"forgeConfig");
        Intrinsics.checkNotNullParameter((Object)((Object)configType), (String)"configType");
        Intrinsics.checkNotNullParameter(updatedEntries, (String)"updatedEntries");
        VSConfigApi.forEachEntry$default(INSTANCE, $this$update.getRoot(), null, (arg_0, arg_1) -> VSConfigApi.update$lambda$3(forgeConfig, updatedEntries, configType, arg_0, arg_1), 1, null);
    }

    private final void forEachEntry(VsiConfigModelCategory $this$forEachEntry, List<String> category, Function2<? super List<String>, ? super VsiConfigModelEntry<?>, Unit> callback) {
        for (Map.Entry<String, VsiConfigNode> node : $this$forEachEntry.getChildren().entrySet()) {
            VsiConfigNode value = node.getValue();
            if (value instanceof VsiConfigModelEntry) {
                callback.invoke(category, (Object)value);
                continue;
            }
            if (!(value instanceof VsiConfigModelCategory)) continue;
            this.forEachEntry((VsiConfigModelCategory)value, CollectionsKt.plus((Collection)category, (Object)((VsiConfigModelCategory)value).getTitle()), callback);
        }
    }

    static /* synthetic */ void forEachEntry$default(VSConfigApi vSConfigApi, VsiConfigModelCategory vsiConfigModelCategory, List list, Function2 function2, int n2, Object object) {
        if ((n2 & 1) != 0) {
            list = CollectionsKt.emptyList();
        }
        vSConfigApi.forEachEntry(vsiConfigModelCategory, list, function2);
    }

    private final ForgeConfigSpec.ConfigValue<?> defineNode(ForgeConfigSpec.Builder builder, VsiConfigModelEntry<?> entry) {
        Object object;
        String string = entry.getDescription();
        if (string != null) {
            String p0 = string;
            boolean bl = false;
            builder.comment(p0);
        }
        Object v = entry.getGetValue().invoke();
        if (v instanceof Integer) {
            ForgeConfigSpec.ConfigValue<Comparable<?>> configValue = VSConfigApi.defineNode$defineNumeric(entry, builder, (Comparable)v);
            object = configValue;
            Intrinsics.checkNotNullExpressionValue(configValue, (String)"defineNode$defineNumeric(...)");
        } else if (v instanceof Long) {
            ForgeConfigSpec.ConfigValue<Comparable<?>> configValue = VSConfigApi.defineNode$defineNumeric(entry, builder, (Comparable)v);
            object = configValue;
            Intrinsics.checkNotNullExpressionValue(configValue, (String)"defineNode$defineNumeric(...)");
        } else if (v instanceof Float) {
            ForgeConfigSpec.ConfigValue<Comparable<?>> configValue = VSConfigApi.defineNode$defineNumeric(entry, builder, (Comparable)v);
            object = configValue;
            Intrinsics.checkNotNullExpressionValue(configValue, (String)"defineNode$defineNumeric(...)");
        } else if (v instanceof Double) {
            ForgeConfigSpec.ConfigValue<Comparable<?>> configValue = VSConfigApi.defineNode$defineNumeric(entry, builder, (Comparable)v);
            object = configValue;
            Intrinsics.checkNotNullExpressionValue(configValue, (String)"defineNode$defineNumeric(...)");
        } else if (v instanceof Boolean) {
            ForgeConfigSpec.ConfigValue<Object> configValue = VSConfigApi.defineNode$define(builder, entry, v);
            object = configValue;
            Intrinsics.checkNotNullExpressionValue(configValue, (String)"defineNode$define(...)");
        } else if (v instanceof String) {
            ForgeConfigSpec.ConfigValue<Object> configValue = VSConfigApi.defineNode$define(builder, entry, v);
            object = configValue;
            Intrinsics.checkNotNullExpressionValue(configValue, (String)"defineNode$define(...)");
        } else if (v instanceof Enum) {
            object = (ForgeConfigSpec.ConfigValue)VSConfigApi.defineNode$defineEnum(entry, builder, (Enum)v);
        } else {
            Object object2 = v;
            throw new IllegalArgumentException("invalid config type " + v + " of class " + (object2 != null ? object2.getClass() : null));
        }
        return object;
    }

    private static final Unit buildForgeConfigSpec$lambda$0(String a2, ForgeConfigSpec.ConfigValue b2) {
        Intrinsics.checkNotNullParameter((Object)a2, (String)"a");
        Intrinsics.checkNotNullParameter((Object)b2, (String)"b");
        return Unit.INSTANCE;
    }

    private static final Unit update$lambda$3(ModConfig $forgeConfig, Set $updatedEntries, ConfigType $configType, List category, VsiConfigModelEntry node) {
        block11: {
            Intrinsics.checkNotNullParameter((Object)$forgeConfig, (String)"$forgeConfig");
            Intrinsics.checkNotNullParameter((Object)$updatedEntries, (String)"$updatedEntries");
            Intrinsics.checkNotNullParameter((Object)((Object)$configType), (String)"$configType");
            Intrinsics.checkNotNullParameter((Object)category, (String)"category");
            Intrinsics.checkNotNullParameter((Object)node, (String)"node");
            String forgeKey = CollectionsKt.joinToString$default((Iterable)CollectionsKt.plus((Collection)category, (Object)node.getName()), (CharSequence)".", null, null, (int)0, null, null, (int)62, null);
            Object object = $forgeConfig.getConfigData().get(forgeKey);
            if (object == null) break block11;
            Object newValue = object;
            boolean bl = false;
            Object defaultValue = node.getDefault();
            if (defaultValue != null) {
                Float convertedValue;
                block10: {
                    if (defaultValue instanceof Float && newValue instanceof Double) {
                        v1 = Float.valueOf((float)((Number)newValue).doubleValue());
                    } else if (defaultValue instanceof Enum) {
                        Object object2 = newValue;
                        if (object2 instanceof String) {
                            Enum[] enumConstants;
                            Class clazz = ((Enum)defaultValue).getDeclaringClass();
                            Intrinsics.checkNotNullExpressionValue(clazz, (String)"getDeclaringClass(...)");
                            Enum[] enumArray = enumConstants = (Enum[])clazz.getEnumConstants();
                            int n2 = enumArray.length;
                            for (int i2 = 0; i2 < n2; ++i2) {
                                Enum enum_;
                                Enum it = enum_ = enumArray[i2];
                                boolean bl2 = false;
                                if (!Intrinsics.areEqual((Object)it.name(), (Object)newValue)) continue;
                                v1 = enum_;
                                break block10;
                            }
                            v1 = null;
                        } else {
                            v1 = object2 instanceof Enum ? (Enum)newValue : null;
                        }
                    } else {
                        v1 = convertedValue = Reflection.getOrCreateKotlinClass(defaultValue.getClass()).isInstance(newValue) ? newValue : null;
                    }
                }
                if (!Intrinsics.areEqual((Object)convertedValue, (Object)node.getGetValue().invoke())) {
                    $updatedEntries.add(new VSGameEvents.ConfigUpdateEntry($configType, category, node.getName()));
                }
                if (convertedValue != null) {
                    node.getSetValue().invoke((Object)convertedValue);
                }
            }
        }
        return Unit.INSTANCE;
    }

    private static final <T> ForgeConfigSpec.ConfigValue<T> defineNode$define(ForgeConfigSpec.Builder $builder, VsiConfigModelEntry<?> $entry, T v) {
        return $builder.define($entry.getName(), v);
    }

    private static final <T extends Enum<T>> ForgeConfigSpec.EnumValue<?> defineNode$defineEnum(VsiConfigModelEntry<?> $entry, ForgeConfigSpec.Builder builder, Enum<?> value) {
        String string = $entry.getName();
        Intrinsics.checkNotNull(value, (String)"null cannot be cast to non-null type T of org.valkyrienskies.mod.api.config.VSConfigApi.defineNode$defineEnum");
        ForgeConfigSpec.EnumValue enumValue = builder.defineEnum(string, value);
        Intrinsics.checkNotNullExpressionValue((Object)enumValue, (String)"defineEnum(...)");
        return enumValue;
    }

    private static final <T extends Comparable<? super T>> ForgeConfigSpec.ConfigValue<? extends Comparable<?>> defineNode$defineNumeric(VsiConfigModelEntry<?> $entry, ForgeConfigSpec.Builder $builder, T v) {
        ForgeConfigSpec.ConfigValue configValue;
        if ($entry.getMin() == null || $entry.getMax() == null) {
            configValue = VSConfigApi.defineNode$define($builder, $entry, v instanceof Float ? (Comparable)Double.valueOf(((Number)((Object)v)).floatValue()) : v);
        } else {
            T t = v;
            if (t instanceof Integer) {
                String string = $entry.getName();
                int n2 = ((Number)((Object)v)).intValue();
                Object obj = $entry.getMin();
                Intrinsics.checkNotNull(obj, (String)"null cannot be cast to non-null type kotlin.Int");
                int n3 = (Integer)obj;
                Object obj2 = $entry.getMax();
                Intrinsics.checkNotNull(obj2, (String)"null cannot be cast to non-null type kotlin.Int");
                configValue = (ForgeConfigSpec.ConfigValue)$builder.defineInRange(string, n2, n3, ((Integer)obj2).intValue());
            } else if (t instanceof Long) {
                String string = $entry.getName();
                long l2 = ((Number)((Object)v)).longValue();
                Object obj = $entry.getMin();
                Intrinsics.checkNotNull(obj, (String)"null cannot be cast to non-null type kotlin.Long");
                long l3 = (Long)obj;
                Object obj3 = $entry.getMax();
                Intrinsics.checkNotNull(obj3, (String)"null cannot be cast to non-null type kotlin.Long");
                configValue = (ForgeConfigSpec.ConfigValue)$builder.defineInRange(string, l2, l3, ((Long)obj3).longValue());
            } else if (t instanceof Float) {
                String string = $entry.getName();
                double d2 = ((Number)((Object)v)).floatValue();
                Object obj = $entry.getMin();
                Intrinsics.checkNotNull(obj, (String)"null cannot be cast to non-null type kotlin.Float");
                double d3 = ((Float)obj).floatValue();
                Object obj4 = $entry.getMax();
                Intrinsics.checkNotNull(obj4, (String)"null cannot be cast to non-null type kotlin.Float");
                configValue = (ForgeConfigSpec.ConfigValue)$builder.defineInRange(string, d2, d3, (double)((Float)obj4).floatValue());
            } else if (t instanceof Double) {
                String string = $entry.getName();
                double d4 = ((Number)((Object)v)).doubleValue();
                Object obj = $entry.getMin();
                Intrinsics.checkNotNull(obj, (String)"null cannot be cast to non-null type kotlin.Double");
                double d5 = (Double)obj;
                Object obj5 = $entry.getMax();
                Intrinsics.checkNotNull(obj5, (String)"null cannot be cast to non-null type kotlin.Double");
                configValue = (ForgeConfigSpec.ConfigValue)$builder.defineInRange(string, d4, d5, ((Double)obj5).doubleValue());
            } else {
                throw new IllegalArgumentException("Non numeric type " + v + " not accepted");
            }
        }
        return configValue;
    }
}

