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
            int buffer = Integer.parseInt(check);
            return buffer;
        } catch (Exception e) {
            screen.displayMessageLine("\tInvalid data type: input should be integer!");
            return -1;
            
        }
    }
}