public class midHistory {
    private int midHistory; // private = restricted access

    // Getter
    public int getHistory() {
        return midHistory;
    }

    // Setter
    public void addHistory() {
        this.midHistory = midHistory + 1;
    }

    public void clearHistory() {
        this.midHistory = 0;
    }
}

