// BankDatabase.java
// Represents the bank account information database 
import java.io.*;
import java.util.*;

public class BankDatabase
{  
   private Account accounts[]; // array of Accounts
   private Vector <String> readData;

   // no-argument BankDatabase constructor initializes accounts
   public BankDatabase()
   {  //declare and initialize counter
      int counter = 0;
      readData = ReadData();
      //Get account data from File
      accounts = new Account[readData.size()];

      //crete saving account and Cheque account object by reading data.txt
      for(String data: readData){
         //store the information of each account
         //buffer format: [account type, account number, pin, Available Balance, total Balance]
         String buffer [] = data.split("/");

         //crete Saving account object when first buffer element is "1"
         if(buffer[0].equals("1")){
            accounts[counter] = new SavingAccount(Integer.parseInt(buffer[1]) , Integer.parseInt(buffer[2]) ,Double.parseDouble(buffer[3]),Double.parseDouble(buffer[4]), this);
         //crete Cheque account object
         }else{
            accounts[counter] = new ChequeAccount(Integer.parseInt(buffer[1]) , Integer.parseInt(buffer[2]) ,Double.parseDouble(buffer[3]),Double.parseDouble(buffer[4]), this);
         }
         counter++;
      }
   } // end no-argument BankDatabase constructor

   //Function - Read Data
   public Vector<String> ReadData(){
      //declare variable
      Vector<String> data = new Vector<String>();
      //Read Data
      try{
         //declare variable of file pathname
         File f = new File("data.txt");
         //Create Output Stream
         Scanner Reader = new Scanner(f);
         //Append data to array line by line
         while (Reader.hasNextLine()) {
            //Get line for file
            String buffer = Reader.nextLine();
            //Append buffer to array
            data.add(buffer);
         }
         //Ending Output Stream
         Reader.close();
      //Exception for file not exists
      } catch (FileNotFoundException e) {}
      return data;
   }

   //Function - Store data
   public void StoreData(int type,int userAccountNumber,int PIN,double availableBalance,double totalBalance,String path){
      //declare variable of file pathname
      File f = new File(path);
      //Write data to file
      try{
         //Create File Input Stream;
         FileWriter Wf = new FileWriter(f,true);
         //If content exists, create newline
         if(!(f.length()==0)){
            Wf.write("\n");
         }
         //Write data to file by parameter declared
         Wf.write(type + "/" + userAccountNumber + "/" + PIN + "/" + Double.toString(availableBalance) + "/" + Double.toString(totalBalance));
         //Ending Input Stream
         Wf.close();
      //Exception for IO
      } catch (IOException e) {
          e.printStackTrace();
      }
   }

   //Function - Update data
   public void UpdateData(int type,int userAccountNumber,int PIN,double availableBalance,double totalBalance){
      //Check is data file exists
      if(ReadData().isEmpty()){
         return;
      }
      //declare variable of file pathname
      File t = new File("temp.txt");
      File f = new File("data.txt");
      String[] buffer = new String[5];
      //Write data to file by parameter declared
      for(String str:ReadData()){
         buffer = str.split("/");
         //Check if AccoutNumber match record
         if(buffer[1].equals(String.valueOf(userAccountNumber))){
            StoreData(type,userAccountNumber, PIN ,availableBalance, totalBalance, "temp.txt");
         }else{
            StoreData(Integer.parseInt(buffer[0]),Integer.parseInt(buffer[1]), Integer.parseInt(buffer[2]), Double.parseDouble(buffer[3]), Double.parseDouble(buffer[4]), "temp.txt");
         }
      }
      //Delete old data
      f.delete();
      //Rename to "data.txt"
      t.renameTo(f);
   }

   // retrieve Account object containing specified account number
   private Account getAccount( int accountNumber )
   {
      // loop through accounts searching for matching account number
      for ( Account currentAccount : accounts )
      {
         // return current account if match found
         if ( currentAccount.getAccountNumber() == accountNumber )
            return currentAccount;
      } // end for

      return null; // if no matching account was found, return null
   } // end method getAccount

   // determine whether user-specified account number and PIN match
   // those of an account in the database
   public boolean authenticateUser( int userAccountNumber, int userPIN )
   {
      // attempt to retrieve the account with the account number
      Account userAccount = getAccount( userAccountNumber );

      // if account exists, return result of Account method validatePIN
      if ( userAccount != null )
         return userAccount.validatePIN( userPIN );
      else
         return false; // account number not found, so return false
   } // end method authenticateUser

   // return available balance of Account with specified account number
   public double getAvailableBalance( int userAccountNumber )
   {
      return getAccount( userAccountNumber ).getAvailableBalance();
   } // end method getAvailableBalance

   // return total balance of Account with specified account number
   public double getTotalBalance( int userAccountNumber )
   {
      return getAccount( userAccountNumber ).getTotalBalance();
   } // end method getTotalBalance

   // credit an amount to Account with specified account number
   public void credit( int userAccountNumber, double amount )
   {
      getAccount( userAccountNumber ).credit( amount );
   } // end method credit

   // debit an amount from of Account with specified account number
   public void debit( int userAccountNumber, double amount )
   {
      getAccount( userAccountNumber ).debit( amount );
   } // end method debit
   
   //check whether Account is exist or not
   public boolean checkAccountExist(int inAccNum){
      return getAccount(inAccNum) != null;
   }
} // end class BankDatabase



/**************************************************************************
 * (C) Copyright 1992-2007 by Deitel & Associates, Inc. and               *
 * Pearson Education, Inc. All Rights Reserved.                           *
 *                                                                        *
 * DISCLAIMER: The authors and publisher of this book have used their     *
 * best efforts in preparing the book. These efforts include the          *
 * development, research, and testing of the theories and programs        *
 * to determine their effectiveness. The authors and publisher make       *
 * no warranty of any kind, expressed or implied, with regard to these    *
 * programs or to the documentation contained in these books. The authors *
 * and publisher shall not be liable in any event for incidental or       *
 * consequential damages in connection with, or arising out of, the       *
 * furnishing, performance, or use of these programs.                     *
 *************************************************************************/