/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.common.collect.BiMap
 *  kotlin.Metadata
 *  kotlin.Pair
 *  kotlin.TuplesKt
 *  kotlin.collections.MapsKt
 *  kotlin.enums.EnumEntries
 *  kotlin.enums.EnumEntriesKt
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  net.fabricmc.fabric.api.item.v1.FabricItemSettings
 *  net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings
 *  net.minecraft.class_1269
 *  net.minecraft.class_1297
 *  net.minecraft.class_1299
 *  net.minecraft.class_1308
 *  net.minecraft.class_1657
 *  net.minecraft.class_1738
 *  net.minecraft.class_1738$class_8051
 *  net.minecraft.class_1741
 *  net.minecraft.class_1747
 *  net.minecraft.class_1792
 *  net.minecraft.class_1792$class_1793
 *  net.minecraft.class_1799
 *  net.minecraft.class_1802
 *  net.minecraft.class_1826
 *  net.minecraft.class_1838
 *  net.minecraft.class_1922
 *  net.minecraft.class_1935
 *  net.minecraft.class_1937
 *  net.minecraft.class_2246
 *  net.minecraft.class_2248
 *  net.minecraft.class_2338
 *  net.minecraft.class_2350
 *  net.minecraft.class_2378
 *  net.minecraft.class_2397
 *  net.minecraft.class_2487
 *  net.minecraft.class_2498
 *  net.minecraft.class_2680
 *  net.minecraft.class_2960
 *  net.minecraft.class_3218
 *  net.minecraft.class_3417
 *  net.minecraft.class_3419
 *  net.minecraft.class_3730
 *  net.minecraft.class_3749
 *  net.minecraft.class_4970
 *  net.minecraft.class_4970$class_2250
 *  net.minecraft.class_4970$class_2251
 *  net.minecraft.class_5712
 *  net.minecraft.class_5778
 *  net.minecraft.class_5819
 *  net.minecraft.class_5953
 *  net.minecraft.class_5955
 *  net.minecraft.class_7118
 *  net.minecraft.class_7923
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package dev.mim1q.derelict.init;

import com.google.common.collect.BiMap;
import dev.mim1q.derelict.Derelict;
import dev.mim1q.derelict.block.EmbersBlock;
import dev.mim1q.derelict.block.SmolderingLeavesBlock;
import dev.mim1q.derelict.block.cobweb.FancyCobwebBlock;
import dev.mim1q.derelict.block.cobweb.FancyCobwebWithSpiderNestBlock;
import dev.mim1q.derelict.block.cobweb.FancyCornerCobwebBlock;
import dev.mim1q.derelict.block.cobweb.SpiderEggBlock;
import dev.mim1q.derelict.block.cobweb.SpiderMoltBlock;
import dev.mim1q.derelict.block.cobweb.SpiderSilkBlock;
import dev.mim1q.derelict.block.cobweb.SpiderSilkStrandBlock;
import dev.mim1q.derelict.block.flickering.ExtinguishedEndRodBlock;
import dev.mim1q.derelict.block.flickering.FlickeringCarvedPumpkinBlock;
import dev.mim1q.derelict.block.flickering.FlickeringEndRodBlock;
import dev.mim1q.derelict.block.flickering.FlickeringLanternBlock;
import dev.mim1q.derelict.block.flickering.FlickeringSolidBlock;
import dev.mim1q.derelict.entity.SpiderlingEntity;
import dev.mim1q.derelict.featureset.CoverBoardsSet;
import dev.mim1q.derelict.featureset.GrassSet;
import dev.mim1q.derelict.featureset.MetalSet;
import dev.mim1q.derelict.featureset.StoneSet;
import dev.mim1q.derelict.featureset.WoodSet;
import dev.mim1q.derelict.init.ModEntities;
import dev.mim1q.derelict.interfaces.AbstractBlockAccessor;
import dev.mim1q.derelict.item.StaffItem;
import dev.mim1q.derelict.item.armor.ModArmorMaterials;
import dev.mim1q.derelict.item.weapon.Arachnicannon;
import dev.mim1q.derelict.item.weapon.SpiderSilkBola;
import dev.mim1q.derelict.item.weapon.Wildfire;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.class_1269;
import net.minecraft.class_1297;
import net.minecraft.class_1299;
import net.minecraft.class_1308;
import net.minecraft.class_1657;
import net.minecraft.class_1738;
import net.minecraft.class_1741;
import net.minecraft.class_1747;
import net.minecraft.class_1792;
import net.minecraft.class_1799;
import net.minecraft.class_1802;
import net.minecraft.class_1826;
import net.minecraft.class_1838;
import net.minecraft.class_1922;
import net.minecraft.class_1935;
import net.minecraft.class_1937;
import net.minecraft.class_2246;
import net.minecraft.class_2248;
import net.minecraft.class_2338;
import net.minecraft.class_2350;
import net.minecraft.class_2378;
import net.minecraft.class_2397;
import net.minecraft.class_2487;
import net.minecraft.class_2498;
import net.minecraft.class_2680;
import net.minecraft.class_2960;
import net.minecraft.class_3218;
import net.minecraft.class_3417;
import net.minecraft.class_3419;
import net.minecraft.class_3730;
import net.minecraft.class_3749;
import net.minecraft.class_4970;
import net.minecraft.class_5712;
import net.minecraft.class_5778;
import net.minecraft.class_5819;
import net.minecraft.class_5953;
import net.minecraft.class_5955;
import net.minecraft.class_7118;
import net.minecraft.class_7923;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000\u00c4\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010#\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u001a\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010$\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0016\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0002\u009a\u0002B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\u0005\u001a\u00020\u0004\u00a2\u0006\u0004\b\u0005\u0010\u0003J\r\u0010\u0006\u001a\u00020\u0004\u00a2\u0006\u0004\b\u0006\u0010\u0003J3\u0010\u0010\u001a\u00028\u0000\"\b\b\u0000\u0010\b*\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00028\u00002\b\b\u0002\u0010\r\u001a\u00020\fH\u0000\u00a2\u0006\u0004\b\u000e\u0010\u000fJ)\u0010\u0013\u001a\u00028\u0000\"\b\b\u0000\u0010\b*\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00028\u0000H\u0000\u00a2\u0006\u0004\b\u0011\u0010\u0012J5\u0010\u0018\u001a\u00028\u0000\"\b\b\u0000\u0010\b*\u00020\u00142\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u0015\u001a\u00028\u00002\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\fH\u0000\u00a2\u0006\u0004\b\u0016\u0010\u0017J\u0017\u0010\u001b\u001a\u00020\u00142\u0006\u0010\n\u001a\u00020\tH\u0000\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\u000f\u0010\u001d\u001a\u00020\u001cH\u0002\u00a2\u0006\u0004\b\u001d\u0010\u001eJ\u001f\u0010#\u001a\u00020\"2\u000e\u0010!\u001a\n\u0012\u0006\b\u0001\u0012\u00020 0\u001fH\u0002\u00a2\u0006\u0004\b#\u0010$R\u001a\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00070%8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b&\u0010'R\u001a\u0010(\u001a\b\u0012\u0004\u0012\u00020\u00070%8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b(\u0010'R\u0017\u0010*\u001a\u00020)8\u0006\u00a2\u0006\f\n\u0004\b*\u0010+\u001a\u0004\b,\u0010-R\u0017\u0010/\u001a\u00020.8\u0006\u00a2\u0006\f\n\u0004\b/\u00100\u001a\u0004\b1\u00102R\u0017\u00104\u001a\u0002038\u0006\u00a2\u0006\f\n\u0004\b4\u00105\u001a\u0004\b6\u00107R\u0017\u00109\u001a\u0002088\u0006\u00a2\u0006\f\n\u0004\b9\u0010:\u001a\u0004\b;\u0010<R\u0017\u0010>\u001a\u00020=8\u0006\u00a2\u0006\f\n\u0004\b>\u0010?\u001a\u0004\b@\u0010AR\u0017\u0010C\u001a\u00020B8\u0006\u00a2\u0006\f\n\u0004\bC\u0010D\u001a\u0004\bE\u0010FR\u0017\u0010H\u001a\u00020G8\u0006\u00a2\u0006\f\n\u0004\bH\u0010I\u001a\u0004\bJ\u0010KR\u0017\u0010M\u001a\u00020L8\u0006\u00a2\u0006\f\n\u0004\bM\u0010N\u001a\u0004\bO\u0010PR\u0017\u0010Q\u001a\u00020L8\u0006\u00a2\u0006\f\n\u0004\bQ\u0010N\u001a\u0004\bR\u0010PR\u0017\u0010T\u001a\u00020S8\u0006\u00a2\u0006\f\n\u0004\bT\u0010U\u001a\u0004\bV\u0010WR\u0017\u0010X\u001a\u00020S8\u0006\u00a2\u0006\f\n\u0004\bX\u0010U\u001a\u0004\bY\u0010WR\u0017\u0010Z\u001a\u00020S8\u0006\u00a2\u0006\f\n\u0004\bZ\u0010U\u001a\u0004\b[\u0010WR\u0017\u0010\\\u001a\u00020S8\u0006\u00a2\u0006\f\n\u0004\b\\\u0010U\u001a\u0004\b]\u0010WR\u0017\u0010^\u001a\u00020S8\u0006\u00a2\u0006\f\n\u0004\b^\u0010U\u001a\u0004\b_\u0010WR\u0017\u0010`\u001a\u00020S8\u0006\u00a2\u0006\f\n\u0004\b`\u0010U\u001a\u0004\ba\u0010WR\u0017\u0010b\u001a\u00020S8\u0006\u00a2\u0006\f\n\u0004\bb\u0010U\u001a\u0004\bc\u0010WR\u0017\u0010d\u001a\u00020S8\u0006\u00a2\u0006\f\n\u0004\bd\u0010U\u001a\u0004\be\u0010WR\u0017\u0010f\u001a\u00020S8\u0006\u00a2\u0006\f\n\u0004\bf\u0010U\u001a\u0004\bg\u0010WR\u0017\u0010h\u001a\u00020S8\u0006\u00a2\u0006\f\n\u0004\bh\u0010U\u001a\u0004\bi\u0010WR\u0017\u0010j\u001a\u00020S8\u0006\u00a2\u0006\f\n\u0004\bj\u0010U\u001a\u0004\bk\u0010WR\u0017\u0010l\u001a\u00020S8\u0006\u00a2\u0006\f\n\u0004\bl\u0010U\u001a\u0004\bm\u0010WR\u0017\u0010o\u001a\u00020n8\u0006\u00a2\u0006\f\n\u0004\bo\u0010p\u001a\u0004\bq\u0010rR\u0017\u0010s\u001a\u00020n8\u0006\u00a2\u0006\f\n\u0004\bs\u0010p\u001a\u0004\bt\u0010rR\u0017\u0010u\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\bu\u0010v\u001a\u0004\bw\u0010xR\u0017\u0010z\u001a\u00020y8\u0006\u00a2\u0006\f\n\u0004\bz\u0010{\u001a\u0004\b|\u0010}R\u001a\u0010\u007f\u001a\u00020~8\u0006\u00a2\u0006\u000f\n\u0005\b\u007f\u0010\u0080\u0001\u001a\u0006\b\u0081\u0001\u0010\u0082\u0001R\u001c\u0010\u0083\u0001\u001a\u00020~8\u0006\u00a2\u0006\u0010\n\u0006\b\u0083\u0001\u0010\u0080\u0001\u001a\u0006\b\u0084\u0001\u0010\u0082\u0001R\u001d\u0010\u0086\u0001\u001a\u00030\u0085\u00018\u0006\u00a2\u0006\u0010\n\u0006\b\u0086\u0001\u0010\u0087\u0001\u001a\u0006\b\u0088\u0001\u0010\u0089\u0001R\u001a\u0010\u008a\u0001\u001a\u00020n8\u0006\u00a2\u0006\u000e\n\u0005\b\u008a\u0001\u0010p\u001a\u0005\b\u008b\u0001\u0010rR\u001a\u0010\u008c\u0001\u001a\u00020\u00078\u0006\u00a2\u0006\u000e\n\u0005\b\u008c\u0001\u0010v\u001a\u0005\b\u008d\u0001\u0010xR\u001a\u0010\u008e\u0001\u001a\u00020n8\u0006\u00a2\u0006\u000e\n\u0005\b\u008e\u0001\u0010p\u001a\u0005\b\u008f\u0001\u0010rR\u001a\u0010\u0090\u0001\u001a\u00020\u00078\u0006\u00a2\u0006\u000e\n\u0005\b\u0090\u0001\u0010v\u001a\u0005\b\u0091\u0001\u0010xR\u001a\u0010\u0092\u0001\u001a\u00020n8\u0006\u00a2\u0006\u000e\n\u0005\b\u0092\u0001\u0010p\u001a\u0005\b\u0093\u0001\u0010rR\u001a\u0010\u0094\u0001\u001a\u00020\u00078\u0006\u00a2\u0006\u000e\n\u0005\b\u0094\u0001\u0010v\u001a\u0005\b\u0095\u0001\u0010xR\u001a\u0010\u0096\u0001\u001a\u00020n8\u0006\u00a2\u0006\u000e\n\u0005\b\u0096\u0001\u0010p\u001a\u0005\b\u0097\u0001\u0010rR\u001a\u0010\u0098\u0001\u001a\u00020\u00078\u0006\u00a2\u0006\u000e\n\u0005\b\u0098\u0001\u0010v\u001a\u0005\b\u0099\u0001\u0010xR\u001a\u0010\u009a\u0001\u001a\u00020n8\u0006\u00a2\u0006\u000e\n\u0005\b\u009a\u0001\u0010p\u001a\u0005\b\u009b\u0001\u0010rR\u001a\u0010\u009c\u0001\u001a\u00020\u00078\u0006\u00a2\u0006\u000e\n\u0005\b\u009c\u0001\u0010v\u001a\u0005\b\u009d\u0001\u0010xR\u001d\u0010\u009f\u0001\u001a\u00030\u009e\u00018\u0006\u00a2\u0006\u0010\n\u0006\b\u009f\u0001\u0010\u00a0\u0001\u001a\u0006\b\u00a1\u0001\u0010\u00a2\u0001R\u001d\u0010\u00a4\u0001\u001a\u00030\u00a3\u00018\u0006\u00a2\u0006\u0010\n\u0006\b\u00a4\u0001\u0010\u00a5\u0001\u001a\u0006\b\u00a6\u0001\u0010\u00a7\u0001R\u001d\u0010\u00a9\u0001\u001a\u00030\u00a8\u00018\u0006\u00a2\u0006\u0010\n\u0006\b\u00a9\u0001\u0010\u00aa\u0001\u001a\u0006\b\u00ab\u0001\u0010\u00ac\u0001R\u001d\u0010\u00ae\u0001\u001a\u00030\u00ad\u00018\u0006\u00a2\u0006\u0010\n\u0006\b\u00ae\u0001\u0010\u00af\u0001\u001a\u0006\b\u00b0\u0001\u0010\u00b1\u0001R\u001d\u0010\u00b3\u0001\u001a\u00030\u00b2\u00018\u0006\u00a2\u0006\u0010\n\u0006\b\u00b3\u0001\u0010\u00b4\u0001\u001a\u0006\b\u00b5\u0001\u0010\u00b6\u0001R\u001d\u0010\u00b7\u0001\u001a\u00030\u00b2\u00018\u0006\u00a2\u0006\u0010\n\u0006\b\u00b7\u0001\u0010\u00b4\u0001\u001a\u0006\b\u00b8\u0001\u0010\u00b6\u0001R\u001d\u0010\u00ba\u0001\u001a\u00030\u00b9\u00018\u0006\u00a2\u0006\u0010\n\u0006\b\u00ba\u0001\u0010\u00bb\u0001\u001a\u0006\b\u00bc\u0001\u0010\u00bd\u0001R\u001d\u0010\u00bf\u0001\u001a\u00030\u00be\u00018\u0006\u00a2\u0006\u0010\n\u0006\b\u00bf\u0001\u0010\u00c0\u0001\u001a\u0006\b\u00c1\u0001\u0010\u00c2\u0001R\u001d\u0010\u00c4\u0001\u001a\u00030\u00c3\u00018\u0006\u00a2\u0006\u0010\n\u0006\b\u00c4\u0001\u0010\u00c5\u0001\u001a\u0006\b\u00c6\u0001\u0010\u00c7\u0001R\u001a\u0010\u00c8\u0001\u001a\u00020\u00078\u0006\u00a2\u0006\u000e\n\u0005\b\u00c8\u0001\u0010v\u001a\u0005\b\u00c9\u0001\u0010xR\u001d\u0010\u00cb\u0001\u001a\u00030\u00ca\u00018\u0006\u00a2\u0006\u0010\n\u0006\b\u00cb\u0001\u0010\u00cc\u0001\u001a\u0006\b\u00cd\u0001\u0010\u00ce\u0001R\u001d\u0010\u00cf\u0001\u001a\u00030\u00ca\u00018\u0006\u00a2\u0006\u0010\n\u0006\b\u00cf\u0001\u0010\u00cc\u0001\u001a\u0006\b\u00d0\u0001\u0010\u00ce\u0001R\u001d\u0010\u00d1\u0001\u001a\u00030\u00ca\u00018\u0006\u00a2\u0006\u0010\n\u0006\b\u00d1\u0001\u0010\u00cc\u0001\u001a\u0006\b\u00d2\u0001\u0010\u00ce\u0001R\u001d\u0010\u00d3\u0001\u001a\u00030\u00ca\u00018\u0006\u00a2\u0006\u0010\n\u0006\b\u00d3\u0001\u0010\u00cc\u0001\u001a\u0006\b\u00d4\u0001\u0010\u00ce\u0001R\u001d\u0010\u00d5\u0001\u001a\u00030\u00ca\u00018\u0006\u00a2\u0006\u0010\n\u0006\b\u00d5\u0001\u0010\u00cc\u0001\u001a\u0006\b\u00d6\u0001\u0010\u00ce\u0001R\u001d\u0010\u00d7\u0001\u001a\u00030\u00ca\u00018\u0006\u00a2\u0006\u0010\n\u0006\b\u00d7\u0001\u0010\u00cc\u0001\u001a\u0006\b\u00d8\u0001\u0010\u00ce\u0001R\u001d\u0010\u00d9\u0001\u001a\u00030\u00ca\u00018\u0006\u00a2\u0006\u0010\n\u0006\b\u00d9\u0001\u0010\u00cc\u0001\u001a\u0006\b\u00da\u0001\u0010\u00ce\u0001R\u001d\u0010\u00db\u0001\u001a\u00030\u00ca\u00018\u0006\u00a2\u0006\u0010\n\u0006\b\u00db\u0001\u0010\u00cc\u0001\u001a\u0006\b\u00dc\u0001\u0010\u00ce\u0001R\u001d\u0010\u00de\u0001\u001a\u00030\u00dd\u00018\u0006\u00a2\u0006\u0010\n\u0006\b\u00de\u0001\u0010\u00df\u0001\u001a\u0006\b\u00e0\u0001\u0010\u00e1\u0001R\u001d\u0010\u00e3\u0001\u001a\u00030\u00e2\u00018\u0006\u00a2\u0006\u0010\n\u0006\b\u00e3\u0001\u0010\u00e4\u0001\u001a\u0006\b\u00e5\u0001\u0010\u00e6\u0001R\u001d\u0010\u00e8\u0001\u001a\u00030\u00e7\u00018\u0006\u00a2\u0006\u0010\n\u0006\b\u00e8\u0001\u0010\u00e9\u0001\u001a\u0006\b\u00ea\u0001\u0010\u00eb\u0001R\u001c\u0010\u00ec\u0001\u001a\u00020\u00148\u0006\u00a2\u0006\u0010\n\u0006\b\u00ec\u0001\u0010\u00ed\u0001\u001a\u0006\b\u00ee\u0001\u0010\u00ef\u0001R2\u0010\u00f2\u0001\u001a\u0018\u0012\r\u0012\u000b \u00f1\u0001*\u0004\u0018\u00010\u00070\u0007\u0012\u0004\u0012\u00020\u00070\u00f0\u00018\u0006\u00a2\u0006\u0010\n\u0006\b\u00f2\u0001\u0010\u00f3\u0001\u001a\u0006\b\u00f4\u0001\u0010\u00f5\u0001R\u001d\u0010\u00f7\u0001\u001a\u00030\u00f6\u00018\u0006\u00a2\u0006\u0010\n\u0006\b\u00f7\u0001\u0010\u00f8\u0001\u001a\u0006\b\u00f9\u0001\u0010\u00fa\u0001R\u001d\u0010\u00fc\u0001\u001a\u00030\u00fb\u00018\u0006\u00a2\u0006\u0010\n\u0006\b\u00fc\u0001\u0010\u00fd\u0001\u001a\u0006\b\u00fe\u0001\u0010\u00ff\u0001R\u001d\u0010\u0081\u0002\u001a\u00030\u0080\u00028\u0006\u00a2\u0006\u0010\n\u0006\b\u0081\u0002\u0010\u0082\u0002\u001a\u0006\b\u0083\u0002\u0010\u0084\u0002R\u001d\u0010\u0086\u0002\u001a\u00030\u0085\u00028\u0006\u00a2\u0006\u0010\n\u0006\b\u0086\u0002\u0010\u0087\u0002\u001a\u0006\b\u0088\u0002\u0010\u0089\u0002R\u001c\u0010\u008a\u0002\u001a\u00020\u00148\u0006\u00a2\u0006\u0010\n\u0006\b\u008a\u0002\u0010\u00ed\u0001\u001a\u0006\b\u008b\u0002\u0010\u00ef\u0001R\u001c\u0010\u008c\u0002\u001a\u00020\u00148\u0006\u00a2\u0006\u0010\n\u0006\b\u008c\u0002\u0010\u00ed\u0001\u001a\u0006\b\u008d\u0002\u0010\u00ef\u0001R\u001c\u0010\u008e\u0002\u001a\u00020\"8\u0006\u00a2\u0006\u0010\n\u0006\b\u008e\u0002\u0010\u008f\u0002\u001a\u0006\b\u0090\u0002\u0010\u0091\u0002R\u001c\u0010\u0092\u0002\u001a\u00020\"8\u0006\u00a2\u0006\u0010\n\u0006\b\u0092\u0002\u0010\u008f\u0002\u001a\u0006\b\u0093\u0002\u0010\u0091\u0002R\u001c\u0010\u0094\u0002\u001a\u00020\"8\u0006\u00a2\u0006\u0010\n\u0006\b\u0094\u0002\u0010\u008f\u0002\u001a\u0006\b\u0095\u0002\u0010\u0091\u0002R\u001c\u0010\u0096\u0002\u001a\u00020\"8\u0006\u00a2\u0006\u0010\n\u0006\b\u0096\u0002\u0010\u008f\u0002\u001a\u0006\b\u0097\u0002\u0010\u0091\u0002R\u001c\u0010\u0098\u0002\u001a\u00020\"8\u0006\u00a2\u0006\u0010\n\u0006\b\u0098\u0002\u0010\u008f\u0002\u001a\u0006\b\u0099\u0002\u0010\u0091\u0002\u00a8\u0006\u009b\u0002"}, d2={"Ldev/mim1q/derelict/init/ModBlocksAndItems;", "", "<init>", "()V", "", "init", "setupWaxableAndAgeable", "Lnet/minecraft/class_2248;", "T", "", "name", "block", "Ldev/mim1q/derelict/init/ModBlocksAndItems$ItemCategory;", "category", "register$derelict", "(Ljava/lang/String;Lnet/minecraft/class_2248;Ldev/mim1q/derelict/init/ModBlocksAndItems$ItemCategory;)Lnet/minecraft/class_2248;", "register", "registerBlock$derelict", "(Ljava/lang/String;Lnet/minecraft/class_2248;)Lnet/minecraft/class_2248;", "registerBlock", "Lnet/minecraft/class_1792;", "item", "registerItem$derelict", "(Ljava/lang/String;Lnet/minecraft/class_1792;Ldev/mim1q/derelict/init/ModBlocksAndItems$ItemCategory;)Lnet/minecraft/class_1792;", "registerItem", "registerSimpleItem$derelict", "(Ljava/lang/String;)Lnet/minecraft/class_1792;", "registerSimpleItem", "Lnet/fabricmc/fabric/api/item/v1/FabricItemSettings;", "defaultItemSettings", "()Lnet/fabricmc/fabric/api/item/v1/FabricItemSettings;", "Lnet/minecraft/class_1299;", "Lnet/minecraft/class_1308;", "entity", "Lnet/minecraft/class_1826;", "registerSpawnEgg", "(Lnet/minecraft/class_1299;)Lnet/minecraft/class_1826;", "", "lastAgeable", "Ljava/util/Set;", "lastWaxable", "Ldev/mim1q/derelict/item/StaffItem$Aging;", "AGING_STAFF", "Ldev/mim1q/derelict/item/StaffItem$Aging;", "getAGING_STAFF", "()Ldev/mim1q/derelict/item/StaffItem$Aging;", "Ldev/mim1q/derelict/item/StaffItem$Waxing;", "WAXING_STAFF", "Ldev/mim1q/derelict/item/StaffItem$Waxing;", "getWAXING_STAFF", "()Ldev/mim1q/derelict/item/StaffItem$Waxing;", "Ldev/mim1q/derelict/featureset/WoodSet;", "BURNED_WOOD", "Ldev/mim1q/derelict/featureset/WoodSet;", "getBURNED_WOOD", "()Ldev/mim1q/derelict/featureset/WoodSet;", "Lnet/minecraft/class_2397;", "BURNED_LEAVES", "Lnet/minecraft/class_2397;", "getBURNED_LEAVES", "()Lnet/minecraft/class_2397;", "Ldev/mim1q/derelict/block/SmolderingLeavesBlock;", "SMOLDERING_LEAVES", "Ldev/mim1q/derelict/block/SmolderingLeavesBlock;", "getSMOLDERING_LEAVES", "()Ldev/mim1q/derelict/block/SmolderingLeavesBlock;", "Ldev/mim1q/derelict/block/EmbersBlock$Smoking;", "SMOKING_EMBERS", "Ldev/mim1q/derelict/block/EmbersBlock$Smoking;", "getSMOKING_EMBERS", "()Ldev/mim1q/derelict/block/EmbersBlock$Smoking;", "Ldev/mim1q/derelict/block/EmbersBlock$Smoldering;", "SMOLDERING_EMBERS", "Ldev/mim1q/derelict/block/EmbersBlock$Smoldering;", "getSMOLDERING_EMBERS", "()Ldev/mim1q/derelict/block/EmbersBlock$Smoldering;", "Ldev/mim1q/derelict/featureset/GrassSet;", "DRIED_GRASS", "Ldev/mim1q/derelict/featureset/GrassSet;", "getDRIED_GRASS", "()Ldev/mim1q/derelict/featureset/GrassSet;", "BURNED_GRASS", "getBURNED_GRASS", "Ldev/mim1q/derelict/featureset/CoverBoardsSet;", "OAK_COVER_BOARDS", "Ldev/mim1q/derelict/featureset/CoverBoardsSet;", "getOAK_COVER_BOARDS", "()Ldev/mim1q/derelict/featureset/CoverBoardsSet;", "SPRUCE_COVER_BOARDS", "getSPRUCE_COVER_BOARDS", "BIRCH_COVER_BOARDS", "getBIRCH_COVER_BOARDS", "JUNGLE_COVER_BOARDS", "getJUNGLE_COVER_BOARDS", "ACACIA_COVER_BOARDS", "getACACIA_COVER_BOARDS", "DARK_OAK_COVER_BOARDS", "getDARK_OAK_COVER_BOARDS", "MANGROVE_COVER_BOARDS", "getMANGROVE_COVER_BOARDS", "CHERRY_COVER_BOARDS", "getCHERRY_COVER_BOARDS", "BAMBOO_COVER_BOARD", "getBAMBOO_COVER_BOARD", "WARPED_COVER_BOARDS", "getWARPED_COVER_BOARDS", "CRIMSON_COVER_BOARDS", "getCRIMSON_COVER_BOARDS", "BURNED_COVER_BOARDS", "getBURNED_COVER_BOARDS", "Ldev/mim1q/derelict/block/flickering/FlickeringSolidBlock;", "FLICKERING_REDSTONE_LAMP", "Ldev/mim1q/derelict/block/flickering/FlickeringSolidBlock;", "getFLICKERING_REDSTONE_LAMP", "()Ldev/mim1q/derelict/block/flickering/FlickeringSolidBlock;", "FLICKERING_SEA_LANTERN", "getFLICKERING_SEA_LANTERN", "EXTINGUISHED_SEA_LANTERN", "Lnet/minecraft/class_2248;", "getEXTINGUISHED_SEA_LANTERN", "()Lnet/minecraft/class_2248;", "Ldev/mim1q/derelict/block/flickering/FlickeringCarvedPumpkinBlock;", "FLICKERING_JACK_O_LANTERN", "Ldev/mim1q/derelict/block/flickering/FlickeringCarvedPumpkinBlock;", "getFLICKERING_JACK_O_LANTERN", "()Ldev/mim1q/derelict/block/flickering/FlickeringCarvedPumpkinBlock;", "Ldev/mim1q/derelict/block/flickering/FlickeringLanternBlock;", "FLICKERING_LANTERN", "Ldev/mim1q/derelict/block/flickering/FlickeringLanternBlock;", "getFLICKERING_LANTERN", "()Ldev/mim1q/derelict/block/flickering/FlickeringLanternBlock;", "FLICKERING_SOUL_LANTERN", "getFLICKERING_SOUL_LANTERN", "Lnet/minecraft/class_3749;", "EXTINGUISHED_LANTERN", "Lnet/minecraft/class_3749;", "getEXTINGUISHED_LANTERN", "()Lnet/minecraft/class_3749;", "FLICKERING_OCHRE_FROGLIGHT", "getFLICKERING_OCHRE_FROGLIGHT", "EXTINGUISHED_OCHRE_FROGLIGHT", "getEXTINGUISHED_OCHRE_FROGLIGHT", "FLICKERING_VERDANT_FROGLIGHT", "getFLICKERING_VERDANT_FROGLIGHT", "EXTINGUISHED_VERDANT_FROGLIGHT", "getEXTINGUISHED_VERDANT_FROGLIGHT", "FLICKERING_PEARLESCENT_FROGLIGHT", "getFLICKERING_PEARLESCENT_FROGLIGHT", "EXTINGUISHED_PEARLESCENT_FROGLIGHT", "getEXTINGUISHED_PEARLESCENT_FROGLIGHT", "FLICKERING_GLOWSTONE", "getFLICKERING_GLOWSTONE", "EXTINGUISHED_GLOWSTONE", "getEXTINGUISHED_GLOWSTONE", "FLICKERING_SHROOMLIGHT", "getFLICKERING_SHROOMLIGHT", "EXTINGUISHED_SHROOMLIGHT", "getEXTINGUISHED_SHROOMLIGHT", "Ldev/mim1q/derelict/block/flickering/FlickeringEndRodBlock;", "FLICKERING_END_ROD", "Ldev/mim1q/derelict/block/flickering/FlickeringEndRodBlock;", "getFLICKERING_END_ROD", "()Ldev/mim1q/derelict/block/flickering/FlickeringEndRodBlock;", "Ldev/mim1q/derelict/block/flickering/ExtinguishedEndRodBlock;", "EXTINGUISHED_END_ROD", "Ldev/mim1q/derelict/block/flickering/ExtinguishedEndRodBlock;", "getEXTINGUISHED_END_ROD", "()Ldev/mim1q/derelict/block/flickering/ExtinguishedEndRodBlock;", "Ldev/mim1q/derelict/block/cobweb/FancyCobwebBlock;", "FANCY_COBWEB", "Ldev/mim1q/derelict/block/cobweb/FancyCobwebBlock;", "getFANCY_COBWEB", "()Ldev/mim1q/derelict/block/cobweb/FancyCobwebBlock;", "Ldev/mim1q/derelict/block/cobweb/FancyCobwebWithSpiderNestBlock;", "FANCY_COBWEB_WITH_SPIDER_NEST", "Ldev/mim1q/derelict/block/cobweb/FancyCobwebWithSpiderNestBlock;", "getFANCY_COBWEB_WITH_SPIDER_NEST", "()Ldev/mim1q/derelict/block/cobweb/FancyCobwebWithSpiderNestBlock;", "Ldev/mim1q/derelict/block/cobweb/FancyCornerCobwebBlock;", "CORNER_COBWEB", "Ldev/mim1q/derelict/block/cobweb/FancyCornerCobwebBlock;", "getCORNER_COBWEB", "()Ldev/mim1q/derelict/block/cobweb/FancyCornerCobwebBlock;", "FANCY_CORNER_COBWEB", "getFANCY_CORNER_COBWEB", "Lnet/minecraft/class_5778;", "WALL_COBWEB", "Lnet/minecraft/class_5778;", "getWALL_COBWEB", "()Lnet/minecraft/class_5778;", "Ldev/mim1q/derelict/block/cobweb/SpiderSilkBlock;", "SPIDER_SILK", "Ldev/mim1q/derelict/block/cobweb/SpiderSilkBlock;", "getSPIDER_SILK", "()Ldev/mim1q/derelict/block/cobweb/SpiderSilkBlock;", "Ldev/mim1q/derelict/block/cobweb/SpiderSilkStrandBlock;", "SPIDER_SILK_STRAND", "Ldev/mim1q/derelict/block/cobweb/SpiderSilkStrandBlock;", "getSPIDER_SILK_STRAND", "()Ldev/mim1q/derelict/block/cobweb/SpiderSilkStrandBlock;", "SPIDER_EGG_BLOCK", "getSPIDER_EGG_BLOCK", "Ldev/mim1q/derelict/block/cobweb/SpiderEggBlock;", "SPIDER_EGG", "Ldev/mim1q/derelict/block/cobweb/SpiderEggBlock;", "getSPIDER_EGG", "()Ldev/mim1q/derelict/block/cobweb/SpiderEggBlock;", "SPIDER_EGG_CLUSTER", "getSPIDER_EGG_CLUSTER", "FAKE_SPIDER_EGG", "getFAKE_SPIDER_EGG", "SPIDERLING_SPIDER_EGG", "getSPIDERLING_SPIDER_EGG", "SPIDER_SPIDER_EGG", "getSPIDER_SPIDER_EGG", "CAVE_SPIDER_SPIDER_EGG", "getCAVE_SPIDER_SPIDER_EGG", "WEB_CASTER_SPIDER_EGG", "getWEB_CASTER_SPIDER_EGG", "JUMPING_SPIDER_SPIDER_EGG", "getJUMPING_SPIDER_SPIDER_EGG", "Ldev/mim1q/derelict/block/cobweb/SpiderMoltBlock;", "SPIDER_MOLT", "Ldev/mim1q/derelict/block/cobweb/SpiderMoltBlock;", "getSPIDER_MOLT", "()Ldev/mim1q/derelict/block/cobweb/SpiderMoltBlock;", "Ldev/mim1q/derelict/featureset/StoneSet;", "ARACHNITE", "Ldev/mim1q/derelict/featureset/StoneSet;", "getARACHNITE", "()Ldev/mim1q/derelict/featureset/StoneSet;", "Ldev/mim1q/derelict/featureset/MetalSet$ThreeLevelOxidizable;", "NOCTISTEEL", "Ldev/mim1q/derelict/featureset/MetalSet$ThreeLevelOxidizable;", "getNOCTISTEEL", "()Ldev/mim1q/derelict/featureset/MetalSet$ThreeLevelOxidizable;", "SPIDERLING_IN_A_BUCKET", "Lnet/minecraft/class_1792;", "getSPIDERLING_IN_A_BUCKET", "()Lnet/minecraft/class_1792;", "", "kotlin.jvm.PlatformType", "BLOCK_AGING_MAP", "Ljava/util/Map;", "getBLOCK_AGING_MAP", "()Ljava/util/Map;", "Ldev/mim1q/derelict/item/weapon/Wildfire;", "WILDFIRE", "Ldev/mim1q/derelict/item/weapon/Wildfire;", "getWILDFIRE", "()Ldev/mim1q/derelict/item/weapon/Wildfire;", "Ldev/mim1q/derelict/item/weapon/Arachnicannon;", "ARACHNICANNON", "Ldev/mim1q/derelict/item/weapon/Arachnicannon;", "getARACHNICANNON", "()Ldev/mim1q/derelict/item/weapon/Arachnicannon;", "Ldev/mim1q/derelict/item/weapon/SpiderSilkBola;", "SPIDER_SILK_BOLA", "Ldev/mim1q/derelict/item/weapon/SpiderSilkBola;", "getSPIDER_SILK_BOLA", "()Ldev/mim1q/derelict/item/weapon/SpiderSilkBola;", "Lnet/minecraft/class_1738;", "NETWALKERS", "Lnet/minecraft/class_1738;", "getNETWALKERS", "()Lnet/minecraft/class_1738;", "SPIDER_SILK_GLAND", "getSPIDER_SILK_GLAND", "SPIDER_PHEROMONE_GLAND", "getSPIDER_PHEROMONE_GLAND", "WEB_CASTER_SPAWN_EGG", "Lnet/minecraft/class_1826;", "getWEB_CASTER_SPAWN_EGG", "()Lnet/minecraft/class_1826;", "CHARMING_SPIDER_SPAWN_EGG", "getCHARMING_SPIDER_SPAWN_EGG", "DADDY_LONG_LEGS_SPAWN_EGG", "getDADDY_LONG_LEGS_SPAWN_EGG", "JUMPING_SPIDER_SPAWN_EGG", "getJUMPING_SPIDER_SPAWN_EGG", "SPINY_SPIDER_SPAWN_EGG", "getSPINY_SPIDER_SPAWN_EGG", "ItemCategory", "derelict"})
@SourceDebugExtension(value={"SMAP\nModBlocksAndItems.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ModBlocksAndItems.kt\ndev/mim1q/derelict/init/ModBlocksAndItems\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 _Maps.kt\nkotlin/collections/MapsKt___MapsKt\n*L\n1#1,296:1\n1863#2,2:297\n1863#2,2:299\n216#3,2:301\n216#3,2:303\n216#3,2:305\n216#3,2:307\n*S KotlinDebug\n*F\n+ 1 ModBlocksAndItems.kt\ndev/mim1q/derelict/init/ModBlocksAndItems\n*L\n219#1:297,2\n220#1:299,2\n221#1:301,2\n225#1:303,2\n229#1:305,2\n233#1:307,2\n*E\n"})
public final class ModBlocksAndItems {
    @NotNull
    public static final ModBlocksAndItems INSTANCE = new ModBlocksAndItems();
    @NotNull
    private static final Set<class_2248> lastAgeable = new LinkedHashSet();
    @NotNull
    private static final Set<class_2248> lastWaxable = new LinkedHashSet();
    @NotNull
    private static final StaffItem.Aging AGING_STAFF;
    @NotNull
    private static final StaffItem.Waxing WAXING_STAFF;
    @NotNull
    private static final WoodSet BURNED_WOOD;
    @NotNull
    private static final class_2397 BURNED_LEAVES;
    @NotNull
    private static final SmolderingLeavesBlock SMOLDERING_LEAVES;
    @NotNull
    private static final EmbersBlock.Smoking SMOKING_EMBERS;
    @NotNull
    private static final EmbersBlock.Smoldering SMOLDERING_EMBERS;
    @NotNull
    private static final GrassSet DRIED_GRASS;
    @NotNull
    private static final GrassSet BURNED_GRASS;
    @NotNull
    private static final CoverBoardsSet OAK_COVER_BOARDS;
    @NotNull
    private static final CoverBoardsSet SPRUCE_COVER_BOARDS;
    @NotNull
    private static final CoverBoardsSet BIRCH_COVER_BOARDS;
    @NotNull
    private static final CoverBoardsSet JUNGLE_COVER_BOARDS;
    @NotNull
    private static final CoverBoardsSet ACACIA_COVER_BOARDS;
    @NotNull
    private static final CoverBoardsSet DARK_OAK_COVER_BOARDS;
    @NotNull
    private static final CoverBoardsSet MANGROVE_COVER_BOARDS;
    @NotNull
    private static final CoverBoardsSet CHERRY_COVER_BOARDS;
    @NotNull
    private static final CoverBoardsSet BAMBOO_COVER_BOARD;
    @NotNull
    private static final CoverBoardsSet WARPED_COVER_BOARDS;
    @NotNull
    private static final CoverBoardsSet CRIMSON_COVER_BOARDS;
    @NotNull
    private static final CoverBoardsSet BURNED_COVER_BOARDS;
    @NotNull
    private static final FlickeringSolidBlock FLICKERING_REDSTONE_LAMP;
    @NotNull
    private static final FlickeringSolidBlock FLICKERING_SEA_LANTERN;
    @NotNull
    private static final class_2248 EXTINGUISHED_SEA_LANTERN;
    @NotNull
    private static final FlickeringCarvedPumpkinBlock FLICKERING_JACK_O_LANTERN;
    @NotNull
    private static final FlickeringLanternBlock FLICKERING_LANTERN;
    @NotNull
    private static final FlickeringLanternBlock FLICKERING_SOUL_LANTERN;
    @NotNull
    private static final class_3749 EXTINGUISHED_LANTERN;
    @NotNull
    private static final FlickeringSolidBlock FLICKERING_OCHRE_FROGLIGHT;
    @NotNull
    private static final class_2248 EXTINGUISHED_OCHRE_FROGLIGHT;
    @NotNull
    private static final FlickeringSolidBlock FLICKERING_VERDANT_FROGLIGHT;
    @NotNull
    private static final class_2248 EXTINGUISHED_VERDANT_FROGLIGHT;
    @NotNull
    private static final FlickeringSolidBlock FLICKERING_PEARLESCENT_FROGLIGHT;
    @NotNull
    private static final class_2248 EXTINGUISHED_PEARLESCENT_FROGLIGHT;
    @NotNull
    private static final FlickeringSolidBlock FLICKERING_GLOWSTONE;
    @NotNull
    private static final class_2248 EXTINGUISHED_GLOWSTONE;
    @NotNull
    private static final FlickeringSolidBlock FLICKERING_SHROOMLIGHT;
    @NotNull
    private static final class_2248 EXTINGUISHED_SHROOMLIGHT;
    @NotNull
    private static final FlickeringEndRodBlock FLICKERING_END_ROD;
    @NotNull
    private static final ExtinguishedEndRodBlock EXTINGUISHED_END_ROD;
    @NotNull
    private static final FancyCobwebBlock FANCY_COBWEB;
    @NotNull
    private static final FancyCobwebWithSpiderNestBlock FANCY_COBWEB_WITH_SPIDER_NEST;
    @NotNull
    private static final FancyCornerCobwebBlock CORNER_COBWEB;
    @NotNull
    private static final FancyCornerCobwebBlock FANCY_CORNER_COBWEB;
    @NotNull
    private static final class_5778 WALL_COBWEB;
    @NotNull
    private static final SpiderSilkBlock SPIDER_SILK;
    @NotNull
    private static final SpiderSilkStrandBlock SPIDER_SILK_STRAND;
    @NotNull
    private static final class_2248 SPIDER_EGG_BLOCK;
    @NotNull
    private static final SpiderEggBlock SPIDER_EGG;
    @NotNull
    private static final SpiderEggBlock SPIDER_EGG_CLUSTER;
    @NotNull
    private static final SpiderEggBlock FAKE_SPIDER_EGG;
    @NotNull
    private static final SpiderEggBlock SPIDERLING_SPIDER_EGG;
    @NotNull
    private static final SpiderEggBlock SPIDER_SPIDER_EGG;
    @NotNull
    private static final SpiderEggBlock CAVE_SPIDER_SPIDER_EGG;
    @NotNull
    private static final SpiderEggBlock WEB_CASTER_SPIDER_EGG;
    @NotNull
    private static final SpiderEggBlock JUMPING_SPIDER_SPIDER_EGG;
    @NotNull
    private static final SpiderMoltBlock SPIDER_MOLT;
    @NotNull
    private static final StoneSet ARACHNITE;
    @NotNull
    private static final MetalSet.ThreeLevelOxidizable NOCTISTEEL;
    @NotNull
    private static final class_1792 SPIDERLING_IN_A_BUCKET;
    @NotNull
    private static final Map<class_2248, class_2248> BLOCK_AGING_MAP;
    @NotNull
    private static final Wildfire WILDFIRE;
    @NotNull
    private static final Arachnicannon ARACHNICANNON;
    @NotNull
    private static final SpiderSilkBola SPIDER_SILK_BOLA;
    @NotNull
    private static final class_1738 NETWALKERS;
    @NotNull
    private static final class_1792 SPIDER_SILK_GLAND;
    @NotNull
    private static final class_1792 SPIDER_PHEROMONE_GLAND;
    @NotNull
    private static final class_1826 WEB_CASTER_SPAWN_EGG;
    @NotNull
    private static final class_1826 CHARMING_SPIDER_SPAWN_EGG;
    @NotNull
    private static final class_1826 DADDY_LONG_LEGS_SPAWN_EGG;
    @NotNull
    private static final class_1826 JUMPING_SPIDER_SPAWN_EGG;
    @NotNull
    private static final class_1826 SPINY_SPIDER_SPAWN_EGG;

    private ModBlocksAndItems() {
    }

    @NotNull
    public final StaffItem.Aging getAGING_STAFF() {
        return AGING_STAFF;
    }

    @NotNull
    public final StaffItem.Waxing getWAXING_STAFF() {
        return WAXING_STAFF;
    }

    @NotNull
    public final WoodSet getBURNED_WOOD() {
        return BURNED_WOOD;
    }

    @NotNull
    public final class_2397 getBURNED_LEAVES() {
        return BURNED_LEAVES;
    }

    @NotNull
    public final SmolderingLeavesBlock getSMOLDERING_LEAVES() {
        return SMOLDERING_LEAVES;
    }

    @NotNull
    public final EmbersBlock.Smoking getSMOKING_EMBERS() {
        return SMOKING_EMBERS;
    }

    @NotNull
    public final EmbersBlock.Smoldering getSMOLDERING_EMBERS() {
        return SMOLDERING_EMBERS;
    }

    @NotNull
    public final GrassSet getDRIED_GRASS() {
        return DRIED_GRASS;
    }

    @NotNull
    public final GrassSet getBURNED_GRASS() {
        return BURNED_GRASS;
    }

    @NotNull
    public final CoverBoardsSet getOAK_COVER_BOARDS() {
        return OAK_COVER_BOARDS;
    }

    @NotNull
    public final CoverBoardsSet getSPRUCE_COVER_BOARDS() {
        return SPRUCE_COVER_BOARDS;
    }

    @NotNull
    public final CoverBoardsSet getBIRCH_COVER_BOARDS() {
        return BIRCH_COVER_BOARDS;
    }

    @NotNull
    public final CoverBoardsSet getJUNGLE_COVER_BOARDS() {
        return JUNGLE_COVER_BOARDS;
    }

    @NotNull
    public final CoverBoardsSet getACACIA_COVER_BOARDS() {
        return ACACIA_COVER_BOARDS;
    }

    @NotNull
    public final CoverBoardsSet getDARK_OAK_COVER_BOARDS() {
        return DARK_OAK_COVER_BOARDS;
    }

    @NotNull
    public final CoverBoardsSet getMANGROVE_COVER_BOARDS() {
        return MANGROVE_COVER_BOARDS;
    }

    @NotNull
    public final CoverBoardsSet getCHERRY_COVER_BOARDS() {
        return CHERRY_COVER_BOARDS;
    }

    @NotNull
    public final CoverBoardsSet getBAMBOO_COVER_BOARD() {
        return BAMBOO_COVER_BOARD;
    }

    @NotNull
    public final CoverBoardsSet getWARPED_COVER_BOARDS() {
        return WARPED_COVER_BOARDS;
    }

    @NotNull
    public final CoverBoardsSet getCRIMSON_COVER_BOARDS() {
        return CRIMSON_COVER_BOARDS;
    }

    @NotNull
    public final CoverBoardsSet getBURNED_COVER_BOARDS() {
        return BURNED_COVER_BOARDS;
    }

    @NotNull
    public final FlickeringSolidBlock getFLICKERING_REDSTONE_LAMP() {
        return FLICKERING_REDSTONE_LAMP;
    }

    @NotNull
    public final FlickeringSolidBlock getFLICKERING_SEA_LANTERN() {
        return FLICKERING_SEA_LANTERN;
    }

    @NotNull
    public final class_2248 getEXTINGUISHED_SEA_LANTERN() {
        return EXTINGUISHED_SEA_LANTERN;
    }

    @NotNull
    public final FlickeringCarvedPumpkinBlock getFLICKERING_JACK_O_LANTERN() {
        return FLICKERING_JACK_O_LANTERN;
    }

    @NotNull
    public final FlickeringLanternBlock getFLICKERING_LANTERN() {
        return FLICKERING_LANTERN;
    }

    @NotNull
    public final FlickeringLanternBlock getFLICKERING_SOUL_LANTERN() {
        return FLICKERING_SOUL_LANTERN;
    }

    @NotNull
    public final class_3749 getEXTINGUISHED_LANTERN() {
        return EXTINGUISHED_LANTERN;
    }

    @NotNull
    public final FlickeringSolidBlock getFLICKERING_OCHRE_FROGLIGHT() {
        return FLICKERING_OCHRE_FROGLIGHT;
    }

    @NotNull
    public final class_2248 getEXTINGUISHED_OCHRE_FROGLIGHT() {
        return EXTINGUISHED_OCHRE_FROGLIGHT;
    }

    @NotNull
    public final FlickeringSolidBlock getFLICKERING_VERDANT_FROGLIGHT() {
        return FLICKERING_VERDANT_FROGLIGHT;
    }

    @NotNull
    public final class_2248 getEXTINGUISHED_VERDANT_FROGLIGHT() {
        return EXTINGUISHED_VERDANT_FROGLIGHT;
    }

    @NotNull
    public final FlickeringSolidBlock getFLICKERING_PEARLESCENT_FROGLIGHT() {
        return FLICKERING_PEARLESCENT_FROGLIGHT;
    }

    @NotNull
    public final class_2248 getEXTINGUISHED_PEARLESCENT_FROGLIGHT() {
        return EXTINGUISHED_PEARLESCENT_FROGLIGHT;
    }

    @NotNull
    public final FlickeringSolidBlock getFLICKERING_GLOWSTONE() {
        return FLICKERING_GLOWSTONE;
    }

    @NotNull
    public final class_2248 getEXTINGUISHED_GLOWSTONE() {
        return EXTINGUISHED_GLOWSTONE;
    }

    @NotNull
    public final FlickeringSolidBlock getFLICKERING_SHROOMLIGHT() {
        return FLICKERING_SHROOMLIGHT;
    }

    @NotNull
    public final class_2248 getEXTINGUISHED_SHROOMLIGHT() {
        return EXTINGUISHED_SHROOMLIGHT;
    }

    @NotNull
    public final FlickeringEndRodBlock getFLICKERING_END_ROD() {
        return FLICKERING_END_ROD;
    }

    @NotNull
    public final ExtinguishedEndRodBlock getEXTINGUISHED_END_ROD() {
        return EXTINGUISHED_END_ROD;
    }

    @NotNull
    public final FancyCobwebBlock getFANCY_COBWEB() {
        return FANCY_COBWEB;
    }

    @NotNull
    public final FancyCobwebWithSpiderNestBlock getFANCY_COBWEB_WITH_SPIDER_NEST() {
        return FANCY_COBWEB_WITH_SPIDER_NEST;
    }

    @NotNull
    public final FancyCornerCobwebBlock getCORNER_COBWEB() {
        return CORNER_COBWEB;
    }

    @NotNull
    public final FancyCornerCobwebBlock getFANCY_CORNER_COBWEB() {
        return FANCY_CORNER_COBWEB;
    }

    @NotNull
    public final class_5778 getWALL_COBWEB() {
        return WALL_COBWEB;
    }

    @NotNull
    public final SpiderSilkBlock getSPIDER_SILK() {
        return SPIDER_SILK;
    }

    @NotNull
    public final SpiderSilkStrandBlock getSPIDER_SILK_STRAND() {
        return SPIDER_SILK_STRAND;
    }

    @NotNull
    public final class_2248 getSPIDER_EGG_BLOCK() {
        return SPIDER_EGG_BLOCK;
    }

    @NotNull
    public final SpiderEggBlock getSPIDER_EGG() {
        return SPIDER_EGG;
    }

    @NotNull
    public final SpiderEggBlock getSPIDER_EGG_CLUSTER() {
        return SPIDER_EGG_CLUSTER;
    }

    @NotNull
    public final SpiderEggBlock getFAKE_SPIDER_EGG() {
        return FAKE_SPIDER_EGG;
    }

    @NotNull
    public final SpiderEggBlock getSPIDERLING_SPIDER_EGG() {
        return SPIDERLING_SPIDER_EGG;
    }

    @NotNull
    public final SpiderEggBlock getSPIDER_SPIDER_EGG() {
        return SPIDER_SPIDER_EGG;
    }

    @NotNull
    public final SpiderEggBlock getCAVE_SPIDER_SPIDER_EGG() {
        return CAVE_SPIDER_SPIDER_EGG;
    }

    @NotNull
    public final SpiderEggBlock getWEB_CASTER_SPIDER_EGG() {
        return WEB_CASTER_SPIDER_EGG;
    }

    @NotNull
    public final SpiderEggBlock getJUMPING_SPIDER_SPIDER_EGG() {
        return JUMPING_SPIDER_SPIDER_EGG;
    }

    @NotNull
    public final SpiderMoltBlock getSPIDER_MOLT() {
        return SPIDER_MOLT;
    }

    @NotNull
    public final StoneSet getARACHNITE() {
        return ARACHNITE;
    }

    @NotNull
    public final MetalSet.ThreeLevelOxidizable getNOCTISTEEL() {
        return NOCTISTEEL;
    }

    @NotNull
    public final class_1792 getSPIDERLING_IN_A_BUCKET() {
        return SPIDERLING_IN_A_BUCKET;
    }

    @NotNull
    public final Map<class_2248, class_2248> getBLOCK_AGING_MAP() {
        return BLOCK_AGING_MAP;
    }

    @NotNull
    public final Wildfire getWILDFIRE() {
        return WILDFIRE;
    }

    @NotNull
    public final Arachnicannon getARACHNICANNON() {
        return ARACHNICANNON;
    }

    @NotNull
    public final SpiderSilkBola getSPIDER_SILK_BOLA() {
        return SPIDER_SILK_BOLA;
    }

    @NotNull
    public final class_1738 getNETWALKERS() {
        return NETWALKERS;
    }

    @NotNull
    public final class_1792 getSPIDER_SILK_GLAND() {
        return SPIDER_SILK_GLAND;
    }

    @NotNull
    public final class_1792 getSPIDER_PHEROMONE_GLAND() {
        return SPIDER_PHEROMONE_GLAND;
    }

    @NotNull
    public final class_1826 getWEB_CASTER_SPAWN_EGG() {
        return WEB_CASTER_SPAWN_EGG;
    }

    @NotNull
    public final class_1826 getCHARMING_SPIDER_SPAWN_EGG() {
        return CHARMING_SPIDER_SPAWN_EGG;
    }

    @NotNull
    public final class_1826 getDADDY_LONG_LEGS_SPAWN_EGG() {
        return DADDY_LONG_LEGS_SPAWN_EGG;
    }

    @NotNull
    public final class_1826 getJUMPING_SPIDER_SPAWN_EGG() {
        return JUMPING_SPIDER_SPAWN_EGG;
    }

    @NotNull
    public final class_1826 getSPINY_SPIDER_SPAWN_EGG() {
        return SPINY_SPIDER_SPAWN_EGG;
    }

    public final void init() {
    }

    public final void setupWaxableAndAgeable() {
        class_2248 from;
        Object object;
        class_2248 it;
        Object element$iv;
        Object $this$forEach$iv = lastWaxable;
        boolean $i$f$forEach = false;
        Iterator<Object> iterator = $this$forEach$iv.iterator();
        while (iterator.hasNext()) {
            element$iv = iterator.next();
            it = (class_2248)element$iv;
            boolean bl = false;
            Intrinsics.checkNotNull((Object)it, (String)"null cannot be cast to non-null type dev.mim1q.derelict.interfaces.AbstractBlockAccessor");
            ((AbstractBlockAccessor)it).setWaxable(false);
        }
        $this$forEach$iv = lastAgeable;
        $i$f$forEach = false;
        iterator = $this$forEach$iv.iterator();
        while (iterator.hasNext()) {
            element$iv = iterator.next();
            it = (class_2248)element$iv;
            boolean bl = false;
            Intrinsics.checkNotNull((Object)it, (String)"null cannot be cast to non-null type dev.mim1q.derelict.interfaces.AbstractBlockAccessor");
            ((AbstractBlockAccessor)it).setAgeable(false);
        }
        $this$forEach$iv = BLOCK_AGING_MAP;
        $i$f$forEach = false;
        iterator = $this$forEach$iv.entrySet().iterator();
        while (iterator.hasNext()) {
            object = element$iv = (Map.Entry)iterator.next();
            boolean bl = false;
            from = (class_2248)object.getKey();
            Intrinsics.checkNotNull((Object)from, (String)"null cannot be cast to non-null type dev.mim1q.derelict.interfaces.AbstractBlockAccessor");
            ((AbstractBlockAccessor)from).setAgeable(true);
            lastAgeable.add(from);
        }
        Object t = class_5953.field_29560.get();
        Intrinsics.checkNotNullExpressionValue(t, (String)"get(...)");
        $this$forEach$iv = (Map)t;
        $i$f$forEach = false;
        iterator = $this$forEach$iv.entrySet().iterator();
        while (iterator.hasNext()) {
            object = element$iv = (Map.Entry)iterator.next();
            boolean bl = false;
            from = (class_2248)object.getKey();
            Intrinsics.checkNotNull((Object)from, (String)"null cannot be cast to non-null type dev.mim1q.derelict.interfaces.AbstractBlockAccessor");
            ((AbstractBlockAccessor)from).setWaxable(true);
            lastWaxable.add(from);
        }
        Object t2 = class_5955.field_29564.get();
        Intrinsics.checkNotNullExpressionValue(t2, (String)"get(...)");
        $this$forEach$iv = (Map)t2;
        $i$f$forEach = false;
        iterator = $this$forEach$iv.entrySet().iterator();
        while (iterator.hasNext()) {
            object = element$iv = (Map.Entry)iterator.next();
            boolean bl = false;
            from = (class_2248)object.getKey();
            Intrinsics.checkNotNull((Object)from, (String)"null cannot be cast to non-null type dev.mim1q.derelict.interfaces.AbstractBlockAccessor");
            ((AbstractBlockAccessor)from).setAgeable(true);
            lastAgeable.add(from);
        }
        Object t3 = class_5953.field_29561.get();
        Intrinsics.checkNotNullExpressionValue(t3, (String)"get(...)");
        $this$forEach$iv = (Map)t3;
        $i$f$forEach = false;
        iterator = $this$forEach$iv.entrySet().iterator();
        while (iterator.hasNext()) {
            object = element$iv = (Map.Entry)iterator.next();
            boolean bl = false;
            from = (class_2248)object.getKey();
            class_2248 to = (class_2248)object.getValue();
            if (!((BiMap)class_5955.field_29564.get()).containsKey((Object)to)) continue;
            Intrinsics.checkNotNull((Object)from, (String)"null cannot be cast to non-null type dev.mim1q.derelict.interfaces.AbstractBlockAccessor");
            ((AbstractBlockAccessor)from).setAgeable(true);
        }
    }

    @NotNull
    public final <T extends class_2248> T register$derelict(@NotNull String name, @NotNull T block, @NotNull ItemCategory category) {
        Intrinsics.checkNotNullParameter((Object)name, (String)"name");
        Intrinsics.checkNotNullParameter(block, (String)"block");
        Intrinsics.checkNotNullParameter((Object)((Object)category), (String)"category");
        this.registerBlock$derelict(name, block);
        this.registerItem$derelict(name, (class_1792)new class_1747(block, (class_1792.class_1793)this.defaultItemSettings()), category);
        return block;
    }

    public static /* synthetic */ class_2248 register$derelict$default(ModBlocksAndItems modBlocksAndItems, String string, class_2248 class_22482, ItemCategory itemCategory, int n, Object object) {
        if ((n & 4) != 0) {
            itemCategory = ItemCategory.GENERAL;
        }
        return modBlocksAndItems.register$derelict(string, class_22482, itemCategory);
    }

    @NotNull
    public final <T extends class_2248> T registerBlock$derelict(@NotNull String name, @NotNull T block) {
        Intrinsics.checkNotNullParameter((Object)name, (String)"name");
        Intrinsics.checkNotNullParameter(block, (String)"block");
        Object object = class_2378.method_10230((class_2378)((class_2378)class_7923.field_41175), (class_2960)Derelict.INSTANCE.id(name), block);
        Intrinsics.checkNotNullExpressionValue((Object)object, (String)"register(...)");
        return (T)((class_2248)object);
    }

    @NotNull
    public final <T extends class_1792> T registerItem$derelict(@NotNull String name, @NotNull T item, @Nullable ItemCategory category) {
        Intrinsics.checkNotNullParameter((Object)name, (String)"name");
        Intrinsics.checkNotNullParameter(item, (String)"item");
        ItemCategory itemCategory = category;
        if (itemCategory != null) {
            itemCategory.add(item);
        }
        Object object = class_2378.method_10230((class_2378)((class_2378)class_7923.field_41178), (class_2960)Derelict.INSTANCE.id(name), item);
        Intrinsics.checkNotNullExpressionValue((Object)object, (String)"register(...)");
        return (T)((class_1792)object);
    }

    public static /* synthetic */ class_1792 registerItem$derelict$default(ModBlocksAndItems modBlocksAndItems, String string, class_1792 class_17922, ItemCategory itemCategory, int n, Object object) {
        if ((n & 4) != 0) {
            itemCategory = ItemCategory.GENERAL;
        }
        return modBlocksAndItems.registerItem$derelict(string, class_17922, itemCategory);
    }

    @NotNull
    public final class_1792 registerSimpleItem$derelict(@NotNull String name) {
        Intrinsics.checkNotNullParameter((Object)name, (String)"name");
        return ModBlocksAndItems.registerItem$derelict$default(this, name, new class_1792((class_1792.class_1793)this.defaultItemSettings()), null, 4, null);
    }

    private final FabricItemSettings defaultItemSettings() {
        return new FabricItemSettings();
    }

    private final class_1826 registerSpawnEgg(class_1299<? extends class_1308> entity) {
        return (class_1826)this.registerItem$derelict(class_7923.field_41177.method_10221(entity).method_12832() + "_spawn_egg", (class_1792)new class_1826(entity, 0xFFFFFF, 0xFFFFFF, (class_1792.class_1793)this.defaultItemSettings()), ItemCategory.SPAWN_EGGS);
    }

    private static final boolean SMOLDERING_EMBERS$lambda$0(class_2680 class_26802, class_1922 class_19222, class_2338 class_23382) {
        return true;
    }

    private static final int EXTINGUISHED_SEA_LANTERN$lambda$1(class_2680 it) {
        return 0;
    }

    private static final int EXTINGUISHED_LANTERN$lambda$2(class_2680 it) {
        return 0;
    }

    private static final int EXTINGUISHED_OCHRE_FROGLIGHT$lambda$3(class_2680 it) {
        return 0;
    }

    private static final int EXTINGUISHED_VERDANT_FROGLIGHT$lambda$4(class_2680 it) {
        return 0;
    }

    private static final int EXTINGUISHED_PEARLESCENT_FROGLIGHT$lambda$5(class_2680 it) {
        return 0;
    }

    private static final int EXTINGUISHED_GLOWSTONE$lambda$6(class_2680 it) {
        return 0;
    }

    private static final int EXTINGUISHED_SHROOMLIGHT$lambda$7(class_2680 it) {
        return 0;
    }

    private static final int EXTINGUISHED_END_ROD$lambda$8(class_2680 it) {
        return 0;
    }

    private static final int SPIDER_EGG$lambda$9(class_2680 it) {
        return 1;
    }

    private static final int FAKE_SPIDER_EGG$lambda$10(class_5819 it) {
        Intrinsics.checkNotNullParameter((Object)it, (String)"it");
        return 0;
    }

    private static final int SPIDERLING_SPIDER_EGG$lambda$11(class_5819 it) {
        Intrinsics.checkNotNullParameter((Object)it, (String)"it");
        return it.method_43048(3) + 1;
    }

    static {
        FabricItemSettings fabricItemSettings = INSTANCE.defaultItemSettings().maxCount(1);
        Intrinsics.checkNotNullExpressionValue((Object)fabricItemSettings, (String)"maxCount(...)");
        AGING_STAFF = (StaffItem.Aging)ModBlocksAndItems.registerItem$derelict$default(INSTANCE, "aging_staff", new StaffItem.Aging(fabricItemSettings), null, 4, null);
        FabricItemSettings fabricItemSettings2 = INSTANCE.defaultItemSettings().maxCount(1);
        Intrinsics.checkNotNullExpressionValue((Object)fabricItemSettings2, (String)"maxCount(...)");
        WAXING_STAFF = (StaffItem.Waxing)ModBlocksAndItems.registerItem$derelict$default(INSTANCE, "waxing_staff", new StaffItem.Waxing(fabricItemSettings2), null, 4, null);
        BURNED_WOOD = new WoodSet(Derelict.INSTANCE.id("burned"), INSTANCE.defaultItemSettings()).register();
        BURNED_LEAVES = (class_2397)ModBlocksAndItems.register$derelict$default(INSTANCE, "burned_leaves", (class_2248)new class_2397((class_4970.class_2251)FabricBlockSettings.copyOf((class_4970)((class_4970)class_2246.field_10503))), null, 4, null);
        FabricBlockSettings fabricBlockSettings = FabricBlockSettings.copyOf((class_4970)((class_4970)class_2246.field_10503));
        Intrinsics.checkNotNullExpressionValue((Object)fabricBlockSettings, (String)"copyOf(...)");
        SMOLDERING_LEAVES = (SmolderingLeavesBlock)ModBlocksAndItems.register$derelict$default(INSTANCE, "smoldering_leaves", (class_2248)new SmolderingLeavesBlock(fabricBlockSettings), null, 4, null);
        FabricBlockSettings fabricBlockSettings2 = FabricBlockSettings.copyOf((class_4970)((class_4970)class_2246.field_10036)).luminance(1).breakInstantly();
        Intrinsics.checkNotNullExpressionValue((Object)fabricBlockSettings2, (String)"breakInstantly(...)");
        SMOKING_EMBERS = (EmbersBlock.Smoking)ModBlocksAndItems.register$derelict$default(INSTANCE, "smoking_embers", (class_2248)new EmbersBlock.Smoking(fabricBlockSettings2), null, 4, null);
        FabricBlockSettings fabricBlockSettings3 = FabricBlockSettings.copyOf((class_4970)((class_4970)class_2246.field_10036)).luminance(4).emissiveLighting(ModBlocksAndItems::SMOLDERING_EMBERS$lambda$0).breakInstantly();
        Intrinsics.checkNotNullExpressionValue((Object)fabricBlockSettings3, (String)"breakInstantly(...)");
        SMOLDERING_EMBERS = (EmbersBlock.Smoldering)ModBlocksAndItems.register$derelict$default(INSTANCE, "smoldering_embers", (class_2248)new EmbersBlock.Smoldering(fabricBlockSettings3), null, 4, null);
        DRIED_GRASS = new GrassSet(Derelict.INSTANCE.id("dried"), INSTANCE.defaultItemSettings());
        BURNED_GRASS = new GrassSet(Derelict.INSTANCE.id("burned"), INSTANCE.defaultItemSettings());
        OAK_COVER_BOARDS = new CoverBoardsSet(Derelict.INSTANCE.id("oak"), INSTANCE.defaultItemSettings(), null, 4, null);
        SPRUCE_COVER_BOARDS = new CoverBoardsSet(Derelict.INSTANCE.id("spruce"), INSTANCE.defaultItemSettings(), null, 4, null);
        BIRCH_COVER_BOARDS = new CoverBoardsSet(Derelict.INSTANCE.id("birch"), INSTANCE.defaultItemSettings(), null, 4, null);
        JUNGLE_COVER_BOARDS = new CoverBoardsSet(Derelict.INSTANCE.id("jungle"), INSTANCE.defaultItemSettings(), null, 4, null);
        ACACIA_COVER_BOARDS = new CoverBoardsSet(Derelict.INSTANCE.id("acacia"), INSTANCE.defaultItemSettings(), null, 4, null);
        DARK_OAK_COVER_BOARDS = new CoverBoardsSet(Derelict.INSTANCE.id("dark_oak"), INSTANCE.defaultItemSettings(), null, 4, null);
        MANGROVE_COVER_BOARDS = new CoverBoardsSet(Derelict.INSTANCE.id("mangrove"), INSTANCE.defaultItemSettings(), null, 4, null);
        CHERRY_COVER_BOARDS = new CoverBoardsSet(Derelict.INSTANCE.id("cherry"), INSTANCE.defaultItemSettings(), null, 4, null);
        BAMBOO_COVER_BOARD = new CoverBoardsSet(Derelict.INSTANCE.id("bamboo"), INSTANCE.defaultItemSettings(), null, 4, null);
        WARPED_COVER_BOARDS = new CoverBoardsSet(Derelict.INSTANCE.id("warped"), INSTANCE.defaultItemSettings(), null, 4, null);
        CRIMSON_COVER_BOARDS = new CoverBoardsSet(Derelict.INSTANCE.id("crimson"), INSTANCE.defaultItemSettings(), null, 4, null);
        BURNED_COVER_BOARDS = new CoverBoardsSet(Derelict.INSTANCE.id("burned"), INSTANCE.defaultItemSettings(), null, 4, null);
        FabricBlockSettings fabricBlockSettings4 = FabricBlockSettings.copyOf((class_4970)((class_4970)class_2246.field_10524));
        Intrinsics.checkNotNullExpressionValue((Object)fabricBlockSettings4, (String)"copyOf(...)");
        FLICKERING_REDSTONE_LAMP = (FlickeringSolidBlock)ModBlocksAndItems.register$derelict$default(INSTANCE, "flickering_redstone_lamp", new FlickeringSolidBlock((class_4970.class_2251)fabricBlockSettings4), null, 4, null);
        FabricBlockSettings fabricBlockSettings5 = FabricBlockSettings.copyOf((class_4970)((class_4970)class_2246.field_10174));
        Intrinsics.checkNotNullExpressionValue((Object)fabricBlockSettings5, (String)"copyOf(...)");
        FLICKERING_SEA_LANTERN = (FlickeringSolidBlock)ModBlocksAndItems.register$derelict$default(INSTANCE, "flickering_sea_lantern", new FlickeringSolidBlock((class_4970.class_2251)fabricBlockSettings5), null, 4, null);
        EXTINGUISHED_SEA_LANTERN = ModBlocksAndItems.register$derelict$default(INSTANCE, "extinguished_sea_lantern", new class_2248((class_4970.class_2251)FabricBlockSettings.copyOf((class_4970)((class_4970)class_2246.field_10174)).luminance(ModBlocksAndItems::EXTINGUISHED_SEA_LANTERN$lambda$1)), null, 4, null);
        FabricBlockSettings fabricBlockSettings6 = FabricBlockSettings.copyOf((class_4970)((class_4970)class_2246.field_10009));
        Intrinsics.checkNotNullExpressionValue((Object)fabricBlockSettings6, (String)"copyOf(...)");
        FLICKERING_JACK_O_LANTERN = (FlickeringCarvedPumpkinBlock)ModBlocksAndItems.register$derelict$default(INSTANCE, "flickering_jack_o_lantern", (class_2248)new FlickeringCarvedPumpkinBlock((class_4970.class_2251)fabricBlockSettings6), null, 4, null);
        FabricBlockSettings fabricBlockSettings7 = FabricBlockSettings.copyOf((class_4970)((class_4970)class_2246.field_16541));
        Intrinsics.checkNotNullExpressionValue((Object)fabricBlockSettings7, (String)"copyOf(...)");
        FLICKERING_LANTERN = (FlickeringLanternBlock)ModBlocksAndItems.register$derelict$default(INSTANCE, "flickering_lantern", (class_2248)new FlickeringLanternBlock((class_4970.class_2251)fabricBlockSettings7), null, 4, null);
        FabricBlockSettings fabricBlockSettings8 = FabricBlockSettings.copyOf((class_4970)((class_4970)class_2246.field_22110));
        Intrinsics.checkNotNullExpressionValue((Object)fabricBlockSettings8, (String)"copyOf(...)");
        FLICKERING_SOUL_LANTERN = (FlickeringLanternBlock)ModBlocksAndItems.register$derelict$default(INSTANCE, "flickering_soul_lantern", (class_2248)new FlickeringLanternBlock((class_4970.class_2251)fabricBlockSettings8), null, 4, null);
        EXTINGUISHED_LANTERN = (class_3749)ModBlocksAndItems.register$derelict$default(INSTANCE, "extinguished_lantern", (class_2248)new class_3749((class_4970.class_2251)FabricBlockSettings.copyOf((class_4970)((class_4970)class_2246.field_16541)).luminance(ModBlocksAndItems::EXTINGUISHED_LANTERN$lambda$2)), null, 4, null);
        FabricBlockSettings fabricBlockSettings9 = FabricBlockSettings.copyOf((class_4970)((class_4970)class_2246.field_37572));
        Intrinsics.checkNotNullExpressionValue((Object)fabricBlockSettings9, (String)"copyOf(...)");
        FLICKERING_OCHRE_FROGLIGHT = (FlickeringSolidBlock)ModBlocksAndItems.register$derelict$default(INSTANCE, "flickering_ochre_froglight", new FlickeringSolidBlock((class_4970.class_2251)fabricBlockSettings9), null, 4, null);
        EXTINGUISHED_OCHRE_FROGLIGHT = ModBlocksAndItems.register$derelict$default(INSTANCE, "extinguished_ochre_froglight", new class_2248((class_4970.class_2251)FabricBlockSettings.copyOf((class_4970)((class_4970)class_2246.field_37572)).luminance(ModBlocksAndItems::EXTINGUISHED_OCHRE_FROGLIGHT$lambda$3)), null, 4, null);
        FabricBlockSettings fabricBlockSettings10 = FabricBlockSettings.copyOf((class_4970)((class_4970)class_2246.field_37573));
        Intrinsics.checkNotNullExpressionValue((Object)fabricBlockSettings10, (String)"copyOf(...)");
        FLICKERING_VERDANT_FROGLIGHT = (FlickeringSolidBlock)ModBlocksAndItems.register$derelict$default(INSTANCE, "flickering_verdant_froglight", new FlickeringSolidBlock((class_4970.class_2251)fabricBlockSettings10), null, 4, null);
        EXTINGUISHED_VERDANT_FROGLIGHT = ModBlocksAndItems.register$derelict$default(INSTANCE, "extinguished_verdant_froglight", new class_2248((class_4970.class_2251)FabricBlockSettings.copyOf((class_4970)((class_4970)class_2246.field_37573)).luminance(ModBlocksAndItems::EXTINGUISHED_VERDANT_FROGLIGHT$lambda$4)), null, 4, null);
        FabricBlockSettings fabricBlockSettings11 = FabricBlockSettings.copyOf((class_4970)((class_4970)class_2246.field_37574));
        Intrinsics.checkNotNullExpressionValue((Object)fabricBlockSettings11, (String)"copyOf(...)");
        FLICKERING_PEARLESCENT_FROGLIGHT = (FlickeringSolidBlock)ModBlocksAndItems.register$derelict$default(INSTANCE, "flickering_pearlescent_froglight", new FlickeringSolidBlock((class_4970.class_2251)fabricBlockSettings11), null, 4, null);
        EXTINGUISHED_PEARLESCENT_FROGLIGHT = ModBlocksAndItems.register$derelict$default(INSTANCE, "extinguished_pearlescent_froglight", new class_2248((class_4970.class_2251)FabricBlockSettings.copyOf((class_4970)((class_4970)class_2246.field_37574)).luminance(ModBlocksAndItems::EXTINGUISHED_PEARLESCENT_FROGLIGHT$lambda$5)), null, 4, null);
        FabricBlockSettings fabricBlockSettings12 = FabricBlockSettings.copyOf((class_4970)((class_4970)class_2246.field_10171));
        Intrinsics.checkNotNullExpressionValue((Object)fabricBlockSettings12, (String)"copyOf(...)");
        FLICKERING_GLOWSTONE = (FlickeringSolidBlock)ModBlocksAndItems.register$derelict$default(INSTANCE, "flickering_glowstone", new FlickeringSolidBlock((class_4970.class_2251)fabricBlockSettings12), null, 4, null);
        EXTINGUISHED_GLOWSTONE = ModBlocksAndItems.register$derelict$default(INSTANCE, "extinguished_glowstone", new class_2248((class_4970.class_2251)FabricBlockSettings.copyOf((class_4970)((class_4970)class_2246.field_10171)).luminance(ModBlocksAndItems::EXTINGUISHED_GLOWSTONE$lambda$6)), null, 4, null);
        FabricBlockSettings fabricBlockSettings13 = FabricBlockSettings.copyOf((class_4970)((class_4970)class_2246.field_22122));
        Intrinsics.checkNotNullExpressionValue((Object)fabricBlockSettings13, (String)"copyOf(...)");
        FLICKERING_SHROOMLIGHT = (FlickeringSolidBlock)ModBlocksAndItems.register$derelict$default(INSTANCE, "flickering_shroomlight", new FlickeringSolidBlock((class_4970.class_2251)fabricBlockSettings13), null, 4, null);
        EXTINGUISHED_SHROOMLIGHT = ModBlocksAndItems.register$derelict$default(INSTANCE, "extinguished_shroomlight", new class_2248((class_4970.class_2251)FabricBlockSettings.copyOf((class_4970)((class_4970)class_2246.field_22122)).luminance(ModBlocksAndItems::EXTINGUISHED_SHROOMLIGHT$lambda$7)), null, 4, null);
        FabricBlockSettings fabricBlockSettings14 = FabricBlockSettings.copyOf((class_4970)((class_4970)class_2246.field_10455));
        Intrinsics.checkNotNullExpressionValue((Object)fabricBlockSettings14, (String)"copyOf(...)");
        FLICKERING_END_ROD = (FlickeringEndRodBlock)ModBlocksAndItems.register$derelict$default(INSTANCE, "flickering_end_rod", (class_2248)new FlickeringEndRodBlock((class_4970.class_2251)fabricBlockSettings14), null, 4, null);
        FabricBlockSettings fabricBlockSettings15 = FabricBlockSettings.copyOf((class_4970)((class_4970)class_2246.field_10455)).luminance(ModBlocksAndItems::EXTINGUISHED_END_ROD$lambda$8);
        Intrinsics.checkNotNullExpressionValue((Object)fabricBlockSettings15, (String)"luminance(...)");
        EXTINGUISHED_END_ROD = (ExtinguishedEndRodBlock)ModBlocksAndItems.register$derelict$default(INSTANCE, "extinguished_end_rod", (class_2248)new ExtinguishedEndRodBlock((class_4970.class_2251)fabricBlockSettings15), null, 4, null);
        FabricBlockSettings fabricBlockSettings16 = FabricBlockSettings.copyOf((class_4970)((class_4970)class_2246.field_10343)).offset(class_4970.class_2250.field_10655).dynamicBounds();
        Intrinsics.checkNotNullExpressionValue((Object)fabricBlockSettings16, (String)"dynamicBounds(...)");
        FANCY_COBWEB = (FancyCobwebBlock)ModBlocksAndItems.register$derelict$default(INSTANCE, "fancy_cobweb", (class_2248)new FancyCobwebBlock((class_4970.class_2251)fabricBlockSettings16, false, 2, null), null, 4, null);
        FabricBlockSettings fabricBlockSettings17 = FabricBlockSettings.copyOf((class_4970)((class_4970)FANCY_COBWEB));
        Intrinsics.checkNotNullExpressionValue((Object)fabricBlockSettings17, (String)"copyOf(...)");
        FANCY_COBWEB_WITH_SPIDER_NEST = (FancyCobwebWithSpiderNestBlock)ModBlocksAndItems.register$derelict$default(INSTANCE, "fancy_cobweb_with_spider_nest", (class_2248)new FancyCobwebWithSpiderNestBlock((class_4970.class_2251)fabricBlockSettings17), null, 4, null);
        FabricBlockSettings fabricBlockSettings18 = FabricBlockSettings.copyOf((class_4970)((class_4970)class_2246.field_10343));
        Intrinsics.checkNotNullExpressionValue((Object)fabricBlockSettings18, (String)"copyOf(...)");
        CORNER_COBWEB = (FancyCornerCobwebBlock)ModBlocksAndItems.register$derelict$default(INSTANCE, "corner_cobweb", new FancyCornerCobwebBlock((class_4970.class_2251)fabricBlockSettings18), null, 4, null);
        FabricBlockSettings fabricBlockSettings19 = FabricBlockSettings.copyOf((class_4970)((class_4970)class_2246.field_10343));
        Intrinsics.checkNotNullExpressionValue((Object)fabricBlockSettings19, (String)"copyOf(...)");
        FANCY_CORNER_COBWEB = (FancyCornerCobwebBlock)ModBlocksAndItems.register$derelict$default(INSTANCE, "fancy_corner_cobweb", new FancyCornerCobwebBlock((class_4970.class_2251)fabricBlockSettings19), null, 4, null);
        Pair[] pairArray = FabricBlockSettings.copyOf((class_4970)((class_4970)class_2246.field_10343));
        WALL_COBWEB = (class_5778)ModBlocksAndItems.register$derelict$default(INSTANCE, "wall_cobweb", (class_2248)new class_5778((FabricBlockSettings)pairArray){

            public class_7118 method_41432() {
                return new class_7118((class_5778)this);
            }
        }, null, 4, null);
        class_4970.class_2251 class_22512 = class_4970.class_2251.method_9630((class_4970)((class_4970)class_2246.field_10446)).method_9634().method_9632(0.2f);
        Intrinsics.checkNotNullExpressionValue((Object)class_22512, (String)"strength(...)");
        SPIDER_SILK = (SpiderSilkBlock)ModBlocksAndItems.register$derelict$default(INSTANCE, "spider_silk", new SpiderSilkBlock(class_22512), null, 4, null);
        FabricBlockSettings fabricBlockSettings20 = FabricBlockSettings.copyOf((class_4970)((class_4970)class_2246.field_10446)).noCollision().breakInstantly();
        Intrinsics.checkNotNullExpressionValue((Object)fabricBlockSettings20, (String)"breakInstantly(...)");
        SPIDER_SILK_STRAND = (SpiderSilkStrandBlock)ModBlocksAndItems.register$derelict$default(INSTANCE, "spider_silk_strand", new SpiderSilkStrandBlock((class_4970.class_2251)fabricBlockSettings20), null, 4, null);
        SPIDER_EGG_BLOCK = ModBlocksAndItems.register$derelict$default(INSTANCE, "spider_egg_block", new class_2248((class_4970.class_2251)FabricBlockSettings.copyOf((class_4970)((class_4970)class_2246.field_37576))), null, 4, null);
        FabricBlockSettings fabricBlockSettings21 = FabricBlockSettings.copyOf((class_4970)((class_4970)class_2246.field_37576)).nonOpaque().noCollision().luminance(ModBlocksAndItems::SPIDER_EGG$lambda$9).offset(class_4970.class_2250.field_10657);
        Intrinsics.checkNotNullExpressionValue((Object)fabricBlockSettings21, (String)"offset(...)");
        SPIDER_EGG = (SpiderEggBlock)ModBlocksAndItems.register$derelict$default(INSTANCE, "spider_egg", (class_2248)new SpiderEggBlock((class_4970.class_2251)fabricBlockSettings21, true, null, null, false, 28, null), null, 4, null);
        FabricBlockSettings fabricBlockSettings22 = FabricBlockSettings.copyOf((class_4970)((class_4970)SPIDER_EGG));
        Intrinsics.checkNotNullExpressionValue((Object)fabricBlockSettings22, (String)"copyOf(...)");
        SPIDER_EGG_CLUSTER = (SpiderEggBlock)ModBlocksAndItems.register$derelict$default(INSTANCE, "spider_egg_cluster", (class_2248)new SpiderEggBlock((class_4970.class_2251)fabricBlockSettings22, false, null, null, false, 30, null), null, 4, null);
        FabricBlockSettings fabricBlockSettings23 = FabricBlockSettings.copyOf((class_4970)((class_4970)SPIDER_EGG));
        Intrinsics.checkNotNullExpressionValue((Object)fabricBlockSettings23, (String)"copyOf(...)");
        FAKE_SPIDER_EGG = (SpiderEggBlock)INSTANCE.registerBlock$derelict("fake_spider_egg", (class_2248)new SpiderEggBlock((class_4970.class_2251)fabricBlockSettings23, false, null, (Function1<? super class_5819, Integer>)((Function1)ModBlocksAndItems::FAKE_SPIDER_EGG$lambda$10), true));
        FabricBlockSettings fabricBlockSettings24 = FabricBlockSettings.copyOf((class_4970)((class_4970)SPIDER_EGG));
        Intrinsics.checkNotNullExpressionValue((Object)fabricBlockSettings24, (String)"copyOf(...)");
        SPIDERLING_SPIDER_EGG = (SpiderEggBlock)INSTANCE.registerBlock$derelict("spiderling_spider_egg", (class_2248)new SpiderEggBlock((class_4970.class_2251)fabricBlockSettings24, false, ModEntities.INSTANCE.getSPIDERLING(), ModBlocksAndItems::SPIDERLING_SPIDER_EGG$lambda$11, false, 16, null));
        FabricBlockSettings fabricBlockSettings25 = FabricBlockSettings.copyOf((class_4970)((class_4970)SPIDER_EGG));
        Intrinsics.checkNotNullExpressionValue((Object)fabricBlockSettings25, (String)"copyOf(...)");
        SPIDER_SPIDER_EGG = (SpiderEggBlock)INSTANCE.registerBlock$derelict("spider_spider_egg", (class_2248)new SpiderEggBlock((class_4970.class_2251)fabricBlockSettings25, true, class_1299.field_6079, null, false, 24, null));
        FabricBlockSettings fabricBlockSettings26 = FabricBlockSettings.copyOf((class_4970)((class_4970)SPIDER_EGG));
        Intrinsics.checkNotNullExpressionValue((Object)fabricBlockSettings26, (String)"copyOf(...)");
        CAVE_SPIDER_SPIDER_EGG = (SpiderEggBlock)INSTANCE.registerBlock$derelict("cave_spider_spider_egg", (class_2248)new SpiderEggBlock((class_4970.class_2251)fabricBlockSettings26, true, class_1299.field_6084, null, false, 24, null));
        FabricBlockSettings fabricBlockSettings27 = FabricBlockSettings.copyOf((class_4970)((class_4970)SPIDER_EGG));
        Intrinsics.checkNotNullExpressionValue((Object)fabricBlockSettings27, (String)"copyOf(...)");
        WEB_CASTER_SPIDER_EGG = (SpiderEggBlock)INSTANCE.registerBlock$derelict("web_caster_spider_egg", (class_2248)new SpiderEggBlock((class_4970.class_2251)fabricBlockSettings27, true, ModEntities.INSTANCE.getWEB_CASTER(), null, false, 24, null));
        FabricBlockSettings fabricBlockSettings28 = FabricBlockSettings.copyOf((class_4970)((class_4970)SPIDER_EGG));
        Intrinsics.checkNotNullExpressionValue((Object)fabricBlockSettings28, (String)"copyOf(...)");
        JUMPING_SPIDER_SPIDER_EGG = (SpiderEggBlock)INSTANCE.registerBlock$derelict("jumping_spider_spider_egg", (class_2248)new SpiderEggBlock((class_4970.class_2251)fabricBlockSettings28, true, ModEntities.INSTANCE.getJUMPING_SPIDER(), null, false, 24, null));
        FabricBlockSettings fabricBlockSettings29 = FabricBlockSettings.copyOf((class_4970)((class_4970)class_2246.field_37576)).nonOpaque();
        Intrinsics.checkNotNullExpressionValue((Object)fabricBlockSettings29, (String)"nonOpaque(...)");
        SPIDER_MOLT = (SpiderMoltBlock)ModBlocksAndItems.register$derelict$default(INSTANCE, "spider_molt", (class_2248)new SpiderMoltBlock((class_4970.class_2251)fabricBlockSettings29), null, 4, null);
        class_2960 class_29602 = Derelict.INSTANCE.id("arachnite");
        FabricBlockSettings fabricBlockSettings30 = FabricBlockSettings.copyOf((class_4970)((class_4970)class_2246.field_10340)).sounds(class_2498.field_37640);
        Intrinsics.checkNotNullExpressionValue((Object)fabricBlockSettings30, (String)"sounds(...)");
        ARACHNITE = new StoneSet(class_29602, fabricBlockSettings30).register();
        class_2960 class_29603 = Derelict.INSTANCE.id("noctisteel");
        FabricItemSettings fabricItemSettings3 = INSTANCE.defaultItemSettings();
        FabricBlockSettings fabricBlockSettings31 = FabricBlockSettings.copyOf((class_4970)((class_4970)class_2246.field_10085)).strength(2.0f, 1200.0f).nonOpaque();
        Intrinsics.checkNotNullExpressionValue((Object)fabricBlockSettings31, (String)"nonOpaque(...)");
        NOCTISTEEL = new MetalSet.ThreeLevelOxidizable(class_29603, fabricItemSettings3, fabricBlockSettings31).register();
        pairArray = INSTANCE.defaultItemSettings().maxCount(1);
        SPIDERLING_IN_A_BUCKET = ModBlocksAndItems.registerItem$derelict$default(INSTANCE, "spiderling_in_a_bucket", new class_1792((FabricItemSettings)pairArray){

            public class_1269 method_7884(class_1838 context) {
                block4: {
                    Intrinsics.checkNotNullParameter((Object)context, (String)"context");
                    if (context.method_8045().field_9236) {
                        return class_1269.field_5812;
                    }
                    class_1299<SpiderlingEntity> class_12992 = ModEntities.INSTANCE.getSPIDERLING();
                    class_1937 class_19372 = context.method_8045();
                    Intrinsics.checkNotNull((Object)class_19372, (String)"null cannot be cast to non-null type net.minecraft.server.world.ServerWorld");
                    SpiderlingEntity entity = (SpiderlingEntity)class_12992.method_5894((class_3218)class_19372, context.method_8041(), context.method_8036(), context.method_8037().method_10081(context.method_8038().method_10163()), class_3730.field_16473, true, false);
                    if (entity == null) break block4;
                    class_2487 class_24872 = context.method_8041().method_7948();
                    Intrinsics.checkNotNullExpressionValue((Object)class_24872, (String)"getOrCreateNbt(...)");
                    entity.method_35170(class_24872);
                    entity.method_6454(true);
                    if (context.method_8038() == class_2350.field_11033) {
                        entity.setAnchorPosition(context.method_8037());
                        entity.method_18800(0.0, -0.1, 0.0);
                    }
                    entity.method_5971();
                    context.method_8045().method_33596((class_1297)context.method_8036(), class_5712.field_28738, context.method_8037());
                    context.method_8045().method_8396(null, context.method_8037(), class_3417.field_14760, class_3419.field_15251, 1.0f, 1.0f);
                    class_1657 class_16572 = context.method_8036();
                    boolean bl = class_16572 != null ? !class_16572.method_7337() : false;
                    if (bl) {
                        class_1657 class_16573 = context.method_8036();
                        if (class_16573 != null) {
                            class_16573.method_6122(context.method_20287(), new class_1799((class_1935)class_1802.field_8550));
                        }
                    }
                }
                return class_1269.field_5812;
            }
        }, null, 4, null);
        pairArray = new Pair[20];
        pairArray[0] = TuplesKt.to((Object)class_2246.field_10524, (Object)FLICKERING_REDSTONE_LAMP);
        pairArray[1] = TuplesKt.to((Object)class_2246.field_10174, (Object)FLICKERING_SEA_LANTERN);
        pairArray[2] = TuplesKt.to((Object)FLICKERING_SEA_LANTERN, (Object)EXTINGUISHED_SEA_LANTERN);
        pairArray[3] = TuplesKt.to((Object)class_2246.field_10009, (Object)FLICKERING_JACK_O_LANTERN);
        pairArray[4] = TuplesKt.to((Object)class_2246.field_16541, (Object)FLICKERING_LANTERN);
        pairArray[5] = TuplesKt.to((Object)FLICKERING_LANTERN, (Object)EXTINGUISHED_LANTERN);
        pairArray[6] = TuplesKt.to((Object)class_2246.field_22110, (Object)FLICKERING_SOUL_LANTERN);
        pairArray[7] = TuplesKt.to((Object)FLICKERING_SOUL_LANTERN, (Object)EXTINGUISHED_LANTERN);
        pairArray[8] = TuplesKt.to((Object)class_2246.field_37572, (Object)FLICKERING_OCHRE_FROGLIGHT);
        pairArray[9] = TuplesKt.to((Object)FLICKERING_OCHRE_FROGLIGHT, (Object)EXTINGUISHED_OCHRE_FROGLIGHT);
        pairArray[10] = TuplesKt.to((Object)class_2246.field_37573, (Object)FLICKERING_VERDANT_FROGLIGHT);
        pairArray[11] = TuplesKt.to((Object)FLICKERING_VERDANT_FROGLIGHT, (Object)EXTINGUISHED_VERDANT_FROGLIGHT);
        pairArray[12] = TuplesKt.to((Object)class_2246.field_37574, (Object)FLICKERING_PEARLESCENT_FROGLIGHT);
        pairArray[13] = TuplesKt.to((Object)FLICKERING_PEARLESCENT_FROGLIGHT, (Object)EXTINGUISHED_PEARLESCENT_FROGLIGHT);
        pairArray[14] = TuplesKt.to((Object)class_2246.field_10171, (Object)FLICKERING_GLOWSTONE);
        pairArray[15] = TuplesKt.to((Object)FLICKERING_GLOWSTONE, (Object)EXTINGUISHED_GLOWSTONE);
        pairArray[16] = TuplesKt.to((Object)class_2246.field_22122, (Object)FLICKERING_SHROOMLIGHT);
        pairArray[17] = TuplesKt.to((Object)FLICKERING_SHROOMLIGHT, (Object)EXTINGUISHED_SHROOMLIGHT);
        pairArray[18] = TuplesKt.to((Object)class_2246.field_10455, (Object)FLICKERING_END_ROD);
        pairArray[19] = TuplesKt.to((Object)FLICKERING_END_ROD, (Object)((Object)EXTINGUISHED_END_ROD));
        BLOCK_AGING_MAP = MapsKt.mapOf((Pair[])pairArray);
        FabricItemSettings fabricItemSettings4 = INSTANCE.defaultItemSettings().maxCount(1);
        Intrinsics.checkNotNullExpressionValue((Object)fabricItemSettings4, (String)"maxCount(...)");
        WILDFIRE = (Wildfire)INSTANCE.registerItem$derelict("wildfire", (class_1792)new Wildfire((class_1792.class_1793)fabricItemSettings4), null);
        FabricItemSettings fabricItemSettings5 = INSTANCE.defaultItemSettings().maxCount(1);
        Intrinsics.checkNotNullExpressionValue((Object)fabricItemSettings5, (String)"maxCount(...)");
        ARACHNICANNON = (Arachnicannon)ModBlocksAndItems.registerItem$derelict$default(INSTANCE, "arachnicannon", new Arachnicannon((class_1792.class_1793)fabricItemSettings5), null, 4, null);
        SPIDER_SILK_BOLA = (SpiderSilkBola)ModBlocksAndItems.registerItem$derelict$default(INSTANCE, "spider_silk_bola", new SpiderSilkBola((class_1792.class_1793)INSTANCE.defaultItemSettings()), null, 4, null);
        NETWALKERS = (class_1738)ModBlocksAndItems.registerItem$derelict$default(INSTANCE, "netwalkers", (class_1792)new class_1738((class_1741)ModArmorMaterials.SPIDER, class_1738.class_8051.field_41936, (class_1792.class_1793)INSTANCE.defaultItemSettings().maxCount(1)), null, 4, null);
        SPIDER_SILK_GLAND = INSTANCE.registerSimpleItem$derelict("spider_silk_gland");
        SPIDER_PHEROMONE_GLAND = INSTANCE.registerSimpleItem$derelict("spider_pheromone_gland");
        WEB_CASTER_SPAWN_EGG = INSTANCE.registerSpawnEgg(ModEntities.INSTANCE.getWEB_CASTER());
        CHARMING_SPIDER_SPAWN_EGG = INSTANCE.registerSpawnEgg(ModEntities.INSTANCE.getCHARMING_SPIDER());
        DADDY_LONG_LEGS_SPAWN_EGG = INSTANCE.registerSpawnEgg(ModEntities.INSTANCE.getDADDY_LONG_LEGS());
        JUMPING_SPIDER_SPAWN_EGG = INSTANCE.registerSpawnEgg(ModEntities.INSTANCE.getJUMPING_SPIDER());
        SPINY_SPIDER_SPAWN_EGG = INSTANCE.registerSpawnEgg(ModEntities.INSTANCE.getSPINY_SPIDER());
    }

    @Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\u000b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004\u00a2\u0006\u0004\b\u0007\u0010\bR\u001d\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00040\t8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013\u00a8\u0006\u0014"}, d2={"Ldev/mim1q/derelict/init/ModBlocksAndItems$ItemCategory;", "", "<init>", "(Ljava/lang/String;I)V", "Lnet/minecraft/class_1792;", "item", "", "add", "(Lnet/minecraft/class_1792;)Z", "", "items", "Ljava/util/List;", "getItems", "()Ljava/util/List;", "GENERAL", "METAL_BLOCKS", "METAL_DECORATION", "WAXED_METAL_BLOCKS", "WAXED_METAL_DECORATION", "SPAWN_EGGS", "derelict"})
    public static final class ItemCategory
    extends Enum<ItemCategory> {
        @NotNull
        private final List<class_1792> items = new ArrayList();
        public static final /* enum */ ItemCategory GENERAL = new ItemCategory();
        public static final /* enum */ ItemCategory METAL_BLOCKS = new ItemCategory();
        public static final /* enum */ ItemCategory METAL_DECORATION = new ItemCategory();
        public static final /* enum */ ItemCategory WAXED_METAL_BLOCKS = new ItemCategory();
        public static final /* enum */ ItemCategory WAXED_METAL_DECORATION = new ItemCategory();
        public static final /* enum */ ItemCategory SPAWN_EGGS = new ItemCategory();
        private static final /* synthetic */ ItemCategory[] $VALUES;
        private static final /* synthetic */ EnumEntries $ENTRIES;

        @NotNull
        public final List<class_1792> getItems() {
            return this.items;
        }

        public final boolean add(@NotNull class_1792 item) {
            Intrinsics.checkNotNullParameter((Object)item, (String)"item");
            return this.items.add(item);
        }

        public static ItemCategory[] values() {
            return (ItemCategory[])$VALUES.clone();
        }

        public static ItemCategory valueOf(String value) {
            return Enum.valueOf(ItemCategory.class, value);
        }

        @NotNull
        public static EnumEntries<ItemCategory> getEntries() {
            return $ENTRIES;
        }

        static {
            $VALUES = itemCategoryArray = new ItemCategory[]{ItemCategory.GENERAL, ItemCategory.METAL_BLOCKS, ItemCategory.METAL_DECORATION, ItemCategory.WAXED_METAL_BLOCKS, ItemCategory.WAXED_METAL_DECORATION, ItemCategory.SPAWN_EGGS};
            $ENTRIES = EnumEntriesKt.enumEntries((Enum[])$VALUES);
        }
    }
}

