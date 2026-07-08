/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.common.cache.Cache
 *  com.google.common.cache.CacheBuilder
 *  kotlin.Metadata
 *  kotlin.Pair
 *  kotlin.TuplesKt
 *  kotlin.collections.CollectionsKt
 *  kotlin.collections.MapsKt
 *  kotlin.jvm.JvmStatic
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.ranges.RangesKt
 *  kotlin.sequences.Sequence
 *  kotlin.sequences.SequencesKt
 *  kotlin.text.Regex
 *  kotlin.text.RegexOption
 *  kotlin.text.StringsKt
 *  net.minecraft.class_1297
 *  net.minecraft.class_1299
 *  net.minecraft.class_1676
 *  net.minecraft.class_2960
 *  net.minecraft.class_7922
 *  net.minecraft.class_7923
 */
package org.valkyrienskies.mod.common.entity.handling;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;
import kotlin.text.Regex;
import kotlin.text.RegexOption;
import kotlin.text.StringsKt;
import net.minecraft.class_1297;
import net.minecraft.class_1299;
import net.minecraft.class_1676;
import net.minecraft.class_2960;
import net.minecraft.class_7922;
import net.minecraft.class_7923;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.valkyrienskies.core.impl.networking.simple.SimplePacketNetworking;
import org.valkyrienskies.mod.common.VSGameUtilsKt;
import org.valkyrienskies.mod.common.entity.handling.DefaultShipyardEntityHandler;
import org.valkyrienskies.mod.common.entity.handling.VSEntityHandler;
import org.valkyrienskies.mod.common.entity.handling.WorldEntityHandler;
import org.valkyrienskies.mod.common.networking.PacketSyncVSEntityTypes;
import org.valkyrienskies.mod.common.util.MinecraftPlayer;
import org.valkyrienskies.mod.compat.CreateCompat;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b/\u00100J\u001d\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004\u00a2\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\n\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u0004\u00a2\u0006\u0004\b\n\u0010\u000bJ!\u0010\u000e\u001a\u00020\u00062\n\u0010\r\u001a\u0006\u0012\u0002\b\u00030\f2\u0006\u0010\u0005\u001a\u00020\u0004\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u0015\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0010\u00a2\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0010H\u0002\u00a2\u0006\u0004\b\u0014\u0010\u0013J\u0017\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0010H\u0002\u00a2\u0006\u0004\b\u0015\u0010\u0013J\u0017\u0010\u0012\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0016\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0012\u0010\u0017J\u0015\u0010\u001a\u001a\u00020\u00062\u0006\u0010\u0019\u001a\u00020\u0018\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\u0017\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u0011\u001a\u00020\u0010H\u0007\u00a2\u0006\u0004\b\u001d\u0010\u001eR \u0010 \u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00040\u001f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b \u0010!R \u0010\"\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00020\u001f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\"\u0010!R$\u0010#\u001a\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\f\u0012\u0004\u0012\u00020\u00040\u001f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b#\u0010!R\u0014\u0010%\u001a\u00020$8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b%\u0010&R\u0016\u0010\t\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\t\u0010'Rd\u0010*\u001aR\u0012\u0014\u0012\u0012\u0012\u0002\b\u0003 )*\b\u0012\u0002\b\u0003\u0018\u00010\f0\f\u0012\f\u0012\n )*\u0004\u0018\u00010\u00040\u0004 )*(\u0012\u0014\u0012\u0012\u0012\u0002\b\u0003 )*\b\u0012\u0002\b\u0003\u0018\u00010\f0\f\u0012\f\u0012\n )*\u0004\u0018\u00010\u00040\u0004\u0018\u00010(0(8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b*\u0010+R\u0014\u0010-\u001a\u00020,8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b-\u0010.\u00a8\u00061"}, d2={"Lorg/valkyrienskies/mod/common/entity/handling/VSEntityManager;", "", "Lnet/minecraft/class_2960;", "name", "Lorg/valkyrienskies/mod/common/entity/handling/VSEntityHandler;", "entityHandler", "", "register", "(Lnet/minecraft/class_2960;Lorg/valkyrienskies/mod/common/entity/handling/VSEntityHandler;)V", "contraptionHandler", "registerContraptionHandler", "(Lorg/valkyrienskies/mod/common/entity/handling/VSEntityHandler;)V", "Lnet/minecraft/class_1299;", "entityType", "pair", "(Lnet/minecraft/class_1299;Lorg/valkyrienskies/mod/common/entity/handling/VSEntityHandler;)V", "Lnet/minecraft/class_1297;", "entity", "getHandler", "(Lnet/minecraft/class_1297;)Lorg/valkyrienskies/mod/common/entity/handling/VSEntityHandler;", "getDefaultHandler", "determineDefaultHandler", "type", "(Lnet/minecraft/class_2960;)Lorg/valkyrienskies/mod/common/entity/handling/VSEntityHandler;", "Lorg/valkyrienskies/mod/common/util/MinecraftPlayer;", "player", "syncHandlers", "(Lorg/valkyrienskies/mod/common/util/MinecraftPlayer;)V", "", "isShipyardEntity", "(Lnet/minecraft/class_1297;)Z", "Ljava/util/HashMap;", "entityHandlersNamed", "Ljava/util/HashMap;", "namedEntityHandlers", "entityHandlers", "Lorg/valkyrienskies/mod/common/entity/handling/WorldEntityHandler;", "default", "Lorg/valkyrienskies/mod/common/entity/handling/WorldEntityHandler;", "Lorg/valkyrienskies/mod/common/entity/handling/VSEntityHandler;", "Lcom/google/common/cache/Cache;", "kotlin.jvm.PlatformType", "defaultHandlersCache", "Lcom/google/common/cache/Cache;", "Lkotlin/text/Regex;", "seatRegistryName", "Lkotlin/text/Regex;", "<init>", "()V", "valkyrienskies-120"})
public final class VSEntityManager {
    @NotNull
    public static final VSEntityManager INSTANCE = new VSEntityManager();
    @NotNull
    private static final HashMap<class_2960, VSEntityHandler> entityHandlersNamed = new HashMap();
    @NotNull
    private static final HashMap<VSEntityHandler, class_2960> namedEntityHandlers = new HashMap();
    @NotNull
    private static final HashMap<class_1299<?>, VSEntityHandler> entityHandlers = new HashMap();
    @NotNull
    private static final WorldEntityHandler default = WorldEntityHandler.INSTANCE;
    @NotNull
    private static VSEntityHandler contraptionHandler = DefaultShipyardEntityHandler.INSTANCE;
    private static final Cache<class_1299<?>, VSEntityHandler> defaultHandlersCache = CacheBuilder.newBuilder().expireAfterAccess(Duration.ofMinutes(5L)).build();
    @NotNull
    private static final Regex seatRegistryName;

    private VSEntityManager() {
    }

    public final void register(@NotNull class_2960 name, @NotNull VSEntityHandler entityHandler) {
        Intrinsics.checkNotNullParameter((Object)name, (String)"name");
        Intrinsics.checkNotNullParameter((Object)entityHandler, (String)"entityHandler");
        ((Map)entityHandlersNamed).put(name, entityHandler);
        ((Map)namedEntityHandlers).put(entityHandler, name);
    }

    public final void registerContraptionHandler(@NotNull VSEntityHandler contraptionHandler) {
        Intrinsics.checkNotNullParameter((Object)contraptionHandler, (String)"contraptionHandler");
        VSEntityManager.contraptionHandler = contraptionHandler;
    }

    public final void pair(@NotNull class_1299<?> entityType, @NotNull VSEntityHandler entityHandler) {
        Intrinsics.checkNotNullParameter(entityType, (String)"entityType");
        Intrinsics.checkNotNullParameter((Object)entityHandler, (String)"entityHandler");
        ((Map)entityHandlers).put(entityType, entityHandler);
    }

    @NotNull
    public final VSEntityHandler getHandler(@NotNull class_1297 entity) {
        Intrinsics.checkNotNullParameter((Object)entity, (String)"entity");
        if (CreateCompat.isContraption(entity)) {
            return contraptionHandler;
        }
        VSEntityHandler vSEntityHandler = entityHandlers.get(entity.method_5864());
        if (vSEntityHandler == null) {
            vSEntityHandler = this.getDefaultHandler(entity);
        }
        return vSEntityHandler;
    }

    private final VSEntityHandler getDefaultHandler(class_1297 entity) {
        Object object = defaultHandlersCache.get((Object)entity.method_5864(), () -> VSEntityManager.getDefaultHandler$lambda$0(entity));
        Intrinsics.checkNotNullExpressionValue((Object)object, (String)"get(...)");
        return (VSEntityHandler)object;
    }

    private final VSEntityHandler determineDefaultHandler(class_1297 entity) {
        block5: {
            try {
                String className = entity.getClass().getSimpleName();
                class_2960 class_29602 = class_7923.field_41177.method_10221((Object)entity.method_5864());
                Intrinsics.checkNotNullExpressionValue((Object)class_29602, (String)"getKey(...)");
                class_2960 registryName = class_29602;
                if (!(entity instanceof class_1676)) {
                    Intrinsics.checkNotNull((Object)className);
                    if (!StringsKt.contains((CharSequence)className, (CharSequence)"SeatEntity", (boolean)true)) {
                        String string = registryName.method_12832();
                        Intrinsics.checkNotNullExpressionValue((Object)string, (String)"getPath(...)");
                        CharSequence charSequence = string;
                        if (!seatRegistryName.containsMatchIn(charSequence)) break block5;
                    }
                }
                return DefaultShipyardEntityHandler.INSTANCE;
            }
            catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        return default;
    }

    @Nullable
    public final VSEntityHandler getHandler(@NotNull class_2960 type) {
        Intrinsics.checkNotNullParameter((Object)type, (String)"type");
        return entityHandlersNamed.get(type);
    }

    public final void syncHandlers(@NotNull MinecraftPlayer player) {
        Intrinsics.checkNotNullParameter((Object)player, (String)"player");
        class_7922 class_79222 = class_7923.field_41177;
        Intrinsics.checkNotNullExpressionValue((Object)class_79222, (String)"ENTITY_TYPE");
        Map entityTypes = MapsKt.toMap((Sequence)SequencesKt.mapNotNull((Sequence)CollectionsKt.asSequence((Iterable)((Iterable)RangesKt.until((int)0, (int)CollectionsKt.count((Iterable)((Iterable)class_79222))))), VSEntityManager::syncHandlers$lambda$1));
        SimplePacketNetworking $this$syncHandlers_u24lambda_u242 = VSGameUtilsKt.getVsCore().getSimplePacketNetworking();
        boolean bl = false;
        $this$syncHandlers_u24lambda_u242.sendToClient1(new PacketSyncVSEntityTypes(entityTypes), player);
    }

    @JvmStatic
    public static final boolean isShipyardEntity(@NotNull class_1297 entity) {
        Intrinsics.checkNotNullParameter((Object)entity, (String)"entity");
        return Intrinsics.areEqual((Object)INSTANCE.getHandler(entity), (Object)DefaultShipyardEntityHandler.INSTANCE);
    }

    private static final VSEntityHandler getDefaultHandler$lambda$0(class_1297 $entity) {
        Intrinsics.checkNotNullParameter((Object)$entity, (String)"$entity");
        return INSTANCE.determineDefaultHandler($entity);
    }

    private static final Pair syncHandlers$lambda$1(int i2) {
        VSEntityHandler vSEntityHandler = entityHandlers.get(class_7923.field_41177.method_10200(i2));
        if (vSEntityHandler == null) {
            return null;
        }
        VSEntityHandler handler = vSEntityHandler;
        return TuplesKt.to((Object)i2, (Object)String.valueOf(namedEntityHandlers.get(handler)));
    }

    static {
        INSTANCE.register(new class_2960("valkyrienskies", "shipyard"), DefaultShipyardEntityHandler.INSTANCE);
        INSTANCE.register(new class_2960("valkyrienskies", "default"), WorldEntityHandler.INSTANCE);
        seatRegistryName = new Regex("(?<![a-z])(seat|chair)(?![a-z])", RegexOption.IGNORE_CASE);
    }
}

