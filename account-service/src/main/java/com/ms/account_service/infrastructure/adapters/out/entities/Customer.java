package com.ms.account_service.infrastructure.adapters.out.entities;
import lombok.Data;

@Data
public class Customer {
    private Integer id;
    private String identification;
    private String firstName;
    private String lastName;
    private GenreEnum genre;
}
