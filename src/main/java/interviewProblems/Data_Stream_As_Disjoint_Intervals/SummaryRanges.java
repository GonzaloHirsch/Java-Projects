package interviewProblems.Data_Stream_As_Disjoint_Intervals;
class SummaryRanges {
    private final int START = 1;
    private final int END = 2;
    private final int FILL = -1;
    private final int LONE = 3;
    private final int LIMIT = 10001;
    private int[] ranges;
    private int totalRanges;

    public SummaryRanges() {
        // Starts array in zeros
        this.ranges = new int[LIMIT];
        this.totalRanges = 0;
    }

    public void addNum(int val) {
        int storedValue = this.ranges[val], targetStoredValue = 0;
        // If value is zero, it means we don't have it
        if (storedValue == 0) {
            // Set the lone value as baseline
            this.ranges[val] = LONE;
            this.totalRanges++;
            // Checking for numbers before
            if (val > 0) {
                targetStoredValue = this.ranges[val - 1];
                switch(targetStoredValue) {
                    // In this scenario the number before was an end, so the new number is an end
                    case END:
                        this.ranges[val - 1] = FILL;
                        this.ranges[val] = END;
                        this.totalRanges--;
                        break;
                    // The previous number was a lone number, so we have a new range
                    case LONE:
                        this.ranges[val - 1] = START;
                        this.ranges[val] = END;
                        this.totalRanges--;
                        break;
                }
            }
            // Checking for numbers after
            if (val < LIMIT) {
                targetStoredValue = this.ranges[val + 1];
                switch(targetStoredValue) {
                    // In this scenario the number before was an end, so the new number is an end
                    case START:
                        this.ranges[val + 1] = FILL;
                        this.ranges[val] = this.ranges[val] == LONE ? START : FILL;
                        this.totalRanges--;
                        break;
                    // The previous number was a lone number, so we have a new range
                    case LONE:
                        this.ranges[val + 1] = END;
                        this.ranges[val] = this.ranges[val] == LONE ? START : FILL;
                        this.totalRanges--;
                        break;
                }
            }
        }
    }

    public int[][] getIntervals() {
        int[][] res = new int[this.totalRanges][2];
        for (int i = 0, currentRanges = 0; i < LIMIT && currentRanges < this.totalRanges; i++) {
            switch(this.ranges[i]) {
                case LONE:
                    res[currentRanges][0] = i;
                    res[currentRanges++][1] = i;
                    break;
                case START:
                    res[currentRanges][0] = i;
                    break;
                case END:
                    res[currentRanges++][1] = i;
                    break;
            }
        }
        return res;
    }
}

/**
 * Your SummaryRanges object will be instantiated and called as such:
 * SummaryRanges obj = new SummaryRanges();
 * obj.addNum(val);
 * int[][] param_2 = obj.getIntervals();
 */