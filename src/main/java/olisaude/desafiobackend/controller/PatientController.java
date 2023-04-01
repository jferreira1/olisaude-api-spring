package olisaude.desafiobackend.controller;

import olisaude.desafiobackend.model.Patient;
import olisaude.desafiobackend.service.PatientService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
public class PatientController {

    private final PatientService patientService;
    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    @PutMapping("/patients")
    public Patient createPatient(@RequestBody Patient patient) {
        System.out.println(patient);
        return patientService.createPatient(patient);
    };

    @GetMapping("/patients")
    public List<Patient> listAllPatients() {
        return patientService.listAllPatients();
    };

    @GetMapping("/patients/{id}")
    public Patient getPatientById(@PathVariable UUID id) {
        return patientService.getPatientById(id);
    };

}
