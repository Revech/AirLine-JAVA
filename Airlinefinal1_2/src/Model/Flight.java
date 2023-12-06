/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author user
 */
public class Flight {
     String Arrival;
     int seats;
     int flightNO;
     String depart;
    
     
     String from ;
     String to;
int price;
String aid;

    public Flight(String Arrival, int seats, int flightNO, String depart, String from, String to, int price,String aid) {
        this.Arrival = Arrival;
        this.seats = seats;
        this.flightNO = flightNO;
        this.depart = depart;
        this.from = from;
        this.to = to;
        this.price = price;
        this.aid=aid;
    }

    public String getArrival() {
        return Arrival;
    }

    public int getSeats() {
        return seats;
    }

    public int getFlightNO() {
        return flightNO;
    }

    public String getDepart() {
        return depart;
    }

    public String getFrom() {
        return from;
    }

    public String getTo() {
        return to;
    }

    public int getPrice() {
        return price;
    }

    public void setArrival(String Arrival) {
        this.Arrival = Arrival;
    }

    public void setSeats(int seats) {
        this.seats = seats;
    }

    public void setFlightNO(int flightNO) {
        this.flightNO = flightNO;
    }

    public void setDepart(String depart) {
        this.depart = depart;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
         String out ="";
       
        
       
        out= "'"+this.Arrival+"', '"+this.seats+"', '"+this.flightNO+"', '"+this.depart+"', '"+this.from+"', '"+this.to+"', '"+this.price+"', '"+this.aid+"'";
    return out; }
    
  
}
