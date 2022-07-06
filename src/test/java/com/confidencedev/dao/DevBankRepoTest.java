package com.confidencedev.dao;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class DevBankRepoTest {

    @Mock
    private DevBankRepo underTest;

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    @Disabled
    void itShouldFindDevBankByEmail() {
        //Given
        String email = "johndoe@gmail.com";

        //When
        boolean expected = underTest.findDevBankByEmail(email).isPresent();

        //Then
        assertThat(expected).isFalse();
    }
}