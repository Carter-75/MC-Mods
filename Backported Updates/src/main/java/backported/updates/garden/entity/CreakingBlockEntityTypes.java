/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.block.Block
 *  net.minecraft.registry.Registry
 *  net.minecraft.block.entity.BlockEntityType
 *  net.minecraft.block.entity.BlockEntityType$Builder
 *  net.minecraft.util.Identifier
 *  net.minecraft.registry.Registries
 */
package backported.updates.garden.entity;

import backported.updates.garden.Init;
import backported.updates.garden.entity.CreakingHeartBlockEntity;
import net.minecraft.block.Block;
import net.minecraft.registry.Registry;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.util.Identifier;
import net.minecraft.registry.Registries;

public class CreakingBlockEntityTypes {
    public static BlockEntityType<CreakingHeartBlockEntity> CREAKING_HEART_BLOCK = null;

    public static <T extends BlockEntityType<?>> T register(String path, T blockEntityType) {
        return (T)((BlockEntityType)Registry.register((Registry)Registries.BLOCK_ENTITY_TYPE, Identifier.of((String)"iwie", (String)path), blockEntityType));
    }

    public static void initialize() {
    }

    static {
        CREAKING_HEART_BLOCK = CreakingBlockEntityTypes.register("creaking_heart", BlockEntityType.Builder.create((pos, state) -> new CreakingHeartBlockEntity(CREAKING_HEART_BLOCK, pos, state), (Block[])new Block[]{Init.CREAKING_HEART}).build(null));
    }
}

