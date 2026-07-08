/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.state.property.BooleanProperty
 *  net.minecraft.state.property.EnumProperty
 *  net.minecraft.state.property.IntProperty
 */
package backported.updates.content.common.registries;

import backported.updates.content.common.level.blocks.blockstates.CreakingHeartState;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.EnumProperty;
import net.minecraft.state.property.IntProperty;

public class ModBlockStateProperties {
    public static final BooleanProperty TIP = BooleanProperty.of((String)"tip");
    public static final BooleanProperty NATURAL = BooleanProperty.of((String)"natural");
    public static final EnumProperty<CreakingHeartState> CREAKING_HEART_STATE = EnumProperty.of((String)"creaking_heart_state", CreakingHeartState.class);
    public static final IntProperty HYDRATION_LEVEL = IntProperty.of((String)"hydration", (int)0, (int)3);
}

