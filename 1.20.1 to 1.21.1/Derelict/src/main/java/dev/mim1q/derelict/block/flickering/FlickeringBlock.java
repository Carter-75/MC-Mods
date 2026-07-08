/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.Pair
 *  kotlin.TuplesKt
 *  kotlin.enums.EnumEntries
 *  kotlin.enums.EnumEntriesKt
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.class_1937
 *  net.minecraft.class_2248
 *  net.minecraft.class_2338
 *  net.minecraft.class_2680
 *  net.minecraft.class_2754
 *  net.minecraft.class_2769
 *  net.minecraft.class_3542
 *  net.minecraft.class_5819
 *  org.jetbrains.annotations.NotNull
 */
package dev.mim1q.derelict.block.flickering;

import dev.mim1q.derelict.Derelict;
import dev.mim1q.derelict.config.DerelictConfigModel;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.class_1937;
import net.minecraft.class_2248;
import net.minecraft.class_2338;
import net.minecraft.class_2680;
import net.minecraft.class_2754;
import net.minecraft.class_2769;
import net.minecraft.class_3542;
import net.minecraft.class_5819;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0006\bf\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017J7\u0010\r\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0016\u00a2\u0006\u0004\b\r\u0010\u000eJ+\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00120\u00112\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\u000fH\u0016\u00a2\u0006\u0004\b\u0013\u0010\u0014J#\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00120\u00112\u0006\u0010\t\u001a\u00020\bH\u0016\u00a2\u0006\u0004\b\u0015\u0010\u0016\u00a8\u0006\u0018"}, d2={"Ldev/mim1q/derelict/block/flickering/FlickeringBlock;", "", "Lnet/minecraft/class_1937;", "world", "Lnet/minecraft/class_2680;", "state", "Lnet/minecraft/class_2338;", "pos", "Lnet/minecraft/class_5819;", "random", "Lnet/minecraft/class_2248;", "block", "", "scheduleFlicker", "(Lnet/minecraft/class_1937;Lnet/minecraft/class_2680;Lnet/minecraft/class_2338;Lnet/minecraft/class_5819;Lnet/minecraft/class_2248;)V", "Ldev/mim1q/derelict/block/flickering/FlickeringBlock$Companion$LightState;", "currentState", "Lkotlin/Pair;", "", "nextFancyFlicker", "(Lnet/minecraft/class_5819;Ldev/mim1q/derelict/block/flickering/FlickeringBlock$Companion$LightState;)Lkotlin/Pair;", "nextFabulousFlicker", "(Lnet/minecraft/class_5819;)Lkotlin/Pair;", "Companion", "derelict"})
public interface FlickeringBlock {
    @NotNull
    public static final Companion Companion = dev.mim1q.derelict.block.flickering.FlickeringBlock$Companion.$$INSTANCE;

    public void scheduleFlicker(@NotNull class_1937 var1, @NotNull class_2680 var2, @NotNull class_2338 var3, @NotNull class_5819 var4, @NotNull class_2248 var5);

    @NotNull
    public Pair<Companion.LightState, Integer> nextFancyFlicker(@NotNull class_5819 var1, @NotNull Companion.LightState var2);

    @NotNull
    public Pair<Companion.LightState, Integer> nextFabulousFlicker(@NotNull class_5819 var1);

    @Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001:\u0001\u000fB\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004\u00a2\u0006\u0004\b\u0007\u0010\bR\u001d\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\t8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\u00a8\u0006\u0010"}, d2={"Ldev/mim1q/derelict/block/flickering/FlickeringBlock$Companion;", "", "<init>", "()V", "Lnet/minecraft/class_2680;", "state", "", "getLuminance", "(Lnet/minecraft/class_2680;)I", "Lnet/minecraft/class_2754;", "Ldev/mim1q/derelict/block/flickering/FlickeringBlock$Companion$LightState;", "LIGHT_STATE", "Lnet/minecraft/class_2754;", "getLIGHT_STATE", "()Lnet/minecraft/class_2754;", "LightState", "derelict"})
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE;
        @NotNull
        private static final class_2754<LightState> LIGHT_STATE;

        private Companion() {
        }

        public final int getLuminance(@NotNull class_2680 state) {
            Intrinsics.checkNotNullParameter((Object)state, (String)"state");
            LightState lightState = (LightState)((Object)state.method_11654((class_2769)LIGHT_STATE));
            return switch (lightState == null ? -1 : WhenMappings.$EnumSwitchMapping$0[lightState.ordinal()]) {
                case 1 -> 5;
                case 2 -> 10;
                case 3 -> 7;
                default -> 0;
            };
        }

        @NotNull
        public final class_2754<LightState> getLIGHT_STATE() {
            return LIGHT_STATE;
        }

        static {
            $$INSTANCE = new Companion();
            class_2754 class_27542 = class_2754.method_11850((String)"light_state", LightState.class);
            Intrinsics.checkNotNullExpressionValue((Object)class_27542, (String)"of(...)");
            LIGHT_STATE = class_27542;
        }

        @Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\u000b\b\u0086\u0081\u0002\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002B\u0011\b\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0003H\u0016\u00a2\u0006\u0004\b\u0007\u0010\bR\u0014\u0010\u0004\u001a\u00020\u00038\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0004\u0010\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r\u00a8\u0006\u000e"}, d2={"Ldev/mim1q/derelict/block/flickering/FlickeringBlock$Companion$LightState;", "Lnet/minecraft/class_3542;", "", "", "id", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "asString", "()Ljava/lang/String;", "Ljava/lang/String;", "FLICKERING", "OFF", "HALF_ON", "ON", "derelict"})
        public static final class LightState
        extends Enum<LightState>
        implements class_3542 {
            @NotNull
            private final String id;
            public static final /* enum */ LightState FLICKERING = new LightState("flickering");
            public static final /* enum */ LightState OFF = new LightState("off");
            public static final /* enum */ LightState HALF_ON = new LightState("half_on");
            public static final /* enum */ LightState ON = new LightState("on");
            private static final /* synthetic */ LightState[] $VALUES;
            private static final /* synthetic */ EnumEntries $ENTRIES;

            private LightState(String id) {
                this.id = id;
            }

            @NotNull
            public String method_15434() {
                return this.id;
            }

            public static LightState[] values() {
                return (LightState[])$VALUES.clone();
            }

            public static LightState valueOf(String value) {
                return Enum.valueOf(LightState.class, value);
            }

            @NotNull
            public static EnumEntries<LightState> getEntries() {
                return $ENTRIES;
            }

            static {
                $VALUES = lightStateArray = new LightState[]{LightState.FLICKERING, LightState.OFF, LightState.HALF_ON, LightState.ON};
                $ENTRIES = EnumEntriesKt.enumEntries((Enum[])$VALUES);
            }
        }

        @Metadata(mv={2, 0, 0}, k=3, xi=48)
        public final class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                int[] nArray = new int[LightState.values().length];
                try {
                    nArray[LightState.HALF_ON.ordinal()] = 1;
                }
                catch (NoSuchFieldError noSuchFieldError) {
                    // empty catch block
                }
                try {
                    nArray[LightState.ON.ordinal()] = 2;
                }
                catch (NoSuchFieldError noSuchFieldError) {
                    // empty catch block
                }
                try {
                    nArray[LightState.FLICKERING.ordinal()] = 3;
                }
                catch (NoSuchFieldError noSuchFieldError) {
                    // empty catch block
                }
                $EnumSwitchMapping$0 = nArray;
            }
        }
    }

    @Metadata(mv={2, 0, 0}, k=3, xi=48)
    public static final class DefaultImpls {
        public static void scheduleFlicker(@NotNull FlickeringBlock $this, @NotNull class_1937 world, @NotNull class_2680 state, @NotNull class_2338 pos, @NotNull class_5819 random, @NotNull class_2248 block) {
            Pair pair;
            Intrinsics.checkNotNullParameter((Object)world, (String)"world");
            Intrinsics.checkNotNullParameter((Object)state, (String)"state");
            Intrinsics.checkNotNullParameter((Object)pos, (String)"pos");
            Intrinsics.checkNotNullParameter((Object)random, (String)"random");
            Intrinsics.checkNotNullParameter((Object)block, (String)"block");
            if (world.field_9236) {
                return;
            }
            if (Derelict.INSTANCE.getCONFIG().flickeringLights() == DerelictConfigModel.FlickeringLightsSetting.FAST) {
                world.method_8501(pos, (class_2680)state.method_11657((class_2769)Companion.getLIGHT_STATE(), (Comparable)((Object)Companion.LightState.FLICKERING)));
                return;
            }
            DerelictConfigModel.FlickeringLightsSetting flickeringLightsSetting = Derelict.INSTANCE.getCONFIG().flickeringLights();
            if ((flickeringLightsSetting == null ? -1 : WhenMappings.$EnumSwitchMapping$0[flickeringLightsSetting.ordinal()]) == 1) {
                Comparable comparable = state.method_11654((class_2769)Companion.getLIGHT_STATE());
                Intrinsics.checkNotNullExpressionValue((Object)comparable, (String)"get(...)");
                pair = $this.nextFancyFlicker(random, (Companion.LightState)((Object)comparable));
            } else {
                pair = state.method_11654((class_2769)Companion.getLIGHT_STATE()) == Companion.LightState.HALF_ON ? $this.nextFabulousFlicker(random) : TuplesKt.to((Object)((Object)Companion.LightState.HALF_ON), (Object)(1 + random.method_43048(1)));
            }
            Pair pair2 = pair;
            Companion.LightState lightState = (Companion.LightState)((Object)pair2.component1());
            int delay = ((Number)pair2.component2()).intValue();
            world.method_8501(pos, (class_2680)state.method_11657((class_2769)Companion.getLIGHT_STATE(), (Comparable)((Object)lightState)));
            world.method_39279(pos, block, delay);
        }

        @NotNull
        public static Pair<Companion.LightState, Integer> nextFancyFlicker(@NotNull FlickeringBlock $this, @NotNull class_5819 random, @NotNull Companion.LightState currentState) {
            Intrinsics.checkNotNullParameter((Object)random, (String)"random");
            Intrinsics.checkNotNullParameter((Object)((Object)currentState), (String)"currentState");
            return WhenMappings.$EnumSwitchMapping$1[currentState.ordinal()] == 1 ? TuplesKt.to((Object)((Object)Companion.LightState.ON), (Object)((double)random.method_43057() < 0.75 ? random.method_43048(3) + 1 : random.method_43048(100) + 20)) : TuplesKt.to((Object)((Object)Companion.LightState.OFF), (Object)(random.method_43048(3) + 1));
        }

        @NotNull
        public static Pair<Companion.LightState, Integer> nextFabulousFlicker(@NotNull FlickeringBlock $this, @NotNull class_5819 random) {
            Intrinsics.checkNotNullParameter((Object)random, (String)"random");
            if ((double)random.method_43057() < 0.5) {
                if ((double)random.method_43057() < 0.5) {
                    return TuplesKt.to((Object)((Object)Companion.LightState.ON), (Object)(random.method_43048(4) + 2));
                }
                return TuplesKt.to((Object)((Object)Companion.LightState.ON), (Object)(random.method_43048(100) + 20));
            }
            return TuplesKt.to((Object)((Object)Companion.LightState.OFF), (Object)(random.method_43048(6) + 1));
        }
    }

    @Metadata(mv={2, 0, 0}, k=3, xi=48)
    public final class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            int[] nArray = new int[DerelictConfigModel.FlickeringLightsSetting.values().length];
            try {
                nArray[DerelictConfigModel.FlickeringLightsSetting.FANCY.ordinal()] = 1;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            $EnumSwitchMapping$0 = nArray;
            nArray = new int[Companion.LightState.values().length];
            try {
                nArray[Companion.LightState.OFF.ordinal()] = 1;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            $EnumSwitchMapping$1 = nArray;
        }
    }
}

