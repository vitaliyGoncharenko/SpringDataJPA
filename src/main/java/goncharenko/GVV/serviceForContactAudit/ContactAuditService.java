package goncharenko.GVV.serviceForContactAudit;

import goncharenko.GVV.entity.ContactAudit;

import java.util.List;

/**
 * Created by Vitaliy on 15.02.2016.
 */
public interface ContactAuditService {
    List<ContactAudit> findAll();
    ContactAudit findById(Long id);
    ContactAudit save(ContactAudit contact);
}
