package homework_1.task_7.orchestra;

import homework_1.task_7.instruments.strings.Bass;
import homework_1.task_7.instruments.strings.Cello;
import homework_1.task_7.instruments.strings.Guitar;
import homework_1.task_7.instruments.strings.Violin;

public class StringOrchestra {
     private Guitar guitar;
    private Violin violin;
    private Cello cello;
    private Bass bass;

    public StringOrchestra() {
        this.guitar = new Guitar();
        this.violin = new Violin();
        this.cello = new Cello();
        this.bass = new Bass();
    }

    public void playYourParts() {
        guitar.playStrings();
        violin.playStrings();
        cello.playStrings();
        bass.playStrings();
    }
}