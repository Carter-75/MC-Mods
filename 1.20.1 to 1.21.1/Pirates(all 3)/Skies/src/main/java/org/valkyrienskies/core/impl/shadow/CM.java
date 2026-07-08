/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.internal.Intrinsics
 */
package org.valkyrienskies.core.impl.shadow;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.BinaryNode;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import kotlin.jvm.internal.Intrinsics;
import org.valkyrienskies.core.api.attachment.BinaryAttachmentSerializer;
import org.valkyrienskies.core.impl.shadow.CK;

public final class CM
implements CK {
    private final BinaryAttachmentSerializer<?> a;

    public CM(BinaryAttachmentSerializer<?> binaryAttachmentSerializer) {
        Intrinsics.checkNotNullParameter(binaryAttachmentSerializer, (String)"");
        this.a = binaryAttachmentSerializer;
    }

    @Override
    public final JsonNode a(Object object) {
        Intrinsics.checkNotNullParameter((Object)object, (String)"");
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        Intrinsics.checkNotNull(this.a);
        this.a.serialize(object, new DataOutputStream(byteArrayOutputStream));
        return new BinaryNode(byteArrayOutputStream.toByteArray());
    }

    @Override
    public final Object a(JsonNode object, Class<?> clazz) {
        Intrinsics.checkNotNullParameter((Object)object, (String)"");
        Intrinsics.checkNotNullParameter(clazz, (String)"");
        object = ((JsonNode)((BinaryNode)object)).binaryValue();
        object = new ByteArrayInputStream((byte[])object);
        return this.a.deserialize(new DataInputStream((InputStream)object));
    }
}

