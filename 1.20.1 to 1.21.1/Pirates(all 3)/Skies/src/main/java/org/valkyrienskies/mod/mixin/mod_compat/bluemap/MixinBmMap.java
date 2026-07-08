/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.flowpowered.math.vector.Vector2i
 *  de.bluecolored.bluemap.core.map.BmMap
 *  de.bluecolored.bluemap.core.map.hires.HiresModelManager
 *  de.bluecolored.bluemap.core.util.Grid
 *  de.bluecolored.bluemap.core.world.World
 *  net.minecraft.class_1937
 *  org.spongepowered.asm.mixin.Final
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.Pseudo
 *  org.spongepowered.asm.mixin.Shadow
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Redirect
 */
package org.valkyrienskies.mod.mixin.mod_compat.bluemap;

import com.flowpowered.math.vector.Vector2i;
import de.bluecolored.bluemap.core.map.BmMap;
import de.bluecolored.bluemap.core.map.hires.HiresModelManager;
import de.bluecolored.bluemap.core.util.Grid;
import de.bluecolored.bluemap.core.world.World;
import java.util.function.Predicate;
import net.minecraft.class_1937;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Pseudo;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.valkyrienskies.mod.common.VSGameUtilsKt;
import org.valkyrienskies.mod.mixinducks.mod_compat.bluemap.WorldDuck;

@Mixin(value={BmMap.class})
@Pseudo
public class MixinBmMap {
    @Shadow
    @Final
    private World world;
    @Shadow
    @Final
    private HiresModelManager hiresModelManager;

    @Redirect(method={"renderTile"}, at=@At(value="INVOKE", target="Ljava/util/function/Predicate;test(Ljava/lang/Object;)Z"), remap=false)
    boolean skipShipyard(Predicate<Object> predicate, Object object) {
        int z;
        Grid grid;
        int x;
        Vector2i tilePos = (Vector2i)object;
        class_1937 level = ((WorldDuck)this.world).valkyrienskies$getCorrelatingLevel();
        boolean notShipyard = !VSGameUtilsKt.isBlockInShipyard(level, x = (grid = this.hiresModelManager.getTileGrid()).getCellMinX(tilePos.getX()) + 1, 0, z = grid.getCellMinY(tilePos.getY()) + 1);
        return predicate.test(tilePos) && notShipyard;
    }
}

