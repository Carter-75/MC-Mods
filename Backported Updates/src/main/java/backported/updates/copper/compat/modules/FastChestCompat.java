/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.block.Block
 */
package backported.updates.copper.compat.modules;

import backported.updates.copper.Constants;
import backported.updates.copper.compat.IModCompatModule;
import backported.updates.copper.compat.IRendererCompat;
import backported.updates.copper.registry.ModBlocks;
import java.util.HashSet;
import java.util.Set;
import net.minecraft.block.Block;

public class FastChestCompat
implements IModCompatModule,
IRendererCompat {
    public static final String MOD_ID = "fastchest";
    private final Set<Block> fastRenderBlocks = new HashSet<Block>();

    @Override
    public String getModId() {
        return MOD_ID;
    }

    @Override
    public void init() {
    }

    @Override
    public void initClient() {
        try {
            this.registerFastRenderBlock((Block)ModBlocks.COPPER_CHEST.get());
            this.registerFastRenderBlock((Block)ModBlocks.EXPOSED_COPPER_CHEST.get());
            this.registerFastRenderBlock((Block)ModBlocks.WEATHERED_COPPER_CHEST.get());
            this.registerFastRenderBlock((Block)ModBlocks.OXIDIZED_COPPER_CHEST.get());
            this.registerFastRenderBlock((Block)ModBlocks.WAXED_COPPER_CHEST.get());
            this.registerFastRenderBlock((Block)ModBlocks.WAXED_EXPOSED_COPPER_CHEST.get());
            this.registerFastRenderBlock((Block)ModBlocks.WAXED_WEATHERED_COPPER_CHEST.get());
            this.registerFastRenderBlock((Block)ModBlocks.WAXED_OXIDIZED_COPPER_CHEST.get());
            Constants.LOG.info("FastChestCompat: Registered {} copper chest blocks for fast rendering", this.fastRenderBlocks.size());
        }
        catch (Exception e) {
            Constants.LOG.warn("FastChestCompat: Could not register blocks: {}", e.getMessage());
        }
    }

    protected void registerFastRenderBlock(Block block) {
        if (block != null) {
            this.fastRenderBlocks.add(block);
        }
    }

    @Override
    public Set<Block> getFastRenderBlocks() {
        return Set.copyOf(this.fastRenderBlocks);
    }

    @Override
    public boolean isFastRenderEnabled(Block block) {
        return this.fastRenderBlocks.contains(block);
    }
}

