/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.JvmStatic
 *  kotlin.jvm.internal.Intrinsics
 */
package org.valkyrienskies.core.internal;

import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.valkyrienskies.core.internal.VsiCoreClient;
import org.valkyrienskies.core.internal.VsiCoreServer;
import org.valkyrienskies.core.internal.hooks.VsiCoreHooksOut;

@Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u0000 \n2\u00020\u0001:\u0001\nJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&\u00a2\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0002H&\u00a2\u0006\u0004\b\b\u0010\t\u00f8\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001\u00a8\u0006\u000b\u00c0\u0006\u0001"}, d2={"Lorg/valkyrienskies/core/internal/VsiCoreFactory;", "", "Lorg/valkyrienskies/core/internal/hooks/VsiCoreHooksOut;", "hooks", "Lorg/valkyrienskies/core/internal/VsiCoreClient;", "newVsCoreClient", "(Lorg/valkyrienskies/core/internal/hooks/VsiCoreHooksOut;)Lorg/valkyrienskies/core/internal/VsiCoreClient;", "Lorg/valkyrienskies/core/internal/VsiCoreServer;", "newVsCoreServer", "(Lorg/valkyrienskies/core/internal/hooks/VsiCoreHooksOut;)Lorg/valkyrienskies/core/internal/VsiCoreServer;", "Companion", "internal"})
public interface VsiCoreFactory {
    @NotNull
    public static final Companion Companion = org.valkyrienskies.core.internal.VsiCoreFactory$Companion.$$INSTANCE;

    @NotNull
    public VsiCoreClient newVsCoreClient(@NotNull VsiCoreHooksOut var1);

    @NotNull
    public VsiCoreServer newVsCoreServer(@NotNull VsiCoreHooksOut var1);

    @NotNull
    public static VsiCoreFactory getInstance() {
        return Companion.getInstance();
    }

    @Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\t\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\n\u0010\tJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0002\u00a2\u0006\u0004\b\u0003\u0010\u0004R \u0010\u0005\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\u0012\n\u0004\b\u0005\u0010\u0006\u0012\u0004\b\b\u0010\t\u001a\u0004\b\u0007\u0010\u0004\u00a8\u0006\u000b"}, d2={"Lorg/valkyrienskies/core/internal/VsiCoreFactory$Companion;", "", "Lorg/valkyrienskies/core/internal/VsiCoreFactory;", "findInstance", "()Lorg/valkyrienskies/core/internal/VsiCoreFactory;", "instance", "Lorg/valkyrienskies/core/internal/VsiCoreFactory;", "getInstance", "getInstance$annotations", "()V", "<init>", "internal"})
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE;
        @NotNull
        private static final VsiCoreFactory instance;

        private Companion() {
        }

        @NotNull
        public final VsiCoreFactory getInstance() {
            return instance;
        }

        @JvmStatic
        public static /* synthetic */ void getInstance$annotations() {
        }

        private final VsiCoreFactory findInstance() {
            Object obj = Class.forName("org.valkyrienskies.core.impl.program.VsiCoreFactoryImpl").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
            Intrinsics.checkNotNull(obj, (String)"null cannot be cast to non-null type org.valkyrienskies.core.internal.VsiCoreFactory");
            return (VsiCoreFactory)obj;
        }

        static {
            $$INSTANCE = new Companion();
            instance = $$INSTANCE.findInstance();
        }
    }
}

