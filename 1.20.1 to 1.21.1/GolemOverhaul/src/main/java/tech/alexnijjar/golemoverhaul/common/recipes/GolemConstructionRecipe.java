/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.gson.JsonArray
 *  com.google.gson.JsonElement
 *  com.google.gson.JsonObject
 *  net.minecraft.class_1299
 *  net.minecraft.class_1792
 *  net.minecraft.class_1799
 *  net.minecraft.class_1860
 *  net.minecraft.class_1865
 *  net.minecraft.class_1937
 *  net.minecraft.class_2248
 *  net.minecraft.class_2540
 *  net.minecraft.class_2694
 *  net.minecraft.class_2697
 *  net.minecraft.class_2700
 *  net.minecraft.class_2715
 *  net.minecraft.class_2960
 *  net.minecraft.class_3518
 *  net.minecraft.class_3956
 *  net.minecraft.class_5321
 *  net.minecraft.class_5455
 *  net.minecraft.class_7923
 *  net.minecraft.class_7924
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package tech.alexnijjar.golemoverhaul.common.recipes;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;
import net.minecraft.class_1299;
import net.minecraft.class_1792;
import net.minecraft.class_1799;
import net.minecraft.class_1860;
import net.minecraft.class_1865;
import net.minecraft.class_1937;
import net.minecraft.class_2248;
import net.minecraft.class_2540;
import net.minecraft.class_2694;
import net.minecraft.class_2697;
import net.minecraft.class_2700;
import net.minecraft.class_2715;
import net.minecraft.class_2960;
import net.minecraft.class_3518;
import net.minecraft.class_3956;
import net.minecraft.class_5321;
import net.minecraft.class_5455;
import net.minecraft.class_7923;
import net.minecraft.class_7924;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tech.alexnijjar.golemoverhaul.common.recipes.SingleEntityInput;

public class GolemConstructionRecipe
implements class_1860<SingleEntityInput> {
    private final class_2960 id;
    private final List<String> pattern;
    private final Map<String, class_5321<class_2248>> key;
    private final class_5321<class_1299<?>> entity;
    private final class_5321<class_1792> item;
    private final boolean visualOnly;
    private final float blockScale;
    private final float entityScale;

    public GolemConstructionRecipe(class_2960 id, List<String> pattern, Map<String, class_5321<class_2248>> key, class_5321<class_1299<?>> entity, class_5321<class_1792> item, boolean visualOnly, float blockScale, float entityScale) {
        this.id = id;
        this.pattern = pattern;
        this.key = key;
        this.entity = entity;
        this.item = item;
        this.visualOnly = visualOnly;
        this.blockScale = blockScale;
        this.entityScale = entityScale;
    }

    public boolean matches(SingleEntityInput input, @NotNull class_1937 level) {
        Optional key = class_7923.field_41177.method_29113(input.entity());
        return key.isPresent() && ((class_5321)key.get()).equals(this.entity);
    }

    @NotNull
    public class_1799 assemble(@NotNull SingleEntityInput container, @NotNull class_5455 registryAccess) {
        return class_1799.field_8037;
    }

    public boolean method_8113(int width, int height) {
        return true;
    }

    @NotNull
    public class_1799 method_8110(@NotNull class_5455 registryAccess) {
        return class_1799.field_8037;
    }

    @NotNull
    public class_2960 method_8114() {
        return this.id;
    }

    @NotNull
    public class_1865<?> method_8119() {
        return Serializer.INSTANCE;
    }

    @NotNull
    public class_3956<?> method_17716() {
        return Type.INSTANCE;
    }

    public boolean method_8118() {
        return true;
    }

    public class_2700 createPattern() {
        class_2697 builder = class_2697.method_11701();
        builder.method_11702(this.pattern.toArray(new String[0]));
        this.key.forEach((key, block_key) -> builder.method_11700(key.charAt(0), class_2694.method_11678((Predicate)class_2715.method_11758((class_2248)Objects.requireNonNull((class_2248)class_7923.field_41175.method_29107(block_key))))));
        return builder.method_11704();
    }

    public Map<String, class_5321<class_2248>> getKey() {
        return this.key;
    }

    public class_5321<class_1792> getItem() {
        return this.item;
    }

    public float getBlockScale() {
        return this.blockScale;
    }

    public float getEntityScale() {
        return this.entityScale;
    }

    public List<String> getPattern() {
        return this.pattern;
    }

    public class_5321<class_1299<?>> getEntity() {
        return this.entity;
    }

    public static class Serializer
    implements class_1865<GolemConstructionRecipe> {
        public static final Serializer INSTANCE = new Serializer();

        @NotNull
        public GolemConstructionRecipe fromJson(@NotNull class_2960 recipeId, @NotNull JsonObject serializedRecipe) {
            JsonArray patternJson = class_3518.method_15261((JsonObject)serializedRecipe, (String)"pattern");
            List<String> pattern = StreamSupport.stream(patternJson.spliterator(), false).map(element -> class_3518.method_15287((JsonElement)element, (String)"pattern entry")).collect(Collectors.toList());
            JsonObject keyJson = class_3518.method_15296((JsonObject)serializedRecipe, (String)"key");
            Map<String, class_5321<class_2248>> key = keyJson.entrySet().stream().collect(Collectors.toMap(Map.Entry::getKey, entry -> {
                class_2960 blockId = new class_2960(class_3518.method_15287((JsonElement)((JsonElement)entry.getValue()), (String)"key value"));
                return class_5321.method_29179((class_5321)class_7924.field_41254, (class_2960)blockId);
            }));
            class_2960 entityId = new class_2960(class_3518.method_15265((JsonObject)serializedRecipe, (String)"entity"));
            class_5321 entity = class_5321.method_29179((class_5321)class_7924.field_41266, (class_2960)entityId);
            class_2960 itemId = new class_2960(class_3518.method_15265((JsonObject)serializedRecipe, (String)"item"));
            class_5321 item = class_5321.method_29179((class_5321)class_7924.field_41197, (class_2960)itemId);
            boolean visualOnly = class_3518.method_15258((JsonObject)serializedRecipe, (String)"visualOnly", (boolean)false);
            float blockScale = class_3518.method_15277((JsonObject)serializedRecipe, (String)"blockScale", (float)1.0f);
            float entityScale = class_3518.method_15277((JsonObject)serializedRecipe, (String)"entityScale", (float)1.0f);
            return new GolemConstructionRecipe(recipeId, pattern, key, entity, (class_5321<class_1792>)item, visualOnly, blockScale, entityScale);
        }

        @Nullable
        public GolemConstructionRecipe fromNetwork(@NotNull class_2960 recipeId, @NotNull class_2540 buffer) {
            List pattern = buffer.method_34066(class_2540::method_19772);
            Map key = buffer.method_34067(class_2540::method_19772, buf -> class_5321.method_29179((class_5321)class_7924.field_41254, (class_2960)buf.method_10810()));
            class_5321 entity = class_5321.method_29179((class_5321)class_7924.field_41266, (class_2960)buffer.method_10810());
            class_5321 item = class_5321.method_29179((class_5321)class_7924.field_41197, (class_2960)buffer.method_10810());
            boolean visualOnly = buffer.readBoolean();
            float blockScale = buffer.readFloat();
            float entityScale = buffer.readFloat();
            return new GolemConstructionRecipe(recipeId, pattern, key, entity, (class_5321<class_1792>)item, visualOnly, blockScale, entityScale);
        }

        public void toNetwork(@NotNull class_2540 buffer, @NotNull GolemConstructionRecipe recipe) {
            buffer.method_34062(recipe.pattern, class_2540::method_10814);
            buffer.method_34063(recipe.key, class_2540::method_10814, (buf, resourceKey) -> buf.method_10812(resourceKey.method_29177()));
            buffer.method_10812(recipe.entity.method_29177());
            buffer.method_10812(recipe.item.method_29177());
            buffer.writeBoolean(recipe.visualOnly);
            buffer.writeFloat(recipe.blockScale);
            buffer.writeFloat(recipe.entityScale);
        }
    }

    public static class Type
    implements class_3956<GolemConstructionRecipe> {
        public static final Type INSTANCE = new Type();
    }
}

