package interviewProblems.Jump_Game_3;

class SolutionAlt {
    private int[] arr;

    public boolean canReach(int[] arr, int start) {
        this.arr = arr;
        return this.recReach(start);
    }

    public boolean recReach(int curr){
        // Check out of bounds or visited
        if (curr < 0 || curr >= this.arr.length || this.arr[curr] < 0) return false;
        // Reached target index
        if (this.arr[curr] == 0) return true;
        // Mark location as visited
        int jump = this.arr[curr];
        this.arr[curr] = -this.arr[curr];
        // Attempt to go to another location
        return this.recReach(curr + jump) || this.recReach(curr - jump);
    }
}