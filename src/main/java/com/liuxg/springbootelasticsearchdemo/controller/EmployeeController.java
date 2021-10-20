package com.liuxg.springbootelasticsearchdemo.controller;

import com.liuxg.springbootelasticsearchdemo.document.Employee;
import com.liuxg.springbootelasticsearchdemo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employee")
public class EmployeeController {
    private final EmployeeService service;

    @Autowired
    public EmployeeController(EmployeeService service) {
        this.service = service;
    }

    @PostMapping
    public void save(@RequestBody final Employee employee) {
        service.save(employee);
    }

    @GetMapping("/{id}")
    public Employee findById(@PathVariable final String id) {
        return service.findById(id);
    }

    @DeleteMapping("/{id}")
    public boolean deleteById(@PathVariable String id) {
        service.deleteEmployee(id);
        return true;
    }

    @GetMapping("/name/{name}")
    public List<Employee> findAllByName(@PathVariable String name) {
        return service.findByName(name);
    }

    @GetMapping("/name/{name}/annotations")
    public List<Employee> findAllByNameAnnotations(@PathVariable String name) {
        return service.getEmployeesByNameUsingAnnotation(name);
    }
}
