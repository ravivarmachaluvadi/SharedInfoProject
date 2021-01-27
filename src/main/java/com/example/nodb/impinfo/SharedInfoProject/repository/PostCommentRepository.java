package com.example.nodb.impinfo.SharedInfoProject.repository;

import com.example.nodb.impinfo.SharedInfoProject.entity.PostComment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.UUID;


@Repository
public interface PostCommentRepository
        extends JpaRepository<PostComment, UUID> {

    Optional<PostComment> findById(Long id);

    @Transactional
     void deleteById(Long id);
 
}