package com.app.warrantychecker.model;

import io.crnk.core.resource.annotations.JsonApiField;
import io.crnk.core.resource.annotations.JsonApiId;
import io.crnk.core.resource.annotations.JsonApiRelation;
import io.crnk.core.resource.annotations.JsonApiResource;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@EntityListeners(AuditingEntityListener.class)
@JsonApiResource(type = "warranty")
public class Warranty {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonApiId
    private long warrantyID;

    @CreatedDate
    @JsonApiField
    private LocalDate createdDate;

    @LastModifiedDate
    @JsonApiField
    private LocalDate modifiedDate;

    @Column(nullable = false)
    @NotBlank
    @NotNull
    @JsonApiField
    private String productBrand;

    @Column(nullable = false)
    @NotNull
    @NotBlank
    @JsonApiField
    private String productName;

    @JsonApiField
    private String productSerialNumber;

    @Column(nullable = false)
    @NotNull
    @JsonApiField
    private LocalDate dateOfPurchase;

    @Column(nullable = false)
    @NotNull
    @JsonApiField
    private LocalDate endDate;

    @JsonApiField
    private String placeOfPurchase;

    // One User have Many Warranties
//    The @ManyToOne association uses FetchType.LAZY because, otherwise, we’d fall back to EAGER fetching which is bad for performance.
    @ManyToOne
    @JsonApiRelation
    private User user;

}
