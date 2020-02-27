package src.leetcode;

public class SortList {

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }

    public ListNode sortList(ListNode head) {
        int len = 0;
        ListNode temp = head;
        while (temp != null) {
            len++;
            temp = temp.next;
        }
        return sortRec(head, 0, len - 1);

    }

    private ListNode sortRec(ListNode head, int l, int r) {
        if (l >= r)
            return head;
        int mid = l + (r - l) / 2;
        ListNode midL = head;
        int count = l;
        while (count <= mid) {
            midL = midL.next;
            count++;
        }
        return merge(sortRec(head, l, mid), sortRec(midL, mid + 1, r));
    }

    private ListNode merge(ListNode l, ListNode r) {
        ListNode head = null;
        if (l.val < r.val) {
            head = l;
            l = l.next;
        } else {
            head = r;
            r = r.next;
        }
        ListNode temp = head;

        while (l != null && r != null) {
            if (l.val < r.val) {
                temp.next = l;
                l = l.next;
            } else {
                temp.next = r;
                r = r.next;
            }

            temp = temp.next;

        }
        if (l == null) {
            temp.next = r;
        } else {
            temp.next = l;
        }

        return head;

    }

}
