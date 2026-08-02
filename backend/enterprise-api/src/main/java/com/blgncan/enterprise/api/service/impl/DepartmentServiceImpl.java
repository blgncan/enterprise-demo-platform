package com.blgncan.enterprise.api.service.impl;

import com.blgncan.enterprise.api.dto.request.DepartmentRequest;
import com.blgncan.enterprise.api.dto.response.DepartmentResponse;
import com.blgncan.enterprise.api.entity.Department;
import com.blgncan.enterprise.api.exception.ResourceNotFoundException;
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
        Department department = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Department not found"));

        return toResponse(department);
    }

    @Override
    public List<DepartmentResponse> getAllDepartments() {
        return repository.findAll()
                .stream()
                .map(this::toResponse)
                .toList();
    }

    @Override
    public DepartmentResponse createDepartment(DepartmentRequest request) {
        Department department = new Department();
        department.setName(request.getName());
        department.setDescription(request.getDescription());

        Department saved = repository.save(department);
        return toResponse(saved);
    }

    @Override
    public DepartmentResponse updateDepartment(Long id, DepartmentRequest request) {
        Department department = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Department not found"));

        department.setName(request.getName());
        department.setDescription(request.getDescription());

        Department updated = repository.save(department);
        return toResponse(updated);
    }

    @Override
    public void deleteDepartment(Long id) {
        Department department=repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Department not found"));
        repository.delete(department);
    }

    private DepartmentResponse toResponse(Department department) {
        return new DepartmentResponse(
                department.getId(),
                department.getName(),
                department.getDescription()
        );
    }


}
