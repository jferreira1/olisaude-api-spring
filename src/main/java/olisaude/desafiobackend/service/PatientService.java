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

    public Patient createPatient(Patient patient) {
        System.out.println(patient.toString());

        return patientRepository.save(patient);
    }

//    public Patient editPatient(UUID id, Patient oldPatient) {
//        return Patient;
//    }

    public Patient getPatientById(UUID id) {
        return patientRepository.findById(id).orElseThrow(() -> new RuntimeException("Cliente não encontrado."));
    }

    public List<Patient> listAllPatients() {
        return patientRepository.findAll();
    }

//    public List<Patient> listHigherPriorityPatients() {
//        return null;
//    }


}
