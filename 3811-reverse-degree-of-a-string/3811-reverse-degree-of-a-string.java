class Solution {
    public int reverseDegree(String s) {
        int total = 0;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            // reverse position in alphabet
            int revPos = 26 - (ch - 'a');

            // 1-based index
            int index = i + 1;

            total += revPos * index;
        }

        return total;
    }
}