package com.example.nodb.impinfo.SharedInfoProject.repository;

import com.example.nodb.impinfo.SharedInfoProject.entity.PostEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.UUID;


@Repository
public interface PostRepository
        extends JpaRepository<PostEntity, UUID> {

    Optional<PostEntity> findById(Integer id);

    @Transactional
     void deleteById(Integer id);
 
}