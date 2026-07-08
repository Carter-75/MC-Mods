/*
 * Decompiled with CFR 0.152.
 */
package com.fasterxml.jackson.databind.jdk14;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.databind.AnnotationIntrospector;
import com.fasterxml.jackson.databind.BeanDescription;
import com.fasterxml.jackson.databind.DeserializationConfig;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.introspect.AnnotatedConstructor;
import com.fasterxml.jackson.databind.util.ClassUtil;
import com.fasterxml.jackson.databind.util.NativeImageUtil;
import java.lang.reflect.Method;
import java.util.Collections;
import java.util.List;

public class JDK14Util {
    public static String[] getRecordFieldNames(Class<?> recordType) {
        return RecordAccessor.instance().getRecordFieldNames(recordType);
    }

    public static AnnotatedConstructor findRecordConstructor(DeserializationContext ctxt, BeanDescription beanDesc, List<String> names) {
        return new CreatorLocator(ctxt, beanDesc).locate(names);
    }

    static class CreatorLocator {
        protected final BeanDescription _beanDesc;
        protected final DeserializationConfig _config;
        protected final AnnotationIntrospector _intr;
        protected final List<AnnotatedConstructor> _constructors;
        protected final AnnotatedConstructor _primaryConstructor;
        protected final RawTypeName[] _recordFields;

        CreatorLocator(DeserializationContext ctxt, BeanDescription beanDesc) {
            this._beanDesc = beanDesc;
            this._intr = ctxt.getAnnotationIntrospector();
            this._config = ctxt.getConfig();
            this._recordFields = RecordAccessor.instance().getRecordFields(beanDesc.getBeanClass());
            if (this._recordFields == null) {
                this._constructors = beanDesc.getConstructors();
                this._primaryConstructor = null;
            } else {
                int argCount = this._recordFields.length;
                AnnotatedConstructor primary = null;
                if (argCount == 0) {
                    primary = beanDesc.findDefaultConstructor();
                    this._constructors = Collections.singletonList(primary);
                } else {
                    this._constructors = beanDesc.getConstructors();
                    block0: for (AnnotatedConstructor ctor : this._constructors) {
                        if (ctor.getParameterCount() != argCount) continue;
                        for (int i2 = 0; i2 < argCount; ++i2) {
                            if (!ctor.getRawParameterType(i2).equals(this._recordFields[i2].rawType)) continue block0;
                        }
                        primary = ctor;
                        break;
                    }
                }
                if (primary == null) {
                    throw new IllegalArgumentException("Failed to find the canonical Record constructor of type " + ClassUtil.getTypeDescription(this._beanDesc.getType()));
                }
                this._primaryConstructor = primary;
            }
        }

        public AnnotatedConstructor locate(List<String> names) {
            for (AnnotatedConstructor ctor : this._constructors) {
                JsonCreator.Mode creatorMode = this._intr.findCreatorAnnotation(this._config, ctor);
                if (null == creatorMode || JsonCreator.Mode.DISABLED == creatorMode) continue;
                if (JsonCreator.Mode.DELEGATING == creatorMode) {
                    return null;
                }
                if (ctor == this._primaryConstructor) continue;
                return null;
            }
            if (this._recordFields == null) {
                return null;
            }
            for (RawTypeName field : this._recordFields) {
                names.add(field.name);
            }
            return this._primaryConstructor;
        }
    }

    static class RawTypeName {
        public final Class<?> rawType;
        public final String name;

        public RawTypeName(Class<?> rt, String n2) {
            this.rawType = rt;
            this.name = n2;
        }
    }

    static class RecordAccessor {
        private final Method RECORD_GET_RECORD_COMPONENTS;
        private final Method RECORD_COMPONENT_GET_NAME;
        private final Method RECORD_COMPONENT_GET_TYPE;
        private static final RecordAccessor INSTANCE;
        private static final RuntimeException PROBLEM;

        private RecordAccessor() throws RuntimeException {
            try {
                this.RECORD_GET_RECORD_COMPONENTS = Class.class.getMethod("getRecordComponents", new Class[0]);
                Class<?> c2 = Class.forName("java.lang.reflect.RecordComponent");
                this.RECORD_COMPONENT_GET_NAME = c2.getMethod("getName", new Class[0]);
                this.RECORD_COMPONENT_GET_TYPE = c2.getMethod("getType", new Class[0]);
            }
            catch (Exception e2) {
                throw new RuntimeException(String.format("Failed to access Methods needed to support `java.lang.Record`: (%s) %s", e2.getClass().getName(), e2.getMessage()), e2);
            }
        }

        public static RecordAccessor instance() {
            if (PROBLEM != null) {
                throw PROBLEM;
            }
            return INSTANCE;
        }

        public String[] getRecordFieldNames(Class<?> recordType) throws IllegalArgumentException {
            Object[] components = this.recordComponents(recordType);
            if (components == null) {
                return null;
            }
            String[] names = new String[components.length];
            for (int i2 = 0; i2 < components.length; ++i2) {
                try {
                    names[i2] = (String)this.RECORD_COMPONENT_GET_NAME.invoke(components[i2], new Object[0]);
                    continue;
                }
                catch (Exception e2) {
                    throw new IllegalArgumentException(String.format("Failed to access name of field #%d (of %d) of Record type %s", i2, components.length, ClassUtil.nameOf(recordType)), e2);
                }
            }
            return names;
        }

        public RawTypeName[] getRecordFields(Class<?> recordType) throws IllegalArgumentException {
            Object[] components = this.recordComponents(recordType);
            if (components == null) {
                return null;
            }
            RawTypeName[] results = new RawTypeName[components.length];
            for (int i2 = 0; i2 < components.length; ++i2) {
                Class type;
                String name;
                try {
                    name = (String)this.RECORD_COMPONENT_GET_NAME.invoke(components[i2], new Object[0]);
                }
                catch (Exception e2) {
                    throw new IllegalArgumentException(String.format("Failed to access name of field #%d (of %d) of Record type %s", i2, components.length, ClassUtil.nameOf(recordType)), e2);
                }
                try {
                    type = (Class)this.RECORD_COMPONENT_GET_TYPE.invoke(components[i2], new Object[0]);
                }
                catch (Exception e3) {
                    throw new IllegalArgumentException(String.format("Failed to access type of field #%d (of %d) of Record type %s", i2, components.length, ClassUtil.nameOf(recordType)), e3);
                }
                results[i2] = new RawTypeName(type, name);
            }
            return results;
        }

        protected Object[] recordComponents(Class<?> recordType) throws IllegalArgumentException {
            try {
                return (Object[])this.RECORD_GET_RECORD_COMPONENTS.invoke(recordType, new Object[0]);
            }
            catch (Exception e2) {
                if (NativeImageUtil.isUnsupportedFeatureError(e2)) {
                    return null;
                }
                throw new IllegalArgumentException("Failed to access RecordComponents of type " + ClassUtil.nameOf(recordType));
            }
        }

        static {
            RuntimeException prob = null;
            RecordAccessor inst = null;
            try {
                inst = new RecordAccessor();
            }
            catch (RuntimeException e2) {
                prob = e2;
            }
            INSTANCE = inst;
            PROBLEM = prob;
        }
    }
}

