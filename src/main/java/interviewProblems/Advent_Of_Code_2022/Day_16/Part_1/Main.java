package interviewProblems.Advent_Of_Code_2022.Day_16.Part_1;

// ---------------------------------- SOLVED ----------------------------------
// --------------------------- NONE / December 2022 ---------------------------

/**
 * Original problem: https://adventofcode.com/2022/day/16
 * The sensors have led you to the origin of the distress signal: yet another handheld device, just like the one the Elves gave you. However, you don't see any Elves around; instead, the device is surrounded by elephants! They must have gotten lost in these tunnels, and one of the elephants apparently figured out how to turn on the distress signal.
 * <p>
 * The ground rumbles again, much stronger this time. What kind of cave is this, exactly? You scan the cave with your handheld device; it reports mostly igneous rock, some ash, pockets of pressurized gas, magma... this isn't just a cave, it's a volcano!
 * <p>
 * You need to get the elephants out of here, quickly. Your device estimates that you have 30 minutes before the volcano erupts, so you don't have time to go back out the way you came in.
 * <p>
 * You scan the cave for other options and discover a network of pipes and pressure-release valves. You aren't sure how such a system got into a volcano, but you don't have time to complain; your device produces a report (your puzzle input) of each valve's flow rate if it were opened (in pressure per minute) and the tunnels you could use to move between the valves.
 * <p>
 * There's even a valve in the room you and the elephants are currently standing in labeled AA. You estimate it will take you one minute to open a single valve and one minute to follow any tunnel from one valve to another. What is the most pressure you could release?
 * <p>
 * For example, suppose you had the following scan output:
 * <p>
 * Valve AA has flow rate=0; tunnels lead to valves DD, II, BB
 * Valve BB has flow rate=13; tunnels lead to valves CC, AA
 * Valve CC has flow rate=2; tunnels lead to valves DD, BB
 * Valve DD has flow rate=20; tunnels lead to valves CC, AA, EE
 * Valve EE has flow rate=3; tunnels lead to valves FF, DD
 * Valve FF has flow rate=0; tunnels lead to valves EE, GG
 * Valve GG has flow rate=0; tunnels lead to valves FF, HH
 * Valve HH has flow rate=22; tunnel leads to valve GG
 * Valve II has flow rate=0; tunnels lead to valves AA, JJ
 * Valve JJ has flow rate=21; tunnel leads to valve II
 * All of the valves begin closed. You start at valve AA, but it must be damaged or jammed or something: its flow rate is 0, so there's no point in opening it. However, you could spend one minute moving to valve BB and another minute opening it; doing so would release pressure during the remaining 28 minutes at a flow rate of 13, a total eventual pressure release of 28 * 13 = 364. Then, you could spend your third minute moving to valve CC and your fourth minute opening it, providing an additional 26 minutes of eventual pressure release at a flow rate of 2, or 52 total pressure released by valve CC.
 * <p>
 * Making your way through the tunnels like this, you could probably open many or all of the valves by the time 30 minutes have elapsed. However, you need to release as much pressure as possible, so you'll need to be methodical. Instead, consider this approach:
 * <p>
 * == Minute 1 ==
 * No valves are open.
 * You move to valve DD.
 * <p>
 * == Minute 2 ==
 * No valves are open.
 * You open valve DD.
 * <p>
 * == Minute 3 ==
 * Valve DD is open, releasing 20 pressure.
 * You move to valve CC.
 * <p>
 * == Minute 4 ==
 * Valve DD is open, releasing 20 pressure.
 * You move to valve BB.
 * <p>
 * == Minute 5 ==
 * Valve DD is open, releasing 20 pressure.
 * You open valve BB.
 * <p>
 * == Minute 6 ==
 * Valves BB and DD are open, releasing 33 pressure.
 * You move to valve AA.
 * <p>
 * == Minute 7 ==
 * Valves BB and DD are open, releasing 33 pressure.
 * You move to valve II.
 * <p>
 * == Minute 8 ==
 * Valves BB and DD are open, releasing 33 pressure.
 * You move to valve JJ.
 * <p>
 * == Minute 9 ==
 * Valves BB and DD are open, releasing 33 pressure.
 * You open valve JJ.
 * <p>
 * == Minute 10 ==
 * Valves BB, DD, and JJ are open, releasing 54 pressure.
 * You move to valve II.
 * <p>
 * == Minute 11 ==
 * Valves BB, DD, and JJ are open, releasing 54 pressure.
 * You move to valve AA.
 * <p>
 * == Minute 12 ==
 * Valves BB, DD, and JJ are open, releasing 54 pressure.
 * You move to valve DD.
 * <p>
 * == Minute 13 ==
 * Valves BB, DD, and JJ are open, releasing 54 pressure.
 * You move to valve EE.
 * <p>
 * == Minute 14 ==
 * Valves BB, DD, and JJ are open, releasing 54 pressure.
 * You move to valve FF.
 * <p>
 * == Minute 15 ==
 * Valves BB, DD, and JJ are open, releasing 54 pressure.
 * You move to valve GG.
 * <p>
 * == Minute 16 ==
 * Valves BB, DD, and JJ are open, releasing 54 pressure.
 * You move to valve HH.
 * <p>
 * == Minute 17 ==
 * Valves BB, DD, and JJ are open, releasing 54 pressure.
 * You open valve HH.
 * <p>
 * == Minute 18 ==
 * Valves BB, DD, HH, and JJ are open, releasing 76 pressure.
 * You move to valve GG.
 * <p>
 * == Minute 19 ==
 * Valves BB, DD, HH, and JJ are open, releasing 76 pressure.
 * You move to valve FF.
 * <p>
 * == Minute 20 ==
 * Valves BB, DD, HH, and JJ are open, releasing 76 pressure.
 * You move to valve EE.
 * <p>
 * == Minute 21 ==
 * Valves BB, DD, HH, and JJ are open, releasing 76 pressure.
 * You open valve EE.
 * <p>
 * == Minute 22 ==
 * Valves BB, DD, EE, HH, and JJ are open, releasing 79 pressure.
 * You move to valve DD.
 * <p>
 * == Minute 23 ==
 * Valves BB, DD, EE, HH, and JJ are open, releasing 79 pressure.
 * You move to valve CC.
 * <p>
 * == Minute 24 ==
 * Valves BB, DD, EE, HH, and JJ are open, releasing 79 pressure.
 * You open valve CC.
 * <p>
 * == Minute 25 ==
 * Valves BB, CC, DD, EE, HH, and JJ are open, releasing 81 pressure.
 * <p>
 * == Minute 26 ==
 * Valves BB, CC, DD, EE, HH, and JJ are open, releasing 81 pressure.
 * <p>
 * == Minute 27 ==
 * Valves BB, CC, DD, EE, HH, and JJ are open, releasing 81 pressure.
 * <p>
 * == Minute 28 ==
 * Valves BB, CC, DD, EE, HH, and JJ are open, releasing 81 pressure.
 * <p>
 * == Minute 29 ==
 * Valves BB, CC, DD, EE, HH, and JJ are open, releasing 81 pressure.
 * <p>
 * == Minute 30 ==
 * Valves BB, CC, DD, EE, HH, and JJ are open, releasing 81 pressure.
 * This approach lets you release the most pressure possible in 30 minutes with this valve layout, 1651.
 * <p>
 * Work out the steps to release the most pressure in 30 minutes. What is the most pressure you can release?
 */
class Main {
    public static void main(String[] args) {
        Solution sol = new Solution();
        String input = "Valve AA has flow rate=0; tunnels lead to valves DD, II, BB\n" + "Valve BB has flow rate=13; tunnels lead to valves CC, AA\n" + "Valve CC has flow rate=2; tunnels lead to valves DD, BB\n" + "Valve DD has flow rate=20; tunnels lead to valves CC, AA, EE\n" + "Valve EE has flow rate=3; tunnels lead to valves FF, DD\n" + "Valve FF has flow rate=0; tunnels lead to valves EE, GG\n" + "Valve GG has flow rate=0; tunnels lead to valves FF, HH\n" + "Valve HH has flow rate=22; tunnel leads to valve GG\n" + "Valve II has flow rate=0; tunnels lead to valves AA, JJ\n" + "Valve JJ has flow rate=21; tunnel leads to valve II";
        System.out.println(sol.openVents(input, "AA", 30));
        input = "Valve JZ has flow rate=0; tunnels lead to valves IR, LY\n" + "Valve KD has flow rate=0; tunnels lead to valves NJ, ZS\n" + "Valve VW has flow rate=0; tunnels lead to valves IT, VH\n" + "Valve HS has flow rate=0; tunnels lead to valves OC, PN\n" + "Valve EU has flow rate=19; tunnel leads to valve GQ\n" + "Valve XF has flow rate=0; tunnels lead to valves WL, QD\n" + "Valve DD has flow rate=8; tunnels lead to valves GQ, YY, JV, SK\n" + "Valve TA has flow rate=0; tunnels lead to valves NJ, VJ\n" + "Valve IR has flow rate=9; tunnels lead to valves JZ, WI, VJ, GC, WG\n" + "Valve SS has flow rate=17; tunnels lead to valves SI, IZ, RK, WI\n" + "Valve SG has flow rate=0; tunnels lead to valves NV, NJ\n" + "Valve IT has flow rate=0; tunnels lead to valves LL, VW\n" + "Valve CP has flow rate=24; tunnels lead to valves HN, ZK, EJ\n" + "Valve SK has flow rate=0; tunnels lead to valves LL, DD\n" + "Valve IS has flow rate=0; tunnels lead to valves AA, LL\n" + "Valve HN has flow rate=0; tunnels lead to valves FF, CP\n" + "Valve VH has flow rate=10; tunnels lead to valves QO, VW, RV, PN\n" + "Valve JV has flow rate=0; tunnels lead to valves DD, RK\n" + "Valve ZS has flow rate=0; tunnels lead to valves KD, LL\n" + "Valve UC has flow rate=25; tunnels lead to valves JD, IV\n" + "Valve WI has flow rate=0; tunnels lead to valves SS, IR\n" + "Valve UR has flow rate=0; tunnels lead to valves QD, LY\n" + "Valve GC has flow rate=0; tunnels lead to valves AA, IR\n" + "Valve YY has flow rate=0; tunnels lead to valves DD, AA\n" + "Valve IV has flow rate=0; tunnels lead to valves ZK, UC\n" + "Valve BM has flow rate=0; tunnels lead to valves SA, WL\n" + "Valve JD has flow rate=0; tunnels lead to valves IZ, UC\n" + "Valve WL has flow rate=12; tunnels lead to valves EF, BM, EJ, XF\n" + "Valve AA has flow rate=0; tunnels lead to valves NV, YY, GC, IS, QO\n" + "Valve WG has flow rate=0; tunnels lead to valves LL, IR\n" + "Valve GQ has flow rate=0; tunnels lead to valves EU, DD\n" + "Valve SI has flow rate=0; tunnels lead to valves SS, NJ\n" + "Valve KH has flow rate=13; tunnels lead to valves SA, ON\n" + "Valve PC has flow rate=22; tunnel leads to valve ON\n" + "Valve QD has flow rate=14; tunnels lead to valves XF, UR\n" + "Valve IZ has flow rate=0; tunnels lead to valves SS, JD\n" + "Valve QO has flow rate=0; tunnels lead to valves AA, VH\n" + "Valve SA has flow rate=0; tunnels lead to valves BM, KH\n" + "Valve NV has flow rate=0; tunnels lead to valves AA, SG\n" + "Valve ZK has flow rate=0; tunnels lead to valves CP, IV\n" + "Valve ON has flow rate=0; tunnels lead to valves PC, KH\n" + "Valve PN has flow rate=0; tunnels lead to valves HS, VH\n" + "Valve RV has flow rate=0; tunnels lead to valves NJ, VH\n" + "Valve RK has flow rate=0; tunnels lead to valves SS, JV\n" + "Valve OC has flow rate=18; tunnel leads to valve HS\n" + "Valve EF has flow rate=0; tunnels lead to valves LY, WL\n" + "Valve VJ has flow rate=0; tunnels lead to valves TA, IR\n" + "Valve LL has flow rate=5; tunnels lead to valves ZS, IT, SK, IS, WG\n" + "Valve FF has flow rate=0; tunnels lead to valves HN, LY\n" + "Valve LY has flow rate=21; tunnels lead to valves EF, FF, UR, JZ\n" + "Valve EJ has flow rate=0; tunnels lead to valves WL, CP\n" + "Valve NJ has flow rate=6; tunnels lead to valves RV, KD, SG, SI, TA";
        System.out.println(sol.openVents(input, "AA", 30));
    }
}