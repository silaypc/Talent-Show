
package talent.show;


/**
 *
 * @author SILA & IPEK
 * 
 */

public class Duo extends Applicant implements Representative{
    
   
    public Duo() {
        super();
        total_duos_added++;
    }

    public Duo(String name, String type) {
        super(name, type);
         total_duos_added++;
    }
    
    @Override
     public void getInput(){
         super.getInput();
         for(int i = 0; i <2; i++){
             Individual_info temp = new Individual_info();
             System.out.println("\n[Enter information for applicant number " +(i+1) +" from the duo]\n----");
             temp.getInput();
             ind.add(temp);
         }
         
    }

    @Override
    public String toString() {
        String rep = chooseRep();
        String all = super.toString();
        for(int i = 0; i < 2; i++)
            all += ind.get(i).toString();
       return all +"\n[Representative of the duo is: " +rep +"]\n";
    }

    @Override
     public void informationEmail(){
         System.out.println("Information email will be sent to the emails: [" +ind.get(0).getEmail() +"] & [" +ind.get(1).getEmail() +"]" );
     }
     
    @Override
    public String chooseRep()
    {
        String rep;
        if(ind.get(0).getAge() <= ind.get(1).getAge())
        rep = ind.get(1).getName_surname();
        else rep = ind.get(0).getName_surname();
        return rep;
    }
   
     
}
