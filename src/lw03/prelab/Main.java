package lw03.prelab;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
        List<String> songList = new ArrayList<>();
        Scanner scanner = new Scanner(Main.class.getResourceAsStream("playlist.txt"));
    
        //problem 1
        System.out.println("===== Problem 1 =====");
        while (scanner.hasNextLine()){
            String line = scanner.nextLine();
            if (line.startsWith("ADD ")){

                String song = line.substring(4);
                songList.add(song);

            } else if (line.startsWith("INSERT ")) {

                String data = line.substring(7);
                int separatorIndex = data.indexOf(" ");
                int indexAngka = Integer.parseInt(data.substring(0, separatorIndex));
                String song = data.substring(separatorIndex + 1);
                songList.add(indexAngka, song);
                // String song = line.substring(9);
                // String indexString = line.substring(7,8);
                // int indexAngka = Integer.parseInt(indexString);
                // songList.add(indexAngka, song);

            } else if (line.startsWith("REMOVE ")){

                String song = line.substring(7);
                if (songList.contains(song)){
                    songList.remove(song);
                }

            }
        }
        scanner.close();
        System.out.println("Total songs: " + songList.size());
        for (int i = 0; i < songList.size(); i++){
            System.out.println((i+1) + ": " + songList.get(i));
        }

        //Problem 2
        System.out.println();
        System.out.println("===== Problem 2 =====");
        Set<String> participants = new LinkedHashSet<>();
        Scanner scanner2 = new Scanner(Main.class.getResourceAsStream("participants.txt"));

        int duplicate = 0;
        while (scanner2.hasNextLine()){
            String nama = scanner2.nextLine();
            if (participants.contains(nama)){
                duplicate++;
            }
            participants.add(nama);
        }
        scanner2.close();
        System.out.println("Unique participants: " + participants.size());
        
        int nomor = 1;
        for (String nama : participants){
            System.out.println(nomor + ". " + nama);
            nomor++;
        }
        System.out.println("Duplicate registrations: " + duplicate);


        //problem 3
        System.out.println();
        System.out.println("===== Problem 3 =====");
        Map<String, Integer> inventory = new LinkedHashMap<>();
        Scanner scanner3 = new Scanner(Main.class.getResourceAsStream("inventory.txt"));

        int failedSales = 0;

        while (scanner3.hasNext()){
            String type = scanner3.next();
            String product = scanner3.next();
            int quantity = scanner3.nextInt();

            if (type.equals("ADD")) {
                if (inventory.containsKey(product)) {
                    int currentStock = inventory.get(product);
                    inventory.put(product, currentStock + quantity);
                } else {
                    inventory.put(product, quantity);
                }
            } else if (type.equals("SELL")) {
                if (inventory.containsKey(product) && inventory.get(product) >= quantity) {
                    int currentStock = inventory.get(product);
                    inventory.put(product, currentStock - quantity);
                } else {
                    failedSales++;
                }
            }
        }
        scanner3.close();
        for (Map.Entry<String, Integer> item : inventory.entrySet()) {
        System.out.println(item.getKey() + ": " + item.getValue());
        }
        System.out.println("Failed sales: " + failedSales);
    }

}
