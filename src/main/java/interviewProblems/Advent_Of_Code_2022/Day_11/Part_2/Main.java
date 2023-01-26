package interviewProblems.Advent_Of_Code_2022.Day_11.Part_2;

// ---------------------------------- SOLVED ----------------------------------
// --------------------------- NONE / December 2022 ---------------------------

/**
 * Original problem: https://adventofcode.com/2022/day/11#part2
 *You're worried you might not ever get your items back. So worried, in fact, that your relief that a monkey's inspection didn't damage an item no longer causes your worry level to be divided by three.
 *
 * Unfortunately, that relief was all that was keeping your worry levels from reaching ridiculous levels. You'll need to find another way to keep your worry levels manageable.
 *
 * At this rate, you might be putting up with these monkeys for a very long time - possibly 10000 rounds!
 *
 * With these new rules, you can still figure out the monkey business after 10000 rounds. Using the same example above:
 *
 * == After round 1 ==
 * Monkey 0 inspected items 2 times.
 * Monkey 1 inspected items 4 times.
 * Monkey 2 inspected items 3 times.
 * Monkey 3 inspected items 6 times.
 *
 * == After round 20 ==
 * Monkey 0 inspected items 99 times.
 * Monkey 1 inspected items 97 times.
 * Monkey 2 inspected items 8 times.
 * Monkey 3 inspected items 103 times.
 *
 * == After round 1000 ==
 * Monkey 0 inspected items 5204 times.
 * Monkey 1 inspected items 4792 times.
 * Monkey 2 inspected items 199 times.
 * Monkey 3 inspected items 5192 times.
 *
 * == After round 2000 ==
 * Monkey 0 inspected items 10419 times.
 * Monkey 1 inspected items 9577 times.
 * Monkey 2 inspected items 392 times.
 * Monkey 3 inspected items 10391 times.
 *
 * == After round 3000 ==
 * Monkey 0 inspected items 15638 times.
 * Monkey 1 inspected items 14358 times.
 * Monkey 2 inspected items 587 times.
 * Monkey 3 inspected items 15593 times.
 *
 * == After round 4000 ==
 * Monkey 0 inspected items 20858 times.
 * Monkey 1 inspected items 19138 times.
 * Monkey 2 inspected items 780 times.
 * Monkey 3 inspected items 20797 times.
 *
 * == After round 5000 ==
 * Monkey 0 inspected items 26075 times.
 * Monkey 1 inspected items 23921 times.
 * Monkey 2 inspected items 974 times.
 * Monkey 3 inspected items 26000 times.
 *
 * == After round 6000 ==
 * Monkey 0 inspected items 31294 times.
 * Monkey 1 inspected items 28702 times.
 * Monkey 2 inspected items 1165 times.
 * Monkey 3 inspected items 31204 times.
 *
 * == After round 7000 ==
 * Monkey 0 inspected items 36508 times.
 * Monkey 1 inspected items 33488 times.
 * Monkey 2 inspected items 1360 times.
 * Monkey 3 inspected items 36400 times.
 *
 * == After round 8000 ==
 * Monkey 0 inspected items 41728 times.
 * Monkey 1 inspected items 38268 times.
 * Monkey 2 inspected items 1553 times.
 * Monkey 3 inspected items 41606 times.
 *
 * == After round 9000 ==
 * Monkey 0 inspected items 46945 times.
 * Monkey 1 inspected items 43051 times.
 * Monkey 2 inspected items 1746 times.
 * Monkey 3 inspected items 46807 times.
 *
 * == After round 10000 ==
 * Monkey 0 inspected items 52166 times.
 * Monkey 1 inspected items 47830 times.
 * Monkey 2 inspected items 1938 times.
 * Monkey 3 inspected items 52013 times.
 * After 10000 rounds, the two most active monkeys inspected items 52166 and 52013 times. Multiplying these together, the level of monkey business in this situation is now 2713310158.
 *
 * Worry levels are no longer divided by three after each item is inspected; you'll need to find another way to keep your worry levels manageable. Starting again from the initial state in your puzzle input, what is the level of monkey business after 10000 rounds?
 */
class Main {
    public static void main(String[] args) {
        Solution sol = new Solution();
        String input = "Monkey 0:\n" + "  Starting items: 79, 98\n" + "  Operation: new = old * 19\n" + "  Test: divisible by 23\n" + "    If true: throw to monkey 2\n" + "    If false: throw to monkey 3\n" + "\n" + "Monkey 1:\n" + "  Starting items: 54, 65, 75, 74\n" + "  Operation: new = old + 6\n" + "  Test: divisible by 19\n" + "    If true: throw to monkey 2\n" + "    If false: throw to monkey 0\n" + "\n" + "Monkey 2:\n" + "  Starting items: 79, 60, 97\n" + "  Operation: new = old * old\n" + "  Test: divisible by 13\n" + "    If true: throw to monkey 1\n" + "    If false: throw to monkey 3\n" + "\n" + "Monkey 3:\n" + "  Starting items: 74\n" + "  Operation: new = old + 3\n" + "  Test: divisible by 17\n" + "    If true: throw to monkey 0\n" + "    If false: throw to monkey 1";
        System.out.println(sol.computeMonkeyBusiness(input, 10000));
        input = "Monkey 0:\n" + "  Starting items: 75, 63\n" + "  Operation: new = old * 3\n" + "  Test: divisible by 11\n" + "    If true: throw to monkey 7\n" + "    If false: throw to monkey 2\n" + "\n" + "Monkey 1:\n" + "  Starting items: 65, 79, 98, 77, 56, 54, 83, 94\n" + "  Operation: new = old + 3\n" + "  Test: divisible by 2\n" + "    If true: throw to monkey 2\n" + "    If false: throw to monkey 0\n" + "\n" + "Monkey 2:\n" + "  Starting items: 66\n" + "  Operation: new = old + 5\n" + "  Test: divisible by 5\n" + "    If true: throw to monkey 7\n" + "    If false: throw to monkey 5\n" + "\n" + "Monkey 3:\n" + "  Starting items: 51, 89, 90\n" + "  Operation: new = old * 19\n" + "  Test: divisible by 7\n" + "    If true: throw to monkey 6\n" + "    If false: throw to monkey 4\n" + "\n" + "Monkey 4:\n" + "  Starting items: 75, 94, 66, 90, 77, 82, 61\n" + "  Operation: new = old + 1\n" + "  Test: divisible by 17\n" + "    If true: throw to monkey 6\n" + "    If false: throw to monkey 1\n" + "\n" + "Monkey 5:\n" + "  Starting items: 53, 76, 59, 92, 95\n" + "  Operation: new = old + 2\n" + "  Test: divisible by 19\n" + "    If true: throw to monkey 4\n" + "    If false: throw to monkey 3\n" + "\n" + "Monkey 6:\n" + "  Starting items: 81, 61, 75, 89, 70, 92\n" + "  Operation: new = old * old\n" + "  Test: divisible by 3\n" + "    If true: throw to monkey 0\n" + "    If false: throw to monkey 1\n" + "\n" + "Monkey 7:\n" + "  Starting items: 81, 86, 62, 87\n" + "  Operation: new = old + 8\n" + "  Test: divisible by 13\n" + "    If true: throw to monkey 3\n" + "    If false: throw to monkey 5";
        System.out.println(sol.computeMonkeyBusiness(input, 10000));
    }
}