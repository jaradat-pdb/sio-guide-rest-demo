package corp.pdb.sio.demo.error;

/**
 * @author jaradat-pdb
 *
 */
public class RegisteredUserDocNotFoundException extends RuntimeException {
    private static final long serialVersionUID = -7205354111515780651L;
    private static final String EX_MSG_TEMPLATE = "Could not find a registered user in system via query by: {name: %s}";

    public RegisteredUserDocNotFoundException(String name) {
        super(String.format(EX_MSG_TEMPLATE, name), new NullPointerException(String.format(EX_MSG_TEMPLATE, name)), false, false);
    }

    public RegisteredUserDocNotFoundException(String name, Exception e) {
        super(String.format(EX_MSG_TEMPLATE, name), e, true, true);
    }

    public RegisteredUserDocNotFoundException(String name, Exception e, boolean enableSuppression, boolean writableStackTrace) {
        super(String.format(EX_MSG_TEMPLATE, name), e, enableSuppression, writableStackTrace);
    }
}
