/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import java.util.Random;

public final class DB {
    private static final ThreadLocal<Random> a = new ThreadLocal<Random>(){

        private static Random a() {
            return new Random();
        }

        @Override
        protected final /* synthetic */ Object initialValue() {
            return new Random();
        }
    };
    private final int b;

    public DB() {
        this.b = a.get().nextInt();
    }

    private DB(Random random) {
        this.b = random.nextInt();
    }

    public final int hashCode() {
        return this.b;
    }
}

