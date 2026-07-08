/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.block.entity.BlockEntityType
 */
package backported.updates.content.common.registries;

import backported.updates.content.common.level.blockentities.CreakingHeartBlockEntity;
import backported.updates.content.common.registries.ModBlocks;
import backported.updates.foundation.core.helper.BlockEntityRegistry;
import backported.updates.foundation.core.helper.BlockEntityTypeBuilder;
import java.util.function.Supplier;
import net.minecraft.block.entity.BlockEntityType;

public class ModBlockEntities {
    public static final BlockEntityRegistry BLOCK_ENTITIES = BlockEntityRegistry.create("backported_updates");
    public static final Supplier<BlockEntityType<CreakingHeartBlockEntity>> CREAKING_HEART = BLOCK_ENTITIES.register("creaking_heart", BlockEntityTypeBuilder.create(CreakingHeartBlockEntity::new, ModBlocks.CREAKING_HEART));
}

