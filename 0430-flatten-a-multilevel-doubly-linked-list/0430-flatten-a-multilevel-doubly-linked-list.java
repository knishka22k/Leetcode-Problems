/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};
*/

class Solution {
    public Node flatten(Node head) {
        Node curr = head;
        Node next;
        while(curr != null){
            if(curr.child != null){
                next = curr.next;
                Node childHead = flatten(curr.child);
                curr.next = childHead;
                childHead.prev = curr;
                curr.child = null;
                
                Node temp = childHead;
                while(temp.next != null){
                    temp = temp.next;
                }
                temp.next = next;

                if(next != null){
                    next.prev = temp;
                }
            }
            curr = curr.next;
        }
        return head;
    }
}