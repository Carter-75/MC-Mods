/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_364
 *  net.minecraft.class_4068
 *  net.minecraft.class_437
 *  net.minecraft.class_6379
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.gen.Accessor
 *  org.spongepowered.asm.mixin.gen.Invoker
 */
package backported_updates.mixin.foundation.access;

import java.util.List;
import net.minecraft.class_364;
import net.minecraft.class_4068;
import net.minecraft.class_437;
import net.minecraft.class_6379;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;
import org.spongepowered.asm.mixin.gen.Invoker;

@Mixin(value={class_437.class})
public interface ScreenAccessor {
    @Accessor
    public List<class_6379> getNarratables();

    @Accessor
    public List<class_4068> getRenderables();

    @Invoker
    public <T extends class_364 & class_4068> T callAddRenderableWidget(T var1);

    @Invoker
    public <T extends class_4068> T callAddRenderableOnly(T var1);

    @Invoker
    public <T extends class_364 & class_6379> T callAddWidget(T var1);
}

