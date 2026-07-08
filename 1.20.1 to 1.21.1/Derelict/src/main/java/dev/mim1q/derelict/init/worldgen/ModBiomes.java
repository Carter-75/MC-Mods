/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.datafixers.util.Pair
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  kotlin.ranges.ClosedFloatingPointRange
 *  kotlin.ranges.RangesKt
 *  net.fabricmc.fabric.api.biome.v1.BiomeModificationContext
 *  net.fabricmc.fabric.api.biome.v1.BiomeModifications
 *  net.fabricmc.fabric.api.biome.v1.BiomeSelectionContext
 *  net.fabricmc.fabric.api.biome.v1.ModificationPhase
 *  net.minecraft.class_1299
 *  net.minecraft.class_1311
 *  net.minecraft.class_1959
 *  net.minecraft.class_1972
 *  net.minecraft.class_2378
 *  net.minecraft.class_2680
 *  net.minecraft.class_2960
 *  net.minecraft.class_5321
 *  net.minecraft.class_5483$class_1964
 *  net.minecraft.class_6544
 *  net.minecraft.class_6544$class_4762
 *  net.minecraft.class_6544$class_6546
 *  net.minecraft.class_6686
 *  net.minecraft.class_6686$class_6693
 *  net.minecraft.class_6686$class_6708
 *  net.minecraft.class_7924
 *  org.jetbrains.annotations.NotNull
 *  terrablender.api.ModifiedVanillaOverworldBuilder
 *  terrablender.api.ParameterUtils$Continentalness
 *  terrablender.api.ParameterUtils$Depth
 *  terrablender.api.ParameterUtils$Erosion
 *  terrablender.api.ParameterUtils$Humidity
 *  terrablender.api.ParameterUtils$ParameterPointListBuilder
 *  terrablender.api.ParameterUtils$Temperature
 *  terrablender.api.ParameterUtils$Weirdness
 *  terrablender.api.Region
 *  terrablender.api.RegionType
 *  terrablender.api.Regions
 *  terrablender.api.SurfaceRuleManager
 *  terrablender.api.SurfaceRuleManager$RuleCategory
 *  terrablender.api.TerraBlenderApi
 */
package dev.mim1q.derelict.init.worldgen;

import com.mojang.datafixers.util.Pair;
import dev.mim1q.derelict.Derelict;
import dev.mim1q.derelict.init.ModBlocksAndItems;
import dev.mim1q.derelict.init.ModEntities;
import dev.mim1q.derelict.init.worldgen.ModBiomes;
import java.util.Collection;
import java.util.List;
import java.util.function.Consumer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.ClosedFloatingPointRange;
import kotlin.ranges.RangesKt;
import net.fabricmc.fabric.api.biome.v1.BiomeModificationContext;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectionContext;
import net.fabricmc.fabric.api.biome.v1.ModificationPhase;
import net.minecraft.class_1299;
import net.minecraft.class_1311;
import net.minecraft.class_1959;
import net.minecraft.class_1972;
import net.minecraft.class_2378;
import net.minecraft.class_2680;
import net.minecraft.class_2960;
import net.minecraft.class_5321;
import net.minecraft.class_5483;
import net.minecraft.class_6544;
import net.minecraft.class_6686;
import net.minecraft.class_7924;
import org.jetbrains.annotations.NotNull;
import terrablender.api.ModifiedVanillaOverworldBuilder;
import terrablender.api.ParameterUtils;
import terrablender.api.Region;
import terrablender.api.RegionType;
import terrablender.api.Regions;
import terrablender.api.SurfaceRuleManager;
import terrablender.api.TerraBlenderApi;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000?\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\b\u0004*\u0001\u001a\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0016\u00a2\u0006\u0004\b\u0005\u0010\u0003Jy\u0010\u0010\u001a\u00020\u000f2\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u000e\b\u0002\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u000e\b\u0002\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\b\b\u0002\u0010\u000e\u001a\u00020\u0007H\u0002\u00a2\u0006\u0004\b\u0010\u0010\u0011J\u001d\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00150\u00142\u0006\u0010\u0013\u001a\u00020\u0012H\u0002\u00a2\u0006\u0004\b\u0016\u0010\u0017R\u001a\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00150\u00148\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0014\u0010\u001b\u001a\u00020\u001a8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001c\u00a8\u0006\u001d"}, d2={"Ldev/mim1q/derelict/init/worldgen/ModBiomes;", "Lterrablender/api/TerraBlenderApi;", "<init>", "()V", "", "onTerraBlenderInitialized", "Lkotlin/ranges/ClosedFloatingPointRange;", "", "temperature", "humidity", "continentalness", "erosion", "depth", "weirdness", "offset", "Lnet/minecraft/class_6544$class_4762;", "noiseParameters", "(Lkotlin/ranges/ClosedFloatingPointRange;Lkotlin/ranges/ClosedFloatingPointRange;Lkotlin/ranges/ClosedFloatingPointRange;Lkotlin/ranges/ClosedFloatingPointRange;Lkotlin/ranges/ClosedFloatingPointRange;Lkotlin/ranges/ClosedFloatingPointRange;F)Lnet/minecraft/class_6544$class_4762;", "", "name", "Lnet/minecraft/class_5321;", "Lnet/minecraft/class_1959;", "biomeKey", "(Ljava/lang/String;)Lnet/minecraft/class_5321;", "SPIDER_CAVES", "Lnet/minecraft/class_5321;", "dev/mim1q/derelict/init/worldgen/ModBiomes.DERELICT_REGION.1", "DERELICT_REGION", "Ldev/mim1q/derelict/init/worldgen/ModBiomes$DERELICT_REGION$1;", "derelict"})
@SourceDebugExtension(value={"SMAP\nModBiomes.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ModBiomes.kt\ndev/mim1q/derelict/init/worldgen/ModBiomes\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,128:1\n1755#2,3:129\n*S KotlinDebug\n*F\n+ 1 ModBiomes.kt\ndev/mim1q/derelict/init/worldgen/ModBiomes\n*L\n68#1:129,3\n*E\n"})
public final class ModBiomes
implements TerraBlenderApi {
    @NotNull
    public static final ModBiomes INSTANCE = new ModBiomes();
    @NotNull
    private static final class_5321<class_1959> SPIDER_CAVES = INSTANCE.biomeKey("spider_caves");
    @NotNull
    private static final DERELICT_REGION.1 DERELICT_REGION;

    private ModBiomes() {
    }

    public void onTerraBlenderInitialized() {
        Regions.register((Region)DERELICT_REGION);
        class_5321[] class_5321Array = new class_5321[]{SPIDER_CAVES};
        SurfaceRuleManager.addSurfaceRules((SurfaceRuleManager.RuleCategory)SurfaceRuleManager.RuleCategory.OVERWORLD, (String)"derelict", (class_6686.class_6708)class_6686.method_39049((class_6686.class_6693)class_6686.method_39055((class_5321[])class_5321Array), (class_6686.class_6708)class_6686.method_39047((class_2680)ModBlocksAndItems.INSTANCE.getARACHNITE().getBlock().method_9564())));
        BiomeModifications.create((class_2960)Derelict.INSTANCE.id("add_jumping_spiders")).add(ModificationPhase.ADDITIONS, ModBiomes::onTerraBlenderInitialized$lambda$1, ModBiomes::onTerraBlenderInitialized$lambda$2);
        BiomeModifications.create((class_2960)Derelict.INSTANCE.id("add_spiny_spiders")).add(ModificationPhase.ADDITIONS, ModBiomes::onTerraBlenderInitialized$lambda$3, ModBiomes::onTerraBlenderInitialized$lambda$4);
        BiomeModifications.create((class_2960)Derelict.INSTANCE.id("add_charming_spiders")).add(ModificationPhase.ADDITIONS, ModBiomes::onTerraBlenderInitialized$lambda$5, ModBiomes::onTerraBlenderInitialized$lambda$6);
    }

    private final class_6544.class_4762 noiseParameters(ClosedFloatingPointRange<Float> temperature, ClosedFloatingPointRange<Float> humidity, ClosedFloatingPointRange<Float> continentalness, ClosedFloatingPointRange<Float> erosion, ClosedFloatingPointRange<Float> depth, ClosedFloatingPointRange<Float> weirdness, float offset) {
        return new class_6544.class_4762(class_6544.class_6546.method_38121((float)((Number)((Object)temperature.getStart())).floatValue(), (float)((Number)((Object)temperature.getEndInclusive())).floatValue()), class_6544.class_6546.method_38121((float)((Number)((Object)humidity.getStart())).floatValue(), (float)((Number)((Object)humidity.getEndInclusive())).floatValue()), class_6544.class_6546.method_38121((float)((Number)((Object)continentalness.getStart())).floatValue(), (float)((Number)((Object)continentalness.getEndInclusive())).floatValue()), class_6544.class_6546.method_38121((float)((Number)((Object)erosion.getStart())).floatValue(), (float)((Number)((Object)erosion.getEndInclusive())).floatValue()), class_6544.class_6546.method_38121((float)((Number)((Object)depth.getStart())).floatValue(), (float)((Number)((Object)depth.getEndInclusive())).floatValue()), class_6544.class_6546.method_38121((float)((Number)((Object)weirdness.getStart())).floatValue(), (float)((Number)((Object)weirdness.getEndInclusive())).floatValue()), class_6544.method_38665((float)offset));
    }

    static /* synthetic */ class_6544.class_4762 noiseParameters$default(ModBiomes modBiomes, ClosedFloatingPointRange closedFloatingPointRange, ClosedFloatingPointRange closedFloatingPointRange2, ClosedFloatingPointRange closedFloatingPointRange3, ClosedFloatingPointRange closedFloatingPointRange4, ClosedFloatingPointRange closedFloatingPointRange5, ClosedFloatingPointRange closedFloatingPointRange6, float f, int n, Object object) {
        if ((n & 1) != 0) {
            closedFloatingPointRange = RangesKt.rangeTo((float)-1.0f, (float)1.0f);
        }
        if ((n & 2) != 0) {
            closedFloatingPointRange2 = RangesKt.rangeTo((float)-1.0f, (float)1.0f);
        }
        if ((n & 4) != 0) {
            closedFloatingPointRange3 = RangesKt.rangeTo((float)-1.0f, (float)1.0f);
        }
        if ((n & 8) != 0) {
            closedFloatingPointRange4 = RangesKt.rangeTo((float)-1.0f, (float)1.0f);
        }
        if ((n & 0x10) != 0) {
            closedFloatingPointRange5 = RangesKt.rangeTo((float)-1.0f, (float)1.0f);
        }
        if ((n & 0x20) != 0) {
            closedFloatingPointRange6 = RangesKt.rangeTo((float)-1.0f, (float)1.0f);
        }
        if ((n & 0x40) != 0) {
            f = 0.0f;
        }
        return modBiomes.noiseParameters((ClosedFloatingPointRange<Float>)closedFloatingPointRange, (ClosedFloatingPointRange<Float>)closedFloatingPointRange2, (ClosedFloatingPointRange<Float>)closedFloatingPointRange3, (ClosedFloatingPointRange<Float>)closedFloatingPointRange4, (ClosedFloatingPointRange<Float>)closedFloatingPointRange5, (ClosedFloatingPointRange<Float>)closedFloatingPointRange6, f);
    }

    private final class_5321<class_1959> biomeKey(String name) {
        class_5321 class_53212 = class_5321.method_29179((class_5321)class_7924.field_41236, (class_2960)Derelict.INSTANCE.id(name));
        Intrinsics.checkNotNullExpressionValue((Object)class_53212, (String)"of(...)");
        return class_53212;
    }

    private static final boolean onTerraBlenderInitialized$lambda$1(BiomeSelectionContext selection) {
        boolean bl;
        block3: {
            List list = selection.getBiome().method_30966().method_31004(class_1311.field_6302).method_34994();
            Intrinsics.checkNotNullExpressionValue((Object)list, (String)"getEntries(...)");
            Iterable $this$any$iv = list;
            boolean $i$f$any = false;
            if ($this$any$iv instanceof Collection && ((Collection)$this$any$iv).isEmpty()) {
                bl = false;
            } else {
                for (Object element$iv : $this$any$iv) {
                    class_5483.class_1964 it = (class_5483.class_1964)element$iv;
                    boolean bl2 = false;
                    if (!Intrinsics.areEqual((Object)it.field_9389, (Object)class_1299.field_6079)) continue;
                    bl = true;
                    break block3;
                }
                bl = false;
            }
        }
        return bl;
    }

    private static final void onTerraBlenderInitialized$lambda$2(BiomeSelectionContext biomeSelectionContext, BiomeModificationContext modification) {
        modification.getSpawnSettings().addSpawn(class_1311.field_6302, new class_5483.class_1964(ModEntities.INSTANCE.getJUMPING_SPIDER(), 30, 1, 2));
    }

    private static final boolean onTerraBlenderInitialized$lambda$3(BiomeSelectionContext selection) {
        return Intrinsics.areEqual((Object)selection.getBiomeKey(), (Object)class_1972.field_22077);
    }

    private static final void onTerraBlenderInitialized$lambda$4(BiomeSelectionContext biomeSelectionContext, BiomeModificationContext modification) {
        modification.getSpawnSettings().addSpawn(class_1311.field_6302, new class_5483.class_1964(ModEntities.INSTANCE.getSPINY_SPIDER(), 15, 1, 2));
    }

    private static final boolean onTerraBlenderInitialized$lambda$5(BiomeSelectionContext selection) {
        return Intrinsics.areEqual((Object)selection.getBiomeKey(), (Object)class_1972.field_22075);
    }

    private static final void onTerraBlenderInitialized$lambda$6(BiomeSelectionContext biomeSelectionContext, BiomeModificationContext modification) {
        modification.getSpawnSettings().addSpawn(class_1311.field_6302, new class_5483.class_1964(ModEntities.INSTANCE.getCHARMING_SPIDER(), 15, 1, 2));
    }

    public static final /* synthetic */ class_5321 access$getSPIDER_CAVES$p() {
        return SPIDER_CAVES;
    }

    static {
        class_2960 class_29602 = Derelict.INSTANCE.id("derelict");
        RegionType regionType = RegionType.OVERWORLD;
        DERELICT_REGION = new Region(class_29602, regionType){

            public void addBiomes(class_2378<class_1959> registry, Consumer<Pair<class_6544.class_4762, class_5321<class_1959>>> mapper) {
                Intrinsics.checkNotNullParameter(registry, (String)"registry");
                Intrinsics.checkNotNullParameter(mapper, (String)"mapper");
                Object[] objectArray = new ParameterUtils.Temperature[]{ParameterUtils.Temperature.FULL_RANGE};
                ParameterUtils.ParameterPointListBuilder parameterPointListBuilder = new ParameterUtils.ParameterPointListBuilder().temperature(objectArray);
                objectArray = new ParameterUtils.Humidity[]{ParameterUtils.Humidity.WET, ParameterUtils.Humidity.HUMID, ParameterUtils.Humidity.ARID};
                ParameterUtils.ParameterPointListBuilder parameterPointListBuilder2 = parameterPointListBuilder.humidity((ParameterUtils.Humidity[])objectArray);
                objectArray = new ParameterUtils.Continentalness[]{ParameterUtils.Continentalness.FULL_RANGE};
                ParameterUtils.ParameterPointListBuilder parameterPointListBuilder3 = parameterPointListBuilder2.continentalness((ParameterUtils.Continentalness[])objectArray);
                objectArray = new ParameterUtils.Erosion[]{ParameterUtils.Erosion.FULL_RANGE};
                ParameterUtils.ParameterPointListBuilder parameterPointListBuilder4 = parameterPointListBuilder3.erosion((ParameterUtils.Erosion[])objectArray);
                objectArray = new ParameterUtils.Depth[]{ParameterUtils.Depth.UNDERGROUND};
                ParameterUtils.ParameterPointListBuilder parameterPointListBuilder5 = parameterPointListBuilder4.depth((ParameterUtils.Depth[])objectArray);
                objectArray = new ParameterUtils.Weirdness[]{ParameterUtils.Weirdness.FULL_RANGE};
                ParameterUtils.ParameterPointListBuilder parameterPointListBuilder6 = parameterPointListBuilder5.weirdness((ParameterUtils.Weirdness[])objectArray);
                objectArray = new Float[]{Float.valueOf(0.38f)};
                List spiderCavesPoints = parameterPointListBuilder6.offset((Float[])objectArray).build();
                this.addModifiedVanillaOverworldBiomes(mapper, arg_0 -> DERELICT_REGION.1.addBiomes$lambda$1(spiderCavesPoints, this, mapper, arg_0));
            }

            private static final void addBiomes$lambda$1(List $spiderCavesPoints, DERELICT_REGION.1 this$0, Consumer $mapper, ModifiedVanillaOverworldBuilder it) {
                Intrinsics.checkNotNullParameter((Object)((Object)this$0), (String)"this$0");
                Intrinsics.checkNotNullParameter((Object)$mapper, (String)"$mapper");
                Intrinsics.checkNotNull((Object)$spiderCavesPoints);
                Iterable $this$forEach$iv = $spiderCavesPoints;
                boolean $i$f$forEach = false;
                for (T element$iv : $this$forEach$iv) {
                    class_6544.class_4762 it2 = (class_6544.class_4762)element$iv;
                    boolean bl = false;
                    this$0.addBiome($mapper, it2, ModBiomes.access$getSPIDER_CAVES$p());
                }
            }
        };
    }
}

