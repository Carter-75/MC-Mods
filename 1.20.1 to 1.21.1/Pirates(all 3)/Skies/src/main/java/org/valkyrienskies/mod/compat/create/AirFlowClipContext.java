/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.simibubi.create.content.decoration.copycat.CopycatBlock
 *  net.minecraft.class_1922
 *  net.minecraft.class_1937
 *  net.minecraft.class_2338
 *  net.minecraft.class_243
 *  net.minecraft.class_259
 *  net.minecraft.class_265
 *  net.minecraft.class_2680
 *  net.minecraft.class_3959
 *  net.minecraft.class_3959$class_242
 *  net.minecraft.class_3959$class_3960
 */
package org.valkyrienskies.mod.compat.create;

import com.simibubi.create.content.decoration.copycat.CopycatBlock;
import java.util.function.Predicate;
import net.minecraft.class_1922;
import net.minecraft.class_1937;
import net.minecraft.class_2338;
import net.minecraft.class_243;
import net.minecraft.class_259;
import net.minecraft.class_265;
import net.minecraft.class_2680;
import net.minecraft.class_3959;
import org.valkyrienskies.core.api.ships.Ship;
import org.valkyrienskies.mod.common.VSGameUtilsKt;

public class AirFlowClipContext
extends class_3959 {
    private final class_1937 level;
    private final class_2338 source;
    private final Ship sourceShip;
    private final Predicate<class_2680> tester;

    public AirFlowClipContext(class_1937 level, class_2338 source, class_243 from, class_243 to2, Predicate<class_2680> tester) {
        super(from, to2, class_3959.class_3960.field_17558, class_3959.class_242.field_1348, null);
        this.level = level;
        this.source = source;
        this.sourceShip = VSGameUtilsKt.getShipManagingPos(level, source);
        this.tester = tester;
    }

    public class_265 method_17748(class_2680 state, class_1922 level, class_2338 pos) {
        if (this.sourceShip == VSGameUtilsKt.getShipManagingPos(this.level, pos)) {
            return class_259.method_1073();
        }
        class_2680 copycat = CopycatBlock.getMaterial((class_1922)level, (class_2338)pos);
        if (this.tester.test(copycat.method_26215() ? state : copycat)) {
            return class_259.method_1073();
        }
        return super.method_17748(state, level, pos);
    }
}

