/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.world.World
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.util.math.Direction
 *  net.minecraft.nbt.NbtCompound
 *  net.minecraft.text.Text
 *  net.minecraft.text.Text$Serialization
 *  net.minecraft.block.entity.BlockEntity
 *  net.minecraft.block.entity.BlockEntity$ComponentsAccess
 *  net.minecraft.network.packet.s2c.play.BlockEntityUpdateS2CPacket
 *  net.minecraft.block.BlockState
 *  net.minecraft.Property
 *  net.minecraft.server.world.ServerWorld
 *  net.minecraft.registry.RegistryWrapper$WrapperLookup
 *  net.minecraft.component.ComponentMap$Builder
 *  net.minecraft.component.DataComponentTypes
 *  org.jetbrains.annotations.Nullable
 */
package backported.updates.copper.block.entity;

import backported.updates.copper.block.CopperGolemStatueBlock;
import backported.updates.copper.entity.CopperGolemEntity;
import backported.updates.copper.registry.ModBlockEntities;
import backported.updates.copper.registry.ModEntities;
import net.minecraft.world.World;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.text.Text;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.network.packet.s2c.play.BlockEntityUpdateS2CPacket;
import net.minecraft.block.BlockState;
import net.minecraft.state.property.Property;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.component.ComponentMap;
import net.minecraft.component.DataComponentTypes;
import org.jetbrains.annotations.Nullable;

public class CopperGolemStatueBlockEntity
extends BlockEntity {
    @Nullable
    private Text customName;

    public CopperGolemStatueBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.COPPER_GOLEM_STATUE_BLOCK_ENTITY.get(), pos, state);
    }

    public void createStatue(CopperGolemEntity golem) {
        this.customName = golem.getCustomName();
        this.markDirty();
    }

    @Nullable
    public CopperGolemEntity removeStatue(BlockState state, ServerWorld level) {
        CopperGolemEntity golem = (CopperGolemEntity)ModEntities.COPPER_GOLEM.get().create((World)level);
        if (golem != null) {
            BlockPos blockPos = this.getPos();
            golem.refreshPositionAndAngles((double)blockPos.getX() + 0.5, blockPos.getY(), (double)blockPos.getZ() + 0.5, ((Direction)state.get(CopperGolemStatueBlock.FACING)).asRotation(), 0.0f);
            golem.headYaw = golem.getYaw();
            golem.bodyYaw = golem.getYaw();
            golem.setCustomName(this.customName);
            golem.setWeatherState(((CopperGolemStatueBlock)state.getBlock()).getWeatheringState());
            return golem;
        }
        return null;
    }

    protected void writeNbt(NbtCompound tag, RegistryWrapper.WrapperLookup registries) {
        super.writeNbt(tag, registries);
        if (this.customName != null) {
            tag.putString("CustomName", Text.Serialization.toJsonString((Text)this.customName, (RegistryWrapper.WrapperLookup)registries));
        }
    }

    protected void readNbt(NbtCompound tag, RegistryWrapper.WrapperLookup registries) {
        super.readNbt(tag, registries);
        if (tag.contains("CustomName")) {
            this.customName = Text.Serialization.fromJson((String)tag.getString("CustomName"), (RegistryWrapper.WrapperLookup)registries);
        }
    }

    public BlockEntityUpdateS2CPacket getUpdatePacket() {
        return BlockEntityUpdateS2CPacket.create((BlockEntity)this);
    }

    public NbtCompound toInitialChunkDataNbt(RegistryWrapper.WrapperLookup registries) {
        return this.createNbt(registries);
    }

    protected void readComponents(BlockEntity.ComponentsAccess componentInput) {
        super.readComponents(componentInput);
        this.customName = (Text)componentInput.get(DataComponentTypes.CUSTOM_NAME);
    }

    protected void addComponents(ComponentMap.Builder components) {
        super.addComponents(components);
        components.add(DataComponentTypes.CUSTOM_NAME, this.customName);
    }

    public void removeFromCopiedStackNbt(NbtCompound tag) {
        tag.remove("CustomName");
    }
}

