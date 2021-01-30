package com.example.nodb.impinfo.SharedInfoProject.dto;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Comment {

@SerializedName("id")
@Expose
private Integer id;
@SerializedName("review")
@Expose
private String review;

public Integer getId() {
return id;
}

public void setId(Integer id) {
this.id = id;
}

public String getReview() {
return review;
}

public void setReview(String review) {
this.review = review;
}

}