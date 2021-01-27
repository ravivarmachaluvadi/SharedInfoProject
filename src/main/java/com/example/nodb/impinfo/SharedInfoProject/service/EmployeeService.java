package com.example.nodb.impinfo.SharedInfoProject.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.example.nodb.impinfo.SharedInfoProject.entity.EmployeeEntity;
import com.example.nodb.impinfo.SharedInfoProject.exception.RecordNotFoundException;
import com.example.nodb.impinfo.SharedInfoProject.repository.EmployeeRepository;
import com.example.nodb.impinfo.SharedInfoProject.util.SharedObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

    @Autowired
    SharedObject sharedObject;
     
    @Autowired
    EmployeeRepository repository;
     
    public List<EmployeeEntity> getAllEmployees()
    {
        List<EmployeeEntity> employeeList = repository.findAll();
         
        if(employeeList.size() > 0) {
            return employeeList;
        } else {
            return new ArrayList<EmployeeEntity>();
        }
    }
     
    public EmployeeEntity getEmployeeById(Integer id) throws RecordNotFoundException
    {
        Optional<EmployeeEntity> employee = repository.findById(id);
         
        if(employee.isPresent()) {
            return employee.get();
        } else {
            throw new RecordNotFoundException("No employee record exist for given id");
        }
    }
     
    public EmployeeEntity createOrUpdateEmployee(EmployeeEntity entity) throws RecordNotFoundException 
    {
        Optional<EmployeeEntity> employee = repository.findById(entity.getId());

        sharedObject.getEmployeeEntity().setEmail("ravivarmachaluvadi@gmail.com");
        sharedObject.getEmployeeEntity().setId(221);
         
        if(employee.isPresent()) 
        {
            EmployeeEntity newEntity = employee.get();
            newEntity.setEmail(entity.getEmail());
            newEntity.setFirstName(entity.getFirstName());
            newEntity.setLastName(entity.getLastName());
 
            newEntity = repository.save(newEntity);
             
            return newEntity;
        } else {
            entity = repository.save(entity);
             
            return entity;
        }
    } 
     
    public void deleteEmployeeById(Integer id) throws RecordNotFoundException
    {
        Optional<EmployeeEntity> employee = repository.findById(id);
         
        if(employee.isPresent()) 
        {
            repository.deleteById(id);
        } else {
            throw new RecordNotFoundException("No employee record exist for given id");
        }
    } 
}