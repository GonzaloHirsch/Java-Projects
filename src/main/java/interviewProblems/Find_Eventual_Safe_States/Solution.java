package interviewProblems.Find_Eventual_Safe_States;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        // Status array, 0 is unvisited, 1 is during visit, 2 is visited
        int[] status = new int[graph.length];
        List<Integer> result = new ArrayList<>();
        // Try DFS with each of the nodes but keeping the status
        for (int i = 0; i < graph.length; i++) {
            if (this.safeDfs(graph, i, status)) result.add(i);
        }
        return result;
    }

    public boolean safeDfs(int[][] graph, int current, int[] status) {
        // Base case
        if (graph[current].length == 0) return true;
        else if (status[current] > 0) return status[current] == 2;
        // Mark as during visit
        status[current] = 1;
        for (int node : graph[current]) {
            // If the node is gray or the result of DFS is false, we return false
            if (status[node] == 1 || !this.safeDfs(graph, node, status)) return false;
        }
        // Marking as fully visited
        status[current] = 2;
        return true;
    }
}