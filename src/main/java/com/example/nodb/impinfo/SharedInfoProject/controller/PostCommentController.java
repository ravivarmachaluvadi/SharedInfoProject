package com.example.nodb.impinfo.SharedInfoProject.controller;

import com.example.nodb.impinfo.SharedInfoProject.exception.RecordNotFoundException;
import com.example.nodb.impinfo.SharedInfoProject.repository.PostCommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/postcomments")
public class PostCommentController {

    @Autowired
    PostCommentRepository postCommentRepository;

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteEmployeeById(@PathVariable("id") Integer id)
            throws RecordNotFoundException {
        //postCommentRepository.deleteRecord(id);
        postCommentRepository.deleteById(id);

        return new ResponseEntity<String>("The record with id "+id+" deleted successfully", new HttpHeaders(), HttpStatus.OK);
    }

}
