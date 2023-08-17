import com.DocDB.common.Gender;
import com.DocDB.exception.InvalidPhoneNumberException;
import com.DocDB.validator.PatientValidator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.sql.Date;

import static com.DocDB.validator.PatientValidator.verifyCnp;
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

    @ParameterizedTest
    @CsvSource({"5040317226766, 2004-03-17, MALE",
                "5070809450021, 2007-08-09, MALE"})
    @DisplayName("Verify good CNPs")
    public void checkCnp(String cnp, Date birthDay, Gender gender){
        assertTrue(() -> verifyCnp(cnp, birthDay, gender));
    }
}
