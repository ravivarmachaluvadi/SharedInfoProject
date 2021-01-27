package com.example.nodb.impinfo.SharedInfoProject.repository;

import com.example.nodb.impinfo.SharedInfoProject.entity.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.UUID;


@Repository
public interface EmployeeRepository 
        extends JpaRepository<EmployeeEntity, UUID> {

    Optional<EmployeeEntity> findById(Integer id);

    @Transactional
     void deleteById(Integer id);

    Optional<EmployeeEntity> findByFirstNameAndLastName(String firstName,String lastName);
 
}