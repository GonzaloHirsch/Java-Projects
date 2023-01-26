package interviewProblems.Advent_Of_Code_2022.Day_13.Part_1;

// ---------------------------------- SOLVED ----------------------------------
// --------------------------- NONE / December 2022 ---------------------------

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Original problem: https://adventofcode.com/2022/day/13
 * You climb the hill and again try contacting the Elves. However, you instead receive a signal you weren't expecting: a distress signal.
 * <p>
 * Your handheld device must still not be working properly; the packets from the distress signal got decoded out of order. You'll need to re-order the list of received packets (your puzzle input) to decode the message.
 * <p>
 * Your list consists of pairs of packets; pairs are separated by a blank line. You need to identify how many pairs of packets are in the right order.
 * <p>
 * For example:
 * <p>
 * [1,1,3,1,1]
 * [1,1,5,1,1]
 * <p>
 * [[1],[2,3,4]]
 * [[1],4]
 * <p>
 * [9]
 * [[8,7,6]]
 * <p>
 * [[4,4],4,4]
 * [[4,4],4,4,4]
 * <p>
 * [7,7,7,7]
 * [7,7,7]
 * <p>
 * []
 * [3]
 * <p>
 * [[[]]]
 * [[]]
 * <p>
 * [1,[2,[3,[4,[5,6,7]]]],8,9]
 * [1,[2,[3,[4,[5,6,0]]]],8,9]
 * Packet data consists of lists and integers. Each list starts with [, ends with ], and contains zero or more comma-separated values (either integers or other lists). Each packet is always a list and appears on its own line.
 * <p>
 * When comparing two values, the first value is called left and the second value is called right. Then:
 * <p>
 * If both values are integers, the lower integer should come first. If the left integer is lower than the right integer, the inputs are in the right order. If the left integer is higher than the right integer, the inputs are not in the right order. Otherwise, the inputs are the same integer; continue checking the next part of the input.
 * If both values are lists, compare the first value of each list, then the second value, and so on. If the left list runs out of items first, the inputs are in the right order. If the right list runs out of items first, the inputs are not in the right order. If the lists are the same length and no comparison makes a decision about the order, continue checking the next part of the input.
 * If exactly one value is an integer, convert the integer to a list which contains that integer as its only value, then retry the comparison. For example, if comparing [0,0,0] and 2, convert the right value to [2] (a list containing 2); the result is then found by instead comparing [0,0,0] and [2].
 * Using these rules, you can determine which of the pairs in the example are in the right order:
 * <p>
 * == Pair 1 ==
 * - Compare [1,1,3,1,1] vs [1,1,5,1,1]
 * - Compare 1 vs 1
 * - Compare 1 vs 1
 * - Compare 3 vs 5
 * - Left side is smaller, so inputs are in the right order
 * <p>
 * == Pair 2 ==
 * - Compare [[1],[2,3,4]] vs [[1],4]
 * - Compare [1] vs [1]
 * - Compare 1 vs 1
 * - Compare [2,3,4] vs 4
 * - Mixed types; convert right to [4] and retry comparison
 * - Compare [2,3,4] vs [4]
 * - Compare 2 vs 4
 * - Left side is smaller, so inputs are in the right order
 * <p>
 * == Pair 3 ==
 * - Compare [9] vs [[8,7,6]]
 * - Compare 9 vs [8,7,6]
 * - Mixed types; convert left to [9] and retry comparison
 * - Compare [9] vs [8,7,6]
 * - Compare 9 vs 8
 * - Right side is smaller, so inputs are not in the right order
 * <p>
 * == Pair 4 ==
 * - Compare [[4,4],4,4] vs [[4,4],4,4,4]
 * - Compare [4,4] vs [4,4]
 * - Compare 4 vs 4
 * - Compare 4 vs 4
 * - Compare 4 vs 4
 * - Compare 4 vs 4
 * - Left side ran out of items, so inputs are in the right order
 * <p>
 * == Pair 5 ==
 * - Compare [7,7,7,7] vs [7,7,7]
 * - Compare 7 vs 7
 * - Compare 7 vs 7
 * - Compare 7 vs 7
 * - Right side ran out of items, so inputs are not in the right order
 * <p>
 * == Pair 6 ==
 * - Compare [] vs [3]
 * - Left side ran out of items, so inputs are in the right order
 * <p>
 * == Pair 7 ==
 * - Compare [[[]]] vs [[]]
 * - Compare [[]] vs []
 * - Right side ran out of items, so inputs are not in the right order
 * <p>
 * == Pair 8 ==
 * - Compare [1,[2,[3,[4,[5,6,7]]]],8,9] vs [1,[2,[3,[4,[5,6,0]]]],8,9]
 * - Compare 1 vs 1
 * - Compare [2,[3,[4,[5,6,7]]]] vs [2,[3,[4,[5,6,0]]]]
 * - Compare 2 vs 2
 * - Compare [3,[4,[5,6,7]]] vs [3,[4,[5,6,0]]]
 * - Compare 3 vs 3
 * - Compare [4,[5,6,7]] vs [4,[5,6,0]]
 * - Compare 4 vs 4
 * - Compare [5,6,7] vs [5,6,0]
 * - Compare 5 vs 5
 * - Compare 6 vs 6
 * - Compare 7 vs 0
 * - Right side is smaller, so inputs are not in the right order
 * What are the indices of the pairs that are already in the right order? (The first pair has index 1, the second pair has index 2, and so on.) In the above example, the pairs in the right order are 1, 2, 4, and 6; the sum of these indices is 13.
 * <p>
 * Determine which pairs of packets are already in the right order. What is the sum of the indices of those pairs?
 */
class Main {
    public static void main(String[] args) {
        Solution sol = new Solution();
        String input = "[1,1,3,1,1]\n" + "[1,1,5,1,1]\n" + "\n" + "[[1],[2,3,4]]\n" + "[[1],4]\n" + "\n" + "[9]\n" + "[[8,7,6]]\n" + "\n" + "[[4,4],4,4]\n" + "[[4,4],4,4,4]\n" + "\n" + "[7,7,7,7]\n" + "[7,7,7]\n" + "\n" + "[]\n" + "[3]\n" + "\n" + "[[[]]]\n" + "[[]]\n" + "\n" + "[1,[2,[3,[4,[5,6,7]]]],8,9]\n" + "[1,[2,[3,[4,[5,6,0]]]],8,9]";
        System.out.println(sol.findPairs(generateNodes(input)));
        input = "[[10,[[10,2],2],3,2],[5,7,[2,[9,4],0,[4,7],0]],[[6,6,10,6],[[7,5],[1,2,9,9,8],4,[9,7]],6],[8,[],8,8,[[4,6,7,7]]],[5,[7],[3,8],[0]]]\n" + "[[[6,1,[]]],[8,[[6,10,0,4],2,10,[0,3,10,4],9],7,7]]\n" + "\n" + "[[[[8,3],[],[10,6,1],[4,3,8,10,4],3],[[9,8,10,2],[1,8,4],0]],[[[10],10,1],[],8,5,3]]\n" + "[[[[0,7,9,4,3],[0,8,1,1]],2]]\n" + "\n" + "[[[0,[5,0,6,8],1,[],1],[8],5,4],[[2,9]],[[9,[10]]],[]]\n" + "[[10,[[3],[10,3,7,10,7],1,9],[3]]]\n" + "\n" + "[[],[[3,9,0],0,3],[[[],5],5,[[3,3],[],[2,4,6],5,[7,2,9]]]]\n" + "[[[1,10,[7,9,7,10,2],[10,0,4,2,5],1],10,2,5],[[10],[9],[[],8,1,3],[]],[5]]\n" + "\n" + "[[],[1,3,4,9],[[2],5,[[4],6],[5],[[]]],[[5,[2,5,3,5],[10,10,4,2],[],[7,3]],10,[5,[2],10,6,[1,1]]],[[[2,10,6],[9]],2,1,7]]\n" + "[[4,7,8,10,[8,1,[8],[9],3]],[[4,[5,6,3,10,2],6,4,[0,2,1,4,4]],[10,[8,2,4,0,6],[]],[[2],[4,2],10],[[],9,[5,10,6],[1,1]]],[[5,1,2]],[[],6]]\n" + "\n" + "[[[],8],[9]]\n" + "[[8,[7],[],7,9],[1,[[1,8,6,1,9]],2,8,[]],[],[3,4,[0,[4]],5],[]]\n" + "\n" + "[[7,3,[[7,2,5]],[[10,9,2],3,[3,5],9]],[9,8,[2],[4,5,[9,2,10,10],6,10]]]\n" + "[[[2,[0,4,2,6]],8,7,2],[[6],[[5,1,6],5,2]]]\n" + "\n" + "[[[],7]]\n" + "[[4],[[0,3,10,[0]]],[[0]],[7,[7],1,8],[]]\n" + "\n" + "[[[[0],[3,7,8,9],[3,4],7],5,3],[[[9,8,9]],5,[0,[2,9,4,4,1]],[]],[9,6,[],[]]]\n" + "[[[[2,4,7],[],8,[9,2,4,1],[8,8,3,6]],0],[[[1],[10],3],[5],0,3]]\n" + "\n" + "[[[],5],[7,[[8,4,5,5],8,[],1],3,[[5,9,5,2,9],10]],[]]\n" + "[[7,8,8,8]]\n" + "\n" + "[[10,4,[3,10,[7,6,10,4,8],3,[7]],4],[5]]\n" + "[[4,[]],[[[8,2,4,6,10]],2,[7,[3],[]]],[10,10,2,[2],4],[],[[2,9,[10,2,8]],4]]\n" + "\n" + "[[[2,6,6,9],2,9,[8,[6]],[[3,0],[0,7,8]]],[[[8,10,4,7,5]],3,[1,[]],[[4],[10,1,1,6],7,[3,5,0]],2],[],[[8,8,[]]],[[[9,1]],2,9,1,9]]\n" + "[[[0,[0,3]],9],[9,9,[5,[1],[2,4],1,6],[[],[3,1],5,10]],[3,6,[[3,0]]],[[5,[5]],5],[[4],[[7,0,8,9,10],7,6,6,2],10,[[8,9,2],[9,3,0],[7],[2,2,2,7,4],[7]],[[5],4,[5,6,0]]]]\n" + "\n" + "[[],[[7,[],2,[0,7,1],8]]]\n" + "[[1],[6,9,3,4],[[4,[2,6],[7,5,0],3,[0]],[[0,1,8,7,3],0],3,[],[[3,5,1,7]]],[0]]\n" + "\n" + "[[[9,[10,4,6],[9,8,6,4,10],2],[[8,10],4,[3,0,10]],[7,8,4,10]]]\n" + "[[[[7],9,[6,0,9,6]],[2,4]],[[],[],8,8,[5,10]],[[[5,0,2,3],[],7,4],2,0,[]]]\n" + "\n" + "[[0],[[],7,[],[[],[6,6,7,2],9,1]],[2,10,[[3],0],0,2],[[[2],2,[3,10,1,1]],9],[9,[[3,10,8],[1,3,0]],[10,[5],[7,7,6,2,1],9,3]]]\n" + "[[[[0,1,9],0,10]],[5,[1,[8,7,2,8],[]]],[3],[[[],[8,8,9,6,6],10,[0,6,1,9],3],[2,[9,8],5,[5]],[[8,3]],[[9],[4,4,0,1],5],6],[]]\n" + "\n" + "[[9],[[[],[5,3]],[],[[1,8,0,3],7]],[],[3,4,[3,[5,2],8],6]]\n" + "[[1,[[0,1,8]],[],2],[0,6,[[]]],[[[],7,9,[7,3,5,1,7]],[[5,4]],4],[4,[3,0,4,4]]]\n" + "\n" + "[[],[[[9],[1,5],5],[[9,0,8,2],4,10,2],2,[[3,1,5,2,8],10]],[],[[10,[2,5],[],[2,10,5,4]],10,3],[[[8,5,4,8,7],6,[1,9,3],0,[4,9,8,6]],3,2]]\n" + "[[0,[2]],[10,3,5],[[[10],3],7,[[3,9],1,[0,0,6],4,9],[]],[[9,5,10,[5,0],[4]],5,10,7,[[1,7,8],7,[4,5]]],[[[],1,[10,9],[8,5,8,2],7]]]\n" + "\n" + "[[],[4,[[2]],0,1],[[7,0,4]]]\n" + "[[[[2,1],[4,9],[0,10],[3,6,9]],2,[[0,6,3,7,10],[3,0,3,5,5]],[[9,0],3,[9,5,8,8,8]],[7]]]\n" + "\n" + "[[[5,10,2],[[4,7,10,7],[0,1,10],[9,5,7,4,6],[10,2,0]]],[7,6,[],7,3],[6,[[9],[0,3],8]],[9,[1,[9,10,1,5],1],[[10,8],8,9],6,6]]\n" + "[[2],[0,3,3,[[10,6],3,[],3,3]],[[7]],[10,[10]],[]]\n" + "\n" + "[[[[1,1,3,6,7],[0,2],6],3,1,[7,[3,1,8,3,10]],[[3,1,5,7,1],8,[3,7,9]]]]\n" + "[[4,[[8,1,6,0,5]]]]\n" + "\n" + "[[[3,2],5,[10,[3,2,5,8,10],[]],3],[0],[],[[]]]\n" + "[[],[10]]\n" + "\n" + "[[6,10],[8,10,[]]]\n" + "[[],[3]]\n" + "\n" + "[[5,0,10,2,9]]\n" + "[[0,7],[]]\n" + "\n" + "[[10,[[3,0,5,7,3],8,0],[]],[[1,3],3,3],[1,7,[[3,6,2],[7,6,3],[7,2]],[[7],[8,2,5,5]]]]\n" + "[[],[[[10,6,5,10],2,[10,5,1,3],[6,4,4]],[],2],[[5],3,[6,[],1],6]]\n" + "\n" + "[[[[2,1,3,3],1],[4,[4]],[[]]],[4,[],[6],8,7],[[5,[3,0],9],[0,10,0]],[[[8,8,7,5,2],2],3]]\n" + "[[[5,9,[10],0],[],0,7,0],[9,[[3,7,0],[1,9,9],[8,8]],0,10,[[8,3,5,9,4],7,[9,6,3,6],[2],8]]]\n" + "\n" + "[[],[],[]]\n" + "[[[[9,5,10,7,3],[]],[3,4,1,[4]],9,8,[]],[[],0]]\n" + "\n" + "[[6,[[2,7,6]]]]\n" + "[[3,9],[[[10,8,5,4,6],6,5,8,10],[[6,1,0,5],7],4,4],[[[10,1,1,2],[2],1,[],[2,2,1]],[[10,2],[8,7,3],[]],[9,[7,3]]],[[5,[8],[7,8],[]],[[3,8,4,1],[3,0,1,2],1,6],[[3,7,0],4,[1,8,1],3,7],4,6]]\n" + "\n" + "[[6,[[3,3,2],[7,0]],[2],6,[[8],[]]],[[],4,[[10],[3,4,10,4,7]],[10,[0],[10]],10]]\n" + "[[6,0,[[4,1,10,10],1,[10,3,3,6,5]]]]\n" + "\n" + "[[[2,[3,9,1,5]],[[9,5,1,7],[0,0,0,0],[9,3,9,8]]],[9,[[10,2,7],3,[10,0,2],10,6],[[8,4,8,8],[3,4,9],5],8,[5,6,6]]]\n" + "[[],[[[8,8,9],4],[[],1,[2,4,6]]],[6,[8],[1],[8,3],[[8,6],6]],[2]]\n" + "\n" + "[[[[8,3],8,9,[3,0],8],[[4,8,7],[0],1]]]\n" + "[[[[8],0,8],[5,7,0,0]],[[]],[]]\n" + "\n" + "[[1,7],[0],[[],[9,5,[1,4],[6,10],0],1,[[]],[[3,0,9,5],6,3,10,1]],[[1,5,3],[6,6,3,1],1,2],[5]]\n" + "[[7,[9,3,[9,9,10,10,3]],[[2,4],[1,9,8,2,9],7],7]]\n" + "\n" + "[[[0,3]],[[],3,[4],5]]\n" + "[[],[9],[[3,[9],[7,9,7]],5,[9]],[[[2,1,1,6],[7,8]],[[],1,[5,1,1,8],[1,10,8,2,4]],3,[],7]]\n" + "\n" + "[[5,[[5],[0,7,2,7,9],9,4],8,[],6],[5,9,9],[[],[[9],6,6,[7,6,7],[]],[7,[8,8,8,2,8],6,2,6]],[5]]\n" + "[[8,8,1,0],[]]\n" + "\n" + "[[8,8,[[1,1],[4]],3,[7]],[[[0,4,5,8,0],[10,8,3,4],[]],7,1,5],[[[10,1,3],9,[1,4,9,8],[],3]],[[]]]\n" + "[[],[],[[10,[7,1,0]],9],[1,[[3,8],[5,5,1,2,0],5,[2,4,7,9,9]],0,[2],6]]\n" + "\n" + "[[],[4,[6,9,[0],8,1],[4,9,[0,2,2,0,10],[7],1]],[[[2,6],[6,2,9],[0,3],2],2],[]]\n" + "[[],[[[6,3],[10,9]],5,7,[2,6],0],[10]]\n" + "\n" + "[[[[4,9,9,6,10],3,7,1,[9,4,8,6]]],[7,[[1,9]],7]]\n" + "[[7,[7,10],10]]\n" + "\n" + "[[[[9],5]],[[[7,7,4],8,9,[0,10,2,0,9]],[[1,0],[6],4],6],[[[7,8],8,9,[],[]],5,[],9],[10]]\n" + "[[[9,[],6],[[7,8,8,1],[]],[4,[],[8,4,9,3,5],3],[0,[0,5,3,4],0,1],[4,9,4,7]],[[0,[10,0]],[[1,1,8,10],9,1,[7,6]],4]]\n" + "\n" + "[[[4,0],[[6,4],0,[2],[3,6,4,2,6],[3,1,2,8,3]],[8,[4,7,10,8],10],[0,8,4]],[[[6,2,5],4,3,2],[[2,7],9,7],6],[8,[7,[6,2,0,2,7],[9,10]],5]]\n" + "[[],[[[10]],[[0,7,0,10],0,[10,8,0]],8,3,[]]]\n" + "\n" + "[[[[8],[0,10,8,0,3],[10]],1,[],8],[[],5,3,10]]\n" + "[[6,2,0,7,5],[]]\n" + "\n" + "[[],[[0,[10,8,4,10],6],[9,7,9,[9]],10,[[5,0,7],1,[6,4,2],[]],[[10,9,3,8,5],5,2]],[2,6,8,4]]\n" + "[[4,10,10]]\n" + "\n" + "[[0,[],10,[[0,7,7,9],7,[],[10,10],7],[[2,8,9,10]]],[[8,1],[]],[[6,[5,5,1,1],[10,4,7,8,7]],8,4,5,[[10,2],[0],[8,8,1,0],[6,4],0]]]\n" + "[[9,9,[[5,9,0,5]],[3,[2],[],[9,8,6]]],[[4]],[3,6,6,9]]\n" + "\n" + "[[4,[[8,4,5,5],[4,8,5,4]],5,9],[]]\n" + "[[3,0,8,[[0,4],[0,6,7,4,6],[2]]],[[5,5,6,8,1],3]]\n" + "\n" + "[[],[[],[8,1,[10,3,5,8]],[[0],3],[[9,3]],1],[],[[6,8,[5,1,10],[2,0,10,8,7]],[[0,2,6,1,10],8,[1,2],[8,8,3,9],[6,1,9,1]],[8,7,6],[[],0,7,8,[1,5,10]]],[6,6]]\n" + "[[[2,1,[1,9],[0]]]]\n" + "\n" + "[[[],[[4,2,7],9,[]],8,[]],[[0,4,[8,2],[]]],[],[[],[7,[2]],7,7]]\n" + "[[[8,3,6,1,7],10,[[9,2,7,1,1],2,[0,1],4,2],1]]\n" + "\n" + "[[9,5,[2,3,[0],[2,3,4,2,10]]],[5,[1,10,4],5]]\n" + "[[4,5],[3,[5,7,10,[]]],[[[],[2,7]],10,4,10,3],[]]\n" + "\n" + "[[6,3,10,[[9,10],5,[1,5,6,6],2],0]]\n" + "[[3,6,8,1],[[[1,5,0],[6,9,2,2],[6]],[],[[9,4,8,7],[9,8,7,6],[1,9,6,3,2]]],[8,5]]\n" + "\n" + "[[[],1,[0],[4,8,10,[10,0]],3],[[[],10,2,1],[[9,6,4],[5],6],[],[6,5,4,[]]],[],[1]]\n" + "[[[7,[9,1,5],1,[3],1],6,9,[[1],[],[8,9,8,8,9]],6],[3,[[0,2,2],6,3],0],[],[4,[],[7,[4,4,3,3,3],[0,5,5,3,8]]]]\n" + "\n" + "[[1,9,[[9,7,0,8,0]],5,[]]]\n" + "[[[],7,[0,[5,6],[0,2],[2,1,4,0,7],[6,8,0,10,9]]],[[[6,2,6,1],6,4],0]]\n" + "\n" + "[[[9],[0,10,7],[4,[1,9,0],[0,7,10],2,7],[[4,6,6,3,4]],3],[6,7,[[4,4,6,4,6],[4,9],[6,1,7,4],7,[1,1,10]],2],[[0,[10,0,7,3,8],9,[4,4,8]],[],6,[[10,9],[0,4,1],9,[7,5,10]],[3,10,[7,9,3]]],[4,[9],7,[6]],[[1,[9,8,1,6],1],4,3,[[2,0,6,9,3],[4,2,1,6,10],[],[],[]]]]\n" + "[[9,5,[[3],[8,9,4,10,5],3,3,[]],[]],[1,8,0,[[8,7,6,8]],3],[[[10,0],[5,5]],10],[[[4,6,9,6,10],[4,8,9,10],[1,8,3,1,4]],[0,1],[7,6]],[[[8],[7]],[[2,8,2],[9],[0],[5]],[0],[2,3,2,1]]]\n" + "\n" + "[[[5,[6],1,[2]],[6,4,5]],[7,10],[[10,5,[8]],[[10,2,8,3],[7,7,4],1]],[1,8]]\n" + "[[8,[[],[10,0,2],[],[10,2]],8,[4,3,[3,7,2,0],[7,7,7,8,10]],7],[[4,[10,7,3],[9,2],2,4],[1,1,[1],8],[[7]],1,3],[[],0],[[],[6,3,6,0],3],[[[2],[3,10,7],4,7,5],[],4]]\n" + "\n" + "[[8,0,[[],[9,1,2,6],5,2]]]\n" + "[[5,[[],4,[10,4,8,1,3]],7]]\n" + "\n" + "[[],[[]]]\n" + "[[[5,[7,8,10,8],1],[[5,10,8,10,8],7,[8,1,1,6,9],[6,1,8],7],3,9],[[[6,0,7,6,0],[7,0],[]],[0,[9,5,0,7,8],7,0,10],10],[],[[[0,3,2,6,0],1],[0,0,[3,7,4,1]]]]\n" + "\n" + "[[[7,[0,10,1,7],[9,1,0,4]],1,5],[3,1,[6,2,[9,4,8],[0,3,8,5]],8]]\n" + "[[9,4,[8,9,10]],[1,[[2,2,3,10],1],8,[[0],[1,10,6],1,[]]],[[[2,2,8,1,5],9,[8,5,9,9,2],[5,0]],[],[],[[9,5,3,1,0],3,2,[1,8,0]],[5,1,[6,6,10,4],9,5]]]\n" + "\n" + "[[0,[]],[[10,[6,10],5,10],[4,5,[5,3],2,8],[],[]]]\n" + "[[6,10],[],[],[[[10,4,0,2,9]],9,5],[5,[9,4],[4,8,0,[0,6,3,2]],[[9,1,2,1,4]]]]\n" + "\n" + "[[3,[1,[9,5]]],[[1,7,[],[2,10,5],0],[4,[],[9,10,2,1],7,6],5,[[6,4,5,4],[0,1,6],6],2],[]]\n" + "[[],[[1,7,[9,7],[9,3,6],2]],[[1,[5]],4]]\n" + "\n" + "[[8]]\n" + "[[8,7,[],[6]],[6,1,4,9,[[4,2,0,6,7],[10,5,5],[],[10,8,10]]]]\n" + "\n" + "[]\n" + "[[[2],[3,6,10],6,[10]],[[8,7,8,[5]]]]\n" + "\n" + "[[[1,5,[],[]],[2,0,[2,6,9],9,6]],[2],[[[7,9,7,2],[9,1,6,5,9],6],7,[],7,[[10,2],[],[],[0]]]]\n" + "[[[[6,4,7],2,[6,5,7],4]],[],[5,6,7,10,1],[10],[[[2,3,5,2],6,[8,2,0],4,9]]]\n" + "\n" + "[[[10,[4,10],2,6]]]\n" + "[[[9,6],[5,9],[6,7,[2,1,10,0,4],6,3]],[]]\n" + "\n" + "[[2,6,2,[2,2,6,9]],[9,[],4,[3]],[6,8],[8]]\n" + "[[[1],0],[],[[[1,0,0,4,5],[5],10,[3,4]],8]]\n" + "\n" + "[[9],[4],[[]],[8]]\n" + "[[3,5,1,[1],[5,[1,7,2,10]]],[]]\n" + "\n" + "[[],[[1,[0,8,5,10],5,[9]]],[3,[3,1,6,10,8],0,1,[4,4]],[7,1,8,9],[7,[[],[0,1,1,1],5],5,[],[[],[]]]]\n" + "[[6,[[1],7,2,[6,4,10,5]],[8,[3],9]],[[[0,2,3,9,6],4],[],1,2,[[4,9,2,7],2,[1,8,1,10,9],0,5]],[3,7,1]]\n" + "\n" + "[[[0,[6,10,3,10,9],8,4,[6,1,4,8]]],[[[1,4,6,4]],3,[],3],[10,[]]]\n" + "[[],[6,[],9],[2,6,[3,0,[7,10,1,6],5],[[4,5]]]]\n" + "\n" + "[[6,4,[],[[10,10],8,5,2]],[8,[7,3,10],3,2,[]],[8]]\n" + "[[7,[7,1,[4,2]],[],[6,[0,10],5,[4,3,3],[2,4]],[]],[[[10],[3,0,3,8,10],[4,1,10],[1,10,7,5,9]],0,8],[],[1]]\n" + "\n" + "[[8,6,6,[5,4,[1,0,4,10,5]],9],[[0,10,[],[0,10]],[10]]]\n" + "[[],[[9,[10,6,4],4,[8,1,10,0]],6,[[2,9,5,1,1],10,8,[]]],[[4,[10],[6,0,9,2],[2,4],6]]]\n" + "\n" + "[[[1,8,[10,4],[10,2]],[[8],1,[]],[[3,6,3],[],7,[7,4]],7,[5,[3,10],4]],[[[4,10,4]],[6,[10,9],2,[5,4],[9,1,4,0,7]],[[0],8],10],[5,6,1]]\n" + "[[[[4,6,2],2,[2,9,10],10,5],[[5,1,0,6,8],[7,3],[8,3]],[[9],[],7],[0,[1,1,6,1]],[[0,2,7],[],7]],[[8],0],[1,10,3],[2,2],[[2,0,[],[4],9],10,1,9,9]]\n" + "\n" + "[[[],5,7,[10]],[9,[[9]],7],[0,1,[[2,5],1,[]],2],[8,3,0,9],[[0,[]],[[4,2,0],10,8,[4,1],[]],1,[7,9,8,[]]]]\n" + "[[[[4,2,9,0]]],[],[8,[],2,4],[],[[],1]]\n" + "\n" + "[[1,3,[[3,9],[6,0,9,8]]],[[1,2,6,5],[],6]]\n" + "[[6,[[5,5,5],4,[2,5,10],6]],[[4,[2,0]],[4,[7,0,1,8,10],2,[0],3],[0,[6,10,1,1]],10],[],[6]]\n" + "\n" + "[[[4,7,2,[3,7,7]],[7,[7,3],[8,2,9,0],9,[8,7,6,3]],2,5,4],[[[8,8,0],1,[10,4,7],[0],[7]],[[],2,[],9],6,[3,[7],4,0],[7]]]\n" + "[[[[9,7]],[9,6],9],[[8],[9,[0],6],[1,7,[2,5,0,5]]],[10,[9,9],10,8,5],[[],0]]\n" + "\n" + "[[[],[8]],[6,7,[[],[8,4],7,5,[]]],[],[0,1,4,8,4]]\n" + "[[10,[1,7,10],7,[],3],[],[],[5],[3,[3,[4,10,3,5,1],6,6],[5,5,[6,3,7,8,10],10]]]\n" + "\n" + "[[4,[[],[8,2,4,2],[6,8,10],[],6]],[[0,10,10],[4,[10,5,1,0]],6]]\n" + "[[1,10,[7,[2],[0,2,3,1,7]]],[5],[[[5,10,6,4],4],2,[2,[2,3]],[7]]]\n" + "\n" + "[[1,7],[1],[10,10],[2,6,[[5,7,9,1,9],[10,8,0],[3,3],8,[]],[]]]\n" + "[[5,3,7,1],[[7,10],[8,[8,3,10,3,8],[7]],[[10,3,2,0],3,[3,10]],8]]\n" + "\n" + "[[[7]],[[[]],[]],[3,2,3,[8,4,[3,0,0,6]]]]\n" + "[[2,8],[[]]]\n" + "\n" + "[[[],4,[[],[9,4,1,6,3],[5,0]],4,9],[[[9,7],[],[1,6,2,10],[1,9,3,3],[]],8,3,[2,[],[8,4],0,[4,7,7]]],[],[5]]\n" + "[[[8,1,4],[6],[],1],[10,5]]\n" + "\n" + "[[[9,[2,8],[3],[3,6,9,9],8],[[7,0,10,5],4],8,1,9],[[7,[],[9,8,1,2,5],[5,0,0]],5,[],9]]\n" + "[[[[5,1,4],8,[]],8,[]],[3,8,9,[[7,9],[5,8],[0],3,[5,3]],9],[7,[5]]]\n" + "\n" + "[[4,5],[],[[9,[3,0,3],5],[],8],[[],[9,0]]]\n" + "[[],[],[],[],[0,4,[[1],[8],[3,8,7,4,7],[0,7,3,8]],8,[6,[9]]]]\n" + "\n" + "[[],[[[1],[4,5,9],[]],10,[0,[6,1],[0,0,7,0,5],6],[3,8,9,[7]]],[7,3],[5,[[],10,10],[[2,0,8,0],9,[10]],0],[7]]\n" + "[[6,9],[],[[[2,3,1],10,6],[[3,9],[10,6],4,10]],[],[]]\n" + "\n" + "[[2,3,[3,9,9]]]\n" + "[[],[[[3,10,4,10,4],[0,4,5],3,[10],[]],0,7]]\n" + "\n" + "[[],[],[[[8,1,2,1],2,[6,8,7,1,10]]]]\n" + "[[[[4,10,5],8,1]],[10,9,[[3,10],[8,5,0],1,8]],[3,7,[4,9,[0,7,5,7],[8]]],[6,3,9,10],[]]\n" + "\n" + "[[7],[[[0],7],[0,[3],[],[7,0],[1]],6],[5,[[7,2,0],6,1,[0]],2,10]]\n" + "[[0,[[3,0,8,6],[],[]],[8,0,2],1],[[[],[5,8,10,2],1,5],4,[2,[5,7,7,1,8],10],[8,9,[8,0,9,9,5],5,[8,6,9]],[[8,0,1,5],5,7,1]]]\n" + "\n" + "[[6,[[3,10,0],[5,9,5,7,5],[9,1,2,8,6],[5,4,5,7],8],[2,5],4,[[1]]],[]]\n" + "[[[],6,7,0,[[]]],[0,10,0,[[6,7,5,6],7,[],[10,8,5,4,10]],[6]],[[9,5,4],6,[[10,4]],4],[9,[5,0,8,[9],2]],[9,[2,[1,5],10,[2,7],[5,2,4,4]]]]\n" + "\n" + "[[10],[[[5,2,7,5],0,9,7,8],8,[1,6,[0,5,0,8,2],[0]],4]]\n" + "[[],[8],[1],[[[8,10],[3,0,1,8],4,7],[9,[3,9],[1,2,9,5,4]],8,[2,5,[2],[]],[9,8,[5]]]]\n" + "\n" + "[9,5,0,3]\n" + "[9,5,0,3,4]\n" + "\n" + "[[4],[0,10,8,10],[10,[]],[[[3,9,4],[9,1,3,6,9],7,[9]],[4,[4,8,8],[6,6]]],[]]\n" + "[[[[4]],6,[8,[0,5,2,10],4,[5,9]]],[[0,[6,1,6]],8,10],[[3,2,[],6],[0,7,4,7,8],0],[6]]\n" + "\n" + "[[4],[]]\n" + "[[[[8,8,6,1],7],[[3],[1,10,1,9],5,9],2,2]]\n" + "\n" + "[[7]]\n" + "[[[8,1,0],[],[],6],[10,9,5,7],[6,[[],[10,7,3]]]]\n" + "\n" + "[[[10]]]\n" + "[[],[[[3,8,3,1,9],[1,6,10,8],8,3]],[[5,7]],[9,[],5,[5,[0],10,[7,9,2],[1,9,8]]],[]]\n" + "\n" + "[[[],[1,[9],[10,9],[8,1],0],[],1,6],[[9],8,[[3,9],[3,7],2],3,[[0,9,1],4]],[],[[[0,1,7,5],5,[9,5,9]]]]\n" + "[[10,5,3,3,1],[[3,[0,2,8,4]],3,[1]],[],[[],5,8,4,1]]\n" + "\n" + "[[],[1],[[]]]\n" + "[[[[]],2,[7,3,8,[]],[9,[0],[4],6,9],0],[6,6,3],[[[2,3,0,0]],[[8],[5],10,4],3]]\n" + "\n" + "[[6,[[1,6,2],[4,0,6,7],8],9,2,[1]],[9,10,10],[1,3,9]]\n" + "[[[8,[9,1,10,7,8],[4,1,6,8]],[[],[3,1,2],2,1,4],[[5,6],[7,5],4,2],10,9],[[[4,5,9,7,7]],[[0,8,1,0],9,[9,3,8,4,1],[4,2,10],[9,4,5,8,4]]],[5,0],[0,[]],[]]\n" + "\n" + "[[[[],[3,7,10,3,4],2],[10,[],[7,6,3],4,10],[[1,1,4,10],[4,3,0,4],4]],[[],[0,4]],[9,4,9,[]],[0,5,[0,5,[],4],[[9,4],[5,10,9,1],10,9,[7]],4]]\n" + "[[[],5,[6,[7,10],[8,9,6],6,4]],[],[],[[0,[3,0,10,7,9],[4],[3,9]]]]\n" + "\n" + "[[[10,[],10,[1],4]],[8]]\n" + "[[8,5,7,6],[]]\n" + "\n" + "[[[[6,7,3,8]],[[4,8,7,3,5],10,4],[[3],[8,8],[8,10],[9]],10,8],[0],[]]\n" + "[[[4,5,6,[6,8,6,9]]]]\n" + "\n" + "[[[],[[8],0,4],10,[],[3,6,2,3,[3,1,3,2]]]]\n" + "[[[6],[]],[[4,3,7,[1]],5,[5,3,1,[2],5]],[[3],[[3,0,4,6],[4,0,7],2,[0,2,7]]],[1]]\n" + "\n" + "[[9,4,3,9,3],[[[0,0,9,3]],10,[2],3],[[[8,0]],7,[[]]],[7,[[8,0],[10,10,4],4],[10,[1,1],[6,2,8,9,4]],4,[4,6,[8,8,4,4,2],[3,4,1,9],10]],[]]\n" + "[[9],[],[5],[[0,6,[],6,6],10,3],[[]]]\n" + "\n" + "[[[[0,1,7,2,6],[3]]],[[[3,10,10],0,6]],[[[8,3,3,0,0]],[[7,8,1],[],[0,10,3],[10,1,7]],5,[[3,3,5,5,4],1,2,3],[8,5]],[1,2,1,6,0],[]]\n" + "[[],[],[5,7,[],6,0],[]]\n" + "\n" + "[[[],4,7],[[[7,2,4,7],[4,10,8,8],9],[4]],[10],[10,[0],[[10,4,0,0,7]]],[9,[[3],10],[[8,0],[],7],8,[[10,10],6,[],[10,1,1,1]]]]\n" + "[[[],[],2]]\n" + "\n" + "[[[3,8,6,[5,5,0,5]],7,4,[2,[7],[1,0,3],9,7],[[1,10],[3],1]],[],[1,1,2],[2,[10,3]],[9]]\n" + "[[2,[5,[5,2,7,7,10],1,[4,10,2,0]],5,[[7,7],7,[1,5,0,3,4]],2],[[[4]],2,4,9,8],[10,[],4,[[8,10,8,2],[1,10,9,3,10],10]]]\n" + "\n" + "[[[1],[],[[3,4],9,[2],[9,10,2,2],[8,8,2]]],[7,[3],0]]\n" + "[[4],[6,2],[6,8],[4]]\n" + "\n" + "[[[[3]],[[10,4,0,4,10],6],[5,[2],4],[10,3,[1,5,1]]]]\n" + "[[0,[10,0],[10,5],[[2,2,5],5,[1]],[[3,0,0],[9,8,0],7,4]],[[],[5,2],[],0]]\n" + "\n" + "[[[[10,5,8,8,0],[7,7],5,7,10],2,[[4],[2],[2],[2,9,7],[4,5,8]],4,2],[[[3,5,2]],4]]\n" + "[[1,0],[[]]]\n" + "\n" + "[[8,[1,[4],3,[9,7,10]],[],2,3],[],[],[],[9,4,9,4,[]]]\n" + "[[[9,[6,0,5],[5,9,2],6],8,[3,10,10,[],[4,4,1,3]],[0,4,0,[2,0]]]]\n" + "\n" + "[[[[6],5,7],4],[[],[6,[],2],[[6,3],3,[10,9,3,9],8,10],[[6,3],[1],[1,4,2],[8,1]]]]\n" + "[[[[7,4,1],10,[],[],5],[[8],[],[3,4,8,6,6],0,0],[[],8,[1,5,0,7,5]]],[[[7,5,1,9,8],[3,4,0,0,8]],8,[[6,9,3,1,10],4]]]\n" + "\n" + "[[[1,[4],8],10],[],[[[10,6],[2],0],9,2,[[1],[3,9,1,4],[0,5,4]]],[[[2],[8,9,10,3],1,0,[4,1,3]],2,[[9,1,0],[],[0],[9,6,3,7],[8]],5,9],[]]\n" + "[[1,[4,9,[7]],9,4,[10,1,[5],[4,1,5]]]]\n" + "\n" + "[[3],[[1,0,1],[[5,6,4,10,1],8],[[6,7,10,4]],1],[8,[5,5],[[2,4,7,2,1],[10,6]],1],[[[5],[8,1,3,2],3,[0,10,10,10,8],[3,4,0,5]],4,8,2],[[9,[7,0],7]]]\n" + "[[[7,2],5,[[],10],2,[1,[2,5,1,0,6],6,6]],[[1,4,[6],[9],1]],[]]\n" + "\n" + "[[],[7,[0,7],7,2,7]]\n" + "[[9,7,8,[2],[[9,3],[7,9,6,6]]],[10,9]]\n" + "\n" + "[[3,9,5,[],1]]\n" + "[[],[[[8,1,3],[7],8],0,10],[],[[2,[2]],9,9],[0]]\n" + "\n" + "[[[],[],[[4,7,5],[],3,[7,7],2],[]],[],[4,[7,5,[9,3],[8,5],6]]]\n" + "[[[1,[2,9]],3],[]]\n" + "\n" + "[[7,[5],[[10,5],[3,7,4],2,[2,7,9]]],[[5],3],[[],10,5,3,[6,6,10,5,10]],[[2,[1,4,0,8],1]]]\n" + "[[6,4],[3,[]],[[[7,10],5,4],5],[[4,10,4,[0,9,0,5],8],7,2,3]]\n" + "\n" + "[[[[6,8]],[2],[3,[8,9,9,10,5]],[[9,2,2,5]],[[2,8,5,9],4,[],[5]]],[7,[[],5,[2,3],[6,3]],9],[[[4],[0],2],10,10],[9]]\n" + "[[],[],[[5,5,10,[4,8,8]],4,[[],7,[7,6],5,[]]],[[10,[],1],3,[[4,8],[6,1,7,3,7]],[2,[9,2]],[9,7]]]\n" + "\n" + "[[6,[[],[4,1,10,6,9],8,[6,0,5,7,6]],2],[6,[],5,[9],2],[]]\n" + "[[[[5,2,2,6,0],2,9,[0,0]]],[[8,[2,0,3]],[5,4,[4],5]],[[[1,0,5,8,4],6,10,3,7],[7,[9,1,9,10,7],[0,3],7,7],[[1,10,0,5,0],[3,5,0],5,5],2,[1]],[3,9,5,[[10,4,7,0,7],1,[7,2],[7,1]],[[],[10,10,5,0,8],[],8,3]]]\n" + "\n" + "[[[4],3,1,10,[[1]]],[2,[[3,4,5,7,2],[6,6,1],[4,4,6,2],[7,4,9,3,9],4],[]]]\n" + "[[4,[[],3],9,7,[[7,6,2,1,0],[2,10,5,3,6],5]],[10],[],[[9,[3],8,[3,4,10,3,3],9]]]\n" + "\n" + "[[],[[[8],8,[5,2]],[[9,0,9,1],7,1,8]],[],[[6,[8,6],0,[7,1,0]],[10,9,1,[5,0,0,9,0]]]]\n" + "[[[[],[5,8,8,2,1],1],8,[]]]\n" + "\n" + "[[[],[10,[2,10,9,5,3],10,1,[10]],[3],[[]],[[5,0,4],[]]],[[5,[3,0,7,4],5,0],7,[5,6,[],[9,9]],5,9]]\n" + "[[5,1,4,[8]]]\n" + "\n" + "[[7,[[10,4,0,9,2],[],3,2]],[[[]],[[5,3,3,8,9]],10,2,10],[[[5,5,0,2],[0,9,7],9,10,0],4,[[0,5,9,10]],2,5],[[[8,3,2,4,7],9,[2,4],1],[0],[6,9,[3],10,[5,10,2,7]],6,[]]]\n" + "[[[2,[6,5],[2,0],[6,8,5]],1,5,[[0,6,7],6,3,5],9],[[[2],[]],0,3],[],[],[6]]\n" + "\n" + "[[[6,2,[2,5],[]],[2,1,[]],9,[6,2,[9,7,7,8],2,5]]]\n" + "[[5,7,0,7,3]]\n" + "\n" + "[[[],6],[5,6,5,[],[4,[3,4,2,1]]],[]]\n" + "[[[]],[[10,6,1]],[[[0,7,2,2],1,1,6],6,5]]\n" + "\n" + "[[],[],[[0,[1,5,1],6],[4,3,[9,10],[3]],[[0,5,8,10,1],[7,5,8,6,6],0,[2,8,9,5]],2,[[4,6,7],0,1]],[2,4,[],0,2]]\n" + "[[0,[5,[5,7,6],5],[],8]]\n" + "\n" + "[[[[]]],[3],[[10,[],[4,5,4,5,8],[7,0,2,2,3]],[10,[],0]],[[[2,5,9],[],9],[[5,5],[],2,3],8,[[]],5]]\n" + "[[[]]]\n" + "\n" + "[[4],[[],1,1],[],[[[0,3,5,6,0]],[7,0,[]],[6,[2],[1],[3,1,7,4,10]],[10,[5]],8]]\n" + "[[[[],[5,9,8,6],6]],[10,1,10,0,[[6],2]],[0,[[8,7,10,7,8],[],[3,10,2,7]],7,8,5],[8,4]]\n" + "\n" + "[[[[],8,[2,3,5,7],[1,6,5,1,8],10]],[0],[[[3,9,1,2,2],[2,7,6],5,[2]],[7,0,[2,5],2,8]]]\n" + "[[4,2],[10],[10]]\n" + "\n" + "[[[],4],[[[6]],[[2,2,10],4,4]],[[[0,4,3,1,2],7,[7,10,4],[8]],0],[[9,1],8,[[]]]]\n" + "[[[1,[8,3,0]]]]\n" + "\n" + "[[],[[1],10,[],[0,3,[0,1,9],1]]]\n" + "[[],[0,8,5],[[8],[6,6],[[1,9,9],[6,5],[10,10,8]]]]\n" + "\n" + "[[2,2,[[4,7],3]],[[[],[5,0,0,7],10]],[[[0,2,6],2]],[[9]]]\n" + "[[[],0,9,0,5],[[[10,10,1]],[3,9,[1]],[[4,4,8,9,7],9]],[[],1]]\n" + "\n" + "[[],[[[]],4,[]]]\n" + "[[[7,[0,2,6]]],[],[[],8],[[0,7],8,6,7],[0]]\n" + "\n" + "[[],[6,6,[[1,6,4],[7,9],3,8]],[3,6,8,[[5,3,6,9],[4,4,6]],0],[3,[3,1,4,9],[[4],10,[3]],8,[8,7,[1,10]]],[[[8,1,8]]]]\n" + "[[6,4,[[10,5,7],3,2],[0,[10,1,7],[9,1,8,8,2]],10],[[],3,3,[7,7,[1]],2],[10,[0,[0,10,0,6,8],[],[9,8,2],[]],4,6],[3,[[4,9,5],10,[],0],5],[7,6,[5],[[3,5],0],[[9,8,4,7,4],[5,1,5,10]]]]\n" + "\n" + "[[[9,9,8,8],9],[7,[[6,0,6,10,7],9,[2,5,1,6,2],[4]],[[7,7]],[5,0,[4]]],[[[8],4],8,[[4]],2]]\n" + "[[4,[6,2,[1,2,4,3,2],[0,0,10,7]]],[[],[[7,3,4],[6,0,0],10,6,[2]]],[[7,5,9]],[[[2,9,9,3,8],10,[4,10,9,9,8],1],10,[2,[8,9,10]],2],[]]\n" + "\n" + "[[9,6],[1,[4,[3,6,1,6,8],[2,3,5,7,1],7,3]],[8,9],[[5,2,4,7,1],2,7],[[[1,2,7,2],[2,5,2,6],9],2,[2,8]]]\n" + "[[[7,[1,0],3,[1,8,1,0]],[],[[7,1],5,[6],[],0],0],[1,[],[]],[1],[[[1,8,10,4,3],2,10,5],[[0,9],5]]]\n" + "\n" + "[[[],8,[[7,2,3,6],[10,8,8,0,0]],[],7]]\n" + "[[[],0,5,[[8],[8,7,0],[8,4,6]]],[[[10,8],[2,0,5,2],[9,6,6],[5,10,8]]],[[[3],[8,9,8,2,4]],[8,2,[1,9,4,2],[9,9,10,5,4]],7,5,[[],3]],[3,3,3]]\n" + "\n" + "[[4],[[9,[5,5],9],[[7,7,0,1]],1],[[],0,[6,3,5,10],1,2],[4,[]],[3,[[8,5,3,5],1,5],[],[[0,10,8,8,4],9,[]]]]\n" + "[[0,[5,[1,8,5]],[10,[0,5,5,0],2],[[]],[10,8,8]]]\n" + "\n" + "[[6,4,[9,[1]],1],[[[0,4,7,4],[5,0]],[8,[4,8]],[],[[2,2,2]],[]]]\n" + "[[],[4]]\n" + "\n" + "[[[[8],9,[],7],6,9,[6],2],[3],[[[4],5],[],3,[6],3],[5,[9,3,[2,8,9,2],2,[]],[5,0],[3,2,[3,5,5,0,8],9]],[5,2,7]]\n" + "[[[]],[[6]],[0,[[7,5,5,2,10],10],2],[[[0],9,6],10,[[1],9,[10,3]]]]\n" + "\n" + "[[7],[[[],8,[9,7,9]],[10,8,9],[[7,6,0,1],[],5,10,9]],[]]\n" + "[[],[[],[[4,9,5,7,0],2,[6,3],3],[8]],[[[6,1,9,10,4],1,[7,7,8],[]]],[8,[]],[[9,7,[0,2,7,1,8]]]]\n" + "\n" + "[[[5,[8,9,8],3],[],[4,9]],[[7],8,0],[],[7],[8]]\n" + "[[[[2,5],[8,10,5],[4,7,9,0,5]],[],[[0,3,7,3],0,[10,3,8,8],[7,0,7,2,4],4]],[[4,9,[2,9],5,3]],[3,0,1,[[2],9,0,[1]]],[[[4,4,0,7,0],0,8,1,[7]],10,[]]]\n" + "\n" + "[[[8],[3,4,[],8,5],[9,[10],8,8,[1,4]]],[],[[[7,3]],[[4,5,9,10]]],[[9,0,[],9],[[9,8],4,[1],4],[7,4,8],[0,[9,1,9,7,2],[6,1,5,6],6],7]]\n" + "[[5,10,[[2,9,4,3]],6,[]],[[]]]\n" + "\n" + "[[8,5,9,[[9,6,8,5],[]]],[5,2,[1,[],2,0,0],3],[],[]]\n" + "[[8],[[3,[0],[6],5],9,10,[[7,9],[],7]],[9,4,[2]]]\n" + "\n" + "[[[[8],[9,10,2,10,10],10],[4],10],[1,9,10,10,10],[2,7,[8,[0,5,0,5],[0,9,2,0]],5,[[3,4],1,[],0]],[8,3,[[3],[8,10,7],3],[[3],[9,10,4],[],[],6],[[9,0,9],1,10]]]\n" + "[[[9,1],[[0,6],[],[4,8,10,5,3]],6,9,[0,8,3,6,10]]]\n" + "\n" + "[[[8,4,6,0,[]]],[7,8,[6,[7,1,4],[10,1,7,9]],[6,6,4]],[[],[[1,5,7,4,2],[3]],1,[[7,5,6,1,8]],6]]\n" + "[[],[],[],[],[]]\n" + "\n" + "[[0]]\n" + "[[],[9,[[8,3,6,6],[8,7,2,0],3,[2,8],[10,3]],[[7,5,3,4],3,3,0,10]],[],[6,8,[[9,9,3,9],2]]]\n" + "\n" + "[[[0,0,0,[],1]]]\n" + "[[2,6,10,5,1],[[],2,[9],[[7,7,6,1],2,[3,8,0,6,5]]]]\n" + "\n" + "[[[4],5],[3,[[5,4,2],[8],1,[3,10]],[],[4,[10,10,6,9],[6,9,3,2,5],4]]]\n" + "[[[]],[1,[10,[],5,[4,9,5,6,6]]]]\n" + "\n" + "[[8,2,[6]],[[[6,5,1,10],[4,3,1],8,10]],[[[0]],5,2,2,2],[[[0,9,4],5,8,[3,7,9]],3,[6,[4,6,3,1]]]]\n" + "[[[[0],[],3,9],[],[[4],[4,0,1,5,10],8]]]\n" + "\n" + "[[]]\n" + "[[],[],[4,[[0],[4,2,5,7,7],9,6],2,2,9],[2]]\n" + "\n" + "[[3,10,1],[[[7,5,2,1,2],[0,0,9],5,[1]]],[6,10,[],[2,[10],2,[2,1],7],[[7,8,2,2]]]]\n" + "[[0,[0],10,[6,6,[1,5],[],[]],10],[[[6,10,1],[],1]]]\n" + "\n" + "[[],[[7,[3,4],4,4],[],[[6,7,8],[],[5,7,7,6,1],9,10],[[5],[],9],[]],[[[5,1],[5,8]]],[]]\n" + "[[[],1,7]]\n" + "\n" + "[[6,9],[[[4,6,3,3,9],9,9,[8,9,2,8],[]],[[],5,[4],[0,7,10,1],[1,5,1,8]],[10,9,4,8,[]],2,3],[[1,[2,8,2,6,4]],[[1,7,7,2,5],[],10],[3,3,[9,8,10,10,6],[8,2,6,0]],8,10],[5],[0,8,[],[],[1]]]\n" + "[[7,5,[[3,7,1]],8],[0],[8,9],[7,4,[7,2,1,3],7]]\n" + "\n" + "[[],[],[[3,[9,5,0,0,6],3,[0]],0,[[],7,5],[]],[4,4],[[],[[2],0,[8,5,8,6]],[[9,1]],6,[5,3]]]\n" + "[[10,[0,4,[8,6],[]],[8,4,3]]]\n" + "\n" + "[1,6,10,0,5]\n" + "[1,6,10,0]\n" + "\n" + "[[[],[[5,5],[4],8],10],[[[8,5,10,1],5,0],[[],[1,0,6,5],[7,3],0],[6],10,5],[7,[[7,10,0,5,2]],7,[],6],[[[6,3,8,0]],8,[]],[4,[[6]],[10,[7,3],[],[7]]]]\n" + "[[8,3,[[],[3,7]],3],[],[5],[7,[0,10,3],[7,[8,2],[3,3],[10],1]]]\n" + "\n" + "[[[[7,3,0,0,9],5]],[]]\n" + "[[[2],[9,[8,9],1,[10,10,7,6]],8,10]]";
        System.out.println(sol.findPairs(generateNodes(input)));
    }

    public static Node[][] generateNodes(String input) {
        String[] lines = replaceAll(input).split("\n");
        Node[][] pairs = new Node[(int) Math.ceil(lines.length / 3.0)][2];
        for (int i = 0, pair; i < lines.length; i++) {
            pair = i / 3;
            // Skip empty lines
            if (i % 3 < 2) pairs[pair][i % 3] = generateNode(lines[i]);
        }
        return pairs;
    }

    public static String replaceAll(String input) {
        return input.replaceAll("10", "k").replaceAll("0", "a").replaceAll("1", "b").replaceAll("2", "c").replaceAll("3", "d").replaceAll("4", "e").replaceAll("5", "f").replaceAll("6", "g").replaceAll("7", "h").replaceAll("8", "i").replaceAll("9", "j");
    }

    public static Node generateNode(String input) {
        char[] chars = input.toCharArray();
        Stack<Node> stack = new Stack<>();
        for (char c : chars) {
            if (c != ']') {
                if (c == '[') stack.push(new Node(true, (char)0));
                else if (c != ',') stack.push(new Node(false, c));
            }
            // Found a closing list, add all to the list node until we find a node that has no
            else {
                List<Node> list = new ArrayList<>();
                while (!stack.isEmpty() && (!stack.peek().isList || stack.peek().list != null)) {
                    list.add(0, stack.pop());
                }
                // Found a node with the null list
                Node node = stack.pop();
                node.list = list;
                // Add back to stack
                stack.push(node);
            }
        }
        return stack.pop();
    }

    public static class Node {
        public char val;
        public List<Node> list;
        public boolean isList = false;

        public Node(boolean isList, char val) {
            this.isList = isList;
            if (val > 0) this.val = val;
        }
    }
}