package com.blgncan.enterprise.api.mapper;

import com.blgncan.enterprise.api.dto.request.DepartmentRequest;
import com.blgncan.enterprise.api.dto.response.DepartmentResponse;
import com.blgncan.enterprise.api.entity.Department;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface DepartmentMapper {
    DepartmentResponse toResponse(Department department);
    Department toEntity(DepartmentRequest request);

    void updateEntity(DepartmentRequest request,
                      @MappingTarget Department department);
}
