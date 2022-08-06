package interviewProblems.Compare_Strings_By_Frequency_Of_The_Smallest_Character;
class Solution {
    public int[] numSmallerByFrequency(String[] queries, String[] words) {
        // Calculate how many words have that given value
        int[] fsWords = new int[11], queryResults = new int[queries.length];
        for (int i = 0; i < queries.length; i++) queryResults[i] = fs(queries[i]);
        for (int i = 0; i < words.length; i++) fsWords[fs(words[i])]++;
        // Iterate all the results to get how many words have the bigger number
        // Given the relation is <, we only need to account for the ones that have a bigger result
        int tmp;
        for (int i = 0; i < queries.length; i++) {
            // Store the target value
            tmp = queryResults[i];
            // Update the results
            queryResults[i] = 0;
            for (int j = tmp + 1; j < fsWords.length; j++) queryResults[i] += fsWords[j];
        }
        return queryResults;
    }

    // Computes f(s) but only stores the value for the minimum value
    public int fs(String s) {
        char min = 'z', current;
        int frequency = 0;
        for (int i = 0; i < s.length(); i++){
            current = s.charAt(i);
            if (current < min) {
                min = current;
                frequency = 1;
            } else if (current == min) frequency++;
        }
        return frequency;
    }
}