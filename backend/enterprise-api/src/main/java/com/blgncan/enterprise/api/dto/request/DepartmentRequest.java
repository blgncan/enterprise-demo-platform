package com.blgncan.enterprise.api.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class DepartmentRequest {

    @Schema(
            description = "Department name",
            example = "Information Technology"
    )
    @NotBlank(message = "Department name is required")
    @Size(max = 100, message = "Department name cannot exceed 100 characters")
    private String name;


    @Schema(
            description = "Department description",
            example = "Handles software development"
    )
    @Size(max = 500, message = "Department description cannot exceed 500 characters")
    @NotBlank(message = "Department description is required")
    private String description;
}
