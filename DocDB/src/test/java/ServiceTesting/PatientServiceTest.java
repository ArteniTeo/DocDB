package ServiceTesting;

import com.DocDB.common.Gender;
import com.DocDB.service.PatientService;
import com.DocDB.service.UserService;
import com.DocDB.entities.Patient;
import com.DocDB.entities.User;
import com.DocDB.exception.InvalidPhoneNumberException;
import com.DocDB.reposiory.PatientRepository;
import com.DocDB.validator.PatientValidator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.sql.Date;

import static com.DocDB.validator.PatientValidator.verifyCnp;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;

public class PatientServiceTest {

    @Mock
    private PatientRepository repository;

    @Mock
    private UserService userService;

    @InjectMocks
    private PatientService patientService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        patientService = new PatientService(repository, userService);
    }

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

    @Test
    @DisplayName("Testing creation of Patient")
    void givenPatient_whenCreatingPatient_thenReturnPatient(){
        //given
        Patient patient = new Patient();
        patient.setUserId(1L);
        patient.setFirstname("Firstname");
        patient.setLastname("Lastname");
        patient.setCnp("5040317226766");
        patient.setPhoneNumber("0739719939");
        patient.setBirthDay(Date.valueOf("2004-03-17"));
        patient.setGender(Gender.MALE);
        given(repository.findByCnp("5040317226766")).willReturn(null);
        User user = new User(1L);
        given(userService.getUserById(patient.getUserId())).willReturn(user);
        given(userService.updateUser(user)).willReturn(null);
        given(repository.save(patient)).willReturn(patient);

        //when
        Patient foundPatient = patientService.createPatient(patient);

        //then
        assertEquals(patient, foundPatient);
    }
}
