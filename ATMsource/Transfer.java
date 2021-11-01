//  Transfer.java
//  This class represents the transfer function of an ATM

public class Transfer extends Transaction{
    private Keypad keypad; // reference to keypad
    private Screen screen;
    private BankDatabase bankDatabase;
    private int tarAccNum;
    private double amount;
    private boolean CANCELED,accValidate;
    private Validation validation;

    private static final int INVALID = -1;


    //Transfer constructor
    public Transfer(int userAccountNumber, Screen atmScreen, BankDatabase atmBankDatabase, Keypad atmKeypad, Validation atmValidation) {
        super(userAccountNumber, atmScreen, atmBankDatabase);
        
        keypad = atmKeypad; // get reference
        validation = atmValidation; // get reference
        bankDatabase = getBankDatabase();   // get reference
        screen = getScreen();   // get reference
    }

    public void execute() {
        //ask user input the transfer information
        do
        {
            //ask user input account number for transfer
            screen.displayMessage("\nPlease enter the account number for transfer: ");
            tarAccNum = validation.checkInt(keypad.getInput());

            //check input is a valid integer
            if(tarAccNum == INVALID)    continue;

            //check input is a valid account number
            accValidate = !accNumValidity();
            if (accValidate)    continue;

            //ask user input amount
            screen.displayMessage("\nPlease enter the amount to transfer (it will ignore digits after two decimal point): ");
            amount = Math.floor(keypad.getDoubleInput()*100)/100.0;
            //clear input buffer
            keypad.getInput();
        } while(tarAccNum == INVALID || accValidate || !amountValidity() ||!confirmUserInput()); //if user inter a invalid information, re-enter the imformation

        //do transfer
        if (!CANCELED){
            //debit the money from owner account number
            bankDatabase.debit(getAccountNumber(), amount);
            //credit the money from transfer target account number
            bankDatabase.credit(tarAccNum, amount);

            //display transfer success message
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
        if(!bankDatabase.checkAccountExist(tarAccNum)){
            screen.displayMessageLine("\tThe account " + tarAccNum + " is an invalid user account.\n\tPlease re-enter the user account.\n");
            return false;
        }
        if(getAccountNumber() == tarAccNum){
            screen.displayMessageLine("\tThe account " + tarAccNum + " is your own account.\n\tPleasse input an valid account number.\n");
            return false;
        }
        return true;
    }

    //boolean method - check the account have enough money to transfer and amount is positive double number
    //havn't check dec place size 
    private boolean amountValidity(){
        double availablebalance = bankDatabase.getAvailableBalance(getAccountNumber());
        //return false when input amount larger than Available Balance
        if (amount > availablebalance){
            screen.displayMessageLine("\tYou have inputted an invalid amount.\n\tPlease re-enter the amount.");
            screen.displayMessageLine("\tAmount should smaller or equal to $" + availablebalance + ".\n");
            return false;
        }
        
        return true;
    }


    //boolean method - confirm the information
    private boolean confirmUserInput(){
        do{
            //display confrim message
            screen.displayMessageLine("\nThe account number for transfer: " + tarAccNum);
            screen.displayMessage("Your transfer amount: ");
            screen.displayDollarAmount(amount);
            screen.displayMessageLine("\n");
            screen.displayMessageLine("Confirm your input?");
            screen.displayMessageLine( "1 - Confirm" );
            screen.displayMessageLine( "2 - re-enter the information" );
            screen.displayMessageLine( "3 - cancel transfer" );

            int input = validation.checkInt(keypad.getInput()); // get user input through keypad
            if (input == INVALID)  continue;    //check is this a valid integer
            
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
