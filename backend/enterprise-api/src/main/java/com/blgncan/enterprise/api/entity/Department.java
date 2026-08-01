package com.blgncan.enterprise.api.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;


@Entity
@Getter
@Setter
@Table(name = "departments")
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100,unique = true)
    private String name;

    @Column(length = 500)
    private String description;

    @Column(nullable = false)
    private Boolean active=true;

    @Column(nullable = false,updatable = false)
    private LocalDateTime createdDate;

    @Column(nullable = false)
    private LocalDateTime updatedDate;


    public Department() {

    }

    @PrePersist
    public void prePersist()
    {
        LocalDateTime now = LocalDateTime.now();

        this.createdDate = now;
        this.updatedDate = now;
    }
    @PreUpdate
    public void preUpdate()
    {
        this.updatedDate = LocalDateTime.now();
    }

}
