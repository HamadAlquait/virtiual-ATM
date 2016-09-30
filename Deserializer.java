package edu.umsl.mis3806;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;

import org.ietf.jgss.Oid;
//Deserializer class which we use it to read stored objects from file
public class Deserializer{

   public static void main (String args[]) throws IOException {
    int count;
	   Deserializer deserializer = new Deserializer();
	   count=deserializer.getCount();
	   System.out.println(count);
	   AccountDetails[] accountdetails = deserializer.deserialzeAccount();
		   System.out.println(accountdetails[0].getAccountHoldername());
		  System.out.println(accountdetails[2].getBalance());
		   
	   
   }
   //get total number of accounts in file
   public int getCount() {
	   AccountDetails[] accountdetails = new AccountDetails[4];
		 int i=0;

		   FileInputStream fin = null;
		try {
			fin = new FileInputStream("test.ser");
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			return i;
		}
		   ObjectInputStream ois=null;
		try {
			ois = new ObjectInputStream(fin);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		   try{
			   //FileInputStream fin = new FileInputStream("test.ser");
			  // ObjectInputStream ois = new ObjectInputStream(fin);
			   while(true){
				   accountdetails[i] = (AccountDetails) ois.readObject(); 
			  i++;
			   }
			   
		   }catch(Exception ex){
			  // ex.printStackTrace();
			   try {
				ois.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			   System.out.println(i);
			   return i;
		   } 
	   } 
   
//get all accounts objects
   public AccountDetails[] deserialzeAccount() throws IOException {
	   
	   AccountDetails[] accountdetails = new AccountDetails[4];
	 int i=0;

	   FileInputStream fin = new FileInputStream("test.ser");

	   ObjectInputStream ois = new ObjectInputStream(fin);
	   try{
		   //FileInputStream fin = new FileInputStream("test.ser");
		  // ObjectInputStream ois = new ObjectInputStream(fin);
		   while(true){
			   accountdetails[i] = (AccountDetails) ois.readObject(); 
		  i++;
		   }
		   
	   }catch(Exception ex){
		  // ex.printStackTrace();
		   ois.close();
		   //System.out.println(i);
		   return accountdetails;
	   } 
   } 
}