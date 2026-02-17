import java.util.Arrays;

public class Task1 {
    static public int binFind(int[] array, int number, int firstIndex) {
        if (array.length == 1 && array[0] == number) {
            //System.out.println("Нашёл: " + firstIndex);
            int n = firstIndex;
            return n;
        } else if (array.length == 1) {
            return -1;
        }

        if (array[array.length / 2] > number) {
            return binFind(Arrays.copyOfRange(array, 0, array.length / 2), number, firstIndex);
        } else {
            return binFind(Arrays.copyOfRange(array, array.length / 2, array.length), number, firstIndex + array.length / 2);
        }
    }

    static public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        int[] oldNumps = nums.clone();
        Arrays.sort(nums);
        for (int startIndex = 0; startIndex < nums.length; startIndex++) {
            int index = binFind(Arrays.copyOfRange(nums, startIndex, nums.length), target - nums[startIndex], startIndex);
            boolean cond1 = false;
            boolean cond2 = false;
            if (index != -1) {
                System.out.println("Индексы в упорядоченном: " + startIndex + " " + index);
                for (int i = 0; i < oldNumps.length; i++) {
                    if (oldNumps[i] == nums[startIndex] && !cond1) {
                        result[0] = i;
                        cond1 = true;
                    } else if (oldNumps[i] == nums[index] && !cond2) {
                        result[1] = i;
                        cond2 = true;
                    }
                    if (cond1 && cond2) {return result;}
                }
            }
        }
        return result;
    }
}
