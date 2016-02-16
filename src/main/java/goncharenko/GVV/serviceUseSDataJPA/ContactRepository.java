package goncharenko.GVV.serviceUseSDataJPA;

import goncharenko.GVV.entity.Contact;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by Vitaliy on 15.02.2016.
 */
public interface ContactRepository extends CrudRepository<Contact, Long> {
    List<Contact> findByFirstName(String firstName);
    List<Contact> findByFirstNameAndLastName(String firstName, String lastName);
}
