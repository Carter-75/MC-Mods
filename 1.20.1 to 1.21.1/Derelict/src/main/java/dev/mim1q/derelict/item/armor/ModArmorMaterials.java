/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.enums.EnumEntries
 *  kotlin.enums.EnumEntriesKt
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.class_1738$class_8051
 *  net.minecraft.class_1741
 *  net.minecraft.class_1856
 *  net.minecraft.class_1935
 *  net.minecraft.class_3414
 *  net.minecraft.class_3417
 *  org.jetbrains.annotations.NotNull
 */
package dev.mim1q.derelict.item.armor;

import dev.mim1q.derelict.init.ModBlocksAndItems;
import java.util.function.Supplier;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.class_1738;
import net.minecraft.class_1741;
import net.minecraft.class_1856;
import net.minecraft.class_1935;
import net.minecraft.class_3414;
import net.minecraft.class_3417;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0018\b\u0086\u0081\u0002\u0018\u0000 *2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0001*BO\b\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\u0005\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\u0006\u0010\r\u001a\u00020\f\u0012\u0006\u0010\u000e\u001a\u00020\f\u0012\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f\u00a2\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u0014H\u0016\u00a2\u0006\u0004\b\u0016\u0010\u0017J\u0017\u0010\u0018\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u0014H\u0016\u00a2\u0006\u0004\b\u0018\u0010\u0017J\u000f\u0010\u0019\u001a\u00020\u0005H\u0016\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\u000f\u0010\u001b\u001a\u00020\nH\u0016\u00a2\u0006\u0004\b\u001b\u0010\u001cJ\u000f\u0010\u001d\u001a\u00020\u0010H\u0016\u00a2\u0006\u0004\b\u001d\u0010\u001eJ\u000f\u0010\u001f\u001a\u00020\u0003H\u0016\u00a2\u0006\u0004\b\u001f\u0010 J\u000f\u0010!\u001a\u00020\fH\u0016\u00a2\u0006\u0004\b!\u0010\"J\u000f\u0010#\u001a\u00020\fH\u0016\u00a2\u0006\u0004\b#\u0010\"R\u0014\u0010\u0004\u001a\u00020\u00038\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0004\u0010$R\u0014\u0010\u0006\u001a\u00020\u00058\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0006\u0010%R\u0014\u0010\b\u001a\u00020\u00078\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\b\u0010&R\u0014\u0010\t\u001a\u00020\u00058\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010%R\u0014\u0010\u000b\u001a\u00020\n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010'R\u0014\u0010\r\u001a\u00020\f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010(R\u0014\u0010\u000e\u001a\u00020\f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010(R\u001a\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u0010)j\u0002\b+\u00a8\u0006,"}, d2={"Ldev/mim1q/derelict/item/armor/ModArmorMaterials;", "Lnet/minecraft/class_1741;", "", "", "id", "", "durabilityMultiplier", "", "protectionAmounts", "enchantability", "Lnet/minecraft/class_3414;", "equipSound", "", "toughness", "knockbackResistance", "Ljava/util/function/Supplier;", "Lnet/minecraft/class_1856;", "repairIngredientSupplier", "<init>", "(Ljava/lang/String;ILjava/lang/String;I[IILnet/minecraft/class_3414;FFLjava/util/function/Supplier;)V", "Lnet/minecraft/class_1738$class_8051;", "type", "getDurability", "(Lnet/minecraft/class_1738$class_8051;)I", "getProtection", "getEnchantability", "()I", "getEquipSound", "()Lnet/minecraft/class_3414;", "getRepairIngredient", "()Lnet/minecraft/class_1856;", "getName", "()Ljava/lang/String;", "getToughness", "()F", "getKnockbackResistance", "Ljava/lang/String;", "I", "[I", "Lnet/minecraft/class_3414;", "F", "Ljava/util/function/Supplier;", "Companion", "SPIDER", "derelict"})
public final class ModArmorMaterials
extends Enum<ModArmorMaterials>
implements class_1741 {
    @NotNull
    public static final Companion Companion;
    @NotNull
    private final String id;
    private final int durabilityMultiplier;
    @NotNull
    private final int[] protectionAmounts;
    private final int enchantability;
    @NotNull
    private final class_3414 equipSound;
    private final float toughness;
    private final float knockbackResistance;
    @NotNull
    private final Supplier<class_1856> repairIngredientSupplier;
    @NotNull
    private static final int[] BASE_DURABILITY;
    public static final /* enum */ ModArmorMaterials SPIDER;
    private static final /* synthetic */ ModArmorMaterials[] $VALUES;
    private static final /* synthetic */ EnumEntries $ENTRIES;

    private ModArmorMaterials(String id, int durabilityMultiplier, int[] protectionAmounts, int enchantability, class_3414 equipSound, float toughness, float knockbackResistance, Supplier<class_1856> repairIngredientSupplier) {
        this.id = id;
        this.durabilityMultiplier = durabilityMultiplier;
        this.protectionAmounts = protectionAmounts;
        this.enchantability = enchantability;
        this.equipSound = equipSound;
        this.toughness = toughness;
        this.knockbackResistance = knockbackResistance;
        this.repairIngredientSupplier = repairIngredientSupplier;
    }

    public int method_48402(@NotNull class_1738.class_8051 type) {
        Intrinsics.checkNotNullParameter((Object)type, (String)"type");
        return BASE_DURABILITY[type.ordinal()] * this.durabilityMultiplier;
    }

    public int method_48403(@NotNull class_1738.class_8051 type) {
        Intrinsics.checkNotNullParameter((Object)type, (String)"type");
        return this.protectionAmounts[type.ordinal()];
    }

    public int method_7699() {
        return this.enchantability;
    }

    @NotNull
    public class_3414 method_7698() {
        return this.equipSound;
    }

    @NotNull
    public class_1856 method_7695() {
        class_1856 class_18562 = this.repairIngredientSupplier.get();
        Intrinsics.checkNotNullExpressionValue((Object)class_18562, (String)"get(...)");
        return class_18562;
    }

    @NotNull
    public String method_7694() {
        return this.id;
    }

    public float method_7700() {
        return this.toughness;
    }

    public float method_24355() {
        return this.knockbackResistance;
    }

    public static ModArmorMaterials[] values() {
        return (ModArmorMaterials[])$VALUES.clone();
    }

    public static ModArmorMaterials valueOf(String value) {
        return Enum.valueOf(ModArmorMaterials.class, value);
    }

    @NotNull
    public static EnumEntries<ModArmorMaterials> getEntries() {
        return $ENTRIES;
    }

    private static final class_1856 _init_$lambda$0() {
        class_1935[] class_1935Array = new class_1935[]{ModBlocksAndItems.INSTANCE.getSPIDER_MOLT()};
        return class_1856.method_8091((class_1935[])class_1935Array);
    }

    static {
        int[] nArray = new int[]{3, 7, 5, 3};
        class_3414 class_34142 = class_3417.field_14760;
        Intrinsics.checkNotNullExpressionValue((Object)class_34142, (String)"ENTITY_SPIDER_STEP");
        SPIDER = new ModArmorMaterials("derelict_spider", 20, nArray, 10, class_34142, 0.0f, 0.0f, ModArmorMaterials::_init_$lambda$0);
        $VALUES = modArmorMaterialsArray = new ModArmorMaterials[]{ModArmorMaterials.SPIDER};
        $ENTRIES = EnumEntriesKt.enumEntries((Enum[])$VALUES);
        Companion = new Companion(null);
        nArray = new int[]{13, 15, 16, 11};
        BASE_DURABILITY = nArray;
    }

    @Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0007"}, d2={"Ldev/mim1q/derelict/item/armor/ModArmorMaterials$Companion;", "", "<init>", "()V", "", "BASE_DURABILITY", "[I", "derelict"})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }
}

