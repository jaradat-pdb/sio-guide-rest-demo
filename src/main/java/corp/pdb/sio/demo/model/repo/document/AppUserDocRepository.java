package corp.pdb.sio.demo.model.repo.document;

import java.math.BigInteger;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import corp.pdb.sio.demo.model.data.document.AppUserDoc;

/**
 * @author jaradat-pdb
 *
 */
public interface AppUserDocRepository<T extends AppUserDoc> extends MongoRepository<T, BigInteger> {
    List<T> findByUserType(String userType);
//    T findByFirstNameAndLastName(String firstName, String lastName);
//    T findByFirstNameAndLastNameAndMiddleName(String firstName, String lastName, String middleName);
}
