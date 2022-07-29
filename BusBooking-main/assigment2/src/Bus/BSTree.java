/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bus;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public class BSTree {
    public Node root;
    public BSTree() {root=null;}
    boolean isEmpty()
      {return(root==null);
      }
    void clear()
      {root=null;
      }
    public void ReadFile(String frame) throws IOException {
        try (RandomAccessFile f = new RandomAccessFile(frame, "r")) {
            String s;
            String[] a;
            String bcode;
            String bus_name;
            int seat;
            int booked;
            double depart_time;
            double arrival_time;
            Bus p;
            while (true) {
                s = f.readLine();
                if (s == null || s.trim().equals("")) {
                    break;
                }
                a = s.split("[|]");
                bcode = a[0].trim();
                bus_name = a[1].trim();
                seat = Integer.parseInt(a[2].trim());
                booked = Integer.parseInt(a[3].trim());
                depart_time = Double.parseDouble(a[4].trim());
                arrival_time = Double.parseDouble(a[5].trim());
                p = new Bus(bcode, bus_name, seat, booked, depart_time, arrival_time);
                insert(p);
            }
        }
    }
    public Node search(Node p , String x){
        if (p==null) return null;
        if (p.info.bcode.equalsIgnoreCase(x)) return p;
        if (x.compareToIgnoreCase(p.info.bcode)<0) return search(p.left, x);
        else return search(p.right, x);
    }
     void inorder(Node p){
        if (p==null) {
            return;
        }
        inorder(p.left);
        visit(p);
        inorder(p.right);
    } 
     void visit(Node p){
        System.out.print(p.tostring());
    }
     void inOrder(Node p, RandomAccessFile f) throws Exception
     {if(p==null) return;
      inOrder(p.left,f);
      fvisit(p,f);
      inOrder(p.right,f);
     }
      void fvisit(Node p, RandomAccessFile f) throws Exception
     {if(p != null) f.writeBytes(p.tostring());
     }
      void f1() throws Exception
    {/* You do not need to edit this function. Your task is to complete insert  function
        above only.
     */
     String fname = "f1.txt";
     File g123 = new File(fname);
     if(g123.exists()) g123.delete();
     RandomAccessFile  f = new RandomAccessFile(fname, "rw"); 
     inOrder(root,f);
     f.writeBytes("\r\n");
     f.close();
    }  
       Node searchParent(String pCode){
        Node parent = null;
        Node q = root;
        while (  q!=null&&!q.info.bcode.equalsIgnoreCase(pCode)) {
            parent = q;
            if (q.info.bcode.compareToIgnoreCase(pCode)>0) {
                q = q.left;} 
             else {
                q = q.right;
            }
        }
            return parent;
        }
        public void deleteByCopying(String x) {
        Node parent = searchParent(x);
        Node p;
        if (parent==null) {
                p = root;
        }
        else if (parent.left == null && parent.right==null) {
            System.out.println(x + " doesn't exists. Delete failed!");
            return;
        }

        else if (parent.left!=null && parent.left.info.bcode.equalsIgnoreCase(x)) {
           p = parent.left;
        }
        else p = parent.right;
        // p has no child
        if (p.left == null && p.right == null) {
            if (parent == null) {
                root = null;
            } else if (parent.left.info.bcode.equalsIgnoreCase(x)) {
                parent.left = null;
            } else {
                parent.right = null;
            }
        }

        // p has only a left child
        if (p.left != null && p.right == null) {
            if (parent == null) {
                root = null;
            } else if (parent.left.info.bcode.equalsIgnoreCase(x)) {
                parent.left = p.left;
            } else {
                parent.right = p.left;
            }
        }

        // p has only a right child
        if (p.left == null && p.right != null) {
            if (parent == null) {
                root = null;
            } else if (parent.left.info.bcode.equalsIgnoreCase(x)) {
                parent.left = p.right;
            } else {
                parent.right = p.right;
            }
        }
        Node q=p;
        // p have two childs
        if (p.left != null && p.right != null) {
            Node parentRm = null;
            Node rm = p.left;
            while (rm.right!=null) {                
                parentRm = rm;
                rm = rm.right;
            }
            p.info = rm.info;
            if (parentRm==null) {
                q = p.left;
                p.left = q.left;
            }
            else{
                parentRm.right = rm.left;
            }
        }
        System.out.println("Delete successfully");
    }
  void inOrder(ArrayList<Bus> t, Node p)
  {if(p==null) return;
    inOrder(t,p.left);
    t.add(p.info);
    inOrder(t,p.right);
  }
  void balance(ArrayList<Bus> t, int i, int j){
      if (i>j) {
          return;
      }
      int k = (i+j)/2;
      insert(t.get(k));
      balance(t, i, k-1);
      balance(t, k+1, j);
  }
  void balance(){
      ArrayList<Bus> t = new ArrayList<Bus>();
      inOrder(t, root);
      int n = t.size();
      clear();
      balance(t, 0, n-1);
  }
   int count(Node p)
    {if(p==null) return(0);
        int k,h,r;
        k = count(p.left);
        h = count(p.right);
        r = k+h+1;
        return(r);
    }

     void breadth() throws Exception {
        if (isEmpty()) {
            return;
        }
       MyQueue q = new MyQueue();
       q.enqueue(root);
       Node p ;
        while (!q.isEmpty()) {            
            p= (Node)q.dequeue(); 
            if (p.left!=null) { 
                q.enqueue(p.left);
            }
            if (p.right!=null) {
                q.enqueue(p.right);
            }
            visit(p);
        } 
}   
    public void insert(Bus x)
     {
 
         if (isEmpty()) {
            root = new Node(x);
            return;
        }
        Node f,p;
        p = root;
        f = null;
        while (p!=null) {            
            if (p.info==x) {
                return;
            }
            f = p;
            if (x.bcode.compareToIgnoreCase(p.info.bcode)<0) {
                p=p.left;
            }
            else p = p.right;
        }
        if (x.bcode.compareToIgnoreCase(f.info.bcode)<0) {
            f.left = new Node(x);
        }
        else{
            f.right = new Node(x);
        }

     }
}
