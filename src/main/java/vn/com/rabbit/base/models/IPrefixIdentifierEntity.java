package vn.com.rabbit.base.models;

public interface IPrefixIdentifierEntity<T> extends IIdentifierEntity<T> {

    String getPrefix();

    void setPrefix(String prefix);
}