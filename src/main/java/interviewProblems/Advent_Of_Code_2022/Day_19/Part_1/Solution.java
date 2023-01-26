package interviewProblems.Advent_Of_Code_2022.Day_19.Part_1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    private int max = 0;
    private Map<String, Integer> memo;

    public int findScores(String input, int limit) {
        // Generate the blueprints
        List<Blueprint> blueprints = this.generateBlueprints(input);

        // Iterate and compute
        int total = 0;
        for (Blueprint print : blueprints) {
            this.max = 0;
            this.memo = new HashMap<>();
            this.computeBlueprintScore(print, new int[4], new int[]{1,0,0,0}, 1, limit);
            total += (print.id * this.max);
        }
        return total;
    }

    private void computeBlueprintScore(Blueprint b, int[] resources, int[] robots, int time, int limit) {
        // Reached the limit
        if (time > limit) {
            this.max = Math.max(resources[3], this.max);
            return;
        }
        // Check if in memo
        //if (this.memo.getOrDefault(b.generateKey(time), -1) >= b.getGeode()) return;
        //this.memo.put(b.generateKey(time), b.getGeode());
        // Attempt to build a new robot if it can be afforded
        for (int i = robots.length - 1; i >= 0; i--) {
            // Not worth creating more robots
            if (b.robotLimits[i] <= robots[i]) continue;
            if (b.canAfford(i, resources)) {
                int[] resourcesCopy = resources.clone(), robotsCopy = robots.clone();
                // Count resources
                for (int r = 0; r < resourcesCopy.length; r++) resourcesCopy[r] += robotsCopy[r];
                for (int r = 0; r < resourcesCopy.length; r++) resourcesCopy[r] -= b.cost[i][r];
                // Increment the robots
                robotsCopy[i]++;
                this.computeBlueprintScore(b, resourcesCopy, robotsCopy, time + 1, limit);
            }
        }
        // Collect the resources, takes 1 min to do that
        for (int r = 0; r < resources.length; r++) resources[r] += robots[r];
        // Not buy any robots after collecting resources
        this.computeBlueprintScore(b, resources, robots, time + 1, limit);
    }

    private List<Blueprint> generateBlueprints(String input) {
        // Input processing
        String[] lines = input.split("\n");
        List<Blueprint> blueprints = new ArrayList<>();

        // Regex for keeping only the numbers
        Pattern p = Pattern.compile("\\d+");
        Matcher m;

        // Generate the data for each blueprint
        Blueprint blueprint;
        for (int i = 0; i < lines.length; i++) {
            // New blueprint instance
            blueprint = new Blueprint(i + 1);
            // Pattern matching
            m = p.matcher(lines[i].split(": ")[1]);
            // Add the costs
            // Ore
            m.find();
            blueprint.cost[0][0] = Integer.parseInt(m.group());
            // Clay
            m.find();
            blueprint.cost[1][0] = Integer.parseInt(m.group());
            // Obsidian
            m.find();
            blueprint.cost[2][0] = Integer.parseInt(m.group());
            m.find();
            blueprint.cost[2][1] = Integer.parseInt(m.group());
            // Geode
            m.find();
            blueprint.cost[3][0] = Integer.parseInt(m.group());
            m.find();
            blueprint.cost[3][2] = Integer.parseInt(m.group());
            // Compute extra info
            blueprint.computeLimits();
            blueprints.add(blueprint);
        }
        return blueprints;
    }

    private static class Blueprint {
        public int id;
        public int[] robotLimits;
        public int[][] cost;
        public Blueprint(int id) {
            this.id = id;
            // Determines the cost of each bot
            this.cost = new int[4][4];
        }
        public boolean canAfford(int robotIndex, int[] resources) {
            for (int i = 0; i < resources.length; i++) if (resources[i] < cost[robotIndex][i]) return false;
            return true;
        }

        public void computeLimits() {
            this.robotLimits = new int[4];
            for (int i = 0; i < robotLimits.length; i++) {
                if (i == robotLimits.length - 1) this.robotLimits[i] = Integer.MAX_VALUE;
                for (int j = 0; j < 4; j++) {
                    this.robotLimits[i] = Math.max(this.robotLimits[i], this.cost[j][i]);
                }
            }
        }
    }
}