public class Task28 {
    public static int strStr(String haystack, String needle) {
        if (haystack.length() < needle.length()) return -1;
        for (int i = 0; i <= haystack.length() - needle.length(); i++) {
            boolean flag = true;
            for (int plus = 0; plus < needle.length(); plus++) {
                if (haystack.charAt(i + plus) != needle.charAt(plus)) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                return i;
            }
        }
        return -1;
    }
}
