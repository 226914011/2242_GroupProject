
public class Transfer extends Transaction{
    private Keypad keypad; // reference to keypad
    private Screen screen;
    private BankDatabase bankDatabase;
    private int tarAccNum;
    private double amount;
    private boolean CANCELED;

    public Transfer(int userAccountNumber, Screen atmScreen, BankDatabase atmBankDatabase, Keypad atmKeypad) {
        super(userAccountNumber, atmScreen, atmBankDatabase);
        
        keypad = atmKeypad;
        bankDatabase = getBankDatabase();
        screen = getScreen();
    }

    @Override
    public void execute() {
        // TODO Auto-generated method stub
        BankDatabase bankDatabase = getBankDatabase(); // get reference
        Screen screen = getScreen(); // get reference

        do{
            //ask user input account number
            screen.displayMessage("\nPlease enter the account number for transfer: ");
            tarAccNum = keypad.getInput();
            
            //ask user input amount
            screen.displayMessage("Please enter the amount to transfer: ");
            amount = keypad.getDoubleInput();

        //need edit, should ask user re-enter ASAP!!!!!
        } while(!(accNumValidity() && amountValidity() && conformUserInput()));

        if (!CANCELED){
            bankDatabase.debit(getAccountNumber(), amount);
            bankDatabase.credit(tarAccNum, amount);

            screen.displayMessageLine("\nThe transfer is success. ");

            //need edit, it is from balanceInquiry class, 
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
        if( getAccountNumber() == tarAccNum || !bankDatabase.checkAccountExist(tarAccNum)){
            screen.displayMessageLine("\tYou input a invalid user account, please re-enter the user account");
            screen.displayMessageLine("\tUser cannot input own account number \n\tPleasse comfirm your input is valid account number\n\n");
            return false;
        }

        return true;
    }

    //boolean method - check the account have enough money to transfer and amount is positive double number
    //havn't check dec place size 
    private boolean amountValidity(){
        if (amount > bankDatabase.getAvailableBalance(getAccountNumber()) || amount < 0.0){
            screen.displayMessageLine("\tYou input a invalid amount, please re-enter the amount");
            screen.displayMessageLine("\tAmount should smaller than AvailableBalance and larger than 0\n\n");
            return false;
        }
        
        return true;
    }


    //boolean method - conform the information
    private boolean conformUserInput(){
        do{
            screen.displayMessageLine("\nThe account number for transfer: " + tarAccNum);
            screen.displayMessage("Your transfer amount: ");
            screen.displayDollarAmount(amount);
            screen.displayMessageLine("\n");
            screen.displayMessageLine("Comfirm your input?");
            screen.displayMessageLine( "1 - Comfirm" );
            screen.displayMessageLine( "2 - re-enter the information" );
            screen.displayMessageLine( "3 - cancel transfer" );

            switch(keypad.getInput()){
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
            }
        } while(true);
    }
}
