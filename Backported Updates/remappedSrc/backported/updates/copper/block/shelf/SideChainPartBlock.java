/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1936
 *  net.minecraft.class_2338
 *  net.minecraft.class_2350
 *  net.minecraft.class_2680
 */
package backported.updates.copper.block.shelf;

import backported.updates.copper.block.shelf.SideChainPart;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.IntFunction;
import net.minecraft.class_1936;
import net.minecraft.class_2338;
import net.minecraft.class_2350;
import net.minecraft.class_2680;

public interface SideChainPartBlock {
    public SideChainPart getSideChainPart(class_2680 var1);

    public class_2680 setSideChainPart(class_2680 var1, SideChainPart var2);

    public class_2350 getFacing(class_2680 var1);

    public boolean isConnectable(class_2680 var1);

    public int getMaxChainLength();

    default public List<class_2338> getAllBlocksConnectedTo(class_1936 level, class_2338 pos) {
        class_2680 blockstate = level.method_8320(pos);
        if (!this.isConnectable(blockstate)) {
            return List.of();
        }
        Neighbors neighbors = this.getNeighbors(level, pos, this.getFacing(blockstate));
        LinkedList<class_2338> list = new LinkedList<class_2338>();
        list.add(pos);
        this.addBlocksConnectingTowards(neighbors::left, SideChainPart.LEFT, list::addFirst);
        this.addBlocksConnectingTowards(neighbors::right, SideChainPart.RIGHT, list::addLast);
        return list;
    }

    private void addBlocksConnectingTowards(IntFunction<Neighbor> neighborGetter, SideChainPart part, Consumer<class_2338> output) {
        for (int i = 1; i < this.getMaxChainLength(); ++i) {
            Neighbor neighbor = neighborGetter.apply(i);
            if (neighbor.connectsTowards(part)) {
                output.accept(neighbor.pos());
            }
            if (neighbor.isUnconnectableOrChainEnd()) break;
        }
    }

    default public void updateNeighborsAfterPoweringDown(class_1936 level, class_2338 pos, class_2680 state) {
        Neighbors neighbors = this.getNeighbors(level, pos, this.getFacing(state));
        neighbors.left().disconnectFromRight();
        neighbors.right().disconnectFromLeft();
    }

    default public void updateSelfAndNeighborsOnPoweringUp(class_1936 level, class_2338 pos, class_2680 state, class_2680 oldState) {
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

    private boolean isBeingUpdatedByNeighbor(class_2680 state, class_2680 oldState) {
        boolean flag = this.getSideChainPart(state).isConnected();
        boolean flag1 = this.isConnectable(oldState) && this.getSideChainPart(oldState).isConnected();
        return flag || flag1;
    }

    private Neighbors getNeighbors(class_1936 level, class_2338 pos, class_2350 facing) {
        return new Neighbors(this, level, facing, pos, new HashMap<class_2338, Neighbor>());
    }

    default public void setPart(class_1936 level, class_2338 pos, SideChainPart part) {
        class_2680 blockstate = level.method_8320(pos);
        if (this.getSideChainPart(blockstate) != part) {
            level.method_8652(pos, this.setSideChainPart(blockstate, part), 3);
        }
    }

    public record Neighbors(SideChainPartBlock block, class_1936 level, class_2350 facing, class_2338 center, Map<class_2338, Neighbor> cache) {
        private boolean isConnectableToThisBlock(class_2680 state) {
            return this.block.isConnectable(state) && this.block.getFacing(state) == this.facing;
        }

        private Neighbor createNewNeighbor(class_2338 pos) {
            class_2680 blockstate = this.level.method_8320(pos);
            SideChainPart sidechainpart = this.isConnectableToThisBlock(blockstate) ? this.block.getSideChainPart(blockstate) : null;
            return sidechainpart == null ? new EmptyNeighbor(pos) : new SideChainNeighbor(this.level, this.block, pos, sidechainpart);
        }

        private Neighbor getOrCreateNeighbor(class_2350 direction, Integer distance) {
            return this.cache.computeIfAbsent(this.center.method_10079(direction, distance.intValue()), this::createNewNeighbor);
        }

        public Neighbor left(int distance) {
            return this.getOrCreateNeighbor(this.facing.method_10170(), distance);
        }

        public Neighbor right(int distance) {
            return this.getOrCreateNeighbor(this.facing.method_10160(), distance);
        }

        public Neighbor left() {
            return this.left(1);
        }

        public Neighbor right() {
            return this.right(1);
        }
    }

    public static interface Neighbor {
        public class_2338 pos();

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

    public record SideChainNeighbor(class_1936 level, SideChainPartBlock block, class_2338 pos, SideChainPart part) implements Neighbor
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

    public record EmptyNeighbor(class_2338 pos) implements Neighbor
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

