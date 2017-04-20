/*
 * ER project
 * I hereby declare upon my word of honor that I have neither given nor 
 * received unauthorized help on this work. 
 *
 */

/**
 *This is the main class for the Emergency room project. 
 * @author sarahgardiner
 * @date 2/1/17
 */

//imports
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;


public class Main {
    
    
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        ArrayList<Patient> ERlist = new ArrayList<>();
        
        while(true){
            System.out.print("Please select your option from the following menu:\n" +
                "E: Enter a new patient\n" +
                "N: Find next patient & remove him/her from the list\n" +
                "F: Find the position of a specific patient\n" +
                "S: Display the list of patients sorted by priority\n" +
                "P: Print the list of patients sorted by patient ID\n" +
                "Q: Quit\n" +
                "Enter your choice:");
            String answer = in.next();
            answer = answer.toUpperCase();
            if(answer.equals("E")){
                //get date and time
                String timeStamp = new SimpleDateFormat("yyyyMMdd_HH:mm").format(Calendar.getInstance().getTime());
                
                //get ID number
                int ID = 0;
                String fName = "ID.txt";
                String line = null;
                int counter = 0;
                int i = 0;
                String a = null;
                try{
                    FileReader fileReader = new FileReader(fName);
                    BufferedReader bufferedReader = new BufferedReader(fileReader);
                    while((line = bufferedReader.readLine()) != null) {
                        a = line;      
                    }
                    
                    ID = Integer.parseInt(a);
                    bufferedReader.close();
                    
                  }
                catch(FileNotFoundException ex) {}
                catch(IOException ex) {}
                
                String.format("%06d", ID);
                
                //get name and priority number
                System.out.println("Enter first name of patient: ");
                String fname = in.next();
                System.out.println("Enter last name of patient: ");
                String lname = in.next();
                System.out.print("Enter priority number of patient: ");
                int priority = in.nextInt();

                //date and time
                TimeDate D = new TimeDate();
                String Date = D.getDate(timeStamp);
                String Time = D.getTime(timeStamp);
                
                //constructor of patient
                Patient P = new Patient(Time, fname, lname, priority, Date, ID);
                ERlist.add(P);
                
                
                ID++;

                BufferedWriter bw = null;
		FileWriter fw = null;
                String content = null;
                
		try 
                {
                    content = ""+ ID;
                    fw = new FileWriter("ID.txt");
                    bw = new BufferedWriter(fw);
                    bw.write(content);
                    bw.close();
		}
                
                catch (IOException e) 
                {
                     e.printStackTrace();
                }
            }
            
            else if (answer.equals("N")){ //find next patient and remove them from list
                Collections.sort(ERlist, new Comparator<Patient>() {
                   @Override
                   public int compare(Patient o1, Patient o2) {
                       return o2.getPri() - o1.getPri(); 
                   }
                   
               });
                if(ERlist.size()!=0){
                    Patient P = ERlist.get(0);
                    System.out.println("Patient "+ P.getFullName() + " is ready to be seen");
                    ERlist.remove(P);
                }
                else
                   System.out.println("There are no more Patients to be seen.");
                }
            
            else if (answer.equals("F")){//find position of a patient
                System.out.println("Please enter patient's first name: ");
                String fn = in.next();
                System.out.println("Please enter patient's last name: ");
                String ln = in.next();
                
                //sort list by priority
                Collections.sort(ERlist, new Comparator<Patient>() {
                   @Override
                   public int compare(Patient o1, Patient o2) {
                       return o2.getPri() - o1.getPri(); 
                   }
               });
                int counter = 0;
                for(int i = 0; i<ERlist.size();i++) {
                    Patient a = ERlist.get(i);
                    if(a.getFname().equalsIgnoreCase(fn)){
                        break;
                    }
                    counter++;
                }
                //counter = ERlist.size() - counter;
                System.out.println("There are "+ counter + " people ahead of " + fn + " " + ln);
            }
            else if (answer.equals("S")){ //sorted list by priority number
               System.out.println("Priority      ID        ArrivalTime     Last name,      First Name");
               Collections.sort(ERlist, new Comparator<Patient>() {
                   @Override
                   public int compare(Patient o1, Patient o2) {
                       return o2.getPri() - o1.getPri(); 
                   }
               });
               for(int i = 0; i<ERlist.size();i++) {
                System.out.println(ERlist.get(i).getAllPri());
                }
            }
            else if (answer.equals("P")){ //printed by ID number
                System.out.println("ID      Priority        ArrivalTime     Last name,      First Name");
                Collections.sort(ERlist, new Comparator<Patient>() {
                   @Override
                   public int compare(Patient o1, Patient o2) {
                       return o2.getID() - o1.getID(); 
                   }
               });
                for(int i = 0; i<ERlist.size();i++) {
                System.out.println(ERlist.get(i).getAllID());
                }
            }
            else if (answer.equals("Q")){
                break;
            }
            else
                System.out.println("That is not an option, please try again.");
        }
        System.out.println("Have a great day!");
    }
}
