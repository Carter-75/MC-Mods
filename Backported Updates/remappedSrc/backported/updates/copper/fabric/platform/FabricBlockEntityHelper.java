/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_2248
 *  net.minecraft.class_2586
 *  net.minecraft.class_2591
 *  net.minecraft.class_2591$class_2592
 */
package backported.updates.copper.fabric.platform;

import backported.updates.copper.platform.services.IBlockEntityHelper;
import net.minecraft.class_2248;
import net.minecraft.class_2586;
import net.minecraft.class_2591;

public class FabricBlockEntityHelper
implements IBlockEntityHelper {
    @Override
    public <T extends class_2586> class_2591<T> createBlockEntityType(IBlockEntityHelper.BlockEntityFactory<T> factory, class_2248 ... blocks) {
        return class_2591.class_2592.method_20528(factory::create, (class_2248[])blocks).method_11034(null);
    }
}

