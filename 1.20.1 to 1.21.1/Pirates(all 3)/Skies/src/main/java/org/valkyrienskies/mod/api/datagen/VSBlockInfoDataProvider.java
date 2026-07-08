/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.gson.JsonArray
 *  com.google.gson.JsonElement
 *  com.google.gson.JsonObject
 *  com.google.gson.JsonPrimitive
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  net.minecraft.class_2248
 *  net.minecraft.class_2405
 *  net.minecraft.class_2960
 *  net.minecraft.class_6862
 *  net.minecraft.class_7403
 *  net.minecraft.class_7784
 */
package org.valkyrienskies.mod.api.datagen;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import net.minecraft.class_2248;
import net.minecraft.class_2405;
import net.minecraft.class_2960;
import net.minecraft.class_6862;
import net.minecraft.class_7403;
import net.minecraft.class_7784;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b&\u0018\u00002\u00020\u0001:\u0001-B\u0017\u0012\u0006\u0010\u001f\u001a\u00020\u001e\u0012\u0006\u0010#\u001a\u00020\u001b\u00a2\u0006\u0004\b+\u0010,J\u000f\u0010\u0003\u001a\u00020\u0002H$\u00a2\u0006\u0004\b\u0003\u0010\u0004JG\u0010\r\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0004\u00a2\u0006\u0004\b\r\u0010\u000eJG\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0004\u00a2\u0006\u0004\b\u000f\u0010\u000eJG\u0010\r\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u00102\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0004\u00a2\u0006\u0004\b\r\u0010\u0012JM\u0010\u000f\u001a\u00020\u00022\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00100\u00132\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0004\u00a2\u0006\u0004\b\u000f\u0010\u0015J\u001b\u0010\u0019\u001a\u0006\u0012\u0002\b\u00030\u00182\u0006\u0010\u0017\u001a\u00020\u0016H\u0016\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\u000f\u0010\u001c\u001a\u00020\u001bH\u0016\u00a2\u0006\u0004\b\u001c\u0010\u001dR\u0017\u0010\u001f\u001a\u00020\u001e8\u0006\u00a2\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"R\u0017\u0010#\u001a\u00020\u001b8\u0006\u00a2\u0006\f\n\u0004\b#\u0010$\u001a\u0004\b%\u0010\u001dR0\u0010)\u001a\u001e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020'0&j\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020'`(8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b)\u0010*\u00a8\u0006."}, d2={"Lorg/valkyrienskies/mod/api/datagen/VSBlockInfoDataProvider;", "Lnet/minecraft/class_2405;", "", "registerEntries", "()V", "Lnet/minecraft/class_2960;", "id", "", "mass", "friction", "elasticity", "", "priority", "addBlock", "(Lnet/minecraft/class_2960;Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/Integer;)V", "addBlockTag", "Lnet/minecraft/class_2248;", "block", "(Lnet/minecraft/class_2248;Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/Integer;)V", "Lnet/minecraft/class_6862;", "tag", "(Lnet/minecraft/class_6862;Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/Integer;)V", "Lnet/minecraft/class_7403;", "cachedOutput", "Ljava/util/concurrent/CompletableFuture;", "run", "(Lnet/minecraft/class_7403;)Ljava/util/concurrent/CompletableFuture;", "", "getName", "()Ljava/lang/String;", "Lnet/minecraft/class_7784;", "output", "Lnet/minecraft/class_7784;", "getOutput", "()Lnet/minecraft/class_7784;", "modId", "Ljava/lang/String;", "getModId", "Ljava/util/HashMap;", "Lorg/valkyrienskies/mod/api/datagen/VSBlockInfoDataProvider$Info;", "Lkotlin/collections/HashMap;", "entries", "Ljava/util/HashMap;", "<init>", "(Lnet/minecraft/class_7784;Ljava/lang/String;)V", "Info", "valkyrienskies-120"})
@SourceDebugExtension(value={"SMAP\nVSBlockInfoDataProvider.kt\nKotlin\n*S Kotlin\n*F\n+ 1 VSBlockInfoDataProvider.kt\norg/valkyrienskies/mod/api/datagen/VSBlockInfoDataProvider\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Maps.kt\nkotlin/collections/MapsKt___MapsKt\n*L\n1#1,149:1\n1#2:150\n216#3,2:151\n*S KotlinDebug\n*F\n+ 1 VSBlockInfoDataProvider.kt\norg/valkyrienskies/mod/api/datagen/VSBlockInfoDataProvider\n*L\n118#1:151,2\n*E\n"})
public abstract class VSBlockInfoDataProvider
implements class_2405 {
    @NotNull
    private final class_7784 output;
    @NotNull
    private final String modId;
    @NotNull
    private final HashMap<class_2960, Info> entries;

    public VSBlockInfoDataProvider(@NotNull class_7784 output, @NotNull String modId) {
        Intrinsics.checkNotNullParameter((Object)output, (String)"output");
        Intrinsics.checkNotNullParameter((Object)modId, (String)"modId");
        this.output = output;
        this.modId = modId;
        this.entries = new HashMap();
    }

    @NotNull
    public final class_7784 getOutput() {
        return this.output;
    }

    @NotNull
    public final String getModId() {
        return this.modId;
    }

    protected abstract void registerEntries();

    protected final void addBlock(@NotNull class_2960 id, @Nullable Double mass, @Nullable Double friction, @Nullable Double elasticity, @Nullable Integer priority) {
        Intrinsics.checkNotNullParameter((Object)id, (String)"id");
        Info info = this.entries.get(id);
        if (info != null) {
            Info it = info;
            boolean bl = false;
            throw new RuntimeException("Duplicate Block Into Entries for " + id);
        }
        ((Map)this.entries).put(id, new Info(false, mass, friction, elasticity, priority));
    }

    public static /* synthetic */ void addBlock$default(VSBlockInfoDataProvider vSBlockInfoDataProvider, class_2960 class_29602, Double d2, Double d3, Double d4, Integer n2, int n3, Object object) {
        if (object != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: addBlock");
        }
        if ((n3 & 2) != 0) {
            d2 = null;
        }
        if ((n3 & 4) != 0) {
            d3 = null;
        }
        if ((n3 & 8) != 0) {
            d4 = null;
        }
        if ((n3 & 0x10) != 0) {
            n2 = null;
        }
        vSBlockInfoDataProvider.addBlock(class_29602, d2, d3, d4, n2);
    }

    protected final void addBlockTag(@NotNull class_2960 id, @Nullable Double mass, @Nullable Double friction, @Nullable Double elasticity, @Nullable Integer priority) {
        Intrinsics.checkNotNullParameter((Object)id, (String)"id");
        Info info = this.entries.get(id);
        if (info != null) {
            Info it = info;
            boolean bl = false;
            throw new RuntimeException("Duplicate Block Into Entries for " + id);
        }
        ((Map)this.entries).put(id, new Info(true, mass, friction, elasticity, priority));
    }

    public static /* synthetic */ void addBlockTag$default(VSBlockInfoDataProvider vSBlockInfoDataProvider, class_2960 class_29602, Double d2, Double d3, Double d4, Integer n2, int n3, Object object) {
        if (object != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: addBlockTag");
        }
        if ((n3 & 2) != 0) {
            d2 = null;
        }
        if ((n3 & 4) != 0) {
            d3 = null;
        }
        if ((n3 & 8) != 0) {
            d4 = null;
        }
        if ((n3 & 0x10) != 0) {
            n2 = null;
        }
        vSBlockInfoDataProvider.addBlockTag(class_29602, d2, d3, d4, n2);
    }

    protected final void addBlock(@NotNull class_2248 block, @Nullable Double mass, @Nullable Double friction, @Nullable Double elasticity, @Nullable Integer priority) {
        Intrinsics.checkNotNullParameter((Object)block, (String)"block");
        class_2960 class_29602 = block.method_40142().method_40237().method_29177();
        Intrinsics.checkNotNullExpressionValue((Object)class_29602, (String)"location(...)");
        this.addBlock(class_29602, mass, friction, elasticity, priority);
    }

    public static /* synthetic */ void addBlock$default(VSBlockInfoDataProvider vSBlockInfoDataProvider, class_2248 class_22482, Double d2, Double d3, Double d4, Integer n2, int n3, Object object) {
        if (object != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: addBlock");
        }
        if ((n3 & 2) != 0) {
            d2 = null;
        }
        if ((n3 & 4) != 0) {
            d3 = null;
        }
        if ((n3 & 8) != 0) {
            d4 = null;
        }
        if ((n3 & 0x10) != 0) {
            n2 = null;
        }
        vSBlockInfoDataProvider.addBlock(class_22482, d2, d3, d4, n2);
    }

    protected final void addBlockTag(@NotNull class_6862<class_2248> tag, @Nullable Double mass, @Nullable Double friction, @Nullable Double elasticity, @Nullable Integer priority) {
        Intrinsics.checkNotNullParameter(tag, (String)"tag");
        class_2960 class_29602 = tag.comp_327();
        Intrinsics.checkNotNullExpressionValue((Object)class_29602, (String)"location(...)");
        this.addBlockTag(class_29602, mass, friction, elasticity, priority);
    }

    public static /* synthetic */ void addBlockTag$default(VSBlockInfoDataProvider vSBlockInfoDataProvider, class_6862 class_68622, Double d2, Double d3, Double d4, Integer n2, int n3, Object object) {
        if (object != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: addBlockTag");
        }
        if ((n3 & 2) != 0) {
            d2 = null;
        }
        if ((n3 & 4) != 0) {
            d3 = null;
        }
        if ((n3 & 8) != 0) {
            d4 = null;
        }
        if ((n3 & 0x10) != 0) {
            n2 = null;
        }
        vSBlockInfoDataProvider.addBlockTag((class_6862<class_2248>)class_68622, d2, d3, d4, n2);
    }

    @NotNull
    public CompletableFuture<?> method_10319(@NotNull class_7403 cachedOutput) {
        Intrinsics.checkNotNullParameter((Object)cachedOutput, (String)"cachedOutput");
        CompletableFuture completableFuture = CompletableFuture.supplyAsync(() -> VSBlockInfoDataProvider.run$lambda$3(this, cachedOutput)).get();
        Intrinsics.checkNotNullExpressionValue((Object)completableFuture, (String)"get(...)");
        return completableFuture;
    }

    @NotNull
    public String method_10321() {
        return "VS Block Info Data Provider: " + this.modId + ".json";
    }

    private static final CompletableFuture run$lambda$3(VSBlockInfoDataProvider this$0, class_7403 $cachedOutput) {
        Intrinsics.checkNotNullParameter((Object)this$0, (String)"this$0");
        Intrinsics.checkNotNullParameter((Object)$cachedOutput, (String)"$cachedOutput");
        Path path = this$0.output.method_45971().resolve("data").resolve("valkyrienskies").resolve("vs_mass").resolve(this$0.modId + ".json");
        this$0.registerEntries();
        try {
            JsonArray array = new JsonArray(this$0.entries.size());
            Map $this$forEach$iv = this$0.entries;
            boolean $i$f$forEach = false;
            Iterator iterator2 = $this$forEach$iv.entrySet().iterator();
            while (iterator2.hasNext()) {
                Map.Entry element$iv;
                Map.Entry entry = element$iv = iterator2.next();
                boolean bl = false;
                class_2960 id = (class_2960)entry.getKey();
                Info info = (Info)entry.getValue();
                array.add((JsonElement)info.toJson(id));
            }
            return class_2405.method_10320((class_7403)$cachedOutput, (JsonElement)((JsonElement)array), (Path)path);
        }
        catch (Exception e2) {
            throw new RuntimeException("Failed to save " + path, e2);
        }
    }

    @Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0010\u000e\n\u0002\b\r\b\u0082\b\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\u0012\u001a\u00020\u0007\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\n\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\n\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\n\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u000f\u00a2\u0006\u0004\b)\u0010*J\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\b\u001a\u00020\u0007H\u00c6\u0003\u00a2\u0006\u0004\b\b\u0010\tJ\u0012\u0010\u000b\u001a\u0004\u0018\u00010\nH\u00c6\u0003\u00a2\u0006\u0004\b\u000b\u0010\fJ\u0012\u0010\r\u001a\u0004\u0018\u00010\nH\u00c6\u0003\u00a2\u0006\u0004\b\r\u0010\fJ\u0012\u0010\u000e\u001a\u0004\u0018\u00010\nH\u00c6\u0003\u00a2\u0006\u0004\b\u000e\u0010\fJ\u0012\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u00c6\u0003\u00a2\u0006\u0004\b\u0010\u0010\u0011JJ\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0012\u001a\u00020\u00072\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u000fH\u00c6\u0001\u00a2\u0006\u0004\b\u0017\u0010\u0018J\u001a\u0010\u001a\u001a\u00020\u00072\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\u001c\u001a\u00020\u000fH\u00d6\u0001\u00a2\u0006\u0004\b\u001c\u0010\u001dJ\u0010\u0010\u001f\u001a\u00020\u001eH\u00d6\u0001\u00a2\u0006\u0004\b\u001f\u0010 R\u0017\u0010\u0012\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\u0012\u0010!\u001a\u0004\b\"\u0010\tR\u0019\u0010\u0013\u001a\u0004\u0018\u00010\n8\u0006\u00a2\u0006\f\n\u0004\b\u0013\u0010#\u001a\u0004\b$\u0010\fR\u0019\u0010\u0014\u001a\u0004\u0018\u00010\n8\u0006\u00a2\u0006\f\n\u0004\b\u0014\u0010#\u001a\u0004\b%\u0010\fR\u0019\u0010\u0015\u001a\u0004\u0018\u00010\n8\u0006\u00a2\u0006\f\n\u0004\b\u0015\u0010#\u001a\u0004\b&\u0010\fR\u0019\u0010\u0016\u001a\u0004\u0018\u00010\u000f8\u0006\u00a2\u0006\f\n\u0004\b\u0016\u0010'\u001a\u0004\b(\u0010\u0011\u00a8\u0006+"}, d2={"Lorg/valkyrienskies/mod/api/datagen/VSBlockInfoDataProvider$Info;", "", "Lnet/minecraft/class_2960;", "id", "Lcom/google/gson/JsonObject;", "toJson", "(Lnet/minecraft/class_2960;)Lcom/google/gson/JsonObject;", "", "component1", "()Z", "", "component2", "()Ljava/lang/Double;", "component3", "component4", "", "component5", "()Ljava/lang/Integer;", "tag", "mass", "friction", "elasticity", "priority", "copy", "(ZLjava/lang/Double;Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/Integer;)Lorg/valkyrienskies/mod/api/datagen/VSBlockInfoDataProvider$Info;", "other", "equals", "(Ljava/lang/Object;)Z", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "Z", "getTag", "Ljava/lang/Double;", "getMass", "getFriction", "getElasticity", "Ljava/lang/Integer;", "getPriority", "<init>", "(ZLjava/lang/Double;Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/Integer;)V", "valkyrienskies-120"})
    @SourceDebugExtension(value={"SMAP\nVSBlockInfoDataProvider.kt\nKotlin\n*S Kotlin\n*F\n+ 1 VSBlockInfoDataProvider.kt\norg/valkyrienskies/mod/api/datagen/VSBlockInfoDataProvider$Info\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,149:1\n1#2:150\n*E\n"})
    private static final class Info {
        private final boolean tag;
        @Nullable
        private final Double mass;
        @Nullable
        private final Double friction;
        @Nullable
        private final Double elasticity;
        @Nullable
        private final Integer priority;

        public Info(boolean tag, @Nullable Double mass, @Nullable Double friction, @Nullable Double elasticity, @Nullable Integer priority) {
            this.tag = tag;
            this.mass = mass;
            this.friction = friction;
            this.elasticity = elasticity;
            this.priority = priority;
        }

        public final boolean getTag() {
            return this.tag;
        }

        @Nullable
        public final Double getMass() {
            return this.mass;
        }

        @Nullable
        public final Double getFriction() {
            return this.friction;
        }

        @Nullable
        public final Double getElasticity() {
            return this.elasticity;
        }

        @Nullable
        public final Integer getPriority() {
            return this.priority;
        }

        @NotNull
        public final JsonObject toJson(@NotNull class_2960 id) {
            JsonObject obj;
            block3: {
                double d2;
                Intrinsics.checkNotNullParameter((Object)id, (String)"id");
                obj = new JsonObject();
                obj.add(this.tag ? "tag" : "block", (JsonElement)new JsonPrimitive(id.toString()));
                Double d3 = this.mass;
                if (d3 != null) {
                    d2 = ((Number)d3).doubleValue();
                    boolean bl = false;
                    obj.add("mass", (JsonElement)new JsonPrimitive((Number)d2));
                }
                Double d4 = this.friction;
                if (d4 != null) {
                    d2 = ((Number)d4).doubleValue();
                    boolean bl = false;
                    obj.add("friction", (JsonElement)new JsonPrimitive((Number)d2));
                }
                Double d5 = this.elasticity;
                if (d5 != null) {
                    d2 = ((Number)d5).doubleValue();
                    boolean bl = false;
                    obj.add("elasticity", (JsonElement)new JsonPrimitive((Number)d2));
                }
                Integer n2 = this.priority;
                if (n2 == null) break block3;
                int d6 = ((Number)n2).intValue();
                boolean bl = false;
                obj.add("priority", (JsonElement)new JsonPrimitive((Number)d6));
            }
            return obj;
        }

        public final boolean component1() {
            return this.tag;
        }

        @Nullable
        public final Double component2() {
            return this.mass;
        }

        @Nullable
        public final Double component3() {
            return this.friction;
        }

        @Nullable
        public final Double component4() {
            return this.elasticity;
        }

        @Nullable
        public final Integer component5() {
            return this.priority;
        }

        @NotNull
        public final Info copy(boolean tag, @Nullable Double mass, @Nullable Double friction, @Nullable Double elasticity, @Nullable Integer priority) {
            return new Info(tag, mass, friction, elasticity, priority);
        }

        public static /* synthetic */ Info copy$default(Info info, boolean bl, Double d2, Double d3, Double d4, Integer n2, int n3, Object object) {
            if ((n3 & 1) != 0) {
                bl = info.tag;
            }
            if ((n3 & 2) != 0) {
                d2 = info.mass;
            }
            if ((n3 & 4) != 0) {
                d3 = info.friction;
            }
            if ((n3 & 8) != 0) {
                d4 = info.elasticity;
            }
            if ((n3 & 0x10) != 0) {
                n2 = info.priority;
            }
            return info.copy(bl, d2, d3, d4, n2);
        }

        @NotNull
        public String toString() {
            return "Info(tag=" + this.tag + ", mass=" + this.mass + ", friction=" + this.friction + ", elasticity=" + this.elasticity + ", priority=" + this.priority + ")";
        }

        public int hashCode() {
            int result2 = Boolean.hashCode(this.tag);
            result2 = result2 * 31 + (this.mass == null ? 0 : ((Object)this.mass).hashCode());
            result2 = result2 * 31 + (this.friction == null ? 0 : ((Object)this.friction).hashCode());
            result2 = result2 * 31 + (this.elasticity == null ? 0 : ((Object)this.elasticity).hashCode());
            result2 = result2 * 31 + (this.priority == null ? 0 : ((Object)this.priority).hashCode());
            return result2;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Info)) {
                return false;
            }
            Info info = (Info)other;
            if (this.tag != info.tag) {
                return false;
            }
            if (!Intrinsics.areEqual((Object)this.mass, (Object)info.mass)) {
                return false;
            }
            if (!Intrinsics.areEqual((Object)this.friction, (Object)info.friction)) {
                return false;
            }
            if (!Intrinsics.areEqual((Object)this.elasticity, (Object)info.elasticity)) {
                return false;
            }
            return Intrinsics.areEqual((Object)this.priority, (Object)info.priority);
        }
    }
}

