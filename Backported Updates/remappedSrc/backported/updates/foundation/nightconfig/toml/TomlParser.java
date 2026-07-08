/*
 * Decompiled with CFR 0.152.
 */
package backported.updates.foundation.nightconfig.toml;

import backported.updates.foundation.nightconfig.core.CommentedConfig;
import backported.updates.foundation.nightconfig.core.Config;
import backported.updates.foundation.nightconfig.core.ConfigFormat;
import backported.updates.foundation.nightconfig.core.io.CharacterInput;
import backported.updates.foundation.nightconfig.core.io.CharsWrapper;
import backported.updates.foundation.nightconfig.core.io.ConfigParser;
import backported.updates.foundation.nightconfig.core.io.ParsingException;
import backported.updates.foundation.nightconfig.core.io.ParsingMode;
import backported.updates.foundation.nightconfig.core.io.ReaderInput;
import backported.updates.foundation.nightconfig.toml.TableParser;
import backported.updates.foundation.nightconfig.toml.TomlFormat;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class TomlParser
implements ConfigParser<CommentedConfig> {
    private int initialStringBuilderCapacity = 16;
    private int initialListCapacity = 10;
    private boolean lenientBareKeys = false;
    private boolean lenientSeparators = false;
    private boolean configWasEmpty = false;
    private ParsingMode parsingMode;
    private String currentComment;

    @Override
    public CommentedConfig parse(Reader reader) {
        this.configWasEmpty = true;
        return (CommentedConfig)this.parse(new ReaderInput(reader), (Config)TomlFormat.instance().createConfig(), ParsingMode.MERGE);
    }

    @Override
    public void parse(Reader reader, Config destination, ParsingMode parsingMode) {
        if (parsingMode == ParsingMode.REPLACE) {
            this.configWasEmpty = true;
        }
        this.parse(new ReaderInput(reader), destination, parsingMode);
    }

    private <T extends Config> T parse(CharacterInput input, T destination, ParsingMode parsingMode) {
        int next;
        this.parsingMode = parsingMode;
        parsingMode.prepareParsing(destination);
        CommentedConfig commentedConfig = CommentedConfig.fake(destination);
        CommentedConfig rootTable = TableParser.parseNormal(input, this, commentedConfig);
        while ((next = input.peek()) != -1) {
            Config table;
            Map<String, Object> parentMap;
            boolean isArray;
            boolean bl = isArray = next == 91;
            if (isArray) {
                input.skipPeeks();
            }
            List<String> path = TableParser.parseTableName(input, this, isArray);
            int lastIndex = path.size() - 1;
            String lastKey = path.get(lastIndex);
            List<String> parentPath = path.subList(0, lastIndex);
            Config parentConfig = this.getSubTable(rootTable, parentPath);
            Map<String, Object> map = parentMap = parentConfig != null ? parentConfig.valueMap() : null;
            if (this.hasPendingComment()) {
                String comment = this.consumeComment();
                if (parentConfig instanceof CommentedConfig) {
                    List<String> lastPath = Collections.singletonList(lastKey);
                    ((CommentedConfig)parentConfig).setComment(lastPath, comment);
                }
            }
            if (isArray) {
                if (parentMap == null) {
                    throw new ParsingException("Cannot create entry " + path + " because of an invalid parent that isn't a table.");
                }
                CommentedConfig table2 = TableParser.parseNormal(input, this);
                List<T> arrayOfTables = (List<T>)parentMap.get(lastKey);
                if (arrayOfTables == null) {
                    arrayOfTables = this.createList();
                    parentMap.put(lastKey, arrayOfTables);
                }
                arrayOfTables.add(table2);
                continue;
            }
            if (parentMap == null) {
                throw new ParsingException("Cannot create entry " + path + " because of an invalid parent that isn't a table.");
            }
            Object alreadyDeclared = parentMap.get(lastKey);
            if (alreadyDeclared == null) {
                table = TableParser.parseNormal(input, this);
                parentMap.put(lastKey, table);
                continue;
            }
            if (alreadyDeclared instanceof Config) {
                table = (Config)alreadyDeclared;
                this.checkContainsOnlySubtables(table, path);
                CommentedConfig commentedTable = CommentedConfig.fake(table);
                TableParser.parseNormal(input, this, commentedTable);
                continue;
            }
            if (!this.configWasEmpty) continue;
            throw new ParsingException("Entry " + path + " has been defined twice.");
        }
        return destination;
    }

    private Config getSubTable(Config parentTable, List<String> path) {
        if (path.isEmpty()) {
            return parentTable;
        }
        Config currentConfig = parentTable;
        for (String key : path) {
            Object value = currentConfig.valueMap().get(key);
            if (value == null) {
                Object sub = TomlFormat.instance().createConfig();
                currentConfig.valueMap().put(key, sub);
                currentConfig = sub;
                continue;
            }
            if (value instanceof Config) {
                currentConfig = (Config)value;
                continue;
            }
            if (value instanceof List) {
                List list = (List)value;
                if (!list.isEmpty() && list.get(0) instanceof Config) {
                    int lastIndex = list.size() - 1;
                    currentConfig = (Config)list.get(lastIndex);
                    continue;
                }
                return null;
            }
            return null;
        }
        return currentConfig;
    }

    private void checkContainsOnlySubtables(Config table, List<String> path) {
        for (Object value : table.valueMap().values()) {
            if (value instanceof Config) continue;
            throw new ParsingException("Table with path " + path + " has been declared twice.");
        }
    }

    public boolean isLenientWithSeparators() {
        return this.lenientSeparators;
    }

    public TomlParser setLenientWithSeparators(boolean lenientSeparators) {
        this.lenientSeparators = lenientSeparators;
        return this;
    }

    public boolean isLenientWithBareKeys() {
        return this.lenientBareKeys;
    }

    public TomlParser setLenientWithBareKeys(boolean lenientBareKeys) {
        this.lenientBareKeys = lenientBareKeys;
        return this;
    }

    public TomlParser setInitialStringBuilderCapacity(int initialStringBuilderCapacity) {
        this.initialStringBuilderCapacity = initialStringBuilderCapacity;
        return this;
    }

    public TomlParser setInitialListCapacity(int initialListCapacity) {
        this.initialListCapacity = initialListCapacity;
        return this;
    }

    @Override
    public ConfigFormat<CommentedConfig> getFormat() {
        return TomlFormat.instance();
    }

    boolean configWasEmpty() {
        return this.configWasEmpty;
    }

    ParsingMode getParsingMode() {
        return this.parsingMode;
    }

    <T> List<T> createList() {
        return new ArrayList(this.initialListCapacity);
    }

    CharsWrapper.Builder createBuilder() {
        return new CharsWrapper.Builder(this.initialStringBuilderCapacity);
    }

    boolean hasPendingComment() {
        return this.currentComment != null;
    }

    String consumeComment() {
        String comment = this.currentComment;
        this.currentComment = null;
        return comment;
    }

    void setComment(CharsWrapper comment) {
        if (comment != null) {
            this.currentComment = this.currentComment == null ? comment.toString() : this.currentComment + '\n' + comment.toString();
        }
    }

    void setComment(List<CharsWrapper> commentsList) {
        CharsWrapper.Builder builder = new CharsWrapper.Builder(32);
        if (!commentsList.isEmpty()) {
            Iterator<CharsWrapper> it = commentsList.iterator();
            builder.append(it.next());
            while (it.hasNext()) {
                builder.append('\n');
                builder.append(it.next());
            }
            this.setComment(builder.build());
        }
    }
}

