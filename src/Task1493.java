public class Task1493 {
    public static int longestSubarray(int[] nums) {
        int max = 0; // ответ
        int len = 0; // длина текущей последовательности единиц
        int last = 0; // длина предыдущей последовательности единиц
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                len++;
            } else {
                //Если nums[i] != 1, значит последовательность прервалась, сверяем новое значение len + last.
                // last всегда добавляем, так как если было 2 нуля подряд, то last = 0
                max = Math.max(max, len + last);
                // Текущей последовательность теперь стала предыдущей, а текущая - 0. Если 2 подряд нуля - last тоже станет 0
                last = len;
                len = 0;
            }
        }
        if (len == nums.length) return len - 1;
        max = Math.max(max, len + last);
        return max;
    }
}
