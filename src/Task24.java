public class Task24 {
    public static ListNode swapPairs(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode list = head;
        ListNode left = null;
        while (list != null && list.next != null) {
            // меняем местами 2 соседних узла
            ListNode theNext = list.next;
            list.next = theNext.next;
            theNext.next = list;

            if (left != null) {
                // у узла, который перед этой парой, меняем ссылку
                left.next = theNext;
            } else {
                // в первой паре была голова, после первой итерации она на 2-м, а не на 1-м месте, возвращаем обратно
                head = theNext;
            }
            // теперь узел перед следующей парой будет последний узёл этой пары
            left = list;

            // идём дальше
            list = list.next;
        }
        return head;
    }
}
