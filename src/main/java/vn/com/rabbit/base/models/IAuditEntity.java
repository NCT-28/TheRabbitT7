package vn.com.rabbit.base.models;

import java.util.Date;

public interface IAuditEntity<T> {

    T getCreatedBy();

    Date getCreatedDate();

    T getUpdatedBy();

    Date getUpdatedDate();
}