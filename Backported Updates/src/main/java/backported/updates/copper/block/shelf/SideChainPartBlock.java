/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.world.WorldAccess
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.util.math.Direction
 *  net.minecraft.block.BlockState
 */
package backported.updates.copper.block.shelf;

import backported.updates.copper.block.shelf.SideChainPart;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.IntFunction;
import net.minecraft.world.WorldAccess;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.block.BlockState;

public interface SideChainPartBlock {
    public SideChainPart getSideChainPart(BlockState var1);

    public BlockState setSideChainPart(BlockState var1, SideChainPart var2);

    public Direction getFacing(BlockState var1);

    public boolean isConnectable(BlockState var1);

    public int getMaxChainLength();

    default public List<BlockPos> getAllBlocksConnectedTo(WorldAccess level, BlockPos pos) {
        BlockState blockstate = level.getBlockState(pos);
        if (!this.isConnectable(blockstate)) {
            return List.of();
        }
        Neighbors neighbors = this.getNeighbors(level, pos, this.getFacing(blockstate));
        LinkedList<BlockPos> list = new LinkedList<BlockPos>();
        list.add(pos);
        this.addBlocksConnectingTowards(neighbors::left, SideChainPart.LEFT, list::addFirst);
        this.addBlocksConnectingTowards(neighbors::right, SideChainPart.RIGHT, list::addLast);
        return list;
    }

    private void addBlocksConnectingTowards(IntFunction<Neighbor> neighborGetter, SideChainPart part, Consumer<BlockPos> output) {
        for (int i = 1; i < this.getMaxChainLength(); ++i) {
            Neighbor neighbor = neighborGetter.apply(i);
            if (neighbor.connectsTowards(part)) {
                output.accept(neighbor.pos());
            }
            if (neighbor.isUnconnectableOrChainEnd()) break;
        }
    }

    default public void updateNeighborsAfterPoweringDown(WorldAccess level, BlockPos pos, BlockState state) {
        Neighbors neighbors = this.getNeighbors(level, pos, this.getFacing(state));
        neighbors.left().disconnectFromRight();
        neighbors.right().disconnectFromLeft();
    }

    default public void updateSelfAndNeighborsOnPoweringUp(WorldAccess level, BlockPos pos, BlockState state, BlockState oldState) {
        if (this.isConnectable(state) && !this.isBeingUpdatedByNeighbor(state, oldState)) {
            Neighbors neighbors = this.getNeighbors(level, pos, this.getFacing(state));
            SideChainPart sidechainpart = SideChainPart.UNCONNECTED;
            int leftCount = neighbors.left().isConnectable() ? this.getAllBlocksConnectedTo(level, neighbors.left().pos()).size() : 0;
            int rightCount = neighbors.right().isConnectable() ? this.getAllBlocksConnectedTo(level, neighbors.right().pos()).size() : 0;
            int currentChainLength = 1;
            if (this.canConnect(leftCount, currentChainLength)) {
                sidechainpart = sidechainpart.whenConnectedToTheLeft();
                neighbors.left().connectToTheRight();
                currentChainLength += leftCount;
            }
            if (this.canConnect(rightCount, currentChainLength)) {
                sidechainpart = sidechainpart.whenConnectedToTheRight();
                neighbors.right().connectToTheLeft();
            }
            this.setPart(level, pos, sidechainpart);
        }
    }

    private boolean canConnect(int segmentLength, int currentChainLength) {
        return segmentLength > 0 && currentChainLength + segmentLength <= this.getMaxChainLength();
    }

    private boolean isBeingUpdatedByNeighbor(BlockState state, BlockState oldState) {
        boolean flag = this.getSideChainPart(state).isConnected();
        boolean flag1 = this.isConnectable(oldState) && this.getSideChainPart(oldState).isConnected();
        return flag || flag1;
    }

    private Neighbors getNeighbors(WorldAccess level, BlockPos pos, Direction facing) {
        return new Neighbors(this, level, facing, pos, new HashMap<BlockPos, Neighbor>());
    }

    default public void setPart(WorldAccess level, BlockPos pos, SideChainPart part) {
        BlockState blockstate = level.getBlockState(pos);
        if (this.getSideChainPart(blockstate) != part) {
            level.setBlockState(pos, this.setSideChainPart(blockstate, part), 3);
        }
    }

    public record Neighbors(SideChainPartBlock block, WorldAccess level, Direction facing, BlockPos center, Map<BlockPos, Neighbor> cache) {
        private boolean isConnectableToThisBlock(BlockState state) {
            return this.block.isConnectable(state) && this.block.getFacing(state) == this.facing;
        }

        private Neighbor createNewNeighbor(BlockPos pos) {
            BlockState blockstate = this.level.getBlockState(pos);
            SideChainPart sidechainpart = this.isConnectableToThisBlock(blockstate) ? this.block.getSideChainPart(blockstate) : null;
            return sidechainpart == null ? new EmptyNeighbor(pos) : new SideChainNeighbor(this.level, this.block, pos, sidechainpart);
        }

        private Neighbor getOrCreateNeighbor(Direction direction, Integer distance) {
            return this.cache.computeIfAbsent(this.center.offset(direction, distance.intValue()), this::createNewNeighbor);
        }

        public Neighbor left(int distance) {
            return this.getOrCreateNeighbor(this.facing.rotateYClockwise(), distance);
        }

        public Neighbor right(int distance) {
            return this.getOrCreateNeighbor(this.facing.rotateYCounterclockwise(), distance);
        }

        public Neighbor left() {
            return this.left(1);
        }

        public Neighbor right() {
            return this.right(1);
        }
    }

    public static interface Neighbor {
        public BlockPos pos();

        public boolean isConnectable();

        public boolean isUnconnectableOrChainEnd();

        public boolean connectsTowards(SideChainPart var1);

        default public void connectToTheRight() {
        }

        default public void connectToTheLeft() {
        }

        default public void disconnectFromRight() {
        }

        default public void disconnectFromLeft() {
        }
    }

    public record SideChainNeighbor(WorldAccess level, SideChainPartBlock block, BlockPos pos, SideChainPart part) implements Neighbor
    {
        @Override
        public boolean isConnectable() {
            return true;
        }

        @Override
        public boolean isUnconnectableOrChainEnd() {
            return this.part.isChainEnd();
        }

        @Override
        public boolean connectsTowards(SideChainPart targetPart) {
            return this.part.isConnectionTowards(targetPart);
        }

        @Override
        public void connectToTheRight() {
            this.block.setPart(this.level, this.pos, this.part.whenConnectedToTheRight());
        }

        @Override
        public void connectToTheLeft() {
            this.block.setPart(this.level, this.pos, this.part.whenConnectedToTheLeft());
        }

        @Override
        public void disconnectFromRight() {
            this.block.setPart(this.level, this.pos, this.part.whenDisconnectedFromTheRight());
        }

        @Override
        public void disconnectFromLeft() {
            this.block.setPart(this.level, this.pos, this.part.whenDisconnectedFromTheLeft());
        }
    }

    public record EmptyNeighbor(BlockPos pos) implements Neighbor
    {
        @Override
        public boolean isConnectable() {
            return false;
        }

        @Override
        public boolean isUnconnectableOrChainEnd() {
            return true;
        }

        @Override
        public boolean connectsTowards(SideChainPart part) {
            return false;
        }
    }
}

