/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  it.unimi.dsi.fastutil.objects.ObjectList
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.collections.CollectionsKt
 *  kotlin.jvm.internal.Intrinsics
 *  me.jellysquid.mods.sodium.client.render.chunk.ChunkRenderMatrices
 *  me.jellysquid.mods.sodium.client.render.chunk.lists.SortedRenderLists
 *  me.jellysquid.mods.sodium.client.render.chunk.terrain.TerrainRenderPass
 *  net.minecraft.class_1921
 *  net.minecraft.class_4587
 *  net.minecraft.class_5568
 *  net.minecraft.class_5572
 *  net.minecraft.class_761
 *  net.minecraft.class_761$class_762
 */
package org.valkyrienskies.mod.common.hooks;

import it.unimi.dsi.fastutil.objects.ObjectList;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import me.jellysquid.mods.sodium.client.render.chunk.ChunkRenderMatrices;
import me.jellysquid.mods.sodium.client.render.chunk.lists.SortedRenderLists;
import me.jellysquid.mods.sodium.client.render.chunk.terrain.TerrainRenderPass;
import net.minecraft.class_1921;
import net.minecraft.class_4587;
import net.minecraft.class_5568;
import net.minecraft.class_5572;
import net.minecraft.class_761;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.joml.Matrix4f;
import org.valkyrienskies.core.api.ships.ClientShip;
import org.valkyrienskies.core.api.ships.Ship;
import org.valkyrienskies.core.util.datastructures.DenseBlockPosSet;
import org.valkyrienskies.core.util.events.EventEmitterImpl;
import org.valkyrienskies.mod.common.config.ConfigType;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0007&'()*+,B\t\b\u0002\u00a2\u0006\u0004\b$\u0010%R\u001d\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u001d\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006\u00a2\u0006\f\n\u0004\b\b\u0010\u0005\u001a\u0004\b\t\u0010\u0007R#\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\u00028\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\u0005\u001a\u0004\b\r\u0010\u0007R\u001d\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0005\u001a\u0004\b\u0010\u0010\u0007R\u001d\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0011\u0010\u0005\u001a\u0004\b\u0012\u0010\u0007R\u001d\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00130\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0014\u0010\u0005\u001a\u0004\b\u0015\u0010\u0007R\u001d\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00160\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0017\u0010\u0005\u001a\u0004\b\u0018\u0010\u0007R\u001d\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00190\u00028\u0006\u00a2\u0006\f\n\u0004\b\u001a\u0010\u0005\u001a\u0004\b\u001b\u0010\u0007R\u001d\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00190\u00028\u0006\u00a2\u0006\f\n\u0004\b\u001c\u0010\u0005\u001a\u0004\b\u001d\u0010\u0007R\u001d\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u001e0\u00028\u0006\u00a2\u0006\f\n\u0004\b\u001f\u0010\u0005\u001a\u0004\b \u0010\u0007R\u001d\u0010\"\u001a\b\u0012\u0004\u0012\u00020!0\u00028\u0006\u00a2\u0006\f\n\u0004\b\"\u0010\u0005\u001a\u0004\b#\u0010\u0007\u00a8\u0006-"}, d2={"Lorg/valkyrienskies/mod/common/hooks/VSGameEvents;", "", "Lorg/valkyrienskies/core/util/events/EventEmitterImpl;", "", "registriesCompleted", "Lorg/valkyrienskies/core/util/events/EventEmitterImpl;", "getRegistriesCompleted", "()Lorg/valkyrienskies/core/util/events/EventEmitterImpl;", "tagsAreLoaded", "getTagsAreLoaded", "", "Lorg/valkyrienskies/mod/common/hooks/VSGameEvents$ConfigUpdateEntry;", "configUpdated", "getConfigUpdated", "Lorg/valkyrienskies/mod/common/hooks/VSGameEvents$ShipRenderEvent;", "renderShip", "getRenderShip", "postRenderShip", "getPostRenderShip", "Lorg/valkyrienskies/mod/common/hooks/VSGameEvents$EntitySectionSetShip;", "entitySectionSetShip", "getEntitySectionSetShip", "Lorg/valkyrienskies/mod/common/hooks/VSGameEvents$ShipStartRenderEvent;", "shipsStartRendering", "getShipsStartRendering", "Lorg/valkyrienskies/mod/common/hooks/VSGameEvents$ShipRenderEventSodium;", "renderShipSodium", "getRenderShipSodium", "postRenderShipSodium", "getPostRenderShipSodium", "Lorg/valkyrienskies/mod/common/hooks/VSGameEvents$ShipStartRenderEventSodium;", "shipsStartRenderingSodium", "getShipsStartRenderingSodium", "Lorg/valkyrienskies/mod/common/hooks/VSGameEvents$ShipSplitEvent;", "shipSplit", "getShipSplit", "<init>", "()V", "ConfigUpdateEntry", "EntitySectionSetShip", "ShipStartRenderEvent", "ShipRenderEvent", "ShipSplitEvent", "ShipStartRenderEventSodium", "ShipRenderEventSodium", "valkyrienskies-120"})
public final class VSGameEvents {
    @NotNull
    public static final VSGameEvents INSTANCE = new VSGameEvents();
    @NotNull
    private static final EventEmitterImpl<Unit> registriesCompleted = new EventEmitterImpl();
    @NotNull
    private static final EventEmitterImpl<Unit> tagsAreLoaded = new EventEmitterImpl();
    @NotNull
    private static final EventEmitterImpl<Set<ConfigUpdateEntry>> configUpdated = new EventEmitterImpl();
    @NotNull
    private static final EventEmitterImpl<ShipRenderEvent> renderShip = new EventEmitterImpl();
    @NotNull
    private static final EventEmitterImpl<ShipRenderEvent> postRenderShip = new EventEmitterImpl();
    @NotNull
    private static final EventEmitterImpl<EntitySectionSetShip> entitySectionSetShip = new EventEmitterImpl();
    @NotNull
    private static final EventEmitterImpl<ShipStartRenderEvent> shipsStartRendering = new EventEmitterImpl();
    @NotNull
    private static final EventEmitterImpl<ShipRenderEventSodium> renderShipSodium = new EventEmitterImpl();
    @NotNull
    private static final EventEmitterImpl<ShipRenderEventSodium> postRenderShipSodium = new EventEmitterImpl();
    @NotNull
    private static final EventEmitterImpl<ShipStartRenderEventSodium> shipsStartRenderingSodium = new EventEmitterImpl();
    @NotNull
    private static final EventEmitterImpl<ShipSplitEvent> shipSplit = new EventEmitterImpl();

    private VSGameEvents() {
    }

    @NotNull
    public final EventEmitterImpl<Unit> getRegistriesCompleted() {
        return registriesCompleted;
    }

    @NotNull
    public final EventEmitterImpl<Unit> getTagsAreLoaded() {
        return tagsAreLoaded;
    }

    @NotNull
    public final EventEmitterImpl<Set<ConfigUpdateEntry>> getConfigUpdated() {
        return configUpdated;
    }

    @NotNull
    public final EventEmitterImpl<ShipRenderEvent> getRenderShip() {
        return renderShip;
    }

    @NotNull
    public final EventEmitterImpl<ShipRenderEvent> getPostRenderShip() {
        return postRenderShip;
    }

    @NotNull
    public final EventEmitterImpl<EntitySectionSetShip> getEntitySectionSetShip() {
        return entitySectionSetShip;
    }

    @NotNull
    public final EventEmitterImpl<ShipStartRenderEvent> getShipsStartRendering() {
        return shipsStartRendering;
    }

    @NotNull
    public final EventEmitterImpl<ShipRenderEventSodium> getRenderShipSodium() {
        return renderShipSodium;
    }

    @NotNull
    public final EventEmitterImpl<ShipRenderEventSodium> getPostRenderShipSodium() {
        return postRenderShipSodium;
    }

    @NotNull
    public final EventEmitterImpl<ShipStartRenderEventSodium> getShipsStartRenderingSodium() {
        return shipsStartRenderingSodium;
    }

    @NotNull
    public final EventEmitterImpl<ShipSplitEvent> getShipSplit() {
        return shipSplit;
    }

    @Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000e\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u000b\u001a\u00020\u0002\u0012\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0010\r\u001a\u00020\u0006\u00a2\u0006\u0004\b \u0010!J\u0010\u0010\u0003\u001a\u00020\u0002H\u00c6\u0003\u00a2\u0006\u0004\b\u0003\u0010\u0004J\u0016\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u00c6\u0003\u00a2\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\t\u001a\u00020\u0006H\u00c6\u0003\u00a2\u0006\u0004\b\t\u0010\nJ4\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u000b\u001a\u00020\u00022\u000e\b\u0002\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\b\b\u0002\u0010\r\u001a\u00020\u0006H\u00c6\u0001\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u001a\u0010\u0012\u001a\u00020\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003\u00a2\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0015\u001a\u00020\u0014H\u00d6\u0001\u00a2\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0017\u001a\u00020\u0006H\u00d6\u0001\u00a2\u0006\u0004\b\u0017\u0010\nR\u0017\u0010\u000b\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\u0018\u001a\u0004\b\u0019\u0010\u0004R\u001d\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\u001a\u001a\u0004\b\u001b\u0010\bR\u0017\u0010\r\u001a\u00020\u00068\u0006\u00a2\u0006\f\n\u0004\b\r\u0010\u001c\u001a\u0004\b\u001d\u0010\nR\u0011\u0010\u001f\u001a\u00020\u00068F\u00a2\u0006\u0006\u001a\u0004\b\u001e\u0010\n\u00a8\u0006\""}, d2={"Lorg/valkyrienskies/mod/common/hooks/VSGameEvents$ConfigUpdateEntry;", "", "Lorg/valkyrienskies/mod/common/config/ConfigType;", "component1", "()Lorg/valkyrienskies/mod/common/config/ConfigType;", "", "", "component2", "()Ljava/util/List;", "component3", "()Ljava/lang/String;", "configType", "category", "name", "copy", "(Lorg/valkyrienskies/mod/common/config/ConfigType;Ljava/util/List;Ljava/lang/String;)Lorg/valkyrienskies/mod/common/hooks/VSGameEvents$ConfigUpdateEntry;", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "Lorg/valkyrienskies/mod/common/config/ConfigType;", "getConfigType", "Ljava/util/List;", "getCategory", "Ljava/lang/String;", "getName", "getPath", "path", "<init>", "(Lorg/valkyrienskies/mod/common/config/ConfigType;Ljava/util/List;Ljava/lang/String;)V", "valkyrienskies-120"})
    public static final class ConfigUpdateEntry {
        @NotNull
        private final ConfigType configType;
        @NotNull
        private final List<String> category;
        @NotNull
        private final String name;

        public ConfigUpdateEntry(@NotNull ConfigType configType, @NotNull List<String> category, @NotNull String name) {
            Intrinsics.checkNotNullParameter((Object)((Object)configType), (String)"configType");
            Intrinsics.checkNotNullParameter(category, (String)"category");
            Intrinsics.checkNotNullParameter((Object)name, (String)"name");
            this.configType = configType;
            this.category = category;
            this.name = name;
        }

        @NotNull
        public final ConfigType getConfigType() {
            return this.configType;
        }

        @NotNull
        public final List<String> getCategory() {
            return this.category;
        }

        @NotNull
        public final String getName() {
            return this.name;
        }

        @NotNull
        public final String getPath() {
            return CollectionsKt.joinToString$default((Iterable)CollectionsKt.plus((Collection)this.category, (Object)this.name), (CharSequence)".", null, null, (int)0, null, null, (int)62, null);
        }

        @NotNull
        public final ConfigType component1() {
            return this.configType;
        }

        @NotNull
        public final List<String> component2() {
            return this.category;
        }

        @NotNull
        public final String component3() {
            return this.name;
        }

        @NotNull
        public final ConfigUpdateEntry copy(@NotNull ConfigType configType, @NotNull List<String> category, @NotNull String name) {
            Intrinsics.checkNotNullParameter((Object)((Object)configType), (String)"configType");
            Intrinsics.checkNotNullParameter(category, (String)"category");
            Intrinsics.checkNotNullParameter((Object)name, (String)"name");
            return new ConfigUpdateEntry(configType, category, name);
        }

        public static /* synthetic */ ConfigUpdateEntry copy$default(ConfigUpdateEntry configUpdateEntry, ConfigType configType, List list, String string, int n2, Object object) {
            if ((n2 & 1) != 0) {
                configType = configUpdateEntry.configType;
            }
            if ((n2 & 2) != 0) {
                list = configUpdateEntry.category;
            }
            if ((n2 & 4) != 0) {
                string = configUpdateEntry.name;
            }
            return configUpdateEntry.copy(configType, list, string);
        }

        @NotNull
        public String toString() {
            return "ConfigUpdateEntry(configType=" + this.configType + ", category=" + this.category + ", name=" + this.name + ")";
        }

        public int hashCode() {
            int result2 = this.configType.hashCode();
            result2 = result2 * 31 + ((Object)this.category).hashCode();
            result2 = result2 * 31 + this.name.hashCode();
            return result2;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ConfigUpdateEntry)) {
                return false;
            }
            ConfigUpdateEntry configUpdateEntry = (ConfigUpdateEntry)other;
            if (this.configType != configUpdateEntry.configType) {
                return false;
            }
            if (!Intrinsics.areEqual(this.category, configUpdateEntry.category)) {
                return false;
            }
            return Intrinsics.areEqual((Object)this.name, (Object)configUpdateEntry.name);
        }
    }

    @Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u0006\u0010\n\u001a\u00020\u0006\u00a2\u0006\u0004\b\u001b\u0010\u001cJ\u0016\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u00c6\u0003\u00a2\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0007\u001a\u00020\u0006H\u00c6\u0003\u00a2\u0006\u0004\b\u0007\u0010\bJ*\u0010\u000b\u001a\u00020\u00002\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\b\b\u0002\u0010\n\u001a\u00020\u0006H\u00c6\u0001\u00a2\u0006\u0004\b\u000b\u0010\fJ\u001a\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0012\u001a\u00020\u0011H\u00d6\u0001\u00a2\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0015\u001a\u00020\u0014H\u00d6\u0001\u00a2\u0006\u0004\b\u0015\u0010\u0016R\u001d\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\u0017\u001a\u0004\b\u0018\u0010\u0005R\u0017\u0010\n\u001a\u00020\u00068\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u0019\u001a\u0004\b\u001a\u0010\b\u00a8\u0006\u001d"}, d2={"Lorg/valkyrienskies/mod/common/hooks/VSGameEvents$EntitySectionSetShip;", "", "Lnet/minecraft/class_5572;", "Lnet/minecraft/class_5568;", "component1", "()Lnet/minecraft/class_5572;", "Lorg/valkyrienskies/core/api/ships/Ship;", "component2", "()Lorg/valkyrienskies/core/api/ships/Ship;", "section", "ship", "copy", "(Lnet/minecraft/class_5572;Lorg/valkyrienskies/core/api/ships/Ship;)Lorg/valkyrienskies/mod/common/hooks/VSGameEvents$EntitySectionSetShip;", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "Lnet/minecraft/class_5572;", "getSection", "Lorg/valkyrienskies/core/api/ships/Ship;", "getShip", "<init>", "(Lnet/minecraft/class_5572;Lorg/valkyrienskies/core/api/ships/Ship;)V", "valkyrienskies-120"})
    public static final class EntitySectionSetShip {
        @NotNull
        private final class_5572<class_5568> section;
        @NotNull
        private final Ship ship;

        public EntitySectionSetShip(@NotNull class_5572<class_5568> section, @NotNull Ship ship) {
            Intrinsics.checkNotNullParameter(section, (String)"section");
            Intrinsics.checkNotNullParameter((Object)ship, (String)"ship");
            this.section = section;
            this.ship = ship;
        }

        @NotNull
        public final class_5572<class_5568> getSection() {
            return this.section;
        }

        @NotNull
        public final Ship getShip() {
            return this.ship;
        }

        @NotNull
        public final class_5572<class_5568> component1() {
            return this.section;
        }

        @NotNull
        public final Ship component2() {
            return this.ship;
        }

        @NotNull
        public final EntitySectionSetShip copy(@NotNull class_5572<class_5568> section, @NotNull Ship ship) {
            Intrinsics.checkNotNullParameter(section, (String)"section");
            Intrinsics.checkNotNullParameter((Object)ship, (String)"ship");
            return new EntitySectionSetShip(section, ship);
        }

        public static /* synthetic */ EntitySectionSetShip copy$default(EntitySectionSetShip entitySectionSetShip, class_5572 class_55722, Ship ship, int n2, Object object) {
            if ((n2 & 1) != 0) {
                class_55722 = entitySectionSetShip.section;
            }
            if ((n2 & 2) != 0) {
                ship = entitySectionSetShip.ship;
            }
            return entitySectionSetShip.copy(class_55722, ship);
        }

        @NotNull
        public String toString() {
            return "EntitySectionSetShip(section=" + this.section + ", ship=" + this.ship + ")";
        }

        public int hashCode() {
            int result2 = this.section.hashCode();
            result2 = result2 * 31 + this.ship.hashCode();
            return result2;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof EntitySectionSetShip)) {
                return false;
            }
            EntitySectionSetShip entitySectionSetShip = (EntitySectionSetShip)other;
            if (!Intrinsics.areEqual(this.section, entitySectionSetShip.section)) {
                return false;
            }
            return Intrinsics.areEqual((Object)this.ship, (Object)entitySectionSetShip.ship);
        }
    }

    @Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0015\b\u0086\b\u0018\u00002\u00020\u0001BU\u0012\u0006\u0010\u001a\u001a\u00020\u0002\u0012\u0006\u0010\u001b\u001a\u00020\u0005\u0012\u0006\u0010\u001c\u001a\u00020\b\u0012\u0006\u0010\u001d\u001a\u00020\u000b\u0012\u0006\u0010\u001e\u001a\u00020\u000b\u0012\u0006\u0010\u001f\u001a\u00020\u000b\u0012\u0006\u0010 \u001a\u00020\u0010\u0012\u0006\u0010!\u001a\u00020\u0013\u0012\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00170\u0016\u00a2\u0006\u0004\b?\u0010@J\u0010\u0010\u0003\u001a\u00020\u0002H\u00c6\u0003\u00a2\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005H\u00c6\u0003\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bH\u00c6\u0003\u00a2\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bH\u00c6\u0003\u00a2\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000e\u001a\u00020\u000bH\u00c6\u0003\u00a2\u0006\u0004\b\u000e\u0010\rJ\u0010\u0010\u000f\u001a\u00020\u000bH\u00c6\u0003\u00a2\u0006\u0004\b\u000f\u0010\rJ\u0010\u0010\u0011\u001a\u00020\u0010H\u00c6\u0003\u00a2\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0014\u001a\u00020\u0013H\u00c6\u0003\u00a2\u0006\u0004\b\u0014\u0010\u0015J\u0016\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00170\u0016H\u00c6\u0003\u00a2\u0006\u0004\b\u0018\u0010\u0019Jp\u0010#\u001a\u00020\u00002\b\b\u0002\u0010\u001a\u001a\u00020\u00022\b\b\u0002\u0010\u001b\u001a\u00020\u00052\b\b\u0002\u0010\u001c\u001a\u00020\b2\b\b\u0002\u0010\u001d\u001a\u00020\u000b2\b\b\u0002\u0010\u001e\u001a\u00020\u000b2\b\b\u0002\u0010\u001f\u001a\u00020\u000b2\b\b\u0002\u0010 \u001a\u00020\u00102\b\b\u0002\u0010!\u001a\u00020\u00132\u000e\b\u0002\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00170\u0016H\u00c6\u0001\u00a2\u0006\u0004\b#\u0010$J\u001a\u0010'\u001a\u00020&2\b\u0010%\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003\u00a2\u0006\u0004\b'\u0010(J\u0010\u0010*\u001a\u00020)H\u00d6\u0001\u00a2\u0006\u0004\b*\u0010+J\u0010\u0010-\u001a\u00020,H\u00d6\u0001\u00a2\u0006\u0004\b-\u0010.R\u0017\u0010\u001a\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u001a\u0010/\u001a\u0004\b0\u0010\u0004R\u0017\u0010\u001b\u001a\u00020\u00058\u0006\u00a2\u0006\f\n\u0004\b\u001b\u00101\u001a\u0004\b2\u0010\u0007R\u0017\u0010\u001c\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\u001c\u00103\u001a\u0004\b4\u0010\nR\u0017\u0010\u001d\u001a\u00020\u000b8\u0006\u00a2\u0006\f\n\u0004\b\u001d\u00105\u001a\u0004\b6\u0010\rR\u0017\u0010\u001e\u001a\u00020\u000b8\u0006\u00a2\u0006\f\n\u0004\b\u001e\u00105\u001a\u0004\b7\u0010\rR\u0017\u0010\u001f\u001a\u00020\u000b8\u0006\u00a2\u0006\f\n\u0004\b\u001f\u00105\u001a\u0004\b8\u0010\rR\u0017\u0010 \u001a\u00020\u00108\u0006\u00a2\u0006\f\n\u0004\b \u00109\u001a\u0004\b:\u0010\u0012R\u0017\u0010!\u001a\u00020\u00138\u0006\u00a2\u0006\f\n\u0004\b!\u0010;\u001a\u0004\b<\u0010\u0015R\u001d\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00170\u00168\u0006\u00a2\u0006\f\n\u0004\b\"\u0010=\u001a\u0004\b>\u0010\u0019\u00a8\u0006A"}, d2={"Lorg/valkyrienskies/mod/common/hooks/VSGameEvents$ShipRenderEvent;", "", "Lnet/minecraft/class_761;", "component1", "()Lnet/minecraft/class_761;", "Lnet/minecraft/class_1921;", "component2", "()Lnet/minecraft/class_1921;", "Lnet/minecraft/class_4587;", "component3", "()Lnet/minecraft/class_4587;", "", "component4", "()D", "component5", "component6", "Lorg/joml/Matrix4f;", "component7", "()Lorg/joml/Matrix4f;", "Lorg/valkyrienskies/core/api/ships/ClientShip;", "component8", "()Lorg/valkyrienskies/core/api/ships/ClientShip;", "Lit/unimi/dsi/fastutil/objects/ObjectList;", "Lnet/minecraft/class_761$class_762;", "component9", "()Lit/unimi/dsi/fastutil/objects/ObjectList;", "renderer", "renderType", "poseStack", "camX", "camY", "camZ", "projectionMatrix", "ship", "chunks", "copy", "(Lnet/minecraft/class_761;Lnet/minecraft/class_1921;Lnet/minecraft/class_4587;DDDLorg/joml/Matrix4f;Lorg/valkyrienskies/core/api/ships/ClientShip;Lit/unimi/dsi/fastutil/objects/ObjectList;)Lorg/valkyrienskies/mod/common/hooks/VSGameEvents$ShipRenderEvent;", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "Lnet/minecraft/class_761;", "getRenderer", "Lnet/minecraft/class_1921;", "getRenderType", "Lnet/minecraft/class_4587;", "getPoseStack", "D", "getCamX", "getCamY", "getCamZ", "Lorg/joml/Matrix4f;", "getProjectionMatrix", "Lorg/valkyrienskies/core/api/ships/ClientShip;", "getShip", "Lit/unimi/dsi/fastutil/objects/ObjectList;", "getChunks", "<init>", "(Lnet/minecraft/class_761;Lnet/minecraft/class_1921;Lnet/minecraft/class_4587;DDDLorg/joml/Matrix4f;Lorg/valkyrienskies/core/api/ships/ClientShip;Lit/unimi/dsi/fastutil/objects/ObjectList;)V", "valkyrienskies-120"})
    public static final class ShipRenderEvent {
        @NotNull
        private final class_761 renderer;
        @NotNull
        private final class_1921 renderType;
        @NotNull
        private final class_4587 poseStack;
        private final double camX;
        private final double camY;
        private final double camZ;
        @NotNull
        private final Matrix4f projectionMatrix;
        @NotNull
        private final ClientShip ship;
        @NotNull
        private final ObjectList<class_761.class_762> chunks;

        public ShipRenderEvent(@NotNull class_761 renderer, @NotNull class_1921 renderType, @NotNull class_4587 poseStack, double camX, double camY, double camZ, @NotNull Matrix4f projectionMatrix, @NotNull ClientShip ship, @NotNull ObjectList<class_761.class_762> chunks) {
            Intrinsics.checkNotNullParameter((Object)renderer, (String)"renderer");
            Intrinsics.checkNotNullParameter((Object)renderType, (String)"renderType");
            Intrinsics.checkNotNullParameter((Object)poseStack, (String)"poseStack");
            Intrinsics.checkNotNullParameter((Object)projectionMatrix, (String)"projectionMatrix");
            Intrinsics.checkNotNullParameter((Object)ship, (String)"ship");
            Intrinsics.checkNotNullParameter(chunks, (String)"chunks");
            this.renderer = renderer;
            this.renderType = renderType;
            this.poseStack = poseStack;
            this.camX = camX;
            this.camY = camY;
            this.camZ = camZ;
            this.projectionMatrix = projectionMatrix;
            this.ship = ship;
            this.chunks = chunks;
        }

        @NotNull
        public final class_761 getRenderer() {
            return this.renderer;
        }

        @NotNull
        public final class_1921 getRenderType() {
            return this.renderType;
        }

        @NotNull
        public final class_4587 getPoseStack() {
            return this.poseStack;
        }

        public final double getCamX() {
            return this.camX;
        }

        public final double getCamY() {
            return this.camY;
        }

        public final double getCamZ() {
            return this.camZ;
        }

        @NotNull
        public final Matrix4f getProjectionMatrix() {
            return this.projectionMatrix;
        }

        @NotNull
        public final ClientShip getShip() {
            return this.ship;
        }

        @NotNull
        public final ObjectList<class_761.class_762> getChunks() {
            return this.chunks;
        }

        @NotNull
        public final class_761 component1() {
            return this.renderer;
        }

        @NotNull
        public final class_1921 component2() {
            return this.renderType;
        }

        @NotNull
        public final class_4587 component3() {
            return this.poseStack;
        }

        public final double component4() {
            return this.camX;
        }

        public final double component5() {
            return this.camY;
        }

        public final double component6() {
            return this.camZ;
        }

        @NotNull
        public final Matrix4f component7() {
            return this.projectionMatrix;
        }

        @NotNull
        public final ClientShip component8() {
            return this.ship;
        }

        @NotNull
        public final ObjectList<class_761.class_762> component9() {
            return this.chunks;
        }

        @NotNull
        public final ShipRenderEvent copy(@NotNull class_761 renderer, @NotNull class_1921 renderType, @NotNull class_4587 poseStack, double camX, double camY, double camZ, @NotNull Matrix4f projectionMatrix, @NotNull ClientShip ship, @NotNull ObjectList<class_761.class_762> chunks) {
            Intrinsics.checkNotNullParameter((Object)renderer, (String)"renderer");
            Intrinsics.checkNotNullParameter((Object)renderType, (String)"renderType");
            Intrinsics.checkNotNullParameter((Object)poseStack, (String)"poseStack");
            Intrinsics.checkNotNullParameter((Object)projectionMatrix, (String)"projectionMatrix");
            Intrinsics.checkNotNullParameter((Object)ship, (String)"ship");
            Intrinsics.checkNotNullParameter(chunks, (String)"chunks");
            return new ShipRenderEvent(renderer, renderType, poseStack, camX, camY, camZ, projectionMatrix, ship, chunks);
        }

        public static /* synthetic */ ShipRenderEvent copy$default(ShipRenderEvent shipRenderEvent, class_761 class_7612, class_1921 class_19212, class_4587 class_45872, double d2, double d3, double d4, Matrix4f matrix4f, ClientShip clientShip, ObjectList objectList, int n2, Object object) {
            if ((n2 & 1) != 0) {
                class_7612 = shipRenderEvent.renderer;
            }
            if ((n2 & 2) != 0) {
                class_19212 = shipRenderEvent.renderType;
            }
            if ((n2 & 4) != 0) {
                class_45872 = shipRenderEvent.poseStack;
            }
            if ((n2 & 8) != 0) {
                d2 = shipRenderEvent.camX;
            }
            if ((n2 & 0x10) != 0) {
                d3 = shipRenderEvent.camY;
            }
            if ((n2 & 0x20) != 0) {
                d4 = shipRenderEvent.camZ;
            }
            if ((n2 & 0x40) != 0) {
                matrix4f = shipRenderEvent.projectionMatrix;
            }
            if ((n2 & 0x80) != 0) {
                clientShip = shipRenderEvent.ship;
            }
            if ((n2 & 0x100) != 0) {
                objectList = shipRenderEvent.chunks;
            }
            return shipRenderEvent.copy(class_7612, class_19212, class_45872, d2, d3, d4, matrix4f, clientShip, objectList);
        }

        @NotNull
        public String toString() {
            return "ShipRenderEvent(renderer=" + this.renderer + ", renderType=" + this.renderType + ", poseStack=" + this.poseStack + ", camX=" + this.camX + ", camY=" + this.camY + ", camZ=" + this.camZ + ", projectionMatrix=" + this.projectionMatrix + ", ship=" + this.ship + ", chunks=" + this.chunks + ")";
        }

        public int hashCode() {
            int result2 = this.renderer.hashCode();
            result2 = result2 * 31 + this.renderType.hashCode();
            result2 = result2 * 31 + this.poseStack.hashCode();
            result2 = result2 * 31 + Double.hashCode(this.camX);
            result2 = result2 * 31 + Double.hashCode(this.camY);
            result2 = result2 * 31 + Double.hashCode(this.camZ);
            result2 = result2 * 31 + this.projectionMatrix.hashCode();
            result2 = result2 * 31 + this.ship.hashCode();
            result2 = result2 * 31 + this.chunks.hashCode();
            return result2;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ShipRenderEvent)) {
                return false;
            }
            ShipRenderEvent shipRenderEvent = (ShipRenderEvent)other;
            if (!Intrinsics.areEqual((Object)this.renderer, (Object)shipRenderEvent.renderer)) {
                return false;
            }
            if (!Intrinsics.areEqual((Object)this.renderType, (Object)shipRenderEvent.renderType)) {
                return false;
            }
            if (!Intrinsics.areEqual((Object)this.poseStack, (Object)shipRenderEvent.poseStack)) {
                return false;
            }
            if (Double.compare(this.camX, shipRenderEvent.camX) != 0) {
                return false;
            }
            if (Double.compare(this.camY, shipRenderEvent.camY) != 0) {
                return false;
            }
            if (Double.compare(this.camZ, shipRenderEvent.camZ) != 0) {
                return false;
            }
            if (!Intrinsics.areEqual((Object)this.projectionMatrix, (Object)shipRenderEvent.projectionMatrix)) {
                return false;
            }
            if (!Intrinsics.areEqual((Object)this.ship, (Object)shipRenderEvent.ship)) {
                return false;
            }
            return Intrinsics.areEqual(this.chunks, shipRenderEvent.chunks);
        }
    }

    @Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0011\b\u0086\b\u0018\u00002\u00020\u0001B?\u0012\u0006\u0010\u0013\u001a\u00020\u0002\u0012\u0006\u0010\u0014\u001a\u00020\u0005\u0012\u0006\u0010\u0015\u001a\u00020\b\u0012\u0006\u0010\u0016\u001a\u00020\b\u0012\u0006\u0010\u0017\u001a\u00020\b\u0012\u0006\u0010\u0018\u001a\u00020\r\u0012\u0006\u0010\u0019\u001a\u00020\u0010\u00a2\u0006\u0004\b2\u00103J\u0010\u0010\u0003\u001a\u00020\u0002H\u00c6\u0003\u00a2\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005H\u00c6\u0003\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bH\u00c6\u0003\u00a2\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u000b\u001a\u00020\bH\u00c6\u0003\u00a2\u0006\u0004\b\u000b\u0010\nJ\u0010\u0010\f\u001a\u00020\bH\u00c6\u0003\u00a2\u0006\u0004\b\f\u0010\nJ\u0010\u0010\u000e\u001a\u00020\rH\u00c6\u0003\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0011\u001a\u00020\u0010H\u00c6\u0003\u00a2\u0006\u0004\b\u0011\u0010\u0012JV\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u0010\u0013\u001a\u00020\u00022\b\b\u0002\u0010\u0014\u001a\u00020\u00052\b\b\u0002\u0010\u0015\u001a\u00020\b2\b\b\u0002\u0010\u0016\u001a\u00020\b2\b\b\u0002\u0010\u0017\u001a\u00020\b2\b\b\u0002\u0010\u0018\u001a\u00020\r2\b\b\u0002\u0010\u0019\u001a\u00020\u0010H\u00c6\u0001\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\u001a\u0010\u001e\u001a\u00020\u001d2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003\u00a2\u0006\u0004\b\u001e\u0010\u001fJ\u0010\u0010!\u001a\u00020 H\u00d6\u0001\u00a2\u0006\u0004\b!\u0010\"J\u0010\u0010$\u001a\u00020#H\u00d6\u0001\u00a2\u0006\u0004\b$\u0010%R\u0017\u0010\u0013\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0013\u0010&\u001a\u0004\b'\u0010\u0004R\u0017\u0010\u0014\u001a\u00020\u00058\u0006\u00a2\u0006\f\n\u0004\b\u0014\u0010(\u001a\u0004\b)\u0010\u0007R\u0017\u0010\u0015\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\u0015\u0010*\u001a\u0004\b+\u0010\nR\u0017\u0010\u0016\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\u0016\u0010*\u001a\u0004\b,\u0010\nR\u0017\u0010\u0017\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\u0017\u0010*\u001a\u0004\b-\u0010\nR\u0017\u0010\u0018\u001a\u00020\r8\u0006\u00a2\u0006\f\n\u0004\b\u0018\u0010.\u001a\u0004\b/\u0010\u000fR\u0017\u0010\u0019\u001a\u00020\u00108\u0006\u00a2\u0006\f\n\u0004\b\u0019\u00100\u001a\u0004\b1\u0010\u0012\u00a8\u00064"}, d2={"Lorg/valkyrienskies/mod/common/hooks/VSGameEvents$ShipRenderEventSodium;", "", "Lme/jellysquid/mods/sodium/client/render/chunk/terrain/TerrainRenderPass;", "component1", "()Lme/jellysquid/mods/sodium/client/render/chunk/terrain/TerrainRenderPass;", "Lme/jellysquid/mods/sodium/client/render/chunk/ChunkRenderMatrices;", "component2", "()Lme/jellysquid/mods/sodium/client/render/chunk/ChunkRenderMatrices;", "", "component3", "()D", "component4", "component5", "Lorg/valkyrienskies/core/api/ships/ClientShip;", "component6", "()Lorg/valkyrienskies/core/api/ships/ClientShip;", "Lme/jellysquid/mods/sodium/client/render/chunk/lists/SortedRenderLists;", "component7", "()Lme/jellysquid/mods/sodium/client/render/chunk/lists/SortedRenderLists;", "pass", "matrices", "camX", "camY", "camZ", "ship", "chunks", "copy", "(Lme/jellysquid/mods/sodium/client/render/chunk/terrain/TerrainRenderPass;Lme/jellysquid/mods/sodium/client/render/chunk/ChunkRenderMatrices;DDDLorg/valkyrienskies/core/api/ships/ClientShip;Lme/jellysquid/mods/sodium/client/render/chunk/lists/SortedRenderLists;)Lorg/valkyrienskies/mod/common/hooks/VSGameEvents$ShipRenderEventSodium;", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "Lme/jellysquid/mods/sodium/client/render/chunk/terrain/TerrainRenderPass;", "getPass", "Lme/jellysquid/mods/sodium/client/render/chunk/ChunkRenderMatrices;", "getMatrices", "D", "getCamX", "getCamY", "getCamZ", "Lorg/valkyrienskies/core/api/ships/ClientShip;", "getShip", "Lme/jellysquid/mods/sodium/client/render/chunk/lists/SortedRenderLists;", "getChunks", "<init>", "(Lme/jellysquid/mods/sodium/client/render/chunk/terrain/TerrainRenderPass;Lme/jellysquid/mods/sodium/client/render/chunk/ChunkRenderMatrices;DDDLorg/valkyrienskies/core/api/ships/ClientShip;Lme/jellysquid/mods/sodium/client/render/chunk/lists/SortedRenderLists;)V", "valkyrienskies-120"})
    public static final class ShipRenderEventSodium {
        @NotNull
        private final TerrainRenderPass pass;
        @NotNull
        private final ChunkRenderMatrices matrices;
        private final double camX;
        private final double camY;
        private final double camZ;
        @NotNull
        private final ClientShip ship;
        @NotNull
        private final SortedRenderLists chunks;

        public ShipRenderEventSodium(@NotNull TerrainRenderPass pass, @NotNull ChunkRenderMatrices matrices, double camX, double camY, double camZ, @NotNull ClientShip ship, @NotNull SortedRenderLists chunks) {
            Intrinsics.checkNotNullParameter((Object)pass, (String)"pass");
            Intrinsics.checkNotNullParameter((Object)matrices, (String)"matrices");
            Intrinsics.checkNotNullParameter((Object)ship, (String)"ship");
            Intrinsics.checkNotNullParameter((Object)chunks, (String)"chunks");
            this.pass = pass;
            this.matrices = matrices;
            this.camX = camX;
            this.camY = camY;
            this.camZ = camZ;
            this.ship = ship;
            this.chunks = chunks;
        }

        @NotNull
        public final TerrainRenderPass getPass() {
            return this.pass;
        }

        @NotNull
        public final ChunkRenderMatrices getMatrices() {
            return this.matrices;
        }

        public final double getCamX() {
            return this.camX;
        }

        public final double getCamY() {
            return this.camY;
        }

        public final double getCamZ() {
            return this.camZ;
        }

        @NotNull
        public final ClientShip getShip() {
            return this.ship;
        }

        @NotNull
        public final SortedRenderLists getChunks() {
            return this.chunks;
        }

        @NotNull
        public final TerrainRenderPass component1() {
            return this.pass;
        }

        @NotNull
        public final ChunkRenderMatrices component2() {
            return this.matrices;
        }

        public final double component3() {
            return this.camX;
        }

        public final double component4() {
            return this.camY;
        }

        public final double component5() {
            return this.camZ;
        }

        @NotNull
        public final ClientShip component6() {
            return this.ship;
        }

        @NotNull
        public final SortedRenderLists component7() {
            return this.chunks;
        }

        @NotNull
        public final ShipRenderEventSodium copy(@NotNull TerrainRenderPass pass, @NotNull ChunkRenderMatrices matrices, double camX, double camY, double camZ, @NotNull ClientShip ship, @NotNull SortedRenderLists chunks) {
            Intrinsics.checkNotNullParameter((Object)pass, (String)"pass");
            Intrinsics.checkNotNullParameter((Object)matrices, (String)"matrices");
            Intrinsics.checkNotNullParameter((Object)ship, (String)"ship");
            Intrinsics.checkNotNullParameter((Object)chunks, (String)"chunks");
            return new ShipRenderEventSodium(pass, matrices, camX, camY, camZ, ship, chunks);
        }

        public static /* synthetic */ ShipRenderEventSodium copy$default(ShipRenderEventSodium shipRenderEventSodium, TerrainRenderPass terrainRenderPass, ChunkRenderMatrices chunkRenderMatrices, double d2, double d3, double d4, ClientShip clientShip, SortedRenderLists sortedRenderLists, int n2, Object object) {
            if ((n2 & 1) != 0) {
                terrainRenderPass = shipRenderEventSodium.pass;
            }
            if ((n2 & 2) != 0) {
                chunkRenderMatrices = shipRenderEventSodium.matrices;
            }
            if ((n2 & 4) != 0) {
                d2 = shipRenderEventSodium.camX;
            }
            if ((n2 & 8) != 0) {
                d3 = shipRenderEventSodium.camY;
            }
            if ((n2 & 0x10) != 0) {
                d4 = shipRenderEventSodium.camZ;
            }
            if ((n2 & 0x20) != 0) {
                clientShip = shipRenderEventSodium.ship;
            }
            if ((n2 & 0x40) != 0) {
                sortedRenderLists = shipRenderEventSodium.chunks;
            }
            return shipRenderEventSodium.copy(terrainRenderPass, chunkRenderMatrices, d2, d3, d4, clientShip, sortedRenderLists);
        }

        @NotNull
        public String toString() {
            return "ShipRenderEventSodium(pass=" + this.pass + ", matrices=" + this.matrices + ", camX=" + this.camX + ", camY=" + this.camY + ", camZ=" + this.camZ + ", ship=" + this.ship + ", chunks=" + this.chunks + ")";
        }

        public int hashCode() {
            int result2 = this.pass.hashCode();
            result2 = result2 * 31 + this.matrices.hashCode();
            result2 = result2 * 31 + Double.hashCode(this.camX);
            result2 = result2 * 31 + Double.hashCode(this.camY);
            result2 = result2 * 31 + Double.hashCode(this.camZ);
            result2 = result2 * 31 + this.ship.hashCode();
            result2 = result2 * 31 + this.chunks.hashCode();
            return result2;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ShipRenderEventSodium)) {
                return false;
            }
            ShipRenderEventSodium shipRenderEventSodium = (ShipRenderEventSodium)other;
            if (!Intrinsics.areEqual((Object)this.pass, (Object)shipRenderEventSodium.pass)) {
                return false;
            }
            if (!Intrinsics.areEqual((Object)this.matrices, (Object)shipRenderEventSodium.matrices)) {
                return false;
            }
            if (Double.compare(this.camX, shipRenderEventSodium.camX) != 0) {
                return false;
            }
            if (Double.compare(this.camY, shipRenderEventSodium.camY) != 0) {
                return false;
            }
            if (Double.compare(this.camZ, shipRenderEventSodium.camZ) != 0) {
                return false;
            }
            if (!Intrinsics.areEqual((Object)this.ship, (Object)shipRenderEventSodium.ship)) {
                return false;
            }
            return Intrinsics.areEqual((Object)this.chunks, (Object)shipRenderEventSodium.chunks);
        }
    }

    @Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\n\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\n\u0010\n\u001a\u00060\u0002j\u0002`\u0003\u0012\n\u0010\u000b\u001a\u00060\u0002j\u0002`\u0003\u0012\u0006\u0010\f\u001a\u00020\u0007\u00a2\u0006\u0004\b\u001e\u0010\u001fJ\u0014\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003H\u00c6\u0003\u00a2\u0006\u0004\b\u0004\u0010\u0005J\u0014\u0010\u0006\u001a\u00060\u0002j\u0002`\u0003H\u00c6\u0003\u00a2\u0006\u0004\b\u0006\u0010\u0005J\u0010\u0010\b\u001a\u00020\u0007H\u00c6\u0003\u00a2\u0006\u0004\b\b\u0010\tJ6\u0010\r\u001a\u00020\u00002\f\b\u0002\u0010\n\u001a\u00060\u0002j\u0002`\u00032\f\b\u0002\u0010\u000b\u001a\u00060\u0002j\u0002`\u00032\b\b\u0002\u0010\f\u001a\u00020\u0007H\u00c6\u0001\u00a2\u0006\u0004\b\r\u0010\u000eJ\u001a\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003\u00a2\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0014\u001a\u00020\u0013H\u00d6\u0001\u00a2\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0017\u001a\u00020\u0016H\u00d6\u0001\u00a2\u0006\u0004\b\u0017\u0010\u0018R\u001b\u0010\n\u001a\u00060\u0002j\u0002`\u00038\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u0019\u001a\u0004\b\u001a\u0010\u0005R\u001b\u0010\u000b\u001a\u00060\u0002j\u0002`\u00038\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\u0019\u001a\u0004\b\u001b\u0010\u0005R\u0017\u0010\f\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\u001c\u001a\u0004\b\u001d\u0010\t\u00a8\u0006 "}, d2={"Lorg/valkyrienskies/mod/common/hooks/VSGameEvents$ShipSplitEvent;", "", "", "Lorg/valkyrienskies/core/api/ships/properties/ShipId;", "component1", "()J", "component2", "Lorg/valkyrienskies/core/util/datastructures/DenseBlockPosSet;", "component3", "()Lorg/valkyrienskies/core/util/datastructures/DenseBlockPosSet;", "ship", "newShip", "blocks", "copy", "(JJLorg/valkyrienskies/core/util/datastructures/DenseBlockPosSet;)Lorg/valkyrienskies/mod/common/hooks/VSGameEvents$ShipSplitEvent;", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "J", "getShip", "getNewShip", "Lorg/valkyrienskies/core/util/datastructures/DenseBlockPosSet;", "getBlocks", "<init>", "(JJLorg/valkyrienskies/core/util/datastructures/DenseBlockPosSet;)V", "valkyrienskies-120"})
    public static final class ShipSplitEvent {
        private final long ship;
        private final long newShip;
        @NotNull
        private final DenseBlockPosSet blocks;

        public ShipSplitEvent(long ship, long newShip, @NotNull DenseBlockPosSet blocks) {
            Intrinsics.checkNotNullParameter((Object)blocks, (String)"blocks");
            this.ship = ship;
            this.newShip = newShip;
            this.blocks = blocks;
        }

        public final long getShip() {
            return this.ship;
        }

        public final long getNewShip() {
            return this.newShip;
        }

        @NotNull
        public final DenseBlockPosSet getBlocks() {
            return this.blocks;
        }

        public final long component1() {
            return this.ship;
        }

        public final long component2() {
            return this.newShip;
        }

        @NotNull
        public final DenseBlockPosSet component3() {
            return this.blocks;
        }

        @NotNull
        public final ShipSplitEvent copy(long ship, long newShip, @NotNull DenseBlockPosSet blocks) {
            Intrinsics.checkNotNullParameter((Object)blocks, (String)"blocks");
            return new ShipSplitEvent(ship, newShip, blocks);
        }

        public static /* synthetic */ ShipSplitEvent copy$default(ShipSplitEvent shipSplitEvent, long l2, long l3, DenseBlockPosSet denseBlockPosSet, int n2, Object object) {
            if ((n2 & 1) != 0) {
                l2 = shipSplitEvent.ship;
            }
            if ((n2 & 2) != 0) {
                l3 = shipSplitEvent.newShip;
            }
            if ((n2 & 4) != 0) {
                denseBlockPosSet = shipSplitEvent.blocks;
            }
            return shipSplitEvent.copy(l2, l3, denseBlockPosSet);
        }

        @NotNull
        public String toString() {
            return "ShipSplitEvent(ship=" + this.ship + ", newShip=" + this.newShip + ", blocks=" + this.blocks + ")";
        }

        public int hashCode() {
            int result2 = Long.hashCode(this.ship);
            result2 = result2 * 31 + Long.hashCode(this.newShip);
            result2 = result2 * 31 + this.blocks.hashCode();
            return result2;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ShipSplitEvent)) {
                return false;
            }
            ShipSplitEvent shipSplitEvent = (ShipSplitEvent)other;
            if (this.ship != shipSplitEvent.ship) {
                return false;
            }
            if (this.newShip != shipSplitEvent.newShip) {
                return false;
            }
            return Intrinsics.areEqual((Object)this.blocks, (Object)shipSplitEvent.blocks);
        }
    }

    @Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0011\b\u0086\b\u0018\u00002\u00020\u0001B?\u0012\u0006\u0010\u0013\u001a\u00020\u0002\u0012\u0006\u0010\u0014\u001a\u00020\u0005\u0012\u0006\u0010\u0015\u001a\u00020\b\u0012\u0006\u0010\u0016\u001a\u00020\u000b\u0012\u0006\u0010\u0017\u001a\u00020\u000b\u0012\u0006\u0010\u0018\u001a\u00020\u000b\u0012\u0006\u0010\u0019\u001a\u00020\u0010\u00a2\u0006\u0004\b2\u00103J\u0010\u0010\u0003\u001a\u00020\u0002H\u00c6\u0003\u00a2\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005H\u00c6\u0003\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bH\u00c6\u0003\u00a2\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bH\u00c6\u0003\u00a2\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000e\u001a\u00020\u000bH\u00c6\u0003\u00a2\u0006\u0004\b\u000e\u0010\rJ\u0010\u0010\u000f\u001a\u00020\u000bH\u00c6\u0003\u00a2\u0006\u0004\b\u000f\u0010\rJ\u0010\u0010\u0011\u001a\u00020\u0010H\u00c6\u0003\u00a2\u0006\u0004\b\u0011\u0010\u0012JV\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u0010\u0013\u001a\u00020\u00022\b\b\u0002\u0010\u0014\u001a\u00020\u00052\b\b\u0002\u0010\u0015\u001a\u00020\b2\b\b\u0002\u0010\u0016\u001a\u00020\u000b2\b\b\u0002\u0010\u0017\u001a\u00020\u000b2\b\b\u0002\u0010\u0018\u001a\u00020\u000b2\b\b\u0002\u0010\u0019\u001a\u00020\u0010H\u00c6\u0001\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\u001a\u0010\u001e\u001a\u00020\u001d2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003\u00a2\u0006\u0004\b\u001e\u0010\u001fJ\u0010\u0010!\u001a\u00020 H\u00d6\u0001\u00a2\u0006\u0004\b!\u0010\"J\u0010\u0010$\u001a\u00020#H\u00d6\u0001\u00a2\u0006\u0004\b$\u0010%R\u0017\u0010\u0013\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0013\u0010&\u001a\u0004\b'\u0010\u0004R\u0017\u0010\u0014\u001a\u00020\u00058\u0006\u00a2\u0006\f\n\u0004\b\u0014\u0010(\u001a\u0004\b)\u0010\u0007R\u0017\u0010\u0015\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\u0015\u0010*\u001a\u0004\b+\u0010\nR\u0017\u0010\u0016\u001a\u00020\u000b8\u0006\u00a2\u0006\f\n\u0004\b\u0016\u0010,\u001a\u0004\b-\u0010\rR\u0017\u0010\u0017\u001a\u00020\u000b8\u0006\u00a2\u0006\f\n\u0004\b\u0017\u0010,\u001a\u0004\b.\u0010\rR\u0017\u0010\u0018\u001a\u00020\u000b8\u0006\u00a2\u0006\f\n\u0004\b\u0018\u0010,\u001a\u0004\b/\u0010\rR\u0017\u0010\u0019\u001a\u00020\u00108\u0006\u00a2\u0006\f\n\u0004\b\u0019\u00100\u001a\u0004\b1\u0010\u0012\u00a8\u00064"}, d2={"Lorg/valkyrienskies/mod/common/hooks/VSGameEvents$ShipStartRenderEvent;", "", "Lnet/minecraft/class_761;", "component1", "()Lnet/minecraft/class_761;", "Lnet/minecraft/class_1921;", "component2", "()Lnet/minecraft/class_1921;", "Lnet/minecraft/class_4587;", "component3", "()Lnet/minecraft/class_4587;", "", "component4", "()D", "component5", "component6", "Lorg/joml/Matrix4f;", "component7", "()Lorg/joml/Matrix4f;", "renderer", "renderType", "poseStack", "camX", "camY", "camZ", "projectionMatrix", "copy", "(Lnet/minecraft/class_761;Lnet/minecraft/class_1921;Lnet/minecraft/class_4587;DDDLorg/joml/Matrix4f;)Lorg/valkyrienskies/mod/common/hooks/VSGameEvents$ShipStartRenderEvent;", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "Lnet/minecraft/class_761;", "getRenderer", "Lnet/minecraft/class_1921;", "getRenderType", "Lnet/minecraft/class_4587;", "getPoseStack", "D", "getCamX", "getCamY", "getCamZ", "Lorg/joml/Matrix4f;", "getProjectionMatrix", "<init>", "(Lnet/minecraft/class_761;Lnet/minecraft/class_1921;Lnet/minecraft/class_4587;DDDLorg/joml/Matrix4f;)V", "valkyrienskies-120"})
    public static final class ShipStartRenderEvent {
        @NotNull
        private final class_761 renderer;
        @NotNull
        private final class_1921 renderType;
        @NotNull
        private final class_4587 poseStack;
        private final double camX;
        private final double camY;
        private final double camZ;
        @NotNull
        private final Matrix4f projectionMatrix;

        public ShipStartRenderEvent(@NotNull class_761 renderer, @NotNull class_1921 renderType, @NotNull class_4587 poseStack, double camX, double camY, double camZ, @NotNull Matrix4f projectionMatrix) {
            Intrinsics.checkNotNullParameter((Object)renderer, (String)"renderer");
            Intrinsics.checkNotNullParameter((Object)renderType, (String)"renderType");
            Intrinsics.checkNotNullParameter((Object)poseStack, (String)"poseStack");
            Intrinsics.checkNotNullParameter((Object)projectionMatrix, (String)"projectionMatrix");
            this.renderer = renderer;
            this.renderType = renderType;
            this.poseStack = poseStack;
            this.camX = camX;
            this.camY = camY;
            this.camZ = camZ;
            this.projectionMatrix = projectionMatrix;
        }

        @NotNull
        public final class_761 getRenderer() {
            return this.renderer;
        }

        @NotNull
        public final class_1921 getRenderType() {
            return this.renderType;
        }

        @NotNull
        public final class_4587 getPoseStack() {
            return this.poseStack;
        }

        public final double getCamX() {
            return this.camX;
        }

        public final double getCamY() {
            return this.camY;
        }

        public final double getCamZ() {
            return this.camZ;
        }

        @NotNull
        public final Matrix4f getProjectionMatrix() {
            return this.projectionMatrix;
        }

        @NotNull
        public final class_761 component1() {
            return this.renderer;
        }

        @NotNull
        public final class_1921 component2() {
            return this.renderType;
        }

        @NotNull
        public final class_4587 component3() {
            return this.poseStack;
        }

        public final double component4() {
            return this.camX;
        }

        public final double component5() {
            return this.camY;
        }

        public final double component6() {
            return this.camZ;
        }

        @NotNull
        public final Matrix4f component7() {
            return this.projectionMatrix;
        }

        @NotNull
        public final ShipStartRenderEvent copy(@NotNull class_761 renderer, @NotNull class_1921 renderType, @NotNull class_4587 poseStack, double camX, double camY, double camZ, @NotNull Matrix4f projectionMatrix) {
            Intrinsics.checkNotNullParameter((Object)renderer, (String)"renderer");
            Intrinsics.checkNotNullParameter((Object)renderType, (String)"renderType");
            Intrinsics.checkNotNullParameter((Object)poseStack, (String)"poseStack");
            Intrinsics.checkNotNullParameter((Object)projectionMatrix, (String)"projectionMatrix");
            return new ShipStartRenderEvent(renderer, renderType, poseStack, camX, camY, camZ, projectionMatrix);
        }

        public static /* synthetic */ ShipStartRenderEvent copy$default(ShipStartRenderEvent shipStartRenderEvent, class_761 class_7612, class_1921 class_19212, class_4587 class_45872, double d2, double d3, double d4, Matrix4f matrix4f, int n2, Object object) {
            if ((n2 & 1) != 0) {
                class_7612 = shipStartRenderEvent.renderer;
            }
            if ((n2 & 2) != 0) {
                class_19212 = shipStartRenderEvent.renderType;
            }
            if ((n2 & 4) != 0) {
                class_45872 = shipStartRenderEvent.poseStack;
            }
            if ((n2 & 8) != 0) {
                d2 = shipStartRenderEvent.camX;
            }
            if ((n2 & 0x10) != 0) {
                d3 = shipStartRenderEvent.camY;
            }
            if ((n2 & 0x20) != 0) {
                d4 = shipStartRenderEvent.camZ;
            }
            if ((n2 & 0x40) != 0) {
                matrix4f = shipStartRenderEvent.projectionMatrix;
            }
            return shipStartRenderEvent.copy(class_7612, class_19212, class_45872, d2, d3, d4, matrix4f);
        }

        @NotNull
        public String toString() {
            return "ShipStartRenderEvent(renderer=" + this.renderer + ", renderType=" + this.renderType + ", poseStack=" + this.poseStack + ", camX=" + this.camX + ", camY=" + this.camY + ", camZ=" + this.camZ + ", projectionMatrix=" + this.projectionMatrix + ")";
        }

        public int hashCode() {
            int result2 = this.renderer.hashCode();
            result2 = result2 * 31 + this.renderType.hashCode();
            result2 = result2 * 31 + this.poseStack.hashCode();
            result2 = result2 * 31 + Double.hashCode(this.camX);
            result2 = result2 * 31 + Double.hashCode(this.camY);
            result2 = result2 * 31 + Double.hashCode(this.camZ);
            result2 = result2 * 31 + this.projectionMatrix.hashCode();
            return result2;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ShipStartRenderEvent)) {
                return false;
            }
            ShipStartRenderEvent shipStartRenderEvent = (ShipStartRenderEvent)other;
            if (!Intrinsics.areEqual((Object)this.renderer, (Object)shipStartRenderEvent.renderer)) {
                return false;
            }
            if (!Intrinsics.areEqual((Object)this.renderType, (Object)shipStartRenderEvent.renderType)) {
                return false;
            }
            if (!Intrinsics.areEqual((Object)this.poseStack, (Object)shipStartRenderEvent.poseStack)) {
                return false;
            }
            if (Double.compare(this.camX, shipStartRenderEvent.camX) != 0) {
                return false;
            }
            if (Double.compare(this.camY, shipStartRenderEvent.camY) != 0) {
                return false;
            }
            if (Double.compare(this.camZ, shipStartRenderEvent.camZ) != 0) {
                return false;
            }
            return Intrinsics.areEqual((Object)this.projectionMatrix, (Object)shipStartRenderEvent.projectionMatrix);
        }
    }

    @Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\r\b\u0086\b\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\r\u001a\u00020\u0002\u0012\u0006\u0010\u000e\u001a\u00020\u0005\u0012\u0006\u0010\u000f\u001a\u00020\b\u0012\u0006\u0010\u0010\u001a\u00020\b\u0012\u0006\u0010\u0011\u001a\u00020\b\u00a2\u0006\u0004\b&\u0010'J\u0010\u0010\u0003\u001a\u00020\u0002H\u00c6\u0003\u00a2\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005H\u00c6\u0003\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bH\u00c6\u0003\u00a2\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u000b\u001a\u00020\bH\u00c6\u0003\u00a2\u0006\u0004\b\u000b\u0010\nJ\u0010\u0010\f\u001a\u00020\bH\u00c6\u0003\u00a2\u0006\u0004\b\f\u0010\nJB\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\r\u001a\u00020\u00022\b\b\u0002\u0010\u000e\u001a\u00020\u00052\b\b\u0002\u0010\u000f\u001a\u00020\b2\b\b\u0002\u0010\u0010\u001a\u00020\b2\b\b\u0002\u0010\u0011\u001a\u00020\bH\u00c6\u0001\u00a2\u0006\u0004\b\u0012\u0010\u0013J\u001a\u0010\u0016\u001a\u00020\u00152\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003\u00a2\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0019\u001a\u00020\u0018H\u00d6\u0001\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\u0010\u0010\u001c\u001a\u00020\u001bH\u00d6\u0001\u00a2\u0006\u0004\b\u001c\u0010\u001dR\u0017\u0010\r\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\r\u0010\u001e\u001a\u0004\b\u001f\u0010\u0004R\u0017\u0010\u000e\u001a\u00020\u00058\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010 \u001a\u0004\b!\u0010\u0007R\u0017\u0010\u000f\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\"\u001a\u0004\b#\u0010\nR\u0017\u0010\u0010\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\"\u001a\u0004\b$\u0010\nR\u0017\u0010\u0011\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\u0011\u0010\"\u001a\u0004\b%\u0010\n\u00a8\u0006("}, d2={"Lorg/valkyrienskies/mod/common/hooks/VSGameEvents$ShipStartRenderEventSodium;", "", "Lme/jellysquid/mods/sodium/client/render/chunk/terrain/TerrainRenderPass;", "component1", "()Lme/jellysquid/mods/sodium/client/render/chunk/terrain/TerrainRenderPass;", "Lme/jellysquid/mods/sodium/client/render/chunk/ChunkRenderMatrices;", "component2", "()Lme/jellysquid/mods/sodium/client/render/chunk/ChunkRenderMatrices;", "", "component3", "()D", "component4", "component5", "pass", "matrices", "camX", "camY", "camZ", "copy", "(Lme/jellysquid/mods/sodium/client/render/chunk/terrain/TerrainRenderPass;Lme/jellysquid/mods/sodium/client/render/chunk/ChunkRenderMatrices;DDD)Lorg/valkyrienskies/mod/common/hooks/VSGameEvents$ShipStartRenderEventSodium;", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "Lme/jellysquid/mods/sodium/client/render/chunk/terrain/TerrainRenderPass;", "getPass", "Lme/jellysquid/mods/sodium/client/render/chunk/ChunkRenderMatrices;", "getMatrices", "D", "getCamX", "getCamY", "getCamZ", "<init>", "(Lme/jellysquid/mods/sodium/client/render/chunk/terrain/TerrainRenderPass;Lme/jellysquid/mods/sodium/client/render/chunk/ChunkRenderMatrices;DDD)V", "valkyrienskies-120"})
    public static final class ShipStartRenderEventSodium {
        @NotNull
        private final TerrainRenderPass pass;
        @NotNull
        private final ChunkRenderMatrices matrices;
        private final double camX;
        private final double camY;
        private final double camZ;

        public ShipStartRenderEventSodium(@NotNull TerrainRenderPass pass, @NotNull ChunkRenderMatrices matrices, double camX, double camY, double camZ) {
            Intrinsics.checkNotNullParameter((Object)pass, (String)"pass");
            Intrinsics.checkNotNullParameter((Object)matrices, (String)"matrices");
            this.pass = pass;
            this.matrices = matrices;
            this.camX = camX;
            this.camY = camY;
            this.camZ = camZ;
        }

        @NotNull
        public final TerrainRenderPass getPass() {
            return this.pass;
        }

        @NotNull
        public final ChunkRenderMatrices getMatrices() {
            return this.matrices;
        }

        public final double getCamX() {
            return this.camX;
        }

        public final double getCamY() {
            return this.camY;
        }

        public final double getCamZ() {
            return this.camZ;
        }

        @NotNull
        public final TerrainRenderPass component1() {
            return this.pass;
        }

        @NotNull
        public final ChunkRenderMatrices component2() {
            return this.matrices;
        }

        public final double component3() {
            return this.camX;
        }

        public final double component4() {
            return this.camY;
        }

        public final double component5() {
            return this.camZ;
        }

        @NotNull
        public final ShipStartRenderEventSodium copy(@NotNull TerrainRenderPass pass, @NotNull ChunkRenderMatrices matrices, double camX, double camY, double camZ) {
            Intrinsics.checkNotNullParameter((Object)pass, (String)"pass");
            Intrinsics.checkNotNullParameter((Object)matrices, (String)"matrices");
            return new ShipStartRenderEventSodium(pass, matrices, camX, camY, camZ);
        }

        public static /* synthetic */ ShipStartRenderEventSodium copy$default(ShipStartRenderEventSodium shipStartRenderEventSodium, TerrainRenderPass terrainRenderPass, ChunkRenderMatrices chunkRenderMatrices, double d2, double d3, double d4, int n2, Object object) {
            if ((n2 & 1) != 0) {
                terrainRenderPass = shipStartRenderEventSodium.pass;
            }
            if ((n2 & 2) != 0) {
                chunkRenderMatrices = shipStartRenderEventSodium.matrices;
            }
            if ((n2 & 4) != 0) {
                d2 = shipStartRenderEventSodium.camX;
            }
            if ((n2 & 8) != 0) {
                d3 = shipStartRenderEventSodium.camY;
            }
            if ((n2 & 0x10) != 0) {
                d4 = shipStartRenderEventSodium.camZ;
            }
            return shipStartRenderEventSodium.copy(terrainRenderPass, chunkRenderMatrices, d2, d3, d4);
        }

        @NotNull
        public String toString() {
            return "ShipStartRenderEventSodium(pass=" + this.pass + ", matrices=" + this.matrices + ", camX=" + this.camX + ", camY=" + this.camY + ", camZ=" + this.camZ + ")";
        }

        public int hashCode() {
            int result2 = this.pass.hashCode();
            result2 = result2 * 31 + this.matrices.hashCode();
            result2 = result2 * 31 + Double.hashCode(this.camX);
            result2 = result2 * 31 + Double.hashCode(this.camY);
            result2 = result2 * 31 + Double.hashCode(this.camZ);
            return result2;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ShipStartRenderEventSodium)) {
                return false;
            }
            ShipStartRenderEventSodium shipStartRenderEventSodium = (ShipStartRenderEventSodium)other;
            if (!Intrinsics.areEqual((Object)this.pass, (Object)shipStartRenderEventSodium.pass)) {
                return false;
            }
            if (!Intrinsics.areEqual((Object)this.matrices, (Object)shipStartRenderEventSodium.matrices)) {
                return false;
            }
            if (Double.compare(this.camX, shipStartRenderEventSodium.camX) != 0) {
                return false;
            }
            if (Double.compare(this.camY, shipStartRenderEventSodium.camY) != 0) {
                return false;
            }
            return Double.compare(this.camZ, shipStartRenderEventSodium.camZ) == 0;
        }
    }
}

