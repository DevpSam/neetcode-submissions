/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
private int getlength(ListNode head){
            int len = 0;
            while(head != null){
                len++;
                head = head.next;
            }
            return len;
        }
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lenA = getlength(headA);
        int lenB = getlength(headB);

        ListNode ptr1 = headA;
        ListNode ptr2 = headB;
        
        if(lenA>lenB){
            for(int i = 0; i<lenA-lenB; i++){
                ptr1 = ptr1.next;
            }
        }
            else{
                for(int i = 0; i<lenB-lenA; i++){
                ptr2 = ptr2.next;
            }
        }

        while(ptr1 != null && ptr2 != null){
            if(ptr1 == ptr2){
                return ptr1;
            }
            else{
                ptr1 = ptr1.next;
                ptr2 = ptr2.next;
            }
        }
        return null;
        
    }
}