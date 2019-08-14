package corp.pdb.sio.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

/**
 * 
 * @author jaradat-pdb
 *
 */
@SpringBootApplication
@EnableMongoRepositories
public class SioGuideRestDemoApplication {
    public static void main(String[] args) {
        SpringApplication.run(SioGuideRestDemoApplication.class, args);
    }
}
