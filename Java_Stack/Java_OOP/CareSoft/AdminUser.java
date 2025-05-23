package Java_OOP.CareSoft;

import java.util.ArrayList;
import java.util.Date;

public class AdminUser extends User implements HIPAACompliantUser, HIPAACompliantAdmin {
	private Integer employeeID;
    private String role;
    private ArrayList<String> securityIncidents;

    public AdminUser(int id, String role) {
        setId(id);
        this.role=role;
        this.securityIncidents=new ArrayList<String>();
    }


    
    public void newIncident(String notes) {
        String report = String.format(
            "Datetime Submitted: %s \n,  Reported By ID: %s\n Notes: %s \n", 
            new Date(), this.id, notes
        );
        securityIncidents.add(report);
    }
    public void authIncident() {
        String report = String.format(
            "Datetime Submitted: %s \n,  ID: %s\n Notes: %s \n", 
            new Date(), this.id, "AUTHORIZATION ATTEMPT FAILED FOR THIS USER"
        );
        securityIncidents.add(report);
    }

    @Override
    public ArrayList<String> reportSecurityIncidents() {

        return getSecurityIncidents();
    }

    @Override
    public boolean assignPin(int pin) {
        if ((pin+"").length()==6){
            this.setPin(pin);
            return true;

        }
        return false;
    }

    @Override
    public boolean accessAuthorized(Integer confirmedAuthID) {

        if (confirmedAuthID.equals(getEmployeeID())) {
            return true;
        }else {
            authIncident();
        }


        return false;

    }

    // TO DO: Setters & Getters

    public Integer getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(Integer employeeID) {
        this.employeeID = employeeID;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public ArrayList<String> getSecurityIncidents() {
        return securityIncidents;
    }

    public void setSecurityIncidents(ArrayList<String> securityIncidents) {
        this.securityIncidents = securityIncidents;
    }
}
