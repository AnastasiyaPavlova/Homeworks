package homework_5_editForTests;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Person {
    private String phoneNumber;
    private String firstAndSecondName;
    private List<String> arrayEMail;
    private String eMail;
    private String address;

    public Person(String phoneNumber, String firstAndSecondName, String eMail, String address) {
        this.phoneNumber = phoneNumber;
        this.firstAndSecondName = firstAndSecondName;
        this.eMail = eMail;
        arrayEMail = new ArrayList<>();
        this.arrayEMail.add(eMail);
        this.address = address;
    }
    public Person(){}

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getFirstAndSecondName() {
        return firstAndSecondName;
    }

    public void setFirstAndSecondName(String firstAndSecondName) {
        this.firstAndSecondName = firstAndSecondName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<String> getEMail() {
        return this.arrayEMail;
    }

    public void setEMail(String eMail) {
        this.arrayEMail.add(eMail);
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person that = (Person) o;
        return phoneNumber.equals(that.phoneNumber) &&
                firstAndSecondName.equals(that.firstAndSecondName) &&
                Objects.equals(arrayEMail, that.arrayEMail) &&
                address.equals(that.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(phoneNumber, firstAndSecondName, arrayEMail, address);
    }

}
