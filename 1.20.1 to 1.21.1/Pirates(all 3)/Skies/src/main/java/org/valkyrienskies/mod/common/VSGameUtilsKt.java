/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.llamalad7.mixinextras.injector.wrapoperation.Operation
 *  kotlin.Deprecated
 *  kotlin.Metadata
 *  kotlin.ReplaceWith
 *  kotlin.Unit
 *  kotlin.jvm.JvmOverloads
 *  kotlin.jvm.functions.Function0
 *  kotlin.jvm.functions.Function3
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  kotlin.text.StringsKt
 *  net.minecraft.class_1255
 *  net.minecraft.class_1297
 *  net.minecraft.class_1657
 *  net.minecraft.class_1923
 *  net.minecraft.class_1937
 *  net.minecraft.class_2338
 *  net.minecraft.class_2374
 *  net.minecraft.class_238
 *  net.minecraft.class_2382
 *  net.minecraft.class_243
 *  net.minecraft.class_2680
 *  net.minecraft.class_2802
 *  net.minecraft.class_2826
 *  net.minecraft.class_2960
 *  net.minecraft.class_310
 *  net.minecraft.class_3215
 *  net.minecraft.class_3218
 *  net.minecraft.class_5321
 *  net.minecraft.class_638
 *  net.minecraft.server.MinecraftServer
 */
package org.valkyrienskies.mod.common;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import net.minecraft.class_1255;
import net.minecraft.class_1297;
import net.minecraft.class_1657;
import net.minecraft.class_1923;
import net.minecraft.class_1937;
import net.minecraft.class_2338;
import net.minecraft.class_2374;
import net.minecraft.class_238;
import net.minecraft.class_2382;
import net.minecraft.class_243;
import net.minecraft.class_2680;
import net.minecraft.class_2802;
import net.minecraft.class_2826;
import net.minecraft.class_2960;
import net.minecraft.class_310;
import net.minecraft.class_3215;
import net.minecraft.class_3218;
import net.minecraft.class_5321;
import net.minecraft.class_638;
import net.minecraft.server.MinecraftServer;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.joml.Matrix4dc;
import org.joml.Vector3d;
import org.joml.Vector3dc;
import org.joml.Vector3ic;
import org.joml.primitives.AABBd;
import org.joml.primitives.AABBdc;
import org.valkyrienskies.core.api.event.RegisteredListener;
import org.valkyrienskies.core.api.events.TickEndEvent;
import org.valkyrienskies.core.api.ships.ClientShip;
import org.valkyrienskies.core.api.ships.LoadedServerShip;
import org.valkyrienskies.core.api.ships.LoadedShip;
import org.valkyrienskies.core.api.ships.ServerShip;
import org.valkyrienskies.core.api.ships.Ship;
import org.valkyrienskies.core.api.ships.properties.ShipTransform;
import org.valkyrienskies.core.api.util.functions.DoubleTernaryConsumer;
import org.valkyrienskies.core.api.world.LevelYRange;
import org.valkyrienskies.core.internal.VsiCore;
import org.valkyrienskies.core.internal.ships.VsiQueryableShipData;
import org.valkyrienskies.core.internal.world.VsiClientShipWorld;
import org.valkyrienskies.core.internal.world.VsiPipeline;
import org.valkyrienskies.core.internal.world.VsiPlayer;
import org.valkyrienskies.core.internal.world.VsiServerShipWorld;
import org.valkyrienskies.core.internal.world.VsiShipWorld;
import org.valkyrienskies.core.internal.world.chunks.VsiBlockType;
import org.valkyrienskies.core.internal.world.chunks.VsiTerrainUpdate;
import org.valkyrienskies.core.util.AABBdUtilKt;
import org.valkyrienskies.mod.common.BlockStateInfo;
import org.valkyrienskies.mod.common.IShipObjectWorldClientProvider;
import org.valkyrienskies.mod.common.IShipObjectWorldServerProvider;
import org.valkyrienskies.mod.common.ValkyrienSkiesMod;
import org.valkyrienskies.mod.common.entity.ShipMountedToData;
import org.valkyrienskies.mod.common.entity.ShipMountedToDataProvider;
import org.valkyrienskies.mod.common.util.DimensionIdProvider;
import org.valkyrienskies.mod.common.util.EntityDragger;
import org.valkyrienskies.mod.common.util.MinecraftPlayer;
import org.valkyrienskies.mod.common.util.VectorConversionsMCKt;
import org.valkyrienskies.mod.mixin.accessors.resource.ResourceKeyAccessor;
import org.valkyrienskies.mod.mixinducks.world.entity.PlayerDuck;

@Metadata(mv={2, 0, 0}, k=2, xi=48, d1={"\u0000\u00f0\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0006\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u001c\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010%\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a\u001f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\n\u0010\u0002\u001a\u00060\u0000j\u0002`\u0001\u00a2\u0006\u0004\b\u0005\u0010\u0006\u001a'\u0010\u000e\u001a\u00020\r*\u00020\u00072\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\f\u001a\u00020\u000b\u00a2\u0006\u0004\b\u000e\u0010\u000f\u001a\u0019\u0010\u0012\u001a\u00020\t*\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0010\u00a2\u0006\u0004\b\u0012\u0010\u0013\u001a!\u0010\u0012\u001a\u00020\t*\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u0014\u00a2\u0006\u0004\b\u0012\u0010\u0017\u001a\u001f\u0010\u0019\u001a\u0004\u0018\u00010\u0018*\u00020\u00072\n\u0010\u0002\u001a\u00060\u0000j\u0002`\u0001\u00a2\u0006\u0004\b\u0019\u0010\u001a\u001a)\u0010 \u001a\u00020\u001c*\u00020\u001b2\u0006\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001e\u001a\u00020\u001c2\u0006\u0010\u001f\u001a\u00020\u001c\u00a2\u0006\u0004\b \u0010!\u001a3\u0010'\u001a\u00020\u001c*\u0004\u0018\u00010\u00042\u0006\u0010#\u001a\u00020\"2\u0006\u0010$\u001a\u00020\"2\u000e\u0010&\u001a\n\u0012\u0004\u0012\u00020\u001c\u0018\u00010%\u00a2\u0006\u0004\b'\u0010(\u001aC\u0010'\u001a\u00020\u001c*\u0004\u0018\u00010\u00042\u0006\u0010)\u001a\u00020\u001c2\u0006\u0010*\u001a\u00020\u001c2\u0006\u0010+\u001a\u00020\u001c2\u0006\u0010,\u001a\u00020\u001c2\u0006\u0010-\u001a\u00020\u001c2\u0006\u0010.\u001a\u00020\u001c\u00a2\u0006\u0004\b'\u0010/\u001a+\u00102\u001a\u0004\u0018\u0001012\b\u00100\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u0014H\u0002\u00a2\u0006\u0004\b2\u00103\u001a'\u00108\u001a\u00020\r*\u00020\u00042\u0006\u00105\u001a\u0002042\f\u00107\u001a\b\u0012\u0004\u0012\u00020406\u00a2\u0006\u0004\b8\u00109\u001a9\u0010=\u001a\b\u0012\u0004\u0012\u00020<0;*\u0004\u0018\u00010\u00042\u0006\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001e\u001a\u00020\u001c2\u0006\u0010\u001f\u001a\u00020\u001c2\u0006\u0010:\u001a\u00020\u001c\u00a2\u0006\u0004\b=\u0010>\u001a;\u0010=\u001a\u00020\r*\u0004\u0018\u00010\u00042\u0006\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001e\u001a\u00020\u001c2\u0006\u0010\u001f\u001a\u00020\u001c2\u0006\u0010:\u001a\u00020\u001c2\u0006\u00107\u001a\u00020?\u00a2\u0006\u0004\b=\u0010@\u001aW\u0010=\u001a\u00020\r*\u00020\u00042\u0006\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001e\u001a\u00020\u001c2\u0006\u0010\u001f\u001a\u00020\u001c2\u0006\u0010:\u001a\u00020\u001c2\u001e\u00107\u001a\u001a\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\r0AH\u0086\b\u00f8\u0001\u0000\u00a2\u0006\u0004\b=\u0010B\u001a!\u0010C\u001a\u00020\t*\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u0014\u00a2\u0006\u0004\bC\u0010\u0017\u001a)\u0010G\u001a\u00020\t*\u00020\u00042\u0006\u0010D\u001a\u00020\u00142\u0006\u0010E\u001a\u00020\u00142\u0006\u0010F\u001a\u00020\u0014\u00a2\u0006\u0004\bG\u0010H\u001a\u0019\u0010G\u001a\u00020\t*\u00020\u00042\u0006\u0010\u0011\u001a\u00020I\u00a2\u0006\u0004\bG\u0010J\u001a\u0019\u0010G\u001a\u00020\t*\u00020\u00042\u0006\u0010\u0011\u001a\u00020\"\u00a2\u0006\u0004\bG\u0010K\u001a)\u0010G\u001a\u00020\t*\u00020\u00042\u0006\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001e\u001a\u00020\u001c2\u0006\u0010\u001f\u001a\u00020\u001c\u00a2\u0006\u0004\bG\u0010L\u001a%\u0010M\u001a\u0004\u0018\u000101*\u0004\u0018\u00010\u00042\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u0014\u00a2\u0006\u0004\bM\u00103\u001a\u001d\u0010M\u001a\u0004\u0018\u000101*\u0004\u0018\u00010\u00042\u0006\u0010O\u001a\u00020N\u00a2\u0006\u0004\bM\u0010P\u001a\u001d\u0010M\u001a\u0004\u0018\u000101*\u0004\u0018\u00010\u00042\u0006\u0010\u0011\u001a\u00020Q\u00a2\u0006\u0004\bM\u0010R\u001a-\u0010M\u001a\u0004\u0018\u000101*\u0004\u0018\u00010\u00042\u0006\u0010S\u001a\u00020\u001c2\u0006\u0010T\u001a\u00020\u001c2\u0006\u0010U\u001a\u00020\u001c\u00a2\u0006\u0004\bM\u0010V\u001a\u001d\u0010M\u001a\u0004\u0018\u000101*\u0004\u0018\u00010\u00042\u0006\u0010W\u001a\u00020\u0010\u00a2\u0006\u0004\bM\u0010X\u001a'\u0010Y\u001a\u0004\u0018\u000101*\u0004\u0018\u00010\u00042\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u0014H\u0007\u00a2\u0006\u0004\bY\u00103\u001a\u001f\u0010Y\u001a\u0004\u0018\u000101*\u0004\u0018\u00010\u00042\u0006\u0010O\u001a\u00020NH\u0007\u00a2\u0006\u0004\bY\u0010P\u001a\u001f\u0010Y\u001a\u0004\u0018\u000101*\u0004\u0018\u00010\u00042\u0006\u0010\u0011\u001a\u00020QH\u0007\u00a2\u0006\u0004\bY\u0010R\u001a/\u0010Y\u001a\u0004\u0018\u000101*\u0004\u0018\u00010\u00042\u0006\u0010S\u001a\u00020\u001c2\u0006\u0010T\u001a\u00020\u001c2\u0006\u0010U\u001a\u00020\u001cH\u0007\u00a2\u0006\u0004\bY\u0010V\u001a\u001f\u0010Y\u001a\u0004\u0018\u000101*\u0004\u0018\u00010\u00042\u0006\u0010W\u001a\u00020\u0010H\u0007\u00a2\u0006\u0004\bY\u0010X\u001a%\u0010M\u001a\u0004\u0018\u00010[*\u0004\u0018\u00010Z2\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u0014\u00a2\u0006\u0004\bM\u0010\\\u001a\u001d\u0010M\u001a\u0004\u0018\u00010[*\u0004\u0018\u00010Z2\u0006\u0010O\u001a\u00020N\u00a2\u0006\u0004\bM\u0010]\u001a-\u0010M\u001a\u0004\u0018\u00010[*\u0004\u0018\u00010Z2\u0006\u0010S\u001a\u00020\u001c2\u0006\u0010T\u001a\u00020\u001c2\u0006\u0010U\u001a\u00020\u001c\u00a2\u0006\u0004\bM\u0010^\u001a\u001d\u0010M\u001a\u0004\u0018\u00010[*\u0004\u0018\u00010Z2\u0006\u0010\u0011\u001a\u00020Q\u00a2\u0006\u0004\bM\u0010_\u001a\u001d\u0010M\u001a\u0004\u0018\u00010[*\u0004\u0018\u00010Z2\u0006\u0010\u0011\u001a\u00020`\u00a2\u0006\u0004\bM\u0010a\u001a\u001d\u0010M\u001a\u0004\u0018\u00010[*\u0004\u0018\u00010Z2\u0006\u0010W\u001a\u00020\u0010\u00a2\u0006\u0004\bM\u0010b\u001a'\u0010Y\u001a\u0004\u0018\u00010[*\u0004\u0018\u00010Z2\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u0014H\u0007\u00a2\u0006\u0004\bY\u0010\\\u001a\u001f\u0010Y\u001a\u0004\u0018\u00010[*\u0004\u0018\u00010Z2\u0006\u0010O\u001a\u00020NH\u0007\u00a2\u0006\u0004\bY\u0010]\u001a/\u0010Y\u001a\u0004\u0018\u00010[*\u0004\u0018\u00010Z2\u0006\u0010S\u001a\u00020\u001c2\u0006\u0010T\u001a\u00020\u001c2\u0006\u0010U\u001a\u00020\u001cH\u0007\u00a2\u0006\u0004\bY\u0010^\u001a\u001f\u0010Y\u001a\u0004\u0018\u00010[*\u0004\u0018\u00010Z2\u0006\u0010\u0011\u001a\u00020QH\u0007\u00a2\u0006\u0004\bY\u0010_\u001a\u001f\u0010Y\u001a\u0004\u0018\u00010[*\u0004\u0018\u00010Z2\u0006\u0010\u0011\u001a\u00020`H\u0007\u00a2\u0006\u0004\bY\u0010a\u001a\u001f\u0010Y\u001a\u0004\u0018\u00010[*\u0004\u0018\u00010Z2\u0006\u0010W\u001a\u00020\u0010H\u0007\u00a2\u0006\u0004\bY\u0010b\u001a%\u0010M\u001a\u0004\u0018\u00010c*\u0004\u0018\u00010\u00182\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u0014\u00a2\u0006\u0004\bM\u0010d\u001a\u001d\u0010M\u001a\u0004\u0018\u00010c*\u0004\u0018\u00010\u00182\u0006\u0010O\u001a\u00020N\u00a2\u0006\u0004\bM\u0010e\u001a\u001d\u0010M\u001a\u0004\u0018\u00010c*\u0004\u0018\u00010\u00182\u0006\u0010W\u001a\u00020\u0010\u00a2\u0006\u0004\bM\u0010f\u001a-\u0010M\u001a\u0004\u0018\u00010c*\u0004\u0018\u00010\u00182\u0006\u0010S\u001a\u00020\u001c2\u0006\u0010T\u001a\u00020\u001c2\u0006\u0010U\u001a\u00020\u001c\u00a2\u0006\u0004\bM\u0010g\u001a\u001d\u0010M\u001a\u0004\u0018\u00010c*\u0004\u0018\u00010\u00182\u0006\u0010\u0011\u001a\u00020Q\u00a2\u0006\u0004\bM\u0010h\u001a'\u0010Y\u001a\u0004\u0018\u00010c*\u0004\u0018\u00010\u00182\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u0014H\u0007\u00a2\u0006\u0004\bY\u0010d\u001a\u001f\u0010Y\u001a\u0004\u0018\u00010c*\u0004\u0018\u00010\u00182\u0006\u0010O\u001a\u00020NH\u0007\u00a2\u0006\u0004\bY\u0010e\u001a\u001f\u0010Y\u001a\u0004\u0018\u00010c*\u0004\u0018\u00010\u00182\u0006\u0010W\u001a\u00020\u0010H\u0007\u00a2\u0006\u0004\bY\u0010f\u001a/\u0010Y\u001a\u0004\u0018\u00010c*\u0004\u0018\u00010\u00182\u0006\u0010S\u001a\u00020\u001c2\u0006\u0010T\u001a\u00020\u001c2\u0006\u0010U\u001a\u00020\u001cH\u0007\u00a2\u0006\u0004\bY\u0010g\u001a\u001f\u0010Y\u001a\u0004\u0018\u00010c*\u0004\u0018\u00010\u00182\u0006\u0010\u0011\u001a\u00020QH\u0007\u00a2\u0006\u0004\bY\u0010h\u001a+\u0010j\u001a\u0004\u0018\u00010i2\b\u00100\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u001d\u001a\u00020\u00142\u0006\u0010\u001f\u001a\u00020\u0014H\u0002\u00a2\u0006\u0004\bj\u0010k\u001a#\u0010l\u001a\u000204*\u0004\u0018\u00010Z2\u0006\u0010\u0011\u001a\u00020`2\u0006\u00105\u001a\u000204\u00a2\u0006\u0004\bl\u0010m\u001a\u0015\u0010n\u001a\u0004\u0018\u00010i*\u0004\u0018\u00010\u001b\u00a2\u0006\u0004\bn\u0010o\u001a%\u0010p\u001a\u0004\u0018\u00010i*\u0004\u0018\u00010\u00042\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u0014\u00a2\u0006\u0004\bp\u0010k\u001a\u001d\u0010p\u001a\u0004\u0018\u00010i*\u0004\u0018\u00010\u00042\u0006\u0010O\u001a\u00020I\u00a2\u0006\u0004\bp\u0010q\u001a\u001d\u0010p\u001a\u0004\u0018\u00010i*\u0004\u0018\u00010\u00042\u0006\u0010\u0011\u001a\u00020`\u00a2\u0006\u0004\bp\u0010r\u001a\u001d\u0010p\u001a\u0004\u0018\u00010i*\u0004\u0018\u00010\u00042\u0006\u0010\u0011\u001a\u00020Q\u00a2\u0006\u0004\bp\u0010s\u001a-\u0010p\u001a\u0004\u0018\u00010i*\u0004\u0018\u00010\u00042\u0006\u0010S\u001a\u00020\u001c2\u0006\u0010T\u001a\u00020\u001c2\u0006\u0010U\u001a\u00020\u001c\u00a2\u0006\u0004\bp\u0010t\u001a-\u0010p\u001a\u0004\u0018\u00010i*\u0004\u0018\u00010\u00042\u0006\u0010S\u001a\u00020u2\u0006\u0010T\u001a\u00020u2\u0006\u0010U\u001a\u00020u\u00a2\u0006\u0004\bp\u0010v\u001a\u001d\u0010p\u001a\u0004\u0018\u00010i*\u0004\u0018\u00010\u00042\u0006\u0010W\u001a\u00020\u0010\u00a2\u0006\u0004\bp\u0010w\u001a%\u0010p\u001a\u0004\u0018\u00010x*\u0004\u0018\u00010\u00182\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u0014\u00a2\u0006\u0004\bp\u0010y\u001a\u001d\u0010p\u001a\u0004\u0018\u00010x*\u0004\u0018\u00010\u00182\u0006\u0010O\u001a\u00020I\u00a2\u0006\u0004\bp\u0010z\u001a\u001d\u0010p\u001a\u0004\u0018\u00010x*\u0004\u0018\u00010\u00182\u0006\u0010\u0011\u001a\u00020Q\u00a2\u0006\u0004\bp\u0010{\u001a-\u0010p\u001a\u0004\u0018\u00010x*\u0004\u0018\u00010\u00182\u0006\u0010S\u001a\u00020\u001c2\u0006\u0010T\u001a\u00020\u001c2\u0006\u0010U\u001a\u00020\u001c\u00a2\u0006\u0004\bp\u0010|\u001a\u001d\u0010p\u001a\u0004\u0018\u00010x*\u0004\u0018\u00010\u00182\u0006\u0010W\u001a\u00020\u0010\u00a2\u0006\u0004\bp\u0010}\u001a\u0019\u0010~\u001a\u00020<*\u00020i2\u0006\u0010\u0011\u001a\u00020I\u00a2\u0006\u0004\b~\u0010\u007f\u001a\u001a\u0010~\u001a\u00020\"*\u00020i2\u0006\u0010\u0011\u001a\u00020\"\u00a2\u0006\u0005\b~\u0010\u0080\u0001\u001a\u001c\u0010~\u001a\u00020\"*\u0004\u0018\u00010\u00042\u0006\u0010\u0011\u001a\u00020I\u00a2\u0006\u0005\b~\u0010\u0081\u0001\u001a\u001c\u0010~\u001a\u00020\"*\u0004\u0018\u00010\u00042\u0006\u0010\u0011\u001a\u00020\"\u00a2\u0006\u0005\b~\u0010\u0082\u0001\u001a'\u0010\u0084\u0001\u001a\u00020\"*\u0004\u0018\u00010Z2\u0007\u0010\u0083\u0001\u001a\u00020\"2\u0006\u0010\u0011\u001a\u00020\"\u00a2\u0006\u0006\b\u0084\u0001\u0010\u0085\u0001\u001a\u001c\u0010~\u001a\u00020<*\u0004\u0018\u00010\u00042\u0006\u0010\u0011\u001a\u00020<\u00a2\u0006\u0005\b~\u0010\u0086\u0001\u001a9\u0010~\u001a\u00020<*\u0004\u0018\u00010\u00042\u0006\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001e\u001a\u00020\u001c2\u0006\u0010\u001f\u001a\u00020\u001c2\t\b\u0002\u0010\u0087\u0001\u001a\u00020<H\u0007\u00a2\u0006\u0005\b~\u0010\u0088\u0001\u001a7\u0010~\u001a\u00020<*\u00020i2\u0006\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001e\u001a\u00020\u001c2\u0006\u0010\u001f\u001a\u00020\u001c2\t\b\u0002\u0010\u0087\u0001\u001a\u00020<H\u0007\u00a2\u0006\u0005\b~\u0010\u0089\u0001\u001a\u001f\u0010\u008d\u0001\u001a\u00030\u008c\u0001*\u00030\u008a\u00012\u0007\u0010W\u001a\u00030\u008b\u0001\u00a2\u0006\u0006\b\u008d\u0001\u0010\u008e\u0001\u001a&\u0010\u008f\u0001\u001a\u00020<*\u0004\u0018\u00010\u00042\u0006\u0010O\u001a\u00020I2\u0006\u0010\u0011\u001a\u00020<\u00a2\u0006\u0006\b\u008f\u0001\u0010\u0090\u0001\u001a#\u0010\u0092\u0001\u001a\t\u0012\u0004\u0012\u00020i0\u0091\u0001*\u00020\u00042\u0006\u00105\u001a\u000204\u00a2\u0006\u0006\b\u0092\u0001\u0010\u0093\u0001\u001a$\u0010\u0092\u0001\u001a\t\u0012\u0004\u0012\u00020i0\u0091\u0001*\u00020\u00042\u0007\u00105\u001a\u00030\u0094\u0001\u00a2\u0006\u0006\b\u0092\u0001\u0010\u0095\u0001\u001a\u001e\u0010\u0096\u0001\u001a\u000204*\u0004\u0018\u00010\u00042\u0006\u00105\u001a\u000204\u00a2\u0006\u0006\b\u0096\u0001\u0010\u0097\u0001\u001a \u0010\u0096\u0001\u001a\u00030\u0098\u0001*\u0004\u0018\u00010\u00042\u0007\u00105\u001a\u00030\u0098\u0001\u00a2\u0006\u0006\b\u0096\u0001\u0010\u0099\u0001\u001a*\u0010\u0096\u0001\u001a\u00030\u0098\u0001*\u0004\u0018\u00010\u00042\u0007\u00105\u001a\u00030\u0094\u00012\b\u0010\u0087\u0001\u001a\u00030\u0098\u0001\u00a2\u0006\u0006\b\u0096\u0001\u0010\u009a\u0001\u001a\u001d\u0010\u009c\u0001\u001a\u00020\r*\u00020\u00042\u0007\u0010\u009b\u0001\u001a\u00020\u000b\u00a2\u0006\u0006\b\u009c\u0001\u0010\u009d\u0001\u001a)\u0010\u00a1\u0001\u001a\u0005\u0018\u00010\u00a0\u00012\u0007\u0010\u009e\u0001\u001a\u00020\u001b2\u000b\b\u0002\u0010\u009f\u0001\u001a\u0004\u0018\u00010u\u00a2\u0006\u0006\b\u00a1\u0001\u0010\u00a2\u0001\u001a\u001b\u0010\u00a4\u0001\u001a\u0004\u0018\u0001012\u0007\u0010\u00a3\u0001\u001a\u00020\u001b\u00a2\u0006\u0006\b\u00a4\u0001\u0010\u00a5\u0001\u001a!\u0010\u00a7\u0001\u001a\u00020\r*\u0004\u0018\u00010\u001b2\t\u0010\u00a6\u0001\u001a\u0004\u0018\u00010i\u00a2\u0006\u0006\b\u00a7\u0001\u0010\u00a8\u0001\u001a\u0017\u0010\u00aa\u0001\u001a\u00020\t*\u0005\u0018\u00010\u00a9\u0001\u00a2\u0006\u0006\b\u00aa\u0001\u0010\u00ab\u0001\"\u0015\u0010\u00af\u0001\u001a\u00030\u00ac\u00018F\u00a2\u0006\b\u001a\u0006\b\u00ad\u0001\u0010\u00ae\u0001\"\u001d\u0010\u00b3\u0001\u001a\u0005\u0018\u00010\u00b0\u0001*\u0004\u0018\u00010\u00048F\u00a2\u0006\b\u001a\u0006\b\u00b1\u0001\u0010\u00b2\u0001\"\u001b\u0010\u00b5\u0001\u001a\u00030\u00b0\u0001*\u0004\u0018\u00010\u00048F\u00a2\u0006\b\u001a\u0006\b\u00b4\u0001\u0010\u00b2\u0001\"!\u0010\u00b9\u0001\u001a\t\u0012\u0004\u0012\u00020i0\u00b6\u0001*\u0004\u0018\u00010\u00048F\u00a2\u0006\b\u001a\u0006\b\u00b7\u0001\u0010\u00b8\u0001\"\u0019\u0010\u00b5\u0001\u001a\u00030\u00ba\u0001*\u00020\u00078F\u00a2\u0006\b\u001a\u0006\b\u00b4\u0001\u0010\u00bb\u0001\"\u0019\u0010\u00bf\u0001\u001a\u00030\u00bc\u0001*\u00020\u00078F\u00a2\u0006\b\u001a\u0006\b\u00bd\u0001\u0010\u00be\u0001\"\u001b\u0010\u00b5\u0001\u001a\u00030\u00ba\u0001*\u0004\u0018\u00010\u00188F\u00a2\u0006\b\u001a\u0006\b\u00b4\u0001\u0010\u00c0\u0001\"\u001b\u0010\u0002\u001a\u00060\u0000j\u0002`\u0001*\u00020\u00048F\u00a2\u0006\b\u001a\u0006\b\u00c1\u0001\u0010\u00c2\u0001\".\u0010\u00c4\u0001\u001a\u0019\u0012\b\u0012\u00060\u0000j\u0002`\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u00c3\u00018\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u00c4\u0001\u0010\u00c5\u0001\"\u0019\u0010\u00c9\u0001\u001a\u00030\u00c6\u0001*\u00020\u00048F\u00a2\u0006\b\u001a\u0006\b\u00c7\u0001\u0010\u00c8\u0001\"\u001a\u0010\u00b5\u0001\u001a\u00030\u00cb\u0001*\u00030\u00ca\u00018F\u00a2\u0006\b\u001a\u0006\b\u00b4\u0001\u0010\u00cc\u0001\"\u001b\u0010\u00b5\u0001\u001a\u00030\u00cb\u0001*\u0004\u0018\u00010Z8F\u00a2\u0006\b\u001a\u0006\b\u00b4\u0001\u0010\u00cd\u0001\"\u001a\u0010\u00d2\u0001\u001a\u00030\u00cf\u0001*\u00030\u00ce\u00018F\u00a2\u0006\b\u001a\u0006\b\u00d0\u0001\u0010\u00d1\u0001\"$\u0010\u00d7\u0001\u001a\r \u00d4\u0001*\u0005\u0018\u00010\u00d3\u00010\u00d3\u0001*\u00030\u00cf\u00018F\u00a2\u0006\b\u001a\u0006\b\u00d5\u0001\u0010\u00d6\u0001\u0082\u0002\u0007\n\u0005\b\u009920\u0001\u00a8\u0006\u00d8\u0001"}, d2={"", "Lorg/valkyrienskies/core/api/world/properties/DimensionId;", "dimensionId", "Lnet/minecraft/class_5321;", "Lnet/minecraft/class_1937;", "getResourceKey", "(Ljava/lang/String;)Lnet/minecraft/class_5321;", "Lnet/minecraft/server/MinecraftServer;", "Lkotlin/Function0;", "", "condition", "Ljava/lang/Runnable;", "toExecute", "", "executeIf", "(Lnet/minecraft/server/MinecraftServer;Lkotlin/jvm/functions/Function0;Ljava/lang/Runnable;)V", "Lnet/minecraft/class_1923;", "pos", "isTickingChunk", "(Lnet/minecraft/class_1937;Lnet/minecraft/class_1923;)Z", "", "chunkX", "chunkZ", "(Lnet/minecraft/class_1937;II)Z", "Lnet/minecraft/class_3218;", "getLevelFromDimensionId", "(Lnet/minecraft/server/MinecraftServer;Ljava/lang/String;)Lnet/minecraft/class_3218;", "Lnet/minecraft/class_1297;", "", "x", "y", "z", "squaredDistanceToInclShips", "(Lnet/minecraft/class_1297;DDD)D", "Lnet/minecraft/class_243;", "v1", "v2", "Lcom/llamalad7/mixinextras/injector/wrapoperation/Operation;", "originalDistance", "squaredDistanceBetweenInclShips", "(Lnet/minecraft/class_1937;Lnet/minecraft/class_243;Lnet/minecraft/class_243;Lcom/llamalad7/mixinextras/injector/wrapoperation/Operation;)D", "x1", "y1", "z1", "x2", "y2", "z2", "(Lnet/minecraft/class_1937;DDDDDD)D", "world", "Lorg/valkyrienskies/core/api/ships/LoadedShip;", "getShipObjectManagingPosImpl", "(Lnet/minecraft/class_1937;II)Lorg/valkyrienskies/core/api/ships/LoadedShip;", "Lnet/minecraft/class_238;", "aabb", "Ljava/util/function/Consumer;", "cb", "transformFromWorldToNearbyShipsAndWorld", "(Lnet/minecraft/class_1937;Lnet/minecraft/class_238;Ljava/util/function/Consumer;)V", "aabbRadius", "", "Lorg/joml/Vector3d;", "transformToNearbyShipsAndWorld", "(Lnet/minecraft/class_1937;DDDD)Ljava/util/List;", "Lorg/valkyrienskies/core/api/util/functions/DoubleTernaryConsumer;", "(Lnet/minecraft/class_1937;DDDDLorg/valkyrienskies/core/api/util/functions/DoubleTernaryConsumer;)V", "Lkotlin/Function3;", "(Lnet/minecraft/class_1937;DDDDLkotlin/jvm/functions/Function3;)V", "isChunkInShipyard", "blockX", "blockY", "blockZ", "isBlockInShipyard", "(Lnet/minecraft/class_1937;III)Z", "Lnet/minecraft/class_2338;", "(Lnet/minecraft/class_1937;Lnet/minecraft/class_2338;)Z", "(Lnet/minecraft/class_1937;Lnet/minecraft/class_243;)Z", "(Lnet/minecraft/class_1937;DDD)Z", "getLoadedShipManagingPos", "Lnet/minecraft/class_2382;", "blockPos", "(Lnet/minecraft/class_1937;Lnet/minecraft/class_2382;)Lorg/valkyrienskies/core/api/ships/LoadedShip;", "Lorg/joml/Vector3dc;", "(Lnet/minecraft/class_1937;Lorg/joml/Vector3dc;)Lorg/valkyrienskies/core/api/ships/LoadedShip;", "posX", "posY", "posZ", "(Lnet/minecraft/class_1937;DDD)Lorg/valkyrienskies/core/api/ships/LoadedShip;", "chunkPos", "(Lnet/minecraft/class_1937;Lnet/minecraft/class_1923;)Lorg/valkyrienskies/core/api/ships/LoadedShip;", "getShipObjectManagingPos", "Lnet/minecraft/class_638;", "Lorg/valkyrienskies/core/api/ships/ClientShip;", "(Lnet/minecraft/class_638;II)Lorg/valkyrienskies/core/api/ships/ClientShip;", "(Lnet/minecraft/class_638;Lnet/minecraft/class_2382;)Lorg/valkyrienskies/core/api/ships/ClientShip;", "(Lnet/minecraft/class_638;DDD)Lorg/valkyrienskies/core/api/ships/ClientShip;", "(Lnet/minecraft/class_638;Lorg/joml/Vector3dc;)Lorg/valkyrienskies/core/api/ships/ClientShip;", "Lnet/minecraft/class_2374;", "(Lnet/minecraft/class_638;Lnet/minecraft/class_2374;)Lorg/valkyrienskies/core/api/ships/ClientShip;", "(Lnet/minecraft/class_638;Lnet/minecraft/class_1923;)Lorg/valkyrienskies/core/api/ships/ClientShip;", "Lorg/valkyrienskies/core/api/ships/LoadedServerShip;", "(Lnet/minecraft/class_3218;II)Lorg/valkyrienskies/core/api/ships/LoadedServerShip;", "(Lnet/minecraft/class_3218;Lnet/minecraft/class_2382;)Lorg/valkyrienskies/core/api/ships/LoadedServerShip;", "(Lnet/minecraft/class_3218;Lnet/minecraft/class_1923;)Lorg/valkyrienskies/core/api/ships/LoadedServerShip;", "(Lnet/minecraft/class_3218;DDD)Lorg/valkyrienskies/core/api/ships/LoadedServerShip;", "(Lnet/minecraft/class_3218;Lorg/joml/Vector3dc;)Lorg/valkyrienskies/core/api/ships/LoadedServerShip;", "Lorg/valkyrienskies/core/api/ships/Ship;", "getShipManagingPosImpl", "(Lnet/minecraft/class_1937;II)Lorg/valkyrienskies/core/api/ships/Ship;", "transformRenderAABBToWorld", "(Lnet/minecraft/class_638;Lnet/minecraft/class_2374;Lnet/minecraft/class_238;)Lnet/minecraft/class_238;", "getShipManaging", "(Lnet/minecraft/class_1297;)Lorg/valkyrienskies/core/api/ships/Ship;", "getShipManagingPos", "(Lnet/minecraft/class_1937;Lnet/minecraft/class_2338;)Lorg/valkyrienskies/core/api/ships/Ship;", "(Lnet/minecraft/class_1937;Lnet/minecraft/class_2374;)Lorg/valkyrienskies/core/api/ships/Ship;", "(Lnet/minecraft/class_1937;Lorg/joml/Vector3dc;)Lorg/valkyrienskies/core/api/ships/Ship;", "(Lnet/minecraft/class_1937;DDD)Lorg/valkyrienskies/core/api/ships/Ship;", "", "(Lnet/minecraft/class_1937;FFF)Lorg/valkyrienskies/core/api/ships/Ship;", "(Lnet/minecraft/class_1937;Lnet/minecraft/class_1923;)Lorg/valkyrienskies/core/api/ships/Ship;", "Lorg/valkyrienskies/core/api/ships/ServerShip;", "(Lnet/minecraft/class_3218;II)Lorg/valkyrienskies/core/api/ships/ServerShip;", "(Lnet/minecraft/class_3218;Lnet/minecraft/class_2338;)Lorg/valkyrienskies/core/api/ships/ServerShip;", "(Lnet/minecraft/class_3218;Lorg/joml/Vector3dc;)Lorg/valkyrienskies/core/api/ships/ServerShip;", "(Lnet/minecraft/class_3218;DDD)Lorg/valkyrienskies/core/api/ships/ServerShip;", "(Lnet/minecraft/class_3218;Lnet/minecraft/class_1923;)Lorg/valkyrienskies/core/api/ships/ServerShip;", "toWorldCoordinates", "(Lorg/valkyrienskies/core/api/ships/Ship;Lnet/minecraft/class_2338;)Lorg/joml/Vector3d;", "(Lorg/valkyrienskies/core/api/ships/Ship;Lnet/minecraft/class_243;)Lnet/minecraft/class_243;", "(Lnet/minecraft/class_1937;Lnet/minecraft/class_2338;)Lnet/minecraft/class_243;", "(Lnet/minecraft/class_1937;Lnet/minecraft/class_243;)Lnet/minecraft/class_243;", "shipPos", "toShipRenderCoordinates", "(Lnet/minecraft/class_638;Lnet/minecraft/class_243;Lnet/minecraft/class_243;)Lnet/minecraft/class_243;", "(Lnet/minecraft/class_1937;Lorg/joml/Vector3d;)Lorg/joml/Vector3d;", "dest", "(Lnet/minecraft/class_1937;DDDLorg/joml/Vector3d;)Lorg/joml/Vector3d;", "(Lorg/valkyrienskies/core/api/ships/Ship;DDDLorg/joml/Vector3d;)Lorg/joml/Vector3d;", "Lnet/minecraft/class_2826;", "Lorg/joml/Vector3ic;", "Lorg/valkyrienskies/core/internal/world/chunks/VsiTerrainUpdate;", "toDenseVoxelUpdate", "(Lnet/minecraft/class_2826;Lorg/joml/Vector3ic;)Lorg/valkyrienskies/core/internal/world/chunks/VsiTerrainUpdate;", "getWorldCoordinates", "(Lnet/minecraft/class_1937;Lnet/minecraft/class_2338;Lorg/joml/Vector3d;)Lorg/joml/Vector3d;", "", "getShipsIntersecting", "(Lnet/minecraft/class_1937;Lnet/minecraft/class_238;)Ljava/lang/Iterable;", "Lorg/joml/primitives/AABBdc;", "(Lnet/minecraft/class_1937;Lorg/joml/primitives/AABBdc;)Ljava/lang/Iterable;", "transformAabbToWorld", "(Lnet/minecraft/class_1937;Lnet/minecraft/class_238;)Lnet/minecraft/class_238;", "Lorg/joml/primitives/AABBd;", "(Lnet/minecraft/class_1937;Lorg/joml/primitives/AABBd;)Lorg/joml/primitives/AABBd;", "(Lnet/minecraft/class_1937;Lorg/joml/primitives/AABBdc;Lorg/joml/primitives/AABBd;)Lorg/joml/primitives/AABBd;", "runnable", "executeOrSchedule", "(Lnet/minecraft/class_1937;Ljava/lang/Runnable;)V", "passenger", "partialTicks", "Lorg/valkyrienskies/mod/common/entity/ShipMountedToData;", "getShipMountedToData", "(Lnet/minecraft/class_1297;Ljava/lang/Float;)Lorg/valkyrienskies/mod/common/entity/ShipMountedToData;", "entity", "getShipMountedTo", "(Lnet/minecraft/class_1297;)Lorg/valkyrienskies/core/api/ships/LoadedShip;", "ship", "applyShipVelocity", "(Lnet/minecraft/class_1297;Lorg/valkyrienskies/core/api/ships/Ship;)V", "Lnet/minecraft/class_2680;", "inAssemblyBlacklist", "(Lnet/minecraft/class_2680;)Z", "Lorg/valkyrienskies/core/internal/VsiCore;", "getVsCore", "()Lorg/valkyrienskies/core/internal/VsiCore;", "vsCore", "Lorg/valkyrienskies/core/internal/world/VsiShipWorld;", "getShipWorldNullable", "(Lnet/minecraft/class_1937;)Lorg/valkyrienskies/core/internal/world/VsiShipWorld;", "shipWorldNullable", "getShipObjectWorld", "shipObjectWorld", "Lorg/valkyrienskies/core/internal/ships/VsiQueryableShipData;", "getAllShips", "(Lnet/minecraft/class_1937;)Lorg/valkyrienskies/core/internal/ships/VsiQueryableShipData;", "allShips", "Lorg/valkyrienskies/core/internal/world/VsiServerShipWorld;", "(Lnet/minecraft/server/MinecraftServer;)Lorg/valkyrienskies/core/internal/world/VsiServerShipWorld;", "Lorg/valkyrienskies/core/internal/world/VsiPipeline;", "getVsPipeline", "(Lnet/minecraft/server/MinecraftServer;)Lorg/valkyrienskies/core/internal/world/VsiPipeline;", "vsPipeline", "(Lnet/minecraft/class_3218;)Lorg/valkyrienskies/core/internal/world/VsiServerShipWorld;", "getDimensionId", "(Lnet/minecraft/class_1937;)Ljava/lang/String;", "", "levelResourceKeyMap", "Ljava/util/Map;", "Lorg/valkyrienskies/core/api/world/LevelYRange;", "getYRange", "(Lnet/minecraft/class_1937;)Lorg/valkyrienskies/core/api/world/LevelYRange;", "yRange", "Lnet/minecraft/class_310;", "Lorg/valkyrienskies/core/internal/world/VsiClientShipWorld;", "(Lnet/minecraft/class_310;)Lorg/valkyrienskies/core/internal/world/VsiClientShipWorld;", "(Lnet/minecraft/class_638;)Lorg/valkyrienskies/core/internal/world/VsiClientShipWorld;", "Lorg/valkyrienskies/core/internal/world/VsiPlayer;", "Lnet/minecraft/class_1657;", "getMcPlayer", "(Lorg/valkyrienskies/core/internal/world/VsiPlayer;)Lnet/minecraft/class_1657;", "mcPlayer", "Lorg/valkyrienskies/mod/common/util/MinecraftPlayer;", "kotlin.jvm.PlatformType", "getPlayerWrapper", "(Lnet/minecraft/class_1657;)Lorg/valkyrienskies/mod/common/util/MinecraftPlayer;", "playerWrapper", "valkyrienskies-120"})
@SourceDebugExtension(value={"SMAP\nVSGameUtils.kt\nKotlin\n*S Kotlin\n*F\n+ 1 VSGameUtils.kt\norg/valkyrienskies/mod/common/VSGameUtilsKt\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,549:1\n229#1,18:552\n229#1,18:570\n1863#2,2:550\n1#3:588\n*S KotlinDebug\n*F\n+ 1 VSGameUtils.kt\norg/valkyrienskies/mod/common/VSGameUtilsKt\n*L\n215#1:552,18\n223#1:570,18\n207#1:550,2\n*E\n"})
public final class VSGameUtilsKt {
    @NotNull
    private static final Map<String, class_5321<class_1937>> levelResourceKeyMap = new HashMap();

    @NotNull
    public static final VsiCore getVsCore() {
        return ValkyrienSkiesMod.getVsCore();
    }

    @Nullable
    public static final VsiShipWorld getShipWorldNullable(@Nullable class_1937 $this$shipWorldNullable) {
        VsiShipWorld vsiShipWorld;
        if ($this$shipWorldNullable == null) {
            vsiShipWorld = null;
        } else if ($this$shipWorldNullable instanceof class_3218) {
            MinecraftServer minecraftServer = ((class_3218)$this$shipWorldNullable).method_8503();
            Intrinsics.checkNotNullExpressionValue((Object)minecraftServer, (String)"getServer(...)");
            vsiShipWorld = VSGameUtilsKt.getShipObjectWorld(minecraftServer);
        } else {
            vsiShipWorld = $this$shipWorldNullable.field_9236 && $this$shipWorldNullable instanceof class_638 ? (VsiShipWorld)VSGameUtilsKt.getShipObjectWorld((class_638)$this$shipWorldNullable) : null;
        }
        return vsiShipWorld;
    }

    @NotNull
    public static final VsiShipWorld getShipObjectWorld(@Nullable class_1937 $this$shipObjectWorld) {
        VsiShipWorld vsiShipWorld = VSGameUtilsKt.getShipWorldNullable($this$shipObjectWorld);
        if (vsiShipWorld == null) {
            vsiShipWorld = VSGameUtilsKt.getVsCore().getDummyShipWorldClient();
        }
        return vsiShipWorld;
    }

    @NotNull
    public static final VsiQueryableShipData<Ship> getAllShips(@Nullable class_1937 $this$allShips) {
        return VSGameUtilsKt.getShipObjectWorld($this$allShips).getAllShips();
    }

    @NotNull
    public static final VsiServerShipWorld getShipObjectWorld(@NotNull MinecraftServer $this$shipObjectWorld) {
        Intrinsics.checkNotNullParameter((Object)$this$shipObjectWorld, (String)"<this>");
        VsiServerShipWorld vsiServerShipWorld = ((IShipObjectWorldServerProvider)$this$shipObjectWorld).getShipObjectWorld();
        if (vsiServerShipWorld == null) {
            vsiServerShipWorld = VSGameUtilsKt.getVsCore().getDummyShipWorldServer();
        }
        return vsiServerShipWorld;
    }

    @NotNull
    public static final VsiPipeline getVsPipeline(@NotNull MinecraftServer $this$vsPipeline) {
        Intrinsics.checkNotNullParameter((Object)$this$vsPipeline, (String)"<this>");
        VsiPipeline vsiPipeline = ((IShipObjectWorldServerProvider)$this$vsPipeline).getVsPipeline();
        Intrinsics.checkNotNull((Object)vsiPipeline);
        return vsiPipeline;
    }

    @NotNull
    public static final VsiServerShipWorld getShipObjectWorld(@Nullable class_3218 $this$shipObjectWorld) {
        Object object = $this$shipObjectWorld;
        if (object == null || (object = object.method_8503()) == null || (object = VSGameUtilsKt.getShipObjectWorld((MinecraftServer)object)) == null) {
            object = VSGameUtilsKt.getVsCore().getDummyShipWorldServer();
        }
        return object;
    }

    @NotNull
    public static final String getDimensionId(@NotNull class_1937 $this$dimensionId) {
        Intrinsics.checkNotNullParameter((Object)$this$dimensionId, (String)"<this>");
        DimensionIdProvider cfr_ignored_0 = (DimensionIdProvider)$this$dimensionId;
        return ((DimensionIdProvider)$this$dimensionId).getDimensionId();
    }

    @NotNull
    public static final class_5321<class_1937> getResourceKey(@NotNull String dimensionId) {
        Intrinsics.checkNotNullParameter((Object)dimensionId, (String)"dimensionId");
        class_5321<class_1937> cached = levelResourceKeyMap.get(dimensionId);
        if (cached == null) {
            String[] stringArray = new String[]{":"};
            List list = StringsKt.split$default((CharSequence)dimensionId, (String[])stringArray, (boolean)false, (int)0, (int)6, null);
            String registryNamespace = (String)list.get(0);
            String registryName = (String)list.get(1);
            String namespace = (String)list.get(2);
            String name = (String)list.get(3);
            class_5321 class_53212 = ResourceKeyAccessor.callCreate(new class_2960(registryNamespace, registryName), new class_2960(namespace, name));
            Intrinsics.checkNotNullExpressionValue(class_53212, (String)"callCreate(...)");
            class_5321 toReturn = class_53212;
            levelResourceKeyMap.put(dimensionId, toReturn);
            return toReturn;
        }
        return cached;
    }

    public static final void executeIf(@NotNull MinecraftServer $this$executeIf, @NotNull Function0<Boolean> condition, @NotNull Runnable toExecute) {
        Intrinsics.checkNotNullParameter((Object)$this$executeIf, (String)"<this>");
        Intrinsics.checkNotNullParameter(condition, (String)"condition");
        Intrinsics.checkNotNullParameter((Object)toExecute, (String)"toExecute");
        VSGameUtilsKt.getVsCore().getTickEndEvent().on((arg_0, arg_1) -> VSGameUtilsKt.executeIf$lambda$0($this$executeIf, condition, toExecute, arg_0, arg_1));
    }

    @NotNull
    public static final LevelYRange getYRange(@NotNull class_1937 $this$yRange) {
        Intrinsics.checkNotNullParameter((Object)$this$yRange, (String)"<this>");
        return new LevelYRange($this$yRange.method_31607(), $this$yRange.method_31600() - 1);
    }

    public static final boolean isTickingChunk(@NotNull class_1937 $this$isTickingChunk, @NotNull class_1923 pos) {
        Intrinsics.checkNotNullParameter((Object)$this$isTickingChunk, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)pos, (String)"pos");
        return VSGameUtilsKt.isTickingChunk($this$isTickingChunk, pos.field_9181, pos.field_9180);
    }

    public static final boolean isTickingChunk(@NotNull class_1937 $this$isTickingChunk, int chunkX, int chunkZ) {
        Intrinsics.checkNotNullParameter((Object)$this$isTickingChunk, (String)"<this>");
        class_2802 class_28022 = $this$isTickingChunk.method_8398();
        Intrinsics.checkNotNull((Object)class_28022, (String)"null cannot be cast to non-null type net.minecraft.server.level.ServerChunkCache");
        return ((class_3215)class_28022).method_37114(class_1923.method_8331((int)chunkX, (int)chunkZ));
    }

    @Nullable
    public static final class_3218 getLevelFromDimensionId(@NotNull MinecraftServer $this$getLevelFromDimensionId, @NotNull String dimensionId) {
        Intrinsics.checkNotNullParameter((Object)$this$getLevelFromDimensionId, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)dimensionId, (String)"dimensionId");
        return $this$getLevelFromDimensionId.method_3847(VSGameUtilsKt.getResourceKey(dimensionId));
    }

    @NotNull
    public static final VsiClientShipWorld getShipObjectWorld(@NotNull class_310 $this$shipObjectWorld) {
        Intrinsics.checkNotNullParameter((Object)$this$shipObjectWorld, (String)"<this>");
        VsiClientShipWorld vsiClientShipWorld = ((IShipObjectWorldClientProvider)$this$shipObjectWorld).getShipObjectWorld();
        if (vsiClientShipWorld == null) {
            vsiClientShipWorld = VSGameUtilsKt.getVsCore().getDummyShipWorldClient();
        }
        return vsiClientShipWorld;
    }

    @NotNull
    public static final VsiClientShipWorld getShipObjectWorld(@Nullable class_638 $this$shipObjectWorld) {
        class_310 class_3102 = class_310.method_1551();
        Intrinsics.checkNotNullExpressionValue((Object)class_3102, (String)"getInstance(...)");
        return VSGameUtilsKt.getShipObjectWorld(class_3102);
    }

    @NotNull
    public static final class_1657 getMcPlayer(@NotNull VsiPlayer $this$mcPlayer) {
        Intrinsics.checkNotNullParameter((Object)$this$mcPlayer, (String)"<this>");
        Object t = ((MinecraftPlayer)$this$mcPlayer).getPlayerEntityReference().get();
        Intrinsics.checkNotNull(t);
        return (class_1657)t;
    }

    public static final MinecraftPlayer getPlayerWrapper(@NotNull class_1657 $this$playerWrapper) {
        Intrinsics.checkNotNullParameter((Object)$this$playerWrapper, (String)"<this>");
        return ((PlayerDuck)$this$playerWrapper).vs_getPlayer();
    }

    public static final double squaredDistanceToInclShips(@NotNull class_1297 $this$squaredDistanceToInclShips, double x, double y, double z) {
        class_243 class_2432;
        Intrinsics.checkNotNullParameter((Object)$this$squaredDistanceToInclShips, (String)"<this>");
        if (VSGameUtilsKt.getShipMountedTo($this$squaredDistanceToInclShips) != null) {
            ShipMountedToData shipMountedToData = VSGameUtilsKt.getShipMountedToData($this$squaredDistanceToInclShips, null);
            Intrinsics.checkNotNull((Object)shipMountedToData);
            class_2432 = VectorConversionsMCKt.toMinecraft(shipMountedToData.getMountPosInShip());
        } else {
            class_2432 = EntityDragger.INSTANCE.serversideEyePosition($this$squaredDistanceToInclShips);
        }
        class_243 eyePos = class_2432;
        return VSGameUtilsKt.squaredDistanceBetweenInclShips($this$squaredDistanceToInclShips.method_37908(), x, y, z, eyePos.field_1352, eyePos.field_1351 - 1.0, eyePos.field_1350);
    }

    public static final double squaredDistanceBetweenInclShips(@Nullable class_1937 $this$squaredDistanceBetweenInclShips, @NotNull class_243 v1, @NotNull class_243 v2, @Nullable Operation<Double> originalDistance) {
        Intrinsics.checkNotNullParameter((Object)v1, (String)"v1");
        Intrinsics.checkNotNullParameter((Object)v2, (String)"v2");
        if (originalDistance == null) {
            return VSGameUtilsKt.squaredDistanceBetweenInclShips($this$squaredDistanceBetweenInclShips, v1.field_1352, v1.field_1351, v1.field_1350, v2.field_1352, v2.field_1351, v2.field_1350);
        }
        class_243 inWorldV1 = VSGameUtilsKt.toWorldCoordinates($this$squaredDistanceBetweenInclShips, v1);
        class_243 inWorldV2 = VSGameUtilsKt.toWorldCoordinates($this$squaredDistanceBetweenInclShips, v2);
        Object[] objectArray = new Object[]{inWorldV1, inWorldV2};
        Object object = originalDistance.call(objectArray);
        Intrinsics.checkNotNullExpressionValue((Object)object, (String)"call(...)");
        return ((Number)object).doubleValue();
    }

    public static final double squaredDistanceBetweenInclShips(@Nullable class_1937 $this$squaredDistanceBetweenInclShips, double x1, double y1, double z1, double x2, double y2, double z2) {
        Object object;
        Object m2;
        double inWorldX1 = 0.0;
        inWorldX1 = x1;
        double inWorldY1 = 0.0;
        inWorldY1 = y1;
        double inWorldZ1 = 0.0;
        inWorldZ1 = z1;
        double inWorldX2 = 0.0;
        inWorldX2 = x2;
        double inWorldY2 = 0.0;
        inWorldY2 = y2;
        double inWorldZ2 = 0.0;
        inWorldZ2 = z2;
        Object object2 = VSGameUtilsKt.getShipManagingPos($this$squaredDistanceBetweenInclShips, (int)x1 >> 4, (int)z1 >> 4);
        if (object2 != null && (object2 = object2.getShipToWorld()) != null) {
            m2 = object2;
            boolean bl = false;
            inWorldX1 = m2.m00() * x1 + m2.m10() * y1 + m2.m20() * z1 + m2.m30();
            inWorldY1 = m2.m01() * x1 + m2.m11() * y1 + m2.m21() * z1 + m2.m31();
            inWorldZ1 = m2.m02() * x1 + m2.m12() * y1 + m2.m22() * z1 + m2.m32();
        }
        if ((object = VSGameUtilsKt.getShipManagingPos($this$squaredDistanceBetweenInclShips, (int)x2 >> 4, (int)z2 >> 4)) != null && (object = object.getShipToWorld()) != null) {
            m2 = object;
            boolean bl = false;
            inWorldX2 = m2.m00() * x2 + m2.m10() * y2 + m2.m20() * z2 + m2.m30();
            inWorldY2 = m2.m01() * x2 + m2.m11() * y2 + m2.m21() * z2 + m2.m31();
            inWorldZ2 = m2.m02() * x2 + m2.m12() * y2 + m2.m22() * z2 + m2.m32();
        }
        double dx = inWorldX2 - inWorldX1;
        double dy = inWorldY2 - inWorldY1;
        double dz = inWorldZ2 - inWorldZ1;
        return dx * dx + dy * dy + dz * dz;
    }

    private static final LoadedShip getShipObjectManagingPosImpl(class_1937 world, int chunkX, int chunkZ) {
        Object ship;
        if (world != null && VSGameUtilsKt.getShipObjectWorld(world).isChunkInShipyard(chunkX, chunkZ, VSGameUtilsKt.getDimensionId(world)) && (ship = VSGameUtilsKt.getShipObjectWorld(world).getAllShips().getByChunkPos(chunkX, chunkZ, VSGameUtilsKt.getDimensionId(world))) != null) {
            return (LoadedShip)VSGameUtilsKt.getShipObjectWorld(world).getLoadedShips().getById(ship.getId());
        }
        return null;
    }

    public static final void transformFromWorldToNearbyShipsAndWorld(@NotNull class_1937 $this$transformFromWorldToNearbyShipsAndWorld, @NotNull class_238 aabb, @NotNull Consumer<class_238> cb) {
        Intrinsics.checkNotNullParameter((Object)$this$transformFromWorldToNearbyShipsAndWorld, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)aabb, (String)"aabb");
        Intrinsics.checkNotNullParameter(cb, (String)"cb");
        AABBd tmpAABB = new AABBd();
        Iterable<Ship> $this$forEach$iv = VSGameUtilsKt.getShipsIntersecting($this$transformFromWorldToNearbyShipsAndWorld, aabb);
        boolean $i$f$forEach = false;
        Iterator<Ship> iterator2 = $this$forEach$iv.iterator();
        while (iterator2.hasNext()) {
            Ship element$iv;
            Ship ship = element$iv = iterator2.next();
            boolean bl = false;
            AABBd aABBd = VectorConversionsMCKt.set(tmpAABB, aabb).transform(ship.getWorldToShip());
            Intrinsics.checkNotNullExpressionValue((Object)aABBd, (String)"transform(...)");
            cb.accept(VectorConversionsMCKt.toMinecraft(aABBd));
        }
    }

    /*
     * WARNING - void declaration
     */
    @NotNull
    public static final List<Vector3d> transformToNearbyShipsAndWorld(@Nullable class_1937 $this$transformToNearbyShipsAndWorld, double x, double y, double z, double aabbRadius) {
        List list;
        block2: {
            list = new ArrayList();
            class_1937 class_19372 = $this$transformToNearbyShipsAndWorld;
            if (class_19372 == null) break block2;
            class_1937 $this$transformToNearbyShipsAndWorld$iv = class_19372;
            boolean $i$f$transformToNearbyShipsAndWorld = false;
            Ship currentShip$iv = VSGameUtilsKt.getShipManagingPos($this$transformToNearbyShipsAndWorld$iv, x, y, z);
            AABBd aabb$iv = AABBdUtilKt.expand(new AABBd(x, y, z, x, y, z), aabbRadius);
            Vector3d posInWorld$iv = new Vector3d(x, y, z);
            Vector3d temp0$iv = new Vector3d();
            if (currentShip$iv != null) {
                void z2;
                void y2;
                currentShip$iv.getShipToWorld().transformPosition(posInWorld$iv);
                double d2 = posInWorld$iv.z();
                double d3 = posInWorld$iv.y();
                double x2 = posInWorld$iv.x();
                boolean bl = false;
                list.add(new Vector3d(x2, (double)y2, (double)z2));
            }
            for (Ship nearbyShip$iv : VSGameUtilsKt.getShipObjectWorld($this$transformToNearbyShipsAndWorld$iv).getAllShips().getIntersecting(aabb$iv, VSGameUtilsKt.getDimensionId($this$transformToNearbyShipsAndWorld$iv))) {
                void z3;
                void y3;
                if (Intrinsics.areEqual((Object)nearbyShip$iv, (Object)currentShip$iv)) continue;
                Vector3d posInShip$iv = nearbyShip$iv.getWorldToShip().transformPosition(posInWorld$iv, temp0$iv);
                double d4 = posInShip$iv.z();
                double d5 = posInShip$iv.y();
                double x3 = posInShip$iv.x();
                boolean bl = false;
                list.add(new Vector3d(x3, (double)y3, (double)z3));
            }
        }
        return list;
    }

    /*
     * WARNING - void declaration
     */
    public static final void transformToNearbyShipsAndWorld(@Nullable class_1937 $this$transformToNearbyShipsAndWorld, double x, double y, double z, double aabbRadius, @NotNull DoubleTernaryConsumer cb) {
        block2: {
            Intrinsics.checkNotNullParameter((Object)cb, (String)"cb");
            class_1937 class_19372 = $this$transformToNearbyShipsAndWorld;
            if (class_19372 == null) break block2;
            class_1937 $this$transformToNearbyShipsAndWorld$iv = class_19372;
            boolean $i$f$transformToNearbyShipsAndWorld = false;
            Ship currentShip$iv = VSGameUtilsKt.getShipManagingPos($this$transformToNearbyShipsAndWorld$iv, x, y, z);
            AABBd aabb$iv = AABBdUtilKt.expand(new AABBd(x, y, z, x, y, z), aabbRadius);
            Vector3d posInWorld$iv = new Vector3d(x, y, z);
            Vector3d temp0$iv = new Vector3d();
            if (currentShip$iv != null) {
                void p2;
                void p1;
                currentShip$iv.getShipToWorld().transformPosition(posInWorld$iv);
                double d2 = posInWorld$iv.z();
                double d3 = posInWorld$iv.y();
                double p0 = posInWorld$iv.x();
                boolean bl = false;
                cb.accept(p0, (double)p1, (double)p2);
            }
            for (Ship nearbyShip$iv : VSGameUtilsKt.getShipObjectWorld($this$transformToNearbyShipsAndWorld$iv).getAllShips().getIntersecting(aabb$iv, VSGameUtilsKt.getDimensionId($this$transformToNearbyShipsAndWorld$iv))) {
                void p2;
                void p1;
                if (Intrinsics.areEqual((Object)nearbyShip$iv, (Object)currentShip$iv)) continue;
                Vector3d posInShip$iv = nearbyShip$iv.getWorldToShip().transformPosition(posInWorld$iv, temp0$iv);
                double d4 = posInShip$iv.z();
                double d5 = posInShip$iv.y();
                double p0 = posInShip$iv.x();
                boolean bl = false;
                cb.accept(p0, (double)p1, (double)p2);
            }
        }
    }

    public static final void transformToNearbyShipsAndWorld(@NotNull class_1937 $this$transformToNearbyShipsAndWorld, double x, double y, double z, double aabbRadius, @NotNull Function3<? super Double, ? super Double, ? super Double, Unit> cb) {
        Intrinsics.checkNotNullParameter((Object)$this$transformToNearbyShipsAndWorld, (String)"<this>");
        Intrinsics.checkNotNullParameter(cb, (String)"cb");
        boolean $i$f$transformToNearbyShipsAndWorld = false;
        Ship currentShip = VSGameUtilsKt.getShipManagingPos($this$transformToNearbyShipsAndWorld, x, y, z);
        AABBd aabb = AABBdUtilKt.expand(new AABBd(x, y, z, x, y, z), aabbRadius);
        Vector3d posInWorld = new Vector3d(x, y, z);
        Vector3d temp0 = new Vector3d();
        if (currentShip != null) {
            currentShip.getShipToWorld().transformPosition(posInWorld);
            cb.invoke((Object)posInWorld.x(), (Object)posInWorld.y(), (Object)posInWorld.z());
        }
        for (Ship nearbyShip : VSGameUtilsKt.getShipObjectWorld($this$transformToNearbyShipsAndWorld).getAllShips().getIntersecting(aabb, VSGameUtilsKt.getDimensionId($this$transformToNearbyShipsAndWorld))) {
            if (Intrinsics.areEqual((Object)nearbyShip, (Object)currentShip)) continue;
            Vector3d posInShip = nearbyShip.getWorldToShip().transformPosition(posInWorld, temp0);
            cb.invoke((Object)posInShip.x(), (Object)posInShip.y(), (Object)posInShip.z());
        }
    }

    public static final boolean isChunkInShipyard(@NotNull class_1937 $this$isChunkInShipyard, int chunkX, int chunkZ) {
        Intrinsics.checkNotNullParameter((Object)$this$isChunkInShipyard, (String)"<this>");
        return VSGameUtilsKt.getShipObjectWorld($this$isChunkInShipyard).isChunkInShipyard(chunkX, chunkZ, VSGameUtilsKt.getDimensionId($this$isChunkInShipyard));
    }

    public static final boolean isBlockInShipyard(@NotNull class_1937 $this$isBlockInShipyard, int blockX, int blockY, int blockZ) {
        Intrinsics.checkNotNullParameter((Object)$this$isBlockInShipyard, (String)"<this>");
        return VSGameUtilsKt.getShipObjectWorld($this$isBlockInShipyard).isBlockInShipyard(blockX, blockY, blockZ, VSGameUtilsKt.getDimensionId($this$isBlockInShipyard));
    }

    public static final boolean isBlockInShipyard(@NotNull class_1937 $this$isBlockInShipyard, @NotNull class_2338 pos) {
        Intrinsics.checkNotNullParameter((Object)$this$isBlockInShipyard, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)pos, (String)"pos");
        return VSGameUtilsKt.isBlockInShipyard($this$isBlockInShipyard, pos.method_10263(), pos.method_10264(), pos.method_10260());
    }

    public static final boolean isBlockInShipyard(@NotNull class_1937 $this$isBlockInShipyard, @NotNull class_243 pos) {
        Intrinsics.checkNotNullParameter((Object)$this$isBlockInShipyard, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)pos, (String)"pos");
        return VSGameUtilsKt.isBlockInShipyard($this$isBlockInShipyard, (int)pos.field_1352, (int)pos.field_1351, (int)pos.field_1350);
    }

    public static final boolean isBlockInShipyard(@NotNull class_1937 $this$isBlockInShipyard, double x, double y, double z) {
        Intrinsics.checkNotNullParameter((Object)$this$isBlockInShipyard, (String)"<this>");
        return VSGameUtilsKt.isBlockInShipyard($this$isBlockInShipyard, (int)x, (int)y, (int)z);
    }

    @Nullable
    public static final LoadedShip getLoadedShipManagingPos(@Nullable class_1937 $this$getLoadedShipManagingPos, int chunkX, int chunkZ) {
        return VSGameUtilsKt.getShipObjectManagingPosImpl($this$getLoadedShipManagingPos, chunkX, chunkZ);
    }

    @Nullable
    public static final LoadedShip getLoadedShipManagingPos(@Nullable class_1937 $this$getLoadedShipManagingPos, @NotNull class_2382 blockPos) {
        Intrinsics.checkNotNullParameter((Object)blockPos, (String)"blockPos");
        return VSGameUtilsKt.getLoadedShipManagingPos($this$getLoadedShipManagingPos, blockPos.method_10263() >> 4, blockPos.method_10260() >> 4);
    }

    @Nullable
    public static final LoadedShip getLoadedShipManagingPos(@Nullable class_1937 $this$getLoadedShipManagingPos, @NotNull Vector3dc pos) {
        Intrinsics.checkNotNullParameter((Object)pos, (String)"pos");
        return VSGameUtilsKt.getLoadedShipManagingPos($this$getLoadedShipManagingPos, (int)pos.x() >> 4, (int)pos.z() >> 4);
    }

    @Nullable
    public static final LoadedShip getLoadedShipManagingPos(@Nullable class_1937 $this$getLoadedShipManagingPos, double posX, double posY, double posZ) {
        return VSGameUtilsKt.getLoadedShipManagingPos($this$getLoadedShipManagingPos, (int)posX >> 4, (int)posZ >> 4);
    }

    @Nullable
    public static final LoadedShip getLoadedShipManagingPos(@Nullable class_1937 $this$getLoadedShipManagingPos, @NotNull class_1923 chunkPos) {
        Intrinsics.checkNotNullParameter((Object)chunkPos, (String)"chunkPos");
        return VSGameUtilsKt.getLoadedShipManagingPos($this$getLoadedShipManagingPos, chunkPos.field_9181, chunkPos.field_9180);
    }

    @Deprecated(message="Use getLoadedShipManagingPos instead", replaceWith=@ReplaceWith(expression="getLoadedShipManagingPos(chunkX, chunkZ)", imports={}))
    @Nullable
    public static final LoadedShip getShipObjectManagingPos(@Nullable class_1937 $this$getShipObjectManagingPos, int chunkX, int chunkZ) {
        return VSGameUtilsKt.getShipObjectManagingPosImpl($this$getShipObjectManagingPos, chunkX, chunkZ);
    }

    @Deprecated(message="Use getLoadedShipManagingPos instead", replaceWith=@ReplaceWith(expression="getLoadedShipManagingPos(blockPos)", imports={}))
    @Nullable
    public static final LoadedShip getShipObjectManagingPos(@Nullable class_1937 $this$getShipObjectManagingPos, @NotNull class_2382 blockPos) {
        Intrinsics.checkNotNullParameter((Object)blockPos, (String)"blockPos");
        return VSGameUtilsKt.getShipObjectManagingPos($this$getShipObjectManagingPos, blockPos.method_10263() >> 4, blockPos.method_10260() >> 4);
    }

    @Deprecated(message="Use getLoadedShipManagingPos instead", replaceWith=@ReplaceWith(expression="getLoadedShipManagingPos(pos)", imports={}))
    @Nullable
    public static final LoadedShip getShipObjectManagingPos(@Nullable class_1937 $this$getShipObjectManagingPos, @NotNull Vector3dc pos) {
        Intrinsics.checkNotNullParameter((Object)pos, (String)"pos");
        return VSGameUtilsKt.getShipObjectManagingPos($this$getShipObjectManagingPos, (int)pos.x() >> 4, (int)pos.z() >> 4);
    }

    @Deprecated(message="Use getLoadedShipManagingPos instead", replaceWith=@ReplaceWith(expression="getLoadedShipManagingPos(posX, posY, posZ)", imports={}))
    @Nullable
    public static final LoadedShip getShipObjectManagingPos(@Nullable class_1937 $this$getShipObjectManagingPos, double posX, double posY, double posZ) {
        return VSGameUtilsKt.getShipObjectManagingPos($this$getShipObjectManagingPos, (int)posX >> 4, (int)posZ >> 4);
    }

    @Deprecated(message="Use getLoadedShipManagingPos instead", replaceWith=@ReplaceWith(expression="getLoadedShipManagingPos(chunkPos)", imports={}))
    @Nullable
    public static final LoadedShip getShipObjectManagingPos(@Nullable class_1937 $this$getShipObjectManagingPos, @NotNull class_1923 chunkPos) {
        Intrinsics.checkNotNullParameter((Object)chunkPos, (String)"chunkPos");
        return VSGameUtilsKt.getShipObjectManagingPos($this$getShipObjectManagingPos, chunkPos.field_9181, chunkPos.field_9180);
    }

    @Nullable
    public static final ClientShip getLoadedShipManagingPos(@Nullable class_638 $this$getLoadedShipManagingPos, int chunkX, int chunkZ) {
        return (ClientShip)VSGameUtilsKt.getShipObjectManagingPosImpl((class_1937)$this$getLoadedShipManagingPos, chunkX, chunkZ);
    }

    @Nullable
    public static final ClientShip getLoadedShipManagingPos(@Nullable class_638 $this$getLoadedShipManagingPos, @NotNull class_2382 blockPos) {
        Intrinsics.checkNotNullParameter((Object)blockPos, (String)"blockPos");
        return VSGameUtilsKt.getLoadedShipManagingPos($this$getLoadedShipManagingPos, blockPos.method_10263() >> 4, blockPos.method_10260() >> 4);
    }

    @Nullable
    public static final ClientShip getLoadedShipManagingPos(@Nullable class_638 $this$getLoadedShipManagingPos, double posX, double posY, double posZ) {
        return VSGameUtilsKt.getLoadedShipManagingPos($this$getLoadedShipManagingPos, (int)posX >> 4, (int)posZ >> 4);
    }

    @Nullable
    public static final ClientShip getLoadedShipManagingPos(@Nullable class_638 $this$getLoadedShipManagingPos, @NotNull Vector3dc pos) {
        Intrinsics.checkNotNullParameter((Object)pos, (String)"pos");
        return VSGameUtilsKt.getLoadedShipManagingPos($this$getLoadedShipManagingPos, (int)pos.x() >> 4, (int)pos.z() >> 4);
    }

    @Nullable
    public static final ClientShip getLoadedShipManagingPos(@Nullable class_638 $this$getLoadedShipManagingPos, @NotNull class_2374 pos) {
        Intrinsics.checkNotNullParameter((Object)pos, (String)"pos");
        return VSGameUtilsKt.getLoadedShipManagingPos($this$getLoadedShipManagingPos, (int)pos.method_10216() >> 4, (int)pos.method_10215() >> 4);
    }

    @Nullable
    public static final ClientShip getLoadedShipManagingPos(@Nullable class_638 $this$getLoadedShipManagingPos, @NotNull class_1923 chunkPos) {
        Intrinsics.checkNotNullParameter((Object)chunkPos, (String)"chunkPos");
        return VSGameUtilsKt.getLoadedShipManagingPos($this$getLoadedShipManagingPos, chunkPos.field_9181, chunkPos.field_9180);
    }

    @Deprecated(message="Use getLoadedShipManagingPos instead", replaceWith=@ReplaceWith(expression="getLoadedShipManagingPos(chunkX, chunkZ)", imports={}))
    @Nullable
    public static final ClientShip getShipObjectManagingPos(@Nullable class_638 $this$getShipObjectManagingPos, int chunkX, int chunkZ) {
        return (ClientShip)VSGameUtilsKt.getShipObjectManagingPosImpl((class_1937)$this$getShipObjectManagingPos, chunkX, chunkZ);
    }

    @Deprecated(message="Use getLoadedShipManagingPos instead", replaceWith=@ReplaceWith(expression="getLoadedShipManagingPos(blockPos)", imports={}))
    @Nullable
    public static final ClientShip getShipObjectManagingPos(@Nullable class_638 $this$getShipObjectManagingPos, @NotNull class_2382 blockPos) {
        Intrinsics.checkNotNullParameter((Object)blockPos, (String)"blockPos");
        return VSGameUtilsKt.getShipObjectManagingPos($this$getShipObjectManagingPos, blockPos.method_10263() >> 4, blockPos.method_10260() >> 4);
    }

    @Deprecated(message="Use getLoadedShipManagingPos instead", replaceWith=@ReplaceWith(expression="getLoadedShipManagingPos(pos)", imports={}))
    @Nullable
    public static final ClientShip getShipObjectManagingPos(@Nullable class_638 $this$getShipObjectManagingPos, double posX, double posY, double posZ) {
        return VSGameUtilsKt.getShipObjectManagingPos($this$getShipObjectManagingPos, (int)posX >> 4, (int)posZ >> 4);
    }

    @Deprecated(message="Use getLoadedShipManagingPos instead", replaceWith=@ReplaceWith(expression="getLoadedShipManagingPos(pos)", imports={}))
    @Nullable
    public static final ClientShip getShipObjectManagingPos(@Nullable class_638 $this$getShipObjectManagingPos, @NotNull Vector3dc pos) {
        Intrinsics.checkNotNullParameter((Object)pos, (String)"pos");
        return VSGameUtilsKt.getShipObjectManagingPos($this$getShipObjectManagingPos, (int)pos.x() >> 4, (int)pos.z() >> 4);
    }

    @Deprecated(message="Use getLoadedShipManagingPos instead", replaceWith=@ReplaceWith(expression="getLoadedShipManagingPos(chunkPos)", imports={}))
    @Nullable
    public static final ClientShip getShipObjectManagingPos(@Nullable class_638 $this$getShipObjectManagingPos, @NotNull class_2374 pos) {
        Intrinsics.checkNotNullParameter((Object)pos, (String)"pos");
        return VSGameUtilsKt.getShipObjectManagingPos($this$getShipObjectManagingPos, (int)pos.method_10216() >> 4, (int)pos.method_10215() >> 4);
    }

    @Deprecated(message="Use getLoadedShipManagingPos instead", replaceWith=@ReplaceWith(expression="getLoadedShipManagingPos(chunkPos)", imports={}))
    @Nullable
    public static final ClientShip getShipObjectManagingPos(@Nullable class_638 $this$getShipObjectManagingPos, @NotNull class_1923 chunkPos) {
        Intrinsics.checkNotNullParameter((Object)chunkPos, (String)"chunkPos");
        return VSGameUtilsKt.getShipObjectManagingPos($this$getShipObjectManagingPos, chunkPos.field_9181, chunkPos.field_9180);
    }

    @Nullable
    public static final LoadedServerShip getLoadedShipManagingPos(@Nullable class_3218 $this$getLoadedShipManagingPos, int chunkX, int chunkZ) {
        return (LoadedServerShip)VSGameUtilsKt.getShipObjectManagingPosImpl((class_1937)$this$getLoadedShipManagingPos, chunkX, chunkZ);
    }

    @Nullable
    public static final LoadedServerShip getLoadedShipManagingPos(@Nullable class_3218 $this$getLoadedShipManagingPos, @NotNull class_2382 blockPos) {
        Intrinsics.checkNotNullParameter((Object)blockPos, (String)"blockPos");
        return VSGameUtilsKt.getLoadedShipManagingPos($this$getLoadedShipManagingPos, blockPos.method_10263() >> 4, blockPos.method_10260() >> 4);
    }

    @Nullable
    public static final LoadedServerShip getLoadedShipManagingPos(@Nullable class_3218 $this$getLoadedShipManagingPos, @NotNull class_1923 chunkPos) {
        Intrinsics.checkNotNullParameter((Object)chunkPos, (String)"chunkPos");
        return VSGameUtilsKt.getLoadedShipManagingPos($this$getLoadedShipManagingPos, chunkPos.field_9181, chunkPos.field_9180);
    }

    @Nullable
    public static final LoadedServerShip getLoadedShipManagingPos(@Nullable class_3218 $this$getLoadedShipManagingPos, double posX, double posY, double posZ) {
        return VSGameUtilsKt.getLoadedShipManagingPos($this$getLoadedShipManagingPos, (int)posX >> 4, (int)posZ >> 4);
    }

    @Nullable
    public static final LoadedServerShip getLoadedShipManagingPos(@Nullable class_3218 $this$getLoadedShipManagingPos, @NotNull Vector3dc pos) {
        Intrinsics.checkNotNullParameter((Object)pos, (String)"pos");
        return VSGameUtilsKt.getLoadedShipManagingPos($this$getLoadedShipManagingPos, (int)pos.x() >> 4, (int)pos.z() >> 4);
    }

    @Deprecated(message="Use getLoadedShipManagingPos instead", replaceWith=@ReplaceWith(expression="getLoadedShipManagingPos(chunkX, chunkZ)", imports={}))
    @Nullable
    public static final LoadedServerShip getShipObjectManagingPos(@Nullable class_3218 $this$getShipObjectManagingPos, int chunkX, int chunkZ) {
        return (LoadedServerShip)VSGameUtilsKt.getShipObjectManagingPosImpl((class_1937)$this$getShipObjectManagingPos, chunkX, chunkZ);
    }

    @Deprecated(message="Use getLoadedShipManagingPos instead", replaceWith=@ReplaceWith(expression="getLoadedShipManagingPos(blockPos)", imports={}))
    @Nullable
    public static final LoadedServerShip getShipObjectManagingPos(@Nullable class_3218 $this$getShipObjectManagingPos, @NotNull class_2382 blockPos) {
        Intrinsics.checkNotNullParameter((Object)blockPos, (String)"blockPos");
        return VSGameUtilsKt.getShipObjectManagingPos($this$getShipObjectManagingPos, blockPos.method_10263() >> 4, blockPos.method_10260() >> 4);
    }

    @Deprecated(message="Use getLoadedShipManagingPos instead", replaceWith=@ReplaceWith(expression="getLoadedShipManagingPos(pos)", imports={}))
    @Nullable
    public static final LoadedServerShip getShipObjectManagingPos(@Nullable class_3218 $this$getShipObjectManagingPos, @NotNull class_1923 chunkPos) {
        Intrinsics.checkNotNullParameter((Object)chunkPos, (String)"chunkPos");
        return VSGameUtilsKt.getShipObjectManagingPos($this$getShipObjectManagingPos, chunkPos.field_9181, chunkPos.field_9180);
    }

    @Deprecated(message="Use getLoadedShipManagingPos instead", replaceWith=@ReplaceWith(expression="getLoadedShipManagingPos(posX, posY, posZ)", imports={}))
    @Nullable
    public static final LoadedServerShip getShipObjectManagingPos(@Nullable class_3218 $this$getShipObjectManagingPos, double posX, double posY, double posZ) {
        return VSGameUtilsKt.getShipObjectManagingPos($this$getShipObjectManagingPos, (int)posX >> 4, (int)posZ >> 4);
    }

    @Deprecated(message="Use getLoadedShipManagingPos instead", replaceWith=@ReplaceWith(expression="getLoadedShipManagingPos(pos)", imports={}))
    @Nullable
    public static final LoadedServerShip getShipObjectManagingPos(@Nullable class_3218 $this$getShipObjectManagingPos, @NotNull Vector3dc pos) {
        Intrinsics.checkNotNullParameter((Object)pos, (String)"pos");
        return VSGameUtilsKt.getShipObjectManagingPos($this$getShipObjectManagingPos, (int)pos.x() >> 4, (int)pos.z() >> 4);
    }

    private static final Ship getShipManagingPosImpl(class_1937 world, int x, int z) {
        return world != null && VSGameUtilsKt.isChunkInShipyard(world, x, z) ? (Ship)VSGameUtilsKt.getShipObjectWorld(world).getAllShips().getByChunkPos(x, z, VSGameUtilsKt.getDimensionId(world)) : null;
    }

    @NotNull
    public static final class_238 transformRenderAABBToWorld(@Nullable class_638 $this$transformRenderAABBToWorld, @NotNull class_2374 pos, @NotNull class_238 aabb) {
        Intrinsics.checkNotNullParameter((Object)pos, (String)"pos");
        Intrinsics.checkNotNullParameter((Object)aabb, (String)"aabb");
        ClientShip ship = VSGameUtilsKt.getLoadedShipManagingPos($this$transformRenderAABBToWorld, pos);
        if (ship != null) {
            AABBd aABBd = VectorConversionsMCKt.toJOML(aabb).transform(ship.getRenderTransform().getShipToWorldMatrix());
            Intrinsics.checkNotNullExpressionValue((Object)aABBd, (String)"transform(...)");
            return VectorConversionsMCKt.toMinecraft(aABBd);
        }
        return aabb;
    }

    @Nullable
    public static final Ship getShipManaging(@Nullable class_1297 $this$getShipManaging) {
        Ship ship;
        class_1297 class_12972 = $this$getShipManaging;
        if (class_12972 != null) {
            class_1297 it = class_12972;
            boolean bl = false;
            class_1937 class_19372 = $this$getShipManaging.method_37908();
            class_243 class_2432 = $this$getShipManaging.method_19538();
            Intrinsics.checkNotNullExpressionValue((Object)class_2432, (String)"position(...)");
            ship = VSGameUtilsKt.getShipManagingPos(class_19372, (class_2374)class_2432);
        } else {
            ship = null;
        }
        return ship;
    }

    @Nullable
    public static final Ship getShipManagingPos(@Nullable class_1937 $this$getShipManagingPos, int chunkX, int chunkZ) {
        return VSGameUtilsKt.getShipManagingPosImpl($this$getShipManagingPos, chunkX, chunkZ);
    }

    @Nullable
    public static final Ship getShipManagingPos(@Nullable class_1937 $this$getShipManagingPos, @NotNull class_2338 blockPos) {
        Intrinsics.checkNotNullParameter((Object)blockPos, (String)"blockPos");
        return VSGameUtilsKt.getShipManagingPos($this$getShipManagingPos, blockPos.method_10263() >> 4, blockPos.method_10260() >> 4);
    }

    @Nullable
    public static final Ship getShipManagingPos(@Nullable class_1937 $this$getShipManagingPos, @NotNull class_2374 pos) {
        Intrinsics.checkNotNullParameter((Object)pos, (String)"pos");
        return VSGameUtilsKt.getShipManagingPos($this$getShipManagingPos, (int)pos.method_10216() >> 4, (int)pos.method_10215() >> 4);
    }

    @Nullable
    public static final Ship getShipManagingPos(@Nullable class_1937 $this$getShipManagingPos, @NotNull Vector3dc pos) {
        Intrinsics.checkNotNullParameter((Object)pos, (String)"pos");
        return VSGameUtilsKt.getShipManagingPos($this$getShipManagingPos, (int)pos.x() >> 4, (int)pos.z() >> 4);
    }

    @Nullable
    public static final Ship getShipManagingPos(@Nullable class_1937 $this$getShipManagingPos, double posX, double posY, double posZ) {
        return VSGameUtilsKt.getShipManagingPos($this$getShipManagingPos, (int)posX >> 4, (int)posZ >> 4);
    }

    @Nullable
    public static final Ship getShipManagingPos(@Nullable class_1937 $this$getShipManagingPos, float posX, float posY, float posZ) {
        return VSGameUtilsKt.getShipManagingPos($this$getShipManagingPos, (int)posX >> 4, (int)posZ >> 4);
    }

    @Nullable
    public static final Ship getShipManagingPos(@Nullable class_1937 $this$getShipManagingPos, @NotNull class_1923 chunkPos) {
        Intrinsics.checkNotNullParameter((Object)chunkPos, (String)"chunkPos");
        return VSGameUtilsKt.getShipManagingPos($this$getShipManagingPos, chunkPos.field_9181, chunkPos.field_9180);
    }

    @Nullable
    public static final ServerShip getShipManagingPos(@Nullable class_3218 $this$getShipManagingPos, int chunkX, int chunkZ) {
        return (ServerShip)VSGameUtilsKt.getShipManagingPosImpl((class_1937)$this$getShipManagingPos, chunkX, chunkZ);
    }

    @Nullable
    public static final ServerShip getShipManagingPos(@Nullable class_3218 $this$getShipManagingPos, @NotNull class_2338 blockPos) {
        Intrinsics.checkNotNullParameter((Object)blockPos, (String)"blockPos");
        return VSGameUtilsKt.getShipManagingPos($this$getShipManagingPos, blockPos.method_10263() >> 4, blockPos.method_10260() >> 4);
    }

    @Nullable
    public static final ServerShip getShipManagingPos(@Nullable class_3218 $this$getShipManagingPos, @NotNull Vector3dc pos) {
        Intrinsics.checkNotNullParameter((Object)pos, (String)"pos");
        return VSGameUtilsKt.getShipManagingPos($this$getShipManagingPos, (int)pos.x() >> 4, (int)pos.z() >> 4);
    }

    @Nullable
    public static final ServerShip getShipManagingPos(@Nullable class_3218 $this$getShipManagingPos, double posX, double posY, double posZ) {
        return VSGameUtilsKt.getShipManagingPos($this$getShipManagingPos, (int)posX >> 4, (int)posZ >> 4);
    }

    @Nullable
    public static final ServerShip getShipManagingPos(@Nullable class_3218 $this$getShipManagingPos, @NotNull class_1923 chunkPos) {
        Intrinsics.checkNotNullParameter((Object)chunkPos, (String)"chunkPos");
        return VSGameUtilsKt.getShipManagingPos($this$getShipManagingPos, chunkPos.field_9181, chunkPos.field_9180);
    }

    @NotNull
    public static final Vector3d toWorldCoordinates(@NotNull Ship $this$toWorldCoordinates, @NotNull class_2338 pos) {
        Intrinsics.checkNotNullParameter((Object)$this$toWorldCoordinates, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)pos, (String)"pos");
        Vector3d vector3d = $this$toWorldCoordinates.getShipToWorld().transformPosition(VectorConversionsMCKt.toJOMLD((class_2382)pos));
        Intrinsics.checkNotNullExpressionValue((Object)vector3d, (String)"transformPosition(...)");
        return vector3d;
    }

    @NotNull
    public static final class_243 toWorldCoordinates(@NotNull Ship $this$toWorldCoordinates, @NotNull class_243 pos) {
        Intrinsics.checkNotNullParameter((Object)$this$toWorldCoordinates, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)pos, (String)"pos");
        Vector3d vector3d = $this$toWorldCoordinates.getShipToWorld().transformPosition(VectorConversionsMCKt.toJOML(pos));
        Intrinsics.checkNotNullExpressionValue((Object)vector3d, (String)"transformPosition(...)");
        return VectorConversionsMCKt.toMinecraft(vector3d);
    }

    @NotNull
    public static final class_243 toWorldCoordinates(@Nullable class_1937 $this$toWorldCoordinates, @NotNull class_2338 pos) {
        Intrinsics.checkNotNullParameter((Object)pos, (String)"pos");
        Object object = $this$toWorldCoordinates;
        if (object == null || (object = VSGameUtilsKt.getShipManagingPos(object, pos)) == null || (object = VSGameUtilsKt.toWorldCoordinates((Ship)object, pos)) == null || (object = VectorConversionsMCKt.toMinecraft((Vector3dc)object)) == null) {
            object = VectorConversionsMCKt.toMinecraft(VectorConversionsMCKt.toJOMLD((class_2382)pos));
        }
        return object;
    }

    @NotNull
    public static final class_243 toWorldCoordinates(@Nullable class_1937 $this$toWorldCoordinates, @NotNull class_243 pos) {
        Intrinsics.checkNotNullParameter((Object)pos, (String)"pos");
        Object object = $this$toWorldCoordinates;
        if (object == null || (object = VSGameUtilsKt.getShipManagingPos(object, (class_2374)pos)) == null || (object = VSGameUtilsKt.toWorldCoordinates((Ship)object, pos)) == null) {
            object = pos;
        }
        return object;
    }

    @NotNull
    public static final class_243 toShipRenderCoordinates(@Nullable class_638 $this$toShipRenderCoordinates, @NotNull class_243 shipPos, @NotNull class_243 pos) {
        class_243 class_2432;
        Vector3d vector3d;
        Matrix4dc matrix4dc;
        ShipTransform shipTransform;
        ClientShip clientShip;
        Intrinsics.checkNotNullParameter((Object)shipPos, (String)"shipPos");
        Intrinsics.checkNotNullParameter((Object)pos, (String)"pos");
        return $this$toShipRenderCoordinates != null && (clientShip = VSGameUtilsKt.getLoadedShipManagingPos($this$toShipRenderCoordinates, (class_2374)shipPos)) != null && (shipTransform = clientShip.getRenderTransform()) != null && (matrix4dc = shipTransform.getWorldToShip()) != null && (vector3d = matrix4dc.transformPosition(VectorConversionsMCKt.toJOML(pos))) != null && (class_2432 = VectorConversionsMCKt.toMinecraft(vector3d)) != null ? class_2432 : pos;
    }

    @NotNull
    public static final Vector3d toWorldCoordinates(@Nullable class_1937 $this$toWorldCoordinates, @NotNull Vector3d pos) {
        Intrinsics.checkNotNullParameter((Object)pos, (String)"pos");
        Object object = $this$toWorldCoordinates;
        if (object == null || (object = VSGameUtilsKt.getShipManagingPos((class_1937)object, (Vector3dc)pos)) == null || (object = object.getShipToWorld()) == null || (object = object.transformPosition(pos)) == null) {
            object = pos;
        }
        return object;
    }

    @JvmOverloads
    @NotNull
    public static final Vector3d toWorldCoordinates(@Nullable class_1937 $this$toWorldCoordinates, double x, double y, double z, @NotNull Vector3d dest) {
        Intrinsics.checkNotNullParameter((Object)dest, (String)"dest");
        Object object = VSGameUtilsKt.getShipManagingPos($this$toWorldCoordinates, x, y, z);
        if (object == null || (object = VSGameUtilsKt.toWorldCoordinates$default((Ship)object, x, y, z, null, 8, null)) == null) {
            Vector3d vector3d = dest.set(x, y, z);
            object = vector3d;
            Intrinsics.checkNotNullExpressionValue((Object)vector3d, (String)"set(...)");
        }
        return object;
    }

    public static /* synthetic */ Vector3d toWorldCoordinates$default(class_1937 class_19372, double d2, double d3, double d4, Vector3d vector3d, int n2, Object object) {
        if ((n2 & 8) != 0) {
            vector3d = new Vector3d();
        }
        return VSGameUtilsKt.toWorldCoordinates(class_19372, d2, d3, d4, vector3d);
    }

    @JvmOverloads
    @NotNull
    public static final Vector3d toWorldCoordinates(@NotNull Ship $this$toWorldCoordinates, double x, double y, double z, @NotNull Vector3d dest) {
        Intrinsics.checkNotNullParameter((Object)$this$toWorldCoordinates, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)dest, (String)"dest");
        Vector3d vector3d = $this$toWorldCoordinates.getTransform().getShipToWorld().transformPosition(dest.set(x, y, z));
        Intrinsics.checkNotNullExpressionValue((Object)vector3d, (String)"transformPosition(...)");
        return vector3d;
    }

    public static /* synthetic */ Vector3d toWorldCoordinates$default(Ship ship, double d2, double d3, double d4, Vector3d vector3d, int n2, Object object) {
        if ((n2 & 8) != 0) {
            vector3d = new Vector3d();
        }
        return VSGameUtilsKt.toWorldCoordinates(ship, d2, d3, d4, vector3d);
    }

    @NotNull
    public static final VsiTerrainUpdate toDenseVoxelUpdate(@NotNull class_2826 $this$toDenseVoxelUpdate, @NotNull Vector3ic chunkPos) {
        Intrinsics.checkNotNullParameter((Object)$this$toDenseVoxelUpdate, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)chunkPos, (String)"chunkPos");
        VsiTerrainUpdate.Builder update = VSGameUtilsKt.getVsCore().newDenseTerrainUpdateBuilder(chunkPos.x(), chunkPos.y(), chunkPos.z());
        BlockStateInfo.Cache info = BlockStateInfo.INSTANCE.getCache();
        for (int x = 0; x < 16; ++x) {
            for (int y = 0; y < 16; ++y) {
                for (int z = 0; z < 16; ++z) {
                    class_2680 class_26802 = $this$toDenseVoxelUpdate.method_12254(x, y, z);
                    Intrinsics.checkNotNullExpressionValue((Object)class_26802, (String)"getBlockState(...)");
                    Object object = info.get(class_26802);
                    if (object == null || (object = (VsiBlockType)object.getSecond()) == null) {
                        object = VSGameUtilsKt.getVsCore().getBlockTypes().getAir();
                    }
                    update.addBlock(x, y, z, (VsiBlockType)object);
                }
            }
        }
        return update.build();
    }

    @NotNull
    public static final Vector3d getWorldCoordinates(@Nullable class_1937 $this$getWorldCoordinates, @NotNull class_2338 blockPos, @NotNull Vector3d pos) {
        Intrinsics.checkNotNullParameter((Object)blockPos, (String)"blockPos");
        Intrinsics.checkNotNullParameter((Object)pos, (String)"pos");
        Object object = VSGameUtilsKt.getLoadedShipManagingPos($this$getWorldCoordinates, (class_2382)blockPos);
        if (object == null || (object = object.getTransform()) == null || (object = object.getShipToWorld()) == null || (object = object.transformPosition(pos)) == null) {
            object = pos;
        }
        return object;
    }

    @NotNull
    public static final Iterable<Ship> getShipsIntersecting(@NotNull class_1937 $this$getShipsIntersecting, @NotNull class_238 aabb) {
        Intrinsics.checkNotNullParameter((Object)$this$getShipsIntersecting, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)aabb, (String)"aabb");
        return VSGameUtilsKt.getShipsIntersecting($this$getShipsIntersecting, VectorConversionsMCKt.toJOML(aabb));
    }

    @NotNull
    public static final Iterable<Ship> getShipsIntersecting(@NotNull class_1937 $this$getShipsIntersecting, @NotNull AABBdc aabb) {
        Intrinsics.checkNotNullParameter((Object)$this$getShipsIntersecting, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)aabb, (String)"aabb");
        return VSGameUtilsKt.getAllShips($this$getShipsIntersecting).getIntersecting(aabb, VSGameUtilsKt.getDimensionId($this$getShipsIntersecting));
    }

    @NotNull
    public static final class_238 transformAabbToWorld(@Nullable class_1937 $this$transformAabbToWorld, @NotNull class_238 aabb) {
        Intrinsics.checkNotNullParameter((Object)aabb, (String)"aabb");
        return VectorConversionsMCKt.toMinecraft(VSGameUtilsKt.transformAabbToWorld($this$transformAabbToWorld, VectorConversionsMCKt.toJOML(aabb)));
    }

    @NotNull
    public static final AABBd transformAabbToWorld(@Nullable class_1937 $this$transformAabbToWorld, @NotNull AABBd aabb) {
        Intrinsics.checkNotNullParameter((Object)aabb, (String)"aabb");
        Object object = $this$transformAabbToWorld;
        if (object == null || (object = VSGameUtilsKt.transformAabbToWorld(object, aabb, aabb)) == null) {
            object = aabb;
        }
        return object;
    }

    @NotNull
    public static final AABBd transformAabbToWorld(@Nullable class_1937 $this$transformAabbToWorld, @NotNull AABBdc aabb, @NotNull AABBd dest) {
        Intrinsics.checkNotNullParameter((Object)aabb, (String)"aabb");
        Intrinsics.checkNotNullParameter((Object)dest, (String)"dest");
        Ship ship = VSGameUtilsKt.getShipManagingPos($this$transformAabbToWorld, aabb.minX(), aabb.minY(), aabb.minZ());
        if (ship == null) {
            AABBd aABBd = dest.set(aabb);
            Intrinsics.checkNotNullExpressionValue((Object)aABBd, (String)"set(...)");
            return aABBd;
        }
        Ship ship1 = ship;
        Ship ship2 = VSGameUtilsKt.getShipManagingPos($this$transformAabbToWorld, aabb.maxX(), aabb.maxY(), aabb.maxZ());
        if (ship2 == null) {
            AABBd aABBd = dest.set(aabb);
            Intrinsics.checkNotNullExpressionValue((Object)aABBd, (String)"set(...)");
            return aABBd;
        }
        Ship ship22 = ship2;
        if (ship1.getId() == ship22.getId()) {
            AABBd aABBd = aabb.transform(ship1.getShipToWorld(), dest);
            Intrinsics.checkNotNullExpressionValue((Object)aABBd, (String)"transform(...)");
            return aABBd;
        }
        AABBd aABBd = dest.set(aabb);
        Intrinsics.checkNotNullExpressionValue((Object)aABBd, (String)"set(...)");
        return aABBd;
    }

    public static final void executeOrSchedule(@NotNull class_1937 $this$executeOrSchedule, @NotNull Runnable runnable) {
        class_1255 blockableEventLoop;
        Intrinsics.checkNotNullParameter((Object)$this$executeOrSchedule, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)runnable, (String)"runnable");
        if (!$this$executeOrSchedule.field_9236) {
            MinecraftServer minecraftServer = $this$executeOrSchedule.method_8503();
            Intrinsics.checkNotNull((Object)minecraftServer);
            v1 = (class_1255)minecraftServer;
        } else {
            class_310 class_3102 = class_310.method_1551();
            Intrinsics.checkNotNull((Object)class_3102);
            v1 = blockableEventLoop = (class_1255)class_3102;
        }
        if (blockableEventLoop.method_18854()) {
            runnable.run();
        } else {
            blockableEventLoop.execute(runnable);
        }
    }

    @Nullable
    public static final ShipMountedToData getShipMountedToData(@NotNull class_1297 passenger, @Nullable Float partialTicks) {
        Intrinsics.checkNotNullParameter((Object)passenger, (String)"passenger");
        class_1297 class_12972 = passenger.method_5854();
        if (class_12972 == null) {
            return null;
        }
        class_1297 vehicle = class_12972;
        if (vehicle instanceof ShipMountedToDataProvider) {
            return ((ShipMountedToDataProvider)vehicle).provideShipMountedToData(passenger, partialTicks);
        }
        class_1937 class_19372 = passenger.method_37908();
        class_243 class_2432 = vehicle.method_19538();
        Intrinsics.checkNotNullExpressionValue((Object)class_2432, (String)"position(...)");
        LoadedShip loadedShip = VSGameUtilsKt.getLoadedShipManagingPos(class_19372, (Vector3dc)VectorConversionsMCKt.toJOML(class_2432));
        if (loadedShip == null) {
            return null;
        }
        LoadedShip shipObjectEntityMountedTo = loadedShip;
        Float f2 = partialTicks;
        class_243 class_2433 = vehicle.method_30950(f2 != null ? f2.floatValue() : 0.0f).method_1031(0.0, vehicle.method_5621() + passenger.method_5678(), 0.0);
        Intrinsics.checkNotNullExpressionValue((Object)class_2433, (String)"add(...)");
        Vector3dc mountedPosInShip = VectorConversionsMCKt.toJOML(class_2433);
        return new ShipMountedToData(shipObjectEntityMountedTo, mountedPosInShip);
    }

    public static /* synthetic */ ShipMountedToData getShipMountedToData$default(class_1297 class_12972, Float f2, int n2, Object object) {
        if ((n2 & 2) != 0) {
            f2 = null;
        }
        return VSGameUtilsKt.getShipMountedToData(class_12972, f2);
    }

    @Nullable
    public static final LoadedShip getShipMountedTo(@NotNull class_1297 entity) {
        Intrinsics.checkNotNullParameter((Object)entity, (String)"entity");
        ShipMountedToData shipMountedToData = VSGameUtilsKt.getShipMountedToData$default(entity, null, 2, null);
        return shipMountedToData != null ? shipMountedToData.getShipMountedTo() : null;
    }

    public static final void applyShipVelocity(@Nullable class_1297 $this$applyShipVelocity, @Nullable Ship ship) {
        if ($this$applyShipVelocity == null || ship == null) {
            return;
        }
        class_243 class_2432 = $this$applyShipVelocity.method_19538();
        Intrinsics.checkNotNullExpressionValue((Object)class_2432, (String)"position(...)");
        Vector3d relPos = VectorConversionsMCKt.toJOML(class_2432).sub(ship.getTransform().getPositionInWorld());
        Vector3d shipSpeed = new Vector3d(ship.getVelocity()).add(ship.getAngularVelocity().cross(relPos, new Vector3d())).mul(0.05);
        $this$applyShipVelocity.method_5762(shipSpeed.x, shipSpeed.y, shipSpeed.z);
    }

    public static final boolean inAssemblyBlacklist(@Nullable class_2680 $this$inAssemblyBlacklist) {
        class_2680 class_26802 = $this$inAssemblyBlacklist;
        return class_26802 != null ? class_26802.method_26164(ValkyrienSkiesMod.INSTANCE.getASSEMBLE_BLACKLIST()) : false;
    }

    @JvmOverloads
    @NotNull
    public static final Vector3d toWorldCoordinates(@Nullable class_1937 $this$toWorldCoordinates, double x, double y, double z) {
        return VSGameUtilsKt.toWorldCoordinates$default($this$toWorldCoordinates, x, y, z, null, 8, null);
    }

    @JvmOverloads
    @NotNull
    public static final Vector3d toWorldCoordinates(@NotNull Ship $this$toWorldCoordinates, double x, double y, double z) {
        Intrinsics.checkNotNullParameter((Object)$this$toWorldCoordinates, (String)"<this>");
        return VSGameUtilsKt.toWorldCoordinates$default($this$toWorldCoordinates, x, y, z, null, 8, null);
    }

    private static final void executeIf$lambda$0(MinecraftServer $this_executeIf, Function0 $condition, Runnable $toExecute, TickEndEvent ev, RegisteredListener handler) {
        Intrinsics.checkNotNullParameter((Object)$this_executeIf, (String)"$this_executeIf");
        Intrinsics.checkNotNullParameter((Object)$condition, (String)"$condition");
        Intrinsics.checkNotNullParameter((Object)$toExecute, (String)"$toExecute");
        Intrinsics.checkNotNullParameter((Object)ev, (String)"ev");
        Intrinsics.checkNotNullParameter((Object)handler, (String)"handler");
        if (Intrinsics.areEqual((Object)ev.getWorld(), (Object)VSGameUtilsKt.getShipObjectWorld($this_executeIf)) && ((Boolean)$condition.invoke()).booleanValue()) {
            $toExecute.run();
            handler.unregister();
        }
    }
}

