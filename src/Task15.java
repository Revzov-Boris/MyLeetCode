import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Task15 {
    static int[] indexesOfUnic;

    public List<List<Integer>> threeSum(int[] rawNums) {
        List<List<Integer>> troikas = new ArrayList<>();
        Arrays.sort(rawNums);
        int[] nums = removeDuplicates(rawNums, 2);
        int lenOfNums = nums.length;
        for (int i : indexesOfUnic) {
            for (int j = i + 1; j < lenOfNums - 1; j++) {
                int numsOfI = nums[i];
                int numsOfJ = nums[j];
                if (numsOfJ + nums[j+1] > -numsOfI) break;
                int sum2 = -(numsOfI + numsOfJ);
                if ((j != i+1 && numsOfJ == nums[j-1]) || (sum2 > nums[lenOfNums - 1])) continue;
                if (Arrays.binarySearch(nums, j + 1, lenOfNums, sum2) > 0) {
                    List<Integer> list = new ArrayList<>(3);
                    list.add(numsOfI);
                    list.add(numsOfJ);
                    list.add(sum2);
                    troikas.add(list);
                }
            }
        }
        return troikas;
    }


    public static int[] removeDuplicates(int[] nums, int countOfDuplicates) {
        int count = 0;
        int last = nums[0];
        int duplicates = 1;
        int theDupl;
        int countOfUnic = 0;
        indexesOfUnic = new int[nums.length];
        indexesOfUnic[0] = 0;
        if (last == 0) {
            theDupl = countOfDuplicates + 1;
        } else {
            theDupl = countOfDuplicates;
        }
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != last) {
                if (nums[i] <= 0) {
                    indexesOfUnic[++countOfUnic] = count+1;
                }
                nums[++count] = nums[i];
                last = nums[count];
                if (last == 0) {
                    theDupl = countOfDuplicates + 1;
                } else {
                    theDupl = countOfDuplicates;
                }
                duplicates = 1;
            } else if (duplicates < theDupl){
                nums[++count] = last;
                duplicates++;
            }
        }

        int[] newMas = Arrays.copyOfRange(nums, 0, count + 1);
        indexesOfUnic = Arrays.copyOfRange(indexesOfUnic, 0, countOfUnic + 1);
        return newMas;
    }
}
