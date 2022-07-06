package com.confidencedev.services;

import com.confidencedev.models.DevBankUser;
import com.confidencedev.dao.DevBankRepo;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
@Slf4j
public class DevBankService {

    private final DevBankRepo devBankRepo;
    private final MongoTemplate mongoTemplate;

    public String addCustomer(DevBankUser devBankUser){
        boolean present = devBankRepo.findDevBankByEmail(devBankUser.getEmail())
                .isPresent();

        if (present) return "User already exists";

        log.info("User creation started...");
        devBankUser.setCreated(LocalDateTime.now());
        devBankRepo.insert(devBankUser);
        return "User Add Successfully";
    }

    public List<DevBankUser> getAllCustomers(){
        return devBankRepo.findAll();
    }

    public DevBankUser getCustomer(String id) {
        Optional<DevBankUser> result = devBankRepo.findById(id);
        return result.orElse(null);
    }

    public String updateACustomer(String id, DevBankUser devBankUser) {
        Query query = new Query();
        query.addCriteria(Criteria.where("_id").is(id));
        //query.fields().include("name");
        Update update = new Update();
        update.set("fullName", devBankUser.getFullName());
        update.set("email", devBankUser.getEmail());
        update.set("gender", devBankUser.getGender());
        update.set("address", devBankUser.getAddress());
        update.set("accounts", devBankUser.getAccounts());
        update.set("balance", devBankUser.getBalance());

        log.info("Updating user");
        mongoTemplate.updateFirst(query, update, DevBankUser.class);
        return "User Updated Successfully";
    }

    public String removeCustomer(String id) {
        devBankRepo.deleteById(id);
        return "User has been removed";
    }
}
