/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.EntityType
 *  net.minecraft.entity.SpawnRestriction
 *  net.minecraft.entity.SpawnRestriction$Entry
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.gen.Accessor
 */
package backported_updates.mixin.foundation.access;

import java.util.Map;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnRestriction;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(value={SpawnRestriction.class})
public interface SpawnPlacementsAccessor {
    @Accessor
    public static Map<EntityType<?>, SpawnRestriction.Entry> getRESTRICTIONS() {
        throw new UnsupportedOperationException();
    }
}

