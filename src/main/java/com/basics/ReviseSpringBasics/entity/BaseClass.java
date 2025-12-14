

package com.basics.ReviseSpringBasics.entity;

import com.fasterxml.jackson.annotation.JsonInclude; // Move this to DTO ideally, but ok here if you insist
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Getter
@Setter
@MappedSuperclass
// Keep this listener ONLY for 'createdBy' and 'modifiedBy'
@EntityListeners(AuditingEntityListener.class)
public abstract class BaseClass {

    // --- DATES (Manual Control) ---

    // Remove @CreatedDate so Spring doesn't touch it automatically
    @Column(updatable = false)
    private LocalDateTime createdAt;

    // Remove @LastModifiedDate so Spring doesn't touch it automatically
    private LocalDateTime modifiedAt;

    // --- USERS (Let Spring Handle This) ---

    @CreatedBy
    @Column(updatable = false)
    private String createdBy;

    @LastModifiedBy
    private String modifiedBy; // Allow this to update normally

    // --- LIFECYCLE HOOKS ---

    @PrePersist
    public void onCreate() {
        this.createdAt = LocalDateTime.now();
        this.modifiedAt = null;
        this.modifiedBy = null;
    }


    @PreUpdate
    public void onUpdate() {
        this.modifiedAt = LocalDateTime.now();
    }
}