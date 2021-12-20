package com.app.warrantychecker.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import java.time.LocalDate;

@Getter
@Setter
public class Warranty {


    private long warrantyID;

    @CreatedDate
    private LocalDate createdDate;

    @LastModifiedDate
    private LocalDate modifiedDate;


    private String productBrand;


    private String productName;

    private String productSerialNumber;


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
