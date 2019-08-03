package corp.pdb.sio.demo.web.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import corp.pdb.sio.demo.error.RegisteredUserDocNotFoundException;
import corp.pdb.sio.demo.model.data.document.RegisteredUserDoc;
import corp.pdb.sio.demo.model.repo.document.AppUserDocRepository;

/**
 * @author jaradat-pdb
 *
 */
@RestController
public class UserController {
    private final Logger log = LoggerFactory.getLogger(UserController.class);
    private AppUserDocRepository<RegisteredUserDoc> registeredUserDocRepository;

    @Autowired
    public UserController(@Qualifier("registeredUserDocRepository") AppUserDocRepository<RegisteredUserDoc> registeredUserDocRepository) {
        this.registeredUserDocRepository = registeredUserDocRepository;
    }

    @GetMapping("/registeredUsers")
    public List<RegisteredUserDoc> getAllRegisteredUsers() {
        log.trace("Retrieving all registered users from system");
        return registeredUserDocRepository.findAll();
    }

    @PostMapping("/registerUser")
    public RegisteredUserDoc registerNewUser(@RequestBody RegisteredUserDoc doc) {
        log.trace("Registering with system new user: {}", doc);
        return registeredUserDocRepository.save(doc);
    }

    @GetMapping("/registeredUsers/fname={firstName}&lname={lastName}")
    public List<RegisteredUserDoc> getRegisteredUserByFirstName(@PathVariable String firstName, @PathVariable String lastName) {
        log.trace("Retrieving registered user from system via query by: {firstName: {}, lastName: {}}", firstName, lastName);
        List<RegisteredUserDoc> docs = registeredUserDocRepository.findByUserType("REG_USER");
        if(!(docs instanceof List<?>) || docs.isEmpty()) {
            throw new RegisteredUserDocNotFoundException(String.format("%s %s", firstName, lastName));
        }
        
        log.debug("Retrieved registered user from system: {}", docs);
        return docs;
    }
}
