public class rewardObject {
    private int intValue;
    private String stringValue;

    // Constructor to initialize both integer and string values
    public rewardObject(int intValue, String stringValue) {
        this.intValue = intValue;
        this.stringValue = stringValue;
    }

    // Getter method for integer value
    public int getRewardValue() {
        return intValue;
    }

    // Setter method for integer value
    public void setRewardValue(int intValue) {
        this.intValue = intValue;
    }

    // Getter method for string value
    public String getItemValue() {
        return stringValue;
    }

    // Setter method for string value
    public void setItemValue(String stringValue) {
        this.stringValue = stringValue;
    }

    // toString method to represent the object as a string
    @Override
    public String toString() {
        return "Reward Type: " + intValue + ", Item: " + stringValue;
    }

    public String decideRewardItem(int rewardNum) {
        String item = null;

        switch(rewardNum) {
            case 0:
                // DECIDE 3 STAR ITEMS
                break;
            case 1:
                // DECIDE 4 STAR ITEMS
                break;
            case 2:
                // DECIDE 5 STAR ITEMS
                break;
        }


        return item;
    }
}

