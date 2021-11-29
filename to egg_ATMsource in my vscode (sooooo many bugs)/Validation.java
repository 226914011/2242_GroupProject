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
            return Integer.parseInt(check);
        //For null input
        } catch (Exception e) {
            return -1;
        }
    }
}