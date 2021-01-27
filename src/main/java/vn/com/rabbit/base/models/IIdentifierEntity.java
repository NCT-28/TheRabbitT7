package vn.com.rabbit.base.models;

public interface IIdentifierEntity<T> extends INaturalIdEntity<T> {

    String getName();

    void setName(String name);
}