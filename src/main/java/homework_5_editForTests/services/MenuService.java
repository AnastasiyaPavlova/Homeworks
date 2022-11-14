package homework_5_editForTests.services;

public class MenuService {


    public void mainMenu() {
        System.out.println("----------------------------------------------------------------------------------------------");
        System.out.println("Добро пожаловать в записную книжку!");
        System.out.println("Выберите, что Вы хотите сделать:");
        System.out.println("1 - Вывести на экран всех людей и их данные.");
        System.out.println("2 - Найти человека по имени, номеру телефона или e-mail.");
        System.out.println("3 - Добавить запись о человеке.");
        System.out.println("4 - Удалить запись о человеке с определенным номером телефона.");
        System.out.println("5 - Редактировать данные о человеке с определенным номером телефона.");
        System.out.println("6 - Завершить работу с программой.");
        System.out.println("----------------------------------------------------------------------------------------------");
    }

    public void returnToMainMenu() {
        System.out.println("----------------------------------------------------------------------------------------------");
        System.out.println("1 - Вернуться в главное меню.");
        System.out.println("----------------------------------------------------------------------------------------------");
    }

    public void findPersonMenu() {
        System.out.println("----------------------------------------------------------------------------------------------");
        System.out.println("Мы ищем запись в записной книжке.");
        System.out.println("По какому параметру будем искать?");
        System.out.println("1 - По имени.");
        System.out.println("2 - По момеру телефона.");
        System.out.println("3 - по e-mail.");
        System.out.println("4 - Вернуться в главное меню.");
        System.out.println("----------------------------------------------------------------------------------------------");
    }

    public void addPersonMenu() {
        System.out.println("----------------------------------------------------------------------------------------------");
        System.out.println("Мы добавляем новую запись о человеке");
        System.out.println("----------------------------------------------------------------------------------------------");
    }

    public void personExistsInPersonRepositoryMenu() {
        System.out.println("----------------------------------------------------------------------------------------------");
        System.out.println("Запись с таким номером телефона уже существует.");
        System.out.println("Что будем делать?");
        System.out.println("1 - Редактировать эту запись.");
        System.out.println("2 - Добавить другую запись.");
        System.out.println("3 - Возврат в главное меню. ");
        System.out.println("----------------------------------------------------------------------------------------------");
    }

    public void deletePersonMenu() {
        System.out.println("----------------------------------------------------------------------------------------------");
        System.out.println("Мы удаляем запись о человеке");
        System.out.println("----------------------------------------------------------------------------------------------");
    }

    public void editPersonMenu() {
        System.out.println("----------------------------------------------------------------------------------------------");
        System.out.println("Мы редактируем запись записной книжки");
        System.out.println("----------------------------------------------------------------------------------------------");
    }

    public void personNotExistsInPersonRepositoryMenu() {
        System.out.println("Записи с таким номером телефона не существует.");
        System.out.println("Что будем делать?");
        System.out.println("1 - Добавить запись с таким номером телефона.");
        System.out.println("2 - Будем редактировать другую запись.");
        System.out.println("3 - Выход в главное меню.");
    }

    public void selectEditOptionsMenu() {
        System.out.println("Какой параметр будем редактировать?");
        System.out.println("1 - Номер телефона.");
        System.out.println("2 - Фамилию и Имя.");
        System.out.println("3 - Адрес E-Mail.");
        System.out.println("4 - Адрес проживания.");
    }

    public void wantContinueEditMenu() {
        System.out.println("Хотите продолжить редактирование?");
        System.out.println("1 - Продолжить редактирование этой записи.");
        System.out.println("2 - Редактировать другую запись.");
        System.out.println("3 - Выйти в главное меню.");
    }

    public void selectEditEMailOptionsMenu() {
        System.out.println("Хотите отредактировать существующий E-Mail или добавить новый?");
        System.out.println("1 - Редактировать существующий E-Mail.");
        System.out.println("2 - Добавить новый E-Mail.");
    }

    public void exitMenu() {
        System.out.println();
        System.out.println("До свидания! Хорошего дня!");
    }
}
