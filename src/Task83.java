public class Task83 {
    public static ListNode deleteDuplicates(ListNode head) {
        if (head == null) return null;
        ListNode linkList = head;
        while (linkList.next != null) {
            if (linkList.val == linkList.next.val) {
                ListNode unique = linkList.next;
                boolean find = false;
                while (unique != null) {
                    if (unique.val != linkList.val) {
                        find = true;
                        break;
                    }
                    unique = unique.next;
                }
                if (find) {
                    linkList.next = unique;
                } else {
                    linkList.next = null;
                    break;
                }
            }
            linkList = linkList.next;
        }
        return head;
    }
}
