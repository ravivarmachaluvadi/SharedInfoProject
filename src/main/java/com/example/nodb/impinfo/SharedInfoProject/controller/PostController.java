package com.example.nodb.impinfo.SharedInfoProject.controller;

import java.util.ArrayList;
import java.util.List;

import com.example.nodb.impinfo.SharedInfoProject.entity.PostComment;
import com.example.nodb.impinfo.SharedInfoProject.entity.PostEntity;
import com.example.nodb.impinfo.SharedInfoProject.exception.RecordNotFoundException;
import com.example.nodb.impinfo.SharedInfoProject.dto.Comment;
import com.example.nodb.impinfo.SharedInfoProject.dto.Post;
import com.example.nodb.impinfo.SharedInfoProject.service.PostService;
import com.example.nodb.impinfo.SharedInfoProject.util.SharedObject;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/posts")
public class PostController 
{
    @Autowired
    PostService service;

    @Autowired
    SharedObject sharedObject;

 
    @GetMapping
    public ResponseEntity<List<PostEntity>> getAllPosts() {
        List<PostEntity> list = service.getAllPosts();
 
        return new ResponseEntity<List<PostEntity>>(list, new HttpHeaders(), HttpStatus.OK);
    }
 
    @GetMapping("/{id}")
    public ResponseEntity<PostEntity> getPostById(@PathVariable("id") Integer id)
                                                    throws RecordNotFoundException {
        PostEntity entity = service.getPostById(id);
 
        return new ResponseEntity<PostEntity>(entity, new HttpHeaders(), HttpStatus.OK);
    }
 
    @PostMapping
    public ResponseEntity<String> createOrUpdatePost(@RequestBody String postJsonString)
                                                    throws RecordNotFoundException {
        Post postPojo = null;
        Gson gson = new Gson();
        postPojo =gson.fromJson(postJsonString,Post.class);

        PostEntity postEntity=new PostEntity();
        postEntity.setId(postPojo.getId());
        postEntity.setTitle(postPojo.getTitle());

        List<PostComment> commentList=new ArrayList<>();

        for(Comment comment: postPojo.getComments()){
            PostComment comment1=new PostComment();
            comment1.setId(comment.getId());
            comment1.setReview(comment.getReview());
            commentList.add(comment1);
        }
        postEntity.setComments(commentList);

        PostEntity updated = service.createOrUpdatePost(postEntity);

        //PostEntity updated = service.createOrUpdatePost(sharedObject.getPosteEntity());

        return new ResponseEntity<String>("This is \n customised response", new HttpHeaders(), HttpStatus.CREATED);
    }


    @PostMapping
    @RequestMapping("/v1")
    public ResponseEntity<String> createOrUpdatePostV1(@RequestBody Post post)
            throws RecordNotFoundException {

        PostEntity postEntity=new PostEntity();
        postEntity.setId(post.getId());
        postEntity.setTitle(post.getTitle());

        List<PostComment> commentList=new ArrayList<>();

        for(Comment comment: post.getComments()){
            PostComment comment1=new PostComment();
            comment1.setId(comment.getId());
            comment1.setReview(comment.getReview());
            commentList.add(comment1);
        }
        postEntity.setComments(commentList);
        PostEntity updated = service.createOrUpdatePost(postEntity);
        return new ResponseEntity<String>("This is \n customised response", new HttpHeaders(), HttpStatus.CREATED);
    }
 
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePostById(@PathVariable("id") Integer id)
                                                    throws RecordNotFoundException {
        service.deletePostById(id);
        return new ResponseEntity<String>("The record with id "+id+" deleted successfully", new HttpHeaders(), HttpStatus.OK);
    }
 
}