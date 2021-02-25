package com.example.nodb.impinfo.SharedInfoProject.guru;

import java.util.List;
import java.util.Set;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
public class Parent {


    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("field")
    @Expose
    private String field;
    @SerializedName("header")
    @Expose
    private String header;
    @SerializedName("child")
    @Expose
    private Set<Child> child = null;
    @SerializedName("values")
    @Expose
    private List<Object> values = null;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Set<Child> getChild() {
        return child;
    }

    public void setChild(Set<Child> child) {
        this.child = child;
    }

    public List<Object> getValues() {
        return values;
    }

    public void setValues(List<Object> values) {
        this.values = values;
    }

    @Override
    public String toString() {
        return "Parent{" +
                "id=" + id +
                ", field='" + field + '\'' +
                ", header='" + header + '\'' +
                ", child=" + child +
                ", values=" + values +
                '}';
    }
}