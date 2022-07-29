/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Customer;

import Bus.Validate;
import java.io.IOException;
import java.util.Scanner;


public class Main {
        static Validate v = new Validate();
    public static void main(String[] args) throws IOException {
        MyList list = new MyList();
        menu(list);
    }

    public static void menu(MyList list) throws IOException {
        while (true) {
            System.out.println("---------------Menu---------------");
            System.out.println("1. Load data from file");
            System.out.println("2. Input & add to the end");
            System.out.println("3. Display data");
            System.out.println("4. Save customer list to file");
            System.out.println("5. Search by ccode");
            System.out.println("6. Delete by ccode");
            System.out.println("7. Exit");
            System.out.print("Enter yout choice: ");
            int n = v.checkInputIntLimit(0, 7);
            switch (n) {
                case 1:
                    System.out.println();
                    list.readFromFile("customers.txt");
                    list.display();
                    break;            
                case 2: 
                       list.addLast(input(list));
                       break;                
                case 3:
                    System.out.printf("ccode |  name  |  phone\n");
                    System.out.println("-------------------------------------------------------");
                    list.display();
                    break;
                case 4:
                    list.saveToFile("outputcustomer.txt");
                    break;
                case 5:
                    System.out.print("Enter ccode to search: ");
                    String xCode = v.checkInputString();
                    if (list.search(xCode) != null) {
                        System.out.println("Found");
                    }
                    else{
                        System.out.println("Not found");
                    }
                    break;
                case 6:
                    System.out.print("Enter ccode to delete: ");
                    xCode = v.checkInputString();                   
                    list.dele(xCode);
                case 7:
                    return;
                    
            }
        }
    }
       public static Customer input(MyList list){
                System.out.println("Enter new information about a train:");
                String ccode;
                do {                        
                    System.out.print("Enter ccode: ");
                    ccode = v.checkInputString();
                }while (!list.checkCcodeExit(ccode));
                System.out.print("Enter customer name: ");
                String cus_name = v.checkInputString();
                System.out.print("Enter phone: ");
                String phone = v.checkInputString();
                Customer customer = new Customer(ccode, cus_name, phone);
               return customer;
    }
}
