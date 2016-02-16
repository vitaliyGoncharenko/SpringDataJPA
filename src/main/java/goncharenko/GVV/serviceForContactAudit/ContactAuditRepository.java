package goncharenko.GVV.serviceForContactAudit;

import goncharenko.GVV.entity.ContactAudit;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Vitaliy on 15.02.2016.
 */
public interface ContactAuditRepository extends CrudRepository<ContactAudit,Long> {

}
