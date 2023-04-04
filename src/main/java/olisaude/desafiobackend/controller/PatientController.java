package olisaude.desafiobackend.controller;

import olisaude.desafiobackend.DTO.PatientDTO;
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


    @GetMapping("/patients")
    public List<Patient> listAllPatients() {
        return patientService.listAllPatients();
    };

    @GetMapping("/patients/{id}")
    public Patient getPatientById(@PathVariable UUID id) {
        return patientService.getPatientById(id);
    };

    @PutMapping("/patients")
    public Patient createPatient(@RequestBody PatientDTO patientDTO) {
        return patientService.createPatient(patientDTO);
    };

    @PutMapping("/patients/{id}")
    public Patient editPatient(@PathVariable UUID id, @RequestBody PatientDTO patientDTO) {
        return patientService.editPatient(id, patientDTO);
    }
}
