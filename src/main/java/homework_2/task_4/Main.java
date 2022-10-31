package homework_2.task_4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        int numberOfWord;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> anagramsList = new ArrayList<>();
        ArrayList<String> notAnagramsList = new ArrayList<>();
        System.out.println("Сколько слов вы будете вводить?");
        numberOfWord = Integer.parseInt(reader.readLine());
        ArrayList<String> list = new ArrayList<>();
        System.out.println("Введите слова");
        for (int i = 0; i < numberOfWord; i++) {
            list.add(reader.readLine());
        }
        int i = 0;
        while (list.size() >= 2) {
            for (int j = i + 1; j < list.size(); j++) {
                if (list.get(i).length() == list.get(j).length()) {
                    if (list.get(i).equalsIgnoreCase(list.get(j))) {
                        notAnagramsList.add(list.get(i));
                        notAnagramsList.add(list.get(j));
                        list.remove(j);
                        list.remove(i);
                        j = 0;
                    } else {
                        char[] symbols = list.get(i).toLowerCase().toCharArray();
                        Arrays.sort(symbols);
                        char[] symbols1 = list.get(j).toLowerCase().toCharArray();
                        Arrays.sort(symbols1);

                        String s1 = new String(symbols);
                        String s2 = new String(symbols1);
                        if (s1.equals(s2)) {
                            anagramsList.add(list.get(i));
                            anagramsList.add(list.get(j));
                            list.remove(j);
                            list.remove(i);
                            j = 0;
                        } else if (j == list.size() - 1) {
                            notAnagramsList.add(list.get(i));
                            list.remove(i);
                            j = 0;
                        }
                    }
                } else if (j == list.size() - 1) {
                    notAnagramsList.add(list.get(i));
                    list.remove(i);
                    j = 0;
                }
            }
        }
        if (list.size() == 1) {
            notAnagramsList.add(list.get(i));
            list.remove(i);
        }
        System.out.print("Слова анаграммы: ");
        for (String el : anagramsList) {
            System.out.print(el + " ");
        }
        System.out.println("");
        System.out.print("Не анаграммы: ");
        for (String el : notAnagramsList) {
            System.out.print(el + " ");
        }
    }
}
