class MyCircularDeque {
    private int[] deque;
    private int frontIndex;
    private int currentSize;
    private int maxCapacity;

    public MyCircularDeque(int k) {
        deque = new int[k];
        frontIndex = 0;
        currentSize = 0;
        maxCapacity = k;
    }
    
    public boolean insertFront(int value) {
        if (isFull()) {
            return false;
        }
        
        // Calculate the new front index, wrapping around using modulo
        frontIndex = (frontIndex - 1 + maxCapacity) % maxCapacity;
        deque[frontIndex] = value;
        currentSize++;
        return true;
    }
    
    public boolean insertLast(int value) {
        if (isFull()) {
            return false;
        }
        
        // The rear index is frontIndex + currentSize 
        int rearIndex = (frontIndex + currentSize) % maxCapacity;
        deque[rearIndex] = value;
        currentSize++;
        return true;
    }
    
    public boolean deleteFront() {
        if (isEmpty()) {
            return false;
        }
        
        // Move frontIndex forward
        frontIndex = (frontIndex + 1) % maxCapacity;
        currentSize--;
        return true;
    }
    
    public boolean deleteLast() {
        if (isEmpty()) {
            return false;
        }

        // Just decrementing the size logically removes the last element
        currentSize--;
        return true;
    }
    
    public int getFront() {
        if (isEmpty()) {
            return -1;
        }
        return deque[frontIndex];
    }
    
    public int getRear() {
        if (isEmpty()) {
            return -1;
        }
        
        // Calculate the current rear index
        int rearIndex = (frontIndex + currentSize - 1) % maxCapacity;
        return deque[rearIndex];
    }
    
    public boolean isEmpty() {
        return currentSize == 0;
    }
    
    public boolean isFull() {
        return currentSize == maxCapacity;
    }
}