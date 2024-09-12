import java.util.Random;
import java.util.Scanner;

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
        if (rollHistory == 90) {
            rollResult = 2;
        }
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
    public static void main(String[] args) {
        int val = 0;
        int rollHistory = 0;
        int reward = 0;
        Scanner scr = new Scanner(System.in);

        System.out.println("\n     Welcome to 50/50 Cope");
        System.out.println("     ---------------------");
        System.out.println("     Enter (1) to wish");
        System.out.println("     Enter (2) to stop");

        while (val != 2) {
            System.out.print("     Enter Choice: ");
            val = scr.nextInt();

            if (val == 1) {
                System.out.println("    Preparing to Roll...");
                rollHistory++;
                reward = rollResult(rollHistory);

                switch(reward) {
                    case 0:
                        System.out.println();
                        System.out.println("    3 star haha get fucked");
                        break;
                    case 1:
                        System.out.println();
                        System.out.println("    4 star woah good job");
                        break;
                    case 2:
                        System.out.println();
                        System.out.println("    5 star yippie ٩(ˊᗜˋ*)و ♡");
                        break;
                }
            }
            else {
                System.out.println();
                System.out.println("    Quitting...");
            }
        }
    }
}