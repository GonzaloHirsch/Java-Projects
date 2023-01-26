package interviewProblems.Advent_Of_Code_2022.Day_16.Part_2;

// ---------------------------------- SOLVED ----------------------------------
// --------------------------- NONE / December 2022 ---------------------------

/**
 * Original problem: https://adventofcode.com/2022/day/16#part2
 * You're worried that even with an optimal approach, the pressure released won't be enough. What if you got one of the elephants to help you?
 *
 * It would take you 4 minutes to teach an elephant how to open the right valves in the right order, leaving you with only 26 minutes to actually execute your plan. Would having two of you working together be better, even if it means having less time? (Assume that you teach the elephant before opening any valves yourself, giving you both the same full 26 minutes.)
 *
 * In the example above, you could teach the elephant to help you as follows:
 *
 * == Minute 1 ==
 * No valves are open.
 * You move to valve II.
 * The elephant moves to valve DD.
 *
 * == Minute 2 ==
 * No valves are open.
 * You move to valve JJ.
 * The elephant opens valve DD.
 *
 * == Minute 3 ==
 * Valve DD is open, releasing 20 pressure.
 * You open valve JJ.
 * The elephant moves to valve EE.
 *
 * == Minute 4 ==
 * Valves DD and JJ are open, releasing 41 pressure.
 * You move to valve II.
 * The elephant moves to valve FF.
 *
 * == Minute 5 ==
 * Valves DD and JJ are open, releasing 41 pressure.
 * You move to valve AA.
 * The elephant moves to valve GG.
 *
 * == Minute 6 ==
 * Valves DD and JJ are open, releasing 41 pressure.
 * You move to valve BB.
 * The elephant moves to valve HH.
 *
 * == Minute 7 ==
 * Valves DD and JJ are open, releasing 41 pressure.
 * You open valve BB.
 * The elephant opens valve HH.
 *
 * == Minute 8 ==
 * Valves BB, DD, HH, and JJ are open, releasing 76 pressure.
 * You move to valve CC.
 * The elephant moves to valve GG.
 *
 * == Minute 9 ==
 * Valves BB, DD, HH, and JJ are open, releasing 76 pressure.
 * You open valve CC.
 * The elephant moves to valve FF.
 *
 * == Minute 10 ==
 * Valves BB, CC, DD, HH, and JJ are open, releasing 78 pressure.
 * The elephant moves to valve EE.
 *
 * == Minute 11 ==
 * Valves BB, CC, DD, HH, and JJ are open, releasing 78 pressure.
 * The elephant opens valve EE.
 *
 * (At this point, all valves are open.)
 *
 * == Minute 12 ==
 * Valves BB, CC, DD, EE, HH, and JJ are open, releasing 81 pressure.
 *
 * ...
 *
 * == Minute 20 ==
 * Valves BB, CC, DD, EE, HH, and JJ are open, releasing 81 pressure.
 *
 * ...
 *
 * == Minute 26 ==
 * Valves BB, CC, DD, EE, HH, and JJ are open, releasing 81 pressure.
 * With the elephant helping, after 26 minutes, the best you could do would release a total of 1707 pressure.
 *
 * With you and an elephant working together for 26 minutes, what is the most pressure you could release?
 */
class Main {
    public static void main(String[] args) {
        Solution sol = new Solution();
        String input = "Valve AA has flow rate=0; tunnels lead to valves DD, II, BB\n" + "Valve BB has flow rate=13; tunnels lead to valves CC, AA\n" + "Valve CC has flow rate=2; tunnels lead to valves DD, BB\n" + "Valve DD has flow rate=20; tunnels lead to valves CC, AA, EE\n" + "Valve EE has flow rate=3; tunnels lead to valves FF, DD\n" + "Valve FF has flow rate=0; tunnels lead to valves EE, GG\n" + "Valve GG has flow rate=0; tunnels lead to valves FF, HH\n" + "Valve HH has flow rate=22; tunnel leads to valve GG\n" + "Valve II has flow rate=0; tunnels lead to valves AA, JJ\n" + "Valve JJ has flow rate=21; tunnel leads to valve II";
        System.out.println(sol.openVents(input, "AA", 26));
        input = "Valve JZ has flow rate=0; tunnels lead to valves IR, LY\n" + "Valve KD has flow rate=0; tunnels lead to valves NJ, ZS\n" + "Valve VW has flow rate=0; tunnels lead to valves IT, VH\n" + "Valve HS has flow rate=0; tunnels lead to valves OC, PN\n" + "Valve EU has flow rate=19; tunnel leads to valve GQ\n" + "Valve XF has flow rate=0; tunnels lead to valves WL, QD\n" + "Valve DD has flow rate=8; tunnels lead to valves GQ, YY, JV, SK\n" + "Valve TA has flow rate=0; tunnels lead to valves NJ, VJ\n" + "Valve IR has flow rate=9; tunnels lead to valves JZ, WI, VJ, GC, WG\n" + "Valve SS has flow rate=17; tunnels lead to valves SI, IZ, RK, WI\n" + "Valve SG has flow rate=0; tunnels lead to valves NV, NJ\n" + "Valve IT has flow rate=0; tunnels lead to valves LL, VW\n" + "Valve CP has flow rate=24; tunnels lead to valves HN, ZK, EJ\n" + "Valve SK has flow rate=0; tunnels lead to valves LL, DD\n" + "Valve IS has flow rate=0; tunnels lead to valves AA, LL\n" + "Valve HN has flow rate=0; tunnels lead to valves FF, CP\n" + "Valve VH has flow rate=10; tunnels lead to valves QO, VW, RV, PN\n" + "Valve JV has flow rate=0; tunnels lead to valves DD, RK\n" + "Valve ZS has flow rate=0; tunnels lead to valves KD, LL\n" + "Valve UC has flow rate=25; tunnels lead to valves JD, IV\n" + "Valve WI has flow rate=0; tunnels lead to valves SS, IR\n" + "Valve UR has flow rate=0; tunnels lead to valves QD, LY\n" + "Valve GC has flow rate=0; tunnels lead to valves AA, IR\n" + "Valve YY has flow rate=0; tunnels lead to valves DD, AA\n" + "Valve IV has flow rate=0; tunnels lead to valves ZK, UC\n" + "Valve BM has flow rate=0; tunnels lead to valves SA, WL\n" + "Valve JD has flow rate=0; tunnels lead to valves IZ, UC\n" + "Valve WL has flow rate=12; tunnels lead to valves EF, BM, EJ, XF\n" + "Valve AA has flow rate=0; tunnels lead to valves NV, YY, GC, IS, QO\n" + "Valve WG has flow rate=0; tunnels lead to valves LL, IR\n" + "Valve GQ has flow rate=0; tunnels lead to valves EU, DD\n" + "Valve SI has flow rate=0; tunnels lead to valves SS, NJ\n" + "Valve KH has flow rate=13; tunnels lead to valves SA, ON\n" + "Valve PC has flow rate=22; tunnel leads to valve ON\n" + "Valve QD has flow rate=14; tunnels lead to valves XF, UR\n" + "Valve IZ has flow rate=0; tunnels lead to valves SS, JD\n" + "Valve QO has flow rate=0; tunnels lead to valves AA, VH\n" + "Valve SA has flow rate=0; tunnels lead to valves BM, KH\n" + "Valve NV has flow rate=0; tunnels lead to valves AA, SG\n" + "Valve ZK has flow rate=0; tunnels lead to valves CP, IV\n" + "Valve ON has flow rate=0; tunnels lead to valves PC, KH\n" + "Valve PN has flow rate=0; tunnels lead to valves HS, VH\n" + "Valve RV has flow rate=0; tunnels lead to valves NJ, VH\n" + "Valve RK has flow rate=0; tunnels lead to valves SS, JV\n" + "Valve OC has flow rate=18; tunnel leads to valve HS\n" + "Valve EF has flow rate=0; tunnels lead to valves LY, WL\n" + "Valve VJ has flow rate=0; tunnels lead to valves TA, IR\n" + "Valve LL has flow rate=5; tunnels lead to valves ZS, IT, SK, IS, WG\n" + "Valve FF has flow rate=0; tunnels lead to valves HN, LY\n" + "Valve LY has flow rate=21; tunnels lead to valves EF, FF, UR, JZ\n" + "Valve EJ has flow rate=0; tunnels lead to valves WL, CP\n" + "Valve NJ has flow rate=6; tunnels lead to valves RV, KD, SG, SI, TA";
        System.out.println(sol.openVents(input, "AA", 26));
    }
}