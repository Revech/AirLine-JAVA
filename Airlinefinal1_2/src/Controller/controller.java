/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.Admin;
import Model.Flight;
import Model.Passenger;
import java.util.ArrayList;

/**
 *
 * @author user
 */
public class controller {
     DBAccess db; 

    public controller() {
     db = new DBAccess();
    }

public boolean CheckPass(int id,  String pass) {
        boolean r = false;
          ArrayList<Passenger> allP = new ArrayList();
        allP = db.getAllPass();
        for (int i = 0; i < allP.size(); i++) {
            if (allP.get(i).getP_id()==id || allP.get(i).getPass().equals(pass)) {
                if (allP.get(i).getPass().equals(pass))
                 r = true;
            }
        }
        return r;
    }



public boolean CheckAdmin(String id,  String pass) {
        boolean r = false;
          ArrayList<Admin> allP = new ArrayList();
        allP = db.getAllAdmin();
        for (int i = 0; i < allP.size(); i++) {
            if (allP.get(i).getA_id().equals(id) || allP.get(i).getApass().equals(pass)) {
                if (allP.get(i).getApass().equals(pass))
                 r = true;
            }
        }
        return r;
    }
 public String PrintAllFlights() {
        String s = "";
      ArrayList<Flight> allP = new ArrayList();
        allP = db. getAllFlight1();
        for (int i = 0; i < allP.size(); i++) {
            s = s + allP.get(i).toString() + "\n";
        }
        return s;
    }
 public void addPass(String name ,int p_id,int passportnum ,String bday,String pass) {
       Passenger p = new Passenger(name, p_id, passportnum, bday,pass);
        db.insertToTable("passenger",p.toString());

    }
 
  public void addAdmin(String id ,String pass) {
       Admin p = new Admin(id,pass);
        db.insertToTable("admin",p.toString());
        
        
        

    }

 public void addFlight(String arrival , int seat, int flightnum, String dep ,String  from, String to,int price ,String aid ) {
       Flight p = new Flight( arrival ,  seat,  flightnum,  dep ,  from,  to, price,aid );
        db.insertToTable("flight",p.toString());


}
 public void deleteflightnum(String flight) {
        db.deleteFromTable("flight", "flightnum", flight);
    }
 
 public ArrayList<Integer> getflightnum(){
        ArrayList<Integer> allflight = new ArrayList();
        ArrayList<Flight> allf = new ArrayList();
        allf = db.getAllFlight();
        for (int i = 0; i < allf.size(); i++) {
            allflight.add(allf.get(i).getFlightNO());
            System.out.println(allf.get(i).getFlightNO());
        }
        
        return allflight;
    }
    
}
