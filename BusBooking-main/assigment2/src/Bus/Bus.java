/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bus;

/**
 *
 * @author Admin
 */
public class Bus {
    String bcode;
    String bus_name;
    int seat;
    int booked;
    double depart_time;
    double arrival_time;

    public Bus(String bcode, String bus_name, int seat, int booked, double depart_time, double arrival_time) {
        this.bcode = bcode;
        this.bus_name = bus_name;
        this.seat = seat;
        this.booked = booked;
        this.depart_time = depart_time;
        this.arrival_time = arrival_time;
    }
    
}
