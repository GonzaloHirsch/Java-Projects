package interviewProblems.Permutations;

import java.util.ArrayList;
import java.util.List;

class Solution {

    private List<List<Integer>> result;

    public List<List<Integer>> permute(int[] nums) {
        this.result = new ArrayList<>();
        this.generatePermutations(nums, new ArrayList<>());
        return this.result;
    }

    private void generatePermutations(int[] nums, List<Integer> list) {
        // Reached the end of the recursion
        if (list.size() == nums.length) {
            this.result.add(new ArrayList<>(list));
            return;
        }
        // Iterate all numbers
        for (int n : nums) {
            if (list.contains(n)) continue;
            list.add(n);
            this.generatePermutations(nums, list);
            list.remove(list.size() - 1);
        }
    }

    /*
    private List<List<Integer>> result;

    public List<List<Integer>> permute(int[] nums) {
        this.result = new ArrayList<>();
        // Create and fill with identifier to trim cases
        Integer[] arr = new Integer[nums.length];
        Arrays.fill(arr, Integer.MIN_VALUE);
        // Recurse
        this.generatePermutations(nums, arr, 0);
        return this.result;
    }

    private void generatePermutations(int[] nums, Integer[] arr, int pos) {
        // Reached the end of the recursion
        if (pos == nums.length) {
            this.result.add(Arrays.asList(Arrays.copyOf(arr, pos)));
            return;
        }
        // Recurse, try each position for the pos character
        for (int i = 0; i < nums.length; i++) {
            // Cannot select same position on one branch
            if (arr[i] != Integer.MIN_VALUE) continue;
            arr[i] = nums[pos];
            this.generatePermutations(nums, arr, pos + 1);
            arr[i] = Integer.MIN_VALUE;
        }
    }
    */
}