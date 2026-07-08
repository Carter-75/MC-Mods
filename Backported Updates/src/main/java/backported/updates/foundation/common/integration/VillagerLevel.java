/*
 * Decompiled with CFR 0.152.
 */
package backported.updates.foundation.common.integration;

public enum VillagerLevel {
    NOVICE(1),
    APPRENTICE(2),
    JOURNEYMAN(3),
    EXPERT(4),
    MASTER(5);

    private final int value;

    private VillagerLevel(int value) {
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }
}

