/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bus;

public class Node
  {public Bus info;
   int bal; // balance factor of the node p = height(p.right) - height(p.left)
   public Node left,right;
   Node(Bus x)
     {info=x;left=right=null;
     }
    public String tostring() {
        return info.bcode + "  |   " + info.bus_name+ "|" + info.seat+"    |  "  
                +info.booked+"  |   "+info.depart_time +"  |   "+info.arrival_time +"\n";
    }
   }
