
import java.util.Arrays;
import java.util.Scanner;

/*
 * Name: Benedict Lee
 * Class: CSCI308-A-ADV DATA STRUCTURS,ALGORTHMS I, FALL 2022
 * Date: 4 Nov 2022 2100
 * Driver class for Lab7
 */
public class UserInterface {

    static int[] changeType = new int[5];
    static int[] changeTracker = new int[5];

    static void interact() {
        try ( Scanner input = new Scanner(System.in)) {
            System.out.print("Please enter integers only.\n"
                    + "Please provide five different values representing "
                    + "five different coin types with an enter between each value."
                    + "\n(E.g. 10 for dime, 5 for nickel) \n");

            //User enters 5 values store into changeType array from smallest to largest
            int coinType = 0;
            for (int i = 0; i < changeType.length; i++) {
                CheckIntegerInput(input);
                coinType = Integer.parseInt(input.next());
                while (coinType < 0 || coinType > 100) {
                    System.out.println("You entered an invalid coin type!"
                            + " Please enter a value between 1 and 100 inclusive");
                    CheckIntegerInput(input);
                    coinType = Integer.parseInt(input.next());
                }
                changeType[i] = coinType;
            }

            for (int i = 0; i < changeType.length; i++) {
                for (int j = i + 1; j < changeType.length; j++) {
                    if (changeType[i] == changeType[j]) {
                        System.out.println("You entered a duplicate coin value! "
                                + "Please try again!");
                        System.exit(0);
                    }
                }
            }
            input.nextLine();
            Arrays.sort(changeType);

            //Amount of change needed
            System.out.println("\nHow much change do you require? "
                    + " The maximum amount of change that we provide is 100.");

            CheckIntegerInput(input);
            int changeRequested = input.nextInt();

            //If change value is over 100
            while (changeRequested > 100) {
                System.out.println("You entered a change value that is higher"
                        + " than 100!!! Please try again.");
                System.out.println("Please enter a change value!");
                CheckIntegerInput(input);
                changeRequested = Integer.parseInt(input.nextLine());
            }
            //If change value is under 100
            while (changeRequested < 0) {
                System.out.println("You entered a change value that is lower"
                        + " than 100!!! Please try again.");
                System.out.println("Please enter a change value!");
                CheckIntegerInput(input);
                changeRequested = Integer.parseInt(input.nextLine());
            }

            //Calculate the minimum amount of change required
            changeCalculator(changeRequested);
            System.out.println();
            //Coin distribution
            coinDistribution(changeRequested);
        } catch (Exception e) {
            System.out.println("An unknown error occured, contact your administrator "
                    + "at 850 - 555 - 4000.");
            System.exit(0);
        }
    }

    private static void CheckIntegerInput(Scanner input) {
        while (!input.hasNextInt()) {
            String inp = input.next();
            System.out.println("Error: " + inp + " is not a valid integer."
                    + " Please try again.");
            input.nextLine();
        }
    }

    private static void changeCalculator(int changeRequested) {
        int totalChange = 0;
        for (int i = 4; i != -1; i--) {
            while (totalChange + changeType[i] <= changeRequested) {
                totalChange += changeType[i];
                changeTracker[i] = changeTracker[i] + 1;
            }
        }
    }

    private static void coinDistribution(int changeRequested) {
        for (int i = 0; i < changeType.length; i++) {
            System.out.println("Coin " + changeType[i] + " Number : "
                    + changeTracker[i]);
        }
        System.out.println("Total Change = " + changeRequested);
    }
}
