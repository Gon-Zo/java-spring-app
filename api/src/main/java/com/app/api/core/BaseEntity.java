package com.app.api.core;

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
    private long seq;

    @Column(updatable = false)
    protected LocalDate createdAt;
    @Column
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
