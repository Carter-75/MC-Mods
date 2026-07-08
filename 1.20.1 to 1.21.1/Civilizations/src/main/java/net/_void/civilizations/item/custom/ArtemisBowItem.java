/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1268
 *  net.minecraft.class_1271
 *  net.minecraft.class_1297
 *  net.minecraft.class_1309
 *  net.minecraft.class_1657
 *  net.minecraft.class_1665
 *  net.minecraft.class_1665$class_1666
 *  net.minecraft.class_1744
 *  net.minecraft.class_1792$class_1793
 *  net.minecraft.class_1799
 *  net.minecraft.class_1802
 *  net.minecraft.class_1811
 *  net.minecraft.class_1839
 *  net.minecraft.class_1887
 *  net.minecraft.class_1890
 *  net.minecraft.class_1893
 *  net.minecraft.class_1935
 *  net.minecraft.class_1937
 *  net.minecraft.class_243
 *  net.minecraft.class_3417
 *  net.minecraft.class_3419
 *  net.minecraft.class_3468
 *  net.minecraft.class_5150
 *  org.joml.Quaternionf
 *  org.joml.Quaternionfc
 *  org.joml.Vector3f
 */
package net._void.civilizations.item.custom;

import java.util.function.Predicate;
import net.minecraft.class_1268;
import net.minecraft.class_1271;
import net.minecraft.class_1297;
import net.minecraft.class_1309;
import net.minecraft.class_1657;
import net.minecraft.class_1665;
import net.minecraft.class_1744;
import net.minecraft.class_1792;
import net.minecraft.class_1799;
import net.minecraft.class_1802;
import net.minecraft.class_1811;
import net.minecraft.class_1839;
import net.minecraft.class_1887;
import net.minecraft.class_1890;
import net.minecraft.class_1893;
import net.minecraft.class_1935;
import net.minecraft.class_1937;
import net.minecraft.class_243;
import net.minecraft.class_3417;
import net.minecraft.class_3419;
import net.minecraft.class_3468;
import net.minecraft.class_5150;
import org.joml.Quaternionf;
import org.joml.Quaternionfc;
import org.joml.Vector3f;

public class ArtemisBowItem
extends class_1811
implements class_5150 {
    public static final int TICKS_PER_SECOND = 20;
    public static final int RANGE = 15;

    public ArtemisBowItem(class_1792.class_1793 settings) {
        super(settings);
    }

    public void method_7840(class_1799 stack, class_1937 world, class_1309 user, int remainingUseTicks) {
        if (user instanceof class_1657) {
            class_1657 playerEntity = (class_1657)user;
            boolean bl = playerEntity.method_31549().field_7477 || class_1890.method_8225((class_1887)class_1893.field_9125, (class_1799)stack) > 0;
            class_1799 itemStack = playerEntity.method_18808(stack);
            if (!itemStack.method_7960() || bl) {
                int i;
                float f;
                if (itemStack.method_7960()) {
                    itemStack = new class_1799((class_1935)class_1802.field_8107);
                }
                if (!((double)(f = ArtemisBowItem.getPullProgress(i = this.method_7881(stack) - remainingUseTicks)) < 0.1)) {
                    boolean bl2;
                    boolean bl3 = bl2 = bl && itemStack.method_31574(class_1802.field_8107);
                    if (!world.field_9236) {
                        int k;
                        int j;
                        class_1744 arrowItem = (class_1744)(itemStack.method_7909() instanceof class_1744 ? itemStack.method_7909() : class_1802.field_8107);
                        class_1665 persistentProjectileEntity = arrowItem.method_7702(world, itemStack, (class_1309)playerEntity);
                        persistentProjectileEntity.method_24919((class_1297)playerEntity, playerEntity.method_36455(), playerEntity.method_36454(), 0.0f, f * 3.0f, 1.0f);
                        persistentProjectileEntity.method_5639(100);
                        persistentProjectileEntity.method_7438(persistentProjectileEntity.method_7448() + 2.0);
                        class_1665 persistentProjectileEntity2 = arrowItem.method_7702(world, itemStack, (class_1309)playerEntity);
                        class_243 vec3d = playerEntity.method_18864(1.0f);
                        Quaternionf quaternionf = new Quaternionf().setAngleAxis(0.1745329201221466, vec3d.field_1352, vec3d.field_1351, vec3d.field_1350);
                        class_243 vec3d2 = playerEntity.method_5828(1.0f);
                        Vector3f vector3f = vec3d2.method_46409().rotate((Quaternionfc)quaternionf);
                        persistentProjectileEntity2.method_7485((double)vector3f.x(), (double)vector3f.y(), (double)vector3f.z(), f * 3.0f, 1.0f);
                        persistentProjectileEntity2.method_5639(100);
                        persistentProjectileEntity2.method_7438(persistentProjectileEntity2.method_7448() + 2.0);
                        class_1665 persistentProjectileEntity3 = arrowItem.method_7702(world, itemStack, (class_1309)playerEntity);
                        Quaternionf quaternionf2 = new Quaternionf().setAngleAxis(-0.1745329201221466, vec3d.field_1352, vec3d.field_1351, vec3d.field_1350);
                        Vector3f vector3f2 = vec3d2.method_46409().rotate((Quaternionfc)quaternionf2);
                        persistentProjectileEntity3.method_7485((double)vector3f2.x(), (double)vector3f2.y(), (double)vector3f2.z(), f * 3.0f, 1.0f);
                        persistentProjectileEntity3.method_5639(100);
                        persistentProjectileEntity3.method_7438(persistentProjectileEntity3.method_7448() + 2.0);
                        if (f == 1.0f) {
                            persistentProjectileEntity.method_7439(true);
                            persistentProjectileEntity2.method_7439(true);
                            persistentProjectileEntity3.method_7439(true);
                        }
                        if ((j = class_1890.method_8225((class_1887)class_1893.field_9103, (class_1799)stack)) > 0) {
                            persistentProjectileEntity.method_7438(persistentProjectileEntity.method_7448() + (double)j * 0.5 + 0.5);
                            persistentProjectileEntity2.method_7438(persistentProjectileEntity.method_7448() + (double)j * 0.5 + 0.5);
                            persistentProjectileEntity3.method_7438(persistentProjectileEntity.method_7448() + (double)j * 0.5 + 0.5);
                        }
                        if ((k = class_1890.method_8225((class_1887)class_1893.field_9116, (class_1799)stack)) > 0) {
                            persistentProjectileEntity.method_7449(k);
                            persistentProjectileEntity2.method_7449(k);
                            persistentProjectileEntity3.method_7449(k);
                        }
                        if (class_1890.method_8225((class_1887)class_1893.field_9126, (class_1799)stack) > 0) {
                            persistentProjectileEntity.method_5639(200);
                            persistentProjectileEntity2.method_5639(200);
                            persistentProjectileEntity3.method_5639(200);
                        }
                        stack.method_7956(1, (class_1309)playerEntity, p -> p.method_20236(playerEntity.method_6058()));
                        persistentProjectileEntity2.field_7572 = class_1665.class_1666.field_7594;
                        persistentProjectileEntity3.field_7572 = class_1665.class_1666.field_7594;
                        if (bl2 || playerEntity.method_31549().field_7477 && (itemStack.method_31574(class_1802.field_8236) || itemStack.method_31574(class_1802.field_8087))) {
                            persistentProjectileEntity.field_7572 = class_1665.class_1666.field_7594;
                        }
                        world.method_8649((class_1297)persistentProjectileEntity);
                        world.method_8649((class_1297)persistentProjectileEntity2);
                        world.method_8649((class_1297)persistentProjectileEntity3);
                    }
                    world.method_43128((class_1657)null, playerEntity.method_23317(), playerEntity.method_23318(), playerEntity.method_23321(), class_3417.field_14600, class_3419.field_15248, 1.0f, 1.0f / (world.method_8409().method_43057() * 0.4f + 1.2f) + f * 0.5f);
                    if (!bl2 && !playerEntity.method_31549().field_7477) {
                        itemStack.method_7934(1);
                        if (itemStack.method_7960()) {
                            playerEntity.method_31548().method_7378(itemStack);
                        }
                    }
                    playerEntity.method_7259(class_3468.field_15372.method_14956((Object)this));
                }
            }
        }
    }

    public static float getPullProgress(int useTicks) {
        float f = (float)useTicks / 20.0f;
        if ((f = (f * f + f * 2.0f) / 3.0f) > 1.0f) {
            f = 1.0f;
        }
        return f;
    }

    public int method_7881(class_1799 stack) {
        return 72000;
    }

    public class_1839 method_7853(class_1799 stack) {
        return class_1839.field_8953;
    }

    public class_1271<class_1799> method_7836(class_1937 world, class_1657 user, class_1268 hand) {
        boolean bl;
        class_1799 itemStack = user.method_5998(hand);
        boolean bl2 = bl = !user.method_18808(itemStack).method_7960();
        if (!user.method_31549().field_7477 && !bl) {
            return class_1271.method_22431((Object)itemStack);
        }
        user.method_6019(hand);
        return class_1271.method_22428((Object)itemStack);
    }

    public Predicate<class_1799> method_19268() {
        return field_18281;
    }

    public int method_24792() {
        return 15;
    }
}

