/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  net.fabricmc.api.ClientModInitializer
 *  net.fabricmc.api.EnvType
 *  net.fabricmc.api.Environment
 *  net.fabricmc.api.ModInitializer
 *  net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries
 *  net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents
 *  net.fabricmc.fabric.api.resource.IdentifiableResourceReloadListener
 *  net.fabricmc.fabric.api.resource.ResourceManagerHelper
 *  net.fabricmc.fabric.api.resource.SimpleSynchronousResourceReloadListener
 *  net.minecraft.class_1792
 *  net.minecraft.class_1935
 *  net.minecraft.class_2248
 *  net.minecraft.class_2378
 *  net.minecraft.class_2960
 *  net.minecraft.class_3264
 *  net.minecraft.class_3300
 *  net.minecraft.class_5321
 *  net.minecraft.class_7706
 *  net.minecraft.class_7923
 *  org.jetbrains.annotations.NotNull
 *  org.valkyrienskies.mod.fabric.common.ValkyrienSkiesModFabric
 */
package g_mungus.vlib.fabric;

import g_mungus.vlib.VLib;
import g_mungus.vlib.data.ReloadListenerKt;
import g_mungus.vlib.item.AssemblyStickItem;
import g_mungus.vlib.v2.internal.block.GhostPlatformBlock;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.fabric.api.resource.IdentifiableResourceReloadListener;
import net.fabricmc.fabric.api.resource.ResourceManagerHelper;
import net.fabricmc.fabric.api.resource.SimpleSynchronousResourceReloadListener;
import net.minecraft.class_1792;
import net.minecraft.class_1935;
import net.minecraft.class_2248;
import net.minecraft.class_2378;
import net.minecraft.class_2960;
import net.minecraft.class_3264;
import net.minecraft.class_3300;
import net.minecraft.class_5321;
import net.minecraft.class_7706;
import net.minecraft.class_7923;
import org.jetbrains.annotations.NotNull;
import org.valkyrienskies.mod.fabric.common.ValkyrienSkiesModFabric;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0001\u0010B\t\b\u0002\u00a2\u0006\u0004\b\u000f\u0010\u0004J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016\u00a2\u0006\u0004\b\u0003\u0010\u0004J\u001f\u0010\t\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0002\u00a2\u0006\u0004\b\t\u0010\nJ\u001f\u0010\r\u001a\u00020\u000b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u000bH\u0002\u00a2\u0006\u0004\b\r\u0010\u000e\u00a8\u0006\u0011"}, d2={"Lg_mungus/vlib/fabric/VLibFabric;", "Lnet/fabricmc/api/ModInitializer;", "", "onInitialize", "()V", "", "name", "Lnet/minecraft/class_2248;", "block", "registerBlock", "(Ljava/lang/String;Lnet/minecraft/class_2248;)Lnet/minecraft/class_2248;", "Lnet/minecraft/class_1792;", "item", "registerItem", "(Ljava/lang/String;Lnet/minecraft/class_1792;)Lnet/minecraft/class_1792;", "<init>", "Client", "vlib"})
public final class VLibFabric
implements ModInitializer {
    @NotNull
    public static final VLibFabric INSTANCE = new VLibFabric();

    private VLibFabric() {
    }

    public void onInitialize() {
        new ValkyrienSkiesModFabric().onInitialize();
        VLib.INSTANCE.setGHOST_BLOCK(this.registerBlock("ghost_block", new GhostPlatformBlock()));
        VLib.INSTANCE.setASSEMBLY_STICK(this.registerItem("assembly_stick", new AssemblyStickItem()));
        ItemGroupEvents.modifyEntriesEvent((class_5321)class_7706.field_41060).register(VLibFabric::onInitialize$lambda$0);
        ResourceManagerHelper.get((class_3264)class_3264.field_14190).registerReloadListener((IdentifiableResourceReloadListener)new SimpleSynchronousResourceReloadListener(){

            public class_2960 getFabricId() {
                return new class_2960("vlib", "");
            }

            public void method_14491(class_3300 resourceManager) {
                Intrinsics.checkNotNullParameter((Object)resourceManager, (String)"resourceManager");
                ReloadListenerKt.onResourceReload(resourceManager);
            }
        });
        VLib.init();
    }

    private final class_2248 registerBlock(String name, class_2248 block) {
        class_2378 class_23782 = (class_2378)class_7923.field_41175;
        class_2960 class_29602 = class_2960.method_43902((String)"vlib", (String)name);
        Intrinsics.checkNotNull((Object)class_29602);
        Object object = class_2378.method_10230((class_2378)class_23782, (class_2960)class_29602, (Object)block);
        Intrinsics.checkNotNullExpressionValue((Object)object, (String)"register(...)");
        return (class_2248)object;
    }

    private final class_1792 registerItem(String name, class_1792 item) {
        class_2378 class_23782 = (class_2378)class_7923.field_41178;
        class_2960 class_29602 = class_2960.method_43902((String)"vlib", (String)name);
        Intrinsics.checkNotNull((Object)class_29602);
        Object object = class_2378.method_10230((class_2378)class_23782, (class_2960)class_29602, (Object)item);
        Intrinsics.checkNotNullExpressionValue((Object)object, (String)"register(...)");
        return (class_1792)object;
    }

    private static final void onInitialize$lambda$0(FabricItemGroupEntries entries) {
        FabricItemGroupEntries fabricItemGroupEntries = entries;
        Intrinsics.checkNotNull((Object)fabricItemGroupEntries);
        fabricItemGroupEntries.method_45421((class_1935)VLib.INSTANCE.getASSEMBLY_STICK());
    }

    @Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0005\u0010\u0004J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016\u00a2\u0006\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0006"}, d2={"Lg_mungus/vlib/fabric/VLibFabric$Client;", "Lnet/fabricmc/api/ClientModInitializer;", "", "onInitializeClient", "()V", "<init>", "vlib"})
    @Environment(value=EnvType.CLIENT)
    public static final class Client
    implements ClientModInitializer {
        public void onInitializeClient() {
            VLib.initClient();
        }
    }
}

