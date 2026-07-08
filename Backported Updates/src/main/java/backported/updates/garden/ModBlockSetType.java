/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  it.unimi.dsi.fastutil.objects.Object2ObjectArrayMap
 *  net.minecraft.sound.BlockSoundGroup
 *  net.minecraft.sound.SoundEvent
 *  net.minecraft.block.BlockSetType
 *  net.minecraft.block.BlockSetType$ActivationRule
 */
package backported.updates.garden;

import it.unimi.dsi.fastutil.objects.Object2ObjectArrayMap;
import java.util.Map;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.sound.SoundEvent;
import net.minecraft.block.BlockSetType;

public record ModBlockSetType(String name, boolean canOpenByHand, boolean canOpenByWindCharge, boolean canButtonBeActivatedByArrows, BlockSetType.ActivationRule pressurePlateSensitivity, BlockSoundGroup soundType, SoundEvent doorClose, SoundEvent doorOpen, SoundEvent trapdoorClose, SoundEvent trapdoorOpen, SoundEvent pressurePlateClickOff, SoundEvent pressurePlateClickOn, SoundEvent buttonClickOff, SoundEvent buttonClickOn) {
    public static final BlockSetType PALE;
    private static final Map<String, ModBlockSetType> VALUES;

    private static BlockSetType register(BlockSetType blockSetType) {
        ModBlockSetType modBlockSetType = new ModBlockSetType(blockSetType.name(), blockSetType.canOpenByHand(), blockSetType.canOpenByWindCharge(), blockSetType.canButtonBeActivatedByArrows(), blockSetType.pressurePlateSensitivity(), blockSetType.soundType(), blockSetType.doorClose(), blockSetType.doorOpen(), blockSetType.trapdoorClose(), blockSetType.trapdoorOpen(), blockSetType.pressurePlateClickOff(), blockSetType.pressurePlateClickOn(), blockSetType.buttonClickOff(), blockSetType.buttonClickOn());
        VALUES.put(blockSetType.name(), modBlockSetType);
        return blockSetType;
    }

    static {
        VALUES = new Object2ObjectArrayMap();
        PALE = ModBlockSetType.register(new BlockSetType("pale_oak"));
    }
}

