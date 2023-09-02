package DaoTesting;

import com.DocDB.entities.LabResult;

import java.sql.Date;

public class TestDataUtil {

    public static LabResult createLabResultA(){
        return LabResult.builder()
                .patientId(1L)
                .doctorId(1L)
                .examDate(new Date(2023-8-9))
                .examinationName("Test")
                .results("Just successful test")
                .build();
    }

}
