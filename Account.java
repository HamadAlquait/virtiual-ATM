package edu.umsl.mis3806;
/**
 *
 * @author lawtonb
 */
import java.io.*;
import java.util.*;
import java.text.*;
//import java.math.*;

//Programmer: Brian J. Lawton
//This program calculates the interest for an individual account for the current
//year. It allows for depsits and withdrawals to be made during that year.
public class Account
{
	private  double balance;
	private  int firstdate;
	private int seconddate;
	private Calendar date1 = new GregorianCalendar();
	private Calendar date2 = new GregorianCalendar();
	private boolean dateflag = false;
	private double rate;
	 String type;
	 int AccountNo;
	 String name;
	// Initial Constructor
	// Once called the Account1 constructor presents a menu for users to make
	// a deposit, withdrawal, check balance or exit.
	// The menu is a loop that based on the selection will call either the
	// deposit method, withdrawal method or exit the program.
	public Account (int AccountNos,String names,double begin_balance,int firstdates,String types) 
	{
		AccountNo=AccountNos;
		balance = begin_balance;
		//System.out.println("type"+balance);
		firstdate=firstdates;
		type=types;
		//System.out.println("type"+types);
		dateflag = true;
		name=names;

	} // End Initial Constructor
	public void menu() throws IOException
	{
		char mychar = 'z';
		while (mychar != 'e')
		{
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println("Please enter a choice:");
			System.out.println("Enter (d) for Deposit");
			System.out.println("Enter (w) for withdraw");
			System.out.println("Enter (c) to CheckBalance");
			System.out.println("Enter (e) to go back to main menu");
			BufferedReader br;
			String input;
			int index = 0;
			br = new BufferedReader(new InputStreamReader(System.in));
			input = br.readLine();
			mychar = input.charAt (index);
			if (mychar == 'd' || mychar == 'D') {
				System.out.println("Your current balance is:" + getBalance());
				if (dateflag == true){
					getDate2();
					getInterest();
					deposit();
				}
				else{
					getDate1();
					deposit();
				}
			}
			else if (mychar == 'w') {
				System.out.println("Your current balance is: " + getBalance());
				if (dateflag == true){
					getDate2();
					getInterest();
					withdraw();
				}
				else{
					getDate1();
					withdraw();
				}
			}

			else if (mychar == 'c')
				System.out.println("Your current balance is: " + getBalance());
			else if(mychar=='e')
				BankAccount.main(null);
				
		}
	}

	//Main method instantiates the initial account balance of 100 hundred dollars
	//Then creates the account and lets the Account class take over from there.
	public static void main(String[] args) throws IOException
	{
		double init_amount = 100.00;
		//Account firstacct = new Account(init_amount);
		//firstacct.menu();
	}

	// This method retrieves the balance field and returns it in currency format
	public String getBalance(){
		NumberFormat currencyFormatter;
		String currencyOut;
		currencyFormatter = NumberFormat.getCurrencyInstance(Locale.US);
		currencyOut = currencyFormatter.format(balance);
		return currencyOut;
	}
	
	public double getBalanceDouble(){
		return balance;
	}
	// This method prompts the user for the deposit and then adds it to the
	// balance field.
	public void deposit() throws IOException {
		BufferedReader br;
		String entered_amount;
		System.out.print("How much would you like to deposit? :");
		br = new BufferedReader(new InputStreamReader(System.in));
		entered_amount = br.readLine();
		double amount = Double.valueOf(entered_amount).doubleValue();
		balance = balance + amount;
		System.out.println("Your balance is: " + getBalance());
		update();
	}
	// This method prompts the user for the withdraw amount and then subtracts
	// it from the balance field.
	public void withdraw() throws IOException {
		BufferedReader br;
		String entered_amount;
		System.out.print("How much would you like to withdraw? :");
		br = new BufferedReader(new InputStreamReader(System.in));
		entered_amount = br.readLine();
		double amount = Double.valueOf(entered_amount).doubleValue();
		if (balance < amount)
			System.out.println("Insufficient funds.");
		else
			balance = balance - amount;

		System.out.println("Your balance is: " + getBalance());
		update();
	}

	// This function is only called on the first transaction after the
	// account has been initialized to set the first time a transaction
	// occurs for the account for the current year.
	public int getDate1() throws IOException {
		System.out.print("Enter todays date(mm/dd/yyyy): ");
		BufferedReader br;
		br = new BufferedReader(new InputStreamReader(System.in));
		String inputText = br.readLine();
		SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
		ParsePosition pos = new ParsePosition(0);
		Date date= new Date();
		date = formatter.parse(inputText, pos);
		date1.setTime(date);
		firstdate = date1.get(date1.DAY_OF_YEAR);
		dateflag = true;
		return firstdate;
	}
	// This method is called for every date entered after the first date.
	// The previous second date is passed to the first date to keep track of
	// time.
	public int getDate2() throws IOException {
		System.out.print("Enter todays date in this format (mm/dd/yyyy): ");
		BufferedReader br;
		br = new BufferedReader(new InputStreamReader(System.in));
		String inputText = br.readLine();
		SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
		ParsePosition pos = new ParsePosition(0);
		Date date= new Date();
		date = formatter.parse(inputText, pos);
		date2.setTime(date);
		seconddate = date2.get(date2.DAY_OF_YEAR);
		if (firstdate > seconddate) {
			System.out.println("You must enter a valid date.");
			getDate2();
		}
		return seconddate;
	}
	// This method calulates the interest based on the previous date and the
	// current date
	public void getInterest() {
		if(type.equals("Savings")){
			int datediff = seconddate - firstdate;
			rate = .05/365;
			double ratetime = Math.pow(1+rate,datediff);
			balance = balance * ratetime;
			firstdate = seconddate;
		}
		
	}
    public void update() {
    	AccountDetails[] accountDetails = null;
    	Deserializer deserializer=new Deserializer();
    	int count=deserializer.getCount();
    	try {
			accountDetails=deserializer.deserialzeAccount();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	removeObject(count,accountDetails);
	}
	private  void removeObject(int count, AccountDetails[] accountDetails) {
		// TODO Auto-generated method stub
		File file = new File("test.ser");
		if(file.delete()){
			System.out.println(file.getName() + " is deleted!");
		}else{
			System.out.println("Delete operation is failed.");
		}
		
		AccountDetails[] accdetails=new AccountDetails[count];
		int status=0;
		for(int i=0;i<count;i++){
			if(AccountNo==accountDetails[i].getAccountNo()){
				status=1;
				accdetails[i]=new AccountDetails();

				Serializer serializer = new Serializer();
				serializer.serializeAccount(AccountNo,name,type,balance,firstdate);

			}
			else{
				accdetails[i]=accountDetails[i];
				Serializer serializer = new Serializer();
				serializer.serializeAccount(accdetails[i].getAccountNo(),accdetails[i].getAccountHoldername(),accdetails[i].getType(),accdetails[i].getBalance(),accdetails[i].getFirstDate());
			}
			
		}
		
		
		
	}
}
