/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.nbt.NbtCompound
 *  net.minecraft.nbt.NbtList
 *  net.minecraft.world.ChunkSerializer
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.Unique
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.ModifyVariable
 */
package backported_updates.mixin.copper;

import backported.updates.copper.Constants;
import backported.updates.copper.registry.RegistryHelper;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.nbt.NbtList;
import net.minecraft.world.ChunkSerializer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

@Mixin(value={ChunkSerializer.class})
public class IdRemapMixin {
    @Unique
    private static final String OLD_NAMESPACE = "copperagebackport:";
    @Unique
    private static final String NEW_NAMESPACE = "minecraft:";

    @ModifyVariable(method={"deserialize"}, at=@At(value="HEAD"), argsOnly=true)
    private static NbtCompound copperagebackport$remapChunkData(NbtCompound tag) {
        String id;
        String remapped;
        int i;
        if (tag == null) {
            return null;
        }
        boolean modified = false;
        if (tag.contains("sections", 9)) {
            NbtList sections = tag.getList("sections", 10);
            for (i = 0; i < sections.size(); ++i) {
                NbtCompound blockStates;
                NbtCompound section = sections.getCompound(i);
                if (!section.contains("block_states", 10) || !(blockStates = section.getCompound("block_states")).contains("palette", 9)) continue;
                NbtList palette = blockStates.getList("palette", 10);
                for (int j = 0; j < palette.size(); ++j) {
                    String name;
                    String remapped2;
                    NbtCompound blockState = palette.getCompound(j);
                    if (!blockState.contains("Name", 8) || (remapped2 = IdRemapMixin.copperagebackport$remapId(name = blockState.getString("Name"), "Block")) == null) continue;
                    blockState.putString("Name", remapped2);
                    modified = true;
                }
            }
        }
        if (tag.contains("block_entities", 9)) {
            NbtList blockEntities = tag.getList("block_entities", 10);
            for (i = 0; i < blockEntities.size(); ++i) {
                NbtCompound blockEntity = blockEntities.getCompound(i);
                if (blockEntity.contains("id", 8) && (remapped = IdRemapMixin.copperagebackport$remapId(id = blockEntity.getString("id"), "BlockEntity")) != null) {
                    blockEntity.putString("id", remapped);
                    modified = true;
                }
                IdRemapMixin.copperagebackport$remapContainerItems(blockEntity);
            }
        }
        if (tag.contains("entities", 9)) {
            NbtList entities = tag.getList("entities", 10);
            for (i = 0; i < entities.size(); ++i) {
                NbtCompound entity = entities.getCompound(i);
                if (!entity.contains("id", 8) || (remapped = IdRemapMixin.copperagebackport$remapId(id = entity.getString("id"), "Entity")) == null) continue;
                entity.putString("id", remapped);
                modified = true;
            }
        }
        if (modified) {
            Constants.LOG.debug("Remapped legacy copperagebackport: IDs in chunk data");
        }
        return tag;
    }

    @Unique
    private static void copperagebackport$remapContainerItems(NbtCompound blockEntity) {
        if (blockEntity.contains("Items", 9)) {
            NbtList items = blockEntity.getList("Items", 10);
            for (int i = 0; i < items.size(); ++i) {
                String id;
                String remapped;
                NbtCompound item = items.getCompound(i);
                if (!item.contains("id", 8) || (remapped = IdRemapMixin.copperagebackport$remapId(id = item.getString("id"), "ContainerItem")) == null) continue;
                item.putString("id", remapped);
            }
        }
    }

    @Unique
    private static String copperagebackport$remapId(String id, String context) {
        if (id == null || !id.startsWith(OLD_NAMESPACE)) {
            return null;
        }
        String path = id.substring(OLD_NAMESPACE.length());
        if (RegistryHelper.VANILLA_BACKPORT_IDS.contains(path)) {
            String newId = NEW_NAMESPACE + path;
            Constants.LOG.info("[{}] Migrate legacy {} -> {}", new Object[]{context, id, newId});
            return newId;
        }
        return null;
    }
}

