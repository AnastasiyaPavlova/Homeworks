package homework_4.task_2;

enum TypeAnimals {
    COW("cow"),
    CAT("cat"),
    DOG("dog"),
    SNAKE("snake");
    private final String typeAnimal;

    TypeAnimals(String typeAnimal) {
        this.typeAnimal = typeAnimal;
    }

    public String getTypeAnimal() {
        return typeAnimal;
    }
}
