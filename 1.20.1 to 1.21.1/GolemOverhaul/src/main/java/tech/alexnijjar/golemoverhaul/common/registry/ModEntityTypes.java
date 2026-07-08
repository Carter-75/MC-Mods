/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.teamresourceful.resourcefullib.common.registry.RegistryEntry
 *  com.teamresourceful.resourcefullib.common.registry.ResourcefulRegistries
 *  com.teamresourceful.resourcefullib.common.registry.ResourcefulRegistry
 *  dev.architectury.injectables.annotations.ExpectPlatform
 *  dev.architectury.injectables.annotations.ExpectPlatform$Transformed
 *  dev.architectury.registry.level.biome.BiomeModifications
 *  dev.architectury.registry.level.entity.EntityAttributeRegistry
 *  dev.architectury.registry.level.entity.SpawnPlacementsRegistry
 *  net.minecraft.class_1297
 *  net.minecraft.class_1299
 *  net.minecraft.class_1299$class_4049
 *  net.minecraft.class_1308
 *  net.minecraft.class_1311
 *  net.minecraft.class_1317$class_1319
 *  net.minecraft.class_1959
 *  net.minecraft.class_2378
 *  net.minecraft.class_2902$class_2903
 *  net.minecraft.class_5483$class_1964
 *  net.minecraft.class_6862
 *  net.minecraft.class_7923
 */
package tech.alexnijjar.golemoverhaul.common.registry;

import com.teamresourceful.resourcefullib.common.registry.RegistryEntry;
import com.teamresourceful.resourcefullib.common.registry.ResourcefulRegistries;
import com.teamresourceful.resourcefullib.common.registry.ResourcefulRegistry;
import dev.architectury.injectables.annotations.ExpectPlatform;
import dev.architectury.registry.level.biome.BiomeModifications;
import dev.architectury.registry.level.entity.EntityAttributeRegistry;
import dev.architectury.registry.level.entity.SpawnPlacementsRegistry;
import net.minecraft.class_1297;
import net.minecraft.class_1299;
import net.minecraft.class_1308;
import net.minecraft.class_1311;
import net.minecraft.class_1317;
import net.minecraft.class_1959;
import net.minecraft.class_2378;
import net.minecraft.class_2902;
import net.minecraft.class_5483;
import net.minecraft.class_6862;
import net.minecraft.class_7923;
import tech.alexnijjar.golemoverhaul.common.entities.golems.BarrelGolem;
import tech.alexnijjar.golemoverhaul.common.entities.golems.CandleGolem;
import tech.alexnijjar.golemoverhaul.common.entities.golems.CoalGolem;
import tech.alexnijjar.golemoverhaul.common.entities.golems.HayGolem;
import tech.alexnijjar.golemoverhaul.common.entities.golems.HoneyGolem;
import tech.alexnijjar.golemoverhaul.common.entities.golems.KelpGolem;
import tech.alexnijjar.golemoverhaul.common.entities.golems.NetheriteGolem;
import tech.alexnijjar.golemoverhaul.common.entities.golems.SlimeGolem;
import tech.alexnijjar.golemoverhaul.common.entities.golems.TerracottaGolem;
import tech.alexnijjar.golemoverhaul.common.entities.projectiles.CandleFlameProjectile;
import tech.alexnijjar.golemoverhaul.common.entities.projectiles.HoneyBlobProjectile;
import tech.alexnijjar.golemoverhaul.common.entities.projectiles.MudBallProjectile;
import tech.alexnijjar.golemoverhaul.common.registry.fabric.ModEntityTypesImpl;
import tech.alexnijjar.golemoverhaul.common.tags.ModBiomeTags;

public class ModEntityTypes {
    public static final ResourcefulRegistry<class_1299<?>> ENTITY_TYPES = ResourcefulRegistries.create((class_2378)class_7923.field_41177, (String)"golemoverhaul");
    public static final ResourcefulRegistry<class_1299<?>> GOLEMS = ResourcefulRegistries.create(ENTITY_TYPES);
    public static final ResourcefulRegistry<class_1299<?>> PROJECTILES = ResourcefulRegistries.create(ENTITY_TYPES);
    public static final RegistryEntry<class_1299<BarrelGolem>> BARREL_GOLEM = GOLEMS.register("barrel_golem", () -> ModEntityTypes.createEntityBuilder(BarrelGolem::new, class_1311.field_6294).sized(1.0f, 1.0f).clientTrackingRange(10).build("barrel_golem"));
    public static final RegistryEntry<class_1299<CandleGolem>> CANDLE_GOLEM = GOLEMS.register("candle_golem", () -> ModEntityTypes.createEntityBuilder(CandleGolem::new, class_1311.field_6294).sized(0.375f, 0.5625f).clientTrackingRange(10).build("candle_golem"));
    public static final RegistryEntry<class_1299<CoalGolem>> COAL_GOLEM = GOLEMS.register("coal_golem", () -> ModEntityTypes.createEntityBuilder(CoalGolem::new, class_1311.field_6303).sized(0.25f, 0.5f).clientTrackingRange(10).fireImmune().build("coal_golem"));
    public static final RegistryEntry<class_1299<HayGolem>> HAY_GOLEM = GOLEMS.register("hay_golem", () -> ModEntityTypes.createEntityBuilder(HayGolem::new, class_1311.field_6294).sized(0.75f, 2.0f).clientTrackingRange(10).build("hay_golem"));
    public static final RegistryEntry<class_1299<HoneyGolem>> HONEY_GOLEM = GOLEMS.register("honey_golem", () -> ModEntityTypes.createEntityBuilder(HoneyGolem::new, class_1311.field_6294).sized(0.875f, 1.0f).clientTrackingRange(10).build("honey_golem"));
    public static final RegistryEntry<class_1299<KelpGolem>> KELP_GOLEM = GOLEMS.register("kelp_golem", () -> ModEntityTypes.createEntityBuilder(KelpGolem::new, class_1311.field_6294).sized(0.8125f, 1.25f).clientTrackingRange(10).build("kelp_golem"));
    public static final RegistryEntry<class_1299<NetheriteGolem>> NETHERITE_GOLEM = GOLEMS.register("netherite_golem", () -> ModEntityTypes.createEntityBuilder(NetheriteGolem::new, class_1311.field_6294).sized(1.75f, 2.1f).clientTrackingRange(10).fireImmune().build("netherite_golem"));
    public static final RegistryEntry<class_1299<SlimeGolem>> SLIME_GOLEM = GOLEMS.register("slime_golem", () -> ModEntityTypes.createEntityBuilder(SlimeGolem::new, class_1311.field_6302).sized(1.125f, 0.8125f).clientTrackingRange(10).build("slime_golem"));
    public static final RegistryEntry<class_1299<TerracottaGolem>> TERRACOTTA_GOLEM = GOLEMS.register("terracotta_golem", () -> ModEntityTypes.createEntityBuilder(TerracottaGolem::new, class_1311.field_6294).sized(0.5f, 0.75f).clientTrackingRange(10).build("terracotta_golem"));
    public static final RegistryEntry<class_1299<CandleFlameProjectile>> CANDLE_FLAME = PROJECTILES.register("candle_flame", () -> ModEntityTypes.createEntityBuilder(CandleFlameProjectile::new, class_1311.field_17715).sized(0.25f, 0.25f).clientTrackingRange(4).updateInterval(10).build("candle_flame"));
    public static final RegistryEntry<class_1299<MudBallProjectile>> MUD_BALL = PROJECTILES.register("mud_ball", () -> ModEntityTypes.createEntityBuilder(MudBallProjectile::new, class_1311.field_17715).sized(0.25f, 0.25f).clientTrackingRange(4).updateInterval(10).build("mud_ball"));
    public static final RegistryEntry<class_1299<HoneyBlobProjectile>> HONEY_BLOB = PROJECTILES.register("honey_blob", () -> ModEntityTypes.createEntityBuilder(HoneyBlobProjectile::new, class_1311.field_17715).sized(0.25f, 0.25f).clientTrackingRange(4).updateInterval(10).build("honey_blob"));

    /*
     * WARNING - void declaration
     */
    @ExpectPlatform
    @ExpectPlatform.Transformed
    public static <T extends class_1297> PlatformEntityBuilder<T> createEntityBuilder(class_1299.class_4049<T> factory, class_1311 category) {
        void var1_1;
        return ModEntityTypesImpl.createEntityBuilder(factory, (class_1311)var1_1);
    }

    public static void init() {
        ENTITY_TYPES.init();
        ModEntityTypes.registerAttributes();
        ModEntityTypes.registerSpawnPlacements();
        ModEntityTypes.registerBiomeModifications();
    }

    private static void registerAttributes() {
        EntityAttributeRegistry.register(BARREL_GOLEM, BarrelGolem::createAttributes);
        EntityAttributeRegistry.register(CANDLE_GOLEM, CandleGolem::createAttributes);
        EntityAttributeRegistry.register(COAL_GOLEM, CoalGolem::createAttributes);
        EntityAttributeRegistry.register(HAY_GOLEM, HayGolem::createAttributes);
        EntityAttributeRegistry.register(HONEY_GOLEM, HoneyGolem::createAttributes);
        EntityAttributeRegistry.register(KELP_GOLEM, KelpGolem::createAttributes);
        EntityAttributeRegistry.register(NETHERITE_GOLEM, NetheriteGolem::createAttributes);
        EntityAttributeRegistry.register(SLIME_GOLEM, SlimeGolem::createAttributes);
        EntityAttributeRegistry.register(TERRACOTTA_GOLEM, TerracottaGolem::createAttributes);
    }

    private static void registerSpawnPlacements() {
        SpawnPlacementsRegistry.register(BARREL_GOLEM, (class_1317.class_1319)class_1317.class_1319.field_6317, (class_2902.class_2903)class_2902.class_2903.field_13203, BarrelGolem::checkMobSpawnRules);
        SpawnPlacementsRegistry.register(CANDLE_GOLEM, (class_1317.class_1319)class_1317.class_1319.field_6317, (class_2902.class_2903)class_2902.class_2903.field_13203, class_1308::method_20636);
        SpawnPlacementsRegistry.register(COAL_GOLEM, (class_1317.class_1319)class_1317.class_1319.field_6317, (class_2902.class_2903)class_2902.class_2903.field_13203, CoalGolem::checkMobSpawnRules);
        SpawnPlacementsRegistry.register(HAY_GOLEM, (class_1317.class_1319)class_1317.class_1319.field_6317, (class_2902.class_2903)class_2902.class_2903.field_13203, HayGolem::checkMobSpawnRules);
        SpawnPlacementsRegistry.register(HONEY_GOLEM, (class_1317.class_1319)class_1317.class_1319.field_6317, (class_2902.class_2903)class_2902.class_2903.field_13203, HoneyGolem::checkMobSpawnRules);
        SpawnPlacementsRegistry.register(KELP_GOLEM, (class_1317.class_1319)class_1317.class_1319.field_6318, (class_2902.class_2903)class_2902.class_2903.field_13203, class_1308::method_20636);
        SpawnPlacementsRegistry.register(NETHERITE_GOLEM, (class_1317.class_1319)class_1317.class_1319.field_6317, (class_2902.class_2903)class_2902.class_2903.field_13203, class_1308::method_20636);
        SpawnPlacementsRegistry.register(SLIME_GOLEM, (class_1317.class_1319)class_1317.class_1319.field_6317, (class_2902.class_2903)class_2902.class_2903.field_13203, SlimeGolem::checkSlimeSpawnRules);
        SpawnPlacementsRegistry.register(TERRACOTTA_GOLEM, (class_1317.class_1319)class_1317.class_1319.field_6317, (class_2902.class_2903)class_2902.class_2903.field_13203, TerracottaGolem::checkMobSpawnRules);
    }

    private static void registerBiomeModifications() {
        ModEntityTypes.addSpawn(COAL_GOLEM, ModBiomeTags.COAL_GOLEM_SPAWNS, 20, 3, 5);
        ModEntityTypes.addSpawn(HONEY_GOLEM, ModBiomeTags.HONEY_GOLEM_SPAWNS, 6, 1, 2);
        ModEntityTypes.addSpawn(SLIME_GOLEM, ModBiomeTags.SLIME_GOLEM_SPAWNS, 25, 1, 2);
        ModEntityTypes.addSpawn(SLIME_GOLEM, ModBiomeTags.SLIME_GOLEM_SWAMP_SPAWNS, 1, 1, 1);
        ModEntityTypes.addSpawn(TERRACOTTA_GOLEM, ModBiomeTags.TERRACOTTA_GOLEM_SPAWNS, 6, 1, 2);
    }

    private static <T extends class_1297> void addSpawn(RegistryEntry<class_1299<T>> entityType, class_6862<class_1959> spawnBiomesTag, int weight, int minCount, int maxCount) {
        BiomeModifications.addProperties(biomeContext -> biomeContext.hasTag(spawnBiomesTag), (context, properties) -> properties.getSpawnProperties().addSpawn(((class_1299)entityType.get()).method_5891(), new class_5483.class_1964((class_1299)entityType.get(), weight, minCount, maxCount)));
    }

    public static interface PlatformEntityBuilder<T extends class_1297> {
        public PlatformEntityBuilder<T> sized(float var1, float var2);

        public PlatformEntityBuilder<T> clientTrackingRange(int var1);

        public PlatformEntityBuilder<T> updateInterval(int var1);

        public PlatformEntityBuilder<T> fireImmune();

        public class_1299<T> build(String var1);
    }
}

