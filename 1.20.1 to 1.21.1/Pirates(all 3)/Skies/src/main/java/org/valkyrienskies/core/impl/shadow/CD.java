/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.internal.Intrinsics
 */
package org.valkyrienskies.core.impl.shadow;

import kotlin.jvm.internal.Intrinsics;
import org.valkyrienskies.core.api.attachment.AttachmentSerializer;
import org.valkyrienskies.core.impl.shadow.CL;

public final class CD {
    final Class<?> a;
    final String b;
    final AttachmentSerializer c;
    final CL d;

    public CD(Class<?> clazz, String string, AttachmentSerializer attachmentSerializer, CL cL) {
        Intrinsics.checkNotNullParameter(clazz, (String)"");
        Intrinsics.checkNotNullParameter((Object)string, (String)"");
        Intrinsics.checkNotNullParameter((Object)attachmentSerializer, (String)"");
        this.a = clazz;
        this.b = string;
        this.c = attachmentSerializer;
        this.d = cL;
    }

    public final Class<?> a() {
        return this.a;
    }

    public final String b() {
        return this.b;
    }

    public final AttachmentSerializer c() {
        return this.c;
    }

    public final CL d() {
        return this.d;
    }
}

