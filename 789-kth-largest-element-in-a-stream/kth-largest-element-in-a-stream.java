import java.util.PriorityQueue;

class KthLargest {
    int K;
    PriorityQueue<Integer> pq; // Declare at the class level

    public KthLargest(int k, int[] nums) {
        this.K = k;
        this.pq = new PriorityQueue<>();
        
        for (int i = 0; i < nums.length; i++) {
            pq.offer(nums[i]); // Use offer() or add()
            if (pq.size() > k) { // Use size()
                pq.poll(); // Use poll()
            }
        }
    }
    
    public int add(int val) {
        pq.offer(val); 
        if (pq.size() > K) {
            pq.poll();
        }
        return pq.peek();
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */