package edu.umsl.mis3806;

import java.io.Serializable;
//abstract class to store the details of account holder 
public class AccountDetails implements Serializable{

	   int accountNo;
	   String type;
	   String accountholdername;
	   double balance;
	   int firstdate;
	   int seconddate;
	   
	   public void setType(String type){
		   this.type = type;
	   }
	   public void setAccountNo(int accountNo){
		   this.accountNo = accountNo;
	   }
	   public void setBalance(double balance){
		   this.balance = balance;
	   }
	   public void setAccountHoldername(String accountholdername){
		   this.accountholdername = accountholdername;
	   }
	   public void setFirstDate(int firstdate){
		   this.firstdate = firstdate;
	   }
	   public void setSecondDate(int seconddate){
		   this.seconddate = seconddate;
	   }
	   
	   public String getType(){
		   return this.type;
	   }
	   public int getAccountNo(){
		   return this.accountNo;
	   }
	   public double getBalance(){
		   return this.balance;
	   }
	   public String getAccountHoldername(){
		   return this.accountholdername;
	   }
	   public int getFirstDate(){
		   return this.firstdate;
	   }
	  
	   
	   @Override
	   public String toString() {
    	   return new StringBuffer(" Type : ")
    	   .append(this.type)
    	   .append(" Name : ")
    	   .append(this.accountholdername)
    	   .append(" Account :")
    	   .append(this.accountNo)
    	   .append(" Balance :")
    	   .append(this.balance)
    	   .append(" FirstDate :")
    	   .append(this.firstdate).toString();
	   }
	   
}