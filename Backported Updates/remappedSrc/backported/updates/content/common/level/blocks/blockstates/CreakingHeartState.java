/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_3542
 */
package backported.updates.content.common.level.blocks.blockstates;

import net.minecraft.class_3542;

public enum CreakingHeartState implements class_3542
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

    public String method_15434() {
        return this.name;
    }
}

