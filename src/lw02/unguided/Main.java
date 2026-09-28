package lw02.unguided;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {

        int MAX_BORROW = 2;

        LinkedList<String[]> requests = new LinkedList<>();
        Queue<String[]> queue = new LinkedList<>();
        LinkedList<String[]> books = new LinkedList<>();
        LinkedList<String[]> members = new LinkedList<>();
        Stack<String[]> failed = new Stack<>();

        Scanner sc = new Scanner (Main.class.getResourceAsStream("borrowing.txt"));
        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            String[] data = line.split(" ");
            requests.add(data);
        }


        books.add(new String[]{"Kalkulus", "2"});
        books.add(new String[]{"Fisika", "1"});
        books.add(new String[]{"Statistika", "2"});

        
        for (int i = 0; i < requests.size(); i++) {
            String nama = requests.get(i)[0];
            boolean ada = false;

            for (int j = 0; j < members.size(); j++) {
                if (members.get(j)[0].equals(nama)) {
                    ada = true;
                }
            }
            
            if (ada == false) {
                members.add(new String[]{nama, "0"});
            }
        }




        for (int i = 0; i < requests.size(); i++) {
            queue.add(requests.get(i));
        }

        

        while (!queue.isEmpty()) {
            String[] req = queue.poll();

            for (int i = 0; i < books.size(); i++) {
                
            }

        }

    }
}