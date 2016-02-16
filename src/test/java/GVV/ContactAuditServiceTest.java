package GVV;

import goncharenko.GVV.entity.ContactAudit;
import goncharenko.GVV.serviceForContactAudit.ContactAuditService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;
import java.util.List;

/**
 * Created by Vitaliy on 15.02.2016.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:app-context-annotation.xml"})
public class ContactAuditServiceTest {
    private static final Logger LOGGER = LoggerFactory.getLogger(ContactAuditServiceTest.class);

    //for testFindAll()
    private static String firstName = "Victor";
    private static String lastName = "Ivanov";
    private static Date birthDate = new Date();

    //for testSave()
    private static String firstNameSave = "Alex";
    private static String lastNameSave = "Svorovich";
    private static Date birthDateSave = new Date();

    //for testFindById()
    private static String firstNameById = "Ekaterina";
    private static String lastNameById = "Petrova";
    private static Date birthDateById = new Date();
    private static Long id = 0L;

    @Autowired
    private ContactAuditService contactAuditService;

    @Test
    public void saveTest (){
        ContactAudit contactAudit = getNewContact(firstNameSave, lastNameSave, birthDateSave);
        ContactAudit contactAuditSaved = contactAuditService.save(contactAudit);

        ContactAudit contacts = contactAuditService.findById(contactAuditSaved.getId());
        Assert.assertEquals(firstNameSave, contacts.getFirstName());
        Assert.assertEquals(lastNameSave, contacts.getLastName());

    }

    @Test
    public void findAllTest(){

        ContactAudit contactAuditForSave = getNewContact(firstName, lastName, birthDate);
        ContactAudit contactAuditSaved = contactAuditService.save(contactAuditForSave);

        List<ContactAudit> contacts = contactAuditService.findAll();
        for(ContactAudit contactAudit: contacts) {
            if(contactAudit.getId()== contactAuditSaved.getId()) {
                Assert.assertEquals(firstName, contactAudit.getFirstName());
                Assert.assertEquals(lastName, contactAudit.getLastName());
            }
        }

        listContacts(contacts);
    }

    @Test
    public void findById(){
        ContactAudit contactAudit = getNewContact(firstNameById, lastNameById, birthDateById);
        ContactAudit contactAuditSaved = contactAuditService.save(contactAudit);

        ContactAudit contact = contactAuditService.findById(contactAuditSaved.getId());
        Assert.assertEquals(firstNameById, contact.getFirstName());
        Assert.assertEquals(lastNameById, contact.getLastName());
        LOGGER.info("Get ContactAudit by id - " + id + " : " + contact);
    }

    private static void listContacts(List<ContactAudit> contacts) {
        LOGGER.info("\nListing contacts without details:");

        for (ContactAudit contact : contacts) {
            LOGGER.info("\n" + contact);
        }
    }

    private static ContactAudit getNewContact(String firstName, String lastName, Date birthDate){
        ContactAudit contactAudit = new ContactAudit();
        contactAudit.setFirstName(firstName);
        contactAudit.setLastName(lastName);
        contactAudit.setBirthDate(birthDate);
        return contactAudit;
    }
}
