package com.example.nodb.impinfo.SharedInfoProject.pojo;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Post {

@SerializedName("id")
@Expose
private Integer id;
@SerializedName("title")
@Expose
private String title;
@SerializedName("comments")
@Expose
private List<Comment> comments = null;

public Integer getId() {
return id;
}

public void setId(Integer id) {
this.id = id;
}

public String getTitle() {
return title;
}

public void setTitle(String title) {
this.title = title;
}

public List<Comment> getComments() {
return comments;
}

public void setComments(List<Comment> comments) {
this.comments = comments;
}

}