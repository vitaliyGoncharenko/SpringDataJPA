package goncharenko.GVV.serviceUseSDataJPA;

import com.google.common.collect.Lists;
import goncharenko.GVV.entity.Contact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Vitaliy on 15.02.2016.
 */
@Service("springJpaContactService")
@Transactional
public class ContactServiceImpl implements ContactService {

    @Autowired
    ContactRepository contactRepository;

    @Transactional(readOnly = true)
    public List<Contact> findByFirstName(String firstName) {
        return contactRepository.findByFirstName(firstName);
    }

    @Transactional(readOnly = true)
    public List<Contact> findByFirstNameAndLastName(String firstName, String lastName) {
        return contactRepository.findByFirstNameAndLastName(firstName,lastName);
    }

    @Transactional(readOnly = true)
    public List<Contact> findAll() {
        return Lists.newArrayList(contactRepository.findAll());
    }
}
