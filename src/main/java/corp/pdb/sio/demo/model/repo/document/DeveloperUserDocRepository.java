package corp.pdb.sio.demo.model.repo.document;

import org.springframework.stereotype.Repository;

import corp.pdb.sio.demo.model.data.document.DeveloperUserDoc;

/**
 * 
 * @author jaradat-pdb
 *
 */
@Repository
interface DeveloperUserDocRepository extends AppUserDocRepository<DeveloperUserDoc> {
//	public List<DeveloperUserDoc> findByFavoriteLang(String favoriteLang);
//	public DeveloperUserDoc findByFirstNameAndLastNameAndFavoriteLang(String firstName, String lastName, String favoriteLang);
}
