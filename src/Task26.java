public class Task26 {
    public int removeDuplicates(int[] nums) {
        int count = 0;
        int last = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != last) {
                nums[++count] = nums[i];
                last = nums[count];
            }
        }
        return count + 1;
    }
}
