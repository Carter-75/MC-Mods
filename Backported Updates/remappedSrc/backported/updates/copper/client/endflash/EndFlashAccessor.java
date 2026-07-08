/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_638
 *  org.jetbrains.annotations.Nullable
 */
package backported.updates.copper.client.endflash;

import backported.updates.copper.client.endflash.EndFlashState;
import net.minecraft.class_638;
import org.jetbrains.annotations.Nullable;

public interface EndFlashAccessor {
    @Nullable
    public EndFlashState copperagebackport$getEndFlashState();

    @Nullable
    public static EndFlashState get(class_638 level) {
        return ((EndFlashAccessor)level).copperagebackport$getEndFlashState();
    }
}

