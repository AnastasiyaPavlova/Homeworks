package homework_4.task_1;

import homework_4.task_1.animals.Cat;
import homework_4.task_1.animals.Cow;
import homework_4.task_1.animals.Dog;
import homework_4.task_1.animals.Snake;

import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        String type;
        String name;
        List<Animal> animalArrayList = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        int i = 0;
        while (i == 0) {
            System.out.println("Введите тип животного (Cow, Cat, Dog или Snake)");
            type = scanner.nextLine();
            while (!type.equalsIgnoreCase("Cow") && !type.equalsIgnoreCase("Cat") &&
                    !type.equalsIgnoreCase("Dog") && !type.equalsIgnoreCase("Snake")
                    && !type.equalsIgnoreCase("достаточно")) {
                System.out.println("Тип животного введен неверно. Повторите ввод");
                type = scanner.nextLine();
            }
            if (!type.equalsIgnoreCase("достаточно")) {
                System.out.println("Введите имя животного");
                name = scanner.nextLine();
                if (!name.equalsIgnoreCase("достаточно")) {
                    switch (type.toLowerCase()) {
                        case "cow" -> animalArrayList.add(new Cow(type, name));
                        case "cat" -> animalArrayList.add(new Cat(type, name));
                        case "dog" -> animalArrayList.add(new Dog(type, name));
                        case "snake" -> animalArrayList.add(new Snake(type, name));
                    }
                } else i = 1;
            } else i = 1;
        }
        List<String> nameList = new ArrayList<>();

        nameList = animalArrayList.stream().map(x -> x.getName().toLowerCase()).distinct().collect(Collectors.toList());
        for (String s : nameList) {
            System.out.print(s + ":  ");
            for (Animal animal : animalArrayList) {
                if (animal.getName().equalsIgnoreCase(s)) {
                    System.out.print(animal.getType().toLowerCase() + " ");
                }
            }
            System.out.println();
        }
    }
}



