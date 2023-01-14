
package onlinebanking;

import java.util.Scanner;

public class Admin extends Bank implements Create {
 int id,pass;
 String ad_Name,usera_name;
 
 
 Admin()
 {
   ad_Name="";
   usera_name="";
   pass=0;
   id=0;
 }
 
 
 
 Admin[] admin_menu(Admin[] a_arr,Customer[] c_arr,Feedback[] fb){
    Scanner sc=new Scanner(System.in);
     int pas=0,chi=0,cnt=0;
     String usnr;
     for(;;)
     {
        cnt=0;
      System.out.println("\t\t****** ADMIN MENU ******");
       System.out.println(" 1 - Login ");
       System.out.println(" 2 - Create");
       System.out.println(" 3 - Close Account / Delete ");
       System.out.println(" 4 - Exit ");
       chi =sc.nextInt();
     if(chi==1)
     {
          Scanner bc=new Scanner(System.in);
          for(;;){
         System.out.println("Enter User Name: ");
         usnr=bc.nextLine();
         boolean flag = Character.isDigit(usnr.charAt(0));
         if(flag==false)
         {
         break;
         }
         else
         {
         try{
           throw new MyException("Enter a valid Username:");
           }catch(MyException e){
               System.out.println(e);
           } 
         }
         }
         
         for(;;){ 
         try{
             System.out.println("Enter PIN(4 Digits)");
         pas =Integer.parseInt(bc.next());
       
      if(pas>=1000 && pas<=9999){
          break;
     }
     else{
         try{
           throw new MyException("Enter a valid PIN(4 Digits)");
           }catch(MyException e){
               System.out.println(e);
           }     
         }
     }catch(Exception e){
             System.out.println("Error!");
             
             }
     }
      
        for(int j = 0; j <ad_count; j++){
           if(a_arr[j].usera_name.equals(usnr) && a_arr[j].pass==pas )
           {
            a_arr[j]=menu(a_arr[j],a_arr,c_arr,fb,j);
            cnt=1;
            break;
            }         
               }
        
            if(cnt==0)
           {
            System.out.println("INVALID USER NAME OR PIN!");
           }
          }
     else if(chi==2)
     {
         int index=0;
          index=ad_count;
          a_arr[index] = new Admin();
        a_arr[index].Create_Account(c_arr,a_arr);
     
     }
      else if(chi==3)
     {
          Scanner jc=new Scanner(System.in);
         System.out.println("\t\tREMOVING ACCOUNT - ENTER ACCOUNT ID AND PASS");
         for(;;){
         System.out.println("Enter User Name: ");
        usnr=jc.nextLine();
         boolean flag = Character.isDigit(usnr.charAt(0));
         if(flag==false)
         {
         break;
         }
         else
         {
         try{
           throw new MyException("Enter a valid Username: ");
           }catch(MyException e){
               System.out.println(e);
           } 
         }
         }
         
        for(;;){ 
         try{
             System.out.println("Enter PIN(4 Digits):");
         pas =Integer.parseInt(jc.next());
       
      if(pas>=1000 && pas<=9999){
          break;
     }
     else{
         try{
           throw new MyException("Enter the valid PIN(4 Digits): ");
           }catch(MyException e){
               System.out.println(e);
           }     
         }
     }catch(Exception e){
             System.out.println("Error: ");
             
             }
     }

        for(int j = 0; j <ad_count; j++){
           if(a_arr[j].usera_name.equals(usnr)&& a_arr[j].pass==pas )
           {
            a_arr = remove(a_arr,j);
            ad_count=--ad_count;
            cnt=1;
            break;
            }         
               }
        
            if(cnt==0)
           {
            System.out.println("INVALID USER NAME OR PIN!");
           }
     }
     else if(chi==4)
     {
         return a_arr;
     }
     else{
       System.out.println(" INVALID ENTRY! ");
     }
     
     }
 }
 Admin menu(Admin adm,Admin[] aradm,Customer[] cu,Feedback[] fb,int jaj)
 {
 
    Scanner sc=new Scanner(System.in);
     int chi=0,choi=0;
     for(;;)
     {
      System.out.println("\t\t******ADMIN ("+adm.ad_Name+jaj+") MENU ******");
       System.out.println(" 1 - User Details ");
       System.out.println(" 2 - Customer Details ");
       System.out.println(" 3 - FeedBacks ");
       System.out.println(" 4 - Edit("+adm.ad_Name+"'s)Information ");
       System.out.println(" 5 - Exit ");
       
       chi =sc.nextInt();
     if(chi==1){
       adm.User_Details();
     }
      else if(chi==2)
     {
             System.out.println("Customer ID and Names: ");
            
                   for(int j = 0; j <cu_count; j++){
                   System.out.println(cu[j].id+" : "+cu[j].customer_Name);
       }  
                   for(;;){
         System.out.println("For more Details about any Customer press 1 (0 for exit)");
            choi =sc.nextInt();
         if(choi==1)
         {
             int idee=0,indx=0;
             
          System.out.println("Enter Customer ID (for full Details):");
          idee =sc.nextInt();
                   for(int j = 0; j <cu_count; j++){
                      if(cu[j].id==idee){
                       indx=j;
                         customer_Details(cu[indx]);
          
                       break;
                      }
                   }
                   if(indx>=cu_count)
                   {
                      System.out.println(" ID not Found: ");
                   }
                   
           
         }
         else if(choi==0)
         {
         break;
         }
             
     }
     }
       else if(chi==3)
     {
             System.out.println("\t\t\t\t #####FEEDBACKS##### ");
                for(int j = 0; j <F_id; j++){
                   System.out.println("FEEDBACK NO "+(j+1)+" : "+fb[j].fb);
       }  
     }
      else if(chi==4)
     {
      Edit_Info(adm,aradm,cu);         
     }
     else if(chi==5)
     {
         return adm;
     }
     else{
       System.out.println(" INVALID ENTRY! ");
     }
     
     }
 
 }
    public void Create_Account(Customer[] c_arr,Admin[] a_arr)
    {
    Scanner sc=new Scanner(System.in);
       System.out.println("/t/t/t******CREATING CUSTOMER ACCOUNT******");
       for(;;)
       {
       System.out.println("Enter Full Name: ");
       ad_Name = sc.nextLine();
       boolean res=ad_Name.matches("[a-z A-Z]+");
       if(res==true){
       break;
       }
       else{
       try{
               throw new MyException("Enter the correct Name: ");
           }catch(MyException e){
//               System.out.println("Invalid gender");
               System.out.println(e);
           } 
       }    
       }

       id=++Id;
       ad_count=++ad_count;
       System.out.println("Assigned ID: "+id);
       String us;
       boolean dec=false;
       for(;;){
        int cnt=0;
        dec=false;
        for(;;){
         System.out.println("Enter User Name:");
        us = sc.nextLine();
         boolean flag = Character.isDigit(us.charAt(0));
         if(flag==false)
         {
         break;
         }
         else
         {
         try{
           throw new MyException("Enter the valid Username:");
           }catch(MyException e){
               System.out.println(e);
           } 
         }
         }
       

       for(int j = 0; j <cu_count; j++){
            
             dec=c_arr[j].userc_name.equals(us);

           if(dec=true )
           {
            cnt=1;
            break;
            }
               }
       
       for(int j = 0; j <ad_count; j++){
             dec=a_arr[j].usera_name.equals(us);

           if(dec==true )
         {

            cnt=1;
            break;
            }
               }
       if(cnt==1)
       {
        System.out.println("User name is already taken!");
       }
       else{
       usera_name=us;
       break;
       }
       }
       for(;;){ 
         try{
             System.out.println("Enter PIN(4 Digits): ");
             pass = Integer.parseInt(sc.next()); 
       
      if(pass>=1000 && pass<=9999){
          break;
     }
     else{
         try{
           throw new MyException("Enter the valid PIN(4 Digits): ");
           }catch(MyException e){
               System.out.println(e);
           }     
         }
     }catch(Exception e){
             System.out.println("Error!");
             
             }
     }
            
    }
    
        
   
    public void User_Details()
    {
                   System.out.println("USER DETAILS: ");

       System.out.println("NAME: "+ad_Name);
       System.out.println("ID: "+id);
       System.out.println("USERNAME: "+usera_name);
       System.out.println("PIN: "+pass);
       System.out.println("BANK: "+bank_Name);
       System.out.println("Bank Address: "+bank_Address);
       System.out.println("Branch Code: "+branch_Code);

    }

     void customer_Details(Customer c)
    {
               System.out.println("USER DETAILS: ");

       System.out.println("NAME: "+c.customer_Name);
       System.out.println("ID: "+c.id);
       System.out.println("USERNAME: "+c.userc_name);
       System.out.println("PIN: "+c.password);
       System.out.println("GENDER: "+c.gender);
       System.out.println("AGE: "+c.Age);
       System.out.println("DOB: "+c.DOB);
       System.out.println("ADDRESS: "+c.Cus_Address);
       System.out.println("PHONE NUMBER: "+c.phn_no);
       System.out.println("CURRENT BALANCE: "+c.amount);
       if(c.Loan==true)
       {
       System.out.println("LOAN AMOUNT: "+c.Loan_amount);
       }
       System.out.println("BANK: "+c.bank_Name);
       System.out.println("Bank Address: "+c.bank_Address);
       System.out.println("Branch Code: "+c.branch_Code);

    }
    
     void Edit_Info(Admin a,Admin[] a_arr,Customer[] c_arr)
     {
     Scanner sc=new Scanner(System.in);
    
         int chi=0;  
         System.out.println("Which information you want to change : ");
         System.out.println("1 - Name : ");
         System.out.println("2 - User Name : ");
         System.out.println("3 - PIN : ");
         System.out.println("You cannot change your ID: ");
         chi=sc.nextInt();
         if(chi==1)
         {
             System.out.println("Previous NAME: "+a.ad_Name);
             for(;;)
       {
       System.out.println("Enter Full Name: ");
       a.ad_Name = sc.nextLine();
       boolean res=a.ad_Name.matches("[a-z A-Z]+");
       if(res==true){
       break;
       }
       else{
       try{
               throw new MyException("Enter the correct Name: ");
           }catch(MyException e){
//               System.out.println("Invalid gender");
               System.out.println(e);
           } 
       }    
       }
           
         }
         else if(chi==2)
         {
            System.out.println("Previous USER NAME: "+a.usera_name);
            String us;
            boolean dec=false;
            for(;;){
        int cnt=0;
        dec=false;
        for(;;){
         System.out.println("Enter user name: ");
         us = sc.nextLine();
         boolean flag = Character.isDigit(us.charAt(0));
         if(flag==false)
         {
         break;
         }
         else
         {
         try{
           throw new MyException("Enter the valid Username: ");
           }catch(MyException e){
               System.out.println(e);
           } 
         }
         }
       

       for(int j = 0; j <cu_count; j++){
               dec=c_arr[j].userc_name.equals(us);

           if(dec=true ){
            cnt=1;
            break;
            }
               }
       
       for(int j = 0; j <ad_count; j++){
             dec=a_arr[j].usera_name.equals(us);

           if(dec==true )  {

            cnt=1;
            break;
            }
               }
       if(cnt==1)
       {
        System.out.println("User name is already taken!");
       }
       else{
       a.usera_name=us;
       break;
       }
       }
            
         }
         else if(chi==3)
         {
             System.out.println("Previous PIN(4 Digits): "+a.pass);
             for(;;){
                 
         try
         {
             System.out.println("Enter New PIN(4 Digits): ");
             a.pass = Integer.parseInt(sc.next()); 
       
      if(a.pass>=1000 && a.pass<=9999){
          break;
     }
     else{
         try{
           throw new MyException("Enter the valid PIN(4 Digits): ");
           }catch(MyException e){
               System.out.println(e);
           }     
         }
     }catch(Exception e){
             System.out.println("Error!");
             
             }
     }
         
         }
         
         else{
                System.out.println(" INVALID ENTRY! ");
         }  
     
     }

      Admin[] remove(Admin[] arr, int index)
    {

        Admin[] Array = new Admin[arr.length - 1];
        for (int i = 0, k = 0; i < arr.length; i++) {
            if (i == index) {
                continue;
            }
            Array[k++] = arr[i];
        }
        return Array;
    }    
}
