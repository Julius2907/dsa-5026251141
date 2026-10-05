package lw03.unguided;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(Main.class.getResourceAsStream("enrollment.txt"));
        Map<String, Integer> matkul = new HashMap<>();

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] lineParts = line.split(" ");
            String command = lineParts[0];
            String course = lineParts[1];
            int countInt = Integer.parseInt(lineParts[2]);
            int failed = 0;
            if (command.equals("REGISTER")) {
                if (matkul.containsKey(course)) {
                    matkul.put(course, matkul.get(course) + countInt);
                } else {
                    matkul.put(course, countInt);
                }
            } else if (command.equals("WITHDRAW")) {
                if (matkul.containsKey(course) && matkul.get(course) >= countInt) {
                    matkul.put(course, matkul.get(course) - countInt);
                } else {
                    failed++;
                }
            } else if (command.equals("CHECK")) {
                System.out.println("====== Enrollment Checks ======");
                for (Map.Entry<String, Integer> list : matkul.entrySet()) {
                    System.out.println(course + ": " + matkul.get(course) + " Students");
                 }
            }
        }
        System.out.println("====== Final Enrollment =====");
    }
}
