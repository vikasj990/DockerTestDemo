package com.iceye.sbdb.pojo;

import java.util.Arrays;
import java.util.HashMap;

public enum Fields {
    DES(0, "des"),
    ORBIT_ID(1, "orbit_id"),
    JD(2, "jd"),
    CD(3, "cd"),
    DIST(4, "dist"),
    DIST_MIN(5, "dist_min"),
    DIST_MAX(6, "dist_max"),
    V_REL(7, "v_rel"),
    V_INF(8, "v_inf"),
    T_SIGMA_F(9, "t_sigma_f"),
    H(10, "h");

    final String fieldName;
    final int fieldIndex;

    Fields(int fieldIndex, String field) {
        fieldName = field;
        this.fieldIndex = fieldIndex;
    }

    private static HashMap<Integer, Fields> enumById = new HashMap<>();

    static {
        Arrays.stream(values()).forEach(e -> enumById.put(e.getFieldIndex(), e));
    }

    public Integer getFieldIndex() {
        return this.fieldIndex;
    }

    public String getFieldName() {
        return fieldName;
    }

    public static Fields getById(int index) {
        return enumById.get(index);
    }

}



