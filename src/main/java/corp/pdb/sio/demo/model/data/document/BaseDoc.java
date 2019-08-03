package corp.pdb.sio.demo.model.data.document;

import java.math.BigInteger;

import org.springframework.data.annotation.Id;

/**
 * Base class for document type model classes.
 * 
 * @author jaradat-pdb
 *
 */
class BaseDoc {
    @Id
    private BigInteger id;

    /**
     * Returns the identifier of the document.
     * 
     * @return the id
     */
    BigInteger getId() {
        return id;
    }

    /*
     * (non-Javadoc)
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(Object obj) {
        if(this == obj) {
            return true;
        }
        
        if(this.id == null || obj == null || !(this.getClass().equals(obj.getClass()))) {
            return false;
        }
        
        BaseDoc otherBaseDoc = (BaseDoc) obj;
        return this.id.equals(otherBaseDoc.getId());
    }

    /*
     * (non-Javadoc)
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {
        return id == null ? 0 : id.hashCode();
    }
}
