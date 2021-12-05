
package talent.show;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author SILA & IPEK
 * 
 */

public class Applicant {
    protected int id;
    protected String name, type;
    
    public static int total_groups_added = 0;
    public static int total_duos_added = 0;
    public static int total_solos_added = 0;
    
    protected ArrayList<Individual_info> ind = new ArrayList();
    
   
    
    

    public Applicant(String name, String type) {
        this.id = 0;
        this.name = name;
        this.type = type;
        
    }

    public Applicant() {
        
    }

    @Override
    public String toString() {
        return "\n   [APPLICANT]\nApplicant ID: "+id +"\nShow Name: " +name +"\nType: " +type;
    }
    
    public void getInput()
    {
        
        Scanner sc = new Scanner(System.in);
         System.out.println("   \nInitiating Input Process\n------------------------");
        System.out.println("Enter name of the show: ");
        name = sc.nextLine();
        while(name.equals(""))
         {
             System.out.println("[Name of show can not be empty! Enter again]: ");
               this.name = sc.nextLine();
         }
        System.out.println("Enter type of show: ");
        type = sc.nextLine(); 
        while(type.equals(""))
         {
             System.out.println("[Type of show can not be empty! Enter again]: ");
               this.type = sc.nextLine();
         }
        
          
    }
    
    //GETTERS AND SETTERS START

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
    
    //GETTERS AND SETTERS END
    
    
   //ABSTRACT METHOD
   public void informationEmail()
   {}
   
   
   public static void formAddStatus(){
       System.out.println("\n[You have added " +(total_groups_added + total_solos_added +total_duos_added) +" application forms]\n["+total_groups_added +" groups]  ["+total_duos_added +" duos]  [" +total_solos_added +" solos]\n"
               + "[And deleted " +((total_groups_added + total_solos_added +total_duos_added)- ApplicantSys.applicant_list.size())+"]");
   }
    
}
