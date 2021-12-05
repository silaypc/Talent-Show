
package talent.show;


/**
 *
 * @author SILA & IPEK
 * 
 */

public class Solo extends Applicant{
    
    
    
     public Solo() {
        super();
        total_solos_added++;
    }

    public Solo(String name, String type) {
        super(name, type);
        total_solos_added++;
    }
    
    @Override
     public void getInput(){
         super.getInput();
         Individual_info temp = new Individual_info();
             System.out.println("\n[Enter information for applicant]:\n----");
             temp.getInput();
             ind.add(temp);
    }

    @Override
    public String toString() {
        return super.toString() + ind.toString() +"\n";
    }
     
     
    
     @Override
     public void informationEmail(){
         System.out.println("Information email will be sent to the email [" +ind.get(0).getEmail() +"]" );
     }
   
}
