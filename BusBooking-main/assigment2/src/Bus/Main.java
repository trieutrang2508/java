/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bus;

import java.io.IOException;
import java.util.Scanner;

public class Main {

    static Scanner in = new Scanner(System.in);
    static Validate v = new Validate();

    public static void main(String[] args) throws IOException, Exception {
        BSTree tree = new BSTree();
        menu(tree);
    }

    public static void menu(BSTree tree) throws IOException, Exception {
        while (true) {
            System.out.println("---------Menu---------");
            System.out.println("1. Load data from file");
            System.out.println("2. Input & insert data");
            System.out.println("3. In-order traverse");
            System.out.println("4. Breadth-first traverse");
            System.out.println("5. In-order traverse to file");
            System.out.println("6. Search by bcode");
            System.out.println("7. Delete by bcode by copying");
            System.out.println("8. Simply balancing");
            System.out.println("9. Count number of buses");
            System.out.println("10. Exit");
            System.out.print("Your selection (1 -> 10): ");
            int choice = v.checkInputIntLimit(0, 10);
            switch (choice) {
               case 1:
                    tree.ReadFile("buses.txt");
                    System.out.println("Load data from file and insert data is done!");
                    System.out.println();
                    break;

                case 2:
                    System.out.println("Enter new information about a bus:");
                    
                    String bcode,pro_name;
                    int seat, booked=0;
                    double depart_time, arrival_time;
                    while (true) {                        
                        System.out.print("Enter bcode: ");                
                        bcode = v.checkInputString();
                        if (tree.search(tree.root, bcode) != null) {
                            System.out.println("Bcode exist");
                                continue;
                        }
                        System.out.print("Enter bus_name: ");
                        pro_name = v.checkInputString();
                        System.out.print("Enter seat: " );
                         seat = v.checkInputInt(1);
                        do{
                        System.out.print("Enter booked: ");
                         booked = v.checkInputInt(0);
                        }while(booked > seat);
                        System.out.print("Enter depart_time: ");
                         depart_time = v.checkInputDouble();
                        do{
                         System.out.print("Enter arrival_time");
                         arrival_time = v.checkInputDouble();
                         }while(arrival_time <= depart_time);
                        Bus b = new Bus(bcode, pro_name, seat, booked, depart_time, arrival_time);
                        tree.insert(b);
                        break;
                    }
                    break;

                case 3:
                    tree.inorder(tree.root);
                    System.out.println();
                    break;

                case 4:
                    tree.breadth();
                    System.out.println();
                    break;
                case 5:
                    tree.f1();
                    System.out.println("In-order traverse to file successful");
                    break;
                case 6:
                    System.out.print("Enter bcode to search: ");
                    String xCode = in.nextLine();
                    if (tree.search(tree.root, xCode) != null) {
                        System.out.println("Found");
                    }
                    else{
                        System.out.println("Not found");
                    }
                    break;
                case 7:
                    System.out.print("Enter bcode to delete by copying: ");
                    xCode = in.nextLine();
                    if (tree.search(tree.root, xCode) != null) {
                        tree.deleteByCopying(xCode);
                    }
                    else{
                        System.out.println("Not found");
                    }
                    break;
                case 8:
                    System.out.println("Before: ");
                    tree.breadth();
                    tree.balance();
                    System.out.println("After: ");
                    tree.breadth();
                    break;
                case 9:
                    int k = tree.count(tree.root);
                    System.out.println("Number of buses: "+k);
                    break;
                case 10:
                    return;
            }
        }
    }
}
