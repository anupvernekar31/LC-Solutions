class Solution {
    public int maxFreqSum(String s) {
        int[] freq = new int[26];
        int maxVowelFreq = 0, maxConsFreq = 0;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);          // s has only 'a'..'z'
            int idx = ch - 'a';
            int f = ++freq[idx];            // frequency after including this char

            if (isVowel(ch)) {
                if (f > maxVowelFreq) maxVowelFreq = f;
            } else {
                if (f > maxConsFreq) maxConsFreq = f;
            }
        }
        return maxVowelFreq + maxConsFreq;  // handles all-vowel or all-consonant cases (adds 0)
    }

    private boolean isVowel(char ch) {
        return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u';
    }
}