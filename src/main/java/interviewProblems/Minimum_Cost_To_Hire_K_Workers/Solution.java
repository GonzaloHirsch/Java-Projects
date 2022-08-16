package interviewProblems.Minimum_Cost_To_Hire_K_Workers;

import java.util.Arrays;
import java.util.PriorityQueue;

class Solution {
    public double mincostToHireWorkers(int[] quality, int[] wage, int k) {
        // Create all workers and sort the array
        double[][] workers = new double[wage.length][2];
        for (int i = 0; i < wage.length; i++)
            workers[i] = new double[]{(double)wage[i]/(double)quality[i], (double)quality[i]};
        Arrays.sort(workers, (a, b) -> Double.compare(a[0], b[0]));
        // Workers kept in order of quality, less total quality means less cost
        PriorityQueue<Double> workerPool = new PriorityQueue<>();
        double res = Double.MAX_VALUE, totalQ = 0;
        // Given we use the rates, we are guaranteed not to pay them under that
        for (double[] worker : workers) {
            totalQ += worker[1];    // Add to quality sum
            workerPool.add(-worker[1]);  // Add to quality pool
            // If we have more than we need, replace the worker with highest quality
            if (workerPool.size() > k) totalQ += workerPool.poll();
            // Check if by using this combination we have lower costs
            if (workerPool.size() == k) res = Math.min(res, totalQ * worker[0]);
        }
        return res;
    }
}