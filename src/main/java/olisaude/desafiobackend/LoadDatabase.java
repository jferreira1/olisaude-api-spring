package olisaude.desafiobackend;

import olisaude.desafiobackend.enums.Gender;
import olisaude.desafiobackend.model.Patient;
import olisaude.desafiobackend.repository.PatientRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.text.SimpleDateFormat;

@Configuration
public class LoadDatabase {
    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

    @Bean
    CommandLineRunner initDatabase(PatientRepository patientRepository) {
      return args -> {

          log.info("Preloading " + patientRepository.save(new Patient("Bob", Gender.M, new SimpleDateFormat("dd/MM/yyyy").parse("31/01/1999"))));
          log.info("Preloading " + patientRepository.save(new Patient("Ana", Gender.F, new SimpleDateFormat("dd/MM/yyyy").parse("30/01/1999"))));
          log.info("Preloading " + patientRepository.save(new Patient("Bianca", Gender.F, new SimpleDateFormat("dd/MM/yyyy").parse("29/02/1999"))));
          log.info("Preloading " + patientRepository.save(new Patient("Edgar", Gender.M, new SimpleDateFormat("dd/MM/yyyy").parse("31/01/1999"))));
      };
    };
}
