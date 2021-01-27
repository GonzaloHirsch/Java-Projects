package interviewProblems.String_K_Compression;

// ---------------------------------- SOLVED ----------------------------------
// ---------------------------- TOPTAL / July 2020 ----------------------------
// ------------------------------- REAL PROBLEM -------------------------------

/**
 * Similar problem: https://leetcode.com/problems/string-compression/ and https://leetcode.com/problems/string-compression-ii/
 * <p>
 * Difficulty: Hard
 * <p>
 * Dado un string que puede ser comprimido de la siguiente forma AAABBAACF -> 3A2B2ACF, y dado un numero K
 * <p>
 * Determinar el tamaño de la minima compresion que se puede generar si se sacan K caracteres.
 */
class Main {
    public static Solution SOL = new Solution();

    public static void main(String[] args) {
        trySolve("AAABBAACF", 3);
        trySolve("AAAAAAAAAAAAABBBBBAAAA", 5);
    }

    public static void trySolve(String s, int k) {
        System.out.println(s + " - K = " + k + " => " + SOL.solution(s, k));
    }
}