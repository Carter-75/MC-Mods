/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.fabricmc.api.ModInitializer
 */
package ace.actually.pirates;

import ace.actually.pirates.Pirates;
import net.fabricmc.api.ModInitializer;

public class PiratesFabric
implements ModInitializer {
    public void onInitialize() {
        Pirates.init();
    }
}

