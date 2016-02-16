package goncharenko.GVV.serviceUseSDataJPA;

import goncharenko.GVV.entity.Contact;

import java.util.List;

/**
 * Created by Vitaliy on 15.02.2016.
 */
public interface ContactService {
    List<Contact> findAll();
    List<Contact> findByFirstName(String firstName);
    List<Contact> findByFirstNameAndLastName(String firstName, String lastName);
}
