package com.blgncan.enterprise.api.service.impl;

import com.blgncan.enterprise.api.dto.request.DepartmentRequest;
import com.blgncan.enterprise.api.dto.response.DepartmentResponse;
import com.blgncan.enterprise.api.entity.Department;
import com.blgncan.enterprise.api.exception.ResourceNotFoundException;
import com.blgncan.enterprise.api.mapper.DepartmentMapper;
import com.blgncan.enterprise.api.repository.DepartmentRepository;
import com.blgncan.enterprise.api.service.DepartmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {

    private final DepartmentRepository repository;
    private final DepartmentMapper mapper;

    @Override
    public DepartmentResponse getDepartmentById(Long id) {
        Department department = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Department not found"));

        return mapper.toResponse(department);
    }

    @Override
    public List<DepartmentResponse> getAllDepartments() {
        return repository.findAll()
                .stream()
                .map(mapper::toResponse)
                .toList();
    }

    @Override
    public DepartmentResponse createDepartment(DepartmentRequest request) {
        Department department = mapper.toEntity(request);
        Department saved = repository.save(department);
        return mapper.toResponse(saved);
    }

    @Override
    public DepartmentResponse updateDepartment(Long id, DepartmentRequest request) {
        Department department = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Department not found"));

        mapper.updateEntity(request, department);

        Department updated = repository.save(department);
        return mapper.toResponse(updated);
    }

    @Override
    public void deleteDepartment(Long id) {
        Department department=repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Department not found"));
        repository.delete(department);
    }




}
