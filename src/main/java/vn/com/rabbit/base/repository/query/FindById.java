package vn.com.rabbit.base.repository.query;

import lombok.experimental.UtilityClass;
import vn.com.rabbit.base.repository.IRepository;
import vn.com.rabbit.base.repository.manager.EMUtils;
import vn.com.rabbit.base.repository.utils.QueryUtils;

import javax.persistence.EntityManager;
import java.util.Map;
import java.util.UUID;

@UtilityClass
public class FindById {
    private <T> String getQuery(Class<T> t) {
        return "from " + QueryUtils.GetNameEntity(t) + " where " + IRepository.baseIDName + "=:p";
    }

    // ================================== [] ==================================
    // ================================== [] ==================================
    public <T> T get(EntityManager e, Class<T> t, UUID i) {
        return EMUtils.singleResult(e, e.createQuery(getQuery(t), t).setParameter("p", i));
    }

    // ================================== [RESULT] ==================================
    // ================================== [RESULT] ==================================
    public <T, R> R get(EntityManager e, Class<T> t, UUID i, String c, Class<R> r) {
        return EMUtils.singleResult(e, e.createQuery(QueryUtils.querySelect(c) + getQuery(t), r).setParameter("p", i));
    }

    // ================================== [DTO] ==================================
    // ================================== [DTO] ==================================
    public <T, D> D get(EntityManager e, Class<T> t, Class<D> d, UUID i, String... c) {
        return EMUtils.singleResult(e, e.createQuery(QueryUtils.querySelect(d, c) + getQuery(t), d).setParameter("p", i));
    }

    // ================================== [MAP] ==================================
    // ================================== [MAP] ==================================
    public <T> Map<String, ?> get(EntityManager e, Class<T> t, UUID i, String... c) {
        return EMUtils.singleResult(e, e.createQuery(QueryUtils.querySelect(c) + getQuery(t)).setParameter("p", i), c);
    }
}