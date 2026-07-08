/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1113
 *  net.minecraft.class_1140
 *  net.minecraft.class_4235$class_4236
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.gen.Accessor
 *  org.spongepowered.asm.mixin.gen.Invoker
 */
package backported_updates.mixin.access;

import java.util.Map;
import net.minecraft.class_1113;
import net.minecraft.class_1140;
import net.minecraft.class_4235;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;
import org.spongepowered.asm.mixin.gen.Invoker;

@Mixin(value={class_1140.class})
public interface SoundEngineAccessor {
    @Accessor
    public Map<class_1113, class_4235.class_4236> getInstanceToChannel();

    @Accessor
    public boolean isLoaded();

    @Invoker
    public float callCalculateVolume(class_1113 var1);
}

