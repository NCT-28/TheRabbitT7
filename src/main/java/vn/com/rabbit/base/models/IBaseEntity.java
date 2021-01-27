package vn.com.rabbit.base.models;

import java.io.Serializable;

public interface IBaseEntity<T> extends IAuditEntity<String>, Serializable {

     T getUuid();
}