public class ChequeAccount extends Account {
    private int limitCheque = 10000;

    public ChequeAccount(int theAccountNumber, int thePIN, double theAvailableBalance, double theTotalBalance) {
        super(theAccountNumber, thePIN, theAvailableBalance, theTotalBalance);
    }
    
    public int getLimit(){
        return limitCheque;
    }

    public void setLimit(int setvalue){
        limitCheque = setvalue;
    }
}
