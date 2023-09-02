package DaoTesting;

import com.DocDB.dao.impl.LabResultsDaoImpl;
import com.DocDB.entities.LabResult;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

import static DaoTesting.TestDataUtil.createLabResultA;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@SpringBootConfiguration
@ExtendWith(SpringExtension.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class LabResultDaoImplTest {

    private final LabResultsDaoImpl underTest;

    @Autowired
    public LabResultDaoImplTest(LabResultsDaoImpl underTest) {
        this.underTest = underTest;
    }

    @Test
    public void goodTest() {

    }

    @Test
    public void testThatLabResultCanBeCreatedAndRecalled() {
        LabResult result = createLabResultA();
        underTest.create(result);
        Optional<LabResult> results = underTest.findByDate(1L, new Date(2023-8-9));
        assertThat(results).isPresent();
    }
}
