/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Deprecated
 *  kotlin.Metadata
 *  kotlin.Pair
 *  kotlin.TuplesKt
 *  kotlin.collections.CollectionsKt
 *  kotlin.jvm.functions.Function0
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  net.minecraft.class_1923
 *  net.minecraft.class_1937
 *  net.minecraft.class_2246
 *  net.minecraft.class_2338
 *  net.minecraft.class_2374
 *  net.minecraft.class_2382
 *  net.minecraft.class_2586
 *  net.minecraft.class_2680
 *  net.minecraft.class_2818
 *  net.minecraft.class_3218
 *  net.minecraft.class_3492
 *  net.minecraft.class_3499
 *  net.minecraft.class_3829
 *  net.minecraft.class_5425
 *  net.minecraft.server.MinecraftServer
 */
package org.valkyrienskies.mod.common.assembly;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import net.minecraft.class_1923;
import net.minecraft.class_1937;
import net.minecraft.class_2246;
import net.minecraft.class_2338;
import net.minecraft.class_2374;
import net.minecraft.class_2382;
import net.minecraft.class_2586;
import net.minecraft.class_2680;
import net.minecraft.class_2818;
import net.minecraft.class_3218;
import net.minecraft.class_3492;
import net.minecraft.class_3499;
import net.minecraft.class_3829;
import net.minecraft.class_5425;
import net.minecraft.server.MinecraftServer;
import org.jetbrains.annotations.NotNull;
import org.joml.Vector3d;
import org.joml.Vector3ic;
import org.valkyrienskies.core.api.bodies.properties.BodyTransform;
import org.valkyrienskies.core.api.ships.ServerShip;
import org.valkyrienskies.core.internal.VsiCore;
import org.valkyrienskies.core.internal.ships.VsiShip;
import org.valkyrienskies.core.internal.world.VsiServerShipWorld;
import org.valkyrienskies.core.util.datastructures.BlockPos2ObjectOpenHashMap;
import org.valkyrienskies.core.util.datastructures.DenseBlockPosSet;
import org.valkyrienskies.core.util.datastructures.SingleChunkDenseBlockPosSet;
import org.valkyrienskies.mod.api.ValkyrienSkies;
import org.valkyrienskies.mod.common.VSGameUtilsKt;
import org.valkyrienskies.mod.common.util.VectorConversionsMCKt;
import org.valkyrienskies.mod.util.RelocationUtilKt;

@Metadata(mv={2, 0, 0}, k=2, xi=48, d1={"\u0000\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a'\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0007\u00a2\u0006\u0004\b\u0007\u0010\b\u001a-\u0010\f\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u0004\u00a2\u0006\u0004\b\f\u0010\r\u00a8\u0006\u000e"}, d2={"Lnet/minecraft/class_2338;", "centerBlock", "Lorg/valkyrienskies/core/util/datastructures/DenseBlockPosSet;", "blocks", "Lnet/minecraft/class_3218;", "level", "Lorg/valkyrienskies/core/api/ships/ServerShip;", "createNewShipWithBlocks", "(Lnet/minecraft/class_2338;Lorg/valkyrienskies/core/util/datastructures/DenseBlockPosSet;Lnet/minecraft/class_3218;)Lorg/valkyrienskies/core/api/ships/ServerShip;", "lowerCorner", "higherCorner", "Lnet/minecraft/class_3499;", "createNewShipWithStructure", "(Lnet/minecraft/class_2338;Lnet/minecraft/class_2338;Lnet/minecraft/class_3499;Lnet/minecraft/class_3218;)Lorg/valkyrienskies/core/api/ships/ServerShip;", "valkyrienskies-120"})
@SourceDebugExtension(value={"SMAP\nShipAssembly.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ShipAssembly.kt\norg/valkyrienskies/mod/common/assembly/ShipAssemblyKt\n+ 2 DenseBlockPosSet.kt\norg/valkyrienskies/core/util/datastructures/DenseBlockPosSet\n+ 3 BlockPos2ObjectOpenHashMap.kt\norg/valkyrienskies/core/util/datastructures/BlockPos2ObjectOpenHashMap\n+ 4 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 5 SingleChunkDenseBlockPosSet.kt\norg/valkyrienskies/core/util/datastructures/SingleChunkDenseBlockPosSet\n+ 6 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n+ 7 Util.kt\norg/valkyrienskies/core/util/UtilKt\n*L\n1#1,160:1\n78#2:161\n79#2,2:164\n81#2:172\n78#2:183\n79#2:186\n80#2:209\n81#2:229\n78#2:230\n79#2:233\n80#2:256\n81#2:283\n68#3,2:162\n72#3,6:166\n68#3,2:184\n72#3,3:210\n77#3:228\n68#3,2:231\n72#3,3:257\n77#3:282\n1368#4:173\n1454#4,5:174\n1557#4:179\n1628#4,3:180\n1734#4,3:284\n24#5:187\n25#5:190\n26#5,2:194\n28#5,4:201\n32#5:206\n33#5:208\n25#5,3:213\n28#5,4:221\n32#5,2:226\n24#5:234\n25#5:237\n26#5,2:241\n28#5,4:248\n32#5:253\n33#5:255\n24#5:260\n25#5:263\n26#5,2:267\n28#5,4:274\n32#5:279\n33#5:281\n13477#6,2:188\n13479#6:207\n13477#6,2:235\n13479#6:254\n13477#6,2:261\n13479#6:280\n10#7,3:191\n66#7,5:196\n14#7:205\n66#7,5:216\n14#7:225\n10#7,3:238\n66#7,5:243\n14#7:252\n10#7,3:264\n66#7,5:269\n14#7:278\n*S KotlinDebug\n*F\n+ 1 ShipAssembly.kt\norg/valkyrienskies/mod/common/assembly/ShipAssemblyKt\n*L\n44#1:161\n44#1:164,2\n44#1:172\n58#1:183\n58#1:186\n58#1:209\n58#1:229\n68#1:230\n68#1:233\n68#1:256\n68#1:283\n44#1:162,2\n44#1:166,6\n58#1:184,2\n58#1:210,3\n58#1:228\n68#1:231,2\n68#1:257,3\n68#1:282\n50#1:173\n50#1:174,5\n51#1:179\n51#1:180,3\n95#1:284,3\n61#1:187\n61#1:190\n61#1:194,2\n61#1:201,4\n61#1:206\n61#1:208\n61#1:213,3\n61#1:221,4\n61#1:226,2\n71#1:234\n71#1:237\n71#1:241,2\n71#1:248,4\n71#1:253\n71#1:255\n71#1:260\n71#1:263\n71#1:267,2\n71#1:274,4\n71#1:279\n71#1:281\n61#1:188,2\n61#1:207\n71#1:235,2\n71#1:254\n71#1:261,2\n71#1:280\n61#1:191,3\n61#1:196,5\n61#1:205\n61#1:216,5\n61#1:225\n71#1:238,3\n71#1:243,5\n71#1:252\n71#1:264,3\n71#1:269,5\n71#1:278\n*E\n"})
public final class ShipAssemblyKt {
    /*
     * WARNING - void declaration
     */
    @Deprecated(message="Use [ShipAssembler.assembleToShip] instead")
    @NotNull
    public static final ServerShip createNewShipWithBlocks(@NotNull class_2338 centerBlock, @NotNull DenseBlockPosSet blocks, @NotNull class_3218 level) {
        boolean bl;
        boolean bl2;
        int pos$iv$iv;
        class_2338 toPos;
        class_2338 fromPos;
        int z;
        int y;
        boolean bl3;
        int x;
        int y$iv;
        int z$iv;
        boolean bl4;
        int x$iv;
        int x$iv$iv;
        int y$iv$iv;
        int z$iv$iv;
        int index$iv$iv;
        boolean $i$f$unwrapIndex;
        Vector3ic dimensions$iv$iv;
        int bitIndex$iv;
        boolean bl5;
        boolean isSet$iv;
        int masked$iv$iv;
        int i$iv$iv;
        boolean $i$f$iterateBits;
        byte $this$iterateBits$iv$iv;
        byte byte$iv;
        boolean bl6;
        int index$iv;
        int index$iv$iv2;
        boolean $i$f$forEachIndexed;
        byte[] $this$forEachIndexed$iv$iv;
        boolean $i$f$forEach;
        SingleChunkDenseBlockPosSet this_$iv;
        class_2818 destChunk;
        class_2818 sourceChunk;
        int chunkZ;
        boolean bl7;
        boolean bl8;
        int x$iv2;
        void $this$mapTo$iv$iv;
        void $this$flatMapTo$iv$iv;
        Object chunk$iv;
        class_1923 destPos;
        class_1923 sourcePos;
        int z2;
        boolean bl9;
        int x2;
        int z$iv2;
        boolean bl10;
        int x$iv3;
        Intrinsics.checkNotNullParameter((Object)centerBlock, (String)"centerBlock");
        Intrinsics.checkNotNullParameter((Object)blocks, (String)"blocks");
        Intrinsics.checkNotNullParameter((Object)level, (String)"level");
        if (blocks.isEmpty()) {
            throw new IllegalArgumentException();
        }
        ServerShip ship = VSGameUtilsKt.getShipObjectWorld(level).createNewShipAtBlock(VectorConversionsMCKt.toJOML((class_2382)centerBlock), false, 1.0, VSGameUtilsKt.getDimensionId((class_1937)level));
        int shipChunkX = ship.getChunkClaim().getXMiddle();
        int shipChunkZ = ship.getChunkClaim().getZMiddle();
        int worldChunkX = centerBlock.method_10263() >> 4;
        int worldChunkZ = centerBlock.method_10260() >> 4;
        int deltaX = worldChunkX - shipChunkX;
        int deltaZ = worldChunkZ - shipChunkZ;
        Map chunksToBeUpdated = new LinkedHashMap();
        DenseBlockPosSet this_$iv2 = blocks;
        boolean $i$f$forEachChunk = false;
        BlockPos2ObjectOpenHashMap<SingleChunkDenseBlockPosSet> this_$iv$iv = this_$iv2.getChunks();
        boolean $i$f$forEach2 = false;
        if (this_$iv$iv.getContainsNullKey()) {
            SingleChunkDenseBlockPosSet singleChunkDenseBlockPosSet = this_$iv$iv.getValues()[this_$iv$iv.getN()];
            int n2 = this_$iv$iv.getKeys()[this_$iv$iv.getN() * 3 + 2];
            int n3 = this_$iv$iv.getKeys()[this_$iv$iv.getN() * 3 + 1];
            x$iv3 = this_$iv$iv.getKeys()[this_$iv$iv.getN() * 3];
            bl10 = false;
            void var21_39 = z$iv2;
            x2 = x$iv3;
            bl9 = false;
            sourcePos = new class_1923(x2, z2);
            destPos = new class_1923(x2 - deltaX, z2 - deltaZ);
            chunksToBeUpdated.put(sourcePos, new Pair((Object)sourcePos, (Object)destPos));
        }
        for (int pos$iv$iv2 = this_$iv$iv.getN(); -1 < pos$iv$iv2; --pos$iv$iv2) {
            if (this_$iv$iv.getKeys()[pos$iv$iv2 * 3] == 0 && this_$iv$iv.getKeys()[pos$iv$iv2 * 3 + 1] == 0 && this_$iv$iv.getKeys()[pos$iv$iv2 * 3 + 2] == 0) continue;
            chunk$iv = this_$iv$iv.getValues()[pos$iv$iv2];
            z$iv2 = this_$iv$iv.getKeys()[pos$iv$iv2 * 3 + 2];
            int y$iv2 = this_$iv$iv.getKeys()[pos$iv$iv2 * 3 + 1];
            x$iv3 = this_$iv$iv.getKeys()[pos$iv$iv2 * 3];
            bl10 = false;
            z2 = z$iv2;
            x2 = x$iv3;
            bl9 = false;
            sourcePos = new class_1923(x2, z2);
            destPos = new class_1923(x2 - deltaX, z2 - deltaZ);
            chunksToBeUpdated.put(sourcePos, new Pair((Object)sourcePos, (Object)destPos));
        }
        List chunkPairs = CollectionsKt.toList((Iterable)chunksToBeUpdated.values());
        Iterable $this$flatMap$iv = chunkPairs;
        boolean $i$f$flatMap = false;
        chunk$iv = $this$flatMap$iv;
        Iterable destination$iv$iv = new ArrayList();
        boolean $i$f$flatMapTo = false;
        for (Object element$iv$iv : $this$flatMapTo$iv$iv) {
            Pair it = (Pair)element$iv$iv;
            boolean bl11 = false;
            Iterable list$iv$iv = TuplesKt.toList((Pair)it);
            CollectionsKt.addAll((Collection)destination$iv$iv, (Iterable)list$iv$iv);
        }
        List chunkPoses = (List)destination$iv$iv;
        Iterable $this$map$iv = chunkPoses;
        boolean $i$f$map = false;
        destination$iv$iv = $this$map$iv;
        Collection destination$iv$iv2 = new ArrayList(CollectionsKt.collectionSizeOrDefault((Iterable)$this$map$iv, (int)10));
        boolean $i$f$mapTo2 = false;
        for (Object item$iv$iv : $this$mapTo$iv$iv) {
            void it;
            class_1923 bl11 = (class_1923)item$iv$iv;
            Collection collection = destination$iv$iv2;
            boolean bl12 = false;
            collection.add(VectorConversionsMCKt.toJOML((class_1923)it));
        }
        List chunkPosesJOML = (List)destination$iv$iv2;
        DenseBlockPosSet this_$iv3 = blocks;
        boolean $i$f$forEachChunk2 = false;
        BlockPos2ObjectOpenHashMap<SingleChunkDenseBlockPosSet> this_$iv$iv2 = this_$iv3.getChunks();
        boolean $i$f$forEach3 = false;
        if (this_$iv$iv2.getContainsNullKey()) {
            void chunk;
            void y$iv3;
            void z$iv3;
            void chunk$iv2;
            SingleChunkDenseBlockPosSet $i$f$mapTo2 = this_$iv$iv2.getValues()[this_$iv$iv2.getN()];
            int element$iv$iv = this_$iv$iv2.getKeys()[this_$iv$iv2.getN() * 3 + 2];
            int item$iv$iv = this_$iv$iv2.getKeys()[this_$iv$iv2.getN() * 3 + 1];
            x$iv2 = this_$iv$iv2.getKeys()[this_$iv$iv2.getN() * 3];
            bl8 = false;
            void x3 = chunk$iv2;
            bl9 = z$iv3;
            void sourcePos2 = y$iv3;
            int chunkX = x$iv2;
            bl7 = false;
            sourceChunk = level.method_8497(chunkX, chunkZ);
            destChunk = level.method_8497(chunkX - deltaX, chunkZ - deltaZ);
            this_$iv = chunk;
            $i$f$forEach = false;
            $this$forEachIndexed$iv$iv = this_$iv.getData();
            $i$f$forEachIndexed = false;
            index$iv$iv2 = 0;
            for (byte item$iv$iv2 : $this$forEachIndexed$iv$iv) {
                int n4 = index$iv$iv2++;
                byte by = item$iv$iv2;
                index$iv = n4;
                bl6 = false;
                $this$iterateBits$iv$iv = byte$iv;
                $i$f$iterateBits = false;
                for (i$iv$iv = 7; -1 < i$iv$iv; --i$iv$iv) {
                    void chunkY;
                    int n5 = i$iv$iv;
                    masked$iv$iv = $this$iterateBits$iv$iv & 1 << i$iv$iv;
                    isSet$iv = masked$iv$iv != 0;
                    bl5 = false;
                    if (!isSet$iv) continue;
                    int n6 = index$iv * 8 + bitIndex$iv;
                    dimensions$iv$iv = SingleChunkDenseBlockPosSet.Companion.getDimensions();
                    $i$f$unwrapIndex = false;
                    z$iv$iv = index$iv$iv / (dimensions$iv$iv.x() * dimensions$iv$iv.y());
                    y$iv$iv = (index$iv$iv - z$iv$iv * dimensions$iv$iv.x() * dimensions$iv$iv.y()) / dimensions$iv$iv.x();
                    x$iv$iv = (index$iv$iv - z$iv$iv * dimensions$iv$iv.x() * dimensions$iv$iv.y()) % dimensions$iv$iv.x();
                    int n7 = z$iv$iv;
                    int n8 = y$iv$iv;
                    x$iv = x$iv$iv;
                    bl4 = false;
                    void var58_96 = z$iv;
                    void var59_97 = y$iv;
                    x = x$iv;
                    bl3 = false;
                    fromPos = new class_2338((sourceChunk.method_12004().field_9181 << 4) + x, (int)((chunkY << 4) + y), (sourceChunk.method_12004().field_9180 << 4) + z);
                    toPos = new class_2338((destChunk.method_12004().field_9181 << 4) + x, (int)((chunkY << 4) + y), (destChunk.method_12004().field_9180 << 4) + z);
                    Intrinsics.checkNotNull((Object)sourceChunk);
                    Intrinsics.checkNotNull((Object)destChunk);
                    RelocationUtilKt.relocateBlock$default(sourceChunk, fromPos, destChunk, toPos, false, ship, null, 64, null);
                }
            }
        }
        for (pos$iv$iv = this_$iv$iv2.getN(); -1 < pos$iv$iv; --pos$iv$iv) {
            if (this_$iv$iv2.getKeys()[pos$iv$iv * 3] == 0 && this_$iv$iv2.getKeys()[pos$iv$iv * 3 + 1] == 0 && this_$iv$iv2.getKeys()[pos$iv$iv * 3 + 2] == 0) continue;
            SingleChunkDenseBlockPosSet chunk$iv2 = this_$iv$iv2.getValues()[pos$iv$iv];
            int z$iv3 = this_$iv$iv2.getKeys()[pos$iv$iv * 3 + 2];
            int y$iv3 = this_$iv$iv2.getKeys()[pos$iv$iv * 3 + 1];
            x$iv2 = this_$iv$iv2.getKeys()[pos$iv$iv * 3];
            bl8 = false;
            SingleChunkDenseBlockPosSet chunk = chunk$iv2;
            chunkZ = z$iv3;
            int chunkY = y$iv3;
            int chunkX = x$iv2;
            bl7 = false;
            sourceChunk = level.method_8497(chunkX, chunkZ);
            destChunk = level.method_8497(chunkX - deltaX, chunkZ - deltaZ);
            this_$iv = chunk;
            $i$f$forEach = false;
            $this$forEachIndexed$iv$iv = this_$iv.getData();
            $i$f$forEachIndexed = false;
            index$iv$iv2 = 0;
            for (byte item$iv$iv2 : $this$forEachIndexed$iv$iv) {
                int n9 = index$iv$iv2++;
                byte$iv = item$iv$iv2;
                index$iv = n9;
                bl6 = false;
                $this$iterateBits$iv$iv = byte$iv;
                $i$f$iterateBits = false;
                for (i$iv$iv = 7; -1 < i$iv$iv; --i$iv$iv) {
                    masked$iv$iv = $this$iterateBits$iv$iv & 1 << i$iv$iv;
                    boolean bl13 = masked$iv$iv != 0;
                    bitIndex$iv = i$iv$iv;
                    isSet$iv = bl13;
                    bl5 = false;
                    if (!isSet$iv) continue;
                    index$iv$iv = index$iv * 8 + bitIndex$iv;
                    dimensions$iv$iv = SingleChunkDenseBlockPosSet.Companion.getDimensions();
                    $i$f$unwrapIndex = false;
                    z$iv$iv = index$iv$iv / (dimensions$iv$iv.x() * dimensions$iv$iv.y());
                    y$iv$iv = (index$iv$iv - z$iv$iv * dimensions$iv$iv.x() * dimensions$iv$iv.y()) / dimensions$iv$iv.x();
                    x$iv$iv = (index$iv$iv - z$iv$iv * dimensions$iv$iv.x() * dimensions$iv$iv.y()) % dimensions$iv$iv.x();
                    z$iv = z$iv$iv;
                    y$iv = y$iv$iv;
                    x$iv = x$iv$iv;
                    bl4 = false;
                    z = z$iv;
                    y = y$iv;
                    x = x$iv;
                    bl3 = false;
                    fromPos = new class_2338((sourceChunk.method_12004().field_9181 << 4) + x, (chunkY << 4) + y, (sourceChunk.method_12004().field_9180 << 4) + z);
                    toPos = new class_2338((destChunk.method_12004().field_9181 << 4) + x, (chunkY << 4) + y, (destChunk.method_12004().field_9180 << 4) + z);
                    Intrinsics.checkNotNull((Object)sourceChunk);
                    Intrinsics.checkNotNull((Object)destChunk);
                    RelocationUtilKt.relocateBlock$default(sourceChunk, fromPos, destChunk, toPos, false, ship, null, 64, null);
                }
            }
        }
        this_$iv3 = blocks;
        $i$f$forEachChunk2 = false;
        this_$iv$iv2 = this_$iv3.getChunks();
        $i$f$forEach3 = false;
        if (this_$iv$iv2.getContainsNullKey()) {
            SingleChunkDenseBlockPosSet chunk$iv3 = this_$iv$iv2.getValues()[this_$iv$iv2.getN()];
            int z$iv4 = this_$iv$iv2.getKeys()[this_$iv$iv2.getN() * 3 + 2];
            int y$iv4 = this_$iv$iv2.getKeys()[this_$iv$iv2.getN() * 3 + 1];
            x$iv2 = this_$iv$iv2.getKeys()[this_$iv$iv2.getN() * 3];
            bl8 = false;
            SingleChunkDenseBlockPosSet chunk = chunk$iv3;
            chunkZ = z$iv4;
            int chunkY = y$iv4;
            int chunkX = x$iv2;
            bl2 = false;
            sourceChunk = level.method_8497(chunkX, chunkZ);
            destChunk = level.method_8497(chunkX - deltaX, chunkZ - deltaZ);
            this_$iv = chunk;
            $i$f$forEach = false;
            $this$forEachIndexed$iv$iv = this_$iv.getData();
            $i$f$forEachIndexed = false;
            index$iv$iv2 = 0;
            for (byte item$iv$iv2 : $this$forEachIndexed$iv$iv) {
                int n10 = index$iv$iv2++;
                byte$iv = item$iv$iv2;
                index$iv = n10;
                bl6 = false;
                $this$iterateBits$iv$iv = byte$iv;
                $i$f$iterateBits = false;
                for (i$iv$iv = 7; -1 < i$iv$iv; --i$iv$iv) {
                    masked$iv$iv = $this$iterateBits$iv$iv & 1 << i$iv$iv;
                    boolean bl14 = masked$iv$iv != 0;
                    bitIndex$iv = i$iv$iv;
                    isSet$iv = bl14;
                    bl5 = false;
                    if (!isSet$iv) continue;
                    index$iv$iv = index$iv * 8 + bitIndex$iv;
                    dimensions$iv$iv = SingleChunkDenseBlockPosSet.Companion.getDimensions();
                    $i$f$unwrapIndex = false;
                    z$iv$iv = index$iv$iv / (dimensions$iv$iv.x() * dimensions$iv$iv.y());
                    y$iv$iv = (index$iv$iv - z$iv$iv * dimensions$iv$iv.x() * dimensions$iv$iv.y()) / dimensions$iv$iv.x();
                    x$iv$iv = (index$iv$iv - z$iv$iv * dimensions$iv$iv.x() * dimensions$iv$iv.y()) % dimensions$iv$iv.x();
                    z$iv = z$iv$iv;
                    y$iv = y$iv$iv;
                    x$iv = x$iv$iv;
                    bl4 = false;
                    z = z$iv;
                    y = y$iv;
                    x = x$iv;
                    bl = false;
                    fromPos = new class_2338((sourceChunk.method_12004().field_9181 << 4) + x, (chunkY << 4) + y, (sourceChunk.method_12004().field_9180 << 4) + z);
                    toPos = new class_2338((destChunk.method_12004().field_9181 << 4) + x, (chunkY << 4) + y, (destChunk.method_12004().field_9180 << 4) + z);
                    class_1937 class_19372 = destChunk.method_12200();
                    Intrinsics.checkNotNullExpressionValue((Object)class_19372, (String)"getLevel(...)");
                    class_2680 class_26802 = destChunk.method_8320(toPos);
                    Intrinsics.checkNotNullExpressionValue((Object)class_26802, (String)"getBlockState(...)");
                    RelocationUtilKt.updateBlock(class_19372, fromPos, toPos, class_26802);
                }
            }
        }
        for (pos$iv$iv = this_$iv$iv2.getN(); -1 < pos$iv$iv; --pos$iv$iv) {
            if (this_$iv$iv2.getKeys()[pos$iv$iv * 3] == 0 && this_$iv$iv2.getKeys()[pos$iv$iv * 3 + 1] == 0 && this_$iv$iv2.getKeys()[pos$iv$iv * 3 + 2] == 0) continue;
            SingleChunkDenseBlockPosSet chunk$iv4 = this_$iv$iv2.getValues()[pos$iv$iv];
            int z$iv5 = this_$iv$iv2.getKeys()[pos$iv$iv * 3 + 2];
            int y$iv5 = this_$iv$iv2.getKeys()[pos$iv$iv * 3 + 1];
            x$iv2 = this_$iv$iv2.getKeys()[pos$iv$iv * 3];
            bl8 = false;
            SingleChunkDenseBlockPosSet chunk = chunk$iv4;
            chunkZ = z$iv5;
            int chunkY = y$iv5;
            int chunkX = x$iv2;
            bl2 = false;
            sourceChunk = level.method_8497(chunkX, chunkZ);
            destChunk = level.method_8497(chunkX - deltaX, chunkZ - deltaZ);
            this_$iv = chunk;
            $i$f$forEach = false;
            $this$forEachIndexed$iv$iv = this_$iv.getData();
            $i$f$forEachIndexed = false;
            index$iv$iv2 = 0;
            for (byte item$iv$iv2 : $this$forEachIndexed$iv$iv) {
                int n11 = index$iv$iv2++;
                byte$iv = item$iv$iv2;
                index$iv = n11;
                bl6 = false;
                $this$iterateBits$iv$iv = byte$iv;
                $i$f$iterateBits = false;
                for (i$iv$iv = 7; -1 < i$iv$iv; --i$iv$iv) {
                    masked$iv$iv = $this$iterateBits$iv$iv & 1 << i$iv$iv;
                    boolean bl15 = masked$iv$iv != 0;
                    bitIndex$iv = i$iv$iv;
                    isSet$iv = bl15;
                    bl5 = false;
                    if (!isSet$iv) continue;
                    index$iv$iv = index$iv * 8 + bitIndex$iv;
                    dimensions$iv$iv = SingleChunkDenseBlockPosSet.Companion.getDimensions();
                    $i$f$unwrapIndex = false;
                    z$iv$iv = index$iv$iv / (dimensions$iv$iv.x() * dimensions$iv$iv.y());
                    y$iv$iv = (index$iv$iv - z$iv$iv * dimensions$iv$iv.x() * dimensions$iv$iv.y()) / dimensions$iv$iv.x();
                    x$iv$iv = (index$iv$iv - z$iv$iv * dimensions$iv$iv.x() * dimensions$iv$iv.y()) % dimensions$iv$iv.x();
                    z$iv = z$iv$iv;
                    y$iv = y$iv$iv;
                    x$iv = x$iv$iv;
                    bl4 = false;
                    z = z$iv;
                    y = y$iv;
                    x = x$iv;
                    bl = false;
                    fromPos = new class_2338((sourceChunk.method_12004().field_9181 << 4) + x, (chunkY << 4) + y, (sourceChunk.method_12004().field_9180 << 4) + z);
                    toPos = new class_2338((destChunk.method_12004().field_9181 << 4) + x, (chunkY << 4) + y, (destChunk.method_12004().field_9180 << 4) + z);
                    class_1937 class_19373 = destChunk.method_12200();
                    Intrinsics.checkNotNullExpressionValue((Object)class_19373, (String)"getLevel(...)");
                    class_2680 class_26803 = destChunk.method_8320(toPos);
                    Intrinsics.checkNotNullExpressionValue((Object)class_26803, (String)"getBlockState(...)");
                    RelocationUtilKt.updateBlock(class_19373, fromPos, toPos, class_26803);
                }
            }
        }
        Vector3d centerInShip = new Vector3d((shipChunkX << 4) + (centerBlock.method_10263() & 0xF), centerBlock.method_10264(), (shipChunkZ << 4) + (centerBlock.method_10260() & 0xF));
        Vector3d centerBlockPosInWorld = ship.getInertiaData().getCenterOfMass().sub(centerInShip, new Vector3d()).add(ship.getTransform().getPositionInWorld());
        Intrinsics.checkNotNull((Object)ship, (String)"null cannot be cast to non-null type org.valkyrienskies.core.internal.ships.VsiShip");
        VsiShip vsiShip = (VsiShip)((Object)ship);
        BodyTransform.Factory factory = ValkyrienSkies.api().getTransformFactory();
        Intrinsics.checkNotNull((Object)centerBlockPosInWorld);
        vsiShip.setFromTransform(factory.create(centerBlockPosInWorld, ship.getTransform().getRotation(), ship.getTransform().getScaling(), ship.getTransform().getPositionInShip()));
        MinecraftServer minecraftServer = level.method_8503();
        Intrinsics.checkNotNullExpressionValue((Object)minecraftServer, (String)"getServer(...)");
        VSGameUtilsKt.executeIf(minecraftServer, (Function0<Boolean>)((Function0)() -> ShipAssemblyKt.createNewShipWithBlocks$lambda$7(chunkPoses, level)), ShipAssemblyKt::createNewShipWithBlocks$lambda$8);
        return ship;
    }

    @NotNull
    public static final ServerShip createNewShipWithStructure(@NotNull class_2338 lowerCorner, @NotNull class_2338 higherCorner, @NotNull class_3499 blocks, @NotNull class_3218 level) {
        Intrinsics.checkNotNullParameter((Object)lowerCorner, (String)"lowerCorner");
        Intrinsics.checkNotNullParameter((Object)higherCorner, (String)"higherCorner");
        Intrinsics.checkNotNullParameter((Object)blocks, (String)"blocks");
        Intrinsics.checkNotNullParameter((Object)level, (String)"level");
        ServerShip ship = VSGameUtilsKt.getShipObjectWorld(level).createNewShipAtBlock(VectorConversionsMCKt.toJOML((class_2382)lowerCorner), false, 1.0, VSGameUtilsKt.getDimensionId((class_1937)level));
        int shipChunkX = ship.getChunkClaim().getXMiddle();
        int shipChunkZ = ship.getChunkClaim().getZMiddle();
        Vector3d lowerCornerInShip = new Vector3d((shipChunkX << 4) + (lowerCorner.method_10263() & 0xF), lowerCorner.method_10264(), (shipChunkZ << 4) + (lowerCorner.method_10260() & 0xF));
        Vector3d higherCornerInShip = new Vector3d((shipChunkX << 4) + (higherCorner.method_10263() & 0xF), higherCorner.method_10264(), (shipChunkZ << 4) + (higherCorner.method_10260() & 0xF));
        blocks.method_15172((class_5425)level, class_2338.method_49638((class_2374)((class_2374)VectorConversionsMCKt.toMinecraft(lowerCornerInShip))), class_2338.method_49638((class_2374)((class_2374)VectorConversionsMCKt.toMinecraft(lowerCornerInShip))), new class_3492(), level.field_9229, 3);
        class_2338 diff = higherCorner.method_10059((class_2382)lowerCorner);
        Vector3d centerPos = VectorConversionsMCKt.toJOMLD((class_2382)lowerCorner).add((double)diff.method_10263() + 0.5, (double)diff.method_10264() + 0.5, (double)diff.method_10260() + 0.5);
        Vector3d centerBlockPosInWorld = ship.getInertiaData().getCenterOfMass().sub(centerPos, new Vector3d()).add(ship.getTransform().getPositionInWorld());
        VsiServerShipWorld vsiServerShipWorld = VSGameUtilsKt.getShipObjectWorld(level);
        VsiCore vsiCore = VSGameUtilsKt.getVsCore();
        Vector3d vector3d = centerBlockPosInWorld.add(0.5, 128.5 - centerBlockPosInWorld.y, 0.5, new Vector3d());
        Intrinsics.checkNotNullExpressionValue((Object)vector3d, (String)"add(...)");
        vsiServerShipWorld.teleportShip(ship, VsiCore.newShipTeleportData$default(vsiCore, vector3d, null, null, null, null, null, ship.getInertiaData().getCenterOfMass(), 62, null));
        int x = lowerCorner.method_10263();
        int n2 = higherCorner.method_10263();
        if (x <= n2) {
            while (true) {
                int n3;
                int y;
                if ((y = lowerCorner.method_10264()) <= (n3 = higherCorner.method_10264())) {
                    while (true) {
                        int n4;
                        int z;
                        if ((z = lowerCorner.method_10260()) <= (n4 = higherCorner.method_10260())) {
                            while (true) {
                                if (!level.method_8320(new class_2338(x, y, z)).method_26215()) {
                                    class_2586 blockEntity = level.method_8321(new class_2338(x, y, z));
                                    class_3829.method_16825((Object)blockEntity);
                                    level.method_8544(new class_2338(x, y, z));
                                    level.method_8497(x, z).method_12010(new class_2338(x, y, z), class_2246.field_10124.method_9564(), false);
                                }
                                if (z == n4) break;
                                ++z;
                            }
                        }
                        if (y == n3) break;
                        ++y;
                    }
                }
                if (x == n2) break;
                ++x;
            }
        }
        return ship;
    }

    private static final boolean createNewShipWithBlocks$lambda$7(List $chunkPoses, class_3218 $level) {
        boolean bl;
        block3: {
            Intrinsics.checkNotNullParameter((Object)$chunkPoses, (String)"$chunkPoses");
            Intrinsics.checkNotNullParameter((Object)$level, (String)"$level");
            Iterable $this$all$iv = $chunkPoses;
            boolean $i$f$all = false;
            if ($this$all$iv instanceof Collection && ((Collection)$this$all$iv).isEmpty()) {
                bl = true;
            } else {
                for (Object element$iv : $this$all$iv) {
                    class_1923 p0 = (class_1923)element$iv;
                    boolean bl2 = false;
                    if (VSGameUtilsKt.isTickingChunk((class_1937)$level, p0)) continue;
                    bl = false;
                    break block3;
                }
                bl = true;
            }
        }
        return bl;
    }

    private static final void createNewShipWithBlocks$lambda$8() {
    }
}

