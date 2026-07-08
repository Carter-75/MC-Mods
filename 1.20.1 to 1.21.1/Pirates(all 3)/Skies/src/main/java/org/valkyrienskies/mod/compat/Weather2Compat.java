/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.Ref$ObjectRef
 *  kotlin.jvm.internal.SourceDebugExtension
 *  net.minecraft.class_243
 *  net.minecraft.class_3218
 *  net.minecraft.class_5321
 *  weather2.ServerTickHandler
 *  weather2.weathersystem.WeatherManagerServer
 *  weather2.weathersystem.storm.StormObject
 *  weather2.weathersystem.storm.WeatherObject
 */
package org.valkyrienskies.mod.compat;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.SourceDebugExtension;
import net.minecraft.class_243;
import net.minecraft.class_3218;
import net.minecraft.class_5321;
import org.jetbrains.annotations.NotNull;
import org.joml.Vector3d;
import org.joml.Vector3dc;
import org.valkyrienskies.core.api.ships.LoadedServerShip;
import org.valkyrienskies.mod.common.VSGameUtilsKt;
import org.valkyrienskies.mod.common.ValkyrienSkiesMod;
import org.valkyrienskies.mod.common.config.VSGameConfig;
import org.valkyrienskies.mod.common.util.GameToPhysicsAdapter;
import org.valkyrienskies.mod.common.util.VectorConversionsMCKt;
import weather2.ServerTickHandler;
import weather2.weathersystem.WeatherManagerServer;
import weather2.weathersystem.storm.StormObject;
import weather2.weathersystem.storm.WeatherObject;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006\u00a8\u0006\t"}, d2={"Lorg/valkyrienskies/mod/compat/Weather2Compat;", "", "Lnet/minecraft/class_3218;", "level", "", "tick", "(Lnet/minecraft/class_3218;)V", "<init>", "()V", "valkyrienskies-120"})
@SourceDebugExtension(value={"SMAP\nWeather2Compat.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Weather2Compat.kt\norg/valkyrienskies/mod/compat/Weather2Compat\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,79:1\n1863#2:80\n1863#2,2:81\n1864#2:83\n*S KotlinDebug\n*F\n+ 1 Weather2Compat.kt\norg/valkyrienskies/mod/compat/Weather2Compat\n*L\n26#1:80\n61#1:81,2\n26#1:83\n*E\n"})
public final class Weather2Compat {
    @NotNull
    public static final Weather2Compat INSTANCE = new Weather2Compat();

    private Weather2Compat() {
    }

    public final void tick(@NotNull class_3218 level) {
        Intrinsics.checkNotNullParameter((Object)level, (String)"level");
        if (!VSGameConfig.SERVER.getWeather2().getEnableWeatherCompat()) {
            return;
        }
        WeatherManagerServer mgr = ServerTickHandler.getWeatherManagerFor((class_5321)level.method_27983());
        float windMult = VSGameConfig.SERVER.getWeather2().getWindMultiplier() / (float)1000;
        float windMax = VSGameConfig.SERVER.getWeather2().getWindMaxVel();
        float stormDampen = 1.0f - VSGameConfig.SERVER.getWeather2().getStormDampening();
        double stormRange = VSGameConfig.SERVER.getWeather2().getStormRange();
        Iterable $this$forEach$iv = VSGameUtilsKt.getShipObjectWorld(level).getLoadedShips();
        boolean $i$f$forEach = false;
        for (Object element$iv : $this$forEach$iv) {
            LoadedServerShip ship = (LoadedServerShip)element$iv;
            boolean bl = false;
            Vector3d vec = new Vector3d();
            GameToPhysicsAdapter forces = ValkyrienSkiesMod.getOrCreateGTPA(ship.getChunkClaimDimension());
            Vector3dc com = ship.getInertiaData().getCenterOfMassInShip();
            ship.getShipToWorld().transformPosition(com, vec);
            class_243 pos = VectorConversionsMCKt.toMinecraft(vec);
            class_243 motion = VectorConversionsMCKt.toMinecraft(ship.getVelocity());
            double mass = ship.getInertiaData().getMass();
            Ref.ObjectRef forcePlusMotion = new Ref.ObjectRef();
            forcePlusMotion.element = mgr.getWindManager().applyWindForceImpl(pos, motion, (float)mass, windMult, windMax, true);
            Weather2Compat.tick$lambda$1$applyForcePlusMotion(vec, (Ref.ObjectRef<class_243>)forcePlusMotion, ship, mass, forces);
            List list = mgr.getStormsAround(pos, stormRange);
            Intrinsics.checkNotNullExpressionValue((Object)list, (String)"getStormsAround(...)");
            Iterable $this$forEach$iv2 = list;
            boolean $i$f$forEach2 = false;
            for (Object element$iv2 : $this$forEach$iv2) {
                WeatherObject it = (WeatherObject)element$iv2;
                boolean bl2 = false;
                if (!(it instanceof StormObject) || ((StormObject)it).getTornadoFunnelSimple() == null) continue;
                forcePlusMotion.element = ((StormObject)it).spinObject(pos, (class_243)forcePlusMotion.element, false, stormDampen, stormDampen, true, 0.0f);
                Weather2Compat.tick$lambda$1$applyForcePlusMotion(vec, (Ref.ObjectRef<class_243>)forcePlusMotion, ship, mass, forces);
            }
        }
    }

    private static final void tick$lambda$1$applyForcePlusMotion(Vector3d vec, Ref.ObjectRef<class_243> forcePlusMotion, LoadedServerShip $ship, double mass, GameToPhysicsAdapter forces) {
        vec.x = ((class_243)forcePlusMotion.element).field_1352;
        vec.y = ((class_243)forcePlusMotion.element).field_1351;
        vec.z = ((class_243)forcePlusMotion.element).field_1350;
        vec.sub($ship.getVelocity());
        vec.mul(mass);
        forces.applyWorldForce($ship.getId(), vec, null);
    }
}

