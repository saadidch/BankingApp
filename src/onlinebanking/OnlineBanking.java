
package onlinebanking;

import java.util.Scanner;
public class OnlineBanking {
 

   
    public static void main(String[] args) {
          Scanner sc=new Scanner(System.in);
       System.out.println("\t\t\t\t\t\t****** WELCOME TO JAVA BANK ******");
       int choice,n;
              Admin[] ad_arr = new Admin[50];
              Customer[] cu_arr = new Customer[50];
             Feedback[] fb=new Feedback[50];
              Admin admin = new Admin();
             Customer customer = new Customer();
             Feedback feedbk=new Feedback();

       for(;;)
       {
           System.out.println("\t\t\t****** MAIN MENU ******");
           System.out.println(" 1 - Admin ");
           System.out.println(" 2 - Customer ");
           System.out.println(" 3 - Bank Details ");
           System.out.println(" 4 - FeedBack ");
           System.out.println(" 5 - Exit ");
       choice =sc.nextInt();
       
       if(choice==1)
       {
           System.out.println(" ADMIN ");
        n=admin.getaid();
        ad_arr[n] = new Admin();
       ad_arr = admin.admin_menu(ad_arr,cu_arr,fb);
       
       }
       else if(choice==2)
       {
           if(admin.getaid()<1)
           {
           System.out.println(" Admin ACCOUNT IS NEEDED ! ");
             
           }
           else{
        System.out.println(" Customer ");
        n=customer.getcid();
        cu_arr[n] = new Customer();
        cu_arr= customer.Customer_menu(cu_arr,ad_arr);
           }
       } 
       else if(choice==3)
       {
          System.out.println(" BANK DETAILS ");
          admin.Bank_Details();
          admin.Services();
       
       }
       else if(choice==4)
       {
        System.out.println(" FEEDBACK --- Message To The Bank ");
        n=admin.getfid();
        fb[n] = new Feedback();
        fb=feedbk.feedmenu(fb);
         
       }
       else if(choice==5)
       {
         break;
       }
       else
       {
         System.out.println(" INVALID ENTRY "); 
       }
       
       }
    }
}
    

// Loan 
// loan-id , loan amount 
//loan menu(),getloan,giveloan back,detucut loan from every transaction

