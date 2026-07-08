/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.Pair
 *  kotlin.jvm.JvmName
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.PropertyReference1
 *  kotlin.jvm.internal.PropertyReference1Impl
 *  kotlin.jvm.internal.Reflection
 *  kotlin.ranges.RangesKt
 *  kotlin.reflect.KProperty
 *  org.valkyrienskies.core.impl.shadow.Eh
 */
package org.valkyrienskies.core.impl.shadow;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.lang.invoke.LambdaMetafactory;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.function.Function;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.ranges.RangesKt;
import kotlin.reflect.KProperty;
import org.apache.logging.log4j.Logger;
import org.joml.Quaterniond;
import org.joml.Vector3d;
import org.joml.Vector3dc;
import org.joml.Vector3i;
import org.joml.Vector3ic;
import org.joml.primitives.AABBi;
import org.joml.primitives.AABBic;
import org.valkyrienskies.core.api.physics.blockstates.BoxesBlockShape;
import org.valkyrienskies.core.api.physics.blockstates.SolidState;
import org.valkyrienskies.core.api.ships.DragController;
import org.valkyrienskies.core.api.ships.PhysShip;
import org.valkyrienskies.core.api.ships.ShipPhysicsListener;
import org.valkyrienskies.core.api.util.AerodynamicUtils;
import org.valkyrienskies.core.api.world.PhysLevel;
import org.valkyrienskies.core.impl.config.VSCoreConfig;
import org.valkyrienskies.core.impl.shadow.CP;
import org.valkyrienskies.core.impl.shadow.DN;
import org.valkyrienskies.core.impl.shadow.Eh;
import org.valkyrienskies.core.impl.shadow.FX;
import org.valkyrienskies.core.impl.shadow.ef_0;
import org.valkyrienskies.core.impl.shadow.ij_0;
import org.valkyrienskies.core.impl.shadow.il_0;
import org.valkyrienskies.core.impl.shadow.in_0;
import org.valkyrienskies.core.internal.physics.blockstates.VsiBlockState;
import org.valkyrienskies.core.util.VectorConversionsKt;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.Eh
 */
@Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u0000\u00ac\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \f2\u00020\u00012\u00020\u0002:\u0001\fB\u0011\u0012\b\b\u0002\u0010\u0004\u001a\u00020:\u00a2\u0006\u0004\ba\u0010bJ\u001f\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0016\u00a2\u0006\u0004\b\b\u0010\tJ\u001d\u0010\f\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\n2\u0006\u0010\u0006\u001a\u00020\u000b\u00a2\u0006\u0004\b\f\u0010\rJ\u0015\u0010\f\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\n\u00a2\u0006\u0004\b\f\u0010\u000eJ)\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u000f2\u0006\u0010\u0004\u001a\u00020\n2\u0006\u0010\u0006\u001a\u00020\u000b\u00a2\u0006\u0004\b\u0010\u0010\u0011J\u0015\u0010\f\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0004\b\f\u0010\u0012J\u001d\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0004\u001a\u00020\n2\u0006\u0010\u0006\u001a\u00020\u000b\u00a2\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0016\u001a\u00020\u0007H\u0016\u00a2\u0006\u0004\b\u0016\u0010\u0017J\u000f\u0010\u0018\u001a\u00020\u0007H\u0016\u00a2\u0006\u0004\b\u0018\u0010\u0017J\u000f\u0010\u0019\u001a\u00020\u0007H\u0016\u00a2\u0006\u0004\b\u0019\u0010\u0017J\u000f\u0010\u001a\u001a\u00020\u0007H\u0016\u00a2\u0006\u0004\b\u001a\u0010\u0017J\u000f\u0010\u001b\u001a\u00020\u0007H\u0016\u00a2\u0006\u0004\b\u001b\u0010\u0017J\u000f\u0010\u001c\u001a\u00020\u0007H\u0016\u00a2\u0006\u0004\b\u001c\u0010\u0017J\u000f\u0010\u001d\u001a\u00020\u0003H\u0002\u00a2\u0006\u0004\b\u001d\u0010\u001eJ\u000f\u0010\u001f\u001a\u00020\u0003H\u0002\u00a2\u0006\u0004\b\u001f\u0010\u001eJ\u000f\u0010 \u001a\u00020\u0003H\u0016\u00a2\u0006\u0004\b \u0010\u001eJ\u000f\u0010!\u001a\u00020\u0003H\u0016\u00a2\u0006\u0004\b!\u0010\u001eJ\u001f\u0010\f\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\n2\u0006\u0010\u0006\u001a\u00020\u0003H\u0002\u00a2\u0006\u0004\b\f\u0010\"J\u000f\u0010#\u001a\u00020\u0003H\u0016\u00a2\u0006\u0004\b#\u0010\u001eJ\u001d\u0010\f\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020$2\u0006\u0010\u0006\u001a\u00020%\u00a2\u0006\u0004\b\f\u0010&J\u001f\u0010(\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\n2\u0006\u0010\u0006\u001a\u00020'H\u0016\u00a2\u0006\u0004\b(\u0010)J\u0015\u0010\f\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020*\u00a2\u0006\u0004\b\f\u0010+J/\u0010/\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010,\u001a\u00020\u00052\u0006\u0010.\u001a\u00020-H\u0016\u00a2\u0006\u0004\b/\u00100J\u001f\u00101\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020-H\u0016\u00a2\u0006\u0004\b1\u00102J'\u0010\f\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u0002032\u0006\u0010\u0006\u001a\u0002042\u0006\u0010,\u001a\u000205H\u0002\u00a2\u0006\u0004\b\f\u00106J\u001b\u0010\f\u001a\u00020\u0005*\u0002072\u0006\u0010\u0004\u001a\u000205H\u0002\u00a2\u0006\u0004\b\f\u00108J\u0013\u0010\f\u001a\u00020:*\u000209H\u0002\u00a2\u0006\u0004\b\f\u0010;R6\u0010\f\u001a\u001e\u0012\u0004\u0012\u000203\u0012\u0004\u0012\u0002090<j\u000e\u0012\u0004\u0012\u000203\u0012\u0004\u0012\u000209`=8\u0007X\u0087\u0004\u00a2\u0006\f\n\u0004\b>\u0010?\u001a\u0004\b@\u0010AR\u001a\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020*0B8\u0002X\u0083\u0004\u00a2\u0006\u0006\n\u0004\bC\u0010DR\u0018\u0010\u0010\u001a\u0004\u0018\u0001048\u0002@\u0002X\u0083\u000e\u00a2\u0006\u0006\n\u0004\bE\u0010FR&\u0010@\u001a\u00060-j\u0002`G8\u0007@\u0007X\u0087\u000e\u00a2\u0006\u0012\n\u0004\b@\u0010H\u001a\u0004\b\u0010\u0010I\"\u0004\b\f\u0010JR\u0016\u0010C\u001a\u00020:8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bK\u0010LRV\u0010>\u001a>\u0012\u0004\u0012\u00020\u0003\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u0002030Mj\b\u0012\u0004\u0012\u000203`N0<j\u001e\u0012\u0004\u0012\u00020\u0003\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u0002030Mj\b\u0012\u0004\u0012\u000203`N`=8\u0007X\u0087\u0004\u00a2\u0006\f\n\u0004\bO\u0010?\u001a\u0004\bC\u0010AR\u0017\u0010O\u001a\u00020:8\u0007\u00a2\u0006\f\n\u0004\b\u0010\u0010L\u001a\u0004\b\u0014\u0010PR\u0016\u0010\u001d\u001a\u00020:8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bQ\u0010LR$\u0010\u001f\u001a\u0004\u0018\u0001048\u0007@\u0007X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0014\u0010F\u001a\u0004\bO\u0010R\"\u0004\b\f\u0010SR\u0016\u0010U\u001a\u00020:8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bT\u0010LR6\u0010V\u001a\u001e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00050<j\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0005`=8\u0007X\u0087\u0004\u00a2\u0006\f\n\u0004\b\u001d\u0010?\u001a\u0004\b>\u0010AR\u0016\u0010X\u001a\u00020\u00038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001f\u0010WR\u0016\u0010Y\u001a\u00020\u00038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bU\u0010WR\u0014\u0010[\u001a\u00020\u00138\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bY\u0010ZR \u0010^\u001a\u000e\u0012\u0004\u0012\u00020-\u0012\u0004\u0012\u00020\u00130\\8\u0002X\u0083\u0004\u00a2\u0006\u0006\n\u0004\bV\u0010]R\u0014\u0010_\u001a\u00020\u00138\u0002X\u0083\u0004\u00a2\u0006\u0006\n\u0004\b^\u0010ZR&\u0010K\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00050\u000f0B8\u0002X\u0083\u0004\u00a2\u0006\u0006\n\u0004\b_\u0010DR\u0016\u0010Q\u001a\u00020\u00058\u0002@\u0002X\u0083\u000e\u00a2\u0006\u0006\n\u0004\b[\u0010`R \u0010T\u001a\u000e\u0012\u0004\u0012\u00020-\u0012\u0004\u0012\u00020\u00050\\8\u0002X\u0083\u0004\u00a2\u0006\u0006\n\u0004\bX\u0010]"}, d2={"Lorg/valkyrienskies/core/impl/shadow/Eh;", "Lorg/valkyrienskies/core/api/ships/DragController;", "Lorg/valkyrienskies/core/api/ships/ShipPhysicsListener;", "Lorg/joml/Vector3dc;", "p0", "", "p1", "", "applyWindImpulse", "(Lorg/joml/Vector3dc;D)V", "Lorg/valkyrienskies/core/api/ships/PhysShip;", "Lorg/valkyrienskies/core/api/util/AerodynamicUtils;", "a", "(Lorg/valkyrienskies/core/api/ships/PhysShip;Lorg/valkyrienskies/core/api/util/AerodynamicUtils;)Lorg/joml/Vector3dc;", "(Lorg/valkyrienskies/core/api/ships/PhysShip;)Lorg/joml/Vector3dc;", "Lkotlin/Pair;", "c", "(Lorg/valkyrienskies/core/api/ships/PhysShip;Lorg/valkyrienskies/core/api/util/AerodynamicUtils;)Lkotlin/Pair;", "(D)D", "Lorg/joml/Vector3d;", "b", "(Lorg/valkyrienskies/core/api/ships/PhysShip;Lorg/valkyrienskies/core/api/util/AerodynamicUtils;)Lorg/joml/Vector3d;", "disableDrag", "()V", "disableLift", "disableRotDrag", "enableDrag", "enableLift", "enableRotDrag", "h", "()Lorg/joml/Vector3dc;", "i", "getDragForce", "getLiftForce", "(Lorg/valkyrienskies/core/api/ships/PhysShip;Lorg/joml/Vector3dc;)D", "getWindVector", "Lorg/valkyrienskies/core/impl/shadow/Il;", "Lorg/valkyrienskies/core/impl/shadow/DN;", "(Lorg/valkyrienskies/core/impl/shadow/Il;Lorg/valkyrienskies/core/impl/shadow/DN;)V", "Lorg/valkyrienskies/core/api/world/PhysLevel;", "physTick", "(Lorg/valkyrienskies/core/api/ships/PhysShip;Lorg/valkyrienskies/core/api/world/PhysLevel;)V", "Lorg/valkyrienskies/core/impl/shadow/Ef;", "(Lorg/valkyrienskies/core/impl/shadow/Ef;)V", "p2", "", "p3", "setWindDirection", "(DDDLjava/lang/String;)V", "setWindSpeed", "(DLjava/lang/String;)V", "Lorg/joml/Vector3ic;", "Lorg/joml/primitives/AABBic;", "", "(Lorg/joml/Vector3ic;Lorg/joml/primitives/AABBic;I)V", "Lorg/valkyrienskies/core/api/physics/blockstates/BoxesBlockShape;", "(Lorg/valkyrienskies/core/api/physics/blockstates/BoxesBlockShape;I)D", "Lorg/valkyrienskies/core/internal/physics/blockstates/VsiBlockState;", "", "(Lorg/valkyrienskies/core/internal/physics/blockstates/VsiBlockState;)Z", "Ljava/util/HashMap;", "Lkotlin/collections/d;", "f", "Ljava/util/HashMap;", "d", "()Ljava/util/HashMap;", "Ljava/util/concurrent/ConcurrentLinkedQueue;", "e", "Ljava/util/concurrent/ConcurrentLinkedQueue;", "t", "Lorg/joml/primitives/AABBic;", "Lorg/valkyrienskies/core/api/world/properties/DimensionId;", "Ljava/lang/String;", "()Ljava/lang/String;", "(Ljava/lang/String;)V", "q", "Z", "Ljava/util/HashSet;", "Lkotlin/collections/f;", "g", "()Z", "r", "()Lorg/joml/primitives/AABBic;", "(Lorg/joml/primitives/AABBic;)V", "s", "j", "k", "Lorg/joml/Vector3dc;", "l", "m", "Lorg/joml/Vector3d;", "n", "Ljava/util/concurrent/ConcurrentHashMap;", "Ljava/util/concurrent/ConcurrentHashMap;", "o", "p", "D", "<init>", "(Z)V"})
public final class eh_0
implements DragController,
ShipPhysicsListener {
    public static final a a = new a(null);
    private final boolean c;
    private String d;
    @JsonIgnore
    private final ConcurrentLinkedQueue<ef_0> e;
    @JsonIgnore
    private final HashMap<Vector3ic, VsiBlockState> f;
    @JsonIgnore
    private final HashMap<Vector3dc, HashSet<Vector3ic>> g;
    @JsonIgnore
    private final HashMap<Vector3dc, Double> h;
    private volatile Vector3dc i;
    private volatile Vector3dc j;
    @JsonIgnore
    private final ConcurrentHashMap<String, Vector3d> k;
    @JsonIgnore
    private final ConcurrentHashMap<String, Double> l;
    private final Vector3d m;
    private double n;
    private final Vector3d o;
    @JsonIgnore
    private final ConcurrentLinkedQueue<Pair<Vector3dc, Double>> p;
    private volatile boolean q;
    private volatile boolean r;
    private volatile boolean s;
    public volatile AABBic b;
    private AABBic t;
    private static final Logger u = FX.a("Pizza Factory");

    private eh_0(boolean bl) {
        this.c = bl;
        this.d = "minecraft:dimension:minecraft:overworld";
        this.e = new ConcurrentLinkedQueue();
        this.f = new HashMap();
        this.g = new HashMap();
        this.h = new HashMap();
        this.i = new Vector3d(0.0, 0.0, 0.0);
        this.j = new Vector3d(0.0, 0.0, 0.0);
        this.k = new ConcurrentHashMap();
        this.l = new ConcurrentHashMap();
        this.m = new Vector3d(0.0, 0.0, 0.0);
        this.o = new Vector3d(0.0, 0.0, 0.0);
        this.p = new ConcurrentLinkedQueue();
        this.q = true;
        this.r = true;
        this.s = true;
    }

    public /* synthetic */ eh_0(boolean bl, int n2, DefaultConstructorMarker defaultConstructorMarker) {
        if ((n2 & 1) != 0) {
            bl = false;
        }
        this(bl);
    }

    @JvmName(name="b")
    private boolean b() {
        return this.c;
    }

    @JvmName(name="c")
    private String c() {
        return this.d;
    }

    @JvmName(name="a")
    private void a(String string) {
        Intrinsics.checkNotNullParameter((Object)string, (String)"");
        this.d = string;
    }

    @JvmName(name="d")
    private HashMap<Vector3ic, VsiBlockState> d() {
        return this.f;
    }

    @JvmName(name="e")
    private HashMap<Vector3dc, HashSet<Vector3ic>> e() {
        return this.g;
    }

    @JvmName(name="f")
    private HashMap<Vector3dc, Double> f() {
        return this.h;
    }

    @JvmName(name="g")
    private AABBic g() {
        return this.b;
    }

    @JvmName(name="a")
    public final void a(AABBic aABBic) {
        this.b = aABBic;
    }

    /*
     * Could not resolve type clashes
     * Unable to fully structure code
     */
    @Override
    public final void physTick(PhysShip physShip, PhysLevel physLevel) {
        block84: {
            block86: {
                block85: {
                    Intrinsics.checkNotNullParameter((Object)physShip, (String)"");
                    Intrinsics.checkNotNullParameter((Object)physLevel, (String)"");
                    if (!Intrinsics.areEqual((Object)this.d, (Object)physLevel.getDimension())) {
                        this.d = physLevel.getDimension();
                    }
                    if (!this.q) {
                        return;
                    }
                    if (this.t == null && this.b == null) {
                        return;
                    }
                    if (this.b != null) {
                        this.t = this.b;
                        this.b = null;
                    }
                    while (((Collection)this.e).isEmpty() == false) {
                        block83: {
                            var3_3 = this.e.poll();
                            v0 = this.t;
                            Intrinsics.checkNotNull((Object)v0);
                            var15_44 = var3_3;
                            if (!VectorConversionsKt.expand(v0, 10, new AABBi()).containsPoint(var15_44.a)) continue;
                            var7_11 = var3_3;
                            if (var7_11.c) break block83;
                            var5_8 = ((Collection)org.valkyrienskies.core.impl.shadow.Eh$a.a()).size();
                            for (var4_4 = 0; var4_4 < var5_8; ++var4_4) {
                                Intrinsics.checkNotNullExpressionValue((Object)this.g.computeIfAbsent(org.valkyrienskies.core.impl.shadow.Eh$a.a().get(var4_4), (Function<Object, HashSet>)LambdaMetafactory.metafactory(null, null, null, (Ljava/lang/Object;)Ljava/lang/Object;, a(kotlin.jvm.functions.Function1 java.lang.Object ), (Ljava/lang/Object;)Ljava/util/HashSet;)((Function1)3.a)), (String)"");
                                v1 = this.g.get(org.valkyrienskies.core.impl.shadow.Eh$a.a().get(var4_4));
                                Intrinsics.checkNotNull(v1);
                                var15_44 = var3_3;
                                if (!v1.contains(var15_44.a)) ** GOTO lbl-1000
                                var15_44 = var3_3;
                                if (((Map)this.f).containsKey(var15_44.a)) {
                                    v2 = true;
                                } else lbl-1000:
                                // 2 sources

                                {
                                    v2 = false;
                                }
                                var7_12 = v2;
                                switch (var4_4) {
                                    case 0: 
                                    case 1: {
                                        var9_15 = (Iterable)var6_10;
                                        if (var9_15 instanceof Collection && ((Collection)var9_15).isEmpty()) ** GOTO lbl51
                                        var11_28 = var9_15.iterator();
                                        while (var11_28.hasNext()) {
                                            var12_29 = var11_28.next();
                                            var13_39 = (Vector3ic)var12_29;
                                            var15_44 = var3_3;
                                            if (var13_39.y() != var15_44.a.y()) ** GOTO lbl-1000
                                            var15_44 = var3_3;
                                            if (var13_39.z() == var15_44.a.z()) {
                                                v3 = true;
                                            } else lbl-1000:
                                            // 2 sources

                                            {
                                                v3 = false;
                                            }
                                            if (!v3) continue;
                                            v4 = true;
                                            ** GOTO lbl52
                                        }
lbl51:
                                        // 2 sources

                                        v4 = false;
lbl52:
                                        // 2 sources

                                        if (!v4) ** GOTO lbl110
                                        var15_44 = var3_3;
                                        if (var6_10.contains(var15_44.a)) ** GOTO lbl110
                                        var10_23 = (Iterable)var6_10;
                                        var12_29 = var10_23.iterator();
                                        while (var12_29.hasNext()) {
                                            var13_39 = var12_29.next();
                                            var14_43 = (Vector3ic)var13_39;
                                            var15_44 = var3_3;
                                            if (var14_43.y() != var15_44.a.y()) ** GOTO lbl-1000
                                            var15_44 = var3_3;
                                            if (var14_43.z() == var15_44.a.z()) {
                                                v5 = true;
                                            } else lbl-1000:
                                            // 2 sources

                                            {
                                                v5 = false;
                                            }
                                            if (!v5) continue;
                                            ** GOTO lbl70
                                        }
                                        throw new NoSuchElementException("Collection contains no element matching the predicate.");
lbl70:
                                        // 1 sources

                                        var9_15 = var13_39;
                                        if (var4_4 != 0) ** GOTO lbl74
                                        var15_44 = var3_3;
                                        if (var9_15.x() < var15_44.a.x()) ** GOTO lbl77
lbl74:
                                        // 2 sources

                                        if (var4_4 != 1) break;
                                        var15_44 = var3_3;
                                        if (var9_15.x() <= var15_44.a.x()) break;
lbl77:
                                        // 2 sources

                                        if ((v6 = this.f.get(var9_15)) == null || (v6 = v6.getSolidState()) == null || (v6 = v6.getShape()) == null) ** GOTO lbl-1000
                                        var17_49 = v6;
                                        v7 = v6 instanceof BoxesBlockShape != false ? (BoxesBlockShape)var17_49 : null;
                                        v6 = v7 != null ? Double.valueOf(eh_0.a(v7, var4_4)) : null;
                                        if (v6 != null) {
                                            v8 = v6.doubleValue();
                                        } else lbl-1000:
                                        // 2 sources

                                        {
                                            v8 = 0.0;
                                        }
                                        var10_24 = v8;
                                        v9 = this.g.get(org.valkyrienskies.core.impl.shadow.Eh$a.a().get(var4_4));
                                        Intrinsics.checkNotNull(v9);
                                        v9.remove(var9_15);
                                        v10 = this.g.get(org.valkyrienskies.core.impl.shadow.Eh$a.a().get(var4_4));
                                        Intrinsics.checkNotNull(v10);
                                        var15_44 = var3_3;
                                        v10.add(var15_44.a);
                                        v11 = this.h.computeIfAbsent(org.valkyrienskies.core.impl.shadow.Eh$a.a().get(var4_4), (Function<Object, Double>)LambdaMetafactory.metafactory(null, null, null, (Ljava/lang/Object;)Ljava/lang/Object;, b(kotlin.jvm.functions.Function1 java.lang.Object ), (Ljava/lang/Object;)Ljava/lang/Double;)((Function1)4.a));
                                        Intrinsics.checkNotNullExpressionValue((Object)v11, (String)"");
                                        var12_30 = ((Number)v11).doubleValue();
                                        var14_43 = this.h;
                                        var6_10 = org.valkyrienskies.core.impl.shadow.Eh$a.a().get(var4_4);
                                        var15_44 = var3_3;
                                        v12 = var15_44.b.getSolidState();
                                        Intrinsics.checkNotNull((Object)v12);
                                        v13 = v12.getShape();
                                        Intrinsics.checkNotNull((Object)v13);
                                        var16_46 = var12_30 - var10_24 + eh_0.a((BoxesBlockShape)v13, var4_4);
                                        var16_45 = Math.max(var16_46, 0.0);
                                        var14_43.put(var6_10, var16_45);
                                        break;
lbl110:
                                        // 2 sources

                                        v14 = this.g.get(org.valkyrienskies.core.impl.shadow.Eh$a.a().get(var4_4));
                                        Intrinsics.checkNotNull(v14);
                                        var15_44 = var3_3;
                                        v14.add(var15_44.a);
                                        v15 = this.h.computeIfAbsent(org.valkyrienskies.core.impl.shadow.Eh$a.a().get(var4_4), (Function<Object, Double>)LambdaMetafactory.metafactory(null, null, null, (Ljava/lang/Object;)Ljava/lang/Object;, c(kotlin.jvm.functions.Function1 java.lang.Object ), (Ljava/lang/Object;)Ljava/lang/Double;)((Function1)5.a));
                                        Intrinsics.checkNotNullExpressionValue((Object)v15, (String)"");
                                        var9_16 = ((Number)v15).doubleValue();
                                        if (var7_12) {
                                            var15_44 = var3_3;
                                            v16 = this.f.get(var15_44.a);
                                            v17 = v16 != null ? v16.getSolidState() : null;
                                            Intrinsics.checkNotNull((Object)v17);
                                            v18 = v17.getShape();
                                            Intrinsics.checkNotNull((Object)v18);
                                            var9_16 -= eh_0.a((BoxesBlockShape)v18, var4_4);
                                        }
                                        var11_28 = this.h;
                                        var12_29 = org.valkyrienskies.core.impl.shadow.Eh$a.a().get(var4_4);
                                        var15_44 = var3_3;
                                        v19 = var15_44.b.getSolidState();
                                        Intrinsics.checkNotNull((Object)v19);
                                        v20 = v19.getShape();
                                        Intrinsics.checkNotNull((Object)v20);
                                        var13_40 = var9_16 + eh_0.a((BoxesBlockShape)v20, var4_4);
                                        var13_39 = Math.max(var13_40, 0.0);
                                        var11_28.put(var12_29, var13_39);
                                        break;
                                    }
                                    case 2: 
                                    case 3: {
                                        var9_17 = (Iterable)var6_10;
                                        if (var9_17 instanceof Collection && ((Collection)var9_17).isEmpty()) ** GOTO lbl156
                                        var11_28 = var9_17.iterator();
                                        while (var11_28.hasNext()) {
                                            var12_31 = var11_28.next();
                                            var13_39 = (Vector3ic)var12_31;
                                            var15_44 = var3_3;
                                            if (var13_39.x() != var15_44.a.x()) ** GOTO lbl-1000
                                            var15_44 = var3_3;
                                            if (var13_39.z() == var15_44.a.z()) {
                                                v21 = true;
                                            } else lbl-1000:
                                            // 2 sources

                                            {
                                                v21 = false;
                                            }
                                            if (!v21) continue;
                                            v22 = true;
                                            ** GOTO lbl157
                                        }
lbl156:
                                        // 2 sources

                                        v22 = false;
lbl157:
                                        // 2 sources

                                        if (!v22) ** GOTO lbl215
                                        var15_44 = var3_3;
                                        if (var6_10.contains(var15_44.a)) ** GOTO lbl215
                                        var10_23 = (Iterable)var6_10;
                                        var12_32 = var10_23.iterator();
                                        while (var12_32.hasNext()) {
                                            var13_39 = var12_32.next();
                                            var14_43 = (Vector3ic)var13_39;
                                            var15_44 = var3_3;
                                            if (var14_43.x() != var15_44.a.x()) ** GOTO lbl-1000
                                            var15_44 = var3_3;
                                            if (var14_43.z() == var15_44.a.z()) {
                                                v23 = true;
                                            } else lbl-1000:
                                            // 2 sources

                                            {
                                                v23 = false;
                                            }
                                            if (!v23) continue;
                                            ** GOTO lbl175
                                        }
                                        throw new NoSuchElementException("Collection contains no element matching the predicate.");
lbl175:
                                        // 1 sources

                                        var9_17 = var13_39;
                                        if (var4_4 != 2) ** GOTO lbl179
                                        var15_44 = var3_3;
                                        if (var9_17.y() < var15_44.a.y()) ** GOTO lbl182
lbl179:
                                        // 2 sources

                                        if (var4_4 != 3) break;
                                        var15_44 = var3_3;
                                        if (var9_17.y() <= var15_44.a.y()) break;
lbl182:
                                        // 2 sources

                                        if ((v24 = this.f.get(var9_17)) == null || (v24 = v24.getSolidState()) == null || (v24 = v24.getShape()) == null) ** GOTO lbl-1000
                                        var17_49 = v24;
                                        v25 = v24 instanceof BoxesBlockShape != false ? (BoxesBlockShape)var17_49 : null;
                                        v24 = v25 != null ? Double.valueOf(eh_0.a(v25, var4_4)) : null;
                                        if (v24 != null) {
                                            v26 = v24.doubleValue();
                                        } else lbl-1000:
                                        // 2 sources

                                        {
                                            v26 = 0.0;
                                        }
                                        var10_25 = v26;
                                        v27 = this.g.get(org.valkyrienskies.core.impl.shadow.Eh$a.a().get(var4_4));
                                        Intrinsics.checkNotNull(v27);
                                        v27.remove(var9_17);
                                        v28 = this.g.get(org.valkyrienskies.core.impl.shadow.Eh$a.a().get(var4_4));
                                        Intrinsics.checkNotNull(v28);
                                        var15_44 = var3_3;
                                        v28.add(var15_44.a);
                                        v29 = this.h.computeIfAbsent(org.valkyrienskies.core.impl.shadow.Eh$a.a().get(var4_4), (Function<Object, Double>)LambdaMetafactory.metafactory(null, null, null, (Ljava/lang/Object;)Ljava/lang/Object;, d(kotlin.jvm.functions.Function1 java.lang.Object ), (Ljava/lang/Object;)Ljava/lang/Double;)((Function1)6.a));
                                        Intrinsics.checkNotNullExpressionValue((Object)v29, (String)"");
                                        var12_33 = ((Number)v29).doubleValue();
                                        var14_43 = this.h;
                                        var6_10 = org.valkyrienskies.core.impl.shadow.Eh$a.a().get(var4_4);
                                        var15_44 = var3_3;
                                        v30 = var15_44.b.getSolidState();
                                        Intrinsics.checkNotNull((Object)v30);
                                        v31 = v30.getShape();
                                        Intrinsics.checkNotNull((Object)v31);
                                        var16_47 = var12_33 - var10_25 + eh_0.a((BoxesBlockShape)v31, var4_4);
                                        var16_45 = Math.max(var16_47, 0.0);
                                        var14_43.put(var6_10, var16_45);
                                        break;
lbl215:
                                        // 2 sources

                                        v32 = this.g.get(org.valkyrienskies.core.impl.shadow.Eh$a.a().get(var4_4));
                                        Intrinsics.checkNotNull(v32);
                                        var15_44 = var3_3;
                                        v32.add(var15_44.a);
                                        v33 = this.h.computeIfAbsent(org.valkyrienskies.core.impl.shadow.Eh$a.a().get(var4_4), (Function<Object, Double>)LambdaMetafactory.metafactory(null, null, null, (Ljava/lang/Object;)Ljava/lang/Object;, e(kotlin.jvm.functions.Function1 java.lang.Object ), (Ljava/lang/Object;)Ljava/lang/Double;)((Function1)7.a));
                                        Intrinsics.checkNotNullExpressionValue((Object)v33, (String)"");
                                        var9_18 = ((Number)v33).doubleValue();
                                        if (var7_12) {
                                            var15_44 = var3_3;
                                            v34 = this.f.get(var15_44.a);
                                            v35 = v34 != null ? v34.getSolidState() : null;
                                            Intrinsics.checkNotNull((Object)v35);
                                            v36 = v35.getShape();
                                            Intrinsics.checkNotNull((Object)v36);
                                            var9_18 -= eh_0.a((BoxesBlockShape)v36, var4_4);
                                        }
                                        var11_28 = this.h;
                                        var12_34 = org.valkyrienskies.core.impl.shadow.Eh$a.a().get(var4_4);
                                        var15_44 = var3_3;
                                        v37 = var15_44.b.getSolidState();
                                        Intrinsics.checkNotNull((Object)v37);
                                        v38 = v37.getShape();
                                        Intrinsics.checkNotNull((Object)v38);
                                        var13_41 = var9_18 + eh_0.a((BoxesBlockShape)v38, var4_4);
                                        var13_39 = Math.max(var13_41, 0.0);
                                        var11_28.put(var12_34, var13_39);
                                        break;
                                    }
                                    default: {
                                        var9_19 = (Iterable)var6_10;
                                        if (var9_19 instanceof Collection && ((Collection)var9_19).isEmpty()) ** GOTO lbl261
                                        var11_28 = var9_19.iterator();
                                        while (var11_28.hasNext()) {
                                            var12_35 = var11_28.next();
                                            var13_39 = (Vector3ic)var12_35;
                                            var15_44 = var3_3;
                                            if (var13_39.x() != var15_44.a.x()) ** GOTO lbl-1000
                                            var15_44 = var3_3;
                                            if (var13_39.y() == var15_44.a.y()) {
                                                v39 = true;
                                            } else lbl-1000:
                                            // 2 sources

                                            {
                                                v39 = false;
                                            }
                                            if (!v39) continue;
                                            v40 = true;
                                            ** GOTO lbl262
                                        }
lbl261:
                                        // 2 sources

                                        v40 = false;
lbl262:
                                        // 2 sources

                                        if (!v40) ** GOTO lbl320
                                        var15_44 = var3_3;
                                        if (var6_10.contains(var15_44.a)) ** GOTO lbl320
                                        var10_23 = (Iterable)var6_10;
                                        var12_36 = var10_23.iterator();
                                        while (var12_36.hasNext()) {
                                            var13_39 = var12_36.next();
                                            var14_43 = (Vector3ic)var13_39;
                                            var15_44 = var3_3;
                                            if (var14_43.x() != var15_44.a.x()) ** GOTO lbl-1000
                                            var15_44 = var3_3;
                                            if (var14_43.y() == var15_44.a.y()) {
                                                v41 = true;
                                            } else lbl-1000:
                                            // 2 sources

                                            {
                                                v41 = false;
                                            }
                                            if (!v41) continue;
                                            ** GOTO lbl280
                                        }
                                        throw new NoSuchElementException("Collection contains no element matching the predicate.");
lbl280:
                                        // 1 sources

                                        var9_19 = var13_39;
                                        if (var4_4 != 4) ** GOTO lbl284
                                        var15_44 = var3_3;
                                        if (var9_19.z() < var15_44.a.z()) ** GOTO lbl287
lbl284:
                                        // 2 sources

                                        if (var4_4 != 5) break;
                                        var15_44 = var3_3;
                                        if (var9_19.z() <= var15_44.a.z()) break;
lbl287:
                                        // 2 sources

                                        if ((v42 = this.f.get(var9_19)) == null || (v42 = v42.getSolidState()) == null || (v42 = v42.getShape()) == null) ** GOTO lbl-1000
                                        var17_49 = v42;
                                        v43 = v42 instanceof BoxesBlockShape != false ? (BoxesBlockShape)var17_49 : null;
                                        v42 = v43 != null ? Double.valueOf(eh_0.a(v43, var4_4)) : null;
                                        if (v42 != null) {
                                            v44 = v42.doubleValue();
                                        } else lbl-1000:
                                        // 2 sources

                                        {
                                            v44 = 0.0;
                                        }
                                        var10_26 = v44;
                                        v45 = this.g.get(org.valkyrienskies.core.impl.shadow.Eh$a.a().get(var4_4));
                                        Intrinsics.checkNotNull(v45);
                                        v45.remove(var9_19);
                                        v46 = this.g.get(org.valkyrienskies.core.impl.shadow.Eh$a.a().get(var4_4));
                                        Intrinsics.checkNotNull(v46);
                                        var15_44 = var3_3;
                                        v46.add(var15_44.a);
                                        v47 = this.h.computeIfAbsent(org.valkyrienskies.core.impl.shadow.Eh$a.a().get(var4_4), (Function<Object, Double>)LambdaMetafactory.metafactory(null, null, null, (Ljava/lang/Object;)Ljava/lang/Object;, f(kotlin.jvm.functions.Function1 java.lang.Object ), (Ljava/lang/Object;)Ljava/lang/Double;)((Function1)8.a));
                                        Intrinsics.checkNotNullExpressionValue((Object)v47, (String)"");
                                        var12_37 = ((Number)v47).doubleValue();
                                        var14_43 = this.h;
                                        var6_10 = org.valkyrienskies.core.impl.shadow.Eh$a.a().get(var4_4);
                                        var15_44 = var3_3;
                                        v48 = var15_44.b.getSolidState();
                                        Intrinsics.checkNotNull((Object)v48);
                                        v49 = v48.getShape();
                                        Intrinsics.checkNotNull((Object)v49);
                                        var16_48 = var12_37 - var10_26 + eh_0.a((BoxesBlockShape)v49, var4_4);
                                        var16_45 = Math.max(var16_48, 0.0);
                                        var14_43.put(var6_10, var16_45);
                                        break;
lbl320:
                                        // 2 sources

                                        v50 = this.g.get(org.valkyrienskies.core.impl.shadow.Eh$a.a().get(var4_4));
                                        Intrinsics.checkNotNull(v50);
                                        var15_44 = var3_3;
                                        v50.add(var15_44.a);
                                        v51 = this.h.computeIfAbsent(org.valkyrienskies.core.impl.shadow.Eh$a.a().get(var4_4), (Function<Object, Double>)LambdaMetafactory.metafactory(null, null, null, (Ljava/lang/Object;)Ljava/lang/Object;, g(kotlin.jvm.functions.Function1 java.lang.Object ), (Ljava/lang/Object;)Ljava/lang/Double;)((Function1)9.a));
                                        Intrinsics.checkNotNullExpressionValue((Object)v51, (String)"");
                                        var9_20 = ((Number)v51).doubleValue();
                                        if (var7_12) {
                                            var15_44 = var3_3;
                                            v52 = this.f.get(var15_44.a);
                                            v53 = v52 != null ? v52.getSolidState() : null;
                                            Intrinsics.checkNotNull((Object)v53);
                                            v54 = v53.getShape();
                                            Intrinsics.checkNotNull((Object)v54);
                                            var9_20 -= eh_0.a((BoxesBlockShape)v54, var4_4);
                                        }
                                        var11_28 = this.h;
                                        var12_38 = org.valkyrienskies.core.impl.shadow.Eh$a.a().get(var4_4);
                                        var15_44 = var3_3;
                                        v55 = var15_44.b.getSolidState();
                                        Intrinsics.checkNotNull((Object)v55);
                                        v56 = v55.getShape();
                                        Intrinsics.checkNotNull((Object)v56);
                                        var13_42 = var9_20 + eh_0.a((BoxesBlockShape)v56, var4_4);
                                        var13_39 = Math.max(var13_42, 0.0);
                                        var11_28.put(var12_38, var13_39);
                                    }
                                }
                                v57 = var3_3;
                                var15_44 = v57;
                                var15_44 = var3_3;
                                ((Map)this.f).put(v57.a, var15_44.b);
                            }
                            continue;
                        }
                        var15_44 = var3_3;
                        if (!((Map)this.f).containsKey(var15_44.a)) {
                            v58 = this.g.values();
                            Intrinsics.checkNotNullExpressionValue(v58, (String)"");
                            var4_5 = v58;
                            if (!((Collection)var4_5).isEmpty()) {
                                var6_10 = var4_5.iterator();
                                while (var6_10.hasNext()) {
                                    var7_11 = var6_10.next();
                                    var8_14 = (HashSet)var7_11;
                                    var15_44 = var3_3;
                                    if (!var8_14.contains(var15_44.a)) continue;
                                    v59 = true;
                                    break;
                                }
                            } else {
                                v59 = false;
                            }
                            if (!v59) continue;
                        }
                        var5_8 = ((Collection)org.valkyrienskies.core.impl.shadow.Eh$a.a()).size();
                        block21: for (var4_6 = 0; var4_6 < var5_8; ++var4_6) {
                            var15_44 = var3_3;
                            if (!this.g.computeIfAbsent(org.valkyrienskies.core.impl.shadow.Eh$a.a().get(var4_6), (Function<Object, HashSet>)LambdaMetafactory.metafactory(null, null, null, (Ljava/lang/Object;)Ljava/lang/Object;, h(kotlin.jvm.functions.Function1 java.lang.Object ), (Ljava/lang/Object;)Ljava/util/HashSet;)((Function1)1.a)).contains(var15_44.a)) continue;
                            var15_44 = var3_3;
                            v60 = this.f.get(var15_44.a);
                            var6_10 = v60 != null && (v60 = v60.getSolidState()) != null ? v60.getShape() : null;
                            var7_13 = 0.0;
                            if (var6_10 instanceof BoxesBlockShape) {
                                var7_13 = eh_0.a((BoxesBlockShape)var6_10, var4_6);
                            }
                            v61 = this.g.get(org.valkyrienskies.core.impl.shadow.Eh$a.a().get(var4_6));
                            Intrinsics.checkNotNull(v61);
                            var15_44 = var3_3;
                            v61.remove(var15_44.a);
                            this.h.computeIfAbsent(org.valkyrienskies.core.impl.shadow.Eh$a.a().get(var4_6), (Function<Object, Double>)LambdaMetafactory.metafactory(null, null, null, (Ljava/lang/Object;)Ljava/lang/Object;, i(kotlin.jvm.functions.Function1 java.lang.Object ), (Ljava/lang/Object;)Ljava/lang/Double;)((Function1)2.a));
                            v62 = this.h;
                            v63 = org.valkyrienskies.core.impl.shadow.Eh$a.a().get(var4_6);
                            v64 = this.h.get(org.valkyrienskies.core.impl.shadow.Eh$a.a().get(var4_6));
                            Intrinsics.checkNotNull((Object)v64);
                            v62.put(v63, Math.max(((Number)v64).doubleValue() - var7_13, 0.0));
                            var15_44 = var3_3;
                            v65 = var15_44.a;
                            Intrinsics.checkNotNull((Object)this.t);
                            var10_27 = var4_6;
                            var8_14 = v65;
                            var7_11 = this;
                            var22_50 = org.valkyrienskies.core.impl.shadow.Eh$a.a().get(var10_27);
                            var23_53 = var22_50.mul(-1.0, new Vector3d());
                            var24_56 = new Vector3i((int)var23_53.x, (int)var23_53.y, (int)var23_53.z);
                            var25_57 = VectorConversionsKt.expand(var9_21, 1, new AABBi());
                            switch (var10_27) {
                                case 0: {
                                    v66 = new Vector3i(var9_21.maxX(), var8_14.y(), var8_14.z());
                                    break;
                                }
                                case 1: {
                                    v66 = new Vector3i(var9_21.minX(), var8_14.y(), var8_14.z());
                                    break;
                                }
                                case 2: {
                                    v66 = new Vector3i(var8_14.x(), var9_21.maxY(), var8_14.z());
                                    break;
                                }
                                case 3: {
                                    v66 = new Vector3i(var8_14.x(), var9_21.minY(), var8_14.z());
                                    break;
                                }
                                case 4: {
                                    v66 = new Vector3i(var8_14.x(), var8_14.y(), var9_21.maxZ());
                                    break;
                                }
                                case 5: {
                                    v66 = new Vector3i(var8_14.x(), var8_14.y(), var9_21.minZ());
                                    break;
                                }
                                default: {
                                    throw new IllegalArgumentException("Invalid direction index: " + var10_27);
                                }
                            }
                            var26_62 = v66;
                            var27_63 = new Vector3i((Vector3ic)var26_62);
                            while (var25_57.containsPoint(var27_63)) {
                                if (Intrinsics.areEqual((Object)var27_63, (Object)var8_14)) {
                                    var27_63.add((Vector3ic)var24_56);
                                    continue;
                                }
                                if (!((Map)var7_11.f).containsKey(var27_63)) {
                                    var27_63.add((Vector3ic)var24_56);
                                    continue;
                                }
                                var28_68 = var7_11.f.get(var27_63);
                                if (var28_68 == null) {
                                    var27_63.add((Vector3ic)var24_56);
                                    continue;
                                }
                                if (!eh_0.a((VsiBlockState)var28_68)) {
                                    var27_63.add((Vector3ic)var24_56);
                                    continue;
                                }
                                v67 = var28_68.getSolidState();
                                var31_74 = v67 != null ? v67.getShape() : null;
                                v68 = var31_74 instanceof BoxesBlockShape != false ? (BoxesBlockShape)var31_74 : null;
                                var29_69 = v68 != null ? eh_0.a(v68, var10_27) : 0.0;
                                if (!(var29_69 == 0.0)) {
                                    var7_11.h.computeIfAbsent(var22_50, (Function<Object, Double>)LambdaMetafactory.metafactory(null, null, null, (Ljava/lang/Object;)Ljava/lang/Object;, j(kotlin.jvm.functions.Function1 java.lang.Object ), (Ljava/lang/Object;)Ljava/lang/Double;)((Function1)10.a));
                                    v69 = var7_11.h;
                                    v70 = var7_11.h.get(var22_50);
                                    Intrinsics.checkNotNull((Object)v70);
                                    v69.put(var22_50, ((Number)v70).doubleValue() + var29_69);
                                    var7_11.g.computeIfAbsent(var22_50, (Function<Object, HashSet>)LambdaMetafactory.metafactory(null, null, null, (Ljava/lang/Object;)Ljava/lang/Object;, k(kotlin.jvm.functions.Function1 java.lang.Object ), (Ljava/lang/Object;)Ljava/util/HashSet;)((Function1)11.a));
                                    v71 = var7_11.g.get(var22_50);
                                    Intrinsics.checkNotNull(v71);
                                    v71.add(var27_63);
                                    continue block21;
                                }
                                var27_63.add((Vector3ic)var24_56);
                            }
                        }
                        var15_44 = var3_3;
                        this.f.remove(var15_44.a);
                    }
                    while (((Collection)this.p).isEmpty() == false) {
                        var3_3 = this.p.poll();
                        this.o.add(((Vector3dc)var3_3.getFirst()).mul(((Number)var3_3.getSecond()).doubleValue(), new Vector3d()));
                    }
                    if (!(((Map)this.f).isEmpty() == false) || !(((Map)this.g).isEmpty() == false) || this.g.size() != 6 || this.c) break block84;
                    v72 = this.t;
                    Intrinsics.checkNotNull((Object)v72);
                    var3_3 = VectorConversionsKt.expand(v72, 1, new AABBi());
                    var9_22 = physLevel.getAerodynamicUtils();
                    var8_14 = physShip;
                    var7_11 = this;
                    Intrinsics.checkNotNullParameter((Object)var8_14, (String)"");
                    Intrinsics.checkNotNullParameter((Object)var9_22, (String)"");
                    v73 = var7_11.getWindVector().sub(var8_14.getVelocity(), new Vector3d());
                    Intrinsics.checkNotNullExpressionValue((Object)v73, (String)"");
                    var10_23 = v73;
                    if (var10_23.lengthSquared() < 1.0E-12 || !var7_11.q || var8_14.isStatic()) {
                        v74 = new Vector3d(0.0, 0.0, 0.0);
                    } else {
                        var22_50 = var10_23.rotate(var8_14.getTransform().getShipToWorldRotation().invert(new Quaterniond()), new Vector3d());
                        v75 = var10_23.normalize(new Vector3d());
                        Intrinsics.checkNotNullExpressionValue((Object)v75, (String)"");
                        var23_53 = v75;
                        v76 = var22_50.normalize(new Vector3d());
                        Intrinsics.checkNotNullExpressionValue((Object)v76, (String)"");
                        var24_56 = v76;
                        var25_58 = var9_22.getAirDensityForY(var8_14.getTransform().getPositionInWorld().y(), var7_11.d);
                        var27_64 = 0.0;
                        for (Vector3dc var30_78 : org.valkyrienskies.core.impl.shadow.Eh$a.a()) {
                            v77 = var7_11.h.get(var30_78);
                            if (v77 == null) continue;
                            var31_75 = ((Number)v77).doubleValue();
                            var33_83 = var24_56.dot(var30_78);
                            if (!(v78 > 0.0)) continue;
                            var27_64 += var31_75 * eh_0.a((PhysShip)var8_14, var30_78) * var33_83;
                        }
                        var29_69 = VSCoreConfig.SERVER.getDs().getDragCoefficient() * var25_58 * (var10_23.lengthSquared() / 2.0) * var27_64;
                        v79 = var23_53.mul(var29_69, new Vector3d());
                        Intrinsics.checkNotNullExpressionValue((Object)v79, (String)"");
                        v74 = v79;
                    }
                    var4_7 = v74;
                    var8_14 = physShip;
                    var7_11 = this;
                    Intrinsics.checkNotNullParameter((Object)var8_14, (String)"");
                    v80 = var7_11.getWindVector().sub(var8_14.getVelocity(), new Vector3d()).rotate(var8_14.getTransform().getShipToWorldRotation().invert(new Quaterniond()), new Vector3d());
                    Intrinsics.checkNotNullExpressionValue((Object)v80, (String)"");
                    var9_22 = v80;
                    if (var9_22.lengthSquared() < 1.0E-12 || !var7_11.q || var8_14.isStatic()) {
                        v81 = new Vector3d(0.0, 0.0, 0.0);
                    } else {
                        v82 = var9_22.normalize(new Vector3d());
                        Intrinsics.checkNotNullExpressionValue((Object)v82, (String)"");
                        var10_23 = v82;
                        var22_50 = new Vector3d();
                        var23_54 = 0.0;
                        var25_59 = var7_11.g.entrySet().iterator();
                        while (var25_59.hasNext()) {
                            var26_62 = var25_59.next();
                            Intrinsics.checkNotNullExpressionValue(var26_62, (String)"");
                            var27_65 = var26_62.getKey();
                            var28_68 = var26_62.getValue();
                            if (var28_68.isEmpty()) continue;
                            var29_71 = new Vector3d();
                            Intrinsics.checkNotNullExpressionValue(var28_68, (String)"");
                            var30_79 = var28_68;
                            for (T var33_84 : var30_79) {
                                var34_88 = (Vector3ic)var33_84;
                                var29_71.add(var34_88.x(), var34_88.y(), var34_88.z()).add(0.5, 0.5, 0.5).add(var27_65.normalize(new Vector3d()).mul(0.5, new Vector3d()));
                            }
                            var29_71.div(var28_68.size());
                            var30_80 = var10_23.dot(var27_65);
                            if (!(v83 > 0.0)) continue;
                            var29_71.mul(var30_80);
                            var22_50.add(var29_71);
                            var23_54 += var30_80;
                        }
                        if (!(var23_54 == 0.0)) {
                            v84 = var22_50.div(var23_54);
                            Intrinsics.checkNotNullExpressionValue((Object)v84, (String)"");
                            v85 = v84;
                        } else {
                            v85 = new Vector3d();
                        }
                        v81 = var25_59 = v85;
                    }
                    var5_9 = v81;
                    var9_22 = physLevel.getAerodynamicUtils();
                    var8_14 = physShip;
                    var7_11 = this;
                    Intrinsics.checkNotNullParameter((Object)var8_14, (String)"");
                    Intrinsics.checkNotNullParameter((Object)var9_22, (String)"");
                    if (var7_11.s && !var8_14.isStatic() && !(var8_14.getAngularVelocity().lengthSquared() < 1.0E-12)) break block85;
                    v86 = new Vector3d();
                    break block86;
                }
                var10_23 = var8_14.getAngularVelocity().rotate(var8_14.getTransform().getShipToWorldRotation().invert(new Quaterniond()), new Vector3d());
                var22_51 = var9_22.getAirDensityForY(var8_14.getTransform().getPositionInWorld().y(), var7_11.d);
                var24_56 = new Vector3d();
                for (Object var26_62 : var7_11.g.entrySet()) {
                    Intrinsics.checkNotNullExpressionValue(var26_62, (String)"");
                    var27_66 = var26_62.getKey();
                    var28_68 = var26_62.getValue();
                    if (var28_68.isEmpty()) continue;
                    var29_72 = new Vector3d(var27_66).normalize();
                    for (Vector3ic var31_76 : var28_68) {
                        var32_86 = new Vector3d(var31_76).add(0.5, 0.5, 0.5).add(new Vector3d(var27_66).mul(0.5));
                        var33_85 = var32_86.sub(var8_14.getTransform().getPositionInShip(), new Vector3d());
                        var34_88 = var10_23.cross(var33_85, new Vector3d());
                        if (var34_88.lengthSquared() < 1.0E-12 || (var9_22 = new Vector3d(var29_72).mul(var35_89 = var34_88.dot(var29_72))).lengthSquared() < 1.0E-12) continue;
                        v87 = var7_11.f.get(var31_76);
                        if (v87 == null || (v87 = v87.getSolidState()) == null || (v87 = v87.getShape()) == null) ** GOTO lbl-1000
                        var44_97 = v87;
                        v88 = v87 instanceof BoxesBlockShape != false ? (BoxesBlockShape)var44_97 : null;
                        v87 = v88 != null ? Double.valueOf(eh_0.a(v88, org.valkyrienskies.core.impl.shadow.Eh$a.a().indexOf(var27_66))) : null;
                        if (v87 != null) {
                            v89 = v87.doubleValue();
                        } else lbl-1000:
                        // 2 sources

                        {
                            v89 = 1.0;
                        }
                        Intrinsics.checkNotNullExpressionValue((Object)var27_66, (String)"");
                        var38_91 = v89 * eh_0.a((PhysShip)var8_14, var27_66);
                        var40_93 = VSCoreConfig.SERVER.getDs().getDragCoefficient() * var22_51 * 0.5 * var9_22.lengthSquared() * var38_91;
                        var42_94 = var9_22.normalize(new Vector3d()).negate().mul(var40_93);
                        var43_96 = var33_85.cross(var42_94, new Vector3d());
                        var24_56.add(var43_96);
                    }
                }
                v90 = var24_56.rotate(var8_14.getTransform().getShipToWorldRotation(), new Vector3d());
                v86 = v90;
                Intrinsics.checkNotNullExpressionValue((Object)v90, (String)"");
            }
            var6_10 = v86;
            var9_22 = var2_2.getAerodynamicUtils();
            var8_14 = physShip;
            var7_11 = this;
            Intrinsics.checkNotNullParameter((Object)var8_14, (String)"");
            Intrinsics.checkNotNullParameter((Object)var9_22, (String)"");
            var10_23 = var7_11.getWindVector().sub(var8_14.getVelocity(), new Vector3d()).rotate(var8_14.getTransform().getShipToWorldRotation().invert(new Quaterniond()), new Vector3d());
            var22_52 = var8_14.getAngularVelocity().rotate(var8_14.getTransform().getShipToWorldRotation().invert(new Quaterniond()), new Vector3d());
            var23_55 = var9_22.getAirDensityForY(var8_14.getTransform().getPositionInWorld().y(), var7_11.d);
            var25_61 = var8_14.getTransform().getPositionInShip();
            var26_62 = new Vector3d();
            var27_67 = new Vector3d();
            for (Map.Entry<Vector3dc, HashSet<Vector3ic>> var29_73 : var7_11.g.entrySet()) {
                Intrinsics.checkNotNullExpressionValue(var29_73, (String)"");
                var30_82 = var29_73.getKey();
                var31_77 = var29_73.getValue();
                if (var31_77.isEmpty()) continue;
                v91 = var7_11.h.get(var30_82);
                if (v91 == null) continue;
                v92 = v91;
                Intrinsics.checkNotNullExpressionValue((Object)var30_82, (String)"");
                var32_87 = v92 * eh_0.a((PhysShip)var8_14, var30_82);
                if (var32_87 <= 0.0) continue;
                var34_88 = new Vector3d();
                for (Object var36_99 : var31_77) {
                    var34_88.add((double)var36_99.x() + 0.5, (double)var36_99.y() + 0.5, (double)var36_99.z() + 0.5);
                    var34_88.add(var30_82.normalize(new Vector3d()).mul(0.5));
                }
                var34_88.div(var31_77.size());
                var35_90 = var34_88.sub(var25_61, new Vector3d());
                var36_99 = var22_52.cross(var35_90, new Vector3d());
                var9_22 = var10_23.add((Vector3dc)var36_99);
                if (var9_22.lengthSquared() < 1.0E-12 || (var40_93 = RangesKt.coerceIn((double)(var38_92 = var9_22.normalize(new Vector3d())).dot(var39_100 = var30_82.normalize(new Vector3d())), (double)-1.0, (double)1.0)) >= 0.0 || (var42_95 = Math.acos(-var40_93)) < 0.001 || var42_95 > Math.toRadians(85.0)) continue;
                var51_102 = var42_95;
                var53_103 = Math.toRadians(20.0);
                var44_98 = var51_102 < var53_103 ? Math.sin(var51_102 * 2.0) : Math.sin(var51_102 * 2.0) * Math.cos((var51_102 - var53_103) * 3.0);
                var46_101 = var23_55 * 0.5 * var9_22.lengthSquared() * var44_98 * var32_87;
                var2_2 = var39_100.cross(var38_92, new Vector3d()).cross(var38_92).normalize();
                if (var2_2.lengthSquared() < 1.0E-12) continue;
                var2_2 = var2_2.mul(var46_101);
                var26_62.add(var2_2.rotate(var8_14.getTransform().getShipToWorldRotation(), new Vector3d()));
                var2_2 = var35_90.cross(var2_2, new Vector3d());
                var27_67.add(var2_2.rotate(var8_14.getTransform().getShipToWorldRotation(), new Vector3d()));
            }
            var7_11 = new Pair(var26_62, (Object)var27_67);
            if (var4_7.isFinite() && var5_9.isFinite() && var3_3.containsPoint((float)var5_9.x(), (float)var5_9.y(), (float)var5_9.z())) {
                this.i = var4_7;
                v93 = var4_7.mul(VSCoreConfig.SERVER.getDs().getDragMultiplier(), new Vector3d());
                Intrinsics.checkNotNullExpressionValue((Object)v93, (String)"");
                physShip.applyWorldForceToModelPos(v93, var5_9);
            } else {
                this.i = new Vector3d(0.0, 0.0, 0.0);
            }
            if (var6_10.isFinite() && !(var6_10.length() == NaN)) {
                v94 = var6_10.mul(VSCoreConfig.SERVER.getDs().getDragMultiplier(), new Vector3d());
                Intrinsics.checkNotNullExpressionValue((Object)v94, (String)"");
                physShip.applyWorldTorque(v94);
            }
            if (((Vector3dc)var7_11.getFirst()).isFinite() && ((Vector3dc)var7_11.getSecond()).isFinite()) {
                v95 = ((Vector3dc)var7_11.getFirst()).mul(VSCoreConfig.SERVER.getDs().getLiftMultiplier(), new Vector3d());
                Intrinsics.checkNotNullExpressionValue((Object)v95, (String)"");
                PhysShip.applyWorldForce$default(physShip, v95, null, 2, null);
                v96 = ((Vector3dc)var7_11.getSecond()).mul(VSCoreConfig.SERVER.getDs().getLiftMultiplier(), new Vector3d());
                Intrinsics.checkNotNullExpressionValue((Object)v96, (String)"");
                var1_1.applyWorldTorque(v96);
                this.j = (Vector3dc)var7_11.getFirst();
            } else {
                this.j = new Vector3d(0.0, 0.0, 0.0);
            }
        }
        this.o.set(0.0, 0.0, 0.0);
    }

    @Override
    public final Vector3dc getWindVector() {
        Vector3d vector3d = new Vector3d(this.h()).add(this.o);
        Intrinsics.checkNotNullExpressionValue((Object)vector3d, (String)"");
        return vector3d;
    }

    private static double a(BoxesBlockShape iterator2, int n2) {
        double d2 = 1.0;
        iterator2 = iterator2.getNegativeBoxes();
        iterator2 = iterator2.iterator();
        while (iterator2.hasNext()) {
            Object object = iterator2.next();
            object = (AABBic)object;
            if (n2 < 2) {
                if (object.minX() != 0 || object.maxX() != 15) continue;
                int n3 = (object.maxY() - object.minY()) * (object.maxZ() - object.minZ());
                d2 -= (double)n3 / 16.0;
                continue;
            }
            if (n2 < 4) {
                if (object.minY() != 0 || object.maxY() != 15) continue;
                int n4 = (object.maxX() - object.minX()) * (object.maxZ() - object.minZ());
                d2 -= (double)n4 / 16.0;
                continue;
            }
            if (object.minZ() != 0 || object.maxZ() != 15) continue;
            int n5 = (object.maxX() - object.minX()) * (object.maxY() - object.minY());
            d2 -= (double)n5 / 16.0;
        }
        return Math.max(d2, 0.0);
    }

    private static double a(PhysShip object, Vector3dc vector3dc) {
        object = object.getTransform().getShipToWorldScaling();
        Vector3dc vector3dc2 = vector3dc;
        if (Intrinsics.areEqual((Object)vector3dc2, (Object)new Vector3d(1.0, 0.0, 0.0))) {
            return object.x();
        }
        if (Intrinsics.areEqual((Object)vector3dc2, (Object)new Vector3d(-1.0, 0.0, 0.0))) {
            return object.x();
        }
        if (Intrinsics.areEqual((Object)vector3dc2, (Object)new Vector3d(0.0, 1.0, 0.0))) {
            return object.y();
        }
        if (Intrinsics.areEqual((Object)vector3dc2, (Object)new Vector3d(0.0, -1.0, 0.0))) {
            return object.y();
        }
        if (Intrinsics.areEqual((Object)vector3dc2, (Object)new Vector3d(0.0, 0.0, 1.0))) {
            return object.z();
        }
        if (Intrinsics.areEqual((Object)vector3dc2, (Object)new Vector3d(0.0, 0.0, -1.0))) {
            return object.z();
        }
        throw new IllegalArgumentException("Invalid direction vector: " + vector3dc);
    }

    private final void a(Vector3ic vector3ic, AABBic object, int n2) {
        Vector3dc vector3dc = org.valkyrienskies.core.impl.shadow.Eh$a.a().get(n2);
        Object object2 = vector3dc.mul(-1.0, new Vector3d());
        object2 = new Vector3i((int)((Vector3d)object2).x, (int)((Vector3d)object2).y, (int)((Vector3d)object2).z);
        AABBic aABBic = VectorConversionsKt.expand((AABBic)object, 1, new AABBi());
        object = switch (n2) {
            case 0 -> new Vector3i(object.maxX(), vector3ic.y(), vector3ic.z());
            case 1 -> new Vector3i(object.minX(), vector3ic.y(), vector3ic.z());
            case 2 -> new Vector3i(vector3ic.x(), object.maxY(), vector3ic.z());
            case 3 -> new Vector3i(vector3ic.x(), object.minY(), vector3ic.z());
            case 4 -> new Vector3i(vector3ic.x(), vector3ic.y(), object.maxZ());
            case 5 -> new Vector3i(vector3ic.x(), vector3ic.y(), object.minZ());
            default -> throw new IllegalArgumentException("Invalid direction index: " + n2);
        };
        object = new Vector3i((Vector3ic)object);
        while (aABBic.containsPoint((Vector3ic)object)) {
            if (Intrinsics.areEqual((Object)object, (Object)vector3ic)) {
                ((Vector3i)object).add((Vector3ic)object2);
                continue;
            }
            if (!((Map)this.f).containsKey(object)) {
                ((Vector3i)object).add((Vector3ic)object2);
                continue;
            }
            Object object3 = this.f.get(object);
            if (object3 == null) {
                ((Vector3i)object).add((Vector3ic)object2);
                continue;
            }
            if (!eh_0.a((VsiBlockState)object3)) {
                ((Vector3i)object).add((Vector3ic)object2);
                continue;
            }
            SolidState solidState = ((VsiBlockState)object3).getSolidState();
            object3 = solidState != null ? solidState.getShape() : null;
            BoxesBlockShape boxesBlockShape = object3 instanceof BoxesBlockShape ? (BoxesBlockShape)object3 : null;
            double d2 = boxesBlockShape != null ? eh_0.a(boxesBlockShape, n2) : 0.0;
            if (!(d2 == 0.0)) {
                this.h.computeIfAbsent(vector3dc, arg_0 -> eh_0.j(10.a, arg_0));
                Map map2 = this.h;
                Double d3 = this.h.get(vector3dc);
                Intrinsics.checkNotNull((Object)d3);
                map2.put(vector3dc, ((Number)d3).doubleValue() + d2);
                this.g.computeIfAbsent(vector3dc, arg_0 -> eh_0.k(11.a, arg_0));
                HashSet<Vector3ic> hashSet = this.g.get(vector3dc);
                Intrinsics.checkNotNull(hashSet);
                hashSet.add((Vector3ic)object);
                return;
            }
            ((Vector3i)object).add((Vector3ic)object2);
        }
    }

    static boolean a(VsiBlockState vsiBlockState) {
        return vsiBlockState.getSolidState() != null;
    }

    public final void a(il_0 il_02, DN dN) {
        Intrinsics.checkNotNullParameter((Object)il_02, (String)"");
        Intrinsics.checkNotNullParameter((Object)dN, (String)"");
        il_0 il_03 = il_02;
        if (il_03 instanceof ij_0) {
            il_03 = (ij_0)il_02;
            int n2 = 0;
            while (n2 < 16) {
                int n3 = n2++;
                int n4 = 0;
                while (n4 < 16) {
                    int n5 = n4++;
                    int n6 = 0;
                    while (n6 < 16) {
                        Vector3i vector3i;
                        int n7 = n6++;
                        int n8 = n5;
                        int n9 = n3;
                        int n10 = n7;
                        int n11 = n9;
                        int n12 = n8;
                        n8 = ((ij_0)il_03).a(n10, n9, n8);
                        n9 = n12;
                        n7 = n11;
                        Object object = dN;
                        object = ((DN)object).b;
                        Object object2 = ((CP)object).d.get(n8);
                        Intrinsics.checkNotNullExpressionValue((Object)object2, (String)"");
                        if (eh_0.a((VsiBlockState)object2) && n8 != dN.getEmpty().toInt()) {
                            vector3i = new Vector3i((il_02.a() << 4) + n10, (il_02.b() << 4) + n7, (il_02.c() << 4) + n9);
                            Vector3ic vector3ic = vector3i;
                            object = dN;
                            object = ((DN)object).b;
                            Object object3 = ((CP)object).d.get(n8);
                            Intrinsics.checkNotNull((Object)object3);
                            this.a(new ef_0(vector3ic, (VsiBlockState)object3, false));
                            continue;
                        }
                        vector3i = new Vector3i((il_02.a() << 4) + n10, (il_02.b() << 4) + n7, (il_02.c() << 4) + n9);
                        Vector3ic vector3ic = vector3i;
                        object = dN;
                        object = ((DN)object).b;
                        Object object4 = ((CP)object).d.get(n8);
                        Intrinsics.checkNotNull((Object)object4);
                        this.a(new ef_0(vector3ic, (VsiBlockState)object4, true));
                    }
                }
            }
            return;
        }
        if (il_03 instanceof in_0) {
            il_03 = (in_0)il_02;
            int n13 = 0;
            Object object = il_03;
            int n14 = ((in_0)object).e.size();
            while (n13 < n14) {
                Vector3i vector3i;
                int n15 = n13++;
                object = il_03;
                int n16 = ((in_0)object).e.getShort(n15);
                object = il_03;
                int n17 = ((in_0)object).f.getInt(n15);
                int n18 = n16;
                int n19 = n18 >> 8 & 0xF;
                int n20 = n18 >> 4 & 0xF;
                int n21 = n18 & 0xF;
                int n22 = n19;
                n15 = n21;
                n19 = n20;
                n20 = n22;
                n21 = n17;
                n20 = n19;
                n16 = n22;
                object = dN;
                object = ((DN)object).b;
                Object object5 = ((CP)object).d.get(n21);
                Intrinsics.checkNotNullExpressionValue((Object)object5, (String)"");
                if (eh_0.a((VsiBlockState)object5) && n21 != dN.getEmpty().toInt()) {
                    vector3i = new Vector3i((il_02.a() << 4) + n16, (il_02.b() << 4) + n20, (il_02.c() << 4) + n15);
                    Vector3ic vector3ic = vector3i;
                    object = dN;
                    object = ((DN)object).b;
                    Object object6 = ((CP)object).d.get(n21);
                    Intrinsics.checkNotNull((Object)object6);
                    this.a(new ef_0(vector3ic, (VsiBlockState)object6, false));
                    continue;
                }
                vector3i = new Vector3i((il_02.a() << 4) + n16, (il_02.b() << 4) + n20, (il_02.c() << 4) + n15);
                Vector3ic vector3ic = vector3i;
                object = dN;
                object = ((DN)object).b;
                Object object7 = ((CP)object).d.get(n21);
                Intrinsics.checkNotNull((Object)object7);
                this.a(new ef_0(vector3ic, (VsiBlockState)object7, true));
            }
        }
    }

    public final void a(ef_0 ef_02) {
        Intrinsics.checkNotNullParameter((Object)ef_02, (String)"");
        this.e.add(ef_02);
    }

    private Vector3dc a(PhysShip physShip, AerodynamicUtils aerodynamicUtils) {
        Intrinsics.checkNotNullParameter((Object)physShip, (String)"");
        Intrinsics.checkNotNullParameter((Object)aerodynamicUtils, (String)"");
        Vector3d vector3d = this.getWindVector().sub(physShip.getVelocity(), new Vector3d());
        Intrinsics.checkNotNullExpressionValue((Object)vector3d, (String)"");
        Vector3dc vector3dc = vector3d;
        if (vector3dc.lengthSquared() < 1.0E-12 || !this.q || physShip.isStatic()) {
            return new Vector3d(0.0, 0.0, 0.0);
        }
        Vector3dc vector3dc2 = vector3dc.rotate(physShip.getTransform().getShipToWorldRotation().invert(new Quaterniond()), new Vector3d());
        Vector3d vector3d2 = vector3dc.normalize(new Vector3d());
        Intrinsics.checkNotNullExpressionValue((Object)vector3d2, (String)"");
        Vector3dc vector3dc3 = vector3d2;
        Vector3d vector3d3 = ((Vector3d)vector3dc2).normalize(new Vector3d());
        Intrinsics.checkNotNullExpressionValue((Object)vector3d3, (String)"");
        vector3dc2 = vector3d3;
        double d2 = aerodynamicUtils.getAirDensityForY(physShip.getTransform().getPositionInWorld().y(), this.d);
        double d3 = 0.0;
        for (Vector3dc vector3dc4 : org.valkyrienskies.core.impl.shadow.Eh$a.a()) {
            double d4;
            Double d5 = this.h.get(vector3dc4);
            if (d5 == null) continue;
            double d6 = ((Number)d5).doubleValue();
            double d7 = vector3dc2.dot(vector3dc4);
            if (!(d4 > 0.0)) continue;
            d3 += d6 * eh_0.a(physShip, vector3dc4) * d7;
        }
        double d8 = VSCoreConfig.SERVER.getDs().getDragCoefficient() * d2 * (vector3dc.lengthSquared() / 2.0) * d3;
        Vector3d vector3d4 = vector3dc3.mul(d8, new Vector3d());
        Intrinsics.checkNotNullExpressionValue((Object)vector3d4, (String)"");
        return vector3d4;
    }

    /*
     * Could not resolve type clashes
     * Unable to fully structure code
     */
    private Vector3d b(PhysShip var1_1, AerodynamicUtils var2_2) {
        Intrinsics.checkNotNullParameter((Object)var1_1, (String)"");
        Intrinsics.checkNotNullParameter((Object)var2_2, (String)"");
        if (!this.s || var1_1.isStatic() || var1_1.getAngularVelocity().lengthSquared() < 1.0E-12) {
            return new Vector3d();
        }
        var3_3 = var1_1.getAngularVelocity().rotate(var1_1.getTransform().getShipToWorldRotation().invert(new Quaterniond()), new Vector3d());
        var4_4 = var2_2.getAirDensityForY(var1_1.getTransform().getPositionInWorld().y(), this.d);
        var2_2 = new Vector3d();
        for (Iterator<E> var7_6 : this.g.entrySet()) {
            Intrinsics.checkNotNullExpressionValue(var7_6, (String)"");
            var8_7 = var7_6.getKey();
            if ((var7_6 = var7_6.getValue()).isEmpty()) continue;
            var9_8 = new Vector3d(var8_7).normalize();
            var7_6 = var7_6.iterator();
            while (var7_6.hasNext()) {
                var10_9 = (Vector3ic)var7_6.next();
                var11_10 = new Vector3d((Vector3ic)var10_9).add(0.5, 0.5, 0.5).add(new Vector3d(var8_7).mul(0.5));
                var12_11 = var3_3.cross(var11_10 = var11_10.sub(var1_1.getTransform().getPositionInShip(), new Vector3d()), new Vector3d());
                if (var12_11.lengthSquared() < 1.0E-12 || (var12_11 = new Vector3d(var9_8).mul(var17_12 = var12_11.dot(var9_8))).lengthSquared() < 1.0E-12) continue;
                v0 = this.f.get(var10_9);
                if (v0 == null || (v0 = v0.getSolidState()) == null || (v0 = v0.getShape()) == null) ** GOTO lbl-1000
                var10_9 = v0;
                v1 = v0 instanceof BoxesBlockShape != false ? (BoxesBlockShape)var10_9 : null;
                v0 = v1 != null ? Double.valueOf(eh_0.a(v1, org.valkyrienskies.core.impl.shadow.Eh$a.a().indexOf(var8_7))) : null;
                if (v0 != null) {
                    v2 = v0.doubleValue();
                } else lbl-1000:
                // 2 sources

                {
                    v2 = 1.0;
                }
                Intrinsics.checkNotNullExpressionValue((Object)var8_7, (String)"");
                var20_13 = v2 * eh_0.a(var1_1, var8_7);
                var22_14 = VSCoreConfig.SERVER.getDs().getDragCoefficient() * var4_4 * 0.5 * var12_11.lengthSquared() * var20_13;
                var10_9 = var12_11.normalize(new Vector3d()).negate().mul(var22_14);
                var10_9 = var11_10.cross((Vector3dc)var10_9, new Vector3d());
                var2_2.add((Vector3dc)var10_9);
            }
        }
        v3 = var2_2.rotate(var1_1.getTransform().getShipToWorldRotation(), new Vector3d());
        Intrinsics.checkNotNullExpressionValue((Object)v3, (String)"");
        return v3;
    }

    private Vector3dc a(PhysShip object) {
        Vector3dc vector3dc;
        Intrinsics.checkNotNullParameter((Object)object, (String)"");
        Vector3d vector3d = this.getWindVector().sub(object.getVelocity(), new Vector3d()).rotate(object.getTransform().getShipToWorldRotation().invert(new Quaterniond()), new Vector3d());
        Intrinsics.checkNotNullExpressionValue((Object)vector3d, (String)"");
        Vector3dc vector3dc2 = vector3d;
        if (vector3dc2.lengthSquared() < 1.0E-12 || !this.q || object.isStatic()) {
            return new Vector3d(0.0, 0.0, 0.0);
        }
        Vector3d vector3d2 = vector3dc2.normalize(new Vector3d());
        Intrinsics.checkNotNullExpressionValue((Object)vector3d2, (String)"");
        object = vector3d2;
        vector3dc2 = new Vector3d();
        double d2 = 0.0;
        for (Map.Entry<Vector3dc, HashSet<Vector3ic>> entry : this.g.entrySet()) {
            double d3;
            Intrinsics.checkNotNullExpressionValue(entry, (String)"");
            Vector3dc vector3dc3 = entry.getKey();
            HashSet<Vector3ic> object2 = entry.getValue();
            if (object2.isEmpty()) continue;
            Vector3d vector3d3 = new Vector3d();
            Intrinsics.checkNotNullExpressionValue(object2, (String)"");
            Iterable iterable = object2;
            for (Object object3 : iterable) {
                object3 = (Vector3ic)object3;
                vector3d3.add(object3.x(), object3.y(), object3.z()).add(0.5, 0.5, 0.5).add(vector3dc3.normalize(new Vector3d()).mul(0.5, new Vector3d()));
            }
            vector3d3.div(object2.size());
            double iterable2 = object.dot(vector3dc3);
            if (!(d3 > 0.0)) continue;
            vector3d3.mul(iterable2);
            ((Vector3d)vector3dc2).add(vector3d3);
            d2 += iterable2;
        }
        if (!(d2 == 0.0)) {
            Vector3d vector3d4 = ((Vector3d)vector3dc2).div(d2);
            Intrinsics.checkNotNullExpressionValue((Object)vector3d4, (String)"");
            vector3dc = vector3d4;
        } else {
            vector3dc = new Vector3d();
        }
        Vector3dc vector3dc4 = vector3dc;
        return vector3dc;
    }

    private Pair<Vector3dc, Vector3dc> c(PhysShip physShip, AerodynamicUtils object) {
        Intrinsics.checkNotNullParameter((Object)physShip, (String)"");
        Intrinsics.checkNotNullParameter((Object)object, (String)"");
        Vector3d vector3d = this.getWindVector().sub(physShip.getVelocity(), new Vector3d()).rotate(physShip.getTransform().getShipToWorldRotation().invert(new Quaterniond()), new Vector3d());
        Vector3d vector3d2 = physShip.getAngularVelocity().rotate(physShip.getTransform().getShipToWorldRotation().invert(new Quaterniond()), new Vector3d());
        double d2 = object.getAirDensityForY(physShip.getTransform().getPositionInWorld().y(), this.d);
        object = physShip.getTransform().getPositionInShip();
        Vector3d vector3d3 = new Vector3d();
        Vector3d vector3d4 = new Vector3d();
        for (Map.Entry<Vector3dc, HashSet<Vector3ic>> entry : this.g.entrySet()) {
            double d3;
            double d4;
            Object object22;
            Intrinsics.checkNotNullExpressionValue(entry, (String)"");
            Vector3dc vector3dc = entry.getKey();
            HashSet<Vector3ic> hashSet = entry.getValue();
            if (hashSet.isEmpty()) continue;
            Double d5 = this.h.get(vector3dc);
            if (d5 == null) continue;
            double d6 = d5;
            Intrinsics.checkNotNullExpressionValue((Object)vector3dc, (String)"");
            double d7 = d6 * eh_0.a(physShip, vector3dc);
            if (d7 <= 0.0) continue;
            Vector3d vector3d5 = new Vector3d();
            for (Object object22 : hashSet) {
                vector3d5.add((double)object22.x() + 0.5, (double)object22.y() + 0.5, (double)object22.z() + 0.5);
                vector3d5.add(vector3dc.normalize(new Vector3d()).mul(0.5));
            }
            vector3d5.div(hashSet.size());
            Vector3d vector3d6 = vector3d5.sub((Vector3dc)object, new Vector3d());
            object22 = vector3d2.cross(vector3d6, new Vector3d());
            Vector3d vector3d7 = vector3d.add((Vector3dc)object22);
            if (vector3d7.lengthSquared() < 1.0E-12 || (d4 = RangesKt.coerceIn((double)(vector3d5 = vector3d7.normalize(new Vector3d())).dot(vector3dc = vector3dc.normalize(new Vector3d())), (double)-1.0, (double)1.0)) >= 0.0 || (d3 = Math.acos(-d4)) < 0.001 || d3 > Math.toRadians(85.0)) continue;
            double d8 = eh_0.a(d3);
            double d9 = d2 * 0.5 * vector3d7.lengthSquared() * d8 * d7;
            Vector3d vector3d8 = ((Vector3d)vector3dc).cross(vector3d5, new Vector3d()).cross(vector3d5).normalize();
            if (vector3d8.lengthSquared() < 1.0E-12) continue;
            Vector3d vector3d9 = vector3d8.mul(d9);
            vector3d3.add(vector3d9.rotate(physShip.getTransform().getShipToWorldRotation(), new Vector3d()));
            Vector3d vector3d10 = vector3d6.cross(vector3d9, new Vector3d());
            vector3d4.add(vector3d10.rotate(physShip.getTransform().getShipToWorldRotation(), new Vector3d()));
        }
        return new Pair((Object)vector3d3, (Object)vector3d4);
    }

    private static double a(double d2) {
        double d3 = Math.toRadians(20.0);
        if (d2 < d3) {
            return Math.sin(d2 * 2.0);
        }
        return Math.sin(d2 * 2.0) * Math.cos((d2 - d3) * 3.0);
    }

    @Override
    public final void enableDrag() {
        this.q = true;
    }

    @Override
    public final void disableDrag() {
        this.q = false;
    }

    @Override
    public final void enableLift() {
        this.r = true;
    }

    @Override
    public final void disableLift() {
        this.r = false;
    }

    @Override
    public final void enableRotDrag() {
        this.s = true;
    }

    @Override
    public final void disableRotDrag() {
        this.s = false;
    }

    private final Vector3dc h() {
        Vector3d vector3d = new Vector3d(this.m).mul(this.n);
        for (Map.Entry entry : ((Map)this.k).entrySet()) {
            String string = (String)entry.getKey();
            Vector3d object = (Vector3d)entry.getValue();
            Double d2 = this.l.get(string);
            if (d2 == null) continue;
            double d3 = ((Number)d2).doubleValue();
            vector3d.add(new Vector3d(object).mul(d3));
        }
        Intrinsics.checkNotNullExpressionValue((Object)vector3d, (String)"");
        return vector3d;
    }

    private final Vector3dc i() {
        Vector3d vector3d = new Vector3d(0.0, 0.0, 0.0);
        for (Pair<Vector3dc, Double> pair : this.p) {
            vector3d.add(((Vector3dc)pair.getFirst()).mul(((Number)pair.getSecond()).doubleValue(), new Vector3d()));
        }
        return vector3d;
    }

    @Override
    public final Vector3dc getDragForce() {
        return this.i;
    }

    @Override
    public final Vector3dc getLiftForce() {
        return this.j;
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public final void setWindDirection(double x, double y, double z, String identifier) {
        void var3_2;
        void var1_1;
        Intrinsics.checkNotNullParameter((Object)identifier, (String)"");
        if (Intrinsics.areEqual((Object)identifier, (Object)"default")) {
            this.m.set(x, y, z);
            return;
        }
        ((Map)this.k).put(identifier, new Vector3d((double)var1_1, (double)var3_2, z));
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public final void setWindSpeed(double speed, String identifier) {
        void var3_3;
        Intrinsics.checkNotNullParameter((Object)identifier, (String)"");
        if (Intrinsics.areEqual((Object)identifier, (Object)"default")) {
            this.n = speed > 0.0 ? speed : 0.0;
            return;
        }
        if (speed > 0.0) {
            void var1_1;
            Double d2 = (double)var1_1;
            ((Map)this.l).put(identifier, d2);
            return;
        }
        this.l.remove(var3_3);
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public final void applyWindImpulse(Vector3dc direction, double speed) {
        void var2_2;
        void var1_1;
        Intrinsics.checkNotNullParameter((Object)direction, (String)"");
        this.p.add((Pair<Vector3dc, Double>)new Pair((Object)var1_1, (Object)((double)var2_2)));
    }

    private static final HashSet a(Function1 function1, Object object) {
        return (HashSet)function1.invoke(object);
    }

    private static final Double b(Function1 function1, Object object) {
        return (Double)function1.invoke(object);
    }

    private static final Double c(Function1 function1, Object object) {
        return (Double)function1.invoke(object);
    }

    private static final Double d(Function1 function1, Object object) {
        return (Double)function1.invoke(object);
    }

    private static final Double e(Function1 function1, Object object) {
        return (Double)function1.invoke(object);
    }

    private static final Double f(Function1 function1, Object object) {
        return (Double)function1.invoke(object);
    }

    private static final Double g(Function1 function1, Object object) {
        return (Double)function1.invoke(object);
    }

    private static final HashSet h(Function1 function1, Object object) {
        return (HashSet)function1.invoke(object);
    }

    private static final Double i(Function1 function1, Object object) {
        return (Double)function1.invoke(object);
    }

    private static final Double j(Function1 function1, Object object) {
        return (Double)function1.invoke(object);
    }

    private static final HashSet k(Function1 function1, Object object) {
        return (HashSet)function1.invoke(object);
    }

    public eh_0() {
        this(false, 1, null);
    }

    public static final /* synthetic */ Logger a() {
        return u;
    }

    @Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028G\u00a2\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u001b\u0010\t\u001a\u00020\u00068CX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\n"}, d2={"Lorg/valkyrienskies/core/impl/shadow/Eh$a;", "", "", "Lorg/joml/Vector3dc;", "a", "()Ljava/util/List;", "Lorg/apache/logging/log4j/Logger;", "u", "Lorg/apache/logging/log4j/Logger;", "b", "()Lorg/apache/logging/log4j/Logger;", "<init>", "()V"})
    public static final class a {
        private static /* synthetic */ KProperty<Object>[] a;

        private a() {
        }

        @JvmName(name="b")
        private final Logger b() {
            KProperty<Object> kProperty = a[0];
            Logger logger = Eh.a();
            Intrinsics.checkNotNullParameter(kProperty, (String)"");
            return logger;
        }

        @JvmName(name="a")
        public static List<Vector3dc> a() {
            ArrayList<Vector3d> arrayList = new ArrayList<Vector3d>(6);
            arrayList.add(new Vector3d(1.0, 0.0, 0.0));
            arrayList.add(new Vector3d(-1.0, 0.0, 0.0));
            arrayList.add(new Vector3d(0.0, 1.0, 0.0));
            arrayList.add(new Vector3d(0.0, -1.0, 0.0));
            arrayList.add(new Vector3d(0.0, 0.0, 1.0));
            arrayList.add(new Vector3d(0.0, 0.0, -1.0));
            return arrayList;
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        static {
            KProperty[] kPropertyArray = new KProperty[1];
            KProperty[] kPropertyArray2 = kPropertyArray;
            kPropertyArray[0] = Reflection.property1((PropertyReference1)((PropertyReference1)new PropertyReference1Impl(a.class, "logger", "getLogger()Lorg/apache/logging/log4j/Logger;", 0)));
            a = kPropertyArray2;
        }
    }
}

