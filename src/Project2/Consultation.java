/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Project2;

/**
 *
 * @author Sim
 */
public abstract class Consultation {
    private int id;
    private String firstName;
    private String lastName;
    private String ssn;
    
    public Consultation (int id, String firstName, String lastName, String ssn) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.ssn = ssn;
    }

    //i added this myself
    public int getID () {
        return id;
    }
    //
    
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getSsn() {
        return ssn;
    }

    public void setSsn(String ssn) {
        this.ssn = ssn;
    }
    
 //got rid of this cos idk if need it   public abstract double earnings();
    
    public String toString() {
        return firstName + " " + lastName + "\n" + "Social Security Number: " + ssn + "\n";
    }
}
