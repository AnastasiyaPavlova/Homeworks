package homework_4.task_2;

import homework_4.task_2.animals.Cat;
import homework_4.task_2.animals.Cow;
import homework_4.task_2.animals.Dog;
import homework_4.task_2.animals.Snake;

import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        String type;
        String name;
        int age;
        Scanner scanner = new Scanner(System.in);
        List<Animal> animalArrayList = new ArrayList<>();
        int i = 0;

        while (i == 0) {
            System.out.println("Введите тип животного (Cow, Cat, Dog или Snake)");
            type = scanner.nextLine();
            while (!valueCheck(type) && !type.equalsIgnoreCase("достаточно")) {
                System.out.println("Тип животного введен неверно. Повторите ввод");
                type = scanner.nextLine();
            }
            if (!type.equalsIgnoreCase("достаточно")) {
                System.out.println("Введите имя животного");
                name = scanner.nextLine();
                if (!name.equalsIgnoreCase("достаточно")) {
                    System.out.println("Введите возраст животного");
                    age = scanner.nextInt();
                    scanner.nextLine();

                    switch (valueEnum(type)) {
                        case COW -> {
                            animalArrayList.add(new Cow(type, name, age));
                        }
                        case CAT -> animalArrayList.add(new Cat(type, name, age));
                        case DOG -> animalArrayList.add(new Dog(type, name, age));
                        case SNAKE -> animalArrayList.add(new Snake(type, name, age));
                    }
                } else i = 1;
            } else i = 1;
        }

        Comparator<Animal> sortByType = ((o1, o2) -> o1.getType().compareToIgnoreCase(o2.getType()));
        Comparator<Animal> sortByName = (p, o) -> p.getName().compareToIgnoreCase(o.getName());

        List<Animal> sortAnimal = animalArrayList.stream()
                .sorted(sortByType.thenComparingInt(Animal::getAge).thenComparing(sortByName)).collect(Collectors.toList());
        for (Animal animal : sortAnimal) {
            System.out.println(animal.getType() + " " + animal.getAge() + " " + animal.getName());
        }
    }

    private static boolean valueCheck(String s) {
        boolean t = false;
        for (TypeAnimals ta : TypeAnimals.values()) {
            if (ta.getTypeAnimal().equalsIgnoreCase(s)) {
                t = true;
            }
        }
        return t;
    }

    private static TypeAnimals valueEnum(String s) {
        for (TypeAnimals ta : TypeAnimals.values()) {
            if (ta.getTypeAnimal().equalsIgnoreCase(s)) {
                return ta;
            }
        }
        return null;
    }
}




