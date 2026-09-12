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
    public ListNode oddEvenList(ListNode head) {

        if(head == null || head.next == null){
            return head;
        }

        ListNode oddNo = head;
        ListNode evenNo = head.next;
        ListNode evenHead = evenNo;

        while(evenNo != null && evenNo.next != null){
        //even - odd
        oddNo.next = evenNo.next;
        oddNo = oddNo.next;

        evenNo.next = oddNo.next;
        evenNo = evenNo.next;

        }
    //combaing
    oddNo.next = evenHead;

    return head;
    }
}