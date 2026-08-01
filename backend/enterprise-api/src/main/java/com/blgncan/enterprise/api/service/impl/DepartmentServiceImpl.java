package com.blgncan.enterprise.api.service.impl;

import com.blgncan.enterprise.api.dto.response.DepartmentResponse;
import com.blgncan.enterprise.api.entity.Department;
import com.blgncan.enterprise.api.repository.DepartmentRepository;
import com.blgncan.enterprise.api.service.DepartmentService;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor


public class DepartmentServiceImpl implements DepartmentService {

    private final DepartmentRepository repository;

    @Override
    public DepartmentResponse getDepartmentById(Long id) {
        Department department = repository.findById(id).orElseThrow(()->new RuntimeException("Department not found"));


        return new DepartmentResponse(
                department.getId(),
                department.getName(),
                department.getDescription()
        );
    }

    @Override
    public List<DepartmentResponse> getAllDepartments() {

        return repository.findAll()
                .stream()
                .map(department ->
                        new DepartmentResponse(
                                department.getId(),
                                department.getName(),
                                department.getDescription()
                        ))
                .toList();
    }

}
