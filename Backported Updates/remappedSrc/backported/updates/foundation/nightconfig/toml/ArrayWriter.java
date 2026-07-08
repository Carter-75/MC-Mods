/*
 * Decompiled with CFR 0.152.
 */
package backported.updates.foundation.nightconfig.toml;

import backported.updates.foundation.nightconfig.core.io.CharacterOutput;
import backported.updates.foundation.nightconfig.toml.TomlWriter;
import backported.updates.foundation.nightconfig.toml.ValueWriter;
import java.util.Iterator;
import java.util.List;

final class ArrayWriter {
    private static final char[] EMPTY_ARRAY = new char[]{'[', ']'};
    static final char[] ELEMENT_SEPARATOR = new char[]{',', ' '};

    static void write(List<?> values, CharacterOutput output, TomlWriter writer) {
        if (values.isEmpty()) {
            output.write(EMPTY_ARRAY);
            return;
        }
        output.write('[');
        boolean indent = writer.writesIndented(values);
        if (indent) {
            writer.increaseIndentLevel();
        }
        Iterator<?> iterator = values.iterator();
        boolean hasNext = iterator.hasNext();
        while (hasNext) {
            if (indent) {
                writer.writeNewline(output);
                writer.writeIndent(output);
            }
            Object value = iterator.next();
            ValueWriter.write(value, output, writer);
            hasNext = iterator.hasNext();
            if (!hasNext) continue;
            if (indent) {
                output.write(',');
                continue;
            }
            output.write(ELEMENT_SEPARATOR);
        }
        if (indent) {
            writer.decreaseIndentLevel();
            writer.writeNewline(output);
        }
        output.write(']');
    }

    private ArrayWriter() {
    }
}

