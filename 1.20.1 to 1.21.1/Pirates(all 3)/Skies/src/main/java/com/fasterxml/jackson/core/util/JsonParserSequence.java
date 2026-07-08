/*
 * Decompiled with CFR 0.152.
 */
package com.fasterxml.jackson.core.util;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.core.util.JsonParserDelegate;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class JsonParserSequence
extends JsonParserDelegate {
    protected final JsonParser[] _parsers;
    protected final boolean _checkForExistingToken;
    protected int _nextParserIndex;
    protected boolean _hasToken;

    @Deprecated
    protected JsonParserSequence(JsonParser[] parsers) {
        this(false, parsers);
    }

    protected JsonParserSequence(boolean checkForExistingToken, JsonParser[] parsers) {
        super(parsers[0]);
        this._checkForExistingToken = checkForExistingToken;
        this._hasToken = checkForExistingToken && this.delegate.hasCurrentToken();
        this._parsers = parsers;
        this._nextParserIndex = 1;
    }

    public static JsonParserSequence createFlattened(boolean checkForExistingToken, JsonParser first2, JsonParser second2) {
        if (!(first2 instanceof JsonParserSequence) && !(second2 instanceof JsonParserSequence)) {
            return new JsonParserSequence(checkForExistingToken, new JsonParser[]{first2, second2});
        }
        ArrayList<JsonParser> p = new ArrayList<JsonParser>();
        if (first2 instanceof JsonParserSequence) {
            ((JsonParserSequence)first2).addFlattenedActiveParsers(p);
        } else {
            p.add(first2);
        }
        if (second2 instanceof JsonParserSequence) {
            ((JsonParserSequence)second2).addFlattenedActiveParsers(p);
        } else {
            p.add(second2);
        }
        return new JsonParserSequence(checkForExistingToken, p.toArray(new JsonParser[p.size()]));
    }

    @Deprecated
    public static JsonParserSequence createFlattened(JsonParser first2, JsonParser second2) {
        return JsonParserSequence.createFlattened(false, first2, second2);
    }

    protected void addFlattenedActiveParsers(List<JsonParser> listToAddIn) {
        int len = this._parsers.length;
        for (int i2 = this._nextParserIndex - 1; i2 < len; ++i2) {
            JsonParser p = this._parsers[i2];
            if (p instanceof JsonParserSequence) {
                ((JsonParserSequence)p).addFlattenedActiveParsers(listToAddIn);
                continue;
            }
            listToAddIn.add(p);
        }
    }

    @Override
    public void close() throws IOException {
        do {
            this.delegate.close();
        } while (this.switchToNext());
    }

    @Override
    public JsonToken nextToken() throws IOException {
        if (this.delegate == null) {
            return null;
        }
        if (this._hasToken) {
            this._hasToken = false;
            return this.delegate.currentToken();
        }
        JsonToken t = this.delegate.nextToken();
        if (t == null) {
            return this.switchAndReturnNext();
        }
        return t;
    }

    @Override
    public JsonParser skipChildren() throws IOException {
        if (this.delegate.currentToken() != JsonToken.START_OBJECT && this.delegate.currentToken() != JsonToken.START_ARRAY) {
            return this;
        }
        int open = 1;
        while (true) {
            JsonToken t;
            if ((t = this.nextToken()) == null) {
                return this;
            }
            if (t.isStructStart()) {
                ++open;
                continue;
            }
            if (t.isStructEnd() && --open == 0) break;
        }
        return this;
    }

    public int containedParsersCount() {
        return this._parsers.length;
    }

    protected boolean switchToNext() {
        if (this._nextParserIndex < this._parsers.length) {
            this.delegate = this._parsers[this._nextParserIndex++];
            return true;
        }
        return false;
    }

    protected JsonToken switchAndReturnNext() throws IOException {
        while (this._nextParserIndex < this._parsers.length) {
            this.delegate = this._parsers[this._nextParserIndex++];
            if (this._checkForExistingToken && this.delegate.hasCurrentToken()) {
                return this.delegate.getCurrentToken();
            }
            JsonToken t = this.delegate.nextToken();
            if (t == null) continue;
            return t;
        }
        return null;
    }
}

