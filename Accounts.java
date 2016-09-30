/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ASG2;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.text.NumberFormat;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.Scanner;

/**
 *
 * @author omsf7f
 */


public class Accounts implements Serializable
{   
    Scanner sc = new Scanner(System.in);
    
    double transaction_balance = 0.00;
//    double withdraw = 0.00;
//    double deposit = 0.00;
      double newAccoutBalance = 100.00;
      
    protected double balance;
    protected int firstdate;
    protected int seconddate;
    protected Calendar cal1 = new GregorianCalendar();
    protected Calendar cal2 = new GregorianCalendar();
    protected boolean dateflag = false;
    protected double rate;
    private String acctname;
    private Object formater;
  
    
    
    
    
    public Accounts()  //constructor
    {
        balance = newAccoutBalance;
    }    

    public void setAcctName(String input)
    {
    
    }
    
   
    
    public void menu() throws IOException
    {
        Accounts mo = new Accounts();
        
        int input;
        
        
        do
        {
            System.out.println("1) Deposit");
            System.out.println("2) Withdraw");
            System.out.println("3) Check Balance");
            System.out.println("4) Create New Account");
            System.out.println("5) Exit");
            
            input = sc.nextInt();
            
            if(input == 1)
            {
                System.out.println("Your current balance is " + getBalance());
                
                    if(dateflag == true)
                    {
                        getDate2();
                        deposit();  
                    }
                    else
                    {
                    getDate1();
                    deposit();
                    System.out.println("Your current balance is " + getBalance());
                    }
            }
            else
            if(input == 2)
            {
                System.out.println("Your current balance is " + getBalance());
                    if (dateflag == true)
                    {
                    getDate2();
                    withdraw();  
                    }
                    else
                    {
                    getDate1();
                    withdraw();
                    System.out.println("Your current balance is " + getBalance());
                    }
            }
            else
            if(input == 3)
            {
                System.out.println("Your current balance is " + getBalance());
                
            }
           
            else
            if(input == 4)
            {
                ATM a = new ATM();
                
                a.CreateMenu();
            }
            else
                            if(input == 5)

                   System.exit(0);
        }while(input < 6);
        
        System.out.println("please input a correct number from 1 the menue options: ");
    }

    
    
    public void deposit()throws IOException
        {
    //ask for deposit//add intrest rate to deposit//get the date for the deposit//menu
            BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
            ATM a = new ATM();
        
            String deposit;
            double dep;
        
            
            System.out.println ("Enter desired deposit ammount: ");
            deposit = br.readLine();
            
            NumberFormat depositFormatted = NumberFormat.getCurrencyInstance();

                  
            dep = Double.valueOf(deposit).doubleValue();
            
//                    parseDouble(deposit);
            
            transaction_balance += dep;
        
            balance = balance + dep;
        
            System.out.println ("Your current balance is " + depositFormatted.format(balance));
        
//            getDate2();
        
            menu();
        }
    
    public void withdraw()throws IOException
        {
    //ask for deposit//add intrest rate to deposit//get the date for the deposit//menu
            BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
            ATM a = new ATM();
                    
            String withdraw;
            double with;
        
            System.out.println ("Enter desired withdraw ammount: ");
            withdraw = br.readLine();
            
            NumberFormat depositFormatted = NumberFormat.getCurrencyInstance();

                  
            with = Double.valueOf(withdraw).doubleValue();
            
            
            transaction_balance -= with;
        
            balance = balance - with;
            
            System.out.println("Your current balance is " + depositFormatted.format(balance));        
        
//            getDate2();
        
            menu();
        }

    public double getBalance() 
        {
            return balance;
        }
  //format currency get off google to format
 //numbers to dollars
    

    
    
    
    public void saveAccount()
    {
                Accounts mo = new Accounts();

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
    
    
    
    private void getDate1() throws IOException
    {
       
//        Date date = new Date();
//        SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
//        System.out.println("Current Date: "
//                + dateFormat.format(date.getTime()));
//        System.out.println("Day of given date : " + date.getDate());
//        
//        cal1.setTime(date);
//        
//        firstdate = cal1.get(cal1.DAY_OF_YEAR);
//    }

        System.out.print("Enter todays date mm/dd/yyy");
    
        BufferedReader br;
        br = new BufferedReader (new InputStreamReader(System.in));
        
        String inputText = br.readLine();
        
        SimpleDateFormat formatter = new SimpleDateFormat ("MM/dd/yyyy");
        ParsePosition pos = new ParsePosition(0);
        
        Date date = new Date();

    
        
//        inputText = sc.next();
//        inputText = br.readLine();

        date = formatter.parse(inputText, pos);
    
        cal1.setTime(date);
         firstdate = cal1.get(cal1.DAY_OF_YEAR);
//        firstdate = cal1.get(Calendar.DAY_OF_YEAR);
    
        dateflag = true;
    }
    

    
    private void getDate2() throws IOException
    {
//            Date date1 = new Date();
//        SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
//        System.out.println("Current Date: "
//                + dateFormat.format(date1.getTime()));
        
        System.out.print("Enter todays date mm/dd/yyy");
    
        BufferedReader br;
        br = new BufferedReader (new InputStreamReader(System.in));
        
        String inputText = br.readLine();
        
        SimpleDateFormat formatter = new SimpleDateFormat ("MM/dd/yyyy");
        ParsePosition pos = new ParsePosition(0);
        
        Date date = new Date();

    
        
//        inputText = sc.next();
//        inputText = br.readLine();

        date = formatter.parse(inputText, pos);
    
        cal2.setTime(date);
         seconddate = cal2.get(cal2.DAY_OF_YEAR);
//        firstdate = cal1.get(Calendar.DAY_OF_YEAR);
    
//        dateflag = true;
        
        
//        System.out.println("Day of given date : " + date1.getDate());
//        BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
////        Scanner sc = new Scanner(System.in);
//        
//        System.out.println("Enter todays date mm/dd/yyyy: ");
////        inputText = sc.next();
////        inputText = br.readLine();
//        
//        String inputText = br.readLine();
//        
//        SimpleDateFormat formatter = new SimpleFDateFormat ("MM/dd/yyyy");
//        ParsePosition pos = new ParsePosition(0);
//        
//        
//        Date date = new Date();
//        date = formatter.parse(inputText, pos);
//        
//        cal2.setTime(date1);

    
        

//        date = formatter.parse(inputText, pos);
    
//        cal2.setTime(date);
//        seconddate = cal2.get(cal2.DAY_OF_YEAR);
    
        if (firstdate > seconddate)
        {
            System.out.println("Enter future date mm/dd/yyyy: ");
            getDate2();
//            inputText = sc.next();
//            inputText = br.readLine();
//
//            date = formatter.parse(inputText, pos);
//    
//            cal2.setTime(date);
//            seconddate = cal2.get(Calendar.DAY_OF_YEAR);
        }
                
//        dateflag = true;
    }    

//    private static class SimpleFDateFormat extends SimpleDateFormat 
//    {
//
//        public SimpleFDateFormat(String mMddyyyy) 
//        {
//        }
//    }
}
