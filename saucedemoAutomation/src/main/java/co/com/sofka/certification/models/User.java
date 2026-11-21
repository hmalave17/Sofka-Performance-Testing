package co.com.sofka.certification.models;

import java.util.Map;


import static co.com.sofka.certification.utils.Constants.USER_TEST;
import static co.com.sofka.certification.utils.Constants.PASSWORD;
import static co.com.sofka.certification.utils.Constants.NAME;
import static co.com.sofka.certification.utils.Constants.LASTNAME;
import static co.com.sofka.certification.utils.Constants.POSTAL_CODE;
import static co.com.sofka.certification.utils.Utils.getValueOrEmpty;

public class User {
    private String userTest;
    private String password;
    private String name;
    private String lastName;
    private String postalCode;

    public User(Map<String, String> data){
        this.userTest = getValueOrEmpty(data.get(USER_TEST));
        this.password = getValueOrEmpty(data.get(PASSWORD));
        this.name = getValueOrEmpty(data.get(NAME));
        this.lastName = getValueOrEmpty(data.get(LASTNAME));
        this.postalCode = getValueOrEmpty(data.get(POSTAL_CODE));
    }


    public String getUserTest() {
        return userTest;
    }

    public void setUserTest(String userTest) {
        this.userTest = userTest;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }
}
