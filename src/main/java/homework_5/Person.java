package homework_5;

import java.util.ArrayList;

public class Person {
    private String phoneNumber;
    private String firstAndSecondName;
    private ArrayList<String> arrayEMail;
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

    public void setEMail(String eMail) {
        this.arrayEMail.add(eMail);
    }

    public void changeEMail(int i, String eMail) {
        this.arrayEMail.set(i, eMail);
    }

    public ArrayList<String> getEMail() {
        return this.arrayEMail;
    }

}
