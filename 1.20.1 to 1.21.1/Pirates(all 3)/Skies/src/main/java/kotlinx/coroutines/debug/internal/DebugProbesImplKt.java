/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 */
package kotlinx.coroutines.debug.internal;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mv={1, 8, 0}, k=2, xi=48, d1={"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0003\u001a\u0013\u0010\u0001\u001a\u00020\u0000*\u00020\u0000H\u0002\u00a2\u0006\u0004\b\u0001\u0010\u0002\u00a8\u0006\u0003"}, d2={"", "repr", "(Ljava/lang/String;)Ljava/lang/String;", "kotlinx-coroutines-core"})
public final class DebugProbesImplKt {
    private static final String repr(String $this$repr) {
        StringBuilder stringBuilder;
        StringBuilder $this$repr_u24lambda_u240 = stringBuilder = new StringBuilder();
        boolean bl = false;
        $this$repr_u24lambda_u240.append('\"');
        int n2 = $this$repr.length();
        for (int i2 = 0; i2 < n2; ++i2) {
            char c2 = $this$repr.charAt(i2);
            char c3 = c2;
            if (c3 == '\"') {
                $this$repr_u24lambda_u240.append("\\\"");
                continue;
            }
            if (c3 == '\\') {
                $this$repr_u24lambda_u240.append("\\\\");
                continue;
            }
            if (c3 == '\b') {
                $this$repr_u24lambda_u240.append("\\b");
                continue;
            }
            if (c3 == '\n') {
                $this$repr_u24lambda_u240.append("\\n");
                continue;
            }
            if (c3 == '\r') {
                $this$repr_u24lambda_u240.append("\\r");
                continue;
            }
            if (c3 == '\t') {
                $this$repr_u24lambda_u240.append("\\t");
                continue;
            }
            $this$repr_u24lambda_u240.append(c2);
        }
        $this$repr_u24lambda_u240.append('\"');
        String string = stringBuilder.toString();
        Intrinsics.checkNotNullExpressionValue((Object)string, (String)"StringBuilder().apply(builderAction).toString()");
        return string;
    }

    public static final /* synthetic */ String access$repr(String $receiver) {
        return DebugProbesImplKt.repr($receiver);
    }
}

