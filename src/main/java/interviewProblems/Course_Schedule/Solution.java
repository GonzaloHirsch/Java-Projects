package interviewProblems.Course_Schedule;

import java.util.*;

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // Compute all the requirements and build the graph
        Map<Integer, Set<Integer>> courses = new HashMap<>();
        for (int i = 0; i < numCourses; i++) courses.put(i, new HashSet<>());
        for (int[] prereq : prerequisites) courses.get(prereq[0]).add(prereq[1]);

        Stack<Integer> stack = new Stack<>();
        Map<Integer, Integer> visited = new HashMap<>();

        // Iterate all the nodes
        for (int i = 0; i < numCourses; i++) {
            // Not being visited is when the node wasn't seen on any path
            if (!visited.containsKey(i)) {
                stack.add(i);
                visited.put(i, 1);  // 1 is IN_STACK, 2 is DONE
                // Check node for cycles
                if (!this.processDFS(courses, stack, visited)) return false;
            }
        }
        return true;
    }

    private boolean processDFS(Map<Integer, Set<Integer>> courses, Stack<Integer> stack, Map<Integer, Integer> visited) {
        // Iterate all the connections for the given node
        for (Integer course : courses.get(stack.peek())) {
            // If the node is currently waiting to be processed in the stack, it's a loop
            if (visited.getOrDefault(course, 0) == 1) return false;
                // If the node isn't visited, continue working. If visited, we should process it
            else if (visited.getOrDefault(course, 0) == 0) {
                stack.push(course);
                visited.put(course, 1);
                if (!this.processDFS(courses, stack, visited)) return false;
            }
        }
        // Mark the node as certain it doesn't have loops and remove it
        visited.put(stack.peek(), 2);
        stack.pop();
        return true;
    }
}