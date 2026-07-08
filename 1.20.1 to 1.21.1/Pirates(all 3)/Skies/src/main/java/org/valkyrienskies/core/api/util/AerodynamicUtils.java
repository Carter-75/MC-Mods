/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.Triple
 */
package org.valkyrienskies.core.api.util;

import kotlin.Metadata;
import kotlin.Triple;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.valkyrienskies.core.api.VsBeta;

@VsBeta
@Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\b\bg\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001aJ#\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\n\u0010\u0006\u001a\u00060\u0004j\u0002`\u0005H&\u00a2\u0006\u0004\b\u0007\u0010\bJ#\u0010\t\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\n\u0010\u0006\u001a\u00060\u0004j\u0002`\u0005H&\u00a2\u0006\u0004\b\t\u0010\bJ#\u0010\n\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\n\u0010\u0006\u001a\u00060\u0004j\u0002`\u0005H&\u00a2\u0006\u0004\b\n\u0010\bJ-\u0010\r\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\f2\n\u0010\u000b\u001a\u00060\u0004j\u0002`\u0005H&\u00a2\u0006\u0004\b\r\u0010\u000eJ3\u0010\u0014\u001a\u00020\u00132\n\u0010\u000f\u001a\u00060\u0004j\u0002`\u00052\u0006\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u0002H&\u00a2\u0006\u0004\b\u0014\u0010\u0015J/\u0010\u0016\u001a\u00020\u00132\n\u0010\u000f\u001a\u00060\u0004j\u0002`\u00052\b\u0010\u0010\u001a\u0004\u0018\u00010\u00022\b\u0010\u0011\u001a\u0004\u0018\u00010\u0002H&\u00a2\u0006\u0004\b\u0016\u0010\u0017J#\u0010\u0018\u001a\u00020\u00132\n\u0010\u000f\u001a\u00060\u0004j\u0002`\u00052\u0006\u0010\u0012\u001a\u00020\u0002H&\u00a2\u0006\u0004\b\u0018\u0010\u0019\u00f8\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001\u00a8\u0006\u001b\u00c0\u0006\u0001"}, d2={"Lorg/valkyrienskies/core/api/util/AerodynamicUtils;", "", "", "y", "", "Lorg/valkyrienskies/core/api/world/properties/DimensionId;", "dimension", "getAirDensityForY", "(DLjava/lang/String;)D", "getAirPressureForY", "getAirTemperatureForY", "id", "Lkotlin/Triple;", "getAtmosphereForDimension", "(Ljava/lang/String;)Lkotlin/Triple;", "dimensionId", "maxY", "seaLevel", "gravity", "", "registerDimension", "(Ljava/lang/String;DDD)V", "updateAerodynamicInfoForDimension", "(Ljava/lang/String;Ljava/lang/Double;Ljava/lang/Double;)V", "updateGravityForDimension", "(Ljava/lang/String;D)V", "Companion", "api"})
public interface AerodynamicUtils {
    @NotNull
    public static final Companion Companion = org.valkyrienskies.core.api.util.AerodynamicUtils$Companion.$$INSTANCE;
    public static final double DEFAULT_MAX = 962.0;
    public static final double DEFAULT_SEA_LEVEL = 62.0;
    public static final double GRAVITATIONAL_ACCELERATION = 10.0;
    public static final double UNIVERSAL_GAS_CONSTANT = 8.314;
    public static final double AIR_MOLAR_MASS = 0.0289644;

    public void registerDimension(@NotNull String var1, double var2, double var4, double var6);

    public void updateGravityForDimension(@NotNull String var1, double var2);

    public void updateAerodynamicInfoForDimension(@NotNull String var1, @Nullable Double var2, @Nullable Double var3);

    @NotNull
    public Triple<Double, Double, Double> getAtmosphereForDimension(@NotNull String var1);

    public double getAirDensityForY(double var1, @NotNull String var3);

    public double getAirPressureForY(double var1, @NotNull String var3);

    public double getAirTemperatureForY(double var1, @NotNull String var3);

    @Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0006\n\u0002\b\t\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\t\u0010\nR\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u0014\u0010\u0007\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u0004R\u0014\u0010\b\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0004\u00a8\u0006\u000b"}, d2={"Lorg/valkyrienskies/core/api/util/AerodynamicUtils$Companion;", "", "", "AIR_MOLAR_MASS", "D", "DEFAULT_MAX", "DEFAULT_SEA_LEVEL", "GRAVITATIONAL_ACCELERATION", "UNIVERSAL_GAS_CONSTANT", "<init>", "()V", "api"})
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE;
        public static final double DEFAULT_MAX = 962.0;
        public static final double DEFAULT_SEA_LEVEL = 62.0;
        public static final double GRAVITATIONAL_ACCELERATION = 10.0;
        public static final double UNIVERSAL_GAS_CONSTANT = 8.314;
        public static final double AIR_MOLAR_MASS = 0.0289644;

        private Companion() {
        }

        static {
            $$INSTANCE = new Companion();
        }
    }
}

