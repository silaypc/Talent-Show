
package talent.show;


import java.util.Scanner;

/**
 *
 * @author SILA & IPEK
 * 
 */

public class Group extends Applicant implements Representative{
    

    public Group() {
        total_groups_added++;
    }
    
    public Group(String name, String type) {
        super(name, type);
        total_groups_added++;
        
    }
    
    @Override
    public void getInput(){
         Scanner sc = new Scanner(System.in);
         System.out.println("[How many people in the group?]: ");
         int no_of_people = sc.nextInt();
         while(no_of_people < 3 && no_of_people > 15)
         {
             System.out.println("\n[Groups must include at least 3 and at most 15 individuals. Enter valid number]: ");
             no_of_people = sc.nextInt();
         }
         super.getInput();
         for(int i = 0; i <no_of_people; i++){
             Individual_info temp = new Individual_info();
             System.out.println("\n[Enter information for applicant number " +(i+1) +" from the group]\n----");
             temp.getInput();
             ind.add(temp);
         }
         
    }

    
    
    @Override
    public String toString() {
        String rep = chooseRep();
        String all = super.toString();
        for(int i = 0; i < ind.size(); i++)
            all += ind.get(i).toString();
        return all +"\n[Representative of the group is: "+rep+"]\n";
    }
    
    @Override
    public void informationEmail()
    {
        System.out.println("Information email regarding the schedule and representative will be sent to the following " +ind.size() +" emails:");
        for(int i = 0; i < ind.size(); i++)
            System.out.println(+(i+1) +". [" +ind.get(i).getEmail() +"]");
    }
    
    @Override
    public String chooseRep(){
        int max = 0;
        for(int i = 0; i < ind.size(); i++)
        {
            if(ind.get(max).getAge() <= ind.get(i).getAge())
                max = i;
        }
        String rep = ind.get(max).getName_surname();
        return rep;
    }
    
   
}
