package homework_1.task_7.orchestra;

import homework_1.task_7.instruments.keys.Harpsichord;
import homework_1.task_7.instruments.keys.Organ;
import homework_1.task_7.instruments.keys.Piano;

public class KeysOrchestra {
    private Piano piano;
    private Organ organ;
    private Harpsichord harpsichord;

    public KeysOrchestra() {
        this.piano = new Piano();
        this.organ = new Organ();
        this.harpsichord = new Harpsichord();
    }
    public void playYourParts() {
        piano.playKeys();
        organ.playKeys();
        harpsichord.playKeys();
    }
}


