package com.confidencedev.api;

import com.confidencedev.models.DevBankUser;
import com.confidencedev.services.DevBankService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/devbank")
@AllArgsConstructor
public class DevBankController {

    private final DevBankService devBankService;

    @PostMapping
    public String addNewCustomer(@RequestBody DevBankUser user){
        return devBankService.addCustomer(user);
    }

    @GetMapping
    public List<DevBankUser> fetchAllCustomers(){
        return devBankService.getAllCustomers();
    }

    @GetMapping(path = "{id}")
    public DevBankUser fetchCustomer(@PathVariable String id){
        return devBankService.getCustomer(id);
    }

    @PutMapping(path = "{id}")
    public String updateCustomer(@PathVariable String id, @RequestBody DevBankUser user){
        return devBankService.updateACustomer(id, user);
    }

    @DeleteMapping(path = "{id}")
    public String deleteCustomer(@PathVariable String id){
        return devBankService.removeCustomer(id);
    }
}
