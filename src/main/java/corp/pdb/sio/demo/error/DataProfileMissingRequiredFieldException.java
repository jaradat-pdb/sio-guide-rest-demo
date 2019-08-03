package corp.pdb.sio.demo.error;

/**
 * @author jaradat-pdb
 *
 */
public class DataProfileMissingRequiredFieldException extends RuntimeException {
    private static final long serialVersionUID = -8496027371494805660L;

    public DataProfileMissingRequiredFieldException(String message, Exception e) {
        super(message, e, true, false);
    }
}
