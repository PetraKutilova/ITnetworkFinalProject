package cz.itnetwork.finalproject;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

/**
 *
 * @author petra
 */
class PersonValidatorTest {

    @Test
    void testValidateName_valid() {
        assertTrue(PersonValidator.validateName("pepina"));
    }

    @Test
    void testValidateName_null() {
        assertFalse(PersonValidator.validateName(null));
    }

    @Test
    void testValidateName_empty() {
        assertFalse(PersonValidator.validateName(""));
    }

    @Test
    void testValidateName_whitespaces() {
        assertFalse(PersonValidator.validateName("     "));
    }

    @Test
    void testValidatePhoneNumber_valid() {
        assertTrue(PersonValidator.validatePhoneNumber("+420123123123"));
    }

    @Test
    void testValidatePhoneNumber_tooLong() {
        assertFalse(PersonValidator.validatePhoneNumber("+4201231231231"));
    }

    @Test
    void testValidatePhoneNumber_invalidCharacters() {
        assertFalse(PersonValidator.validatePhoneNumber("+abc"));
    }

    @Test
    void testValidatePhoneNumber_noPlusAtBeginning() {
        assertFalse(PersonValidator.validatePhoneNumber("420123"));
    }

    @Test
    void testValidatePhoneNumber_onlyPlus() {
        assertFalse(PersonValidator.validatePhoneNumber("+"));
    }

    @Test
    void testValidateAge_valid() {
        assertTrue(PersonValidator.validateAge("55"));
    }

    @Test
    void testValidateAge_minimum() {
        assertTrue(PersonValidator.validateAge("0"));
    }

    @Test
    void testValidateAge_maximum() {
        assertTrue(PersonValidator.validateAge("150"));
    }

    @Test
    void testValidateAge_tooLow() {
        assertFalse(PersonValidator.validateAge("-1"));
    }

    @Test
    void testValidateAge_tooHigh() {
        assertFalse(PersonValidator.validateAge("850"));
    }
}
