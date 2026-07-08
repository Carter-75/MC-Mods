/*
 * Decompiled with CFR 0.152.
 */
package org.apache.logging.log4j.message;

import java.io.Serializable;
import org.apache.logging.log4j.message.Clearable;
import org.apache.logging.log4j.message.Message;
import org.apache.logging.log4j.message.MessageFactory2;
import org.apache.logging.log4j.message.ReusableObjectMessage;
import org.apache.logging.log4j.message.ReusableParameterizedMessage;
import org.apache.logging.log4j.message.ReusableSimpleMessage;
import org.apache.logging.log4j.util.PerformanceSensitive;

@PerformanceSensitive(value={"allocation"})
public final class ReusableMessageFactory
implements MessageFactory2,
Serializable {
    public static final ReusableMessageFactory INSTANCE = new ReusableMessageFactory();
    private static final long serialVersionUID = -8970940216592525651L;
    private static ThreadLocal<ReusableParameterizedMessage> threadLocalParameterized = new ThreadLocal();
    private static ThreadLocal<ReusableSimpleMessage> threadLocalSimpleMessage = new ThreadLocal();
    private static ThreadLocal<ReusableObjectMessage> threadLocalObjectMessage = new ThreadLocal();

    private static ReusableParameterizedMessage getParameterized() {
        ReusableParameterizedMessage result2 = threadLocalParameterized.get();
        if (result2 == null) {
            result2 = new ReusableParameterizedMessage();
            threadLocalParameterized.set(result2);
        }
        return result2.reserved ? new ReusableParameterizedMessage().reserve() : result2.reserve();
    }

    private static ReusableSimpleMessage getSimple() {
        ReusableSimpleMessage result2 = threadLocalSimpleMessage.get();
        if (result2 == null) {
            result2 = new ReusableSimpleMessage();
            threadLocalSimpleMessage.set(result2);
        }
        return result2;
    }

    private static ReusableObjectMessage getObject() {
        ReusableObjectMessage result2 = threadLocalObjectMessage.get();
        if (result2 == null) {
            result2 = new ReusableObjectMessage();
            threadLocalObjectMessage.set(result2);
        }
        return result2;
    }

    public static void release(Message message) {
        if (message instanceof Clearable) {
            ((Clearable)((Object)message)).clear();
        }
    }

    @Override
    public Message newMessage(CharSequence charSequence) {
        ReusableSimpleMessage result2 = ReusableMessageFactory.getSimple();
        result2.set(charSequence);
        return result2;
    }

    @Override
    public Message newMessage(String message, Object ... params) {
        return ReusableMessageFactory.getParameterized().set(message, params);
    }

    @Override
    public Message newMessage(String message, Object p0) {
        return ReusableMessageFactory.getParameterized().set(message, p0);
    }

    @Override
    public Message newMessage(String message, Object p0, Object p1) {
        return ReusableMessageFactory.getParameterized().set(message, p0, p1);
    }

    @Override
    public Message newMessage(String message, Object p0, Object p1, Object p2) {
        return ReusableMessageFactory.getParameterized().set(message, p0, p1, p2);
    }

    @Override
    public Message newMessage(String message, Object p0, Object p1, Object p2, Object p3) {
        return ReusableMessageFactory.getParameterized().set(message, p0, p1, p2, p3);
    }

    @Override
    public Message newMessage(String message, Object p0, Object p1, Object p2, Object p3, Object p4) {
        return ReusableMessageFactory.getParameterized().set(message, p0, p1, p2, p3, p4);
    }

    @Override
    public Message newMessage(String message, Object p0, Object p1, Object p2, Object p3, Object p4, Object p5) {
        return ReusableMessageFactory.getParameterized().set(message, p0, p1, p2, p3, p4, p5);
    }

    @Override
    public Message newMessage(String message, Object p0, Object p1, Object p2, Object p3, Object p4, Object p5, Object p6) {
        return ReusableMessageFactory.getParameterized().set(message, p0, p1, p2, p3, p4, p5, p6);
    }

    @Override
    public Message newMessage(String message, Object p0, Object p1, Object p2, Object p3, Object p4, Object p5, Object p6, Object p7) {
        return ReusableMessageFactory.getParameterized().set(message, p0, p1, p2, p3, p4, p5, p6, p7);
    }

    @Override
    public Message newMessage(String message, Object p0, Object p1, Object p2, Object p3, Object p4, Object p5, Object p6, Object p7, Object p8) {
        return ReusableMessageFactory.getParameterized().set(message, p0, p1, p2, p3, p4, p5, p6, p7, p8);
    }

    @Override
    public Message newMessage(String message, Object p0, Object p1, Object p2, Object p3, Object p4, Object p5, Object p6, Object p7, Object p8, Object p9) {
        return ReusableMessageFactory.getParameterized().set(message, p0, p1, p2, p3, p4, p5, p6, p7, p8, p9);
    }

    @Override
    public Message newMessage(String message) {
        ReusableSimpleMessage result2 = ReusableMessageFactory.getSimple();
        result2.set(message);
        return result2;
    }

    @Override
    public Message newMessage(Object message) {
        ReusableObjectMessage result2 = ReusableMessageFactory.getObject();
        result2.set(message);
        return result2;
    }
}

