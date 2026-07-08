/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.fabricmc.api.EnvType
 *  net.fabricmc.api.Environment
 *  net.minecraft.class_746
 *  org.jetbrains.annotations.Nullable
 */
package backported.updates.foundation.client.event;

import backported.updates.foundation.core.util.event.Event;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.class_746;
import org.jetbrains.annotations.Nullable;

@Environment(value=EnvType.CLIENT)
public interface LocalPlayerEvents {
    public static final Event<PlayerJoin> ON_LOGIN = Event.create(PlayerJoin.class);
    public static final Event<PlayerLeave> ON_LOGOUT = Event.create(PlayerLeave.class);
    public static final Event<PlayerRespawn> ON_RESPAWN = Event.create(PlayerRespawn.class);

    public static interface PlayerJoin {
        public void onLogin(class_746 var1);
    }

    public static interface PlayerLeave {
        public void onLogout(@Nullable class_746 var1);
    }

    public static interface PlayerRespawn {
        public void onRespawn(class_746 var1, class_746 var2);
    }
}

