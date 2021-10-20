package com.liuxg.springbootelasticsearchdemo.service;

import com.liuxg.springbootelasticsearchdemo.document.Employee;
import com.liuxg.springbootelasticsearchdemo.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    private final EmployeeRepository repository;

    @Autowired
    public EmployeeService(EmployeeRepository repository) {
        this.repository = repository;
    }

    public void save(final Employee employee) { repository.save(employee); }
    public Employee findById(final String id) { return repository.findById(id).orElse(null); }
    public List<Employee> findByName(final String name) { return repository.findAllByName(name);}

    public List<Employee> getEmployeesByNameUsingAnnotation(String name) {
        return repository.findAllByNameUsingAnnotations(name);
    }

    public void deleteEmployee(String id) {
        repository.deleteById(id);
    }
}
