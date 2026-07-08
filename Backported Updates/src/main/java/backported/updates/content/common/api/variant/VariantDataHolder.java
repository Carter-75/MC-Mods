/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.LivingEntity
 *  net.minecraft.util.math.random.Random
 *  net.minecraft.entity.VariantHolder
 */
package backported.updates.content.common.api.variant;

import java.util.Optional;
import net.minecraft.entity.LivingEntity;
import net.minecraft.util.math.random.Random;
import net.minecraft.entity.VariantHolder;

public interface VariantDataHolder<T> {
    public static <T> VariantDataHolder<T> getHolder(LivingEntity entity) {
        return entity instanceof VariantDataHolder ? (VariantDataHolder)entity : null;
    }

    public static <A, B> void trySetOffspringVariant(LivingEntity child, LivingEntity father, LivingEntity mother) {
        Random random = child.getRandom();
        Optional fromFather = VariantDataHolder.getHolder(father).getVariantData();
        Optional fromMother = VariantDataHolder.getHolder(mother).getVariantData();
        Optional<Object> dataVariant = fromFather.isPresent() && fromMother.isPresent() ? (random.nextBoolean() ? fromFather : fromMother) : (random.nextBoolean() ? fromFather.or(() -> fromMother) : Optional.empty());
        if (dataVariant.isPresent()) {
            dataVariant.ifPresent(variant -> VariantDataHolder.getHolder(child).setVariantData(variant));
        } else {
            Object variant2 = random.nextBoolean() ? ((VariantHolder)father).getVariant() : ((VariantHolder)mother).getVariant();
            ((VariantHolder)child).setVariant(variant2);
        }
    }

    public Optional<T> getVariantData();

    public void setVariantData(T var1);
}

