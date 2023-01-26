package interviewProblems.Advent_Of_Code_2022.Day_9.Part_2;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public int computePositions(String input, int knotCount) {
        String[] steps = input.split("\n"), directions;
        int amount;

        // Storing the result
        Set<String> positions = new HashSet<>();
        positions.add("0-0");

        // Creating the references, the head is 0, tail is the end
        Node[] knots = new Node[knotCount];
        for (int i = 0; i < knots.length; i++) knots[i] = new Node();

        // Simulate everything
        for (String step : steps) {
            // Get direction and amount
            directions = step.split(" ");
            amount = Integer.parseInt(directions[1]);
            // Simulate
            for (int i = 0; i < amount; i++) {
                // Move head
                knots[0].move(directions[0]);
                // Check if tail needs to be moved and move it
                for (int j = 1; j < knots.length; j++) {
                    if (this.shouldCarry(knots[j - 1], knots[j])) {
                        knots[j].x += (knots[j - 1].x - knots[j].x > 0 ? Math.min(1, knots[j - 1].x - knots[j].x) : Math.max(-1, knots[j - 1].x - knots[j].x));
                        knots[j].y += (knots[j - 1].y - knots[j].y > 0 ? Math.min(1, knots[j - 1].y - knots[j].y) : Math.max(-1, knots[j - 1].y - knots[j].y));
                    }
                }
                // Add to positions
                positions.add(knots[knots.length - 1].getCoordinates());
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