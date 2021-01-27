package com.example.nodb.impinfo.SharedInfoProject.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "post")
@Getter
@Setter
public class PostEntity {

    @Id
    @GeneratedValue
    @Column(columnDefinition = "uuid",updatable = false)
    private UUID key;

    @Column(name="id")
    private Integer id;

    @Column(name="title")
    private String title;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    //@JoinColumn(name = "post_id")
    private List<PostComment> comments = new ArrayList<>();

    public PostEntity() {

    }

    public PostEntity(String title) {
        this.title=title;
    }

    //Constructors, getters and setters removed for brevity
}
