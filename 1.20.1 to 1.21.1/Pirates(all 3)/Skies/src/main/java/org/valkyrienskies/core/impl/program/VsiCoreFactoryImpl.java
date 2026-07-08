/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.netty.buffer.ByteBuf
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.functions.Function2
 *  kotlin.jvm.internal.Intrinsics
 */
package org.valkyrienskies.core.impl.program;

import io.netty.buffer.ByteBuf;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.valkyrienskies.core.impl.program.DaggerVSCoreClientFactory;
import org.valkyrienskies.core.impl.program.DaggerVSCoreServerFactory;
import org.valkyrienskies.core.impl.program.VSCoreClientImpl;
import org.valkyrienskies.core.impl.program.VSCoreModule;
import org.valkyrienskies.core.impl.program.VSCoreServerImpl;
import org.valkyrienskies.core.impl.shadow.EV;
import org.valkyrienskies.core.impl.shadow.EY;
import org.valkyrienskies.core.impl.shadow.fj_0;
import org.valkyrienskies.core.internal.VsiCoreClient;
import org.valkyrienskies.core.internal.VsiCoreFactory;
import org.valkyrienskies.core.internal.VsiCoreServer;
import org.valkyrienskies.core.internal.hooks.VsiCoreHooksOut;
import org.valkyrienskies.core.internal.world.VsiPlayer;

@Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a2\u0006\u0004\b\b\u0010\tJ\u0017\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a2\u0006\u0004\b\u000b\u0010\f"}, d2={"Lorg/valkyrienskies/core/impl/program/VsiCoreFactoryImpl;", "Lorg/valkyrienskies/core/internal/VsiCoreFactory;", "Lorg/valkyrienskies/core/internal/hooks/VsiCoreHooksOut;", "hooks", "Lorg/valkyrienskies/core/impl/program/VSCoreModule;", "makeModule", "(Lorg/valkyrienskies/core/internal/hooks/VsiCoreHooksOut;)Lorg/valkyrienskies/core/impl/program/VSCoreModule;", "Lorg/valkyrienskies/core/internal/VsiCoreClient;", "newVsCoreClient", "(Lorg/valkyrienskies/core/internal/hooks/VsiCoreHooksOut;)Lorg/valkyrienskies/core/internal/VsiCoreClient;", "Lorg/valkyrienskies/core/internal/VsiCoreServer;", "newVsCoreServer", "(Lorg/valkyrienskies/core/internal/hooks/VsiCoreHooksOut;)Lorg/valkyrienskies/core/internal/VsiCoreServer;", "<init>", "()V"})
public final class VsiCoreFactoryImpl
implements VsiCoreFactory {
    @Override
    public final VsiCoreClient newVsCoreClient(VsiCoreHooksOut hooks) {
        VSCoreClientImpl vSCoreClientImpl;
        Intrinsics.checkNotNullParameter((Object)hooks, (String)"");
        vSCoreClientImpl = DaggerVSCoreClientFactory.builder().vSCoreModule(this.makeModule((VsiCoreHooksOut)((Object)vSCoreClientImpl))).build().client();
        EV.a(vSCoreClientImpl.getHooks());
        return vSCoreClientImpl;
    }

    @Override
    public final VsiCoreServer newVsCoreServer(VsiCoreHooksOut hooks) {
        VSCoreServerImpl vSCoreServerImpl;
        Intrinsics.checkNotNullParameter((Object)hooks, (String)"");
        vSCoreServerImpl = DaggerVSCoreServerFactory.builder().vSCoreModule(this.makeModule((VsiCoreHooksOut)((Object)vSCoreServerImpl))).build().server();
        EV.a(vSCoreServerImpl.getHooks());
        return vSCoreServerImpl;
    }

    /*
     * WARNING - void declaration
     */
    private final VSCoreModule makeModule(VsiCoreHooksOut hooks) {
        void var1_1;
        fj_0 fj_02 = arg_0 -> VsiCoreFactoryImpl.makeModule$lambda$0(hooks, arg_0);
        return new VSCoreModule((VsiCoreHooksOut)var1_1, fj_02, null, 4, null);
    }

    /*
     * WARNING - void declaration
     */
    private static final void makeModule$lambda$0(VsiCoreHooksOut $hooks, EY it) {
        VsiCoreHooksOut vsiCoreHooksOut;
        void var1_1;
        Intrinsics.checkNotNullParameter((Object)it, (String)"");
        it.a((Function1<? super ByteBuf, Unit>)((Function1)new Function1<ByteBuf, Unit>((Object)$hooks){
            {
                void var1_1;
            }

            public final void invoke(ByteBuf p0) {
                Intrinsics.checkNotNullParameter((Object)p0, (String)"");
                ((VsiCoreHooksOut)this.receiver).sendToServer(p0);
            }
        }));
        var1_1.a((Function2<? super ByteBuf, ? super VsiPlayer, Unit>)((Function2)new Function2<ByteBuf, VsiPlayer, Unit>((Object)vsiCoreHooksOut){
            {
                void var1_1;
            }

            public final void invoke(ByteBuf p0, VsiPlayer p1) {
                Intrinsics.checkNotNullParameter((Object)p0, (String)"");
                Intrinsics.checkNotNullParameter((Object)p1, (String)"");
                ((VsiCoreHooksOut)this.receiver).sendToClient(p0, p1);
            }
        }));
    }
}

