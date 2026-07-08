/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.ai.pathing.Path
 *  net.minecraft.entity.mob.MobEntity
 *  net.minecraft.entity.ai.pathing.MobNavigation
 *  net.minecraft.world.World
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.world.chunk.WorldChunk
 *  net.minecraft.util.math.ChunkSectionPos
 */
package backported.updates.copper.entity.ai.navigation;

import java.util.Set;
import net.minecraft.entity.ai.pathing.Path;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.ai.pathing.MobNavigation;
import net.minecraft.world.World;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.chunk.WorldChunk;
import net.minecraft.util.math.ChunkSectionPos;

public class CopperGolemNavigation
extends MobNavigation {
    private float requiredPathLength = 16.0f;
    private boolean canPathToTargetsBelowSurface = false;

    public CopperGolemNavigation(MobEntity mob, World level) {
        super(mob, level);
    }

    public void setRequiredPathLength(float requiredPathLength) {
        this.requiredPathLength = requiredPathLength;
    }

    public float getRequiredPathLength() {
        return this.requiredPathLength;
    }

    public void setCanPathToTargetsBelowSurface(boolean canPathToTargetsBelowSurface) {
        this.canPathToTargetsBelowSurface = canPathToTargetsBelowSurface;
    }

    public boolean canPathToTargetsBelowSurface() {
        return this.canPathToTargetsBelowSurface;
    }

    public Path findPathTo(BlockPos pos, int accuracy) {
        if (!this.canPathToTargetsBelowSurface) {
            return super.findPathTo(pos, accuracy);
        }
        WorldChunk chunk = this.world.getChunkManager().getWorldChunk(ChunkSectionPos.getSectionCoord((int)pos.getX()), ChunkSectionPos.getSectionCoord((int)pos.getZ()));
        if (chunk == null) {
            return null;
        }
        return this.createPathDirect(pos, accuracy);
    }

    private Path createPathDirect(BlockPos pos, int accuracy) {
        return super.findPathTo(Set.of(pos), 8, false, accuracy);
    }
}

