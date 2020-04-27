class Solution_v1 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 != null || l2 != null) {
            PriorityQueue<Integer> pq = new PriorityQueue<>();
            while (l1 != null) {
                pq.add(l1.val);
                l1 = l1.next;
            }
            while (l2 != null) {
                pq.add(l2.val);
                l2 = l2.next;
            }
            ListNode head = new ListNode(pq.poll());
            ListNode toReturn = head;
            ListNode node;
            while (pq.size() > 0) {
                node = new ListNode(pq.poll());
                head.next = node;
                head = node;
            }
            return toReturn;
        } else {
            return l1;
        }
    }
}