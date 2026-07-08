/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1297
 *  net.minecraft.class_1309
 *  net.minecraft.class_243
 *  net.minecraft.class_2596
 *  net.minecraft.class_2684$class_2685
 *  net.minecraft.class_2684$class_2686
 *  net.minecraft.class_2684$class_2687
 *  net.minecraft.class_2726
 *  net.minecraft.class_2743
 *  net.minecraft.class_2752
 *  net.minecraft.class_2777
 *  net.minecraft.class_3222
 *  net.minecraft.class_3231
 *  net.minecraft.class_3532
 *  net.minecraft.class_7422
 *  org.spongepowered.asm.mixin.Final
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.Shadow
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfo
 */
package backported_updates.mixin.common.entities;

import backported.updates.content.common.level.entities.happyghast.HappyGhast;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Stream;
import net.minecraft.class_1297;
import net.minecraft.class_1309;
import net.minecraft.class_243;
import net.minecraft.class_2596;
import net.minecraft.class_2684;
import net.minecraft.class_2726;
import net.minecraft.class_2743;
import net.minecraft.class_2752;
import net.minecraft.class_2777;
import net.minecraft.class_3222;
import net.minecraft.class_3231;
import net.minecraft.class_3532;
import net.minecraft.class_7422;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value={class_3231.class})
public abstract class ServerEntityMixin {
    @Shadow
    private int field_14040;
    @Shadow
    private int field_14047;
    @Shadow
    private int field_14060;
    @Shadow
    private int field_14043;
    @Shadow
    private boolean field_14051;
    @Shadow
    private boolean field_14036;
    @Shadow
    @Final
    private class_1297 field_14049;
    @Shadow
    private int field_14059;
    @Shadow
    private class_243 field_18278;
    @Shadow
    @Final
    private int field_14037;
    @Shadow
    @Final
    private boolean field_14039;
    @Shadow
    private List<class_1297> field_14045;
    @Shadow
    @Final
    private class_7422 field_39019;
    @Shadow
    @Final
    private Consumer<class_2596<?>> field_18259;

    @Shadow
    protected abstract void method_14306();

    @Shadow
    protected abstract void method_18758(class_2596<?> var1);

    @Shadow
    private static Stream<class_1297> method_49753(List<class_1297> initialPassengers, List<class_1297> currentPassengers) {
        throw new AssertionError();
    }

    @Inject(method={"sendChanges"}, at={@At(value="HEAD")}, cancellable=true)
    private void onSendChanges(CallbackInfo ci) {
        class_1297 class_12972 = this.field_14049;
        if (class_12972 instanceof HappyGhast) {
            HappyGhast ghast = (HappyGhast)class_12972;
            List passengers = this.field_14049.method_5685();
            if (!passengers.equals(this.field_14045)) {
                this.field_18259.accept((class_2596<?>)new class_2752(this.field_14049));
                ServerEntityMixin.method_49753(passengers, this.field_14045).forEach(entity -> {
                    if (entity instanceof class_3222) {
                        class_3222 player = (class_3222)entity;
                        player.field_13987.method_14363(player.method_23317(), player.method_23318(), player.method_23321(), player.method_36454(), player.method_36455());
                    }
                });
                this.field_14045 = passengers;
            }
            if (this.field_14040 % this.field_14037 == 0 || this.field_14049.field_6007 || this.field_14049.method_5841().method_12786()) {
                byte yHeadRot;
                boolean shouldSendRotation;
                byte yRot = (byte)class_3532.method_15375((float)(this.field_14049.method_36454() * 256.0f / 360.0f));
                byte xRot = (byte)class_3532.method_15375((float)(this.field_14049.method_36455() * 256.0f / 360.0f));
                boolean bl = shouldSendRotation = Math.abs(yRot - this.field_14060) >= 1 || Math.abs(xRot - this.field_14047) >= 1;
                if (!this.field_14049.method_5765()) {
                    class_243 movement;
                    double diff;
                    class_1309 living;
                    class_1297 class_12973;
                    boolean deltaTooBig;
                    ++this.field_14043;
                    class_243 currentPosition = this.field_14049.method_43390();
                    boolean positionChanged = this.field_39019.method_43493(currentPosition).method_1027() >= 7.62939453125E-6;
                    class_2777 packet = null;
                    boolean pos = positionChanged || this.field_14040 % 60 == 0;
                    boolean sendPosition = false;
                    boolean sendRotation = false;
                    long x = this.field_39019.method_43490(currentPosition);
                    long y = this.field_39019.method_43491(currentPosition);
                    long z = this.field_39019.method_43492(currentPosition);
                    boolean bl2 = deltaTooBig = x < -32768L || x > 32767L || y < -32768L || y > 32767L || z < -32768L || z > 32767L;
                    if (ghast.getRequiresPrecisePosition() || deltaTooBig || this.field_14043 > 400 || this.field_14051 || this.field_14036 != this.field_14049.method_24828()) {
                        this.field_14036 = this.field_14049.method_24828();
                        this.field_14043 = 0;
                        packet = new class_2777(this.field_14049);
                        sendPosition = true;
                        sendRotation = true;
                    } else if (!pos || !shouldSendRotation) {
                        if (pos) {
                            packet = new class_2684.class_2685(this.field_14049.method_5628(), (short)x, (short)y, (short)z, this.field_14049.method_24828());
                            sendPosition = true;
                        } else if (shouldSendRotation) {
                            packet = new class_2684.class_2687(this.field_14049.method_5628(), yRot, xRot, this.field_14049.method_24828());
                            sendRotation = true;
                        }
                    } else {
                        packet = new class_2684.class_2686(this.field_14049.method_5628(), (short)x, (short)y, (short)z, yRot, xRot, this.field_14049.method_24828());
                        sendPosition = true;
                        sendRotation = true;
                    }
                    if ((this.field_14039 || this.field_14049.field_6007 || (class_12973 = this.field_14049) instanceof class_1309 && (living = (class_1309)class_12973).method_6128()) && ((diff = (movement = this.field_14049.method_18798()).method_1025(this.field_18278)) > 1.0E-7 || diff > 0.0 && movement.method_1027() == 0.0)) {
                        this.field_18278 = movement;
                        this.field_18259.accept((class_2596<?>)new class_2743(this.field_14049.method_5628(), this.field_18278));
                    }
                    if (packet != null) {
                        this.field_18259.accept((class_2596<?>)packet);
                    }
                    this.method_14306();
                    if (sendPosition) {
                        this.field_39019.method_43494(currentPosition);
                    }
                    if (sendRotation) {
                        this.field_14060 = yRot;
                        this.field_14047 = xRot;
                    }
                    this.field_14051 = false;
                }
                if (Math.abs((yHeadRot = (byte)class_3532.method_15375((float)(this.field_14049.method_5791() * 256.0f / 360.0f))) - this.field_14059) >= 1) {
                    this.field_18259.accept((class_2596<?>)new class_2726(this.field_14049, yHeadRot));
                    this.field_14059 = yHeadRot;
                }
                this.field_14049.field_6007 = false;
            }
            ++this.field_14040;
            if (this.field_14049.field_6037) {
                this.field_14049.field_6037 = false;
                this.method_18758((class_2596<?>)new class_2743(this.field_14049));
            }
            ci.cancel();
        }
    }
}

