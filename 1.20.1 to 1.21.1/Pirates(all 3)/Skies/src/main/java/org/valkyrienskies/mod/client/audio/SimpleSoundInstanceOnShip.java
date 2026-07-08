/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.class_1109
 *  net.minecraft.class_1113$class_1114
 *  net.minecraft.class_2960
 *  net.minecraft.class_3414
 *  net.minecraft.class_3419
 *  net.minecraft.class_5819
 */
package org.valkyrienskies.mod.client.audio;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.class_1109;
import net.minecraft.class_1113;
import net.minecraft.class_2960;
import net.minecraft.class_3414;
import net.minecraft.class_3419;
import net.minecraft.class_5819;
import org.jetbrains.annotations.NotNull;
import org.joml.Vector3d;
import org.joml.Vector3dc;
import org.valkyrienskies.core.api.ships.Ship;
import org.valkyrienskies.mod.client.audio.VelocityTickableSoundInstance;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002Bq\b\u0016\u0012\u0006\u0010\u0016\u001a\u00020\u0015\u0012\u0006\u0010\u0018\u001a\u00020\u0017\u0012\u0006\u0010\u001a\u001a\u00020\u0019\u0012\u0006\u0010\u001b\u001a\u00020\u0019\u0012\u0006\u0010\u001d\u001a\u00020\u001c\u0012\u0006\u0010\u001e\u001a\u00020\u0003\u0012\u0006\u0010 \u001a\u00020\u001f\u0012\u0006\u0010\"\u001a\u00020!\u0012\u0006\u0010$\u001a\u00020#\u0012\u0006\u0010%\u001a\u00020#\u0012\u0006\u0010&\u001a\u00020#\u0012\u0006\u0010'\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\t\u00a2\u0006\u0004\b(\u0010)Bi\b\u0016\u0012\u0006\u0010+\u001a\u00020*\u0012\u0006\u0010\u0018\u001a\u00020\u0017\u0012\u0006\u0010\u001a\u001a\u00020\u0019\u0012\u0006\u0010\u001b\u001a\u00020\u0019\u0012\u0006\u0010\u001d\u001a\u00020\u001c\u0012\u0006\u0010\u001e\u001a\u00020\u0003\u0012\u0006\u0010 \u001a\u00020\u001f\u0012\u0006\u0010\"\u001a\u00020!\u0012\u0006\u0010$\u001a\u00020#\u0012\u0006\u0010%\u001a\u00020#\u0012\u0006\u0010&\u001a\u00020#\u0012\u0006\u0010\n\u001a\u00020\t\u00a2\u0006\u0004\b(\u0010,BQ\b\u0016\u0012\u0006\u0010+\u001a\u00020*\u0012\u0006\u0010\u0018\u001a\u00020\u0017\u0012\u0006\u0010\u001a\u001a\u00020\u0019\u0012\u0006\u0010\u001b\u001a\u00020\u0019\u0012\u0006\u0010\u001d\u001a\u00020\u001c\u0012\u0006\u0010$\u001a\u00020#\u0012\u0006\u0010%\u001a\u00020#\u0012\u0006\u0010&\u001a\u00020#\u0012\u0006\u0010\n\u001a\u00020\t\u00a2\u0006\u0004\b(\u0010-J\u000f\u0010\u0004\u001a\u00020\u0003H\u0016\u00a2\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H\u0016\u00a2\u0006\u0004\b\u0007\u0010\bR\u0014\u0010\n\u001a\u00020\t8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0014\u0010\r\u001a\u00020\f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000eR$\u0010\u0011\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000f8\u0016@RX\u0096\u000e\u00a2\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\u00a8\u0006."}, d2={"Lorg/valkyrienskies/mod/client/audio/SimpleSoundInstanceOnShip;", "Lnet/minecraft/class_1109;", "Lorg/valkyrienskies/mod/client/audio/VelocityTickableSoundInstance;", "", "isStopped", "()Z", "", "tick", "()V", "Lorg/valkyrienskies/core/api/ships/Ship;", "ship", "Lorg/valkyrienskies/core/api/ships/Ship;", "Lorg/joml/Vector3d;", "originalPos", "Lorg/joml/Vector3d;", "Lorg/joml/Vector3dc;", "value", "velocity", "Lorg/joml/Vector3dc;", "getVelocity", "()Lorg/joml/Vector3dc;", "Lnet/minecraft/class_2960;", "resourceLocation", "Lnet/minecraft/class_3419;", "soundSource", "", "volume", "pitch", "Lnet/minecraft/class_5819;", "random", "looping", "", "delay", "Lnet/minecraft/class_1113$class_1114;", "attenuation", "", "x", "y", "z", "relative", "<init>", "(Lnet/minecraft/class_2960;Lnet/minecraft/class_3419;FFLnet/minecraft/class_5819;ZILnet/minecraft/class_1113$class_1114;DDDZLorg/valkyrienskies/core/api/ships/Ship;)V", "Lnet/minecraft/class_3414;", "soundEvent", "(Lnet/minecraft/class_3414;Lnet/minecraft/class_3419;FFLnet/minecraft/class_5819;ZILnet/minecraft/class_1113$class_1114;DDDLorg/valkyrienskies/core/api/ships/Ship;)V", "(Lnet/minecraft/class_3414;Lnet/minecraft/class_3419;FFLnet/minecraft/class_5819;DDDLorg/valkyrienskies/core/api/ships/Ship;)V", "valkyrienskies-120"})
public final class SimpleSoundInstanceOnShip
extends class_1109
implements VelocityTickableSoundInstance {
    @NotNull
    private final Ship ship;
    @NotNull
    private final Vector3d originalPos;
    @NotNull
    private Vector3dc velocity;

    public SimpleSoundInstanceOnShip(@NotNull class_2960 resourceLocation, @NotNull class_3419 soundSource, float volume, float pitch, @NotNull class_5819 random, boolean looping, int delay, @NotNull class_1113.class_1114 attenuation, double x, double y, double z, boolean relative, @NotNull Ship ship) {
        Intrinsics.checkNotNullParameter((Object)resourceLocation, (String)"resourceLocation");
        Intrinsics.checkNotNullParameter((Object)soundSource, (String)"soundSource");
        Intrinsics.checkNotNullParameter((Object)random, (String)"random");
        Intrinsics.checkNotNullParameter((Object)attenuation, (String)"attenuation");
        Intrinsics.checkNotNullParameter((Object)ship, (String)"ship");
        super(resourceLocation, soundSource, volume, pitch, random, looping, delay, attenuation, x, y, z, relative);
        this.originalPos = new Vector3d(this.field_5439, this.field_5450, this.field_5449);
        this.velocity = new Vector3d();
        this.ship = ship;
        Vector3d newPos = ship.getShipToWorld().transformPosition(this.originalPos, new Vector3d());
        this.field_5439 = newPos.x;
        this.field_5450 = newPos.y;
        this.field_5449 = newPos.z;
    }

    public SimpleSoundInstanceOnShip(@NotNull class_3414 soundEvent, @NotNull class_3419 soundSource, float volume, float pitch, @NotNull class_5819 random, boolean looping, int delay, @NotNull class_1113.class_1114 attenuation, double x, double y, double z, @NotNull Ship ship) {
        Intrinsics.checkNotNullParameter((Object)soundEvent, (String)"soundEvent");
        Intrinsics.checkNotNullParameter((Object)soundSource, (String)"soundSource");
        Intrinsics.checkNotNullParameter((Object)random, (String)"random");
        Intrinsics.checkNotNullParameter((Object)attenuation, (String)"attenuation");
        Intrinsics.checkNotNullParameter((Object)ship, (String)"ship");
        class_2960 class_29602 = soundEvent.method_14833();
        Intrinsics.checkNotNullExpressionValue((Object)class_29602, (String)"getLocation(...)");
        this(class_29602, soundSource, volume, pitch, random, looping, delay, attenuation, x, y, z, false, ship);
    }

    public SimpleSoundInstanceOnShip(@NotNull class_3414 soundEvent, @NotNull class_3419 soundSource, float volume, float pitch, @NotNull class_5819 random, double x, double y, double z, @NotNull Ship ship) {
        Intrinsics.checkNotNullParameter((Object)soundEvent, (String)"soundEvent");
        Intrinsics.checkNotNullParameter((Object)soundSource, (String)"soundSource");
        Intrinsics.checkNotNullParameter((Object)random, (String)"random");
        Intrinsics.checkNotNullParameter((Object)ship, (String)"ship");
        this(soundEvent, soundSource, volume, pitch, random, false, 0, class_1113.class_1114.field_5476, x, y, z, ship);
    }

    @Override
    @NotNull
    public Vector3dc getVelocity() {
        return this.velocity;
    }

    public boolean method_4793() {
        return false;
    }

    public void method_16896() {
        Vector3d newPos = this.ship.getShipToWorld().transformPosition(this.originalPos, new Vector3d());
        this.velocity = newPos.sub(this.field_5439, this.field_5450, this.field_5449, new Vector3d());
        this.field_5439 = newPos.x;
        this.field_5450 = newPos.y;
        this.field_5449 = newPos.z;
    }
}

