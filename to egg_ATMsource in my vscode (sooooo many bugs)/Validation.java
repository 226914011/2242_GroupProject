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
            //input is double, return -1
            if(check.contains(".")){
                screen.displayMessageLine("\tInvalid data type: input should be integer!");
                return -1;  //-1 mean invalid input
            }
            //input digits that larger than 9, return -1
            if (check.length() > 9){
                screen.displayMessageLine("\tInvalid data length: input should be within 9 digits!");
                return -1;  //-1 mean invalid input
            }
            //convert string to integer
            return Integer.parseInt(check);
        //For other unexpected exceptions
        } catch (Exception e) {
            screen.displayMessageLine("\tInvalid input: unexpected exception!");
            return -1;  //-1 mean invalid input
            
        }
    }
}