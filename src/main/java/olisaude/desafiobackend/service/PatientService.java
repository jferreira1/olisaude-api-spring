package olisaude.desafiobackend.service;

import olisaude.desafiobackend.model.Patient;
import olisaude.desafiobackend.repository.PatientRepository;
import org.springframework.stereotype.Service;

import java.util.List;
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

    public Patient createPatient(Patient patient) {
        return patientRepository.save(patient);
    }

    public Patient editPatient(UUID id, Patient patient) {
            return patientRepository.findById(id)
                    .map(patientFound -> {
                        patientFound.setName(patient.getName());
                        patientFound.setGender(patient.getGender());
                        if (patient.getBirthdate() != null) patientFound.setBirthdate(patient.getBirthdate());
                        return patientRepository.save(patientFound);
                    }).orElseGet(() -> {
                        patient.setId(id);
                        return patientRepository.save(patient);
                    });
    }

//    public List<Patient> listHigherPriorityPatients() {
//        return null;
//    }
}
