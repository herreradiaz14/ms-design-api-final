package com.msa.customer.service.infrastructure.adapters.out.entities;

import com.msa.customer.service.infrastructure.adapters.out.enums.GenreEnumEntity;
import jakarta.persistence.*;
import lombok.Data;
import java.time.OffsetDateTime;

@Data
@Entity
@Table(name = "T_CUSTOMERS")
public class CustomerEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ctr_id", nullable = false)
    private Integer id;

    @Column(name = "ctr_dni", nullable = false, unique = true)
    private String identification;

    @Column(name = "ctr_f_name", nullable = false)
    private String firstName;

    @Column(name = "ctr_l_name", nullable = false)
    private String lastName;

    @Enumerated(EnumType.STRING)
    @Column(name = "ctr_genre", nullable = false)
    private GenreEnumEntity genre;

    @Column(name = "ctr_create_user", nullable = true)
    private String createUser;

    @Column(name = "ctr_active")
    private Boolean active;

    @Column(name = "ctr_create_date", nullable = true)
    private OffsetDateTime createDate;

    @PrePersist
    protected void onCreate() {
        this.createDate = OffsetDateTime.now();
        this.active = true;
    }
}
