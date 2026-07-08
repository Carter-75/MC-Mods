/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_3542
 */
package ace.actually.pirates.entities;

import net.minecraft.class_3542;

public enum CrewSpawnType implements class_3542
{
    PIRATE("pirate"),
    VILLAGER("villager"),
    SKELETON_PIRATE("skeleton_pirate"),
    CUSTOM_0("custom_0"),
    CUSTOM_1("custom_1"),
    CUSTOM_2("custom_2"),
    CUSTOM_3("custom_3");

    private final String name;

    private CrewSpawnType(String name) {
        this.name = name;
    }

    public String method_15434() {
        return this.name;
    }
}

