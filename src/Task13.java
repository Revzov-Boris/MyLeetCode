import java.util.Map;
import java.util.Set;

public class Task13 {
    public static void main(String[] args) {
        System.out.println(romanToInt("CIX")); // 109
        System.out.println(romanToInt("XLVIII")); // 48
        System.out.println(romanToInt("MCXLIX")); // 1149
    }


    public static int romanToInt(String s) {
        Map<Character, Integer> romans = Map.of('I', 1, 'V', 5, 'X', 10, 'L', 50, 'C', 100, 'D', 500, 'M', 1000);
        Map<Character, Set<Character>> before = Map.of('I', Set.of('V', 'X'), 'X', Set.of('L', 'C'), 'C', Set.of('D', 'M'));
        int sum = 0;
        boolean skip = false;
        for (int i = 0; i < s.length(); i++) {
            if (skip) {
                skip = false;
                continue;
            }
            char diget = s.charAt(i);
            if (i < s.length() - 1 &&
                    (diget == 'I' || diget == 'X' || diget == 'C')  &&
                    before.get(diget).contains(s.charAt(i+1))) {
                sum += romans.get(s.charAt(i + 1)) - romans.get(diget);
                skip = true;
            } else {
                sum += romans.get(diget);
            }
        }
        return sum;
    }
}
