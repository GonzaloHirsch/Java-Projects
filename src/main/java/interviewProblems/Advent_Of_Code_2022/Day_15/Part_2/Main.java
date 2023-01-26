package interviewProblems.Advent_Of_Code_2022.Day_15.Part_2;

// ---------------------------------- SOLVED ----------------------------------
// --------------------------- NONE / December 2022 ---------------------------

/**
 * Original problem: https://adventofcode.com/2022/day/15#part2
 * Your handheld device indicates that the distress signal is coming from a beacon nearby. The distress beacon is not detected by any sensor, but the distress beacon must have x and y coordinates each no lower than 0 and no larger than 4000000.
 *
 * To isolate the distress beacon's signal, you need to determine its tuning frequency, which can be found by multiplying its x coordinate by 4000000 and then adding its y coordinate.
 *
 * In the example above, the search space is smaller: instead, the x and y coordinates can each be at most 20. With this reduced search area, there is only a single position that could have a beacon: x=14, y=11. The tuning frequency for this distress beacon is 56000011.
 *
 * Find the only possible position for the distress beacon. What is its tuning frequency?
 */
class Main {
    public static void main(String[] args) {
        Solution sol = new Solution();
        String input = "Sensor at x=2, y=18: closest beacon is at x=-2, y=15\n" + "Sensor at x=9, y=16: closest beacon is at x=10, y=16\n" + "Sensor at x=13, y=2: closest beacon is at x=15, y=3\n" + "Sensor at x=12, y=14: closest beacon is at x=10, y=16\n" + "Sensor at x=10, y=20: closest beacon is at x=10, y=16\n" + "Sensor at x=14, y=17: closest beacon is at x=10, y=16\n" + "Sensor at x=8, y=7: closest beacon is at x=2, y=10\n" + "Sensor at x=2, y=0: closest beacon is at x=2, y=10\n" + "Sensor at x=0, y=11: closest beacon is at x=2, y=10\n" + "Sensor at x=20, y=14: closest beacon is at x=25, y=17\n" + "Sensor at x=17, y=20: closest beacon is at x=21, y=22\n" + "Sensor at x=16, y=7: closest beacon is at x=15, y=3\n" + "Sensor at x=14, y=3: closest beacon is at x=15, y=3\n" + "Sensor at x=20, y=1: closest beacon is at x=15, y=3";
        System.out.println(sol.findFrequency(input, new int[]{0, 20}, new int[]{0, 20}));
        input = "Sensor at x=3772068, y=2853720: closest beacon is at x=4068389, y=2345925\n" + "Sensor at x=78607, y=2544104: closest beacon is at x=-152196, y=4183739\n" + "Sensor at x=3239531, y=3939220: closest beacon is at x=3568548, y=4206192\n" + "Sensor at x=339124, y=989831: closest beacon is at x=570292, y=1048239\n" + "Sensor at x=3957534, y=2132743: closest beacon is at x=3897332, y=2000000\n" + "Sensor at x=1882965, y=3426126: closest beacon is at x=2580484, y=3654136\n" + "Sensor at x=1159443, y=3861139: closest beacon is at x=2580484, y=3654136\n" + "Sensor at x=2433461, y=287013: closest beacon is at x=2088099, y=-190228\n" + "Sensor at x=3004122, y=3483833: closest beacon is at x=2580484, y=3654136\n" + "Sensor at x=3571821, y=799602: closest beacon is at x=3897332, y=2000000\n" + "Sensor at x=2376562, y=1539540: closest beacon is at x=2700909, y=2519581\n" + "Sensor at x=785113, y=1273008: closest beacon is at x=570292, y=1048239\n" + "Sensor at x=1990787, y=38164: closest beacon is at x=2088099, y=-190228\n" + "Sensor at x=3993778, y=3482849: closest beacon is at x=4247709, y=3561264\n" + "Sensor at x=3821391, y=3986080: closest beacon is at x=3568548, y=4206192\n" + "Sensor at x=2703294, y=3999015: closest beacon is at x=2580484, y=3654136\n" + "Sensor at x=1448314, y=2210094: closest beacon is at x=2700909, y=2519581\n" + "Sensor at x=3351224, y=2364892: closest beacon is at x=4068389, y=2345925\n" + "Sensor at x=196419, y=3491556: closest beacon is at x=-152196, y=4183739\n" + "Sensor at x=175004, y=138614: closest beacon is at x=570292, y=1048239\n" + "Sensor at x=1618460, y=806488: closest beacon is at x=570292, y=1048239\n" + "Sensor at x=3974730, y=1940193: closest beacon is at x=3897332, y=2000000\n" + "Sensor at x=2995314, y=2961775: closest beacon is at x=2700909, y=2519581\n" + "Sensor at x=105378, y=1513086: closest beacon is at x=570292, y=1048239\n" + "Sensor at x=3576958, y=3665667: closest beacon is at x=3568548, y=4206192\n" + "Sensor at x=2712265, y=2155055: closest beacon is at x=2700909, y=2519581";
        System.out.println(sol.findFrequency(input, new int[]{0, 4000000}, new int[]{0, 4000000}));
    }
}