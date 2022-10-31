package homework_5;

import java.util.*;

import java.util.stream.Collectors;

public class Repository {
    HashMap<String, Person> repository;

    public Repository() {
        this.repository = new HashMap<>();
        this.repository.put("111111111", new Person("111111111", "Человек1",
                "eMail1", "Город1"));
        this.repository.put("222222222", new Person("222222222", "Человек1",
                "eMail2", "Город2"));
        this.repository.put("333333333", new Person("333333333", "Человек3",
                "eMail3", "Город3"));
        this.repository.put("444444444", new Person("444444444", "Человек4",
                "eMail4", "Город4"));
        this.repository.put("555555555", new Person("555555555", "Человек5",
                "eMail5", "Город5"));
    }

    public List<Person> searchForName(String name) {
        List<Person> myArrayList;
        myArrayList = repository
                .values()
                .stream()
                .filter(x -> x.getFirstAndSecondName().equalsIgnoreCase(name))
                .collect(Collectors.toList());
        if (myArrayList.size() != 0)
            return myArrayList;
        else return null;
    }

    public Person searchForNumber(String phoneNumber) {
        return repository.get(phoneNumber);
    }

    public Person searchForEMail(String eMail) {
        Person person;
        person = null;
        for (Person p : repository.values()) {
            for (String string : p.getEMail()) {
                if (string.equalsIgnoreCase(eMail)) {
                    person = p;
                }
            }
        }
        return person;
    }

    public void addPerson(String phoneNumber, Person person) {
        repository.put(phoneNumber, person);
    }

    public void deletePerson(String phoneNumber) {
        repository.remove(phoneNumber);
    }

    public void consoleOutputRepository() {
        for (Map.Entry<String, Person> el : repository.entrySet()) {
            System.out.print("Фамилия и имя: " + el.getValue().getFirstAndSecondName() + ",  "
                    + "номер телефона: " + el.getKey() + ",  ");
            System.out.print("e-mail: ");
            el.getValue().getEMail().stream().forEach(result -> System.out.print(result + ", "));
            System.out.print("  адрес проживания: " + el.getValue().getAddress());
            System.out.println();
        }
    }

    public void consoleOutputPerson(Person person) {
        System.out.print("Фамилия и имя: " + person.getFirstAndSecondName() + " ,"
                + "номер телефона " + person.getPhoneNumber() + " ,"
                + "адрес проживания " + person.getAddress() + ", " + "e-mail: ");
        person.getEMail().stream().forEach(result -> System.out.print(result + " "));
        System.out.println();
    }
}
