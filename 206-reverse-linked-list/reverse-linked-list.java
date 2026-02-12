class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode current = head;

        while (current != null) {
            ListNode next = current.next; // store next
            current.next = prev;          // reverse pointer
            prev = current;               // move prev
            current = next;               // move current
        }

        return prev; // new head
    }
}
