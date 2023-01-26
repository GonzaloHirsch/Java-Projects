package interviewProblems.Advent_Of_Code_2022.Day_9.Part_1;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public int computePositions(String input) {
        String[] steps = input.split("\n"), directions;
        int amount;

        // Storing the result
        Set<String> positions = new HashSet<>();
        positions.add("0-0");

        // Creating the references
        Node head = new Node(), tail = new Node();

        // Simulate everything
        for (String step : steps) {
            // Get direction and amount
            directions = step.split(" ");
            amount = Integer.parseInt(directions[1]);
            // Simulate
            for (int i = 0; i < amount; i++) {
                // Move head
                head.move(directions[0]);
                // Check if tail needs to be moved and move it
                if (this.shouldCarry(head, tail)) {
                    tail.x += (head.x - tail.x > 0 ? Math.min(1, head.x - tail.x) : Math.max(-1, head.x - tail.x));
                    tail.y += (head.y - tail.y > 0 ? Math.min(1, head.y - tail.y) : Math.max(-1, head.y - tail.y));
                }
                // Add to positions
                positions.add(tail.getCoordinates());
            }
        }

        return positions.size();
    }

    private boolean shouldCarry(Node head, Node tail) {
        return Math.abs(head.x - tail.x) > 1 || Math.abs(head.y - tail.y) > 1;
    }

    public class Node {
        int x = 0, y = 0;
        public void move(String direction) {
            switch (direction) {
                case "U":
                    this.y += 1;
                    break;
                case "D":
                    this.y -= 1;
                    break;
                case "L":
                    this.x -= 1;
                    break;
                case "R":
                    this.x += 1;
                    break;
            }
        }

        public String getCoordinates() {
            return this.x + "-" + this.y;
        }
    }
}