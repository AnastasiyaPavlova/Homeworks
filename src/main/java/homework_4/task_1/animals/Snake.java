package homework_4.task_1.animals;

import homework_4.task_1.Animal;

public class Snake implements Animal {
    public String type;
    public String name;

    public Snake(String type, String name) {
        this.type = type;
        this.name = name;
    }

    @Override
    public void tellMeWhoYouAre() {
        System.out.println(type + " " + name);
    }

    @Override
    public String getType() {
        return type;
    }

    @Override
    public String getName() {
        return name;
    }
}



