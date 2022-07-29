/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bus;

import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class Validate {
        private  Scanner sc = new Scanner(System.in);
    public  int checkInputIntLimit(int min, int max) {
        //loop until user input correct
        while (true) {
            try {
                int result = Integer.parseInt(sc.nextLine().trim());
                if (result < min || result > max) {
                    throw new NumberFormatException();

                }
                return result;
            } catch (NumberFormatException e) {
                System.err.println("Please input number in rage [" + min + ", " + max + "]");
                System.out.print("Enter again: ");
            }
        }
    }
      //check user input String
    public  String checkInputString(){
        //loop until user input correct
        while (true) {            
            String result = sc.nextLine().trim();
            if (result.isEmpty()) {
                System.err.println("Not empty");
                System.out.print("Please re-enter: ");
            }
            else{
                return result;
            }
        }
    }
     //check user input int
    public int checkInputInt(int a){
        //loop until user input correct
        while (true) {            
            try {
                int result = Integer.parseInt(sc.nextLine());
                if (result>=a) {
                    return result;
                }       
                else{
                throw new NumberFormatException();
                }
            } catch (NumberFormatException e) {
                System.err.println("Must input positive integer");
                System.out.print("Please re-enter: ");
            }
        }
    }
    
    
    //check user input double
    public double checkInputDouble(){
        //loop until user input correct
        while (true) {            
            try {
                double result = Double.parseDouble(sc.nextLine());
                if (result<0) {
                    throw  new NumberFormatException();
                }
                return result;
            } catch (NumberFormatException e) {
                System.err.println("Must input positive double");
                System.out.print("Please re-enter: ");
            }
        }
    }
}
