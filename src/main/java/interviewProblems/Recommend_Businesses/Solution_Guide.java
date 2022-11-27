package interviewProblems.Recommend_Businesses;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Business class that consists of a business name and a hashmap of nearby businesses.
 */
class Businesses_Guide {
    /**
     * The name of the business.
     */
    String name;

    /**
     * A Map of nearbyBusinesses where the key is the nearby Business object
     * and the value is distance from the current Business to the nearby Business.
     */
    Map<Businesses_Guide, Integer> nearbyBusinesses;

    public Businesses_Guide(String name) {
        this.name = name;
        this.nearbyBusinesses = new HashMap<>();
    }

    public String getName() {
        return this.name;
    }

    public Map<Businesses_Guide, Integer> getNearbyBusinesses() {
        return this.nearbyBusinesses;
    }
}

// Note: This is the input they give you, along with the business class
class Solution_Guide {
    public static List<String> findReachableBusinesses(Businesses_Guide startingBusiness, int distance) {
        // todo
        return null;
    }
}