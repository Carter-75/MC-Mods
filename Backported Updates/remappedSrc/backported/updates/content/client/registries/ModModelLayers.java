/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_2960
 *  net.minecraft.class_5601
 */
package backported.updates.content.client.registries;

import net.minecraft.class_2960;
import net.minecraft.class_5601;

public class ModModelLayers {
    public static final class_5601 CREAKING = ModModelLayers.register("creaking");
    public static final class_5601 PALE_OAK_BOAT = ModModelLayers.register("pale_oak_boat");
    public static final class_5601 PALE_OAK_CHEST_BOAT = ModModelLayers.register("pale_oak_chest_boat");
    public static final class_5601 COLD_PIG = ModModelLayers.register("cold_pig");
    public static final class_5601 COLD_CHICKEN = ModModelLayers.register("cold_chicken");
    public static final class_5601 COLD_COW = ModModelLayers.register("cold_cow");
    public static final class_5601 WARM_COW = ModModelLayers.register("warm_cow");
    public static final class_5601 HAPPY_GHAST = ModModelLayers.register("happy_ghast");
    public static final class_5601 HAPPY_GHAST_HARNESS = ModModelLayers.register("happy_ghast", "harness");
    public static final class_5601 HAPPY_GHAST_ROPES = ModModelLayers.register("happy_ghast", "ropes");

    private static class_5601 register(String name) {
        return ModModelLayers.register(name, "main");
    }

    private static class_5601 register(String name, String layer) {
        return new class_5601(class_2960.method_60656((String)name), layer);
    }
}

