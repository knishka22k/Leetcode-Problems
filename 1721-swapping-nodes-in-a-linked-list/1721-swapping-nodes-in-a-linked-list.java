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
        ListNode prevk = null;

        ListNode currl = head;
        ListNode prevl = null;
        
        for(int i=1; i<k; i++){
            prevk = currk;
            currk = currk.next;
        }
        // while(currk != null && currk.val != k){
        //     prevk = currk;
        //     currk = currk.next;
        // }

        for(int i=1; i<l; i++){
            prevl = currl;
            currl = currl.next;
        }

        // while(currl != null && currl.val != l){
        //     prevl = currl;
        //     currl = currl.next;
        // }

        if(currk == null || currl == null){
            return head;
        }

        if(prevk != null){
            prevk.next = currl;
        }else {
            head = currl;
        }

        if(prevl != null){
            prevl.next = currk;
        }else {
            head = currk;
        }

        //swap 
        ListNode tempNode = currk.next;
        currk.next = currl.next;
        currl.next = tempNode;

        return head;
    }
}