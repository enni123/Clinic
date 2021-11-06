package simple.applications.controller;
import org.springframework.stereotype.Controller;
import simple.applications.entity.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import simple.applications.repository.PatientRepository;
import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping(value = "/patients", produces = "application/json")
public class PatientController {

    private PatientRepository repository;

    @Autowired
    public void setRepository(PatientRepository repository) {
        this.repository = repository;
    }
    @GetMapping(value = "/name")
    @ResponseBody
    public Patient getName(@RequestParam(name = "name", required = false) String name){
        return repository.getPatientByName(name);
    }
    @GetMapping(value = "/email")
    @ResponseBody
    public Patient getEmail(@RequestParam(name = "email", required = false) String email){
        return repository.findPatientByEmail(email);
    }
    @GetMapping("/all")
    @ResponseBody
    public List<Patient> getAllPatients(){
        return repository.findAll();
    }
    @GetMapping("/get/{id}")
    @ResponseBody
    public Optional<Patient> getOne(@PathVariable("id") int id){
        return repository.findById(id);
    }
    @GetMapping("/new")
    public String newPatient(@ModelAttribute("patient") Patient patient){
        return "registry";
    }
    @PostMapping("/add")
    public String add(@Valid @ModelAttribute("patient") Patient patient,
                      BindingResult result){
        if(result.hasErrors()){
            return "registry";
        }
        repository.save(patient);
        return "simple_message";
    }
    @DeleteMapping("/delete/{id}")
    @ResponseBody
    public void delete(@PathVariable("id") int id){
        repository.deleteById(id);
    }
}
