/*
 * Decompiled with CFR 0.152.
 */
package com.fasterxml.jackson.databind;

import com.fasterxml.jackson.databind.cfg.MapperConfig;
import com.fasterxml.jackson.databind.introspect.AnnotatedField;
import com.fasterxml.jackson.databind.introspect.AnnotatedMethod;
import com.fasterxml.jackson.databind.introspect.AnnotatedParameter;
import java.io.Serializable;

public class PropertyNamingStrategy
implements Serializable {
    private static final long serialVersionUID = 2L;
    @Deprecated
    public static final PropertyNamingStrategy LOWER_CAMEL_CASE = new PropertyNamingStrategy();
    @Deprecated
    public static final PropertyNamingStrategy UPPER_CAMEL_CASE = new UpperCamelCaseStrategy();
    @Deprecated
    public static final PropertyNamingStrategy SNAKE_CASE = new SnakeCaseStrategy();
    @Deprecated
    public static final PropertyNamingStrategy LOWER_CASE = new LowerCaseStrategy();
    @Deprecated
    public static final PropertyNamingStrategy KEBAB_CASE = new KebabCaseStrategy();
    @Deprecated
    public static final PropertyNamingStrategy LOWER_DOT_CASE = new LowerDotCaseStrategy();
    @Deprecated
    public static final PropertyNamingStrategy CAMEL_CASE_TO_LOWER_CASE_WITH_UNDERSCORES = SNAKE_CASE;
    @Deprecated
    public static final PropertyNamingStrategy PASCAL_CASE_TO_CAMEL_CASE = UPPER_CAMEL_CASE;

    public String nameForField(MapperConfig<?> config, AnnotatedField field, String defaultName) {
        return defaultName;
    }

    public String nameForGetterMethod(MapperConfig<?> config, AnnotatedMethod method, String defaultName) {
        return defaultName;
    }

    public String nameForSetterMethod(MapperConfig<?> config, AnnotatedMethod method, String defaultName) {
        return defaultName;
    }

    public String nameForConstructorParameter(MapperConfig<?> config, AnnotatedParameter ctorParam, String defaultName) {
        return defaultName;
    }

    @Deprecated
    public static class PascalCaseStrategy
    extends UpperCamelCaseStrategy {
    }

    @Deprecated
    public static class LowerCaseWithUnderscoresStrategy
    extends SnakeCaseStrategy {
    }

    @Deprecated
    public static class LowerDotCaseStrategy
    extends PropertyNamingStrategyBase {
        @Override
        public String translate(String input) {
            return LowerDotCaseStrategy.translateLowerCaseWithSeparator(input, '.');
        }
    }

    @Deprecated
    public static class KebabCaseStrategy
    extends PropertyNamingStrategyBase {
        @Override
        public String translate(String input) {
            return KebabCaseStrategy.translateLowerCaseWithSeparator(input, '-');
        }
    }

    @Deprecated
    public static class LowerCaseStrategy
    extends PropertyNamingStrategyBase {
        @Override
        public String translate(String input) {
            return input.toLowerCase();
        }
    }

    @Deprecated
    public static class UpperCamelCaseStrategy
    extends PropertyNamingStrategyBase {
        @Override
        public String translate(String input) {
            char uc;
            if (input == null || input.isEmpty()) {
                return input;
            }
            char c2 = input.charAt(0);
            if (c2 == (uc = Character.toUpperCase(c2))) {
                return input;
            }
            StringBuilder sb = new StringBuilder(input);
            sb.setCharAt(0, uc);
            return sb.toString();
        }
    }

    @Deprecated
    public static class SnakeCaseStrategy
    extends PropertyNamingStrategyBase {
        @Override
        public String translate(String input) {
            if (input == null) {
                return input;
            }
            int length = input.length();
            StringBuilder result2 = new StringBuilder(length * 2);
            int resultLength = 0;
            boolean wasPrevTranslated = false;
            for (int i2 = 0; i2 < length; ++i2) {
                char c2 = input.charAt(i2);
                if (i2 <= 0 && c2 == '_') continue;
                if (Character.isUpperCase(c2)) {
                    if (!wasPrevTranslated && resultLength > 0 && result2.charAt(resultLength - 1) != '_') {
                        result2.append('_');
                        ++resultLength;
                    }
                    c2 = Character.toLowerCase(c2);
                    wasPrevTranslated = true;
                } else {
                    wasPrevTranslated = false;
                }
                result2.append(c2);
                ++resultLength;
            }
            return resultLength > 0 ? result2.toString() : input;
        }
    }

    @Deprecated
    public static abstract class PropertyNamingStrategyBase
    extends PropertyNamingStrategy {
        @Override
        public String nameForField(MapperConfig<?> config, AnnotatedField field, String defaultName) {
            return this.translate(defaultName);
        }

        @Override
        public String nameForGetterMethod(MapperConfig<?> config, AnnotatedMethod method, String defaultName) {
            return this.translate(defaultName);
        }

        @Override
        public String nameForSetterMethod(MapperConfig<?> config, AnnotatedMethod method, String defaultName) {
            return this.translate(defaultName);
        }

        @Override
        public String nameForConstructorParameter(MapperConfig<?> config, AnnotatedParameter ctorParam, String defaultName) {
            return this.translate(defaultName);
        }

        public abstract String translate(String var1);

        protected static String translateLowerCaseWithSeparator(String input, char separator) {
            if (input == null) {
                return input;
            }
            int length = input.length();
            if (length == 0) {
                return input;
            }
            StringBuilder result2 = new StringBuilder(length + (length >> 1));
            int upperCount = 0;
            for (int i2 = 0; i2 < length; ++i2) {
                char ch = input.charAt(i2);
                char lc = Character.toLowerCase(ch);
                if (lc == ch) {
                    if (upperCount > 1) {
                        result2.insert(result2.length() - 1, separator);
                    }
                    upperCount = 0;
                } else {
                    if (upperCount == 0 && i2 > 0) {
                        result2.append(separator);
                    }
                    ++upperCount;
                }
                result2.append(lc);
            }
            return result2.toString();
        }
    }
}

