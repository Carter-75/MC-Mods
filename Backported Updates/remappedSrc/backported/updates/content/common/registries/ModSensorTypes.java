/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_4149
 *  net.minecraft.class_5760
 */
package backported.updates.content.common.registries;

import backported.updates.content.common.level.entities.happyghast.HappyGhast;
import backported.updates.content.common.level.entities.sensortypes.AdultSensorAnyType;
import backported.updates.foundation.core.helper.EntityRegistry;
import java.util.function.Predicate;
import java.util.function.Supplier;
import net.minecraft.class_4149;
import net.minecraft.class_5760;

public class ModSensorTypes {
    public static final EntityRegistry SENSOR_TYPES = EntityRegistry.create("minecraft");
    public static final Supplier<class_4149<AdultSensorAnyType>> NEAREST_ADULT_ANY_TYPE = SENSOR_TYPES.sensor("nearest_adult_any_type", AdultSensorAnyType::new);
    public static final Supplier<class_4149<class_5760>> HAPPY_GHAST_TEMPTATIONS = SENSOR_TYPES.sensor("happy_ghast_temptations", () -> new class_5760((Predicate)HappyGhast.IS_FOOD));
}

