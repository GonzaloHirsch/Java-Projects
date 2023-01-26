package interviewProblems.Advent_Of_Code_2022.Day_18.Part_1;
public class Solution {
    public int findSurface(String input) {
        // Compute the coordinates
        char[][] coordinates = this.getCoordinates(input);
        // Store the hidden sides
        char[] hiddenSides = new char[coordinates.length];
        int total = 0;
        for (int i = 0; i < coordinates.length; i++) {
            for (int j = i + 1; j < coordinates.length; j++) {
                if (computeDistance(coordinates[i], coordinates[j]) <= 1) {
                    hiddenSides[i]++;
                    hiddenSides[j]++;
                }
            }
            total += (6 - hiddenSides[i]);
        }
        return total;
    }

    private int computeDistance(char[] a, char[] b) {
        return Math.abs(a[0] - b[0]) + Math.abs(a[1] - b[1]) + Math.abs(a[2] - b[2]);
    }

    private char[][] getCoordinates(String input) {
        String[] lines = input.split("\n"), numbers;
        char[][] res = new char[lines.length][3];
        for (int i = 0; i < lines.length; i++) {
            numbers = lines[i].split(",");
            for (int j = 0; j < res[0].length; j++) res[i][j] = (char)Integer.parseInt(numbers[j]);
        }
        return res;
    }
}