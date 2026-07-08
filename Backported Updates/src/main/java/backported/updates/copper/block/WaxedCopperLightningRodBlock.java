/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.datafixers.kinds.App
 *  com.mojang.datafixers.kinds.Applicative
 *  com.mojang.serialization.MapCodec
 *  com.mojang.serialization.codecs.RecordCodecBuilder
 *  net.minecraft.util.Hand
 *  net.minecraft.entity.EquipmentSlot
 *  net.minecraft.entity.LivingEntity
 *  net.minecraft.entity.player.PlayerEntity
 *  net.minecraft.item.ItemStack
 *  net.minecraft.world.World
 *  net.minecraft.block.Blocks
 *  net.minecraft.block.Block
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.block.BlockState
 *  net.minecraft.sound.SoundEvents
 *  net.minecraft.sound.SoundCategory
 *  net.minecraft.registry.tag.ItemTags
 *  net.minecraft.util.hit.BlockHitResult
 *  net.minecraft.block.AbstractBlock$Settings
 *  net.minecraft.block.Oxidizable$OxidationLevel
 *  net.minecraft.util.ItemActionResult
 */
package backported.updates.copper.block;

import backported.updates.copper.block.CopperLightningRodBlock;
import backported.updates.copper.registry.ModBlocks;
import com.mojang.datafixers.kinds.App;
import com.mojang.datafixers.kinds.Applicative;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import java.util.Optional;
import net.minecraft.util.Hand;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraft.block.Blocks;
import net.minecraft.block.Block;
import net.minecraft.util.math.BlockPos;
import net.minecraft.block.BlockState;
import net.minecraft.sound.SoundEvents;
import net.minecraft.sound.SoundCategory;
import net.minecraft.registry.tag.ItemTags;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Oxidizable;
import net.minecraft.util.ItemActionResult;

public class WaxedCopperLightningRodBlock
extends CopperLightningRodBlock {
    public static final MapCodec<WaxedCopperLightningRodBlock> CODEC = RecordCodecBuilder.mapCodec(instance -> instance.group(Oxidizable.OxidationLevel.CODEC.fieldOf("weathering_state").forGetter(WaxedCopperLightningRodBlock::getWeatheringState), WaxedCopperLightningRodBlock.createSettingsCodec()).apply(instance, WaxedCopperLightningRodBlock::new));
    private final Oxidizable.OxidationLevel weatheringState;

    @Override
    public MapCodec<? extends CopperLightningRodBlock> getCodec() {
        return CODEC;
    }

    public WaxedCopperLightningRodBlock(Oxidizable.OxidationLevel weatheringState, AbstractBlock.Settings properties) {
        super(properties);
        this.weatheringState = weatheringState;
    }

    public Oxidizable.OxidationLevel getWeatheringState() {
        return this.weatheringState;
    }

    public Optional<Block> getUnwaxedBlock() {
        return switch (this.weatheringState) {
            default -> throw new MatchException(null, null);
            case Oxidizable.OxidationLevel.UNAFFECTED -> Optional.of(Blocks.LIGHTNING_ROD);
            case Oxidizable.OxidationLevel.EXPOSED -> Optional.of((Block)ModBlocks.EXPOSED_LIGHTNING_ROD.get());
            case Oxidizable.OxidationLevel.WEATHERED -> Optional.of((Block)ModBlocks.WEATHERED_LIGHTNING_ROD.get());
            case Oxidizable.OxidationLevel.OXIDIZED -> Optional.of((Block)ModBlocks.OXIDIZED_LIGHTNING_ROD.get());
        };
    }

    protected ItemActionResult onUseWithItem(ItemStack stack, BlockState state, World level, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hitResult) {
        Optional<Block> unwaxed;
        if (stack.isIn(ItemTags.AXES) && (unwaxed = this.getUnwaxedBlock()).isPresent()) {
            level.playSound(player, pos, SoundEvents.ITEM_AXE_WAX_OFF, SoundCategory.BLOCKS, 1.0f, 1.0f);
            level.syncWorldEvent(player, 3004, pos, 0);
            if (!level.isClient) {
                level.setBlockState(pos, unwaxed.get().getStateWithProperties(state), 11);
                if (!player.getAbilities().creativeMode) {
                    stack.damage(1, (LivingEntity)player, hand == Hand.MAIN_HAND ? EquipmentSlot.MAINHAND : EquipmentSlot.OFFHAND);
                }
            }
            return ItemActionResult.success((boolean)level.isClient);
        }
        return super.onUseWithItem(stack, state, level, pos, player, hand, hitResult);
    }
}

