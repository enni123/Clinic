package simple.applications.test;
import org.assertj.core.api.Assertions;
import simple.applications.entity.Patient;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import simple.applications.repository.PatientRepository;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PatientTest {
    @Autowired
    private PatientRepository repository;

    @Test
    public void testByPhone(){
        Patient patient = repository.findPatientByPhoneNumber("+380992331640");
        System.out.println(patient.getName());
    }
    @Test
    public void getPatientByName(){
        Patient name = repository.getPatientByName("Денис");
        Assertions.assertThat(name).hasFieldOrProperty("name");
        Assertions.assertThat(name.getEmail()).isEqualTo("denis33@ukr.net");
    }
    @Test
    public void findPatient(){
        List<Patient> all = repository.findAll();
        Assertions.assertThat(all.get(2)).isIn(all);
    }
    @Test
    public void deletePatient(){
        Patient patient = repository.getPatientByName("Александр");
        repository.delete(patient);

        List<Patient> all = repository.findAll();
        assertThat(all).hasSize(10);
    }
}
