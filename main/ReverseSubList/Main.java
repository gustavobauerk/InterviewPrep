package ReverseSubList;

public class Main {
    public static void main(String[] args) {
        ListNode head = new ListNode(100);
        head.next = new ListNode(200);
        head.next.next = new ListNode(300);
        head.next.next.next = new ListNode(400);
        head.next.next.next.next = new ListNode(500);
        System.out.println(reverse(head, 2, 5));
    }

    private static ListNode reverse(ListNode head, int p, int q) {
        ListNode prev = null;
        ListNode curr = head;
        ListNode qNode = null;
        ListNode qNodeNext = null;
        int count = 0;
        while (curr != null) {
            count++;
            if (count == q) {
                qNode = curr;
                qNodeNext = curr.next;
            }
            if (count > p && count <= q) {
                ListNode temp = curr.next;
                curr.next = prev;
                prev = curr;
                curr = temp;
            } else {
                prev = curr;
                curr = curr.next;
            }
        }
        curr = head;
        count = 1;
        if (count != p) {
           while (++count != p) {
                curr = curr.next;
            }
            ListNode pNode = curr.next;
            curr.next = qNode;
            pNode.next = qNodeNext;
        }else{
            curr.next = qNodeNext;
            head = qNode;
        }

        return head;
    }

    static class ListNode {
        int val = 0;
        ListNode next;

        ListNode(int value) {
            this.val = value;
        }

        @Override
        public String toString() {
            return "val: " + val + "; next: " + next;
        }
    }
}
