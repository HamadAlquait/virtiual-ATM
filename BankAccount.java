package edu.umsl.mis3806;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Array;
import java.util.Scanner;


public class BankAccount extends Account{

	



	public BankAccount(int AccountNo, String name, double begin_balance, int firstdate, String type) {
		super(AccountNo, name, begin_balance, firstdate, type);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 * @throws IOException 
	 */


	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		char mychar;
		BufferedReader br;
		String input;
		int index = 0;
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println("*********************************");
		System.out.println("*    WELCOME TO RIPUOFF BANK    *");
		System.out.println("*                               *");
		System.out.println("*     Come in and check out     *");
		System.out.println("*          our low 30%          *");
		System.out.println("*      interest rate loans      *");
		System.out.println("*                               *");
		System.out.println("*********************************");
		System.out.println();
		System.out.println("Please enter a choice:");
		System.out.println("1.Open existing account(o)\t 2.Create Account (c)\nChoose:");
		br = new BufferedReader(new InputStreamReader(System.in));
		input = br.readLine();
		mychar = input.charAt (index);
		switch(mychar){
		case 'o':
			System.out.println("Open existing account:\n");
			openExistAccount();
			break;
		case 'O':
			System.out.println("Open existing account:\n");
			openExistAccount();
			break;
		case 'c':
			System.out.println("Create Account:\n");
			createAccount();
			break;
		case 'C':
			System.out.println("Create Account:\n");
			createAccount();
			break;
		}


	}

	private static void createAccount() throws IOException {
		// TODO Auto-generated method stub
		Deserializer deserializer=new Deserializer();
		int count=deserializer.getCount();
		if(count>=3){
			System.out.println("Exceeded the maxium accounts");
			System.out.println("Exiting from the application");
			System.exit(0);
		}
		else{
			int accountNo=1000;
			System.out.println("Please enter a choice:");
			System.out.println("Checkings(c)");
			System.out.println("Savings(s)");

			char mychar;
			BufferedReader br;
			String input; 
			int index = 0;
			br = new BufferedReader(new InputStreamReader(System.in));
			input = br.readLine();
			mychar = input.charAt (index);
			Account account=new Account(0,null,100,0,null);
			
			System.out.println("Enter Name: ");
			Scanner sc = new Scanner(System.in);
			String name = sc.nextLine();
			String type="Checkings";
			switch(count){
			case 0:
				accountNo=1001;

				break;
			case 1:
				accountNo=1002;
				break;
			case 2:
				accountNo=1003;
				break;
			default:
				System.out.println("Exceeded the maxium accounts");
				System.out.println("Exiting from the application");
				System.exit(0);

			}


			int fdate=account.getDate1();

			double balance=account.getBalanceDouble();

			if (mychar == 'c' || mychar == 'C')    
			{
				System.out.println("\n Checkings account:\n");
				type="Checkings";

				Serializer serializer = new Serializer();
				serializer.serializeAccount(accountNo,name,type,balance,fdate);
				BankAccount.main(null);
			}
			if (mychar == 's' || mychar == 'S')    
			{

				System.out.println("\n savings account:\n");
				type="Savings";

				Serializer serializer = new Serializer();
				serializer.serializeAccount(accountNo,name,type,balance,fdate);
				BankAccount.main(null);
			}
		}
	}

	private static void openExistAccount() {
		// TODO Auto-generated method stub
		
		AccountDetails[] accountDetails = null;
		AccountDetails accountDetailsSingleObject;
		Deserializer deserializer=new Deserializer();
		int count=deserializer.getCount();
		System.out.println("\n Enter the AccountNO:");
		Scanner sc = new Scanner(System.in);
		int AccountNo=sc.nextInt();
		
		try {
			accountDetails=deserializer.deserialzeAccount();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		accountDetailsSingleObject=getAccountdetailsfor(count,AccountNo,accountDetails);
		System.out.println("\nWELCOME "+accountDetailsSingleObject.getAccountHoldername()+"\n");
		Account acc=new Account(AccountNo,accountDetailsSingleObject.getAccountHoldername(),accountDetailsSingleObject.getBalance(),accountDetailsSingleObject.getFirstDate(),accountDetailsSingleObject.getType());
		try {
			System.out.println("account balance"+acc.type);
			
			acc.menu();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	private static AccountDetails getAccountdetailsfor(int count, int accountNo, AccountDetails[] accountDetails) {
		// TODO Auto-generated method stub
		int status=0;
		for(int i=0;i<count;i++){
			if(accountNo==accountDetails[i].getAccountNo()){
				status=1;
				return accountDetails[i];
			}
			
		}
		if (status==1) {
			
		}else{
			System.out.println("No details for account number exits");
			System.exit(0);
		}
		return null;
		
	}

	public static void saving() {
		// TODO Auto-generated method stub

	}

	public static void checkings() {
		// TODO Auto-generated method stub

	}

}