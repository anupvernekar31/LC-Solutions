// import java.util.HashSet;
// import java.util.Set;


// O(log n)
// class Solution {
//     public boolean isHappy(int n) {
//         Set<Integer> seen = new HashSet<>();
        
//         while (n != 1 && !seen.contains(n)) {
//             seen.add(n);
//             n = sumOfSquares(n);
//         }
        
//         return n == 1;
//     }
    
//     private int sumOfSquares(int num) {
//         int sum = 0;
//         while (num > 0) {
//             int digit = num % 10;
//             sum += digit * digit;
//             num /= 10;
//         }
//         return sum;
//     }
// }

class Solution {
    public boolean isHappy(int n) {
        int slow = n;
        int fast = sumOfSquares(n);
        
        while (fast != 1 && slow != fast) {
            slow = sumOfSquares(slow);
            fast = sumOfSquares(sumOfSquares(fast));
        }
        
        return fast == 1;
    }
    
    private int sumOfSquares(int num) {
        int sum = 0;
        while (num > 0) {
            int digit = num % 10;
            sum += digit * digit;
            num /= 10;
        }
        return sum;
    }
}