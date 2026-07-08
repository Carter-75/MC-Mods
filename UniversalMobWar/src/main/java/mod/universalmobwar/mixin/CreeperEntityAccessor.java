package mod.universalmobwar.mixin;

import net.minecraft.world.entity.monster.Creeper;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

/**
 * Accesses Creeper explosion radius so scaling abilities can adjust it on demand.
 */
@Mixin(Creeper.class)
public interface CreeperEntityAccessor {
    @Accessor("explosionRadius")
    int universalmobwar$getExplosionRadius();

    @Accessor("explosionRadius")
    void universalmobwar$setExplosionRadius(int radius);
}
