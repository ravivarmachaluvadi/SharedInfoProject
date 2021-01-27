package com.example.nodb.impinfo.SharedInfoProject.util;

import com.example.nodb.impinfo.SharedInfoProject.entity.EmployeeEntity;
import com.example.nodb.impinfo.SharedInfoProject.entity.PostEntity;
import org.springframework.stereotype.Component;

@Component
public class SharedObject {

    EmployeeEntity employeeEntity=new EmployeeEntity();

    PostEntity posteEntity=new PostEntity();

    public EmployeeEntity getEmployeeEntity() {
        return employeeEntity;
    }

    public PostEntity getPostEntity() {
        return posteEntity;
    }

    public void setPostEntity(PostEntity posteEntity) {
        this.posteEntity = posteEntity;
    }

    public void setEmployeeEntity(EmployeeEntity employeeEntity) {
        this.employeeEntity = employeeEntity;
    }
}
