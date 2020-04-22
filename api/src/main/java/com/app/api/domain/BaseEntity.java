package com.app.api.domain;

import lombok.Getter;

import javax.persistence.*;
import java.time.LocalDate;

/**
 * Base Entity to Table
 * seq not update to role
 *
 * @author jkpark 20/20/01/31
 */
@Getter
@MappedSuperclass
public class BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "seq" , nullable = false)
    private Long seq;

    @Column(updatable = false , nullable = false)
    protected LocalDate createdAt;
    @Column(nullable = false)
    protected LocalDate updatedAt;

    @PrePersist
    protected void onPersist() {
        this.createdAt = this.updatedAt = LocalDate.now();
    }

    @PreUpdate
    protected void onUpdate() {
        this.updatedAt = LocalDate.now();
    }

}
