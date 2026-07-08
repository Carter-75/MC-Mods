/*
 * Decompiled with CFR 0.152.
 */
package org.apache.logging.log4j.util;

import java.lang.reflect.Method;
import java.util.Stack;
import java.util.function.Predicate;
import org.apache.logging.log4j.util.LoaderUtil;
import org.apache.logging.log4j.util.PerformanceSensitive;
import org.apache.logging.log4j.util.PrivateSecurityManagerStackTraceUtil;

public final class StackLocator {
    static final int JDK_7u25_OFFSET;
    private static final Method GET_CALLER_CLASS;
    private static final StackLocator INSTANCE;

    public static StackLocator getInstance() {
        return INSTANCE;
    }

    private StackLocator() {
    }

    @PerformanceSensitive
    public Class<?> getCallerClass(Class<?> sentinelClass, Predicate<Class<?>> callerPredicate) {
        Class<?> clazz;
        if (sentinelClass == null) {
            throw new IllegalArgumentException("sentinelClass cannot be null");
        }
        if (callerPredicate == null) {
            throw new IllegalArgumentException("callerPredicate cannot be null");
        }
        boolean foundSentinel = false;
        int i2 = 2;
        while (null != (clazz = this.getCallerClass(i2))) {
            if (sentinelClass.equals(clazz)) {
                foundSentinel = true;
            } else if (foundSentinel && callerPredicate.test(clazz)) {
                return clazz;
            }
            ++i2;
        }
        return null;
    }

    @PerformanceSensitive
    public Class<?> getCallerClass(int depth) {
        if (depth < 0) {
            throw new IndexOutOfBoundsException(Integer.toString(depth));
        }
        if (GET_CALLER_CLASS == null) {
            return null;
        }
        try {
            return (Class)GET_CALLER_CLASS.invoke(null, depth + 1 + JDK_7u25_OFFSET);
        }
        catch (Exception e2) {
            return null;
        }
    }

    @PerformanceSensitive
    public Class<?> getCallerClass(String fqcn, String pkg) {
        Class<?> clazz;
        boolean next = false;
        int i2 = 2;
        while (null != (clazz = this.getCallerClass(i2))) {
            if (fqcn.equals(clazz.getName())) {
                next = true;
            } else if (next && clazz.getName().startsWith(pkg)) {
                return clazz;
            }
            ++i2;
        }
        return null;
    }

    @PerformanceSensitive
    public Class<?> getCallerClass(Class<?> anchor) {
        Class<?> clazz;
        boolean next = false;
        int i2 = 2;
        while (null != (clazz = this.getCallerClass(i2))) {
            if (anchor.equals(clazz)) {
                next = true;
            } else if (next) {
                return clazz;
            }
            ++i2;
        }
        return Object.class;
    }

    @PerformanceSensitive
    public Stack<Class<?>> getCurrentStackTrace() {
        Class<?> clazz;
        if (PrivateSecurityManagerStackTraceUtil.isEnabled()) {
            return PrivateSecurityManagerStackTraceUtil.getCurrentStackTrace();
        }
        Stack classes = new Stack();
        int i2 = 1;
        while (null != (clazz = this.getCallerClass(i2))) {
            classes.push(clazz);
            ++i2;
        }
        return classes;
    }

    public StackTraceElement calcLocation(String fqcnOfLogger) {
        if (fqcnOfLogger == null) {
            return null;
        }
        StackTraceElement[] stackTrace = new Throwable().getStackTrace();
        boolean found = false;
        for (int i2 = 0; i2 < stackTrace.length; ++i2) {
            String className = stackTrace[i2].getClassName();
            if (fqcnOfLogger.equals(className)) {
                found = true;
                continue;
            }
            if (!found || fqcnOfLogger.equals(className)) continue;
            return stackTrace[i2];
        }
        return null;
    }

    public StackTraceElement getStackTraceElement(int depth) {
        StackTraceElement[] elements = new Throwable().getStackTrace();
        int i2 = 0;
        for (StackTraceElement element : elements) {
            if (!this.isValid(element)) continue;
            if (i2 == depth) {
                return element;
            }
            ++i2;
        }
        throw new IndexOutOfBoundsException(Integer.toString(depth));
    }

    private boolean isValid(StackTraceElement element) {
        if (element.isNativeMethod()) {
            return false;
        }
        String cn = element.getClassName();
        if (cn.startsWith("sun.reflect.")) {
            return false;
        }
        String mn = element.getMethodName();
        if (cn.startsWith("java.lang.reflect.") && (mn.equals("invoke") || mn.equals("newInstance"))) {
            return false;
        }
        if (cn.startsWith("jdk.internal.reflect.")) {
            return false;
        }
        if (cn.equals("java.lang.Class") && mn.equals("newInstance")) {
            return false;
        }
        return !cn.equals("java.lang.invoke.MethodHandle") || !mn.startsWith("invoke");
    }

    static {
        Method getCallerClass;
        int java7u25CompensationOffset = 0;
        try {
            Class<?> sunReflectionClass = LoaderUtil.loadClass("sun.reflect.Reflection");
            getCallerClass = sunReflectionClass.getDeclaredMethod("getCallerClass", Integer.TYPE);
            Object o = getCallerClass.invoke(null, 0);
            getCallerClass.invoke(null, 0);
            if (o == null || o != sunReflectionClass) {
                getCallerClass = null;
                java7u25CompensationOffset = -1;
            } else {
                o = getCallerClass.invoke(null, 1);
                if (o == sunReflectionClass) {
                    System.out.println("WARNING: Java 1.7.0_25 is in use which has a broken implementation of Reflection.getCallerClass().  Please consider upgrading to Java 1.7.0_40 or later.");
                    java7u25CompensationOffset = 1;
                }
            }
        }
        catch (Exception | LinkageError e2) {
            System.out.println("WARNING: sun.reflect.Reflection.getCallerClass is not supported. This will impact performance.");
            getCallerClass = null;
            java7u25CompensationOffset = -1;
        }
        GET_CALLER_CLASS = getCallerClass;
        JDK_7u25_OFFSET = java7u25CompensationOffset;
        INSTANCE = new StackLocator();
    }
}

