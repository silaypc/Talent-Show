
package talent.show;

/**
 *
 * @author SILA & IPEK
 * 
 */

import java.util.Scanner;

public class ApplicantMain {

    
    public static void menuText(){
         System.out.println("\nMENU\n1- Add application\n2- Delete application with ID\n3- Delete application with show name\n4- Search show\n5- Display application info"
             + "\n6- Short list of applications\n7- Application add/delete status\n8- Create Schedule\n9- Display Schedule\n10- Email list\n11- EXIT\n\n[Choose operation from the menu]: ");
    }
    
    public static void menu1(){
    
     String choice;
     int num;
     String title;
     
     
     menuText();
     Scanner sc = new Scanner(System.in);
     choice = sc.next();
     
     while(!choice.matches("1||2||3||4||5||6||7||8||9||10||11") )
     {
         System.out.println("\n[Enter valid number]: ");
         choice = sc.next();
     }
     
     while(choice.matches("1||2||3||4||5||6||7||8||9||10"))
     {
         
     switch(choice){
         
         
         case "1": ApplicantSys.addApplicant();
             menuText();
             choice = sc.next();        
         break;
         
         
         case "2": 
             if(!ApplicantSys.schedule.isEmpty())
               System.out.println("\n[Deletion can not be made after the schedule is created.]");
             else{
         System.out.println("\n[Enter ID to delete from the list]: ");
         num = sc.nextInt();
         ApplicantSys.deleteApplicant(num);
         menuText();
         choice = sc.next();   
             }
         break;
         
         
         case "3": 
              if(!ApplicantSys.schedule.isEmpty())
               System.out.println("\n[Deletion can not be made after the schedule is created.]");
             else{
         System.out.println("\n[Enter show name to delete from the list]: ");
         sc.nextLine();
         title = sc.nextLine();
         ApplicantSys.deleteApplicant(title);
         menuText();
         choice = sc.next();  
              }
         break;
         
         
         case "4": System.out.println("\n[Enter show name to search]: ");
         sc.nextLine();
         title = sc.nextLine();
         Applicant temp = ApplicantSys.searchApplicant(title);
         if(temp != null) 
             System.out.println("\n[Applicant already added]");
         menuText();
         choice = sc.next();  
         break;
         
         
         case "5": ApplicantSys.display();
         menuText();
         choice = sc.next();  
         break;
         
         
         case "6": ApplicantSys.listOfApplicants();
          menuText();
         choice = sc.next();  
         break;
         
         
         case "7": Applicant.formAddStatus();
          menuText();
         choice = sc.next();  
         break;
         
         
         case "8": 
          if(ApplicantSys.schedule.isEmpty())
          ApplicantSys.createSchedule();
          else 
                 System.out.println("\n[Schedule already created]");
          menuText();
         choice = sc.next();  
         break;
         
         
         case "9": ApplicantSys.displaySchedule();
         menuText();
         choice = sc.next();  
         break;
         
         
         case "10": ApplicantSys.emailList();
         menuText();
         choice = sc.next();  
         break;
         
         
     }
     
     while(!choice.matches("1||2||3||4||5||6||7||8||9||10||11") )
     {
         System.out.println("\n[Enter valid number]: ");
         choice = sc.next();
     }
     }
         
     
    }
    
    
    
    public static void main(String[] args) {
        
       menu1();
      
    }
    
}
