package interviewProblems.Advent_Of_Code_2022.Day_15.Part_1;

import java.util.*;

public class Solution {
    public int findBeaconOverlap(String input, int targetY) {
        // Queues for testing with existing ranges
        Queue<int[]> pendingRanges = new LinkedList<>();
        List<int[]> freeRanges = new ArrayList<>(), freePendingRanges = new ArrayList<>();
        // Compute the ranges
        Configuration config = this.computeConfig(input, targetY);
        int[][] ranges = config.ranges;
        int[] found, overlap, curr;
        boolean hasOverlap = false;
        // Check which ones overlap with Y
        for (int[] range : ranges) {
            // If the range does overlap with the target Y
            if (this.yOverlaps(range, targetY)) {
                // Compute overlapping range and add to processing queue
                found = this.computeOverlap(range, targetY);
                pendingRanges.add(found);
                // Iterate ranges and combine
                while (!pendingRanges.isEmpty()) {
                    // Get current range
                    curr = pendingRanges.poll();
                    // Compare with existing ranges and remove overlaps
                    for (int[] freeRange : freeRanges) {
                        overlap = this.rangeOverlap(freeRange, curr);
                        // Ranges do overlap, trim the overlap
                        if (overlap[0] <= overlap[1]) {
                            hasOverlap = true;
                            if (curr[0] < overlap[0]) pendingRanges.add(new int[]{curr[0], overlap[0] - 1});
                            if (curr[1] > overlap[1]) pendingRanges.add(new int[]{overlap[1] + 1, curr[1]});
                            break;
                        }
                    }
                    // Check if no overlap
                    if (!hasOverlap) freePendingRanges.add(curr);
                    hasOverlap = false;
                }
                freeRanges.addAll(freePendingRanges);
                freePendingRanges.clear();
            }
        }
        return this.computeTotalLength(freeRanges, config.beacons);
    }

    private int computeTotalLength(List<int[]> ranges, Set<Integer> beacons) {
        int total = 0;
        for (int[] range : ranges) {
            total += (range[1] - range[0] + 1);
            for (int beacon : beacons) if (range[0] <= beacon && beacon <= range[1]) total--;
        }
        return total;
    }

    private int[] rangeOverlap(int[] r1, int[] r2) {
        return new int[]{Math.max(r1[0], r2[0]), Math.min(r1[1], r2[1])};
    }

    private boolean yOverlaps(int[] range, int targetY) {
        return range[1] - range[2] <= targetY && range[1] + range[2] >= targetY;
    }

    private int[] computeOverlap(int[] range, int targetY) {
        int diff = range[2] - Math.abs(range[1] - targetY);
        return new int[]{range[0] - diff, range[0] + diff};
    }

    // Compute ranges in format [x, y, range]
    private Configuration computeConfig(String input, int targetY) {
        Configuration config = new Configuration();
        String[] scanners = input.split("\n"), parts;
        int[][] ranges = new int[scanners.length][3];
        Set<Integer> beacons = new HashSet<>();
        for (int i = 0, x, y; i < scanners.length; i++) {
            parts = scanners[i].replace(": closest beacon is at ", " ").replaceAll(", ", " ").replace("Sensor at ", "").split(" ");
            ranges[i][0] = Integer.parseInt(parts[0].split("=")[1]);
            ranges[i][1] = Integer.parseInt(parts[1].split("=")[1]);
            x = Integer.parseInt(parts[2].split("=")[1]);
            y = Integer.parseInt(parts[3].split("=")[1]);
            ranges[i][2] = Math.abs(ranges[i][0] - x) + Math.abs(ranges[i][1] - y);
            if (y == targetY) beacons.add(x);
        }
        config.ranges = ranges;
        config.beacons = beacons;
        return config;
    }

    private class Configuration {
        int[][] ranges;
        Set<Integer> beacons;
    }
}