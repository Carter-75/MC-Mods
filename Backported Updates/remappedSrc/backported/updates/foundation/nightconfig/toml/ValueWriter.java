/*
 * Decompiled with CFR 0.152.
 */
package backported.updates.foundation.nightconfig.toml;

import backported.updates.foundation.nightconfig.core.Config;
import backported.updates.foundation.nightconfig.core.NullObject;
import backported.updates.foundation.nightconfig.core.io.CharacterOutput;
import backported.updates.foundation.nightconfig.core.io.WritingException;
import backported.updates.foundation.nightconfig.toml.ArrayWriter;
import backported.updates.foundation.nightconfig.toml.StringWriter;
import backported.updates.foundation.nightconfig.toml.TableWriter;
import backported.updates.foundation.nightconfig.toml.TemporalWriter;
import backported.updates.foundation.nightconfig.toml.TomlWriter;
import java.time.temporal.Temporal;
import java.util.List;

final class ValueWriter {
    private static void writeString(String string, CharacterOutput output, TomlWriter writer) {
        if (writer.writesLiteral(string)) {
            StringWriter.writeLiteral(string, output);
        } else {
            StringWriter.writeBasic(string, output);
        }
    }

    static void write(Object value, CharacterOutput output, TomlWriter writer) {
        if (value instanceof Config) {
            TableWriter.writeInline((Config)value, output, writer);
        } else if (value instanceof List) {
            List list = (List)value;
            if (!list.isEmpty() && list.get(0) instanceof Config) {
                for (Object table : list) {
                    TableWriter.writeInline((Config)table, output, writer);
                }
            } else {
                ArrayWriter.write((List)value, output, writer);
            }
        } else if (value instanceof CharSequence) {
            ValueWriter.writeString(value.toString(), output, writer);
        } else if (value instanceof Enum) {
            ValueWriter.writeString(((Enum)value).name(), output, writer);
        } else if (value instanceof Temporal) {
            TemporalWriter.write((Temporal)value, output);
        } else if (value instanceof Float || value instanceof Double) {
            double d = ((Number)value).doubleValue();
            if (Double.isNaN(d)) {
                output.write("nan");
            } else if (d == Double.POSITIVE_INFINITY) {
                output.write("+inf");
            } else if (d == Double.NEGATIVE_INFINITY) {
                output.write("-inf");
            } else {
                output.write(value.toString());
            }
        } else if (value instanceof Number || value instanceof Boolean) {
            output.write(value.toString());
        } else {
            if (value == null || value == NullObject.NULL_OBJECT) {
                throw new WritingException("TOML doesn't support null values");
            }
            throw new WritingException("Unsupported value type: " + value.getClass());
        }
    }

    private ValueWriter() {
    }
}

