import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Task12 {
    public static void main(String[] args) {
        System.out.println(intToRoman(407)); // CDVII
        System.out.println(intToRoman(3749)); // MMMDCCXLIX
    }


    public static String intToRoman(int num) {
        List<Integer> values = List.of(1, 4, 5, 9, 10, 40, 50, 90, 100, 400, 500, 900, 1000);
        Map<Integer, String> ints = new HashMap();
        ints.put(1, "I");
        ints.put(4, "IV");
        ints.put(5, "V");
        ints.put(9, "IX");
        ints.put(10, "X");
        ints.put(40, "XL");
        ints.put(50, "L");
        ints.put(90, "XC");
        ints.put(100, "C");
        ints.put(400, "CD");
        ints.put(500, "D");
        ints.put(900, "CM");
        ints.put(1000, "M");
        StringBuilder sb = new StringBuilder();
        for (int i = values.size() - 1; i >= 0; i--) {
            int val = values.get(i);
            for (int c = 0; c < num / val; c++)
                sb.append(ints.get(val));
            num -= val * (num / val);
            if (num == 0) break;
        }
        return sb.toString();
    }
}
