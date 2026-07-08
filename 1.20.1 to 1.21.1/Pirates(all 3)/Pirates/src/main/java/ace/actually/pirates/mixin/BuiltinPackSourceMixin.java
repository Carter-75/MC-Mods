/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1065
 *  net.minecraft.class_2561
 *  net.minecraft.class_3259
 *  net.minecraft.class_3264
 *  net.minecraft.class_3288
 *  net.minecraft.class_3288$class_3289
 *  net.minecraft.class_5352
 *  net.minecraft.class_7678
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfo
 */
package ace.actually.pirates.mixin;

import ace.actually.pirates.util.BuiltinResourcePackSource;
import java.nio.file.Path;
import java.util.function.Consumer;
import net.minecraft.class_1065;
import net.minecraft.class_2561;
import net.minecraft.class_3259;
import net.minecraft.class_3264;
import net.minecraft.class_3288;
import net.minecraft.class_5352;
import net.minecraft.class_7678;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value={class_7678.class})
public class BuiltinPackSourceMixin {
    @Inject(method={"loadPacks"}, at={@At(value="RETURN")})
    private void addBuiltinResourcePacks(Consumer<class_3288> consumer, CallbackInfo ci) {
        if (this instanceof class_1065) {
            class_3288.method_45275((String)"eureka_ships", (class_2561)class_2561.method_43470((String)"Eureka Ships"), (boolean)false, a -> new class_3259("eureka_ships", Path.of("pirates/datapacks/eureka_ships/", new String[0]), true), (class_3264)class_3264.field_14190, (class_3288.class_3289)class_3288.class_3289.field_14280, (class_5352)new BuiltinResourcePackSource());
        }
    }
}

