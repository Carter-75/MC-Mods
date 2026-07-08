/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.util.StringIdentifiable
 */
package backported.updates.content.common.level.blocks.blockstates;

import net.minecraft.util.StringIdentifiable;

public enum CreakingHeartState implements StringIdentifiable
{
    UPROOTED("uprooted"),
    DORMANT("dormant"),
    AWAKE("awake");

    private final String name;

    private CreakingHeartState(String name) {
        this.name = name;
    }

    public String toString() {
        return this.name;
    }

    public String asString() {
        return this.name;
    }
}

