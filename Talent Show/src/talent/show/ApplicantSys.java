
package talent.show;


import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Scanner;

/**
 *
 * @author SILA & IPEK
 * 
 */

public class ApplicantSys {
      public static ArrayList<Applicant> applicant_list  = new ArrayList();
      public static LinkedHashSet<String> temp = new LinkedHashSet();
      public static LinkedHashSet<String> schedule = new LinkedHashSet();
      public static final double STARTING_TIME = 19;
      public static double end = 0;
      public static double end_time;
     
      
      
 
       public static void addApplicant(){
           Scanner sc = new Scanner(System.in);
           System.out.println("[Do you want to add applicant? (enter solo/duo/group or NO to stop)]: ");
           String input = sc.next();
        
           while(!input.equalsIgnoreCase("no"))
           {

               if(input.equalsIgnoreCase("solo")){
                   
                   int order = applicant_list.size() + 1;
                   Applicant x = new Solo();
                   x.setId(order);
                   x.getInput();
                   applicant_list.add(x);
            
                   System.out.println("[Add another applicant?  (enter solo/duo/group or NO to stop)]:  ");
                   input = sc.next();
                
               } 
               else if(input.equalsIgnoreCase("Duo")){
                
                   int order = applicant_list.size() + 1;
                   Applicant x = new Duo();
                   x.setId(order);
                   x.getInput();
                   applicant_list.add(x);
            
                   System.out.println("[Add another applicant?  (enter solo/duo/group or NO to stop)]:  ");
                   input = sc.next();
            
               } else if(input.equalsIgnoreCase("group")){
            
                   int order = applicant_list.size() + 1;
                   Applicant x = new Group();
                   x.setId(order);
                   x.getInput();
                   applicant_list.add(x);
                
                   System.out.println("[Add another applicant?  (enter solo/duo/group or NO to stop)]:  ");
                   input = sc.next();
                
               }else{System.out.println("[Invalid input. Enter solo/duo/group] ");
               input = sc.next();
               }
           }
       }
       
       
       public static boolean deleteApplicant(int id){
      
           int i;
           for(i = 0; i < applicant_list.size(); i++){
               int no = applicant_list.get(i).getId();
               if(id == no){
                   applicant_list.remove(i);
                   System.out.println("\n[Application succesfully deleted]");
                   return true;
               }
               
           }System.out.println("\n[Application not found]");
           return false;
       }
       
       
        public static boolean deleteApplicant(String title){
         
           int i;
           for(i = 0; i < applicant_list.size(); i++){
               String name = applicant_list.get(i).getName();
               if(name.equals(title)){
                   applicant_list.remove(i);
                   System.out.println("\n[Application title: " +title  +" succesfully deleted]");
                   return true;
               }
              
           } System.out.println("\n[Application not found]");
           return false;
       }
       
       public static Applicant searchApplicant(String title)
       {
           for(int i = 0; i < applicant_list.size(); i++)
           {
               String name = applicant_list.get(i).getName();
               if(name.equals(title))
                   return applicant_list.get(i);
           }System.out.println("\n[Applicant does not exist]");
           return null;
   }
   
       public static void display(){
       
           if(applicant_list.isEmpty())
               System.out.println("\n[No applicants have been registered yet.]");
           for(int i = 0; i < applicant_list.size(); i++)
           {
               System.out.println(applicant_list.get(i).toString());   
               }
   }
       
       public static void listOfApplicants()
    {
        System.out.println("\n[Short list of applications(ID/Name/Type)]\n--------------------------------\n");
        for(int i = 0; i < applicant_list.size(); i++)
            System.out.println("  " +applicant_list.get(i).getId() +"  " +applicant_list.get(i).name + "  ["+applicant_list.get(i).type +"]\n");
        System.out.println("--------------------------------");
        System.out.println("[Number of applicants is]: " +applicant_list.size());
    } 
   
       
       public static boolean createSchedule() {
        
        if(applicant_list.size() < 3 || applicant_list.size() > 12)  {
            
            System.out.println("\n[The number of applicants must be at least 3 and at most 12.]"
                    + "\n[You currently have " + applicant_list.size() + " applicants.]");
            return false;
            
        }
        
        
        Scanner input = new Scanner(System.in);
        double duration;
        double start = 19.05;
        
        System.out.println("\nS[chedule cannot be changed after creation.]"
                + "\n[If you have entered applicants with identical show titles the latter will be removed.]"
                + "\n[Proceed? (YES/NO]): ");
        
        String answer = input.next();
        
        while( !answer.equalsIgnoreCase("YES") && !answer.equalsIgnoreCase("NO")) {
            
            System.out.println("\n[Warning] Enter a valid input.");
            answer = input.next();
            
        }
        
        
        
        if(answer.equalsIgnoreCase("YES")) {
            
            for(int i = 0; i < applicant_list.size(); i++) {
                
                temp.add(applicant_list.get(i).name);
            }
            
            if(temp.size() < 3) {
                System.out.println("\n[Warning] Not enough applicants. Deleting schedule.");
                temp.clear();
                return false;
            }
            
            
           
            
            for(String tempName : temp) {
                
                System.out.println("\n[Enter performance duration in minutes for show " + tempName + " (between 5 and 15)]: ");
                duration = input.nextFloat();
                
                while(duration < 5 || duration > 15) {
                    System.out.println("\n[Warning] Duration must be between 5 and 15 minutes.");
                    duration = input.nextDouble();
                }
                
                double length = duration;
                length *= 0.01;
                
                end =  start + length;
                
                start = (int)(Math.round(start * 100))/100.0;
                
                if((end > 19.59 && end < 19.99) || (end > 20.59 && end < 20.99) || (end > 21.59 && end < 21.99))
                  end += 0.40;
                end = (int)(Math.round(end * 100))/100.0;
                
                schedule.add(tempName +"  -->  Start: " + start + "   End: " + end);
                
                start = end + 0.03;
                
                if((start > 19.59 && start < 19.99) || (start > 20.59 && start < 20.99) || (start > 21.59 && start < 21.99))
                  start += 0.40;
                start = (int)(Math.round(start * 100))/100.0;
                
              
                
            }
            
            
            end_time = end + 0.15;
            
            if((end_time > 19.59 && end_time < 19.99) || (end_time > 20.59 && end_time < 20.99) || (end_time > 21.59 && end_time < 21.99))
              end_time += 0.40;
            end_time = (int)(Math.round(end_time * 100))/100.0;
            
            
            System.out.println("\n[SCHEDULE SUCCESSFULLY CREATED]");
            return true;
        }  
        
        
        else
            return false;
        
    }
     
      public static void displaySchedule()
      {
          if(temp.size() >= 3 && temp.size() <=12){
          System.out.println("\n    SCHEDULE\n---------------\n[Intro] -> start: 19.00 end: 19.05");
          for (String s : schedule) 
            System.out.print(s + "\n");
          //end = end + 0.05;
          if((end > 19.59 && end < 19.99) || (end > 20.59 && end < 20.99) || (end > 21.59 && end < 21.99))
                  end -= 0.40;
          end = (int)(Math.round(end * 100))/100.0;
        System.out.println("[Voting] -> start: " +end +" end: " +end_time); }else System.out.println("[Schedule not created yet]");
      }
      
      public static void emailList(){
          if(schedule.isEmpty())
              System.out.println("\n[Schedule not created yet]");
          else{
          System.out.println("\n[Email list]: \n");
          for(String tempName : temp)
          {
              searchApplicant(tempName).informationEmail();
          }
          
          }
      }
      
     
}
