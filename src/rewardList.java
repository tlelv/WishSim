
import java.util.ArrayList;

public class rewardList {
    private ArrayList<Reward> rewardHistory;
    private ArrayList<Reward> rewardChoices;

    public void RewardHistory() {
        rewardHistory = new ArrayList<>();
    }

    // Add a new Reward to the array
    public void addReward(Reward obj) {
        rewardHistory.add(obj);
    }

    // Get the object at a specified index
    public Reward getObject(int index) {
        if (index >= 0 && index < rewardHistory.size()) {
            return rewardHistory.get(index);
        } else {
            throw new IndexOutOfBoundsException("Index out of bounds.");
        }
    }

    // Display all objects in the array
    public void displayAllRewards() {
        for (Reward obj : rewardHistory) {
            System.out.println(obj);
        }
    }
}