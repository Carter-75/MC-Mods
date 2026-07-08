/*
 * Decompiled with CFR 0.152.
 */
package backported.updates.copper.platform.services;

public interface IPlatformHelper {
    public String getPlatformName();

    public boolean isModLoaded(String var1);

    public boolean isDevelopmentEnvironment();

    default public String getEnvironmentName() {
        return this.isDevelopmentEnvironment() ? "development" : "production";
    }

    default public boolean isFastChestSimplifiedEnabled() {
        return false;
    }
}

