import java.util.Arrays;

class Task198 {
    public static void main(String[] args) {
        int[] m = new int[]{2,7,9,3,1};
        System.out.println(rob(m));
    }

    public static int rob(int[] nums) {
        if (nums.length == 1) return nums[0];
        int[] sums = new int[nums.length];
        sums[0] = nums[0];
        sums[1] = nums[1];
        int maxNow = sums[0];
        for (int i = 2; i < nums.length; i++) {
            if (sums[i - 2] > maxNow)
                maxNow = sums[i - 2];
            sums[i] = maxNow + nums[i];
        }
        int last = sums[sums.length - 1];
        int last2 = sums[sums.length - 2];
        return last > last2 ? last : last2;
    }

}
