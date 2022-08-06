package interviewProblems.Encrypt_Decrypt_Strings;


import java.util.HashMap;
import java.util.Map;

class Encrypter {
    private Map<Character, String> keyToValue = new HashMap<>();
    private Map<String, Integer> validWords = new HashMap<>();

    public Encrypter(char[] keys, String[] values, String[] dictionary) {
        // Add key -> value mapping to the keys map
        for (int i = 0; i < keys.length; i++) {
            this.keyToValue.put(keys[i], values[i]);
        }
        String encryption;
        for (String word : dictionary) {
            // Encrypt the word
            encryption = this.encrypt(word);
            // verify if the possible encryption exists
            if (!this.validWords.containsKey(encryption)) {
                this.validWords.put(encryption, 0);
            }
            // Accumulate the number of words that can be encrypted to that string
            this.validWords.put(encryption, this.validWords.get(encryption) + 1);
        }
    }

    public String encrypt(String word1) {
        // Convert to char array for iteration
        char[] tmp = word1.toCharArray();
        // Use a StringBuilder for performance
        StringBuilder sb = new StringBuilder();
        for (Character c : tmp) {
            // Need to check if key is present for edge cases
            if (!this.keyToValue.containsKey(c)) return "";
            sb.append(this.keyToValue.get(c));
        }
        return sb.toString();
    }

    // No need to decrypt, we know all the posibilities so there's no need to calculate the decryption
    public int decrypt(String word2) {
        return this.validWords.getOrDefault(word2, 0);
    }
}

/**
 * Your Encrypter object will be instantiated and called as such:
 * Encrypter obj = new Encrypter(keys, values, dictionary);
 * String param_1 = obj.encrypt(word1);
 * int param_2 = obj.decrypt(word2);
 */