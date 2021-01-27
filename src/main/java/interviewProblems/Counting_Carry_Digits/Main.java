package interviewProblems.Counting_Carry_Digits;

// ---------------------------------- SOLVED ----------------------------------
// --------------------------- TOPTAL / August 2020 ---------------------------
// ------------------------ REAL PROBLEM FROM INTERVIEW -----------------------

/**
 * I do not have the question anymore, but it was a simple one.
 *
 * Question: Given 2 positive integers, count how many carry digits are used when performing an addition.
 *
 * A carry digit is a bit used to denote a carry operation between 2 numbers, for example:
 *      5 + 5 = 10 -> Uses 1 carry digit
 *      4 + 4 = 8 -> Does NOT use carry digit
 *      65 + 55 = 120 -> Uses 2 carry digits
 * */
public class Main {
    public static void main(String[] args){
        Solution s = new Solution();

        System.out.println(s.numberOfCarryOperations(123, 456)); // 0
        System.out.println(s.numberOfCarryOperations(555, 555)); // 3
        System.out.println(s.numberOfCarryOperations(900, 11)); // 0
        System.out.println(s.numberOfCarryOperations(145, 55)); // 2
        System.out.println(s.numberOfCarryOperations(0, 0)); // 0
        System.out.println(s.numberOfCarryOperations(1, 99999)); // 5
        System.out.println(s.numberOfCarryOperations(999045, 1055)); // 5
        System.out.println(s.numberOfCarryOperations(101, 809)); // 1
        System.out.println(s.numberOfCarryOperations(189, 209)); // 1
    }
}
