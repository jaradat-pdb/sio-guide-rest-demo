package corp.pdb.sio.demo.data.repo.document;

import java.math.BigInteger;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import corp.pdb.sio.demo.data.model.document.AppUserDoc;

/**
 * @author jaradat-pdb
 *
 */
public interface AppUserDocRepository<T extends AppUserDoc> extends MongoRepository<T, BigInteger> {
    List<T> findByUserType(String userType);
}
