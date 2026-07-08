/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.teamresourceful.resourcefullib.common.registry.RegistryEntry
 *  com.teamresourceful.resourcefullib.common.registry.ResourcefulRegistries
 *  com.teamresourceful.resourcefullib.common.registry.ResourcefulRegistry
 *  net.minecraft.class_2246
 *  net.minecraft.class_2248
 *  net.minecraft.class_2378
 *  net.minecraft.class_2769
 *  net.minecraft.class_4970
 *  net.minecraft.class_4970$class_2251
 *  net.minecraft.class_7923
 */
package tech.alexnijjar.golemoverhaul.common.registry;

import com.teamresourceful.resourcefullib.common.registry.RegistryEntry;
import com.teamresourceful.resourcefullib.common.registry.ResourcefulRegistries;
import com.teamresourceful.resourcefullib.common.registry.ResourcefulRegistry;
import net.minecraft.class_2246;
import net.minecraft.class_2248;
import net.minecraft.class_2378;
import net.minecraft.class_2769;
import net.minecraft.class_4970;
import net.minecraft.class_7923;
import tech.alexnijjar.golemoverhaul.common.blocks.CandleGolemBlock;
import tech.alexnijjar.golemoverhaul.common.blocks.ClayGolemStatueBlock;

public class ModBlocks {
    public static final ResourcefulRegistry<class_2248> BLOCKS = ResourcefulRegistries.create((class_2378)class_7923.field_41175, (String)"golemoverhaul");
    public static final RegistryEntry<class_2248> CANDLE_GOLEM_BLOCK = BLOCKS.register("candle_golem_block", () -> new CandleGolemBlock(class_4970.class_2251.method_9630((class_4970)class_2246.field_27099).method_9631(s -> (Boolean)s.method_11654((class_2769)CandleGolemBlock.field_27083) != false ? 12 : 0)));
    public static final RegistryEntry<class_2248> CLAY_GOLEM_STATUE = BLOCKS.register("clay_golem_statue", () -> new ClayGolemStatueBlock(class_4970.class_2251.method_9630((class_4970)class_2246.field_10460).method_22488().method_9640()));
}

