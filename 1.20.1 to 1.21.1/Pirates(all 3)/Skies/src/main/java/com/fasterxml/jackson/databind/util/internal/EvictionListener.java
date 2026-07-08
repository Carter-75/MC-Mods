/*
 * Decompiled with CFR 0.152.
 */
package com.fasterxml.jackson.databind.util.internal;

interface EvictionListener<K, V> {
    public void onEviction(K var1, V var2);
}

