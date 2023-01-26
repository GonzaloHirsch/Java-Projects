package interviewProblems.Advent_Of_Code_2022.Day_2.Part_2;

// ---------------------------------- SOLVED ----------------------------------
// --------------------------- NONE / December 2022 ---------------------------

/**
 * Original problem: https://adventofcode.com/2022/day/2#part2
 *
 * The Elf finishes helping with the tent and sneaks back over to you. "Anyway, the second column says how the round needs to end: X means you need to lose, Y means you need to end the round in a draw, and Z means you need to win. Good luck!"
 *
 * The total score is still calculated in the same way, but now you need to figure out what shape to choose so the round ends as indicated. The example above now goes like this:
 *
 * In the first round, your opponent will choose Rock (A), and you need the round to end in a draw (Y), so you also choose Rock. This gives you a score of 1 + 3 = 4.
 * In the second round, your opponent will choose Paper (B), and you choose Rock so you lose (X) with a score of 1 + 0 = 1.
 * In the third round, you will defeat your opponent's Scissors with Rock for a score of 1 + 6 = 7.
 * Now that you're correctly decrypting the ultra top secret strategy guide, you would get a total score of 12.
 *
 * Following the Elf's instructions for the second column, what would your total score be if everything goes exactly according to your strategy guide?
 */
class Main {
    public static void main(String[] args) {
        String input = "A Y\n" + "B X\n" + "C Z";
        Solution sol = new Solution();
        System.out.println(sol.getMaxScore(input));
        input = "A Z\n" + "A Z\n" + "A Z\n" + "B Z\n" + "C X\n" + "A Z\n" + "A Z\n" + "C Y\n" + "A Z\n" + "A Y\n" + "B Y\n" + "A Z\n" + "C X\n" + "A Z\n" + "A Z\n" + "A Z\n" + "A Z\n" + "A Y\n" + "A Z\n" + "A Z\n" + "C Y\n" + "C X\n" + "C X\n" + "C X\n" + "A Z\n" + "A Z\n" + "B Y\n" + "A Z\n" + "A Z\n" + "C Z\n" + "B Z\n" + "A Y\n" + "A Z\n" + "B Y\n" + "A Z\n" + "B Y\n" + "A X\n" + "B Z\n" + "A Z\n" + "A Z\n" + "A Z\n" + "C X\n" + "C X\n" + "A X\n" + "A Z\n" + "A Z\n" + "C X\n" + "A Z\n" + "B Y\n" + "A Z\n" + "B Z\n" + "A Z\n" + "A Z\n" + "B Z\n" + "B Z\n" + "C Y\n" + "B Z\n" + "A X\n" + "B Z\n" + "A Z\n" + "B Y\n" + "A Z\n" + "B Z\n" + "C X\n" + "A Z\n" + "B Y\n" + "B Z\n" + "A Z\n" + "B Y\n" + "C X\n" + "B Y\n" + "A Z\n" + "A Z\n" + "A Z\n" + "B Y\n" + "A Z\n" + "A Z\n" + "B Y\n" + "B Z\n" + "C Z\n" + "A X\n" + "A Z\n" + "A Z\n" + "C Z\n" + "C X\n" + "A Z\n" + "C X\n" + "A Z\n" + "A X\n" + "A Z\n" + "A Z\n" + "A Z\n" + "B X\n" + "B Y\n" + "A Z\n" + "A Z\n" + "A Z\n" + "C Y\n" + "B Y\n" + "C X\n" + "C X\n" + "A Z\n" + "A Z\n" + "A Z\n" + "A X\n" + "C X\n" + "B Z\n" + "C X\n" + "C X\n" + "A Z\n" + "A Z\n" + "A Z\n" + "A Z\n" + "B Z\n" + "A Y\n" + "A Y\n" + "C X\n" + "A Y\n" + "C X\n" + "B Y\n" + "A Z\n" + "C Z\n" + "A Z\n" + "B Y\n" + "A Z\n" + "C X\n" + "B X\n" + "A Y\n" + "C X\n" + "A Z\n" + "A Z\n" + "A Y\n" + "B Z\n" + "C X\n" + "C X\n" + "C X\n" + "B Y\n" + "A Z\n" + "A Z\n" + "B Y\n" + "A Z\n" + "B Z\n" + "C X\n" + "C Z\n" + "A Z\n" + "C X\n" + "B Z\n" + "A Z\n" + "B Y\n" + "C X\n" + "A Y\n" + "B Y\n" + "C X\n" + "C X\n" + "A Z\n" + "A Y\n" + "A Z\n" + "A Z\n" + "A Z\n" + "A Y\n" + "C X\n" + "A Z\n" + "A Z\n" + "B Z\n" + "A Z\n" + "B Z\n" + "A Z\n" + "C Z\n" + "C Z\n" + "A Z\n" + "A Z\n" + "B Z\n" + "A Z\n" + "B Z\n" + "A Z\n" + "B Z\n" + "B Y\n" + "B Y\n" + "B Z\n" + "B Y\n" + "A Z\n" + "A Z\n" + "A Z\n" + "A Z\n" + "A Z\n" + "A Z\n" + "A Z\n" + "A Z\n" + "C X\n" + "C X\n" + "A Z\n" + "A Z\n" + "C Y\n" + "A Z\n" + "C Y\n" + "B Y\n" + "C X\n" + "B Z\n" + "A Z\n" + "A Z\n" + "C X\n" + "A Z\n" + "B Y\n" + "A Z\n" + "A Z\n" + "A Z\n" + "B Z\n" + "A Z\n" + "B Y\n" + "A Z\n" + "B Y\n" + "A Z\n" + "A Z\n" + "C Z\n" + "A Z\n" + "C X\n" + "C Y\n" + "C X\n" + "C Y\n" + "C X\n" + "A Z\n" + "B Z\n" + "A Z\n" + "A Z\n" + "A Z\n" + "A Z\n" + "A Z\n" + "B Y\n" + "A Z\n" + "C X\n" + "C X\n" + "A Z\n" + "A Z\n" + "C Z\n" + "C Z\n" + "A Z\n" + "A Z\n" + "A Z\n" + "C X\n" + "A Z\n" + "A Z\n" + "A Z\n" + "A Y\n" + "A Z\n" + "C X\n" + "A Z\n" + "A Z\n" + "A Z\n" + "C X\n" + "C X\n" + "A Z\n" + "C Y\n" + "A X\n" + "A Z\n" + "A Z\n" + "A Y\n" + "B Z\n" + "A Z\n" + "A Z\n" + "A Z\n" + "C X\n" + "A Z\n" + "A Z\n" + "A Z\n" + "B Z\n" + "B Z\n" + "A Y\n" + "B Z\n" + "C X\n" + "B Y\n" + "A Z\n" + "A Z\n" + "A Z\n" + "A Z\n" + "A Z\n" + "A Z\n" + "B Z\n" + "C X\n" + "A Z\n" + "A Y\n" + "A Z\n" + "B Y\n" + "B Z\n" + "C Z\n" + "A Z\n" + "A Y\n" + "A Z\n" + "B Z\n" + "A Y\n" + "C X\n" + "A Z\n" + "A Y\n" + "A Z\n" + "C Y\n" + "A Z\n" + "A Z\n" + "B Y\n" + "C X\n" + "A Z\n" + "A Z\n" + "A X\n" + "A Z\n" + "C X\n" + "A Z\n" + "B Y\n" + "A Z\n" + "C X\n" + "A Z\n" + "B Y\n" + "A Z\n" + "C Y\n" + "B Z\n" + "C X\n" + "A Z\n" + "C X\n" + "B Y\n" + "A Z\n" + "C X\n" + "A Z\n" + "B Y\n" + "A Z\n" + "A Z\n" + "C Z\n" + "A Z\n" + "A Y\n" + "A Z\n" + "A Z\n" + "C X\n" + "A Y\n" + "A Z\n" + "B Z\n" + "A Z\n" + "A Y\n" + "C X\n" + "A Z\n" + "B Y\n" + "A Y\n" + "A Z\n" + "A Z\n" + "A Z\n" + "A Z\n" + "A Z\n" + "A Z\n" + "B Z\n" + "B Y\n" + "B X\n" + "C Y\n" + "B X\n" + "A Z\n" + "A Y\n" + "C X\n" + "A Z\n" + "A Z\n" + "C X\n" + "C Y\n" + "A Y\n" + "A Z\n" + "C X\n" + "B Y\n" + "B Y\n" + "C X\n" + "A Z\n" + "C Y\n" + "A Z\n" + "A Z\n" + "A Z\n" + "A Z\n" + "B X\n" + "A Z\n" + "A X\n" + "B Z\n" + "C Z\n" + "A Z\n" + "A Z\n" + "A Y\n" + "A Z\n" + "A Y\n" + "A Z\n" + "A Z\n" + "B Y\n" + "A Z\n" + "A Z\n" + "A Z\n" + "C X\n" + "A Z\n" + "A Z\n" + "A Z\n" + "B Z\n" + "A Z\n" + "A Z\n" + "A Z\n" + "A Z\n" + "A Z\n" + "B Z\n" + "A Z\n" + "A Z\n" + "C X\n" + "A Z\n" + "A Z\n" + "A Z\n" + "A Z\n" + "A Y\n" + "A Z\n" + "A Z\n" + "C Z\n" + "A Z\n" + "A Y\n" + "B Y\n" + "B Z\n" + "A Z\n" + "B Y\n" + "B Z\n" + "A Z\n" + "C X\n" + "A Z\n" + "B X\n" + "A Z\n" + "A Z\n" + "A Y\n" + "A Z\n" + "B X\n" + "B Z\n" + "A Z\n" + "B Z\n" + "A Y\n" + "A Z\n" + "A Z\n" + "A Z\n" + "B Y\n" + "A Z\n" + "B Z\n" + "A Z\n" + "B Z\n" + "A Z\n" + "A Y\n" + "A Z\n" + "B Z\n" + "A Z\n" + "C X\n" + "C X\n" + "A Z\n" + "A Z\n" + "B Z\n" + "A Z\n" + "A Z\n" + "C X\n" + "A Z\n" + "A X\n" + "A Z\n" + "A X\n" + "C X\n" + "A Y\n" + "C Y\n" + "B Y\n" + "A Z\n" + "A Y\n" + "A X\n" + "A Z\n" + "A Y\n" + "A Z\n" + "A Z\n" + "A Z\n" + "C X\n" + "B Z\n" + "A Z\n" + "B Y\n" + "A Z\n" + "A Y\n" + "A Z\n" + "A Z\n" + "B Z\n" + "C X\n" + "A Z\n" + "A Z\n" + "A Y\n" + "C X\n" + "C Y\n" + "B Z\n" + "A Z\n" + "A Z\n" + "B Z\n" + "C X\n" + "A Z\n" + "A Z\n" + "A Z\n" + "C Y\n" + "A Y\n" + "A Z\n" + "B Z\n" + "B Z\n" + "A Z\n" + "B Z\n" + "A X\n" + "A Z\n" + "B Z\n" + "A Z\n" + "A Z\n" + "B Y\n" + "A Z\n" + "A Y\n" + "B Y\n" + "A Z\n" + "B Z\n" + "C X\n" + "C Y\n" + "A Z\n" + "B Z\n" + "C X\n" + "A Z\n" + "B X\n" + "A Z\n" + "A Z\n" + "C X\n" + "A Z\n" + "A Y\n" + "B Z\n" + "B Y\n" + "A Z\n" + "A Y\n" + "C Y\n" + "A Z\n" + "C X\n" + "B Z\n" + "A X\n" + "A Z\n" + "A Z\n" + "A Z\n" + "A Z\n" + "A Z\n" + "A Z\n" + "A Z\n" + "A Y\n" + "A Z\n" + "A Z\n" + "C X\n" + "B Y\n" + "B Z\n" + "C X\n" + "C X\n" + "C X\n" + "A Z\n" + "A Z\n" + "B Z\n" + "B Y\n" + "A Z\n" + "A Z\n" + "B Y\n" + "B Y\n" + "A Y\n" + "A Y\n" + "A X\n" + "A Y\n" + "B Y\n" + "A Y\n" + "C X\n" + "A Z\n" + "A Z\n" + "A Z\n" + "A Y\n" + "B Y\n" + "A Z\n" + "C Y\n" + "B Z\n" + "C X\n" + "A Y\n" + "A Z\n" + "C Z\n" + "A Z\n" + "B Z\n" + "C X\n" + "B Z\n" + "C X\n" + "B Z\n" + "B Y\n" + "B Y\n" + "C X\n" + "A Z\n" + "A Z\n" + "B Z\n" + "B Z\n" + "B Z\n" + "A Z\n" + "A Z\n" + "A Z\n" + "A Z\n" + "A Z\n" + "C X\n" + "C X\n" + "C Y\n" + "B X\n" + "C X\n" + "A Z\n" + "A Z\n" + "A Z\n" + "A Z\n" + "A Z\n" + "A X\n" + "A Z\n" + "C X\n" + "A Z\n" + "C Z\n" + "A Z\n" + "C X\n" + "C Z\n" + "A Z\n" + "A Z\n" + "A Y\n" + "B Z\n" + "A X\n" + "A Z\n" + "A Z\n" + "A Z\n" + "C X\n" + "B Y\n" + "A Z\n" + "B Y\n" + "A Z\n" + "B Y\n" + "A Z\n" + "C X\n" + "A Z\n" + "C X\n" + "A Z\n" + "A Z\n" + "A Z\n" + "A Z\n" + "A Z\n" + "B X\n" + "B Y\n" + "C X\n" + "C X\n" + "A Z\n" + "C X\n" + "A Z\n" + "A Z\n" + "A Z\n" + "A Y\n" + "A Z\n" + "A Y\n" + "A Z\n" + "A Z\n" + "A Z\n" + "C Y\n" + "A Z\n" + "A Z\n" + "B Z\n" + "B Y\n" + "C X\n" + "A Y\n" + "A Z\n" + "B Z\n" + "A Z\n" + "A Z\n" + "A Z\n" + "B Y\n" + "C Z\n" + "A Y\n" + "C Y\n" + "A X\n" + "A X\n" + "B Z\n" + "A Y\n" + "C X\n" + "C X\n" + "B Z\n" + "A Z\n" + "B Z\n" + "A Z\n" + "A Z\n" + "A Y\n" + "B Z\n" + "C Y\n" + "A Z\n" + "A Z\n" + "A Z\n" + "C X\n" + "B Y\n" + "A X\n" + "A Z\n" + "C X\n" + "A Z\n" + "B Z\n" + "B Y\n" + "C X\n" + "B Y\n" + "A X\n" + "A Z\n" + "A Z\n" + "A Z\n" + "A Y\n" + "A Z\n" + "A Z\n" + "A Y\n" + "A Y\n" + "A Y\n" + "A X\n" + "A Z\n" + "A Z\n" + "B Z\n" + "A Y\n" + "A Z\n" + "C X\n" + "C X\n" + "A Z\n" + "A Z\n" + "B Z\n" + "B Y\n" + "A Z\n" + "A Z\n" + "C X\n" + "A Y\n" + "C X\n" + "B Z\n" + "A Z\n" + "A Z\n" + "A Z\n" + "A Y\n" + "A X\n" + "C Y\n" + "C X\n" + "C X\n" + "A Z\n" + "A Y\n" + "A Z\n" + "A Z\n" + "A Z\n" + "C X\n" + "A Z\n" + "A Z\n" + "B Z\n" + "C X\n" + "C X\n" + "B Z\n" + "B Z\n" + "C X\n" + "A Z\n" + "B X\n" + "A Z\n" + "B Z\n" + "A Y\n" + "A Z\n" + "A Z\n" + "C X\n" + "A Z\n" + "C Z\n" + "A Z\n" + "B Z\n" + "C X\n" + "A Z\n" + "B Y\n" + "A Y\n" + "A Z\n" + "A Z\n" + "B X\n" + "C X\n" + "B Z\n" + "C X\n" + "C X\n" + "C Y\n" + "B Z\n" + "C X\n" + "A Y\n" + "C X\n" + "A Z\n" + "A Z\n" + "A Z\n" + "A Y\n" + "A Z\n" + "C X\n" + "C Y\n" + "A Z\n" + "A Z\n" + "B Z\n" + "A Z\n" + "B Y\n" + "A X\n" + "A X\n" + "B Z\n" + "C X\n" + "B Y\n" + "A Z\n" + "C X\n" + "A Z\n" + "B Z\n" + "A Z\n" + "B Y\n" + "B Y\n" + "A X\n" + "B Y\n" + "A Z\n" + "A X\n" + "A Z\n" + "C X\n" + "A Z\n" + "A Z\n" + "B Y\n" + "C Y\n" + "A X\n" + "A Z\n" + "C Y\n" + "C X\n" + "A Z\n" + "A Z\n" + "A Z\n" + "A Y\n" + "A Z\n" + "C X\n" + "A Z\n" + "B Y\n" + "A Z\n" + "B Z\n" + "B Z\n" + "C X\n" + "B Y\n" + "A Z\n" + "C Y\n" + "A Y\n" + "A Z\n" + "A Z\n" + "C X\n" + "A Z\n" + "A Z\n" + "A Z\n" + "A Z\n" + "B Y\n" + "B Z\n" + "A Z\n" + "A Z\n" + "C Y\n" + "A Z\n" + "A Z\n" + "A Z\n" + "A Z\n" + "A Y\n" + "A Z\n" + "A Z\n" + "C Y\n" + "B Y\n" + "B Z\n" + "A Z\n" + "B Z\n" + "A Z\n" + "B Z\n" + "A Z\n" + "A Z\n" + "A Y\n" + "A Z\n" + "A Z\n" + "B Z\n" + "C Y\n" + "A Z\n" + "B Z\n" + "A X\n" + "C X\n" + "C X\n" + "A Z\n" + "A Z\n" + "A Z\n" + "A Z\n" + "A Z\n" + "C X\n" + "A Z\n" + "C X\n" + "A Z\n" + "B Y\n" + "A Z\n" + "C Y\n" + "A Y\n" + "B Z\n" + "C X\n" + "A Y\n" + "A Z\n" + "A Y\n" + "A Z\n" + "B Z\n" + "B Y\n" + "A Y\n" + "B Z\n" + "A Z\n" + "A Z\n" + "C Z\n" + "C Z\n" + "A Y\n" + "A Z\n" + "A Z\n" + "C X\n" + "A Z\n" + "A X\n" + "C Y\n" + "C X\n" + "A Z\n" + "A Z\n" + "B Y\n" + "B Z\n" + "C Y\n" + "A Z\n" + "B Z\n" + "A Z\n" + "C Z\n" + "A Z\n" + "A Y\n" + "B Y\n" + "C X\n" + "A Z\n" + "A Z\n" + "A Z\n" + "C X\n" + "A Z\n" + "A Y\n" + "A Z\n" + "A Z\n" + "B Z\n" + "C X\n" + "C X\n" + "C X\n" + "A Z\n" + "A Z\n" + "A Z\n" + "C X\n" + "A Z\n" + "A Z\n" + "A Z\n" + "A X\n" + "A Z\n" + "C X\n" + "C X\n" + "B Z\n" + "A Z\n" + "A Z\n" + "A Z\n" + "B Y\n" + "A Z\n" + "C X\n" + "A X\n" + "B Z\n" + "C X\n" + "A Z\n" + "C X\n" + "A Y\n" + "A Z\n" + "A Z\n" + "A Y\n" + "A Z\n" + "A Y\n" + "A X\n" + "C X\n" + "A Z\n" + "A Y\n" + "B Y\n" + "A Z\n" + "A Y\n" + "C Z\n" + "B Y\n" + "A Z\n" + "A Z\n" + "A Y\n" + "A Z\n" + "C X\n" + "A Z\n" + "B Y\n" + "B Z\n" + "B Z\n" + "A Z\n" + "A Z\n" + "A Z\n" + "C X\n" + "A Z\n" + "B Y\n" + "B Y\n" + "A Z\n" + "A Y\n" + "C X\n" + "A Z\n" + "C X\n" + "A Z\n" + "C X\n" + "C X\n" + "A Y\n" + "B Z\n" + "A Z\n" + "A Z\n" + "A Z\n" + "A Y\n" + "A X\n" + "B Y\n" + "A Z\n" + "B Z\n" + "B Y\n" + "C Y\n" + "C X\n" + "C Y\n" + "A Z\n" + "B Z\n" + "A Z\n" + "A Y\n" + "B X\n" + "C Z\n" + "A X\n" + "A Z\n" + "A Z\n" + "A Z\n" + "A Y\n" + "A Y\n" + "A Z\n" + "A Y\n" + "C X\n" + "A Z\n" + "A Y\n" + "C X\n" + "A Z\n" + "A Z\n" + "C Y\n" + "A Z\n" + "B Z\n" + "A Y\n" + "B Z\n" + "B X\n" + "B Z\n" + "C X\n" + "A Z\n" + "A Z\n" + "C X\n" + "A Z\n" + "A Z\n" + "C X\n" + "B Z\n" + "B Z\n" + "B Z\n" + "A Z\n" + "A Z\n" + "B Y\n" + "A Z\n" + "A Z\n" + "C Z\n" + "C Z\n" + "B Z\n" + "A Z\n" + "B Y\n" + "A Z\n" + "A Z\n" + "C X\n" + "B Z\n" + "A Z\n" + "A Z\n" + "A Z\n" + "C Y\n" + "B Y\n" + "C X\n" + "A Z\n" + "A Z\n" + "A Z\n" + "A Y\n" + "A Z\n" + "C X\n" + "A Z\n" + "C X\n" + "A Z\n" + "A Z\n" + "C Y\n" + "C X\n" + "C X\n" + "C X\n" + "C X\n" + "C X\n" + "B Z\n" + "B Z\n" + "B Y\n" + "B Y\n" + "C Z\n" + "A Z\n" + "B Z\n" + "A Z\n" + "A X\n" + "A Z\n" + "A Z\n" + "A Z\n" + "C X\n" + "A Z\n" + "C X\n" + "A Z\n" + "A Z\n" + "C X\n" + "C X\n" + "B Y\n" + "A Z\n" + "C Y\n" + "A Z\n" + "A Y\n" + "C Y\n" + "B Z\n" + "B Y\n" + "C X\n" + "A Z\n" + "C Y\n" + "A Z\n" + "A Z\n" + "A Z\n" + "B Y\n" + "C X\n" + "B Z\n" + "B Z\n" + "C X\n" + "B Y\n" + "B Z\n" + "A Z\n" + "C X\n" + "A Z\n" + "B Y\n" + "B Z\n" + "A Y\n" + "A Z\n" + "A Z\n" + "A Z\n" + "A Z\n" + "C Y\n" + "A Z\n" + "C Y\n" + "A Z\n" + "B Y\n" + "C X\n" + "B Z\n" + "A Z\n" + "A Z\n" + "B Z\n" + "C X\n" + "B Z\n" + "A Z\n" + "A Z\n" + "A X\n" + "B Y\n" + "A Z\n" + "A Z\n" + "A Z\n" + "A Z\n" + "A Y\n" + "B Z\n" + "A Z\n" + "A Z\n" + "A Z\n" + "B Z\n" + "C Y\n" + "C X\n" + "C X\n" + "B Z\n" + "A Z\n" + "B Z\n" + "C X\n" + "A Y\n" + "C X\n" + "B Y\n" + "B Z\n" + "C Y\n" + "B Y\n" + "B Y\n" + "A Y\n" + "C Y\n" + "A Z\n" + "A Z\n" + "B Z\n" + "B Z\n" + "A X\n" + "A Z\n" + "A Z\n" + "B Z\n" + "A Z\n" + "B Z\n" + "A X\n" + "A Z\n" + "A Y\n" + "A Y\n" + "A Z\n" + "B Z\n" + "A Z\n" + "B Z\n" + "A Z\n" + "B Z\n" + "C X\n" + "A Z\n" + "A Z\n" + "C X\n" + "A Z\n" + "A Z\n" + "A Z\n" + "C X\n" + "B Y\n" + "A X\n" + "B Z\n" + "B Z\n" + "C Y\n" + "A Z\n" + "A Z\n" + "C X\n" + "B Y\n" + "C X\n" + "A Z\n" + "A X\n" + "A Z\n" + "A Z\n" + "A Z\n" + "A Z\n" + "A Z\n" + "A Z\n" + "A Z\n" + "A Z\n" + "A Z\n" + "C X\n" + "B Z\n" + "B Z\n" + "C X\n" + "A Y\n" + "C Z\n" + "A Y\n" + "A Z\n" + "C Y\n" + "A Z\n" + "A Z\n" + "A Y\n" + "A Z\n" + "C X\n" + "C Z\n" + "A Z\n" + "A Y\n" + "A Z\n" + "A X\n" + "A Y\n" + "A Z\n" + "C X\n" + "B Z\n" + "A Z\n" + "B Z\n" + "C Y\n" + "C X\n" + "A Z\n" + "A Z\n" + "A X\n" + "A Z\n" + "B Z\n" + "C X\n" + "A Z\n" + "B Y\n" + "A Z\n" + "A X\n" + "A Z\n" + "B Z\n" + "A Z\n" + "A Z\n" + "C X\n" + "B Z\n" + "B X\n" + "A Z\n" + "A Z\n" + "C Z\n" + "A Z\n" + "A Z\n" + "A Y\n" + "B Z\n" + "A Z\n" + "C X\n" + "B Z\n" + "A Z\n" + "C Y\n" + "A Z\n" + "B Z\n" + "B Z\n" + "A Z\n" + "A Z\n" + "C X\n" + "B Z\n" + "C Y\n" + "A Y\n" + "A Y\n" + "B Z\n" + "A Z\n" + "A Z\n" + "C Z\n" + "B Z\n" + "A Y\n" + "A Y\n" + "C Z\n" + "C Z\n" + "A Z\n" + "B Z\n" + "B Y\n" + "A Z\n" + "B Y\n" + "A Z\n" + "A Z\n" + "A Z\n" + "C Y\n" + "A Y\n" + "A Z\n" + "A Z\n" + "A Z\n" + "A Z\n" + "C Z\n" + "A Z\n" + "B Y\n" + "A Z\n" + "B Z\n" + "C Y\n" + "A Z\n" + "B Y\n" + "B Z\n" + "A Z\n" + "A Y\n" + "A Z\n" + "A Z\n" + "B Z\n" + "A Z\n" + "A Z\n" + "A Z\n" + "C Z\n" + "B Z\n" + "C X\n" + "B Z\n" + "A Z\n" + "A Z\n" + "A Y\n" + "A Z\n" + "A Z\n" + "A Z\n" + "A Z\n" + "C Y\n" + "A Z\n" + "A Z\n" + "A Z\n" + "A X\n" + "A Y\n" + "B Y\n" + "C X\n" + "A Z\n" + "A Z\n" + "B Y\n" + "A Z\n" + "C X\n" + "A Y\n" + "A Z\n" + "A Z\n" + "C X\n" + "A X\n" + "A Z\n" + "A Z\n" + "A Z\n" + "B Y\n" + "B Z\n" + "A X\n" + "A Z\n" + "C X\n" + "A Z\n" + "C X\n" + "B Z\n" + "B Y\n" + "A Z\n" + "B Y\n" + "A Y\n" + "A Z\n" + "A Y\n" + "A Z\n" + "B Y\n" + "C X\n" + "B X\n" + "B Y\n" + "C X\n" + "A Z\n" + "A Z\n" + "A Y\n" + "A Z\n" + "A Y\n" + "B Z\n" + "B Y\n" + "B Y\n" + "A Y\n" + "A X\n" + "A Z\n" + "C X\n" + "A Z\n" + "B X\n" + "A Z\n" + "A Z\n" + "C X\n" + "B Y\n" + "B Z\n" + "B Z\n" + "B Y\n" + "B Z\n" + "A Y\n" + "C X\n" + "C Z\n" + "A Z\n" + "A Y\n" + "B Y\n" + "B Y\n" + "A Z\n" + "A Y\n" + "C Y\n" + "B Y\n" + "B Z\n" + "A Z\n" + "A Y\n" + "A Z\n" + "B Z\n" + "A Z\n" + "A Z\n" + "A Z\n" + "A Z\n" + "B Z\n" + "A Y\n" + "C X\n" + "A Z\n" + "A Z\n" + "B Y\n" + "A Z\n" + "B Y\n" + "B Z\n" + "A Z\n" + "C X\n" + "A Z\n" + "C X\n" + "B Y\n" + "A Z\n" + "B Z\n" + "C X\n" + "A Z\n" + "A Z\n" + "A Z\n" + "C X\n" + "C X\n" + "A Z\n" + "A Z\n" + "A Z\n" + "B Y\n" + "A Z\n" + "A Z\n" + "A Z\n" + "A Z\n" + "A Z\n" + "A Y\n" + "B Z\n" + "C Y\n" + "A Y\n" + "C X\n" + "A Z\n" + "A Z\n" + "B Y\n" + "B X\n" + "A Z\n" + "C Z\n" + "A Z\n" + "A Y\n" + "A Z\n" + "A X\n" + "A Z\n" + "A Z\n" + "A Z\n" + "C Z\n" + "C X\n" + "C X\n" + "B Y\n" + "C X\n" + "C X\n" + "B Y\n" + "C Z\n" + "C X\n" + "C X\n" + "A Y\n" + "A Z\n" + "C X\n" + "C Z\n" + "B Y\n" + "A Z\n" + "C X\n" + "C X\n" + "A Z\n" + "A Z\n" + "A Z\n" + "A Y\n" + "A Z\n" + "A Y\n" + "B Z\n" + "A Z\n" + "A Z\n" + "A Z\n" + "A Z\n" + "A Z\n" + "A Z\n" + "C X\n" + "C X\n" + "C X\n" + "C X\n" + "A Z\n" + "A Z\n" + "B Z\n" + "A Y\n" + "A Z\n" + "A Z\n" + "B Z\n" + "A Z\n" + "A Z\n" + "A Z\n" + "A Z\n" + "A Z\n" + "C X\n" + "C X\n" + "A Z\n" + "A Z\n" + "C X\n" + "C Z\n" + "C Z\n" + "A Z\n" + "A Z\n" + "B Y\n" + "B Z\n" + "A Z\n" + "A Z\n" + "B Y\n" + "B X\n" + "C X\n" + "B Y\n" + "C X\n" + "C X\n" + "A Z\n" + "C X\n" + "C X\n" + "C Y\n" + "C X\n" + "C X\n" + "C X\n" + "B Z\n" + "B Z\n" + "A Z\n" + "A Z\n" + "B Z\n" + "A Z\n" + "C X\n" + "A Z\n" + "B Y\n" + "A Y\n" + "A Z\n" + "C Z\n" + "B Y\n" + "B Z\n" + "B Z\n" + "A Z\n" + "C X\n" + "B Z\n" + "A X\n" + "B Y\n" + "A Y\n" + "B Y\n" + "B Z\n" + "A Z\n" + "A Z\n" + "A Z\n" + "A Z\n" + "A Z\n" + "A Z\n" + "C X\n" + "C X\n" + "B Z\n" + "A Z\n" + "B Y\n" + "A Z\n" + "B Z\n" + "A Z\n" + "B Y\n" + "A Z\n" + "A X\n" + "A Z\n" + "B Y\n" + "B Y\n" + "A Y\n" + "C X\n" + "A Z\n" + "A Z\n" + "C Y\n" + "A Z\n" + "A Z\n" + "B Z\n" + "C Z\n" + "B Z\n" + "A Z\n" + "A Z\n" + "C X\n" + "C Y\n" + "B Z\n" + "A Z\n" + "C X\n" + "A Z\n" + "C X\n" + "B Y\n" + "C X\n" + "B Z\n" + "A Z\n" + "A Z\n" + "C X\n" + "A Z\n" + "C X\n" + "A Y\n" + "C X\n" + "C X\n" + "C Y\n" + "B Z\n" + "C X\n" + "B Z\n" + "C X\n" + "A Z\n" + "A Z\n" + "C X\n" + "A Y\n" + "B Z\n" + "C X\n" + "B Z\n" + "C X\n" + "A Z\n" + "C X\n" + "C X\n" + "A Z\n" + "A Z\n" + "B Y\n" + "C Z\n" + "A X\n" + "A X\n" + "A Z\n" + "C X\n" + "A Z\n" + "A Z\n" + "A Z\n" + "A Y\n" + "A Z\n" + "A Z\n" + "A Z\n" + "A Z\n" + "B Z\n" + "C X\n" + "B Y\n" + "A Z\n" + "A Z\n" + "B Y\n" + "A Z\n" + "A Z\n" + "A Z\n" + "A Z\n" + "B Y\n" + "A Z\n" + "B Z\n" + "A Y\n" + "A Y\n" + "A Y\n" + "A Z\n" + "A Y\n" + "A Z\n" + "B Z\n" + "A Z\n" + "B Y\n" + "A Z\n" + "C X\n" + "A Y\n" + "C X\n" + "A Z\n" + "B Y\n" + "A Y\n" + "A Z\n" + "A Y\n" + "A Z\n" + "C Z\n" + "A Z\n" + "B Z\n" + "A Z\n" + "C X\n" + "B Z\n" + "A Z\n" + "A Z\n" + "C X\n" + "B Y\n" + "A Z\n" + "C X\n" + "C Y\n" + "A Z\n" + "B Y\n" + "A Z\n" + "B X\n" + "B Y\n" + "B Y\n" + "C Z\n" + "C X\n" + "A Z\n" + "C X\n" + "A Y\n" + "A Y\n" + "B Z\n" + "A Z\n" + "C X\n" + "B Z\n" + "A Z\n" + "A Z\n" + "A Y\n" + "C X\n" + "C X\n" + "A Z\n" + "A X\n" + "B Z\n" + "A Z\n" + "A Z\n" + "A X\n" + "A Z\n" + "C X\n" + "A Z\n" + "B Y\n" + "A Z\n" + "B X\n" + "B Y\n" + "A Y\n" + "C X\n" + "A Z\n" + "A X\n" + "A X\n" + "A Y\n" + "B Y\n" + "A Y\n" + "A Z\n" + "C X\n" + "B Z\n" + "A Z\n" + "A X\n" + "A X\n" + "A Z\n" + "C X\n" + "B Z\n" + "C X\n" + "B Y\n" + "A Z\n" + "C X\n" + "A Y\n" + "A Z\n" + "A Z\n" + "A Z\n" + "A Z\n" + "C Z\n" + "B Z\n" + "C Z\n" + "A Z\n" + "A Z\n" + "C X\n" + "B Y\n" + "A Y\n" + "B Z\n" + "C X\n" + "B Z\n" + "A Z\n" + "A Z\n" + "A Z\n" + "A X\n" + "B Y\n" + "C X\n" + "B Y\n" + "B Z\n" + "B Z\n" + "A Z\n" + "A Y\n" + "C Y\n" + "A Y\n" + "A X\n" + "A Z\n" + "C X\n" + "A Z\n" + "A Z\n" + "A X\n" + "A Z\n" + "A Z\n" + "C X\n" + "A Z\n" + "A X\n" + "A Z\n" + "C Y\n" + "A Z\n" + "B Z\n" + "A Y\n" + "A Z\n" + "C Z\n" + "A Y\n" + "A Y\n" + "B Z\n" + "A Y\n" + "A Y\n" + "A Y\n" + "A Z\n" + "A Z\n" + "A Z\n" + "A Z\n" + "C X\n" + "A Z\n" + "A Z\n" + "A Z\n" + "A Z\n" + "A Z\n" + "A Z\n" + "A X\n" + "A Z\n" + "A Z\n" + "A Z\n" + "A Z\n" + "A Z\n" + "A Y\n" + "B Z\n" + "A Y\n" + "A Z\n" + "C X\n" + "A X\n" + "B Z\n" + "A Z\n" + "A X\n" + "C Y\n" + "B Y\n" + "B Y\n" + "B Z\n" + "C X\n" + "C X\n" + "A Z\n" + "A Z\n" + "C X\n" + "C X\n" + "A Z\n" + "A X\n" + "A Z\n" + "A Z\n" + "A Z\n" + "A X\n" + "C X\n" + "C X\n" + "A Z\n" + "A Y\n" + "A Z\n" + "A Z\n" + "A Z\n" + "A Z\n" + "C Z\n" + "A Z\n" + "C X\n" + "B Z\n" + "C Z\n" + "C X\n" + "A Z\n" + "B Y\n" + "C X\n" + "C X\n" + "B Z\n" + "C X\n" + "B Y\n" + "A Y\n" + "B X\n" + "A Z\n" + "A Z\n" + "A Z\n" + "B Z\n" + "C X\n" + "A X\n" + "B Z\n" + "A X\n" + "A Z\n" + "C Z\n" + "B Z\n" + "A Z\n" + "A Z\n" + "C X\n" + "C X\n" + "A X\n" + "C X\n" + "C Y\n" + "A Z\n" + "A Z\n" + "A Z\n" + "B Z\n" + "C Z\n" + "A Z\n" + "A Z\n" + "A Z\n" + "A Z\n" + "A Z\n" + "B Z\n" + "A Z\n" + "A Z\n" + "C X\n" + "B Y\n" + "A Z\n" + "B Z\n" + "A Z\n" + "C X\n" + "A Z\n" + "A Z\n" + "A Z\n" + "B Z\n" + "C X\n" + "B Y\n" + "A Z\n" + "A Z\n" + "A Z\n" + "C Y\n" + "A Z\n" + "A Z\n" + "C X\n" + "C X\n" + "A Y\n" + "B Z\n" + "A Z\n" + "C Y\n" + "C X\n" + "A Z\n" + "A Z\n" + "A Z\n" + "C X\n" + "A Z\n" + "A Z\n" + "B Z\n" + "B Z\n" + "A Z\n" + "A Z\n" + "A Z\n" + "C X\n" + "C X\n" + "A Z\n" + "B Z\n" + "A X\n" + "B Y\n" + "C X\n" + "C X\n" + "C X\n" + "A Z\n" + "C X\n" + "A Z\n" + "A Z\n" + "B Y\n" + "A Y\n" + "B Z\n" + "B Z\n" + "A Z\n" + "A Z\n" + "C Z\n" + "A Y\n" + "A Y\n" + "A Z\n" + "A Z\n" + "C X\n" + "C Z\n" + "A Z\n" + "A Z\n" + "A Z\n" + "A Z\n" + "C Y\n" + "B Y\n" + "B Y\n" + "C Y\n" + "A Z\n" + "C X\n" + "B Z\n" + "A X\n" + "A Y\n" + "B Z\n" + "A Z\n" + "A Z\n" + "A Z\n" + "A X\n" + "A Z\n" + "A Z\n" + "A Z\n" + "A Y\n" + "C Z\n" + "A Y\n" + "C X\n" + "A Y\n" + "A X\n" + "C X\n" + "A Z\n" + "B Y\n" + "A Y\n" + "B Y\n" + "A Z\n" + "C X\n" + "C Z\n" + "A Z\n" + "C Z\n" + "A Y\n" + "A Z\n" + "A Z\n" + "B Z\n" + "B X\n" + "B Z\n" + "B Z\n" + "B Y\n" + "C Z\n" + "C X\n" + "A X\n" + "C Z\n" + "B Z\n" + "A Z\n" + "A Z\n" + "B Z\n" + "A Y\n" + "A Z\n" + "B Y\n" + "C X\n" + "A Z\n" + "B Z\n" + "C X\n" + "A X\n" + "B Z\n" + "A Z\n" + "A Z\n" + "C X\n" + "C X\n" + "C X\n" + "B Z\n" + "C Z\n" + "A Z\n" + "C X\n" + "A Z\n" + "A Z\n" + "A Z\n" + "A Z\n" + "C Z\n" + "C X\n" + "A X\n" + "B Y\n" + "A Z\n" + "C X\n" + "C Z\n" + "A Z\n" + "C X\n" + "B Z\n" + "B Y\n" + "A Z\n" + "C X\n" + "A Z\n" + "B Z\n" + "C Z\n" + "A Z\n" + "A Z\n" + "A X\n" + "B Y\n" + "C X\n" + "A Z\n" + "C X\n" + "A Z\n" + "A X\n" + "C X\n" + "A Z\n" + "C X\n" + "A Y\n" + "A Z\n" + "C X\n" + "C Z\n" + "C Y\n" + "B Z\n" + "B Z\n" + "A Y\n" + "B Z\n" + "A Z\n" + "A Z\n" + "A Y\n" + "A Z\n" + "C X\n" + "C X\n" + "A Z\n" + "A Z\n" + "C X\n" + "B Z\n" + "A Z\n" + "B Y\n" + "A Z\n" + "A Z\n" + "A Z\n" + "C X\n" + "A Z\n" + "A Y\n" + "B Y\n" + "A Z\n" + "C X\n" + "A Z\n" + "A X\n" + "A Z\n" + "A Z\n" + "C X\n" + "C Y\n" + "A Z\n" + "C X\n" + "A Z\n" + "A Y\n" + "C X\n" + "B Z\n" + "C Z\n" + "B Y\n" + "A Z\n" + "A Z\n" + "B Y\n" + "A Z\n" + "B Y\n" + "A Z\n" + "A Z\n" + "A Z\n" + "C X\n" + "A Y\n" + "C X\n" + "A Z\n" + "C Y\n" + "A Z\n" + "A Z\n" + "A Z\n" + "B Y\n" + "B Z\n" + "B Z\n" + "C Z\n" + "A X\n" + "A Z\n" + "A Z\n" + "C X\n" + "A Z\n" + "C X\n" + "A Z\n" + "A X\n" + "C Z\n" + "C X\n" + "A Z\n" + "A Z\n" + "A Z\n" + "A Z\n" + "B Z\n" + "A Z\n" + "A Z\n" + "C Y\n" + "A Y\n" + "A Z\n" + "C Y\n" + "C Y\n" + "A Z\n" + "B Z\n" + "A Z\n" + "B Z\n" + "A Z\n" + "B Z\n" + "C Y\n" + "C X\n" + "C X\n" + "A Y\n" + "A Z\n" + "B Z\n" + "C X\n" + "A X\n" + "A Z\n" + "A Z\n" + "A Y\n" + "A Z\n" + "A Z\n" + "A Z\n" + "C X\n" + "C X\n" + "A Y\n" + "A Z\n" + "A Z\n" + "C X\n" + "B Z\n" + "B Y\n" + "A Y\n" + "A Z\n" + "B Z\n" + "A Z\n" + "A Z\n" + "A X\n" + "A Z\n" + "A Z\n" + "B Y\n" + "A Z\n" + "A Y\n" + "B Z\n" + "C X\n" + "A Z\n" + "A Z\n" + "A Z\n" + "C X\n" + "A Z\n" + "B Z\n" + "B Z\n" + "A Z\n" + "A Z\n" + "A Z\n" + "A Z\n" + "B Z\n" + "A Z\n" + "A Z\n" + "A Z\n" + "A Z\n" + "C X\n" + "C X\n" + "A Z\n" + "B X\n" + "A Z\n" + "B Y\n" + "C Z\n" + "A Z\n" + "A Z\n" + "A Z\n" + "C Z\n" + "A Z\n" + "B Y\n" + "A X\n" + "A Z\n" + "C Z\n" + "A Z\n" + "C Z\n" + "A Z\n" + "C X\n" + "A Y\n" + "C X\n" + "C Z\n" + "A Y\n" + "A Z\n" + "A Z\n" + "C X\n" + "C X\n" + "A Z\n" + "A Z\n" + "A Z\n" + "B Z\n" + "B Z\n" + "A Y\n" + "B Y\n" + "C Z\n" + "B Z\n" + "B X\n" + "A Z\n" + "A Z\n" + "A Z\n" + "C X\n" + "B Y\n" + "A Z\n" + "B Z\n" + "C X\n" + "A Z\n" + "A Z\n" + "C X\n" + "C X\n" + "A Z\n" + "A Z\n" + "A Z\n" + "A Z\n" + "B Z\n" + "A Z\n" + "A Z\n" + "A Z\n" + "A Z\n" + "A Z\n" + "B Z\n" + "A Z\n" + "A Z\n" + "B Z\n" + "A Y\n" + "A Z\n" + "B Y\n" + "A Z\n" + "A Z\n" + "A Z\n" + "B Z\n" + "A Z\n" + "A Z\n" + "C X\n" + "B Y\n" + "C X\n" + "A Y\n" + "C X\n" + "A Z\n" + "A Z\n" + "A Z\n" + "C X\n" + "B Z\n" + "A Z\n" + "A Z\n" + "A Z\n" + "A Z\n" + "A Z\n" + "C X\n" + "A Z\n" + "A Z\n" + "A Z\n" + "A Z\n" + "A Z\n" + "A Y\n" + "C X\n" + "B Y\n" + "C X\n" + "A Z\n" + "A Z\n" + "A Z\n" + "A Z\n" + "A Z\n" + "B Y\n" + "A Z\n" + "C X\n" + "A Z\n" + "A Z\n" + "A Z\n" + "A Z\n" + "A Z\n" + "A Z\n" + "A Z\n" + "C X\n" + "A Z\n" + "C X\n" + "A Y\n" + "B Z\n" + "A Z\n" + "C X\n" + "A Z\n" + "C X\n" + "B Z\n" + "B Z\n" + "A Z\n" + "A Z\n" + "A Z\n" + "C X\n" + "A Z\n" + "B Z\n" + "B Y\n" + "C X\n" + "C X\n" + "C X\n" + "B Z\n" + "A X\n" + "A Y\n" + "A Z\n" + "A Z\n" + "A Z\n" + "A Y\n" + "A Z\n" + "A Z\n" + "A Y\n" + "A X\n" + "A Y\n" + "C X\n" + "A Y\n" + "C X\n" + "B Z\n" + "B Y\n" + "C X\n" + "B Y\n" + "B Y\n" + "C X\n" + "A Z\n" + "A Z\n" + "B Z\n" + "C X\n" + "A Z\n" + "A Z\n" + "B Y\n" + "A Z\n" + "B Y\n" + "A Z\n" + "A X\n" + "C Y\n" + "C X\n" + "B Z\n" + "C X\n" + "A Z\n" + "A Z\n" + "A Z\n" + "C X\n" + "A Z\n" + "C X\n" + "A X\n" + "A Y\n" + "A Z\n" + "A Z\n" + "C X\n" + "A Y\n" + "A Z\n" + "B X\n" + "A Y\n" + "A Z\n" + "A Z\n" + "A Z\n" + "A Z\n" + "A Z\n" + "A Z\n" + "C X\n" + "A Z\n" + "C X\n" + "A Z\n" + "C Y\n" + "A Z\n" + "A Z\n" + "B Z\n" + "A Y\n" + "A Z\n" + "B Y\n" + "B Y\n" + "A Z\n" + "C X\n" + "A Z\n" + "C X\n" + "C Z\n" + "A Z\n" + "B Z\n" + "B Z\n" + "A Z\n" + "A Z\n" + "C X\n" + "C X\n" + "B Y\n" + "A Z\n" + "A Z\n" + "B Z\n" + "C Z\n" + "B Y\n" + "B Y\n" + "C X\n" + "A Z\n" + "A Z\n" + "B Y\n" + "A Z\n" + "C X\n" + "C Z\n" + "A Z\n" + "B Z\n" + "C X\n" + "A Y\n" + "C X\n" + "A Z\n" + "B Y\n" + "B Y\n" + "A Y\n" + "A Z\n" + "A Z\n" + "A Z\n" + "A Z\n" + "A Z\n" + "A Y\n" + "A Z\n" + "A Y\n" + "A Z\n" + "B Y\n" + "B Y\n" + "B Y\n" + "C X\n" + "A Z\n" + "A Z\n" + "A Y\n" + "A Z\n" + "A Z\n" + "C X\n" + "A Y\n" + "C X\n" + "A Z\n" + "A Z\n" + "A Z\n" + "B Y\n" + "A Z\n" + "A Z\n" + "B Z\n" + "C X\n" + "A Z\n" + "B Y\n" + "B Y\n" + "C X\n" + "C Z\n" + "B Y\n" + "A Z\n" + "A Z\n" + "A Z\n" + "C X\n" + "A Z\n" + "B Z\n" + "C Z\n" + "C X\n" + "B Y\n" + "A Z\n" + "A Z\n" + "A Y\n" + "A X\n" + "A Z\n" + "A Z\n" + "A Z\n" + "A Z\n" + "A Z\n" + "A Y\n" + "B Y\n" + "A Z\n" + "B Z\n" + "B Z\n" + "A Z\n" + "C Y\n" + "A X\n" + "A Z\n" + "A Z\n" + "C X\n" + "C X\n" + "C Y\n" + "B Y\n" + "B Y\n" + "B X\n" + "A Z\n" + "A Z\n" + "B Z\n" + "A Z";
        System.out.println(sol.getMaxScore(input));
    }
}