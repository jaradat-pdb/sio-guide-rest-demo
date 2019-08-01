package corp.pdb.sio.demo.error;

/**
 * @author jaradat-pdb
 *
 */
public class RegisteredUserDocNotFoundException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public RegisteredUserDocNotFoundException(String name) {
		super(String.format("Could not find a registered user in system via query by: {name: %s}", name));
	}
}
