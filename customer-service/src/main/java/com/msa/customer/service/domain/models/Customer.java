package com.msa.customer.service.domain.models;

import com.msa.customer.service.domain.enums.GenreEnum;
import lombok.Data;
import java.time.OffsetDateTime;

@Data
public class Customer {

    private Integer id;

    private String identification;

    private String firstName;

    private String lastName;

    private GenreEnum genre;

    private String createUser;

    private Boolean active;

    private OffsetDateTime createDate;
}
