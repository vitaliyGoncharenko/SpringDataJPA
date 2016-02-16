package goncharenko.GVV.forAudit;

import org.springframework.data.domain.AuditorAware;

/**
 * Created by Vitaliy on 15.02.2016.
 */
public class AuditorAwareBean implements AuditorAware<String> {
    public String getCurrentAuditor() {
        return "createdByGoncharenko";
    }
}
