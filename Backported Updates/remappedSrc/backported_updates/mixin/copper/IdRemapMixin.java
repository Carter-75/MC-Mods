/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_2487
 *  net.minecraft.class_2499
 *  net.minecraft.class_2852
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.Unique
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.ModifyVariable
 */
package backported_updates.mixin.copper;

import backported.updates.copper.Constants;
import backported.updates.copper.registry.RegistryHelper;
import net.minecraft.class_2487;
import net.minecraft.class_2499;
import net.minecraft.class_2852;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

@Mixin(value={class_2852.class})
public class IdRemapMixin {
    @Unique
    private static final String OLD_NAMESPACE = "copperagebackport:";
    @Unique
    private static final String NEW_NAMESPACE = "minecraft:";

    @ModifyVariable(method={"read"}, at=@At(value="HEAD"), argsOnly=true)
    private static class_2487 copperagebackport$remapChunkData(class_2487 tag) {
        String id;
        String remapped;
        int i;
        if (tag == null) {
            return null;
        }
        boolean modified = false;
        if (tag.method_10573("sections", 9)) {
            class_2499 sections = tag.method_10554("sections", 10);
            for (i = 0; i < sections.size(); ++i) {
                class_2487 blockStates;
                class_2487 section = sections.method_10602(i);
                if (!section.method_10573("block_states", 10) || !(blockStates = section.method_10562("block_states")).method_10573("palette", 9)) continue;
                class_2499 palette = blockStates.method_10554("palette", 10);
                for (int j = 0; j < palette.size(); ++j) {
                    String name;
                    String remapped2;
                    class_2487 blockState = palette.method_10602(j);
                    if (!blockState.method_10573("Name", 8) || (remapped2 = IdRemapMixin.copperagebackport$remapId(name = blockState.method_10558("Name"), "Block")) == null) continue;
                    blockState.method_10582("Name", remapped2);
                    modified = true;
                }
            }
        }
        if (tag.method_10573("block_entities", 9)) {
            class_2499 blockEntities = tag.method_10554("block_entities", 10);
            for (i = 0; i < blockEntities.size(); ++i) {
                class_2487 blockEntity = blockEntities.method_10602(i);
                if (blockEntity.method_10573("id", 8) && (remapped = IdRemapMixin.copperagebackport$remapId(id = blockEntity.method_10558("id"), "BlockEntity")) != null) {
                    blockEntity.method_10582("id", remapped);
                    modified = true;
                }
                IdRemapMixin.copperagebackport$remapContainerItems(blockEntity);
            }
        }
        if (tag.method_10573("entities", 9)) {
            class_2499 entities = tag.method_10554("entities", 10);
            for (i = 0; i < entities.size(); ++i) {
                class_2487 entity = entities.method_10602(i);
                if (!entity.method_10573("id", 8) || (remapped = IdRemapMixin.copperagebackport$remapId(id = entity.method_10558("id"), "Entity")) == null) continue;
                entity.method_10582("id", remapped);
                modified = true;
            }
        }
        if (modified) {
            Constants.LOG.debug("Remapped legacy copperagebackport: IDs in chunk data");
        }
        return tag;
    }

    @Unique
    private static void copperagebackport$remapContainerItems(class_2487 blockEntity) {
        if (blockEntity.method_10573("Items", 9)) {
            class_2499 items = blockEntity.method_10554("Items", 10);
            for (int i = 0; i < items.size(); ++i) {
                String id;
                String remapped;
                class_2487 item = items.method_10602(i);
                if (!item.method_10573("id", 8) || (remapped = IdRemapMixin.copperagebackport$remapId(id = item.method_10558("id"), "ContainerItem")) == null) continue;
                item.method_10582("id", remapped);
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

