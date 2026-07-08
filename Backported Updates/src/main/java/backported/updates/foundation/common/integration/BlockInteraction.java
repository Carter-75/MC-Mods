/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.util.ActionResult
 *  net.minecraft.item.ItemUsageContext
 */
package backported.updates.foundation.common.integration;

import net.minecraft.util.ActionResult;
import net.minecraft.item.ItemUsageContext;

public interface BlockInteraction {
    public ActionResult onUse(ItemUsageContext var1);
}

