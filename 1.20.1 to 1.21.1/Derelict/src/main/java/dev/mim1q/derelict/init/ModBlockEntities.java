/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder
 *  net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder$Factory
 *  net.minecraft.class_2248
 *  net.minecraft.class_2378
 *  net.minecraft.class_2586
 *  net.minecraft.class_2591
 *  net.minecraft.class_2960
 *  net.minecraft.class_7923
 *  org.jetbrains.annotations.NotNull
 */
package dev.mim1q.derelict.init;

import dev.mim1q.derelict.Derelict;
import dev.mim1q.derelict.block.cobweb.SpiderEggBlock;
import dev.mim1q.derelict.init.ModBlocksAndItems;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.class_2248;
import net.minecraft.class_2378;
import net.minecraft.class_2586;
import net.minecraft.class_2591;
import net.minecraft.class_2960;
import net.minecraft.class_7923;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\u0005\u001a\u00020\u0004\u00a2\u0006\u0004\b\u0005\u0010\u0003JI\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00000\u000f\"\b\b\u0000\u0010\u0007*\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00000\n2\u0012\u0010\u000e\u001a\n\u0012\u0006\b\u0001\u0012\u00020\r0\f\"\u00020\rH\u0002\u00a2\u0006\u0004\b\u0010\u0010\u0011R%\u0010\u0014\u001a\u0010\u0012\f\u0012\n \u0013*\u0004\u0018\u00010\u00120\u00120\u000f8\u0006\u00a2\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\u00a8\u0006\u0018"}, d2={"Ldev/mim1q/derelict/init/ModBlockEntities;", "", "<init>", "()V", "", "init", "Lnet/minecraft/class_2586;", "T", "", "id", "Lnet/fabricmc/fabric/api/object/builder/v1/block/entity/FabricBlockEntityTypeBuilder$Factory;", "factory", "", "Lnet/minecraft/class_2248;", "blocks", "Lnet/minecraft/class_2591;", "register", "(Ljava/lang/String;Lnet/fabricmc/fabric/api/object/builder/v1/block/entity/FabricBlockEntityTypeBuilder$Factory;[Lnet/minecraft/class_2248;)Lnet/minecraft/class_2591;", "Ldev/mim1q/derelict/block/cobweb/SpiderEggBlock$SpiderEggBlockEntity;", "kotlin.jvm.PlatformType", "SPIDER_EGG_BLOCK_ENTITY", "Lnet/minecraft/class_2591;", "getSPIDER_EGG_BLOCK_ENTITY", "()Lnet/minecraft/class_2591;", "derelict"})
public final class ModBlockEntities {
    @NotNull
    public static final ModBlockEntities INSTANCE = new ModBlockEntities();
    @NotNull
    private static final class_2591<SpiderEggBlock.SpiderEggBlockEntity> SPIDER_EGG_BLOCK_ENTITY;

    private ModBlockEntities() {
    }

    @NotNull
    public final class_2591<SpiderEggBlock.SpiderEggBlockEntity> getSPIDER_EGG_BLOCK_ENTITY() {
        return SPIDER_EGG_BLOCK_ENTITY;
    }

    public final void init() {
    }

    private final <T extends class_2586> class_2591<T> register(String id, FabricBlockEntityTypeBuilder.Factory<T> factory, class_2248 ... blocks) {
        Object object = class_2378.method_10230((class_2378)class_7923.field_41181, (class_2960)Derelict.INSTANCE.id(id), (Object)FabricBlockEntityTypeBuilder.create(factory, (class_2248[])new class_2248[0]).addBlocks(Arrays.copyOf(blocks, blocks.length)).build());
        Intrinsics.checkNotNullExpressionValue((Object)object, (String)"register(...)");
        return (class_2591)object;
    }

    static {
        class_2248[] class_2248Array = new class_2248[]{ModBlocksAndItems.INSTANCE.getSPIDER_EGG(), ModBlocksAndItems.INSTANCE.getSPIDER_EGG_CLUSTER(), ModBlocksAndItems.INSTANCE.getSPIDERLING_SPIDER_EGG(), ModBlocksAndItems.INSTANCE.getSPIDER_SPIDER_EGG(), ModBlocksAndItems.INSTANCE.getCAVE_SPIDER_SPIDER_EGG(), ModBlocksAndItems.INSTANCE.getJUMPING_SPIDER_SPIDER_EGG(), ModBlocksAndItems.INSTANCE.getWEB_CASTER_SPIDER_EGG(), ModBlocksAndItems.INSTANCE.getFAKE_SPIDER_EGG()};
        SPIDER_EGG_BLOCK_ENTITY = INSTANCE.register("spider_egg", SpiderEggBlock.SpiderEggBlockEntity::new, class_2248Array);
    }
}

