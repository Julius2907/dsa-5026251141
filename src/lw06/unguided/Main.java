package lw06.unguided;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(Main.class.getResourceAsStream("treenumbers.txt"));
        BinarySearchTree tree = new BinarySearchTree();
        Node root = null;

        String[] angkaPisah = sc.nextLine().split(" ");
        int target = sc.nextInt();
        sc.close();

        for (int i = 0; i < angkaPisah.length; i++) {
            tree.insert(Integer.parseInt(angkaPisah[i]));
        }

        System.out.print("Preorder  : ");
        tree.preOrder();

        System.out.print("Inorder   : ");
        tree.inOrder();

        System.out.print("Postorder : ");
        tree.postOrder();

        System.out.println("Search " + target + " : " + tree.search(target));

        System.out.println("Minimum : " + tree.findMin());
        System.out.println("Maximum : " + tree.findMax());

        sc.close();
    }
}