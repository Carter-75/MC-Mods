/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.block.Block
 */
package backported.updates.copper.compat;

import java.util.Set;
import net.minecraft.block.Block;

public interface IRendererCompat {
    public Set<Block> getFastRenderBlocks();

    public boolean isFastRenderEnabled(Block var1);
}

