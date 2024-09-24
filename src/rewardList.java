
import java.util.ArrayList;

public class rewardList {
    private ArrayList<rewardObject> rewardHistory;

    public void RewardHistory() {
        rewardHistory = new ArrayList<>();
    }

    // Add a new Reward to the array
    public void addReward(int reward, String item) {
        rewardObject obj = new rewardObject(reward, item);
        rewardHistory.add(obj);
    }

    // Get the object at a specified index
    public rewardObject getObject(int index) {
        if (index >= 0 && index < rewardHistory.size()) {
            return rewardHistory.get(index);
        } else {
            throw new IndexOutOfBoundsException("Index out of bounds.");
        }
    }

    // Display all objects in the array
    public void displayAllRewards() {
        for (rewardObject obj : rewardHistory) {
            System.out.println(obj);
        }
    }
}