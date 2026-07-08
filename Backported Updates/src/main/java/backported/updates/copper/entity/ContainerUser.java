/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.LivingEntity
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.block.entity.ViewerCountManager
 */
package backported.updates.copper.entity;

import net.minecraft.entity.LivingEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.block.entity.ViewerCountManager;

public interface ContainerUser {
    public boolean hasContainerOpen(ViewerCountManager var1, BlockPos var2);

    public double getContainerInteractionRange();

    default public LivingEntity getLivingEntity() {
        if (this instanceof LivingEntity) {
            return (LivingEntity)this;
        }
        throw new IllegalStateException("A container user must be a LivingEntity");
    }
}

