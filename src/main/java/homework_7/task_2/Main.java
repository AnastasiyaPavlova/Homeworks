package homework_7.task_2;

import java.util.Scanner;
import java.util.concurrent.Semaphore;

public class Main {
    static Chicken threadChicken;
    static Egg threadEgg;


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Начинается спор, что появилось раньше: Курица или Яйцо");
        System.out.println("Сколько раз участники могут высказаться?");
        int numberOfIterations = scanner.nextInt();
        System.out.println("Кто выскажется последним?");
        System.out.println("1 - Курица");
        System.out.println("2 - Яйцо");
        int winner = scanner.nextInt();
        GiveYourVoice giveYourVoice = new GiveYourVoice(winner);
        threadChicken = new Chicken(giveYourVoice, numberOfIterations);
        threadEgg = new Egg(giveYourVoice, numberOfIterations);
        threadChicken.start();
        threadEgg.start();
    }
}

class Chicken extends Thread {
    GiveYourVoice giveYourVoice;
    int numberOfIterations;

    public Chicken(GiveYourVoice giveYourVoice, int numberOfIterations) {
        this.giveYourVoice = giveYourVoice;
        this.numberOfIterations = numberOfIterations;
    }

    public void run() {
        for (int i = 0; i < numberOfIterations; i++) {
            try {
                sleep(1000);
            } catch (InterruptedException e) {
            }
            giveYourVoice.printChicken();
        }
    }
}

class Egg extends Thread {
    GiveYourVoice giveYourVoice;
    int numberOfIterations;

    public Egg(GiveYourVoice giveYourVoice, int numberOfIterations) {
        this.giveYourVoice = giveYourVoice;
        this.numberOfIterations = numberOfIterations;
    }

    @Override
    public void run() {
        for (int i = 0; i < numberOfIterations; i++) {
            try {
                sleep(1000);
            } catch (InterruptedException e) {
            }
            giveYourVoice.printEgg();
        }
    }
}

class GiveYourVoice {
    int winner;
    Semaphore semChicken;
    Semaphore semEgg;

    public GiveYourVoice(int winner) {
        this.winner = winner;
        if (winner == 1) {
            semChicken = new Semaphore(0);
            semEgg = new Semaphore(1);
        } else {
            semChicken = new Semaphore(1);
            semEgg = new Semaphore(0);
        }
    }

    public void printChicken() {
        try {
            semChicken.acquire();
        } catch (InterruptedException e) {
        }
        System.out.println("Курица!");
        semEgg.release();
    }

    public void printEgg() {
        try {
            semEgg.acquire();
        } catch (InterruptedException e) {
        }
        System.out.println("Яйцо!");
        semChicken.release();
    }
}