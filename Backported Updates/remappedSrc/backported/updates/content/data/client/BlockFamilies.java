/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.common.collect.Maps
 *  net.minecraft.class_2248
 *  net.minecraft.class_5794
 *  net.minecraft.class_5794$class_5795
 *  net.minecraft.class_7923
 */
package backported.updates.content.data.client;

import backported.updates.content.common.registries.ModBlocks;
import com.google.common.collect.Maps;
import java.util.Map;
import java.util.function.Supplier;
import java.util.stream.Stream;
import net.minecraft.class_2248;
import net.minecraft.class_5794;
import net.minecraft.class_7923;

public class BlockFamilies {
    private static final Map<class_2248, class_5794> MAP = Maps.newHashMap();
    public static final class_5794 PALE_OAK_PLANKS = BlockFamilies.familyBuilder(ModBlocks.PALE_OAK_PLANKS.get()).method_33482(ModBlocks.PALE_OAK_BUTTON.get()).method_33490(ModBlocks.PALE_OAK_FENCE.get()).method_33491(ModBlocks.PALE_OAK_FENCE_GATE.get()).method_33494(ModBlocks.PALE_OAK_PRESSURE_PLATE.get()).method_33483((class_2248)((Supplier)ModBlocks.PALE_OAK_SIGN.getFirst()).get(), (class_2248)((Supplier)ModBlocks.PALE_OAK_SIGN.getSecond()).get()).method_33492(ModBlocks.PALE_OAK_SLAB.get()).method_33493(ModBlocks.PALE_OAK_STAIRS.get()).method_33489(ModBlocks.PALE_OAK_DOOR.get()).method_33496(ModBlocks.PALE_OAK_TRAPDOOR.get()).method_33484("wooden").method_33487("has_planks").method_33481();
    public static final class_5794 RESIN_BRICKS = BlockFamilies.familyBuilder(ModBlocks.RESIN_BRICKS.get()).method_33497(ModBlocks.RESIN_BRICK_WALL.get()).method_33493(ModBlocks.RESIN_BRICK_STAIRS.get()).method_33492(ModBlocks.RESIN_BRICK_SLAB.get()).method_33486(ModBlocks.CHISELED_RESIN_BRICKS.get()).method_33481();

    private static class_5794.class_5795 familyBuilder(class_2248 block) {
        class_5794.class_5795 builder = new class_5794.class_5795(block);
        class_5794 family = MAP.put(block, builder.method_33481());
        if (family != null) {
            throw new IllegalStateException("Duplicate family definition for " + String.valueOf(class_7923.field_41175.method_10221((Object)block)));
        }
        return builder;
    }

    public static Stream<class_5794> getAllFamilies() {
        return MAP.values().stream();
    }
}

