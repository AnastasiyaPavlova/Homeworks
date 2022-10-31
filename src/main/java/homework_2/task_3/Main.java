package homework_2.task_3;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int numberOfLines, numberOfColumns, swap;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите количество строк в массиве");
        numberOfLines = scanner.nextInt();
        System.out.println("Введите количество столбцов в массиве");
        numberOfColumns = scanner.nextInt();
        int myArray[][] = new int[numberOfLines][numberOfColumns];
        System.out.println("Введите элементы массива");
        for (int i = 0; i < numberOfLines; i++) {
            for (int j = 0; j < numberOfColumns; j++) {
                myArray[i][j] = scanner.nextInt();
            }
        }
        for (int i = 0; i < myArray.length; i++) {
            for (int j = 0; j < myArray[i].length; j++) {
                for (int k = 0; k < myArray.length; k++) {
                    for (int l = 0; l < myArray[k].length; l++) {
                        if (myArray[i][j] <= myArray[k][l]) {
                            swap = myArray[i][j];
                            myArray[i][j] = myArray[k][l];
                            myArray[k][l] = swap;
                        }
                    }
                }
            }
        }
        for (int i = myArray.length - 1; i >= 0; i--) {
            for (int j = myArray[i].length - 1; j >= 0; j--) {
                System.out.print(myArray[i][j] + " ");
            }
            System.out.println();
        }
    }
}
