import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

// Make array of roll history so it can be viewed again
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

    public static int currency(boolean purchase) {
        int balance = 0;

        if (purchase) {
            balance++;
        }

        return balance;
    }

    public static void main(String[] args) {
        rollHistory currHistory = new rollHistory();
        midHistory currMidHistory = new midHistory();
        rewardList rewardHistory = new rewardList();
        Scanner scr = new Scanner(System.in);
        int val = 0;

        // Lists to hold rewards by rarity
        List<Reward> rarity2 = new ArrayList<>();  // 5-star
        List<Reward> rarity1 = new ArrayList<>();  // 4-star
        List<Reward> rarity0 = new ArrayList<>();  // 3-star

        // Read from file
        String fileName = "exampleList.txt"; // The file that contains the reward data

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                // Ignore comment lines or empty lines
                if (line.startsWith("#") || line.trim().isEmpty()) {
                    continue;
                }

                // Process each line from the file
                String[] parts = line.split(";");
                int rarity = Integer.parseInt(parts[0]);
                String name = parts[1];
                String weaponType = parts[2];
                String element = parts[3];

                // Create a new reward object
                Reward reward = new Reward(rarity, name, weaponType, element);

                // Add to the respective list based on rarity
                if (rarity == 2) {
                    rarity2.add(reward);
                } else if (rarity == 1) {
                    rarity1.add(reward);
                } else if (rarity == 0) {
                    rarity0.add(reward);
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }

        // Print the lists
        System.out.println("5-star rewards:");
        for (Reward reward : rarity2) {
            System.out.println(reward);
        }

        System.out.println("\n4-star rewards:");
        for (Reward reward : rarity1) {
            System.out.println(reward);
        }

        System.out.println("\n3-star rewards:");
        for (Reward reward : rarity0) {
            System.out.println(reward);
        }


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
                    System.out.println("Rolling 10 times");
                    for (int i = 0; i < 10; i++) {
                        runRoll(currHistory, currMidHistory, rewardHistory);
                    }
                    break;
                case 3:
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