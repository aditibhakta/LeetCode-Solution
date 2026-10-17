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
    public ListNode reverseKGroup(ListNode head, int k) {

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;

        while(true){
            ListNode kth = prev;

            for(int i = 0; i < k; i++){
                kth = kth.next;

                if(kth == null){
                    return dummy.next;
                }
            }
            ListNode curr = prev.next;

            for(int i = 0; i < k - 1; i++){
                ListNode nextNode = curr.next;
                curr.next = nextNode.next;
                nextNode.next = prev.next;
                prev.next = nextNode;
            }
            prev = curr;
        }
    }
}