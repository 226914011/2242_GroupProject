//  ChequeAccount.java
//  This class represents the bank's cheque account

public class ChequeAccount extends Account {
    //declare the limit for limit per cheque 
    private double limitCheque = 10000;

    //constructor method
    public ChequeAccount(int theAccountNumber, int thePIN, double theAvailableBalance, double theTotalBalance, BankDatabase theBD) {
        
        super(2, theAccountNumber, thePIN, theAvailableBalance, theTotalBalance, theBD);
    }
    
    //get the limit per cheque
    public double getLimit(){
        return limitCheque;
    }

    //set the limit per cheque
    public void setLimit(double setvalue){
        limitCheque = setvalue;
    }
}
