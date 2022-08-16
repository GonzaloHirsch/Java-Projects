package interviewProblems.Design_Underground_System;
import java.util.*;


class UndergroundSystem {
    private Map<String, AbstractMap.SimpleEntry<Long, Integer>> stationTimes = new HashMap<>();
    private Map<Integer, AbstractMap.SimpleEntry<String, Integer>> currentTravels = new HashMap<>();

    public UndergroundSystem() {}

    public void checkIn(int id, String stationName, int t) {
        this.currentTravels.put(id, new AbstractMap.SimpleEntry<>(stationName, t));
    }

    public void checkOut(int id, String stationName, int t) {
        // Get the current travel and remove it
        AbstractMap.SimpleEntry<String, Integer> travel = this.currentTravels.get(id);
        int delta = t - travel.getValue();
        this.currentTravels.remove(id);
        // Create the key
        String key = travel.getKey() + "##" + stationName;
        // Get the map with destinations stats
        AbstractMap.SimpleEntry<Long, Integer> travelStats = this.stationTimes.getOrDefault(key, new AbstractMap.SimpleEntry<Long, Integer>(0l, 0));
        // Add the new stats to the station
        this.stationTimes.put(key, new AbstractMap.SimpleEntry<>(travelStats.getKey() + delta, travelStats.getValue() + 1));
    }

    public double getAverageTime(String startStation, String endStation) {
        AbstractMap.SimpleEntry<Long, Integer> travelStats = this.stationTimes.get(startStation + "##" + endStation);
        return (double)travelStats.getKey() / travelStats.getValue();
    }
}

/**
 * Your UndergroundSystem object will be instantiated and called as such:
 * UndergroundSystem obj = new UndergroundSystem();
 * obj.checkIn(id,stationName,t);
 * obj.checkOut(id,stationName,t);
 * double param_3 = obj.getAverageTime(startStation,endStation);
 */