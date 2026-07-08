/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.TypeIntrinsics
 */
package org.valkyrienskies.core.impl.shadow;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import org.valkyrienskies.core.api.attachment.AttachmentRegistration;
import org.valkyrienskies.core.api.attachment.AttachmentSerializer;
import org.valkyrienskies.core.api.attachment.JacksonAttachmentSerializer;
import org.valkyrienskies.core.api.attachment.LegacyAttachmentSerializer;
import org.valkyrienskies.core.api.attachment.TransientAttachmentSerializer;
import org.valkyrienskies.core.impl.shadow.CG;
import org.valkyrienskies.core.impl.shadow.CL;

public final class CF<T>
implements AttachmentRegistration.Builder<T> {
    private final Class<T> a;
    private String b;
    private AttachmentSerializer c;
    private CL d;

    public CF(Class<T> clazz) {
        Intrinsics.checkNotNullParameter(clazz, (String)"");
        this.a = clazz;
        String string = this.getAttachmentClass().getName();
        Intrinsics.checkNotNullExpressionValue((Object)string, (String)"");
        this.b = string;
        this.c = JacksonAttachmentSerializer.INSTANCE;
    }

    @Override
    public final Class<T> getAttachmentClass() {
        return this.a;
    }

    @Override
    public final String getKey() {
        return this.b;
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public final void setKey(String string) {
        void var1_1;
        Intrinsics.checkNotNullParameter((Object)string, (String)"");
        this.b = var1_1;
    }

    @Override
    public final AttachmentSerializer getSerializer() {
        return this.c;
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public final void setSerializer(AttachmentSerializer attachmentSerializer) {
        void var1_1;
        Intrinsics.checkNotNullParameter((Object)attachmentSerializer, (String)"");
        this.c = var1_1;
    }

    private CL a() {
        return this.d;
    }

    private void a(CL cL) {
        this.d = cL;
    }

    private CF<T> b() {
        CF cF = this;
        this.setSerializer(JacksonAttachmentSerializer.INSTANCE);
        return cF;
    }

    private CF<T> c() {
        CF cF = this;
        this.setSerializer(LegacyAttachmentSerializer.INSTANCE);
        return cF;
    }

    private CF<T> d() {
        CF cF = this;
        this.setSerializer(TransientAttachmentSerializer.INSTANCE);
        return cF;
    }

    private <NEW> CF<T> a(Class<NEW> clazz, Function1<? super T, ? extends NEW> function1) {
        Intrinsics.checkNotNullParameter(clazz, (String)"");
        Intrinsics.checkNotNullParameter(function1, (String)"");
        CF cF = this;
        this.d = new CL(this.getAttachmentClass(), clazz, (Function1<Object, ? extends Object>)((Function1)TypeIntrinsics.beforeCheckcastToFunctionOfArity(function1, (int)1)));
        return cF;
    }

    @Override
    public final AttachmentRegistration<T> build() {
        return new CG<T>(this.getAttachmentClass(), this.getKey(), this.getSerializer(), this.d);
    }

    @Override
    public final /* synthetic */ AttachmentRegistration.Builder useJacksonSerializer() {
        CF cF;
        CF cF2 = cF = this;
        cF.setSerializer(JacksonAttachmentSerializer.INSTANCE);
        return cF2;
    }

    @Override
    public final /* synthetic */ AttachmentRegistration.Builder useLegacySerializer() {
        CF cF;
        CF cF2 = cF = this;
        cF.setSerializer(LegacyAttachmentSerializer.INSTANCE);
        return cF2;
    }

    @Override
    public final /* synthetic */ AttachmentRegistration.Builder useTransientSerializer() {
        CF cF;
        CF cF2 = cF = this;
        cF.setSerializer(TransientAttachmentSerializer.INSTANCE);
        return cF2;
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public final /* synthetic */ AttachmentRegistration.Builder useUpdater(Class newAttachmentClass, Function1 updater) {
        CF cF;
        void var2_2;
        void var3_3 = var2_2;
        var2_2 = cF;
        cF = this;
        Intrinsics.checkNotNullParameter((Object)var2_2, (String)"");
        Intrinsics.checkNotNullParameter((Object)var3_3, (String)"");
        CF cF2 = cF;
        cF.d = new CL(cF.getAttachmentClass(), (Class<?>)var2_2, (Function1<Object, ? extends Object>)((Function1)TypeIntrinsics.beforeCheckcastToFunctionOfArity((Object)var3_3, (int)1)));
        return cF2;
    }
}

