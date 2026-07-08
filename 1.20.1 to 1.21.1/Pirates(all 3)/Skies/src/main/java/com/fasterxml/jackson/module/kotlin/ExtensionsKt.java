/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.jvm.JvmClassMappingKt
 *  kotlin.jvm.JvmInline
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.reflect.KClass
 */
package com.fasterxml.jackson.module.kotlin;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.TreeNode;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectReader;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.module.kotlin.ExtensionsKt;
import com.fasterxml.jackson.module.kotlin.KotlinModule;
import com.fasterxml.jackson.module.kotlin.KotlinModuleKt;
import java.io.File;
import java.io.InputStream;
import java.io.Reader;
import java.lang.annotation.Annotation;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.net.URL;
import java.util.BitSet;
import java.util.Collection;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.JvmInline;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={1, 5, 1}, k=2, xi=48, d1={"\u0000\u0092\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u001e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\n\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010(\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\u001a\r\u0010\u0001\u001a\u00020\u0000\u00a2\u0006\u0004\b\u0001\u0010\u0002\u001a\r\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0004\u0010\u0005\u001a\u001e\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007\"\u0006\b\u0000\u0010\u0006\u0018\u0001H\u0086\b\u00a2\u0006\u0004\b\b\u0010\t\u001a(\u0010\u000f\u001a\u00020\u000e2\u0019\b\u0002\u0010\r\u001a\u0013\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u000b0\n\u00a2\u0006\u0002\b\f\u00a2\u0006\u0004\b\u000f\u0010\u0010\u001a(\u0010\u0013\u001a\u00020\u00122\u0019\b\u0002\u0010\r\u001a\u0013\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u000b0\n\u00a2\u0006\u0002\b\f\u00a2\u0006\u0004\b\u0013\u0010\u0014\u001a<\u0010\u001b\u001a\u00020\u0016\"\n\b\u0000\u0010\u0006\u0018\u0001*\u00020\u0015*\u00020\u00162\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00028\u00000\u00172\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00028\u00000\u0019H\u0086\b\u00a2\u0006\u0004\b\u001b\u0010\u001c\u001a<\u0010\u001f\u001a\u00020\u0016\"\n\b\u0000\u0010\u0006\u0018\u0001*\u00020\u0015*\u00020\u00162\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00028\u00000\u00172\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00028\u00000\u001dH\u0086\b\u00a2\u0006\u0004\b\u001f\u0010 \u001a\u001c\u0010%\u001a\u00020$*\u00020!2\u0006\u0010#\u001a\u00020\"H\u0086\u0002\u00a2\u0006\u0004\b%\u0010&\u001a\u001c\u0010%\u001a\u00020$*\u00020!2\u0006\u0010(\u001a\u00020'H\u0086\u0002\u00a2\u0006\u0004\b%\u0010)\u001a$\u0010+\u001a\u00028\u0000\"\u0006\b\u0000\u0010\u0006\u0018\u0001*\u00020\u00032\u0006\u0010*\u001a\u00020\u0015H\u0086\b\u00a2\u0006\u0004\b+\u0010,\u001a\u0017\u0010.\u001a\u00020$*\u0006\u0012\u0002\b\u00030-H\u0000\u00a2\u0006\u0004\b.\u0010/\u001a\u001c\u00101\u001a\u00020\u000b*\u0002002\u0006\u0010#\u001a\u00020\"H\u0086\u0002\u00a2\u0006\u0004\b1\u00102\u001a\u001c\u00101\u001a\u00020\u000b*\u0002032\u0006\u0010(\u001a\u00020'H\u0086\u0002\u00a2\u0006\u0004\b1\u00104\u001a\"\u00101\u001a\u00020\u000b*\u0002032\f\u00106\u001a\b\u0012\u0004\u0012\u00020'05H\u0086\u0002\u00a2\u0006\u0004\b1\u00107\u001a\u001c\u00108\u001a\u00020\u000b*\u0002002\u0006\u0010#\u001a\u00020\"H\u0086\u0002\u00a2\u0006\u0004\b8\u00102\u001a\u001c\u00108\u001a\u00020\u000b*\u0002032\u0006\u0010(\u001a\u00020'H\u0086\u0002\u00a2\u0006\u0004\b8\u00104\u001a\"\u00108\u001a\u00020\u000b*\u0002032\f\u00106\u001a\b\u0012\u0004\u0012\u00020'05H\u0086\u0002\u00a2\u0006\u0004\b8\u00107\u001a\u001c\u0010:\u001a\u00020\u000b*\u0002002\u0006\u00109\u001a\u00020!H\u0086\u0002\u00a2\u0006\u0004\b:\u0010;\u001a\u001c\u0010:\u001a\u00020\u000b*\u0002002\u0006\u0010<\u001a\u000200H\u0086\u0002\u00a2\u0006\u0004\b:\u0010=\u001a\u001c\u0010:\u001a\u00020\u000b*\u0002002\u0006\u00109\u001a\u00020>H\u0086\u0002\u00a2\u0006\u0004\b:\u0010?\u001a\u001c\u0010:\u001a\u00020\u000b*\u0002002\u0006\u00109\u001a\u00020@H\u0086\u0002\u00a2\u0006\u0004\b:\u0010A\u001a\u001c\u0010:\u001a\u00020\u000b*\u0002002\u0006\u00109\u001a\u00020$H\u0086\u0002\u00a2\u0006\u0004\b:\u0010B\u001a\u001c\u0010:\u001a\u00020\u000b*\u0002002\u0006\u00109\u001a\u00020CH\u0086\u0002\u00a2\u0006\u0004\b:\u0010D\u001a\u001c\u0010:\u001a\u00020\u000b*\u0002002\u0006\u00109\u001a\u00020EH\u0086\u0002\u00a2\u0006\u0004\b:\u0010F\u001a\u001c\u0010:\u001a\u00020\u000b*\u0002002\u0006\u00109\u001a\u00020GH\u0086\u0002\u00a2\u0006\u0004\b:\u0010H\u001a\u001c\u0010:\u001a\u00020\u000b*\u0002002\u0006\u00109\u001a\u00020\"H\u0086\u0002\u00a2\u0006\u0004\b:\u00102\u001a\u001c\u0010:\u001a\u00020\u000b*\u0002002\u0006\u00109\u001a\u00020IH\u0086\u0002\u00a2\u0006\u0004\b:\u0010J\u001a\u001c\u0010:\u001a\u00020\u000b*\u0002002\u0006\u00109\u001a\u00020KH\u0086\u0002\u00a2\u0006\u0004\b:\u0010L\u001a\u001c\u0010:\u001a\u00020\u000b*\u0002002\u0006\u00109\u001a\u00020'H\u0086\u0002\u00a2\u0006\u0004\b:\u0010M\u001a\u001c\u0010N\u001a\u00020\u000b*\u0002002\u0006\u00109\u001a\u00020!H\u0086\u0002\u00a2\u0006\u0004\bN\u0010;\u001a\u001c\u0010N\u001a\u00020\u000b*\u0002002\u0006\u0010<\u001a\u000200H\u0086\u0002\u00a2\u0006\u0004\bN\u0010=\u001a\u001c\u0010N\u001a\u00020\u000b*\u0002002\u0006\u00109\u001a\u00020>H\u0086\u0002\u00a2\u0006\u0004\bN\u0010?\u001a\u001c\u0010N\u001a\u00020\u000b*\u0002002\u0006\u00109\u001a\u00020@H\u0086\u0002\u00a2\u0006\u0004\bN\u0010A\u001a\u001c\u0010N\u001a\u00020\u000b*\u0002002\u0006\u00109\u001a\u00020$H\u0086\u0002\u00a2\u0006\u0004\bN\u0010B\u001a\u001c\u0010N\u001a\u00020\u000b*\u0002002\u0006\u00109\u001a\u00020CH\u0086\u0002\u00a2\u0006\u0004\bN\u0010D\u001a\u001c\u0010N\u001a\u00020\u000b*\u0002002\u0006\u00109\u001a\u00020EH\u0086\u0002\u00a2\u0006\u0004\bN\u0010F\u001a\u001c\u0010N\u001a\u00020\u000b*\u0002002\u0006\u00109\u001a\u00020GH\u0086\u0002\u00a2\u0006\u0004\bN\u0010H\u001a\u001c\u0010N\u001a\u00020\u000b*\u0002002\u0006\u00109\u001a\u00020\"H\u0086\u0002\u00a2\u0006\u0004\bN\u00102\u001a\u001c\u0010N\u001a\u00020\u000b*\u0002002\u0006\u00109\u001a\u00020IH\u0086\u0002\u00a2\u0006\u0004\bN\u0010J\u001a\u001c\u0010N\u001a\u00020\u000b*\u0002002\u0006\u00109\u001a\u00020KH\u0086\u0002\u00a2\u0006\u0004\bN\u0010L\u001a\u001c\u0010N\u001a\u00020\u000b*\u0002002\u0006\u00109\u001a\u00020'H\u0086\u0002\u00a2\u0006\u0004\bN\u0010M\u001a$\u0010Q\u001a\u00028\u0000\"\u0006\b\u0000\u0010\u0006\u0018\u0001*\u00020\u00032\u0006\u0010P\u001a\u00020OH\u0086\b\u00a2\u0006\u0004\bQ\u0010R\u001a$\u0010Q\u001a\u00028\u0000\"\u0006\b\u0000\u0010\u0006\u0018\u0001*\u00020\u00032\u0006\u0010T\u001a\u00020SH\u0086\b\u00a2\u0006\u0004\bQ\u0010U\u001a$\u0010Q\u001a\u00028\u0000\"\u0006\b\u0000\u0010\u0006\u0018\u0001*\u00020\u00032\u0006\u0010T\u001a\u00020VH\u0086\b\u00a2\u0006\u0004\bQ\u0010W\u001a$\u0010Q\u001a\u00028\u0000\"\u0006\b\u0000\u0010\u0006\u0018\u0001*\u00020\u00032\u0006\u0010T\u001a\u00020XH\u0086\b\u00a2\u0006\u0004\bQ\u0010Y\u001a$\u0010Q\u001a\u00028\u0000\"\u0006\b\u0000\u0010\u0006\u0018\u0001*\u00020\u00032\u0006\u0010T\u001a\u00020ZH\u0086\b\u00a2\u0006\u0004\bQ\u0010[\u001a$\u0010Q\u001a\u00028\u0000\"\u0006\b\u0000\u0010\u0006\u0018\u0001*\u00020\u00032\u0006\u0010T\u001a\u00020CH\u0086\b\u00a2\u0006\u0004\bQ\u0010\\\u001a$\u0010Q\u001a\u00028\u0000\"\u0006\b\u0000\u0010\u0006\u0018\u0001*\u00020\u00032\u0006\u0010]\u001a\u00020'H\u0086\b\u00a2\u0006\u0004\bQ\u0010^\u001a$\u0010`\u001a\u00028\u0000\"\u0006\b\u0000\u0010\u0006\u0018\u0001*\u00020_2\u0006\u0010P\u001a\u00020OH\u0086\b\u00a2\u0006\u0004\b`\u0010a\u001a*\u0010c\u001a\b\u0012\u0004\u0012\u00028\u00000b\"\u0006\b\u0000\u0010\u0006\u0018\u0001*\u00020\u00032\u0006\u0010P\u001a\u00020OH\u0086\b\u00a2\u0006\u0004\bc\u0010d\u001a*\u0010f\u001a\b\u0012\u0004\u0012\u00028\u00000e\"\u0006\b\u0000\u0010\u0006\u0018\u0001*\u00020_2\u0006\u0010P\u001a\u00020OH\u0086\b\u00a2\u0006\u0004\bf\u0010g\u001a\u0011\u0010h\u001a\u00020\u0003*\u00020\u0003\u00a2\u0006\u0004\bh\u0010i\u001a\u0013\u0010k\u001a\u00020j*\u00020\"H\u0000\u00a2\u0006\u0004\bk\u0010l\u001a$\u0010o\u001a\u00028\u0000\"\u0006\b\u0000\u0010\u0006\u0018\u0001*\u00020\u00032\u0006\u0010n\u001a\u00020mH\u0086\b\u00a2\u0006\u0004\bo\u0010p\u001a&\u0010o\u001a\u0004\u0018\u00018\u0000\"\u0006\b\u0000\u0010\u0006\u0018\u0001*\u00020_2\u0006\u0010n\u001a\u00020mH\u0086\b\u00a2\u0006\u0004\bo\u0010q\u001a-\u0010u\u001a\n t*\u0004\u0018\u00010r0r*\u00020r2\b\u0010s\u001a\u0004\u0018\u00010\u00152\u0006\u0010#\u001a\u00020\"H\u0000\u00a2\u0006\u0004\bu\u0010v\u001a-\u0010u\u001a\n t*\u0004\u0018\u00010r0r*\u00020r2\b\u0010s\u001a\u0004\u0018\u00010\u00152\u0006\u0010w\u001a\u00020'H\u0000\u00a2\u0006\u0004\bu\u0010x\u00a8\u0006y"}, d2={"Lcom/fasterxml/jackson/databind/json/JsonMapper$Builder;", "jacksonMapperBuilder", "()Lcom/fasterxml/jackson/databind/json/JsonMapper$Builder;", "Lcom/fasterxml/jackson/databind/ObjectMapper;", "jacksonObjectMapper", "()Lcom/fasterxml/jackson/databind/ObjectMapper;", "T", "Lcom/fasterxml/jackson/core/type/TypeReference;", "jacksonTypeRef", "()Lcom/fasterxml/jackson/core/type/TypeReference;", "Lkotlin/Function1;", "", "Lkotlin/ExtensionFunctionType;", "initializer", "Lcom/fasterxml/jackson/databind/json/JsonMapper;", "jsonMapper", "(Lkotlin/jvm/functions/Function1;)Lcom/fasterxml/jackson/databind/json/JsonMapper;", "Lcom/fasterxml/jackson/module/kotlin/KotlinModule$Builder;", "Lcom/fasterxml/jackson/module/kotlin/KotlinModule;", "kotlinModule", "(Lkotlin/jvm/functions/Function1;)Lcom/fasterxml/jackson/module/kotlin/KotlinModule;", "", "Lcom/fasterxml/jackson/databind/module/SimpleModule;", "Lkotlin/reflect/KClass;", "kClass", "Lcom/fasterxml/jackson/databind/JsonDeserializer;", "deserializer", "addDeserializer", "(Lcom/fasterxml/jackson/databind/module/SimpleModule;Lkotlin/reflect/KClass;Lcom/fasterxml/jackson/databind/JsonDeserializer;)Lcom/fasterxml/jackson/databind/module/SimpleModule;", "Lcom/fasterxml/jackson/databind/JsonSerializer;", "serializer", "addSerializer", "(Lcom/fasterxml/jackson/databind/module/SimpleModule;Lkotlin/reflect/KClass;Lcom/fasterxml/jackson/databind/JsonSerializer;)Lcom/fasterxml/jackson/databind/module/SimpleModule;", "Lcom/fasterxml/jackson/databind/JsonNode;", "", "index", "", "contains", "(Lcom/fasterxml/jackson/databind/JsonNode;I)Z", "", "field", "(Lcom/fasterxml/jackson/databind/JsonNode;Ljava/lang/String;)Z", "from", "convertValue", "(Lcom/fasterxml/jackson/databind/ObjectMapper;Ljava/lang/Object;)Ljava/lang/Object;", "Ljava/lang/Class;", "isUnboxableValueClass", "(Ljava/lang/Class;)Z", "Lcom/fasterxml/jackson/databind/node/ArrayNode;", "minus", "(Lcom/fasterxml/jackson/databind/node/ArrayNode;I)V", "Lcom/fasterxml/jackson/databind/node/ObjectNode;", "(Lcom/fasterxml/jackson/databind/node/ObjectNode;Ljava/lang/String;)V", "", "fields", "(Lcom/fasterxml/jackson/databind/node/ObjectNode;Ljava/util/Collection;)V", "minusAssign", "element", "plus", "(Lcom/fasterxml/jackson/databind/node/ArrayNode;Lcom/fasterxml/jackson/databind/JsonNode;)V", "elements", "(Lcom/fasterxml/jackson/databind/node/ArrayNode;Lcom/fasterxml/jackson/databind/node/ArrayNode;)V", "Ljava/math/BigDecimal;", "(Lcom/fasterxml/jackson/databind/node/ArrayNode;Ljava/math/BigDecimal;)V", "Ljava/math/BigInteger;", "(Lcom/fasterxml/jackson/databind/node/ArrayNode;Ljava/math/BigInteger;)V", "(Lcom/fasterxml/jackson/databind/node/ArrayNode;Z)V", "", "(Lcom/fasterxml/jackson/databind/node/ArrayNode;[B)V", "", "(Lcom/fasterxml/jackson/databind/node/ArrayNode;D)V", "", "(Lcom/fasterxml/jackson/databind/node/ArrayNode;F)V", "", "(Lcom/fasterxml/jackson/databind/node/ArrayNode;J)V", "", "(Lcom/fasterxml/jackson/databind/node/ArrayNode;S)V", "(Lcom/fasterxml/jackson/databind/node/ArrayNode;Ljava/lang/String;)V", "plusAssign", "Lcom/fasterxml/jackson/core/JsonParser;", "jp", "readValue", "(Lcom/fasterxml/jackson/databind/ObjectMapper;Lcom/fasterxml/jackson/core/JsonParser;)Ljava/lang/Object;", "Ljava/io/File;", "src", "(Lcom/fasterxml/jackson/databind/ObjectMapper;Ljava/io/File;)Ljava/lang/Object;", "Ljava/io/InputStream;", "(Lcom/fasterxml/jackson/databind/ObjectMapper;Ljava/io/InputStream;)Ljava/lang/Object;", "Ljava/io/Reader;", "(Lcom/fasterxml/jackson/databind/ObjectMapper;Ljava/io/Reader;)Ljava/lang/Object;", "Ljava/net/URL;", "(Lcom/fasterxml/jackson/databind/ObjectMapper;Ljava/net/URL;)Ljava/lang/Object;", "(Lcom/fasterxml/jackson/databind/ObjectMapper;[B)Ljava/lang/Object;", "content", "(Lcom/fasterxml/jackson/databind/ObjectMapper;Ljava/lang/String;)Ljava/lang/Object;", "Lcom/fasterxml/jackson/databind/ObjectReader;", "readValueTyped", "(Lcom/fasterxml/jackson/databind/ObjectReader;Lcom/fasterxml/jackson/core/JsonParser;)Ljava/lang/Object;", "Lcom/fasterxml/jackson/databind/MappingIterator;", "readValues", "(Lcom/fasterxml/jackson/databind/ObjectMapper;Lcom/fasterxml/jackson/core/JsonParser;)Lcom/fasterxml/jackson/databind/MappingIterator;", "", "readValuesTyped", "(Lcom/fasterxml/jackson/databind/ObjectReader;Lcom/fasterxml/jackson/core/JsonParser;)Ljava/util/Iterator;", "registerKotlinModule", "(Lcom/fasterxml/jackson/databind/ObjectMapper;)Lcom/fasterxml/jackson/databind/ObjectMapper;", "Ljava/util/BitSet;", "toBitSet", "(I)Ljava/util/BitSet;", "Lcom/fasterxml/jackson/core/TreeNode;", "n", "treeToValue", "(Lcom/fasterxml/jackson/databind/ObjectMapper;Lcom/fasterxml/jackson/core/TreeNode;)Ljava/lang/Object;", "(Lcom/fasterxml/jackson/databind/ObjectReader;Lcom/fasterxml/jackson/core/TreeNode;)Ljava/lang/Object;", "Lcom/fasterxml/jackson/databind/JsonMappingException;", "refFrom", "kotlin.jvm.PlatformType", "wrapWithPath", "(Lcom/fasterxml/jackson/databind/JsonMappingException;Ljava/lang/Object;I)Lcom/fasterxml/jackson/databind/JsonMappingException;", "refFieldName", "(Lcom/fasterxml/jackson/databind/JsonMappingException;Ljava/lang/Object;Ljava/lang/String;)Lcom/fasterxml/jackson/databind/JsonMappingException;", "jackson-module-kotlin"})
public final class ExtensionsKt {
    @NotNull
    public static final KotlinModule kotlinModule(@NotNull Function1<? super KotlinModule.Builder, Unit> initializer) {
        Intrinsics.checkNotNullParameter(initializer, (String)"initializer");
        KotlinModule.Builder builder = new KotlinModule.Builder();
        initializer.invoke((Object)builder);
        return builder.build();
    }

    public static /* synthetic */ KotlinModule kotlinModule$default(Function1 function1, int n2, Object object) {
        if ((n2 & 1) != 0) {
            function1 = kotlinModule.1.INSTANCE;
        }
        return ExtensionsKt.kotlinModule((Function1<? super KotlinModule.Builder, Unit>)function1);
    }

    @NotNull
    public static final JsonMapper jsonMapper(@NotNull Function1<? super JsonMapper.Builder, Unit> initializer) {
        Intrinsics.checkNotNullParameter(initializer, (String)"initializer");
        JsonMapper.Builder builder = JsonMapper.builder();
        Intrinsics.checkNotNullExpressionValue((Object)builder, (String)"builder");
        initializer.invoke((Object)builder);
        Object m2 = builder.build();
        Intrinsics.checkNotNullExpressionValue(m2, (String)"builder.build()");
        return (JsonMapper)m2;
    }

    public static /* synthetic */ JsonMapper jsonMapper$default(Function1 function1, int n2, Object object) {
        if ((n2 & 1) != 0) {
            function1 = jsonMapper.1.INSTANCE;
        }
        return ExtensionsKt.jsonMapper((Function1<? super JsonMapper.Builder, Unit>)function1);
    }

    @NotNull
    public static final ObjectMapper jacksonObjectMapper() {
        return ExtensionsKt.jsonMapper((Function1<? super JsonMapper.Builder, Unit>)((Function1)jacksonObjectMapper.1.INSTANCE));
    }

    @NotNull
    public static final JsonMapper.Builder jacksonMapperBuilder() {
        Object b2 = JsonMapper.builder().addModule(ExtensionsKt.kotlinModule$default(null, 1, null));
        Intrinsics.checkNotNullExpressionValue(b2, (String)"builder().addModule(kotlinModule())");
        return (JsonMapper.Builder)b2;
    }

    @NotNull
    public static final ObjectMapper registerKotlinModule(@NotNull ObjectMapper $this$registerKotlinModule) {
        Intrinsics.checkNotNullParameter((Object)$this$registerKotlinModule, (String)"<this>");
        ObjectMapper objectMapper = $this$registerKotlinModule.registerModule(ExtensionsKt.kotlinModule$default(null, 1, null));
        Intrinsics.checkNotNullExpressionValue((Object)objectMapper, (String)"this.registerModule(kotlinModule())");
        return objectMapper;
    }

    public static final /* synthetic */ <T> TypeReference<T> jacksonTypeRef() {
        boolean $i$f$jacksonTypeRef = false;
        Intrinsics.needClassReification();
        return new TypeReference<T>(){};
    }

    public static final /* synthetic */ <T> T readValue(ObjectMapper $this$readValue, JsonParser jp) {
        Intrinsics.checkNotNullParameter((Object)$this$readValue, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)jp, (String)"jp");
        boolean $i$f$readValue = false;
        boolean $i$f$jacksonTypeRef = false;
        Intrinsics.needClassReification();
        return $this$readValue.readValue(jp, new TypeReference<T>(){});
    }

    public static final /* synthetic */ <T> MappingIterator<T> readValues(ObjectMapper $this$readValues, JsonParser jp) {
        Intrinsics.checkNotNullParameter((Object)$this$readValues, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)jp, (String)"jp");
        boolean $i$f$readValues = false;
        boolean $i$f$jacksonTypeRef = false;
        Intrinsics.needClassReification();
        Iterator iterator2 = $this$readValues.readValues(jp, new TypeReference<T>(){});
        Intrinsics.checkNotNullExpressionValue((Object)iterator2, (String)"readValues(jp, jacksonTypeRef<T>())");
        return iterator2;
    }

    public static final /* synthetic */ <T> T readValue(ObjectMapper $this$readValue, File src) {
        Intrinsics.checkNotNullParameter((Object)$this$readValue, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)src, (String)"src");
        boolean $i$f$readValue = false;
        boolean $i$f$jacksonTypeRef = false;
        Intrinsics.needClassReification();
        return $this$readValue.readValue(src, new TypeReference<T>(){});
    }

    public static final /* synthetic */ <T> T readValue(ObjectMapper $this$readValue, URL src) {
        Intrinsics.checkNotNullParameter((Object)$this$readValue, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)src, (String)"src");
        boolean $i$f$readValue = false;
        boolean $i$f$jacksonTypeRef = false;
        Intrinsics.needClassReification();
        return $this$readValue.readValue(src, new TypeReference<T>(){});
    }

    public static final /* synthetic */ <T> T readValue(ObjectMapper $this$readValue, String content) {
        Intrinsics.checkNotNullParameter((Object)$this$readValue, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)content, (String)"content");
        boolean $i$f$readValue = false;
        boolean $i$f$jacksonTypeRef = false;
        Intrinsics.needClassReification();
        return $this$readValue.readValue(content, new TypeReference<T>(){});
    }

    public static final /* synthetic */ <T> T readValue(ObjectMapper $this$readValue, Reader src) {
        Intrinsics.checkNotNullParameter((Object)$this$readValue, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)src, (String)"src");
        boolean $i$f$readValue = false;
        boolean $i$f$jacksonTypeRef = false;
        Intrinsics.needClassReification();
        return $this$readValue.readValue(src, new TypeReference<T>(){});
    }

    public static final /* synthetic */ <T> T readValue(ObjectMapper $this$readValue, InputStream src) {
        Intrinsics.checkNotNullParameter((Object)$this$readValue, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)src, (String)"src");
        boolean $i$f$readValue = false;
        boolean $i$f$jacksonTypeRef = false;
        Intrinsics.needClassReification();
        return $this$readValue.readValue(src, new TypeReference<T>(){});
    }

    public static final /* synthetic */ <T> T readValue(ObjectMapper $this$readValue, byte[] src) {
        Intrinsics.checkNotNullParameter((Object)$this$readValue, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)src, (String)"src");
        boolean $i$f$readValue = false;
        boolean $i$f$jacksonTypeRef = false;
        Intrinsics.needClassReification();
        return $this$readValue.readValue(src, new TypeReference<T>(){});
    }

    public static final /* synthetic */ <T> T treeToValue(ObjectMapper $this$treeToValue, TreeNode n2) {
        Intrinsics.checkNotNullParameter((Object)$this$treeToValue, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)n2, (String)"n");
        boolean $i$f$treeToValue = false;
        JsonParser jsonParser = $this$treeToValue.treeAsTokens(n2);
        boolean $i$f$jacksonTypeRef = false;
        Intrinsics.needClassReification();
        return $this$treeToValue.readValue(jsonParser, new TypeReference<T>(){});
    }

    public static final /* synthetic */ <T> T convertValue(ObjectMapper $this$convertValue, Object from) {
        Intrinsics.checkNotNullParameter((Object)$this$convertValue, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)from, (String)"from");
        boolean $i$f$convertValue = false;
        boolean $i$f$jacksonTypeRef = false;
        Intrinsics.needClassReification();
        return $this$convertValue.convertValue(from, new TypeReference<T>(){});
    }

    public static final /* synthetic */ <T> T readValueTyped(ObjectReader $this$readValueTyped, JsonParser jp) {
        Intrinsics.checkNotNullParameter((Object)$this$readValueTyped, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)jp, (String)"jp");
        boolean $i$f$readValueTyped = false;
        boolean $i$f$jacksonTypeRef = false;
        Intrinsics.needClassReification();
        return $this$readValueTyped.readValue(jp, new TypeReference<T>(){});
    }

    public static final /* synthetic */ <T> Iterator<T> readValuesTyped(ObjectReader $this$readValuesTyped, JsonParser jp) {
        Intrinsics.checkNotNullParameter((Object)$this$readValuesTyped, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)jp, (String)"jp");
        boolean $i$f$readValuesTyped = false;
        boolean $i$f$jacksonTypeRef = false;
        Intrinsics.needClassReification();
        Iterator iterator2 = $this$readValuesTyped.readValues(jp, new TypeReference<T>(){});
        Intrinsics.checkNotNullExpressionValue(iterator2, (String)"readValues(jp, jacksonTypeRef<T>())");
        return iterator2;
    }

    public static final /* synthetic */ <T> T treeToValue(ObjectReader $this$treeToValue, TreeNode n2) {
        Intrinsics.checkNotNullParameter((Object)$this$treeToValue, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)n2, (String)"n");
        boolean $i$f$treeToValue = false;
        JsonParser jsonParser = $this$treeToValue.treeAsTokens(n2);
        boolean $i$f$jacksonTypeRef = false;
        Intrinsics.needClassReification();
        return $this$treeToValue.readValue(jsonParser, new TypeReference<T>(){});
    }

    public static final void plus(@NotNull ArrayNode $this$plus, boolean element) {
        Intrinsics.checkNotNullParameter((Object)$this$plus, (String)"<this>");
        Unit unit = Unit.INSTANCE;
        boolean bl = false;
        boolean bl2 = false;
        Unit $this$plus_u24lambda_u2d0 = unit;
        boolean bl3 = false;
        $this$plus.add(element);
    }

    public static final void plus(@NotNull ArrayNode $this$plus, short element) {
        Intrinsics.checkNotNullParameter((Object)$this$plus, (String)"<this>");
        Unit unit = Unit.INSTANCE;
        boolean bl = false;
        boolean bl2 = false;
        Unit $this$plus_u24lambda_u2d1 = unit;
        boolean bl3 = false;
        $this$plus.add(element);
    }

    public static final void plus(@NotNull ArrayNode $this$plus, int element) {
        Intrinsics.checkNotNullParameter((Object)$this$plus, (String)"<this>");
        Unit unit = Unit.INSTANCE;
        boolean bl = false;
        boolean bl2 = false;
        Unit $this$plus_u24lambda_u2d2 = unit;
        boolean bl3 = false;
        $this$plus.add(element);
    }

    public static final void plus(@NotNull ArrayNode $this$plus, long element) {
        Intrinsics.checkNotNullParameter((Object)$this$plus, (String)"<this>");
        Unit unit = Unit.INSTANCE;
        boolean bl = false;
        boolean bl2 = false;
        Unit $this$plus_u24lambda_u2d3 = unit;
        boolean bl3 = false;
        $this$plus.add(element);
    }

    public static final void plus(@NotNull ArrayNode $this$plus, float element) {
        Intrinsics.checkNotNullParameter((Object)$this$plus, (String)"<this>");
        Unit unit = Unit.INSTANCE;
        boolean bl = false;
        boolean bl2 = false;
        Unit $this$plus_u24lambda_u2d4 = unit;
        boolean bl3 = false;
        $this$plus.add(element);
    }

    public static final void plus(@NotNull ArrayNode $this$plus, double element) {
        Intrinsics.checkNotNullParameter((Object)$this$plus, (String)"<this>");
        Unit unit = Unit.INSTANCE;
        boolean bl = false;
        boolean bl2 = false;
        Unit $this$plus_u24lambda_u2d5 = unit;
        boolean bl3 = false;
        $this$plus.add(element);
    }

    public static final void plus(@NotNull ArrayNode $this$plus, @NotNull BigDecimal element) {
        Intrinsics.checkNotNullParameter((Object)$this$plus, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)element, (String)"element");
        Unit unit = Unit.INSTANCE;
        boolean bl = false;
        boolean bl2 = false;
        Unit $this$plus_u24lambda_u2d6 = unit;
        boolean bl3 = false;
        $this$plus.add(element);
    }

    public static final void plus(@NotNull ArrayNode $this$plus, @NotNull BigInteger element) {
        Intrinsics.checkNotNullParameter((Object)$this$plus, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)element, (String)"element");
        Unit unit = Unit.INSTANCE;
        boolean bl = false;
        boolean bl2 = false;
        Unit $this$plus_u24lambda_u2d7 = unit;
        boolean bl3 = false;
        $this$plus.add(element);
    }

    public static final void plus(@NotNull ArrayNode $this$plus, @NotNull String element) {
        Intrinsics.checkNotNullParameter((Object)$this$plus, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)element, (String)"element");
        Unit unit = Unit.INSTANCE;
        boolean bl = false;
        boolean bl2 = false;
        Unit $this$plus_u24lambda_u2d8 = unit;
        boolean bl3 = false;
        $this$plus.add(element);
    }

    public static final void plus(@NotNull ArrayNode $this$plus, @NotNull byte[] element) {
        Intrinsics.checkNotNullParameter((Object)$this$plus, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)element, (String)"element");
        Unit unit = Unit.INSTANCE;
        boolean bl = false;
        boolean bl2 = false;
        Unit $this$plus_u24lambda_u2d9 = unit;
        boolean bl3 = false;
        $this$plus.add(element);
    }

    public static final void plus(@NotNull ArrayNode $this$plus, @NotNull JsonNode element) {
        Intrinsics.checkNotNullParameter((Object)$this$plus, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)element, (String)"element");
        Unit unit = Unit.INSTANCE;
        boolean bl = false;
        boolean bl2 = false;
        Unit $this$plus_u24lambda_u2d10 = unit;
        boolean bl3 = false;
        $this$plus.add(element);
    }

    public static final void plus(@NotNull ArrayNode $this$plus, @NotNull ArrayNode elements) {
        Intrinsics.checkNotNullParameter((Object)$this$plus, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)elements, (String)"elements");
        Unit unit = Unit.INSTANCE;
        boolean bl = false;
        boolean bl2 = false;
        Unit $this$plus_u24lambda_u2d11 = unit;
        boolean bl3 = false;
        $this$plus.addAll(elements);
    }

    public static final void plusAssign(@NotNull ArrayNode $this$plusAssign, boolean element) {
        Intrinsics.checkNotNullParameter((Object)$this$plusAssign, (String)"<this>");
        Unit unit = Unit.INSTANCE;
        boolean bl = false;
        boolean bl2 = false;
        Unit $this$plusAssign_u24lambda_u2d12 = unit;
        boolean bl3 = false;
        $this$plusAssign.add(element);
    }

    public static final void plusAssign(@NotNull ArrayNode $this$plusAssign, short element) {
        Intrinsics.checkNotNullParameter((Object)$this$plusAssign, (String)"<this>");
        Unit unit = Unit.INSTANCE;
        boolean bl = false;
        boolean bl2 = false;
        Unit $this$plusAssign_u24lambda_u2d13 = unit;
        boolean bl3 = false;
        $this$plusAssign.add(element);
    }

    public static final void plusAssign(@NotNull ArrayNode $this$plusAssign, int element) {
        Intrinsics.checkNotNullParameter((Object)$this$plusAssign, (String)"<this>");
        Unit unit = Unit.INSTANCE;
        boolean bl = false;
        boolean bl2 = false;
        Unit $this$plusAssign_u24lambda_u2d14 = unit;
        boolean bl3 = false;
        $this$plusAssign.add(element);
    }

    public static final void plusAssign(@NotNull ArrayNode $this$plusAssign, long element) {
        Intrinsics.checkNotNullParameter((Object)$this$plusAssign, (String)"<this>");
        Unit unit = Unit.INSTANCE;
        boolean bl = false;
        boolean bl2 = false;
        Unit $this$plusAssign_u24lambda_u2d15 = unit;
        boolean bl3 = false;
        $this$plusAssign.add(element);
    }

    public static final void plusAssign(@NotNull ArrayNode $this$plusAssign, float element) {
        Intrinsics.checkNotNullParameter((Object)$this$plusAssign, (String)"<this>");
        Unit unit = Unit.INSTANCE;
        boolean bl = false;
        boolean bl2 = false;
        Unit $this$plusAssign_u24lambda_u2d16 = unit;
        boolean bl3 = false;
        $this$plusAssign.add(element);
    }

    public static final void plusAssign(@NotNull ArrayNode $this$plusAssign, double element) {
        Intrinsics.checkNotNullParameter((Object)$this$plusAssign, (String)"<this>");
        Unit unit = Unit.INSTANCE;
        boolean bl = false;
        boolean bl2 = false;
        Unit $this$plusAssign_u24lambda_u2d17 = unit;
        boolean bl3 = false;
        $this$plusAssign.add(element);
    }

    public static final void plusAssign(@NotNull ArrayNode $this$plusAssign, @NotNull BigDecimal element) {
        Intrinsics.checkNotNullParameter((Object)$this$plusAssign, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)element, (String)"element");
        Unit unit = Unit.INSTANCE;
        boolean bl = false;
        boolean bl2 = false;
        Unit $this$plusAssign_u24lambda_u2d18 = unit;
        boolean bl3 = false;
        $this$plusAssign.add(element);
    }

    public static final void plusAssign(@NotNull ArrayNode $this$plusAssign, @NotNull BigInteger element) {
        Intrinsics.checkNotNullParameter((Object)$this$plusAssign, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)element, (String)"element");
        Unit unit = Unit.INSTANCE;
        boolean bl = false;
        boolean bl2 = false;
        Unit $this$plusAssign_u24lambda_u2d19 = unit;
        boolean bl3 = false;
        $this$plusAssign.add(element);
    }

    public static final void plusAssign(@NotNull ArrayNode $this$plusAssign, @NotNull String element) {
        Intrinsics.checkNotNullParameter((Object)$this$plusAssign, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)element, (String)"element");
        Unit unit = Unit.INSTANCE;
        boolean bl = false;
        boolean bl2 = false;
        Unit $this$plusAssign_u24lambda_u2d20 = unit;
        boolean bl3 = false;
        $this$plusAssign.add(element);
    }

    public static final void plusAssign(@NotNull ArrayNode $this$plusAssign, @NotNull byte[] element) {
        Intrinsics.checkNotNullParameter((Object)$this$plusAssign, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)element, (String)"element");
        Unit unit = Unit.INSTANCE;
        boolean bl = false;
        boolean bl2 = false;
        Unit $this$plusAssign_u24lambda_u2d21 = unit;
        boolean bl3 = false;
        $this$plusAssign.add(element);
    }

    public static final void plusAssign(@NotNull ArrayNode $this$plusAssign, @NotNull JsonNode element) {
        Intrinsics.checkNotNullParameter((Object)$this$plusAssign, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)element, (String)"element");
        Unit unit = Unit.INSTANCE;
        boolean bl = false;
        boolean bl2 = false;
        Unit $this$plusAssign_u24lambda_u2d22 = unit;
        boolean bl3 = false;
        $this$plusAssign.add(element);
    }

    public static final void plusAssign(@NotNull ArrayNode $this$plusAssign, @NotNull ArrayNode elements) {
        Intrinsics.checkNotNullParameter((Object)$this$plusAssign, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)elements, (String)"elements");
        Unit unit = Unit.INSTANCE;
        boolean bl = false;
        boolean bl2 = false;
        Unit $this$plusAssign_u24lambda_u2d23 = unit;
        boolean bl3 = false;
        $this$plusAssign.addAll(elements);
    }

    public static final void minus(@NotNull ArrayNode $this$minus, int index) {
        Intrinsics.checkNotNullParameter((Object)$this$minus, (String)"<this>");
        Unit unit = Unit.INSTANCE;
        boolean bl = false;
        boolean bl2 = false;
        Unit $this$minus_u24lambda_u2d24 = unit;
        boolean bl3 = false;
        $this$minus.remove(index);
    }

    public static final void minusAssign(@NotNull ArrayNode $this$minusAssign, int index) {
        Intrinsics.checkNotNullParameter((Object)$this$minusAssign, (String)"<this>");
        Unit unit = Unit.INSTANCE;
        boolean bl = false;
        boolean bl2 = false;
        Unit $this$minusAssign_u24lambda_u2d25 = unit;
        boolean bl3 = false;
        $this$minusAssign.remove(index);
    }

    public static final void minus(@NotNull ObjectNode $this$minus, @NotNull String field) {
        Intrinsics.checkNotNullParameter((Object)$this$minus, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)field, (String)"field");
        Unit unit = Unit.INSTANCE;
        boolean bl = false;
        boolean bl2 = false;
        Unit $this$minus_u24lambda_u2d26 = unit;
        boolean bl3 = false;
        $this$minus.remove(field);
    }

    public static final void minus(@NotNull ObjectNode $this$minus, @NotNull Collection<String> fields) {
        Intrinsics.checkNotNullParameter((Object)$this$minus, (String)"<this>");
        Intrinsics.checkNotNullParameter(fields, (String)"fields");
        Unit unit = Unit.INSTANCE;
        boolean bl = false;
        boolean bl2 = false;
        Unit $this$minus_u24lambda_u2d27 = unit;
        boolean bl3 = false;
        $this$minus.remove(fields);
    }

    public static final void minusAssign(@NotNull ObjectNode $this$minusAssign, @NotNull String field) {
        Intrinsics.checkNotNullParameter((Object)$this$minusAssign, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)field, (String)"field");
        Unit unit = Unit.INSTANCE;
        boolean bl = false;
        boolean bl2 = false;
        Unit $this$minusAssign_u24lambda_u2d28 = unit;
        boolean bl3 = false;
        $this$minusAssign.remove(field);
    }

    public static final void minusAssign(@NotNull ObjectNode $this$minusAssign, @NotNull Collection<String> fields) {
        Intrinsics.checkNotNullParameter((Object)$this$minusAssign, (String)"<this>");
        Intrinsics.checkNotNullParameter(fields, (String)"fields");
        Unit unit = Unit.INSTANCE;
        boolean bl = false;
        boolean bl2 = false;
        Unit $this$minusAssign_u24lambda_u2d29 = unit;
        boolean bl3 = false;
        $this$minusAssign.remove(fields);
    }

    public static final boolean contains(@NotNull JsonNode $this$contains, @NotNull String field) {
        Intrinsics.checkNotNullParameter((Object)$this$contains, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)field, (String)"field");
        return $this$contains.has(field);
    }

    public static final boolean contains(@NotNull JsonNode $this$contains, int index) {
        Intrinsics.checkNotNullParameter((Object)$this$contains, (String)"<this>");
        return $this$contains.has(index);
    }

    public static final JsonMappingException wrapWithPath(@NotNull JsonMappingException $this$wrapWithPath, @Nullable Object refFrom, @NotNull String refFieldName) {
        Intrinsics.checkNotNullParameter((Object)$this$wrapWithPath, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)refFieldName, (String)"refFieldName");
        return JsonMappingException.wrapWithPath((Throwable)$this$wrapWithPath, refFrom, refFieldName);
    }

    public static final JsonMappingException wrapWithPath(@NotNull JsonMappingException $this$wrapWithPath, @Nullable Object refFrom, int index) {
        Intrinsics.checkNotNullParameter((Object)$this$wrapWithPath, (String)"<this>");
        return JsonMappingException.wrapWithPath((Throwable)$this$wrapWithPath, refFrom, index);
    }

    public static final /* synthetic */ <T> SimpleModule addSerializer(SimpleModule $this$addSerializer, KClass<T> kClass, JsonSerializer<T> serializer) {
        Intrinsics.checkNotNullParameter((Object)$this$addSerializer, (String)"<this>");
        Intrinsics.checkNotNullParameter(kClass, (String)"kClass");
        Intrinsics.checkNotNullParameter(serializer, (String)"serializer");
        boolean $i$f$addSerializer = false;
        SimpleModule simpleModule = $this$addSerializer;
        boolean bl = false;
        boolean bl2 = false;
        SimpleModule $this$addSerializer_u24lambda_u2d30 = simpleModule;
        boolean bl3 = false;
        $this$addSerializer_u24lambda_u2d30.addSerializer(JvmClassMappingKt.getJavaClass(kClass), serializer);
        $this$addSerializer_u24lambda_u2d30.addSerializer(JvmClassMappingKt.getJavaObjectType(kClass), serializer);
        return simpleModule;
    }

    public static final /* synthetic */ <T> SimpleModule addDeserializer(SimpleModule $this$addDeserializer, KClass<T> kClass, JsonDeserializer<T> deserializer) {
        Intrinsics.checkNotNullParameter((Object)$this$addDeserializer, (String)"<this>");
        Intrinsics.checkNotNullParameter(kClass, (String)"kClass");
        Intrinsics.checkNotNullParameter(deserializer, (String)"deserializer");
        boolean $i$f$addDeserializer = false;
        SimpleModule simpleModule = $this$addDeserializer;
        boolean bl = false;
        boolean bl2 = false;
        SimpleModule $this$addDeserializer_u24lambda_u2d31 = simpleModule;
        boolean bl3 = false;
        $this$addDeserializer_u24lambda_u2d31.addDeserializer(JvmClassMappingKt.getJavaClass(kClass), deserializer);
        $this$addDeserializer_u24lambda_u2d31.addDeserializer(JvmClassMappingKt.getJavaObjectType(kClass), deserializer);
        return simpleModule;
    }

    @NotNull
    public static final BitSet toBitSet(int $this$toBitSet) {
        int index = 0;
        BitSet bits = new BitSet(32);
        for (int i2 = $this$toBitSet; i2 != 0; i2 >>= 1) {
            if (i2 % 2 != 0) {
                bits.set(index);
            }
            ++index;
        }
        return bits;
    }

    public static final boolean isUnboxableValueClass(@NotNull Class<?> $this$isUnboxableValueClass) {
        boolean bl;
        block1: {
            Intrinsics.checkNotNullParameter($this$isUnboxableValueClass, (String)"<this>");
            Annotation[] annotationArray = $this$isUnboxableValueClass.getAnnotations();
            Intrinsics.checkNotNullExpressionValue((Object)annotationArray, (String)"annotations");
            Object[] $this$any$iv = annotationArray;
            boolean $i$f$any = false;
            for (Object element$iv : $this$any$iv) {
                Annotation it = (Annotation)element$iv;
                boolean bl2 = false;
                if (!(it instanceof JvmInline)) continue;
                bl = true;
                break block1;
            }
            bl = false;
        }
        return bl && KotlinModuleKt.isKotlinClass($this$isUnboxableValueClass);
    }
}

