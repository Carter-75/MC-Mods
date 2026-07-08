/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1937
 *  net.minecraft.class_2237
 *  net.minecraft.class_2248
 *  net.minecraft.class_2338
 *  net.minecraft.class_2464
 *  net.minecraft.class_2586
 *  net.minecraft.class_2591
 *  net.minecraft.class_2680
 *  net.minecraft.class_2689$class_2690
 *  net.minecraft.class_2741
 *  net.minecraft.class_2769
 *  net.minecraft.class_4970$class_2251
 *  net.minecraft.class_5558
 *  org.jetbrains.annotations.Nullable
 */
package ace.actually.pirates.blocks;

import ace.actually.pirates.Pirates;
import ace.actually.pirates.blocks.entity.CrewSpawnerBlockEntity;
import ace.actually.pirates.entities.CrewTypes;
import net.minecraft.class_1937;
import net.minecraft.class_2237;
import net.minecraft.class_2248;
import net.minecraft.class_2338;
import net.minecraft.class_2464;
import net.minecraft.class_2586;
import net.minecraft.class_2591;
import net.minecraft.class_2680;
import net.minecraft.class_2689;
import net.minecraft.class_2741;
import net.minecraft.class_2769;
import net.minecraft.class_4970;
import net.minecraft.class_5558;
import org.jetbrains.annotations.Nullable;

public class CrewSpawnerBlock
extends class_2237 {
    public CrewSpawnerBlock(class_4970.class_2251 settings) {
        super(settings);
    }

    @Nullable
    public class_2586 method_10123(class_2338 pos, class_2680 state) {
        return new CrewSpawnerBlockEntity(pos, state);
    }

    protected void method_9515(class_2689.class_2690<class_2248, class_2680> builder) {
        builder.method_11667(new class_2769[]{class_2741.field_12486}).method_11667(new class_2769[]{CrewTypes.CREW_SPAWN_TYPE});
    }

    @Nullable
    public <T extends class_2586> class_5558<T> method_31645(class_1937 world, class_2680 state, class_2591<T> type) {
        return CrewSpawnerBlock.method_31618(type, (class_2591)((class_2591)Pirates.CREW_SPAWNER_BLOCK_ENTITY.get()), CrewSpawnerBlockEntity::tick);
    }

    public class_2464 method_9604(class_2680 state) {
        return class_2464.field_11455;
    }
}

