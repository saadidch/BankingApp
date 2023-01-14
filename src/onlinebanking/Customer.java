
package onlinebanking;
import java.util.Scanner;
import java.util.InputMismatchException;

public class Customer extends Bank implements Create {
    String customer_Name,DOB,Cus_Address;
    String gender,userc_name;
    int id,Age,password;
    double phn_no;
    float amount,Loan_amount;
    boolean Loan;
    Customer()
    {
    customer_Name =null ;
    userc_name=null;
     gender =null;
     id=0;
     Age=0;
     password=0;
    Cus_Address=null;
     DOB=null; 
     phn_no=0;
     amount=0;
     Loan=false;
     Loan_amount=0;
    }
    
     Customer[] Customer_menu(Customer[] c_arr,Admin[] a_arr){
    Scanner sc=new Scanner(System.in);
     int pas=0,chi=0,cnt=0;
     String usnr;
     for(;;)
     {
         cnt=0;
      System.out.println("\t\t****** Customer MENU ******");
       System.out.println(" 1 ---- Login ");
       System.out.println(" 2 ---- Create");
       System.out.println(" 3 ---- Close Account / Delete ");
       System.out.println(" 4 ---- Exit ");
       chi =sc.nextInt();
     if(chi==1)
     {  
         Scanner ac=new Scanner(System.in);
         for(;;){
         System.out.println("Enter User Name : ");
         usnr=ac.nextLine();
         boolean flag = Character.isDigit(usnr.charAt(0));
         if(flag==false)
         {
         break;
         }
         else
         {
         try{
           throw new MyException("Enter the valid Username");
           }catch(MyException e){
               System.out.println(e);
           } 
         }
         }
         for(;;){ 
         try{
             System.out.println("Enter Password");
         pas =Integer.parseInt(ac.next());
       
      if(pas>=1000 && pas<=9999){
          break;
     }
     else{
         try{
           throw new MyException("Enter the valid password");
           }catch(MyException e){
               System.out.println(e);
           }     
         }
     }catch(Exception e){
             System.out.println("error");
             
             }
     }
       
        for(int j = 0; j <cu_count; j++){
           if(c_arr[j].userc_name.equals(usnr) && c_arr[j].password==pas )
           {
            c_arr[j]=meun(c_arr[j],c_arr,a_arr);
            cnt=1;
            break;
            }         
               }
        
            if(cnt==0)
           {
            System.out.println("INVALID USER NAME OR PASSWORD");
           }
          }
     else if(chi==2)
     {
         int index=0;
          index=cu_count;
        c_arr[index] = new Customer();
        c_arr[index].Create_Account(c_arr,a_arr);
     
     }
     else if(chi==3)
     {
          Scanner dc=new Scanner(System.in);
          for(;;){
         System.out.println("Enter User Name : ");
         usnr=dc.nextLine();
         boolean flag = Character.isDigit(usnr.charAt(0));
         if(flag==false)
         {
         break;
         }
         else
         {
         try{
           throw new MyException("Enter the valid Username");
           }catch(MyException e){
               System.out.println(e);
           } 
         }
         }
          
         
          for(;;){ 
         try{
             System.out.println("Enter Password");
         pas =Integer.parseInt(dc.next());
       
      if(pas>=1000 && pas<=9999){
          break;
     }
     else{
         try{
           throw new MyException("Enter the valid password");
           }catch(MyException e){
               System.out.println(e);
           }     
         }
     }catch(Exception e){
             System.out.println("error");
             
             }
     }
    
          for(int j = 0; j <cu_count; j++){
           if(c_arr[j].userc_name.equals(usnr) && c_arr[j].password==pas )
           {
            c_arr=remove_cus(c_arr,j);
            cu_count=--cu_count;
            cnt=1;
            break;
            }         
               }
        
            if(cnt==0)
           {
            System.out.println("INVALID USER NAME OR PASSWORD");
           }
     }
     else if(chi==4)
     {
         return c_arr;
     }
     else{
       System.out.println(" INVALID ENTRY ");
     }
     
     }
 }
      Customer meun(Customer cus,Customer[] arr,Admin[] a_arr)
 {
 
    Scanner sc=new Scanner(System.in);
     int chi=0;
     for(;;)
     {
      System.out.println("\t\t****** Customer ("+cus.customer_Name+"'s) MENU ******");
       System.out.println(" 1 ---- User Details ");
       System.out.println(" 2 ---- Check Balance ");
       System.out.println(" 3 ---- Deposit ");
       System.out.println(" 4 ---- Withdraw ");
       System.out.println(" 5 ---- Transfer ");
       System.out.println(" 6 ---- Loan Details");
       System.out.println(" 7 ---- Edit("+cus.customer_Name+"'s)Information ");
       System.out.println(" 8 ---- Exit ");
       
       chi =sc.nextInt();
     if(chi==1){
       cus.User_Details();
     }
      else if(chi==2)
      {
         Chk_Balance(cus);
      }
      else if(chi==3)
      {
         Deposit(cus);
      }
      else if(chi==4)
      {
        Withdraw(cus);
      }
      else if(chi==5)
      {
        Transfer(cus,arr);
      }
      else if(chi==6)
     {
       cus=loan_menu(cus);          
     }
      else if(chi==7)
     {
      Edit_info(cus,arr,a_arr);         
     }
     else if(chi==8)
     {
         return cus;
     }
    
     else{
       System.out.println(" INVALID ENTRY ");
     }
     
     }
 
 }

      Customer loan_menu(Customer cus)
      {
          Scanner sc=new Scanner(System.in);
          int chi;
          for(;;){
        System.out.println("\t\t****** ("+cus.customer_Name+"'s) LOAN MENU ******");
       System.out.println(" 1 ---- Check Loan Amount ");
       System.out.println(" 2 ---- Get Loan ");
       System.out.println(" 3 ---- Return Loan ");
      System.out.println(" 4 ---- Exit ");
       chi =sc.nextInt();
     
      if(chi==1)
     {
         if(cus.Loan==false)
         {
          System.out.println(" NO Loan have been taken ");
         }
         else{
          System.out.println("LOAN AMOUNT : "+cus.Loan_amount);
      }
         
     }
      else if(chi==2)
     {
        System.out.println("+++++ GET LOAN +++++");
          float lon;
          System.out.println("Enter the amount you want to Lend  : ");
          lon=sc.nextFloat();
          cus.Loan=true;
          cus.Loan_amount=cus.Loan_amount+lon;
          cus.amount=cus.amount+lon;
           System.out.println(lon+" Been Entered in your Current balance : ");
     }
      else if(chi==3)
     {
        System.out.println("+++++ RETURN LOAN +++++");
        float lon,amt;
          System.out.println("Enter the amount you want to Pay/Return Back  : ");
          lon=sc.nextFloat();
            boolean b = chk(lon,cus);
              if(b==true)
          {
              if(lon>cus.Loan_amount)
              {
              amt = lon-cus.Loan_amount;
              cus.amount=cus.amount-lon;
              cus.amount=cus.amount+amt;
              cus.Loan_amount=0;
              }
              else{
            cus.amount=cus.amount-lon;
          cus.Loan_amount=cus.Loan_amount-lon;
         
              }
              
          if(cus.Loan_amount==0)
          {
          cus.Loan=false;
          }    
           System.out.println("Loan been paid by your Current balance : ");
          
          }
          else
          {
            System.out.println("INSUFFICIENT AMOUNT");
            System.out.println("The amount you enter is greater than it is in your account");
            
          }
          
        
     }
    
      else if(chi==4)
     {
         return cus;
     }
      else{
       System.out.println(" INVALID ENTRY ");
     }
      }
      }

    public void Create_Account(Customer[] c_arr,Admin[] a_arr)
     {

       Scanner sc=new Scanner(System.in);
       System.out.println("/t/t/t******CREATING CUSTOMER ACCOUNT******");
       for(;;)
       {
       System.out.println("Enter Full Name : ");
       customer_Name = sc.nextLine();
       boolean res=customer_Name.matches("[a-z A-Z]+");
       if(res==true){
       break;
       }
       else{
       try{
               throw new MyException("Enter the correct Name");   
           }catch(MyException e){
//               System.out.println("Invalid gender");
               System.out.println(e);
           } 
       }    
       }
       for(;;){
       System.out.println("Enter Gender : ");
       gender = sc.nextLine();
       if(gender.equalsIgnoreCase("male")|| gender.equalsIgnoreCase("female") || gender.equalsIgnoreCase("others"))
       {
        break;
       }
       else{
           try{
               throw new MyException("Enter the correct gender");   
           }catch(MyException e){
//               System.out.println("Invalid gender");
               System.out.println(e);
           } 
       }
       
       }
       
       System.out.println("Enter Full Address : ");
       System.out.println("LIKE--> street,city,town,house-no");
       Cus_Address = sc.nextLine();
       for(;;){
           int d,y,m;
       System.out.println("Enter DoB(Date of Birth) : ");
//       System.out.println("LIKE--> dd/mm/yyyy");
//       DOB = sc.nextLine();
       System.out.println("Enter the date");
       d=sc.nextInt();
       if(d>0 && d<=31){
       System.out.println("Enter the month");
       m=sc.nextInt();
       if(m>0 && m<=12){
       System.out.println("Enter the year");
       y=sc.nextInt();
       if(y>1922 && m<=2004){
           String d1=String.valueOf(d);
           String m1=String.valueOf(m);
           String y1=String.valueOf(y);
           DOB=d1+"/"+m1+"/"+y1;
           System.out.println(DOB);
         break;
       }
       else{
       System.out.println("Enter the correct year");
       }
       }
       else{
       System.out.println("Enter the correct month");
       }
       }
       else{
           System.out.println("Enter the correct day");
       }
       
       }
       Scanner input = new Scanner(System.in);
        boolean bError = true;
       do {
        try {
            System.out.println("Enter age: ");
            Age = Integer.parseInt(input.next());
            
             if(Age>=18 && Age <100)
        {
           bError = false;
        }
       
       else{
         if(Age<=18)
         {
           try{
           throw new MyException("you are under-age age");
           }catch(MyException e){
               System.out.println(e);
           }  
         }
         else
         {
            try{
           throw new MyException("Enter the valid age");
           }catch(MyException e){
               System.out.println(e);
           } 
         }
         
       }
            
        } 
        catch (Exception e) {
            System.out.println("Error!");
            input.reset();
        }
    } while (bError);
     for(;;){
         
         try{
       System.out.println("Enter PHONE No.");
       phn_no = Double.parseDouble(sc.next());
       
      if(phn_no>=1000000000 && phn_no<=9999999999l){
          break;
     }
     else{
         try{
           throw new MyException("Enter the valid phone number");
           }catch(MyException e){
               System.out.println(e);
           }     
         }
     }catch(Exception e){
             System.out.println("error");
             
             }
     }
     
      String us;
       boolean dec=false;
     for(;;){
       int cnt=0;
       dec=false;
       Scanner ss=new Scanner(System.in);
       for(;;){
         System.out.println("Enter user name");
         us = ss.nextLine();
         boolean flag = Character.isDigit(us.charAt(0));
         if(flag==false)
         {
         break;
         }
         else
         {
         try{
           throw new MyException("Enter the valid Username");
           }catch(MyException e){
               System.out.println(e);
           } 
         }
         }
       

       for(int j = 0; j <cu_count; j++){
          dec=c_arr[j].userc_name.equals(us);

           if(dec=true ) {
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
        System.out.println("User name is already taken");
       }
       else{
       userc_name=us;
       break;
       }
       }
     
       id=++Id;
       cu_count=++cu_count;
       System.out.println("Assigned ID : "+id);
       
        for(;;){ 
         try{
       System.out.println("Enter Password (in interger)");
       password = Integer.parseInt(input.next());
       
      if(password>=1000 && password<=9999){
          break;
     }
     else{
         try{
           throw new MyException("Enter the valid password");
           }catch(MyException e){
               System.out.println(e);
           }     
         }
     }catch(Exception e){
             System.out.println("error");
             
             }
     }
       
     }
  
    void Chk_Balance(Customer c)
    {
          System.out.println("+++++ CHECK BALANCE +++++");
        System.out.println("CURRENT BALANCE : "+c.amount);
    }
    
    void Deposit(Customer c)
    {
          System.out.println("+++++ DEPOSIT +++++");
          float dep;
          Scanner sc=new Scanner(System.in);
          System.out.println("Enter the amount you want to deposit : ");
          dep=sc.nextFloat();
          c.amount=c.amount+dep;
    }
    
    void Withdraw(Customer c)
    {
         System.out.println("+++++ WITHDRAW +++++");
         Scanner sc=new Scanner(System.in);
         float wit;
        System.out.println("Enter the amount you want to Withdraw : ");
          wit=sc.nextFloat();
          boolean b = chk(wit,c);
          if(b==true)
          {
            c.amount=c.amount-wit;
        System.out.println("Withdraw amount : "+wit);    
        System.out.println("Remaining Balance : "+c.amount);
            
          }
          else
          {
            System.out.println("INSUFFICIENT AMOUNT");
            System.out.println("The amount you enter is greater than it is in your account");
            
          }
    
    }
    
   
        void Transfer(Customer c,Customer[] arr)
    {
        System.out.println("+++++ TRANSFER +++++");
        Scanner sc=new Scanner(System.in);
       
        float chak;
        int ide,cnt=0;
        int trnv;
        String bname;
        
          System.out.println("1) Transfer for own bank  ");
          System.out.println("2) transfer for another bank");
          System.out.println("3) transfer the amount on cnic ");
          trnv=sc.nextInt();
          if(trnv==1)
          {
              System.out.println("Enter the amount you want to Transfer : ");
          chak=sc.nextFloat();
         boolean b = chk(chak,c);
          if(b==true)
          {
              System.out.println("Enter the Account ID ,of the Account U want to Transfer Balance : ");
              ide=sc.nextInt();
              for(int j = 0; j <cu_count; j++){
           if(arr[j].id==ide )
           {
               arr[j].amount=arr[j].amount+chak;
               c.amount=c.amount-chak;
            cnt=1;
            break;
            }         
               }
            if(cnt==0)
           {
            System.out.println("INVALID ID");
           }
          }
            
          else
          {
            System.out.println("INSUFFICIENT AMOUNT");
            System.out.println("The amount you enter is greater than it is in your account");
            
          }
          
          }
          else if(trnv==2)
          {
                    Scanner mc=new Scanner(System.in);
             
              System.out.println("Enter the Bank Name");
              bname =mc.nextLine();
    
              System.out.println("Enter the Account ID ,of the Account U want to Transfer Balance : ");
              ide=sc.nextInt();
              
              System.out.println("Enter the amount you want to Transfer : ");
          chak=sc.nextFloat();
              boolean b = chk(chak,c);
           if(b==true )
           {
               
               c.amount=c.amount-chak;
            cnt=1;
            System.out.println("~ Transaction successful compelete ~~");
            System.out.println("Bank name: "+bname);
            System.out.println("Account number: "+ide);
            System.out.println("Transfer amount: "+chak);
            System.out.println("remaning amount: "+c.amount);
            
            }         
               
           else
          {
            System.out.println("INSUFFICIENT AMOUNT");
            System.out.println("The amount you enter is greater than it is in your account");
            
          }
           
          }
          
          else if(trnv==3)
          {
              long cni=00000000000000L;
              String usern;
              Scanner ss=new Scanner(System.in);
              System.out.println("enter the user name");
              usern = ss.nextLine();
              
              System.out.println("enter the cnic number ");
              cni=sc.nextLong();
              
              
              System.out.println("Enter the amount you want to Transfer : ");
              chak=sc.nextFloat();
                boolean b = chk(chak,c);
           if(b==true )
           {
               
               c.amount=c.amount-chak;
            cnt=1;
            System.out.println("~ Transaction successful compelete ~~");
            System.out.println("user name: "+usern);
            System.out.println("Cnic number: "+cni);
            System.out.println("Transfer amount: "+chak);
            System.out.println("remaning amount: "+c.amount);
            }         
               
           else
          {
            System.out.println("INSUFFICIENT AMOUNT");
            System.out.println("The amount you enter is greater than it is in your account");
            
          }   
          }   
    }

    public void User_Details()
    {
               System.out.println("******USER DETAILS******");

       System.out.println("NAME : "+customer_Name);
       System.out.println("ID : "+id);
       System.out.println("USER NAME : "+userc_name);
       System.out.println("PASSWORD : "+password);
       System.out.println("GENDER : "+gender);
       System.out.println("AGE : "+Age);
       System.out.println("DOB : "+DOB);
       System.out.println("ADDRESS : "+Cus_Address);
       System.out.println("PHONE NUMBER : "+0+phn_no);
       System.out.println("CURRENT BALANCE : "+amount);
       if(Loan==true)
       {
       System.out.println("LOAN AMOUNT : "+Loan_amount);
       }
       System.out.println("BANK : "+bank_Name);
       System.out.println("BANK ADDRESS : "+bank_Address);
       System.out.println("BRANCH CODE  "+branch_Code); 
       
    }
    
    boolean chk(float c,Customer d)  //used in withdraw
    {
      if(c>d.amount)
      {
      return false;
      }
      else
      {
      return true;
      }
    }
 void Edit_info(Customer c,Customer[] c_arr,Admin[] a_arr)
     {
     Scanner sc=new Scanner(System.in);
    Scanner sa=new Scanner(System.in);
         int chi=0;  
         System.out.println("Which information you want to change : ");
         System.out.println("1 --- Name : ");
         System.out.println("2 --- Gender : ");
         System.out.println("3 --- AGE : ");
         System.out.println("4 --- DOB : ");
         System.out.println("5 --- ADDRESS : ");
         System.out.println("6 --- PHONE NUMBER : ");
         System.out.println("7 --- USER NAME : ");
         System.out.println("8 --- password : ");
         System.out.println("You cannot change your ID : ");
         chi=sc.nextInt();
         if(chi==1)
         {
            System.out.println("Previous NAME : "+c.customer_Name);
            for(;;)
       {
       System.out.println("Enter Newl Name : ");
       c.customer_Name = sa.nextLine();
       boolean res=c.customer_Name.matches("[a-z A-Z]+");
       if(res==true){
       break;
       }
       else{
       try{
               throw new MyException("Enter the correct Name");   
           }catch(MyException e){
//               System.out.println("Invalid gender");
               System.out.println(e);
           } 
       }    
       }
         }
         else if(chi==2)
         {
            System.out.println("Previous GENDER : "+c.gender);
           for(;;){
       System.out.println("Enter New Gender : ");
       c.gender = sa.nextLine();
       if(c.gender.equalsIgnoreCase("male")|| c.gender.equalsIgnoreCase("female") || c.gender.equalsIgnoreCase("others"))
       {
        break;
       }
       else{
           try{
               throw new MyException("Enter the correct gender");   
           }catch(MyException e){
//               System.out.println("Invalid gender");
               System.out.println(e);
           } 
       }
       
       }
         }
          else if(chi==3)
         {
            System.out.println("Previous AGE : "+c.Age);
            Scanner input = new Scanner(System.in);
            boolean bError = true;
       do {
        try {
            System.out.println("Enter New Age: ");
            c.Age = Integer.parseInt(input.next());
            
             if(c.Age>=18 && c.Age <100)
        {
           bError = false;
        }
       
       else{
         if(c.Age<=18)
         {
           try{
           throw new MyException("you are under-age age");
           }catch(MyException e){
               System.out.println(e);
           }  
         }
         else
         {
            try{
           throw new MyException("Enter the valid age");
           }catch(MyException e){
               System.out.println(e);
           } 
         }
         
       }
            
        } 
        catch (Exception e) {
            System.out.println("Error!");
            input.reset();
        }
    } while (bError);
         }
           else if(chi==4)
         {
            System.out.println("Previous DOB : "+c.DOB);
            for(;;){
           int d,y,m;
       System.out.println("Enter DoB(Date of Birth) : ");
//       System.out.println("LIKE--> dd/mm/yyyy");
//       DOB = sc.nextLine();
       System.out.println("Enter the date");
       d=sa.nextInt();
       if(d>0 && d<=31){
       System.out.println("Enter the month");
       m=sa.nextInt();
       if(m>0 && m<=12){
       System.out.println("Enter the year");
       y=sa.nextInt();
       if(y>1922 && m<=2004){
           String d1=String.valueOf(d);
           String m1=String.valueOf(m);
           String y1=String.valueOf(y);
           c.DOB=d1+"/"+m1+"/"+y1;
           System.out.println(c.DOB);
         break;
       }
       else{
       System.out.println("Enter the correct year");
       }
       }
       else{
       System.out.println("Enter the correct month");
       }
       }
       else{
           System.out.println("Enter the correct day");
       }
       
       }
         }
            else if(chi==5)
         {
            System.out.println("Previous ADDRESS : "+c.Cus_Address);
             System.out.println("Enter New ADDRESS : ");
           c.Cus_Address=sa.nextLine();
         }
             else if(chi==6)
         {
            System.out.println("Previous PHONE NUMBER : "+c.phn_no);
            for(;;){
         
         try{
       System.out.println("Enter PHONE No.");
       c.phn_no = Double.parseDouble(sc.next());
       
      if(c.phn_no>=1000000000 && c.phn_no<=1999999999)
      {
          break;
      }
     else{
         try{
           throw new MyException("Enter the valid phone number");
           }catch(MyException e){
               System.out.println(e);
           }     
         }
     }catch(Exception e){
             System.out.println("error");
             
             }
     }
         }
              else if(chi==7)
         {
            System.out.println("Previous USER NAME : "+c.userc_name);
            String us;
                        boolean dec=false;

            for(;;){
                dec=false;
        int cnt=0;
        for(;;){
         System.out.println("Enter user name");
         us = sa.nextLine();
         boolean flag = Character.isDigit(us.charAt(0));
         if(flag==false)
         {
         break;
         }
         else
         {
         try{
           throw new MyException("Enter the valid Username");
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

           if(dec==true ) {

            cnt=1;
            break;
            }
               }
       if(cnt==1)
       {
        System.out.println("User name is already taken");
       }
       else{
       c.userc_name=us;
       break;
       }
       }
            
         }

         else if(chi==8)
         {
             System.out.println("Previous PASSWORD : "+c.password);
        for(;;){ 
         try{
             
             System.out.println("Enter New PASSWORD : ");
             c.password=Integer.parseInt(sc.next());
       
      if(c.password>=1000 && c.password<=9999){
          break;
     }
     else{
         try{
           throw new MyException("Enter the valid password");
           }catch(MyException e){
               System.out.println(e);
           }     
         }
     }catch(Exception e){
             System.out.println("error");
             
             }
     }
            
         }
         else{
                System.out.println(" INVALID ENTRY ");    
         }  
     
     }
    
    Customer[] remove_cus(Customer[] arr, int index)
    {

        Customer[] Array = new Customer[arr.length - 1];
        for (int i = 0, k = 0; i < arr.length; i++) {
            if (i == index) {
                continue;
            }
            Array[k++] = arr[i];
        }
        return Array;
    }    
    
    
    
    
}
