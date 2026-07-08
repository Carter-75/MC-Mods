/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_339
 *  net.minecraft.class_364
 *  net.minecraft.class_4068
 *  net.minecraft.class_437
 *  net.minecraft.class_6379
 */
package backported.updates.foundation.client.event.screen.api;

import java.util.List;
import net.minecraft.class_339;
import net.minecraft.class_364;
import net.minecraft.class_4068;
import net.minecraft.class_437;
import net.minecraft.class_6379;

public interface ScreenAccess {
    public class_437 screen();

    public List<class_6379> narratables();

    public List<class_4068> renderables();

    public <T extends class_339 & class_6379> T addRenderableWidget(T var1);

    public <T extends class_4068> T addRenderableOnly(T var1);

    public <T extends class_364 & class_6379> T addWidget(T var1);
}

