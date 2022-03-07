package TpDaoMain;

import java.util.Scanner;

public class GlobalMethod {

    //Validation checker
    public int validateInputaNum() {
        Scanner sc = new Scanner(System.in);
        int inputInt;
        try {
            inputInt = sc.nextInt();
        } catch (Exception e) {
            System.out.println("This is not a number, please try again. ");
            return validateInputaNum ();
        }
        return inputInt;
    }

    // Validator for double value
    public double validateInputDouble() {
        Scanner sc = new Scanner(System.in);
        double inputDouble;
        try {
            inputDouble = sc.nextDouble();
        } catch (Exception e) {
            System.out.println("This is not a double number, please try again. ");
            return validateInputDouble();
        }
        return inputDouble;
    }
}
