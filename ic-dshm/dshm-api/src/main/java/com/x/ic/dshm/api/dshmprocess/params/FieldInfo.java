package com.x.ic.dshm.api.dshmprocess.params;

import java.io.Serializable;

/**
 * Created by wangyongxin on 2016/4/1.
 */
public class FieldInfo implements Serializable{
    private String fieldName;
    private String fieldType;
    private boolean isPrimary;
    private boolean supportIndex;
    private boolean asIndex;
    private String comment;

    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    public String getFieldType() {
        return fieldType;
    }

    public void setFieldType(String fieldType) {
        this.fieldType = fieldType;
    }

    public boolean isPrimary() {
        return isPrimary;
    }

    public void setPrimary(boolean primary) {
        isPrimary = primary;
    }

    public boolean isSupportIndex() {
        return supportIndex;
    }

    public void setSupportIndex(boolean supportIndex) {
        this.supportIndex = supportIndex;
    }

    public boolean isAsIndex() {
        return asIndex;
    }

    public void setAsIndex(boolean asIndex) {
        this.asIndex = asIndex;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
