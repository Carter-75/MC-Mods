/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.JvmName
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 */
package org.valkyrienskies.core.impl.program;

import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.valkyrienskies.core.api.physics.blockstates.BoxesBlockShape;
import org.valkyrienskies.core.api.physics.blockstates.LiquidState;
import org.valkyrienskies.core.api.physics.blockstates.SolidState;
import org.valkyrienskies.core.impl.api_impl.physics.blockstates.BoxesBlockShapeImpl;
import org.valkyrienskies.core.impl.api_impl.physics.blockstates.LiquidStateImpl;
import org.valkyrienskies.core.impl.api_impl.physics.blockstates.SolidStateImpl;
import org.valkyrienskies.core.impl.config.VSCoreConfig;
import org.valkyrienskies.core.impl.game.ships.serialization.ShipSerializationModule;
import org.valkyrienskies.core.impl.program.VSCoreImpl;
import org.valkyrienskies.core.impl.program.VSCoreInternal;
import org.valkyrienskies.core.impl.shadow.DN;
import org.valkyrienskies.core.impl.shadow.EU;
import org.valkyrienskies.core.impl.shadow.FJ;
import org.valkyrienskies.core.impl.shadow.FL;
import org.valkyrienskies.core.impl.shadow.FR;
import org.valkyrienskies.core.impl.shadow.GG;
import org.valkyrienskies.core.impl.shadow.do_0;
import org.valkyrienskies.core.impl.shadow.dp_1;
import org.valkyrienskies.core.impl.shadow.dw_1;
import org.valkyrienskies.core.impl.shadow.dx_1;
import org.valkyrienskies.core.impl.shadow.fi_2;
import org.valkyrienskies.core.impl.shadow.fj_0;
import org.valkyrienskies.core.internal.VsiCore;
import org.valkyrienskies.core.internal.collision.VsiSolidShapeUtils;
import org.valkyrienskies.core.internal.hooks.VsiCoreHooks;
import org.valkyrienskies.core.internal.hooks.VsiCoreHooksOut;
import org.valkyrienskies.core.internal.world.chunks.VsiBlockTypes;

@dw_1(a={fi_2.a_0.class, GG.class, ShipSerializationModule.class, Declarations.class}, b={FL.class})
@Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001:\u0001\u0016B!\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u000f\u00a2\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0003\u001a\u00020\u0002H\u0007\u00a2\u0006\u0004\b\u0003\u0010\u0004R\u0017\u0010\u0006\u001a\u00020\u00058\u0007\u00a2\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\tR\u001a\u0010\u000b\u001a\u00020\n8\u0007X\u0087\u0004\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u001a\u0010\u0010\u001a\u00020\u000f8\u0007X\u0087\u0004\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013"}, d2={"Lorg/valkyrienskies/core/impl/program/VSCoreModule;", "", "Lorg/valkyrienskies/core/impl/config/VSCoreConfig$Server;", "serverConfig", "()Lorg/valkyrienskies/core/impl/config/VSCoreConfig$Server;", "Lorg/valkyrienskies/core/impl/shadow/Fj;", "configurator", "Lorg/valkyrienskies/core/impl/shadow/Fj;", "getConfigurator", "()Lorg/valkyrienskies/core/impl/shadow/Fj;", "Lorg/valkyrienskies/core/internal/hooks/VsiCoreHooksOut;", "hooks", "Lorg/valkyrienskies/core/internal/hooks/VsiCoreHooksOut;", "getHooks", "()Lorg/valkyrienskies/core/internal/hooks/VsiCoreHooksOut;", "Lorg/valkyrienskies/core/impl/shadow/FR;", "physicsThreadChecker", "Lorg/valkyrienskies/core/impl/shadow/FR;", "getPhysicsThreadChecker", "()Lorg/valkyrienskies/core/impl/shadow/FR;", "<init>", "(Lorg/valkyrienskies/core/internal/hooks/VsiCoreHooksOut;Lorg/valkyrienskies/core/impl/shadow/Fj;Lorg/valkyrienskies/core/impl/shadow/FR;)V", "Declarations"})
public final class VSCoreModule {
    private final VsiCoreHooksOut hooks;
    private final fj_0 configurator;
    private final FR physicsThreadChecker;

    /*
     * WARNING - void declaration
     */
    public VSCoreModule(VsiCoreHooksOut hooks, fj_0 configurator2, FR physicsThreadChecker) {
        void var3_3;
        void var2_2;
        void var1_1;
        Intrinsics.checkNotNullParameter((Object)hooks, (String)"");
        Intrinsics.checkNotNullParameter((Object)configurator2, (String)"");
        Intrinsics.checkNotNullParameter((Object)physicsThreadChecker, (String)"");
        this.hooks = var1_1;
        this.configurator = var2_2;
        this.physicsThreadChecker = var3_3;
    }

    public /* synthetic */ VSCoreModule(VsiCoreHooksOut vsiCoreHooksOut, fj_0 fj_02, FR fR, int n2, DefaultConstructorMarker defaultConstructorMarker) {
        if ((n2 & 4) != 0) {
            fR = FJ.a.a();
        }
        this(vsiCoreHooksOut, fj_02, fR);
    }

    @dx_1
    @JvmName(name="getHooks")
    public final VsiCoreHooksOut getHooks() {
        return this.hooks;
    }

    @dx_1
    @JvmName(name="getConfigurator")
    public final fj_0 getConfigurator() {
        return this.configurator;
    }

    @dx_1
    @JvmName(name="getPhysicsThreadChecker")
    public final FR getPhysicsThreadChecker() {
        return this.physicsThreadChecker;
    }

    @dx_1
    @Singleton
    public final VSCoreConfig.Server serverConfig() {
        return VSCoreConfig.SERVER;
    }

    @dw_1
    @Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u0000f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H'\u00a2\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0007H'\u00a2\u0006\u0004\b\t\u0010\nJ\u0017\u0010\r\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u000bH'\u00a2\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0003\u001a\u00020\u000fH'\u00a2\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0003\u001a\u00020\u0013H'\u00a2\u0006\u0004\b\u0015\u0010\u0016J\u0017\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0003\u001a\u00020\u0017H'\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\u0017\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u0003\u001a\u00020\u001bH'\u00a2\u0006\u0004\b\u001d\u0010\u001eJ\u0017\u0010 \u001a\u00020\u001f2\u0006\u0010\u0003\u001a\u00020\u001bH'\u00a2\u0006\u0004\b \u0010!\u00f8\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001\u00c0\u0006\u0001"}, d2={"Lorg/valkyrienskies/core/impl/program/VSCoreModule$Declarations;", "", "Lorg/valkyrienskies/core/impl/shadow/DN;", "impl", "Lorg/valkyrienskies/core/internal/world/chunks/VsiBlockTypes;", "blockTypes", "(Lorg/valkyrienskies/core/impl/shadow/DN;)Lorg/valkyrienskies/core/internal/world/chunks/VsiBlockTypes;", "Lorg/valkyrienskies/core/impl/shadow/EU;", "Lorg/valkyrienskies/core/internal/hooks/VsiCoreHooks;", "hooks", "(Lorg/valkyrienskies/core/impl/shadow/EU;)Lorg/valkyrienskies/core/internal/hooks/VsiCoreHooks;", "Lorg/valkyrienskies/core/impl/api_impl/physics/blockstates/LiquidStateImpl$BuilderImpl;", "Lorg/valkyrienskies/core/api/physics/blockstates/LiquidState$Builder;", "liquidStateBuilder", "(Lorg/valkyrienskies/core/impl/api_impl/physics/blockstates/LiquidStateImpl$BuilderImpl;)Lorg/valkyrienskies/core/api/physics/blockstates/LiquidState$Builder;", "Lorg/valkyrienskies/core/impl/shadow/Do;", "Lorg/valkyrienskies/core/internal/collision/VsiSolidShapeUtils;", "solidShapeUtils", "(Lorg/valkyrienskies/core/impl/shadow/Do;)Lorg/valkyrienskies/core/internal/collision/VsiSolidShapeUtils;", "Lorg/valkyrienskies/core/impl/api_impl/physics/blockstates/BoxesBlockShapeImpl$BuilderImpl;", "Lorg/valkyrienskies/core/api/physics/blockstates/BoxesBlockShape$Builder;", "solidStateBoxesShapeBuilder", "(Lorg/valkyrienskies/core/impl/api_impl/physics/blockstates/BoxesBlockShapeImpl$BuilderImpl;)Lorg/valkyrienskies/core/api/physics/blockstates/BoxesBlockShape$Builder;", "Lorg/valkyrienskies/core/impl/api_impl/physics/blockstates/SolidStateImpl$BuilderImpl;", "Lorg/valkyrienskies/core/api/physics/blockstates/SolidState$Builder;", "solidStateBuilder", "(Lorg/valkyrienskies/core/impl/api_impl/physics/blockstates/SolidStateImpl$BuilderImpl;)Lorg/valkyrienskies/core/api/physics/blockstates/SolidState$Builder;", "Lorg/valkyrienskies/core/impl/program/VSCoreImpl;", "Lorg/valkyrienskies/core/internal/VsiCore;", "vsCore", "(Lorg/valkyrienskies/core/impl/program/VSCoreImpl;)Lorg/valkyrienskies/core/internal/VsiCore;", "Lorg/valkyrienskies/core/impl/program/VSCoreInternal;", "vsCoreInternal", "(Lorg/valkyrienskies/core/impl/program/VSCoreImpl;)Lorg/valkyrienskies/core/impl/program/VSCoreInternal;"})
    public static interface Declarations {
        @dp_1
        public BoxesBlockShape.Builder solidStateBoxesShapeBuilder(BoxesBlockShapeImpl.BuilderImpl var1);

        @dp_1
        public SolidState.Builder solidStateBuilder(SolidStateImpl.BuilderImpl var1);

        @dp_1
        public LiquidState.Builder liquidStateBuilder(LiquidStateImpl.BuilderImpl var1);

        @dp_1
        public VsiSolidShapeUtils solidShapeUtils(do_0 var1);

        @dp_1
        public VsiCore vsCore(VSCoreImpl var1);

        @dp_1
        public VSCoreInternal vsCoreInternal(VSCoreImpl var1);

        @dp_1
        public VsiCoreHooks hooks(EU var1);

        @dp_1
        public VsiBlockTypes blockTypes(DN var1);
    }
}

