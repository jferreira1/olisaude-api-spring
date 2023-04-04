package olisaude.desafiobackend.service;

import jakarta.persistence.EntityNotFoundException;
import olisaude.desafiobackend.DTO.PatientDTO;
import olisaude.desafiobackend.model.HealthIssue;
import olisaude.desafiobackend.model.Patient;
import olisaude.desafiobackend.repository.PatientRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class PatientService {
    private final PatientRepository patientRepository;

    public PatientService(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    public Patient getPatientById(UUID id) {
        return patientRepository.findById(id).orElseThrow(() -> new RuntimeException("Cliente não encontrado."));
    }

    public List<Patient> listAllPatients() {
        return patientRepository.findAll();
    }

    public Patient createPatient(PatientDTO patientDTO) {

        Patient patient = new Patient();
        patient.setName(patientDTO.getName());
        patient.setGender(patientDTO.getGender());
        patient.setBirthdate(patientDTO.getBirthdate());

        List<HealthIssue> healthIssues = new ArrayList<>();
        for(HealthIssue healthIssueOnDTO : patientDTO.getHealthIssues()) {
            HealthIssue healthIssue = new HealthIssue();
            healthIssue.setName(healthIssueOnDTO.getName());
            healthIssue.setGrade(healthIssueOnDTO.getGrade());
            healthIssue.setPatient(patient);
            healthIssues.add(healthIssue);
        }
        patient.setHealthIssues(healthIssues);
        return patientRepository.save(patient);
    }

    public Patient editPatient(UUID id, PatientDTO patientDTO) {
        Optional<Patient> optionalPatient = patientRepository.findById(id);
        if (optionalPatient.isEmpty()) { throw new EntityNotFoundException("Patient not found."); }

        Patient patient = optionalPatient.get();
        patient.setName(patientDTO.getName());
        patient.setGender(patientDTO.getGender());
        patient.setBirthdate(patientDTO.getBirthdate());

        List<HealthIssue> healthIssues = new ArrayList<>();

        for (HealthIssue healthIssueOnDTO : patientDTO.getHealthIssues()) {
            HealthIssue healthIssueToUpdate = null;
            for (HealthIssue existingHealthIssue : patient.getHealthIssues()) {
                if (existingHealthIssue.getId().equals(healthIssueOnDTO.getId())) {
                    healthIssueToUpdate = existingHealthIssue;
                    break;
                }
            }
            if (healthIssueToUpdate == null) {
                healthIssueToUpdate = new HealthIssue();
                healthIssueToUpdate.setPatient(patient);
            }
            healthIssueToUpdate.setName(healthIssueOnDTO.getName());
            healthIssueToUpdate.setGrade(healthIssueOnDTO.getGrade());
            healthIssues.add(healthIssueToUpdate);
        }

        patient.setHealthIssues(healthIssues);
        return patientRepository.save(patient);
    }

//    public List<Patient> listHigherPriorityPatients() {
//        return null;
//    }
}
