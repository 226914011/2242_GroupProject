// CashDispenser.java
// Represents the cash dispenser of the ATM

public class CashDispenser 
{
   // the default initial number in the cash dispenser
   private final static int INITIAL_COUNT_HUNDRED = 1;
   private final static int INITIAL_COUNT_FIVEHUNDRED = 1;
   private final static int INITIAL_COUNT_THOUSAND = 1;
   private int count_hundred; // number of $100 remaining
   private int count_fivehundred; // number of $500 remaining
   private int count_thousand; // number of $1000 remaining
   // no-argument CashDispenser constructor initializes count to default
   public CashDispenser()
   {  // set count attribute to default
      count_hundred = INITIAL_COUNT_HUNDRED; //500 * 100
      count_fivehundred = INITIAL_COUNT_FIVEHUNDRED; // 300 * 500
      count_thousand = INITIAL_COUNT_THOUSAND; // 100 * 1000
   } // end CashDispenser constructor

   // simulates dispensing of specified amount of cash
   public void dispenseCash( int hundred, int fivehundred, int thousand )
   {
      count_hundred -= hundred; // update the count of $100 
      count_fivehundred -= fivehundred;// update the count of $500 
      count_thousand -= thousand;// update the count of $1000 
   } // end method dispenseCash

   // indicates whether cash dispenser can dispense desired amount
   public int isSufficientCashAvailable( int amount )
   {
      int hundred, fivehundred, thousand, remaining;
         if(amount % 100 != 0) return 1;  //when user not input the multiple of 100, return 1
         if (amount > count_hundred * 100 + count_fivehundred * 500 + count_thousand * 1000) return 2;//that means there has not enough dollar note
         thousand = amount / 1000; //how many 1000$ dollar note needed
         remaining = amount % 1000; //remain amount after withdraw 1000$ dollar note
         fivehundred = remaining / 500; // how many 500$ dollar note needed
         // Check if 1000$ enought for withdraw
         if(count_thousand < thousand){
            fivehundred += (thousand - count_thousand) * 2;
            thousand = count_thousand;
         }
         if(amount - thousand * 1000 > count_fivehundred * 500 + count_hundred * 100) return 3;//that means there has not enough 100$ dollar note or 500$ dollar note
         remaining = remaining % 500; // remain aount after withdraw 500$ dollar note
         hundred = remaining / 100; // how many 100$ dollar note needed
         // Check if 500$ enought for withdraw
         if(count_fivehundred < fivehundred){
            hundred += (fivehundred - count_fivehundred) * 5;
            fivehundred = count_fivehundred;
         }
         if (amount - thousand * 1000 - fivehundred * 500 > count_hundred * 100) return 4;//that means there has not enough 100$ dollar note
         dispenseCash(hundred, fivehundred, thousand);
         return 5;
        
 
   } // end method isSufficientCashAvailable
} // end class CashDispenser



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