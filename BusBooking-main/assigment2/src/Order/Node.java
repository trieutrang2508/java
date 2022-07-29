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
public class Node {
    Ordering info;
    Node next;
    
    Node(){       
    }
    
    Node(Ordering x) {
        info = x;
        next = null;
    }
    public String tostring() {
        return info.bcode + "  |   " + info.ccode+ "  |   " + info.seat+"\n";
    }
}