class MinStack {
    LinkedList<Node> stack;

    /** initialize your data structure here. */
    public MinStack() {
        stack = new LinkedList<>();
    }
    
    private class Node {
        int data;
        int minSoFar;
        
        public Node(int data, int minSoFar) {
            this.data = data;
            this.minSoFar = minSoFar;
        }
    }
    
    public void push(int x) {
        if (stack.size() == 0 || x < stack.peek().minSoFar) {
            stack.push(new Node(x, x));
        } else {
            stack.push(new Node(x, stack.peek().minSoFar));
        }
    }
    
    public void pop() {
        stack.pop();
    }
    
    public int top() {
        return stack.peek().data;
    }
    
    public int getMin() {
        return stack.peek().minSoFar;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */