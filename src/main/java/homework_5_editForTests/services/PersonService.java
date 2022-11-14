package homework_5_editForTests.services;

import homework_5_editForTests.Person;

public class PersonService {
    GetDataFromUsersService getDataFromUsersService = new GetDataFromUsersService();
    PersonsRepositoryService personsRepositoryService = new PersonsRepositoryService();
    PrintService printService = new PrintService();

    public Person creatPerson(String phonePerson) {
        String name = getDataFromUsersService.getStringWithPrintMessageQuery("Введите Фамилию и Имя человека, которого хотите добавить.");
        String email = getDataFromUsersService.getStringWithPrintMessageQuery("Введите email человека, которого хотите добавить.");
        String address = getDataFromUsersService.getStringWithPrintMessageQuery("Введите адрес, которого хотите добавить.");
        return new Person(phonePerson, name, email, address);
    }

    public void editAndSavePhonePerson(String phonePersonNew, Person person) {
        personsRepositoryService.deletePerson(person.getPhoneNumber());
        person.setPhoneNumber(phonePersonNew);
        personsRepositoryService.addPerson(phonePersonNew, person);
        System.out.println("Номер телефона успешно изменен");
        printService.printPerson(person);
    }

    public void editNamePerson(String name, Person person) {
        person.setFirstAndSecondName(name);
        System.out.println("Фамилия и Имя успешно изменены!");
        printService.printPerson(person);
    }

    public void editExistsEMail(Person person) {
        System.out.println("Какой из электронных адресов хотите отредактировать?");
        int i;
        for (i = 0; i < person.getEMail().size(); i++) {
            System.out.println(i + 1 + " -  " + person.getEMail().get(i));
        }
        int positionEMail = getDataFromUsersService.getPositiveIntNumber(i);
        String newEmail = getDataFromUsersService.getStringWithPrintMessageQuery("Введите новый адрес e-mail.");
        person.getEMail().set(positionEMail - 1, newEmail);
    }

    public void addNewEMail(Person person) {
        String newEMail = getDataFromUsersService.getStringWithPrintMessageQuery("Введите новый адрес E-Mail.");
        person.setEMail(newEMail);
    }

    public void editAddressPerson(String address, Person person) {
        person.setAddress(address);
        System.out.println("Адрес успешно изменен!");
        printService.printPerson(person);
    }
}
