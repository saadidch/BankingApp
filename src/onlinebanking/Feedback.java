
package onlinebanking;

import java.util.Scanner;


public final class Feedback extends Bank {
    
     String fb;
     
     Feedback(){
       fb="";
     }
     
     Feedback[] feedmenu(Feedback[] f)
     {
       
       int index=0;
          index=F_id;
             
        f[index].feedback();
        return f;
     }
     void feedback(){
          Scanner sc=new Scanner(System.in);
        System.out.println("\t\t****** ENTER YOUR FEEDBACK ******");
      fb=sc.nextLine();
      F_id=++F_id;
       
     }
     
     
     
     
     
   
}
