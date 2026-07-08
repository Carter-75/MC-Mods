/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.ai.brain.sensor.SensorType
 *  net.minecraft.entity.ai.brain.sensor.TemptationsSensor
 */
package backported.updates.content.common.registries;

import backported.updates.content.common.level.entities.happyghast.HappyGhast;
import backported.updates.content.common.level.entities.sensortypes.AdultSensorAnyType;
import backported.updates.foundation.core.helper.EntityRegistry;
import java.util.function.Predicate;
import java.util.function.Supplier;
import net.minecraft.entity.ai.brain.sensor.SensorType;
import net.minecraft.entity.ai.brain.sensor.TemptationsSensor;

public class ModSensorTypes {
    public static final EntityRegistry SENSOR_TYPES = EntityRegistry.create("backported_updates");
    public static final Supplier<SensorType<AdultSensorAnyType>> NEAREST_ADULT_ANY_TYPE = SENSOR_TYPES.sensor("nearest_adult_any_type", AdultSensorAnyType::new);
    public static final Supplier<SensorType<TemptationsSensor>> HAPPY_GHAST_TEMPTATIONS = SENSOR_TYPES.sensor("happy_ghast_temptations", () -> new TemptationsSensor(HappyGhast.IS_FOOD));
}

