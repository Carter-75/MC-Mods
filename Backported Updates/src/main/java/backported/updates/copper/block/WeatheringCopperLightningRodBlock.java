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
 *  net.minecraft.item.Items
 *  net.minecraft.world.World
 *  net.minecraft.block.Blocks
 *  net.minecraft.block.Block
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.block.BlockState
 *  net.minecraft.server.world.ServerWorld
 *  net.minecraft.sound.SoundEvents
 *  net.minecraft.sound.SoundCategory
 *  net.minecraft.registry.tag.ItemTags
 *  net.minecraft.util.hit.BlockHitResult
 *  net.minecraft.block.AbstractBlock$Settings
 *  net.minecraft.block.Degradable
 *  net.minecraft.util.math.random.Random
 *  net.minecraft.block.Oxidizable
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
import net.minecraft.item.Items;
import net.minecraft.world.World;
import net.minecraft.block.Blocks;
import net.minecraft.block.Block;
import net.minecraft.util.math.BlockPos;
import net.minecraft.block.BlockState;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundEvents;
import net.minecraft.sound.SoundCategory;
import net.minecraft.registry.tag.ItemTags;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Degradable;
import net.minecraft.util.math.random.Random;
import net.minecraft.block.Oxidizable;
import net.minecraft.util.ItemActionResult;

public class WeatheringCopperLightningRodBlock
extends CopperLightningRodBlock
implements Oxidizable {
    public static final MapCodec<WeatheringCopperLightningRodBlock> CODEC = RecordCodecBuilder.mapCodec(instance -> instance.group(Oxidizable.OxidationLevel.CODEC.fieldOf("weathering_state").forGetter(Degradable::getDegradationLevel), WeatheringCopperLightningRodBlock.createSettingsCodec()).apply(instance, WeatheringCopperLightningRodBlock::new));
    private final Oxidizable.OxidationLevel weatherState;

    @Override
    public MapCodec<? extends CopperLightningRodBlock> getCodec() {
        return CODEC;
    }

    public WeatheringCopperLightningRodBlock(Oxidizable.OxidationLevel weatherState, AbstractBlock.Settings properties) {
        super(properties);
        this.weatherState = weatherState;
    }

    public Oxidizable.OxidationLevel getAge() {
        return this.weatherState;
    }

    public Oxidizable.OxidationLevel getDegradationLevel() {
        return this.weatherState;
    }

    public Optional<Block> getNextBlock() {
        return switch (this.weatherState) {
            default -> throw new MatchException(null, null);
            case Oxidizable.OxidationLevel.UNAFFECTED -> Optional.of((Block)ModBlocks.EXPOSED_LIGHTNING_ROD.get());
            case Oxidizable.OxidationLevel.EXPOSED -> Optional.of((Block)ModBlocks.WEATHERED_LIGHTNING_ROD.get());
            case Oxidizable.OxidationLevel.WEATHERED -> Optional.of((Block)ModBlocks.OXIDIZED_LIGHTNING_ROD.get());
            case Oxidizable.OxidationLevel.OXIDIZED -> Optional.empty();
        };
    }

    public Optional<Block> getPreviousBlock() {
        return switch (this.weatherState) {
            default -> throw new MatchException(null, null);
            case Oxidizable.OxidationLevel.UNAFFECTED -> Optional.empty();
            case Oxidizable.OxidationLevel.EXPOSED -> Optional.of(Blocks.LIGHTNING_ROD);
            case Oxidizable.OxidationLevel.WEATHERED -> Optional.of((Block)ModBlocks.EXPOSED_LIGHTNING_ROD.get());
            case Oxidizable.OxidationLevel.OXIDIZED -> Optional.of((Block)ModBlocks.WEATHERED_LIGHTNING_ROD.get());
        };
    }

    public Optional<Block> getWaxedBlock() {
        return switch (this.weatherState) {
            default -> throw new MatchException(null, null);
            case Oxidizable.OxidationLevel.UNAFFECTED -> Optional.of((Block)ModBlocks.WAXED_LIGHTNING_ROD.get());
            case Oxidizable.OxidationLevel.EXPOSED -> Optional.of((Block)ModBlocks.WAXED_EXPOSED_LIGHTNING_ROD.get());
            case Oxidizable.OxidationLevel.WEATHERED -> Optional.of((Block)ModBlocks.WAXED_WEATHERED_LIGHTNING_ROD.get());
            case Oxidizable.OxidationLevel.OXIDIZED -> Optional.of((Block)ModBlocks.WAXED_OXIDIZED_LIGHTNING_ROD.get());
        };
    }

    protected void randomTick(BlockState state, ServerWorld level, BlockPos pos, Random random) {
        this.tickDegradation(state, level, pos, random);
    }

    protected boolean hasRandomTicks(BlockState state) {
        return this.getNextBlock().isPresent();
    }

    public Optional<BlockState> getDegradationResult(BlockState state) {
        return this.getNextBlock().map(block -> block.getStateWithProperties(state));
    }

    public float getDegradationChanceMultiplier() {
        return 1.0f;
    }

    protected ItemActionResult onUseWithItem(ItemStack stack, BlockState state, World level, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hitResult) {
        Optional<Block> previousBlock;
        Optional<Block> waxedBlock;
        if (stack.isOf(Items.HONEYCOMB) && (waxedBlock = this.getWaxedBlock()).isPresent()) {
            level.playSound(player, pos, SoundEvents.ITEM_HONEYCOMB_WAX_ON, SoundCategory.BLOCKS, 1.0f, 1.0f);
            level.syncWorldEvent(player, 3003, pos, 0);
            if (!level.isClient) {
                level.setBlockState(pos, waxedBlock.get().getStateWithProperties(state), 11);
                if (!player.getAbilities().creativeMode) {
                    stack.decrement(1);
                }
            }
            return ItemActionResult.success((boolean)level.isClient);
        }
        if (stack.isIn(ItemTags.AXES) && (previousBlock = this.getPreviousBlock()).isPresent()) {
            level.playSound(player, pos, SoundEvents.ITEM_AXE_SCRAPE, SoundCategory.BLOCKS, 1.0f, 1.0f);
            level.syncWorldEvent(player, 3005, pos, 0);
            if (!level.isClient) {
                level.setBlockState(pos, previousBlock.get().getStateWithProperties(state), 11);
                if (!player.getAbilities().creativeMode) {
                    stack.damage(1, (LivingEntity)player, hand == Hand.MAIN_HAND ? EquipmentSlot.MAINHAND : EquipmentSlot.OFFHAND);
                }
            }
            return ItemActionResult.success((boolean)level.isClient);
        }
        return super.onUseWithItem(stack, state, level, pos, player, hand, hitResult);
    }
}

