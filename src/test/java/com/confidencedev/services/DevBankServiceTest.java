package com.confidencedev.services;

import com.confidencedev.dao.DevBankRepo;
import com.confidencedev.models.Address;
import com.confidencedev.models.DevBankUser;
import com.confidencedev.models.Gender;
import lombok.AllArgsConstructor;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.mongodb.core.MongoTemplate;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;

//@ExtendWith(MockitoExtension.class) uncomment then remove afterEach and Closeable
class DevBankServiceTest {

    @Mock
    private DevBankRepo devBankRepo;
    @Mock
    private MongoTemplate mongoTemplate;
    private AutoCloseable autoCloseable;
    private DevBankService underTest;

    @BeforeEach
    @Disabled
    void setUp() {
        autoCloseable = MockitoAnnotations.openMocks(this);
        underTest = new DevBankService(devBankRepo, mongoTemplate);
    }

    @AfterEach
    @Disabled
    void tearDown() throws Exception {
        autoCloseable.close();
    }

    @Test
    @Disabled
    void addCustomer() {
        //Given
        DevBankUser devBankUser = new DevBankUser(
          "John Doe",
          "johndoe@gmail.com",
                Gender.male,
          new Address("worldwide"),
                List.of("savings"),
          BigDecimal.TEN,
          LocalDateTime.now()
        );

        //When
        underTest.addCustomer(devBankUser);

        //Then
        ArgumentCaptor<DevBankUser> bankUserArgumentCaptor =
                ArgumentCaptor.forClass(DevBankUser.class);

        verify(devBankRepo).save(bankUserArgumentCaptor.capture());

        DevBankUser capturedUser = bankUserArgumentCaptor.getValue();

        assertThat(capturedUser).isEqualTo(devBankUser);
    }

    @Test
    @Disabled
    void getAllCustomers() {
        //When
        underTest.getAllCustomers();
        //Then
        verify(devBankRepo).findAll();
    }

    @Test
    @Disabled
    void getCustomer() {
    }

    @Test
    @Disabled
    void updateACustomer() {
    }

    @Test
    @Disabled
    void removeCustomer() {
    }
}
