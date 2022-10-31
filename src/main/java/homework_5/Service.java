package homework_5;


import java.util.List;
import java.util.Scanner;

public class Service {
    int choice = 0;
    Scanner scanner = new Scanner(System.in);
    Repository myRepository = new Repository();
    boolean scan;

    public void work() {
        menu();
        choice = valueCheck();
        while (choice < 1 || choice > 6) {
            System.out.println("Число должно быть от 1 до 6. Повторите ввод.");
            choice = valueCheck();
        }
        switch (choice) {
            case 1 -> menu1();
            case 2 -> menu2();
            case 3 -> menu3();
            case 4 -> menu4();
            case 5 -> menu5();
            case 6 -> menu6();
        }
    }

    public void menu() {
        System.out.println("Добро пожаловать в записную книжку!");
        System.out.println("Выберите, что Вы хотите сделать:");
        System.out.println("1 - Вывести на экран всех людей и их данные.");
        System.out.println("2 - Найти человека по имени, номеру телефона или e-mail.");
        System.out.println("3 - Добавить запись о человеке.");
        System.out.println("4 - Удалить запись о человеке с определенным номером телефона.");
        System.out.println("5 - Редактировать данные о человеке с определенным номером телефона.");
        System.out.println("6 - Завершить работу с программой.");
    }

    public int valueCheck() {
        scan = true;
        int k = 0;
        while (scan) {
            if (!scanner.hasNextInt()) {
                System.out.println("Похоже вы ввели не число. Повторите ввод.");
                scanner.nextLine();
            } else {
                k = scanner.nextInt();
                scanner.nextLine();
                scan = false;
            }
        }
        return k;
    }

    public void returnToMainMenu() {
        System.out.println();
        System.out.println("1 - Вернуться в главное меню.");
        choice = valueCheck();
        while (choice != 1) {
            System.out.println("Для выхода в главное меню введите 1.");
            choice = valueCheck();
        }
        work();
    }

    public void menu1() {
        System.out.println("Записи вашей записной книжки:");
        myRepository.consoleOutputRepository();
        returnToMainMenu();
    }

    public void menu2() {
        System.out.println("Мы ищем запись в записной книжке.");
        System.out.println("По какому параметру будем искать?");
        System.out.println("1 - По имени.");
        System.out.println("2 - По момеру телефона.");
        System.out.println("3 - по e-mail.");
        choice = valueCheck();
        while (choice < 1 || choice > 3) {
            System.out.println("Выберите 1,2 или 3.");
            choice = valueCheck();
        }
        switch (choice) {
            case 1 -> {
                List<Person> personArrayList;
                System.out.println("Введите Фамилию и Имя человека, которого ищете.");
                String namePerson = scanner.nextLine();
                personArrayList =
                        myRepository.searchForName(namePerson);
                if (personArrayList == null) {
                    System.out.println("Запись не найдена.");
                    returnToMainMenu();
                } else {
                    for (Person p : personArrayList) {
                        myRepository.consoleOutputPerson(p);
                    }
                }
                returnToMainMenu();
            }
            case 2 -> {
                System.out.println("Ведите номер телефона человека, которого ищете.");
                String numberPhone = scanner.nextLine();
                Person person;
                person = myRepository.searchForNumber(numberPhone);
                if (person == null) {
                    System.out.println("Запись не найдена.");
                    returnToMainMenu();
                } else {
                    myRepository.consoleOutputPerson(person);
                    returnToMainMenu();
                }
            }
            case 3 -> {

                System.out.println("Ведите e-mail человека, которого ицете.");
                String eMailPerson = scanner.nextLine();
                Person person;
                person = myRepository.searchForEMail(eMailPerson);
                if (person == null) {
                    System.out.println("Запись не найдена.");
                    returnToMainMenu();
                } else {
                    myRepository.consoleOutputPerson(person);
                }
            }
        }
    }


    public void menu3() {
        System.out.println("Мы добавляем новую запись о человеке");
        System.out.println("Введите номер телефона.");
        String numberPhone = scanner.nextLine();
        menu3(numberPhone);
    }

    public void menu3(String numberPhone) {
        Person person;
        person = myRepository.searchForNumber(numberPhone);
        if (person != null) {
            System.out.println("Запись с таким номером телефона уже существует.");
            System.out.println("Что будем делать?");
            System.out.println("1 - Посмотреть запись.");
            System.out.println("2 - Редактировать запись.");
            System.out.println("3 - Возврат в главное меню. ");
            choice = valueCheck();
            while (choice < 1 || choice > 3) {
                System.out.println("Выберите 1,2 или 3.");
                choice = valueCheck();
            }
            switch (choice) {
                case 1 -> {
                    myRepository.consoleOutputPerson(person);
                    returnToMainMenu();
                }
                case 2 -> menu5(numberPhone);
                case 3 -> work();
            }
        } else {
            System.out.println("Введите Фамилию и Имя.");
            String name = scanner.nextLine();
            System.out.println("Ведите адрес E-Mail.");
            String email = scanner.nextLine();
            System.out.println("Ведите адрес проживания.");
            String address = scanner.nextLine();
            Person person1 = new Person(numberPhone, name, email, address);
            System.out.println("Хотите добавить дополнительный адрес E-Mail.");
            System.out.println("1 - Добавить дополнительный адрес E-Mail?.");
            System.out.println("2 - Не буду добавлять дополнительный адрес E-Mail.");
            choice = valueCheck();
            while (choice < 1 || choice > 2) {
                System.out.println("Выберите 1 или 2.");
                choice = valueCheck();
            }
            switch (choice) {
                case 1 -> {
                    System.out.println("Введите дополнительный адрес E-Mail.");
                    email = scanner.nextLine();
                    person1.setEMail(email);
                    myRepository.repository.put(numberPhone, person1);
                }
                case 2 -> myRepository.addPerson(numberPhone, person1);

            }
            System.out.println("Новая запись о человеке:");
            myRepository.consoleOutputPerson(person1);
            System.out.println("Успешно добавлена в записную книжку!");
            returnToMainMenu();
        }
    }


    public void menu4() {
        System.out.println("Мы удаляем запись из записной книжки");
        String numberPhone;
        Person person;
        System.out.println("Введите номер телефона человека, запись о котором хотите удалить.");
        numberPhone = scanner.nextLine();
        person = myRepository.searchForNumber(numberPhone);
        if (person == null) {
            System.out.println("Запись с данным номером телефона не найдена.");
            returnToMainMenu();
        } else {
            myRepository.deletePerson(numberPhone);
            System.out.println("Запись о человеке: ");
            myRepository.consoleOutputPerson(person);
            System.out.println("Успешно удалена!");
            System.out.println();
            System.out.println("Хотите продолжить удаление записей?");
            System.out.println("1 - Продолжить удаление записей.");
            System.out.println("2 - Вернутся в главное меню.");
            choice = valueCheck();
            while (choice < 1 || choice > 2) {
                System.out.println("Выберите 1 или 2.");
                choice = valueCheck();
            }
            switch (choice) {
                case 1 -> menu4();
                case 2 -> returnToMainMenu();
            }
        }
    }

    public void menu5() {
        System.out.println("Мы редактируем запись записной книжки");
        System.out.println("Введите номер телефона человека, запись которого вы хотите отредактировать.");
        String numberPhone = scanner.nextLine();
        Person person;
        person = myRepository.searchForNumber(numberPhone);
        if (person == null) {
            System.out.println("Записи с таким номером телефона не существует.");
            System.out.println("Что будем делать?");
            System.out.println("1 - Добавить запись с таким номером телефона.");
            System.out.println("2 - Будем редактировать другую запись.");
            System.out.println("3 - Выход в главное меню.");
            choice = valueCheck();
            while (choice < 1 || choice > 3) {
                System.out.println("Выберите 1, 2 или 3.");
                choice = valueCheck();
            }
            switch (choice) {
                case 1 -> menu3(numberPhone);
                case 2 -> menu5();
                case 3 -> returnToMainMenu();
            }
        } else menu5(numberPhone);
    }

    public void menu5(String numberPhone) {
        System.out.println("Мы редактируем запись:");
        Person person;
        String numberPhoneNew;
        person = myRepository.searchForNumber(numberPhone);
        myRepository.consoleOutputPerson(person);
        System.out.println("Какой параметр будем редактировать?");
        System.out.println("1 - Номер телефона.");
        System.out.println("2 - Фамилию и Имя.");
        System.out.println("3 - Адрес E-Mail.");
        System.out.println("4 - Адрес проживания.");
        choice = valueCheck();
        while (choice < 1 || choice > 4) {
            System.out.println("Выберите 1, 2, 3 или 4.");
            choice = valueCheck();
        }
        switch (choice) {
            case 1 -> {
                System.out.println("Введите новый номер телефона.");
                numberPhoneNew = scanner.nextLine();
                if (myRepository.searchForNumber(numberPhoneNew) != null) {
                    System.out.println("Невозможно сохранить этот номер телефона у данного человека," +
                            " так как он был найден в другой записи.");
                    myRepository.consoleOutputPerson(myRepository.searchForNumber(numberPhoneNew));
                    System.out.println("Редактировать другие параметры или выйти в главное меню?");
                    System.out.println("1 - Выйти в главное меню.");
                    System.out.println("2 - Редактировать параметры.");
                    choice = valueCheck();
                    while (choice < 1 || choice > 2) {
                        System.out.println("Выберите 1 или 2.");
                        choice = valueCheck();
                    }
                    switch (choice) {
                        case 1 -> returnToMainMenu();
                        case 2 -> menu5();
                    }
                } else {
                    person.setPhoneNumber(numberPhoneNew);
                    System.out.println("Номер телефона успешно изменен!");
                    myRepository.consoleOutputPerson(person);
                }
            }

            case 2 -> {
                System.out.println("Введите новые Фамилию и Имя.");
                String name = scanner.nextLine();
                person.setFirstAndSecondName(name);
                System.out.println("Фамилия и Имя успешно изменены!");
                myRepository.consoleOutputPerson(person);
            }
            case 3 -> {
                System.out.println("Хотите отредактироваnь существующий E-Mail или добавить новый?");
                System.out.println("1 - Редактировать существующий E-Mail.");
                System.out.println("2 - Добавить новый E-Mail.");
                while (choice < 1 || choice > 2) {
                    System.out.println("Выберите 1 или 2.");
                    choice = valueCheck();
                }
                switch (choice) {
                    case 1 -> {
                        System.out.println("Какой из электронных адресов хотите отредактировать?");
                        int i;
                        for (i = 0; i < person.getEMail().size(); i++) {
                            System.out.println(i + 1 + " -  " + person.getEMail().get(i));
                        }
                        choice = valueCheck();
                        while (choice < 1 || choice > i) {
                            System.out.println("Выберите от 1 до " + i + 1 + ".");
                            choice = valueCheck();
                        }
                        System.out.println("Введите новый адрес e-mail.");
                        String mail = scanner.nextLine();
                        person.changeEMail(choice - 1, mail);
                        System.out.println("Адрес e-mail успешно изменен!");
                        myRepository.consoleOutputPerson(person);
                    }
                    case 2 -> {
                        System.out.println("Введите новый адрес E-Mail.");
                        String mail = scanner.nextLine();
                        person.setEMail(mail);
                        System.out.println("Новый адрес E-Mail успешно добавлен.");
                        myRepository.consoleOutputPerson(person);
                    }
                }

            }
            case 4 -> {
                System.out.println("Введите новый адрес проживания.");
                String address = scanner.nextLine();
                person.setAddress(address);
                System.out.println("Адрес проживания испешно изменен!");
                myRepository.consoleOutputPerson(person);
            }
        }
        myRepository.deletePerson(numberPhone);
        myRepository.addPerson(person.getPhoneNumber(), person);
        System.out.println("Хотите продолжить редактирование?");
        System.out.println("1 - Выйти в главное меню.");
        System.out.println("2 - Продолжить редактирование этой записи.");
        System.out.println("3 - Редактировать другую запись.");

        choice = valueCheck();
        while (choice < 1 || choice > 3) {
            System.out.println("Выберите 1, 2 или 3.");
            choice = valueCheck();
        }
        switch (choice) {
            case 1 -> returnToMainMenu();
            case 2 -> menu5(numberPhone);
            case 3 -> menu5();
        }
    }

    public void menu6() {
        System.out.println();
        System.out.println("До свидания! Хорошего дня!");
    }
}










