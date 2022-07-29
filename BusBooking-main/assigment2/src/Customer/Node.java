/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Customer;

public class Node {
    Customer info;
    Node next;
    
    Node(){       
    }
    
    Node(Customer x) {
        info = x;
        next = null;
    }
    public String tostring() {
        return info.ccode + "  |   " + info.cus_name+ "   |   " + info.phone+"\n";
    }
}
