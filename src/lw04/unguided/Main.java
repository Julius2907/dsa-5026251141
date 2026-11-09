package lw04.unguided;

import java.util.Scanner;

public class Main {

    public static void selectionSort(int[] array, int passes) {
        int size = array.length;

        for (int i = 0; i < passes; i++) {
            int min = i;

            for (int j = i + 1; j < size; j++) {
                if (array[j] < array[min]) {
                    min = j;
                }
            }

            int a = array[min];
            array[min] = array[i];
            array[i] = a;
        }
    }

    public static int linearSearch(int[] targetCard, int target) {
        for (int i = 0; i < targetCard.length; i++) {
            if (targetCard[i] == target) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(Main.class.getResourceAsStream("cards.txt"));

        // buat array card
        int cardSize = sc.nextInt();
        int[] cards = new int[cardSize];

        // masukin ke dalam array
        for (int i = 0; i < cardSize; i++) {
            cards[i] = sc.nextInt();
        }

        // buat array target kartu dicari
        int targetCardSize = sc.nextInt();
        int[] targetCard = new int[targetCardSize];

        // masukin ke array target card
        for (int i = 0; i < targetCardSize; i++) {
            targetCard[i] = sc.nextInt();
        }

        selectionSort(cards, 2);

        for (int i = 0; i < cards.length; i++) {
            if (i > 0) {
                System.out.print(" ");
            }
            System.out.print(cards[i]);
        }

        System.out.println();

        for (int i = 0; i < targetCardSize; i++) {
            int index = linearSearch(cards, targetCard[i]);
            if (index == -1) {
                System.out.println(targetCard[i] + ": NOT FOUND");
            } else {
                System.out.println(targetCard[i] + ": FOUND at index " + index);
            }
        }
        sc.close();
    }
}
