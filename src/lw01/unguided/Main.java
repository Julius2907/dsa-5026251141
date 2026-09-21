package lw01.unguided;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Rental[] rentals;
        try (Scanner scanner = new Scanner(new File("src/lw01/unguided/rentals.txt"))){
            int jumlah = scanner.nextInt();
            rentals = new Rental[jumlah];

            for (int i = 0; i < jumlah; i++){
                String type = scanner.next();
                String id = scanner.next();
                int days = scanner.nextInt();
                
                 if (type.equals("LAPTOP")) {
                    rentals[i] = new LaptopRental(id, days);
                } else if (type.equals("PROJECTOR")) {
                    rentals[i] = new ProjectorRental(id, days);
                }

            }

        } catch (FileNotFoundException e) {
            System.out.println("File rentals.txt tidak ditemukan!");
            return;
        }

            for (Rental rental : rentals) {
                System.out.println(rental.summary());
        }


    }
    
}
