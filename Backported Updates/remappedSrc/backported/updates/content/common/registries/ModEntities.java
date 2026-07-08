/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1297
 *  net.minecraft.class_1299
 *  net.minecraft.class_1299$class_1300
 *  net.minecraft.class_1311
 *  net.minecraft.class_243
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
import net.minecraft.class_1297;
import net.minecraft.class_1299;
import net.minecraft.class_1311;
import net.minecraft.class_243;

public class ModEntities {
    public static final EntityRegistry ENTITIES = EntityRegistry.create("minecraft");
    public static final Supplier<class_1299<Creaking>> CREAKING = ENTITIES.entity("creaking", class_1299.class_1300.method_5903(Creaking::new, (class_1311)class_1311.field_6302).method_17687(0.9f, 2.7f).method_55687(2.3f).method_27299(8));
    public static final Supplier<class_1299<HappyGhast>> HAPPY_GHAST = ENTITIES.entity("happy_ghast", class_1299.class_1300.method_5903(HappyGhast::new, (class_1311)class_1311.field_6294).method_17687(4.0f, 4.0f).method_55687(2.6f).method_55690(new class_243[]{new class_243(0.0, 4.0, 1.8), new class_243(-1.8, 4.0, 0.0), new class_243(0.0, 4.0, -1.8), new class_243(1.8, 4.0, 0.0)}).method_55691(0.5f).method_27299(10));
    public static final Supplier<class_1299<PaleOakBoat>> PALE_OAK_BOAT = ENTITIES.entity("pale_oak_boat", class_1299.class_1300.method_5903(PaleOakBoat::new, (class_1311)class_1311.field_17715).method_17687(1.375f, 0.5625f).method_27299(10));
    public static final Supplier<class_1299<PaleOakChestBoat>> PALE_OAK_CHEST_BOAT = ENTITIES.entity("pale_oak_chest_boat", class_1299.class_1300.method_5903(PaleOakChestBoat::new, (class_1311)class_1311.field_17715).method_17687(1.375f, 0.5625f).method_27299(10));

    private static <T extends class_1297> Optional<Supplier<class_1299<T>>> conditional(String name, class_1299.class_1300<T> builder, FeatureFlag flag) {
        if (flag.isEnabled()) {
            return Optional.of(ENTITIES.entity(name, builder));
        }
        return Optional.empty();
    }
}

