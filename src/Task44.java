import java.util.ArrayList;
import java.util.List;

public class Task44 {
    public boolean isMatch(String s, String p) {
        while (p.contains("**")) {
            p = p.replace("**", "*");
        }
        if (p.equals("*") || s.equals(p)) return true;
        List<String> strings = new ArrayList<>();

        // лист из p отдельно строки и символы ? *
        for (String path: p.replace("*", "'*'").split("'")) {
            if (!path.isEmpty()) strings.add(path);
        }

        int minLen = p.replace("*", "").length(); // минимально возможная длина сроки, соответствующей шаблону (если все * это пустые строки)
        if (minLen > s.length()) {
            return false;
        }
        if (!p.contains("*") && p.length() < s.length()) {
            return false;
        }

        boolean isSpace = false;
        String block = "";

        int lenStrings = strings.size();
        for (int strIndex = 0; strIndex < lenStrings; strIndex++) {
            String str = strings.get(strIndex);
            if (isSpace) {
                if (!str.equals("*")) {
                    if (s.isEmpty()) return false;
                    block = str;
                } else if (strIndex != lenStrings - 1) {
                    continue;
                }

                if (strIndex == lenStrings - 1 && !str.equals("*")) {
                    if (s.length() < block.length()) return false;
                    return isMatch(s.substring(s.length() - block.length()), block);
                }

                for (int startIndex = 0; startIndex <= s.length() - block.length(); startIndex++) {
                    String copyS = new String(s);
                    if (isMatch(copyS.substring(startIndex, startIndex + block.length()), block)) {
                        s = s.substring(startIndex + block.length());
                        break;
                    }
                    if (startIndex == s.length() - block.length()) return false;
                }
                block = "";
            } else if (str.equals("*")) {
                if (strIndex == lenStrings - 1) return true;
                isSpace = true;
            } else {
                if (s.length() < str.length()) {
                    return false;
                }
                for (int i = 0; i < str.length(); i++) {
                    if (str.charAt(i) != '?' && s.charAt(i) != str.charAt(i)) return false;
                }
                s = s.substring(str.length());
            }
        }
        return true;
    }
}
