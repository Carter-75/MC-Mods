/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.util.StringIdentifiable
 */
package backported.updates.copper.block.shelf;

import net.minecraft.util.StringIdentifiable;

public enum SideChainPart implements StringIdentifiable
{
    UNCONNECTED("unconnected"),
    RIGHT("right"),
    CENTER("center"),
    LEFT("left");

    private final String name;

    private SideChainPart(String name) {
        this.name = name;
    }

    public String toString() {
        return this.asString();
    }

    public String asString() {
        return this.name;
    }

    public boolean isConnected() {
        return this != UNCONNECTED;
    }

    public boolean isConnectionTowards(SideChainPart part) {
        return this == CENTER || this == part;
    }

    public boolean isChainEnd() {
        return this != CENTER;
    }

    public SideChainPart whenConnectedToTheRight() {
        return switch (this.ordinal()) {
            default -> throw new MatchException(null, null);
            case 0, 3 -> LEFT;
            case 1, 2 -> CENTER;
        };
    }

    public SideChainPart whenConnectedToTheLeft() {
        return switch (this.ordinal()) {
            default -> throw new MatchException(null, null);
            case 0, 1 -> RIGHT;
            case 2, 3 -> CENTER;
        };
    }

    public SideChainPart whenDisconnectedFromTheRight() {
        return switch (this.ordinal()) {
            default -> throw new MatchException(null, null);
            case 0, 3 -> UNCONNECTED;
            case 1, 2 -> RIGHT;
        };
    }

    public SideChainPart whenDisconnectedFromTheLeft() {
        return switch (this.ordinal()) {
            default -> throw new MatchException(null, null);
            case 0, 1 -> UNCONNECTED;
            case 2, 3 -> LEFT;
        };
    }
}

