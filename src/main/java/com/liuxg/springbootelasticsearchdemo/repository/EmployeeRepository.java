package com.liuxg.springbootelasticsearchdemo.repository;

import com.liuxg.springbootelasticsearchdemo.document.Employee;
import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

public interface EmployeeRepository extends ElasticsearchRepository<Employee, String> {
    List<Employee> findAllByName(String name);

    @Query("{\"match\":{\"name\":\"?0\"}}")
    List<Employee> findAllByNameUsingAnnotations(String name);
}
