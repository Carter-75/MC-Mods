/*
 * Decompiled with CFR 0.152.
 */
package backported.updates.foundation.nightconfig.core.io;

public enum NewlineStyle {
    UNIX('\n'),
    WINDOWS('\r', '\n');

    public final char[] chars;

    private NewlineStyle(char ... chars) {
        this.chars = chars;
    }

    public static NewlineStyle system() {
        String systemNewline = System.getProperty("line.separator");
        return systemNewline.equals("\r\n") ? WINDOWS : UNIX;
    }
}

