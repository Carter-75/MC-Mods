/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1297
 *  net.minecraft.class_1299
 *  net.minecraft.class_1304
 *  net.minecraft.class_1646
 *  net.minecraft.class_1792
 *  net.minecraft.class_1799
 *  net.minecraft.class_1802
 *  net.minecraft.class_1893
 *  net.minecraft.class_1935
 *  net.minecraft.class_1937
 *  net.minecraft.class_2248
 *  net.minecraft.class_2338
 *  net.minecraft.class_2586
 *  net.minecraft.class_2591
 *  net.minecraft.class_2680
 *  net.minecraft.class_2741
 *  net.minecraft.class_2769
 *  net.minecraft.class_2960
 *  net.minecraft.class_3218
 *  net.minecraft.class_3854
 *  net.minecraft.class_6880
 *  net.minecraft.class_7923
 *  org.jetbrains.annotations.NotNull
 *  org.valkyrienskies.core.api.ships.Ship
 *  org.valkyrienskies.mod.common.VSGameUtilsKt
 */
package ace.actually.pirates.blocks.entity;

import ace.actually.pirates.Pirates;
import ace.actually.pirates.entities.CrewSpawnType;
import ace.actually.pirates.entities.CrewTypes;
import ace.actually.pirates.entities.pirate_default.PirateEntity;
import ace.actually.pirates.util.ConfigUtils;
import net.minecraft.class_1297;
import net.minecraft.class_1299;
import net.minecraft.class_1304;
import net.minecraft.class_1646;
import net.minecraft.class_1792;
import net.minecraft.class_1799;
import net.minecraft.class_1802;
import net.minecraft.class_1893;
import net.minecraft.class_1935;
import net.minecraft.class_1937;
import net.minecraft.class_2248;
import net.minecraft.class_2338;
import net.minecraft.class_2586;
import net.minecraft.class_2591;
import net.minecraft.class_2680;
import net.minecraft.class_2741;
import net.minecraft.class_2769;
import net.minecraft.class_2960;
import net.minecraft.class_3218;
import net.minecraft.class_3854;
import net.minecraft.class_6880;
import net.minecraft.class_7923;
import org.jetbrains.annotations.NotNull;
import org.valkyrienskies.core.api.ships.Ship;
import org.valkyrienskies.mod.common.VSGameUtilsKt;

public class CrewSpawnerBlockEntity
extends class_2586 {
    public int countdown = 0;

    public CrewSpawnerBlockEntity(class_2338 pos, class_2680 state) {
        super((class_2591)Pirates.CREW_SPAWNER_BLOCK_ENTITY.get(), pos, state);
    }

    public static void tick(class_1937 world, class_2338 pos, class_2680 state, CrewSpawnerBlockEntity be) {
        if (world.method_8450().method_8355(Pirates.PIRATES_IS_LIVE_WORLD)) {
            if (((Boolean)state.method_11654((class_2769)class_2741.field_12486)).booleanValue()) {
                CrewSpawnerBlockEntity.spawnCrewIfOnShip(world, be);
            } else {
                CrewSpawnerBlockEntity.spawnCrew(world, be);
            }
        }
    }

    private static void spawnCrewIfOnShip(class_1937 world, CrewSpawnerBlockEntity be) {
        if (!world.method_8608() && VSGameUtilsKt.isBlockInShipyard((class_1937)world, (class_2338)be.method_11016())) {
            Ship ship = VSGameUtilsKt.getShipManagingPos((class_1937)world, (class_2338)be.method_11016());
            if (ship == null) {
                return;
            }
            if (be.countdown > 100) {
                CrewSpawnerBlockEntity.spawnCrew(world, be);
            } else {
                ++be.countdown;
            }
        }
    }

    private static void spawnCrew(class_1937 world, CrewSpawnerBlockEntity be) {
        class_1297 crew = CrewSpawnerBlockEntity.getEntityFromState(world, be);
        if (crew != null) {
            crew.method_33574(be.method_11016().method_46558().method_1031(0.0, -0.5, 0.0));
            world.method_8649(crew);
        }
        world.method_22352(be.method_11016(), false);
    }

    private static class_2338 checkForBlocksToCrew(class_1937 world, class_2338 origin) {
        class_2338 blockResult = new class_2338(0, 0, 0);
        if (world.method_8320(origin.method_10095()).method_27852((class_2248)Pirates.CANNON_PRIMING_BLOCK.get())) {
            blockResult = origin.method_10095();
        } else if (world.method_8320(origin.method_10078()).method_27852((class_2248)Pirates.CANNON_PRIMING_BLOCK.get())) {
            blockResult = origin.method_10078();
        } else if (world.method_8320(origin.method_10072()).method_27852((class_2248)Pirates.CANNON_PRIMING_BLOCK.get())) {
            blockResult = origin.method_10072();
        } else if (world.method_8320(origin.method_10067()).method_27852((class_2248)Pirates.CANNON_PRIMING_BLOCK.get())) {
            blockResult = origin.method_10067();
        }
        class_2338 origin1 = origin.method_10074();
        if (world.method_8320(origin1.method_10095()).method_27852((class_2248)Pirates.MOTION_INVOKING_BLOCK.get()) || world.method_8320(origin1.method_10095()).method_27852((class_2248)Pirates.CANNON_PRIMING_BLOCK.get())) {
            blockResult = origin1.method_10095();
        } else if (world.method_8320(origin1.method_10078()).method_27852((class_2248)Pirates.MOTION_INVOKING_BLOCK.get()) || world.method_8320(origin1.method_10078()).method_27852((class_2248)Pirates.CANNON_PRIMING_BLOCK.get())) {
            blockResult = origin1.method_10078();
        } else if (world.method_8320(origin1.method_10072()).method_27852((class_2248)Pirates.MOTION_INVOKING_BLOCK.get()) || world.method_8320(origin1.method_10072()).method_27852((class_2248)Pirates.CANNON_PRIMING_BLOCK.get())) {
            blockResult = origin1.method_10072();
        } else if (world.method_8320(origin1.method_10067()).method_27852((class_2248)Pirates.MOTION_INVOKING_BLOCK.get()) || world.method_8320(origin1.method_10067()).method_27852((class_2248)Pirates.CANNON_PRIMING_BLOCK.get())) {
            blockResult = origin1.method_10067();
        }
        return blockResult;
    }

    private static class_1297 getEntityFromState(class_1937 world, class_2586 be) {
        Object crew = null;
        switch ((CrewSpawnType)((Object)be.method_11010().method_11654(CrewTypes.CREW_SPAWN_TYPE))) {
            case PIRATE: {
                crew = new PirateEntity(world, CrewSpawnerBlockEntity.checkForBlocksToCrew(world, be.method_11016()));
                crew.method_5673(class_1304.field_6173, new class_1799((class_1935)class_1802.field_8102));
                break;
            }
            case VILLAGER: {
                crew = new class_1646(class_1299.field_6077, world, class_3854.method_16930((class_6880)world.method_23753(be.method_11016())));
                break;
            }
            case SKELETON_PIRATE: {
                class_2338 blockToCrew = CrewSpawnerBlockEntity.checkForBlocksToCrew(world, be.method_11016());
                crew = new PirateEntity(world, blockToCrew);
                class_1799 itemStack = new class_1799((class_1935)class_1802.field_8102);
                if (world.method_8320(blockToCrew).method_27852((class_2248)Pirates.MOTION_INVOKING_BLOCK.get())) {
                    itemStack.method_7978(class_1893.field_9103, 2);
                }
                crew.method_5673(class_1304.field_6173, itemStack);
                if (!(world instanceof class_3218)) break;
                class_3218 serverWorld = (class_3218)world;
                serverWorld.method_27910(0, 36000, true, true);
                break;
            }
            case CUSTOM_0: {
                crew = CrewSpawnerBlockEntity.makeCustomCrew(world, 0);
                break;
            }
            case CUSTOM_1: {
                crew = CrewSpawnerBlockEntity.makeCustomCrew(world, 1);
                break;
            }
            case CUSTOM_2: {
                crew = CrewSpawnerBlockEntity.makeCustomCrew(world, 2);
                break;
            }
            case CUSTOM_3: {
                crew = CrewSpawnerBlockEntity.makeCustomCrew(world, 3);
            }
        }
        return crew;
    }

    public static class_1297 makeCustomCrew(@NotNull class_1937 world, int number) {
        String id = ConfigUtils.config.getOrDefault("custom-crew-entity-" + number, "minecraft:zombie");
        class_1299 j = null;
        if (class_1299.method_5898((String)id).isPresent()) {
            j = (class_1299)class_1299.method_5898((String)id).get();
        }
        assert (j != null);
        class_1297 crew = j.method_5883(world);
        String equipments = ConfigUtils.config.getOrDefault("custom-crew-equipment-" + number, "0,0,0,0,0,0");
        String[] parts = equipments.split(",");
        if (parts.length == 6) {
            block8: for (int i = 0; i < parts.length; ++i) {
                if (parts[i].equals("0") || parts[i].equals("null") || parts[i].isEmpty()) continue;
                class_1792 item = (class_1792)class_7923.field_41178.method_10223(class_2960.method_12829((String)parts[i].replace(" ", "")));
                switch (i) {
                    case 0: {
                        crew.method_5673(class_1304.field_6173, new class_1799((class_1935)item));
                        continue block8;
                    }
                    case 1: {
                        crew.method_5673(class_1304.field_6171, new class_1799((class_1935)item));
                        continue block8;
                    }
                    case 2: {
                        crew.method_5673(class_1304.field_6169, new class_1799((class_1935)item));
                        continue block8;
                    }
                    case 3: {
                        crew.method_5673(class_1304.field_6174, new class_1799((class_1935)item));
                        continue block8;
                    }
                    case 4: {
                        crew.method_5673(class_1304.field_6172, new class_1799((class_1935)item));
                        continue block8;
                    }
                    case 5: {
                        crew.method_5673(class_1304.field_6166, new class_1799((class_1935)item));
                    }
                }
            }
        }
        return crew;
    }
}

