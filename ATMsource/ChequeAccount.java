public class ChequeAccount extends Account {
    private double limitCheque = 10000;

    public ChequeAccount(int theAccountNumber, int thePIN, double theAvailableBalance, double theTotalBalance, BankDatabase theBD) {
        super(false, theAccountNumber, thePIN, theAvailableBalance, theTotalBalance, theBD);
    }
    
    public double getLimit(){
        return limitCheque;
    }

    public void setLimit(double setvalue){
        limitCheque = setvalue;
    }
}
