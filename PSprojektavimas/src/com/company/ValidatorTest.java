package com.company;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

class ValidatorTest {

    Validator validator;
    @BeforeEach
    void setUp() {
        validator = new Validator();
    }
    //Tests for password
    @Test
    void passwordCheckerLengthTest() {
        String password = "ABC123456789@";
        assertTrue(validator.validatePassword(password));
    }

    @Test
    void passwordCheckerUppercaseTest() {
        String password = "ABC123456789@";
        assertTrue(validator.validatePassword(password));
    }

    @Test
    void passwordCheckerSpecialSymbolTest() {
        String password = "ABC123456789@";
        assertTrue(validator.validatePassword(password));
    }
    //Tests for phone
    @Test
    void phoneValidatorOtherSymbolTest() {
        String number = "860806655@";
        assertTrue(validator.validatePhone(number));
    }

    @Test
    void phoneValidatorLengthTest() {
        String number = "860806655@";
        assertTrue(validator.validatePhone(number));
    }

    @Test
    void phoneValidatorPrefixTest() {
        String number = "860806655@";
        assertTrue(validator.validatePhone(number));
    }
    //Tests for e-mail
    @Test
    void emailValidatorContainsEtaTest() {
        String email = "projektavimas@gmail.com";
        assertTrue(validator.validatEmail(email));
    }
    @Test
    void emailValidatorSymbolTest() {
        String email = "projektavimas@gmail.com";
        assertTrue(validator.validatEmail(email));
    }
    @Test
    void emailValidatorDomainTest() {
        String email = "projektavimas@gmail.com";
        assertTrue(validator.validatEmail(email));
    }
    @Test
    void emailValidatorTLDTest() {
        String email = "projektavimas@gmail.com";
        assertTrue(validator.validatEmail(email));
    }
    @AfterEach
    void tearDown() {
    }
}