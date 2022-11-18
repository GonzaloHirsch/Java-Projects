package interviewProblems.Design_Underground_System;

import java.util.AbstractMap;
import java.util.HashMap;
import java.util.Map;


class UndergroundSystem_Alt {
    private Map<Integer, Trip> users;
    private Map<String, Stat> stats;
    private Trip trip;
    private Stat stat;

    public UndergroundSystem_Alt() {
        this.users = new HashMap<>();
        this.stats = new HashMap<>();
    }

    public void checkIn(int id, String stationName, int t) {
        // Just create a new trip and replace it
        this.trip = new Trip(t, stationName);
        this.users.put(id, this.trip);
    }

    public void checkOut(int id, String stationName, int t) {
        // Get the trip and stats
        this.trip = this.users.get(id);
        this.stat = this.stats.getOrDefault(this.getStatKey(this.trip.from, stationName), new Stat());
        // End the trip
        int time = this.trip.endTrip(t);
        // Add the trip to the stats
        this.stat.addTrip(time);
        // Store the stat
        this.stats.put(this.getStatKey(this.trip.from, stationName), this.stat);
    }

    public double getAverageTime(String startStation, String endStation) {
        this.stat = this.stats.get(this.getStatKey(startStation, endStation));
        return this.stat.getAverage();
    }

    private String getStatKey(String start, String end) {
        return start + "____" + end;
    }

    class Trip {
        public int startTime;
        public String from;
        public Trip(int time, String from) {
            this.startTime = time;
            this.from = from;
        }
        public int endTrip(int time) {
            return time - this.startTime;
        }
    }

    class Stat {
        public long totalTime = 0;
        public int times = 0;
        public void addTrip(int time) {
            this.totalTime += time;
            this.times++;
        }
        public double getAverage(){
            return this.totalTime / (double)this.times;
        }
    }
}

/**
 * Your UndergroundSystem object will be instantiated and called as such:
 * UndergroundSystem obj = new UndergroundSystem();
 * obj.checkIn(id,stationName,t);
 * obj.checkOut(id,stationName,t);
 * double param_3 = obj.getAverageTime(startStation,endStation);
 */
