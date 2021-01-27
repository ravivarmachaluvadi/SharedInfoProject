package com.example.nodb.impinfo.SharedInfoProject.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.stereotype.Component;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;
import java.util.UUID;

@Entity
@Table(name="EMPLOYEES")
@Getter
@Setter
@ToString
@NoArgsConstructor
@Component
public class EmployeeEntity {
 
    @Id
    @GeneratedValue
    @Column(columnDefinition = "uuid",updatable = false)
    private UUID key;

    @Column(name="id")
    private Integer id;
     
    @Column(name="first_name")
    private String firstName;
     
    @Column(name="last_name")
    private String lastName;
     
    @Column(name="email", nullable=false, length=200)
    private String email;

    @CreationTimestamp
    private Date creationDate;

    @UpdateTimestamp
    private Date modifiedDate;

}