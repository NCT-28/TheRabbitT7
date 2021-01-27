package vn.com.rabbit.base.repository.update;

import lombok.experimental.UtilityClass;
import vn.com.rabbit.base.entity.AuditConstant;
import vn.com.rabbit.base.repository.IRepository;
import vn.com.rabbit.base.repository.utils.QueryUtils;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import java.util.Date;
import java.util.Map;
import java.util.UUID;

@UtilityClass
public class UpdateById {

    public <T> Query generateQuery(EntityManager e, Class<T> t, Map<String, Object> p, UUID k) {
        StringBuilder s = new StringBuilder("UPDATE " + QueryUtils.GetNameEntity(t) + " SET ");
        int i = 0;
        for (Map.Entry<String, ?> j : p.entrySet()) {
            if (j.getValue() != null) {
                s.append(j.getKey()).append("=:q").append(i).append(", ");
                i += 1;
            }
        }
        s.append(AuditConstant.updatedBy).append("=:p,");
        s.append(AuditConstant.updatedDate).append("=:k ");
        s.append("WHERE " + IRepository.baseIDName + "=:i ");
        Query q = e.createQuery(s.toString());
        i = 0;
        for (Map.Entry<String, ?> d : p.entrySet()) {
            if (d.getValue() != null) {
                q.setParameter("q" + i, d.getValue());
                i += 1;
            }
        }
       // q.setParameter("p", new AuditorProvider().getCurrentAuditor().orElse(""));
        q.setParameter("k", new Date());
        return q.setParameter("i", k);
    }
}