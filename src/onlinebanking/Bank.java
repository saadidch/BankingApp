/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package onlinebanking;


public class Bank extends MyException{
    static final String bank_Name ="Java ISLAMIC Bank";
    String bank_Address;
    int branch_Code;
    static int Id;
    static int ad_count;
    static int cu_count;
    static int F_id;
    Bank()
    {
      bank_Address = "Main Street, Defence Road , Lahore ";
      branch_Code = 32445;
    }

    void editBank(String s,int c)
    {
      bank_Address = s;
      branch_Code = c;
    }
    int getfid()
    {
    return F_id;
    }
    int getaid()
    {
    return ad_count;
    }
    
    int getcid()
    {
    return cu_count;
    }
    
    
    void Bank_Details()
    {
      System.out.println("***** BANK DETAILS ***** ");
    System.out.println("BANK : "+bank_Name);
    System.out.println("BANK ADDRESS : "+bank_Address);
    System.out.println("BRANCH CODE : "+branch_Code);
    
    
    }
    void Services()
    {
      System.out.println(" ***** SERVICES *****  ");
      System.out.println("Provides Creating account   ");
      System.out.println("Provide Id and Password (safe)   ");
      System.out.println("Deposit / Withdraw   ");  
      System.out.println("Trasnfer to Different Account ");
      System.out.println("Details and Edit info ");
      System.out.println("Feedback Options ");
      
    }
}
