package homework_7.task_1;

public class Main {
    static Ping threadPing;
    static Pong threadPong;

    public static void main(String[] args) {
        PrintPingPong printPingPong = new PrintPingPong();
        threadPing = new Ping(printPingPong);
        threadPong = new Pong(printPingPong);
        threadPing.setPriority(4);
        threadPong.setPriority(1);
        threadPing.start();
        threadPong.start();
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
        }
        threadPing.interrupt();
        threadPong.interrupt();
    }
}

class Ping extends Thread {
    PrintPingPong printPingPong;

    public Ping(PrintPingPong printPingPong) {
        this.printPingPong = printPingPong;
    }

    public void run() {
        try {
            while (!isInterrupted()) {
                printPingPong.printPing();
                sleep(1000);
            }
        } catch (InterruptedException ex) {
            interrupt();
        }
    }
}

class Pong extends Thread {
    PrintPingPong printPingPong;

    public Pong(PrintPingPong printPingPong) {
        this.printPingPong = printPingPong;
    }

    @Override
    public void run() {
        try {
            while (!isInterrupted()) {
                sleep(1000);
                printPingPong.printPong();
            }
        } catch (InterruptedException ex) {
            interrupt();
        }
    }
}

class PrintPingPong {
    public synchronized void printPing() throws InterruptedException {
        System.out.print("Пинг");
        notify();
        wait();
    }

    public synchronized void printPong() throws InterruptedException {
        System.out.println("-Понг");
        notify();
        wait();
    }
}


