import java.util.ArrayList;
import java.util.List;

public class rollHistory {
    private int rollCount;            // Counter for total rolls
    private List<Reward> rewards;     // List to store rewards

    // Constructor to initialize the rollCount and rewards list
    public rollHistory() {
        this.rollCount = 0;           // Initialize rollCount to 0
        this.rewards = new ArrayList<>(); // Initialize rewards list
    }

    public int getRollCount() {
        return rollCount;
    }

    public List<Reward> getRewards() {
        return rewards;
    }

    // Method to increment the roll count
    public void incrementRollCount() {
        this.rollCount++;               // Increment the roll count
    }

    // Method to add a reward to the list
    public void addReward(Reward reward) {
        this.rewards.add(reward);       // Add the reward to the list
    }

    // Method to reset the roll count
    public void resetRollCount() {
        this.rollCount = 0;            // Reset roll count to 0
    }

    // Method to clear rewards list
    public void clearRewards() {
        this.rewards.clear();           // Clear the rewards list
    }

    // Method to return a string representation of the history
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Current Roll Total (Pity Resets at 90): ").append(rollCount).append("\n");

        if (rewards.isEmpty()) {
            sb.append("No rewards in history.");
        } else {
            sb.append("Roll History:\n");
            for (Reward reward : rewards) {
                sb.append(reward).append("\n");
            }
        }
        return sb.toString();
    }
}