/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.datafixers.util.Pair
 *  net.fabricmc.api.EnvType
 *  net.fabricmc.api.Environment
 *  net.minecraft.class_1690
 *  net.minecraft.class_2960
 *  net.minecraft.class_4595
 *  net.minecraft.class_554
 *  net.minecraft.class_5617$class_5618
 *  net.minecraft.class_7752
 *  net.minecraft.class_881
 */
package backported.updates.content.client.level.entities.renderer;

import backported.updates.content.client.registries.ModModelLayers;
import backported.updates.foundation.client.api.model.CustomBoatModel;
import com.mojang.datafixers.util.Pair;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.class_1690;
import net.minecraft.class_2960;
import net.minecraft.class_4595;
import net.minecraft.class_554;
import net.minecraft.class_5617;
import net.minecraft.class_7752;
import net.minecraft.class_881;

@Environment(value=EnvType.CLIENT)
public class PaleOakBoatRenderer
extends class_881
implements CustomBoatModel {
    private static final class_2960 PALE_OAK_BOAT = class_2960.method_60656((String)"textures/entity/boat/pale_oak.png");
    private static final class_2960 PALE_OAK_CHEST_BOAT = class_2960.method_60656((String)"textures/entity/chest_boat/pale_oak.png");
    private final Pair<class_2960, class_4595<class_1690>> boatResource;

    public PaleOakBoatRenderer(class_5617.class_5618 context, boolean chestBoat) {
        super(context, chestBoat);
        this.boatResource = Pair.of((Object)(chestBoat ? PALE_OAK_CHEST_BOAT : PALE_OAK_BOAT), (Object)(chestBoat ? new class_7752(context.method_32167(ModModelLayers.PALE_OAK_CHEST_BOAT)) : new class_554(context.method_32167(ModModelLayers.PALE_OAK_BOAT))));
    }

    @Override
    public Pair<class_2960, class_4595<class_1690>> getModelWithLocation(class_1690 boat) {
        return this.boatResource;
    }
}

