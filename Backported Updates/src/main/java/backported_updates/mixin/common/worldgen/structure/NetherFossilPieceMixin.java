/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.util.math.ChunkPos
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.util.math.Vec3i
 *  net.minecraft.util.BlockRotation
 *  net.minecraft.world.gen.chunk.ChunkGenerator
 *  net.minecraft.util.Identifier
 *  net.minecraft.util.math.BlockBox
 *  net.minecraft.structure.SimpleStructurePiece
 *  net.minecraft.structure.StructureTemplateManager
 *  net.minecraft.structure.StructurePlacementData
 *  net.minecraft.structure.StructurePieceType
 *  net.minecraft.structure.NetherFossilGenerator$Piece
 *  net.minecraft.world.gen.StructureAccessor
 *  net.minecraft.world.StructureWorldAccess
 *  net.minecraft.util.math.random.Random
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfo
 */
package backported_updates.mixin.common.worldgen.structure;

import backported.updates.content.common.registries.ModBlocks;
import backported.updates.content.core.VanillaBackport;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3i;
import net.minecraft.util.BlockRotation;
import net.minecraft.world.gen.chunk.ChunkGenerator;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockBox;
import net.minecraft.structure.SimpleStructurePiece;
import net.minecraft.structure.StructureTemplateManager;
import net.minecraft.structure.StructurePlacementData;
import net.minecraft.structure.StructurePieceType;
import net.minecraft.structure.NetherFossilGenerator;
import net.minecraft.world.gen.StructureAccessor;
import net.minecraft.world.StructureWorldAccess;
import net.minecraft.util.math.random.Random;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value={NetherFossilGenerator.Piece.class})
public abstract class NetherFossilPieceMixin
extends SimpleStructurePiece {
    public NetherFossilPieceMixin(StructurePieceType type, int genDepth, StructureTemplateManager structureTemplateManager, Identifier location, String templateName, StructurePlacementData placeSettings, BlockPos templatePosition) {
        super(type, genDepth, structureTemplateManager, location, templateName, placeSettings, templatePosition);
    }

    @Inject(method={"generate"}, at={@At(value="TAIL")})
    private void placeDriedGhast(StructureWorldAccess level, StructureAccessor structureManager, ChunkGenerator generator, Random worldRandom, BlockBox box, ChunkPos chunkPos, BlockPos origin, CallbackInfo ci) {
        if (VanillaBackport.COMMON_CONFIG.hasDriedGhasts.get().booleanValue() && level.getDimension().ultrawarm() && level.getDimension().piglinSafe()) {
            int z;
            int y;
            int x;
            BlockPos pos;
            BlockBox template = this.getTemplate().calculateBoundingBox(this.getPlacementData(), this.getPos());
            Random random = Random.create((long)level.getSeed()).nextSplitter().split(template.getCenter());
            if (random.nextFloat() < 0.5f && level.getBlockState(pos = new BlockPos(x = template.getMinX() + random.nextInt(template.getBlockCountX()), y = template.getMinY(), z = template.getMinZ() + random.nextInt(template.getBlockCountZ()))).isAir() && box.contains((Vec3i)pos)) {
                level.setBlockState(pos, ModBlocks.DRIED_GHAST.get().getDefaultState().rotate(BlockRotation.random(random)), 2);
            }
        }
    }
}

