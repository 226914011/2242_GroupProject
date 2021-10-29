// SavingAccount.java
// This class represents a bank savings account

public class SavingAccount extends Account {
        private double interestRate = 0.001;  //Saving interest rate per annum
    
        // SavingAccount constructor initializing attributes using superclass constructor
        public SavingAccount ( int theAccountNumber, int thePIN, 
        double theAvailableBalance, double theTotalBalance)
        {
           super(theAccountNumber, thePIN, theAvailableBalance, theTotalBalance); 
        }
        
        // set method for instance variable interestRate
        public void setInterestRate(double rate)
        {
            interestRate = rate;  // replacing current interest rate with the value of parameter
        }
    
        // get method for instance variable interestRate
        public double getInterestRate()
        {
            return interestRate;  
        }
}
