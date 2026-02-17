import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Task3 {
    public int lengthOfLongestSubstring(String s) {
        int[] ends = initArray(s);
        if (ends.length == 1) return s.length();
        int maxLen = ends[0];
        for (int finalIndexOfEnds = 1; finalIndexOfEnds < ends.length; finalIndexOfEnds++) {
            int startIndex;
            if (finalIndexOfEnds == 1) {
                startIndex = 1;
            } else {
                startIndex = ends[finalIndexOfEnds - 2] + 1;
            }
            int potentialLen = ends[finalIndexOfEnds] - startIndex;
            if (potentialLen <= maxLen) {
                continue;
            }
            for (int finalIndex = ends[finalIndexOfEnds] - 1; finalIndex >= ends[finalIndexOfEnds - 1]; finalIndex--) {
                if ((finalIndex - startIndex + 1) < maxLen || (maxLen == potentialLen)) break;
                Set<Character> set = new HashSet<>();
                for (int i = finalIndex; i >= startIndex; i--) {
                    if (!set.add(s.charAt(i))) {
                        break;
                    }
                }
                maxLen = Math.max(maxLen, set.size());
            }
        }
        return maxLen;
    }

    public static int[] initArray(String s) {
        List<Integer> list = new ArrayList<>();
        Set<Character> set = new HashSet<>();
        char[] sMas = s.toCharArray();
        for (int i = 0; i < s.length(); i++) {
            if (!set.add(sMas[i])) {
                list.add(i);
                set.clear();
                set.add(sMas[i]);
            }
        }
        list.add(s.length());
        int[] result = new int[list.size()];
        for (int j = 0; j < list.size(); j++) result[j] = list.get(j);
        return result;
    }
}
