package com.app.warrantychecker.model;

import com.fasterxml.jackson.annotation.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

@ToString
@Setter
@Getter
@Entity
@Table(name = "user_entity")
@EntityListeners(AuditingEntityListener.class)
public class User {

    @Id
    @NotBlank
    @NotNull
    @NotEmpty
    @Email
    private String email;

    @CreatedDate
    private Date createdDate;

    @LastModifiedDate
    private Date modifiedDate;

    // mappedBy refers to the attribute User declared in Warranty.jaba
//    @OneToMany(
//            mappedBy = "user",
//            cascade = CascadeType.ALL,
//            orphanRemoval = true,
//            fetch = FetchType.LAZY
//    )
////    @JsonManagedReference
//    private List<Warranty> warranties;
}
