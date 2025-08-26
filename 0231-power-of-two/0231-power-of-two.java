class Solution {
    // =======================
    // METHOD 1: Integer.bitCount(n)
    // =======================

    // public boolean isPowerOfTwo(int n) {
    //     return Integer.bitCount(n) == 1;
    // }

    // =======================
    // METHOD 1: Integer.bitCount(n)
    // =======================

    public boolean isPowerOfTwo(int n) {
        return n > 0 && (n & (n - 1)) == 0;
    }
}