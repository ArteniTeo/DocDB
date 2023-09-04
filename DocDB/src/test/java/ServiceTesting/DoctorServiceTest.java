package ServiceTesting;

import com.DocDB.service.DoctorService;
import com.DocDB.entities.Doctor;
import com.DocDB.reposiory.DoctorRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
public class DoctorServiceTest {

    @Mock
    DoctorRepository repository;

    @InjectMocks
    DoctorService service;

    @Test
    void givenId_whenFindByUserId_thenReturnsDoctor(){
        //given
        var userID = 1L;
        var doctor = new Doctor();
        doctor.setUserId(userID);
        given(repository.findByUserId(userID)).willReturn(doctor);

        //when
        Doctor foundDoctor = service.findByUserId(userID);

        //then
        assertEquals(userID, foundDoctor.getUserId());
    }

}
