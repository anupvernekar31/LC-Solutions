/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverse(ListNode head){
        if(head == null || head.next == null){
            return head;
            
        }
        ListNode prev = null, next =null,curr = head;
        while(curr !=null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
    public boolean isPalindrome(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        
        if(head == null || head.next == null){
            return true;
        }
        
        fast = fast.next;
        while(fast!=null && fast.next != null){
            fast =fast.next.next;
            slow = slow.next;
        }
        
        ListNode newHead = reverse(slow.next);
        System.out.print(newHead.val);
        ListNode first = head, second = newHead;
    
        while(second!=null){
            if(first.val != second.val){
                return false;
            }
            first = first.next;
            second = second.next;
        }
        return true;
    }
}