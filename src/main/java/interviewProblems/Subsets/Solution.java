package interviewProblems.Subsets;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {
    private List<List<Integer>> res;
    private int[] nums;
    private Set<Integer> current;

    public List<List<Integer>> subsets(int[] nums) {
        // Create with fixed size
        this.res = new ArrayList<>((int)Math.pow(nums.length, 2));
        this.nums = nums;
        this.current = new HashSet<Integer>(nums.length);
        // Add base case of empty list
        res.add(new ArrayList<Integer>());
        // Add base case of full list
        List<Integer> fullList = new ArrayList<>(nums.length);
        for (int i = 0; i < nums.length; i++) fullList.add(nums[i]);
        res.add(fullList);
        // Call the recursive method
        computeLists(0);
        return res;
    }

    private void computeLists(int index) {
        // Base cases
        if (this.current.size() == this.nums.length) return;
        else if (this.current.size() >= 1) this.res.add(new ArrayList<>(this.current));
        // Iterate to explore, don't count "older" numbers
        for (int i = index; i < this.nums.length; i++) {
            if (!this.current.contains(this.nums[i])) {
                this.current.add(this.nums[i]);
                computeLists(i);
                this.current.remove(this.nums[i]);
            }
        }
    }
}