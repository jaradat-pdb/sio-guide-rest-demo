package corp.pdb.sio.demo.boot.loader;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import corp.pdb.sio.demo.data.model.document.DeveloperUserDoc;
import corp.pdb.sio.demo.data.model.document.RegisteredUserDoc;
import corp.pdb.sio.demo.data.repo.document.AppUserDocRepository;
/* Generates a logger (based on Slf4j LoggerFactory) object by the name of log */
import lombok.extern.slf4j.Slf4j;

/**
 * 
 * @author jaradat-pdb
 *
 */
@Configuration
@Slf4j
class LoadDatabase {
    private String loadingTemplate = "Preloading {}";
    private AppUserDocRepository<DeveloperUserDoc> developerUserDocRepository;
    private AppUserDocRepository<RegisteredUserDoc> registeredUserDocRepository;

    @Autowired
    LoadDatabase(
            @Qualifier("developerUserDocRepository") AppUserDocRepository<DeveloperUserDoc> developerUserDocRepository,
            @Qualifier("registeredUserDocRepository") AppUserDocRepository<RegisteredUserDoc> registeredUserDocRepository) {
        this.developerUserDocRepository = developerUserDocRepository;
        this.registeredUserDocRepository = registeredUserDocRepository;
    }

    @Bean
    CommandLineRunner initDatabase() {
        
        long developerUserDocCount = developerUserDocRepository.count();
        long registeredUserDocCount = registeredUserDocRepository.count();
        
        if(developerUserDocCount == 0 && registeredUserDocCount == 0) {
            return args -> {
                log.info(loadingTemplate, developerUserDocRepository.save(new DeveloperUserDoc("Wil-Meister", "Gerrard", "Java", "Dirty Willay")));
                log.info(loadingTemplate, developerUserDocRepository.save(new DeveloperUserDoc("PDB", "Corp", "Java")));
                log.info(loadingTemplate, registeredUserDocRepository.save(new RegisteredUserDoc("Waleed", "Al-Jaradat")));
                log.info(loadingTemplate, registeredUserDocRepository.save(new RegisteredUserDoc("Nasser", "Al-Jaradat", "Khaled")));
            };
            
        } else if(developerUserDocCount == 0) {
            return args -> {
                log.info(loadingTemplate, developerUserDocRepository.save(new DeveloperUserDoc("PDB", "Corp", "Java")));
                log.info(loadingTemplate, developerUserDocRepository.save(new DeveloperUserDoc("Wil-Meister", "Gerrard", "Java", "Dirty Willay")));
            };
            
        } else if(registeredUserDocCount == 0) {
            return args -> {
                log.info(loadingTemplate, registeredUserDocRepository.save(new RegisteredUserDoc("Waleed", "Al-Jaradat")));
                log.info(loadingTemplate, registeredUserDocRepository.save(new RegisteredUserDoc("Nasser", "Al-Jaradat", "Khaled")));
            };
            
        } else {
            return args -> {
                log.info("Database contains {} document(s) in the APPUSER collection", (developerUserDocCount + registeredUserDocCount));
            };
        }
    }
}
