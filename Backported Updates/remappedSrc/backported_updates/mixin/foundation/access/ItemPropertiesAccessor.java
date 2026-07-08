/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1800
 *  net.minecraft.class_2960
 *  net.minecraft.class_5272
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.gen.Accessor
 */
package backported_updates.mixin.foundation.access;

import java.util.Map;
import net.minecraft.class_1800;
import net.minecraft.class_2960;
import net.minecraft.class_5272;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(value={class_5272.class})
public interface ItemPropertiesAccessor {
    @Accessor
    public static Map<class_2960, class_1800> getGENERIC_PROPERTIES() {
        throw new UnsupportedOperationException();
    }
}

