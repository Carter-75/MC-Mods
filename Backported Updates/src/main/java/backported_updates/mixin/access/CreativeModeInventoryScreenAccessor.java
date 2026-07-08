/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.item.ItemGroup
 *  net.minecraft.client.gui.screen.ingame.CreativeInventoryScreen
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.gen.Accessor
 */
package backported_updates.mixin.access;

import net.minecraft.item.ItemGroup;
import net.minecraft.client.gui.screen.ingame.CreativeInventoryScreen;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(value={CreativeInventoryScreen.class})
public interface CreativeModeInventoryScreenAccessor {
    @Accessor
    public static ItemGroup getSelectedTab() {
        throw new UnsupportedOperationException();
    }
}

