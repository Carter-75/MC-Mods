/*
 * Decompiled with CFR 0.152.
 */
package net._void.civilizations.entity.custom;

import java.util.Arrays;
import java.util.Comparator;

public enum RomeGuardVariant {
    CIVILIAN1(1),
    CIVILIAN2(2);

    private static final RomeGuardVariant[] BY_ID;
    private final int id;

    private RomeGuardVariant(int id) {
        this.id = id;
    }

    public int getId() {
        return this.id;
    }

    public static RomeGuardVariant byId(int id) {
        return BY_ID[id % BY_ID.length];
    }

    static {
        BY_ID = (RomeGuardVariant[])Arrays.stream(RomeGuardVariant.values()).sorted(Comparator.comparingInt(RomeGuardVariant::getId)).toArray(RomeGuardVariant[]::new);
    }
}

