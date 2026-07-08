/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  dev.onyxstudios.cca.api.v3.component.Component
 *  dev.onyxstudios.cca.api.v3.component.ComponentKey
 *  dev.onyxstudios.cca.api.v3.component.ComponentRegistry
 *  dev.onyxstudios.cca.api.v3.component.sync.AutoSyncedComponent
 *  dev.onyxstudios.cca.api.v3.entity.EntityComponentFactoryRegistry
 *  dev.onyxstudios.cca.api.v3.entity.EntityComponentInitializer
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  net.minecraft.class_1291
 *  net.minecraft.class_1293
 *  net.minecraft.class_1309
 *  net.minecraft.class_2487
 *  net.minecraft.class_2960
 *  net.minecraft.class_7923
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package dev.mim1q.derelict.init.component;

import dev.mim1q.derelict.Derelict;
import dev.onyxstudios.cca.api.v3.component.Component;
import dev.onyxstudios.cca.api.v3.component.ComponentKey;
import dev.onyxstudios.cca.api.v3.component.ComponentRegistry;
import dev.onyxstudios.cca.api.v3.component.sync.AutoSyncedComponent;
import dev.onyxstudios.cca.api.v3.entity.EntityComponentFactoryRegistry;
import dev.onyxstudios.cca.api.v3.entity.EntityComponentInitializer;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import net.minecraft.class_1291;
import net.minecraft.class_1293;
import net.minecraft.class_1309;
import net.minecraft.class_2487;
import net.minecraft.class_2960;
import net.minecraft.class_7923;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0001\u001dB\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a2\u0006\u0004\b\u0007\u0010\bJ\u0019\u0010\r\u001a\u00020\f*\u00020\t2\u0006\u0010\u000b\u001a\u00020\n\u00a2\u0006\u0004\b\r\u0010\u000eJ\u001b\u0010\u0010\u001a\u0004\u0018\u00010\u000f*\u00020\t2\u0006\u0010\u000b\u001a\u00020\n\u00a2\u0006\u0004\b\u0010\u0010\u0011J\u0011\u0010\u0012\u001a\u00020\u0006*\u00020\t\u00a2\u0006\u0004\b\u0012\u0010\u0013R\u001d\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00150\u00148\u0006\u00a2\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u0015\u0010\u001c\u001a\u00020\u0015*\u00020\t8F\u00a2\u0006\u0006\u001a\u0004\b\u001a\u0010\u001b\u00a8\u0006\u001e"}, d2={"Ldev/mim1q/derelict/init/component/ModCardinalComponents;", "Ldev/onyxstudios/cca/api/v3/entity/EntityComponentInitializer;", "<init>", "()V", "Ldev/onyxstudios/cca/api/v3/entity/EntityComponentFactoryRegistry;", "registry", "", "registerEntityComponentFactories", "(Ldev/onyxstudios/cca/api/v3/entity/EntityComponentFactoryRegistry;)V", "Lnet/minecraft/class_1309;", "Lnet/minecraft/class_1291;", "effect", "", "hasClientSyncedEffect", "(Lnet/minecraft/class_1309;Lnet/minecraft/class_1291;)Z", "", "getClientSyncedEffectAmplifier", "(Lnet/minecraft/class_1309;Lnet/minecraft/class_1291;)Ljava/lang/Integer;", "updateClientSyncedEffects", "(Lnet/minecraft/class_1309;)V", "Ldev/onyxstudios/cca/api/v3/component/ComponentKey;", "Ldev/mim1q/derelict/init/component/ModCardinalComponents$DerelictEffectsComponent;", "EFFECTS_COMPONENT", "Ldev/onyxstudios/cca/api/v3/component/ComponentKey;", "getEFFECTS_COMPONENT", "()Ldev/onyxstudios/cca/api/v3/component/ComponentKey;", "getStatusEffectComponent", "(Lnet/minecraft/class_1309;)Ldev/mim1q/derelict/init/component/ModCardinalComponents$DerelictEffectsComponent;", "statusEffectComponent", "DerelictEffectsComponent", "derelict"})
@SourceDebugExtension(value={"SMAP\nModCardinalComponents.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ModCardinalComponents.kt\ndev/mim1q/derelict/init/component/ModCardinalComponents\n+ 2 _Maps.kt\nkotlin/collections/MapsKt___MapsKt\n*L\n1#1,77:1\n216#2,2:78\n*S KotlinDebug\n*F\n+ 1 ModCardinalComponents.kt\ndev/mim1q/derelict/init/component/ModCardinalComponents\n*L\n72#1:78,2\n*E\n"})
public final class ModCardinalComponents
implements EntityComponentInitializer {
    @NotNull
    public static final ModCardinalComponents INSTANCE = new ModCardinalComponents();
    @NotNull
    private static final ComponentKey<DerelictEffectsComponent> EFFECTS_COMPONENT;

    private ModCardinalComponents() {
    }

    @NotNull
    public final ComponentKey<DerelictEffectsComponent> getEFFECTS_COMPONENT() {
        return EFFECTS_COMPONENT;
    }

    public void registerEntityComponentFactories(@NotNull EntityComponentFactoryRegistry registry) {
        Intrinsics.checkNotNullParameter((Object)registry, (String)"registry");
        registry.registerFor(class_1309.class, EFFECTS_COMPONENT, DerelictEffectsComponent::new);
    }

    @NotNull
    public final DerelictEffectsComponent getStatusEffectComponent(@NotNull class_1309 $this$statusEffectComponent) {
        Intrinsics.checkNotNullParameter((Object)$this$statusEffectComponent, (String)"<this>");
        Component component = EFFECTS_COMPONENT.get((Object)$this$statusEffectComponent);
        Intrinsics.checkNotNullExpressionValue((Object)component, (String)"get(...)");
        return (DerelictEffectsComponent)component;
    }

    public final boolean hasClientSyncedEffect(@NotNull class_1309 $this$hasClientSyncedEffect, @NotNull class_1291 effect) {
        Intrinsics.checkNotNullParameter((Object)$this$hasClientSyncedEffect, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)effect, (String)"effect");
        return this.getStatusEffectComponent($this$hasClientSyncedEffect).getEffectAmplifier(effect) != null;
    }

    @Nullable
    public final Integer getClientSyncedEffectAmplifier(@NotNull class_1309 $this$getClientSyncedEffectAmplifier, @NotNull class_1291 effect) {
        Intrinsics.checkNotNullParameter((Object)$this$getClientSyncedEffectAmplifier, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)effect, (String)"effect");
        return this.getStatusEffectComponent($this$getClientSyncedEffectAmplifier).getEffectAmplifier(effect);
    }

    public final void updateClientSyncedEffects(@NotNull class_1309 $this$updateClientSyncedEffects) {
        Intrinsics.checkNotNullParameter((Object)$this$updateClientSyncedEffects, (String)"<this>");
        this.getStatusEffectComponent($this$updateClientSyncedEffects).removeAll();
        Map map = $this$updateClientSyncedEffects.method_6088();
        Intrinsics.checkNotNullExpressionValue((Object)map, (String)"getActiveStatusEffects(...)");
        Map $this$forEach$iv = map;
        boolean $i$f$forEach = false;
        Iterator iterator = $this$forEach$iv.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry element$iv;
            Map.Entry it = element$iv = iterator.next();
            boolean bl = false;
            DerelictEffectsComponent derelictEffectsComponent = INSTANCE.getStatusEffectComponent($this$updateClientSyncedEffects);
            Object k = it.getKey();
            Intrinsics.checkNotNullExpressionValue(k, (String)"<get-key>(...)");
            derelictEffectsComponent.addEffect((class_1291)k, ((class_1293)it.getValue()).method_5578());
        }
    }

    static {
        ComponentKey componentKey = ComponentRegistry.getOrCreate((class_2960)Derelict.INSTANCE.id("effect_flags"), DerelictEffectsComponent.class);
        Intrinsics.checkNotNullExpressionValue((Object)componentKey, (String)"getOrCreate(...)");
        EFFECTS_COMPONENT = componentKey;
    }

    @Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0016\u00a2\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\f\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0016\u00a2\u0006\u0004\b\f\u0010\u000bJ\u001d\u0010\u0011\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000f\u00a2\u0006\u0004\b\u0011\u0010\u0012J\u0015\u0010\u0013\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\r\u00a2\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0015\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u000e\u001a\u00020\r\u00a2\u0006\u0004\b\u0015\u0010\u0016J\r\u0010\u0017\u001a\u00020\t\u00a2\u0006\u0004\b\u0017\u0010\u0018R\u0014\u0010\u0004\u001a\u00020\u00038\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0004\u0010\u0019R \u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\u000f0\u001a8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001d\u00a8\u0006\u001e"}, d2={"Ldev/mim1q/derelict/init/component/ModCardinalComponents$DerelictEffectsComponent;", "Ldev/onyxstudios/cca/api/v3/component/Component;", "Ldev/onyxstudios/cca/api/v3/component/sync/AutoSyncedComponent;", "", "provider", "<init>", "(Ljava/lang/Object;)V", "Lnet/minecraft/class_2487;", "tag", "", "readFromNbt", "(Lnet/minecraft/class_2487;)V", "writeToNbt", "Lnet/minecraft/class_1291;", "effect", "", "amplifier", "addEffect", "(Lnet/minecraft/class_1291;I)V", "removeEffect", "(Lnet/minecraft/class_1291;)V", "getEffectAmplifier", "(Lnet/minecraft/class_1291;)Ljava/lang/Integer;", "removeAll", "()V", "Ljava/lang/Object;", "", "Lnet/minecraft/class_2960;", "effects", "Ljava/util/Map;", "derelict"})
    @SourceDebugExtension(value={"SMAP\nModCardinalComponents.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ModCardinalComponents.kt\ndev/mim1q/derelict/init/component/ModCardinalComponents$DerelictEffectsComponent\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 _Maps.kt\nkotlin/collections/MapsKt___MapsKt\n*L\n1#1,77:1\n1863#2,2:78\n216#3,2:80\n*S KotlinDebug\n*F\n+ 1 ModCardinalComponents.kt\ndev/mim1q/derelict/init/component/ModCardinalComponents$DerelictEffectsComponent\n*L\n29#1:78,2\n35#1:80,2\n*E\n"})
    public static final class DerelictEffectsComponent
    implements Component,
    AutoSyncedComponent {
        @NotNull
        private final Object provider;
        @NotNull
        private final Map<class_2960, Integer> effects;

        public DerelictEffectsComponent(@NotNull Object provider) {
            Intrinsics.checkNotNullParameter((Object)provider, (String)"provider");
            this.provider = provider;
            this.effects = new LinkedHashMap();
        }

        public void readFromNbt(@NotNull class_2487 tag) {
            Intrinsics.checkNotNullParameter((Object)tag, (String)"tag");
            this.effects.clear();
            Set set = tag.method_10541();
            Intrinsics.checkNotNullExpressionValue((Object)set, (String)"getKeys(...)");
            Iterable $this$forEach$iv = set;
            boolean $i$f$forEach = false;
            for (Object element$iv : $this$forEach$iv) {
                String key = (String)element$iv;
                boolean bl = false;
                this.effects.put(new class_2960(key), tag.method_10550(key));
            }
        }

        public void writeToNbt(@NotNull class_2487 tag) {
            Intrinsics.checkNotNullParameter((Object)tag, (String)"tag");
            Map<class_2960, Integer> $this$forEach$iv = this.effects;
            boolean $i$f$forEach = false;
            Iterator<Map.Entry<class_2960, Integer>> iterator = $this$forEach$iv.entrySet().iterator();
            while (iterator.hasNext()) {
                Map.Entry<class_2960, Integer> element$iv;
                Map.Entry<class_2960, Integer> entry = element$iv = iterator.next();
                boolean bl = false;
                class_2960 key = entry.getKey();
                int value = ((Number)entry.getValue()).intValue();
                tag.method_10569(key.toString(), value);
            }
        }

        public final void addEffect(@NotNull class_1291 effect, int amplifier) {
            Intrinsics.checkNotNullParameter((Object)effect, (String)"effect");
            class_2960 class_29602 = class_7923.field_41174.method_10221((Object)effect);
            if (class_29602 == null) {
                return;
            }
            class_2960 id = class_29602;
            Integer n = amplifier;
            this.effects.put(id, n);
            INSTANCE.getEFFECTS_COMPONENT().sync(this.provider);
        }

        public final void removeEffect(@NotNull class_1291 effect) {
            Intrinsics.checkNotNullParameter((Object)effect, (String)"effect");
            class_2960 class_29602 = class_7923.field_41174.method_10221((Object)effect);
            if (class_29602 == null) {
                return;
            }
            class_2960 id = class_29602;
            this.effects.remove(id);
            INSTANCE.getEFFECTS_COMPONENT().sync(this.provider);
        }

        @Nullable
        public final Integer getEffectAmplifier(@NotNull class_1291 effect) {
            Intrinsics.checkNotNullParameter((Object)effect, (String)"effect");
            class_2960 class_29602 = class_7923.field_41174.method_10221((Object)effect);
            if (class_29602 == null) {
                return null;
            }
            class_2960 id = class_29602;
            return this.effects.get(id);
        }

        public final void removeAll() {
            this.effects.clear();
        }
    }
}

