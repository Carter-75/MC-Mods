/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Lazy
 *  kotlin.LazyKt
 *  kotlin.Metadata
 *  kotlin.enums.EnumEntries
 *  kotlin.enums.EnumEntriesKt
 *  kotlin.jvm.JvmStatic
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.PropertyReference0
 *  kotlin.jvm.internal.PropertyReference0Impl
 *  kotlin.jvm.internal.Reflection
 *  kotlin.properties.ReadOnlyProperty
 *  kotlin.reflect.KProperty
 */
package org.valkyrienskies.mod.compat;

import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference0;
import kotlin.jvm.internal.PropertyReference0Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\b\n\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0002\"#B\t\b\u0002\u00a2\u0006\u0004\b!\u0010\bR!\u0010\t\u001a\u00020\u00028FX\u0087\u0084\u0002\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u0012\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006R!\u0010\r\u001a\u00020\u00028FX\u0087\u0084\u0002\u00a2\u0006\u0012\n\u0004\b\n\u0010\u0004\u0012\u0004\b\f\u0010\b\u001a\u0004\b\u000b\u0010\u0006R!\u0010\u0011\u001a\u00020\u00028FX\u0087\u0084\u0002\u00a2\u0006\u0012\n\u0004\b\u000e\u0010\u0004\u0012\u0004\b\u0010\u0010\b\u001a\u0004\b\u000f\u0010\u0006R!\u0010\u0015\u001a\u00020\u00028FX\u0087\u0084\u0002\u00a2\u0006\u0012\n\u0004\b\u0012\u0010\u0004\u0012\u0004\b\u0014\u0010\b\u001a\u0004\b\u0013\u0010\u0006R!\u0010\u0019\u001a\u00020\u00028FX\u0087\u0084\u0002\u00a2\u0006\u0012\n\u0004\b\u0016\u0010\u0004\u0012\u0004\b\u0018\u0010\b\u001a\u0004\b\u0017\u0010\u0006R!\u0010 \u001a\u00020\u001a8FX\u0087\u0084\u0002\u00a2\u0006\u0012\n\u0004\b\u001b\u0010\u001c\u0012\u0004\b\u001f\u0010\b\u001a\u0004\b\u001d\u0010\u001e\u00a8\u0006$"}, d2={"Lorg/valkyrienskies/mod/compat/LoadedMods;", "", "", "iris$delegate", "Lorg/valkyrienskies/mod/compat/LoadedMods$CompatInfo;", "getIris", "()Z", "getIris$annotations", "()V", "iris", "weather2$delegate", "getWeather2", "getWeather2$annotations", "weather2", "immersivePortals$delegate", "getImmersivePortals", "getImmersivePortals$annotations", "immersivePortals", "create$delegate", "getCreate", "getCreate$annotations", "create", "oldCreate$delegate", "getOldCreate", "getOldCreate$annotations", "oldCreate", "Lorg/valkyrienskies/mod/compat/LoadedMods$FlywheelVersion;", "flywheel$delegate", "Lkotlin/Lazy;", "getFlywheel", "()Lorg/valkyrienskies/mod/compat/LoadedMods$FlywheelVersion;", "getFlywheel$annotations", "flywheel", "<init>", "CompatInfo", "FlywheelVersion", "valkyrienskies-120"})
public final class LoadedMods {
    @NotNull
    public static final LoadedMods INSTANCE;
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties;
    @NotNull
    private static final CompatInfo iris$delegate;
    @NotNull
    private static final CompatInfo weather2$delegate;
    @NotNull
    private static final CompatInfo immersivePortals$delegate;
    @NotNull
    private static final CompatInfo create$delegate;
    @NotNull
    private static final CompatInfo oldCreate$delegate;
    @NotNull
    private static final Lazy flywheel$delegate;

    private LoadedMods() {
    }

    public static final boolean getIris() {
        return (Boolean)iris$delegate.getValue((Object)INSTANCE, (KProperty)$$delegatedProperties[0]);
    }

    @JvmStatic
    public static /* synthetic */ void getIris$annotations() {
    }

    public static final boolean getWeather2() {
        return (Boolean)weather2$delegate.getValue((Object)INSTANCE, (KProperty)$$delegatedProperties[1]);
    }

    @JvmStatic
    public static /* synthetic */ void getWeather2$annotations() {
    }

    public static final boolean getImmersivePortals() {
        return (Boolean)immersivePortals$delegate.getValue((Object)INSTANCE, (KProperty)$$delegatedProperties[2]);
    }

    @JvmStatic
    public static /* synthetic */ void getImmersivePortals$annotations() {
    }

    public static final boolean getCreate() {
        return (Boolean)create$delegate.getValue((Object)INSTANCE, (KProperty)$$delegatedProperties[3]);
    }

    @JvmStatic
    public static /* synthetic */ void getCreate$annotations() {
    }

    public static final boolean getOldCreate() {
        return (Boolean)oldCreate$delegate.getValue((Object)INSTANCE, (KProperty)$$delegatedProperties[4]);
    }

    @JvmStatic
    public static /* synthetic */ void getOldCreate$annotations() {
    }

    @NotNull
    public static final FlywheelVersion getFlywheel() {
        Lazy lazy = flywheel$delegate;
        return (FlywheelVersion)((Object)lazy.getValue());
    }

    @JvmStatic
    public static /* synthetic */ void getFlywheel$annotations() {
    }

    private static final FlywheelVersion flywheel_delegate$lambda$0() {
        FlywheelVersion flywheelVersion;
        try {
            Class.forName("dev.engine_room.flywheel.backend.FlwBackend");
            flywheelVersion = FlywheelVersion.V1;
        }
        catch (ClassNotFoundException e2) {
            FlywheelVersion flywheelVersion2;
            try {
                Class.forName("com.jozufozu.flywheel.Flywheel");
                flywheelVersion2 = FlywheelVersion.V06;
            }
            catch (ClassNotFoundException classNotFoundException) {
                flywheelVersion2 = FlywheelVersion.NONE;
            }
            flywheelVersion = flywheelVersion2;
        }
        return flywheelVersion;
    }

    static {
        KProperty[] kPropertyArray = new KProperty[]{Reflection.property0((PropertyReference0)((PropertyReference0)new PropertyReference0Impl((Object)INSTANCE, LoadedMods.class, "iris", "getIris()Z", 0))), Reflection.property0((PropertyReference0)((PropertyReference0)new PropertyReference0Impl((Object)INSTANCE, LoadedMods.class, "weather2", "getWeather2()Z", 0))), Reflection.property0((PropertyReference0)((PropertyReference0)new PropertyReference0Impl((Object)INSTANCE, LoadedMods.class, "immersivePortals", "getImmersivePortals()Z", 0))), Reflection.property0((PropertyReference0)((PropertyReference0)new PropertyReference0Impl((Object)INSTANCE, LoadedMods.class, "create", "getCreate()Z", 0))), Reflection.property0((PropertyReference0)((PropertyReference0)new PropertyReference0Impl((Object)INSTANCE, LoadedMods.class, "oldCreate", "getOldCreate()Z", 0)))};
        $$delegatedProperties = kPropertyArray;
        INSTANCE = new LoadedMods();
        iris$delegate = new CompatInfo("net.coderbot.iris.Iris");
        weather2$delegate = new CompatInfo("weather2.Weather");
        immersivePortals$delegate = new CompatInfo("qouteall.imm_ptl.core.IPModMain");
        create$delegate = new CompatInfo("com.simibubi.create.AllMountedDispenseItemBehaviors");
        oldCreate$delegate = new CompatInfo("com.simibubi.create.foundation.render.AllInstanceFormats");
        flywheel$delegate = LazyKt.lazy(LoadedMods::flywheel_delegate$lambda$0);
    }

    @Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0007\u0018\u00002\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u000f\u0012\u0006\u0010\n\u001a\u00020\t\u00a2\u0006\u0004\b\u000e\u0010\u000fJ&\u0010\u0007\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00022\n\u0010\u0006\u001a\u0006\u0012\u0002\b\u00030\u0005H\u0096\u0002\u00a2\u0006\u0004\b\u0007\u0010\bR\u0014\u0010\n\u001a\u00020\t8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0018\u0010\f\u001a\u0004\u0018\u00010\u00038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\f\u0010\r\u00a8\u0006\u0010"}, d2={"Lorg/valkyrienskies/mod/compat/LoadedMods$CompatInfo;", "Lkotlin/properties/ReadOnlyProperty;", "", "", "thisRef", "Lkotlin/reflect/KProperty;", "property", "getValue", "(Ljava/lang/Object;Lkotlin/reflect/KProperty;)Ljava/lang/Boolean;", "", "className", "Ljava/lang/String;", "isLoaded", "Ljava/lang/Boolean;", "<init>", "(Ljava/lang/String;)V", "valkyrienskies-120"})
    public static final class CompatInfo
    implements ReadOnlyProperty<Object, Boolean> {
        @NotNull
        private final String className;
        @Nullable
        private Boolean isLoaded;

        public CompatInfo(@NotNull String className) {
            Intrinsics.checkNotNullParameter((Object)className, (String)"className");
            this.className = className;
        }

        @NotNull
        public Boolean getValue(@Nullable Object thisRef, @NotNull KProperty<?> property) {
            Intrinsics.checkNotNullParameter(property, (String)"property");
            if (this.isLoaded == null) {
                boolean bl;
                CompatInfo compatInfo;
                CompatInfo compatInfo2 = this;
                try {
                    compatInfo = compatInfo2;
                    Class.forName(this.className, false, LoadedMods.class.getClassLoader());
                    bl = true;
                }
                catch (ClassNotFoundException classNotFoundException) {
                    compatInfo = compatInfo2;
                    bl = false;
                }
                compatInfo.isLoaded = bl;
            }
            Boolean bl = this.isLoaded;
            Intrinsics.checkNotNull((Object)bl);
            return bl;
        }
    }

    @Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006\u00a8\u0006\u0007"}, d2={"Lorg/valkyrienskies/mod/compat/LoadedMods$FlywheelVersion;", "", "<init>", "(Ljava/lang/String;I)V", "V1", "V06", "NONE", "valkyrienskies-120"})
    public static final class FlywheelVersion
    extends Enum<FlywheelVersion> {
        public static final /* enum */ FlywheelVersion V1 = new FlywheelVersion();
        public static final /* enum */ FlywheelVersion V06 = new FlywheelVersion();
        public static final /* enum */ FlywheelVersion NONE = new FlywheelVersion();
        private static final /* synthetic */ FlywheelVersion[] $VALUES;
        private static final /* synthetic */ EnumEntries $ENTRIES;

        public static FlywheelVersion[] values() {
            return (FlywheelVersion[])$VALUES.clone();
        }

        public static FlywheelVersion valueOf(String value) {
            return Enum.valueOf(FlywheelVersion.class, value);
        }

        @NotNull
        public static EnumEntries<FlywheelVersion> getEntries() {
            return $ENTRIES;
        }

        static {
            $VALUES = flywheelVersionArray = new FlywheelVersion[]{FlywheelVersion.V1, FlywheelVersion.V06, FlywheelVersion.NONE};
            $ENTRIES = EnumEntriesKt.enumEntries((Enum[])$VALUES);
        }
    }
}

