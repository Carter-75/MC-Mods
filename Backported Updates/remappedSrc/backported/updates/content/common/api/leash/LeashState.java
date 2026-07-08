/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.fabricmc.api.EnvType
 *  net.fabricmc.api.Environment
 *  net.minecraft.class_243
 */
package backported.updates.content.common.api.leash;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.class_243;

@Environment(value=EnvType.CLIENT)
public class LeashState {
    public class_243 offset = class_243.field_1353;
    public class_243 start = class_243.field_1353;
    public class_243 end = class_243.field_1353;
    public int startBlockLight = 0;
    public int endBlockLight = 0;
    public int startSkyLight = 15;
    public int endSkyLight = 15;
    public boolean slack = true;
}

