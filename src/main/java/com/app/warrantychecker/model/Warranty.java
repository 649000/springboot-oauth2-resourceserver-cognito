package com.app.warrantychecker.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
//import javax.validation.constraints.NotBlank;
//import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@EntityListeners(AuditingEntityListener.class)
public class Warranty {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long warrantyID;

    @CreatedDate
    private LocalDate createdDate;

    @LastModifiedDate
    private LocalDate modifiedDate;

    @Column(nullable = false)
    private String productBrand;

    @Column(nullable = false)
    private String productName;

    private String productSerialNumber;

    @Column(nullable = false)
    private LocalDate dateOfPurchase;

    // @Column(nullable = false)
    // private LocalDate endDate;

    //Duration in years
    private double duration;

    //duration in months
    private double monthDuration;

    

    private String placeOfPurchase;

    private String additionalInfo;

    private String imageReceipt;

    // One User have Many Warranties
//    The @ManyToOne association uses FetchType.LAZY because, otherwise, we’d fall back to EAGER fetching which is bad for performance.
    // @ManyToOne
    // private User user;

}
