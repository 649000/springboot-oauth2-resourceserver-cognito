package com.app.warrantychecker.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@ToString
@Setter
@Getter
@Entity
@Table(name = "user_entity")
@EntityListeners(AuditingEntityListener.class)
public class User {

    @Id
    private String email;

    @CreatedDate
    private Date createdDate;

    @LastModifiedDate
    private Date modifiedDate;

    // mappedBy refers to the attribute User declared in Warranty.java
    // Dual sided relationship is a nightmare
    // It will create a circular reference when printing out the JSON.
//    @OneToMany(
//            mappedBy = "user",
//            cascade = CascadeType.ALL,
//            orphanRemoval = true,
//            fetch = FetchType.LAZY
//    )
//    private List<Warranty> warranties;
}
