/*
 * Decompiled with CFR 0.152.
 */
package backported.updates.foundation.nightconfig.toml;

import backported.updates.foundation.nightconfig.core.io.CharacterInput;
import backported.updates.foundation.nightconfig.core.io.ParsingException;
import backported.updates.foundation.nightconfig.toml.Toml;
import backported.updates.foundation.nightconfig.toml.TomlParser;
import backported.updates.foundation.nightconfig.toml.ValueParser;
import java.util.List;

final class ArrayParser {
    static List<?> parse(CharacterInput input, TomlParser parser) {
        char after;
        List list = parser.createList();
        do {
            char firstChar;
            if ((firstChar = Toml.readUsefulChar(input)) == ']') {
                return list;
            }
            if (firstChar == ',') {
                char nextChar = Toml.readUsefulChar(input);
                if (nextChar == ']') {
                    return list;
                }
                throw new ParsingException("Unexpected character in array: '" + nextChar + "' - Expected end of array because of the leading comma.");
            }
            Object value = ValueParser.parse(input, firstChar, parser);
            list.add(value);
            after = Toml.readUsefulChar(input);
            if (after != ']') continue;
            return list;
        } while (after == ',');
        throw new ParsingException("Invalid separator '" + after + "' in array.");
    }

    private ArrayParser() {
    }
}

