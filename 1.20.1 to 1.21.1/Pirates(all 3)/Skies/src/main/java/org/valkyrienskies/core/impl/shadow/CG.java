/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.internal.Intrinsics
 */
package org.valkyrienskies.core.impl.shadow;

import kotlin.jvm.internal.Intrinsics;
import org.valkyrienskies.core.api.attachment.AttachmentRegistration;
import org.valkyrienskies.core.api.attachment.AttachmentSerializer;
import org.valkyrienskies.core.impl.shadow.CL;

public final class CG<T>
implements AttachmentRegistration<T> {
    private final Class<T> b;
    private final String c;
    private final AttachmentSerializer d;
    final CL a;

    public CG(Class<T> clazz, String string, AttachmentSerializer attachmentSerializer, CL cL) {
        Intrinsics.checkNotNullParameter(clazz, (String)"");
        Intrinsics.checkNotNullParameter((Object)string, (String)"");
        Intrinsics.checkNotNullParameter((Object)attachmentSerializer, (String)"");
        this.b = clazz;
        this.c = string;
        this.d = attachmentSerializer;
        this.a = cL;
    }

    @Override
    public final Class<T> getAttachmentClass() {
        return this.b;
    }

    @Override
    public final String getKey() {
        return this.c;
    }

    @Override
    public final AttachmentSerializer getSerializer() {
        return this.d;
    }

    public final CL a() {
        return this.a;
    }
}

