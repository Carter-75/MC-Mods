/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.simibubi.create.foundation.blockEntity.behaviour.scrollValue.INamedIconOptions
 *  com.simibubi.create.foundation.blockEntity.behaviour.scrollValue.ScrollOptionBehaviour
 *  com.simibubi.create.foundation.gui.AllIcons
 *  net.createmod.catnip.lang.Lang
 */
package org.valkyrienskies.mod.mixinducks.mod_compat.create;

import com.simibubi.create.foundation.blockEntity.behaviour.scrollValue.INamedIconOptions;
import com.simibubi.create.foundation.blockEntity.behaviour.scrollValue.ScrollOptionBehaviour;
import com.simibubi.create.foundation.gui.AllIcons;
import net.createmod.catnip.lang.Lang;

public interface IDeployerBehavior {
    default public ScrollOptionBehaviour<WorkingMode> valkyrienskies$get_working_mode() {
        return null;
    }

    public static enum WorkingMode implements INamedIconOptions
    {
        ORIGINAL(AllIcons.I_MOVE_PLACE),
        IN_WORLD(AllIcons.I_MOVE_PLACE_RETURNED);

        private String translationKey;
        private AllIcons icon;

        private WorkingMode(AllIcons icon) {
            this.icon = icon;
            this.translationKey = "misc.valkyrienskies.create.deployer_working_mode." + Lang.asId((String)this.name());
        }

        public AllIcons getIcon() {
            return this.icon;
        }

        public String getTranslationKey() {
            return this.translationKey;
        }
    }
}

