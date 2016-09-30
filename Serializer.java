package edu.umsl.mis3806;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;

public class Serializer {


//this method is to write the array objects to serializable file
	public void serializeAccount(int accountNo, String name,String type,double balance,int firstdate){

		//calling accountdetails class to create object containg details
		AccountDetails accountdetails=new AccountDetails();

		accountdetails.setAccountHoldername(name);
		accountdetails.setAccountNo(accountNo);
		accountdetails.setType(type);
		accountdetails.setBalance(balance);
		accountdetails.setFirstDate(firstdate);




		try{

			//FileOutputStream fout = new FileOutputStream("accountdetails.ser");
			//ObjectOutputStream oos = new ObjectOutputStream(fout);   
			File storageFile = new File("test.ser");
			//calling method to get the objectoutputstream
			ObjectOutputStream oos = getOOS(storageFile);
			oos.writeObject(accountdetails);
			oos.close();
			System.out.println("Done");

		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	//returns the objectoutputstream for the serializable file 
	private static ObjectOutputStream getOOS(File storageFile)
			throws IOException {
		//check whether the file exits or not->to make sure whether to append existing fiile or write new one
		if (storageFile.exists()) {
			// this is a workaround so that we can append objects to an existing file
			return new AppendableObjectOutputStream(new FileOutputStream(storageFile, true));
		} else {
			return new ObjectOutputStream(new FileOutputStream(storageFile));
		}
	}
	

	private static class AppendableObjectOutputStream extends
	ObjectOutputStream {

		public AppendableObjectOutputStream(OutputStream out)
				throws IOException {
			super(out);
		}

		@Override
		protected void writeStreamHeader() throws IOException {
			// do not write a header
		}
	}

	

}