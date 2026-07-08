/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_2591
 */
package backported.updates.content.common.registries;

import backported.updates.content.common.level.blockentities.CreakingHeartBlockEntity;
import backported.updates.content.common.registries.ModBlocks;
import backported.updates.foundation.core.helper.BlockEntityRegistry;
import backported.updates.foundation.core.helper.BlockEntityTypeBuilder;
import java.util.function.Supplier;
import net.minecraft.class_2591;

public class ModBlockEntities {
    public static final BlockEntityRegistry BLOCK_ENTITIES = BlockEntityRegistry.create("minecraft");
    public static final Supplier<class_2591<CreakingHeartBlockEntity>> CREAKING_HEART = BLOCK_ENTITIES.register("creaking_heart", BlockEntityTypeBuilder.create(CreakingHeartBlockEntity::new, ModBlocks.CREAKING_HEART));
}

