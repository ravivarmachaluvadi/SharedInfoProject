package com.example.nodb.impinfo.SharedInfoProject.guru;

import java.util.List;
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
@SerializedName("filed")
@Expose
private String filed;
@SerializedName("values")
@Expose
private List<Object> values = null;
@SerializedName("child")
@Expose
private List<Child> child = null;
@SerializedName("fields")
@Expose
private String fields;

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

public String getFiled() {
return filed;
}

public void setFiled(String filed) {
this.filed = filed;
}

public List<Object> getValues() {
return values;
}

public void setValues(List<Object> values) {
this.values = values;
}

public List<Child> getChild() {
return child;
}

public void setChild(List<Child> child) {
this.child = child;
}

public String getFields() {
return fields;
}

public void setFields(String fields) {
this.fields = fields;
}

}