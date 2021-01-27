package vn.com.rabbit.base.models;

import java.util.Date;

import vn.com.rabbit.base.enums.Gender;

public interface IPeopleDetailsEntity<T> extends IBaseEntity<T> {

    String getName();

    void setName(String name);

    String getEmail();

    void setEmail(String email);

    String getPhoneNumber();

    void setPhoneNumber(String phoneNumber);

    Gender getGender();

    void setGender(Gender gender);

    Date getBirthday();

    void setBirthday(Date birthday);

    String getIdentityCard();

    void setIdentityCard(String identityCard);

    Date getDateOfSupply();

    void setDateOfSupply(Date dateOfSupply);

    String getLocationProvided();

    void setLocationProvided(String locationProvided);
}