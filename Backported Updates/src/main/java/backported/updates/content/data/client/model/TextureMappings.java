/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.block.Block
 *  net.minecraft.util.Identifier
 *  net.minecraft.data.client.TextureMap
 *  net.minecraft.data.client.TextureKey
 */
package backported.updates.content.data.client.model;

import backported.updates.content.common.registries.ModBlocks;
import backported.updates.content.data.client.model.TextureSlots;
import net.minecraft.block.Block;
import net.minecraft.util.Identifier;
import net.minecraft.data.client.TextureMap;
import net.minecraft.data.client.TextureKey;

public class TextureMappings {
    public static TextureMap side(Block block) {
        return TextureMap.of((TextureKey)TextureKey.SIDE, TextureMap.getId((Block)block));
    }

    public static TextureMap driedGhast(String string) {
        return new TextureMap().put(TextureKey.PARTICLE, TextureMap.getSubId((Block)ModBlocks.DRIED_GHAST.get(), (String)(string + "_north"))).put(TextureKey.BOTTOM, TextureMap.getSubId((Block)ModBlocks.DRIED_GHAST.get(), (String)(string + "_bottom"))).put(TextureKey.TOP, TextureMap.getSubId((Block)ModBlocks.DRIED_GHAST.get(), (String)(string + "_top"))).put(TextureKey.NORTH, TextureMap.getSubId((Block)ModBlocks.DRIED_GHAST.get(), (String)(string + "_north"))).put(TextureKey.SOUTH, TextureMap.getSubId((Block)ModBlocks.DRIED_GHAST.get(), (String)(string + "_south"))).put(TextureKey.EAST, TextureMap.getSubId((Block)ModBlocks.DRIED_GHAST.get(), (String)(string + "_west"))).put(TextureKey.WEST, TextureMap.getSubId((Block)ModBlocks.DRIED_GHAST.get(), (String)(string + "_east"))).put(TextureSlots.TENTACLES, TextureMap.getSubId((Block)ModBlocks.DRIED_GHAST.get(), (String)(string + "_tentacles")));
    }
}

