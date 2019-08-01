package corp.pdb.sio.demo.model.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.mongodb.MongoClient;

/**
 * @author jaradat-pdb
 *
 */
@Configuration
@EnableTransactionManagement
@ComponentScan({"corp.pdb.sio.demo.model"})
@EnableMongoRepositories(basePackages = {"corp.pdb.sio.demo.model.repo.document"})
@Profile(value = {"default", "mongo"})
public class MongoDbDatasourceConfig {
	@Primary
	@Bean
	@ConfigurationProperties(prefix = "spring.data.mongodb")
	public MongoClient mongoClient() {
//		return new MongoClient("localhost:27017");
		return new MongoClient();
	}
}
