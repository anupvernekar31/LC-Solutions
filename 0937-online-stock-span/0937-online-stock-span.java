
//BRUTE FORCE SOLUTION
/*
class StockSpanner {
    private List<Integer> prices;

    public StockSpanner() {
        prices = new ArrayList<>();
    }

    public int next(int price) {
        prices.add(price);
        int span = 1;
        int i = prices.size() - 2; // start from the previous day

        while (i >= 0 && prices.get(i) <= price) {
            span++;
            i--;
        }

        return span;
    }
}

*/


class StockSpanner {
    private Stack<int[]> stack;  // Each element: [price, span]
    int index;

    public StockSpanner() {
        stack = new Stack<>();
        index = -1;
    }

    public int next(int price) {
        index = index+1;

        // Pop elements with price <= current price and add their spans
        while (!stack.isEmpty() && stack.peek()[0] <= price) {
            stack.pop();
        }

        int ans = index - (stack.isEmpty() ? -1 : stack.peek()[1]);

        stack.push(new int[]{price, index});
        return ans;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */