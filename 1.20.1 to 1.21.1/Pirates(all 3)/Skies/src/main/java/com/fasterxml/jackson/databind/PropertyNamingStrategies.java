/*
 * Decompiled with CFR 0.152.
 */
package com.fasterxml.jackson.databind;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.cfg.MapperConfig;
import com.fasterxml.jackson.databind.introspect.AnnotatedField;
import com.fasterxml.jackson.databind.introspect.AnnotatedMethod;
import com.fasterxml.jackson.databind.introspect.AnnotatedParameter;
import java.io.Serializable;

public abstract class PropertyNamingStrategies
implements Serializable {
    private static final long serialVersionUID = 2L;
    public static final PropertyNamingStrategy LOWER_CAMEL_CASE = LowerCamelCaseStrategy.INSTANCE;
    public static final PropertyNamingStrategy UPPER_CAMEL_CASE = UpperCamelCaseStrategy.INSTANCE;
    public static final PropertyNamingStrategy SNAKE_CASE = SnakeCaseStrategy.INSTANCE;
    public static final PropertyNamingStrategy UPPER_SNAKE_CASE = UpperSnakeCaseStrategy.INSTANCE;
    public static final PropertyNamingStrategy LOWER_CASE = LowerCaseStrategy.INSTANCE;
    public static final PropertyNamingStrategy KEBAB_CASE = KebabCaseStrategy.INSTANCE;
    public static final PropertyNamingStrategy LOWER_DOT_CASE = LowerDotCaseStrategy.INSTANCE;

    public static class LowerDotCaseStrategy
    extends NamingBase {
        private static final long serialVersionUID = 2L;
        public static final LowerDotCaseStrategy INSTANCE = new LowerDotCaseStrategy();

        @Override
        public String translate(String input) {
            return this.translateLowerCaseWithSeparator(input, '.');
        }
    }

    public static class KebabCaseStrategy
    extends NamingBase {
        private static final long serialVersionUID = 2L;
        public static final KebabCaseStrategy INSTANCE = new KebabCaseStrategy();

        @Override
        public String translate(String input) {
            return this.translateLowerCaseWithSeparator(input, '-');
        }
    }

    public static class LowerCaseStrategy
    extends NamingBase {
        private static final long serialVersionUID = 2L;
        public static final LowerCaseStrategy INSTANCE = new LowerCaseStrategy();

        @Override
        public String translate(String input) {
            return input.toLowerCase();
        }
    }

    public static class UpperCamelCaseStrategy
    extends NamingBase {
        private static final long serialVersionUID = 2L;
        public static final UpperCamelCaseStrategy INSTANCE = new UpperCamelCaseStrategy();

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

    public static class LowerCamelCaseStrategy
    extends NamingBase {
        private static final long serialVersionUID = 2L;
        public static final LowerCamelCaseStrategy INSTANCE = new LowerCamelCaseStrategy();

        @Override
        public String translate(String input) {
            return input;
        }
    }

    public static class UpperSnakeCaseStrategy
    extends SnakeCaseStrategy {
        private static final long serialVersionUID = 2L;
        public static final UpperSnakeCaseStrategy INSTANCE = new UpperSnakeCaseStrategy();

        @Override
        public String translate(String input) {
            String output = super.translate(input);
            if (output == null) {
                return null;
            }
            return super.translate(input).toUpperCase();
        }
    }

    public static class SnakeCaseStrategy
    extends NamingBase {
        private static final long serialVersionUID = 2L;
        public static final SnakeCaseStrategy INSTANCE = new SnakeCaseStrategy();

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

    public static abstract class NamingBase
    extends PropertyNamingStrategy {
        private static final long serialVersionUID = 2L;

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

        protected String translateLowerCaseWithSeparator(String input, char separator) {
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

