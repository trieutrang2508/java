/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Order;
import Bus.BSTree;
import Customer.MyList;
import Bus.Node;
import Bus.Validate;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    static Scanner in = new Scanner(System.in);
    static  Validate v = new Validate();
    public static void main(String[] args) throws IOException {
        MyList listCus = new MyList();
        MyListOrder listOrder = new MyListOrder();
        BSTree listBus = new BSTree();
        menu(listCus, listOrder, listBus);
    }

    public static void menu(MyList listCus, MyListOrder listOrder, BSTree listBus) throws IOException  {
        listCus.readFromFile("customers.txt");
        listBus.ReadFile("buses.txt");
        while (true) {
            System.out.println("---------------Menu---------------");
            System.out.println("1. Input data");
            System.out.println("2. Display booking data");
            System.out.println("3. Sort by bcode + ccode");
            System.out.println("4. Exit");
            System.out.print("Enter yout choice: ");
            int n = v.checkInputIntLimit(0, 4);
            switch (n) {          
                case 1: 
                       input(listCus, listOrder, listBus);
                       break;                
                case 2:
                    System.out.print("bcode |  ccode  |  seat\n");
                    System.out.println("---------------------------");
                    listOrder.traverse();
                    break;
                case 3:
                    System.out.println("Sort by bcode + ccode");
                    System.out.print("bcode |  ccode  |  seat\n");
                    System.out.println("---------------------------");
                    listOrder.sortByBcodeCcode();
                    listOrder.traverse();
                    break;
                case 4:
                    return;
                    
            }
        }
    }
       public static void input(MyList listCus, MyListOrder listOrder, BSTree listBus){
                System.out.println("Enter new information about a bus booking:");
                System.out.print("Enter code of the bus: ");
                String bcode = in.nextLine();
                System.out.print("Enter code of the customer: ");
                String ccode = in.nextLine();
                System.out.print("Enter the number of seats to be booked on the bus: ");
                int seat = v.checkInputInt(0);
                Node p  = listBus.search(listBus.root,bcode);
               
                if (listCus.checkCcodeExit(ccode) || p==null ) {
                    System.err.println("Data is not accepted");
                    return;
                }
                else if (!listOrder.checkOrderExit(bcode, ccode)){
                    System.err.println("Data is not accepted");
                    return ;
                }
                
                     listOrder.addLast(new Ordering(bcode, ccode, seat));
    }
}
