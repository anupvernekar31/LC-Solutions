class Solution {
    
    public int hammingWeight(int n) {
        int count = 0; 

        while (n > 0) {
            n &= (n - 1);  
            count++;  
        }
        return count;
    }
    // THIS IS ANOTHER SOLUTION TO FIND THE NUMBER OF SET BITS (OPTIONAL)
    /*
    public int hammingWeight(int n) {
        int res = 0;
        for (int i = 0; i < 32; i++) {
            if (((n >> i) & 1) == 1) {
                res += 1;
            }
        }
        return res;        
    } */
}