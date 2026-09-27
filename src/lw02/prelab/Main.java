package lw02.prelab;

import java.io.InputStream;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {

        LinkedList<String[]> transactionList = new LinkedList<>();
        LinkedList<String[]> customerList = new LinkedList<>();

        InputStream input = Main.class.getResourceAsStream("transactions.txt");

        if (input == null) {
            System.out.println("File tidak ditemukan!");
            return;
        }

        Scanner scanner = new Scanner(input);

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();

            if (line.isEmpty()) {
                continue;
            }

            String[] transaction = line.split(" ");
            transactionList.add(transaction);
        }

        scanner.close();

        for (int i = 0; i < transactionList.size(); i++) {
            String[] transaction = transactionList.get(i);
            String customerName = transaction[0];

            boolean customerFound = false;

            for (int j = 0; j < customerList.size(); j++) {
                String[] customer = customerList.get(j);

                if (customer[0].equals(customerName)) {
                    customerFound = true;
                    break;
                }
            }

            if (!customerFound) {
                String[] newCustomer = {customerName, "0"};
                customerList.add(newCustomer);
            }
        }

        Queue<String[]> transactionQueue = new LinkedList<>();
        Stack<String[]> failedTransactions = new Stack<>();

        for (int i = 0; i < transactionList.size(); i++) {
            transactionQueue.add(transactionList.get(i));
        }

        while (!transactionQueue.isEmpty()) {
            String[] transaction = transactionQueue.poll();

            String customerName = transaction[0];
            String transactionType = transaction[1];
            int amount = Integer.parseInt(transaction[2]);

            for (int i = 0; i < customerList.size(); i++) {
                String[] customer = customerList.get(i);

                if (customer[0].equals(customerName)) {
                    int balance = Integer.parseInt(customer[1]);

                    if (transactionType.equals("DEPOSIT")) {
                        balance += amount;
                        customer[1] = String.valueOf(balance);

                    } else if (transactionType.equals("WITHDRAW")) {
                        if (amount > balance) {
                            failedTransactions.push(transaction);
                        } else {
                            balance -= amount;
                            customer[1] = String.valueOf(balance);
                        }
                    }

                    break;
                }
            }
        }

        System.out.println("=== Final Balances ===");
        System.out.println();

        for (int i = 0; i < customerList.size(); i++) {
            String[] customer = customerList.get(i);
            System.out.println(customer[0] + " : " + customer[1]);
        }

        System.out.println();
        System.out.println("=== Failed Transactions ===");

        while (!failedTransactions.isEmpty()) {
            String[] failedTransaction = failedTransactions.pop();

            System.out.println(
                failedTransaction[0] + " " +
                failedTransaction[1] + " " +
                failedTransaction[2]
            );
        }
    }
}

        // //buat linkedlist
        // LinkedList<String[]> transactionList = new LinkedList<>();
        // LinkedList<String[]> customerList = new LinkedList<>();

        // InputStream input = Main.class.getResourceAsStream("transactions.txt");

        // //kalo gk nemu filenya
        // if (input == null){
        //     System.out.println("File tidak ditemukan!");
        //     return;
        // }

        // //buat masukin array masing masing transaksi ke list transaksi
        // Scanner scanner = new Scanner(input);
        // while (scanner.hasNextLine()){
        //     String line = scanner.nextLine();
        //     String[] transaction = line.split(" ");
        //     transactionList.add(transaction);
        // }
        // scanner.close();
        
        // System.out.println("Total transaction: " + transactionList.size());
        // System.out.println("=== Stored Transactions ===");

        // for (int i = 0; i < transactionList.size(); i++){
        //     String[] currentTransaction = transactionList.get(0);
        //     System.out.println(currentTransaction[0] + currentTransaction[1] + currentTransaction[2]);
        // }