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
    public ListNode reverseLinkedList(ListNode head) {
        // Initialize'temp' at
        // head of linked list
        ListNode temp = head;  
   
       // Initialize pointer 'prev' to NULL,
       // representing the previous node
       ListNode prev = null;  
       
       // Traverse the list, continue till
       // 'temp' reaches the end (NULL)
       while(temp != null){  
           // Store the next node in
           // 'front' to preserve the reference
           ListNode front = temp.next;  
           
           // Reverse the direction of the
           // current node's 'next' pointer
           // to point to 'prev'
           temp.next = prev;  
           
            // Move 'prev' to the current
            // node for the next iteration
           prev = temp;  
           
            // Move 'temp' to the 'front' node
            // advancing the traversal
           temp = front; 
       }
       
       // Return the new head of
       // the reversed linked list
       return prev;  

    }
    
    public ListNode findKthNode(ListNode temp, int k) {
        // Decrement K as we already
        // start from the 1st node
        for(int i=1;i<k;i++){
            if(temp == null){
                break;
            }
            temp = temp.next;
        }
        
        // Return the Kth node
        return temp;
    }
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode temp = head;
        ListNode lastPrev = null;
        
        while(temp!=null){
            ListNode kthNode = findKthNode(temp, k);
            
            if(kthNode == null){                    // this if is not required for version - 2
                if(lastPrev != null){
                    lastPrev.next = temp;
                }
                break;
            }
            
            ListNode nextNode = kthNode.next;
            kthNode.next =null;
            reverseLinkedList(temp);
            if(temp == head){
                head = kthNode;
            } else {
                lastPrev.next = kthNode;
            }
            lastPrev = temp;
            temp = nextNode;
        }
        return head;
    }

    /* ===================================================
        public ListNode findKthNode(ListNode temp, int k) {
        // Decrement K as we already
        // start from the 1st node
        for(int i=1;i<k;i++){
            if(temp.next == null){
                break;
            }
            temp = temp.next;
        }
        
        // Return the Kth node
        return temp;
    }

    */
}