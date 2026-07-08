/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import java.util.MissingResourceException;
import java.util.ResourceBundle;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.cl
 */
public class cl_2 {
    private static final String a = "jsv-messages";
    private static final ResourceBundle b;

    public static String a(String object) {
        String string = null;
        try {
            string = b.getString((String)object);
        }
        catch (MissingResourceException missingResourceException) {
            object = missingResourceException;
            missingResourceException.printStackTrace();
            System.exit(2);
        }
        return string;
    }

    static {
        ResourceBundle resourceBundle = null;
        try {
            resourceBundle = ResourceBundle.getBundle(a);
        }
        catch (MissingResourceException missingResourceException) {
            MissingResourceException missingResourceException2 = missingResourceException;
            missingResourceException.printStackTrace();
            System.exit(1);
        }
        b = resourceBundle;
    }
}

