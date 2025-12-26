package com.basics.ReviseSpringBasics.entity;

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
@EntityListeners(AuditingEntityListener.class)
public abstract class BaseClass {

    @Column(updatable = false)
    private LocalDateTime createdAt;

    private LocalDateTime modifiedAt;

    @CreatedBy
    @Column(updatable = false)
    private String createdBy;

    @LastModifiedBy
    private String modifiedBy;

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










// with simple life cycle hooks

//
//package com.basics.ReviseSpringBasics.entity;
//
//import jakarta.persistence.*;
//import lombok.Getter;
//import lombok.Setter;
//
//import java.time.LocalDateTime;
//
//@Getter
//@Setter
//@MappedSuperclass
//public abstract class BaseClass {
//
//    @Column(updatable = false)
//    private LocalDateTime createdAt;
//
//    @Column(updatable = false)
//    private String createdBy;
//
//    private LocalDateTime modifiedAt;
//
//    private String modifiedBy;
//
//    // --- LIFECYCLE HOOKS ---
//
//    @PrePersist
//    public void onCreate() {
//        this.createdAt = LocalDateTime.now();
//        this.createdBy = getCurrentUser();
//
//        this.modifiedAt = null;
//        this.modifiedBy = null;
//    }
//
//
//    @PreUpdate
//    public void onUpdate() {
//        this.modifiedAt = LocalDateTime.now();
//        this.modifiedBy = getCurrentUser();
//    }
//
//
//    private String getCurrentUser() {
//        // return SecurityContextHolder.getContext().getAuthentication().getName();
//        return "system";
//    }
//}