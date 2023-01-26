package interviewProblems.Advent_Of_Code_2022.Day_11.Part_2;


import java.util.*;
import java.util.function.Function;

public class Solution {
    public long computeMonkeyBusiness(String input, int rounds) {
        Monkey[] monkeys = this.createMonkeys(input);

        // Compute mod
        int mod = 1;
        for (Monkey mon : monkeys) mod *= mon.mod;

        long item;
        for (int i = 0; i < rounds; i++) {
            for (Monkey mon : monkeys) {
                // Apply to all items
                while (!mon.items.isEmpty()) {
                    item = mon.increaseWorry.apply(mon.items.poll());
                    monkeys[mon.testItem.apply(item) ? mon.testTrueId : mon.testFalseId].items.add(item % mod);
                    mon.inspection++;
                }
            }
        }

        // Sort monkeys by actions
        Arrays.sort(monkeys, (a,b) -> Long.compare(b.inspection, a.inspection));
        return monkeys[0].inspection * monkeys[1].inspection;
    }

    private Monkey[] createMonkeys(String input) {
        List<Monkey> monkeys = new ArrayList<>();
        Monkey curr = null;
        int step = 0;

        String[] lines = input.split("\n");
        for (String line : lines) {
            final String[] parts = line.split(" ");
            // Check if new monkey
            if (parts[0].equals("Monkey")) {
                curr = new Monkey(monkeys.size());
                step = 0;
            }
            // Check if finished monkey
            else if (line.isEmpty()) monkeys.add(curr);
                // Check for the config
            else {
                switch (step) {
                    case 0:
                        for (int i = 4; i < parts.length; i++) {
                            curr.items.add(Long.parseLong(parts[i].replaceAll(",", "")));
                        }
                        break;
                    case 1:
                        // 6 --> op
                        // 7 --> res
                        curr.increaseWorry = (a) -> {
                            if (parts[6].equals("*")) {
                                return a * (parts[7].equals("old") ? a : Integer.parseInt(parts[7]));
                            } else {
                                return a + (parts[7].equals("old") ? a : Integer.parseInt(parts[7]));
                            }
                        };
                        break;
                    case 2:
                        // 5 --> divisible by
                        curr.mod = Integer.parseInt(parts[5]);
                        break;
                    case 3:
                        // 9 --> Monkey that receives
                        curr.testTrueId = Integer.parseInt(parts[9]);
                        break;
                    case 4:
                        // 9 --> Monkey that receives
                        curr.testFalseId = Integer.parseInt(parts[9]);
                        break;
                }
                step++;
            }
        }
        // Add the last monkey
        monkeys.add(curr);

        return monkeys.toArray(new Monkey[0]);
    }

    private class Monkey {
        public Queue<Long> items = new LinkedList<>();
        public long inspection = 0;
        public int id;
        public int mod = 1;
        public int testTrueId = 0;
        public int testFalseId = 0;
        public Function<Long, Long> increaseWorry;
        public Function<Long, Boolean> testItem =  (item) -> item % mod == 0;
        public Monkey(int id) {
            this.id = id;
        }
    }
}