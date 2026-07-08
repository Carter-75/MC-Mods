/*
 * Decompiled with CFR 0.152.
 */
package org.yaml.snakeyaml.parser;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.yaml.snakeyaml.DumperOptions;
import org.yaml.snakeyaml.LoaderOptions;
import org.yaml.snakeyaml.comments.CommentType;
import org.yaml.snakeyaml.error.Mark;
import org.yaml.snakeyaml.error.YAMLException;
import org.yaml.snakeyaml.events.AliasEvent;
import org.yaml.snakeyaml.events.CommentEvent;
import org.yaml.snakeyaml.events.DocumentEndEvent;
import org.yaml.snakeyaml.events.DocumentStartEvent;
import org.yaml.snakeyaml.events.Event;
import org.yaml.snakeyaml.events.ImplicitTuple;
import org.yaml.snakeyaml.events.MappingEndEvent;
import org.yaml.snakeyaml.events.MappingStartEvent;
import org.yaml.snakeyaml.events.NodeEvent;
import org.yaml.snakeyaml.events.ScalarEvent;
import org.yaml.snakeyaml.events.SequenceEndEvent;
import org.yaml.snakeyaml.events.SequenceStartEvent;
import org.yaml.snakeyaml.events.StreamEndEvent;
import org.yaml.snakeyaml.events.StreamStartEvent;
import org.yaml.snakeyaml.parser.Parser;
import org.yaml.snakeyaml.parser.ParserException;
import org.yaml.snakeyaml.parser.Production;
import org.yaml.snakeyaml.parser.VersionTagsTuple;
import org.yaml.snakeyaml.reader.StreamReader;
import org.yaml.snakeyaml.scanner.Scanner;
import org.yaml.snakeyaml.scanner.ScannerImpl;
import org.yaml.snakeyaml.tokens.AliasToken;
import org.yaml.snakeyaml.tokens.AnchorToken;
import org.yaml.snakeyaml.tokens.BlockEntryToken;
import org.yaml.snakeyaml.tokens.CommentToken;
import org.yaml.snakeyaml.tokens.DirectiveToken;
import org.yaml.snakeyaml.tokens.ScalarToken;
import org.yaml.snakeyaml.tokens.StreamEndToken;
import org.yaml.snakeyaml.tokens.StreamStartToken;
import org.yaml.snakeyaml.tokens.TagToken;
import org.yaml.snakeyaml.tokens.TagTuple;
import org.yaml.snakeyaml.tokens.Token;
import org.yaml.snakeyaml.util.ArrayStack;

public class ParserImpl
implements Parser {
    private static final Map<String, String> DEFAULT_TAGS = new HashMap<String, String>();
    protected final Scanner scanner;
    private Event currentEvent;
    private final ArrayStack<Production> states;
    private final ArrayStack<Mark> marks;
    private Production state;
    private VersionTagsTuple directives;

    @Deprecated
    public ParserImpl(StreamReader reader) {
        this(new ScannerImpl(reader));
    }

    @Deprecated
    public ParserImpl(StreamReader reader, boolean parseComments) {
        this(new ScannerImpl(reader, new LoaderOptions().setProcessComments(parseComments)));
    }

    public ParserImpl(StreamReader reader, LoaderOptions options2) {
        this(new ScannerImpl(reader, options2));
    }

    public ParserImpl(Scanner scanner) {
        this.scanner = scanner;
        this.currentEvent = null;
        this.directives = new VersionTagsTuple(null, new HashMap<String, String>(DEFAULT_TAGS));
        this.states = new ArrayStack(100);
        this.marks = new ArrayStack(10);
        this.state = new ParseStreamStart();
    }

    @Override
    public boolean checkEvent(Event.ID choice) {
        this.peekEvent();
        return this.currentEvent != null && this.currentEvent.is(choice);
    }

    @Override
    public Event peekEvent() {
        if (this.currentEvent == null && this.state != null) {
            this.currentEvent = this.state.produce();
        }
        return this.currentEvent;
    }

    @Override
    public Event getEvent() {
        this.peekEvent();
        Event value = this.currentEvent;
        this.currentEvent = null;
        return value;
    }

    private CommentEvent produceCommentEvent(CommentToken token2) {
        Mark startMark = token2.getStartMark();
        Mark endMark = token2.getEndMark();
        String value = token2.getValue();
        CommentType type = token2.getCommentType();
        return new CommentEvent(type, value, startMark, endMark);
    }

    private VersionTagsTuple processDirectives() {
        HashMap<String, String> tagHandles = new HashMap<String, String>(this.directives.getTags());
        for (String key : DEFAULT_TAGS.keySet()) {
            tagHandles.remove(key);
        }
        this.directives = new VersionTagsTuple(null, tagHandles);
        while (this.scanner.checkToken(Token.ID.Directive)) {
            List value;
            DirectiveToken token2 = (DirectiveToken)this.scanner.getToken();
            if (token2.getName().equals("YAML")) {
                if (this.directives.getVersion() != null) {
                    throw new ParserException(null, null, "found duplicate YAML directive", token2.getStartMark());
                }
                value = token2.getValue();
                Integer major = (Integer)value.get(0);
                if (major != 1) {
                    throw new ParserException(null, null, "found incompatible YAML document (version 1.* is required)", token2.getStartMark());
                }
                Integer minor = (Integer)value.get(1);
                if (minor == 0) {
                    this.directives = new VersionTagsTuple(DumperOptions.Version.V1_0, tagHandles);
                    continue;
                }
                this.directives = new VersionTagsTuple(DumperOptions.Version.V1_1, tagHandles);
                continue;
            }
            if (!token2.getName().equals("TAG")) continue;
            value = token2.getValue();
            String handle = (String)value.get(0);
            String prefix = (String)value.get(1);
            if (tagHandles.containsKey(handle)) {
                throw new ParserException(null, null, "duplicate tag handle " + handle, token2.getStartMark());
            }
            tagHandles.put(handle, prefix);
        }
        HashMap<String, String> detectedTagHandles = new HashMap();
        if (!tagHandles.isEmpty()) {
            detectedTagHandles = new HashMap<String, String>(tagHandles);
        }
        for (String key : DEFAULT_TAGS.keySet()) {
            if (tagHandles.containsKey(key)) continue;
            tagHandles.put(key, DEFAULT_TAGS.get(key));
        }
        return new VersionTagsTuple(this.directives.getVersion(), detectedTagHandles);
    }

    private Event parseFlowNode() {
        return this.parseNode(false, false);
    }

    private Event parseBlockNodeOrIndentlessSequence() {
        return this.parseNode(true, true);
    }

    private Event parseNode(boolean block, boolean indentlessSequence) {
        NodeEvent event;
        Mark startMark = null;
        Mark endMark = null;
        Mark tagMark = null;
        if (this.scanner.checkToken(Token.ID.Alias)) {
            AliasToken token2 = (AliasToken)this.scanner.getToken();
            event = new AliasEvent(token2.getValue(), token2.getStartMark(), token2.getEndMark());
            this.state = this.states.pop();
        } else {
            Token token3;
            boolean implicit;
            String anchor = null;
            TagTuple tagTokenTag = null;
            if (this.scanner.checkToken(Token.ID.Anchor)) {
                AnchorToken token4 = (AnchorToken)this.scanner.getToken();
                startMark = token4.getStartMark();
                endMark = token4.getEndMark();
                anchor = token4.getValue();
                if (this.scanner.checkToken(Token.ID.Tag)) {
                    TagToken tagToken = (TagToken)this.scanner.getToken();
                    tagMark = tagToken.getStartMark();
                    endMark = tagToken.getEndMark();
                    tagTokenTag = tagToken.getValue();
                }
            } else if (this.scanner.checkToken(Token.ID.Tag)) {
                TagToken tagToken = (TagToken)this.scanner.getToken();
                tagMark = startMark = tagToken.getStartMark();
                endMark = tagToken.getEndMark();
                tagTokenTag = tagToken.getValue();
                if (this.scanner.checkToken(Token.ID.Anchor)) {
                    AnchorToken token5 = (AnchorToken)this.scanner.getToken();
                    endMark = token5.getEndMark();
                    anchor = token5.getValue();
                }
            }
            String tag = null;
            if (tagTokenTag != null) {
                String handle = tagTokenTag.getHandle();
                String suffix = tagTokenTag.getSuffix();
                if (handle != null) {
                    if (!this.directives.getTags().containsKey(handle)) {
                        throw new ParserException("while parsing a node", startMark, "found undefined tag handle " + handle, tagMark);
                    }
                    tag = this.directives.getTags().get(handle) + suffix;
                } else {
                    tag = suffix;
                }
            }
            if (startMark == null) {
                endMark = startMark = this.scanner.peekToken().getStartMark();
            }
            event = null;
            boolean bl = implicit = tag == null || tag.equals("!");
            if (indentlessSequence && this.scanner.checkToken(Token.ID.BlockEntry)) {
                endMark = this.scanner.peekToken().getEndMark();
                event = new SequenceStartEvent(anchor, tag, implicit, startMark, endMark, DumperOptions.FlowStyle.BLOCK);
                this.state = new ParseIndentlessSequenceEntryKey();
            } else if (this.scanner.checkToken(Token.ID.Scalar)) {
                token3 = (ScalarToken)this.scanner.getToken();
                endMark = token3.getEndMark();
                ImplicitTuple implicitValues = ((ScalarToken)token3).getPlain() && tag == null || "!".equals(tag) ? new ImplicitTuple(true, false) : (tag == null ? new ImplicitTuple(false, true) : new ImplicitTuple(false, false));
                event = new ScalarEvent(anchor, tag, implicitValues, ((ScalarToken)token3).getValue(), startMark, endMark, ((ScalarToken)token3).getStyle());
                this.state = this.states.pop();
            } else if (this.scanner.checkToken(Token.ID.FlowSequenceStart)) {
                endMark = this.scanner.peekToken().getEndMark();
                event = new SequenceStartEvent(anchor, tag, implicit, startMark, endMark, DumperOptions.FlowStyle.FLOW);
                this.state = new ParseFlowSequenceFirstEntry();
            } else if (this.scanner.checkToken(Token.ID.FlowMappingStart)) {
                endMark = this.scanner.peekToken().getEndMark();
                event = new MappingStartEvent(anchor, tag, implicit, startMark, endMark, DumperOptions.FlowStyle.FLOW);
                this.state = new ParseFlowMappingFirstKey();
            } else if (block && this.scanner.checkToken(Token.ID.BlockSequenceStart)) {
                endMark = this.scanner.peekToken().getStartMark();
                event = new SequenceStartEvent(anchor, tag, implicit, startMark, endMark, DumperOptions.FlowStyle.BLOCK);
                this.state = new ParseBlockSequenceFirstEntry();
            } else if (block && this.scanner.checkToken(Token.ID.BlockMappingStart)) {
                endMark = this.scanner.peekToken().getStartMark();
                event = new MappingStartEvent(anchor, tag, implicit, startMark, endMark, DumperOptions.FlowStyle.BLOCK);
                this.state = new ParseBlockMappingFirstKey();
            } else if (anchor != null || tag != null) {
                event = new ScalarEvent(anchor, tag, new ImplicitTuple(implicit, false), "", startMark, endMark, DumperOptions.ScalarStyle.PLAIN);
                this.state = this.states.pop();
            } else {
                token3 = this.scanner.peekToken();
                throw new ParserException("while parsing a " + (block ? "block" : "flow") + " node", startMark, "expected the node content, but found '" + (Object)((Object)token3.getTokenId()) + "'", token3.getStartMark());
            }
        }
        return event;
    }

    private Event processEmptyScalar(Mark mark) {
        return new ScalarEvent(null, null, new ImplicitTuple(true, false), "", mark, mark, DumperOptions.ScalarStyle.PLAIN);
    }

    static {
        DEFAULT_TAGS.put("!", "!");
        DEFAULT_TAGS.put("!!", "tag:yaml.org,2002:");
    }

    private class ParseFlowMappingEmptyValue
    implements Production {
        private ParseFlowMappingEmptyValue() {
        }

        @Override
        public Event produce() {
            ParserImpl.this.state = new ParseFlowMappingKey(false);
            return ParserImpl.this.processEmptyScalar(ParserImpl.this.scanner.peekToken().getStartMark());
        }
    }

    private class ParseFlowMappingValue
    implements Production {
        private ParseFlowMappingValue() {
        }

        @Override
        public Event produce() {
            if (ParserImpl.this.scanner.checkToken(Token.ID.Value)) {
                Token token2 = ParserImpl.this.scanner.getToken();
                if (!ParserImpl.this.scanner.checkToken(Token.ID.FlowEntry, Token.ID.FlowMappingEnd)) {
                    ParserImpl.this.states.push(new ParseFlowMappingKey(false));
                    return ParserImpl.this.parseFlowNode();
                }
                ParserImpl.this.state = new ParseFlowMappingKey(false);
                return ParserImpl.this.processEmptyScalar(token2.getEndMark());
            }
            ParserImpl.this.state = new ParseFlowMappingKey(false);
            Token token3 = ParserImpl.this.scanner.peekToken();
            return ParserImpl.this.processEmptyScalar(token3.getStartMark());
        }
    }

    private class ParseFlowMappingKey
    implements Production {
        private final boolean first;

        public ParseFlowMappingKey(boolean first2) {
            this.first = first2;
        }

        @Override
        public Event produce() {
            if (ParserImpl.this.scanner.checkToken(Token.ID.Comment)) {
                ParserImpl.this.state = new ParseFlowMappingKey(this.first);
                return ParserImpl.this.produceCommentEvent((CommentToken)ParserImpl.this.scanner.getToken());
            }
            if (!ParserImpl.this.scanner.checkToken(Token.ID.FlowMappingEnd)) {
                if (!this.first) {
                    if (ParserImpl.this.scanner.checkToken(Token.ID.FlowEntry)) {
                        ParserImpl.this.scanner.getToken();
                        if (ParserImpl.this.scanner.checkToken(Token.ID.Comment)) {
                            ParserImpl.this.state = new ParseFlowMappingKey(true);
                            return ParserImpl.this.produceCommentEvent((CommentToken)ParserImpl.this.scanner.getToken());
                        }
                    } else {
                        Token token2 = ParserImpl.this.scanner.peekToken();
                        throw new ParserException("while parsing a flow mapping", (Mark)ParserImpl.this.marks.pop(), "expected ',' or '}', but got " + (Object)((Object)token2.getTokenId()), token2.getStartMark());
                    }
                }
                if (ParserImpl.this.scanner.checkToken(Token.ID.Key)) {
                    Token token3 = ParserImpl.this.scanner.getToken();
                    if (!ParserImpl.this.scanner.checkToken(Token.ID.Value, Token.ID.FlowEntry, Token.ID.FlowMappingEnd)) {
                        ParserImpl.this.states.push(new ParseFlowMappingValue());
                        return ParserImpl.this.parseFlowNode();
                    }
                    ParserImpl.this.state = new ParseFlowMappingValue();
                    return ParserImpl.this.processEmptyScalar(token3.getEndMark());
                }
                if (!ParserImpl.this.scanner.checkToken(Token.ID.FlowMappingEnd)) {
                    ParserImpl.this.states.push(new ParseFlowMappingEmptyValue());
                    return ParserImpl.this.parseFlowNode();
                }
            }
            Token token4 = ParserImpl.this.scanner.getToken();
            MappingEndEvent event = new MappingEndEvent(token4.getStartMark(), token4.getEndMark());
            ParserImpl.this.marks.pop();
            if (!ParserImpl.this.scanner.checkToken(Token.ID.Comment)) {
                ParserImpl.this.state = (Production)ParserImpl.this.states.pop();
            } else {
                ParserImpl.this.state = new ParseFlowEndComment();
            }
            return event;
        }
    }

    private class ParseFlowMappingFirstKey
    implements Production {
        private ParseFlowMappingFirstKey() {
        }

        @Override
        public Event produce() {
            Token token2 = ParserImpl.this.scanner.getToken();
            ParserImpl.this.marks.push(token2.getStartMark());
            return new ParseFlowMappingKey(true).produce();
        }
    }

    private class ParseFlowSequenceEntryMappingEnd
    implements Production {
        private ParseFlowSequenceEntryMappingEnd() {
        }

        @Override
        public Event produce() {
            ParserImpl.this.state = new ParseFlowSequenceEntry(false);
            Token token2 = ParserImpl.this.scanner.peekToken();
            return new MappingEndEvent(token2.getStartMark(), token2.getEndMark());
        }
    }

    private class ParseFlowSequenceEntryMappingValue
    implements Production {
        private ParseFlowSequenceEntryMappingValue() {
        }

        @Override
        public Event produce() {
            if (ParserImpl.this.scanner.checkToken(Token.ID.Value)) {
                Token token2 = ParserImpl.this.scanner.getToken();
                if (!ParserImpl.this.scanner.checkToken(Token.ID.FlowEntry, Token.ID.FlowSequenceEnd)) {
                    ParserImpl.this.states.push(new ParseFlowSequenceEntryMappingEnd());
                    return ParserImpl.this.parseFlowNode();
                }
                ParserImpl.this.state = new ParseFlowSequenceEntryMappingEnd();
                return ParserImpl.this.processEmptyScalar(token2.getEndMark());
            }
            ParserImpl.this.state = new ParseFlowSequenceEntryMappingEnd();
            Token token3 = ParserImpl.this.scanner.peekToken();
            return ParserImpl.this.processEmptyScalar(token3.getStartMark());
        }
    }

    private class ParseFlowSequenceEntryMappingKey
    implements Production {
        private ParseFlowSequenceEntryMappingKey() {
        }

        @Override
        public Event produce() {
            Token token2 = ParserImpl.this.scanner.getToken();
            if (!ParserImpl.this.scanner.checkToken(Token.ID.Value, Token.ID.FlowEntry, Token.ID.FlowSequenceEnd)) {
                ParserImpl.this.states.push(new ParseFlowSequenceEntryMappingValue());
                return ParserImpl.this.parseFlowNode();
            }
            ParserImpl.this.state = new ParseFlowSequenceEntryMappingValue();
            return ParserImpl.this.processEmptyScalar(token2.getEndMark());
        }
    }

    private class ParseFlowEndComment
    implements Production {
        private ParseFlowEndComment() {
        }

        @Override
        public Event produce() {
            CommentEvent event = ParserImpl.this.produceCommentEvent((CommentToken)ParserImpl.this.scanner.getToken());
            if (!ParserImpl.this.scanner.checkToken(Token.ID.Comment)) {
                ParserImpl.this.state = (Production)ParserImpl.this.states.pop();
            }
            return event;
        }
    }

    private class ParseFlowSequenceEntry
    implements Production {
        private final boolean first;

        public ParseFlowSequenceEntry(boolean first2) {
            this.first = first2;
        }

        @Override
        public Event produce() {
            if (ParserImpl.this.scanner.checkToken(Token.ID.Comment)) {
                ParserImpl.this.state = new ParseFlowSequenceEntry(this.first);
                return ParserImpl.this.produceCommentEvent((CommentToken)ParserImpl.this.scanner.getToken());
            }
            if (!ParserImpl.this.scanner.checkToken(Token.ID.FlowSequenceEnd)) {
                if (!this.first) {
                    if (ParserImpl.this.scanner.checkToken(Token.ID.FlowEntry)) {
                        ParserImpl.this.scanner.getToken();
                        if (ParserImpl.this.scanner.checkToken(Token.ID.Comment)) {
                            ParserImpl.this.state = new ParseFlowSequenceEntry(true);
                            return ParserImpl.this.produceCommentEvent((CommentToken)ParserImpl.this.scanner.getToken());
                        }
                    } else {
                        Token token2 = ParserImpl.this.scanner.peekToken();
                        throw new ParserException("while parsing a flow sequence", (Mark)ParserImpl.this.marks.pop(), "expected ',' or ']', but got " + (Object)((Object)token2.getTokenId()), token2.getStartMark());
                    }
                }
                if (ParserImpl.this.scanner.checkToken(Token.ID.Key)) {
                    Token token3 = ParserImpl.this.scanner.peekToken();
                    MappingStartEvent event = new MappingStartEvent(null, null, true, token3.getStartMark(), token3.getEndMark(), DumperOptions.FlowStyle.FLOW);
                    ParserImpl.this.state = new ParseFlowSequenceEntryMappingKey();
                    return event;
                }
                if (!ParserImpl.this.scanner.checkToken(Token.ID.FlowSequenceEnd)) {
                    ParserImpl.this.states.push(new ParseFlowSequenceEntry(false));
                    return ParserImpl.this.parseFlowNode();
                }
            }
            Token token4 = ParserImpl.this.scanner.getToken();
            SequenceEndEvent event = new SequenceEndEvent(token4.getStartMark(), token4.getEndMark());
            if (!ParserImpl.this.scanner.checkToken(Token.ID.Comment)) {
                ParserImpl.this.state = (Production)ParserImpl.this.states.pop();
            } else {
                ParserImpl.this.state = new ParseFlowEndComment();
            }
            ParserImpl.this.marks.pop();
            return event;
        }
    }

    private class ParseFlowSequenceFirstEntry
    implements Production {
        private ParseFlowSequenceFirstEntry() {
        }

        @Override
        public Event produce() {
            Token token2 = ParserImpl.this.scanner.getToken();
            ParserImpl.this.marks.push(token2.getStartMark());
            return new ParseFlowSequenceEntry(true).produce();
        }
    }

    private class ParseBlockMappingValueCommentList
    implements Production {
        List<CommentToken> tokens;

        public ParseBlockMappingValueCommentList(List<CommentToken> tokens) {
            this.tokens = tokens;
        }

        @Override
        public Event produce() {
            if (!this.tokens.isEmpty()) {
                return ParserImpl.this.produceCommentEvent(this.tokens.remove(0));
            }
            return new ParseBlockMappingKey().produce();
        }
    }

    private class ParseBlockMappingValueComment
    implements Production {
        List<CommentToken> tokens = new LinkedList<CommentToken>();

        private ParseBlockMappingValueComment() {
        }

        @Override
        public Event produce() {
            if (ParserImpl.this.scanner.checkToken(Token.ID.Comment)) {
                this.tokens.add((CommentToken)ParserImpl.this.scanner.getToken());
                return this.produce();
            }
            if (!ParserImpl.this.scanner.checkToken(Token.ID.Key, Token.ID.Value, Token.ID.BlockEnd)) {
                if (!this.tokens.isEmpty()) {
                    return ParserImpl.this.produceCommentEvent(this.tokens.remove(0));
                }
                ParserImpl.this.states.push(new ParseBlockMappingKey());
                return ParserImpl.this.parseBlockNodeOrIndentlessSequence();
            }
            ParserImpl.this.state = new ParseBlockMappingValueCommentList(this.tokens);
            return ParserImpl.this.processEmptyScalar(ParserImpl.this.scanner.peekToken().getStartMark());
        }
    }

    private class ParseBlockMappingValue
    implements Production {
        private ParseBlockMappingValue() {
        }

        @Override
        public Event produce() {
            if (ParserImpl.this.scanner.checkToken(Token.ID.Value)) {
                Token token2 = ParserImpl.this.scanner.getToken();
                if (ParserImpl.this.scanner.checkToken(Token.ID.Comment)) {
                    ParserImpl.this.state = new ParseBlockMappingValueComment();
                    return ParserImpl.this.state.produce();
                }
                if (!ParserImpl.this.scanner.checkToken(Token.ID.Key, Token.ID.Value, Token.ID.BlockEnd)) {
                    ParserImpl.this.states.push(new ParseBlockMappingKey());
                    return ParserImpl.this.parseBlockNodeOrIndentlessSequence();
                }
                ParserImpl.this.state = new ParseBlockMappingKey();
                return ParserImpl.this.processEmptyScalar(token2.getEndMark());
            }
            if (ParserImpl.this.scanner.checkToken(Token.ID.Scalar)) {
                ParserImpl.this.states.push(new ParseBlockMappingKey());
                return ParserImpl.this.parseBlockNodeOrIndentlessSequence();
            }
            ParserImpl.this.state = new ParseBlockMappingKey();
            Token token3 = ParserImpl.this.scanner.peekToken();
            return ParserImpl.this.processEmptyScalar(token3.getStartMark());
        }
    }

    private class ParseBlockMappingKey
    implements Production {
        private ParseBlockMappingKey() {
        }

        @Override
        public Event produce() {
            if (ParserImpl.this.scanner.checkToken(Token.ID.Comment)) {
                ParserImpl.this.state = new ParseBlockMappingKey();
                return ParserImpl.this.produceCommentEvent((CommentToken)ParserImpl.this.scanner.getToken());
            }
            if (ParserImpl.this.scanner.checkToken(Token.ID.Key)) {
                Token token2 = ParserImpl.this.scanner.getToken();
                if (!ParserImpl.this.scanner.checkToken(Token.ID.Key, Token.ID.Value, Token.ID.BlockEnd)) {
                    ParserImpl.this.states.push(new ParseBlockMappingValue());
                    return ParserImpl.this.parseBlockNodeOrIndentlessSequence();
                }
                ParserImpl.this.state = new ParseBlockMappingValue();
                return ParserImpl.this.processEmptyScalar(token2.getEndMark());
            }
            if (!ParserImpl.this.scanner.checkToken(Token.ID.BlockEnd)) {
                Token token3 = ParserImpl.this.scanner.peekToken();
                throw new ParserException("while parsing a block mapping", (Mark)ParserImpl.this.marks.pop(), "expected <block end>, but found '" + (Object)((Object)token3.getTokenId()) + "'", token3.getStartMark());
            }
            Token token4 = ParserImpl.this.scanner.getToken();
            MappingEndEvent event = new MappingEndEvent(token4.getStartMark(), token4.getEndMark());
            ParserImpl.this.state = (Production)ParserImpl.this.states.pop();
            ParserImpl.this.marks.pop();
            return event;
        }
    }

    private class ParseBlockMappingFirstKey
    implements Production {
        private ParseBlockMappingFirstKey() {
        }

        @Override
        public Event produce() {
            Token token2 = ParserImpl.this.scanner.getToken();
            ParserImpl.this.marks.push(token2.getStartMark());
            return new ParseBlockMappingKey().produce();
        }
    }

    private class ParseIndentlessSequenceEntryValue
    implements Production {
        BlockEntryToken token;

        public ParseIndentlessSequenceEntryValue(BlockEntryToken token2) {
            this.token = token2;
        }

        @Override
        public Event produce() {
            if (ParserImpl.this.scanner.checkToken(Token.ID.Comment)) {
                ParserImpl.this.state = new ParseIndentlessSequenceEntryValue(this.token);
                return ParserImpl.this.produceCommentEvent((CommentToken)ParserImpl.this.scanner.getToken());
            }
            if (!ParserImpl.this.scanner.checkToken(Token.ID.BlockEntry, Token.ID.Key, Token.ID.Value, Token.ID.BlockEnd)) {
                ParserImpl.this.states.push(new ParseIndentlessSequenceEntryKey());
                return new ParseBlockNode().produce();
            }
            ParserImpl.this.state = new ParseIndentlessSequenceEntryKey();
            return ParserImpl.this.processEmptyScalar(this.token.getEndMark());
        }
    }

    private class ParseIndentlessSequenceEntryKey
    implements Production {
        private ParseIndentlessSequenceEntryKey() {
        }

        @Override
        public Event produce() {
            if (ParserImpl.this.scanner.checkToken(Token.ID.Comment)) {
                ParserImpl.this.state = new ParseIndentlessSequenceEntryKey();
                return ParserImpl.this.produceCommentEvent((CommentToken)ParserImpl.this.scanner.getToken());
            }
            if (ParserImpl.this.scanner.checkToken(Token.ID.BlockEntry)) {
                BlockEntryToken token2 = (BlockEntryToken)ParserImpl.this.scanner.getToken();
                return new ParseIndentlessSequenceEntryValue(token2).produce();
            }
            Token token3 = ParserImpl.this.scanner.peekToken();
            SequenceEndEvent event = new SequenceEndEvent(token3.getStartMark(), token3.getEndMark());
            ParserImpl.this.state = (Production)ParserImpl.this.states.pop();
            return event;
        }
    }

    private class ParseBlockSequenceEntryValue
    implements Production {
        BlockEntryToken token;

        public ParseBlockSequenceEntryValue(BlockEntryToken token2) {
            this.token = token2;
        }

        @Override
        public Event produce() {
            if (ParserImpl.this.scanner.checkToken(Token.ID.Comment)) {
                ParserImpl.this.state = new ParseBlockSequenceEntryValue(this.token);
                return ParserImpl.this.produceCommentEvent((CommentToken)ParserImpl.this.scanner.getToken());
            }
            if (!ParserImpl.this.scanner.checkToken(Token.ID.BlockEntry, Token.ID.BlockEnd)) {
                ParserImpl.this.states.push(new ParseBlockSequenceEntryKey());
                return new ParseBlockNode().produce();
            }
            ParserImpl.this.state = new ParseBlockSequenceEntryKey();
            return ParserImpl.this.processEmptyScalar(this.token.getEndMark());
        }
    }

    private class ParseBlockSequenceEntryKey
    implements Production {
        private ParseBlockSequenceEntryKey() {
        }

        @Override
        public Event produce() {
            if (ParserImpl.this.scanner.checkToken(Token.ID.Comment)) {
                ParserImpl.this.state = new ParseBlockSequenceEntryKey();
                return ParserImpl.this.produceCommentEvent((CommentToken)ParserImpl.this.scanner.getToken());
            }
            if (ParserImpl.this.scanner.checkToken(Token.ID.BlockEntry)) {
                BlockEntryToken token2 = (BlockEntryToken)ParserImpl.this.scanner.getToken();
                return new ParseBlockSequenceEntryValue(token2).produce();
            }
            if (!ParserImpl.this.scanner.checkToken(Token.ID.BlockEnd)) {
                Token token3 = ParserImpl.this.scanner.peekToken();
                throw new ParserException("while parsing a block collection", (Mark)ParserImpl.this.marks.pop(), "expected <block end>, but found '" + (Object)((Object)token3.getTokenId()) + "'", token3.getStartMark());
            }
            Token token4 = ParserImpl.this.scanner.getToken();
            SequenceEndEvent event = new SequenceEndEvent(token4.getStartMark(), token4.getEndMark());
            ParserImpl.this.state = (Production)ParserImpl.this.states.pop();
            ParserImpl.this.marks.pop();
            return event;
        }
    }

    private class ParseBlockSequenceFirstEntry
    implements Production {
        private ParseBlockSequenceFirstEntry() {
        }

        @Override
        public Event produce() {
            Token token2 = ParserImpl.this.scanner.getToken();
            ParserImpl.this.marks.push(token2.getStartMark());
            return new ParseBlockSequenceEntryKey().produce();
        }
    }

    private class ParseBlockNode
    implements Production {
        private ParseBlockNode() {
        }

        @Override
        public Event produce() {
            return ParserImpl.this.parseNode(true, false);
        }
    }

    private class ParseDocumentContent
    implements Production {
        private ParseDocumentContent() {
        }

        @Override
        public Event produce() {
            if (ParserImpl.this.scanner.checkToken(Token.ID.Comment)) {
                ParserImpl.this.state = new ParseDocumentContent();
                return ParserImpl.this.produceCommentEvent((CommentToken)ParserImpl.this.scanner.getToken());
            }
            if (ParserImpl.this.scanner.checkToken(Token.ID.Directive, Token.ID.DocumentStart, Token.ID.DocumentEnd, Token.ID.StreamEnd)) {
                Event event = ParserImpl.this.processEmptyScalar(ParserImpl.this.scanner.peekToken().getStartMark());
                ParserImpl.this.state = (Production)ParserImpl.this.states.pop();
                return event;
            }
            return new ParseBlockNode().produce();
        }
    }

    private class ParseDocumentEnd
    implements Production {
        private ParseDocumentEnd() {
        }

        @Override
        public Event produce() {
            Mark startMark;
            Token token2 = ParserImpl.this.scanner.peekToken();
            Mark endMark = startMark = token2.getStartMark();
            boolean explicit = false;
            if (ParserImpl.this.scanner.checkToken(Token.ID.DocumentEnd)) {
                token2 = ParserImpl.this.scanner.getToken();
                endMark = token2.getEndMark();
                explicit = true;
            }
            DocumentEndEvent event = new DocumentEndEvent(startMark, endMark, explicit);
            ParserImpl.this.state = new ParseDocumentStart();
            return event;
        }
    }

    private class ParseDocumentStart
    implements Production {
        private ParseDocumentStart() {
        }

        @Override
        public Event produce() {
            Token token2;
            while (ParserImpl.this.scanner.checkToken(Token.ID.DocumentEnd)) {
                ParserImpl.this.scanner.getToken();
            }
            if (!ParserImpl.this.scanner.checkToken(Token.ID.StreamEnd)) {
                token2 = ParserImpl.this.scanner.peekToken();
                Mark startMark = token2.getStartMark();
                VersionTagsTuple tuple = ParserImpl.this.processDirectives();
                while (ParserImpl.this.scanner.checkToken(Token.ID.Comment)) {
                    ParserImpl.this.scanner.getToken();
                }
                if (!ParserImpl.this.scanner.checkToken(Token.ID.StreamEnd)) {
                    if (!ParserImpl.this.scanner.checkToken(Token.ID.DocumentStart)) {
                        throw new ParserException(null, null, "expected '<document start>', but found '" + (Object)((Object)ParserImpl.this.scanner.peekToken().getTokenId()) + "'", ParserImpl.this.scanner.peekToken().getStartMark());
                    }
                    token2 = ParserImpl.this.scanner.getToken();
                    Mark endMark = token2.getEndMark();
                    DocumentStartEvent event = new DocumentStartEvent(startMark, endMark, true, tuple.getVersion(), tuple.getTags());
                    ParserImpl.this.states.push(new ParseDocumentEnd());
                    ParserImpl.this.state = new ParseDocumentContent();
                    return event;
                }
            }
            token2 = (StreamEndToken)ParserImpl.this.scanner.getToken();
            StreamEndEvent event = new StreamEndEvent(token2.getStartMark(), token2.getEndMark());
            if (!ParserImpl.this.states.isEmpty()) {
                throw new YAMLException("Unexpected end of stream. States left: " + ParserImpl.this.states);
            }
            if (!ParserImpl.this.marks.isEmpty()) {
                throw new YAMLException("Unexpected end of stream. Marks left: " + ParserImpl.this.marks);
            }
            ParserImpl.this.state = null;
            return event;
        }
    }

    private class ParseImplicitDocumentStart
    implements Production {
        private ParseImplicitDocumentStart() {
        }

        @Override
        public Event produce() {
            if (ParserImpl.this.scanner.checkToken(Token.ID.Comment)) {
                ParserImpl.this.state = new ParseImplicitDocumentStart();
                return ParserImpl.this.produceCommentEvent((CommentToken)ParserImpl.this.scanner.getToken());
            }
            if (!ParserImpl.this.scanner.checkToken(Token.ID.Directive, Token.ID.DocumentStart, Token.ID.StreamEnd)) {
                Mark startMark;
                Token token2 = ParserImpl.this.scanner.peekToken();
                Mark endMark = startMark = token2.getStartMark();
                DocumentStartEvent event = new DocumentStartEvent(startMark, endMark, false, null, null);
                ParserImpl.this.states.push(new ParseDocumentEnd());
                ParserImpl.this.state = new ParseBlockNode();
                return event;
            }
            return new ParseDocumentStart().produce();
        }
    }

    private class ParseStreamStart
    implements Production {
        private ParseStreamStart() {
        }

        @Override
        public Event produce() {
            StreamStartToken token2 = (StreamStartToken)ParserImpl.this.scanner.getToken();
            StreamStartEvent event = new StreamStartEvent(token2.getStartMark(), token2.getEndMark());
            ParserImpl.this.state = new ParseImplicitDocumentStart();
            return event;
        }
    }
}

