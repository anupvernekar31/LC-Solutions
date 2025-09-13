class Solution {
    public int divide(int dividend, int divisor) {
        if(dividend == divisor) return 1;
        if(dividend == Integer.MIN_VALUE && divisor == -1) return Integer.MAX_VALUE;
        if(divisor == 1) return dividend;
        
        // Variable to store the sign of result
        boolean isPositive = true;
        
        // Updating the sign of quotient
        if(dividend >= 0 && divisor < 0) 
            isPositive = false;
        else if(dividend <= 0 && divisor > 0)
            isPositive = false;
            
        // Storing absolute dividend & divisor
        long n = dividend;
        long d = divisor;
        
        n = Math.abs(n);
        d = Math.abs(d);
        
        // Variable to store the answer
        int ans = 0;
        
        /* Looping while dividend is 
        greater than equal to divisor */
        while(n >= d) {
            int count = 0;
            
            /* Finding the required 
            largest power of 2 */
            while(n >= (d << (count+1))) {
                count++;
            }
            
            // Updating the answer & dividend
            ans += (1 << count);
            n -= (d << count);
        }
        
        // Handling overflowing condition
        if(ans == (1 << 31) && isPositive) 
            return Integer.MAX_VALUE;
        if(ans == (1 << 31) && !isPositive)
            return Integer.MIN_VALUE;
        
        /* Returning the quotient 
        with proper sign */
        return isPositive ? ans : -1*ans;
    }
}