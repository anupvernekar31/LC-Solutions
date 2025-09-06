class MinStack {
    Stack<Long> st;
    long mini;

    public MinStack() {
        st = new Stack<>();
        mini = Long.MAX_VALUE;
    }

    public void push(int val) {
        long value = val;
        if (st.isEmpty()) {
            mini = value;
            st.push(value);
        } else {
            if (value >= mini) {
                st.push(value);
            } else {
                // Push encoded value
                st.push(2 * value - mini);
                mini = value;
            }
        }
    }

    public void pop() {
        if (st.isEmpty()) return;

        long top = st.pop();
        if (top < mini) {
            // Recover previous minimum
            mini = 2 * mini - top;
        }
    }

    public int top() {
        if (st.isEmpty()) return -1;

        long top = st.peek();
        return (top >= mini) ? (int) top : (int) mini;
    }

    public int getMin() {
        return (int) mini;
    }
}