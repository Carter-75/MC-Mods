/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.gson.JsonElement
 *  com.google.gson.JsonObject
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  net.minecraft.class_1299
 *  net.minecraft.class_2405
 *  net.minecraft.class_2960
 *  net.minecraft.class_7403
 *  net.minecraft.class_7784
 */
package org.valkyrienskies.mod.api.datagen;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import net.minecraft.class_1299;
import net.minecraft.class_2405;
import net.minecraft.class_2960;
import net.minecraft.class_7403;
import net.minecraft.class_7784;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b&\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0015\u001a\u00020\u0014\u0012\u0006\u0010\u0019\u001a\u00020\u0011\u00a2\u0006\u0004\b \u0010!J\u000f\u0010\u0003\u001a\u00020\u0002H$\u00a2\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0004\u00a2\u0006\u0004\b\u0007\u0010\bJ\u001b\u0010\u0007\u001a\u00020\u00022\n\u0010\n\u001a\u0006\u0012\u0002\b\u00030\tH\u0004\u00a2\u0006\u0004\b\u0007\u0010\u000bJ\u001b\u0010\u000f\u001a\u0006\u0012\u0002\b\u00030\u000e2\u0006\u0010\r\u001a\u00020\fH\u0016\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0012\u001a\u00020\u0011H\u0016\u00a2\u0006\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0015\u001a\u00020\u00148\u0006\u00a2\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u0017\u0010\u0019\u001a\u00020\u00118\u0006\u00a2\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u0013R8\u0010\u001e\u001a&\u0012\u0004\u0012\u00020\u0005\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u000e0\u001cj\u0012\u0012\u0004\u0012\u00020\u0005\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u000e`\u001d8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001f\u00a8\u0006\""}, d2={"Lorg/valkyrienskies/mod/api/datagen/VSShipyardEntityDataProvider;", "Lnet/minecraft/class_2405;", "", "registerEntries", "()V", "Lnet/minecraft/class_2960;", "id", "addEntity", "(Lnet/minecraft/class_2960;)V", "Lnet/minecraft/class_1299;", "type", "(Lnet/minecraft/class_1299;)V", "Lnet/minecraft/class_7403;", "cachedOutput", "Ljava/util/concurrent/CompletableFuture;", "run", "(Lnet/minecraft/class_7403;)Ljava/util/concurrent/CompletableFuture;", "", "getName", "()Ljava/lang/String;", "Lnet/minecraft/class_7784;", "output", "Lnet/minecraft/class_7784;", "getOutput", "()Lnet/minecraft/class_7784;", "modId", "Ljava/lang/String;", "getModId", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "entries", "Ljava/util/HashMap;", "<init>", "(Lnet/minecraft/class_7784;Ljava/lang/String;)V", "valkyrienskies-120"})
@SourceDebugExtension(value={"SMAP\nVSShipyardEntityDataProvider.kt\nKotlin\n*S Kotlin\n*F\n+ 1 VSShipyardEntityDataProvider.kt\norg/valkyrienskies/mod/api/datagen/VSShipyardEntityDataProvider\n+ 2 ArraysJVM.kt\nkotlin/collections/ArraysKt__ArraysJVMKt\n*L\n1#1,71:1\n37#2:72\n36#2,3:73\n*S KotlinDebug\n*F\n+ 1 VSShipyardEntityDataProvider.kt\norg/valkyrienskies/mod/api/datagen/VSShipyardEntityDataProvider\n*L\n64#1:72\n64#1:73,3\n*E\n"})
public abstract class VSShipyardEntityDataProvider
implements class_2405 {
    @NotNull
    private final class_7784 output;
    @NotNull
    private final String modId;
    @NotNull
    private final HashMap<class_2960, CompletableFuture<?>> entries;

    public VSShipyardEntityDataProvider(@NotNull class_7784 output, @NotNull String modId) {
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

    protected final void addEntity(@NotNull class_2960 id) {
        Intrinsics.checkNotNullParameter((Object)id, (String)"id");
        if (((Map)this.entries).containsKey(id)) {
            throw new RuntimeException("Duplicate Block Into Entries for " + id);
        }
        Path path = this.output.method_45971().resolve("data").resolve(id.method_12836()).resolve("vs_entities").resolve(id.method_12832() + ".json");
        Intrinsics.checkNotNullExpressionValue((Object)path, (String)"resolve(...)");
        Path path2 = path;
        ((Map)this.entries).put(id, CompletableFuture.supplyAsync(() -> VSShipyardEntityDataProvider.addEntity$lambda$0(path2)).join());
    }

    protected final void addEntity(@NotNull class_1299<?> type) {
        Intrinsics.checkNotNullParameter(type, (String)"type");
        class_2960 class_29602 = type.method_40124().method_40237().method_29177();
        Intrinsics.checkNotNullExpressionValue((Object)class_29602, (String)"location(...)");
        this.addEntity(class_29602);
    }

    @NotNull
    public CompletableFuture<?> method_10319(@NotNull class_7403 cachedOutput) {
        Intrinsics.checkNotNullParameter((Object)cachedOutput, (String)"cachedOutput");
        this.registerEntries();
        Collection<CompletableFuture<?>> collection = this.entries.values();
        Intrinsics.checkNotNullExpressionValue(collection, (String)"<get-values>(...)");
        Collection<CompletableFuture<?>> $this$toTypedArray$iv = collection;
        boolean $i$f$toTypedArray = false;
        Collection<CompletableFuture<?>> thisCollection$iv = $this$toTypedArray$iv;
        CompletableFuture[] completableFutureArray = thisCollection$iv.toArray(new CompletableFuture[0]);
        CompletableFuture<Void> completableFuture = CompletableFuture.allOf(Arrays.copyOf(completableFutureArray, completableFutureArray.length));
        Intrinsics.checkNotNullExpressionValue(completableFuture, (String)"allOf(...)");
        return completableFuture;
    }

    @NotNull
    public String method_10321() {
        return "VS Shipyard Entity Data Provider: " + this.modId;
    }

    private static final CompletableFuture addEntity$lambda$0(Path $path) {
        Intrinsics.checkNotNullParameter((Object)$path, (String)"$path");
        try {
            JsonObject json = new JsonObject();
            json.addProperty("handler", "valkyrienskies:shipyard");
            return class_2405.method_10320((class_7403)class_7403.field_39439, (JsonElement)((JsonElement)json), (Path)$path);
        }
        catch (Exception e2) {
            throw new RuntimeException("Failed to save " + $path, e2);
        }
    }
}

