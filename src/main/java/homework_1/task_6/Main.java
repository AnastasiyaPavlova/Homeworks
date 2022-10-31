package homework_1.task_6;

import homework_1.task_6.animals.Cat;
import homework_1.task_6.animals.Cow;
import homework_1.task_6.animals.Snake;

public class Main {
    public static void main(String[] args) {
        Cat cat = new Cat();
        Snake snake = new Snake();
        Cow cow =new Cow();
        cat.tellHowAreYouMoving();
        snake.tellHowAreYouMoving();
        cow.tellHowAreYouMoving();
    }
}