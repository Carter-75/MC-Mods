/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.dN
 */
public enum dn_1 {
    SKIP("SkipWalk", "Skip only the walk method, but continue invoking the other listeners"),
    ABORT("Abort", "Aborts all the walk listeners and walk method itself"),
    CONTINUE("ContinueToWalk", "continue to invoke the walk method and other listeners");

    private String name;
    private String description;

    private dn_1(String string2, String string3) {
        this.name = string2;
        this.description = string3;
    }

    public final String a() {
        return this.name;
    }

    public final String b() {
        return this.description;
    }
}

