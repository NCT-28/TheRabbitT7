package vn.com.rabbit.base.models;

public interface IDescriptionEntity<T> extends IIdentifierEntity<T> {

    String getDescription();

    void setDescription(String description);
}