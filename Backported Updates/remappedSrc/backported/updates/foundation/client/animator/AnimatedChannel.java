/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.fabricmc.api.EnvType
 *  net.fabricmc.api.Environment
 */
package backported.updates.foundation.client.animator;

import backported.updates.foundation.client.animator.AnimatedPoint;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;

@Environment(value=EnvType.CLIENT)
public record AnimatedChannel(AnimatedPoint[] targets) {
}

