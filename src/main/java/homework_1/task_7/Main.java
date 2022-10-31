package homework_1.task_7;

import homework_1.task_7.orchestra.KeysOrchestra;
import homework_1.task_7.orchestra.StringOrchestra;

public class Main {
    public static void main(String[] args) {
        StringOrchestra stringOrchestra = new StringOrchestra();
        KeysOrchestra keysOrchestra = new KeysOrchestra();
        stringOrchestra.playYourParts();
        keysOrchestra.playYourParts();
    }
}