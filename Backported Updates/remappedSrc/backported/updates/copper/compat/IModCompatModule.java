/*
 * Decompiled with CFR 0.152.
 */
package backported.updates.copper.compat;

public interface IModCompatModule {
    public String getModId();

    public void init();

    default public void initClient() {
    }
}

