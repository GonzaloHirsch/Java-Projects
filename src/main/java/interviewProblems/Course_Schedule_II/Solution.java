package interviewProblems.Course_Schedule_II;

import java.util.*;

/*
* This solution can be further improved by using the indegree of each node.
* */
class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        // Generate the courses
        Map<Integer, List<Integer>> courses = generateCourses(numCourses, prerequisites);

        // Queue to improve search speed and initialize it
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) queue.add(i);

        int[] res = new int[numCourses];
        int i = 0, prevI = 0, size, curr;

        while (!queue.isEmpty() && i >= 0) {
            size = queue.size();
            for (int j = 0; j < size; j++) {
                curr = queue.poll();
                // If no requirements, just add it
                // Check if all requirements are taken too
                if (!courses.containsKey(curr) || courses.get(curr) == null || courses.get(curr).stream().noneMatch(c -> courses.containsKey(c))) {
                    courses.remove(curr);
                    res[i++] = curr;
                } else queue.add(curr);
            }
            // Unchanged, cannot find answer
            if (i == prevI) i = Integer.MIN_VALUE;
            prevI = i;
        }

        return i < 0 ? new int[0] : res;
    }

    private Map<Integer, List<Integer>> generateCourses(int numCourses, int[][] requirements) {
        // Create and fill the courses
        Map<Integer, List<Integer>> courses = new HashMap<>();
        for (int i = 0; i < numCourses; i++) courses.put(i, null);
        // Fill the relationships
        for (int[] req : requirements) {
            courses.computeIfAbsent(req[0], k -> new ArrayList<>());
            courses.get(req[0]).add(req[1]);
        }
        return courses;
    }
}