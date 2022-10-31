package homework_4.task_1;

public abstract interface Animal {
    public default String getType() {
        return "Я не владею этой информацией";
    }

    public default String getName() {
        return "Я не владею этой информацией";
    }

    abstract void tellMeWhoYouAre();
}

