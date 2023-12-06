/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.Admin;
import Model.Flight;
import Model.Passenger;
import java.lang.ModuleLayer.Controller;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author user
 */
public class DBAccess {
       Connection connection;
    Statement statement;

    private void connect() throws SQLException {
        connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/flightres", "root", "");
        statement = connection.createStatement();
    }
    
     private void disconnect() throws SQLException {
        statement.close();
        connection.close();
    }
     
         public void insertToTable(String tableName, String str){
        String query = "insert into "+ tableName + " values("+str+");";
        
        try {
            connect();
            statement.executeUpdate(query);
            disconnect();
        } catch (SQLException ex) {
            System.out.println("Not able to connect");
        }
    }
         
          public void addPass(String name , int pid, int passportnum, String bday ,String  pass) {
     String query = "insert into passenger values(" + name + ",'" + pid + "','" + passportnum + "',"  + bday + "'," + pass + ");";

        try {
            connect();
            statement.executeUpdate(query);
            disconnect();
        } catch (SQLException ex) {
            System.out.println("Not able to connect");
        }
}
     
                public void addAdmin(String pass , String aid) {
     String query = "insert into admin values(" +pass  + ",'" + aid + ");";

        try {
            connect();
            statement.executeUpdate(query);
            disconnect();
        } catch (SQLException ex) {
            System.out.println("Not able to connect");
        }
}
    
                      public void addFlight(String arrival , int seat, int flightnum, String dep ,String  from, String to,double price ) {
     String query = "insert into flight values(" + arrival + ",'" + seat + "','" + flightnum + "',"  + dep +",'" + from + "'," + to + "','"+ price + ");";

        try {
            connect();
            statement.executeUpdate(query);
            disconnect();
        } catch (SQLException ex) {
            System.out.println("Not able to connect");
        }
}
     
           public void deleteFromTable(String tableName, String attribute, String value){
        String query = "delete from " + tableName+ " where "+attribute +"='"+value+"';";
             try {
            connect();
            statement.executeUpdate(query);
            disconnect();

        } catch (SQLException ex) {
            Logger.getLogger(ModuleLayer.Controller.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
    }
             public void updateFlight(String arrival , int seat, int flightnum, String dep ,String  from, String to,int price  ){
        String query = "UPDATE flight SET " +
                    "arrivaltime = '" + arrival + "', " +
                    "availableseats = '" + seat + "', " +
                    "departtime = '" + dep + "', " +
                    "fromm = '" + from + "', " +
                    "too = '" + to + "', " +
                    "price = '" + price + "' " +
                    "WHERE flightnum = '" + flightnum + "'";
        try {
            connect();
            statement.executeUpdate(query);
            disconnect();
        } catch (SQLException ex) {
            System.out.println("Not able to connect");
        }
    }
         public  ArrayList<Flight> getAllFlight() {
   ArrayList <Flight> allF = new ArrayList();
   String query = "Select * from flight";

        try {
            connect();
            ResultSet resultSet = statement.executeQuery(query);
            System.out.println(query);
            while (resultSet.next()) {
               Flight f = new Flight(resultSet.getString("arrivaltime"),resultSet.getInt("availableseats"),resultSet.getInt("flightnum"),resultSet.getString("departtime"),resultSet.getString("fromm"),resultSet.getString("too"),resultSet.getInt("price"),resultSet.getString("A_id"));
               allF.add(f);
               System.out.println(allF.size());
            }
            disconnect();
        } catch (SQLException ex) {
            Logger.getLogger(ModuleLayer.Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
   
   return allF;
   }  
          public ArrayList<Passenger> getAllPass() {
   ArrayList <Passenger> allpass = new ArrayList();
   String query = "Select * from passenger";

        try {
            connect();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
               Passenger p = new Passenger(resultSet.getString("name"),resultSet.getInt("p_id"),resultSet.getInt("passportnum"),resultSet.getString("Birthdate"),resultSet.getString("p_pass"));
               allpass.add(p);
               System.out.println(allpass.size());
            }
            disconnect();
        } catch (SQLException ex) {
            Logger.getLogger(ModuleLayer.Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
   
   return allpass;
   }
          
                    public ArrayList<Admin> getAllAdmin() {
   ArrayList <Admin> allA = new ArrayList();
   String query = "Select * from Admin";

        try {
            connect();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
               Admin a = new Admin(resultSet.getString("pass"),resultSet.getString("a_id"));
               allA.add(a);
               System.out.println(allA.size());
            }
            disconnect();
        } catch (SQLException ex) {
            Logger.getLogger(ModuleLayer.Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
   
   return allA;
   }
                    
     
     
    
        
    public  ArrayList<Flight> getAllFlight1() {
   ArrayList <Flight> allF = new ArrayList();
   String query = "Select arrivaltime, availableseats, flightnum,departtime, fromm,too,price  from flight";

        try {
            connect();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
               Flight f = new Flight(resultSet.getString("arrivaltime"),resultSet.getInt("availableseats"),resultSet.getInt("flightnum"),resultSet.getString("departtime"),resultSet.getString("fromm"),resultSet.getString("too"),resultSet.getInt("price"),"");
               allF.add(f); 
               System.out.println(allF.size());
            }
            disconnect();
        } catch (SQLException ex) {
            Logger.getLogger(ModuleLayer.Controller.class.getName()).log(Level.SEVERE, null, ex);
        } 
        return allF;
}
    
    
    public int totalflights() {
        String query = "select count(Flightnum) from flight ;";

        int count = 0;

        try {
            connect();
            ResultSet resultSet = statement.executeQuery(query);
            if (resultSet.next()) {
                count = resultSet.getInt(1);
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }

        System.out.println(count);
        return count;
    }
    public int avg1() {
        String query = "select  AVG(price) from flight;;";

        int count = 0;

        try {
            connect();
            ResultSet resultSet = statement.executeQuery(query);
            if (resultSet.next()) {
                count = resultSet.getInt(1);
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }

        System.out.println(count);
        return count;
    }

}