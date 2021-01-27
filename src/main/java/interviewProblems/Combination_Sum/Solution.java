package interviewProblems.Combination_Sum;

import java.util.ArrayList;
import java.util.HashSet;
public class Solution {
    public ArrayList<ArrayList<Integer>> combinationSum(ArrayList<Integer> A, int B) {
        // Create solution, must be list to maintain order
        ArrayList<ArrayList<Integer>> sol = new ArrayList<>();
        // Removing duplicates
        A = new ArrayList<Integer>(new HashSet<Integer>(A));
        // Sorting
        heapsort(A);
        // Brute force sum
        combine(sol, A, new ArrayList<Integer>(), B, 0, 0);
        return new ArrayList<ArrayList<Integer>>(sol);
    }

    public void combine(ArrayList<ArrayList<Integer>> sol, ArrayList<Integer> src, ArrayList<Integer> nw, int B, int sum, int idx){
        if (sum < B){
            for (int i = 0; i < src.size(); i++){
                if (i >= idx){
                    nw.add(src.get(i));
                    this.combine(sol, src, nw, B, sum + src.get(i), i);
                    nw.remove(nw.size() - 1);
                }
            }
        } else if (sum == B){
            sol.add((ArrayList<Integer>)nw.clone());
        }
    }

    public void heapsort(ArrayList<Integer> arr){
        int n = arr.size();
        for (int i = n / 2 - 1; i >= 0; i--){
            heapify(arr, i, n);
        }

        for (int i = n - 1; i >= 0; i--){
            swap(arr, 0, i);
            heapify(arr, 0, i);
        }
    }

    public void heapify(ArrayList<Integer> arr, int i, int n){
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        if (left < n && arr.get(left) > arr.get(largest)){
            largest = left;
        }
        if (right < n && arr.get(right) > arr.get(largest)){
            largest = right;
        }
        if (largest > i){
            swap(arr, i, largest);
            heapify(arr, largest, n);
        }
    }

    public void swap(ArrayList<Integer> arr, int a, int b){
        int tmp = arr.get(a);
        arr.set(a, arr.get(b));
        arr.set(b, tmp);
    }
}
