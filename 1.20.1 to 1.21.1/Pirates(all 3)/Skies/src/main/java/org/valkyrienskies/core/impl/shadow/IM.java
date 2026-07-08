/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.UUID;
import java.util.zip.CRC32;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

public class IM {
    private static boolean d = System.getProperty("os.name").contains("Windows");
    private static boolean e = System.getProperty("os.name").contains("Linux");
    private static boolean f = System.getProperty("os.name").contains("Mac");
    public static boolean a = false;
    public static boolean b = false;
    private static boolean g = System.getProperty("os.arch").startsWith("arm") || System.getProperty("os.arch").equals("aarch64");
    public static boolean c = System.getProperty("os.arch").equals("amd64") || System.getProperty("os.arch").equals("x86_64") || System.getProperty("os.arch").equals("aarch64");
    private static final HashSet<String> h;
    private String i;

    public IM() {
    }

    private IM(String string) {
        this.i = string;
    }

    private static String a(InputStream inputStream) {
        if (inputStream == null) {
            throw new IllegalArgumentException("input cannot be null.");
        }
        CRC32 cRC32 = new CRC32();
        byte[] byArray = new byte[4096];
        try {
            int n2;
            while ((n2 = inputStream.read(byArray)) != -1) {
                cRC32.update(byArray, 0, n2);
            }
        }
        catch (Exception exception) {
        }
        finally {
            IM.a((Closeable)inputStream);
        }
        return Long.toString(cRC32.getValue(), 16);
    }

    public static String a(String string) {
        if (d) {
            return string + (c ? "64.dll" : ".dll");
        }
        if (e) {
            return "lib" + string + (g ? "arm" : "") + (c ? "64.so" : ".so");
        }
        if (f) {
            return "lib" + string + (g ? "arm" : "") + (c ? "64.dylib" : ".dylib");
        }
        return string;
    }

    public final void b(String string) {
        if (a) {
            return;
        }
        Class<IM> clazz = IM.class;
        synchronized (IM.class) {
            if (IM.e(string)) {
                // ** MonitorExit[var2_4] (shouldn't be in output)
                return;
            }
            String string2 = IM.a(string);
            System.out.println("KrunchPhysicsAPISharedLibraryLoader loading library " + string);
            try {
                if (b) {
                    System.loadLibrary(string2);
                } else {
                    this.c(string2);
                }
                IM.d(string);
            }
            catch (Throwable throwable) {
                throw new RuntimeException("Couldn't load shared library '" + string2 + "' for target: " + System.getProperty("os.name") + (c ? ", 64-bit" : ", 32-bit"), throwable);
            }
            return;
        }
    }

    private InputStream f(String string) {
        if (this.i == null) {
            InputStream inputStream = IM.class.getResourceAsStream("/" + string);
            if (inputStream == null) {
                throw new RuntimeException("Unable to read file for extraction: " + string);
            }
            return inputStream;
        }
        try {
            ZipFile zipFile = new ZipFile(this.i);
            ZipEntry zipEntry = zipFile.getEntry(string);
            if (zipEntry == null) {
                throw new RuntimeException("Couldn't find '" + string + "' in JAR: " + this.i);
            }
            return zipFile.getInputStream(zipEntry);
        }
        catch (IOException iOException) {
            throw new RuntimeException("Error reading '" + string + "' in JAR: " + this.i, iOException);
        }
    }

    private File a(String string, String object) {
        try {
            String string2 = IM.a(this.f(string));
            if (object == null) {
                object = string2;
            }
            if ((object = this.b((String)object, new File(string).getName())) == null && (object = this.b(UUID.randomUUID().toString(), new File(string).getName())) == null) {
                throw new RuntimeException("Unable to find writable path to extract file. Is the user home directory writable?");
            }
            return this.a(string, string2, (File)object);
        }
        catch (RuntimeException runtimeException) {
            object = new File(System.getProperty("java.library.path"), string);
            if (((File)object).exists()) {
                return object;
            }
            throw runtimeException;
        }
    }

    private void a(String string, File file) {
        this.a(string, IM.a(this.f(string)), new File(file, new File(string).getName()));
    }

    private File b(String string, String string2) {
        File file;
        File file2 = new File(System.getProperty("java.io.tmpdir") + "/libgdx" + System.getProperty("user.name") + "/" + string, string2);
        if (this.a(file2)) {
            return file2;
        }
        try {
            file = File.createTempFile(string, null);
            if (file.delete() && this.a(file = new File(file, string2))) {
                return file;
            }
        }
        catch (IOException iOException) {}
        file = new File(System.getProperty("user.home") + "/.libgdx/" + string, string2);
        if (this.a(file)) {
            return file;
        }
        file = new File(".temp/" + string, string2);
        if (this.a(file)) {
            return file;
        }
        if (System.getenv("APP_SANDBOX_CONTAINER_ID") != null) {
            return file2;
        }
        return null;
    }

    private boolean a(File file) {
        File file2 = file.getParentFile();
        if (file.exists()) {
            if (!file.canWrite() || !IM.b(file)) {
                return false;
            }
            file = new File(file2, UUID.randomUUID().toString());
        } else {
            file2.mkdirs();
            if (!file2.isDirectory()) {
                return false;
            }
        }
        try {
            new FileOutputStream(file).close();
            return IM.b(file);
            {
            }
        }
        catch (Throwable throwable) {
            return false;
        }
        finally {
            file.delete();
        }
    }

    private static boolean b(File file) {
        try {
            Method method = File.class.getMethod("canExecute", new Class[0]);
            if (((Boolean)method.invoke((Object)file, new Object[0])).booleanValue()) {
                return true;
            }
            Method method2 = File.class.getMethod("setExecutable", Boolean.TYPE, Boolean.TYPE);
            method2.invoke((Object)file, Boolean.TRUE, Boolean.FALSE);
            return (Boolean)method.invoke((Object)file, new Object[0]);
        }
        catch (Exception exception) {
            return false;
        }
    }

    private File a(String string, String object, File file) {
        Object object2 = null;
        if (file.exists()) {
            try {
                object2 = IM.a(new FileInputStream(file));
            }
            catch (FileNotFoundException fileNotFoundException) {}
        }
        if (object2 == null || !((String)object2).equals(object)) {
            object = null;
            object2 = null;
            try {
                int n2;
                object = this.f(string);
                file.getParentFile().mkdirs();
                object2 = new FileOutputStream(file);
                byte[] byArray = new byte[4096];
                while ((n2 = ((InputStream)object).read(byArray)) != -1) {
                    ((FileOutputStream)object2).write(byArray, 0, n2);
                }
            }
            catch (IOException iOException) {
                throw new RuntimeException("Error extracting file: " + string + "\nTo: " + file.getAbsolutePath(), iOException);
            }
            finally {
                IM.a((Closeable)object);
                IM.a((Closeable)object2);
            }
        }
        return file;
    }

    public void c(String string) {
        String string2 = IM.a(this.f(string));
        String string3 = new File(string).getName();
        File file = new File(System.getProperty("java.io.tmpdir") + "/libgdx" + System.getProperty("user.name") + "/" + string2, string3);
        Throwable throwable = this.b(string, string2, file);
        if (throwable == null) {
            return;
        }
        try {
            file = File.createTempFile(string2, null);
            if (file.delete() && this.b(string, string2, file) == null) {
                return;
            }
        }
        catch (Throwable throwable2) {}
        file = new File(System.getProperty("user.home") + "/.libgdx/" + string2, string3);
        if (this.b(string, string2, file) == null) {
            return;
        }
        file = new File(".temp/" + string2, string3);
        if (this.b(string, string2, file) == null) {
            return;
        }
        file = new File(System.getProperty("java.library.path"), string);
        if (file.exists()) {
            System.load(file.getAbsolutePath());
            return;
        }
        throw new RuntimeException(throwable);
    }

    private Throwable b(String object, String string, File file) {
        try {
            System.load(this.a((String)object, string, file).getAbsolutePath());
            return null;
        }
        catch (Throwable throwable) {
            object = throwable;
            return throwable;
        }
    }

    public static synchronized void d(String string) {
        h.add(string);
    }

    public static synchronized boolean e(String string) {
        return h.contains(string);
    }

    private static void a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
                return;
            }
            catch (Throwable throwable) {}
        }
    }

    static {
        boolean bl = "iOS".equals(System.getProperty("moe.platform.name"));
        String string = System.getProperty("java.runtime.name");
        if (string != null && string.contains("Android Runtime")) {
            b = true;
            d = false;
            e = false;
            f = false;
            c = false;
        }
        if (bl || !b && !d && !e && !f) {
            a = true;
            b = false;
            d = false;
            e = false;
            f = false;
            c = false;
        }
        h = new HashSet();
    }
}

