/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1299
 *  net.minecraft.class_1317
 *  net.minecraft.class_1317$class_1318
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.gen.Accessor
 */
package backported_updates.mixin.foundation.access;

import java.util.Map;
import net.minecraft.class_1299;
import net.minecraft.class_1317;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(value={class_1317.class})
public interface SpawnPlacementsAccessor {
    @Accessor
    public static Map<class_1299<?>, class_1317.class_1318> getDATA_BY_TYPE() {
        throw new UnsupportedOperationException();
    }
}

