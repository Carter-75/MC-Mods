/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1297
 *  net.minecraft.class_1937
 *  net.minecraft.class_2246
 *  net.minecraft.class_2248
 *  net.minecraft.class_2338
 *  net.minecraft.class_2350
 *  net.minecraft.class_2680
 *  net.minecraft.class_3218
 *  net.minecraft.class_3222
 *  net.minecraft.class_5955
 *  net.minecraft.class_5955$class_5811
 */
package backported.updates.copper.event;

import backported.updates.copper.ModMemoryTypes;
import backported.updates.copper.ModTags;
import backported.updates.copper.block.CopperChestBlock;
import backported.updates.copper.config.CommonConfig;
import backported.updates.copper.entity.CopperGolemEntity;
import backported.updates.copper.registry.ModEntities;
import net.minecraft.class_1297;
import net.minecraft.class_1937;
import net.minecraft.class_2246;
import net.minecraft.class_2248;
import net.minecraft.class_2338;
import net.minecraft.class_2350;
import net.minecraft.class_2680;
import net.minecraft.class_3218;
import net.minecraft.class_3222;
import net.minecraft.class_5955;

public final class CopperGolemSpawnLogic {
    private CopperGolemSpawnLogic() {
    }

    public static void handleBlockPlaced(class_1937 level, class_2338 pos, class_2680 placedState, class_2350 playerDirection) {
        class_2350 effectiveDirection;
        if (!(level instanceof class_3218)) {
            return;
        }
        class_3218 serverLevel = (class_3218)level;
        if (!CommonConfig.golemBuildSpawning()) {
            return;
        }
        class_2350 class_23502 = effectiveDirection = playerDirection != null ? playerDirection : class_2350.field_11043;
        if (placedState.method_27852(class_2246.field_10147)) {
            CopperGolemSpawnLogic.trySpawnCopperGolem(serverLevel, pos, effectiveDirection);
        }
    }

    private static void trySpawnCopperGolem(class_3218 level, class_2338 pumpkinPos, class_2350 playerDirection) {
        class_2338 copperPos = pumpkinPos.method_10074();
        class_2680 copperState = level.method_8320(copperPos);
        if (copperState.method_26164(ModTags.Blocks.COPPER)) {
            class_2350 direction = playerDirection.method_10153();
            level.method_20290(2001, pumpkinPos, class_2248.method_9507((class_2680)class_2246.field_10147.method_9564()));
            level.method_20290(2001, copperPos, class_2248.method_9507((class_2680)copperState));
            level.method_8652(pumpkinPos, class_2246.field_10124.method_9564(), 2);
            class_2248 copperBlock = copperState.method_26204();
            class_2680 chestState = CopperChestBlock.getFromCopperBlock(copperBlock, direction, (class_1937)level, copperPos);
            level.method_8652(copperPos, chestState, 2);
            CopperGolemEntity copperGolem = (CopperGolemEntity)ModEntities.COPPER_GOLEM.get().method_5883((class_1937)level);
            if (copperGolem != null) {
                float yaw = direction.method_10144();
                copperGolem.method_5808((double)copperPos.method_10263() + 0.5, (double)copperPos.method_10264() + 1.0, (double)copperPos.method_10260() + 0.5, yaw, 0.0f);
                copperGolem.method_36456(yaw);
                copperGolem.field_5982 = yaw;
                copperGolem.method_5636(yaw);
                copperGolem.field_6220 = yaw;
                copperGolem.method_5847(yaw);
                copperGolem.field_6259 = yaw;
                class_5955.class_5811 weatherState = CopperGolemSpawnLogic.getWeatherStateFromBlock(copperState.method_26204());
                copperGolem.spawn(weatherState);
                copperGolem.method_18868().method_18878(ModMemoryTypes.TRANSPORT_ITEMS_COOLDOWN_TICKS.get(), (Object)140);
                level.method_8649((class_1297)copperGolem);
                for (class_3222 class_32222 : level.method_18467(class_3222.class, copperGolem.method_5829().method_1014(5.0))) {
                }
                level.method_8452(copperPos, chestState.method_26204());
                level.method_8452(pumpkinPos, class_2246.field_10124);
            }
        }
    }

    private static class_5955.class_5811 getWeatherStateFromBlock(class_2248 block) {
        if (block instanceof class_5955) {
            class_5955 weatheringCopper = (class_5955)block;
            return (class_5955.class_5811)weatheringCopper.method_33622();
        }
        if (block == class_2246.field_27133) {
            return class_5955.class_5811.field_28704;
        }
        if (block == class_2246.field_27135) {
            return class_5955.class_5811.field_28705;
        }
        if (block == class_2246.field_27134) {
            return class_5955.class_5811.field_28706;
        }
        if (block == class_2246.field_33407) {
            return class_5955.class_5811.field_28707;
        }
        return class_5955.class_5811.field_28704;
    }
}

