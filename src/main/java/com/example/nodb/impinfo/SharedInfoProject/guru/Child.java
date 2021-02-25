package com.example.nodb.impinfo.SharedInfoProject.guru;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Child {


    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("PresentHeaderName")
    @Expose
    private String presentHeaderName;
    @SerializedName("field")
    @Expose
    private String field;
    @SerializedName("header")
    @Expose
    private String header;
    @SerializedName("ParentHeaderName")
    @Expose
    private String parentHeaderName;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPresentHeaderName() {
        return presentHeaderName;
    }

    public void setPresentHeaderName(String presentHeaderName) {
        this.presentHeaderName = presentHeaderName;
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public String getParentHeaderName() {
        return parentHeaderName;
    }

    public void setParentHeaderName(String parentHeaderName) {
        this.parentHeaderName = parentHeaderName;
    }

    @Override
    public String toString() {
        return "Child{" +
                "id=" + id +
                ", presentHeaderName='" + presentHeaderName + '\'' +
                ", field='" + field + '\'' +
                ", header='" + header + '\'' +
                ", parentHeaderName='" + parentHeaderName + '\'' +
                '}';
    }
}