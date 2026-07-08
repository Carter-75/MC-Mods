/*
 * Decompiled with CFR 0.152.
 */
package backported.updates.foundation.nightconfig.toml;

import backported.updates.foundation.nightconfig.core.UnmodifiableCommentedConfig;
import backported.updates.foundation.nightconfig.core.UnmodifiableConfig;
import backported.updates.foundation.nightconfig.core.io.CharacterOutput;
import backported.updates.foundation.nightconfig.core.io.WritingException;
import backported.updates.foundation.nightconfig.toml.ArrayWriter;
import backported.updates.foundation.nightconfig.toml.TomlWriter;
import backported.updates.foundation.nightconfig.toml.ValueWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

final class TableWriter {
    private static final char[] KEY_VALUE_SEPARATOR = new char[]{' ', '=', ' '};
    private static final char[] INLINE_ENTRY_SEPARATOR = ArrayWriter.ELEMENT_SEPARATOR;
    private static final char[] ARRAY_OF_TABLES_NAME_BEGIN = new char[]{'[', '['};
    private static final char[] ARRAY_OF_TABLES_NAME_END = new char[]{']', ']'};
    private static final char[] TABLE_NAME_BEGIN = new char[]{'['};
    private static final char[] TABLE_NAME_END = new char[]{']'};

    static void writeInline(UnmodifiableConfig config, CharacterOutput output, TomlWriter writer) {
        output.write('{');
        for (Map.Entry<String, Object> entry : config.valueMap().entrySet()) {
            String key = entry.getKey();
            Object value = entry.getValue();
            writer.writeKey(key, output);
            output.write(KEY_VALUE_SEPARATOR);
            ValueWriter.write(value, output, writer);
            output.write(INLINE_ENTRY_SEPARATOR);
        }
        output.write('}');
    }

    static void writeNormal(UnmodifiableConfig config, List<String> configPath, CharacterOutput output, TomlWriter writer) {
        UnmodifiableCommentedConfig commentedConfig = UnmodifiableCommentedConfig.fake(config);
        TableWriter.writeNormal(commentedConfig, configPath, output, writer);
    }

    private static void writeNormal(UnmodifiableCommentedConfig config, List<String> configPath, CharacterOutput output, TomlWriter writer) {
        ArrayList<UnmodifiableCommentedConfig.Entry> tablesEntries = new ArrayList<UnmodifiableCommentedConfig.Entry>();
        ArrayList<UnmodifiableCommentedConfig.Entry> tableArraysEntries = new ArrayList<UnmodifiableCommentedConfig.Entry>();
        writer.increaseIndentLevel();
        for (UnmodifiableCommentedConfig.Entry entry : config.entrySet()) {
            List list;
            String key = entry.getKey();
            Object value = entry.getValue();
            String comment = entry.getComment();
            if (value instanceof UnmodifiableConfig && !writer.writesInline((UnmodifiableConfig)value)) {
                tablesEntries.add(entry);
                continue;
            }
            if (value instanceof List && !(list = value).isEmpty() && list.get(0) instanceof UnmodifiableConfig) {
                tableArraysEntries.add(entry);
                continue;
            }
            writer.writeComment(comment, output);
            writer.writeIndent(output);
            writer.writeKey(key, output);
            output.write(KEY_VALUE_SEPARATOR);
            ValueWriter.write(value, output, writer);
            writer.writeNewline(output);
        }
        writer.writeNewline(output);
        for (UnmodifiableCommentedConfig.Entry entry : tablesEntries) {
            writer.writeComment(entry.getComment(), output);
            configPath.add(entry.getKey());
            TableWriter.writeTableName(configPath, output, writer);
            writer.writeNewline(output);
            TableWriter.writeNormal((UnmodifiableConfig)entry.getValue(), configPath, output, writer);
            configPath.remove(configPath.size() - 1);
        }
        for (UnmodifiableCommentedConfig.Entry entry : tableArraysEntries) {
            writer.writeComment(entry.getComment(), output);
            configPath.add(entry.getKey());
            List tableArray = entry.getValue();
            for (UnmodifiableConfig table : tableArray) {
                TableWriter.writeTableArrayName(configPath, output, writer);
                writer.writeNewline(output);
                TableWriter.writeNormal(table, configPath, output, writer);
            }
            configPath.remove(configPath.size() - 1);
        }
        writer.decreaseIndentLevel();
    }

    private static void writeTableArrayName(List<String> name, CharacterOutput output, TomlWriter writer) {
        TableWriter.writeTableName(name, output, writer, ARRAY_OF_TABLES_NAME_BEGIN, ARRAY_OF_TABLES_NAME_END);
    }

    private static void writeTableName(List<String> name, CharacterOutput output, TomlWriter writer) {
        TableWriter.writeTableName(name, output, writer, TABLE_NAME_BEGIN, TABLE_NAME_END);
    }

    private static void writeTableName(List<String> name, CharacterOutput output, TomlWriter writer, char[] begin, char[] end) {
        if (name.isEmpty()) {
            throw new WritingException("Invalid empty table name.");
        }
        writer.writeIndent(output);
        output.write(begin);
        Iterator<String> it = name.iterator();
        writer.writeKey(it.next(), output);
        while (it.hasNext()) {
            output.write('.');
            writer.writeKey(it.next(), output);
        }
        output.write(end);
    }

    private TableWriter() {
    }
}

