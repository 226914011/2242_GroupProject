// CashDispenser.java
// Represents the cash dispenser of the ATM

public class CashDispenser 
{
   // the default initial number of bills in the cash dispenser
   private final static int INITIAL_COUNT_HUNDRED = 10;
   private final static int INITIAL_COUNT_FIVEHUNDRED = 10;
   private final static int INITIAL_COUNT_THOUSAND = 1;
   private int count_hundred; // number of $20 bills remaining
   private int count_fivehundred; 
   private int count_thousand; 
   // no-argument CashDispenser constructor initializes count to default
   public CashDispenser()
   {
      count_hundred = INITIAL_COUNT_HUNDRED;
      count_fivehundred = INITIAL_COUNT_FIVEHUNDRED;
      count_thousand = INITIAL_COUNT_THOUSAND; // set count attribute to default
   } // end CashDispenser constructor

   // simulates dispensing of specified amount of cash
   public void dispenseCash( int hundred, int fivehundred, int thousand )
   {
      count_hundred -= hundred; // update the count of bills
      count_fivehundred -= fivehundred;
      count_thousand -= thousand;
      System.out.printf("count_hundred=%d,count_fivehundred=%d,count_thousand=%d",count_hundred,count_fivehundred,count_thousand);
   } // end method dispenseCash

   // indicates whether cash dispenser can dispense desired amount
   public boolean isSufficientCashAvailable( int amount )
   {
      int hundred, fivehundred, thousand, remaining;
         thousand=amount/1000;
         remaining = amount%1000;
         fivehundred = remaining/500;
         if(count_thousand<thousand){
            int extrafivehundred = ((thousand-count_thousand)*2);
            fivehundred = extrafivehundred + fivehundred;
            thousand=count_thousand;
         }
         remaining = remaining%500;
         hundred = remaining/100;
         if(count_fivehundred<fivehundred){
            int extrahundred ;
            extrahundred = ((fivehundred-count_fivehundred)*5);
            hundred = extrahundred + hundred;
            fivehundred = count_fivehundred;
            
         }
         remaining = remaining%100;
         if (remaining != 0||count_hundred<hundred){
           return false;
         }else{
            dispenseCash(hundred, fivehundred, thousand);
            return true ;
         }
        
     
 // not enough bills available
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