package com.blgncan.enterprise.api.service;

import com.blgncan.enterprise.api.dto.request.DepartmentRequest;
import com.blgncan.enterprise.api.dto.response.DepartmentResponse;

import java.util.List;

public interface DepartmentService {

    DepartmentResponse getDepartmentById(Long id);

    List<DepartmentResponse> getAllDepartments();

    DepartmentResponse createDepartment(DepartmentRequest request);

    DepartmentResponse updateDepartment(Long id,DepartmentRequest request);

    void deleteDepartment(Long id);
}
