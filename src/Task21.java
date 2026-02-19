import java.util.ArrayList;
import java.util.List;

public class Task21 {
    public static void main(String[] args) {
        ListNode head1 = new ListNode(4);
        head1.next = new ListNode(5);
        head1.next.next = new ListNode(9);
        ListNode head2 = new ListNode(-3);
        head2.next = new ListNode(0);
        head2.next.next = new ListNode(5);
        head2.next.next.next = new ListNode(7);
        head2.next.next.next.next = new ListNode(13);

        System.out.println(mergeTwoLists(head1, head2));
    }


    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null || list2 == null) {
            if (list1 != null) {
                return list1;
            }
            if (list2 != null) {
                return list2;
            }
            return null;
        }

        ListNode list = new ListNode(list1.val <= list2.val ? list1.val : list2.val);
        if (list1.val <= list2.val) {
            list1 = list1.next;
        } else {
            list2 = list2.next;
        }
        ListNode head = list;
        while (list1 != null || list2 != null) {
            if (list1 != null && list2 == null) {
                list.next = list1;
                break;
            } else if (list1 == null && list2 != null) {
                list.next = list2;
                break;
            }

            if (list1.val <= list2.val) {
                list.next = new ListNode(list1.val);
                list = list.next;
                list1 = list1.next;
            } else {
                list.next = new ListNode(list2.val);
                list = list.next;
                list2 = list2.next;
            }
        }
        return head;
    }

}




class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }


    @Override
    public String toString() {
        return val + " -> " + next;
    }
}
