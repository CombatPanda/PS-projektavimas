package lt.vu.mif.ood;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;

public class UnitTest {

    PasswordChecker passwordChecker;
    PhoneChecker phoneChecker;
    EmailChecker emailChecker;
    @BeforeEach
    void setUp() {
        passwordChecker = new PasswordChecker();
        phoneChecker = new PhoneChecker();
        emailChecker = new EmailChecker();
    }

    //region Password

    // Testing the length of the password
    @Test
    void TestPasswordLengthCorrect() {
        assertTrue(passwordChecker.lengthRequirement("abcdef", 5));
    }

    @Test
    void TestPasswordLengthEqualLength() {
        assertTrue(passwordChecker.lengthRequirement("abcde", 5));
    }

    @Test
    void TestPasswordLengthFalse() {
        assertFalse(passwordChecker.lengthRequirement("abcd", 5));
    }

    // Testing if password has any uppercase letters
    @Test
    void TestPasswordHasUppercaseCorrect(){
        assertTrue(passwordChecker.uppercaseRequirement("aBcdef"));
    }

    @Test
    void TestPasswordHasUppercaseFalse(){
        assertFalse(passwordChecker.uppercaseRequirement("abcdef"));
    }

    // Test if password has any special symbols
    @Test
    void TestPasswordSpecialSymbolsCorrect(){
        assertTrue(passwordChecker.specialSymbolsRequirement("aBcdef*"));
    }
    @Test
    void TestPasswordSpecialSymbolsFalse(){
        assertFalse(passwordChecker.specialSymbolsRequirement("aBcdef"));
    }

    //endregion

    //region Phone number
    // Testing if input phone number is valid. (has valid structure)
    @Test
    void TestPhoneProperNumberCorrect(){
        assertTrue(phoneChecker.validNumberRequirement("+37061234567"));
    }

    @Test
    void TestPhoneProperNumberShortenedCorrect(){
        assertTrue(phoneChecker.validNumberRequirement("861234567"));
    }

    @Test
    void TestPhoneProperNumberFalse(){
        assertFalse(phoneChecker.validNumberRequirement("+3706A2E4567"));
    }

    @Test
    void TestPhoneEmptyNumber(){
        assertFalse(phoneChecker.validNumberRequirement(""));
    }

    // Testing if phone starts with +370
    @Test
    void TestPhoneNumberStartSymbolCorrect(){
        assertEquals("Phone number has a proper starting number sequence.",phoneChecker.checkNumberStartingSymbol("+37061234567"));
    }

    @Test
    void TestPhoneNumberWrongStartSymbol(){
        assertEquals("Phone number has a proper starting number sequence.",phoneChecker.checkNumberStartingSymbol("861234567"));
    }

    // Test if it's possible to validate phone number through country index and number length
    @Test
    void TestPhoneCountryIndexCorrect(){
        assertEquals("Country's prefix matches phone number.",phoneChecker.checkCountryByIndex("LT", "+37061234567"));
    }

    @Test
    void TestPhoneCountryIndexFailed(){
        assertEquals("Country's prefix doesn't matches phone number.",phoneChecker.checkCountryByIndex("LV", "+37061234567"));
    }

    @Test
    void TestPhoneCountryIndexLengthCorrect(){
        assertEquals("Country's prefix matches phone number length.",phoneChecker.checkCountryByIndexLength("LT", "+37061234567"));
    }

    @Test
    void TestPhoneCountryIndexLengthFailed(){
        assertEquals("Country's prefix doesn't matches phone number length.",phoneChecker.checkCountryByIndexLength("LT", "+370612345678"));
    }

    //endregion

    //region EMail
    // Test if email has '@' symbol
    @Test
    void TestIfEmailIsProperCorrect(){
        assertTrue(emailChecker.validEmailRequirement("kostas@mail.com"));
    }

    @Test
    void TestIfEmailIsProperFailed(){
        assertFalse(emailChecker.validEmailRequirement("kostasmail.com"));
    }

    //test if email has valid symbols in it
    @Test
    void TestEmailHasSymbolsCorrect(){
        assertTrue(emailChecker.validEmailSymbolsRequirement("kostas@mail.com"));
    }

    @Test
    void TestEmailHasSymbolsFailed(){
        assertFalse(emailChecker.validEmailSymbolsRequirement("kos[tas@mail.com"));
    }

    @Test
    void TestEmailHasSymbolsFailedDoubleAt(){
        assertFalse(emailChecker.validEmailSymbolsRequirement("kos@tas@mail.com"));
    }

    // Test if email has the right domain and TLD
    @Test
    void TestEmailDomainCorrect(){
        assertTrue(emailChecker.validDomainRequirement("kostas@mail.another.com"));
    }

    @Test
    void TestEmailDomainFailed(){
        assertFalse(emailChecker.validDomainRequirement("kostas@.com"));
    }

    @Test
    void TestEmailDomainFailedDoubleDot(){
        assertFalse(emailChecker.validDomainRequirement("kostas@mail..com"));
    }

    //endregion

    @AfterEach
    void tearDown() {
    }

}