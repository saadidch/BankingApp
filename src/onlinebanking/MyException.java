/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package onlinebanking;

/**
 *
 * @author HP
 */
public class MyException extends Exception{
    String str1;
    
       public MyException()
       {
       str1=null;
       }
       public MyException(String str2) {
       str1=str2;
   }
       
          public String toString(){ 
	return ("Requested to: "+str1) ;
   }
    
}
