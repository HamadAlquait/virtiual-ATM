/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ASG2;


import java.io.*;
import java.util.*;

/**
 *
 * @author omsf7f
 */
public class ATM 
{
    Accounts[] mo = new Accounts[3];
    String ans;
//    Accounts mo = new Accounts();
//    Scanner sc = new Scanner(System.in);
    //MenuOptions mo = new MenuOptions();
//    ATM a = new ATM();
   //double[] account = {0,1,2};
//    private MenuOptions[] acctArray = new MenuOptions[3];   //HIS CODE
    
//    int number;
//    private Accounts[] mo = new Accounts[3]; 
    
    
//             //HELP HELP HELP
    
//    String beginningBalance;
//
//    //Saving account object
//    //Balance is inherited from Account, and balance is set to a unique value that belongs to this Saving object
//    int index = 0;
//    beginningBalance = JOptionPane.showInputDialog("Enter beginning balance for new saving account.");
//    mo[index] = new Saving(Double.parseDouble(balance));
//
// 
//    //Checking account object
//    //Balance is inherited from Account, and balance is set to a unique value that belongs to this Checking object
//    int index = 1;
// 
//    beginningBalance = JOptionPane.showInputDialog("Enter beginning balance for new checking account.");
//    mo[index] = new Checking(Double.parseDouble(balance));
   

      
    
    public static void main(String[] args) throws IOException 
    {
        
        ATM a = new ATM();
//        Accounts mo = new Accounts();
        
        
          a.firstMenu();
        
        
//        }
//        
//        
//        mo.menu();
        
    }
    
//    public void runATM()
//    {
//        
//    }
        
    public void firstMenu()throws IOException
    {
        Scanner sc = new Scanner (System.in);
//        ATM a = new ATM();
        String answer = "Y";
    
            System.out.println("*********************************");
            System.out.println("*     WELCOME TO HALAL BANK     *");
            System.out.println("*                               *");
            System.out.println("*     Come in and check out     *");
            System.out.println("*          our low 5%           *");
            System.out.println("*      interest rate loans      *");
            System.out.println("*                               *");
            System.out.println("*********************************");
            System.out.println();
            System.out.print("Are you a new customer (Y or N)? ");
            answer = sc.next();
            ans = answer;
            
        switch (answer) 
        {
            case "y":
            case "Y":
               createAcct();          
                break;
            case "n":
            case "N":
                pickAccount();
                break;
        }      
    }
    
    public void CreateMenu()throws IOException
    {
        Scanner sc = new Scanner (System.in);
//        ATM a = new ATM();
        String answer = "Y";
    
            System.out.println();
            System.out.print("Are you a new customer (Y or N)? ");
            answer = sc.next();
            ans = answer;
            
        switch (answer) 
        {
            case "y":
            case "Y":
               createAcct();          
                break;
            case "n":
            case "N":
                pickAccount();
                break;
        }      
    }
    
    public void createAcct() throws IOException
    {   
        Scanner sc = new Scanner(System.in);
        String input;
    //       Accounts mo = new Accounts();
//       Accounts[] mo = new Accounts[3];
        //ATM a = new ATM();
        
//        double reward;
        
        for (int i = 0; i<mo.length; i++)
		{
//                    if (ans == "y" || ans == "Y")
//                    {
                    mo[i]= new Accounts();
                    System.out.println("What is the name on the account" );
                    input = sc.next();
                    System.out.println(input );
//                    mo[i].saveAccount();
                    
//                    }
                    mo[i].menu();
		}
            }
    public void pickAccount() throws IOException
    {
        ATM atm = new ATM();
        Accounts mo = new Accounts();
        System.out.println("Choose which acount you would like to access by pressing 0, 1, or 2.\n\npress 4 to exit.");
        Scanner sc = new Scanner(System.in);
        int input = sc.nextInt();
        
        if (input >= 0 || input <= 2)
            mo.menu();
        else
            {
            System.out.println("Enter a valid account: ");
            input = sc.nextInt();
            }
    }
        
//        do {
//            for (int i = 0; i<mo.length; i++)
//		{
//                    if(input < 3)
//                    {
////                        System.out.println("Account One");
//                        //input--;//make the input one less to match the array values
//                     mo[i].menu();
//                    }
//                    else
//                    {
//                        System.out.println("Enter a valid account: ");
//                        input = sc.nextInt();
//                        if(input < 3)
////                        {
////                         mo[i].menu();
////                        }
//                }
//                    }
//                else if (input == 1)
//                {
//                    System.out.println("Account Two");
//                    //input--;//make the input one less to match the array values
//                    mo[1].menu();
//                }
//                else if (input == 2)
//                {
//                    System.out.println("Account Three");
//                    //input--;//make the input one less to match the array values
//                    mo[2].menu();
//                }
                
//                System.out.println("Choose which acount you would like to access by pressing 1, 2, or 3.\n\npress 4 to exit.");
//                input = sc.nextInt();
//               
//        } while (input != 4);    
//                
//        }
////    }
//    
       
    public void saveAccount()
    {
        try
        {
            FileOutputStream outStream =  new FileOutputStream ("file1.out");
            ObjectOutputStream  oos = new ObjectOutputStream(outStream); 
            oos.writeObject(mo);
            oos.flush();
            outStream.close();
        }
        
        catch (Throwable e)
        {
            System.err.println(e);
        }                                    
    }
    
    public void loadAccts()
    {
        try
        {
            FileInputStream inStream = new FileInputStream("file1.out");
            ObjectInputStream is = new ObjectInputStream(inStream);
            mo = (Accounts[]) is.readObject();
            inStream.close();
        }
        
        catch (Throwable e)
        {
            System.err.println(e);
        }
    }
        
        
    
}
 