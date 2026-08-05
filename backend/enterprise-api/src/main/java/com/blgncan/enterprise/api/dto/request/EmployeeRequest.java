package com.blgncan.enterprise.api.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeRequest {

    @Schema(
            description = "Employee first name",
            example = "Bilgin"
    )
    @NotBlank(message = "First name is required")
    private String firstName;


    @Schema(
            description = "Employee last name",
            example = "Can"
    )
    @NotBlank(message = "Last name is required")
    private String lastName;


    @Schema(
            description = "Employee email address",
            example = "bilgin@example.com"
    )
    @Email(message = "Invalid email")
    @NotBlank(message = "Email is required")
    private String email;


    @Schema(
            description = "Employee salary",
            example = "75000"
    )
    @NotNull(message = "Salary is required")
    private BigDecimal salary;


    @Schema(
            description = "Department id",
            example = "1"
    )
    @NotNull(message = "Department id is required")
    private Long departmentId;
}
