/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Lazy
 *  kotlin.LazyKt
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.collections.CollectionsKt
 *  kotlin.jvm.JvmName
 *  kotlin.jvm.JvmOverloads
 *  kotlin.jvm.functions.Function3
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  net.minecraft.class_1297
 *  net.minecraft.class_1923
 *  net.minecraft.class_1937
 *  net.minecraft.class_2338
 *  net.minecraft.class_2350
 *  net.minecraft.class_2374
 *  net.minecraft.class_238
 *  net.minecraft.class_2382
 *  net.minecraft.class_243
 *  net.minecraft.class_310
 *  net.minecraft.class_4587
 *  net.minecraft.class_4587$class_4665
 *  net.minecraft.server.MinecraftServer
 */
package org.valkyrienskies.mod.api;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import net.minecraft.class_1297;
import net.minecraft.class_1923;
import net.minecraft.class_1937;
import net.minecraft.class_2338;
import net.minecraft.class_2350;
import net.minecraft.class_2374;
import net.minecraft.class_238;
import net.minecraft.class_2382;
import net.minecraft.class_243;
import net.minecraft.class_310;
import net.minecraft.class_4587;
import net.minecraft.server.MinecraftServer;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.joml.Matrix4dc;
import org.joml.Matrix4f;
import org.joml.Matrix4fc;
import org.joml.Quaterniondc;
import org.joml.Quaternionf;
import org.joml.Quaternionfc;
import org.joml.Vector2i;
import org.joml.Vector2ic;
import org.joml.Vector3d;
import org.joml.Vector3dc;
import org.joml.Vector3f;
import org.joml.Vector3i;
import org.joml.Vector3ic;
import org.joml.Vector4f;
import org.joml.primitives.AABBd;
import org.joml.primitives.AABBdc;
import org.valkyrienskies.core.api.ships.Ship;
import org.valkyrienskies.core.api.ships.properties.ShipTransform;
import org.valkyrienskies.core.api.util.functions.DoubleTernaryConsumer;
import org.valkyrienskies.core.api.world.ClientShipWorld;
import org.valkyrienskies.core.api.world.ServerShipWorld;
import org.valkyrienskies.core.api.world.ShipWorld;
import org.valkyrienskies.mod.api.VsApi;

@Metadata(mv={2, 0, 0}, k=2, xi=48, d1={"\u0000\u00ae\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u001c\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a!\u0010\u0005\u001a\u0004\u0018\u00010\u0004*\u0004\u0018\u00010\u00002\n\u0010\u0003\u001a\u00060\u0001j\u0002`\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006\u001a+\u0010\f\u001a\u00020\u000b*\u0004\u0018\u00010\u00002\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u0007\u00a2\u0006\u0004\b\f\u0010\r\u001a#\u0010\u0010\u001a\u00020\u000b*\u0004\u0018\u00010\u00002\u0006\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u0007\u00a2\u0006\u0004\b\u0010\u0010\u0011\u001a%\u0010\u0012\u001a\u0004\u0018\u00010\u0004*\u0004\u0018\u00010\u00002\u0006\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u0007\u00a2\u0006\u0004\b\u0012\u0010\u0013\u001a\u001f\u0010\u0012\u001a\u0004\u0018\u00010\u0004*\u0004\u0018\u00010\u00002\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014\u00a2\u0006\u0004\b\u0012\u0010\u0016\u001a-\u0010\u001a\u001a\u0004\u0018\u00010\u0004*\u0004\u0018\u00010\u00002\u0006\u0010\u0017\u001a\u00020\u00072\u0006\u0010\u0018\u001a\u00020\u00072\u0006\u0010\u0019\u001a\u00020\u0007\u00a2\u0006\u0004\b\u001a\u0010\u001b\u001a\u001f\u0010\u001a\u001a\u0004\u0018\u00010\u0004*\u0004\u0018\u00010\u00002\b\u0010\u0015\u001a\u0004\u0018\u00010\u001c\u00a2\u0006\u0004\b\u001a\u0010\u001d\u001a-\u0010\u001a\u001a\u0004\u0018\u00010\u0004*\u0004\u0018\u00010\u00002\u0006\u0010\u0017\u001a\u00020\u001e2\u0006\u0010\u0018\u001a\u00020\u001e2\u0006\u0010\u0019\u001a\u00020\u001e\u00a2\u0006\u0004\b\u001a\u0010\u001f\u001a\u001f\u0010\u001a\u001a\u0004\u0018\u00010\u0004*\u0004\u0018\u00010\u00002\b\u0010!\u001a\u0004\u0018\u00010 \u00a2\u0006\u0004\b\u001a\u0010\"\u001a\u001f\u0010\u001a\u001a\u0004\u0018\u00010\u0004*\u0004\u0018\u00010\u00002\b\u0010!\u001a\u0004\u0018\u00010#\u00a2\u0006\u0004\b\u001a\u0010$\u001a\u0015\u0010&\u001a\u0004\u0018\u00010\u0004*\u0004\u0018\u00010%\u00a2\u0006\u0004\b&\u0010'\u001a#\u0010,\u001a\u00020**\u0004\u0018\u00010\u00002\u0006\u0010)\u001a\u00020(2\u0006\u0010+\u001a\u00020*\u00a2\u0006\u0004\b,\u0010-\u001a\u001b\u0010,\u001a\u00020**\u0004\u0018\u00010\u00002\u0006\u0010)\u001a\u00020*\u00a2\u0006\u0004\b,\u0010.\u001a\u001b\u0010,\u001a\u00020/*\u0004\u0018\u00010\u00002\u0006\u0010)\u001a\u00020/\u00a2\u0006\u0004\b,\u00100\u001a\u001b\u00102\u001a\u000201*\u0004\u0018\u00010\u00002\u0006\u0010\u0015\u001a\u000201\u00a2\u0006\u0004\b2\u00103\u001a\u001b\u00102\u001a\u000204*\u0004\u0018\u00010\u00002\u0006\u0010\u0015\u001a\u000204\u00a2\u0006\u0004\b2\u00105\u001a#\u00102\u001a\u000204*\u0004\u0018\u00010\u00002\u0006\u0010\u0015\u001a\u00020 2\u0006\u0010+\u001a\u000204\u00a2\u0006\u0004\b2\u00106\u001a\u001b\u00102\u001a\u000201*\u0004\u0018\u00010\u00042\u0006\u0010\u0015\u001a\u000201\u00a2\u0006\u0004\b2\u00107\u001a\u001b\u00102\u001a\u000204*\u0004\u0018\u00010\u00042\u0006\u0010\u0015\u001a\u000204\u00a2\u0006\u0004\b2\u00108\u001a#\u00102\u001a\u000204*\u0004\u0018\u00010\u00042\u0006\u0010\u0015\u001a\u00020 2\u0006\u0010+\u001a\u000204\u00a2\u0006\u0004\b2\u00109\u001a\u001b\u0010:\u001a\u000201*\u0004\u0018\u00010\u00042\u0006\u0010\u0015\u001a\u000201\u00a2\u0006\u0004\b:\u00107\u001a\u001b\u0010:\u001a\u000204*\u0004\u0018\u00010\u00042\u0006\u0010\u0015\u001a\u000204\u00a2\u0006\u0004\b:\u00108\u001a#\u0010:\u001a\u000204*\u0004\u0018\u00010\u00042\u0006\u0010\u0015\u001a\u00020 2\u0006\u0010+\u001a\u000204\u00a2\u0006\u0004\b:\u00109\u001a\u001b\u00102\u001a\u000201*\u0004\u0018\u00010;2\u0006\u0010\u0015\u001a\u000201\u00a2\u0006\u0004\b2\u0010<\u001a\u001b\u00102\u001a\u000204*\u0004\u0018\u00010;2\u0006\u0010\u0015\u001a\u000204\u00a2\u0006\u0004\b2\u0010=\u001a#\u00102\u001a\u000204*\u0004\u0018\u00010;2\u0006\u0010\u0015\u001a\u00020 2\u0006\u0010+\u001a\u000204\u00a2\u0006\u0004\b2\u0010>\u001a\u001b\u0010:\u001a\u000201*\u0004\u0018\u00010;2\u0006\u0010\u0015\u001a\u000201\u00a2\u0006\u0004\b:\u0010<\u001a\u001b\u0010:\u001a\u000204*\u0004\u0018\u00010;2\u0006\u0010\u0015\u001a\u000204\u00a2\u0006\u0004\b:\u0010=\u001a#\u0010:\u001a\u000204*\u0004\u0018\u00010;2\u0006\u0010\u0015\u001a\u00020 2\u0006\u0010+\u001a\u000204\u00a2\u0006\u0004\b:\u0010>\u001a1\u0010@\u001a\b\u0012\u0004\u0012\u00020\u00040?*\u0004\u0018\u00010\u00002\u0006\u0010\u0017\u001a\u00020\u001e2\u0006\u0010\u0018\u001a\u00020\u001e2\u0006\u0010\u0019\u001a\u00020\u001e\u00a2\u0006\u0004\b@\u0010A\u001a#\u0010@\u001a\b\u0012\u0004\u0012\u00020\u00040?*\u0004\u0018\u00010\u00002\b\u0010)\u001a\u0004\u0018\u00010(\u00a2\u0006\u0004\b@\u0010B\u001a1\u0010C\u001a\b\u0012\u0004\u0012\u0002040?*\u0004\u0018\u00010\u00002\u0006\u0010\u0017\u001a\u00020\u001e2\u0006\u0010\u0018\u001a\u00020\u001e2\u0006\u0010\u0019\u001a\u00020\u001e\u00a2\u0006\u0004\bC\u0010A\u001a;\u0010C\u001a\b\u0012\u0004\u0012\u0002040?*\u0004\u0018\u00010\u00002\u0006\u0010\u0017\u001a\u00020\u001e2\u0006\u0010\u0018\u001a\u00020\u001e2\u0006\u0010\u0019\u001a\u00020\u001e2\b\u0010)\u001a\u0004\u0018\u00010(\u00a2\u0006\u0004\bC\u0010D\u001a9\u0010C\u001a\b\u0012\u0004\u0012\u0002040?*\u0004\u0018\u00010\u00002\u0006\u0010\u0017\u001a\u00020\u001e2\u0006\u0010\u0018\u001a\u00020\u001e2\u0006\u0010\u0019\u001a\u00020\u001e2\u0006\u0010E\u001a\u00020\u001e\u00a2\u0006\u0004\bC\u0010F\u001a3\u0010C\u001a\u00020I*\u0004\u0018\u00010\u00002\u0006\u0010\u0017\u001a\u00020\u001e2\u0006\u0010\u0018\u001a\u00020\u001e2\u0006\u0010\u0019\u001a\u00020\u001e2\u0006\u0010H\u001a\u00020G\u00a2\u0006\u0004\bC\u0010J\u001a=\u0010C\u001a\u00020I*\u0004\u0018\u00010\u00002\u0006\u0010\u0017\u001a\u00020\u001e2\u0006\u0010\u0018\u001a\u00020\u001e2\u0006\u0010\u0019\u001a\u00020\u001e2\b\u0010)\u001a\u0004\u0018\u00010(2\u0006\u0010H\u001a\u00020G\u00a2\u0006\u0004\bC\u0010K\u001a;\u0010C\u001a\u00020I*\u0004\u0018\u00010\u00002\u0006\u0010\u0017\u001a\u00020\u001e2\u0006\u0010\u0018\u001a\u00020\u001e2\u0006\u0010\u0019\u001a\u00020\u001e2\u0006\u0010E\u001a\u00020\u001e2\u0006\u0010H\u001a\u00020G\u00a2\u0006\u0004\bC\u0010L\u001a1\u0010M\u001a\b\u0012\u0004\u0012\u0002040?*\u0004\u0018\u00010\u00002\u0006\u0010\u0017\u001a\u00020\u001e2\u0006\u0010\u0018\u001a\u00020\u001e2\u0006\u0010\u0019\u001a\u00020\u001e\u00a2\u0006\u0004\bM\u0010A\u001a;\u0010M\u001a\b\u0012\u0004\u0012\u0002040?*\u0004\u0018\u00010\u00002\u0006\u0010\u0017\u001a\u00020\u001e2\u0006\u0010\u0018\u001a\u00020\u001e2\u0006\u0010\u0019\u001a\u00020\u001e2\b\u0010)\u001a\u0004\u0018\u00010(\u00a2\u0006\u0004\bM\u0010D\u001a9\u0010M\u001a\b\u0012\u0004\u0012\u0002040?*\u0004\u0018\u00010\u00002\u0006\u0010\u0017\u001a\u00020\u001e2\u0006\u0010\u0018\u001a\u00020\u001e2\u0006\u0010\u0019\u001a\u00020\u001e2\u0006\u0010E\u001a\u00020\u001e\u00a2\u0006\u0004\bM\u0010F\u001a3\u0010M\u001a\u00020I*\u0004\u0018\u00010\u00002\u0006\u0010\u0017\u001a\u00020\u001e2\u0006\u0010\u0018\u001a\u00020\u001e2\u0006\u0010\u0019\u001a\u00020\u001e2\u0006\u0010H\u001a\u00020G\u00a2\u0006\u0004\bM\u0010J\u001a=\u0010M\u001a\u00020I*\u0004\u0018\u00010\u00002\u0006\u0010\u0017\u001a\u00020\u001e2\u0006\u0010\u0018\u001a\u00020\u001e2\u0006\u0010\u0019\u001a\u00020\u001e2\b\u0010)\u001a\u0004\u0018\u00010(2\u0006\u0010H\u001a\u00020G\u00a2\u0006\u0004\bM\u0010K\u001a;\u0010M\u001a\u00020I*\u0004\u0018\u00010\u00002\u0006\u0010\u0017\u001a\u00020\u001e2\u0006\u0010\u0018\u001a\u00020\u001e2\u0006\u0010\u0019\u001a\u00020\u001e2\u0006\u0010E\u001a\u00020\u001e2\u0006\u0010H\u001a\u00020G\u00a2\u0006\u0004\bM\u0010L\u001a/\u0010O\u001a\u00020*2\u0006\u0010\u0017\u001a\u00020\u001e2\u0006\u0010\u0018\u001a\u00020\u001e2\u0006\u0010\u0019\u001a\u00020\u001e2\u0006\u0010N\u001a\u00020\u001eH\u0002\u00a2\u0006\u0004\bO\u0010P\u001aX\u0010M\u001a\u00020I*\u0004\u0018\u00010\u00002\u0006\u0010\u0017\u001a\u00020\u001e2\u0006\u0010\u0018\u001a\u00020\u001e2\u0006\u0010\u0019\u001a\u00020\u001e2\b\u0010)\u001a\u0004\u0018\u00010(2\u001e\u0010H\u001a\u001a\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020I0QH\u0082\b\u00a2\u0006\u0004\bM\u0010R\u001aX\u0010C\u001a\u00020I*\u0004\u0018\u00010\u00002\u0006\u0010\u0017\u001a\u00020\u001e2\u0006\u0010\u0018\u001a\u00020\u001e2\u0006\u0010\u0019\u001a\u00020\u001e2\b\u0010)\u001a\u0004\u0018\u00010(2\u001e\u0010H\u001a\u001a\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020I0QH\u0082\b\u00a2\u0006\u0004\bC\u0010R\u001aC\u0010Y\u001a\u00020\u001e*\u0004\u0018\u00010\u00002\u0006\u0010S\u001a\u00020\u001e2\u0006\u0010T\u001a\u00020\u001e2\u0006\u0010U\u001a\u00020\u001e2\u0006\u0010V\u001a\u00020\u001e2\u0006\u0010W\u001a\u00020\u001e2\u0006\u0010X\u001a\u00020\u001e\u00a2\u0006\u0004\bY\u0010Z\u001a#\u0010Y\u001a\u00020\u001e*\u0004\u0018\u00010\u00002\u0006\u0010[\u001a\u00020#2\u0006\u0010\\\u001a\u00020#\u00a2\u0006\u0004\bY\u0010]\u001aC\u0010^\u001a\u00020\u001e*\u0004\u0018\u00010\u00002\u0006\u0010S\u001a\u00020\u001e2\u0006\u0010T\u001a\u00020\u001e2\u0006\u0010U\u001a\u00020\u001e2\u0006\u0010V\u001a\u00020\u001e2\u0006\u0010W\u001a\u00020\u001e2\u0006\u0010X\u001a\u00020\u001e\u00a2\u0006\u0004\b^\u0010Z\u001a#\u0010^\u001a\u00020\u001e*\u0004\u0018\u00010\u00002\u0006\u0010[\u001a\u00020#2\u0006\u0010\\\u001a\u00020#\u00a2\u0006\u0004\b^\u0010]\u001a#\u0010^\u001a\u00020\u001e*\u0004\u0018\u00010\u00002\u0006\u0010[\u001a\u00020_2\u0006\u0010\\\u001a\u00020_\u00a2\u0006\u0004\b^\u0010`\u001a3\u0010a\u001a\u00020\u001e*\u0004\u0018\u00010\u00002\u0006\u0010[\u001a\u00020_2\u0006\u0010V\u001a\u00020\u001e2\u0006\u0010W\u001a\u00020\u001e2\u0006\u0010X\u001a\u00020\u001e\u00a2\u0006\u0004\ba\u0010b\u001a#\u0010a\u001a\u00020\u001e*\u0004\u0018\u00010\u00002\u0006\u0010[\u001a\u00020_2\u0006\u0010\\\u001a\u00020#\u00a2\u0006\u0004\ba\u0010c\u001a+\u0010d\u001a\u00020\u000b*\u0004\u0018\u00010\u00002\u0006\u0010[\u001a\u00020#2\u0006\u0010\\\u001a\u00020#2\u0006\u0010Y\u001a\u00020\u001e\u00a2\u0006\u0004\bd\u0010e\u001a+\u0010d\u001a\u00020\u000b*\u0004\u0018\u00010\u00002\u0006\u0010[\u001a\u00020_2\u0006\u0010\\\u001a\u00020_2\u0006\u0010Y\u001a\u00020\u001e\u00a2\u0006\u0004\bd\u0010f\u001a;\u0010g\u001a\u00020\u000b*\u0004\u0018\u00010\u00002\u0006\u0010[\u001a\u00020_2\u0006\u0010V\u001a\u00020\u001e2\u0006\u0010W\u001a\u00020\u001e2\u0006\u0010X\u001a\u00020\u001e2\u0006\u0010Y\u001a\u00020\u001e\u00a2\u0006\u0004\bg\u0010h\u001a+\u0010g\u001a\u00020\u000b*\u0004\u0018\u00010\u00002\u0006\u0010[\u001a\u00020_2\u0006\u0010\\\u001a\u00020#2\u0006\u0010Y\u001a\u00020\u001e\u00a2\u0006\u0004\bg\u0010i\u001a\u0013\u0010j\u001a\u00020\u001e*\u00020\u001eH\u0002\u00a2\u0006\u0004\bj\u0010k\u001a_\u0010o\u001a\u00028\u0000\"\u0004\b\u0000\u0010l*\u00020m2\u0006\u0010\u0017\u001a\u00020\u001e2\u0006\u0010\u0018\u001a\u00020\u001e2\u0006\u0010\u0019\u001a\u00020\u001e2\u001e\u0010n\u001a\u001a\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00028\u00000QH\u0082\b\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0004 \u0001\u00a2\u0006\u0004\bo\u0010p\u001a\u0019\u0010r\u001a\u00020q*\u00020q2\u0006\u0010!\u001a\u00020_\u00a2\u0006\u0004\br\u0010s\u001a\u0019\u0010r\u001a\u000204*\u0002042\u0006\u0010!\u001a\u00020_\u00a2\u0006\u0004\br\u0010t\u001a\u0019\u0010r\u001a\u00020u*\u00020u2\u0006\u0010!\u001a\u00020_\u00a2\u0006\u0004\br\u0010v\u001a\u0019\u0010r\u001a\u000204*\u0002042\u0006\u0010!\u001a\u00020#\u00a2\u0006\u0004\br\u0010w\u001a\u0019\u0010r\u001a\u00020**\u00020*2\u0006\u0010!\u001a\u00020/\u00a2\u0006\u0004\br\u0010x\u001a\u0011\u0010z\u001a\u00020\u001c*\u00020y\u00a2\u0006\u0004\bz\u0010{\u001a\u0011\u0010|\u001a\u000201*\u00020 \u00a2\u0006\u0004\b|\u0010}\u001a\u0011\u0010|\u001a\u00020/*\u00020(\u00a2\u0006\u0004\b|\u0010~\u001a\u0012\u0010\u007f\u001a\u00020**\u00020/\u00a2\u0006\u0005\b\u007f\u0010\u0080\u0001\u001a\u0015\u0010\u0082\u0001\u001a\u00020\u0014*\u00030\u0081\u0001\u00a2\u0006\u0006\b\u0082\u0001\u0010\u0083\u0001\u001a\u0013\u0010\u007f\u001a\u00030\u0084\u0001*\u00020\u0014\u00a2\u0006\u0005\b\u007f\u0010\u0085\u0001\u001a\u0012\u0010\u007f\u001a\u000204*\u000201\u00a2\u0006\u0005\b\u007f\u0010\u0086\u0001\u001a\u001a\u0010r\u001a\u000204*\u0002042\u0006\u0010!\u001a\u000201\u00a2\u0006\u0005\br\u0010\u0087\u0001\u001a\u001c\u0010r\u001a\u00030\u0084\u0001*\u00030\u0084\u00012\u0006\u0010\u0015\u001a\u00020\u0014\u00a2\u0006\u0005\br\u0010\u0088\u0001\u001a(\u0010\u0089\u0001\u001a\u000204*\u00020m2\u0006\u0010!\u001a\u00020_2\b\b\u0002\u0010+\u001a\u000204H\u0007\u00a2\u0006\u0006\b\u0089\u0001\u0010\u008a\u0001\u001a*\u0010\u0089\u0001\u001a\u000204*\u00020m2\b\u0010\u008c\u0001\u001a\u00030\u008b\u00012\b\b\u0002\u0010+\u001a\u000204H\u0007\u00a2\u0006\u0006\b\u0089\u0001\u0010\u008d\u0001\u001a\u001e\u0010\u008f\u0001\u001a\u00030\u008e\u0001*\u00020m2\u0007\u0010!\u001a\u00030\u008e\u0001\u00a2\u0006\u0006\b\u008f\u0001\u0010\u0090\u0001\u001a\u001c\u0010\u0091\u0001\u001a\u000201*\u00020m2\u0006\u0010!\u001a\u00020#\u00a2\u0006\u0006\b\u0091\u0001\u0010\u0092\u0001\u001a\u001f\u0010\u0095\u0001\u001a\u00030\u0093\u0001*\u00030\u0093\u00012\u0007\u0010\u0094\u0001\u001a\u00020m\u00a2\u0006\u0006\b\u0095\u0001\u0010\u0096\u0001\u001a\u0012\u0010\u007f\u001a\u00020q*\u00020_\u00a2\u0006\u0005\b\u007f\u0010\u0097\u0001\u001a\u0014\u0010\u0098\u0001\u001a\u000204*\u00020_\u00a2\u0006\u0006\b\u0098\u0001\u0010\u0099\u0001\u001a\u0014\u0010\u009a\u0001\u001a\u00020u*\u00020_\u00a2\u0006\u0006\b\u009a\u0001\u0010\u009b\u0001\u001a\u0012\u0010\u007f\u001a\u000204*\u00020#\u00a2\u0006\u0005\b\u007f\u0010\u009c\u0001\u001a\u0016\u0010\u009f\u0001\u001a\u00030\u009e\u0001*\u00030\u009d\u0001\u00a2\u0006\u0006\b\u009f\u0001\u0010\u00a0\u0001\u001a\u0015\u0010\u009f\u0001\u001a\u00030\u00a1\u0001*\u00020m\u00a2\u0006\u0006\b\u009f\u0001\u0010\u00a2\u0001\"!\u0010\u00a8\u0001\u001a\u00030\u00a3\u00018GX\u0086\u0084\u0002\u00a2\u0006\u0010\n\u0006\b\u00a4\u0001\u0010\u00a5\u0001\u001a\u0006\b\u00a6\u0001\u0010\u00a7\u0001\"\u001e\u0010\u00ad\u0001\u001a\b0\u00a9\u0001j\u0003`\u00aa\u0001*\u00020\u00008G\u00a2\u0006\b\u001a\u0006\b\u00ab\u0001\u0010\u00ac\u0001\"$\u0010\u00ad\u0001\u001a\f\u0018\u00010\u00a9\u0001j\u0005\u0018\u0001`\u00aa\u0001*\u0004\u0018\u00010\u00008G\u00a2\u0006\b\u001a\u0006\b\u00ae\u0001\u0010\u00ac\u0001\"\u001e\u0010\u00b3\u0001\u001a\u0005\u0018\u00010\u00b0\u0001*\u0005\u0018\u00010\u00af\u00018F\u00a2\u0006\b\u001a\u0006\b\u00b1\u0001\u0010\u00b2\u0001\"\u001e\u0010\u00b3\u0001\u001a\u0005\u0018\u00010\u00b5\u0001*\u0005\u0018\u00010\u00b4\u00018F\u00a2\u0006\b\u001a\u0006\b\u00b1\u0001\u0010\u00b6\u0001\"\u001d\u0010\u00b3\u0001\u001a\u0005\u0018\u00010\u00b7\u0001*\u0004\u0018\u00010\u00008F\u00a2\u0006\b\u001a\u0006\b\u00b1\u0001\u0010\u00b8\u0001\u00a8\u0006\u00b9\u0001"}, d2={"Lnet/minecraft/class_1937;", "", "Lorg/valkyrienskies/core/api/ships/properties/ShipId;", "id", "Lorg/valkyrienskies/core/api/ships/Ship;", "getShipById", "(Lnet/minecraft/class_1937;J)Lorg/valkyrienskies/core/api/ships/Ship;", "", "blockX", "blockY", "blockZ", "", "isBlockInShipyard", "(Lnet/minecraft/class_1937;III)Z", "chunkX", "chunkZ", "isChunkInShipyard", "(Lnet/minecraft/class_1937;II)Z", "getShipManagingChunk", "(Lnet/minecraft/class_1937;II)Lorg/valkyrienskies/core/api/ships/Ship;", "Lnet/minecraft/class_1923;", "pos", "(Lnet/minecraft/class_1937;Lnet/minecraft/class_1923;)Lorg/valkyrienskies/core/api/ships/Ship;", "x", "y", "z", "getShipManagingBlock", "(Lnet/minecraft/class_1937;III)Lorg/valkyrienskies/core/api/ships/Ship;", "Lnet/minecraft/class_2338;", "(Lnet/minecraft/class_1937;Lnet/minecraft/class_2338;)Lorg/valkyrienskies/core/api/ships/Ship;", "", "(Lnet/minecraft/class_1937;DDD)Lorg/valkyrienskies/core/api/ships/Ship;", "Lorg/joml/Vector3dc;", "v", "(Lnet/minecraft/class_1937;Lorg/joml/Vector3dc;)Lorg/valkyrienskies/core/api/ships/Ship;", "Lnet/minecraft/class_2374;", "(Lnet/minecraft/class_1937;Lnet/minecraft/class_2374;)Lorg/valkyrienskies/core/api/ships/Ship;", "Lnet/minecraft/class_1297;", "getShipManagingEntity", "(Lnet/minecraft/class_1297;)Lorg/valkyrienskies/core/api/ships/Ship;", "Lorg/joml/primitives/AABBdc;", "aabb", "Lorg/joml/primitives/AABBd;", "dest", "toWorld", "(Lnet/minecraft/class_1937;Lorg/joml/primitives/AABBdc;Lorg/joml/primitives/AABBd;)Lorg/joml/primitives/AABBd;", "(Lnet/minecraft/class_1937;Lorg/joml/primitives/AABBd;)Lorg/joml/primitives/AABBd;", "Lnet/minecraft/class_238;", "(Lnet/minecraft/class_1937;Lnet/minecraft/class_238;)Lnet/minecraft/class_238;", "Lnet/minecraft/class_243;", "positionToWorld", "(Lnet/minecraft/class_1937;Lnet/minecraft/class_243;)Lnet/minecraft/class_243;", "Lorg/joml/Vector3d;", "(Lnet/minecraft/class_1937;Lorg/joml/Vector3d;)Lorg/joml/Vector3d;", "(Lnet/minecraft/class_1937;Lorg/joml/Vector3dc;Lorg/joml/Vector3d;)Lorg/joml/Vector3d;", "(Lorg/valkyrienskies/core/api/ships/Ship;Lnet/minecraft/class_243;)Lnet/minecraft/class_243;", "(Lorg/valkyrienskies/core/api/ships/Ship;Lorg/joml/Vector3d;)Lorg/joml/Vector3d;", "(Lorg/valkyrienskies/core/api/ships/Ship;Lorg/joml/Vector3dc;Lorg/joml/Vector3d;)Lorg/joml/Vector3d;", "positionToShip", "Lorg/valkyrienskies/core/api/ships/properties/ShipTransform;", "(Lorg/valkyrienskies/core/api/ships/properties/ShipTransform;Lnet/minecraft/class_243;)Lnet/minecraft/class_243;", "(Lorg/valkyrienskies/core/api/ships/properties/ShipTransform;Lorg/joml/Vector3d;)Lorg/joml/Vector3d;", "(Lorg/valkyrienskies/core/api/ships/properties/ShipTransform;Lorg/joml/Vector3dc;Lorg/joml/Vector3d;)Lorg/joml/Vector3d;", "", "getShipsIntersecting", "(Lnet/minecraft/class_1937;DDD)Ljava/lang/Iterable;", "(Lnet/minecraft/class_1937;Lorg/joml/primitives/AABBdc;)Ljava/lang/Iterable;", "positionToNearbyShips", "(Lnet/minecraft/class_1937;DDDLorg/joml/primitives/AABBdc;)Ljava/lang/Iterable;", "aabbRadius", "(Lnet/minecraft/class_1937;DDDD)Ljava/lang/Iterable;", "Lorg/valkyrienskies/core/api/util/functions/DoubleTernaryConsumer;", "cb", "", "(Lnet/minecraft/class_1937;DDDLorg/valkyrienskies/core/api/util/functions/DoubleTernaryConsumer;)V", "(Lnet/minecraft/class_1937;DDDLorg/joml/primitives/AABBdc;Lorg/valkyrienskies/core/api/util/functions/DoubleTernaryConsumer;)V", "(Lnet/minecraft/class_1937;DDDDLorg/valkyrienskies/core/api/util/functions/DoubleTernaryConsumer;)V", "positionToNearbyShipsAndWorld", "r", "newAABBWithRadius", "(DDDD)Lorg/joml/primitives/AABBd;", "Lkotlin/Function3;", "(Lnet/minecraft/class_1937;DDDLorg/joml/primitives/AABBdc;Lkotlin/jvm/functions/Function3;)V", "x1", "y1", "z1", "x2", "y2", "z2", "distance", "(Lnet/minecraft/class_1937;DDDDDD)D", "v1", "v2", "(Lnet/minecraft/class_1937;Lnet/minecraft/class_2374;Lnet/minecraft/class_2374;)D", "distanceSquared", "Lnet/minecraft/class_2382;", "(Lnet/minecraft/class_1937;Lnet/minecraft/class_2382;Lnet/minecraft/class_2382;)D", "distanceToCenterSquared", "(Lnet/minecraft/class_1937;Lnet/minecraft/class_2382;DDD)D", "(Lnet/minecraft/class_1937;Lnet/minecraft/class_2382;Lnet/minecraft/class_2374;)D", "closerThan", "(Lnet/minecraft/class_1937;Lnet/minecraft/class_2374;Lnet/minecraft/class_2374;D)Z", "(Lnet/minecraft/class_1937;Lnet/minecraft/class_2382;Lnet/minecraft/class_2382;D)Z", "closerToCenterThan", "(Lnet/minecraft/class_1937;Lnet/minecraft/class_2382;DDDD)Z", "(Lnet/minecraft/class_1937;Lnet/minecraft/class_2382;Lnet/minecraft/class_2374;D)Z", "squared", "(D)D", "T", "Lorg/joml/Matrix4dc;", "transformed", "transformPositionInline", "(Lorg/joml/Matrix4dc;DDDLkotlin/jvm/functions/Function3;)Ljava/lang/Object;", "Lorg/joml/Vector3i;", "set", "(Lorg/joml/Vector3i;Lnet/minecraft/class_2382;)Lorg/joml/Vector3i;", "(Lorg/joml/Vector3d;Lnet/minecraft/class_2382;)Lorg/joml/Vector3d;", "Lorg/joml/Vector3f;", "(Lorg/joml/Vector3f;Lnet/minecraft/class_2382;)Lorg/joml/Vector3f;", "(Lorg/joml/Vector3d;Lnet/minecraft/class_2374;)Lorg/joml/Vector3d;", "(Lorg/joml/primitives/AABBd;Lnet/minecraft/class_238;)Lorg/joml/primitives/AABBd;", "Lorg/joml/Vector3ic;", "toBlockPos", "(Lorg/joml/Vector3ic;)Lnet/minecraft/class_2338;", "toMinecraft", "(Lorg/joml/Vector3dc;)Lnet/minecraft/class_243;", "(Lorg/joml/primitives/AABBdc;)Lnet/minecraft/class_238;", "toJOML", "(Lnet/minecraft/class_238;)Lorg/joml/primitives/AABBd;", "Lorg/joml/Vector2ic;", "toChunkPos", "(Lorg/joml/Vector2ic;)Lnet/minecraft/class_1923;", "Lorg/joml/Vector2i;", "(Lnet/minecraft/class_1923;)Lorg/joml/Vector2i;", "(Lnet/minecraft/class_243;)Lorg/joml/Vector3d;", "(Lorg/joml/Vector3d;Lnet/minecraft/class_243;)Lorg/joml/Vector3d;", "(Lorg/joml/Vector2i;Lnet/minecraft/class_1923;)Lorg/joml/Vector2i;", "transformDirection", "(Lorg/joml/Matrix4dc;Lnet/minecraft/class_2382;Lorg/joml/Vector3d;)Lorg/joml/Vector3d;", "Lnet/minecraft/class_2350;", "dir", "(Lorg/joml/Matrix4dc;Lnet/minecraft/class_2350;Lorg/joml/Vector3d;)Lorg/joml/Vector3d;", "Lorg/joml/Vector4f;", "transform", "(Lorg/joml/Matrix4dc;Lorg/joml/Vector4f;)Lorg/joml/Vector4f;", "transformPosition", "(Lorg/joml/Matrix4dc;Lnet/minecraft/class_2374;)Lnet/minecraft/class_243;", "Lnet/minecraft/class_4587;", "modelTransform", "multiply", "(Lnet/minecraft/class_4587;Lorg/joml/Matrix4dc;)Lnet/minecraft/class_4587;", "(Lnet/minecraft/class_2382;)Lorg/joml/Vector3i;", "toJOMLd", "(Lnet/minecraft/class_2382;)Lorg/joml/Vector3d;", "toJOMLf", "(Lnet/minecraft/class_2382;)Lorg/joml/Vector3f;", "(Lnet/minecraft/class_2374;)Lorg/joml/Vector3d;", "Lorg/joml/Quaterniondc;", "Lorg/joml/Quaternionfc;", "toFloat", "(Lorg/joml/Quaterniondc;)Lorg/joml/Quaternionfc;", "Lorg/joml/Matrix4fc;", "(Lorg/joml/Matrix4dc;)Lorg/joml/Matrix4fc;", "Lorg/valkyrienskies/mod/api/VsApi;", "vsApi$delegate", "Lkotlin/Lazy;", "api", "()Lorg/valkyrienskies/mod/api/VsApi;", "vsApi", "", "Lorg/valkyrienskies/core/api/world/properties/DimensionId;", "getDimensionIdNonnull", "(Lnet/minecraft/class_1937;)Ljava/lang/String;", "dimensionId", "getDimensionId", "Lnet/minecraft/server/MinecraftServer;", "Lorg/valkyrienskies/core/api/world/ServerShipWorld;", "getShipWorld", "(Lnet/minecraft/server/MinecraftServer;)Lorg/valkyrienskies/core/api/world/ServerShipWorld;", "shipWorld", "Lnet/minecraft/class_310;", "Lorg/valkyrienskies/core/api/world/ClientShipWorld;", "(Lnet/minecraft/class_310;)Lorg/valkyrienskies/core/api/world/ClientShipWorld;", "Lorg/valkyrienskies/core/api/world/ShipWorld;", "(Lnet/minecraft/class_1937;)Lorg/valkyrienskies/core/api/world/ShipWorld;", "valkyrienskies-120"})
@JvmName(name="ValkyrienSkies")
@SourceDebugExtension(value={"SMAP\nValkyrienSkies.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ValkyrienSkies.kt\norg/valkyrienskies/mod/api/ValkyrienSkies\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,589:1\n289#1:599\n290#1,4:601\n407#1,4:605\n295#1:609\n289#1:610\n290#1,4:612\n407#1,4:616\n295#1:620\n273#1,2:621\n289#1:623\n290#1,4:625\n407#1,4:629\n295#1:633\n275#1:634\n273#1,2:635\n289#1:637\n290#1,4:639\n407#1,4:643\n295#1:647\n275#1:648\n289#1:649\n290#1,4:651\n407#1,4:655\n295#1:659\n407#1,4:660\n407#1,4:664\n407#1,4:668\n407#1,4:672\n1#2:590\n1#2:600\n1#2:611\n1#2:624\n1#2:638\n1#2:650\n1557#3:591\n1628#3,3:592\n1557#3:595\n1628#3,3:596\n*S KotlinDebug\n*F\n+ 1 ValkyrienSkies.kt\norg/valkyrienskies/mod/api/ValkyrienSkies\n*L\n237#1:599\n237#1:601,4\n237#1:605,4\n237#1:609\n240#1:610\n240#1:612,4\n240#1:616,4\n240#1:620\n255#1:621,2\n255#1:623\n255#1:625,4\n255#1:629,4\n255#1:633\n255#1:634\n258#1:635,2\n258#1:637\n258#1:639,4\n258#1:643,4\n258#1:647\n258#1:648\n274#1:649\n274#1:651,4\n274#1:655,4\n274#1:659\n293#1:660,4\n322#1:664,4\n327#1:668,4\n549#1:672,4\n237#1:600\n240#1:611\n255#1:624\n258#1:638\n274#1:650\n223#1:591\n223#1:592,3\n230#1:595\n230#1:596,3\n*E\n"})
public final class ValkyrienSkies {
    @NotNull
    private static final Lazy vsApi$delegate = LazyKt.lazy(ValkyrienSkies::vsApi_delegate$lambda$0);

    @JvmName(name="api")
    @NotNull
    public static final VsApi api() {
        Lazy lazy = vsApi$delegate;
        return (VsApi)lazy.getValue();
    }

    @JvmName(name="getDimensionIdNonnull")
    public static final /* synthetic */ String getDimensionIdNonnull(class_1937 $this$dimensionId) {
        Intrinsics.checkNotNullParameter((Object)$this$dimensionId, (String)"<this>");
        return ValkyrienSkies.api().getDimensionId($this$dimensionId);
    }

    @Contract(value="null -> null; !null -> !null")
    @Nullable
    public static final String getDimensionId(@Nullable class_1937 $this$dimensionId) {
        class_1937 class_19372 = $this$dimensionId;
        return class_19372 != null ? ValkyrienSkies.getDimensionIdNonnull(class_19372) : null;
    }

    @Nullable
    public static final ServerShipWorld getShipWorld(@Nullable MinecraftServer $this$shipWorld) {
        return ValkyrienSkies.api().getServerShipWorld($this$shipWorld);
    }

    @Nullable
    public static final ClientShipWorld getShipWorld(@Nullable class_310 $this$shipWorld) {
        return ValkyrienSkies.api().getClientShipWorld($this$shipWorld);
    }

    @Nullable
    public static final ShipWorld getShipWorld(@Nullable class_1937 $this$shipWorld) {
        return ValkyrienSkies.api().getShipWorld($this$shipWorld);
    }

    @Nullable
    public static final Ship getShipById(@Nullable class_1937 $this$getShipById, long id) {
        Object object = ValkyrienSkies.getShipWorld($this$getShipById);
        return object != null && (object = object.getAllShips()) != null ? (Ship)object.getById(id) : null;
    }

    public static final boolean isBlockInShipyard(@Nullable class_1937 $this$isBlockInShipyard, int blockX, int blockY, int blockZ) {
        return ValkyrienSkies.isChunkInShipyard($this$isBlockInShipyard, blockX >> 4, blockZ >> 4);
    }

    public static final boolean isChunkInShipyard(@Nullable class_1937 $this$isChunkInShipyard, int chunkX, int chunkZ) {
        return ValkyrienSkies.api().isChunkInShipyard($this$isChunkInShipyard, chunkX, chunkZ);
    }

    @Nullable
    public static final Ship getShipManagingChunk(@Nullable class_1937 $this$getShipManagingChunk, int chunkX, int chunkZ) {
        return ValkyrienSkies.api().getShipManagingChunk($this$getShipManagingChunk, chunkX, chunkZ);
    }

    @Nullable
    public static final Ship getShipManagingChunk(@Nullable class_1937 $this$getShipManagingChunk, @Nullable class_1923 pos) {
        Ship ship;
        class_1923 class_19232 = pos;
        if (class_19232 != null) {
            class_1923 it = class_19232;
            boolean bl = false;
            ship = ValkyrienSkies.getShipManagingChunk($this$getShipManagingChunk, pos.field_9181, pos.field_9180);
        } else {
            ship = null;
        }
        return ship;
    }

    @Nullable
    public static final Ship getShipManagingBlock(@Nullable class_1937 $this$getShipManagingBlock, int x, int y, int z) {
        return ValkyrienSkies.getShipManagingChunk($this$getShipManagingBlock, x >> 4, z >> 4);
    }

    @Nullable
    public static final Ship getShipManagingBlock(@Nullable class_1937 $this$getShipManagingBlock, @Nullable class_2338 pos) {
        Ship ship;
        class_2338 class_23382 = pos;
        if (class_23382 != null) {
            class_2338 it = class_23382;
            boolean bl = false;
            ship = ValkyrienSkies.getShipManagingBlock($this$getShipManagingBlock, pos.method_10263(), pos.method_10264(), pos.method_10260());
        } else {
            ship = null;
        }
        return ship;
    }

    @Nullable
    public static final Ship getShipManagingBlock(@Nullable class_1937 $this$getShipManagingBlock, double x, double y, double z) {
        return ValkyrienSkies.getShipManagingBlock($this$getShipManagingBlock, (int)x, (int)y, (int)z);
    }

    @Nullable
    public static final Ship getShipManagingBlock(@Nullable class_1937 $this$getShipManagingBlock, @Nullable Vector3dc v) {
        Ship ship;
        Vector3dc vector3dc = v;
        if (vector3dc != null) {
            Vector3dc it = vector3dc;
            boolean bl = false;
            ship = ValkyrienSkies.getShipManagingBlock($this$getShipManagingBlock, v.x(), v.y(), v.z());
        } else {
            ship = null;
        }
        return ship;
    }

    @Nullable
    public static final Ship getShipManagingBlock(@Nullable class_1937 $this$getShipManagingBlock, @Nullable class_2374 v) {
        Ship ship;
        class_2374 class_23742 = v;
        if (class_23742 != null) {
            class_2374 it = class_23742;
            boolean bl = false;
            ship = ValkyrienSkies.getShipManagingBlock($this$getShipManagingBlock, v.method_10216(), v.method_10214(), v.method_10215());
        } else {
            ship = null;
        }
        return ship;
    }

    @Nullable
    public static final Ship getShipManagingEntity(@Nullable class_1297 $this$getShipManagingEntity) {
        class_1297 class_12972 = $this$getShipManagingEntity;
        return class_12972 != null && (class_12972 = class_12972.method_37908()) != null ? ValkyrienSkies.getShipManagingBlock((class_1937)class_12972, (class_2374)$this$getShipManagingEntity.method_19538()) : null;
    }

    @NotNull
    public static final AABBd toWorld(@Nullable class_1937 $this$toWorld, @NotNull AABBdc aabb, @NotNull AABBd dest) {
        Intrinsics.checkNotNullParameter((Object)aabb, (String)"aabb");
        Intrinsics.checkNotNullParameter((Object)dest, (String)"dest");
        Ship ship = ValkyrienSkies.getShipManagingBlock($this$toWorld, aabb.minX(), aabb.minY(), aabb.minZ());
        if (ship == null) {
            AABBd aABBd = dest.set(aabb);
            Intrinsics.checkNotNullExpressionValue((Object)aABBd, (String)"set(...)");
            return aABBd;
        }
        Ship ship1 = ship;
        Ship ship2 = ValkyrienSkies.getShipManagingBlock($this$toWorld, aabb.maxX(), aabb.maxY(), aabb.maxZ());
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

    @NotNull
    public static final AABBd toWorld(@Nullable class_1937 $this$toWorld, @NotNull AABBd aabb) {
        Intrinsics.checkNotNullParameter((Object)aabb, (String)"aabb");
        return ValkyrienSkies.toWorld($this$toWorld, aabb, aabb);
    }

    @NotNull
    public static final class_238 toWorld(@Nullable class_1937 $this$toWorld, @NotNull class_238 aabb) {
        Intrinsics.checkNotNullParameter((Object)aabb, (String)"aabb");
        return ValkyrienSkies.toMinecraft(ValkyrienSkies.toWorld($this$toWorld, ValkyrienSkies.toJOML(aabb)));
    }

    @NotNull
    public static final class_243 positionToWorld(@Nullable class_1937 $this$positionToWorld, @NotNull class_243 pos) {
        Intrinsics.checkNotNullParameter((Object)pos, (String)"pos");
        return ValkyrienSkies.positionToWorld(ValkyrienSkies.getShipManagingBlock($this$positionToWorld, (class_2374)pos), pos);
    }

    @NotNull
    public static final Vector3d positionToWorld(@Nullable class_1937 $this$positionToWorld, @NotNull Vector3d pos) {
        Intrinsics.checkNotNullParameter((Object)pos, (String)"pos");
        return ValkyrienSkies.positionToWorld($this$positionToWorld, (Vector3dc)pos, pos);
    }

    @NotNull
    public static final Vector3d positionToWorld(@Nullable class_1937 $this$positionToWorld, @NotNull Vector3dc pos, @NotNull Vector3d dest) {
        Intrinsics.checkNotNullParameter((Object)pos, (String)"pos");
        Intrinsics.checkNotNullParameter((Object)dest, (String)"dest");
        return ValkyrienSkies.positionToWorld(ValkyrienSkies.getShipManagingBlock($this$positionToWorld, pos), pos, dest);
    }

    @NotNull
    public static final class_243 positionToWorld(@Nullable Ship $this$positionToWorld, @NotNull class_243 pos) {
        Intrinsics.checkNotNullParameter((Object)pos, (String)"pos");
        Ship ship = $this$positionToWorld;
        return ValkyrienSkies.positionToWorld(ship != null ? ship.getTransform() : null, pos);
    }

    @NotNull
    public static final Vector3d positionToWorld(@Nullable Ship $this$positionToWorld, @NotNull Vector3d pos) {
        Intrinsics.checkNotNullParameter((Object)pos, (String)"pos");
        return ValkyrienSkies.positionToWorld($this$positionToWorld, (Vector3dc)pos, pos);
    }

    @NotNull
    public static final Vector3d positionToWorld(@Nullable Ship $this$positionToWorld, @NotNull Vector3dc pos, @NotNull Vector3d dest) {
        Intrinsics.checkNotNullParameter((Object)pos, (String)"pos");
        Intrinsics.checkNotNullParameter((Object)dest, (String)"dest");
        Ship ship = $this$positionToWorld;
        return ValkyrienSkies.positionToWorld(ship != null ? ship.getTransform() : null, pos, dest);
    }

    @NotNull
    public static final class_243 positionToShip(@Nullable Ship $this$positionToShip, @NotNull class_243 pos) {
        Intrinsics.checkNotNullParameter((Object)pos, (String)"pos");
        Ship ship = $this$positionToShip;
        return ValkyrienSkies.positionToShip(ship != null ? ship.getTransform() : null, pos);
    }

    @NotNull
    public static final Vector3d positionToShip(@Nullable Ship $this$positionToShip, @NotNull Vector3d pos) {
        Intrinsics.checkNotNullParameter((Object)pos, (String)"pos");
        return ValkyrienSkies.positionToShip($this$positionToShip, (Vector3dc)pos, pos);
    }

    @NotNull
    public static final Vector3d positionToShip(@Nullable Ship $this$positionToShip, @NotNull Vector3dc pos, @NotNull Vector3d dest) {
        Intrinsics.checkNotNullParameter((Object)pos, (String)"pos");
        Intrinsics.checkNotNullParameter((Object)dest, (String)"dest");
        Ship ship = $this$positionToShip;
        return ValkyrienSkies.positionToShip(ship != null ? ship.getTransform() : null, pos, dest);
    }

    @NotNull
    public static final class_243 positionToWorld(@Nullable ShipTransform $this$positionToWorld, @NotNull class_243 pos) {
        Intrinsics.checkNotNullParameter((Object)pos, (String)"pos");
        Object object = $this$positionToWorld;
        if (object == null || (object = object.getShipToWorld()) == null || (object = ValkyrienSkies.transformPosition((Matrix4dc)object, (class_2374)pos)) == null) {
            object = pos;
        }
        return object;
    }

    @NotNull
    public static final Vector3d positionToWorld(@Nullable ShipTransform $this$positionToWorld, @NotNull Vector3d pos) {
        Intrinsics.checkNotNullParameter((Object)pos, (String)"pos");
        return ValkyrienSkies.positionToWorld($this$positionToWorld, (Vector3dc)pos, pos);
    }

    @NotNull
    public static final Vector3d positionToWorld(@Nullable ShipTransform $this$positionToWorld, @NotNull Vector3dc pos, @NotNull Vector3d dest) {
        Intrinsics.checkNotNullParameter((Object)pos, (String)"pos");
        Intrinsics.checkNotNullParameter((Object)dest, (String)"dest");
        Object object = $this$positionToWorld;
        if (object == null || (object = object.getShipToWorld()) == null || (object = object.transformPosition(pos, dest)) == null) {
            Vector3d vector3d = dest.set(pos);
            object = vector3d;
            Intrinsics.checkNotNullExpressionValue((Object)vector3d, (String)"set(...)");
        }
        return object;
    }

    @NotNull
    public static final class_243 positionToShip(@Nullable ShipTransform $this$positionToShip, @NotNull class_243 pos) {
        Intrinsics.checkNotNullParameter((Object)pos, (String)"pos");
        Object object = $this$positionToShip;
        if (object == null || (object = object.getWorldToShip()) == null || (object = ValkyrienSkies.transformPosition((Matrix4dc)object, (class_2374)pos)) == null) {
            object = pos;
        }
        return object;
    }

    @NotNull
    public static final Vector3d positionToShip(@Nullable ShipTransform $this$positionToShip, @NotNull Vector3d pos) {
        Intrinsics.checkNotNullParameter((Object)pos, (String)"pos");
        return ValkyrienSkies.positionToShip($this$positionToShip, (Vector3dc)pos, pos);
    }

    @NotNull
    public static final Vector3d positionToShip(@Nullable ShipTransform $this$positionToShip, @NotNull Vector3dc pos, @NotNull Vector3d dest) {
        Intrinsics.checkNotNullParameter((Object)pos, (String)"pos");
        Intrinsics.checkNotNullParameter((Object)dest, (String)"dest");
        Object object = $this$positionToShip;
        if (object == null || (object = object.getWorldToShip()) == null || (object = object.transformPosition(pos, dest)) == null) {
            Vector3d vector3d = dest.set(pos);
            object = vector3d;
            Intrinsics.checkNotNullExpressionValue((Object)vector3d, (String)"set(...)");
        }
        return object;
    }

    @NotNull
    public static final Iterable<Ship> getShipsIntersecting(@Nullable class_1937 $this$getShipsIntersecting, double x, double y, double z) {
        return ValkyrienSkies.api().getShipsIntersecting($this$getShipsIntersecting, x, y, z);
    }

    @NotNull
    public static final Iterable<Ship> getShipsIntersecting(@Nullable class_1937 $this$getShipsIntersecting, @Nullable AABBdc aabb) {
        return ValkyrienSkies.api().getShipsIntersecting($this$getShipsIntersecting, aabb);
    }

    /*
     * WARNING - void declaration
     */
    @NotNull
    public static final Iterable<Vector3d> positionToNearbyShips(@Nullable class_1937 $this$positionToNearbyShips, double x, double y, double z) {
        void $this$mapTo$iv$iv;
        Iterable<Ship> $this$map$iv = ValkyrienSkies.getShipsIntersecting($this$positionToNearbyShips, x, y, z);
        boolean $i$f$map = false;
        Iterable<Ship> iterable = $this$map$iv;
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, (int)10));
        boolean $i$f$mapTo = false;
        for (Object item$iv$iv : $this$mapTo$iv$iv) {
            void it;
            Ship ship = (Ship)item$iv$iv;
            Collection collection = destination$iv$iv;
            boolean bl = false;
            collection.add(ValkyrienSkies.positionToShip((Ship)it, new Vector3d(x, y, z)));
        }
        return (List)destination$iv$iv;
    }

    /*
     * WARNING - void declaration
     */
    @NotNull
    public static final Iterable<Vector3d> positionToNearbyShips(@Nullable class_1937 $this$positionToNearbyShips, double x, double y, double z, @Nullable AABBdc aabb) {
        void $this$mapTo$iv$iv;
        if ($this$positionToNearbyShips == null || aabb == null) {
            return CollectionsKt.emptyList();
        }
        Iterable<Ship> $this$map$iv = ValkyrienSkies.getShipsIntersecting($this$positionToNearbyShips, aabb);
        boolean $i$f$map = false;
        Iterable<Ship> iterable = $this$map$iv;
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, (int)10));
        boolean $i$f$mapTo = false;
        for (Object item$iv$iv : $this$mapTo$iv$iv) {
            void it;
            Ship ship = (Ship)item$iv$iv;
            Collection collection = destination$iv$iv;
            boolean bl = false;
            collection.add(ValkyrienSkies.positionToShip((Ship)it, new Vector3d(x, y, z)));
        }
        return (List)destination$iv$iv;
    }

    @NotNull
    public static final Iterable<Vector3d> positionToNearbyShips(@Nullable class_1937 $this$positionToNearbyShips, double x, double y, double z, double aabbRadius) {
        return ValkyrienSkies.positionToNearbyShips($this$positionToNearbyShips, x, y, z, ValkyrienSkies.newAABBWithRadius(x, y, z, aabbRadius));
    }

    /*
     * WARNING - void declaration
     */
    public static final void positionToNearbyShips(@Nullable class_1937 $this$positionToNearbyShips, double x, double y, double z, @NotNull DoubleTernaryConsumer cb) {
        void $this$positionToNearbyShips$iv;
        Intrinsics.checkNotNullParameter((Object)cb, (String)"cb");
        class_1937 class_19372 = $this$positionToNearbyShips;
        Object aabb$iv = null;
        boolean $i$f$positionToNearbyShips = false;
        Iterable<Ship> ships$iv = ValkyrienSkies.getShipsIntersecting((class_1937)$this$positionToNearbyShips$iv, x, y, z);
        for (Ship ship$iv : ships$iv) {
            void p2;
            void p1;
            Matrix4dc $this$transformPositionInline$iv$iv = ship$iv.getWorldToShip();
            boolean $i$f$transformPositionInline = false;
            double d2 = $this$transformPositionInline$iv$iv.m02() * x + $this$transformPositionInline$iv$iv.m12() * y + $this$transformPositionInline$iv$iv.m22() * z + $this$transformPositionInline$iv$iv.m32();
            double d3 = $this$transformPositionInline$iv$iv.m01() * x + $this$transformPositionInline$iv$iv.m11() * y + $this$transformPositionInline$iv$iv.m21() * z + $this$transformPositionInline$iv$iv.m31();
            double p0 = $this$transformPositionInline$iv$iv.m00() * x + $this$transformPositionInline$iv$iv.m10() * y + $this$transformPositionInline$iv$iv.m20() * z + $this$transformPositionInline$iv$iv.m30();
            boolean bl = false;
            cb.accept(p0, (double)p1, (double)p2);
        }
    }

    /*
     * WARNING - void declaration
     */
    public static final void positionToNearbyShips(@Nullable class_1937 $this$positionToNearbyShips, double x, double y, double z, @Nullable AABBdc aabb, @NotNull DoubleTernaryConsumer cb) {
        Object object;
        block4: {
            class_1937 $this$positionToNearbyShips$iv;
            block3: {
                Intrinsics.checkNotNullParameter((Object)cb, (String)"cb");
                $this$positionToNearbyShips$iv = $this$positionToNearbyShips;
                boolean $i$f$positionToNearbyShips = false;
                object = aabb;
                if (object == null) break block3;
                AABBdc p0$iv = object;
                boolean bl = false;
                Iterable<Ship> iterable = ValkyrienSkies.getShipsIntersecting($this$positionToNearbyShips$iv, p0$iv);
                object = iterable;
                if (iterable != null) break block4;
            }
            object = ValkyrienSkies.getShipsIntersecting($this$positionToNearbyShips$iv, x, y, z);
        }
        Iterable<Ship> ships$iv = object;
        for (Ship ship$iv : ships$iv) {
            void p2;
            void p1;
            Matrix4dc $this$transformPositionInline$iv$iv = ship$iv.getWorldToShip();
            boolean $i$f$transformPositionInline = false;
            double d2 = $this$transformPositionInline$iv$iv.m02() * x + $this$transformPositionInline$iv$iv.m12() * y + $this$transformPositionInline$iv$iv.m22() * z + $this$transformPositionInline$iv$iv.m32();
            double d3 = $this$transformPositionInline$iv$iv.m01() * x + $this$transformPositionInline$iv$iv.m11() * y + $this$transformPositionInline$iv$iv.m21() * z + $this$transformPositionInline$iv$iv.m31();
            double p0 = $this$transformPositionInline$iv$iv.m00() * x + $this$transformPositionInline$iv$iv.m10() * y + $this$transformPositionInline$iv$iv.m20() * z + $this$transformPositionInline$iv$iv.m30();
            boolean bl = false;
            cb.accept(p0, (double)p1, (double)p2);
        }
    }

    public static final void positionToNearbyShips(@Nullable class_1937 $this$positionToNearbyShips, double x, double y, double z, double aabbRadius, @NotNull DoubleTernaryConsumer cb) {
        Intrinsics.checkNotNullParameter((Object)cb, (String)"cb");
        ValkyrienSkies.positionToNearbyShips($this$positionToNearbyShips, x, y, z, (AABBdc)ValkyrienSkies.newAABBWithRadius(x, y, z, aabbRadius), cb);
    }

    @NotNull
    public static final Iterable<Vector3d> positionToNearbyShipsAndWorld(@Nullable class_1937 $this$positionToNearbyShipsAndWorld, double x, double y, double z) {
        return CollectionsKt.plus((Collection)CollectionsKt.listOf((Object)new Vector3d(x, y, z)), ValkyrienSkies.positionToNearbyShips($this$positionToNearbyShipsAndWorld, x, y, z));
    }

    @NotNull
    public static final Iterable<Vector3d> positionToNearbyShipsAndWorld(@Nullable class_1937 $this$positionToNearbyShipsAndWorld, double x, double y, double z, @Nullable AABBdc aabb) {
        return CollectionsKt.plus((Collection)CollectionsKt.listOf((Object)new Vector3d(x, y, z)), ValkyrienSkies.positionToNearbyShips($this$positionToNearbyShipsAndWorld, x, y, z, aabb));
    }

    @NotNull
    public static final Iterable<Vector3d> positionToNearbyShipsAndWorld(@Nullable class_1937 $this$positionToNearbyShipsAndWorld, double x, double y, double z, double aabbRadius) {
        return ValkyrienSkies.positionToNearbyShipsAndWorld($this$positionToNearbyShipsAndWorld, x, y, z, ValkyrienSkies.newAABBWithRadius(x, y, z, aabbRadius));
    }

    /*
     * WARNING - void declaration
     */
    public static final void positionToNearbyShipsAndWorld(@Nullable class_1937 $this$positionToNearbyShipsAndWorld, double x, double y, double z, @NotNull DoubleTernaryConsumer cb) {
        void $this$positionToNearbyShipsAndWorld$iv;
        double p2;
        void p1;
        Intrinsics.checkNotNullParameter((Object)cb, (String)"cb");
        class_1937 class_19372 = $this$positionToNearbyShipsAndWorld;
        Object aabb$iv = null;
        boolean $i$f$positionToNearbyShipsAndWorld = false;
        double d2 = z;
        double d3 = y;
        double p0 = x;
        boolean bl = false;
        cb.accept(p0, (double)p1, p2);
        void $this$positionToNearbyShips$iv$iv = $this$positionToNearbyShipsAndWorld$iv;
        boolean $i$f$positionToNearbyShips = false;
        Iterable<Ship> ships$iv$iv = ValkyrienSkies.getShipsIntersecting((class_1937)$this$positionToNearbyShips$iv$iv, x, y, z);
        for (Ship ship$iv$iv : ships$iv$iv) {
            void p22;
            void p12;
            Matrix4dc $this$transformPositionInline$iv$iv$iv = ship$iv$iv.getWorldToShip();
            boolean $i$f$transformPositionInline = false;
            double d4 = $this$transformPositionInline$iv$iv$iv.m02() * x + $this$transformPositionInline$iv$iv$iv.m12() * y + $this$transformPositionInline$iv$iv$iv.m22() * z + $this$transformPositionInline$iv$iv$iv.m32();
            p2 = $this$transformPositionInline$iv$iv$iv.m01() * x + $this$transformPositionInline$iv$iv$iv.m11() * y + $this$transformPositionInline$iv$iv$iv.m21() * z + $this$transformPositionInline$iv$iv$iv.m31();
            double p02 = $this$transformPositionInline$iv$iv$iv.m00() * x + $this$transformPositionInline$iv$iv$iv.m10() * y + $this$transformPositionInline$iv$iv$iv.m20() * z + $this$transformPositionInline$iv$iv$iv.m30();
            $i$a$-positionToNearbyShipsAndWorld-ValkyrienSkies$positionToNearbyShipsAndWorld$1 = false;
            cb.accept(p02, (double)p12, (double)p22);
        }
    }

    /*
     * WARNING - void declaration
     */
    public static final void positionToNearbyShipsAndWorld(@Nullable class_1937 $this$positionToNearbyShipsAndWorld, double x, double y, double z, @Nullable AABBdc aabb, @NotNull DoubleTernaryConsumer cb) {
        Object object;
        double p2;
        block4: {
            class_1937 $this$positionToNearbyShips$iv$iv;
            block3: {
                void p1;
                Intrinsics.checkNotNullParameter((Object)cb, (String)"cb");
                class_1937 $this$positionToNearbyShipsAndWorld$iv = $this$positionToNearbyShipsAndWorld;
                boolean $i$f$positionToNearbyShipsAndWorld = false;
                double d2 = z;
                double d3 = y;
                double p0 = x;
                boolean bl = false;
                cb.accept(p0, (double)p1, p2);
                $this$positionToNearbyShips$iv$iv = $this$positionToNearbyShipsAndWorld$iv;
                boolean $i$f$positionToNearbyShips = false;
                object = aabb;
                if (object == null) break block3;
                AABBdc p0$iv$iv = object;
                boolean bl2 = false;
                Iterable<Ship> iterable = ValkyrienSkies.getShipsIntersecting($this$positionToNearbyShips$iv$iv, p0$iv$iv);
                object = iterable;
                if (iterable != null) break block4;
            }
            object = ValkyrienSkies.getShipsIntersecting($this$positionToNearbyShips$iv$iv, x, y, z);
        }
        Iterable<Ship> ships$iv$iv = object;
        for (Ship ship$iv$iv : ships$iv$iv) {
            void p22;
            void p1;
            Matrix4dc $this$transformPositionInline$iv$iv$iv = ship$iv$iv.getWorldToShip();
            boolean $i$f$transformPositionInline = false;
            double d4 = $this$transformPositionInline$iv$iv$iv.m02() * x + $this$transformPositionInline$iv$iv$iv.m12() * y + $this$transformPositionInline$iv$iv$iv.m22() * z + $this$transformPositionInline$iv$iv$iv.m32();
            p2 = $this$transformPositionInline$iv$iv$iv.m01() * x + $this$transformPositionInline$iv$iv$iv.m11() * y + $this$transformPositionInline$iv$iv$iv.m21() * z + $this$transformPositionInline$iv$iv$iv.m31();
            double p0 = $this$transformPositionInline$iv$iv$iv.m00() * x + $this$transformPositionInline$iv$iv$iv.m10() * y + $this$transformPositionInline$iv$iv$iv.m20() * z + $this$transformPositionInline$iv$iv$iv.m30();
            boolean bl = false;
            cb.accept(p0, (double)p1, (double)p22);
        }
    }

    public static final void positionToNearbyShipsAndWorld(@Nullable class_1937 $this$positionToNearbyShipsAndWorld, double x, double y, double z, double aabbRadius, @NotNull DoubleTernaryConsumer cb) {
        Intrinsics.checkNotNullParameter((Object)cb, (String)"cb");
        ValkyrienSkies.positionToNearbyShipsAndWorld($this$positionToNearbyShipsAndWorld, x, y, z, (AABBdc)ValkyrienSkies.newAABBWithRadius(x, y, z, aabbRadius), cb);
    }

    private static final AABBd newAABBWithRadius(double x, double y, double z, double r) {
        return new AABBd(x - r, y - r, z - r, x + r, y + r, z + r);
    }

    private static final void positionToNearbyShipsAndWorld(class_1937 $this$positionToNearbyShipsAndWorld, double x, double y, double z, AABBdc aabb, Function3<? super Double, ? super Double, ? super Double, Unit> cb) {
        Object object;
        block4: {
            class_1937 $this$positionToNearbyShips$iv;
            block3: {
                boolean $i$f$positionToNearbyShipsAndWorld = false;
                cb.invoke((Object)x, (Object)y, (Object)z);
                $this$positionToNearbyShips$iv = $this$positionToNearbyShipsAndWorld;
                boolean $i$f$positionToNearbyShips = false;
                object = aabb;
                if (object == null) break block3;
                AABBdc p0$iv = object;
                boolean bl = false;
                Iterable<Ship> iterable = ValkyrienSkies.getShipsIntersecting($this$positionToNearbyShips$iv, p0$iv);
                object = iterable;
                if (iterable != null) break block4;
            }
            object = ValkyrienSkies.getShipsIntersecting($this$positionToNearbyShips$iv, x, y, z);
        }
        Iterable<Ship> ships$iv = object;
        for (Ship ship$iv : ships$iv) {
            Matrix4dc $this$transformPositionInline$iv$iv = ship$iv.getWorldToShip();
            boolean $i$f$transformPositionInline = false;
            cb.invoke((Object)($this$transformPositionInline$iv$iv.m00() * x + $this$transformPositionInline$iv$iv.m10() * y + $this$transformPositionInline$iv$iv.m20() * z + $this$transformPositionInline$iv$iv.m30()), (Object)($this$transformPositionInline$iv$iv.m01() * x + $this$transformPositionInline$iv$iv.m11() * y + $this$transformPositionInline$iv$iv.m21() * z + $this$transformPositionInline$iv$iv.m31()), (Object)($this$transformPositionInline$iv$iv.m02() * x + $this$transformPositionInline$iv$iv.m12() * y + $this$transformPositionInline$iv$iv.m22() * z + $this$transformPositionInline$iv$iv.m32()));
        }
    }

    private static final void positionToNearbyShips(class_1937 $this$positionToNearbyShips, double x, double y, double z, AABBdc aabb, Function3<? super Double, ? super Double, ? super Double, Unit> cb) {
        Object object;
        block4: {
            block3: {
                boolean $i$f$positionToNearbyShips = false;
                object = aabb;
                if (object == null) break block3;
                AABBdc p0 = object;
                boolean bl = false;
                Iterable<Ship> iterable = ValkyrienSkies.getShipsIntersecting($this$positionToNearbyShips, p0);
                object = iterable;
                if (iterable != null) break block4;
            }
            object = ValkyrienSkies.getShipsIntersecting($this$positionToNearbyShips, x, y, z);
        }
        Iterable<Ship> ships = object;
        for (Ship ship : ships) {
            Matrix4dc $this$transformPositionInline$iv = ship.getWorldToShip();
            boolean $i$f$transformPositionInline = false;
            cb.invoke((Object)($this$transformPositionInline$iv.m00() * x + $this$transformPositionInline$iv.m10() * y + $this$transformPositionInline$iv.m20() * z + $this$transformPositionInline$iv.m30()), (Object)($this$transformPositionInline$iv.m01() * x + $this$transformPositionInline$iv.m11() * y + $this$transformPositionInline$iv.m21() * z + $this$transformPositionInline$iv.m31()), (Object)($this$transformPositionInline$iv.m02() * x + $this$transformPositionInline$iv.m12() * y + $this$transformPositionInline$iv.m22() * z + $this$transformPositionInline$iv.m32()));
        }
    }

    public static final double distance(@Nullable class_1937 $this$distance, double x1, double y1, double z1, double x2, double y2, double z2) {
        return Math.sqrt(ValkyrienSkies.distanceSquared($this$distance, x1, y1, z1, x2, y2, z2));
    }

    public static final double distance(@Nullable class_1937 $this$distance, @NotNull class_2374 v1, @NotNull class_2374 v2) {
        Intrinsics.checkNotNullParameter((Object)v1, (String)"v1");
        Intrinsics.checkNotNullParameter((Object)v2, (String)"v2");
        return Math.sqrt(ValkyrienSkies.distanceSquared($this$distance, v1, v2));
    }

    public static final double distanceSquared(@Nullable class_1937 $this$distanceSquared, double x1, double y1, double z1, double x2, double y2, double z2) {
        Ship ship2;
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
        Ship ship1 = ValkyrienSkies.getShipManagingBlock($this$distanceSquared, x1, y1, z1);
        if (!Intrinsics.areEqual((Object)ship1, (Object)(ship2 = ValkyrienSkies.getShipManagingBlock($this$distanceSquared, x2, y2, z2)))) {
            Object object;
            double z;
            double y;
            double x;
            boolean $i$f$transformPositionInline;
            Object $this$transformPositionInline$iv;
            Object object2 = ship1;
            if (object2 != null && (object2 = object2.getShipToWorld()) != null) {
                $this$transformPositionInline$iv = object2;
                $i$f$transformPositionInline = false;
                double d2 = $this$transformPositionInline$iv.m02() * x1 + $this$transformPositionInline$iv.m12() * y1 + $this$transformPositionInline$iv.m22() * z1 + $this$transformPositionInline$iv.m32();
                double d3 = $this$transformPositionInline$iv.m01() * x1 + $this$transformPositionInline$iv.m11() * y1 + $this$transformPositionInline$iv.m21() * z1 + $this$transformPositionInline$iv.m31();
                x = $this$transformPositionInline$iv.m00() * x1 + $this$transformPositionInline$iv.m10() * y1 + $this$transformPositionInline$iv.m20() * z1 + $this$transformPositionInline$iv.m30();
                boolean bl = false;
                inWorldX1 = x;
                inWorldY1 = y;
                inWorldZ1 = z;
            }
            if ((object = ship2) != null && (object = object.getShipToWorld()) != null) {
                $this$transformPositionInline$iv = object;
                $i$f$transformPositionInline = false;
                z = $this$transformPositionInline$iv.m02() * x2 + $this$transformPositionInline$iv.m12() * y2 + $this$transformPositionInline$iv.m22() * z2 + $this$transformPositionInline$iv.m32();
                y = $this$transformPositionInline$iv.m01() * x2 + $this$transformPositionInline$iv.m11() * y2 + $this$transformPositionInline$iv.m21() * z2 + $this$transformPositionInline$iv.m31();
                x = $this$transformPositionInline$iv.m00() * x2 + $this$transformPositionInline$iv.m10() * y2 + $this$transformPositionInline$iv.m20() * z2 + $this$transformPositionInline$iv.m30();
                boolean bl = false;
                inWorldX2 = x;
                inWorldY2 = y;
                inWorldZ2 = z;
            }
        }
        double dx = inWorldX2 - inWorldX1;
        double dy = inWorldY2 - inWorldY1;
        double dz = inWorldZ2 - inWorldZ1;
        return dx * dx + dy * dy + dz * dz;
    }

    public static final double distanceSquared(@Nullable class_1937 $this$distanceSquared, @NotNull class_2374 v1, @NotNull class_2374 v2) {
        Intrinsics.checkNotNullParameter((Object)v1, (String)"v1");
        Intrinsics.checkNotNullParameter((Object)v2, (String)"v2");
        return ValkyrienSkies.distanceSquared($this$distanceSquared, v1.method_10216(), v1.method_10214(), v1.method_10215(), v2.method_10216(), v2.method_10214(), v2.method_10215());
    }

    public static final double distanceSquared(@Nullable class_1937 $this$distanceSquared, @NotNull class_2382 v1, @NotNull class_2382 v2) {
        Intrinsics.checkNotNullParameter((Object)v1, (String)"v1");
        Intrinsics.checkNotNullParameter((Object)v2, (String)"v2");
        return ValkyrienSkies.distanceSquared($this$distanceSquared, v1.method_10263(), v1.method_10264(), v1.method_10260(), v2.method_10263(), v2.method_10264(), v2.method_10260());
    }

    public static final double distanceToCenterSquared(@Nullable class_1937 $this$distanceToCenterSquared, @NotNull class_2382 v1, double x2, double y2, double z2) {
        Intrinsics.checkNotNullParameter((Object)v1, (String)"v1");
        return ValkyrienSkies.distanceSquared($this$distanceToCenterSquared, (double)v1.method_10263() + 0.5, (double)v1.method_10264() + 0.5, (double)v1.method_10260() + 0.5, x2, y2, z2);
    }

    public static final double distanceToCenterSquared(@Nullable class_1937 $this$distanceToCenterSquared, @NotNull class_2382 v1, @NotNull class_2374 v2) {
        Intrinsics.checkNotNullParameter((Object)v1, (String)"v1");
        Intrinsics.checkNotNullParameter((Object)v2, (String)"v2");
        return ValkyrienSkies.distanceToCenterSquared($this$distanceToCenterSquared, v1, v2.method_10216(), v2.method_10214(), v2.method_10215());
    }

    public static final boolean closerThan(@Nullable class_1937 $this$closerThan, @NotNull class_2374 v1, @NotNull class_2374 v2, double distance) {
        Intrinsics.checkNotNullParameter((Object)v1, (String)"v1");
        Intrinsics.checkNotNullParameter((Object)v2, (String)"v2");
        return ValkyrienSkies.distanceSquared($this$closerThan, v1, v2) < ValkyrienSkies.squared(distance);
    }

    public static final boolean closerThan(@Nullable class_1937 $this$closerThan, @NotNull class_2382 v1, @NotNull class_2382 v2, double distance) {
        Intrinsics.checkNotNullParameter((Object)v1, (String)"v1");
        Intrinsics.checkNotNullParameter((Object)v2, (String)"v2");
        return ValkyrienSkies.distanceSquared($this$closerThan, v1, v2) < ValkyrienSkies.squared(distance);
    }

    public static final boolean closerToCenterThan(@Nullable class_1937 $this$closerToCenterThan, @NotNull class_2382 v1, double x2, double y2, double z2, double distance) {
        Intrinsics.checkNotNullParameter((Object)v1, (String)"v1");
        return ValkyrienSkies.distanceToCenterSquared($this$closerToCenterThan, v1, x2, y2, z2) < ValkyrienSkies.squared(distance);
    }

    public static final boolean closerToCenterThan(@Nullable class_1937 $this$closerToCenterThan, @NotNull class_2382 v1, @NotNull class_2374 v2, double distance) {
        Intrinsics.checkNotNullParameter((Object)v1, (String)"v1");
        Intrinsics.checkNotNullParameter((Object)v2, (String)"v2");
        return ValkyrienSkies.distanceToCenterSquared($this$closerToCenterThan, v1, v2) < ValkyrienSkies.squared(distance);
    }

    private static final double squared(double $this$squared) {
        return $this$squared * $this$squared;
    }

    private static final <T> T transformPositionInline(Matrix4dc $this$transformPositionInline, double x, double y, double z, Function3<? super Double, ? super Double, ? super Double, ? extends T> transformed) {
        boolean $i$f$transformPositionInline = false;
        return (T)transformed.invoke((Object)($this$transformPositionInline.m00() * x + $this$transformPositionInline.m10() * y + $this$transformPositionInline.m20() * z + $this$transformPositionInline.m30()), (Object)($this$transformPositionInline.m01() * x + $this$transformPositionInline.m11() * y + $this$transformPositionInline.m21() * z + $this$transformPositionInline.m31()), (Object)($this$transformPositionInline.m02() * x + $this$transformPositionInline.m12() * y + $this$transformPositionInline.m22() * z + $this$transformPositionInline.m32()));
    }

    @NotNull
    public static final Vector3i set(@NotNull Vector3i $this$set, @NotNull class_2382 v) {
        Vector3i vector3i;
        Intrinsics.checkNotNullParameter((Object)$this$set, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)v, (String)"v");
        Vector3i it = vector3i = $this$set;
        boolean bl = false;
        $this$set.x = v.method_10263();
        $this$set.y = v.method_10264();
        $this$set.z = v.method_10260();
        return vector3i;
    }

    @NotNull
    public static final Vector3d set(@NotNull Vector3d $this$set, @NotNull class_2382 v) {
        Vector3d vector3d;
        Intrinsics.checkNotNullParameter((Object)$this$set, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)v, (String)"v");
        Vector3d it = vector3d = $this$set;
        boolean bl = false;
        $this$set.x = v.method_10263();
        $this$set.y = v.method_10264();
        $this$set.z = v.method_10260();
        return vector3d;
    }

    @NotNull
    public static final Vector3f set(@NotNull Vector3f $this$set, @NotNull class_2382 v) {
        Vector3f vector3f;
        Intrinsics.checkNotNullParameter((Object)$this$set, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)v, (String)"v");
        Vector3f it = vector3f = $this$set;
        boolean bl = false;
        $this$set.x = v.method_10263();
        $this$set.y = v.method_10264();
        $this$set.z = v.method_10260();
        return vector3f;
    }

    @NotNull
    public static final Vector3d set(@NotNull Vector3d $this$set, @NotNull class_2374 v) {
        Vector3d vector3d;
        Intrinsics.checkNotNullParameter((Object)$this$set, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)v, (String)"v");
        Vector3d it = vector3d = $this$set;
        boolean bl = false;
        $this$set.x = v.method_10216();
        $this$set.y = v.method_10214();
        $this$set.z = v.method_10215();
        return vector3d;
    }

    @NotNull
    public static final AABBd set(@NotNull AABBd $this$set, @NotNull class_238 v) {
        AABBd aABBd;
        Intrinsics.checkNotNullParameter((Object)$this$set, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)v, (String)"v");
        AABBd it = aABBd = $this$set;
        boolean bl = false;
        $this$set.minX = v.field_1323;
        $this$set.minY = v.field_1322;
        $this$set.minZ = v.field_1321;
        $this$set.maxX = v.field_1320;
        $this$set.maxY = v.field_1325;
        $this$set.maxZ = v.field_1324;
        return aABBd;
    }

    @NotNull
    public static final class_2338 toBlockPos(@NotNull Vector3ic $this$toBlockPos) {
        Intrinsics.checkNotNullParameter((Object)$this$toBlockPos, (String)"<this>");
        return new class_2338($this$toBlockPos.x(), $this$toBlockPos.y(), $this$toBlockPos.z());
    }

    @NotNull
    public static final class_243 toMinecraft(@NotNull Vector3dc $this$toMinecraft) {
        Intrinsics.checkNotNullParameter((Object)$this$toMinecraft, (String)"<this>");
        return new class_243($this$toMinecraft.x(), $this$toMinecraft.y(), $this$toMinecraft.z());
    }

    @NotNull
    public static final class_238 toMinecraft(@NotNull AABBdc $this$toMinecraft) {
        Intrinsics.checkNotNullParameter((Object)$this$toMinecraft, (String)"<this>");
        return new class_238($this$toMinecraft.minX(), $this$toMinecraft.minY(), $this$toMinecraft.minZ(), $this$toMinecraft.maxX(), $this$toMinecraft.maxY(), $this$toMinecraft.maxZ());
    }

    @NotNull
    public static final AABBd toJOML(@NotNull class_238 $this$toJOML) {
        Intrinsics.checkNotNullParameter((Object)$this$toJOML, (String)"<this>");
        return ValkyrienSkies.set(new AABBd(), $this$toJOML);
    }

    @NotNull
    public static final class_1923 toChunkPos(@NotNull Vector2ic $this$toChunkPos) {
        Intrinsics.checkNotNullParameter((Object)$this$toChunkPos, (String)"<this>");
        return new class_1923($this$toChunkPos.x(), $this$toChunkPos.y());
    }

    @NotNull
    public static final Vector2i toJOML(@NotNull class_1923 $this$toJOML) {
        Intrinsics.checkNotNullParameter((Object)$this$toJOML, (String)"<this>");
        return ValkyrienSkies.set(new Vector2i(), $this$toJOML);
    }

    @NotNull
    public static final Vector3d toJOML(@NotNull class_243 $this$toJOML) {
        Intrinsics.checkNotNullParameter((Object)$this$toJOML, (String)"<this>");
        return ValkyrienSkies.set(new Vector3d(), $this$toJOML);
    }

    @NotNull
    public static final Vector3d set(@NotNull Vector3d $this$set, @NotNull class_243 v) {
        Vector3d vector3d;
        Intrinsics.checkNotNullParameter((Object)$this$set, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)v, (String)"v");
        Vector3d it = vector3d = $this$set;
        boolean bl = false;
        $this$set.x = v.field_1352;
        $this$set.y = v.field_1351;
        $this$set.z = v.field_1350;
        return vector3d;
    }

    @NotNull
    public static final Vector2i set(@NotNull Vector2i $this$set, @NotNull class_1923 pos) {
        Vector2i vector2i;
        Intrinsics.checkNotNullParameter((Object)$this$set, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)pos, (String)"pos");
        Vector2i it = vector2i = $this$set;
        boolean bl = false;
        $this$set.x = pos.field_9181;
        $this$set.y = pos.field_9180;
        return vector2i;
    }

    @JvmOverloads
    @NotNull
    public static final Vector3d transformDirection(@NotNull Matrix4dc $this$transformDirection, @NotNull class_2382 v, @NotNull Vector3d dest) {
        Intrinsics.checkNotNullParameter((Object)$this$transformDirection, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)v, (String)"v");
        Intrinsics.checkNotNullParameter((Object)dest, (String)"dest");
        Vector3d vector3d = $this$transformDirection.transformDirection(dest.set(v.method_10263(), v.method_10264(), v.method_10260()));
        Intrinsics.checkNotNullExpressionValue((Object)vector3d, (String)"transformDirection(...)");
        return vector3d;
    }

    public static /* synthetic */ Vector3d transformDirection$default(Matrix4dc matrix4dc, class_2382 class_23822, Vector3d vector3d, int n2, Object object) {
        if ((n2 & 2) != 0) {
            vector3d = new Vector3d();
        }
        return ValkyrienSkies.transformDirection(matrix4dc, class_23822, vector3d);
    }

    @JvmOverloads
    @NotNull
    public static final Vector3d transformDirection(@NotNull Matrix4dc $this$transformDirection, @NotNull class_2350 dir, @NotNull Vector3d dest) {
        Intrinsics.checkNotNullParameter((Object)$this$transformDirection, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)dir, (String)"dir");
        Intrinsics.checkNotNullParameter((Object)dest, (String)"dest");
        class_2382 class_23822 = dir.method_10163();
        Intrinsics.checkNotNullExpressionValue((Object)class_23822, (String)"getNormal(...)");
        return ValkyrienSkies.transformDirection($this$transformDirection, class_23822, dest);
    }

    public static /* synthetic */ Vector3d transformDirection$default(Matrix4dc matrix4dc, class_2350 class_23502, Vector3d vector3d, int n2, Object object) {
        if ((n2 & 2) != 0) {
            vector3d = new Vector3d();
        }
        return ValkyrienSkies.transformDirection(matrix4dc, class_23502, vector3d);
    }

    @NotNull
    public static final Vector4f transform(@NotNull Matrix4dc $this$transform, @NotNull Vector4f v) {
        Vector4f vector4f;
        Intrinsics.checkNotNullParameter((Object)$this$transform, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)v, (String)"v");
        Vector4f it = vector4f = v;
        boolean bl = false;
        it.set((float)($this$transform.m00() * (double)v.x() + $this$transform.m01() * (double)v.y() + $this$transform.m02() * (double)v.z() + $this$transform.m03() * (double)v.w()), (float)($this$transform.m10() * (double)v.x() + $this$transform.m11() * (double)v.y() + $this$transform.m12() * (double)v.z() + $this$transform.m13() * (double)v.w()), (float)($this$transform.m20() * (double)v.x() + $this$transform.m21() * (double)v.y() + $this$transform.m22() * (double)v.z() + $this$transform.m23() * (double)v.w()), (float)($this$transform.m30() * (double)v.x() + $this$transform.m31() * (double)v.y() + $this$transform.m32() * (double)v.z() + $this$transform.m33() * (double)v.w()));
        return vector4f;
    }

    /*
     * WARNING - void declaration
     */
    @NotNull
    public static final class_243 transformPosition(@NotNull Matrix4dc $this$transformPosition, @NotNull class_2374 v) {
        void z;
        void y;
        void y$iv;
        void x$iv;
        void $this$transformPositionInline$iv;
        Intrinsics.checkNotNullParameter((Object)$this$transformPosition, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)v, (String)"v");
        Matrix4dc matrix4dc = $this$transformPosition;
        double d2 = v.method_10216();
        double d3 = v.method_10214();
        double z$iv = v.method_10215();
        boolean $i$f$transformPositionInline = false;
        double d4 = $this$transformPositionInline$iv.m02() * x$iv + $this$transformPositionInline$iv.m12() * y$iv + $this$transformPositionInline$iv.m22() * z$iv + $this$transformPositionInline$iv.m32();
        double d5 = $this$transformPositionInline$iv.m01() * x$iv + $this$transformPositionInline$iv.m11() * y$iv + $this$transformPositionInline$iv.m21() * z$iv + $this$transformPositionInline$iv.m31();
        double x = $this$transformPositionInline$iv.m00() * x$iv + $this$transformPositionInline$iv.m10() * y$iv + $this$transformPositionInline$iv.m20() * z$iv + $this$transformPositionInline$iv.m30();
        boolean bl = false;
        return new class_243(x, (double)y, (double)z);
    }

    @NotNull
    public static final class_4587 multiply(@NotNull class_4587 $this$multiply, @NotNull Matrix4dc modelTransform) {
        class_4587 class_45872;
        Intrinsics.checkNotNullParameter((Object)$this$multiply, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)modelTransform, (String)"modelTransform");
        class_4587 it = class_45872 = $this$multiply;
        boolean bl = false;
        class_4587.class_4665 last2 = $this$multiply.method_23760();
        Matrix4fc modelTransformF = ValkyrienSkies.toFloat(modelTransform);
        Matrix4f matrix4f = new Matrix4f(last2.method_23761()).mul(modelTransformF);
        Intrinsics.checkNotNullExpressionValue((Object)matrix4f, (String)"mul(...)");
        Matrix4fc newPose = matrix4f;
        last2.method_23761().set(newPose);
        return class_45872;
    }

    @NotNull
    public static final Vector3i toJOML(@NotNull class_2382 $this$toJOML) {
        Intrinsics.checkNotNullParameter((Object)$this$toJOML, (String)"<this>");
        return ValkyrienSkies.set(new Vector3i(), $this$toJOML);
    }

    @NotNull
    public static final Vector3d toJOMLd(@NotNull class_2382 $this$toJOMLd) {
        Intrinsics.checkNotNullParameter((Object)$this$toJOMLd, (String)"<this>");
        return ValkyrienSkies.set(new Vector3d(), $this$toJOMLd);
    }

    @NotNull
    public static final Vector3f toJOMLf(@NotNull class_2382 $this$toJOMLf) {
        Intrinsics.checkNotNullParameter((Object)$this$toJOMLf, (String)"<this>");
        return ValkyrienSkies.set(new Vector3f(), $this$toJOMLf);
    }

    @NotNull
    public static final Vector3d toJOML(@NotNull class_2374 $this$toJOML) {
        Intrinsics.checkNotNullParameter((Object)$this$toJOML, (String)"<this>");
        return ValkyrienSkies.set(new Vector3d(), $this$toJOML);
    }

    @NotNull
    public static final Quaternionfc toFloat(@NotNull Quaterniondc $this$toFloat) {
        Intrinsics.checkNotNullParameter((Object)$this$toFloat, (String)"<this>");
        return new Quaternionf($this$toFloat.x(), $this$toFloat.y(), $this$toFloat.z(), $this$toFloat.w());
    }

    @NotNull
    public static final Matrix4fc toFloat(@NotNull Matrix4dc $this$toFloat) {
        Intrinsics.checkNotNullParameter((Object)$this$toFloat, (String)"<this>");
        Matrix4f matrix4f = new Matrix4f().set($this$toFloat);
        Intrinsics.checkNotNullExpressionValue((Object)matrix4f, (String)"set(...)");
        return matrix4f;
    }

    @JvmOverloads
    @NotNull
    public static final Vector3d transformDirection(@NotNull Matrix4dc $this$transformDirection, @NotNull class_2382 v) {
        Intrinsics.checkNotNullParameter((Object)$this$transformDirection, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)v, (String)"v");
        return ValkyrienSkies.transformDirection$default($this$transformDirection, v, null, 2, null);
    }

    @JvmOverloads
    @NotNull
    public static final Vector3d transformDirection(@NotNull Matrix4dc $this$transformDirection, @NotNull class_2350 dir) {
        Intrinsics.checkNotNullParameter((Object)$this$transformDirection, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)dir, (String)"dir");
        return ValkyrienSkies.transformDirection$default($this$transformDirection, dir, null, 2, null);
    }

    /*
     * WARNING - void declaration
     */
    private static final VsApi vsApi_delegate$lambda$0() {
        void var0;
        try {
            void var2_3;
            Class<?> modClass = Class.forName("org.valkyrienskies.mod.common.ValkyrienSkiesMod");
            Method getApi = modClass.getDeclaredMethod("getApi", new Class[0]);
            Object object = getApi.invoke(null, new Object[0]);
            Intrinsics.checkNotNull((Object)object, (String)"null cannot be cast to non-null type org.valkyrienskies.mod.api.VsApi");
            VsApi instance = (VsApi)object;
            var0 = var2_3;
        }
        catch (Exception ex) {
            throw new IllegalStateException("Failed initialize the Valkyrien Skies API. Suggestion: Ensure that you have Valkyrien Skies installed.", ex);
        }
        return var0;
    }
}

