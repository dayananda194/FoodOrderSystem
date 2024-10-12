package org.example.foodorderingservice.models;


import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.List;


import java.util.*;

@EntityListeners(AuditingEntityListener.class)
@Entity
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Builder
public class Restaurant {

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    Long id;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    String name;

    @Temporal(TemporalType.TIMESTAMP) // tells what format of date  should be stored ie time/timestamp
    @CreatedDate  // tells what value to be stored
    @Column(nullable = false)
    protected Date createdAt;



}
