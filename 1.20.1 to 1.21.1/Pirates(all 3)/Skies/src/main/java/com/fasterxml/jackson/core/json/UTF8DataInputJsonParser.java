/*
 * Decompiled with CFR 0.152.
 */
package com.fasterxml.jackson.core.json;

import com.fasterxml.jackson.core.Base64Variant;
import com.fasterxml.jackson.core.JsonLocation;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.core.StreamReadCapability;
import com.fasterxml.jackson.core.base.ParserBase;
import com.fasterxml.jackson.core.io.CharTypes;
import com.fasterxml.jackson.core.io.IOContext;
import com.fasterxml.jackson.core.json.JsonReadFeature;
import com.fasterxml.jackson.core.sym.ByteQuadsCanonicalizer;
import com.fasterxml.jackson.core.util.ByteArrayBuilder;
import com.fasterxml.jackson.core.util.JacksonFeatureSet;
import java.io.DataInput;
import java.io.EOFException;
import java.io.IOException;
import java.io.OutputStream;
import java.io.Writer;
import java.util.Arrays;

public class UTF8DataInputJsonParser
extends ParserBase {
    static final byte BYTE_LF = 10;
    private static final int FEAT_MASK_TRAILING_COMMA = JsonParser.Feature.ALLOW_TRAILING_COMMA.getMask();
    private static final int FEAT_MASK_LEADING_ZEROS = JsonParser.Feature.ALLOW_NUMERIC_LEADING_ZEROS.getMask();
    private static final int FEAT_MASK_NON_NUM_NUMBERS = JsonParser.Feature.ALLOW_NON_NUMERIC_NUMBERS.getMask();
    private static final int FEAT_MASK_ALLOW_MISSING = JsonParser.Feature.ALLOW_MISSING_VALUES.getMask();
    private static final int FEAT_MASK_ALLOW_SINGLE_QUOTES = JsonParser.Feature.ALLOW_SINGLE_QUOTES.getMask();
    private static final int FEAT_MASK_ALLOW_UNQUOTED_NAMES = JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES.getMask();
    private static final int FEAT_MASK_ALLOW_JAVA_COMMENTS = JsonParser.Feature.ALLOW_COMMENTS.getMask();
    private static final int FEAT_MASK_ALLOW_YAML_COMMENTS = JsonParser.Feature.ALLOW_YAML_COMMENTS.getMask();
    private static final int[] _icUTF8 = CharTypes.getInputCodeUtf8();
    protected static final int[] _icLatin1 = CharTypes.getInputCodeLatin1();
    protected ObjectCodec _objectCodec;
    protected final ByteQuadsCanonicalizer _symbols;
    protected int[] _quadBuffer = new int[16];
    protected boolean _tokenIncomplete;
    private int _quad1;
    protected DataInput _inputData;
    protected int _nextByte = -1;

    public UTF8DataInputJsonParser(IOContext ctxt, int features, DataInput inputData, ObjectCodec codec, ByteQuadsCanonicalizer sym, int firstByte) {
        super(ctxt, features);
        this._objectCodec = codec;
        this._symbols = sym;
        this._inputData = inputData;
        this._nextByte = firstByte;
    }

    @Override
    public ObjectCodec getCodec() {
        return this._objectCodec;
    }

    @Override
    public void setCodec(ObjectCodec c2) {
        this._objectCodec = c2;
    }

    @Override
    public JacksonFeatureSet<StreamReadCapability> getReadCapabilities() {
        return JSON_READ_CAPABILITIES;
    }

    @Override
    public int releaseBuffered(OutputStream out) throws IOException {
        return 0;
    }

    @Override
    public Object getInputSource() {
        return this._inputData;
    }

    @Override
    protected void _closeInput() throws IOException {
    }

    @Override
    protected void _releaseBuffers() throws IOException {
        super._releaseBuffers();
        this._symbols.release();
    }

    @Override
    public String getText() throws IOException {
        if (this._currToken == JsonToken.VALUE_STRING) {
            if (this._tokenIncomplete) {
                this._tokenIncomplete = false;
                return this._finishAndReturnString();
            }
            return this._textBuffer.contentsAsString();
        }
        return this._getText2(this._currToken);
    }

    @Override
    public int getText(Writer writer) throws IOException {
        JsonToken t = this._currToken;
        if (t == JsonToken.VALUE_STRING) {
            if (this._tokenIncomplete) {
                this._tokenIncomplete = false;
                this._finishString();
            }
            return this._textBuffer.contentsToWriter(writer);
        }
        if (t == JsonToken.FIELD_NAME) {
            String n2 = this._parsingContext.getCurrentName();
            writer.write(n2);
            return n2.length();
        }
        if (t != null) {
            if (t.isNumeric()) {
                return this._textBuffer.contentsToWriter(writer);
            }
            char[] ch = t.asCharArray();
            writer.write(ch);
            return ch.length;
        }
        return 0;
    }

    @Override
    public String getValueAsString() throws IOException {
        if (this._currToken == JsonToken.VALUE_STRING) {
            if (this._tokenIncomplete) {
                this._tokenIncomplete = false;
                return this._finishAndReturnString();
            }
            return this._textBuffer.contentsAsString();
        }
        if (this._currToken == JsonToken.FIELD_NAME) {
            return this.getCurrentName();
        }
        return super.getValueAsString(null);
    }

    @Override
    public String getValueAsString(String defValue) throws IOException {
        if (this._currToken == JsonToken.VALUE_STRING) {
            if (this._tokenIncomplete) {
                this._tokenIncomplete = false;
                return this._finishAndReturnString();
            }
            return this._textBuffer.contentsAsString();
        }
        if (this._currToken == JsonToken.FIELD_NAME) {
            return this.getCurrentName();
        }
        return super.getValueAsString(defValue);
    }

    @Override
    public int getValueAsInt() throws IOException {
        JsonToken t = this._currToken;
        if (t == JsonToken.VALUE_NUMBER_INT || t == JsonToken.VALUE_NUMBER_FLOAT) {
            if ((this._numTypesValid & 1) == 0) {
                if (this._numTypesValid == 0) {
                    return this._parseIntValue();
                }
                if ((this._numTypesValid & 1) == 0) {
                    this.convertNumberToInt();
                }
            }
            return this._numberInt;
        }
        return super.getValueAsInt(0);
    }

    @Override
    public int getValueAsInt(int defValue) throws IOException {
        JsonToken t = this._currToken;
        if (t == JsonToken.VALUE_NUMBER_INT || t == JsonToken.VALUE_NUMBER_FLOAT) {
            if ((this._numTypesValid & 1) == 0) {
                if (this._numTypesValid == 0) {
                    return this._parseIntValue();
                }
                if ((this._numTypesValid & 1) == 0) {
                    this.convertNumberToInt();
                }
            }
            return this._numberInt;
        }
        return super.getValueAsInt(defValue);
    }

    protected final String _getText2(JsonToken t) {
        if (t == null) {
            return null;
        }
        switch (t.id()) {
            case 5: {
                return this._parsingContext.getCurrentName();
            }
            case 6: 
            case 7: 
            case 8: {
                return this._textBuffer.contentsAsString();
            }
        }
        return t.asString();
    }

    @Override
    public char[] getTextCharacters() throws IOException {
        if (this._currToken != null) {
            switch (this._currToken.id()) {
                case 5: {
                    if (!this._nameCopied) {
                        String name = this._parsingContext.getCurrentName();
                        int nameLen = name.length();
                        if (this._nameCopyBuffer == null) {
                            this._nameCopyBuffer = this._ioContext.allocNameCopyBuffer(nameLen);
                        } else if (this._nameCopyBuffer.length < nameLen) {
                            this._nameCopyBuffer = new char[nameLen];
                        }
                        name.getChars(0, nameLen, this._nameCopyBuffer, 0);
                        this._nameCopied = true;
                    }
                    return this._nameCopyBuffer;
                }
                case 6: {
                    if (this._tokenIncomplete) {
                        this._tokenIncomplete = false;
                        this._finishString();
                    }
                }
                case 7: 
                case 8: {
                    return this._textBuffer.getTextBuffer();
                }
            }
            return this._currToken.asCharArray();
        }
        return null;
    }

    @Override
    public int getTextLength() throws IOException {
        if (this._currToken == JsonToken.VALUE_STRING) {
            if (this._tokenIncomplete) {
                this._tokenIncomplete = false;
                this._finishString();
            }
            return this._textBuffer.size();
        }
        if (this._currToken == JsonToken.FIELD_NAME) {
            return this._parsingContext.getCurrentName().length();
        }
        if (this._currToken != null) {
            if (this._currToken.isNumeric()) {
                return this._textBuffer.size();
            }
            return this._currToken.asCharArray().length;
        }
        return 0;
    }

    @Override
    public int getTextOffset() throws IOException {
        if (this._currToken != null) {
            switch (this._currToken.id()) {
                case 5: {
                    return 0;
                }
                case 6: {
                    if (this._tokenIncomplete) {
                        this._tokenIncomplete = false;
                        this._finishString();
                    }
                }
                case 7: 
                case 8: {
                    return this._textBuffer.getTextOffset();
                }
            }
        }
        return 0;
    }

    @Override
    public byte[] getBinaryValue(Base64Variant b64variant) throws IOException {
        if (this._currToken != JsonToken.VALUE_STRING && (this._currToken != JsonToken.VALUE_EMBEDDED_OBJECT || this._binaryValue == null)) {
            this._reportError("Current token (" + (Object)((Object)this._currToken) + ") not VALUE_STRING or VALUE_EMBEDDED_OBJECT, can not access as binary");
        }
        if (this._tokenIncomplete) {
            try {
                this._binaryValue = this._decodeBase64(b64variant);
            }
            catch (IllegalArgumentException iae) {
                throw this._constructError("Failed to decode VALUE_STRING as base64 (" + b64variant + "): " + iae.getMessage());
            }
            this._tokenIncomplete = false;
        } else if (this._binaryValue == null) {
            ByteArrayBuilder builder = this._getByteArrayBuilder();
            this._decodeBase64(this.getText(), builder, b64variant);
            this._binaryValue = builder.toByteArray();
        }
        return this._binaryValue;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public int readBinaryValue(Base64Variant b64variant, OutputStream out) throws IOException {
        if (!this._tokenIncomplete || this._currToken != JsonToken.VALUE_STRING) {
            byte[] b2 = this.getBinaryValue(b64variant);
            out.write(b2);
            return b2.length;
        }
        byte[] buf = this._ioContext.allocBase64Buffer();
        try {
            int n2 = this._readBinary(b64variant, out, buf);
            return n2;
        }
        finally {
            this._ioContext.releaseBase64Buffer(buf);
        }
    }

    protected int _readBinary(Base64Variant b64variant, OutputStream out, byte[] buffer) throws IOException {
        int outputPtr = 0;
        int outputEnd = buffer.length - 3;
        int outputCount = 0;
        while (true) {
            int ch;
            if ((ch = this._inputData.readUnsignedByte()) <= 32) {
                continue;
            }
            int bits = b64variant.decodeBase64Char(ch);
            if (bits < 0) {
                if (ch == 34) break;
                bits = this._decodeBase64Escape(b64variant, ch, 0);
                if (bits < 0) continue;
            }
            if (outputPtr > outputEnd) {
                outputCount += outputPtr;
                out.write(buffer, 0, outputPtr);
                outputPtr = 0;
            }
            int decodedData = bits;
            ch = this._inputData.readUnsignedByte();
            bits = b64variant.decodeBase64Char(ch);
            if (bits < 0) {
                bits = this._decodeBase64Escape(b64variant, ch, 1);
            }
            decodedData = decodedData << 6 | bits;
            ch = this._inputData.readUnsignedByte();
            bits = b64variant.decodeBase64Char(ch);
            if (bits < 0) {
                if (bits != -2) {
                    if (ch == 34) {
                        buffer[outputPtr++] = (byte)(decodedData >>= 4);
                        if (!b64variant.usesPadding()) break;
                        this._handleBase64MissingPadding(b64variant);
                        break;
                    }
                    bits = this._decodeBase64Escape(b64variant, ch, 2);
                }
                if (bits == -2) {
                    ch = this._inputData.readUnsignedByte();
                    if (!(b64variant.usesPaddingChar(ch) || ch == 92 && this._decodeBase64Escape(b64variant, ch, 3) == -2)) {
                        throw this.reportInvalidBase64Char(b64variant, ch, 3, "expected padding character '" + b64variant.getPaddingChar() + "'");
                    }
                    buffer[outputPtr++] = (byte)(decodedData >>= 4);
                    continue;
                }
            }
            decodedData = decodedData << 6 | bits;
            ch = this._inputData.readUnsignedByte();
            bits = b64variant.decodeBase64Char(ch);
            if (bits < 0) {
                if (bits != -2) {
                    if (ch == 34) {
                        buffer[outputPtr++] = (byte)((decodedData >>= 2) >> 8);
                        buffer[outputPtr++] = (byte)decodedData;
                        if (!b64variant.usesPadding()) break;
                        this._handleBase64MissingPadding(b64variant);
                        break;
                    }
                    bits = this._decodeBase64Escape(b64variant, ch, 3);
                }
                if (bits == -2) {
                    buffer[outputPtr++] = (byte)((decodedData >>= 2) >> 8);
                    buffer[outputPtr++] = (byte)decodedData;
                    continue;
                }
            }
            decodedData = decodedData << 6 | bits;
            buffer[outputPtr++] = (byte)(decodedData >> 16);
            buffer[outputPtr++] = (byte)(decodedData >> 8);
            buffer[outputPtr++] = (byte)decodedData;
        }
        this._tokenIncomplete = false;
        if (outputPtr > 0) {
            outputCount += outputPtr;
            out.write(buffer, 0, outputPtr);
        }
        return outputCount;
    }

    @Override
    public JsonToken nextToken() throws IOException {
        JsonToken t;
        int i2;
        if (this._closed) {
            return null;
        }
        if (this._currToken == JsonToken.FIELD_NAME) {
            return this._nextAfterName();
        }
        this._numTypesValid = 0;
        if (this._tokenIncomplete) {
            this._skipString();
        }
        if ((i2 = this._skipWSOrEnd()) < 0) {
            this.close();
            this._currToken = null;
            return null;
        }
        this._binaryValue = null;
        this._tokenInputRow = this._currInputRow;
        if (i2 == 93 || i2 == 125) {
            this._closeScope(i2);
            return this._currToken;
        }
        if (this._parsingContext.expectComma()) {
            if (i2 != 44) {
                this._reportUnexpectedChar(i2, "was expecting comma to separate " + this._parsingContext.typeDesc() + " entries");
            }
            i2 = this._skipWS();
            if ((this._features & FEAT_MASK_TRAILING_COMMA) != 0 && (i2 == 93 || i2 == 125)) {
                this._closeScope(i2);
                return this._currToken;
            }
        }
        if (!this._parsingContext.inObject()) {
            return this._nextTokenNotInObject(i2);
        }
        String n2 = this._parseName(i2);
        this._parsingContext.setCurrentName(n2);
        this._currToken = JsonToken.FIELD_NAME;
        i2 = this._skipColon();
        if (i2 == 34) {
            this._tokenIncomplete = true;
            this._nextToken = JsonToken.VALUE_STRING;
            return this._currToken;
        }
        switch (i2) {
            case 45: {
                t = this._parseNegNumber();
                break;
            }
            case 43: {
                if (this.isEnabled(JsonReadFeature.ALLOW_LEADING_PLUS_SIGN_FOR_NUMBERS.mappedFeature())) {
                    t = this._parsePosNumber();
                    break;
                }
                t = this._handleUnexpectedValue(i2);
                break;
            }
            case 46: {
                t = this._parseFloatThatStartsWithPeriod(false, false);
                break;
            }
            case 48: 
            case 49: 
            case 50: 
            case 51: 
            case 52: 
            case 53: 
            case 54: 
            case 55: 
            case 56: 
            case 57: {
                t = this._parseUnsignedNumber(i2);
                break;
            }
            case 102: {
                this._matchToken("false", 1);
                t = JsonToken.VALUE_FALSE;
                break;
            }
            case 110: {
                this._matchToken("null", 1);
                t = JsonToken.VALUE_NULL;
                break;
            }
            case 116: {
                this._matchToken("true", 1);
                t = JsonToken.VALUE_TRUE;
                break;
            }
            case 91: {
                t = JsonToken.START_ARRAY;
                break;
            }
            case 123: {
                t = JsonToken.START_OBJECT;
                break;
            }
            default: {
                t = this._handleUnexpectedValue(i2);
            }
        }
        this._nextToken = t;
        return this._currToken;
    }

    private final JsonToken _nextTokenNotInObject(int i2) throws IOException {
        if (i2 == 34) {
            this._tokenIncomplete = true;
            this._currToken = JsonToken.VALUE_STRING;
            return this._currToken;
        }
        switch (i2) {
            case 91: {
                this._parsingContext = this._parsingContext.createChildArrayContext(this._tokenInputRow, this._tokenInputCol);
                this._currToken = JsonToken.START_ARRAY;
                return this._currToken;
            }
            case 123: {
                this._parsingContext = this._parsingContext.createChildObjectContext(this._tokenInputRow, this._tokenInputCol);
                this._currToken = JsonToken.START_OBJECT;
                return this._currToken;
            }
            case 116: {
                this._matchToken("true", 1);
                this._currToken = JsonToken.VALUE_TRUE;
                return this._currToken;
            }
            case 102: {
                this._matchToken("false", 1);
                this._currToken = JsonToken.VALUE_FALSE;
                return this._currToken;
            }
            case 110: {
                this._matchToken("null", 1);
                this._currToken = JsonToken.VALUE_NULL;
                return this._currToken;
            }
            case 45: {
                this._currToken = this._parseNegNumber();
                return this._currToken;
            }
            case 43: {
                if (this.isEnabled(JsonReadFeature.ALLOW_LEADING_PLUS_SIGN_FOR_NUMBERS.mappedFeature())) {
                    this._currToken = this._parsePosNumber();
                    return this._currToken;
                }
                this._currToken = this._handleUnexpectedValue(i2);
                return this._currToken;
            }
            case 46: {
                this._currToken = this._parseFloatThatStartsWithPeriod(false, false);
                return this._currToken;
            }
            case 48: 
            case 49: 
            case 50: 
            case 51: 
            case 52: 
            case 53: 
            case 54: 
            case 55: 
            case 56: 
            case 57: {
                this._currToken = this._parseUnsignedNumber(i2);
                return this._currToken;
            }
        }
        this._currToken = this._handleUnexpectedValue(i2);
        return this._currToken;
    }

    private final JsonToken _nextAfterName() {
        this._nameCopied = false;
        JsonToken t = this._nextToken;
        this._nextToken = null;
        if (t == JsonToken.START_ARRAY) {
            this._parsingContext = this._parsingContext.createChildArrayContext(this._tokenInputRow, this._tokenInputCol);
        } else if (t == JsonToken.START_OBJECT) {
            this._parsingContext = this._parsingContext.createChildObjectContext(this._tokenInputRow, this._tokenInputCol);
        }
        this._currToken = t;
        return this._currToken;
    }

    @Override
    public void finishToken() throws IOException {
        if (this._tokenIncomplete) {
            this._tokenIncomplete = false;
            this._finishString();
        }
    }

    @Override
    public String nextFieldName() throws IOException {
        JsonToken t;
        this._numTypesValid = 0;
        if (this._currToken == JsonToken.FIELD_NAME) {
            this._nextAfterName();
            return null;
        }
        if (this._tokenIncomplete) {
            this._skipString();
        }
        int i2 = this._skipWS();
        this._binaryValue = null;
        this._tokenInputRow = this._currInputRow;
        if (i2 == 93 || i2 == 125) {
            this._closeScope(i2);
            return null;
        }
        if (this._parsingContext.expectComma()) {
            if (i2 != 44) {
                this._reportUnexpectedChar(i2, "was expecting comma to separate " + this._parsingContext.typeDesc() + " entries");
            }
            i2 = this._skipWS();
            if ((this._features & FEAT_MASK_TRAILING_COMMA) != 0 && (i2 == 93 || i2 == 125)) {
                this._closeScope(i2);
                return null;
            }
        }
        if (!this._parsingContext.inObject()) {
            this._nextTokenNotInObject(i2);
            return null;
        }
        String nameStr = this._parseName(i2);
        this._parsingContext.setCurrentName(nameStr);
        this._currToken = JsonToken.FIELD_NAME;
        i2 = this._skipColon();
        if (i2 == 34) {
            this._tokenIncomplete = true;
            this._nextToken = JsonToken.VALUE_STRING;
            return nameStr;
        }
        switch (i2) {
            case 45: {
                t = this._parseNegNumber();
                break;
            }
            case 43: {
                if (this.isEnabled(JsonReadFeature.ALLOW_LEADING_PLUS_SIGN_FOR_NUMBERS.mappedFeature())) {
                    t = this._parsePosNumber();
                    break;
                }
                t = this._handleUnexpectedValue(i2);
                break;
            }
            case 46: {
                t = this._parseFloatThatStartsWithPeriod(false, false);
            }
            case 48: 
            case 49: 
            case 50: 
            case 51: 
            case 52: 
            case 53: 
            case 54: 
            case 55: 
            case 56: 
            case 57: {
                t = this._parseUnsignedNumber(i2);
                break;
            }
            case 102: {
                this._matchToken("false", 1);
                t = JsonToken.VALUE_FALSE;
                break;
            }
            case 110: {
                this._matchToken("null", 1);
                t = JsonToken.VALUE_NULL;
                break;
            }
            case 116: {
                this._matchToken("true", 1);
                t = JsonToken.VALUE_TRUE;
                break;
            }
            case 91: {
                t = JsonToken.START_ARRAY;
                break;
            }
            case 123: {
                t = JsonToken.START_OBJECT;
                break;
            }
            default: {
                t = this._handleUnexpectedValue(i2);
            }
        }
        this._nextToken = t;
        return nameStr;
    }

    @Override
    public String nextTextValue() throws IOException {
        if (this._currToken == JsonToken.FIELD_NAME) {
            this._nameCopied = false;
            JsonToken t = this._nextToken;
            this._nextToken = null;
            this._currToken = t;
            if (t == JsonToken.VALUE_STRING) {
                if (this._tokenIncomplete) {
                    this._tokenIncomplete = false;
                    return this._finishAndReturnString();
                }
                return this._textBuffer.contentsAsString();
            }
            if (t == JsonToken.START_ARRAY) {
                this._parsingContext = this._parsingContext.createChildArrayContext(this._tokenInputRow, this._tokenInputCol);
            } else if (t == JsonToken.START_OBJECT) {
                this._parsingContext = this._parsingContext.createChildObjectContext(this._tokenInputRow, this._tokenInputCol);
            }
            return null;
        }
        return this.nextToken() == JsonToken.VALUE_STRING ? this.getText() : null;
    }

    @Override
    public int nextIntValue(int defaultValue) throws IOException {
        if (this._currToken == JsonToken.FIELD_NAME) {
            this._nameCopied = false;
            JsonToken t = this._nextToken;
            this._nextToken = null;
            this._currToken = t;
            if (t == JsonToken.VALUE_NUMBER_INT) {
                return this.getIntValue();
            }
            if (t == JsonToken.START_ARRAY) {
                this._parsingContext = this._parsingContext.createChildArrayContext(this._tokenInputRow, this._tokenInputCol);
            } else if (t == JsonToken.START_OBJECT) {
                this._parsingContext = this._parsingContext.createChildObjectContext(this._tokenInputRow, this._tokenInputCol);
            }
            return defaultValue;
        }
        return this.nextToken() == JsonToken.VALUE_NUMBER_INT ? this.getIntValue() : defaultValue;
    }

    @Override
    public long nextLongValue(long defaultValue) throws IOException {
        if (this._currToken == JsonToken.FIELD_NAME) {
            this._nameCopied = false;
            JsonToken t = this._nextToken;
            this._nextToken = null;
            this._currToken = t;
            if (t == JsonToken.VALUE_NUMBER_INT) {
                return this.getLongValue();
            }
            if (t == JsonToken.START_ARRAY) {
                this._parsingContext = this._parsingContext.createChildArrayContext(this._tokenInputRow, this._tokenInputCol);
            } else if (t == JsonToken.START_OBJECT) {
                this._parsingContext = this._parsingContext.createChildObjectContext(this._tokenInputRow, this._tokenInputCol);
            }
            return defaultValue;
        }
        return this.nextToken() == JsonToken.VALUE_NUMBER_INT ? this.getLongValue() : defaultValue;
    }

    @Override
    public Boolean nextBooleanValue() throws IOException {
        if (this._currToken == JsonToken.FIELD_NAME) {
            this._nameCopied = false;
            JsonToken t = this._nextToken;
            this._nextToken = null;
            this._currToken = t;
            if (t == JsonToken.VALUE_TRUE) {
                return Boolean.TRUE;
            }
            if (t == JsonToken.VALUE_FALSE) {
                return Boolean.FALSE;
            }
            if (t == JsonToken.START_ARRAY) {
                this._parsingContext = this._parsingContext.createChildArrayContext(this._tokenInputRow, this._tokenInputCol);
            } else if (t == JsonToken.START_OBJECT) {
                this._parsingContext = this._parsingContext.createChildObjectContext(this._tokenInputRow, this._tokenInputCol);
            }
            return null;
        }
        JsonToken t = this.nextToken();
        if (t == JsonToken.VALUE_TRUE) {
            return Boolean.TRUE;
        }
        if (t == JsonToken.VALUE_FALSE) {
            return Boolean.FALSE;
        }
        return null;
    }

    @Deprecated
    protected final JsonToken _parseFloatThatStartsWithPeriod() throws IOException {
        return this._parseFloatThatStartsWithPeriod(false, false);
    }

    protected final JsonToken _parseFloatThatStartsWithPeriod(boolean neg, boolean hasSign) throws IOException {
        if (!this.isEnabled(JsonReadFeature.ALLOW_LEADING_DECIMAL_POINT_FOR_NUMBERS.mappedFeature())) {
            return this._handleUnexpectedValue(46);
        }
        char[] outBuf = this._textBuffer.emptyAndGetCurrentSegment();
        int outPtr = 0;
        if (neg) {
            outBuf[outPtr++] = 45;
        }
        return this._parseFloat(outBuf, outPtr, 46, neg, 0);
    }

    protected JsonToken _parseUnsignedNumber(int c2) throws IOException {
        int outPtr;
        char[] outBuf = this._textBuffer.emptyAndGetCurrentSegment();
        if (c2 == 48) {
            c2 = this._handleLeadingZeroes();
            if (c2 <= 57 && c2 >= 48) {
                outPtr = 0;
            } else {
                if (c2 == 120 || c2 == 88) {
                    return this._handleInvalidNumberStart(c2, false);
                }
                outBuf[0] = 48;
                outPtr = 1;
            }
        } else {
            outBuf[0] = (char)c2;
            c2 = this._inputData.readUnsignedByte();
            outPtr = 1;
        }
        int intLen = outPtr;
        while (c2 <= 57 && c2 >= 48) {
            ++intLen;
            if (outPtr >= outBuf.length) {
                outBuf = this._textBuffer.finishCurrentSegment();
                outPtr = 0;
            }
            outBuf[outPtr++] = (char)c2;
            c2 = this._inputData.readUnsignedByte();
        }
        if (c2 == 46 || c2 == 101 || c2 == 69) {
            return this._parseFloat(outBuf, outPtr, c2, false, intLen);
        }
        this._textBuffer.setCurrentLength(outPtr);
        if (this._parsingContext.inRoot()) {
            this._verifyRootSpace();
        } else {
            this._nextByte = c2;
        }
        return this.resetInt(false, intLen);
    }

    protected final JsonToken _parsePosNumber() throws IOException {
        return this._parseSignedNumber(false);
    }

    protected final JsonToken _parseNegNumber() throws IOException {
        return this._parseSignedNumber(true);
    }

    /*
     * Enabled aggressive block sorting
     */
    private final JsonToken _parseSignedNumber(boolean negative) throws IOException {
        int c2;
        int outPtr;
        char[] outBuf;
        block10: {
            outBuf = this._textBuffer.emptyAndGetCurrentSegment();
            outPtr = 0;
            if (negative) {
                outBuf[outPtr++] = 45;
            }
            c2 = this._inputData.readUnsignedByte();
            outBuf[outPtr++] = (char)c2;
            if (c2 <= 48) {
                if (c2 == 48) {
                    c2 = this._handleLeadingZeroes();
                    break block10;
                } else {
                    if (c2 == 46) {
                        return this._parseFloatThatStartsWithPeriod(negative, true);
                    }
                    return this._handleInvalidNumberStart(c2, negative, true);
                }
            }
            if (c2 > 57) {
                return this._handleInvalidNumberStart(c2, negative, true);
            }
            c2 = this._inputData.readUnsignedByte();
        }
        int intLen = 1;
        while (c2 <= 57 && c2 >= 48) {
            ++intLen;
            if (outPtr >= outBuf.length) {
                outBuf = this._textBuffer.finishCurrentSegment();
                outPtr = 0;
            }
            outBuf[outPtr++] = (char)c2;
            c2 = this._inputData.readUnsignedByte();
        }
        if (c2 == 46 || c2 == 101 || c2 == 69) {
            return this._parseFloat(outBuf, outPtr, c2, negative, intLen);
        }
        this._textBuffer.setCurrentLength(outPtr);
        this._nextByte = c2;
        if (this._parsingContext.inRoot()) {
            this._verifyRootSpace();
        }
        return this.resetInt(negative, intLen);
    }

    private final int _handleLeadingZeroes() throws IOException {
        int ch = this._inputData.readUnsignedByte();
        if (ch < 48 || ch > 57) {
            return ch;
        }
        if ((this._features & FEAT_MASK_LEADING_ZEROS) == 0) {
            this.reportInvalidNumber("Leading zeroes not allowed");
        }
        while (ch == 48) {
            ch = this._inputData.readUnsignedByte();
        }
        return ch;
    }

    private final JsonToken _parseFloat(char[] outBuf, int outPtr, int c2, boolean negative, int integerPartLength) throws IOException {
        int fractLen = 0;
        if (c2 == 46) {
            if (outPtr >= outBuf.length) {
                outBuf = this._textBuffer.finishCurrentSegment();
                outPtr = 0;
            }
            outBuf[outPtr++] = (char)c2;
            while ((c2 = this._inputData.readUnsignedByte()) >= 48 && c2 <= 57) {
                ++fractLen;
                if (outPtr >= outBuf.length) {
                    outBuf = this._textBuffer.finishCurrentSegment();
                    outPtr = 0;
                }
                outBuf[outPtr++] = (char)c2;
            }
            if (fractLen == 0 && !this.isEnabled(JsonReadFeature.ALLOW_TRAILING_DECIMAL_POINT_FOR_NUMBERS.mappedFeature())) {
                this._reportUnexpectedNumberChar(c2, "Decimal point not followed by a digit");
            }
        }
        int expLen = 0;
        if (c2 == 101 || c2 == 69) {
            if (outPtr >= outBuf.length) {
                outBuf = this._textBuffer.finishCurrentSegment();
                outPtr = 0;
            }
            outBuf[outPtr++] = (char)c2;
            c2 = this._inputData.readUnsignedByte();
            if (c2 == 45 || c2 == 43) {
                if (outPtr >= outBuf.length) {
                    outBuf = this._textBuffer.finishCurrentSegment();
                    outPtr = 0;
                }
                outBuf[outPtr++] = (char)c2;
                c2 = this._inputData.readUnsignedByte();
            }
            while (c2 <= 57 && c2 >= 48) {
                ++expLen;
                if (outPtr >= outBuf.length) {
                    outBuf = this._textBuffer.finishCurrentSegment();
                    outPtr = 0;
                }
                outBuf[outPtr++] = (char)c2;
                c2 = this._inputData.readUnsignedByte();
            }
            if (expLen == 0) {
                this._reportUnexpectedNumberChar(c2, "Exponent indicator not followed by a digit");
            }
        }
        this._nextByte = c2;
        if (this._parsingContext.inRoot()) {
            this._verifyRootSpace();
        }
        this._textBuffer.setCurrentLength(outPtr);
        return this.resetFloat(negative, integerPartLength, fractLen, expLen);
    }

    private final void _verifyRootSpace() throws IOException {
        int ch = this._nextByte;
        if (ch <= 32) {
            this._nextByte = -1;
            if (ch == 13 || ch == 10) {
                ++this._currInputRow;
            }
            return;
        }
        this._reportMissingRootWS(ch);
    }

    protected final String _parseName(int i2) throws IOException {
        if (i2 != 34) {
            return this._handleOddName(i2);
        }
        int[] codes = _icLatin1;
        int q = this._inputData.readUnsignedByte();
        if (codes[q] == 0) {
            i2 = this._inputData.readUnsignedByte();
            if (codes[i2] == 0) {
                q = q << 8 | i2;
                i2 = this._inputData.readUnsignedByte();
                if (codes[i2] == 0) {
                    q = q << 8 | i2;
                    i2 = this._inputData.readUnsignedByte();
                    if (codes[i2] == 0) {
                        q = q << 8 | i2;
                        i2 = this._inputData.readUnsignedByte();
                        if (codes[i2] == 0) {
                            this._quad1 = q;
                            return this._parseMediumName(i2);
                        }
                        if (i2 == 34) {
                            return this.findName(q, 4);
                        }
                        return this.parseName(q, i2, 4);
                    }
                    if (i2 == 34) {
                        return this.findName(q, 3);
                    }
                    return this.parseName(q, i2, 3);
                }
                if (i2 == 34) {
                    return this.findName(q, 2);
                }
                return this.parseName(q, i2, 2);
            }
            if (i2 == 34) {
                return this.findName(q, 1);
            }
            return this.parseName(q, i2, 1);
        }
        if (q == 34) {
            return "";
        }
        return this.parseName(0, q, 0);
    }

    private final String _parseMediumName(int q2) throws IOException {
        int[] codes = _icLatin1;
        int i2 = this._inputData.readUnsignedByte();
        if (codes[i2] != 0) {
            if (i2 == 34) {
                return this.findName(this._quad1, q2, 1);
            }
            return this.parseName(this._quad1, q2, i2, 1);
        }
        q2 = q2 << 8 | i2;
        i2 = this._inputData.readUnsignedByte();
        if (codes[i2] != 0) {
            if (i2 == 34) {
                return this.findName(this._quad1, q2, 2);
            }
            return this.parseName(this._quad1, q2, i2, 2);
        }
        q2 = q2 << 8 | i2;
        i2 = this._inputData.readUnsignedByte();
        if (codes[i2] != 0) {
            if (i2 == 34) {
                return this.findName(this._quad1, q2, 3);
            }
            return this.parseName(this._quad1, q2, i2, 3);
        }
        q2 = q2 << 8 | i2;
        i2 = this._inputData.readUnsignedByte();
        if (codes[i2] != 0) {
            if (i2 == 34) {
                return this.findName(this._quad1, q2, 4);
            }
            return this.parseName(this._quad1, q2, i2, 4);
        }
        return this._parseMediumName2(i2, q2);
    }

    private final String _parseMediumName2(int q3, int q2) throws IOException {
        int[] codes = _icLatin1;
        int i2 = this._inputData.readUnsignedByte();
        if (codes[i2] != 0) {
            if (i2 == 34) {
                return this.findName(this._quad1, q2, q3, 1);
            }
            return this.parseName(this._quad1, q2, q3, i2, 1);
        }
        q3 = q3 << 8 | i2;
        i2 = this._inputData.readUnsignedByte();
        if (codes[i2] != 0) {
            if (i2 == 34) {
                return this.findName(this._quad1, q2, q3, 2);
            }
            return this.parseName(this._quad1, q2, q3, i2, 2);
        }
        q3 = q3 << 8 | i2;
        i2 = this._inputData.readUnsignedByte();
        if (codes[i2] != 0) {
            if (i2 == 34) {
                return this.findName(this._quad1, q2, q3, 3);
            }
            return this.parseName(this._quad1, q2, q3, i2, 3);
        }
        q3 = q3 << 8 | i2;
        i2 = this._inputData.readUnsignedByte();
        if (codes[i2] != 0) {
            if (i2 == 34) {
                return this.findName(this._quad1, q2, q3, 4);
            }
            return this.parseName(this._quad1, q2, q3, i2, 4);
        }
        return this._parseLongName(i2, q2, q3);
    }

    private final String _parseLongName(int q, int q2, int q3) throws IOException {
        this._quadBuffer[0] = this._quad1;
        this._quadBuffer[1] = q2;
        this._quadBuffer[2] = q3;
        int[] codes = _icLatin1;
        int qlen = 3;
        while (true) {
            int i2;
            if (codes[i2 = this._inputData.readUnsignedByte()] != 0) {
                if (i2 == 34) {
                    return this.findName(this._quadBuffer, qlen, q, 1);
                }
                return this.parseEscapedName(this._quadBuffer, qlen, q, i2, 1);
            }
            q = q << 8 | i2;
            i2 = this._inputData.readUnsignedByte();
            if (codes[i2] != 0) {
                if (i2 == 34) {
                    return this.findName(this._quadBuffer, qlen, q, 2);
                }
                return this.parseEscapedName(this._quadBuffer, qlen, q, i2, 2);
            }
            q = q << 8 | i2;
            i2 = this._inputData.readUnsignedByte();
            if (codes[i2] != 0) {
                if (i2 == 34) {
                    return this.findName(this._quadBuffer, qlen, q, 3);
                }
                return this.parseEscapedName(this._quadBuffer, qlen, q, i2, 3);
            }
            q = q << 8 | i2;
            i2 = this._inputData.readUnsignedByte();
            if (codes[i2] != 0) {
                if (i2 == 34) {
                    return this.findName(this._quadBuffer, qlen, q, 4);
                }
                return this.parseEscapedName(this._quadBuffer, qlen, q, i2, 4);
            }
            if (qlen >= this._quadBuffer.length) {
                this._quadBuffer = UTF8DataInputJsonParser._growArrayBy(this._quadBuffer, qlen);
            }
            this._quadBuffer[qlen++] = q;
            q = i2;
        }
    }

    private final String parseName(int q1, int ch, int lastQuadBytes) throws IOException {
        return this.parseEscapedName(this._quadBuffer, 0, q1, ch, lastQuadBytes);
    }

    private final String parseName(int q1, int q2, int ch, int lastQuadBytes) throws IOException {
        this._quadBuffer[0] = q1;
        return this.parseEscapedName(this._quadBuffer, 1, q2, ch, lastQuadBytes);
    }

    private final String parseName(int q1, int q2, int q3, int ch, int lastQuadBytes) throws IOException {
        this._quadBuffer[0] = q1;
        this._quadBuffer[1] = q2;
        return this.parseEscapedName(this._quadBuffer, 2, q3, ch, lastQuadBytes);
    }

    protected final String parseEscapedName(int[] quads, int qlen, int currQuad, int ch, int currQuadBytes) throws IOException {
        String name;
        int[] codes = _icLatin1;
        while (true) {
            if (codes[ch] != 0) {
                if (ch == 34) break;
                if (ch != 92) {
                    this._throwUnquotedSpace(ch, "name");
                } else {
                    ch = this._decodeEscaped();
                }
                if (ch > 127) {
                    if (currQuadBytes >= 4) {
                        if (qlen >= quads.length) {
                            quads = UTF8DataInputJsonParser._growArrayBy(quads, quads.length);
                            this._quadBuffer = quads;
                        }
                        quads[qlen++] = currQuad;
                        currQuad = 0;
                        currQuadBytes = 0;
                    }
                    if (ch < 2048) {
                        currQuad = currQuad << 8 | (0xC0 | ch >> 6);
                        ++currQuadBytes;
                    } else {
                        currQuad = currQuad << 8 | (0xE0 | ch >> 12);
                        if (++currQuadBytes >= 4) {
                            if (qlen >= quads.length) {
                                quads = UTF8DataInputJsonParser._growArrayBy(quads, quads.length);
                                this._quadBuffer = quads;
                            }
                            quads[qlen++] = currQuad;
                            currQuad = 0;
                            currQuadBytes = 0;
                        }
                        currQuad = currQuad << 8 | (0x80 | ch >> 6 & 0x3F);
                        ++currQuadBytes;
                    }
                    ch = 0x80 | ch & 0x3F;
                }
            }
            if (currQuadBytes < 4) {
                ++currQuadBytes;
                currQuad = currQuad << 8 | ch;
            } else {
                if (qlen >= quads.length) {
                    quads = UTF8DataInputJsonParser._growArrayBy(quads, quads.length);
                    this._quadBuffer = quads;
                }
                quads[qlen++] = currQuad;
                currQuad = ch;
                currQuadBytes = 1;
            }
            ch = this._inputData.readUnsignedByte();
        }
        if (currQuadBytes > 0) {
            if (qlen >= quads.length) {
                quads = UTF8DataInputJsonParser._growArrayBy(quads, quads.length);
                this._quadBuffer = quads;
            }
            quads[qlen++] = UTF8DataInputJsonParser.pad(currQuad, currQuadBytes);
        }
        if ((name = this._symbols.findName(quads, qlen)) == null) {
            name = this.addName(quads, qlen, currQuadBytes);
        }
        return name;
    }

    protected String _handleOddName(int ch) throws IOException {
        String name;
        int[] codes;
        if (ch == 39 && (this._features & FEAT_MASK_ALLOW_SINGLE_QUOTES) != 0) {
            return this._parseAposName();
        }
        if ((this._features & FEAT_MASK_ALLOW_UNQUOTED_NAMES) == 0) {
            char c2 = (char)this._decodeCharForError(ch);
            this._reportUnexpectedChar(c2, "was expecting double-quote to start field name");
        }
        if ((codes = CharTypes.getInputCodeUtf8JsNames())[ch] != 0) {
            this._reportUnexpectedChar(ch, "was expecting either valid name character (for unquoted name) or double-quote (for quoted) to start field name");
        }
        int[] quads = this._quadBuffer;
        int qlen = 0;
        int currQuad = 0;
        int currQuadBytes = 0;
        do {
            if (currQuadBytes < 4) {
                ++currQuadBytes;
                currQuad = currQuad << 8 | ch;
                continue;
            }
            if (qlen >= quads.length) {
                this._quadBuffer = quads = UTF8DataInputJsonParser._growArrayBy(quads, quads.length);
            }
            quads[qlen++] = currQuad;
            currQuad = ch;
            currQuadBytes = 1;
        } while (codes[ch = this._inputData.readUnsignedByte()] == 0);
        this._nextByte = ch;
        if (currQuadBytes > 0) {
            if (qlen >= quads.length) {
                this._quadBuffer = quads = UTF8DataInputJsonParser._growArrayBy(quads, quads.length);
            }
            quads[qlen++] = currQuad;
        }
        if ((name = this._symbols.findName(quads, qlen)) == null) {
            name = this.addName(quads, qlen, currQuadBytes);
        }
        return name;
    }

    protected String _parseAposName() throws IOException {
        String name;
        int ch = this._inputData.readUnsignedByte();
        if (ch == 39) {
            return "";
        }
        int[] quads = this._quadBuffer;
        int qlen = 0;
        int currQuad = 0;
        int currQuadBytes = 0;
        int[] codes = _icLatin1;
        while (ch != 39) {
            if (ch != 34 && codes[ch] != 0) {
                if (ch != 92) {
                    this._throwUnquotedSpace(ch, "name");
                } else {
                    ch = this._decodeEscaped();
                }
                if (ch > 127) {
                    if (currQuadBytes >= 4) {
                        if (qlen >= quads.length) {
                            this._quadBuffer = quads = UTF8DataInputJsonParser._growArrayBy(quads, quads.length);
                        }
                        quads[qlen++] = currQuad;
                        currQuad = 0;
                        currQuadBytes = 0;
                    }
                    if (ch < 2048) {
                        currQuad = currQuad << 8 | (0xC0 | ch >> 6);
                        ++currQuadBytes;
                    } else {
                        currQuad = currQuad << 8 | (0xE0 | ch >> 12);
                        if (++currQuadBytes >= 4) {
                            if (qlen >= quads.length) {
                                this._quadBuffer = quads = UTF8DataInputJsonParser._growArrayBy(quads, quads.length);
                            }
                            quads[qlen++] = currQuad;
                            currQuad = 0;
                            currQuadBytes = 0;
                        }
                        currQuad = currQuad << 8 | (0x80 | ch >> 6 & 0x3F);
                        ++currQuadBytes;
                    }
                    ch = 0x80 | ch & 0x3F;
                }
            }
            if (currQuadBytes < 4) {
                ++currQuadBytes;
                currQuad = currQuad << 8 | ch;
            } else {
                if (qlen >= quads.length) {
                    this._quadBuffer = quads = UTF8DataInputJsonParser._growArrayBy(quads, quads.length);
                }
                quads[qlen++] = currQuad;
                currQuad = ch;
                currQuadBytes = 1;
            }
            ch = this._inputData.readUnsignedByte();
        }
        if (currQuadBytes > 0) {
            if (qlen >= quads.length) {
                this._quadBuffer = quads = UTF8DataInputJsonParser._growArrayBy(quads, quads.length);
            }
            quads[qlen++] = UTF8DataInputJsonParser.pad(currQuad, currQuadBytes);
        }
        if ((name = this._symbols.findName(quads, qlen)) == null) {
            name = this.addName(quads, qlen, currQuadBytes);
        }
        return name;
    }

    private final String findName(int q1, int lastQuadBytes) throws JsonParseException {
        String name = this._symbols.findName(q1 = UTF8DataInputJsonParser.pad(q1, lastQuadBytes));
        if (name != null) {
            return name;
        }
        this._quadBuffer[0] = q1;
        return this.addName(this._quadBuffer, 1, lastQuadBytes);
    }

    private final String findName(int q1, int q2, int lastQuadBytes) throws JsonParseException {
        String name = this._symbols.findName(q1, q2 = UTF8DataInputJsonParser.pad(q2, lastQuadBytes));
        if (name != null) {
            return name;
        }
        this._quadBuffer[0] = q1;
        this._quadBuffer[1] = q2;
        return this.addName(this._quadBuffer, 2, lastQuadBytes);
    }

    private final String findName(int q1, int q2, int q3, int lastQuadBytes) throws JsonParseException {
        String name = this._symbols.findName(q1, q2, q3 = UTF8DataInputJsonParser.pad(q3, lastQuadBytes));
        if (name != null) {
            return name;
        }
        int[] quads = this._quadBuffer;
        quads[0] = q1;
        quads[1] = q2;
        quads[2] = UTF8DataInputJsonParser.pad(q3, lastQuadBytes);
        return this.addName(quads, 3, lastQuadBytes);
    }

    private final String findName(int[] quads, int qlen, int lastQuad, int lastQuadBytes) throws JsonParseException {
        if (qlen >= quads.length) {
            quads = UTF8DataInputJsonParser._growArrayBy(quads, quads.length);
            this._quadBuffer = quads;
        }
        quads[qlen++] = UTF8DataInputJsonParser.pad(lastQuad, lastQuadBytes);
        String name = this._symbols.findName(quads, qlen);
        if (name == null) {
            return this.addName(quads, qlen, lastQuadBytes);
        }
        return name;
    }

    private final String addName(int[] quads, int qlen, int lastQuadBytes) throws JsonParseException {
        int lastQuad;
        int byteLen = (qlen << 2) - 4 + lastQuadBytes;
        if (lastQuadBytes < 4) {
            lastQuad = quads[qlen - 1];
            quads[qlen - 1] = lastQuad << (4 - lastQuadBytes << 3);
        } else {
            lastQuad = 0;
        }
        char[] cbuf = this._textBuffer.emptyAndGetCurrentSegment();
        int cix = 0;
        int ix = 0;
        while (ix < byteLen) {
            int ch = quads[ix >> 2];
            int byteIx = ix & 3;
            ch = ch >> (3 - byteIx << 3) & 0xFF;
            ++ix;
            if (ch > 127) {
                int needed;
                if ((ch & 0xE0) == 192) {
                    ch &= 0x1F;
                    needed = 1;
                } else if ((ch & 0xF0) == 224) {
                    ch &= 0xF;
                    needed = 2;
                } else if ((ch & 0xF8) == 240) {
                    ch &= 7;
                    needed = 3;
                } else {
                    this._reportInvalidInitial(ch);
                    ch = 1;
                    needed = 1;
                }
                if (ix + needed > byteLen) {
                    this._reportInvalidEOF(" in field name", JsonToken.FIELD_NAME);
                }
                int ch2 = quads[ix >> 2];
                byteIx = ix & 3;
                ++ix;
                if (((ch2 >>= 3 - byteIx << 3) & 0xC0) != 128) {
                    this._reportInvalidOther(ch2);
                }
                ch = ch << 6 | ch2 & 0x3F;
                if (needed > 1) {
                    ch2 = quads[ix >> 2];
                    byteIx = ix & 3;
                    ++ix;
                    if (((ch2 >>= 3 - byteIx << 3) & 0xC0) != 128) {
                        this._reportInvalidOther(ch2);
                    }
                    ch = ch << 6 | ch2 & 0x3F;
                    if (needed > 2) {
                        ch2 = quads[ix >> 2];
                        byteIx = ix & 3;
                        ++ix;
                        if (((ch2 >>= 3 - byteIx << 3) & 0xC0) != 128) {
                            this._reportInvalidOther(ch2 & 0xFF);
                        }
                        ch = ch << 6 | ch2 & 0x3F;
                    }
                }
                if (needed > 2) {
                    ch -= 65536;
                    if (cix >= cbuf.length) {
                        cbuf = this._textBuffer.expandCurrentSegment();
                    }
                    cbuf[cix++] = (char)(55296 + (ch >> 10));
                    ch = 0xDC00 | ch & 0x3FF;
                }
            }
            if (cix >= cbuf.length) {
                cbuf = this._textBuffer.expandCurrentSegment();
            }
            cbuf[cix++] = (char)ch;
        }
        String baseName = new String(cbuf, 0, cix);
        if (lastQuadBytes < 4) {
            quads[qlen - 1] = lastQuad;
        }
        return this._symbols.addName(baseName, quads, qlen);
    }

    @Override
    protected void _finishString() throws IOException {
        int outPtr = 0;
        char[] outBuf = this._textBuffer.emptyAndGetCurrentSegment();
        int[] codes = _icUTF8;
        int outEnd = outBuf.length;
        do {
            int c2;
            if (codes[c2 = this._inputData.readUnsignedByte()] != 0) {
                if (c2 == 34) {
                    this._textBuffer.setCurrentLength(outPtr);
                    return;
                }
                this._finishString2(outBuf, outPtr, c2);
                return;
            }
            outBuf[outPtr++] = (char)c2;
        } while (outPtr < outEnd);
        this._finishString2(outBuf, outPtr, this._inputData.readUnsignedByte());
    }

    private String _finishAndReturnString() throws IOException {
        int outPtr = 0;
        char[] outBuf = this._textBuffer.emptyAndGetCurrentSegment();
        int[] codes = _icUTF8;
        int outEnd = outBuf.length;
        do {
            int c2;
            if (codes[c2 = this._inputData.readUnsignedByte()] != 0) {
                if (c2 == 34) {
                    return this._textBuffer.setCurrentAndReturn(outPtr);
                }
                this._finishString2(outBuf, outPtr, c2);
                return this._textBuffer.contentsAsString();
            }
            outBuf[outPtr++] = (char)c2;
        } while (outPtr < outEnd);
        this._finishString2(outBuf, outPtr, this._inputData.readUnsignedByte());
        return this._textBuffer.contentsAsString();
    }

    private final void _finishString2(char[] outBuf, int outPtr, int c2) throws IOException {
        int[] codes = _icUTF8;
        int outEnd = outBuf.length;
        while (true) {
            if (codes[c2] == 0) {
                if (outPtr >= outEnd) {
                    outBuf = this._textBuffer.finishCurrentSegment();
                    outPtr = 0;
                    outEnd = outBuf.length;
                }
                outBuf[outPtr++] = (char)c2;
                c2 = this._inputData.readUnsignedByte();
                continue;
            }
            if (c2 == 34) break;
            switch (codes[c2]) {
                case 1: {
                    c2 = this._decodeEscaped();
                    break;
                }
                case 2: {
                    c2 = this._decodeUtf8_2(c2);
                    break;
                }
                case 3: {
                    c2 = this._decodeUtf8_3(c2);
                    break;
                }
                case 4: {
                    c2 = this._decodeUtf8_4(c2);
                    if (outPtr >= outBuf.length) {
                        outBuf = this._textBuffer.finishCurrentSegment();
                        outPtr = 0;
                        outEnd = outBuf.length;
                    }
                    outBuf[outPtr++] = (char)(0xD800 | c2 >> 10);
                    c2 = 0xDC00 | c2 & 0x3FF;
                    break;
                }
                default: {
                    if (c2 < 32) {
                        this._throwUnquotedSpace(c2, "string value");
                        break;
                    }
                    this._reportInvalidChar(c2);
                }
            }
            if (outPtr >= outBuf.length) {
                outBuf = this._textBuffer.finishCurrentSegment();
                outPtr = 0;
                outEnd = outBuf.length;
            }
            outBuf[outPtr++] = (char)c2;
            c2 = this._inputData.readUnsignedByte();
        }
        this._textBuffer.setCurrentLength(outPtr);
    }

    protected void _skipString() throws IOException {
        this._tokenIncomplete = false;
        int[] codes = _icUTF8;
        block6: while (true) {
            int c2;
            if (codes[c2 = this._inputData.readUnsignedByte()] == 0) {
                continue;
            }
            if (c2 == 34) break;
            switch (codes[c2]) {
                case 1: {
                    this._decodeEscaped();
                    continue block6;
                }
                case 2: {
                    this._skipUtf8_2();
                    continue block6;
                }
                case 3: {
                    this._skipUtf8_3();
                    continue block6;
                }
                case 4: {
                    this._skipUtf8_4();
                    continue block6;
                }
            }
            if (c2 < 32) {
                this._throwUnquotedSpace(c2, "string value");
                continue;
            }
            this._reportInvalidChar(c2);
        }
    }

    protected JsonToken _handleUnexpectedValue(int c2) throws IOException {
        switch (c2) {
            case 93: {
                if (!this._parsingContext.inArray()) break;
            }
            case 44: {
                if (!this._parsingContext.inRoot() && (this._features & FEAT_MASK_ALLOW_MISSING) != 0) {
                    this._nextByte = c2;
                    return JsonToken.VALUE_NULL;
                }
            }
            case 125: {
                this._reportUnexpectedChar(c2, "expected a value");
            }
            case 39: {
                if ((this._features & FEAT_MASK_ALLOW_SINGLE_QUOTES) == 0) break;
                return this._handleApos();
            }
            case 78: {
                this._matchToken("NaN", 1);
                if ((this._features & FEAT_MASK_NON_NUM_NUMBERS) != 0) {
                    return this.resetAsNaN("NaN", Double.NaN);
                }
                this._reportError("Non-standard token 'NaN': enable `JsonReadFeature.ALLOW_NON_NUMERIC_NUMBERS` to allow");
                break;
            }
            case 73: {
                this._matchToken("Infinity", 1);
                if ((this._features & FEAT_MASK_NON_NUM_NUMBERS) != 0) {
                    return this.resetAsNaN("Infinity", Double.POSITIVE_INFINITY);
                }
                this._reportError("Non-standard token 'Infinity': enable `JsonReadFeature.ALLOW_NON_NUMERIC_NUMBERS` to allow");
                break;
            }
            case 43: {
                return this._handleInvalidNumberStart(this._inputData.readUnsignedByte(), false, true);
            }
        }
        if (Character.isJavaIdentifierStart(c2)) {
            this._reportInvalidToken(c2, "" + (char)c2, this._validJsonTokenList());
        }
        this._reportUnexpectedChar(c2, "expected a valid value " + this._validJsonValueList());
        return null;
    }

    protected JsonToken _handleApos() throws IOException {
        int c2 = 0;
        int outPtr = 0;
        char[] outBuf = this._textBuffer.emptyAndGetCurrentSegment();
        int[] codes = _icUTF8;
        block6: while (true) {
            int outEnd = outBuf.length;
            if (outPtr >= outBuf.length) {
                outBuf = this._textBuffer.finishCurrentSegment();
                outPtr = 0;
                outEnd = outBuf.length;
            }
            while ((c2 = this._inputData.readUnsignedByte()) != 39) {
                if (codes[c2] == 0 || c2 == 34) {
                    outBuf[outPtr++] = (char)c2;
                    if (outPtr < outEnd) continue;
                    continue block6;
                }
                switch (codes[c2]) {
                    case 1: {
                        c2 = this._decodeEscaped();
                        break;
                    }
                    case 2: {
                        c2 = this._decodeUtf8_2(c2);
                        break;
                    }
                    case 3: {
                        c2 = this._decodeUtf8_3(c2);
                        break;
                    }
                    case 4: {
                        c2 = this._decodeUtf8_4(c2);
                        outBuf[outPtr++] = (char)(0xD800 | c2 >> 10);
                        if (outPtr >= outBuf.length) {
                            outBuf = this._textBuffer.finishCurrentSegment();
                            outPtr = 0;
                        }
                        c2 = 0xDC00 | c2 & 0x3FF;
                        break;
                    }
                    default: {
                        if (c2 < 32) {
                            this._throwUnquotedSpace(c2, "string value");
                        }
                        this._reportInvalidChar(c2);
                    }
                }
                if (outPtr >= outBuf.length) {
                    outBuf = this._textBuffer.finishCurrentSegment();
                    outPtr = 0;
                }
                outBuf[outPtr++] = (char)c2;
                continue block6;
            }
            break;
        }
        this._textBuffer.setCurrentLength(outPtr);
        return JsonToken.VALUE_STRING;
    }

    protected JsonToken _handleInvalidNumberStart(int ch, boolean neg) throws IOException {
        return this._handleInvalidNumberStart(ch, neg, false);
    }

    protected JsonToken _handleInvalidNumberStart(int ch, boolean neg, boolean hasSign) throws IOException {
        while (ch == 73) {
            String match;
            ch = this._inputData.readUnsignedByte();
            if (ch == 78) {
                match = neg ? "-INF" : "+INF";
            } else {
                if (ch != 110) break;
                match = neg ? "-Infinity" : "+Infinity";
            }
            this._matchToken(match, 3);
            if ((this._features & FEAT_MASK_NON_NUM_NUMBERS) != 0) {
                return this.resetAsNaN(match, neg ? Double.NEGATIVE_INFINITY : Double.POSITIVE_INFINITY);
            }
            this._reportError("Non-standard token '" + match + "': enable `JsonReadFeature.ALLOW_NON_NUMERIC_NUMBERS` to allow");
        }
        if (!this.isEnabled(JsonReadFeature.ALLOW_LEADING_PLUS_SIGN_FOR_NUMBERS.mappedFeature()) && hasSign && !neg) {
            this._reportUnexpectedNumberChar(43, "JSON spec does not allow numbers to have plus signs: enable `JsonReadFeature.ALLOW_LEADING_PLUS_SIGN_FOR_NUMBERS` to allow");
        }
        String message = neg ? "expected digit (0-9) to follow minus sign, for valid numeric value" : "expected digit (0-9) for valid numeric value";
        this._reportUnexpectedNumberChar(ch, message);
        return null;
    }

    protected final void _matchToken(String matchStr, int i2) throws IOException {
        int ch;
        int len = matchStr.length();
        do {
            if ((ch = this._inputData.readUnsignedByte()) == matchStr.charAt(i2)) continue;
            this._reportInvalidToken(ch, matchStr.substring(0, i2));
        } while (++i2 < len);
        ch = this._inputData.readUnsignedByte();
        if (ch >= 48 && ch != 93 && ch != 125) {
            this._checkMatchEnd(matchStr, i2, ch);
        }
        this._nextByte = ch;
    }

    private final void _checkMatchEnd(String matchStr, int i2, int ch) throws IOException {
        char c2 = (char)this._decodeCharForError(ch);
        if (Character.isJavaIdentifierPart(c2)) {
            this._reportInvalidToken(c2, matchStr.substring(0, i2));
        }
    }

    private final int _skipWS() throws IOException {
        int i2 = this._nextByte;
        if (i2 < 0) {
            i2 = this._inputData.readUnsignedByte();
        } else {
            this._nextByte = -1;
        }
        while (true) {
            if (i2 > 32) {
                if (i2 == 47 || i2 == 35) {
                    return this._skipWSComment(i2);
                }
                return i2;
            }
            if (i2 == 13 || i2 == 10) {
                ++this._currInputRow;
            }
            i2 = this._inputData.readUnsignedByte();
        }
    }

    private final int _skipWSOrEnd() throws IOException {
        int i2 = this._nextByte;
        if (i2 < 0) {
            try {
                i2 = this._inputData.readUnsignedByte();
            }
            catch (EOFException e2) {
                return this._eofAsNextChar();
            }
        } else {
            this._nextByte = -1;
        }
        while (true) {
            if (i2 > 32) {
                if (i2 == 47 || i2 == 35) {
                    return this._skipWSComment(i2);
                }
                return i2;
            }
            if (i2 == 13 || i2 == 10) {
                ++this._currInputRow;
            }
            try {
                i2 = this._inputData.readUnsignedByte();
            }
            catch (EOFException e3) {
                return this._eofAsNextChar();
            }
        }
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private final int _skipWSComment(int i2) throws IOException {
        while (true) {
            if (i2 > 32) {
                if (i2 == 47) {
                    this._skipComment();
                } else {
                    if (i2 != 35) return i2;
                    if (!this._skipYAMLComment()) {
                        return i2;
                    }
                }
            } else if (i2 == 13 || i2 == 10) {
                ++this._currInputRow;
            }
            i2 = this._inputData.readUnsignedByte();
        }
    }

    private final int _skipColon() throws IOException {
        int i2 = this._nextByte;
        if (i2 < 0) {
            i2 = this._inputData.readUnsignedByte();
        } else {
            this._nextByte = -1;
        }
        if (i2 == 58) {
            i2 = this._inputData.readUnsignedByte();
            if (i2 > 32) {
                if (i2 == 47 || i2 == 35) {
                    return this._skipColon2(i2, true);
                }
                return i2;
            }
            if ((i2 == 32 || i2 == 9) && (i2 = this._inputData.readUnsignedByte()) > 32) {
                if (i2 == 47 || i2 == 35) {
                    return this._skipColon2(i2, true);
                }
                return i2;
            }
            return this._skipColon2(i2, true);
        }
        if (i2 == 32 || i2 == 9) {
            i2 = this._inputData.readUnsignedByte();
        }
        if (i2 == 58) {
            i2 = this._inputData.readUnsignedByte();
            if (i2 > 32) {
                if (i2 == 47 || i2 == 35) {
                    return this._skipColon2(i2, true);
                }
                return i2;
            }
            if ((i2 == 32 || i2 == 9) && (i2 = this._inputData.readUnsignedByte()) > 32) {
                if (i2 == 47 || i2 == 35) {
                    return this._skipColon2(i2, true);
                }
                return i2;
            }
            return this._skipColon2(i2, true);
        }
        return this._skipColon2(i2, false);
    }

    private final int _skipColon2(int i2, boolean gotColon) throws IOException {
        while (true) {
            if (i2 > 32) {
                if (i2 == 47) {
                    this._skipComment();
                } else if (i2 != 35 || !this._skipYAMLComment()) {
                    if (gotColon) {
                        return i2;
                    }
                    if (i2 != 58) {
                        this._reportUnexpectedChar(i2, "was expecting a colon to separate field name and value");
                    }
                    gotColon = true;
                }
            } else if (i2 == 13 || i2 == 10) {
                ++this._currInputRow;
            }
            i2 = this._inputData.readUnsignedByte();
        }
    }

    private final void _skipComment() throws IOException {
        int c2;
        if ((this._features & FEAT_MASK_ALLOW_JAVA_COMMENTS) == 0) {
            this._reportUnexpectedChar(47, "maybe a (non-standard) comment? (not recognized as one since Feature 'ALLOW_COMMENTS' not enabled for parser)");
        }
        if ((c2 = this._inputData.readUnsignedByte()) == 47) {
            this._skipLine();
        } else if (c2 == 42) {
            this._skipCComment();
        } else {
            this._reportUnexpectedChar(c2, "was expecting either '*' or '/' for a comment");
        }
    }

    private final void _skipCComment() throws IOException {
        int[] codes = CharTypes.getInputCodeComment();
        int i2 = this._inputData.readUnsignedByte();
        block7: while (true) {
            int code;
            if ((code = codes[i2]) != 0) {
                switch (code) {
                    case 42: {
                        i2 = this._inputData.readUnsignedByte();
                        if (i2 != 47) continue block7;
                        return;
                    }
                    case 10: 
                    case 13: {
                        ++this._currInputRow;
                        break;
                    }
                    case 2: {
                        this._skipUtf8_2();
                        break;
                    }
                    case 3: {
                        this._skipUtf8_3();
                        break;
                    }
                    case 4: {
                        this._skipUtf8_4();
                        break;
                    }
                    default: {
                        this._reportInvalidChar(i2);
                    }
                }
            }
            i2 = this._inputData.readUnsignedByte();
        }
    }

    private final boolean _skipYAMLComment() throws IOException {
        if ((this._features & FEAT_MASK_ALLOW_YAML_COMMENTS) == 0) {
            return false;
        }
        this._skipLine();
        return true;
    }

    private final void _skipLine() throws IOException {
        int[] codes = CharTypes.getInputCodeComment();
        block7: while (true) {
            int i2;
            int code;
            if ((code = codes[i2 = this._inputData.readUnsignedByte()]) == 0) {
                continue;
            }
            switch (code) {
                case 10: 
                case 13: {
                    ++this._currInputRow;
                    return;
                }
                case 42: {
                    continue block7;
                }
                case 2: {
                    this._skipUtf8_2();
                    continue block7;
                }
                case 3: {
                    this._skipUtf8_3();
                    continue block7;
                }
                case 4: {
                    this._skipUtf8_4();
                    continue block7;
                }
            }
            if (code >= 0) continue;
            this._reportInvalidChar(i2);
        }
    }

    @Override
    protected char _decodeEscaped() throws IOException {
        int c2 = this._inputData.readUnsignedByte();
        switch (c2) {
            case 98: {
                return '\b';
            }
            case 116: {
                return '\t';
            }
            case 110: {
                return '\n';
            }
            case 102: {
                return '\f';
            }
            case 114: {
                return '\r';
            }
            case 34: 
            case 47: 
            case 92: {
                return (char)c2;
            }
            case 117: {
                break;
            }
            default: {
                return this._handleUnrecognizedCharacterEscape((char)this._decodeCharForError(c2));
            }
        }
        int value = 0;
        for (int i2 = 0; i2 < 4; ++i2) {
            int ch = this._inputData.readUnsignedByte();
            int digit = CharTypes.charToHex(ch);
            if (digit < 0) {
                this._reportUnexpectedChar(ch, "expected a hex-digit for character escape sequence");
            }
            value = value << 4 | digit;
        }
        return (char)value;
    }

    protected int _decodeCharForError(int firstByte) throws IOException {
        int c2 = firstByte & 0xFF;
        if (c2 > 127) {
            int needed;
            if ((c2 & 0xE0) == 192) {
                c2 &= 0x1F;
                needed = 1;
            } else if ((c2 & 0xF0) == 224) {
                c2 &= 0xF;
                needed = 2;
            } else if ((c2 & 0xF8) == 240) {
                c2 &= 7;
                needed = 3;
            } else {
                this._reportInvalidInitial(c2 & 0xFF);
                needed = 1;
            }
            int d2 = this._inputData.readUnsignedByte();
            if ((d2 & 0xC0) != 128) {
                this._reportInvalidOther(d2 & 0xFF);
            }
            c2 = c2 << 6 | d2 & 0x3F;
            if (needed > 1) {
                d2 = this._inputData.readUnsignedByte();
                if ((d2 & 0xC0) != 128) {
                    this._reportInvalidOther(d2 & 0xFF);
                }
                c2 = c2 << 6 | d2 & 0x3F;
                if (needed > 2) {
                    d2 = this._inputData.readUnsignedByte();
                    if ((d2 & 0xC0) != 128) {
                        this._reportInvalidOther(d2 & 0xFF);
                    }
                    c2 = c2 << 6 | d2 & 0x3F;
                }
            }
        }
        return c2;
    }

    private final int _decodeUtf8_2(int c2) throws IOException {
        int d2 = this._inputData.readUnsignedByte();
        if ((d2 & 0xC0) != 128) {
            this._reportInvalidOther(d2 & 0xFF);
        }
        return (c2 & 0x1F) << 6 | d2 & 0x3F;
    }

    private final int _decodeUtf8_3(int c1) throws IOException {
        c1 &= 0xF;
        int d2 = this._inputData.readUnsignedByte();
        if ((d2 & 0xC0) != 128) {
            this._reportInvalidOther(d2 & 0xFF);
        }
        int c2 = c1 << 6 | d2 & 0x3F;
        d2 = this._inputData.readUnsignedByte();
        if ((d2 & 0xC0) != 128) {
            this._reportInvalidOther(d2 & 0xFF);
        }
        c2 = c2 << 6 | d2 & 0x3F;
        return c2;
    }

    private final int _decodeUtf8_4(int c2) throws IOException {
        int d2 = this._inputData.readUnsignedByte();
        if ((d2 & 0xC0) != 128) {
            this._reportInvalidOther(d2 & 0xFF);
        }
        c2 = (c2 & 7) << 6 | d2 & 0x3F;
        d2 = this._inputData.readUnsignedByte();
        if ((d2 & 0xC0) != 128) {
            this._reportInvalidOther(d2 & 0xFF);
        }
        c2 = c2 << 6 | d2 & 0x3F;
        d2 = this._inputData.readUnsignedByte();
        if ((d2 & 0xC0) != 128) {
            this._reportInvalidOther(d2 & 0xFF);
        }
        return (c2 << 6 | d2 & 0x3F) - 65536;
    }

    private final void _skipUtf8_2() throws IOException {
        int c2 = this._inputData.readUnsignedByte();
        if ((c2 & 0xC0) != 128) {
            this._reportInvalidOther(c2 & 0xFF);
        }
    }

    private final void _skipUtf8_3() throws IOException {
        int c2 = this._inputData.readUnsignedByte();
        if ((c2 & 0xC0) != 128) {
            this._reportInvalidOther(c2 & 0xFF);
        }
        if (((c2 = this._inputData.readUnsignedByte()) & 0xC0) != 128) {
            this._reportInvalidOther(c2 & 0xFF);
        }
    }

    private final void _skipUtf8_4() throws IOException {
        int d2 = this._inputData.readUnsignedByte();
        if ((d2 & 0xC0) != 128) {
            this._reportInvalidOther(d2 & 0xFF);
        }
        if (((d2 = this._inputData.readUnsignedByte()) & 0xC0) != 128) {
            this._reportInvalidOther(d2 & 0xFF);
        }
        if (((d2 = this._inputData.readUnsignedByte()) & 0xC0) != 128) {
            this._reportInvalidOther(d2 & 0xFF);
        }
    }

    protected void _reportInvalidToken(int ch, String matchedPart) throws IOException {
        this._reportInvalidToken(ch, matchedPart, this._validJsonTokenList());
    }

    protected void _reportInvalidToken(int ch, String matchedPart, String msg) throws IOException {
        char c2;
        StringBuilder sb = new StringBuilder(matchedPart);
        while (Character.isJavaIdentifierPart(c2 = (char)this._decodeCharForError(ch))) {
            sb.append(c2);
            ch = this._inputData.readUnsignedByte();
        }
        this._reportError("Unrecognized token '" + sb.toString() + "': was expecting " + msg);
    }

    protected void _reportInvalidChar(int c2) throws JsonParseException {
        if (c2 < 32) {
            this._throwInvalidSpace(c2);
        }
        this._reportInvalidInitial(c2);
    }

    protected void _reportInvalidInitial(int mask) throws JsonParseException {
        this._reportError("Invalid UTF-8 start byte 0x" + Integer.toHexString(mask));
    }

    private void _reportInvalidOther(int mask) throws JsonParseException {
        this._reportError("Invalid UTF-8 middle byte 0x" + Integer.toHexString(mask));
    }

    private static int[] _growArrayBy(int[] arr, int more) {
        if (arr == null) {
            return new int[more];
        }
        return Arrays.copyOf(arr, arr.length + more);
    }

    protected final byte[] _decodeBase64(Base64Variant b64variant) throws IOException {
        ByteArrayBuilder builder = this._getByteArrayBuilder();
        while (true) {
            int ch;
            if ((ch = this._inputData.readUnsignedByte()) <= 32) {
                continue;
            }
            int bits = b64variant.decodeBase64Char(ch);
            if (bits < 0) {
                if (ch == 34) {
                    return builder.toByteArray();
                }
                bits = this._decodeBase64Escape(b64variant, ch, 0);
                if (bits < 0) continue;
            }
            int decodedData = bits;
            ch = this._inputData.readUnsignedByte();
            bits = b64variant.decodeBase64Char(ch);
            if (bits < 0) {
                bits = this._decodeBase64Escape(b64variant, ch, 1);
            }
            decodedData = decodedData << 6 | bits;
            ch = this._inputData.readUnsignedByte();
            bits = b64variant.decodeBase64Char(ch);
            if (bits < 0) {
                if (bits != -2) {
                    if (ch == 34) {
                        builder.append(decodedData >>= 4);
                        if (b64variant.usesPadding()) {
                            this._handleBase64MissingPadding(b64variant);
                        }
                        return builder.toByteArray();
                    }
                    bits = this._decodeBase64Escape(b64variant, ch, 2);
                }
                if (bits == -2) {
                    ch = this._inputData.readUnsignedByte();
                    if (!(b64variant.usesPaddingChar(ch) || ch == 92 && this._decodeBase64Escape(b64variant, ch, 3) == -2)) {
                        throw this.reportInvalidBase64Char(b64variant, ch, 3, "expected padding character '" + b64variant.getPaddingChar() + "'");
                    }
                    builder.append(decodedData >>= 4);
                    continue;
                }
            }
            decodedData = decodedData << 6 | bits;
            ch = this._inputData.readUnsignedByte();
            bits = b64variant.decodeBase64Char(ch);
            if (bits < 0) {
                if (bits != -2) {
                    if (ch == 34) {
                        builder.appendTwoBytes(decodedData >>= 2);
                        if (b64variant.usesPadding()) {
                            this._handleBase64MissingPadding(b64variant);
                        }
                        return builder.toByteArray();
                    }
                    bits = this._decodeBase64Escape(b64variant, ch, 3);
                }
                if (bits == -2) {
                    builder.appendTwoBytes(decodedData >>= 2);
                    continue;
                }
            }
            decodedData = decodedData << 6 | bits;
            builder.appendThreeBytes(decodedData);
        }
    }

    @Override
    public JsonLocation getTokenLocation() {
        return new JsonLocation(this._contentReference(), -1L, -1L, this._tokenInputRow, -1);
    }

    @Override
    public JsonLocation getCurrentLocation() {
        int col = -1;
        return new JsonLocation(this._contentReference(), -1L, -1L, this._currInputRow, -1);
    }

    private void _closeScope(int i2) throws JsonParseException {
        if (i2 == 93) {
            if (!this._parsingContext.inArray()) {
                this._reportMismatchedEndMarker(i2, '}');
            }
            this._parsingContext = this._parsingContext.clearAndGetParent();
            this._currToken = JsonToken.END_ARRAY;
        }
        if (i2 == 125) {
            if (!this._parsingContext.inObject()) {
                this._reportMismatchedEndMarker(i2, ']');
            }
            this._parsingContext = this._parsingContext.clearAndGetParent();
            this._currToken = JsonToken.END_OBJECT;
        }
    }

    private static final int pad(int q, int bytes) {
        return bytes == 4 ? q : q | -1 << (bytes << 3);
    }
}

