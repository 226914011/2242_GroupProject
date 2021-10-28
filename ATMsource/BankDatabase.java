// BankDatabase.java
// Represents the bank account information database 
import java.io.*;
import java.util.*;

public class BankDatabase
{
   //Function - Store data
   public void StoreData(int userAccountNumber,int PIN,double availableBalance,double totalBalance){
      //declare variable
      boolean empty = true;

      //declare variable of file pathname
      File f = new File("data.txt");

      //Check if file exists
      try{
          //Create Output Stream
          Scanner Reader = new Scanner(f);
          //Check if there is any content
          if(Reader.hasNextLine()){
              empty = false;
          }
          //Ending Output Stream
          Reader.close();
      //Exception for file not exists
      } catch (FileNotFoundException e) {}

      //Write data to file
      try{
          //Create File Input Stream
          FileWriter Wf = new FileWriter(f,true);
          //If content exists, create newline
          if(!empty){
              Wf.write("\n");
          }
          //Write data to file by parameter declared
          Wf.write(userAccountNumber + "/" + PIN + "/" + Double.toString(availableBalance) + "/" + Double.toString(totalBalance));
          //Ending Input Stream
          Wf.close();
      //Exception for IO
      } catch (IOException e) {
          e.printStackTrace();
      }
      
   }
   //Function - Read Data
   public Vector<String> ReadData(){
      //declare variable
      Vector<String> data = new Vector<String>();

      //Read Data
      try {
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

   private Account accounts[]; // array of Accounts

   // no-argument BankDatabase constructor initializes accounts
   public BankDatabase()
   {  //declare and initialize counter
      int counter = 0;
      
      //2 account for test case
      StoreData(12345, 54321, 1000.0, 1200.0);
      StoreData(98765, 56789, 200.0, 200.0);
      
      //Get account data from File
      accounts = new Account[ReadData().size()];
      for(String data: ReadData()){
         String buffer[] = data.split("/");
         accounts[counter] = new Account(Integer.parseInt(buffer[0]),Integer.parseInt(buffer[1]),Double.parseDouble(buffer[2]),Double.parseDouble(buffer[3]));
         counter++;
      }
   } // end no-argument BankDatabase constructor
   
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