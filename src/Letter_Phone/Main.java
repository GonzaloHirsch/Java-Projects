package Letter_Phone;

// ---------------------------------- SOLVED ----------------------------------
// --------------------------- FACEBOOK / April 2020 --------------------------
/**
 * Original problem: https://www.interviewbit.com/problems/letter-phone/
 *
 * Given a digit string, return all possible letter combinations that the number could represent.
 *
 * A mapping of digit to letters (just like on the telephone buttons) is given below.
 *
 * (Photo of the mapping of digits)
 * https://upload.wikimedia.org/wikipedia/commons/thumb/7/73/Telephone-keypad2.svg/200px-Telephone-keypad2.svg.png
 *
 * (Digit mapping with a hashmap)
 * HashMap<Character, List<Character>> map = new HashMap<>();
 *     map.put('0', Arrays.asList('0'));
 *     map.put('1', Arrays.asList('1'));
 *     map.put('2', Arrays.asList('a','b','c'));
 *     map.put('3', Arrays.asList('d','e','f'));
 *     map.put('4', Arrays.asList('g','h','i'));
 *     map.put('5', Arrays.asList('j','k','l'));
 *     map.put('6', Arrays.asList('m','n','o'));
 *     map.put('7', Arrays.asList('p','q','r','s'));
 *     map.put('8', Arrays.asList('t','u','v'));
 *     map.put('9', Arrays.asList('w','x','y','z'));
 *
 * The digit 0 maps to 0 itself.
 * The digit 1 maps to 1 itself.
 *
 * Input: Digit string "23"
 * Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 * Make sure the returned strings are lexicographically sorted.
 */
class Main {
    public static void main(String[] args){

    }
}