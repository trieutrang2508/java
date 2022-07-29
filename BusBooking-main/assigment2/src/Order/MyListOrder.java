/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Order;





/**
 *
 * @author Admin
 */
public class MyListOrder {
     Node head, tail;
      int size;
     public boolean isEmpty() {
        return head == null;
    }
    public boolean checkOrderExit(String bcode, String ccode){
        Node p = head;
        if (isEmpty()) {
            return true;
        }
        while (p!=null) {            
            if (p.info.ccode.equalsIgnoreCase(ccode) && p.info.bcode.equalsIgnoreCase(bcode)) {
                return false;
            }
            p = p.next;
        }
        return true;
    }
     public void addLast(Ordering x){
        Node p =new Node(x);
        if (isEmpty()) {
            head = p;
            tail = head;
            size = 1;
        }
        else{
            tail.next = p;  
            tail = p;
            size++;
        }
    }
      public void traverse() {
        if (isEmpty()) {
            System.out.println("Empty");
            return;
        }
        Node p = head;
        while (p != null) {
            System.out.print(p.tostring());
            p = p.next;
        }
        System.out.println();
    }
    public void sortByBcodeCcode() {
        if (isEmpty()) {
            return;
        }
        Node p = head;
        int swap;
        Ordering t;
        while (true) {
        swap = 0;
        while (p.next != null) {
                String s1 = p.info.bcode + p.info.ccode;
                String s2 = p.next.info.bcode+ p.next.info.ccode;
                if (s1.compareToIgnoreCase(s2) > 0) {
                    t = p.info;
                    p.info = p.next.info;
                    p.next.info = t;
                    swap = 1;
                }
                p = p.next;
            }
            if (swap == 0) {
                break;
            }
            p = head;
        }
    }
   

}
