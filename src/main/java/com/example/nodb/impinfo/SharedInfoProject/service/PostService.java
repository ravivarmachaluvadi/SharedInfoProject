package com.example.nodb.impinfo.SharedInfoProject.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.example.nodb.impinfo.SharedInfoProject.entity.PostEntity;
import com.example.nodb.impinfo.SharedInfoProject.exception.RecordNotFoundException;
import com.example.nodb.impinfo.SharedInfoProject.repository.PostRepository;
import com.example.nodb.impinfo.SharedInfoProject.util.SharedObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostService {

    @Autowired
    SharedObject sharedObject;
     
    @Autowired
    PostRepository repository;
     
    public List<PostEntity> getAllPosts()
    {
        List<PostEntity> PostList = repository.findAll();
         
        if(PostList.size() > 0) {
            return PostList;
        } else {
            return new ArrayList<PostEntity>();
        }
    }
     
    public PostEntity getPostById(Integer id) throws RecordNotFoundException
    {
        Optional<PostEntity> Post = repository.findById(id);
         
        if(Post.isPresent()) {
            return Post.get();
        } else {
            throw new RecordNotFoundException("No PostEntity record exist for given id");
        }
    }
     
    public PostEntity createOrUpdatePost(PostEntity entity) throws RecordNotFoundException
    {
        Optional<PostEntity> Post = repository.findById(entity.getId());
         
        if(Post.isPresent())
        {
            PostEntity newEntity = Post.get();
 
            newEntity = repository.save(newEntity);
             
            return newEntity;
        } else {
            entity = repository.save(entity);
             
            return entity;
        }
    } 
     
    public void deletePostById(Integer id) throws RecordNotFoundException
    {
        Optional<PostEntity> Post = repository.findById(id);
         
        if(Post.isPresent())
        {
            repository.deleteById(id);
        } else {
            throw new RecordNotFoundException("No PostEntity record exist for given id");
        }
    } 
}