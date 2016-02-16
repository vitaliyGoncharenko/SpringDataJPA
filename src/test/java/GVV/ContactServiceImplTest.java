package GVV;

import goncharenko.GVV.entity.Contact;
import goncharenko.GVV.serviceUseSDataJPA.ContactService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * Created by Vitaliy on 10.02.2016.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:app-context-annotation.xml"})
public class ContactServiceImplTest {
    private static final Logger LOGGER = LoggerFactory.getLogger(ContactServiceImplTest.class);

    //for testFindAll()
    private static String firstNameExpected = "Chris";
    private static String lastNameExpected = "Schaefer";

    @Autowired
    private ContactService contactService;

    @Test
    public void testFindAll() throws Exception {
        List<Contact> contacts = contactService.findAll();
        Assert.assertEquals(firstNameExpected, contacts.get(0).getFirstName());
        Assert.assertEquals(lastNameExpected, contacts.get(0).getLastName());
        listContacts(contacts);
    }

    @Test
    public void testFindByFirstName() throws Exception {
        List<Contact> contacts = contactService.findByFirstName(firstNameExpected);
        Assert.assertEquals(firstNameExpected, contacts.get(0).getFirstName());
        Assert.assertEquals(lastNameExpected, contacts.get(0).getLastName());
        listContacts(contacts);
    }

    @Test
    public void testFindByFirstNameAndLastName() throws Exception {
        List<Contact> contacts = contactService.findByFirstNameAndLastName(firstNameExpected, lastNameExpected);
        Assert.assertEquals(firstNameExpected, contacts.get(0).getFirstName());
        Assert.assertEquals(lastNameExpected, contacts.get(0).getLastName());
        listContacts(contacts);
    }

    private static void listContacts(List<Contact> contacts) {
        LOGGER.info("\nListing contacts without details:");

        for (Contact contact : contacts) {
            LOGGER.info("\n" + contact);
        }
    }


}