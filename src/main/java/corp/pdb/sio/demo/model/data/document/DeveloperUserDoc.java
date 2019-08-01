package corp.pdb.sio.demo.model.data.document;

import java.util.Objects;

import org.apache.commons.lang3.StringUtils;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.util.Assert;

/**
 * A document type model representation of a <code>DEVELOPER_USER</code> with the system.
 * 
 * @author jaradat-pdb
 *
 */
@Document(collection="appuser")
public class DeveloperUserDoc extends AppUserDoc {
	private String firstName;
	private String lastName;
	private String middleName;
	private String favoriteLang;

	protected DeveloperUserDoc() {}
	
	/**
	 * Creates a new {@link DeveloperUserDoc} from the given firstName, lastName, and favoriteLang parameters.
	 * 
	 * @param firstName must not be {@literal null} or empty.
	 * @param lastName must not be {@literal null} or empty.
	 * @param favoriteLang can be {@literal null} or empty, represents the developer's favorite || most familiar programming language.
	 */
	public DeveloperUserDoc(String firstName, String lastName, String favoriteLang) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.setUserType("DEV_USER");
		if(StringUtils.isBlank(favoriteLang)) {
			this.favoriteLang = "JAVA";
		} else {
			this.favoriteLang = favoriteLang;
		}
	}
	/**
	 * Creates a new {@link DeveloperUserDoc} from the given firstName, lastName, favoriteLang, and middleName parameters.
	 * 
	 * @param firstName must not be {@literal null} or empty.
	 * @param lastName must not be {@literal null} or empty.
	 * @param favoriteLang can be {@literal null} or empty, represents the developer's favorite || most familiar programming language.
	 * @param middleName must not be {@literal null} empty.
	 */
	public DeveloperUserDoc(String firstName, String lastName, String favoriteLang, String middleName) {
		this(firstName, lastName, favoriteLang);
		
		if(!StringUtils.isEmpty(middleName)) {
			Assert.hasText(middleName, "Text assertion of middleName variable provided failed");
			this.middleName = middleName;
		}
	}

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}
	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}
	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @return the middleName
	 */
	public String getMiddleName() {
		return middleName;
	}
	/**
	 * @param middleName the middleName to set
	 */
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	/**
	 * @return the favoriteLang
	 */
	public String getFavoriteLang() {
		return favoriteLang;
	}
	/**
	 * @param favoriteLang the favoriteLang to set
	 */
	public void setFavoriteLang(String favoriteLang) {
		this.favoriteLang = favoriteLang;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(favoriteLang, firstName, lastName, middleName);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!super.equals(obj)) {
			return false;
		}
		if (!(obj instanceof DeveloperUserDoc)) {
			return false;
		}
		
		DeveloperUserDoc other = (DeveloperUserDoc) obj;
		return Objects.equals(firstName, other.firstName) && Objects.equals(lastName, other.lastName)
				&& Objects.equals(favoriteLang, other.favoriteLang) && Objects.equals(middleName, other.middleName);
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("DeveloperUserDoc [");
		if (firstName != null)
			builder.append("firstName=").append(firstName).append(", ");
		if (lastName != null)
			builder.append("lastName=").append(lastName).append(", ");
		if (middleName != null)
			builder.append("middleName=").append(middleName).append(", ");
		if (favoriteLang != null)
			builder.append("favoriteLang=").append(favoriteLang);
		builder.append("]");
		return builder.toString();
	}
}
