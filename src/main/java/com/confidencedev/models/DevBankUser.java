package com.confidencedev.models;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Document
public class DevBankUser {

    @Id
    private String id;
    private String fullName;
    @Indexed(unique = true)
    private String email;
    private Gender gender;
    private Address address;
    private List<String> accounts;
    private BigDecimal balance;
    private LocalDateTime created;

    public DevBankUser(String fullName, String email,
                       Gender gender, Address address,
                       List<String> accounts, BigDecimal balance,
                       LocalDateTime created) {
        this.fullName = fullName;
        this.email = email;
        this.gender = gender;
        this.address = address;
        this.accounts = accounts;
        this.balance = balance;
        this.created = created;
    }
}