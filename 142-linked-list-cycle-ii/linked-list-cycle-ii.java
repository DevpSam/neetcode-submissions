/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
       ListNode slow = head;
        ListNode fast = head;
        
        while (fast != null && fast.next != null) {
            slow = slow.next;         // move slow by 1
            fast = fast.next.next;    // move fast by 2
            
            // 1. Check if they meet (Cycle exists)
            if (slow == fast) {
                ListNode p = head;
                
                // 2. Find the start of the cycle
                // Move both pointers ONE step at a time until they meet
                while (p != slow) {
                    p = p.next;
                    slow = slow.next;
                }
                
                // The meeting point is the start of the cycle
                return p;
            }
        }
        
        // If the loop finishes, fast reached the end, so there is no cycle
        return null;
    }
}