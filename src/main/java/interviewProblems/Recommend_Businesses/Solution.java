package interviewProblems.Recommend_Businesses;

import java.util.*;

/**
 * Business class that consists of a business name and a hashmap of nearby businesses.
 */
class Business {
    /**
     * The name of the business.
     */
    String name;

    /**
     * A Map of nearbyBusinesses where the key is the nearby Business object
     * and the value is distance from the current Business to the nearby Business.
     */
    Map<Business, Integer> nearbyBusinesses;

    public Business(String name) {
        this.name = name;
        this.nearbyBusinesses = new HashMap<>();
    }

    public String getName() {
        return this.name;
    }

    public Map<Business, Integer> getNearbyBusinesses() {
        return this.nearbyBusinesses;
    }
}

class Solution {
    /* DFS SOLUTION */
    public static List<String> findReachableBusinesses1(Business startingBusiness, int distance) {
        List<String> reachableBusinesses = new ArrayList<>();
        reachableBusinessesDFS(startingBusiness, reachableBusinesses, 0, distance);
        return reachableBusinesses;
    }

    private static void reachableBusinessesDFS(Business currentBusiness, List<String> reachableBusinesses, int currentDistance, int maxDistance) {
        // Out of range
        if (currentDistance > maxDistance) return;
        // Business is within the distance, avoid adding the initial business
        else if (currentDistance > 0) reachableBusinesses.add((currentBusiness.getName()));
        // Continue checking for subsequent businesses
        currentBusiness.getNearbyBusinesses().forEach((key, value) -> {
            reachableBusinessesDFS(key, reachableBusinesses, currentDistance + value, maxDistance);
        });
    }

    /* BFS SOLUTION */
    public static List<String> findReachableBusinesses2(Business startingBusiness, int distance) {
        // Fill with initial distance info
        Map<String, Integer> distanceMap = new HashMap<>();
        distanceMap.put(startingBusiness.getName(), 0);
        // Create the business queue and initialize with the starting business
        Queue<Business> businessQueue = new LinkedList<>();
        businessQueue.add(startingBusiness);
        // Iterate all businesses within range
        Business currentBusiness;
        int currentDistance;
        while (!businessQueue.isEmpty()) {
            currentBusiness = businessQueue.poll();
            // Make it final to have it within the lambda to avoid polling every time
            currentDistance= distanceMap.getOrDefault(currentBusiness.getName(), 0);
            // Iterate connections and expand if possible
            for (Map.Entry<Business, Integer> entry : currentBusiness.getNearbyBusinesses().entrySet()) {
                if (currentDistance + entry.getValue() <= distance) {
                    businessQueue.add(entry.getKey());
                    distanceMap.put(entry.getKey().getName(), currentDistance + entry.getValue());
                }
            }
        }
        return new ArrayList<>(distanceMap.keySet());
    }
}