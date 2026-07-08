/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.EntityType
 *  net.minecraft.entity.EntityType$Builder
 *  net.minecraft.entity.SpawnGroup
 *  net.minecraft.util.math.Vec3d
 */
package backported.updates.content.common.registries;

import backported.updates.content.common.level.boat.PaleOakBoat;
import backported.updates.content.common.level.boat.PaleOakChestBoat;
import backported.updates.content.common.level.entities.creaking.Creaking;
import backported.updates.content.common.level.entities.happyghast.HappyGhast;
import backported.updates.content.core.FeatureFlag;
import backported.updates.foundation.core.helper.EntityRegistry;
import java.util.Optional;
import java.util.function.Supplier;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.util.math.Vec3d;

public class ModEntities {
    public static final EntityRegistry ENTITIES = EntityRegistry.create("backported_updates");
    public static final Supplier<EntityType<Creaking>> CREAKING = ENTITIES.entity("creaking", EntityType.Builder.create(Creaking::new, (SpawnGroup)SpawnGroup.MONSTER).dimensions(0.9f, 2.7f).eyeHeight(2.3f).maxTrackingRange(8));
    public static final Supplier<EntityType<HappyGhast>> HAPPY_GHAST = ENTITIES.entity("happy_ghast", EntityType.Builder.create(HappyGhast::new, (SpawnGroup)SpawnGroup.CREATURE).dimensions(4.0f, 4.0f).eyeHeight(2.6f).passengerAttachments(new Vec3d(0.0, 4.0, 1.8), new Vec3d(-1.8, 4.0, 0.0), new Vec3d(0.0, 4.0, -1.8), new Vec3d(1.8, 4.0, 0.0)).vehicleAttachment(0.5f).maxTrackingRange(10));
    public static final Supplier<EntityType<PaleOakBoat>> PALE_OAK_BOAT = ENTITIES.entity("pale_oak_boat", EntityType.Builder.<PaleOakBoat>create(PaleOakBoat::new, (SpawnGroup)SpawnGroup.MISC).dimensions(1.375f, 0.5625f).maxTrackingRange(10));
    public static final Supplier<EntityType<PaleOakChestBoat>> PALE_OAK_CHEST_BOAT = ENTITIES.entity("pale_oak_chest_boat", EntityType.Builder.<PaleOakChestBoat>create(PaleOakChestBoat::new, (SpawnGroup)SpawnGroup.MISC).dimensions(1.375f, 0.5625f).maxTrackingRange(10));

    private static <T extends Entity> Optional<Supplier<EntityType<T>>> conditional(String name, EntityType.Builder<T> builder, FeatureFlag flag) {
        if (flag.isEnabled()) {
            return Optional.of(ENTITIES.entity(name, builder));
        }
        return Optional.empty();
    }
}

