/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Lazy
 *  kotlin.LazyKt
 *  kotlin.Metadata
 *  kotlin.Pair
 *  kotlin.Unit
 *  kotlin.jvm.JvmStatic
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.functions.Function2
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  net.minecraft.class_1297
 *  net.minecraft.class_1299
 *  net.minecraft.class_1761
 *  net.minecraft.class_1792
 *  net.minecraft.class_1937
 *  net.minecraft.class_2248
 *  net.minecraft.class_2338
 *  net.minecraft.class_2586
 *  net.minecraft.class_2591
 *  net.minecraft.class_2960
 *  net.minecraft.class_310
 *  net.minecraft.class_5321
 *  net.minecraft.class_631
 *  net.minecraft.class_638
 *  net.minecraft.class_6862
 *  net.minecraft.class_7924
 *  net.minecraft.server.MinecraftServer
 */
package org.valkyrienskies.mod.common;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import java.util.HashMap;
import java.util.Map;
import java.util.ServiceLoader;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import net.minecraft.class_1297;
import net.minecraft.class_1299;
import net.minecraft.class_1761;
import net.minecraft.class_1792;
import net.minecraft.class_1937;
import net.minecraft.class_2248;
import net.minecraft.class_2338;
import net.minecraft.class_2586;
import net.minecraft.class_2591;
import net.minecraft.class_2960;
import net.minecraft.class_310;
import net.minecraft.class_5321;
import net.minecraft.class_631;
import net.minecraft.class_638;
import net.minecraft.class_6862;
import net.minecraft.class_7924;
import net.minecraft.server.MinecraftServer;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.valkyrienskies.core.api.attachment.AttachmentRegistration;
import org.valkyrienskies.core.api.events.PhysTickEvent;
import org.valkyrienskies.core.api.events.ShipLoadEvent;
import org.valkyrienskies.core.api.events.ShipUnloadEventClient;
import org.valkyrienskies.core.api.ships.PhysShip;
import org.valkyrienskies.core.api.ships.Ship;
import org.valkyrienskies.core.internal.VsiCore;
import org.valkyrienskies.core.internal.VsiCoreClient;
import org.valkyrienskies.mod.api.BlockEntityPhysicsListener;
import org.valkyrienskies.mod.api.EntityPhysicsListener;
import org.valkyrienskies.mod.api.SeatedControllingPlayer;
import org.valkyrienskies.mod.api.ValkyrienSkies;
import org.valkyrienskies.mod.api_impl.events.VsApiImpl;
import org.valkyrienskies.mod.common.BlockStateInfo;
import org.valkyrienskies.mod.common.VSCoreProvider;
import org.valkyrienskies.mod.common.blockentity.TestAntigravBlockEntity;
import org.valkyrienskies.mod.common.blockentity.TestHingeBlockEntity;
import org.valkyrienskies.mod.common.blockentity.TestThrusterBlockEntity;
import org.valkyrienskies.mod.common.entity.ShipMountingEntity;
import org.valkyrienskies.mod.common.entity.VSPhysicsEntity;
import org.valkyrienskies.mod.common.jackson.BlockPosDeserializer;
import org.valkyrienskies.mod.common.jackson.BlockPosKeyDeserializer;
import org.valkyrienskies.mod.common.jackson.BlockPosKeySerializer;
import org.valkyrienskies.mod.common.jackson.BlockPosSerializer;
import org.valkyrienskies.mod.common.networking.VSGamePackets;
import org.valkyrienskies.mod.common.util.GameToPhysicsAdapter;
import org.valkyrienskies.mod.common.util.ShipSettings;
import org.valkyrienskies.mod.common.util.SplitHandler;
import org.valkyrienskies.mod.common.util.SplittingDisablerAttachment;
import org.valkyrienskies.mod.mixinducks.client.world.ClientChunkCacheDuck;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000\u00ea\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\b\u00c6\u0002\u0018\u00002\u00020\u0001B\n\b\u0002\u00a2\u0006\u0005\b\u00b0\u0001\u0010\u0004J\r\u0010\u0003\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0003\u0010\u0004J\u001b\u0010\t\u001a\u00020\b2\n\u0010\u0007\u001a\u00060\u0005j\u0002`\u0006H\u0007\u00a2\u0006\u0004\b\t\u0010\nJ)\u0010\u000f\u001a\u00020\u00022\n\u0010\u0007\u001a\u00060\u0005j\u0002`\u00062\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\r\u00a2\u0006\u0004\b\u000f\u0010\u0010J#\u0010\u0011\u001a\u0004\u0018\u00010\r2\n\u0010\u0007\u001a\u00060\u0005j\u0002`\u00062\u0006\u0010\f\u001a\u00020\u000b\u00a2\u0006\u0004\b\u0011\u0010\u0012J!\u0010\u0013\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000b2\n\u0010\u0007\u001a\u00060\u0005j\u0002`\u0006\u00a2\u0006\u0004\b\u0013\u0010\u0014J!\u0010\u0017\u001a\u00020\u00022\n\u0010\u0007\u001a\u00060\u0005j\u0002`\u00062\u0006\u0010\u0016\u001a\u00020\u0015\u00a2\u0006\u0004\b\u0017\u0010\u0018J!\u0010\u0019\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u00152\n\u0010\u0007\u001a\u00060\u0005j\u0002`\u0006\u00a2\u0006\u0004\b\u0019\u0010\u001aJ#\u0010\u001e\u001a\u0004\u0018\u00010\u001d2\n\u0010\u0007\u001a\u00060\u0005j\u0002`\u00062\u0006\u0010\u001c\u001a\u00020\u001b\u00a2\u0006\u0004\b\u001e\u0010\u001fJ#\u0010\u001e\u001a\u0004\u0018\u00010\u001d2\n\u0010\u0007\u001a\u00060\u0005j\u0002`\u00062\u0006\u0010\u0016\u001a\u00020\u0015\u00a2\u0006\u0004\b\u001e\u0010 R\u0014\u0010!\u001a\u00020\u00058\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b!\u0010\"R\"\u0010$\u001a\u00020#8\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R\"\u0010*\u001a\u00020#8\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b*\u0010%\u001a\u0004\b+\u0010'\"\u0004\b,\u0010)R\"\u0010-\u001a\u00020#8\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b-\u0010%\u001a\u0004\b.\u0010'\"\u0004\b/\u0010)R\"\u00100\u001a\u00020#8\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b0\u0010%\u001a\u0004\b1\u0010'\"\u0004\b2\u0010)R\"\u00103\u001a\u00020#8\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b3\u0010%\u001a\u0004\b4\u0010'\"\u0004\b5\u0010)R\"\u00106\u001a\u00020#8\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b6\u0010%\u001a\u0004\b7\u0010'\"\u0004\b8\u0010)R\"\u00109\u001a\u00020#8\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b9\u0010%\u001a\u0004\b:\u0010'\"\u0004\b;\u0010)R\"\u0010=\u001a\u00020<8\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b=\u0010>\u001a\u0004\b?\u0010@\"\u0004\bA\u0010BR\"\u0010C\u001a\u00020<8\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\bC\u0010>\u001a\u0004\bD\u0010@\"\u0004\bE\u0010BR\"\u0010F\u001a\u00020<8\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\bF\u0010>\u001a\u0004\bG\u0010@\"\u0004\bH\u0010BR\"\u0010I\u001a\u00020<8\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\bI\u0010>\u001a\u0004\bJ\u0010@\"\u0004\bK\u0010BR\"\u0010L\u001a\u00020<8\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\bL\u0010>\u001a\u0004\bM\u0010@\"\u0004\bN\u0010BR\"\u0010O\u001a\u00020<8\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\bO\u0010>\u001a\u0004\bP\u0010@\"\u0004\bQ\u0010BR(\u0010T\u001a\b\u0012\u0004\u0012\u00020S0R8\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\bT\u0010U\u001a\u0004\bV\u0010W\"\u0004\bX\u0010YR(\u0010[\u001a\b\u0012\u0004\u0012\u00020Z0R8\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b[\u0010U\u001a\u0004\b\\\u0010W\"\u0004\b]\u0010YR(\u0010`\u001a\b\u0012\u0004\u0012\u00020_0^8\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b`\u0010a\u001a\u0004\bb\u0010c\"\u0004\bd\u0010eR(\u0010g\u001a\b\u0012\u0004\u0012\u00020f0^8\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\bg\u0010a\u001a\u0004\bh\u0010c\"\u0004\bi\u0010eR(\u0010k\u001a\b\u0012\u0004\u0012\u00020j0^8\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\bk\u0010a\u001a\u0004\bl\u0010c\"\u0004\bm\u0010eR8\u0010p\u001a&\u0012\b\u0012\u00060\u0005j\u0002`\u0006\u0012\u0004\u0012\u00020\b0nj\u0012\u0012\b\u0012\u00060\u0005j\u0002`\u0006\u0012\u0004\u0012\u00020\b`o8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bp\u0010qR;\u0010u\u001a&\u0012\f\u0012\n t*\u0004\u0018\u00010s0s t*\u0012\u0012\f\u0012\n t*\u0004\u0018\u00010s0s\u0018\u00010r0r8\u0006\u00a2\u0006\f\n\u0004\bu\u0010v\u001a\u0004\bw\u0010xR\u001d\u0010z\u001a\b\u0012\u0004\u0012\u00020#0y8\u0006\u00a2\u0006\f\n\u0004\bz\u0010{\u001a\u0004\b|\u0010}R0\u0010\u007f\u001a\u0004\u0018\u00010~8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u001e\n\u0005\b\u007f\u0010\u0080\u0001\u0012\u0005\b\u0085\u0001\u0010\u0004\u001a\u0006\b\u0081\u0001\u0010\u0082\u0001\"\u0006\b\u0083\u0001\u0010\u0084\u0001R(\u0010\u008c\u0001\u001a\u00030\u0086\u00018FX\u0087\u0084\u0002\u00a2\u0006\u0017\n\u0006\b\u0087\u0001\u0010\u0088\u0001\u0012\u0005\b\u008b\u0001\u0010\u0004\u001a\u0006\b\u0089\u0001\u0010\u008a\u0001R'\u0010\u008e\u0001\u001a\u00030\u008d\u00018\u0006X\u0087\u0004\u00a2\u0006\u0017\n\u0006\b\u008e\u0001\u0010\u008f\u0001\u0012\u0005\b\u0092\u0001\u0010\u0004\u001a\u0006\b\u0090\u0001\u0010\u0091\u0001R\u001f\u0010\u0097\u0001\u001a\u00030\u0093\u00018FX\u0087\u0004\u00a2\u0006\u000f\u0012\u0005\b\u0096\u0001\u0010\u0004\u001a\u0006\b\u0094\u0001\u0010\u0095\u0001R(\u0010\u009d\u0001\u001a\u00030\u0098\u00018FX\u0087\u0084\u0002\u00a2\u0006\u0017\n\u0006\b\u0099\u0001\u0010\u0088\u0001\u0012\u0005\b\u009c\u0001\u0010\u0004\u001a\u0006\b\u009a\u0001\u0010\u009b\u0001RQ\u0010\u00a2\u0001\u001a7\u0012\b\u0012\u00060\u0005j\u0002`\u0006\u0012(\u0012&\u0012\u0004\u0012\u00020\u000b\u0012\u001b\u0012\u0019\u0012\u000e\u0012\f\u0018\u00010\u00a0\u0001j\u0005\u0018\u0001`\u00a1\u0001\u0012\u0004\u0012\u00020\r0\u009f\u00010\u009e\u00010\u009e\u00018\u0006\u00a2\u0006\u0010\n\u0006\b\u00a2\u0001\u0010\u00a3\u0001\u001a\u0006\b\u00a4\u0001\u0010\u00a5\u0001R:\u0010\u00a6\u0001\u001a \u0012\b\u0012\u00060\u0005j\u0002`\u0006\u0012\u0011\u0012\u000f\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\u001d0\u009e\u00010\u009e\u00018\u0006\u00a2\u0006\u0010\n\u0006\b\u00a6\u0001\u0010\u00a3\u0001\u001a\u0006\b\u00a7\u0001\u0010\u00a5\u0001R1\u0010\u00a9\u0001\u001a\u00030\u00a8\u00018\u0006@\u0006X\u0087.\u00a2\u0006\u001f\n\u0006\b\u00a9\u0001\u0010\u00aa\u0001\u0012\u0005\b\u00af\u0001\u0010\u0004\u001a\u0006\b\u00ab\u0001\u0010\u00ac\u0001\"\u0006\b\u00ad\u0001\u0010\u00ae\u0001\u00a8\u0006\u00b1\u0001"}, d2={"Lorg/valkyrienskies/mod/common/ValkyrienSkiesMod;", "", "", "init", "()V", "", "Lorg/valkyrienskies/core/api/world/properties/DimensionId;", "dimensionId", "Lorg/valkyrienskies/mod/common/util/GameToPhysicsAdapter;", "getOrCreateGTPA", "(Ljava/lang/String;)Lorg/valkyrienskies/mod/common/util/GameToPhysicsAdapter;", "Lnet/minecraft/class_2338;", "pos", "Lorg/valkyrienskies/mod/api/BlockEntityPhysicsListener;", "blockEntity", "addBlockEntityPhysTicker", "(Ljava/lang/String;Lnet/minecraft/class_2338;Lorg/valkyrienskies/mod/api/BlockEntityPhysicsListener;)V", "getBlockEntityPhysTicker", "(Ljava/lang/String;Lnet/minecraft/class_2338;)Lorg/valkyrienskies/mod/api/BlockEntityPhysicsListener;", "removeBlockEntityPhysTicker", "(Lnet/minecraft/class_2338;Ljava/lang/String;)V", "Lnet/minecraft/class_1297;", "entity", "addEntityPhysTicker", "(Ljava/lang/String;Lnet/minecraft/class_1297;)V", "removeEntityPhysTicker", "(Lnet/minecraft/class_1297;Ljava/lang/String;)V", "", "entityId", "Lorg/valkyrienskies/mod/api/EntityPhysicsListener;", "getEntityPhysTicker", "(Ljava/lang/String;I)Lorg/valkyrienskies/mod/api/EntityPhysicsListener;", "(Ljava/lang/String;Lnet/minecraft/class_1297;)Lorg/valkyrienskies/mod/api/EntityPhysicsListener;", "MOD_ID", "Ljava/lang/String;", "Lnet/minecraft/class_2248;", "TEST_CHAIR", "Lnet/minecraft/class_2248;", "getTEST_CHAIR", "()Lnet/minecraft/class_2248;", "setTEST_CHAIR", "(Lnet/minecraft/class_2248;)V", "TEST_HINGE", "getTEST_HINGE", "setTEST_HINGE", "TEST_FLAP", "getTEST_FLAP", "setTEST_FLAP", "TEST_WING", "getTEST_WING", "setTEST_WING", "TEST_SPHERE", "getTEST_SPHERE", "setTEST_SPHERE", "TEST_THRUSTER", "getTEST_THRUSTER", "setTEST_THRUSTER", "TEST_ANTIGRAV", "getTEST_ANTIGRAV", "setTEST_ANTIGRAV", "Lnet/minecraft/class_1792;", "CONNECTION_CHECKER_ITEM", "Lnet/minecraft/class_1792;", "getCONNECTION_CHECKER_ITEM", "()Lnet/minecraft/class_1792;", "setCONNECTION_CHECKER_ITEM", "(Lnet/minecraft/class_1792;)V", "SHIP_CREATOR_ITEM", "getSHIP_CREATOR_ITEM", "setSHIP_CREATOR_ITEM", "SHIP_ASSEMBLER_ITEM", "getSHIP_ASSEMBLER_ITEM", "setSHIP_ASSEMBLER_ITEM", "SHIP_CREATOR_ITEM_SMALLER", "getSHIP_CREATOR_ITEM_SMALLER", "setSHIP_CREATOR_ITEM_SMALLER", "AREA_ASSEMBLER_ITEM", "getAREA_ASSEMBLER_ITEM", "setAREA_ASSEMBLER_ITEM", "PHYSICS_ENTITY_CREATOR_ITEM", "getPHYSICS_ENTITY_CREATOR_ITEM", "setPHYSICS_ENTITY_CREATOR_ITEM", "Lnet/minecraft/class_1299;", "Lorg/valkyrienskies/mod/common/entity/ShipMountingEntity;", "SHIP_MOUNTING_ENTITY_TYPE", "Lnet/minecraft/class_1299;", "getSHIP_MOUNTING_ENTITY_TYPE", "()Lnet/minecraft/class_1299;", "setSHIP_MOUNTING_ENTITY_TYPE", "(Lnet/minecraft/class_1299;)V", "Lorg/valkyrienskies/mod/common/entity/VSPhysicsEntity;", "PHYSICS_ENTITY_TYPE", "getPHYSICS_ENTITY_TYPE", "setPHYSICS_ENTITY_TYPE", "Lnet/minecraft/class_2591;", "Lorg/valkyrienskies/mod/common/blockentity/TestHingeBlockEntity;", "TEST_HINGE_BLOCK_ENTITY_TYPE", "Lnet/minecraft/class_2591;", "getTEST_HINGE_BLOCK_ENTITY_TYPE", "()Lnet/minecraft/class_2591;", "setTEST_HINGE_BLOCK_ENTITY_TYPE", "(Lnet/minecraft/class_2591;)V", "Lorg/valkyrienskies/mod/common/blockentity/TestThrusterBlockEntity;", "TEST_THRUSTER_BLOCK_ENTITY_TYPE", "getTEST_THRUSTER_BLOCK_ENTITY_TYPE", "setTEST_THRUSTER_BLOCK_ENTITY_TYPE", "Lorg/valkyrienskies/mod/common/blockentity/TestAntigravBlockEntity;", "TEST_ANTIGRAV_BLOCK_ENTITY_TYPE", "getTEST_ANTIGRAV_BLOCK_ENTITY_TYPE", "setTEST_ANTIGRAV_BLOCK_ENTITY_TYPE", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "dimensionalGTPAs", "Ljava/util/HashMap;", "Lnet/minecraft/class_5321;", "Lnet/minecraft/class_1761;", "kotlin.jvm.PlatformType", "VS_CREATIVE_TAB", "Lnet/minecraft/class_5321;", "getVS_CREATIVE_TAB", "()Lnet/minecraft/class_5321;", "Lnet/minecraft/class_6862;", "ASSEMBLE_BLACKLIST", "Lnet/minecraft/class_6862;", "getASSEMBLE_BLACKLIST", "()Lnet/minecraft/class_6862;", "Lnet/minecraft/server/MinecraftServer;", "currentServer", "Lnet/minecraft/server/MinecraftServer;", "getCurrentServer", "()Lnet/minecraft/server/MinecraftServer;", "setCurrentServer", "(Lnet/minecraft/server/MinecraftServer;)V", "getCurrentServer$annotations", "Lorg/valkyrienskies/mod/common/VSCoreProvider;", "vsCoreProvider$delegate", "Lkotlin/Lazy;", "getVsCoreProvider", "()Lorg/valkyrienskies/mod/common/VSCoreProvider;", "getVsCoreProvider$annotations", "vsCoreProvider", "Lorg/valkyrienskies/core/internal/VsiCore;", "vsCore", "Lorg/valkyrienskies/core/internal/VsiCore;", "getVsCore", "()Lorg/valkyrienskies/core/internal/VsiCore;", "getVsCore$annotations", "Lorg/valkyrienskies/core/internal/VsiCoreClient;", "getVsCoreClient", "()Lorg/valkyrienskies/core/internal/VsiCoreClient;", "getVsCoreClient$annotations", "vsCoreClient", "Lorg/valkyrienskies/mod/api_impl/events/VsApiImpl;", "api$delegate", "getApi", "()Lorg/valkyrienskies/mod/api_impl/events/VsApiImpl;", "getApi$annotations", "api", "Ljava/util/concurrent/ConcurrentHashMap;", "Lkotlin/Pair;", "", "Lorg/valkyrienskies/core/api/ships/properties/ShipId;", "blockEntityPhysListeners", "Ljava/util/concurrent/ConcurrentHashMap;", "getBlockEntityPhysListeners", "()Ljava/util/concurrent/ConcurrentHashMap;", "entityPhysListeners", "getEntityPhysListeners", "Lorg/valkyrienskies/mod/common/util/SplitHandler;", "splitHandler", "Lorg/valkyrienskies/mod/common/util/SplitHandler;", "getSplitHandler", "()Lorg/valkyrienskies/mod/common/util/SplitHandler;", "setSplitHandler", "(Lorg/valkyrienskies/mod/common/util/SplitHandler;)V", "getSplitHandler$annotations", "<init>", "valkyrienskies-120"})
@SourceDebugExtension(value={"SMAP\nValkyrienSkiesMod.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ValkyrienSkiesMod.kt\norg/valkyrienskies/mod/common/ValkyrienSkiesMod\n+ 2 Maps.kt\nkotlin/collections/MapsKt__MapsKt\n+ 3 MapsJVM.kt\nkotlin/collections/MapsKt__MapsJVMKt\n+ 4 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,216:1\n381#2,7:217\n72#3,2:224\n72#3,2:227\n72#3,2:230\n72#3,2:233\n72#3,2:236\n72#3,2:239\n72#3,2:242\n72#3,2:245\n72#3,2:248\n1#4:226\n1#4:229\n1#4:232\n1#4:235\n1#4:238\n1#4:241\n1#4:244\n1#4:247\n1#4:250\n*S KotlinDebug\n*F\n+ 1 ValkyrienSkiesMod.kt\norg/valkyrienskies/mod/common/ValkyrienSkiesMod\n*L\n172#1:217,7\n185#1:224,2\n189#1:227,2\n193#1:230,2\n200#1:233,2\n204#1:236,2\n208#1:239,2\n212#1:242,2\n148#1:245,2\n158#1:248,2\n185#1:226\n189#1:229\n193#1:232\n200#1:235\n204#1:238\n208#1:241\n212#1:244\n148#1:247\n158#1:250\n*E\n"})
public final class ValkyrienSkiesMod {
    @NotNull
    public static final ValkyrienSkiesMod INSTANCE = new ValkyrienSkiesMod();
    @NotNull
    public static final String MOD_ID = "valkyrienskies";
    public static class_2248 TEST_CHAIR;
    public static class_2248 TEST_HINGE;
    public static class_2248 TEST_FLAP;
    public static class_2248 TEST_WING;
    public static class_2248 TEST_SPHERE;
    public static class_2248 TEST_THRUSTER;
    public static class_2248 TEST_ANTIGRAV;
    public static class_1792 CONNECTION_CHECKER_ITEM;
    public static class_1792 SHIP_CREATOR_ITEM;
    public static class_1792 SHIP_ASSEMBLER_ITEM;
    public static class_1792 SHIP_CREATOR_ITEM_SMALLER;
    public static class_1792 AREA_ASSEMBLER_ITEM;
    public static class_1792 PHYSICS_ENTITY_CREATOR_ITEM;
    public static class_1299<ShipMountingEntity> SHIP_MOUNTING_ENTITY_TYPE;
    public static class_1299<VSPhysicsEntity> PHYSICS_ENTITY_TYPE;
    public static class_2591<TestHingeBlockEntity> TEST_HINGE_BLOCK_ENTITY_TYPE;
    public static class_2591<TestThrusterBlockEntity> TEST_THRUSTER_BLOCK_ENTITY_TYPE;
    public static class_2591<TestAntigravBlockEntity> TEST_ANTIGRAV_BLOCK_ENTITY_TYPE;
    @NotNull
    private static final HashMap<String, GameToPhysicsAdapter> dimensionalGTPAs;
    private static final class_5321<class_1761> VS_CREATIVE_TAB;
    @NotNull
    private static final class_6862<class_2248> ASSEMBLE_BLACKLIST;
    @Nullable
    private static MinecraftServer currentServer;
    @NotNull
    private static final Lazy vsCoreProvider$delegate;
    @NotNull
    private static final VsiCore vsCore;
    @NotNull
    private static final Lazy api$delegate;
    @NotNull
    private static final ConcurrentHashMap<String, ConcurrentHashMap<class_2338, Pair<Long, BlockEntityPhysicsListener>>> blockEntityPhysListeners;
    @NotNull
    private static final ConcurrentHashMap<String, ConcurrentHashMap<Integer, EntityPhysicsListener>> entityPhysListeners;
    public static SplitHandler splitHandler;

    private ValkyrienSkiesMod() {
    }

    @NotNull
    public final class_2248 getTEST_CHAIR() {
        class_2248 class_22482 = TEST_CHAIR;
        if (class_22482 != null) {
            return class_22482;
        }
        Intrinsics.throwUninitializedPropertyAccessException((String)"TEST_CHAIR");
        return null;
    }

    public final void setTEST_CHAIR(@NotNull class_2248 class_22482) {
        Intrinsics.checkNotNullParameter((Object)class_22482, (String)"<set-?>");
        TEST_CHAIR = class_22482;
    }

    @NotNull
    public final class_2248 getTEST_HINGE() {
        class_2248 class_22482 = TEST_HINGE;
        if (class_22482 != null) {
            return class_22482;
        }
        Intrinsics.throwUninitializedPropertyAccessException((String)"TEST_HINGE");
        return null;
    }

    public final void setTEST_HINGE(@NotNull class_2248 class_22482) {
        Intrinsics.checkNotNullParameter((Object)class_22482, (String)"<set-?>");
        TEST_HINGE = class_22482;
    }

    @NotNull
    public final class_2248 getTEST_FLAP() {
        class_2248 class_22482 = TEST_FLAP;
        if (class_22482 != null) {
            return class_22482;
        }
        Intrinsics.throwUninitializedPropertyAccessException((String)"TEST_FLAP");
        return null;
    }

    public final void setTEST_FLAP(@NotNull class_2248 class_22482) {
        Intrinsics.checkNotNullParameter((Object)class_22482, (String)"<set-?>");
        TEST_FLAP = class_22482;
    }

    @NotNull
    public final class_2248 getTEST_WING() {
        class_2248 class_22482 = TEST_WING;
        if (class_22482 != null) {
            return class_22482;
        }
        Intrinsics.throwUninitializedPropertyAccessException((String)"TEST_WING");
        return null;
    }

    public final void setTEST_WING(@NotNull class_2248 class_22482) {
        Intrinsics.checkNotNullParameter((Object)class_22482, (String)"<set-?>");
        TEST_WING = class_22482;
    }

    @NotNull
    public final class_2248 getTEST_SPHERE() {
        class_2248 class_22482 = TEST_SPHERE;
        if (class_22482 != null) {
            return class_22482;
        }
        Intrinsics.throwUninitializedPropertyAccessException((String)"TEST_SPHERE");
        return null;
    }

    public final void setTEST_SPHERE(@NotNull class_2248 class_22482) {
        Intrinsics.checkNotNullParameter((Object)class_22482, (String)"<set-?>");
        TEST_SPHERE = class_22482;
    }

    @NotNull
    public final class_2248 getTEST_THRUSTER() {
        class_2248 class_22482 = TEST_THRUSTER;
        if (class_22482 != null) {
            return class_22482;
        }
        Intrinsics.throwUninitializedPropertyAccessException((String)"TEST_THRUSTER");
        return null;
    }

    public final void setTEST_THRUSTER(@NotNull class_2248 class_22482) {
        Intrinsics.checkNotNullParameter((Object)class_22482, (String)"<set-?>");
        TEST_THRUSTER = class_22482;
    }

    @NotNull
    public final class_2248 getTEST_ANTIGRAV() {
        class_2248 class_22482 = TEST_ANTIGRAV;
        if (class_22482 != null) {
            return class_22482;
        }
        Intrinsics.throwUninitializedPropertyAccessException((String)"TEST_ANTIGRAV");
        return null;
    }

    public final void setTEST_ANTIGRAV(@NotNull class_2248 class_22482) {
        Intrinsics.checkNotNullParameter((Object)class_22482, (String)"<set-?>");
        TEST_ANTIGRAV = class_22482;
    }

    @NotNull
    public final class_1792 getCONNECTION_CHECKER_ITEM() {
        class_1792 class_17922 = CONNECTION_CHECKER_ITEM;
        if (class_17922 != null) {
            return class_17922;
        }
        Intrinsics.throwUninitializedPropertyAccessException((String)"CONNECTION_CHECKER_ITEM");
        return null;
    }

    public final void setCONNECTION_CHECKER_ITEM(@NotNull class_1792 class_17922) {
        Intrinsics.checkNotNullParameter((Object)class_17922, (String)"<set-?>");
        CONNECTION_CHECKER_ITEM = class_17922;
    }

    @NotNull
    public final class_1792 getSHIP_CREATOR_ITEM() {
        class_1792 class_17922 = SHIP_CREATOR_ITEM;
        if (class_17922 != null) {
            return class_17922;
        }
        Intrinsics.throwUninitializedPropertyAccessException((String)"SHIP_CREATOR_ITEM");
        return null;
    }

    public final void setSHIP_CREATOR_ITEM(@NotNull class_1792 class_17922) {
        Intrinsics.checkNotNullParameter((Object)class_17922, (String)"<set-?>");
        SHIP_CREATOR_ITEM = class_17922;
    }

    @NotNull
    public final class_1792 getSHIP_ASSEMBLER_ITEM() {
        class_1792 class_17922 = SHIP_ASSEMBLER_ITEM;
        if (class_17922 != null) {
            return class_17922;
        }
        Intrinsics.throwUninitializedPropertyAccessException((String)"SHIP_ASSEMBLER_ITEM");
        return null;
    }

    public final void setSHIP_ASSEMBLER_ITEM(@NotNull class_1792 class_17922) {
        Intrinsics.checkNotNullParameter((Object)class_17922, (String)"<set-?>");
        SHIP_ASSEMBLER_ITEM = class_17922;
    }

    @NotNull
    public final class_1792 getSHIP_CREATOR_ITEM_SMALLER() {
        class_1792 class_17922 = SHIP_CREATOR_ITEM_SMALLER;
        if (class_17922 != null) {
            return class_17922;
        }
        Intrinsics.throwUninitializedPropertyAccessException((String)"SHIP_CREATOR_ITEM_SMALLER");
        return null;
    }

    public final void setSHIP_CREATOR_ITEM_SMALLER(@NotNull class_1792 class_17922) {
        Intrinsics.checkNotNullParameter((Object)class_17922, (String)"<set-?>");
        SHIP_CREATOR_ITEM_SMALLER = class_17922;
    }

    @NotNull
    public final class_1792 getAREA_ASSEMBLER_ITEM() {
        class_1792 class_17922 = AREA_ASSEMBLER_ITEM;
        if (class_17922 != null) {
            return class_17922;
        }
        Intrinsics.throwUninitializedPropertyAccessException((String)"AREA_ASSEMBLER_ITEM");
        return null;
    }

    public final void setAREA_ASSEMBLER_ITEM(@NotNull class_1792 class_17922) {
        Intrinsics.checkNotNullParameter((Object)class_17922, (String)"<set-?>");
        AREA_ASSEMBLER_ITEM = class_17922;
    }

    @NotNull
    public final class_1792 getPHYSICS_ENTITY_CREATOR_ITEM() {
        class_1792 class_17922 = PHYSICS_ENTITY_CREATOR_ITEM;
        if (class_17922 != null) {
            return class_17922;
        }
        Intrinsics.throwUninitializedPropertyAccessException((String)"PHYSICS_ENTITY_CREATOR_ITEM");
        return null;
    }

    public final void setPHYSICS_ENTITY_CREATOR_ITEM(@NotNull class_1792 class_17922) {
        Intrinsics.checkNotNullParameter((Object)class_17922, (String)"<set-?>");
        PHYSICS_ENTITY_CREATOR_ITEM = class_17922;
    }

    @NotNull
    public final class_1299<ShipMountingEntity> getSHIP_MOUNTING_ENTITY_TYPE() {
        class_1299<ShipMountingEntity> class_12992 = SHIP_MOUNTING_ENTITY_TYPE;
        if (class_12992 != null) {
            return class_12992;
        }
        Intrinsics.throwUninitializedPropertyAccessException((String)"SHIP_MOUNTING_ENTITY_TYPE");
        return null;
    }

    public final void setSHIP_MOUNTING_ENTITY_TYPE(@NotNull class_1299<ShipMountingEntity> class_12992) {
        Intrinsics.checkNotNullParameter(class_12992, (String)"<set-?>");
        SHIP_MOUNTING_ENTITY_TYPE = class_12992;
    }

    @NotNull
    public final class_1299<VSPhysicsEntity> getPHYSICS_ENTITY_TYPE() {
        class_1299<VSPhysicsEntity> class_12992 = PHYSICS_ENTITY_TYPE;
        if (class_12992 != null) {
            return class_12992;
        }
        Intrinsics.throwUninitializedPropertyAccessException((String)"PHYSICS_ENTITY_TYPE");
        return null;
    }

    public final void setPHYSICS_ENTITY_TYPE(@NotNull class_1299<VSPhysicsEntity> class_12992) {
        Intrinsics.checkNotNullParameter(class_12992, (String)"<set-?>");
        PHYSICS_ENTITY_TYPE = class_12992;
    }

    @NotNull
    public final class_2591<TestHingeBlockEntity> getTEST_HINGE_BLOCK_ENTITY_TYPE() {
        class_2591<TestHingeBlockEntity> class_25912 = TEST_HINGE_BLOCK_ENTITY_TYPE;
        if (class_25912 != null) {
            return class_25912;
        }
        Intrinsics.throwUninitializedPropertyAccessException((String)"TEST_HINGE_BLOCK_ENTITY_TYPE");
        return null;
    }

    public final void setTEST_HINGE_BLOCK_ENTITY_TYPE(@NotNull class_2591<TestHingeBlockEntity> class_25912) {
        Intrinsics.checkNotNullParameter(class_25912, (String)"<set-?>");
        TEST_HINGE_BLOCK_ENTITY_TYPE = class_25912;
    }

    @NotNull
    public final class_2591<TestThrusterBlockEntity> getTEST_THRUSTER_BLOCK_ENTITY_TYPE() {
        class_2591<TestThrusterBlockEntity> class_25912 = TEST_THRUSTER_BLOCK_ENTITY_TYPE;
        if (class_25912 != null) {
            return class_25912;
        }
        Intrinsics.throwUninitializedPropertyAccessException((String)"TEST_THRUSTER_BLOCK_ENTITY_TYPE");
        return null;
    }

    public final void setTEST_THRUSTER_BLOCK_ENTITY_TYPE(@NotNull class_2591<TestThrusterBlockEntity> class_25912) {
        Intrinsics.checkNotNullParameter(class_25912, (String)"<set-?>");
        TEST_THRUSTER_BLOCK_ENTITY_TYPE = class_25912;
    }

    @NotNull
    public final class_2591<TestAntigravBlockEntity> getTEST_ANTIGRAV_BLOCK_ENTITY_TYPE() {
        class_2591<TestAntigravBlockEntity> class_25912 = TEST_ANTIGRAV_BLOCK_ENTITY_TYPE;
        if (class_25912 != null) {
            return class_25912;
        }
        Intrinsics.throwUninitializedPropertyAccessException((String)"TEST_ANTIGRAV_BLOCK_ENTITY_TYPE");
        return null;
    }

    public final void setTEST_ANTIGRAV_BLOCK_ENTITY_TYPE(@NotNull class_2591<TestAntigravBlockEntity> class_25912) {
        Intrinsics.checkNotNullParameter(class_25912, (String)"<set-?>");
        TEST_ANTIGRAV_BLOCK_ENTITY_TYPE = class_25912;
    }

    public final class_5321<class_1761> getVS_CREATIVE_TAB() {
        return VS_CREATIVE_TAB;
    }

    @NotNull
    public final class_6862<class_2248> getASSEMBLE_BLACKLIST() {
        return ASSEMBLE_BLACKLIST;
    }

    @Nullable
    public static final MinecraftServer getCurrentServer() {
        return currentServer;
    }

    public static final void setCurrentServer(@Nullable MinecraftServer minecraftServer) {
        currentServer = minecraftServer;
    }

    @JvmStatic
    public static /* synthetic */ void getCurrentServer$annotations() {
    }

    @NotNull
    public static final VSCoreProvider getVsCoreProvider() {
        Lazy lazy = vsCoreProvider$delegate;
        Object object = lazy.getValue();
        Intrinsics.checkNotNullExpressionValue((Object)object, (String)"getValue(...)");
        return (VSCoreProvider)object;
    }

    @JvmStatic
    public static /* synthetic */ void getVsCoreProvider$annotations() {
    }

    @NotNull
    public static final VsiCore getVsCore() {
        return vsCore;
    }

    @JvmStatic
    public static /* synthetic */ void getVsCore$annotations() {
    }

    @NotNull
    public static final VsiCoreClient getVsCoreClient() {
        VsiCore vsiCore = vsCore;
        Intrinsics.checkNotNull((Object)vsiCore, (String)"null cannot be cast to non-null type org.valkyrienskies.core.internal.VsiCoreClient");
        return (VsiCoreClient)vsiCore;
    }

    @JvmStatic
    public static /* synthetic */ void getVsCoreClient$annotations() {
    }

    @NotNull
    public static final VsApiImpl getApi() {
        Lazy lazy = api$delegate;
        return (VsApiImpl)lazy.getValue();
    }

    @JvmStatic
    public static /* synthetic */ void getApi$annotations() {
    }

    @NotNull
    public final ConcurrentHashMap<String, ConcurrentHashMap<class_2338, Pair<Long, BlockEntityPhysicsListener>>> getBlockEntityPhysListeners() {
        return blockEntityPhysListeners;
    }

    @NotNull
    public final ConcurrentHashMap<String, ConcurrentHashMap<Integer, EntityPhysicsListener>> getEntityPhysListeners() {
        return entityPhysListeners;
    }

    @NotNull
    public static final SplitHandler getSplitHandler() {
        SplitHandler splitHandler = ValkyrienSkiesMod.splitHandler;
        if (splitHandler != null) {
            return splitHandler;
        }
        Intrinsics.throwUninitializedPropertyAccessException((String)"splitHandler");
        return null;
    }

    public static final void setSplitHandler(@NotNull SplitHandler splitHandler) {
        Intrinsics.checkNotNullParameter((Object)splitHandler, (String)"<set-?>");
        ValkyrienSkiesMod.splitHandler = splitHandler;
    }

    @JvmStatic
    public static /* synthetic */ void getSplitHandler$annotations() {
    }

    public final void init() {
        VsiCore core = vsCore;
        BlockStateInfo.INSTANCE.init();
        VSGamePackets.INSTANCE.register();
        VSGamePackets.INSTANCE.registerHandlers();
        SimpleModule aabbModule = new SimpleModule();
        aabbModule.addSerializer(class_2338.class, new BlockPosSerializer());
        aabbModule.addDeserializer(class_2338.class, new BlockPosDeserializer());
        aabbModule.addKeySerializer(class_2338.class, new BlockPosKeySerializer());
        aabbModule.addKeyDeserializer(class_2338.class, new BlockPosKeyDeserializer());
        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(aabbModule);
        ValkyrienSkiesMod.setSplitHandler(new SplitHandler(vsCore.getHooks().getEnableBlockEdgeConnectivity(), vsCore.getHooks().getEnableBlockCornerConnectivity()));
        core.registerAttachment(ShipSettings.class);
        core.registerAttachment(SeatedControllingPlayer.class, ValkyrienSkiesMod::init$lambda$3);
        core.registerAttachment(SplittingDisablerAttachment.class, ValkyrienSkiesMod::init$lambda$4);
        core.getShipLoadEvent().on(arg_0 -> ValkyrienSkiesMod.init$lambda$6(ValkyrienSkiesMod::init$lambda$5, arg_0));
        core.getPhysTickEvent().on(arg_0 -> ValkyrienSkiesMod.init$lambda$16(ValkyrienSkiesMod::init$lambda$15, arg_0));
        core.getShipUnloadEventClient().on(arg_0 -> ValkyrienSkiesMod.init$lambda$18(ValkyrienSkiesMod::init$lambda$17, arg_0));
    }

    @JvmStatic
    @NotNull
    public static final GameToPhysicsAdapter getOrCreateGTPA(@NotNull String dimensionId) {
        Object object;
        Intrinsics.checkNotNullParameter((Object)dimensionId, (String)"dimensionId");
        Map $this$getOrPut$iv = dimensionalGTPAs;
        boolean $i$f$getOrPut = false;
        Object value$iv = $this$getOrPut$iv.get(dimensionId);
        if (value$iv == null) {
            boolean bl = false;
            GameToPhysicsAdapter answer$iv = new GameToPhysicsAdapter();
            $this$getOrPut$iv.put(dimensionId, answer$iv);
            object = answer$iv;
        } else {
            object = value$iv;
        }
        return (GameToPhysicsAdapter)object;
    }

    public final void addBlockEntityPhysTicker(@NotNull String dimensionId, @NotNull class_2338 pos, @NotNull BlockEntityPhysicsListener blockEntity) {
        Intrinsics.checkNotNullParameter((Object)dimensionId, (String)"dimensionId");
        Intrinsics.checkNotNullParameter((Object)pos, (String)"pos");
        Intrinsics.checkNotNullParameter((Object)blockEntity, (String)"blockEntity");
        class_1937 class_19372 = ((class_2586)blockEntity).method_10997();
        if (class_19372 == null) {
            return;
        }
        class_1937 level = class_19372;
        if (level.field_9236) {
            return;
        }
        Long shipId = null;
        if (!level.field_9236) {
            Ship ship;
            Ship ship2 = ship = ValkyrienSkies.getShipManagingBlock(level, pos);
            shipId = ship2 != null ? Long.valueOf(ship2.getId()) : null;
        }
        ConcurrentMap $this$getOrPut$iv = blockEntityPhysListeners;
        boolean $i$f$getOrPut = false;
        Object object = $this$getOrPut$iv.get(dimensionId);
        if (object == null) {
            boolean bl = false;
            ConcurrentHashMap default$iv = new ConcurrentHashMap();
            boolean bl2 = false;
            object = $this$getOrPut$iv.putIfAbsent(dimensionId, default$iv);
            if (object == null) {
                object = default$iv;
            }
        }
        Intrinsics.checkNotNullExpressionValue(object, (String)"getOrPut(...)");
        Map map2 = (Map)object;
        Pair pair = new Pair((Object)shipId, (Object)blockEntity);
        map2.put(pos, pair);
    }

    @Nullable
    public final BlockEntityPhysicsListener getBlockEntityPhysTicker(@NotNull String dimensionId, @NotNull class_2338 pos) {
        Intrinsics.checkNotNullParameter((Object)dimensionId, (String)"dimensionId");
        Intrinsics.checkNotNullParameter((Object)pos, (String)"pos");
        ConcurrentMap $this$getOrPut$iv = blockEntityPhysListeners;
        boolean $i$f$getOrPut = false;
        Object object = $this$getOrPut$iv.get(dimensionId);
        if (object == null) {
            boolean bl = false;
            ConcurrentHashMap default$iv = new ConcurrentHashMap();
            boolean bl2 = false;
            object = $this$getOrPut$iv.putIfAbsent(dimensionId, default$iv);
            if (object == null) {
                object = default$iv;
            }
        }
        Pair pair = (Pair)((ConcurrentHashMap)object).get(pos);
        return pair != null ? (BlockEntityPhysicsListener)pair.getSecond() : null;
    }

    public final void removeBlockEntityPhysTicker(@NotNull class_2338 pos, @NotNull String dimensionId) {
        Intrinsics.checkNotNullParameter((Object)pos, (String)"pos");
        Intrinsics.checkNotNullParameter((Object)dimensionId, (String)"dimensionId");
        ConcurrentMap $this$getOrPut$iv = blockEntityPhysListeners;
        boolean $i$f$getOrPut = false;
        Object object = $this$getOrPut$iv.get(dimensionId);
        if (object == null) {
            boolean bl = false;
            ConcurrentHashMap default$iv = new ConcurrentHashMap();
            boolean bl2 = false;
            object = $this$getOrPut$iv.putIfAbsent(dimensionId, default$iv);
            if (object == null) {
                object = default$iv;
            }
        }
        ((ConcurrentHashMap)object).remove(pos);
    }

    public final void addEntityPhysTicker(@NotNull String dimensionId, @NotNull class_1297 entity) {
        Intrinsics.checkNotNullParameter((Object)dimensionId, (String)"dimensionId");
        Intrinsics.checkNotNullParameter((Object)entity, (String)"entity");
        if (entity.method_37908() == null || entity.method_37908().field_9236) {
            return;
        }
        ConcurrentMap $this$getOrPut$iv = entityPhysListeners;
        boolean $i$f$getOrPut = false;
        Object object = $this$getOrPut$iv.get(dimensionId);
        if (object == null) {
            boolean bl = false;
            ConcurrentHashMap default$iv = new ConcurrentHashMap();
            boolean bl2 = false;
            object = $this$getOrPut$iv.putIfAbsent(dimensionId, default$iv);
            if (object == null) {
                object = default$iv;
            }
        }
        Intrinsics.checkNotNullExpressionValue(object, (String)"getOrPut(...)");
        Map map2 = (Map)object;
        Integer n2 = entity.method_5628();
        EntityPhysicsListener entityPhysicsListener = (EntityPhysicsListener)entity;
        map2.put(n2, entityPhysicsListener);
    }

    public final void removeEntityPhysTicker(@NotNull class_1297 entity, @NotNull String dimensionId) {
        Intrinsics.checkNotNullParameter((Object)entity, (String)"entity");
        Intrinsics.checkNotNullParameter((Object)dimensionId, (String)"dimensionId");
        ConcurrentMap $this$getOrPut$iv = entityPhysListeners;
        boolean $i$f$getOrPut = false;
        Object object = $this$getOrPut$iv.get(dimensionId);
        if (object == null) {
            boolean bl = false;
            ConcurrentHashMap default$iv = new ConcurrentHashMap();
            boolean bl2 = false;
            object = $this$getOrPut$iv.putIfAbsent(dimensionId, default$iv);
            if (object == null) {
                object = default$iv;
            }
        }
        ((ConcurrentHashMap)object).remove(entity.method_5628());
    }

    @Nullable
    public final EntityPhysicsListener getEntityPhysTicker(@NotNull String dimensionId, int entityId) {
        Intrinsics.checkNotNullParameter((Object)dimensionId, (String)"dimensionId");
        ConcurrentMap $this$getOrPut$iv = entityPhysListeners;
        boolean $i$f$getOrPut = false;
        Object object = $this$getOrPut$iv.get(dimensionId);
        if (object == null) {
            boolean bl = false;
            ConcurrentHashMap default$iv = new ConcurrentHashMap();
            boolean bl2 = false;
            object = $this$getOrPut$iv.putIfAbsent(dimensionId, default$iv);
            if (object == null) {
                object = default$iv;
            }
        }
        return (EntityPhysicsListener)((ConcurrentHashMap)object).get(entityId);
    }

    @Nullable
    public final EntityPhysicsListener getEntityPhysTicker(@NotNull String dimensionId, @NotNull class_1297 entity) {
        Intrinsics.checkNotNullParameter((Object)dimensionId, (String)"dimensionId");
        Intrinsics.checkNotNullParameter((Object)entity, (String)"entity");
        ConcurrentMap $this$getOrPut$iv = entityPhysListeners;
        boolean $i$f$getOrPut = false;
        Object object = $this$getOrPut$iv.get(dimensionId);
        if (object == null) {
            boolean bl = false;
            ConcurrentHashMap default$iv = new ConcurrentHashMap();
            boolean bl2 = false;
            object = $this$getOrPut$iv.putIfAbsent(dimensionId, default$iv);
            if (object == null) {
                object = default$iv;
            }
        }
        return (EntityPhysicsListener)((ConcurrentHashMap)object).get(entity.method_5628());
    }

    private static final IllegalStateException vsCoreProvider_delegate$lambda$1$lambda$0() {
        return new IllegalStateException("No VSCoreProvider implementation found via ServiceLoader!");
    }

    private static final VSCoreProvider vsCoreProvider_delegate$lambda$1() {
        ServiceLoader<VSCoreProvider> loader = ServiceLoader.load(VSCoreProvider.class, VSCoreProvider.class.getClassLoader());
        return loader.findFirst().orElseThrow(ValkyrienSkiesMod::vsCoreProvider_delegate$lambda$1$lambda$0);
    }

    private static final VsApiImpl api_delegate$lambda$2() {
        return new VsApiImpl(vsCore);
    }

    private static final Unit init$lambda$3(AttachmentRegistration.Builder $this$registerAttachment) {
        Intrinsics.checkNotNullParameter((Object)$this$registerAttachment, (String)"$this$registerAttachment");
        $this$registerAttachment.useLegacySerializer();
        return Unit.INSTANCE;
    }

    private static final Unit init$lambda$4(AttachmentRegistration.Builder $this$registerAttachment) {
        Intrinsics.checkNotNullParameter((Object)$this$registerAttachment, (String)"$this$registerAttachment");
        $this$registerAttachment.useLegacySerializer();
        return Unit.INSTANCE;
    }

    private static final Unit init$lambda$5(ShipLoadEvent event) {
        Intrinsics.checkNotNullParameter((Object)event, (String)"event");
        event.getShip().setAttachment(new SplittingDisablerAttachment(false));
        return Unit.INSTANCE;
    }

    private static final void init$lambda$6(Function1 $tmp0, Object p0) {
        Intrinsics.checkNotNullParameter((Object)$tmp0, (String)"$tmp0");
        $tmp0.invoke(p0);
    }

    private static final Unit init$lambda$15$lambda$7(PhysTickEvent $event, String dimensionId, GameToPhysicsAdapter gameTickForceApplier) {
        Intrinsics.checkNotNullParameter((Object)$event, (String)"$event");
        Intrinsics.checkNotNullParameter((Object)dimensionId, (String)"dimensionId");
        Intrinsics.checkNotNullParameter((Object)gameTickForceApplier, (String)"gameTickForceApplier");
        if (Intrinsics.areEqual((Object)$event.getWorld().getDimension(), (Object)dimensionId)) {
            gameTickForceApplier.physTick($event.getWorld(), $event.getDelta());
        }
        return Unit.INSTANCE;
    }

    private static final void init$lambda$15$lambda$8(Function2 $tmp0, Object p0, Object p1) {
        Intrinsics.checkNotNullParameter((Object)$tmp0, (String)"$tmp0");
        $tmp0.invoke(p0, p1);
    }

    private static final Unit init$lambda$15$lambda$10(PhysTickEvent $event, class_2338 pos, Pair infoPair) {
        Intrinsics.checkNotNullParameter((Object)$event, (String)"$event");
        Intrinsics.checkNotNullParameter((Object)pos, (String)"pos");
        Intrinsics.checkNotNullParameter((Object)infoPair, (String)"infoPair");
        Long shipId = (Long)infoPair.getFirst();
        BlockEntityPhysicsListener listener = (BlockEntityPhysicsListener)infoPair.getSecond();
        PhysShip ship = shipId != null ? $event.getWorld().getShipById(shipId) : null;
        listener.physTick(ship, $event.getWorld());
        return Unit.INSTANCE;
    }

    private static final void init$lambda$15$lambda$11(Function2 $tmp0, Object p0, Object p1) {
        Intrinsics.checkNotNullParameter((Object)$tmp0, (String)"$tmp0");
        $tmp0.invoke(p0, p1);
    }

    private static final Unit init$lambda$15$lambda$13(PhysTickEvent $event, Integer n2, EntityPhysicsListener listener) {
        Intrinsics.checkNotNullParameter((Object)$event, (String)"$event");
        Intrinsics.checkNotNullParameter((Object)n2, (String)"<unused var>");
        Intrinsics.checkNotNullParameter((Object)listener, (String)"listener");
        listener.physTick($event.getWorld());
        return Unit.INSTANCE;
    }

    private static final void init$lambda$15$lambda$14(Function2 $tmp0, Object p0, Object p1) {
        Intrinsics.checkNotNullParameter((Object)$tmp0, (String)"$tmp0");
        $tmp0.invoke(p0, p1);
    }

    private static final Unit init$lambda$15(PhysTickEvent event) {
        boolean bl;
        ConcurrentHashMap default$iv;
        ConcurrentMap $this$getOrPut$iv;
        Intrinsics.checkNotNullParameter((Object)event, (String)"event");
        dimensionalGTPAs.forEach((arg_0, arg_1) -> ValkyrienSkiesMod.init$lambda$15$lambda$8((arg_0, arg_1) -> ValkyrienSkiesMod.init$lambda$15$lambda$7(event, arg_0, arg_1), arg_0, arg_1));
        ConcurrentMap concurrentMap = blockEntityPhysListeners;
        String key$iv = event.getWorld().getDimension();
        boolean $i$f$getOrPut = false;
        Object object = $this$getOrPut$iv.get(key$iv);
        if (object == null) {
            boolean bl2 = false;
            default$iv = new ConcurrentHashMap();
            bl = false;
            object = $this$getOrPut$iv.putIfAbsent(key$iv, default$iv);
            if (object == null) {
                object = default$iv;
            }
        }
        ((ConcurrentHashMap)object).forEach((arg_0, arg_1) -> ValkyrienSkiesMod.init$lambda$15$lambda$11((arg_0, arg_1) -> ValkyrienSkiesMod.init$lambda$15$lambda$10(event, arg_0, arg_1), arg_0, arg_1));
        $this$getOrPut$iv = entityPhysListeners;
        key$iv = event.getWorld().getDimension();
        $i$f$getOrPut = false;
        Object object2 = $this$getOrPut$iv.get(key$iv);
        if (object2 == null) {
            boolean bl3 = false;
            default$iv = new ConcurrentHashMap();
            bl = false;
            object2 = $this$getOrPut$iv.putIfAbsent(key$iv, default$iv);
            if (object2 == null) {
                object2 = default$iv;
            }
        }
        ((ConcurrentHashMap)object2).forEach((arg_0, arg_1) -> ValkyrienSkiesMod.init$lambda$15$lambda$14((arg_0, arg_1) -> ValkyrienSkiesMod.init$lambda$15$lambda$13(event, arg_0, arg_1), arg_0, arg_1));
        return Unit.INSTANCE;
    }

    private static final void init$lambda$16(Function1 $tmp0, Object p0) {
        Intrinsics.checkNotNullParameter((Object)$tmp0, (String)"$tmp0");
        $tmp0.invoke(p0);
    }

    private static final Unit init$lambda$17(ShipUnloadEventClient event) {
        Intrinsics.checkNotNullParameter((Object)event, (String)"event");
        class_638 level = class_310.method_1551().field_1687;
        if (level != null) {
            class_631 class_6312 = level.method_2935();
            Intrinsics.checkNotNull((Object)class_6312, (String)"null cannot be cast to non-null type org.valkyrienskies.mod.mixinducks.client.world.ClientChunkCacheDuck");
            ((ClientChunkCacheDuck)class_6312).vs$removeShip(event.getShip());
        }
        return Unit.INSTANCE;
    }

    private static final void init$lambda$18(Function1 $tmp0, Object p0) {
        Intrinsics.checkNotNullParameter((Object)$tmp0, (String)"$tmp0");
        $tmp0.invoke(p0);
    }

    static {
        dimensionalGTPAs = new HashMap();
        VS_CREATIVE_TAB = class_5321.method_29179((class_5321)class_7924.field_44688, (class_2960)new class_2960(MOD_ID));
        class_6862 class_68622 = class_6862.method_40092((class_5321)class_7924.field_41254, (class_2960)new class_2960(MOD_ID, "assemble_blacklist"));
        Intrinsics.checkNotNullExpressionValue((Object)class_68622, (String)"create(...)");
        ASSEMBLE_BLACKLIST = class_68622;
        vsCoreProvider$delegate = LazyKt.lazy(ValkyrienSkiesMod::vsCoreProvider_delegate$lambda$1);
        vsCore = ValkyrienSkiesMod.getVsCoreProvider().newVSCore();
        api$delegate = LazyKt.lazy(ValkyrienSkiesMod::api_delegate$lambda$2);
        blockEntityPhysListeners = new ConcurrentHashMap();
        entityPhysListeners = new ConcurrentHashMap();
    }
}

