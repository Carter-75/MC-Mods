/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import org.valkyrienskies.core.impl.shadow.oY;
import org.valkyrienskies.core.impl.shadow.vm_0;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 * Renamed from org.valkyrienskies.core.impl.shadow.vl
 */
public enum vl_0 {
    TRIGGER_ONLY_DECREASING_EVENTS{

        protected final boolean a() {
            return false;
        }

        protected final vm_0 a(vm_0 vm_02, double d2, boolean bl) {
            if (bl) {
                switch (vm_02) {
                    case UNINITIALIZED: {
                        if (d2 > 0.0) {
                            return vm_0.MAX;
                        }
                        if (d2 < 0.0) {
                            return vm_0.PLUS;
                        }
                        return vm_0.UNINITIALIZED;
                    }
                    case PLUS: {
                        if (d2 >= 0.0) {
                            return vm_0.MIN;
                        }
                        return vm_02;
                    }
                    case MINUS: {
                        if (d2 >= 0.0) {
                            return vm_0.MAX;
                        }
                        return vm_02;
                    }
                    case MIN: {
                        if (d2 <= 0.0) {
                            return vm_0.MINUS;
                        }
                        return vm_02;
                    }
                    case MAX: {
                        if (d2 <= 0.0) {
                            return vm_0.PLUS;
                        }
                        return vm_02;
                    }
                }
                throw new oY();
            }
            switch (vm_02) {
                case UNINITIALIZED: {
                    if (d2 > 0.0) {
                        return vm_0.MINUS;
                    }
                    if (d2 < 0.0) {
                        return vm_0.MIN;
                    }
                    return vm_0.UNINITIALIZED;
                }
                case PLUS: {
                    if (d2 <= 0.0) {
                        return vm_0.MAX;
                    }
                    return vm_02;
                }
                case MINUS: {
                    if (d2 <= 0.0) {
                        return vm_0.MIN;
                    }
                    return vm_02;
                }
                case MIN: {
                    if (d2 >= 0.0) {
                        return vm_0.PLUS;
                    }
                    return vm_02;
                }
                case MAX: {
                    if (d2 >= 0.0) {
                        return vm_0.MINUS;
                    }
                    return vm_02;
                }
            }
            throw new oY();
        }
    }
    ,
    TRIGGER_ONLY_INCREASING_EVENTS{

        protected final boolean a() {
            return true;
        }

        protected final vm_0 a(vm_0 vm_02, double d2, boolean bl) {
            if (bl) {
                switch (vm_02) {
                    case UNINITIALIZED: {
                        if (d2 > 0.0) {
                            return vm_0.PLUS;
                        }
                        if (d2 < 0.0) {
                            return vm_0.MIN;
                        }
                        return vm_0.UNINITIALIZED;
                    }
                    case PLUS: {
                        if (d2 <= 0.0) {
                            return vm_0.MAX;
                        }
                        return vm_02;
                    }
                    case MINUS: {
                        if (d2 <= 0.0) {
                            return vm_0.MIN;
                        }
                        return vm_02;
                    }
                    case MIN: {
                        if (d2 >= 0.0) {
                            return vm_0.PLUS;
                        }
                        return vm_02;
                    }
                    case MAX: {
                        if (d2 >= 0.0) {
                            return vm_0.MINUS;
                        }
                        return vm_02;
                    }
                }
                throw new oY();
            }
            switch (vm_02) {
                case UNINITIALIZED: {
                    if (d2 > 0.0) {
                        return vm_0.MAX;
                    }
                    if (d2 < 0.0) {
                        return vm_0.MINUS;
                    }
                    return vm_0.UNINITIALIZED;
                }
                case PLUS: {
                    if (d2 >= 0.0) {
                        return vm_0.MIN;
                    }
                    return vm_02;
                }
                case MINUS: {
                    if (d2 >= 0.0) {
                        return vm_0.MAX;
                    }
                    return vm_02;
                }
                case MIN: {
                    if (d2 <= 0.0) {
                        return vm_0.MINUS;
                    }
                    return vm_02;
                }
                case MAX: {
                    if (d2 <= 0.0) {
                        return vm_0.PLUS;
                    }
                    return vm_02;
                }
            }
            throw new oY();
        }
    };


    private vl_0() {
    }

    protected abstract boolean a();

    protected abstract vm_0 a(vm_0 var1, double var2, boolean var4);

    /* synthetic */ vl_0(String string, int n2, byte by) {
        this();
    }
}

