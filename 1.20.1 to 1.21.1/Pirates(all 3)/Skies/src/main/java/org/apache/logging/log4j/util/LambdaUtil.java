/*
 * Decompiled with CFR 0.152.
 */
package org.apache.logging.log4j.util;

import org.apache.logging.log4j.message.Message;
import org.apache.logging.log4j.message.MessageFactory;
import org.apache.logging.log4j.util.MessageSupplier;
import org.apache.logging.log4j.util.Supplier;

public final class LambdaUtil {
    private LambdaUtil() {
    }

    public static Object[] getAll(Supplier<?> ... suppliers) {
        if (suppliers == null) {
            return null;
        }
        Object[] result2 = new Object[suppliers.length];
        for (int i2 = 0; i2 < result2.length; ++i2) {
            result2[i2] = LambdaUtil.get(suppliers[i2]);
        }
        return result2;
    }

    public static Object get(Supplier<?> supplier) {
        if (supplier == null) {
            return null;
        }
        Object result2 = supplier.get();
        return result2 instanceof Message ? ((Message)result2).getFormattedMessage() : result2;
    }

    public static Message get(MessageSupplier supplier) {
        if (supplier == null) {
            return null;
        }
        return supplier.get();
    }

    public static Message getMessage(Supplier<?> supplier, MessageFactory messageFactory) {
        if (supplier == null) {
            return null;
        }
        Object result2 = supplier.get();
        return result2 instanceof Message ? (Message)result2 : messageFactory.newMessage(result2);
    }
}

