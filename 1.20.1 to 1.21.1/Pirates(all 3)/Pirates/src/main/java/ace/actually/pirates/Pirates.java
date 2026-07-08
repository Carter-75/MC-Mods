/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.common.base.Suppliers
 *  dev.architectury.platform.Platform
 *  dev.architectury.registry.level.entity.EntityAttributeRegistry
 *  dev.architectury.registry.registries.DeferredRegister
 *  dev.architectury.registry.registries.Registrar
 *  dev.architectury.registry.registries.RegistrarManager
 *  dev.architectury.registry.registries.RegistrySupplier
 *  dev.architectury.utils.Env
 *  dev.architectury.utils.EnvExecutor
 *  net.minecraft.class_1299
 *  net.minecraft.class_1299$class_1300
 *  net.minecraft.class_1311
 *  net.minecraft.class_1747
 *  net.minecraft.class_1761
 *  net.minecraft.class_1792
 *  net.minecraft.class_1792$class_1793
 *  net.minecraft.class_1799
 *  net.minecraft.class_1928
 *  net.minecraft.class_1928$class_4310
 *  net.minecraft.class_1928$class_4313
 *  net.minecraft.class_1928$class_4314
 *  net.minecraft.class_1928$class_5198
 *  net.minecraft.class_1935
 *  net.minecraft.class_2246
 *  net.minecraft.class_2248
 *  net.minecraft.class_2498
 *  net.minecraft.class_2591
 *  net.minecraft.class_2591$class_2592
 *  net.minecraft.class_2960
 *  net.minecraft.class_3417
 *  net.minecraft.class_4970
 *  net.minecraft.class_4970$class_2251
 *  net.minecraft.class_5321
 *  net.minecraft.class_7923
 *  net.minecraft.class_7924
 *  org.slf4j.Logger
 *  org.slf4j.LoggerFactory
 */
package ace.actually.pirates;

import ace.actually.pirates.blocks.CannonPrimingBlock;
import ace.actually.pirates.blocks.CrewSpawnerBlock;
import ace.actually.pirates.blocks.DispenserCannonBlock;
import ace.actually.pirates.blocks.MotionInvokingBlock;
import ace.actually.pirates.blocks.ShipIdBlock;
import ace.actually.pirates.blocks.StableBlock;
import ace.actually.pirates.blocks.entity.CannonPrimingBlockEntity;
import ace.actually.pirates.blocks.entity.CrewSpawnerBlockEntity;
import ace.actually.pirates.blocks.entity.MotionInvokingBlockEntity;
import ace.actually.pirates.blocks.entity.ShipIdBlockEntity;
import ace.actually.pirates.blocks.entity.StableBlockEntity;
import ace.actually.pirates.client.PiratesClient;
import ace.actually.pirates.entities.friendly_pirate.FriendlyPirateEntity;
import ace.actually.pirates.entities.pirate_default.PirateEntity;
import ace.actually.pirates.entities.pirate_skeleton.SkeletonPirateEntity;
import ace.actually.pirates.entities.shot.ShotEntity;
import ace.actually.pirates.items.ContractItem;
import ace.actually.pirates.items.ShipPather;
import ace.actually.pirates.items.ShipPointer;
import ace.actually.pirates.items.TestItem;
import ace.actually.pirates.sound.ModSounds;
import ace.actually.pirates.util.ConfigUtils;
import com.google.common.base.Suppliers;
import dev.architectury.platform.Platform;
import dev.architectury.registry.level.entity.EntityAttributeRegistry;
import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.Registrar;
import dev.architectury.registry.registries.RegistrarManager;
import dev.architectury.registry.registries.RegistrySupplier;
import dev.architectury.utils.Env;
import dev.architectury.utils.EnvExecutor;
import java.util.function.Supplier;
import net.minecraft.class_1299;
import net.minecraft.class_1311;
import net.minecraft.class_1747;
import net.minecraft.class_1761;
import net.minecraft.class_1792;
import net.minecraft.class_1799;
import net.minecraft.class_1928;
import net.minecraft.class_1935;
import net.minecraft.class_2246;
import net.minecraft.class_2248;
import net.minecraft.class_2498;
import net.minecraft.class_2591;
import net.minecraft.class_2960;
import net.minecraft.class_3417;
import net.minecraft.class_4970;
import net.minecraft.class_5321;
import net.minecraft.class_7923;
import net.minecraft.class_7924;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Pirates {
    public static final String MOD_ID = "pirates";
    public static final Supplier<RegistrarManager> MANAGER = Suppliers.memoize(() -> RegistrarManager.get((String)MOD_ID));
    public static final Logger LOGGER = LoggerFactory.getLogger((String)"pirates");
    public static final class_1928.class_4313<class_1928.class_4310> PIRATES_IS_LIVE_WORLD = class_1928.method_8359((String)"piratesIsLive", (class_1928.class_5198)class_1928.class_5198.field_24100, (class_1928.class_4314)class_1928.class_4310.method_20759((boolean)true));
    public static final class_5321<class_1761> PIRATES_ITEM_GROUP_KEY = class_5321.method_29179((class_5321)class_7923.field_44687.method_30517(), (class_2960)class_2960.method_43902((String)"pirates", (String)"item_group"));
    public static float baseShotPower;
    public static float cannonRange;
    public static int pursuitDistance;
    public static boolean shouldEnableFlyingPirates;
    public static Supplier<class_1799> recruitCost;
    public static CompatTracker loadedCompats;
    private static final class_2498 Silent;
    public static RegistrySupplier<MotionInvokingBlock> MOTION_INVOKING_BLOCK;
    public static RegistrySupplier<CannonPrimingBlock> CANNON_PRIMING_BLOCK;
    public static RegistrySupplier<DispenserCannonBlock> DISPENSER_CANNON_BLOCK;
    public static RegistrySupplier<CrewSpawnerBlock> CREW_SPAWNER_BLOCK;
    public static RegistrySupplier<StableBlock> STABLE_BLOCK;
    public static RegistrySupplier<ShipIdBlock> SHIP_ID_BLOCK;
    public static RegistrySupplier<class_2248> HEAVY_BLOCK;
    public static RegistrySupplier<class_2591<MotionInvokingBlockEntity>> MOTION_INVOKING_BLOCK_ENTITY;
    public static RegistrySupplier<class_2591<CannonPrimingBlockEntity>> CANNON_PRIMING_BLOCK_ENTITY;
    public static RegistrySupplier<class_2591<CrewSpawnerBlockEntity>> CREW_SPAWNER_BLOCK_ENTITY;
    public static RegistrySupplier<class_2591<StableBlockEntity>> STABLE_BLOCK_ENTITY;
    public static RegistrySupplier<class_2591<ShipIdBlockEntity>> SHIP_ID_BLOCK_ENTITY;
    public static RegistrySupplier<class_1792> CANNONBALL;
    public static RegistrySupplier<class_1792> FIRE_CANNONBALL;
    public static RegistrySupplier<class_1792> WEIGHTED_CANNONBALL;
    public static RegistrySupplier<class_1792> CANNONBALL_ENT;
    public static RegistrySupplier<ShipPointer> SHIP_POINTER;
    public static RegistrySupplier<ShipPather> SHIP_PATHER;
    public static RegistrySupplier<ContractItem> CANNONEER_ITEM;
    public static RegistrySupplier<ContractItem> DOCTOR_ITEM;
    public static RegistrySupplier<TestItem> TEST_ITEM;
    public static final DeferredRegister<class_1299<?>> ENTITY_TYPES;
    public static final RegistrySupplier<class_1299<ShotEntity>> SHOT_ENTITY_TYPE;
    public static final RegistrySupplier<class_1299<PirateEntity>> PIRATE_ENTITY_TYPE;
    public static final RegistrySupplier<class_1299<FriendlyPirateEntity>> FRIENDLY_PIRATE_TYPE;
    public static RegistrySupplier<class_1299<SkeletonPirateEntity>> SKELETON_PIRATE_ENTITY_TYPE;

    public static void init() {
        if (Platform.isModLoaded((String)"vs_sails")) {
            Pirates.loadedCompats.sails = true;
        }
        if (Platform.isModLoaded((String)"vs_eureka")) {
            Pirates.loadedCompats.eureka = true;
        }
        ConfigUtils.checkConfigs();
        baseShotPower = Float.parseFloat(ConfigUtils.config.getOrDefault("base-shot-power", "2.2"));
        cannonRange = Float.parseFloat(ConfigUtils.config.getOrDefault("cannon-range", "1.7"));
        pursuitDistance = Integer.parseInt(ConfigUtils.config.getOrDefault("pursuit-distance", "10000"));
        shouldEnableFlyingPirates = ConfigUtils.config.getOrDefault("should-enable-flying-pirates", "false").equals("true");
        String[] rc = ConfigUtils.config.getOrDefault("recruit-cost", "minecraft:golden_apple,1").split(",");
        recruitCost = () -> new class_1799((class_1935)class_7923.field_41178.method_10223(class_2960.method_12829((String)rc[0])), Integer.parseInt(rc[1]));
        Pirates.registerBlocks();
        Pirates.registerBlockEntities();
        Pirates.registerItems();
        Pirates.registerEntities();
        ModSounds.registerSounds();
        EnvExecutor.runInEnv((Env)Env.CLIENT, () -> PiratesClient::initClientFromMain);
    }

    private static void registerBlocks() {
        Registrar blocks = MANAGER.get().get(class_7924.field_41254);
        CANNON_PRIMING_BLOCK = blocks.register(new class_2960(MOD_ID, "cannon_priming_block"), () -> new CannonPrimingBlock(class_4970.class_2251.method_9630((class_4970)class_2246.field_10200).method_36557(5.0f)));
        MOTION_INVOKING_BLOCK = blocks.register(new class_2960(MOD_ID, "motion_invoking_block"), () -> new MotionInvokingBlock(class_4970.class_2251.method_9630((class_4970)class_2246.field_10307).method_45477().method_36557(7.0f).method_42327()));
        DISPENSER_CANNON_BLOCK = blocks.register(new class_2960(MOD_ID, "dispenser_cannon_block"), () -> new DispenserCannonBlock(class_4970.class_2251.method_9630((class_4970)class_2246.field_10200).method_36557(5.0f)));
        CREW_SPAWNER_BLOCK = blocks.register(new class_2960(MOD_ID, "crew_spawner_block"), () -> new CrewSpawnerBlock(class_4970.class_2251.method_9630((class_4970)class_2246.field_10307).method_45477().method_9634().method_42327().method_9626(Silent)));
        STABLE_BLOCK = blocks.register(new class_2960(MOD_ID, "stable_block"), () -> new StableBlock(class_4970.class_2251.method_9637()));
        SHIP_ID_BLOCK = blocks.register(new class_2960(MOD_ID, "ship_id_block"), () -> new ShipIdBlock(class_4970.class_2251.method_9637()));
        HEAVY_BLOCK = blocks.register(new class_2960(MOD_ID, "heavy_block"), () -> new class_2248(class_4970.class_2251.method_9630((class_4970)class_2246.field_10540)));
    }

    private static void registerBlockEntities() {
        Registrar bes = MANAGER.get().get(class_7924.field_41255);
        MOTION_INVOKING_BLOCK_ENTITY = bes.register(new class_2960(MOD_ID, "motion_invoking_block_entity"), () -> class_2591.class_2592.method_20528(MotionInvokingBlockEntity::new, (class_2248[])new class_2248[]{(class_2248)MOTION_INVOKING_BLOCK.get()}).method_11034(null));
        CANNON_PRIMING_BLOCK_ENTITY = bes.register(new class_2960(MOD_ID, "cannon_priming_block_entity"), () -> class_2591.class_2592.method_20528(CannonPrimingBlockEntity::new, (class_2248[])new class_2248[]{(class_2248)CANNON_PRIMING_BLOCK.get()}).method_11034(null));
        CREW_SPAWNER_BLOCK_ENTITY = bes.register(new class_2960(MOD_ID, "crew_spawner_block_entity"), () -> class_2591.class_2592.method_20528(CrewSpawnerBlockEntity::new, (class_2248[])new class_2248[]{(class_2248)CREW_SPAWNER_BLOCK.get()}).method_11034(null));
        STABLE_BLOCK_ENTITY = bes.register(new class_2960(MOD_ID, "stable_block_entity"), () -> class_2591.class_2592.method_20528(StableBlockEntity::new, (class_2248[])new class_2248[]{(class_2248)STABLE_BLOCK.get()}).method_11034(null));
        SHIP_ID_BLOCK_ENTITY = bes.register(new class_2960(MOD_ID, "ship_id_block_entity"), () -> class_2591.class_2592.method_20528(ShipIdBlockEntity::new, (class_2248[])new class_2248[]{(class_2248)SHIP_ID_BLOCK.get()}).method_11034(null));
    }

    private static void registerItems() {
        Registrar items = MANAGER.get().get(class_7924.field_41197);
        CANNONBALL = items.register(new class_2960(MOD_ID, "cannonball"), () -> new class_1792(new class_1792.class_1793()));
        FIRE_CANNONBALL = items.register(new class_2960(MOD_ID, "fire_cannonball"), () -> new class_1792(new class_1792.class_1793()));
        WEIGHTED_CANNONBALL = items.register(new class_2960(MOD_ID, "weighted_cannonball"), () -> new class_1792(new class_1792.class_1793()));
        CANNONBALL_ENT = items.register(new class_2960("util_pirates", "util_1"), () -> new class_1792(new class_1792.class_1793()));
        SHIP_POINTER = items.register(new class_2960(MOD_ID, "ship_pointer"), () -> new ShipPointer(new class_1792.class_1793()));
        CANNONEER_ITEM = items.register(new class_2960(MOD_ID, "cannoneer"), () -> new ContractItem((class_2248)CANNON_PRIMING_BLOCK.get(), "cannoneer"));
        DOCTOR_ITEM = items.register(new class_2960(MOD_ID, "doctor"), () -> new ContractItem(class_2246.field_10205, "doctor"));
        SHIP_PATHER = items.register(new class_2960(MOD_ID, "ship_pather"), () -> new ShipPather(new class_1792.class_1793()));
        items.register(new class_2960(MOD_ID, "stable_block"), () -> new class_1747((class_2248)STABLE_BLOCK.get(), new class_1792.class_1793()));
        items.register(new class_2960(MOD_ID, "cannon_priming_block"), () -> new class_1747((class_2248)CANNON_PRIMING_BLOCK.get(), new class_1792.class_1793()));
        TEST_ITEM = items.register(new class_2960(MOD_ID, "test"), () -> new TestItem(new class_1792.class_1793()));
        items.register(new class_2960(MOD_ID, "motion_invoking_block"), () -> new class_1747((class_2248)MOTION_INVOKING_BLOCK.get(), new class_1792.class_1793()));
        items.register(new class_2960(MOD_ID, "crew_spawner_block"), () -> new class_1747((class_2248)CREW_SPAWNER_BLOCK.get(), new class_1792.class_1793()));
        items.register(new class_2960(MOD_ID, "ship_id_block"), () -> new class_1747((class_2248)SHIP_ID_BLOCK.get(), new class_1792.class_1793()));
    }

    private static void registerEntities() {
        ENTITY_TYPES.register();
        EntityAttributeRegistry.register(PIRATE_ENTITY_TYPE, PirateEntity::attributes);
        EntityAttributeRegistry.register(FRIENDLY_PIRATE_TYPE, FriendlyPirateEntity::attributes);
    }

    static {
        loadedCompats = new CompatTracker();
        Silent = new class_2498(0.0f, 0.0f, class_3417.field_15083, class_3417.field_15083, class_3417.field_15083, class_3417.field_15083, class_3417.field_15083);
        ENTITY_TYPES = DeferredRegister.create((String)MOD_ID, (class_5321)class_7924.field_41266);
        SHOT_ENTITY_TYPE = ENTITY_TYPES.register("shot", () -> class_1299.class_1300.method_5903(ShotEntity::new, (class_1311)class_1311.field_17715).method_17687(0.5f, 0.5f).method_5905("shot"));
        PIRATE_ENTITY_TYPE = ENTITY_TYPES.register("pirate", () -> class_1299.class_1300.method_5903(PirateEntity::new, (class_1311)class_1311.field_17715).method_17687(0.6f, 1.9f).method_5905("pirate"));
        FRIENDLY_PIRATE_TYPE = ENTITY_TYPES.register("friendly_pirate", () -> class_1299.class_1300.method_5903(FriendlyPirateEntity::new, (class_1311)class_1311.field_17715).method_17687(0.6f, 1.9f).method_5905("friendly_pirate"));
        SKELETON_PIRATE_ENTITY_TYPE = null;
    }

    public static class CompatTracker {
        public boolean eureka = false;
        public boolean sails = false;
    }
}

