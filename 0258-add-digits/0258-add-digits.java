class Solution {
    int findSum(int num){
        int sum = 0;
        while(num > 0){
            int dig = num % 10;
            sum += dig;
            num = num /10;
        }
        return sum;
    }
    public int addDigits(int num) {
        int sum = findSum(num);
        while(sum > 9){
            sum = findSum(sum);
        }

        return sum;
    }
}