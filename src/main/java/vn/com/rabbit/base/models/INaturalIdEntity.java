package vn.com.rabbit.base.models;

public interface INaturalIdEntity<T> extends IBaseEntity<T> {

    String getCode();

    void setCode(String code);
}