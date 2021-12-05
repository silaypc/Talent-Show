
package talent.show;

import java.util.Scanner;

/**
 *
 * @author SILA & IPEK
 * 
 */

public class Individual_info {
    private int age;
    private String name_surname;
    private char gender;
    private String contact_number;
    private String email;
    
    
     public Individual_info() {
        super();
        age = 0;
        name_surname = null;
        gender = ' ';
        contact_number = null;
        email = null;
    }

    public Individual_info(int age, String name_surname, char gender, String contact_number, String email) {
        this.age = age;
        this.name_surname = name_surname;
        this.gender = gender;
        this.contact_number = contact_number;
        this.email = email;
    }
    
     public void getInput(){
         Scanner sc = new Scanner(System.in);
         System.out.println("Enter name and surname: ");
         this.name_surname = sc.nextLine();
         while(name_surname.equals(""))
         {
             System.out.println("[Name and surname can not be empty! Enter again]: ");
               this.name_surname = sc.nextLine();
         }
         
         
         System.out.println("Enter age : ");
         
       
             try {
             this.age = Integer.parseInt(sc.next());
         } catch (NumberFormatException e) {
          
             System.out.println("Enter valid age: ");
             this.age = Integer.parseInt(sc.next());
         }
         
         System.out.println("Enter gender (F/M): ");
         char a = sc.next().charAt(0);
         while(a != 'F' && a != 'f' && a != 'M' && a != 'm'){
             System.out.println("Enter valid gender: ");
             a = sc.next().charAt(0);
         } this.gender = a;
         sc.nextLine();
         System.out.println("Enter phone number: ");
         this.contact_number = sc.nextLine();
          while(contact_number.equals(""))
         {
             System.out.println("[Contact number can not be empty! Enter again]: ");
               this.contact_number = sc.nextLine();
         }
         System.out.println("Enter email: ");
         this.email = sc.nextLine();
         while(email.equals(""))
         {
             System.out.println("[Email can not be empty! Enter again]: ");
               this.email = sc.nextLine();
         }
    }

    @Override
    public String toString() {
        return "\n---------------\nName and Surname: " +name_surname +"\nAge: " +age +"\nGender: " +gender + "\nContact Number: " +contact_number + "\nEmail: " +email;
    }

   
    
    //setters and getters start

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName_surname() {
        return name_surname;
    }

    public void setName_surname(String name_surname) {
        this.name_surname = name_surname;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public String getContact_number() {
        return contact_number;
    }

    public void setContact_number(String contact_number) {
        this.contact_number = contact_number;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

   //getters and setters end
}
