/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.util.Identifier
 *  net.minecraft.client.render.entity.model.EntityModelLayer
 */
package backported.updates.content.client.registries;

import net.minecraft.util.Identifier;
import net.minecraft.client.render.entity.model.EntityModelLayer;

public class ModModelLayers {
    public static final EntityModelLayer CREAKING = ModModelLayers.register("creaking");
    public static final EntityModelLayer PALE_OAK_BOAT = ModModelLayers.register("pale_oak_boat");
    public static final EntityModelLayer PALE_OAK_CHEST_BOAT = ModModelLayers.register("pale_oak_chest_boat");
    public static final EntityModelLayer COLD_PIG = ModModelLayers.register("cold_pig");
    public static final EntityModelLayer COLD_CHICKEN = ModModelLayers.register("cold_chicken");
    public static final EntityModelLayer COLD_COW = ModModelLayers.register("cold_cow");
    public static final EntityModelLayer WARM_COW = ModModelLayers.register("warm_cow");
    public static final EntityModelLayer HAPPY_GHAST = ModModelLayers.register("happy_ghast");
    public static final EntityModelLayer HAPPY_GHAST_HARNESS = ModModelLayers.register("happy_ghast", "harness");
    public static final EntityModelLayer HAPPY_GHAST_ROPES = ModModelLayers.register("happy_ghast", "ropes");

    private static EntityModelLayer register(String name) {
        return ModModelLayers.register(name, "main");
    }

    private static EntityModelLayer register(String name, String layer) {
        return new EntityModelLayer(Identifier.ofVanilla((String)name), layer);
    }
}

