/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.fabricmc.api.ModInitializer
 */
package backported.updates.content.core.fabric;

import backported.updates.content.core.VanillaBackport;
import net.fabricmc.api.ModInitializer;

public final class VanillaBackportFabric
implements ModInitializer {
    public void onInitialize() {
        VanillaBackport.bootstrap();
    }
}

