package lw04.prelab;
import java.util.Scanner;

public class Main {
    
    //method sort
    public static void insertionSort(int[] array, int passes){
        for(int i = 1; i <= passes; i++){
            int key = array[i];
            int j = i - 1;

            while (j >= 0 && array[j] < key){
                array[j + 1] = array[j];
                j--;
            }

            array[j + 1] = key;
        }

        for (int a : array){
            System.out.print(a + " ");
        }
    }

    //method search
    public static int linearSearch (int[] array, int target){
        for (int i = 0; i < array.length; i++){
            if (array[i] == target){
                return i;
            }
        }
        return -1;
    }

    public static void main (String[] args){
        Scanner sc = new Scanner(Main.class.getResourceAsStream("branches.txt"));
        
        //sort----------------------------------------------------
        int size = sc.nextInt();
        int[] array = new int[size];

        for(int i = 0; i < size; i++){
            array[i] = sc.nextInt();
        }

        //search--------------------------------------------------
        int targetSize = sc.nextInt();
        int[] targets = new int[targetSize];

        //masukin target ke array
        for (int i = 0; i < targetSize; i++){
            targets[i] = sc.nextInt();
        }

        //manggil method sort
        insertionSort(array, 3);
        System.out.println();

        //manggil metod search
        for(int i = 0; i < targets.length; i++){
            int index = linearSearch(array, targets[i]);
            if (index == -1){
                System.out.println(targets[i] + ": NOT FOUND");
            } else {
                System.out.println(targets[i] + ": FOUND at index " + index);
            }
        }

        sc.close();
    }
}
