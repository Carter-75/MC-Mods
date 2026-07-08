/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1266
 *  net.minecraft.class_1268
 *  net.minecraft.class_1269
 *  net.minecraft.class_1293
 *  net.minecraft.class_1294
 *  net.minecraft.class_1297
 *  net.minecraft.class_1299
 *  net.minecraft.class_1304
 *  net.minecraft.class_1309
 *  net.minecraft.class_1314
 *  net.minecraft.class_1352
 *  net.minecraft.class_1399
 *  net.minecraft.class_1588
 *  net.minecraft.class_1603
 *  net.minecraft.class_1657
 *  net.minecraft.class_1665
 *  net.minecraft.class_1675
 *  net.minecraft.class_1792
 *  net.minecraft.class_1799
 *  net.minecraft.class_1802
 *  net.minecraft.class_1935
 *  net.minecraft.class_1937
 *  net.minecraft.class_2338
 *  net.minecraft.class_238
 *  net.minecraft.class_243
 *  net.minecraft.class_2487
 *  net.minecraft.class_2561
 *  net.minecraft.class_2940
 *  net.minecraft.class_2941
 *  net.minecraft.class_2943
 *  net.minecraft.class_2945
 *  net.minecraft.class_3417
 *  net.minecraft.class_5132$class_5133
 *  net.minecraft.class_5134
 *  net.minecraft.class_5819
 */
package ace.actually.pirates.entities.friendly_pirate;

import ace.actually.pirates.Pirates;
import ace.actually.pirates.entities.pirate_abstract.AbstractPirateEntity;
import ace.actually.pirates.entities.pirate_abstract.PirateBowAttackGoal;
import java.util.List;
import net.minecraft.class_1266;
import net.minecraft.class_1268;
import net.minecraft.class_1269;
import net.minecraft.class_1293;
import net.minecraft.class_1294;
import net.minecraft.class_1297;
import net.minecraft.class_1299;
import net.minecraft.class_1304;
import net.minecraft.class_1309;
import net.minecraft.class_1314;
import net.minecraft.class_1352;
import net.minecraft.class_1399;
import net.minecraft.class_1588;
import net.minecraft.class_1603;
import net.minecraft.class_1657;
import net.minecraft.class_1665;
import net.minecraft.class_1675;
import net.minecraft.class_1792;
import net.minecraft.class_1799;
import net.minecraft.class_1802;
import net.minecraft.class_1935;
import net.minecraft.class_1937;
import net.minecraft.class_2338;
import net.minecraft.class_238;
import net.minecraft.class_243;
import net.minecraft.class_2487;
import net.minecraft.class_2561;
import net.minecraft.class_2940;
import net.minecraft.class_2941;
import net.minecraft.class_2943;
import net.minecraft.class_2945;
import net.minecraft.class_3417;
import net.minecraft.class_5132;
import net.minecraft.class_5134;
import net.minecraft.class_5819;

public class FriendlyPirateEntity
extends AbstractPirateEntity
implements class_1603 {
    private static final String[] FIRST = new String[]{"Johan", "John", "Bob", "Cali", "Dorris", "Lopez", "Wilhelm", "Armstrong", "David", "Giorno"};
    private static final String[] LAST = new String[]{"Diver", "Smith", "Forest", "Maze", "Fisherman", "Callous", "Calculated", "Fierce", "Flatulent", "Agreeable", "Rational"};
    private static final class_2940<String> JOB = class_2945.method_12791(FriendlyPirateEntity.class, (class_2941)class_2943.field_13326);

    public FriendlyPirateEntity(class_1937 world) {
        super((class_1299<? extends class_1588>)((class_1299)Pirates.FRIENDLY_PIRATE_TYPE.get()), world, class_2338.field_10980);
    }

    public FriendlyPirateEntity(class_1299<? extends class_1588> entityEntityType, class_1937 level) {
        super(entityEntityType, level, class_2338.field_10980);
    }

    public String getPirateJob() {
        return (String)this.field_6011.method_12789(JOB);
    }

    public void setPirateJob(String pirateJob) {
        this.field_6011.method_12778(JOB, (Object)pirateJob);
    }

    @Override
    public void method_5652(class_2487 nbt) {
        super.method_5652(nbt);
        nbt.method_10582("pirateJob", (String)this.field_6011.method_12789(JOB));
    }

    @Override
    public void method_5749(class_2487 nbt) {
        super.method_5749(nbt);
        this.field_6011.method_12778(JOB, (Object)nbt.method_10558("pirateJob"));
    }

    public FriendlyPirateEntity(class_1937 world, class_2338 blockToDisable) {
        super((class_1299<? extends class_1588>)((class_1299)Pirates.FRIENDLY_PIRATE_TYPE.get()), world, blockToDisable);
        this.method_5964(world.field_9229, world.method_8404(this.method_24515()));
    }

    protected void method_5693() {
        super.method_5693();
        this.field_6011.method_12784(JOB, (Object)"none");
    }

    public void genCustomName(class_1937 world) {
        this.method_5665(class_2561.method_30163((String)(FIRST[world.field_9229.method_43048(FIRST.length)] + " the " + LAST[world.field_9229.method_43048(LAST.length)])));
    }

    @Override
    protected void method_5959() {
        super.method_5959();
        this.field_6201.method_6277(3, new PirateBowAttackGoal<FriendlyPirateEntity>(this, 1.0, 20, 20.0f));
        this.field_6185.method_6277(1, (class_1352)new class_1399((class_1314)this, new Class[0]));
    }

    public void method_5773() {
        super.method_5773();
        if (this.method_5770().method_8532() % 1000L == 0L && this.getPirateJob().equals("doctor")) {
            List crew = this.method_5770().method_8390(FriendlyPirateEntity.class, new class_238(this.method_24515().method_10069(-10, -10, -10), this.method_24515().method_10069(10, 10, 10)), class_1309::method_5805);
            crew.forEach(a -> a.method_6092(new class_1293(class_1294.field_5924, 500, 1)));
        }
    }

    public static class_5132.class_5133 attributes() {
        return FriendlyPirateEntity.method_26918().method_26868(class_5134.field_23719, 0.3).method_26868(class_5134.field_23717, 100.0);
    }

    protected void method_5964(class_5819 random, class_1266 localDifficulty) {
        super.method_5964(random, localDifficulty);
        this.method_5673(class_1304.field_6173, new class_1799((class_1935)class_1802.field_8102));
    }

    public void method_7105(class_1309 target, float pullProgress) {
        class_1799 itemStack = this.method_5998(class_1675.method_18812((class_1309)this, (class_1792)class_1802.field_8102));
        class_1665 persistentProjectileEntity = this.createArrowProjectile(itemStack, pullProgress);
        double d = target.method_23317() - this.method_23317();
        double e = target.method_23323(0.3333333333333333) - persistentProjectileEntity.method_23318();
        double f = target.method_23321() - this.method_23321();
        double g = Math.sqrt(d * d + f * f);
        persistentProjectileEntity.method_7485(d, e + g * (double)0.2f, f, 1.6f, (float)(14 - this.method_5770().method_8407().method_5461() * 4));
        this.method_5783(class_3417.field_14633, 1.0f, 1.0f / (this.method_6051().method_43057() * 0.4f + 0.8f));
        this.method_5770().method_8649((class_1297)persistentProjectileEntity);
    }

    protected class_1665 createArrowProjectile(class_1799 arrow, float damageModifier) {
        return class_1675.method_18813((class_1309)this, (class_1799)arrow, (float)damageModifier);
    }

    public class_1269 method_5664(class_1657 player, class_243 hitPos, class_1268 hand) {
        class_1799 stack = Pirates.recruitCost.get();
        if (!this.method_16914() && player.method_5998(hand).method_31574(stack.method_7909()) && player.method_5998(hand).method_7947() >= stack.method_7947()) {
            player.method_7270(new class_1799((class_1935)Pirates.CANNONEER_ITEM.get()));
            player.method_5998(hand).method_7934(stack.method_7947());
            this.method_20620(0.0, 0.0, 0.0);
            this.method_5768();
        }
        return super.method_5664(player, hitPos, hand);
    }
}

