class MyQueue {
    private Deque<Integer> stk1 = new ArrayDeque<>();
    private Deque<Integer> stk2 = new ArrayDeque<>();

    public void transferElements(){
        if (stk2.isEmpty()){
            while(!stk1.isEmpty()){
                stk2.push(stk1.pop());
            }
        }
    }

    public MyQueue() {
        
    }
    
    public void push(int x) {
        stk1.push(x);
        
    }
    
    public int pop() {
        transferElements();
        return stk2.pop();
    }
    
    public int peek() {
        transferElements();
        return stk2.peek();
        
    }
    
    public boolean empty() {
        return stk1.isEmpty() && stk2.isEmpty(); 
        
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */