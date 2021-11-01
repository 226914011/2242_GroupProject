//  Validation.java
//  This class stores general validation method for the program

public class Validation {
    private Screen screen;

    public Validation(Screen thescreen){
        screen = thescreen;
    }

    //Return integer method - check data type is integer
    public int checkInt (String check){
        try {
            if(check.contains(".")){
                screen.displayMessageLine("\tInvalid data type: input should be integer!");
                return -1;
            }
            if (check.length() > 9){
                screen.displayMessageLine("\tInvalid data length: input should be within 9 digits!");
                return -1;
            }
            return Integer.parseInt(check);
        //For other unexpected exceptions
        } catch (Exception e) {
            screen.displayMessageLine("\tInvalid data type: input should be integer!");
            return -1;
            
        }
    }
}