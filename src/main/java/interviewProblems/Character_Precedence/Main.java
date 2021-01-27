package interviewProblems.Character_Precedence;

import java.util.Arrays;

// ---------------------------------- SOLVED ----------------------------------
// --------------------------- TOPTAL / August 2020 ---------------------------
// ------------------------ REAL PROBLEM FROM INTERVIEW -----------------------
/**
 * A precedence rule is given as "P>E", which means that letter "P" is followed directly by the letter "E". Write a function, given an array of precedence rules, that finds the word represented by the given rules.
 *
 * Note: Each represented word contains a set of unique characters, i.e. the word does not contain duplicate letters.
 *
 * Examples:
 * findWord(["P>E","E>R","R>U"]) // PERU
 * findWord(["I>N","A>I","P>A","S>P"]) // SPAIN
 *
 * Test cases
 * findWord(["U>N", "G>A", "R>Y", "H>U", "N>G", "A>R"]) // HUNGARY
 * findWord(["I>F", "W>I", "S>W", "F>T"]) // SWIFT
 * findWord(["R>T", "A>L", "P>O", "O>R", "G>A", "T>U", "U>G"]) // PORTUGAL
 * findWord(["W>I", "R>L", "T>Z", "Z>E", "S>W", "E>R", "L>A", "A>N", "N>D", "I>T"]) // SWITZERLAND
 *
 * */
public class Main {
    public static void main(String[] args){
        Solution s = new Solution();

        System.out.println(s.findWord(Arrays.asList("P>E","E>R","R>U"))); // PERU
        System.out.println(s.findWord(Arrays.asList("I>N","A>I","P>A","S>P"))); // SPAIN
        System.out.println(s.findWord(Arrays.asList("U>N", "G>A", "R>Y", "H>U", "N>G", "A>R"))); // HUNGARY
        System.out.println(s.findWord(Arrays.asList("I>F", "W>I", "S>W", "F>T"))); // SWIFT
        System.out.println(s.findWord(Arrays.asList("R>T", "A>L", "P>O", "O>R", "G>A", "T>U", "U>G"))); // PORTUGAL
        System.out.println(s.findWord(Arrays.asList("W>I", "R>L", "T>Z", "Z>E", "S>W", "E>R", "L>A", "A>N", "N>D", "I>T"))); // SWITZERLAND
        System.out.println(s.findWord(Arrays.asList("H>E"))); // HE
        System.out.println(s.findWord(Arrays.asList("T>O", "O>P", "P>A", "A>L"))); // TOPAL
    }
}
