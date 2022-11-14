package homework_5_editForTests.services;


import homework_5_editForTests.Person;


public class WorkWithUsersService {


    private PersonsRepositoryService personsRepositoryService = new PersonsRepositoryService();
    private MenuService menuService = new MenuService();
    private GetDataFromUsersService getDataFromUsersService = new GetDataFromUsersService();
    private PrintService printService = new PrintService();
    private PersonService personService = new PersonService();
    private Person person;


    public void workWithUsers() {
        menuService.mainMenu();
        switch (getDataFromUsersService.getPositiveIntNumber(6)) {
            case 1 -> printAllPerson();
            case 2 -> findPerson();
            case 3 -> addPerson();
            case 4 -> deletePerson();
            case 5 -> editPerson();
            case 6 -> exit();
        }
    }


    public void printAllPerson() {
        printService.printPerson(personsRepositoryService.getAllPersons());
        menuService.returnToMainMenu();
        getDataFromUsersService.getPositiveIntNumber(1);
        workWithUsers();
    }

    public void findPerson() {
        menuService.findPersonMenu();
        switch (getDataFromUsersService.getPositiveIntNumber(4)) {
            case 1 -> findPersonByName();
            case 2 -> findPersonByPhone();
            case 3 -> findPersonByEMail();
            case 4 -> workWithUsers();
        }
    }

    public void findPersonByName() {
        String namePerson = getDataFromUsersService.getStringWithPrintMessageQuery("Введите Фамилию и Имя человека, которого ищете.");
        printService.printPerson(personsRepositoryService.getPersonByName(namePerson));
        findPerson();
    }


    public void findPersonByPhone() {
        String phonePerson = getDataFromUsersService.getStringWithPrintMessageQuery("Ведите номер телефона человека, которого ищете.");
        printService.printPerson(personsRepositoryService.getPersonByPhone(phonePerson));
        findPerson();
    }

    public void findPersonByEMail() {
        String eMailPerson = getDataFromUsersService.getStringWithPrintMessageQuery("Ведите e-mail человека, которого ицете.");
        printService.printPerson(personsRepositoryService.getPersonByeMail(eMailPerson));
        findPerson();
    }

    public void addPerson() {
        menuService.addPersonMenu();
        String phonePerson = getDataFromUsersService.getStringWithPrintMessageQuery("Введите номер телефона человека, которого хотите добавить.");
        person = personsRepositoryService.getPersonByPhone(phonePerson);
        if (person != null) {
            printService.printPerson(person);
            menuService.personExistsInPersonRepositoryMenu();
            switch (getDataFromUsersService.getPositiveIntNumber(3)) {
                case 1 -> selectEditingOptions(person);
                case 2 -> addPerson();
                case 3 -> workWithUsers();
            }
        } else creatAndSavePerson(phonePerson);
    }

    public void creatAndSavePerson(String phonePerson) {
        person = personService.creatPerson(phonePerson);
        personsRepositoryService.addPerson(phonePerson, person);
        System.out.println("Запись добавлена успешно!");
        printService.printPerson(person);
        returnToMain();
    }

    public void returnToMain() {
        menuService.returnToMainMenu();
        getDataFromUsersService.getPositiveIntNumber(1);
        workWithUsers();
    }

    public void deletePerson() {
        menuService.deletePersonMenu();
        String phonePerson = getDataFromUsersService.getStringWithPrintMessageQuery("Введите номер телефона человека, запись о котором хотите удалить.");
        Person person = new Person();
        person = personsRepositoryService.getPersonByPhone(phonePerson);
        if (person == null) {
            System.out.println("Запись с данным номером телефона не найдена.");
            returnToMain();
        } else {
            personsRepositoryService.deletePerson(phonePerson);
            System.out.println("Запись о человеке: ");
            printService.printPerson(person);
            System.out.println("Успешно удалена!");
            returnToMain();
        }
    }


    public void editPerson() {
        menuService.editPersonMenu();
        String phonePerson = getDataFromUsersService.getStringWithPrintMessageQuery("Введите номер телефона человека, запись которого вы хотите отредактировать.");
        Person person = new Person();
        person = personsRepositoryService.getPersonByPhone(phonePerson);
        if (person == null) {
            menuService.personNotExistsInPersonRepositoryMenu();
            switch (getDataFromUsersService.getPositiveIntNumber(3)) {
                case 1 -> creatAndSavePerson(phonePerson);
                case 2 -> editPerson();
                case 3 -> returnToMain();
            }
        } else selectEditingOptions(person);
    }

    public void selectEditingOptions(Person person) {
        menuService.selectEditOptionsMenu();
        switch (getDataFromUsersService.getPositiveIntNumber(4)) {
            case 1 -> editPhonePerson(person);
            case 2 -> editNamePerson(person);
            case 3 -> selectEditEMailOptions(person);
            case 4 -> editAddressPerson(person);
        }
    }

    public void editPhonePerson(Person person) {
        String phonePersonNew = getDataFromUsersService.getStringWithPrintMessageQuery("Введите новый номер телефона.");
        if (personsRepositoryService.getPersonByPhone(phonePersonNew) != null) {
            System.out.println("Невозможно сохранить этот номер телефона у данного человека," +
                    " так как он был найден в другой записи.");
            printService.printPerson(personsRepositoryService.getPersonByPhone(phonePersonNew));
            System.out.println("Редактировать другие параметры или выйти в главное меню? \n 1 - Редактировать другие параметры этой записи. \n 2 - Выйти в главное меню.");
            switch (getDataFromUsersService.getPositiveIntNumber(2)) {
                case 1 -> selectEditingOptions(person);
                case 2 -> returnToMain();
            }
        } else {
            personService.editAndSavePhonePerson(phonePersonNew, person);
            menuService.wantContinueEditMenu();
            switch (getDataFromUsersService.getPositiveIntNumber(3)) {
                case 1 -> selectEditingOptions(person);
                case 2 -> editPerson();
                case 3 -> returnToMain();
            }
        }
    }

    public void editNamePerson(Person person) {
        String name = getDataFromUsersService.getStringWithPrintMessageQuery("Введите новые Фамилию и Имя.");
        personService.editNamePerson(name, person);
        menuService.wantContinueEditMenu();
        switch (getDataFromUsersService.getPositiveIntNumber(3)) {
            case 1 -> selectEditingOptions(person);
            case 2 -> editPerson();
            case 3 -> returnToMain();
        }
    }

    public void selectEditEMailOptions(Person person) {
        menuService.selectEditEMailOptionsMenu();
        switch (getDataFromUsersService.getPositiveIntNumber(2)) {
            case 1 -> editExistsEMail(person);
            case 2 -> addNewEmail(person);
        }
    }


    public void editExistsEMail(Person person) {
        personService.editExistsEMail(person);
        System.out.println("Адрес e-mail успешно изменен!");
        printService.printPerson(person);
        menuService.wantContinueEditMenu();
        switch (getDataFromUsersService.getPositiveIntNumber(3)) {
            case 1 -> selectEditingOptions(person);
            case 2 -> editPerson();
            case 3 -> returnToMain();
        }
    }

    public void addNewEmail(Person person) {
        personService.addNewEMail(person);
        System.out.println("Новый адрес E-Mail успешно добавлен.");
        printService.printPerson(person);
        menuService.wantContinueEditMenu();
        switch (getDataFromUsersService.getPositiveIntNumber(3)) {
            case 1 -> selectEditingOptions(person);
            case 2 -> editPerson();
            case 3 -> returnToMain();
        }
    }

    public void editAddressPerson(Person person) {
        String address = getDataFromUsersService.getStringWithPrintMessageQuery("Введите новый адрес.");
        personService.editAddressPerson(address, person);
        menuService.wantContinueEditMenu();
        switch (getDataFromUsersService.getPositiveIntNumber(3)) {
            case 1 -> selectEditingOptions(person);
            case 2 -> editPerson();
            case 3 -> returnToMain();
        }
    }


    public void exit() {
        menuService.exitMenu();
    }
}











