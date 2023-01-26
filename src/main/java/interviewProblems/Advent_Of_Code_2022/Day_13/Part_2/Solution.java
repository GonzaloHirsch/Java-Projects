package interviewProblems.Advent_Of_Code_2022.Day_13.Part_2;

import java.util.*;

public class Solution {
    public int findDividers(List<Main.Node> nodes) {
        nodes.sort((a,b) -> compareList(b,a));
        int total = 1, index = 1;
        for (Main.Node node : nodes) {
            if (node.isDivider) total *= index;
            index++;
        }
        return total;
    }

    private int compareList(Main.Node left, Main.Node right) {
        Main.Node[] nodesL = left.list.toArray(new Main.Node[0]), nodesR = right.list.toArray(new Main.Node[0]);
        int l = 0, r = 0, state = 0;
        while (l < nodesL.length && r < nodesR.length && state == 0) {
            // Get current item for both
            left = nodesL[l];
            right = nodesR[r];
            // Both lists
            if (left.isList && right.isList) {
                state = this.compareList(left, right);
                l++;
                r++;
            }
            // Both numbers
            else if (!left.isList && !right.isList) {
                // If no equal advancement, determine what to do
                if (!(left.val == right.val)) return left.val < right.val ? 1 : -1;
                else {
                    l++;
                    r++;
                }
            }
            // Mixed types
            else {
                // Generate new node
                Main.Node node = new Main.Node(true, Character.MIN_VALUE);
                node.list = new ArrayList<>();
                if (!left.isList) {
                    node.list.add(left);
                    nodesL[l] = node;
                }
                if (!right.isList) {
                    node.list.add(right);
                    nodesR[r] = node;
                }
            }
        }
        return state == 0 ? (l >= nodesL.length && r >= nodesR.length ? 0 : (l >= nodesL.length ? 1 : -1)) : state;
    }
}