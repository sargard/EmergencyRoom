/*
 * 
 * I hereby declare upon my word of honor that I have neither given nor 
 * received unauthorized help on this work. 
 *
 */

/**
 * Patient class that constructs a patient object that stores the time, ID, first name,
 * last name, priority, and date of when that patient came in.
 *
 * @author sarahgardiner
 * @date 2/1/17
 * 
 */



public class Patient {
    
    
    private String time;
    private int ID;
    private String fname;
    private String lname;
    private int priority;
    private String date;
    
    
    
    /**
     * This method create the object patient
     * @param t is time the patient came in.
     * @param fn is the first name of the patient.
     * @param ln is the last name of the patient.
     * @param pri is the priority of the patient.
     * @param d is the date the patient came in.
     * @param i is the ID number of the patient.
     */
    public Patient(String t, String fn, String ln, int pri,String d, int i){
        super();
        time = t;
        ID = i;
        fname = fn;
        lname = ln;
        priority = pri;
        date = d;
    }
    
    /**
     * This getter returns the first name of the patient.
     * @return the first name of the patient.
     */
    public String getFname(){
        return this.fname;
    }
    
    /**
     * This getter returns the last name of the patient.
     * @return last name of the patient.
     */
    public String getLname(){
        return this.lname;
    }
    
    /**
     * This getter returns the full name of the patient.
     * @return the full name of the patient.
     */
    public String getFullName(){
        String fn = this .getFname();
        String ln = this.getLname();
        String full = fn + " " + ln;
        return full;
    }
    
    /**
     * This getter returns the priority of the patient.
     * @return the priority of the patient.
     */
    public int getPri(){
        return priority;
    }
    
    /**
     * This getter returns the account ID of the patient.
     * @return the account ID of the patient.
     */
    public int getID(){
        return ID;
    }
    
    /**
     * This getter returns the time the patient got to the emergency room.
     * @return the time the patient got to the emergency room.
     */
    public String getTime(){
        return time;
    }
    
    /**
     * This getter returns everything about the patient starting with the priority number of he or she.
     * @return a string with all the information about the patient.
     */
    public String getAllPri(){
        String a = Integer.toString(priority);
        int b = ID;
        String c = "        ";
        String d = ",               ";
        String all = String.format("%03d", priority) + c + String.format("%06d", ID) + c + time + c + lname + d + fname ;
        return all;
    }
    
    /**
     * This getter returns everything about the patient starting with the account ID number of he or she.
     * @return a string with all the information about the patient.
     */
    public String getAllID(){
        String a = Integer.toString(priority);
        int b = ID;
        String c = "        ";
        String d = ",               ";
        String all = String.format("%06d", ID) + c + String.format("%03d", priority) + c + time + c + lname + d + fname ;
        return all;
    }

    

    

   
}
