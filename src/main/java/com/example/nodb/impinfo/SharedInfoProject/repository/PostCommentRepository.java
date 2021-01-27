package com.example.nodb.impinfo.SharedInfoProject.repository;

import com.example.nodb.impinfo.SharedInfoProject.entity.PostComment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.UUID;


@Repository
public interface PostCommentRepository
        extends JpaRepository<PostComment, UUID> {

    Optional<PostComment> findById(Integer id);

    @Transactional
     void deleteById(Integer id);

    @Modifying
    @Transactional
    @Query(value = "delete from post_comment where id =:id",nativeQuery = true)
    void deleteRecord(@Param("id") Integer id);
 
}
