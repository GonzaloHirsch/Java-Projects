package interviewProblems.Advent_Of_Code_2022.Day_16.Part_1;

import java.util.*;
import java.util.stream.Collectors;

public class Solution {
    public Map<String, Integer> cache;
    public int openVents(String input, String start, int time) {
        // Generate the caves and get a list of the ones with positive flows
        List<Cave> caves = this.generateRoutes(this.generateCaves(input), start);
        // Get the starting cave
        Cave startingCave = this.getCave(start, caves);
        this.cache = new HashMap<>();
        return this.dfs(startingCave, time, 0L, 0);
    }

    public List<Cave> generateRoutes(Collection<Cave> caves, String start) {
        // Find caves with positive flow
        List<Cave> interestingCaves = caves.stream().filter(c -> c.valve > 0 || c.name.equals(start)).collect(Collectors.toList());
        // Find cost of moving and opening to other caves
        for (Cave from : interestingCaves) {
            from.connectionsWithCost = new ArrayList<>();
            for (Cave to : interestingCaves) {
                // Check we are not computing the cost of moving to itself
                if (!from.name.equals(to.name)) {
                    from.connectionsWithCost.add(new Route(to, this.findCaveCost(from, to)));
                }
            }
        }
        return interestingCaves;
    }

    // Find path to cave using BFS
    public int findCaveCost(Cave from, Cave to) {
        // Queue for pending nodes
        Queue<Cave> pending = new LinkedList<>();
        pending.add(from);
        // Iterate until we find it
        int size, cost = 0;
        Cave curr;
        while (!pending.isEmpty()) {
            size = pending.size();
            for (int i = 0; i < size; i++) {
                curr = pending.poll();
                if (curr.name.equals(to.name)) return cost + 1;
                pending.addAll(curr.connections);
            }
            cost++;
        }
        return -1;
    }

    public Cave getCave(String name, Collection<Cave> caves) {
        return caves.stream().filter(c -> c.name.equals(name)).findFirst().orElse(null);
    }

    private int dfs(Cave cave, int timeLeft, long state, int flow) {
        // Base case, no more time left
        if (timeLeft == 0) return 0;
        if (this.cache.containsKey(this.generateKey(timeLeft, state, flow))) {
            return this.cache.get(this.generateKey(timeLeft, state, flow));
        }
        int max = 0, val;
        for (Route route : cave.connectionsWithCost) {
            // Check if the target cave is open or not
            if (((state & (1L << route.cave.id)) != 0)) continue;
            // Check if there's time to open it
            if (timeLeft < route.cost) continue;
            val = dfs(route.cave, timeLeft - route.cost, this.setBit(state, route.cave.id), flow + (timeLeft - route.cost) * route.cave.valve) + (timeLeft - route.cost) * route.cave.valve;
            max = Math.max(max, val);
        }
        this.cache.put(this.generateKey(timeLeft, state, max), max);
        return max;
    }

    private String generateKey(int timeLeft, long state, int total) {
        return timeLeft + "-" + state + "-" + total;
    }

    private Collection<Cave> generateCaves(String input) {
        Map<String, Cave> caveMap = new HashMap<>();
        Cave curr, child;

        String[] caves = input.split("\n"), caveData;
        int id = 0;
        for (String cave : caves) {
            // Replace strings to have it easier
            caveData = cave.replace("Valve ", "").replace(" has flow rate=", " ").replace("; tunnels lead to valves ", " ").replace("; tunnel leads to valve ", " ").replaceAll(", ", ",").split(" ");
            // Get the current cave
            curr = caveMap.getOrDefault(caveData[0], new Cave(caveData[0], id));
            curr.id = id++;
            curr.valve = Integer.parseInt(caveData[1]);
            // Add children
            caveData = caveData[2].split(",");
            for (String data : caveData) {
                child = caveMap.getOrDefault(data, new Cave(data, 0));
                curr.connections.add(child);
                caveMap.put(child.name, child);
            }
            // Store back
            caveMap.put(curr.name, curr);
        }

        return caveMap.values();
    }

    private long setBit(long n, int bit) {
        return n | (1L << bit);
    }

    private static class Cave {
        String name;
        int valve;
        int id;
        List<Cave> connections = new ArrayList<>();
        List<Route> connectionsWithCost = new ArrayList<>();
        public Cave (String name, int id) {
            this.name = name;
            this.id = id;
        }
    }

    private static class Route {
        public Cave cave;
        public int cost;
        public Route(Cave cave, int cost) {
            this.cave = cave;
            this.cost = cost;
        }
    }
}