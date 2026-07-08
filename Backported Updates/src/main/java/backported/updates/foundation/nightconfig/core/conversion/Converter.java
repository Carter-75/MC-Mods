/*
 * Decompiled with CFR 0.152.
 */
package backported.updates.foundation.nightconfig.core.conversion;

public interface Converter<FieldType, ConfigValueType> {
    public FieldType convertToField(ConfigValueType var1);

    public ConfigValueType convertFromField(FieldType var1);
}

