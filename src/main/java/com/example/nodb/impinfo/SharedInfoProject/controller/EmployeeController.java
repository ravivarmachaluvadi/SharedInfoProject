package com.example.nodb.impinfo.SharedInfoProject.controller;

import java.util.List;
import java.util.Optional;

import com.example.nodb.impinfo.SharedInfoProject.entity.EmployeeEntity;
import com.example.nodb.impinfo.SharedInfoProject.exception.RecordNotFoundException;
import com.example.nodb.impinfo.SharedInfoProject.repository.EmployeeRepository;
import com.example.nodb.impinfo.SharedInfoProject.service.EmployeeService;
import com.example.nodb.impinfo.SharedInfoProject.util.SharedObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/employees")
public class EmployeeController 
{
    @Autowired
    EmployeeService service;

    @Autowired
    SharedObject sharedObject;

    @Autowired
    EmployeeRepository employeeRepository;

 
    @GetMapping
    public ResponseEntity<List<EmployeeEntity>> getAllEmployees() {
        List<EmployeeEntity> list = service.getAllEmployees();
 
        return new ResponseEntity<List<EmployeeEntity>>(list, new HttpHeaders(), HttpStatus.OK);
    }
 
    @GetMapping("/{id}")
    public ResponseEntity<EmployeeEntity> getEmployeeById(@PathVariable("id") Integer id)
                                                    throws RecordNotFoundException {
        EmployeeEntity entity = service.getEmployeeById(id);
 
        return new ResponseEntity<EmployeeEntity>(entity, new HttpHeaders(), HttpStatus.OK);
    }

    @GetMapping("name/{firstName}")
    public ResponseEntity<EmployeeEntity> getEmployeeById(@PathVariable("firstName") String firstName,@RequestParam("lastName") String lastName)
            throws RecordNotFoundException {
        Optional<EmployeeEntity> entity = employeeRepository.findByFirstNameAndLastName(firstName,lastName);

        return new ResponseEntity<EmployeeEntity>(entity.get(), new HttpHeaders(), HttpStatus.OK);
    }
 
    @PostMapping
    public ResponseEntity<String> createOrUpdateEmployee(@RequestBody EmployeeEntity employee)
                                                    throws RecordNotFoundException {
        //EmployeeEntity updated = service.createOrUpdateEmployee(employee);
        //ApacheCamel API vs RESTFul API (against data object sharing)
/*
        sharedObject.getEmployeeEntity().setFirstName("Ravi");
        sharedObject.getEmployeeEntity().setLastName("Varma");*/
        //EmployeeEntity updated = service.createOrUpdateEmployee(sharedObject.getEmployeeEntity());

        EmployeeEntity updated = service.createOrUpdateEmployee(employee);
        return new ResponseEntity<String>("This is \n customised response", new HttpHeaders(), HttpStatus.CREATED);
    }
 
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteEmployeeById(@PathVariable("id") Integer id)
                                                    throws RecordNotFoundException {
        service.deleteEmployeeById(id);
        return new ResponseEntity<String>("The record with id "+id+" deleted successfully", new HttpHeaders(), HttpStatus.OK);
    }
 
}