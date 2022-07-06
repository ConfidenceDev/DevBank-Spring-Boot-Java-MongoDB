package com.confidencedev.dao;

import com.confidencedev.models.DevBankUser;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DevBankRepo
        extends MongoRepository<DevBankUser, String> {
    Optional<DevBankUser> findDevBankByEmail(String email);
}
