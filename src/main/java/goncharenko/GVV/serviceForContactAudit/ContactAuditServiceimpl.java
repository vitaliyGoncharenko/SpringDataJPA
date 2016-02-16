package goncharenko.GVV.serviceForContactAudit;

import com.google.common.collect.Lists;
import goncharenko.GVV.entity.ContactAudit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Vitaliy on 15.02.2016.
 */
@Service ("contactAuditService")
@Transactional
public class ContactAuditServiceimpl implements ContactAuditService {
    @Autowired
    private ContactAuditRepository contactAuditRepository;

    @Transactional(readOnly = true)
    public List<ContactAudit> findAll() {
        return Lists.newArrayList(contactAuditRepository.findAll());
    }
    @Transactional(readOnly = true)
    public ContactAudit findById(Long id) {
        return contactAuditRepository.findOne(id);
    }
    public ContactAudit save(ContactAudit contact) {
        return contactAuditRepository.save(contact);
    }
}
