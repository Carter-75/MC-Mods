/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.serialization.Codec
 *  com.mojang.serialization.MapCodec
 *  net.minecraft.class_2960
 *  net.minecraft.class_9129
 *  net.minecraft.class_9139
 */
package backported.updates.content.common.api.variant;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import net.minecraft.class_2960;
import net.minecraft.class_9129;
import net.minecraft.class_9139;

public record ClientAsset(class_2960 id, class_2960 path) {
    public static final Codec<ClientAsset> CODEC = class_2960.field_25139.xmap(ClientAsset::new, ClientAsset::id);
    public static final MapCodec<ClientAsset> DEFAULT_FIELD_CODEC = CODEC.fieldOf("asset_id");
    public static final class_9139<class_9129, ClientAsset> STREAM_CODEC = class_9139.method_56435((class_9139)class_2960.field_48267, ClientAsset::id, (class_9139)class_2960.field_48267, ClientAsset::path, ClientAsset::new);

    public ClientAsset(class_2960 path) {
        this(path, path.method_45134(string -> "textures/" + string + ".png"));
    }
}

