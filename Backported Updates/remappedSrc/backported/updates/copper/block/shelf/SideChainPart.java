/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_3542
 */
package backported.updates.copper.block.shelf;

import net.minecraft.class_3542;

public enum SideChainPart implements class_3542
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
        return this.method_15434();
    }

    public String method_15434() {
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

