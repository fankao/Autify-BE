package com.autify.be.api.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;

@MappedSuperclass
@Data
@NoArgsConstructor
public class BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "created_date")
    @CreationTimestamp
    private Timestamp createdDate;
    @Column(name = "last_updated_date")
    @UpdateTimestamp
    private Timestamp lastUpdatedDate;
    @Column(name = "last_updated_by")
    private String lastUpdatedBy;
}
