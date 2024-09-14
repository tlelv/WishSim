import java.util.Random;
import java.util.Scanner;


// Make array of roll history so it can be viewed again
// Add 10 roll function
public class Main {

    public static int rollResult (int rollHistory) {
        int rollResult = 0;

        // create instance of Random class
        Random roll = new Random();

        // Generate random integers in range 0 to 999
        int rollRng = roll.nextInt(1000);

        // Looks at roll history given no pity
        if (rollHistory > 90) {
            System.out.println("    Error, reset Roll Counter");
            rollResult = 3;
        }
        // Hard Pity
        if (rollHistory == 90) {
            rollResult = 2;
        }
        // Soft Pity
        if (rollHistory > 75 && rollHistory < 90) {
            if (rollRng < 325) {
                rollResult = 2;
            }
            if (rollRng > 324 && rollRng < 376) {
                rollResult = 1;
            }
        }
        else {
            if (rollRng < 6) {
                rollResult = 2;
            }
            if (rollRng > 5 && rollRng < 58) {
                rollResult = 1;
            }
        }
        return rollResult;
    }

    //public static int runRoll {

    //}
    public static void main(String[] args) {
        Scanner scr = new Scanner(System.in);
        int val = 0,
            rollHistory = 0,
            midHistory = 0,
            reward;


        System.out.println("\n     Welcome to 50/50 Cope");
        System.out.println("     ---------------------");
        System.out.println("     Enter (1) to Single wish");
        System.out.println("     Enter (2) to Multi Wish (10)");
        System.out.println("     Enter (3) to Check Wish History");
        System.out.println("     Enter (4) to Stop");

        while (val != 4) {
            System.out.print("     Enter Choice: ");
            val = scr.nextInt();

            switch(val) {
                case 1:
                    System.out.println("\n    Preparing to Roll...");
                    rollHistory++;

                    reward = rollResult(rollHistory);

                    // Guaranteed 4 star
                    if (midHistory >= 9 && reward != 2) {
                        reward = 1;
                    }
                    switch(reward) {
                        case 0:
                            System.out.println();
                            System.out.println("    3 star haha get fucked\n");
                            midHistory++;
                            break;
                        case 1:
                            System.out.println();
                            System.out.println("    4 star woah good job\n");
                            midHistory = 0;
                            break;
                        case 2:
                            System.out.println();
                            System.out.println("    5 star yippie ٩(ˊᗜˋ*)و ♡\n");
                            // Resets Pity
                            // Add Method to determine 50/50
                            midHistory++;
                            rollHistory = 0;
                            break;
                    }
                    break;
                case 2:
                    // ADD 10 ROLL
                    System.out.println("Rolling 10 times");
                    break;
                case 3:
                    // ADD ROLL HISTORY
                    System.out.println("Checking roll history");
                    break;
                case 4:
                    break;
                default:
                    System.out.println("Enter valid choice");
                    break;
            }
        }
        System.out.println();
        System.out.println("    Quitting...");
    }
}