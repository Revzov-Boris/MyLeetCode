public class Task45 {
    /**
     <h4>Идея:</h4>
     идти от предпоследнего элемента и для каждого считать,</br>
     сколько минимально прыжков от него можно сделать для попадания в последнюю ячейку. </br>
     Храним эту информацию в отдельном массиве <b>stepsCount</b>:</br>
     <b>stepsCount[i]</b> = n - из i-й ячейки можно добраться до последней за n прыжков.</br>
     Тогда ответом будет <b>stepsCount[0]</b> - столько прыжков нужно сделать из нулевой ячейки.</br>
     </br>
     Если <b>nums[i]</b> больше расстояния до конца, то делаем <b>stepsCount[i] = 1</b>,</br>
     иначе делаем <b>nums[i]</b> шагов вправо <b>stepsCount</b>, ищем там минимальное значение <b>minStep</b>,</br>
     тогда <b>stepsCount[i] = minStep + 1</b>
    */
    public int jump(int[] nums) {
        if (nums.length == 1) return 0;
        if (nums[0] >= nums.length - 1) return 1;
        int[] stepsCount = new int[nums.length];
        for (int start = nums.length - 2; start >= 0; start--) {
            if (nums[start] >= nums.length - 1 - start) {
                stepsCount[start] = 1;
                continue;
            }
            int finish = Math.min(nums[start], nums.length - 1 - start);
            int minStep = Integer.MAX_VALUE;
            for (int step = 1; step <= finish; step++) {
                minStep = Math.min(minStep, stepsCount[start + step]);
                if (minStep == 1) {
                    break;
                }
            }
            // бывают нули в nums, в таких случаях предыдущий цикл ни разу не запустится,
            // а значит minStep = Integer.MAX_VALUE, при увеличении произойдёт переполнение.
            if (minStep == Integer.MAX_VALUE) {
                stepsCount[start] = minStep;
            } else {
                stepsCount[start] = minStep + 1;
            }
        }
        return stepsCount[0];
    }
}
