//  Validation.java
//  This class stores general validation method for the program

public class Validation {
    Screen screen;
    public Validation(Screen thescreen){
        screen = thescreen;
    }

    //boolean method - check data type is integer
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
