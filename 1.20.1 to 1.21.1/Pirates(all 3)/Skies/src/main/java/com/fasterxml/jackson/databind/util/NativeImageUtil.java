/*
 * Decompiled with CFR 0.152.
 */
package com.fasterxml.jackson.databind.util;

import com.fasterxml.jackson.databind.util.ClassUtil;
import java.lang.reflect.InvocationTargetException;

public class NativeImageUtil {
    private static final boolean RUNNING_IN_SVM = System.getProperty("org.graalvm.nativeimage.imagecode") != null;

    private NativeImageUtil() {
    }

    private static boolean isRunningInNativeImage() {
        return RUNNING_IN_SVM && "runtime".equals(System.getProperty("org.graalvm.nativeimage.imagecode"));
    }

    public static boolean isUnsupportedFeatureError(Throwable e2) {
        if (!NativeImageUtil.isRunningInNativeImage()) {
            return false;
        }
        if (e2 instanceof InvocationTargetException) {
            e2 = e2.getCause();
        }
        return e2.getClass().getName().equals("com.oracle.svm.core.jdk.UnsupportedFeatureError");
    }

    public static boolean needsReflectionConfiguration(Class<?> cl) {
        if (!NativeImageUtil.isRunningInNativeImage()) {
            return false;
        }
        return (cl.getDeclaredFields().length == 0 || ClassUtil.isRecordType(cl)) && cl.getDeclaredMethods().length == 0 && cl.getDeclaredConstructors().length == 0;
    }
}

