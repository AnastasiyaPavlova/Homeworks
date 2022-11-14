package homework_5_editForTests.services;

import homework_5_editForTests.Person;


import java.util.List;

public class PrintService {

    public void printPerson(List<Person> arrayList) {
        {
            if (arrayList == null) {
                System.out.println("Запись не найдена");
            } else {
                System.out.println("----------------------------------------------------------------------------------------------");
                for (Person p : arrayList) {
                    System.out.print("Фамилия и имя: " + p.getFirstAndSecondName() + " ,"
                            + "номер телефона " + p.getPhoneNumber() + " ,"
                            + "адрес проживания " + p.getAddress() + ", " + "e-mail: ");
                    p.getEMail().stream().forEach(result -> System.out.print(result + " "));
                    if (arrayList.size() == 0)
                        System.out.println("Запись не найдена");
                    System.out.println();
                }
            }
        }
    }

    public void printPerson(Person person) {
        if (person == null) {
            System.out.println("Запись не найдена");
        } else {
            System.out.println("---------------------------------------------------------------------");
            System.out.print("Фамилия и имя: " + person.getFirstAndSecondName() + " ,"
                    + "номер телефона " + person.getPhoneNumber() + " ,"
                    + "адрес проживания " + person.getAddress() + ", " + "e-mail: ");
            person.getEMail().stream().forEach(result -> System.out.print(result + " "));
            System.out.println();
        }
    }
}



