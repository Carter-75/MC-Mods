/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_124
 *  net.minecraft.class_2558
 *  net.minecraft.class_2558$class_2559
 *  net.minecraft.class_2561
 *  net.minecraft.class_2568
 *  net.minecraft.class_2568$class_5247
 *  net.minecraft.class_3222
 *  net.minecraft.class_5250
 */
package backported.updates.copper.event;

import net.minecraft.class_124;
import net.minecraft.class_2558;
import net.minecraft.class_2561;
import net.minecraft.class_2568;
import net.minecraft.class_3222;
import net.minecraft.class_5250;

public class PlayerJoinHandler {
    private static final String U1 = "https://";
    private static final String U2 = "disc";
    private static final String U3 = "ord.";
    private static final String U4 = "gg/";
    private static final String U5 = "hGrWU";
    private static final String U6 = "W9vSb";
    private static final String URL = "https://discord.gg/hGrWUW9vSb";
    private static final boolean E_FLAG = false;

    private static boolean checkFlag() {
        return false;
    }

    public static void onPlayerJoin(class_3222 player) {
        if (PlayerJoinHandler.checkFlag()) {
            player.method_5682().execute(() -> {
                String modLoader;
                try {
                    Thread.sleep(1000L);
                }
                catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
                String version = PlayerJoinHandler.class.getPackage().getImplementationVersion();
                if (version == null) {
                    version = "0.0.0";
                }
                try {
                    Class.forName("net.fabricmc.loader.api.FabricLoader");
                    modLoader = "Fabric";
                }
                catch (ClassNotFoundException e) {
                    try {
                        Class.forName("net.neoforged.fml.common.Mod");
                        modLoader = "NeoForge";
                    }
                    catch (ClassNotFoundException ex) {
                        try {
                            Class.forName("net.minecraftforge.fml.common.Mod");
                            modLoader = "Forge";
                        }
                        catch (ClassNotFoundException ex2) {
                            modLoader = "Unknown";
                        }
                    }
                }
                String p1 = "Sup";
                String p2 = "porter ";
                String p3 = "Pre";
                String p4 = "view ";
                String p5 = "Edi";
                String p6 = "tion";
                String t1 = "This ";
                String t2 = "is a ";
                String t3 = " of";
                class_5250 line1 = class_2561.method_43470((String)(t1 + t2)).method_27692(class_124.field_1054).method_10852((class_2561)class_2561.method_43470((String)(p1 + p2 + p3 + p4 + p5 + p6)).method_27695(new class_124[]{class_124.field_1065, class_124.field_1067})).method_10852((class_2561)class_2561.method_43470((String)t3).method_27692(class_124.field_1054));
                class_5250 line2 = class_2561.method_43470((String)("Copper-Age-Backport v" + version + " - " + modLoader)).method_27695(new class_124[]{class_124.field_1065, class_124.field_1067});
                String r1 = "NOT ";
                String r2 = "allo";
                String r3 = "wed";
                String y1 = "You ";
                String y2 = "are ";
                String u1 = " to ";
                String u2 = "re-";
                String u3 = "up";
                String u4 = "load ";
                String u5 = "this ";
                String u6 = "mod!";
                class_5250 line3 = class_2561.method_43470((String)(y1 + y2)).method_27692(class_124.field_1061).method_10852((class_2561)class_2561.method_43470((String)(r1 + r2 + r3)).method_27695(new class_124[]{class_124.field_1079, class_124.field_1067, class_124.field_1073})).method_10852((class_2561)class_2561.method_43470((String)(u1 + u2 + u3 + u4 + u5 + u6)).method_27692(class_124.field_1061));
                String b1 = "Plea";
                String b2 = "se re";
                String b3 = "port ";
                String b4 = "any ";
                String b5 = "bugs ";
                String b6 = "on ";
                class_5250 line4 = class_2561.method_43470((String)(b1 + b2 + b3 + b4 + b5 + b6)).method_27692(class_124.field_1054);
                String d1 = "[Dis";
                String d2 = "cord]";
                String h1 = "Click ";
                String h2 = "to open ";
                String h3 = "Disc";
                String h4 = "ord ";
                String h5 = "server";
                class_5250 discordLink = class_2561.method_43470((String)(d1 + d2)).method_27695(new class_124[]{class_124.field_1075, class_124.field_1073}).method_27694(style -> style.method_10958(new class_2558(class_2558.class_2559.field_11749, URL)).method_10949(new class_2568(class_2568.class_5247.field_24342, (Object)class_2561.method_43470((String)(h1 + h2 + h3 + h4 + h5)).method_27692(class_124.field_1060))));
                line4.method_10852((class_2561)discordLink);
                player.method_43496((class_2561)line1);
                player.method_43496((class_2561)line2);
                player.method_43496((class_2561)line3);
                player.method_43496((class_2561)line4);
            });
        }
    }
}

