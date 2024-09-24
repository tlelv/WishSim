public class rollHistory {
    private int history; // private = restricted access

    // Getter
    public int getHistory() {
        return history;
    }

    // Setter
    public void addHistory() {
        this.history = history + 1;
    }

    public void clearHistory() {
        this.history = 0;
    }

}


