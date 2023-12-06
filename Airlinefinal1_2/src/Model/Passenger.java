/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author user
 */
public class Passenger {
      String name ;
    int p_id;
    int passportnum;
    String bday;
    String pass;

    public Passenger(String name, int p_id, int passportnum, String bday, String pass) {
        this.name = name;
        this.p_id = p_id;
        this.passportnum = passportnum;
        this.bday = bday;
        this.pass = pass;
    }

    public String getName() {
        return name;
    }

    public int getP_id() {
        return p_id;
    }

    public int getPassportnum() {
        return passportnum;
    }

    public String getBday() {
        return bday;
    }

    public String getPass() {
        return pass;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setP_id(int p_id) {
        this.p_id = p_id;
    }

    public void setPassportnum(int passportnum) {
        this.passportnum = passportnum;
    }

    public void setBday(String bday) {
        this.bday = bday;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    @Override
    public String toString() {
      //  String out ="";
       
        
       
        return  "'"+this.name+"', '"+this.p_id+"', '"+this.passportnum+"', '"+this.bday+"', '"+this.pass+"'";
    //return out; }
    
}
}
