/*
 * Decompiled with CFR 0.152.
 */
package com.fasterxml.jackson.core.util;

import java.util.concurrent.ConcurrentHashMap;

public final class InternCache
extends ConcurrentHashMap<String, String> {
    private static final long serialVersionUID = 1L;
    private static final int MAX_ENTRIES = 180;
    public static final InternCache instance = new InternCache();
    private final Object lock = new Object();

    private InternCache() {
        super(180, 0.8f, 4);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public String intern(String input) {
        String result2 = (String)this.get(input);
        if (result2 != null) {
            return result2;
        }
        if (this.size() >= 180) {
            Object object = this.lock;
            synchronized (object) {
                if (this.size() >= 180) {
                    this.clear();
                }
            }
        }
        result2 = input.intern();
        this.put(result2, result2);
        return result2;
    }
}

