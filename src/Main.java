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

    public static void runRoll (rollHistory rollHist, midHistory midHist, rewardList rewardHistory){
        int reward;

        rollHist.addHistory();
        reward = rollResult(rollHist.getHistory());

        // Guaranteed 4 star
        if (midHist.getHistory() >= 9 && reward != 2) {
            reward = 1;
        }
        // rewardHistory.addReward(reward, "PUT ITEM HERE DECIDED BY RNG");

        switch (reward) {
            case 0:
                System.out.println();
                System.out.println("    3 star haha get fucked (3)\n");
                midHist.addHistory();
                break;
            case 1:
                System.out.println();
                System.out.println("    4 star woah good job (4)\n");
                midHist.clearHistory();
                break;
            case 2:
                System.out.println();
                System.out.println("    5 star yippie ٩(ˊᗜˋ*)و ♡ (5)\n");
                // Resets Pity
                // Add Method to determine 50/50
                midHist.addHistory();
                rollHist.clearHistory();
                break;
        }
    }

    public static void main(String[] args) {
        rollHistory currHistory = new rollHistory();
        midHistory currMidHistory = new midHistory();
        rewardList rewardHistory = new rewardList();
        Scanner scr = new Scanner(System.in);
        int val = 0;


        while (val != 4) {
            System.out.println("\n     Welcome to 50/50 Cope");
            System.out.println("     ---------------------");
            System.out.println("     Enter (1) to Single wish");
            System.out.println("     Enter (2) to Multi Wish (10)");
            System.out.println("     Enter (3) to Check Wish History");
            System.out.println("     Enter (4) to Stop");
            System.out.println();
            System.out.println();
            System.out.print("     Enter Choice: ");



            val = scr.nextInt();

            switch(val) {
                case 1:
                    System.out.println("\n    Preparing to Roll...");
                    runRoll(currHistory, currMidHistory, rewardHistory);
                    break;
                case 2:
                    // ADD 10 ROLL
                    System.out.println("Rolling 10 times");
                    for (int i = 0; i < 10; i++) {
                        runRoll(currHistory, currMidHistory, rewardHistory);
                    }
                    break;
                case 3:
                    // ADD ROLL HISTORY
                    System.out.println("\nChecking roll history");
                    System.out.println();
                    System.out.println("Current Roll History: " + currHistory.getHistory());
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