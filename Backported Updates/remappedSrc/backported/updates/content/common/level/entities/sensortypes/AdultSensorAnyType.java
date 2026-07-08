/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.common.collect.ImmutableSet
 *  net.minecraft.class_1296
 *  net.minecraft.class_3218
 *  net.minecraft.class_4140
 *  net.minecraft.class_4148
 *  net.minecraft.class_6670
 */
package backported.updates.content.common.level.entities.sensortypes;

import backported.updates.content.core.data.tags.ModEntityTypeTags;
import com.google.common.collect.ImmutableSet;
import java.util.Optional;
import java.util.Set;
import net.minecraft.class_1296;
import net.minecraft.class_3218;
import net.minecraft.class_4140;
import net.minecraft.class_4148;
import net.minecraft.class_6670;

public class AdultSensorAnyType
extends class_4148<class_1296> {
    public Set<class_4140<?>> method_19099() {
        return ImmutableSet.of((Object)class_4140.field_25359, (Object)class_4140.field_18442);
    }

    protected void doTick(class_3218 level, class_1296 entity) {
        entity.method_18868().method_18904(class_4140.field_18442).ifPresent(entities -> this.setNearestVisibleAdult(entity, (class_6670)entities));
    }

    private void setNearestVisibleAdult(class_1296 mob, class_6670 entities) {
        Optional<class_1296> adult = entities.method_38975(entity -> entity.method_5864().method_20210(ModEntityTypeTags.FOLLOWABLE_FRIENDLY_MOBS) && !entity.method_6109()).map(class_1296.class::cast);
        mob.method_18868().method_18879(class_4140.field_25359, adult);
    }
}

