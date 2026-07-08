/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_2248
 */
package backported.updates.copper.compat.modules;

import backported.updates.copper.Constants;
import backported.updates.copper.compat.IModCompatModule;
import backported.updates.copper.compat.IRendererCompat;
import backported.updates.copper.registry.ModBlocks;
import java.util.HashSet;
import java.util.Set;
import net.minecraft.class_2248;

public class FastChestCompat
implements IModCompatModule,
IRendererCompat {
    public static final String MOD_ID = "fastchest";
    private final Set<class_2248> fastRenderBlocks = new HashSet<class_2248>();

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
            this.registerFastRenderBlock((class_2248)ModBlocks.COPPER_CHEST.get());
            this.registerFastRenderBlock((class_2248)ModBlocks.EXPOSED_COPPER_CHEST.get());
            this.registerFastRenderBlock((class_2248)ModBlocks.WEATHERED_COPPER_CHEST.get());
            this.registerFastRenderBlock((class_2248)ModBlocks.OXIDIZED_COPPER_CHEST.get());
            this.registerFastRenderBlock((class_2248)ModBlocks.WAXED_COPPER_CHEST.get());
            this.registerFastRenderBlock((class_2248)ModBlocks.WAXED_EXPOSED_COPPER_CHEST.get());
            this.registerFastRenderBlock((class_2248)ModBlocks.WAXED_WEATHERED_COPPER_CHEST.get());
            this.registerFastRenderBlock((class_2248)ModBlocks.WAXED_OXIDIZED_COPPER_CHEST.get());
            Constants.LOG.info("FastChestCompat: Registered {} copper chest blocks for fast rendering", (Object)this.fastRenderBlocks.size());
        }
        catch (Exception e) {
            Constants.LOG.warn("FastChestCompat: Could not register blocks: {}", (Object)e.getMessage());
        }
    }

    protected void registerFastRenderBlock(class_2248 block) {
        if (block != null) {
            this.fastRenderBlocks.add(block);
        }
    }

    @Override
    public Set<class_2248> getFastRenderBlocks() {
        return Set.copyOf(this.fastRenderBlocks);
    }

    @Override
    public boolean isFastRenderEnabled(class_2248 block) {
        return this.fastRenderBlocks.contains(block);
    }
}

