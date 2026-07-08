/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.serialization.Codec
 *  com.mojang.serialization.MapCodec
 *  net.minecraft.util.Identifier
 *  net.minecraft.network.RegistryByteBuf
 *  net.minecraft.network.codec.PacketCodec
 */
package backported.updates.content.common.api.variant;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import net.minecraft.util.Identifier;
import net.minecraft.network.RegistryByteBuf;
import net.minecraft.network.codec.PacketCodec;

public record ClientAsset(Identifier id, Identifier path) {
    public static final Codec<ClientAsset> CODEC = Identifier.CODEC.xmap(ClientAsset::new, ClientAsset::id);
    public static final MapCodec<ClientAsset> DEFAULT_FIELD_CODEC = CODEC.fieldOf("asset_id");
    public static final PacketCodec<RegistryByteBuf, ClientAsset> STREAM_CODEC = PacketCodec.tuple((PacketCodec)Identifier.PACKET_CODEC, ClientAsset::id, (PacketCodec)Identifier.PACKET_CODEC, ClientAsset::path, ClientAsset::new);

    public ClientAsset(Identifier path) {
        this(path, path.withPath(string -> "textures/" + string + ".png"));
    }
}

