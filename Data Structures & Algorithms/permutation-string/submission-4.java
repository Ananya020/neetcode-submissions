public class Solution {
    public boolean checkInclusion(String s1, String s2) {

        // If s1 is longer, it cannot fit inside s2
        if (s1.length() > s2.length()) {
            return false;
        }

        // Frequency of characters in s1
        int[] s1Count = new int[26];

        // Frequency of characters in current window of s2
        int[] s2Count = new int[26];

        // Create the first window
        for (int i = 0; i < s1.length(); i++) {
            s1Count[s1.charAt(i) - 'a']++;
            s2Count[s2.charAt(i) - 'a']++;
        }

        // Number of characters whose frequencies match
        int matches = 0;

        // Initially compare all 26 characters
        for (int i = 0; i < 26; i++) {
            if (s1Count[i] == s2Count[i]) {
                matches++;
            }
        }

        // Left side of sliding window
        int l = 0;

        // r starts after our initial window
        for (int r = s1.length(); r < s2.length(); r++) {

            // If all 26 frequencies match,
            // current window is a permutation of s1
            if (matches == 26) {
                return true;
            }

            // Add the new character from the right
            int index = s2.charAt(r) - 'a';
            s2Count[index]++;

            // Update matches because this character changed
            if (s1Count[index] == s2Count[index]) {
                matches++;
            } 
            else if (s1Count[index] + 1 == s2Count[index]) {
                matches--;
            }

            // Remove the old character from the left
            index = s2.charAt(l) - 'a';
            s2Count[index]--;

            // Update matches again
            if (s1Count[index] == s2Count[index]) {
                matches++;
            } 
            else if (s1Count[index] - 1 == s2Count[index]) {
                matches--;
            }

            // Move left pointer
            l++;
        }

        // Check the final window
        return matches == 26;
    }
}