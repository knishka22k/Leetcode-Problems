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
    public ListNode swapNodes(ListNode head, int k) {

        ListNode temp = head;
        
        int size = 0;
        while(temp != null){
            temp = temp.next;
            size++;
        }

        int l = size - k + 1;

        if(k == l){
            return head;
        }

        ListNode currk = head;
        ListNode currl = head;
        
        for(int i=1; i<k; i++){
            currk = currk.next;
        }

        for(int i=1; i<l; i++){
            currl = currl.next;
        }

        //swap 
        int tempVal = currk.val;
        currk.val = currl.val;
        currl.val = tempVal;

        return head;
    }
}