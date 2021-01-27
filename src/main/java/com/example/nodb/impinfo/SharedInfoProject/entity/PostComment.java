package com.example.nodb.impinfo.SharedInfoProject.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "post_comment")
@Getter
@Setter
public class PostComment {

    @Id
    @GeneratedValue
    @Column(columnDefinition = "uuid",updatable = false)
    private UUID key;

    @Column(name="id")
    private Integer id;

    @Column(name="review")
    private String review;

    @CreationTimestamp
    private Date creationDate;

    @UpdateTimestamp
    private Date modifiedDate;

    public PostComment(String review) {
        this.review=review;
    }
    public PostComment() {
    }

    //Constructors, getters and setters removed for brevity
}
