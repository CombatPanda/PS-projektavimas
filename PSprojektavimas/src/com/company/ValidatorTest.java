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
    void passwordCheckerCorrectTest() {
        String password = "ABC123456789@";
        assertTrue(validator.validatePassword(password));
    }
    @Test
    void passwordCheckerLengthTest() {
        String password = "A123@";
        assertFalse(validator.validatePassword(password));
    }
    @Test
    void passwordCheckerUppercaseTest() {
        String password = "abc123456789@";
        assertFalse(validator.validatePassword(password));
    }
    @Test
    void passwordCheckerSpecialSymbolTest() {
        String password = "abc123456789";
        assertFalse(validator.validatePassword(password));
    }
    //Tests for phone
    @Test
    void phoneValidatorCorrectTest() {
        String number = "+37060806912";
        assertTrue(validator.validatePhone(number));
    }
    @Test
    void phoneValidatorOtherSymbolTest() {
        String number = "+37060806912@";
        assertFalse(validator.validatePhone(number));
    }

    @Test
    void phoneValidatorLengthTest() {
        String number = "+37060806";
        assertFalse(validator.validatePhone(number));
    }
    @Test
    void phoneValidatorPrefixTest() {
        String number = "860806912";
        assertTrue(validator.validatePhone(number));
    }
    //Tests for e-mail
    @Test
    void emailValidatorCorrectTest() {
        String email = "projektavimas@gmail.com";
        assertTrue(validator.validatEmail(email));
    }
    @Test
    void emailValidatorContainsEtaTest() {
        String email = "projektavimasgmail.com";
        assertFalse(validator.validatEmail(email));
    }
    @Test
    void emailValidatorSymbolTest() {
        String email = "p^^^@gmail.com";
        assertFalse(validator.validatEmail(email));
    }
    @Test
    void emailValidatorDomainTest() {
        String email = "projektas@gmail.cpm";
        assertFalse(validator.validatEmail(email));
    }
    @Test
    void emailValidatorTLDTest() {
        String email = "testas@asdf.com";
        assertFalse(validator.validatEmail(email));
    }
    @AfterEach
    void tearDown() {
    }
}
