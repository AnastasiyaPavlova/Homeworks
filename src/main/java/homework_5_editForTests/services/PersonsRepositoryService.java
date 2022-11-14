package homework_5_editForTests.services;

import homework_5_editForTests.Person;
import homework_5_editForTests.PersonsRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class PersonsRepositoryService {
    private PersonsRepository personsRepository = new PersonsRepository();


    public List<Person> getAllPersons() {
        return new ArrayList<Person>(personsRepository.returnAllPersons());
    }

    public List<Person> getPersonByName(String namePerson) {
        List<Person> personsArray;
        personsArray = personsRepository.returnAllPersons()
                .stream()
                .filter(x -> x.getFirstAndSecondName().equalsIgnoreCase(namePerson))
                .collect(Collectors.toList());
        if (personsArray.size() == 0) return null;
        else return personsArray;
    }

    public Person getPersonByPhone(String phonePerson) {
        Person person = null;
        for (Person p : personsRepository.returnAllPersons()) {
            if (p.getPhoneNumber().equalsIgnoreCase(phonePerson)) {
                person = p;
            }
        }
        return person;
    }


    public Person getPersonByeMail(String eMailPerson) {
        Person person = null;
        for (Person p : personsRepository.returnAllPersons()) {
            for (String eMail : p.getEMail()) {
                if (eMail.equalsIgnoreCase(eMailPerson)) {
                    person = p;
                }
            }
        }
        return person;
    }

    public void addPerson(String phonePerson, Person person) {
        personsRepository.addPerson(phonePerson, person);
    }

    public void deletePerson(String phonePerson) {
        personsRepository.deletePerson(phonePerson);
    }
}
