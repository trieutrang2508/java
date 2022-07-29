/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Customer;

import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 *
 * @author Admin
 */
public class MyList {
     Node head, tail;
    int size;
    public MyList() {
        head = tail = null;
        size = -1;
    }

    public boolean isEmpty() {
        return head == null;
    }

     public void addLast(Customer x){
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
    
    
    public void readFromFile(String fname) throws IOException {
        try (RandomAccessFile f = new RandomAccessFile(fname, "r")) {
            String s;
            String[] a;
            String ccode;
            String name ;
            String phone;
            Customer customer;
            while (true) {
                s = f.readLine();
                if (s == null || s.trim().equals("")) {
                    break;
                }
                a = s.split("[|]");
                ccode = a[0].trim();
                name = a[1].trim();               
                phone= a[2].trim();
                customer = new Customer(ccode, name, phone);                
                addLast(customer);
            }
        }
    }

    public void display() {
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


    public void saveToFile(String fname) throws IOException {
        if (isEmpty()) {
            return;
        }
        try (DataOutputStream g = new DataOutputStream(new FileOutputStream(fname))) {
            Node node = head;
            while (node != null) {
                g.writeBytes(node.tostring());
                node = node.next;
            }
        }
    }
   
   
    public Node search(String ccode){
        Node tmp = head;
        Node p = null;
        if (head==null) {
            System.out.println("List is empty");
        }
        else{           
            while (tmp!=null) {                 
                //Compares node to be found with each node present in the list
                if (tmp.info.ccode.equalsIgnoreCase(ccode)) {                   
                    p = tmp;
                    break;
                }
                tmp=tmp.next;
            }
        }
        return p;
    }
    public void dele(String ccode) {
        if (isEmpty()) {
            System.out.println("Empty");
            return;
        }
        Node p = head;
        Node x = search(ccode);
        while (p != null) {
            if (p == x) {
                if (p == head) {
                    head = p.next;
                } else {
                    deleteNode(p);
                }
                break;
            }
            p = p.next;
        }
    }
      public Node preNode(Node p) {
        Node pre = new Node();
        pre.next = head;
        while (pre.next != p) {
            pre = pre.next;
        }
        return pre;
    }

    public void deleteNode(Node p) {
        if (p==head) {
            head=head.next;
            size--;
            return;
        }
        preNode(p).next = preNode(p).next.next;
        size--;
    }
      public boolean checkCcodeExit(String ccode){
        Node p = head;
        if (isEmpty()) {
            return true;
        }
        while (p!=null) {            
            if (p.info.ccode.equalsIgnoreCase(ccode)) {
                return false;
            }
            p = p.next;
        }
        return true;
    }
}
