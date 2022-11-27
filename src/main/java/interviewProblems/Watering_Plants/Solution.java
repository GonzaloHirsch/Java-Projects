package interviewProblems.Watering_Plants;


import java.util.*;

class Solution {
    public int wateringPlants(int[] plants, int capacity) {
        int steps = 0;
        for (int i = 0, water = capacity; i < plants.length; i++) {
            if (water < plants[i]) {
                steps += (i * 2);
                water = capacity;
            }
            water -= plants[i];
        }
        return steps + plants.length;
    }
}