package corp.pdb.sio.demo.data.model.document;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import com.google.gson.Gson;

import corp.pdb.sio.demo.data.model.profile.impl.BasicInfoProfile;

/**
 * A document type model representation of a <code>REGISTERED_USER</code> with the system.
 * 
 * @author jaradat-pdb
 *
 */
@Document(collection="appuser")
public class RegisteredUserDoc extends AppUserDoc {
    private static final Gson GSON = new Gson();
    /* TODO: add method or logic to derive the age of a user if BasicInfoProfile#isbDateStringParseable() returns true */
    private BigInteger age;
    private List<org.bson.Document> profiles;

    RegisteredUserDoc() {}
    /**
     * Generates a new {@link RegisteredUserDoc} from the provided {@link corp.pdb.sio.demo.data.model.profile.impl.BasicInfoProfile basicInfoProfile} parameter.
     * <br>
     * @param basicInfoProfile must not be {@literal null} or empty.
     */
    @PersistenceConstructor
    public RegisteredUserDoc(List<org.bson.Document> profiles) {
        this.profiles = profiles;
        this.setUserType("REG_USER");
    }
    /**
     * Uses the provided firstName and lastName parameters to:
     * <li>first generate a {@link corp.pdb.sio.demo.data.model.profile.impl.BasicInfoProfile basicInfoProfile}</li>
     * <li>then generate a new {@link RegisteredUserDoc}</li>
     * <br>
     * @param fName must not be {@literal null} or empty.
     * @param lName must not be {@literal null} or empty.
     */
    public RegisteredUserDoc(String fName, String lName) {
        this(Arrays.asList(org.bson.Document.parse(GSON.toJson(new BasicInfoProfile(fName, lName)))));
    }
    /**
     * Uses the provided firstName, lastName, and middleName parameters to:
     * <li>first generate a {@link corp.pdb.sio.demo.data.model.profile.impl.BasicInfoProfile basicInfoProfile}</li>
     * <li>then generate a new {@link RegisteredUserDoc}</li>
     * <br>
     * @param fName must not be {@literal null} or empty.
     * @param lName must not be {@literal null} or empty.
     * @param mName can be {@literal null} or empty.
     */
    public RegisteredUserDoc(String fName, String lName, String mName) {
        this(Arrays.asList(org.bson.Document.parse(GSON.toJson(new BasicInfoProfile(fName, lName, mName)))));
    }
    /**
     * 
     * @param fName must not be {@literal null} or empty.
     * @param lName must not be {@literal null} or empty.
     * @param mName can be {@literal null} or empty.
     * @param bDateString should be provided in the format <b><code>yyyyMMdd</code></b>, can be {@literal null} or empty.
     */
    public RegisteredUserDoc(String fName, String lName, String mName, String bDateString) {
        this(Arrays.asList(org.bson.Document.parse(GSON.toJson(new BasicInfoProfile(fName, lName, mName, bDateString)))));
    }

    /**
     * @return the age
     */
    public BigInteger getAge() {
        return age;
    }
    /**
     * @param age the age to set
     */
    public void setAge(BigInteger age) {
        this.age = age;
    }

    /**
     * @return the profiles
     */
    public List<org.bson.Document> getProfiles() {
        return profiles;
    }
    /**
     * @param profiles the profiles to set
     */
    public void setProfiles(List<org.bson.Document> profiles) {
        this.profiles = profiles;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + Objects.hash(getId(), getUserType(), profiles, age);
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
        if (!(obj instanceof RegisteredUserDoc)) {
            return false;
        }
        
        RegisteredUserDoc other = (RegisteredUserDoc) obj;
        return Objects.equals(age, other.age) && Objects.equals(profiles, other.profiles) 
                && Objects.equals(getId(), other.getId()) && Objects.equals(getUserType(), other.getUserType());
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("RegisteredUserDoc [");
        if(getId() != null) {
            builder.append("id=").append(getId());
        }
        if(getUserType() != null) {
            builder.append(", userType=").append(getUserType());
        }
        if(age != null) {
            builder.append(", age=").append(age);
        }
        if(profiles != null && !profiles.isEmpty()) {
            for(org.bson.Document profile : profiles) {
                builder.append(", ").append(profile.toJson());
            }
        }
        builder.append("]");
        return builder.toString();
    }
}
