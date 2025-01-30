package test.java.services;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import services.ValidationService;

class ValidationServiceDiffblueTest {
    /**
     * Test {@link ValidationService#isEmailValid(String)}.
     * <ul>
     *   <li>When {@code 42jane.doe@example.org}.</li>
     *   <li>Then return {@code true}.</li>
     * </ul>
     * <p>
     * Method under test: {@link ValidationService#isEmailValid(String)}
     */
    @Test
    @DisplayName("Test isEmailValid(String); when '42jane.doe@example.org'; then return 'true'")
    void testIsEmailValid_when42janeDoeExampleOrg_thenReturnTrue() {
        // Arrange, Act and Assert
        assertTrue(ValidationService.isEmailValid("42jane.doe@example.org"));
    }

    /**
     * Test {@link ValidationService#isEmailValid(String)}.
     * <ul>
     *   <li>When {@code 42john.smith@example.org}.</li>
     *   <li>Then return {@code true}.</li>
     * </ul>
     * <p>
     * Method under test: {@link ValidationService#isEmailValid(String)}
     */
    @Test
    @DisplayName("Test isEmailValid(String); when '42john.smith@example.org'; then return 'true'")
    void testIsEmailValid_when42johnSmithExampleOrg_thenReturnTrue() {
        // Arrange, Act and Assert
        assertTrue(ValidationService.isEmailValid("42john.smith@example.org"));
    }

    /**
     * Test {@link ValidationService#isEmailValid(String)}.
     * <ul>
     *   <li>When {@code 42prof.einstein@example.org}.</li>
     *   <li>Then return {@code true}.</li>
     * </ul>
     * <p>
     * Method under test: {@link ValidationService#isEmailValid(String)}
     */
    @Test
    @DisplayName("Test isEmailValid(String); when '42prof.einstein@example.org'; then return 'true'")
    void testIsEmailValid_when42profEinsteinExampleOrg_thenReturnTrue() {
        // Arrange, Act and Assert
        assertTrue(ValidationService.isEmailValid("42prof.einstein@example.org"));
    }

    /**
     * Test {@link ValidationService#isEmailValid(String)}.
     * <ul>
     *   <li>When {@code 42U@U.UUUU}.</li>
     *   <li>Then return {@code true}.</li>
     * </ul>
     * <p>
     * Method under test: {@link ValidationService#isEmailValid(String)}
     */
    @Test
    @DisplayName("Test isEmailValid(String); when '42U@U.UUUU'; then return 'true'")
    void testIsEmailValid_when42uUUuuu_thenReturnTrue() {
        // Arrange, Act and Assert
        assertTrue(ValidationService.isEmailValid("42U@U.UUUU"));
    }

    /**
     * Test {@link ValidationService#isEmailValid(String)}.
     * <ul>
     *   <li>When {@code ^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,6}$}.</li>
     *   <li>Then return {@code false}.</li>
     * </ul>
     * <p>
     * Method under test: {@link ValidationService#isEmailValid(String)}
     */
    @Test
    @DisplayName("Test isEmailValid(String); when '^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$'; then return 'false'")
    void testIsEmailValid_whenAZAZ09AZAZ09AZAZ26_thenReturnFalse() {
        // Arrange, Act and Assert
        assertFalse(ValidationService.isEmailValid("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$"));
    }

    /**
     * Test {@link ValidationService#isEmailValid(String)}.
     * <ul>
     *   <li>When {@code EmailU@U.UUUU}.</li>
     *   <li>Then return {@code true}.</li>
     * </ul>
     * <p>
     * Method under test: {@link ValidationService#isEmailValid(String)}
     */
    @Test
    @DisplayName("Test isEmailValid(String); when 'EmailU@U.UUUU'; then return 'true'")
    void testIsEmailValid_whenEmailUUUuuu_thenReturnTrue() {
        // Arrange, Act and Assert
        assertTrue(ValidationService.isEmailValid("EmailU@U.UUUU"));
    }

    /**
     * Test {@link ValidationService#isEmailValid(String)}.
     * <ul>
     *   <li>When {@code Emailjane.doe@example.org}.</li>
     *   <li>Then return {@code true}.</li>
     * </ul>
     * <p>
     * Method under test: {@link ValidationService#isEmailValid(String)}
     */
    @Test
    @DisplayName("Test isEmailValid(String); when 'Emailjane.doe@example.org'; then return 'true'")
    void testIsEmailValid_whenEmailjaneDoeExampleOrg_thenReturnTrue() {
        // Arrange, Act and Assert
        assertTrue(ValidationService.isEmailValid("Emailjane.doe@example.org"));
    }

    /**
     * Test {@link ValidationService#isEmailValid(String)}.
     * <ul>
     *   <li>When {@code Emailjohn.smith@example.org}.</li>
     *   <li>Then return {@code true}.</li>
     * </ul>
     * <p>
     * Method under test: {@link ValidationService#isEmailValid(String)}
     */
    @Test
    @DisplayName("Test isEmailValid(String); when 'Emailjohn.smith@example.org'; then return 'true'")
    void testIsEmailValid_whenEmailjohnSmithExampleOrg_thenReturnTrue() {
        // Arrange, Act and Assert
        assertTrue(ValidationService.isEmailValid("Emailjohn.smith@example.org"));
    }

    /**
     * Test {@link ValidationService#isEmailValid(String)}.
     * <ul>
     *   <li>When {@code Emailprof.einstein@example.org}.</li>
     *   <li>Then return {@code true}.</li>
     * </ul>
     * <p>
     * Method under test: {@link ValidationService#isEmailValid(String)}
     */
    @Test
    @DisplayName("Test isEmailValid(String); when 'Emailprof.einstein@example.org'; then return 'true'")
    void testIsEmailValid_whenEmailprofEinsteinExampleOrg_thenReturnTrue() {
        // Arrange, Act and Assert
        assertTrue(ValidationService.isEmailValid("Emailprof.einstein@example.org"));
    }

    /**
     * Test {@link ValidationService#isEmailValid(String)}.
     * <ul>
     *   <li>When {@code jane.doe@example.org}.</li>
     *   <li>Then return {@code true}.</li>
     * </ul>
     * <p>
     * Method under test: {@link ValidationService#isEmailValid(String)}
     */
    @Test
    @DisplayName("Test isEmailValid(String); when 'jane.doe@example.org'; then return 'true'")
    void testIsEmailValid_whenJaneDoeExampleOrg_thenReturnTrue() {
        // Arrange, Act and Assert
        assertTrue(ValidationService.isEmailValid("jane.doe@example.org"));
    }

    /**
     * Test {@link ValidationService#isEmailValid(String)}.
     * <ul>
     *   <li>When {@code john.smith@example.org}.</li>
     *   <li>Then return {@code true}.</li>
     * </ul>
     * <p>
     * Method under test: {@link ValidationService#isEmailValid(String)}
     */
    @Test
    @DisplayName("Test isEmailValid(String); when 'john.smith@example.org'; then return 'true'")
    void testIsEmailValid_whenJohnSmithExampleOrg_thenReturnTrue() {
        // Arrange, Act and Assert
        assertTrue(ValidationService.isEmailValid("john.smith@example.org"));
    }

    /**
     * Test {@link ValidationService#isEmailValid(String)}.
     * <ul>
     *   <li>When {@code prof.einstein@example.org}.</li>
     *   <li>Then return {@code true}.</li>
     * </ul>
     * <p>
     * Method under test: {@link ValidationService#isEmailValid(String)}
     */
    @Test
    @DisplayName("Test isEmailValid(String); when 'prof.einstein@example.org'; then return 'true'")
    void testIsEmailValid_whenProfEinsteinExampleOrg_thenReturnTrue() {
        // Arrange, Act and Assert
        assertTrue(ValidationService.isEmailValid("prof.einstein@example.org"));
    }

    /**
     * Test {@link ValidationService#isEmailValid(String)}.
     * <ul>
     *   <li>When {@code U@U.UUUU}.</li>
     *   <li>Then return {@code true}.</li>
     * </ul>
     * <p>
     * Method under test: {@link ValidationService#isEmailValid(String)}
     */
    @Test
    @DisplayName("Test isEmailValid(String); when 'U@U.UUUU'; then return 'true'")
    void testIsEmailValid_whenUUUuuu_thenReturnTrue() {
        // Arrange, Act and Assert
        assertTrue(ValidationService.isEmailValid("U@U.UUUU"));
    }

    /**
     * Test {@link ValidationService#isPhoneNumberValid(String)}.
     * <ul>
     *   <li>When {@code 4242}.</li>
     *   <li>Then return {@code true}.</li>
     * </ul>
     * <p>
     * Method under test: {@link ValidationService#isPhoneNumberValid(String)}
     */
    @Test
    @DisplayName("Test isPhoneNumberValid(String); when '4242'; then return 'true'")
    void testIsPhoneNumberValid_when4242_thenReturnTrue() {
        // Arrange, Act and Assert
        assertTrue(ValidationService.isPhoneNumberValid("4242"));
    }

    /**
     * Test {@link ValidationService#isPhoneNumberValid(String)}.
     * <ul>
     *   <li>When {@code +499999999}.</li>
     *   <li>Then return {@code true}.</li>
     * </ul>
     * <p>
     * Method under test: {@link ValidationService#isPhoneNumberValid(String)}
     */
    @Test
    @DisplayName("Test isPhoneNumberValid(String); when '+499999999'; then return 'true'")
    void testIsPhoneNumberValid_when499999999_thenReturnTrue() {
        // Arrange, Act and Assert
        assertTrue(ValidationService.isPhoneNumberValid("+499999999"));
    }

    /**
     * Test {@link ValidationService#isPhoneNumberValid(String)}.
     * <ul>
     *   <li>When {@code 6625550144}.</li>
     *   <li>Then return {@code true}.</li>
     * </ul>
     * <p>
     * Method under test: {@link ValidationService#isPhoneNumberValid(String)}
     */
    @Test
    @DisplayName("Test isPhoneNumberValid(String); when '6625550144'; then return 'true'")
    void testIsPhoneNumberValid_when6625550144_thenReturnTrue() {
        // Arrange, Act and Assert
        assertTrue(ValidationService.isPhoneNumberValid("6625550144"));
    }

    /**
     * Test {@link ValidationService#isPhoneNumberValid(String)}.
     * <ul>
     *   <li>When {@code 8605550118}.</li>
     *   <li>Then return {@code true}.</li>
     * </ul>
     * <p>
     * Method under test: {@link ValidationService#isPhoneNumberValid(String)}
     */
    @Test
    @DisplayName("Test isPhoneNumberValid(String); when '8605550118'; then return 'true'")
    void testIsPhoneNumberValid_when8605550118_thenReturnTrue() {
        // Arrange, Act and Assert
        assertTrue(ValidationService.isPhoneNumberValid("8605550118"));
    }

    /**
     * Test {@link ValidationService#isPhoneNumberValid(String)}.
     * <ul>
     *   <li>When {@code +49999999942}.</li>
     *   <li>Then return {@code true}.</li>
     * </ul>
     * <p>
     * Method under test: {@link ValidationService#isPhoneNumberValid(String)}
     */
    @Test
    @DisplayName("Test isPhoneNumberValid(String); when '+49999999942'; then return 'true'")
    void testIsPhoneNumberValid_when49999999942_thenReturnTrue() {
        // Arrange, Act and Assert
        assertTrue(ValidationService.isPhoneNumberValid("+49999999942"));
    }

    /**
     * Test {@link ValidationService#isPhoneNumberValid(String)}.
     * <ul>
     *   <li>When {@code 426625550144}.</li>
     *   <li>Then return {@code true}.</li>
     * </ul>
     * <p>
     * Method under test: {@link ValidationService#isPhoneNumberValid(String)}
     */
    @Test
    @DisplayName("Test isPhoneNumberValid(String); when '426625550144'; then return 'true'")
    void testIsPhoneNumberValid_when426625550144_thenReturnTrue() {
        // Arrange, Act and Assert
        assertTrue(ValidationService.isPhoneNumberValid("426625550144"));
    }

    /**
     * Test {@link ValidationService#isPhoneNumberValid(String)}.
     * <ul>
     *   <li>When {@code 428605550118}.</li>
     *   <li>Then return {@code true}.</li>
     * </ul>
     * <p>
     * Method under test: {@link ValidationService#isPhoneNumberValid(String)}
     */
    @Test
    @DisplayName("Test isPhoneNumberValid(String); when '428605550118'; then return 'true'")
    void testIsPhoneNumberValid_when428605550118_thenReturnTrue() {
        // Arrange, Act and Assert
        assertTrue(ValidationService.isPhoneNumberValid("428605550118"));
    }

    /**
     * Test {@link ValidationService#isPhoneNumberValid(String)}.
     * <ul>
     *   <li>When {@code 662555014442}.</li>
     *   <li>Then return {@code true}.</li>
     * </ul>
     * <p>
     * Method under test: {@link ValidationService#isPhoneNumberValid(String)}
     */
    @Test
    @DisplayName("Test isPhoneNumberValid(String); when '662555014442'; then return 'true'")
    void testIsPhoneNumberValid_when662555014442_thenReturnTrue() {
        // Arrange, Act and Assert
        assertTrue(ValidationService.isPhoneNumberValid("662555014442"));
    }

    /**
     * Test {@link ValidationService#isPhoneNumberValid(String)}.
     * <ul>
     *   <li>When {@code 860555011842}.</li>
     *   <li>Then return {@code true}.</li>
     * </ul>
     * <p>
     * Method under test: {@link ValidationService#isPhoneNumberValid(String)}
     */
    @Test
    @DisplayName("Test isPhoneNumberValid(String); when '860555011842'; then return 'true'")
    void testIsPhoneNumberValid_when860555011842_thenReturnTrue() {
        // Arrange, Act and Assert
        assertTrue(ValidationService.isPhoneNumberValid("860555011842"));
    }

    /**
     * Test {@link ValidationService#isPhoneNumberValid(String)}.
     * <ul>
     *   <li>When {@code +44 1865 4960636}.</li>
     *   <li>Then return {@code false}.</li>
     * </ul>
     * <p>
     * Method under test: {@link ValidationService#isPhoneNumberValid(String)}
     */
    @Test
    @DisplayName("Test isPhoneNumberValid(String); when '+44 1865 4960636'; then return 'false'")
    void testIsPhoneNumberValid_when4418654960636_thenReturnFalse() {
        // Arrange, Act and Assert
        assertFalse(ValidationService.isPhoneNumberValid("+44 1865 4960636"));
    }

    /**
     * Test {@link ValidationService#isPhoneNumberValid(String)}.
     * <ul>
     *   <li>When {@code 66255501444242}.</li>
     *   <li>Then return {@code true}.</li>
     * </ul>
     * <p>
     * Method under test: {@link ValidationService#isPhoneNumberValid(String)}
     */
    @Test
    @DisplayName("Test isPhoneNumberValid(String); when '66255501444242'; then return 'true'")
    void testIsPhoneNumberValid_when66255501444242_thenReturnTrue() {
        // Arrange, Act and Assert
        assertTrue(ValidationService.isPhoneNumberValid("66255501444242"));
    }

    /**
     * Test {@link ValidationService#isPhoneNumberValid(String)}.
     * <ul>
     *   <li>When {@code 86055501184242}.</li>
     *   <li>Then return {@code true}.</li>
     * </ul>
     * <p>
     * Method under test: {@link ValidationService#isPhoneNumberValid(String)}
     */
    @Test
    @DisplayName("Test isPhoneNumberValid(String); when '86055501184242'; then return 'true'")
    void testIsPhoneNumberValid_when86055501184242_thenReturnTrue() {
        // Arrange, Act and Assert
        assertTrue(ValidationService.isPhoneNumberValid("86055501184242"));
    }

    /**
     * Test {@link ValidationService#isPhoneNumberValid(String)}.
     * <ul>
     *   <li>When {@code +4999999996625550144}.</li>
     *   <li>Then return {@code true}.</li>
     * </ul>
     * <p>
     * Method under test: {@link ValidationService#isPhoneNumberValid(String)}
     */
    @Test
    @DisplayName("Test isPhoneNumberValid(String); when '+4999999996625550144'; then return 'true'")
    void testIsPhoneNumberValid_when4999999996625550144_thenReturnTrue() {
        // Arrange, Act and Assert
        assertTrue(ValidationService.isPhoneNumberValid("+4999999996625550144"));
    }

    /**
     * Test {@link ValidationService#isPhoneNumberValid(String)}.
     * <ul>
     *   <li>When {@code +4999999998605550118}.</li>
     *   <li>Then return {@code true}.</li>
     * </ul>
     * <p>
     * Method under test: {@link ValidationService#isPhoneNumberValid(String)}
     */
    @Test
    @DisplayName("Test isPhoneNumberValid(String); when '+4999999998605550118'; then return 'true'")
    void testIsPhoneNumberValid_when4999999998605550118_thenReturnTrue() {
        // Arrange, Act and Assert
        assertTrue(ValidationService.isPhoneNumberValid("+4999999998605550118"));
    }

    /**
     * Test {@link ValidationService#isGermanIbanValid(String)}.
     * <ul>
     *   <li>When {@code DE99999999999999999999}.</li>
     *   <li>Then return {@code true}.</li>
     * </ul>
     * <p>
     * Method under test: {@link ValidationService#isGermanIbanValid(String)}
     */
    @Test
    @DisplayName("Test isGermanIbanValid(String); when 'DE99999999999999999999'; then return 'true'")
    void testIsGermanIbanValid_whenDe99999999999999999999_thenReturnTrue() {
        // Arrange, Act and Assert
        assertTrue(ValidationService.isGermanIbanValid("DE99999999999999999999"));
    }

    /**
     * Test {@link ValidationService#isGermanIbanValid(String)}.
     * <ul>
     *   <li>When {@code Iban}.</li>
     *   <li>Then return {@code false}.</li>
     * </ul>
     * <p>
     * Method under test: {@link ValidationService#isGermanIbanValid(String)}
     */
    @Test
    @DisplayName("Test isGermanIbanValid(String); when 'Iban'; then return 'false'")
    void testIsGermanIbanValid_whenIban_thenReturnFalse() {
        // Arrange, Act and Assert
        assertFalse(ValidationService.isGermanIbanValid("Iban"));
    }
}
