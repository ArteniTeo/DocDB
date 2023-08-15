import com.DocDB.controller.PatientService;
import com.DocDB.exception.InvalidPhoneNumberException;
import com.DocDB.validator.PatientValidator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;

import java.sql.Date;

import static org.junit.jupiter.api.Assertions.*;

public class TestTest {

    @Test
    @DisplayName("Check normal number")
    public void verifyNormalPhoneNumberTest(){
        assertTrue(() -> PatientValidator.verifyPhoneNumber("0798493899"));
    }

    @Test
    @DisplayName("Check abnormal number")
    public void verifyAbnormalPhoneNumberTest(){
        assertThrows(InvalidPhoneNumberException.class, () ->PatientValidator.verifyPhoneNumber("0a98493899"));
    }

    @Test
    public void checkAgeTest(){
        Date date = new Date(2002-12-1);
        assertTrue(PatientValidator.verifyAge(date));
    }
}
