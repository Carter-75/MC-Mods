/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1309
 *  net.minecraft.class_5819
 *  net.minecraft.class_7988
 */
package backported.updates.content.common.api.variant;

import java.util.Optional;
import net.minecraft.class_1309;
import net.minecraft.class_5819;
import net.minecraft.class_7988;

public interface VariantDataHolder<T> {
    public static <T> VariantDataHolder<T> getHolder(class_1309 entity) {
        return entity instanceof VariantDataHolder ? (VariantDataHolder)entity : null;
    }

    public static <A, B> void trySetOffspringVariant(class_1309 child, class_1309 father, class_1309 mother) {
        class_5819 random = child.method_59922();
        Optional fromFather = VariantDataHolder.getHolder(father).getVariantData();
        Optional fromMother = VariantDataHolder.getHolder(mother).getVariantData();
        Optional<Object> dataVariant = fromFather.isPresent() && fromMother.isPresent() ? (random.method_43056() ? fromFather : fromMother) : (random.method_43056() ? fromFather.or(() -> fromMother) : Optional.empty());
        if (dataVariant.isPresent()) {
            dataVariant.ifPresent(variant -> VariantDataHolder.getHolder(child).setVariantData(variant));
        } else {
            Object variant2 = random.method_43056() ? ((class_7988)father).method_47827() : ((class_7988)mother).method_47827();
            ((class_7988)child).method_47826(variant2);
        }
    }

    public Optional<T> getVariantData();

    public void setVariantData(T var1);
}

