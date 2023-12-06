
package Model;


public class Admin {
      String a_id;
    String apass;

    public Admin(String a_id, String apass) {
        this.a_id = a_id;
        this.apass = apass;
    }

    public String getA_id() {
        return a_id;
    }

    public String getApass() {
        return apass;
    }

    public void setA_id(String a_id) {
        this.a_id = a_id;
    }

    public void setApass(String apass) {
        this.apass = apass;
    }

    @Override
    public String toString() {
        String out ="";
       
        
       
        out= "'"+this.apass+"', '"+this.a_id+"'";
    return out; }
    
}
