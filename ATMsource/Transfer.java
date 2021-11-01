//  Transfer.java
//  This class represents the transfer function of an ATM

public class Transfer extends Transaction{
    private Keypad keypad; // reference to keypad
    private Screen screen;
    private BankDatabase bankDatabase;
    private int tarAccNum;
    private double amount;
    private boolean CANCELED;
    private Validation validation;

    private static final int INVALID = -1;


    //Transfer constructor
    public Transfer(int userAccountNumber, Screen atmScreen, BankDatabase atmBankDatabase, Keypad atmKeypad, Validation atmValidation) {
        super(userAccountNumber, atmScreen, atmBankDatabase);
        
        keypad = atmKeypad;
        validation = atmValidation;
        bankDatabase = getBankDatabase();
        screen = getScreen();
    }

    public void execute() {
        BankDatabase bankDatabase = getBankDatabase(); // get reference
        Screen screen = getScreen(); // get reference
        //ask user input the account information
        
        do
        {
            screen.displayMessage("\nPlease enter the account number for transfer: ");
            tarAccNum = validation.checkInt(keypad.getInput());
            
            //ask user input amount
            screen.displayMessage("\nPlease enter the amount to transfer (it will ignore digits after two decimal point): ");
            amount = Math.floor(keypad.getDoubleInput()*100)/100.0;

        } while(!accNumValidity() || !amountValidity() || !confirmUserInput() || tarAccNum == INVALID); //if user inter a invalid information, re-enter the imformation


        if (!CANCELED){
            bankDatabase.debit(getAccountNumber(), amount);
            bankDatabase.credit(tarAccNum, amount);

            screen.displayMessageLine("\nThe transfer is success. ");

            //Show account updated available balance and total balance
            screen.displayMessageLine( "\nUpdated balance Information:" );
            screen.displayMessage( " - Available balance: " ); 
            screen.displayDollarAmount( bankDatabase.getAvailableBalance( getAccountNumber() ) );
            screen.displayMessage( "\n - Total balance:     " );
            screen.displayDollarAmount( bankDatabase.getTotalBalance( getAccountNumber() ) );
            screen.displayMessageLine( "" );
        }
        else{
            screen.displayMessageLine( "\nCanceling transaction..." );
            return; // return to main menu because user canceled
        }
    }

    //boolean method - checkUserAccExistAndNotUserOwnAcc
    private boolean accNumValidity(){
        //return false when transfer account number equal to own account or account number does not exist
        if( getAccountNumber() == tarAccNum || !bankDatabase.checkAccountExist(tarAccNum)){
            screen.displayMessageLine("\tYou have inputted an invalid user account, please re-enter the user account");
            screen.displayMessageLine("\tUser cannot input own account number \n\tPleasse comfirm your input is valid account number\n\n");
            return false;
        }
        
        return true;
        
    }

    //boolean method - check the account have enough money to transfer and amount is positive double number
    //havn't check dec place size 
    private boolean amountValidity(){
        if (amount > bankDatabase.getAvailableBalance(getAccountNumber()) || amount < 0.0){
            screen.displayMessageLine("\tYou have inputted an invalid amount, please re-enter the amount");
            screen.displayMessageLine("\tAmount should smaller than AvailableBalance and larger than 0\n\n");
            return false;
        }
        
        return true;
        
    }


    //boolean method - confirm the information
    private boolean confirmUserInput(){
        do{
            screen.displayMessageLine("\nThe account number for transfer: " + tarAccNum);
            screen.displayMessage("Your transfer amount: ");
            screen.displayDollarAmount(amount);
            screen.displayMessageLine("\n");
            screen.displayMessageLine("Comfirm your input?");
            screen.displayMessageLine( "1 - Comfirm" );
            screen.displayMessageLine( "2 - re-enter the information" );
            screen.displayMessageLine( "3 - cancel transfer" );

            int input = validation.checkInt(keypad.getInput()); // get user input through keypad
            if (input == INVALID)  continue;
            
            switch(input){
                case 1: 
                    return true;
                case 2: 
                    return false;
                case 3:
                    CANCELED = true;
                    return true;
                default:
                    screen.displayMessageLine( 
                    "\nInvalid selection. Try again." );
                    break;
            } 
        } while(true);
    }
}
