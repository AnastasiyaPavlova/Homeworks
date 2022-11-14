package homework_5_editForTests;

import java.util.*;

public class PersonsRepository {
    private static HashMap<String, Person> personRepository;

    public PersonsRepository() {
        this.personRepository = new HashMap<>();

        this.personRepository.put("111111111", new Person("111111111", "Человек1",
                "eMail1", "Город1"));
        this.personRepository.put("222222222", new Person("222222222", "Человек1",
                "eMail2", "Город2"));
        this.personRepository.put("333333333", new Person("333333333", "Человек3",
                "eMail3", "Город3"));
        this.personRepository.put("444444444", new Person("444444444", "Человек4",
                "eMail4", "Город4"));
        this.personRepository.put("555555555", new Person("555555555", "Человек5",
                "eMail5", "Город5"));
    }


    public ArrayList<Person> returnAllPersons() {
        return new ArrayList<Person>(personRepository.values());
    }

    public void addPerson(String phoneNumber, Person person) {
        personRepository.put(phoneNumber, person);
          }

    public void deletePerson(String phoneNumber) {
        personRepository.remove(phoneNumber);
    }



}
