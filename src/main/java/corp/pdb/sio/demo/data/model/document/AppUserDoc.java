package corp.pdb.sio.demo.model.data.document;

import lombok.EqualsAndHashCode;

/**
 * A base document type model representation of an <code>APP_USER</code> within the system.
 * 
 * @author jaradat-pdb
 *
 */
@EqualsAndHashCode(callSuper = true)
public class AppUserDoc extends BaseDoc {
    private String userType;

    public AppUserDoc() {
        super();
    }

    /**
     * @return the userType
     */
    String getUserType() {
        return userType;
    }
    /**
     * @param userType the userType to set
     */
    void setUserType(String userType) {
        this.userType = userType;
    }
}
