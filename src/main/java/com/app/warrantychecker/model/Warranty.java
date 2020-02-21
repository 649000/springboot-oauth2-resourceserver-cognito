package com.app.warrantychecker.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Getter
@Setter
@Entity
@EntityListeners(AuditingEntityListener.class)
public class Warranty {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long warrantyID;

    @CreatedDate
    private Date createdDate;

    @LastModifiedDate
    private Date modifiedDate;

    // One User have Many Warranties
//    The @ManyToOne association uses FetchType.LAZY because, otherwise, we’d fall back to EAGER fetching which is bad for performance.
//    @ManyToOne(fetch = FetchType.LAZY)
//    private User user;

//    @Column(nullable=false)
//    private Date startDate;
//
//    @Column(nullable=false)
//    private Date endDate;
//
    @Column(nullable=false)
    @NotNull
    @NotBlank
    private String productName;
}
