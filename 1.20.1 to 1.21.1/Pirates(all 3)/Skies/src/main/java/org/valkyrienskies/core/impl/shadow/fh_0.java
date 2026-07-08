/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 */
package org.valkyrienskies.core.impl.shadow;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.Fh
 */
@Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006J\r\u0010\u0003\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0003\u0010\u0004"}, d2={"Lorg/valkyrienskies/core/impl/shadow/Fh;", "", "Ljavax/crypto/SecretKey;", "a", "()Ljavax/crypto/SecretKey;", "<init>", "()V"})
public final class fh_0 {
    public static final fh_0 INSTANCE = new fh_0();

    private fh_0() {
    }

    public static SecretKey a() {
        KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
        keyGenerator.init(128);
        SecretKey secretKey = keyGenerator.generateKey();
        Intrinsics.checkNotNullExpressionValue((Object)secretKey, (String)"");
        return secretKey;
    }
}

