package interviewProblems.Advent_Of_Code_2022.Day_5.Part_2;

// ---------------------------------- SOLVED ----------------------------------
// --------------------------- NONE / December 2022 ---------------------------

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Original problem: https://adventofcode.com/2022/day/5#part2
 * As you watch the crane operator expertly rearrange the crates, you notice the process isn't following your prediction.
 * <p>
 * Some mud was covering the writing on the side of the crane, and you quickly wipe it away. The crane isn't a CrateMover 9000 - it's a CrateMover 9001.
 * <p>
 * The CrateMover 9001 is notable for many new and exciting features: air conditioning, leather seats, an extra cup holder, and the ability to pick up and move multiple crates at once.
 * <p>
 * Again considering the example above, the crates begin in the same configuration:
 * <p>
 * [D]
 * [N] [C]
 * [Z] [M] [P]
 * 1   2   3
 * Moving a single crate from stack 2 to stack 1 behaves the same as before:
 * <p>
 * [D]
 * [N] [C]
 * [Z] [M] [P]
 * 1   2   3
 * However, the action of moving three crates from stack 1 to stack 3 means that those three moved crates stay in the same order, resulting in this new configuration:
 * <p>
 * [D]
 * [N]
 * [C] [Z]
 * [M] [P]
 * 1   2   3
 * Next, as both crates are moved from stack 2 to stack 1, they retain their order as well:
 * <p>
 * [D]
 * [N]
 * [C]     [Z]
 * [M]     [P]
 * 1   2   3
 * Finally, a single crate is still moved from stack 1 to stack 2, but now it's crate C that gets moved:
 * <p>
 * [D]
 * [N]
 * [Z]
 * [M] [C] [P]
 * 1   2   3
 * In this example, the CrateMover 9001 has put the crates in a totally different order: MCD.
 * <p>
 * Before the rearrangement process finishes, update your simulation so that the Elves know where they should stand to be ready to unload the final supplies. After the rearrangement procedure completes, what crate ends up on top of each stack?
 */
class Main {
    public static void main(String[] args) {
        String input = "    [D]    \n" + "[N] [C]    \n" + "[Z] [M] [P]\n" + " 1   2   3 \n" + "\n" + "move 1 from 2 to 1\n" + "move 3 from 1 to 3\n" + "move 2 from 2 to 1\n" + "move 1 from 1 to 2";
        Solution sol = new Solution();
        System.out.println(sol.getOutcome(generateStacks(input), generateInstructions(input)));
        input = "[T]     [Q]             [S]        \n" + "[R]     [M]             [L] [V] [G]\n" + "[D] [V] [V]             [Q] [N] [C]\n" + "[H] [T] [S] [C]         [V] [D] [Z]\n" + "[Q] [J] [D] [M]     [Z] [C] [M] [F]\n" + "[N] [B] [H] [N] [B] [W] [N] [J] [M]\n" + "[P] [G] [R] [Z] [Z] [C] [Z] [G] [P]\n" + "[B] [W] [N] [P] [D] [V] [G] [L] [T]\n" + " 1   2   3   4   5   6   7   8   9 \n" + "\n" + "move 5 from 4 to 9\n" + "move 3 from 5 to 1\n" + "move 12 from 9 to 6\n" + "move 1 from 6 to 9\n" + "move 3 from 2 to 8\n" + "move 6 from 3 to 9\n" + "move 2 from 2 to 9\n" + "move 2 from 3 to 5\n" + "move 9 from 8 to 1\n" + "move 1 from 6 to 9\n" + "move 1 from 8 to 3\n" + "move 14 from 1 to 2\n" + "move 8 from 2 to 6\n" + "move 2 from 2 to 7\n" + "move 2 from 5 to 8\n" + "move 5 from 2 to 6\n" + "move 9 from 7 to 8\n" + "move 1 from 9 to 8\n" + "move 5 from 6 to 9\n" + "move 1 from 3 to 8\n" + "move 1 from 7 to 5\n" + "move 1 from 1 to 5\n" + "move 4 from 1 to 7\n" + "move 15 from 6 to 1\n" + "move 4 from 7 to 6\n" + "move 2 from 5 to 7\n" + "move 9 from 8 to 7\n" + "move 13 from 1 to 3\n" + "move 8 from 6 to 9\n" + "move 1 from 6 to 8\n" + "move 1 from 7 to 5\n" + "move 2 from 1 to 3\n" + "move 4 from 7 to 1\n" + "move 13 from 3 to 6\n" + "move 2 from 1 to 3\n" + "move 1 from 5 to 8\n" + "move 2 from 3 to 4\n" + "move 5 from 7 to 1\n" + "move 4 from 1 to 9\n" + "move 2 from 4 to 5\n" + "move 4 from 6 to 2\n" + "move 3 from 2 to 5\n" + "move 6 from 8 to 1\n" + "move 7 from 6 to 7\n" + "move 1 from 3 to 5\n" + "move 1 from 2 to 4\n" + "move 8 from 1 to 8\n" + "move 4 from 6 to 2\n" + "move 3 from 5 to 3\n" + "move 1 from 4 to 3\n" + "move 2 from 1 to 3\n" + "move 8 from 8 to 5\n" + "move 2 from 3 to 8\n" + "move 4 from 5 to 3\n" + "move 1 from 9 to 2\n" + "move 1 from 8 to 3\n" + "move 1 from 2 to 1\n" + "move 15 from 9 to 3\n" + "move 6 from 7 to 5\n" + "move 1 from 7 to 3\n" + "move 2 from 2 to 8\n" + "move 6 from 9 to 4\n" + "move 22 from 3 to 6\n" + "move 3 from 8 to 6\n" + "move 1 from 1 to 2\n" + "move 2 from 9 to 8\n" + "move 6 from 4 to 7\n" + "move 6 from 7 to 2\n" + "move 16 from 6 to 9\n" + "move 8 from 2 to 1\n" + "move 4 from 6 to 1\n" + "move 2 from 3 to 4\n" + "move 9 from 5 to 4\n" + "move 1 from 7 to 9\n" + "move 1 from 6 to 2\n" + "move 3 from 5 to 7\n" + "move 16 from 9 to 4\n" + "move 2 from 7 to 1\n" + "move 4 from 6 to 3\n" + "move 1 from 9 to 5\n" + "move 1 from 9 to 7\n" + "move 1 from 7 to 6\n" + "move 1 from 7 to 9\n" + "move 2 from 9 to 2\n" + "move 1 from 6 to 1\n" + "move 2 from 8 to 1\n" + "move 11 from 4 to 2\n" + "move 9 from 2 to 6\n" + "move 9 from 6 to 1\n" + "move 15 from 4 to 6\n" + "move 1 from 4 to 2\n" + "move 1 from 5 to 3\n" + "move 6 from 6 to 4\n" + "move 3 from 2 to 1\n" + "move 2 from 4 to 6\n" + "move 3 from 6 to 2\n" + "move 7 from 6 to 2\n" + "move 1 from 4 to 7\n" + "move 1 from 7 to 2\n" + "move 5 from 3 to 6\n" + "move 1 from 5 to 4\n" + "move 1 from 4 to 5\n" + "move 8 from 1 to 6\n" + "move 1 from 4 to 8\n" + "move 12 from 6 to 1\n" + "move 1 from 3 to 4\n" + "move 1 from 4 to 1\n" + "move 1 from 3 to 4\n" + "move 2 from 6 to 5\n" + "move 31 from 1 to 7\n" + "move 2 from 5 to 7\n" + "move 1 from 8 to 2\n" + "move 1 from 5 to 8\n" + "move 1 from 8 to 6\n" + "move 3 from 4 to 9\n" + "move 3 from 9 to 4\n" + "move 2 from 4 to 3\n" + "move 2 from 1 to 6\n" + "move 2 from 3 to 8\n" + "move 1 from 4 to 9\n" + "move 4 from 2 to 9\n" + "move 17 from 7 to 8\n" + "move 3 from 8 to 2\n" + "move 2 from 9 to 4\n" + "move 4 from 2 to 5\n" + "move 1 from 1 to 4\n" + "move 1 from 9 to 3\n" + "move 8 from 8 to 4\n" + "move 1 from 9 to 4\n" + "move 4 from 8 to 3\n" + "move 8 from 2 to 5\n" + "move 2 from 2 to 3\n" + "move 1 from 2 to 1\n" + "move 1 from 8 to 4\n" + "move 2 from 8 to 1\n" + "move 1 from 7 to 2\n" + "move 1 from 8 to 6\n" + "move 3 from 4 to 5\n" + "move 8 from 4 to 7\n" + "move 1 from 2 to 8\n" + "move 1 from 8 to 1\n" + "move 2 from 4 to 7\n" + "move 8 from 5 to 9\n" + "move 7 from 5 to 2\n" + "move 6 from 3 to 1\n" + "move 6 from 1 to 2\n" + "move 9 from 9 to 4\n" + "move 5 from 7 to 4\n" + "move 2 from 1 to 2\n" + "move 9 from 4 to 2\n" + "move 3 from 6 to 2\n" + "move 1 from 6 to 8\n" + "move 1 from 8 to 9\n" + "move 1 from 3 to 5\n" + "move 6 from 7 to 5\n" + "move 4 from 4 to 2\n" + "move 19 from 2 to 3\n" + "move 1 from 4 to 6\n" + "move 7 from 7 to 5\n" + "move 2 from 1 to 8\n" + "move 12 from 3 to 4\n" + "move 3 from 4 to 1\n" + "move 1 from 6 to 3\n" + "move 8 from 5 to 9\n" + "move 3 from 9 to 7\n" + "move 6 from 4 to 3\n" + "move 3 from 1 to 2\n" + "move 13 from 3 to 7\n" + "move 3 from 4 to 6\n" + "move 4 from 9 to 4\n" + "move 14 from 7 to 8\n" + "move 3 from 5 to 2\n" + "move 3 from 2 to 6\n" + "move 1 from 6 to 2\n" + "move 1 from 3 to 9\n" + "move 4 from 4 to 6\n" + "move 11 from 2 to 7\n" + "move 2 from 9 to 6\n" + "move 3 from 5 to 6\n" + "move 1 from 9 to 7\n" + "move 14 from 6 to 5\n" + "move 1 from 5 to 1\n" + "move 4 from 5 to 8\n" + "move 2 from 5 to 6\n" + "move 4 from 2 to 5\n" + "move 1 from 2 to 9\n" + "move 14 from 8 to 5\n" + "move 2 from 8 to 4\n" + "move 3 from 8 to 7\n" + "move 5 from 5 to 4\n" + "move 13 from 5 to 7\n" + "move 5 from 7 to 6\n" + "move 31 from 7 to 9\n" + "move 7 from 6 to 7\n" + "move 6 from 5 to 7\n" + "move 1 from 8 to 9\n" + "move 1 from 5 to 3\n" + "move 1 from 3 to 5\n" + "move 1 from 1 to 8\n" + "move 6 from 4 to 3\n" + "move 1 from 8 to 5\n" + "move 1 from 4 to 1\n" + "move 33 from 9 to 3\n" + "move 13 from 7 to 1\n" + "move 29 from 3 to 2\n" + "move 3 from 3 to 8\n" + "move 1 from 5 to 2\n" + "move 20 from 2 to 6\n" + "move 19 from 6 to 4\n" + "move 1 from 7 to 4\n" + "move 5 from 1 to 7\n" + "move 1 from 8 to 7\n" + "move 2 from 8 to 5\n" + "move 10 from 2 to 8\n" + "move 6 from 3 to 9\n" + "move 4 from 7 to 1\n" + "move 1 from 3 to 5\n" + "move 1 from 1 to 2\n" + "move 1 from 7 to 6\n" + "move 1 from 2 to 8\n" + "move 1 from 8 to 7\n" + "move 4 from 9 to 7\n" + "move 2 from 5 to 2\n" + "move 1 from 8 to 5\n" + "move 1 from 8 to 6\n" + "move 7 from 8 to 3\n" + "move 2 from 9 to 4\n" + "move 3 from 5 to 1\n" + "move 2 from 2 to 5\n" + "move 5 from 7 to 8\n" + "move 10 from 4 to 1\n" + "move 5 from 8 to 5\n" + "move 10 from 1 to 3\n" + "move 2 from 6 to 4\n" + "move 1 from 7 to 3\n" + "move 1 from 8 to 1\n" + "move 3 from 5 to 8\n" + "move 12 from 4 to 7\n" + "move 3 from 5 to 3\n" + "move 16 from 1 to 7\n" + "move 2 from 3 to 7\n" + "move 1 from 5 to 6\n" + "move 3 from 8 to 4\n" + "move 1 from 4 to 7\n" + "move 1 from 6 to 3\n" + "move 14 from 3 to 1\n" + "move 5 from 3 to 8\n" + "move 1 from 3 to 5\n" + "move 1 from 7 to 6\n" + "move 1 from 6 to 2\n" + "move 13 from 7 to 2\n" + "move 1 from 5 to 3\n" + "move 3 from 4 to 2\n" + "move 1 from 3 to 5\n" + "move 3 from 8 to 9\n" + "move 2 from 8 to 9\n" + "move 1 from 6 to 4\n" + "move 5 from 2 to 4\n" + "move 3 from 2 to 5\n" + "move 7 from 7 to 3\n" + "move 7 from 4 to 7\n" + "move 5 from 3 to 7\n" + "move 8 from 2 to 3\n" + "move 5 from 9 to 5\n" + "move 11 from 1 to 9\n" + "move 4 from 3 to 1\n" + "move 1 from 2 to 7\n" + "move 4 from 1 to 7\n" + "move 22 from 7 to 3\n" + "move 5 from 3 to 4\n" + "move 1 from 7 to 1\n" + "move 1 from 1 to 4\n" + "move 3 from 4 to 6\n" + "move 3 from 1 to 3\n" + "move 2 from 6 to 1\n" + "move 2 from 4 to 9\n" + "move 13 from 9 to 1\n" + "move 1 from 6 to 5\n" + "move 4 from 7 to 1\n" + "move 3 from 1 to 6\n" + "move 19 from 3 to 9\n" + "move 5 from 3 to 1\n" + "move 18 from 9 to 8\n" + "move 1 from 9 to 3\n" + "move 11 from 1 to 7\n" + "move 1 from 4 to 5\n" + "move 13 from 8 to 1\n" + "move 7 from 5 to 8\n" + "move 7 from 8 to 5\n" + "move 3 from 6 to 5\n" + "move 2 from 3 to 9\n" + "move 1 from 3 to 7\n" + "move 5 from 5 to 2\n" + "move 10 from 1 to 5\n" + "move 9 from 7 to 9\n" + "move 11 from 5 to 2\n" + "move 2 from 8 to 4\n" + "move 1 from 4 to 3\n" + "move 2 from 7 to 3\n" + "move 1 from 7 to 4\n" + "move 3 from 8 to 3\n" + "move 8 from 5 to 2\n" + "move 2 from 3 to 8\n" + "move 4 from 3 to 8\n" + "move 6 from 2 to 6\n" + "move 5 from 1 to 8\n" + "move 8 from 2 to 7\n" + "move 2 from 4 to 7\n" + "move 9 from 2 to 9\n" + "move 4 from 7 to 8\n" + "move 5 from 1 to 8\n" + "move 3 from 7 to 4\n" + "move 1 from 8 to 3\n" + "move 3 from 7 to 2\n" + "move 3 from 1 to 9\n" + "move 1 from 4 to 9\n" + "move 1 from 6 to 3\n" + "move 18 from 8 to 5\n" + "move 1 from 8 to 2\n" + "move 2 from 4 to 9\n" + "move 3 from 2 to 1\n" + "move 2 from 2 to 3\n" + "move 24 from 9 to 8\n" + "move 3 from 3 to 7\n" + "move 15 from 8 to 2\n" + "move 12 from 2 to 5\n" + "move 1 from 7 to 4\n" + "move 1 from 3 to 1\n" + "move 28 from 5 to 4\n" + "move 1 from 7 to 9\n" + "move 2 from 2 to 1\n" + "move 4 from 6 to 3\n" + "move 1 from 5 to 3\n" + "move 1 from 5 to 9\n" + "move 1 from 2 to 6\n" + "move 5 from 3 to 5\n" + "move 8 from 4 to 2\n" + "move 2 from 6 to 2\n" + "move 1 from 7 to 3\n" + "move 4 from 2 to 8\n" + "move 3 from 1 to 2\n" + "move 5 from 2 to 5\n" + "move 3 from 5 to 4\n" + "move 2 from 1 to 5\n" + "move 2 from 2 to 1\n" + "move 4 from 9 to 2\n" + "move 7 from 8 to 9\n" + "move 1 from 3 to 1\n" + "move 1 from 1 to 7\n" + "move 2 from 8 to 3\n" + "move 4 from 9 to 3\n" + "move 9 from 5 to 7\n" + "move 3 from 3 to 5\n" + "move 1 from 5 to 3\n" + "move 7 from 7 to 9\n" + "move 1 from 7 to 9\n" + "move 1 from 5 to 9\n" + "move 1 from 5 to 1\n" + "move 1 from 8 to 5\n" + "move 9 from 9 to 1\n" + "move 2 from 7 to 2\n" + "move 1 from 5 to 6\n" + "move 4 from 3 to 2\n" + "move 11 from 2 to 4\n" + "move 1 from 8 to 4\n" + "move 1 from 8 to 2\n" + "move 1 from 2 to 8\n" + "move 1 from 6 to 5\n" + "move 1 from 8 to 6\n" + "move 6 from 1 to 7\n" + "move 1 from 5 to 6\n" + "move 1 from 6 to 5\n" + "move 3 from 9 to 8\n" + "move 3 from 8 to 1\n" + "move 3 from 7 to 8\n" + "move 1 from 6 to 9\n" + "move 1 from 2 to 4\n" + "move 1 from 9 to 7\n" + "move 2 from 7 to 9\n" + "move 10 from 1 to 6\n" + "move 2 from 9 to 3\n" + "move 1 from 5 to 7\n" + "move 3 from 7 to 5\n" + "move 3 from 5 to 3\n" + "move 4 from 6 to 3\n" + "move 18 from 4 to 2\n" + "move 3 from 4 to 1\n" + "move 1 from 1 to 3\n" + "move 2 from 1 to 2\n" + "move 8 from 2 to 9\n" + "move 1 from 4 to 7\n" + "move 1 from 7 to 1\n" + "move 3 from 9 to 2\n" + "move 3 from 8 to 6\n" + "move 1 from 4 to 9\n" + "move 7 from 2 to 8\n" + "move 7 from 6 to 7\n" + "move 3 from 9 to 2\n" + "move 3 from 2 to 5\n" + "move 6 from 4 to 6\n" + "move 2 from 5 to 6\n" + "move 3 from 3 to 6\n" + "move 6 from 6 to 3\n" + "move 5 from 7 to 5\n" + "move 2 from 4 to 8\n" + "move 5 from 5 to 2\n" + "move 1 from 7 to 2\n" + "move 4 from 6 to 4\n" + "move 1 from 7 to 8\n" + "move 1 from 6 to 4\n" + "move 1 from 5 to 7\n" + "move 1 from 3 to 4\n" + "move 1 from 6 to 4\n" + "move 2 from 9 to 1\n" + "move 3 from 1 to 3\n" + "move 1 from 3 to 1\n" + "move 9 from 2 to 1\n" + "move 8 from 1 to 5\n" + "move 1 from 7 to 1\n" + "move 1 from 9 to 1\n" + "move 4 from 5 to 7\n" + "move 4 from 7 to 5\n" + "move 1 from 1 to 9\n" + "move 5 from 2 to 4\n" + "move 1 from 9 to 6\n" + "move 8 from 8 to 9\n" + "move 18 from 4 to 9\n" + "move 3 from 5 to 4\n" + "move 2 from 6 to 5\n" + "move 1 from 8 to 5\n" + "move 17 from 9 to 6\n" + "move 2 from 8 to 1\n" + "move 1 from 4 to 6\n" + "move 8 from 6 to 3\n" + "move 1 from 1 to 8\n" + "move 5 from 5 to 3\n" + "move 1 from 1 to 7\n" + "move 1 from 8 to 6\n" + "move 2 from 4 to 5\n" + "move 6 from 9 to 4\n" + "move 1 from 7 to 5\n" + "move 7 from 6 to 8\n" + "move 2 from 6 to 5\n" + "move 6 from 8 to 3\n" + "move 1 from 9 to 6\n" + "move 2 from 9 to 5\n" + "move 1 from 3 to 1\n" + "move 1 from 8 to 6\n" + "move 7 from 5 to 6\n" + "move 7 from 6 to 7\n" + "move 5 from 4 to 9\n" + "move 1 from 4 to 5\n" + "move 2 from 9 to 6\n" + "move 3 from 1 to 7\n" + "move 5 from 6 to 8\n" + "move 1 from 1 to 5\n" + "move 21 from 3 to 6\n" + "move 3 from 7 to 2\n" + "move 2 from 9 to 3\n" + "move 1 from 9 to 7\n" + "move 5 from 5 to 7\n" + "move 7 from 6 to 7\n" + "move 14 from 7 to 1\n" + "move 3 from 2 to 8\n" + "move 12 from 1 to 4\n" + "move 5 from 7 to 6\n" + "move 1 from 7 to 4\n" + "move 8 from 8 to 3\n" + "move 8 from 3 to 5\n" + "move 6 from 5 to 6\n" + "move 1 from 5 to 3\n" + "move 2 from 1 to 8\n" + "move 2 from 8 to 3\n" + "move 10 from 3 to 7\n" + "move 8 from 4 to 3\n" + "move 3 from 4 to 9\n" + "move 3 from 9 to 2\n" + "move 1 from 2 to 5\n" + "move 2 from 2 to 9\n" + "move 13 from 3 to 1\n" + "move 1 from 4 to 1\n" + "move 2 from 1 to 7\n" + "move 1 from 5 to 8\n" + "move 1 from 9 to 6\n" + "move 1 from 9 to 2\n" + "move 1 from 4 to 9\n" + "move 8 from 6 to 2\n" + "move 1 from 9 to 5\n" + "move 1 from 2 to 8\n" + "move 1 from 5 to 9\n" + "move 2 from 2 to 3\n" + "move 12 from 6 to 8\n" + "move 1 from 3 to 7\n" + "move 8 from 8 to 4\n" + "move 1 from 9 to 1\n" + "move 13 from 1 to 3\n" + "move 2 from 4 to 5\n" + "move 12 from 7 to 2\n" + "move 1 from 5 to 8\n" + "move 3 from 3 to 8\n" + "move 2 from 4 to 1\n" + "move 1 from 1 to 9";
        System.out.println(sol.getOutcome(generateStacks(input), generateInstructions(input)));
    }

    private static List<int[]> generateInstructions(String input) {
        String[] parts = input.split("\n"), sections;
        List<int[]> result = new ArrayList<>();
        for (String part : parts) {
            // Part of an instruction
            if (part.contains("move")) {
                sections = part.split(" ");
                result.add(new int[]{Integer.parseInt(sections[1]), Integer.parseInt(sections[3]), Integer.parseInt(sections[5])});
            }
        }
        return result;
    }

    private static List<Stack<Character>> generateStacks(String input) {
        String[] parts = input.split("\n");
        // Iterate first line to find the number of stacks
        int totalStacks = parts[0].length() / 4 + 1, i = 0;
        List<Stack<Character>> stacks = new ArrayList<>();
        // Fill the stacks
        for (int j = 0; j < totalStacks; j++) stacks.add(new Stack<>());
        // Look for the instructions
        for (; i < parts.length && !parts[i].contains("move"); i++) ;
        i -= 2;
        // Iterate backwards to build the stack
        char[] line;
        for (; i >= 0; i--) {
            line = parts[i].toCharArray();
            for (int j = 1; j < line.length; j += 4) {
                // Not empty, add to the stack
                if (line[j] != ' ') stacks.get(j / 4).push(line[j]);
            }
        }
        return stacks;
    }
}