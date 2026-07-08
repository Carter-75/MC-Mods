/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.valkyrienskies.core.impl.shadow.cU
 */
package org.valkyrienskies.core.impl.shadow;

import com.fasterxml.jackson.databind.JsonNode;
import java.lang.reflect.Constructor;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.valkyrienskies.core.impl.shadow.bp_1;
import org.valkyrienskies.core.impl.shadow.bq_1;
import org.valkyrienskies.core.impl.shadow.br_1;
import org.valkyrienskies.core.impl.shadow.bw_1;
import org.valkyrienskies.core.impl.shadow.bx_1;
import org.valkyrienskies.core.impl.shadow.cU;
import org.valkyrienskies.core.impl.shadow.ca_1;
import org.valkyrienskies.core.impl.shadow.ca_2;
import org.valkyrienskies.core.impl.shadow.cb_1;
import org.valkyrienskies.core.impl.shadow.cb_2;
import org.valkyrienskies.core.impl.shadow.cc_1;
import org.valkyrienskies.core.impl.shadow.cc_2;
import org.valkyrienskies.core.impl.shadow.cd_1;
import org.valkyrienskies.core.impl.shadow.cd_2;
import org.valkyrienskies.core.impl.shadow.ce_1;
import org.valkyrienskies.core.impl.shadow.ce_2;
import org.valkyrienskies.core.impl.shadow.cf_1;
import org.valkyrienskies.core.impl.shadow.cf_2;
import org.valkyrienskies.core.impl.shadow.cg_2;
import org.valkyrienskies.core.impl.shadow.ch_1;
import org.valkyrienskies.core.impl.shadow.ch_2;
import org.valkyrienskies.core.impl.shadow.ci_1;
import org.valkyrienskies.core.impl.shadow.cj_1;
import org.valkyrienskies.core.impl.shadow.cl_1;
import org.valkyrienskies.core.impl.shadow.cl_2;
import org.valkyrienskies.core.impl.shadow.cm_1;
import org.valkyrienskies.core.impl.shadow.cm_2;
import org.valkyrienskies.core.impl.shadow.cn_1;
import org.valkyrienskies.core.impl.shadow.cn_2;
import org.valkyrienskies.core.impl.shadow.co_1;
import org.valkyrienskies.core.impl.shadow.cp_1;
import org.valkyrienskies.core.impl.shadow.cp_2;
import org.valkyrienskies.core.impl.shadow.cq_1;
import org.valkyrienskies.core.impl.shadow.cr_1;
import org.valkyrienskies.core.impl.shadow.cs_1;
import org.valkyrienskies.core.impl.shadow.cu_1;
import org.valkyrienskies.core.impl.shadow.cv_2;
import org.valkyrienskies.core.impl.shadow.cw_2;
import org.valkyrienskies.core.impl.shadow.cx_2;
import org.valkyrienskies.core.impl.shadow.cy_1;
import org.valkyrienskies.core.impl.shadow.cy_2;
import org.valkyrienskies.core.impl.shadow.cz_2;
import org.valkyrienskies.core.impl.shadow.da_2;
import org.valkyrienskies.core.impl.shadow.dc_2;
import org.valkyrienskies.core.impl.shadow.dd_2;
import org.valkyrienskies.core.impl.shadow.de_2;
import org.valkyrienskies.core.impl.shadow.df_2;
import org.valkyrienskies.core.impl.shadow.dp_2;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.dj
 */
public enum dj_2 implements ce_2,
cw_2
{
    ADDITIONAL_PROPERTIES("additionalProperties", "1001", new MessageFormat(cl_2.a("additionalProperties")), bp_1.class, dp_2.AllVersions),
    ALL_OF("allOf", "1002", new MessageFormat(cl_2.a("allOf")), bq_1.class, dp_2.AllVersions),
    ANY_OF("anyOf", "1003", new MessageFormat(cl_2.a("anyOf")), br_1.class, dp_2.AllVersions),
    CROSS_EDITS("crossEdits", "1004", new MessageFormat(cl_2.a("crossEdits")), null, dp_2.AllVersions),
    DEPENDENCIES("dependencies", "1007", new MessageFormat(cl_2.a("dependencies")), ca_2.class, dp_2.AllVersions),
    EDITS("edits", "1005", new MessageFormat(cl_2.a("edits")), null, dp_2.AllVersions),
    ENUM("enum", "1008", new MessageFormat(cl_2.a("enum")), cd_2.class, dp_2.AllVersions),
    FORMAT("format", "1009", new MessageFormat(cl_2.a("format")), null, dp_2.AllVersions){

        @Override
        public final cv_2 a(String string, JsonNode jsonNode, cp_2 cp_22, df_2 df_22) {
            throw new UnsupportedOperationException("Use FormatKeyword instead");
        }
    }
    ,
    ITEMS("items", "1010", new MessageFormat(cl_2.a("items")), cn_2.class, dp_2.MaxV201909),
    MAXIMUM("maximum", "1011", new MessageFormat(cl_2.a("maximum")), ca_1.class, dp_2.AllVersions),
    MAX_ITEMS("maxItems", "1012", new MessageFormat(cl_2.a("maxItems")), cx_2.class, dp_2.AllVersions),
    MAX_LENGTH("maxLength", "1013", new MessageFormat(cl_2.a("maxLength")), cy_2.class, dp_2.AllVersions),
    MAX_PROPERTIES("maxProperties", "1014", new MessageFormat(cl_2.a("maxProperties")), cz_2.class, dp_2.AllVersions),
    MINIMUM("minimum", "1015", new MessageFormat(cl_2.a("minimum")), ce_1.class, dp_2.AllVersions),
    MIN_ITEMS("minItems", "1016", new MessageFormat(cl_2.a("minItems")), cb_1.class, dp_2.AllVersions),
    MIN_LENGTH("minLength", "1017", new MessageFormat(cl_2.a("minLength")), cc_1.class, dp_2.AllVersions),
    MIN_PROPERTIES("minProperties", "1018", new MessageFormat(cl_2.a("minProperties")), cd_1.class, dp_2.AllVersions),
    MULTIPLE_OF("multipleOf", "1019", new MessageFormat(cl_2.a("multipleOf")), cf_1.class, dp_2.AllVersions),
    NOT_ALLOWED("notAllowed", "1033", new MessageFormat(cl_2.a("notAllowed")), ch_1.class, dp_2.AllVersions),
    NOT("not", "1020", new MessageFormat(cl_2.a("not")), ci_1.class, dp_2.AllVersions),
    ONE_OF("oneOf", "1022", new MessageFormat(cl_2.a("oneOf")), cj_1.class, dp_2.AllVersions),
    PATTERN_PROPERTIES("patternProperties", "1024", new MessageFormat(cl_2.a("patternProperties")), cl_1.class, dp_2.AllVersions),
    PATTERN("pattern", "1023", new MessageFormat(cl_2.a("pattern")), cm_1.class, dp_2.AllVersions),
    PREFIX_ITEMS("prefixItems", "1048", new MessageFormat(cl_2.a("prefixItems")), cn_1.class, dp_2.MinV202012),
    PROPERTIES("properties", "1025", new MessageFormat(cl_2.a("properties")), co_1.class, dp_2.AllVersions),
    READ_ONLY("readOnly", "1032", new MessageFormat(cl_2.a("readOnly")), cq_1.class, dp_2.AllVersions),
    REF("$ref", "1026", new MessageFormat(cl_2.a("$ref")), cr_1.class, dp_2.AllVersions),
    REQUIRED("required", "1028", new MessageFormat(cl_2.a("required")), cs_1.class, dp_2.AllVersions),
    TYPE("type", "1029", new MessageFormat(cl_2.a("type")), da_2.class, dp_2.AllVersions),
    UNION_TYPE("unionType", "1030", new MessageFormat(cl_2.a("unionType")), dd_2.class, dp_2.AllVersions),
    UNIQUE_ITEMS("uniqueItems", "1031", new MessageFormat(cl_2.a("uniqueItems")), de_2.class, dp_2.AllVersions),
    DATETIME("dateTime", "1034", new MessageFormat(cl_2.a("dateTime")), null, dp_2.AllVersions),
    UUID("uuid", "1035", new MessageFormat(cl_2.a("uuid")), null, dp_2.AllVersions),
    ID("id", "1036", new MessageFormat(cl_2.a("id")), null, dp_2.AllVersions),
    IF_THEN_ELSE("if", "1037", null, cm_2.class, dp_2.MinV7),
    EXCLUSIVE_MAXIMUM("exclusiveMaximum", "1038", new MessageFormat(cl_2.a("exclusiveMaximum")), cf_2.class, dp_2.MinV6),
    EXCLUSIVE_MINIMUM("exclusiveMinimum", "1039", new MessageFormat(cl_2.a("exclusiveMinimum")), cg_2.class, dp_2.MinV6),
    TRUE("true", "1040", null, cy_1.class, dp_2.MinV6),
    FALSE("false", "1041", new MessageFormat(cl_2.a("false")), ch_2.class, dp_2.MinV6),
    CONST("const", "1042", new MessageFormat(cl_2.a("const")), bw_1.class, dp_2.MinV6),
    CONTAINS("contains", "1043", new MessageFormat(cl_2.a("contains")), bx_1.class, dp_2.MinV6),
    PROPERTYNAMES("propertyNames", "1044", new MessageFormat(cl_2.a("propertyNames")), cp_1.class, dp_2.MinV6),
    DEPENDENT_REQUIRED("dependentRequired", "1045", new MessageFormat(cl_2.a("dependentRequired")), cb_2.class, dp_2.MinV201909),
    DEPENDENT_SCHEMAS("dependentSchemas", "1046", new MessageFormat(cl_2.a("dependentSchemas")), cc_2.class, dp_2.MinV201909),
    UNEVALUATED_PROPERTIES("unevaluatedProperties", "1047", new MessageFormat(cl_2.a("unevaluatedProperties")), dc_2.class, dp_2.MinV6);

    private static Map<String, dj_2> constants;
    private static cu_1 specVersion;
    private final String value;
    private final String errorCode;
    private final MessageFormat messageFormat;
    private String customMessage;
    private final String errorCodeKey;
    private final Class<?> validator;
    private final long versionCode;

    private dj_2(String string2, String string3, MessageFormat messageFormat, Class<?> clazz, dp_2 dp_22) {
        this.value = string2;
        this.errorCode = string3;
        this.messageFormat = messageFormat;
        this.errorCodeKey = string2 + "ErrorCode";
        this.validator = clazz;
        this.versionCode = dp_22.a();
        this.customMessage = null;
    }

    public static List<dj_2> a(cu_1.a a2) {
        ArrayList<dj_2> arrayList = new ArrayList<dj_2>();
        for (dj_2 dj_22 : dj_2.values()) {
            if (FORMAT.equals(dj_22) || !specVersion.a(dj_22.versionCode).contains((Object)a2)) continue;
            arrayList.add(dj_22);
        }
        return arrayList;
    }

    public static dj_2 b(String string) {
        dj_2 dj_22 = constants.get(string);
        if (dj_22 == null) {
            throw new IllegalArgumentException(string);
        }
        return dj_22;
    }

    @Override
    public cv_2 a(String string, JsonNode jsonNode, cp_2 cp_22, df_2 df_22) {
        if (this.validator == null) {
            throw new UnsupportedOperationException("No suitable validator for " + this.a());
        }
        Constructor<?> constructor = this.validator.getConstructor(String.class, JsonNode.class, cp_2.class, df_2.class);
        return (cv_2)constructor.newInstance(string + "/" + this.a(), jsonNode, cp_22, df_22);
    }

    public String toString() {
        return this.value;
    }

    @Override
    public String a() {
        return this.value;
    }

    @Override
    public String b_() {
        return this.errorCode;
    }

    @Override
    public MessageFormat b() {
        return this.messageFormat;
    }

    @Override
    public void a(String string) {
        this.customMessage = string;
    }

    @Override
    public String c() {
        return this.customMessage;
    }

    public String d() {
        return this.errorCodeKey;
    }

    public long e() {
        return this.versionCode;
    }

    static {
        constants = new HashMap<String, dj_2>();
        specVersion = new cU();
        for (dj_2 dj_22 : dj_2.values()) {
            constants.put(dj_22.value, dj_22);
        }
    }
}

