/*
 * Decompiled with CFR 0.152.
 */
package net._void.civilizations.entity.custom;

import java.util.Arrays;
import java.util.Comparator;

public enum GreeceCivilianVariant {
    CIVILIAN1(1),
    CIVILIAN2(2),
    CIVILIAN3(3),
    CIVILIAN4(4),
    CIVILIAN5(5),
    CIVILIAN6(6),
    CIVILIAN7(7),
    CIVILIAN8(8);

    private static final GreeceCivilianVariant[] BY_ID;
    private final int id;

    private GreeceCivilianVariant(int id) {
        this.id = id;
    }

    public int getId() {
        return this.id;
    }

    public static GreeceCivilianVariant byId(int id) {
        return BY_ID[id % BY_ID.length];
    }

    static {
        BY_ID = (GreeceCivilianVariant[])Arrays.stream(GreeceCivilianVariant.values()).sorted(Comparator.comparingInt(GreeceCivilianVariant::getId)).toArray(GreeceCivilianVariant[]::new);
    }
}

